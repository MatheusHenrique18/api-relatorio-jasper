package com.mhsb.relatorioapi.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhsb.relatorioapi.entity.Usuario;
import com.mhsb.relatorioapi.service.UsuarioService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	private List<Usuario> getUsuarios(){
		return usuarioService.getUsuarios();
	}
	
	@GetMapping(value = "/relatorio")
	private String gerarPDF() throws FileNotFoundException, JRException{
		return usuarioService.getRelatorio();
	}
}
