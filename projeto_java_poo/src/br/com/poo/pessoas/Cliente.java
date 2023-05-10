package br.com.poo.pessoas;

public class Cliente extends Pessoa{
	
	
	public Cliente(String nome, String sobrenome, String cpf, String email, String contato,Double saldo) {
		super(nome, sobrenome, cpf, email, contato);
		
	}
	private String agencia;
	private String numconta;
	
	
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumconta() {
		return numconta;
	}
	public void setNumconta(String numconta) {
		this.numconta = numconta;
	}
}
