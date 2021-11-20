package com.trivia.negocio.validador.implementacion.banco;

import com.trivia.negocio.dominio.BancoDominio;
import com.trivia.negocio.validador.regla.Regla;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;
import com.trivia.transversal.utilitario.UtilNumero;

public class CodigoValidoBancoRegla implements Regla<BancoDominio> 
{
	private static final Regla<BancoDominio> INSTANCIA = new CodigoValidoBancoRegla();
	
	private CodigoValidoBancoRegla()
	{
		super();
	}
	
	public static Regla<BancoDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(BancoDominio dato) 
	{
		validarCodigoEsMayorQueCero(dato.getCodigo());
	}
	
	private void validarCodigoEsMayorQueCero(int codigo)
	{
		if(UtilNumero.numeroEsMenorOIgual(codigo, 0))
		{
			throw new TriviaNegocioExcepcion("El codigo de un Banco no puede ser menor o igual que cero");
		}
	}
}