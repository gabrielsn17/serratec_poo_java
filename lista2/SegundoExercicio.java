package br.com.residencia.poo.segundalista;

import java.util.Random;

public class SegundoExercicio 
{

	public static void main(String[] args) 
	{
		Random aleatorio = new Random();
		
		int idade = aleatorio.nextInt(50)+1;
		
		if(idade == 1)
		{
			System.out.println("A Empresa Alterdata tem " + idade +" ano.");
		}
		else
		{
			System.out.println("A Empresa Alterdata tem " + idade +" anos.");
		}
	}
}
