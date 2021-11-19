package com.trivia.dto;

import java.util.Date;

public class TriviaDTO 
{
	private int codigo;
	private Date fecha;
	private BancoDTO banco;
	private JugadorDTO jugador;
	private RankingDTO ranking;
	
	private TriviaDTO(int codigo, Date fecha, BancoDTO banco, JugadorDTO jugador, RankingDTO ranking) 
	{
		this.codigo = codigo;
		this.fecha = fecha;
		this.banco = banco;
		this.jugador = jugador;
		this.ranking = ranking;
	}
	
	public static TriviaDTO crear(int codigo, Date fecha, BancoDTO banco, JugadorDTO jugador, RankingDTO ranking)
	{
		return new TriviaDTO(codigo, fecha, banco, jugador, ranking);
	}
	
	public static TriviaDTO crear()
	{
		return new TriviaDTO(0, new Date(), BancoDTO.crear(), JugadorDTO.crear(), RankingDTO.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public TriviaDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public Date getFecha() 
	{
		return fecha;
	}

	public TriviaDTO setFecha(Date fecha) 
	{
		this.fecha = fecha;
		return this;
	}

	public BancoDTO getBanco() 
	{
		return banco;
	}

	public TriviaDTO setBanco(BancoDTO banco) 
	{
		this.banco = banco;
		return this;
	}

	public JugadorDTO getJugador() 
	{
		return jugador;
	}

	public TriviaDTO setJugador(JugadorDTO jugador) 
	{
		this.jugador = jugador;
		return this;
	}

	public RankingDTO getRanking() 
	{
		return ranking;
	}

	public TriviaDTO setRanking(RankingDTO ranking) 
	{
		this.ranking = ranking;
		return this;
	}
}