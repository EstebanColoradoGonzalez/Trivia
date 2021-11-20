package com.trivia.api.controlador;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.trivia.api.controlador.respuesta.Respuesta;
import com.trivia.api.controlador.respuesta.enumerador.EstadoRespuestaEnum;
import com.trivia.dto.JugadorDTO;
import com.trivia.negocio.fachada.JugadorFachada;

@RestController
@RequestMapping("/api/jugador")
@CrossOrigin(origins = "http://localhost:4200")
public class JugadorControlador 
{
	@Autowired
	JugadorFachada usuarioFachada;
	
	@PostMapping
	public ResponseEntity<Respuesta<JugadorDTO>> crear(@RequestBody JugadorDTO usuario)
	{
		ResponseEntity<Respuesta<JugadorDTO>> entidadRespuesta;
		Respuesta<JugadorDTO> respuesta = new Respuesta<>();
			
		try 
		{
			usuarioFachada.registrar(usuario);
			
			respuesta.adicionarMensaje("El Jugador se creo sin problemas");
			respuesta.setEstado(EstadoRespuestaEnum.EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
		} 
		catch (RuntimeException excepcion) 
		{
			respuesta.adicionarMensaje(excepcion.getMessage());
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
		catch (Exception excepcion) 
		{
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de registrar la información de un nuevo Jugador");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
		
	@PutMapping("/{codigo}")
	public ResponseEntity<Respuesta<JugadorDTO>> modificar(@RequestBody JugadorDTO usuario, @PathVariable int codigo)
	{
		ResponseEntity<Respuesta<JugadorDTO>> entidadRespuesta;
		Respuesta<JugadorDTO> respuesta = new Respuesta<>();
			
		try 
		{
			usuarioFachada.modificar(usuario.setCodigo(codigo));
				
			respuesta.adicionarMensaje("El Jugador se Modifico sin problemas");
			respuesta.setEstado(EstadoRespuestaEnum.EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
		} 
		catch (RuntimeException excepcion) 
		{
			respuesta.adicionarMensaje(excepcion.getMessage());
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
		catch (Exception excepcion) 
		{
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de modificar la información de un Jugador");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
	   
	@DeleteMapping("/{correo}")
	public ResponseEntity<Respuesta<JugadorDTO>> eliminar(@PathVariable String correo)
	{
	    ResponseEntity<Respuesta<JugadorDTO>> entidadRespuesta;
		Respuesta<JugadorDTO> respuesta = new Respuesta<>();
			
		try 
		{
			List<JugadorDTO> usuarios = usuarioFachada.consultar();
			
			usuarioFachada.eliminar(JugadorDTO.crear().setCodigo(usuarios.get(0).getCodigo()));
				
			respuesta.adicionarMensaje("El Jugador se elimino sin problemas");
			respuesta.setEstado(EstadoRespuestaEnum.EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
		} 
		catch (RuntimeException excepcion) 
		{
			respuesta.adicionarMensaje(excepcion.getMessage());
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
		catch (Exception excepcion) 
		{
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de eliminar la información de un usuario");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
	    
	@GetMapping
	public ResponseEntity<Respuesta<JugadorDTO>> consultar()
	{
		ResponseEntity<Respuesta<JugadorDTO>> entidadRespuesta;
		Respuesta<JugadorDTO> respuesta = new Respuesta<>();
			
		try 
		{
			List<JugadorDTO> usuarios = usuarioFachada.consultar();
				
			respuesta.setDatos(usuarios);
			respuesta.adicionarMensaje("Los Jugadores se consultaron de forma exitosa.");
			respuesta.setEstado(EstadoRespuestaEnum.EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
		} 
		catch (RuntimeException excepcion) 
		{
			respuesta.adicionarMensaje(excepcion.getMessage());
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
		catch (Exception excepcion) 
		{
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de consultar la información de los usuarios");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
			return entidadRespuesta;
	}
	
	@GetMapping("/{correo}")
	public ResponseEntity<Respuesta<JugadorDTO>> consultar(@PathVariable String correo)
	{
		ResponseEntity<Respuesta<JugadorDTO>> entidadRespuesta;
		Respuesta<JugadorDTO> respuesta = new Respuesta<>();
			
		try 
		{	
			var usuarios = new ArrayList<JugadorDTO>();
			
			usuarios.add(usuarioFachada.consultar(correo));
			
			respuesta.setDatos(usuarios);
			respuesta.adicionarMensaje("Los jugadores se consultaron de forma exitosa.");
			respuesta.setEstado(EstadoRespuestaEnum.EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
		} 
		catch (RuntimeException excepcion) 
		{
			respuesta.adicionarMensaje(excepcion.getMessage());
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
		catch (Exception excepcion) 
		{
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de consultar la información de los jugadores");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
			return entidadRespuesta;
	}
}