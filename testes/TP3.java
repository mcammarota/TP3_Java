package testes;

import java.util.Scanner;

import dominio.Aluno;
import dominio.Pessoa;
import dominio.Professor;
import dominio.Aluno;
import exceptions.NumberFormatException;
import exceptions.StringIndexOutOfBoundsException;

public class TP3 {
	
	private static Pessoa[] pessoas;
	
	private static int index;	

	private static final int QTDE = 100;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		pessoas = new Pessoa[QTDE];
		
		String opcao = null;
		
		try {
			do {
				System.out.println("[1] Cadastrar professor");
				System.out.println("[2] Cadastrar aluno");
				System.out.println("[3] Consultar situação de um docente/discente");
				System.out.println("[4] Sair.");
				
				System.out.print("Informe a opção desejada: ");
				opcao = in.next();
				
				switch (opcao) {
				case "1":
					if(index < QTDE) {
						
						Professor prof = new Professor();

						prof.setId(index);

						System.out.println("Informe o nome completo: ");
						try {
							in.nextLine();
							String nome = in.nextLine();
							prof.setNome(nome);
						} catch (Exception e) {
							System.out.println("Erro: nome precisa ser completo.");
							break;
						}

						System.out.println("Informe a idade: ");
						try { 
							String idade = in.next();
							int Value = Integer.parseInt(idade);
							prof.setIdade(Value);
						} catch (Exception e) {
							System.out.println("Erro: o número deve ser inteiro.");
							break;
						}

						System.out.println("Informe o salário: ");
						prof.setSalario(in.nextFloat());

						System.out.println("Informe se é integral: ");
						prof.setIntegral(in.nextBoolean());

						pessoas[index] = prof;

						index++;

					} else {
						System.out.println("Não existe mais vaga para o cadastramento!");
					}

					break;
					
				case "2":
					if(index < QTDE) {
						Aluno aluno = new Aluno();

						aluno.setId(index);

						System.out.println("Informe o nome completo: ");
						try {
							in.nextLine();
							String nome = in.nextLine();
							aluno.setNome(nome);
						} catch (Exception e) {
							System.out.println("Erro: nome precisa ser completo.");
							break;
						}

						System.out.println("Informe a idade: ");
						try { 
							String idade = in.next();
							int Value = Integer.parseInt(idade);
							aluno.setIdade(Value);
						} catch (Exception e) {
							System.out.println("Erro: o número deve ser inteiro.");
							break;
						}

						System.out.println("Informe a nota 1: ");
						aluno.setNota1(in.nextFloat());

						System.out.println("Informe a nota 2: ");
						aluno.setNota2(in.nextFloat());

						pessoas[index] = aluno;

						index++;

					} else {
						System.out.println("Não existe mais vaga para o cadastramento!");
					}

					break;
					
				case "3":
					System.out.print("Informe a posição: ");
					int pos = in.nextInt();
					
					if(pos >= 0 && pos < index) {
						try {
							pessoas[pos].imprimir();
						} catch (StringIndexOutOfBoundsException e) {
							System.out.println("Erro: " + e.getMessage());
						}
					} else {
						System.out.println("Pessoa inexistente.");
					}
					
					break;
					
				case "4":
					break;
				
				default:
					System.out.println("Opção inválida!");
					break;
				}
				
			} while (!opcao.equals("4"));
			
			in.close();
		} finally {
			System.out.println("Pesquisa finalizada!");
		}	
	}

	private static void imprimir() {
		System.out.println("Listagem de inscritos:");
		for(int i = 0; i < index; i++) {
			try {
				pessoas[i].imprimir();
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
	}
}