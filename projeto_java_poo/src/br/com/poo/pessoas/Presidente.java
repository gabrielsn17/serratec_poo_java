package br.com.poo.pessoas;

public class Presidente extends Diretor
{
	public Presidente(String nome, String sobrenome, String cpf, String email, String contato,double salario) {
		super(nome, sobrenome, cpf, email, contato, salario);
		
	}
	
	public void setNovoDiretor() {
		Diretor diretor = new Diretor("ra", "sobre", "14445712", "rafa@hota", "54545454", 50000);
		
		
	}
	

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public void SalarioCaixa() {
		
	}

	
}
