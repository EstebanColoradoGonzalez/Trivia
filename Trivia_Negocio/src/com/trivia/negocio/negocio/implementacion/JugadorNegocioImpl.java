package com.trivia.negocio.negocio.implementacion;

import static com.trivia.negocio.ensamblador.implementacion.JugadorEnsambladorImpl.obtenerJugadorEnsamblador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trivia.datos.dao.JugadorDAO;
import com.trivia.entidad.JugadorEntidad;
import com.trivia.negocio.dominio.JugadorDominio;
import com.trivia.negocio.negocio.JugadorNegocio;
import com.trivia.negocio.validador.enumerador.TipoValidacion;
import com.trivia.negocio.validador.implementacion.JugadorValidador;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;

@Service
public class JugadorNegocioImpl implements JugadorNegocio
{
	@Autowired
	private JugadorDAO jugadorDAO;
	
	@Override
	public List<JugadorDominio> consultar() 
	{
		var resultados = jugadorDAO.findAll();
		
		return obtenerJugadorEnsamblador().ensamblarDominiosDesdeEntidad((List<JugadorEntidad>) resultados);
	}

	@Override
	public JugadorDominio consultar(String correo) 
	{
		var resultados = jugadorDAO.findAll();
		
		List<JugadorDominio> jugadores = obtenerJugadorEnsamblador().ensamblarDominiosDesdeEntidad((List<JugadorEntidad>) resultados);
		
		var jugador = JugadorDominio.crear();
		
		for(int i = 0; i < jugadores.size(); i++)
		{
			if(jugadores.get(i).getCorreo().equals(correo))
			{
				jugador = jugadores.get(i);
			}
		}
		
		return jugador;
	}

	@Override
	public void registrar(JugadorDominio jugadorDominio) 
	{
		JugadorValidador.obtenerInstancia().validar(jugadorDominio, TipoValidacion.CREACION);
		asegurarJugadorNoExistaConCorreo(jugadorDominio);
		jugadorDAO.save(obtenerJugadorEnsamblador().ensamblarEntidadDesdeDominio(jugadorDominio));
	}

	@Override
	public void modificar(JugadorDominio jugadorDominio) 
	{
		JugadorValidador.obtenerInstancia().validar(jugadorDominio, TipoValidacion.ACTUALIZACION);
		asegurarJugadorNoExistaConCorreoModificar(jugadorDominio);
		jugadorDAO.save(obtenerJugadorEnsamblador().ensamblarEntidadDesdeDominio(jugadorDominio));
	}

	@Override
	public void eliminar(JugadorDominio jugadorDominio) 
	{
		JugadorValidador.obtenerInstancia().validar(jugadorDominio, TipoValidacion.ELIMINACION);
		jugadorDAO.delete(obtenerJugadorEnsamblador().ensamblarEntidadDesdeDominio(jugadorDominio));
	}
	
	private void asegurarJugadorNoExistaConCorreo(JugadorDominio jugadorDominio)
	{
		var jugador = JugadorDominio.crear().setCorreo(jugadorDominio.getCorreo());
		
		List<JugadorDominio> lista = consultar();
		
		for(int i = 0; i < lista.size(); i ++)
		{
			if(jugador.getCorreo().equals(lista.get(i).getCorreo()))
			{
				throw new TriviaNegocioExcepcion("Ya existe un Jugador con el correo " + jugadorDominio.getCorreo());
			}
		}
	}
	
	private void asegurarJugadorNoExistaConCorreoModificar(JugadorDominio jugadorDominio)
	{	
		var jugador = JugadorDominio.crear().setCorreo(jugadorDominio.getCorreo());
		
		List<JugadorDominio> lista = consultar();
		
		for(int i = 0; i < lista.size(); i ++)
		{
			if(jugador.getCorreo().equals(lista.get(i).getCorreo()) && jugadorDominio.getCodigo() != lista.get(i).getCodigo())
			{
				throw new TriviaNegocioExcepcion("Ya existe un Jugador con el correo " + jugadorDominio.getCorreo());
			}
		}
	}
}