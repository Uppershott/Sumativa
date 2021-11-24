package com.nttdata.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("")
	public String inicioUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
		model.addAttribute("usuario", new Usuario());
		
		List<Usuario> listaUsuarios = usuarioService.encontrarTodos();
		model.addAttribute("listaUsuarios", listaUsuarios);
		
		return "usuario.jsp";
	}
	
	//-----------------------------------------------------------------------------------------------
	@RequestMapping("/registrar")
	public String registrarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, Model model) {
		String error = valida(usuario);
		
		if(error.isEmpty()) {
			model.addAttribute("usuario", usuario);
			
			usuarioService.insertarUsuario(usuario);
			return "usuarioDatos.jsp";
		}else {
			model.addAttribute("error", error);
			return "error.jsp";
		}
	}
	
	public String valida(Usuario usuario) {
		String error="";
		
		if(usuario.getNombre()==null) {
			error+="El nombre no puede ser nulo. ";
		}
		if(usuario.getApellido()==null) {
			error+="El apellido no puede ser nulo. ";
		}
		if(usuario.getTelefono()==null) {
			error+="El telefono no puede ser nulo. ";
		}
		if(usuario.getCorreo()==null) {
			error+="El correo no puede ser nulo. ";
		}
		return error;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	@RequestMapping("/editar")
	public String editar(@RequestParam("id") Long id, Model model, HttpSession session) {
		Usuario usuario = usuarioService.buscarUsuario(id);
		
		session.setAttribute("usuarioAntiguo", usuario);
		model.addAttribute("usuarioEdit", usuario);
		return "usuarioEdit.jsp";
	}
	
	@RequestMapping("/editarUsuario")
	public String editarUsuario(@ModelAttribute("usuarioEdit") Usuario usuario, Model model, HttpSession session) {
		Usuario usuarioAntiguo = (Usuario)session.getAttribute("usuarioAntiguo");
		
		String error = valida(usuario);
		
		if(error.isEmpty()) {
			usuarioAntiguo.setNombre(usuario.getNombre());
			usuarioAntiguo.setApellido(usuario.getApellido());
			usuarioAntiguo.setTelefono(usuario.getTelefono());
			usuarioAntiguo.setCorreo(usuario.getCorreo());
			
			usuarioService.editarUsuario(usuarioAntiguo);
			return "redirect:/usuario";
		}else {
			model.addAttribute("error", error);
			return "error.jsp";
		}
	}
	
	//-----------------------------------------------------------------------------------------------
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("id") Long id, Model model) {
		Usuario usuario = usuarioService.buscarUsuario(id);
		if(usuario != null) {
			usuarioService.eliminarUsuario(usuario);
			return "redirect:/usuario";
		}else {
			String error = "El usuario que intenta eliminar no existe!";
			model.addAttribute("error", error);
			
			return "error.jsp";
		}
	}
}
