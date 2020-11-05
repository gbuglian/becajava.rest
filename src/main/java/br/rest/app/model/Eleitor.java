package br.rest.app.model;

public class Eleitor {
	
	private Long Id;
	private String Nome;
	private String tituloNum;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTituloNum() {
		return tituloNum;
	}

	public void setTituloNum(String tituloNum) {
		this.tituloNum = tituloNum;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}	
}
