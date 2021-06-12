package dominio;

import exceptions.NumberFormatException;
import exceptions.StringIndexOutOfBoundsException;

public abstract class Pessoa {
	
	private int id;
	private String nome;
	private String sobrenome;
	private int idade;
	
	public Pessoa() {
		nome = "Fulano";
	}
	
	public void imprimir() throws StringIndexOutOfBoundsException {
		System.out.printf("%d :: %s - %d - %s\n",
				id,
				this.getNome(),
				getIdade(),
				this.toString()
				);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public StringBuilder getNome() throws StringIndexOutOfBoundsException {
		
		if(nome == null || sobrenome == null) {
			throw new StringIndexOutOfBoundsException("Erro: nome precisa ser completo.");
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(sobrenome.toUpperCase());
		sb.append(", ");
		sb.append(nome.toUpperCase().charAt(0));
		sb.append(".");
		return sb;
	}
	
	public void setNome(String nome) {
		int posInicial = nome.indexOf(" ");

		this.nome = nome.substring(0, posInicial);
		this.sobrenome = nome.substring(posInicial).trim();
	}

	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) throws NumberFormatException {
		
		if (idade != (int) idade) {
			throw new NumberFormatException("Erro: número deve ser inteiro.");
		}
		
		this.idade = idade;
	}
}
	
