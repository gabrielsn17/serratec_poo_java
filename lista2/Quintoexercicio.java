package br.com.residencia.poo.segundalista;

import java.util.Scanner;

public class Quintoexercicio 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		int my_age, city_age= 131, cidade;
		
		System.out.print("Olá, quantos anos você tem? ");
		my_age = input.nextInt();
		limpa();
		
		cidade = city_age - my_age;
		
		System.out.println("Teresópolis tem " + city_age + " anos.Desses, "+ cidade + " foram antes de mim. Mas os últimos " + my_age + " anos contaram comigo!");
	}
	public static void limpa()
	{
		for(int i = 0; i < 50; i++)
		{
			System.out.println("\n");
		}
	}
}
