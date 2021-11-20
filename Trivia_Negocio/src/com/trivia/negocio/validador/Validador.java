package com.trivia.negocio.validador;

import com.trivia.negocio.validador.enumerador.TipoValidacion;

public interface Validador<D> 
{
	void validar(D dominio, TipoValidacion validacion);
}
