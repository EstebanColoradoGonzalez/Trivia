package com.trivia.negocio.fachada;

import java.util.List;
import org.springframework.stereotype.Component;
import com.trivia.dto.JugadorDTO;

@Component
public interface JugadorFachada 
{
	List<JugadorDTO> consultar();
	JugadorDTO consultar(String correo);
	void registrar(JugadorDTO jugadorDTO);
	void modificar(JugadorDTO jugadorDTO);
	void eliminar(JugadorDTO jugadorDTO);
}