package com.trivia.negocio.negocio;

import java.util.List;
import org.springframework.stereotype.Component;
import com.trivia.negocio.dominio.JugadorDominio;

@Component
public interface JugadorNegocio 
{
	List<JugadorDominio> consultar();
	JugadorDominio consultar(String correo);
	void registrar(JugadorDominio jugadorDominio);
	void modificar(JugadorDominio jugadorDominio);
	void eliminar(JugadorDominio jugadorDominio);
}