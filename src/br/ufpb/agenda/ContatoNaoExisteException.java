package br.ufpb.agenda;

public class ContatoNaoExisteException extends Exception {
	
	/**
	 * Versão da exceção.
	 */
	private static final long serialVersionUID = 1L;

	public ContatoNaoExisteException(String msg){
		super(msg);
	}
}
