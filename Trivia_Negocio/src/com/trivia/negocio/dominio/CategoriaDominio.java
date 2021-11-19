package com.trivia.negocio.dominio;

import com.trivia.transversal.utilitario.UtilTexto;

public class CategoriaDominio 
{
	private int codigo;
	private String nombre;
	
	private CategoriaDominio(int codigo, String nombre) 
	{
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public static CategoriaDominio crear(int codigo, String nombre)
	{
		return new CategoriaDominio(codigo, nombre);
	}
	
	public static CategoriaDominio crear()
	{
		return new CategoriaDominio(0, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public CategoriaDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public CategoriaDominio setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}
}