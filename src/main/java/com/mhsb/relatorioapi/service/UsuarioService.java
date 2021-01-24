package com.mhsb.relatorioapi.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.mhsb.relatorioapi.entity.Usuario;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class UsuarioService {

	public List<Usuario> getUsuarios(){
		return getUsuariosListFactory();
	}
	
	public String getRelatorio() throws FileNotFoundException, JRException{
		return exportarRelatorio();
	}
	
	private List<Usuario> getUsuariosListFactory(){

		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		Usuario usu1 = new Usuario();
		usu1.setId("1");
		usu1.setEmail("matheus.hsb@teste.com");
		usu1.setSenha("teste123");
		usu1.setPerfil("admin");
		usuarios.add(usu1);
		
		Usuario usu2 = new Usuario();
		usu2.setId("2");
		usu2.setEmail("henrique.hsb@teste.com");
		usu2.setSenha("teste123");
		usu2.setPerfil("tecnico");
		usuarios.add(usu2);
		
		Usuario usu3 = new Usuario();
		usu3.setId("3");
		usu3.setEmail("sousa.hsb@teste.com");
		usu3.setSenha("teste123");
		usu3.setPerfil("cliente");
		usuarios.add(usu3);
		
		Usuario usu4 = new Usuario();
		usu4.setId("4");
		usu4.setEmail("brito.hsb@teste.com");
		usu4.setSenha("teste123");
		usu4.setPerfil("admin");
		usuarios.add(usu4);
		
		Usuario usu5 = new Usuario();
		usu5.setId("5");
		usu5.setEmail("hercules.hsb@teste.com");
		usu5.setSenha("teste123");
		usu5.setPerfil("tecnico");
		usuarios.add(usu5);
		
		Usuario usu6 = new Usuario();
		usu6.setId("6");
		usu6.setEmail("tom.hsb@teste.com");
		usu6.setSenha("teste123");
		usu6.setPerfil("cliente");
		usuarios.add(usu6);
		
		return usuarios;
	}
	
	private String exportarRelatorio() throws FileNotFoundException, JRException {
		
		//File arquivo = ResourceUtils.getFile("classpath:relatoriousuarios.jrxml");
		InputStream arquivo = Usuario.class.getResourceAsStream("/relatorioUsuarios.jrxml");
		JasperReport jasper = JasperCompileManager.compileReport(arquivo);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(getUsuariosListFactory());
		byte[] btPDF;
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("gain java", "knowledge");
		
		JasperPrint print = JasperFillManager.fillReport(jasper, parameters, dataSource);
		
		btPDF = JasperExportManager.exportReportToPdf(print);
		
		//convertendo de byte para binário de base 64
		StringBuilder sb = new StringBuilder();
		sb.append(DatatypeConverter.printBase64Binary(btPDF));

		String resposta = sb.toString();
		
		return resposta;
	}
}

