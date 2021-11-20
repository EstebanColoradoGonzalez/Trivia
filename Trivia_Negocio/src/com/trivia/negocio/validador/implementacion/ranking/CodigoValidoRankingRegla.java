package com.trivia.negocio.validador.implementacion.ranking;

import com.trivia.negocio.dominio.RankingDominio;
import com.trivia.negocio.validador.regla.Regla;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;
import com.trivia.transversal.utilitario.UtilNumero;

public class CodigoValidoRankingRegla implements Regla<RankingDominio> 
{
	private static final Regla<RankingDominio> INSTANCIA = new CodigoValidoRankingRegla();
	
	private CodigoValidoRankingRegla()
	{
		super();
	}
	
	public static Regla<RankingDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(RankingDominio dato) 
	{
		validarCodigoEsMayorQueCero(dato.getCodigo());
	}
	
	private void validarCodigoEsMayorQueCero(int codigo)
	{
		if(UtilNumero.numeroEsMenorOIgual(codigo, 0))
		{
			throw new TriviaNegocioExcepcion("El codigo de un Ranking no puede ser menor o igual que cero");
		}
	}
}