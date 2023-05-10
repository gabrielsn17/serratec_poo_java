package br.com.poo.vo;

import javax.swing.JOptionPane;

public class CadastroClienteVO {

	private String nome;
	private String sobrenome;
	private String cpf;
	private String email;
	private String contato;
	private String cargo;
	private String senha ;
	private String saldos;
	private String salarios;
	private String saldops;
	private double saldop;
	private double saldo;
	private double salario;
	
	
	public CadastroClienteVO(String nome, String sobrenome, String cpf, String email, String contato, String cargo,
		String senha, String saldos, double saldo,String salarios, double salario) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.contato = contato;
		this.cargo = cargo;
		this.senha = senha;
		this.saldos = saldos;
		this.saldo = saldo;
		this.salarios = salarios;
	}


	public CadastroClienteVO() {
		super();
	
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContato() {
		return contato;
	}


	public void setContato(String contato) {
		this.contato = contato;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getSaldos() {
		return saldos;
	}


	public void setSaldos(String saldos) {
		this.saldos = saldos;
	}


	public double getSaldo() {
		return saldo=Double.parseDouble(saldos);
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public double getSalario() {
		return salario=Double.parseDouble(salarios);
	}


	public void setSalario(String salarios) {
		this.salarios = salarios;
	}
	public String getSalarios() {
		return salarios;
	}


	public void setSalarios(String salarios) {
		this.salarios = salarios;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getSaldops() {
		return saldops;
	}


	public void setSaldops(String saldops) {
		this.saldops = saldops;
	}


	public double getSaldop() {
		return saldop=Double.parseDouble(saldops);
	}


	public void setSaldop(double saldop) {
		this.saldop = saldop;
	}


	
	
    
    

 
}
