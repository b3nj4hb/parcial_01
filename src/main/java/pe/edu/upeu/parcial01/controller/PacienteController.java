package pe.edu.upeu.parcial01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.parcial01.model.Paciente;
import pe.edu.upeu.parcial01.service.PacienteService;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

@Autowired
	private PacienteService pacienteservice;
		@PostMapping("/crear")
		public ResponseEntity<Paciente> save(@RequestBody Paciente pac) {
			try {
				Paciente p = pacienteservice.create(new Paciente(pac.getIdpaciente(), 
						pac.getDni(), pac.getNombres(), pac.getApellidos(), 
						pac.getDireccion(),pac.getTelefono()));
			    return new ResponseEntity<>(p,HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@GetMapping("/listar")
		public ResponseEntity<List<Paciente>> gePost(){
			try {
				List<Paciente> list = new ArrayList<>();
				list = pacienteservice.readAll();
				if(list.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(list, HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@GetMapping("/read/{id}")
		public ResponseEntity<Paciente> getUser(@PathVariable("id") long id){
			Paciente paciente = pacienteservice.read(id);
				if(paciente.getIdpaciente()>0) {
					return new ResponseEntity<>(paciente, HttpStatus.OK);
				}else {
				
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				} 
		}
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
			try {
				pacienteservice.delete(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@PutMapping("/update/{id}")
		public ResponseEntity<Paciente> update(@RequestBody Paciente paciente, @PathVariable("id") long id){
			try {
				Paciente pe = pacienteservice.read(id);
				if(pe.getIdpaciente()>0) {
					pe.setDni(paciente.getDni());
					pe.setNombres(paciente.getNombres());
					pe.setApellidos(paciente.getApellidos());
					pe.setDireccion(paciente.getDireccion());
					pe.setTelefono(paciente.getTelefono());
					
					return new ResponseEntity<>(pacienteservice.create(pe),HttpStatus.OK);
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}			

			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
}