package br.ufpb.agenda;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

public class MenuAgenda {

	public static void main(String[] args) {
		AgendaIF agenda = new Agenda();
		GravadorDeContatos gravador = new GravadorDeContatos("contatos.txt");
		
		List<Contato> contatosGravados;
		try {
			contatosGravados = gravador.recuperaContatos();
			for (Contato c: contatosGravados){
				agenda.cadastraContato(c);
			}
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Lista de contatos vazia");
		}
		
		
		boolean querSair = false;
		while (!querSair) {
			String opcao = JOptionPane.showInputDialog(
					"Qual a opção desejada?1. Cadastrar contato; 2.Pesquisar contato; 3. Remover contato; 4. Sair");
			if (opcao.equals("1")) {
				String nome = JOptionPane.showInputDialog("Qual o nome?");
				String tel = JOptionPane.showInputDialog("Qual o telefone?");
				Contato c = new Contato(nome, tel);
				agenda.cadastraContato(c);
			} else if (opcao.equals("2")) {
				String nomeAPesquisar = JOptionPane.showInputDialog("Qual o nome do contato a pesquisar?");
				try {
					Contato contatoAchado = agenda.pesquisaContatoPeloNome(nomeAPesquisar);
					JOptionPane.showMessageDialog(null, "Foi encontrado o contato:" + contatoAchado.toString());
				} catch(ContatoNaoExisteException e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			} else if (opcao.equals("3")) {
				String nomeARemover = JOptionPane.showInputDialog("Qual o nome do contato a remover?");
				try {
					agenda.removeContatoPeloNome(nomeARemover);
					JOptionPane.showMessageDialog(null, "Foi removido com sucesso o contato:");
				} catch (ContatoNaoExisteException e){
					JOptionPane.showMessageDialog(null, "Contato não pôde ser removido. Erro:"+e.getMessage());
				}
			} else if (opcao.equals("4")){
				querSair = true;
				try {
					gravador.gravaContatos(agenda.getTodosOsContatos());
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Contatos não salvos. Erro:"+e.getMessage());
				}
			}
		}
	}

}
