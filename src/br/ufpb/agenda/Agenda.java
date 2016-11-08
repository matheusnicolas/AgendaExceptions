package br.ufpb.agenda;

import java.util.ArrayList;
import java.util.List;

public class Agenda implements AgendaIF {

	private List<Contato> contatos;
	
	public Agenda(){
		this.contatos = new ArrayList<Contato>();
	}
	@Override
	public String cadastraContato(Contato c) {
		this.contatos.add(c);
		if (c.getId() == null){
			c.setId(geraId());
		}
		return c.getId();
		
	}
	
	private String geraId(){
		return "C"+this.contatos.size();
	}
	

	@Override
	public Contato pesquisaContatoPeloNome(String nome) throws ContatoNaoExisteException {
		for (Contato c: this.contatos){
			if (c.getNome().equals(nome)){
				return c;
			}
		}
		throw new ContatoNaoExisteException("Não existe contato com o nome:"+nome);
	}

	@Override
	public void removeContatoPeloNome(String nome) throws ContatoNaoExisteException {
		Contato c = this.pesquisaContatoPeloNome(nome);
		this.contatos.remove(c);
	}
	@Override
	public List<Contato> getTodosOsContatos() {
		return this.contatos;
	}
	
/*	public void removeContatoPeloNome(String nome) throws ContatoNaoExisteException {
		boolean removeu = false;
		for (Contato c: this.contatos){
			if (c.getNome().equals(nome)){
				this.contatos.remove(c);
				removeu = true;
				break;
			}
		}
		if (!removeu){
			throw new ContatoNaoExisteException("Não existe contato com o nome:"+nome);
		}

	}
	*/

}
