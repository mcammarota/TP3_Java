// foi alterado o domínio Pessoa, portanto está dando erro neste teste.

package testes;

import java.util.Scanner;

import dominio.Aluno;
import dominio.Pessoa;
import dominio.Professor;

public class TP2 {
	
	private static Pessoa[] pessoas;
	
	private static int index;	

	private static final int QTDE = 100;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		pessoas = new Pessoa[QTDE];
		
		String opcao = null;
		
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
					
					System.out.println("Informe o nome: ");
					prof.setNome(in.next());
					
					System.out.println("Informe o sobrenome: ");
					prof.setSobrenome(in.next());
					
					System.out.println("Informe a idade: ");
					prof.setIdade(in.nextInt());
					
					System.out.println("Informe o salário: ");
					prof.setSalario(in.nextFloat());
					
					System.out.println("Informe se é integral: ");
					prof.setIntegral(in.nextBoolean());
					
					pessoas[index] = prof;
					
					index++;
					
				} else {
					System.out.println("Não existe mais vaga para o cadastramento!!!");
				}
				
				break;
				
			case "2":
				if(index < QTDE) {
					Aluno aluno = new Aluno();
					
					aluno.setId(index);
					
					System.out.println("Informe o nome: ");
					aluno.setNome(in.next());
					
					System.out.println("Informe o sobrenome: ");
					aluno.setSobrenome(in.next());
					
					System.out.println("Informe a idade: ");
					aluno.setIdade(in.nextInt());
					
					System.out.println("Informe a nota 1: ");
					aluno.setNota1(in.nextFloat());
					
					System.out.println("Informe a nota 2: ");
					aluno.setNota2(in.nextFloat());
					
					pessoas[index] = aluno;
					
					index++;
				} else {
				System.out.println("Não existe mais vaga para o cadastramento!!!");
				}
			
				break;
				
			case "3":
				System.out.print("Informe a posição: ");
				int pos = in.nextInt();
				
				if(pos >= 0 && pos < index) {
					pessoas[pos].imprimir();
				} else {
					System.out.println("Pessoa inexistente.");
				}
				
				break;
				
			case "4":
				System.out.println("Finalizou!");
				break;
				
			default:
				System.out.println("Opção inválida!");
				break;
			}
			
		} while (!opcao.equals("4"));
		
		in.close();
	}

	private static void imprimir() {
		System.out.println("Listagem de inscritos:");
		for(int i = 0; i < index; i++) {
			pessoas[i].imprimir();
		}
	}
}
