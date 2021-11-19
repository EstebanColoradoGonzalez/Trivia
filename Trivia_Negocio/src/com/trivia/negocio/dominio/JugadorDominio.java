package com.trivia.negocio.dominio;

import com.trivia.transversal.utilitario.UtilTexto;

public class JugadorDominio 
{
	private int codigo;
	private String nombre;
	private String apellidos;
	private String correo;
	private String clave;
	
	private JugadorDominio(int codigo, String nombre, String apellidos, String correo, String clave) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setApellidos(apellidos);
		setCorreo(correo);
		setClave(clave);
	}
	
	public static JugadorDominio crear(int codigo, String nombre, String apellidos, String correo, String clave)
	{
		return new JugadorDominio(codigo, nombre, apellidos, correo, clave);
	}
	
	public static JugadorDominio crear()
	{
		return new JugadorDominio(0, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public JugadorDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public JugadorDominio setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getApellidos() 
	{
		return apellidos;
	}

	public JugadorDominio setApellidos(String apellidos) 
	{
		this.apellidos = UtilTexto.aplicarTrim(apellidos);
		return this;
	}

	public String getCorreo() 
	{
		return correo;
	}

	public JugadorDominio setCorreo(String correo) 
	{
		this.correo = UtilTexto.aplicarTrim(correo);
		return this;
	}

	public String getClave() 
	{
		return clave;
	}

	public JugadorDominio setClave(String clave) 
	{
		this.clave = UtilTexto.aplicarTrim(clave);
		return this;
	}
}