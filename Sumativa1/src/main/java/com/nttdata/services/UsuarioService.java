package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Usuario;
import com.nttdata.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Usuario> encontrarTodos() {
		return usuarioRepository.findAll();
	}

	public void insertarUsuario(@Valid Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public Usuario buscarUsuario(Long id) {
		return usuarioRepository.findById(id).get();
	}

	public void editarUsuario(Usuario usuarioAntiguo) {
		usuarioRepository.save(usuarioAntiguo);
	}

	public void eliminarUsuario(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
	
}
