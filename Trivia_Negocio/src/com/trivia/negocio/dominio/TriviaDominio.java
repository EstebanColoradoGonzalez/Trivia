package com.trivia.negocio.dominio;

import java.util.Date;

public class TriviaDominio 
{
	private int codigo;
	private Date fecha;
	private BancoDominio banco;
	private JugadorDominio jugador;
	private RankingDominio ranking;
	
	private TriviaDominio(int codigo, Date fecha, BancoDominio banco, JugadorDominio jugador, RankingDominio ranking) 
	{
		this.codigo = codigo;
		this.fecha = fecha;
		this.banco = banco;
		this.jugador = jugador;
		this.ranking = ranking;
	}
	
	public static TriviaDominio crear(int codigo, Date fecha, BancoDominio banco, JugadorDominio jugador, RankingDominio ranking)
	{
		return new TriviaDominio(codigo, fecha, banco, jugador, ranking);
	}
	
	public static TriviaDominio crear()
	{
		return new TriviaDominio(0, new Date(), BancoDominio.crear(), JugadorDominio.crear(), RankingDominio.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public TriviaDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public Date getFecha() 
	{
		return fecha;
	}

	public TriviaDominio setFecha(Date fecha) 
	{
		this.fecha = fecha;
		return this;
	}

	public BancoDominio getBanco() 
	{
		return banco;
	}

	public TriviaDominio setBanco(BancoDominio banco) 
	{
		this.banco = banco;
		return this;
	}

	public JugadorDominio getJugador() 
	{
		return jugador;
	}

	public TriviaDominio setJugador(JugadorDominio jugador) 
	{
		this.jugador = jugador;
		return this;
	}

	public RankingDominio getRanking() 
	{
		return ranking;
	}

	public TriviaDominio setRanking(RankingDominio ranking) 
	{
		this.ranking = ranking;
		return this;
	}
}