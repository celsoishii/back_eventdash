package br.com.isidrocorp.eventdash.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.eventdash.model.Usuario;

/* ponte para gerar o sql update insert, etc*/

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
	
	public Usuario findByEmailOrRacf(String email, String racf);

}
