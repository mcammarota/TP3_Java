package dominio;

import exceptions.InputMismatchException;
import exceptions.NomeIncompletoException;

public abstract class Pessoa {
	
	private int id;
	private String nome;
	private String sobrenome;
	private String ultimoNome;
	private int idade;
	
	public Pessoa() {
		nome = "Fulano";
	}
	
	public Pessoa(String nome, int idade) {
		this();
		this.nome = nome;
		this.idade = idade;
	}
	
	public Pessoa(String nome, String sobrenome, int idade) {
		this();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
	}
	
	public void imprimir() throws NomeIncompletoException {
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
	
	public StringBuilder getNome() throws NomeIncompletoException {
		
		if(ultimoNome == null || nome == null || sobrenome == null) {
			throw new NomeIncompletoException("Preenchimento inválido!");

		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(ultimoNome.toUpperCase());
		sb.append(", ");
		sb.append(nome.substring(0,1).toUpperCase() + nome.substring(0, 1));
		sb.append(sobrenome.toUpperCase().charAt(0));
		sb.append(".");
		return sb;
	}
	
	public void setNome(String nome) {
		int posInicial = nome.indexOf(" ");
		int posFinal = nome.lastIndexOf(" ");

		this.nome = nome.substring(0, posInicial);
		this.sobrenome = nome.substring(posInicial, posFinal).trim();
		this.ultimoNome = nome.substring(posFinal).trim();
	}

//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public String getSobrenome() {
//		return sobrenome;
//	}
//
//	public void setSobrenome(String sobrenome) {
//		this.sobrenome = sobrenome;
//	}
//
//	public String getUltimoNome() {
//		return ultimoNome;
//	}
//
//	public void setUltimoNome(String ultimoNome) {
//		this.ultimoNome = ultimoNome;
//	}

	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) throws InputMismatchException {
		if (idade != (int)idade) {
			throw new InputMismatchException("A idade precisa ser um número inteiro.");
		}
		
		this.idade = idade;
	}
}
