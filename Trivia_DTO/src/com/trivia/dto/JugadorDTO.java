package com.trivia.dto;

import com.trivia.transversal.utilitario.UtilTexto;

public class JugadorDTO 
{
	private int codigo;
	private String nombre;
	private String apellidos;
	private String correo;
	private String clave;
	
	public JugadorDTO() 
	{
		
	}
	
	private JugadorDTO(int codigo, String nombre, String apellidos, String correo, String clave) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setApellidos(apellidos);
		setCorreo(correo);
		setClave(clave);
	}
	
	public static JugadorDTO crear(int codigo, String nombre, String apellidos, String correo, String clave)
	{
		return new JugadorDTO(codigo, nombre, apellidos, correo, clave);
	}
	
	public static JugadorDTO crear()
	{
		return new JugadorDTO(0, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public JugadorDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public JugadorDTO setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getApellidos() 
	{
		return apellidos;
	}

	public JugadorDTO setApellidos(String apellidos) 
	{
		this.apellidos = UtilTexto.aplicarTrim(apellidos);
		return this;
	}

	public String getCorreo() 
	{
		return correo;
	}

	public JugadorDTO setCorreo(String correo) 
	{
		this.correo = UtilTexto.aplicarTrim(correo);
		return this;
	}

	public String getClave() 
	{
		return clave;
	}

	public JugadorDTO setClave(String clave) 
	{
		this.clave = UtilTexto.aplicarTrim(clave);
		return this;
	}
}