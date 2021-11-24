package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Producto;
import com.nttdata.repositories.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepository;

	public List<Producto> encontrarTodos() {
		return productoRepository.findAll();
	}

	public void insertarProducto(@Valid Producto producto) {
		productoRepository.save(producto);
	}

	public Producto buscarProducto(Long id) {
		return productoRepository.findById(id).get();
	}

	public void editarProducto(Producto productoAntiguo) {
		productoRepository.save(productoAntiguo);
	}

	public void eliminarProducto(Producto producto) {
		productoRepository.delete(producto);
	}
	
	
}
