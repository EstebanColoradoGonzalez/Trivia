package com.trivia.negocio.dominio;

import java.util.ArrayList;
import java.util.List;

public class RankingDominio 
{
	private int codigo;
	private List<TriviaDominio> trivias;
	
	private RankingDominio(int codigo, List<TriviaDominio> trivias) 
	{
		super();
		this.codigo = codigo;
		this.trivias = trivias;
	}
	
	public static RankingDominio crear(int codigo, List<TriviaDominio> trivias)
	{
		return new RankingDominio(codigo, trivias);
	}
	
	public static RankingDominio crear()
	{
		return new RankingDominio(0, new ArrayList<>());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public RankingDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public List<TriviaDominio> getTrivias() 
	{
		return trivias;
	}

	public RankingDominio setTrivias(List<TriviaDominio> trivias) 
	{
		this.trivias = trivias;
		return this;
	}
}