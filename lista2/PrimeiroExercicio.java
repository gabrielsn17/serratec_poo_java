package br.com.residencia.poo.segundalista;

import java.util.Random;
import java.util.Scanner;

public class PrimeiroExercicio 
{

	public static void main(String[] args) 
	{	
		Random aleatorio = new Random();
		Scanner input = new Scanner(System.in);
		
		int universo;
		String nada = "";
		
		universo = aleatorio.nextInt(101);
		
		System.out.println("Qual o significado do universo?");
		System.out.println("Clique no ENTER e descubra seu número do Universo");
		nada = input.nextLine();
		System.out.println("Seu número do universo é: " + universo);
		
	}
	

}
