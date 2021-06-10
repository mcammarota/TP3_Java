package dominio;

public class Professor extends Pessoa{
	
	private float salario;
	private boolean integral;
	
	public Professor() {
		
	}
	
	public Professor(String nome, int idade) {
		super(nome, idade);
	}
	
	@Override
	public String toString() {
		return String.format("%.2f - %s", salario, integral);
	}
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public boolean isIntegral() {
		return integral;
	}
	public void setIntegral(boolean integral) {
		this.integral = integral;
	}
}
