package com.trivia.entidad;

import com.trivia.transversal.utilitario.UtilTexto;

public class JugadorEntidad 
{
	private int codigo;
	private String nombre;
	private String apellidos;
	private String correo;
	private String clave;
	
	private JugadorEntidad(int codigo, String nombre, String apellidos, String correo, String clave) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setApellidos(apellidos);
		setCorreo(correo);
		setClave(clave);
	}
	
	public static JugadorEntidad crear(int codigo, String nombre, String apellidos, String correo, String clave)
	{
		return new JugadorEntidad(codigo, nombre, apellidos, correo, clave);
	}
	
	public static JugadorEntidad crear()
	{
		return new JugadorEntidad(0, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public JugadorEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public JugadorEntidad setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getApellidos() 
	{
		return apellidos;
	}

	public JugadorEntidad setApellidos(String apellidos) 
	{
		this.apellidos = UtilTexto.aplicarTrim(apellidos);
		return this;
	}

	public String getCorreo() 
	{
		return correo;
	}

	public JugadorEntidad setCorreo(String correo) 
	{
		this.correo = UtilTexto.aplicarTrim(correo);
		return this;
	}

	public String getClave() 
	{
		return clave;
	}

	public JugadorEntidad setClave(String clave) 
	{
		this.clave = UtilTexto.aplicarTrim(clave);
		return this;
	}
}