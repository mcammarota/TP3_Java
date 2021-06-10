package dominio;

public class Aluno extends Pessoa {
	
	private float nota1;
	private float nota2;
	private float media;
	
	public Aluno() {
		
	}
	
	public Aluno(String nome, int idade) {
		super(nome, idade);
	}
	
	public float calcularMedia() {
		return (this.nota1 + this.nota2)/2;
	}
	
	public String getSituacao() {
		media = calcularMedia();
		if(media < 4) {
			return "Reprovado";
		} else if (media > 4 && media < 7) {
			return "Prova final";
		} else {
			return "Aprovado";
		}
	}
	
	@Override
	public String toString() {
		media = calcularMedia();
		return String.format("%.1f - %.1f - %.1f (%s)", nota1, nota2, media, getSituacao());
	}
	
	public float getNota1() {
		return nota1;
	}
	public void setNota1(float nota1) {
		this.nota1 = nota1;
	}
	public float getNota2() {
		return nota2;
	}
	public void setNota2(float nota2) {
		this.nota2 = nota2;
	}

}
