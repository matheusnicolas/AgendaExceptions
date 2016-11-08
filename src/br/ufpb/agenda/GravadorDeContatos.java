package br.ufpb.agenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeContatos {
	private String nomeArquivo;

	public GravadorDeContatos(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public void gravaContatos(List<Contato> contatos) throws IOException {
		BufferedWriter escritor = null;
		try {
			escritor = new BufferedWriter(new FileWriter(this.nomeArquivo));
			for (Contato c : contatos) {
				escritor.write(c.getNome() + "\n");
				escritor.write(c.getTelefone() + "\n");
				escritor.write(c.getId() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (escritor != null) {
				escritor.close();
			}
		}

	}

	public List<Contato> recuperaContatos() throws IOException{
		BufferedReader leitor = null;
		List<Contato> contatos = new ArrayList<Contato>();
		try {
			leitor = new BufferedReader(new FileReader(this.nomeArquivo));
			String linhaLida;
			do {
				linhaLida = leitor.readLine();
				if (linhaLida!=null){
				 Contato c = new Contato("","");
				 c.setNome(linhaLida);
				 linhaLida = leitor.readLine();
				 c.setTelefone(linhaLida);
				 linhaLida = leitor.readLine();
				 c.setId(linhaLida);
				 contatos.add(c);
				}
			} while (linhaLida!=null);
		} catch (IOException e){
			e.printStackTrace();
		} finally{
			if (leitor!=null){
				leitor.close();
			}
		}
		return contatos;
	}
}
