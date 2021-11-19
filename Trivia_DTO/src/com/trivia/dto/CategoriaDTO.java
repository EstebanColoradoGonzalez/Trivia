package com.trivia.dto;

import com.trivia.transversal.utilitario.UtilTexto;

public class CategoriaDTO 
{
	private int codigo;
	private String nombre;
	
	private CategoriaDTO(int codigo, String nombre) 
	{
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public static CategoriaDTO crear(int codigo, String nombre)
	{
		return new CategoriaDTO(codigo, nombre);
	}
	
	public static CategoriaDTO crear()
	{
		return new CategoriaDTO(0, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public CategoriaDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public CategoriaDTO setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}
}