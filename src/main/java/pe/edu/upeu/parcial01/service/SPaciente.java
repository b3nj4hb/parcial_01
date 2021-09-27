package pe.edu.upeu.parcial01.service;

import java.util.List;

import pe.edu.upeu.parcial01.model.Paciente;

public interface SPaciente {
	Paciente create(Paciente p);
	List<Paciente> readAll();
	Paciente read(Long id);
	void delete(Long id);
	Paciente update(Paciente pe);
}
