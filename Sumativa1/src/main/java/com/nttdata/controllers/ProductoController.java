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

import com.nttdata.models.Producto;
import com.nttdata.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@RequestMapping("")
	public String inicioProducto(@ModelAttribute("producto") Producto producto, Model model) {
		model.addAttribute("producto", new Producto());
		
		List<Producto> listaProductos = productoService.encontrarTodos();
		model.addAttribute("listaProductos", listaProductos);
		
		return "producto.jsp";
	}
	
	//-----------------------------------------------------------------------------------------------
	
	@RequestMapping("/registrar")
	public String registrarProducto(@Valid @ModelAttribute("producto") Producto producto, Model model) {
		String error = valida(producto);
		
		if(error.isEmpty()) {
			model.addAttribute("producto", producto);
			
			productoService.insertarProducto(producto);
			return "productoDatos.jsp";
		}else {
			model.addAttribute("error", error);
			return "error.jsp";
		}
	}
	
	public String valida(Producto producto) {
		String error="";
		if(producto.getIsbn()==null) {
			error+="El ISBN no puede ser nulo. ";
		}
		if(producto.getNombre()==null) {
			error+="El nombre no puede ser nulo. ";
		}
		if(producto.getAutor()==null) {
			error+="El autor no puede ser nulo. ";
		}
		if(producto.getEditorial()==null) {
			error+="La editorial no puede ser nula.";
		}
		return error;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	@RequestMapping("/editar")
	public String editar(@RequestParam("id") Long id, Model model, HttpSession session) {
		Producto producto = productoService.buscarProducto(id);
		
		session.setAttribute("productoAntiguo", producto);
		model.addAttribute("productoEdit", producto);
		return "productoEdit.jsp";
	}
	
	@RequestMapping("/editarProducto")
	public String editarProducto(@ModelAttribute("productoEdit") Producto producto, Model model, HttpSession session) {
		Producto productoAntiguo = (Producto)session.getAttribute("productoAntiguo");
		
		String error = valida(producto);
		
		if(error.isEmpty()) {
			productoAntiguo.setIsbn(producto.getIsbn());
			productoAntiguo.setNombre(producto.getNombre());
			productoAntiguo.setAutor(producto.getAutor());
			productoAntiguo.setEditorial(producto.getEditorial());
			
			productoService.editarProducto(productoAntiguo);
			return "redirect:/producto";
		}else {
			model.addAttribute("error", error);
			return "error.jsp";
		}
	}
	
	//-----------------------------------------------------------------------------------------------
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("id") Long id, Model model) {
		Producto producto = productoService.buscarProducto(id);
		if(producto != null) {
			productoService.eliminarProducto(producto);
			return "redirect:/producto";
		}else {
			String error = "El producto que intenta eliminar no existe.";
			model.addAttribute("error", error);
			
			return "error.jsp";
		}
	}
}
