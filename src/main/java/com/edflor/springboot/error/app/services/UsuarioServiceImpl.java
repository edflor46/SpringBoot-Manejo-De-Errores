package com.edflor.springboot.error.app.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edflor.springboot.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private List<Usuario> lista;

	public UsuarioServiceImpl() {
		this.lista = new ArrayList<>();
		this.lista.add(new Usuario(1, "Luis", "Ramirez"));
		this.lista.add(new Usuario(2, "Eduardo", "Ramirez"));
		this.lista.add(new Usuario(3, "Luis", "Flores"));
		this.lista.add(new Usuario(4, "Eduardo", "Flores"));
		this.lista.add(new Usuario(5, "Lalo", "Ramirez"));
		this.lista.add(new Usuario(6, "Wicho", "Flores"));
		this.lista.add(new Usuario(7, "Lu", "Ramirez"));
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario resultado = null;

		for (Usuario u : this.lista) {
			if (u.getId().equals(id)) {
				resultado = u;
				break;
			}
		}

		return resultado;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		
		Usuario usuario = this.obtenerPorId(id);
		return Optional.ofNullable(usuario);
	}

}
