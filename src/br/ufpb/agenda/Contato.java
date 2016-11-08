package br.ufpb.agenda;

public class Contato {
	private String id;
	private String nome;
	private String telefone;
	
	public Contato(String nome, String tel){
		this.setNome(nome);
		this.setTelefone(tel);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String toString (){
		return "Nome:"+this.nome+", Telefone:"+this.telefone+", Id:"+this.id;
	}
}
