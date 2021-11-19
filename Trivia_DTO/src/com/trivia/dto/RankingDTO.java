package com.trivia.dto;

import java.util.ArrayList;
import java.util.List;

public class RankingDTO 
{
	private int codigo;
	private List<TriviaDTO> trivias;
	
	private RankingDTO(int codigo, List<TriviaDTO> trivias) 
	{
		super();
		this.codigo = codigo;
		this.trivias = trivias;
	}
	
	public static RankingDTO crear(int codigo, List<TriviaDTO> trivias)
	{
		return new RankingDTO(codigo, trivias);
	}
	
	public static RankingDTO crear()
	{
		return new RankingDTO(0, new ArrayList<>());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public RankingDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public List<TriviaDTO> getTrivias() 
	{
		return trivias;
	}

	public RankingDTO setTrivias(List<TriviaDTO> trivias) 
	{
		this.trivias = trivias;
		return this;
	}
}