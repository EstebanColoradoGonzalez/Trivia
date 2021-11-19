package com.trivia.entidad;

import com.trivia.transversal.utilitario.UtilTexto;

public class CategoriaEntidad 
{
	private int codigo;
	private String nombre;
	
	private CategoriaEntidad(int codigo, String nombre) 
	{
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public static CategoriaEntidad crear(int codigo, String nombre)
	{
		return new CategoriaEntidad(codigo, nombre);
	}
	
	public static CategoriaEntidad crear()
	{
		return new CategoriaEntidad(0, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public CategoriaEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public CategoriaEntidad setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}
}