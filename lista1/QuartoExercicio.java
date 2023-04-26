//4.O programa “termômetro” lê uma temperatura em graus celsius, e devolve sua equivalência 
//na escala fahrenheit. (Use: F = C * 1, 8 + 32)

package br.com.residencia.poo.primeiralista;

import java.util.Scanner;

public class QuartoExercicio 
{

	public static void main(String[] args) 
	{
		float cel = 0, resultado;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite a temperatura em graus Celsius e irei converter para Fahrenheit.");
		System.out.print("Temperatura em °C: ");
		cel = input.nextFloat();
		
		resultado = (cel * 1.8f) + 32;
		
		float arredonda = Math.round(resultado);
		
		System.out.println("Temperatura em °C: "+cel);
		System.out.println("Temperatura em °F: "+arredonda);
		
		
	}

}
