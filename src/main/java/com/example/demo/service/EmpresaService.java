package com.example.demo.service;

import com.example.demo.model.Empresa;
import com.example.demo.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    public List<Empresa> listarTodas() {
        return repository.findAll();
    }

    public Optional<Empresa> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Empresa guardar(Empresa empresa) {
        return repository.save(empresa);
    }

    public Empresa actualizar(Long id, Empresa datos) {
        Empresa existente = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Empresa no encontrada con id: " + id));
        existente.setNombre(datos.getNombre());
        existente.setNit(datos.getNit());
        existente.setCiudad(datos.getCiudad());
        existente.setSector(datos.getSector());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
