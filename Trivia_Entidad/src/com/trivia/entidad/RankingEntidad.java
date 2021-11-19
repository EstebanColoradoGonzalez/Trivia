package com.trivia.entidad;

import java.util.ArrayList;
import java.util.List;

public class RankingEntidad 
{
	private int codigo;
	private List<TriviaEntidad> trivias;
	
	private RankingEntidad(int codigo, List<TriviaEntidad> trivias) 
	{
		super();
		this.codigo = codigo;
		this.trivias = trivias;
	}
	
	public static RankingEntidad crear(int codigo, List<TriviaEntidad> trivias)
	{
		return new RankingEntidad(codigo, trivias);
	}
	
	public static RankingEntidad crear()
	{
		return new RankingEntidad(0, new ArrayList<>());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public RankingEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public List<TriviaEntidad> getTrivias() 
	{
		return trivias;
	}

	public RankingEntidad setTrivias(List<TriviaEntidad> trivias) 
	{
		this.trivias = trivias;
		return this;
	}
}