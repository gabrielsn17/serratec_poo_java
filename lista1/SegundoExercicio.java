//2.O programa “Tempo de vida” irá imprimir a soma das idades de todos os colegas da sua equipe
//(6 pessoas). Pergunte a cada um a idade e não esqueça a sua! Depois faça a atribuição direta 
//da expressão em uma variável inteira.

package br.com.residencia.poo.primeiralista;

import java.util.Scanner;

public class SegundoExercicio {

	
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		int somar = 0;
		
		for(int i = 0; i < 6; i++)
		{
			System.out.println("Digite a idade do "+(i + 1)+" colega: ");
			int idade = input.nextInt();
			somar += idade;			
		}
		
		System.out.println("A soma das idades dos colegas é: "+somar);
	}
}
