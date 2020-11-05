package br.rest.app.model;

public class Municipio {
	
	private Long Id;
	private String Nome;
	private Long Populacao;
		
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getPopulacao() {
		return Populacao;
	}

	public void setPopulacao(Long populacao) {
		Populacao = populacao;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String Nome) {
		this.Nome = Nome;
	}
}
