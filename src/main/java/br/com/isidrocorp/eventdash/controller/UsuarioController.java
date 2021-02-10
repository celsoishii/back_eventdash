package br.com.isidrocorp.eventdash.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.eventdash.dao.UsuarioDAO;
import br.com.isidrocorp.eventdash.model.Usuario;

@CrossOrigin("*")  //habilita o acesso do backend a entidades externas (nesse caso qq um)
@RestController
public class UsuarioController {

	@Autowired // o Autowired indica a Injecao de dependencias
	private UsuarioDAO dao;

//	@GetMapping("/usuarios")
//	public ArrayList<Usuario> recuperarTodos(){
//		ArrayList<Usuario> lista;
//		lista = (ArrayList<Usuario>)dao.findAll();
//		return lista;
//	}

	@PostMapping("/login")

	public ResponseEntity<Usuario> fazerLogin(@RequestBody Usuario dados) {
		Usuario resultado = dao.findByEmailOrRacf(dados.getEmail(), dados.getRacf());
		if (resultado != null) { // se o usuario existe no banco
			if (resultado.getSenha().equals(dados.getSenha())) {// as senahs batem
				resultado.setSenha("**********");
				return ResponseEntity.ok(resultado);
			}

			return ResponseEntity.status(401).build();// usuario existe mas senha não confere
		}
		// retorna 404 - pois não existe esse email ou racf no banco
		return ResponseEntity.notFound().build();
	}

}
