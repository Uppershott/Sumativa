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

import com.nttdata.models.Venta;
import com.nttdata.services.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
	VentaService ventaService;
	
	@RequestMapping("")
	public String inicioVenta(@ModelAttribute("venta") Venta venta, Model model) {
		model.addAttribute("venta", new Venta());
		
		List<Venta> listaVentas = ventaService.encontrarTodos();
		model.addAttribute("listaVentas", listaVentas);
		
		return "venta.jsp";
	}
	
	//-----------------------------------------------------------------------------------------------
	
	@RequestMapping("/registrar")
	public String registrarVenta(@Valid @ModelAttribute("venta") Venta venta, Model model) {
		String error = valida(venta);
		
		if(error.isEmpty()) {
			model.addAttribute("venta", venta);
			
			ventaService.insertarVenta(venta);
			return "ventaDatos.jsp";
		}else {
			model.addAttribute("error", error);
			return "error.jsp";
		}
	}
	
	public String valida(Venta venta) {
		String error="";
		
		if(venta.getNombreCliente()==null) {
			error+="El nombre del cliente no puede ser nulo. ";
		}
		if(venta.getNombreLibro()==null) {
			error+="El nombre del libro no puede ser nulo. ";
		}
		if(venta.getPrecioLibro()==null) {
			error+="El precio del libro no puede ser nulo. ";
		}
		return error;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	@RequestMapping("/editar")
	public String editar(@RequestParam("id") Long id, Model model, HttpSession session) {
		Venta venta = ventaService.buscarVenta(id);
		
		session.setAttribute("ventaAntiguo", venta);
		model.addAttribute("ventaEdit", venta);
		return "ventaEdit.jsp";
	}
	
	@RequestMapping("/editarVenta")
	public String editarVenta(@ModelAttribute("ventaEdit") Venta venta, Model model, HttpSession session) {
		Venta ventaAntiguo = (Venta)session.getAttribute("ventaAntiguo");
		
		String error = valida(venta);
		
		if(error.isEmpty()) {
			ventaAntiguo.setNombreCliente(venta.getNombreCliente());
			ventaAntiguo.setNombreLibro(venta.getNombreLibro());
			ventaAntiguo.setPrecioLibro(venta.getPrecioLibro());
			
			ventaService.editarVenta(ventaAntiguo);
			return "redirect:/venta";
		}else {
			model.addAttribute("error", error);
			return "error.jsp";
		}
	}
	
	//-----------------------------------------------------------------------------------------------
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("id") Long id, Model model) {
		Venta venta = ventaService.buscarVenta(id);
		if(venta != null) {
			ventaService.eliminarVenta(venta);
			return "redirect:/venta";
		}else {
			String error = "La venta que intenta eliminar no existe.";
			model.addAttribute("error", error);
			
			return "error.jsp";
		}
	}
}
