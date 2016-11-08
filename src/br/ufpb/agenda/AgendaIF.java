package br.ufpb.agenda;

import java.util.List;

/**
 * Interface que define uma agenda genérica.
 * @author ayla
 *
 */
public interface AgendaIF {
	
	/**
	 * Cadastra um novo contato na agenda.
	 * @param c O contato a ser cadastrado.
	 * @return o identificador (id) do contato cadastrado.
	 */
	public String cadastraContato(Contato c);
	
	/**
	 * Pesquisa um contato a partir do nome
	 * @param nome O nome do contato a ser pesquisado.
	 * @return o contato encontrado.
	 * @throws ContatoNaoExisteException caso não exista contato com esse nome.
	 */
	public Contato pesquisaContatoPeloNome(String nome) throws ContatoNaoExisteException;
	
	/**
	 * Remove um contato que tem um dado nome.
	 * @param nome O nome do contato a ser removido.
	 * @throws ContatoNaoExisteException Caso não exista nenhum contato
	 * com esse nome;
	 */
	public void removeContatoPeloNome(String nome) throws ContatoNaoExisteException;
	
	/**
	 * Obtem a lista completa dos contatos.
	 * @return a lista dos contatos.
	 */
	public List<Contato> getTodosOsContatos();
	
}
