package com.trivia.entidad;

import java.util.Date;

public class TriviaEntidad 
{
	private int codigo;
	private Date fecha;
	private BancoEntidad banco;
	private JugadorEntidad jugador;
	private RankingEntidad ranking;
	
	private TriviaEntidad(int codigo, Date fecha, BancoEntidad banco, JugadorEntidad jugador, RankingEntidad ranking) 
	{
		this.codigo = codigo;
		this.fecha = fecha;
		this.banco = banco;
		this.jugador = jugador;
		this.ranking = ranking;
	}
	
	public static TriviaEntidad crear(int codigo, Date fecha, BancoEntidad banco, JugadorEntidad jugador, RankingEntidad ranking)
	{
		return new TriviaEntidad(codigo, fecha, banco, jugador, ranking);
	}
	
	public static TriviaEntidad crear()
	{
		return new TriviaEntidad(0, new Date(), BancoEntidad.crear(), JugadorEntidad.crear(), RankingEntidad.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public TriviaEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public Date getFecha() 
	{
		return fecha;
	}

	public TriviaEntidad setFecha(Date fecha) 
	{
		this.fecha = fecha;
		return this;
	}

	public BancoEntidad getBanco() 
	{
		return banco;
	}

	public TriviaEntidad setBanco(BancoEntidad banco) 
	{
		this.banco = banco;
		return this;
	}

	public JugadorEntidad getJugador() 
	{
		return jugador;
	}

	public TriviaEntidad setJugador(JugadorEntidad jugador) 
	{
		this.jugador = jugador;
		return this;
	}

	public RankingEntidad getRanking() 
	{
		return ranking;
	}

	public TriviaEntidad setRanking(RankingEntidad ranking) 
	{
		this.ranking = ranking;
		return this;
	}
}