package br.com.residencia.poo.segundalista;

import java.util.Scanner;

public class TerceiroExercicio 
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		int qnt, valor;
		String nome;
		
		System.out.println("Qual o seu nome? ");
		nome = input.next();
		
		int tamanho = nome.length();
		boolean temnumero = false;
		
		for(int i = 0; i < tamanho; i++)
		{
			String s = nome.substring(i, i + 1);
			if(s == "0" || s == "1" || s == "2" || s == "3" || s == "4"
			|| s == "5" || s == "6" || s == "7" || s == "8" || s == "9")
			{
				temnumero = true;
			}
		}
		
		if(temnumero)
		{
			System.out.println("Nome Inválido, não pode conter números! Tente de novo.");
		}
		else
		{
			System.out.println("Olá " + nome + "!" + " Quantos itens você irá comprar?");
		}
		
		qnt = input.nextInt();
		
		limpa();
		
		System.out.print("Comprando");
		aguarde(500);
		System.out.print(".");
		aguarde(500);
		System.out.print(".");
		aguarde(500);
		System.out.print(".");
		aguarde(500);
		
		limpa();
		
		System.out.println("Parabéns " + nome + "!" + "Você comprou " + qnt + " produtos!");
		
	}
	
	public static void aguarde(int milissegundos) 
	{
        try 
        {
            Thread.sleep(milissegundos);
        }
        catch (InterruptedException e) 
        {   
        }
    }
	
	public static void limpa()
	{
		for(int i = 0; i < 50; i++)
		{
			System.out.println("\n");
		}
	}
}

