package br.com.residencia.poo.exemplos;

public class Aluno 
{
	private String nome = "Zézinho";
	private int idade;
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setIdade(int idade)
	{
		if(idade > 0 && idade < 110)
		{
			this.idade = idade;
			System.out.println("Idade cadastrada!");
		}
		else
		{
			System.out.println("Erro. Idade Inválida!");
		}		
	}	
	
}
