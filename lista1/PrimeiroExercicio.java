//1.O programa “bem-vindo” pergunta seu nome e sobrenome, 
//e depois gentilmente te cumprimenta.

package br.com.residencia.poo.primeiralista;

import java.util.Scanner;

public class PrimeiroExercicio 
{
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		String nome;
		String sobrenome = null;
		
		while(true)
		{
			System.out.print("Nome: ");
			nome = input.nextLine();
		
			
			System.out.print("Sobrenome: ");
			sobrenome = input.nextLine();
						
			boolean verifica_nome = nome.matches("[a-zA-Z]+");
			boolean verifica_sobrenome = sobrenome.matches("[a-zA-Z]+");
			
			if(verifica_nome && verifica_sobrenome)
			{
				System.out.println("Seu nome é " + nome + ", e seu sobrenome é " + sobrenome + ".");
				break;
			}
			else
			{
				System.out.println("Nome ou sobrenome inválidos!");
				System.out.println("O nome e sobrenome não podem conter números nem caracteres especiais.");
				System.out.println("Tente novamente.");
			}		
		}
	}	
}
