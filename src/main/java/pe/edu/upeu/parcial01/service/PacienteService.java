package pe.edu.upeu.parcial01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.parcial01.model.Paciente;
import pe.edu.upeu.parcial01.repository.PacienteRepository;
@Service
public class PacienteService implements SPaciente{
@Autowired
private PacienteRepository productoRepository;
	@Override
	public Paciente create(Paciente p) {
		// TODO Auto-generated method stub
		return productoRepository.save(p);
	}

	@Override
	public List<Paciente> readAll() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public Paciente read(Long id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(id);
		
	}

	@Override
	public Paciente update(Paciente pe) {
		// TODO Auto-generated method stub
		return null;
	}

}
