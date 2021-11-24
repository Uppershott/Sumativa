package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Venta;
import com.nttdata.repositories.VentaRepository;

@Service
public class VentaService {
	@Autowired
	VentaRepository ventaRepository;

	public List<Venta> encontrarTodos() {
		return ventaRepository.findAll();
	}

	public void insertarVenta(@Valid Venta venta) {
		ventaRepository.save(venta);
	}

	public Venta buscarVenta(Long id) {
		return ventaRepository.findById(id).get();
	}

	public void editarVenta(Venta ventaAntiguo) {
		ventaRepository.save(ventaAntiguo);
	}

	public void eliminarVenta(Venta venta) {
		ventaRepository.delete(venta);
	}
	
	
}
