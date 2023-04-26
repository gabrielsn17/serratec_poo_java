package br.com.residencia.poo.segundalista;

import java.util.Scanner;

public class QuartoExercicio
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		String nome, apelido;
		
		System.out.print("Olá, qual é o seu nome? ");
		nome = input.next();
		limpa();
		System.out.print("Como você gostaria de ser chamado? ");
		apelido = input.next();
		limpa();
		
		System.out.println("Saudações " + apelido + "!");						
	}

	public static void limpa()
	{
		for(int i = 0; i < 50; i++)
		{
			System.out.println("\n");
		}
	}
	
}
