package br.org.generation.blogpessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //Gera tabela
@Table(name = "tb_postagens") // definir nome da tabela
public class Postagem {
	
	@Id //Chave Primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private long id;
	
	@NotNull(message = "O atributo titulo é obrigatório!")
	@Size(min=5, max=100, message = "O atributo titulo deve ter no min 5 e no max 100 caracteres!" )
	private String titulo;
	
	@NotNull(message = "O atributo texto é obrigatório!")
	@Size(min=10, max=1000, message = "O atributo texto deve ter no min 10 e no max 1000 caracteres!" )
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis()) ; //grava em milissegundos para evitar a chance de dois arquivos terem o mesmo tempo e no
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	
	
}
