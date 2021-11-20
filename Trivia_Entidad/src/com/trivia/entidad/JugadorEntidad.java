package com.trivia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.trivia.transversal.utilitario.UtilTexto;

@Entity
@Table(name = "jugador", schema = "public")
public class JugadorEntidad 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="jugador_codigo_seq")
	@SequenceGenerator(name="jugador_codigo_seq", sequenceName="jugador_codigo_seq", allocationSize=1)
	@Column(name = "codigo")
	private int codigo;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private String correo;
	@Column
	private String clave;
	
	public JugadorEntidad()
	{
		
	}
	
	private JugadorEntidad(int codigo, String nombre, String apellidos, String correo, String clave) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setApellidos(apellidos);
		setCorreo(correo);
		setClave(clave);
	}
	
	public static JugadorEntidad crear(int codigo, String nombre, String apellidos, String correo, String clave)
	{
		return new JugadorEntidad(codigo, nombre, apellidos, correo, clave);
	}
	
	public static JugadorEntidad crear()
	{
		return new JugadorEntidad(0, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public JugadorEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public JugadorEntidad setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getApellidos() 
	{
		return apellidos;
	}

	public JugadorEntidad setApellidos(String apellidos) 
	{
		this.apellidos = UtilTexto.aplicarTrim(apellidos);
		return this;
	}

	public String getCorreo() 
	{
		return correo;
	}

	public JugadorEntidad setCorreo(String correo) 
	{
		this.correo = UtilTexto.aplicarTrim(correo);
		return this;
	}

	public String getClave() 
	{
		return clave;
	}

	public JugadorEntidad setClave(String clave) 
	{
		this.clave = UtilTexto.aplicarTrim(clave);
		return this;
	}
}