package com.trivia.negocio.fachada.implementacion;

import static com.trivia.negocio.ensamblador.implementacion.JugadorEnsambladorImpl.obtenerJugadorEnsamblador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trivia.dto.JugadorDTO;
import com.trivia.negocio.dominio.JugadorDominio;
import com.trivia.negocio.fachada.JugadorFachada;
import com.trivia.negocio.negocio.JugadorNegocio;

@Service
@Transactional
public class JugadorFachadaImpl implements JugadorFachada 
{
	@Autowired
	JugadorNegocio jugadorNegocio;
	
	@Override
	public List<JugadorDTO> consultar() 
	{
		List<JugadorDominio> jugadoresDominio = jugadorNegocio.consultar();
		return obtenerJugadorEnsamblador().ensamblarDTOsDesdeDominio(jugadoresDominio);
	}

	@Override
	public JugadorDTO consultar(String correo) 
	{
		return obtenerJugadorEnsamblador().ensamblarDTODesdeDominio(jugadorNegocio.consultar(correo));
	}

	@Override
	public void registrar(JugadorDTO jugadorDTO) 
	{
		JugadorDominio jugadorDominio = obtenerJugadorEnsamblador().ensamblarDominioDesdeDTO(jugadorDTO);
		jugadorNegocio.registrar(jugadorDominio);
	}

	@Override
	public void modificar(JugadorDTO jugadorDTO) 
	{
		JugadorDominio jugadorDominio = obtenerJugadorEnsamblador().ensamblarDominioDesdeDTO(jugadorDTO);
		jugadorNegocio.modificar(jugadorDominio);
	}

	@Override
	public void eliminar(JugadorDTO jugadorDTO) 
	{
		JugadorDominio jugadorDominio = obtenerJugadorEnsamblador().ensamblarDominioDesdeDTO(jugadorDTO);
		jugadorNegocio.eliminar(jugadorDominio);
	}
}
