package br.com.poo.pessoas;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Pessoa 
{
	private String nome;
	private String sobrenome;
	private String cpf;
	private String email;
	private String contato;
	
	
	
	
	
	public Pessoa(String nome,String sobrenome,String cpf,String email,String contato){
		
		this.nome=nome;
		this.sobrenome=sobrenome;
		this.cpf=cpf;
		this.email=email;
		this.contato=contato;
		
	}
	public Pessoa() {
		
		
	}
	
	public String getNome() 
	{				
		  
	    
		return nome;						
	}
	
	public void setNome(String nome) 
	{							
		for (int i = 0; i < nome.length(); i++) 
		{
	        if (Character.isDigit(nome.charAt(i)) || nome.length() < 3 || nome.equals(" ") || nome.equals("")) 
	        {
	             System.out.println("O Nome não pode:"
		            		+ "\n-Conter números;"
		            		+ "\n-Estar vazio;"
		            		+ "\n-Ser menor que três caracteres;");   	            
	        }
	        else 
	        {	        	
	        	this.nome = nome;
			}
		}		
	}
	
	public String getSobrenome() 
	{
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) 
	{
		this.sobrenome = sobrenome;
	}
	
	public String getCpf() 
	{
		return cpf;
	}
	
	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}
	

	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	

	public String getContato() 
	{
		return contato;
	}
	
	public void setContato(String contato) 
	{
		this.contato = contato;
	}

	public static Pessoa[] getPessoa() {
		// TODO Auto-generated method stub
		return null;
	}
	
		
}
