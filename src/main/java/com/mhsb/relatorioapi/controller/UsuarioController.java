package com.mhsb.relatorioapi.controller;

import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	private ResponseEntity<String> gerarPDF(HttpServletRequest request, @RequestBody Usuario usuario) throws FileNotFoundException, JRException{
		return usuarioService.exportarRelatorio(request, usuario);
	}
}
