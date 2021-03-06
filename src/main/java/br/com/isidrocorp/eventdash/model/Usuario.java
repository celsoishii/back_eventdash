package br.com.isidrocorp.eventdash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* o objetivo desta classe e mapear a propria estrutura da classe usuario 
 * a estrutura da tabela itmn_usuario
 * 
 * quais requisitos?
 * -a classe tera a mesma quantidade de atributos da tabela
 * faremos a equivalencia a cada um dos atributos */

@Entity  // a classe usuario é armazenal em banco
@Table(name="itmn_usuario") // especificar nome da tabela
public class Usuario {
	
	@Column(name="id_usuario") // mpaear o atributo para o nome da coluna
	@Id                        //indico que é chave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) // preciso informar auto_increment
	private int id;
	
	@Column(name="nome_usuario", length = 100, nullable = false)
	private String nome;
	
	@Column(name="email_usuario", length = 100, nullable = false)
	private String email;
	
	@Column(name="racf_usuario", length = 7, nullable = false)
	private String racf;
	
	@Column(name="senha_usuario", length = 50, nullable = false)
	private String senha;
	
	@Column(name="ramal_usuario", length = 10)
	private String ramal;
	
	@Column(name="link_foto", length = 255)
	private String linkFoto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRacf() {
		return racf;
	}
	public void setRacf(String racf) {
		this.racf = racf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getRamal() {
		return ramal;
	}
	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	public String getLinkFoto() {
		return linkFoto;
	}
	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	
	

}
