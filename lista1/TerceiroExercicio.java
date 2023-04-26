//3.Crie o programa “minicalculadora”, que após ler dois números inteiros apresenta as 
//operações de soma, subtração, multiplicação e divisão com eles.

package br.com.residencia.poo.primeiralista;

import java.util.Scanner;

public class TerceiroExercicio 
{
	
	static float num1, num2;
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
				
		int verificanum1, verificanum2, numInt1, numInt2;
		String escolha = "";
		
		System.out.print("Digite o valor 1: ");
		num1 = input.nextFloat();
		
		System.out.print("Digite o valor 2: ");
		num2 = input.nextFloat();
		
		verificanum1 = (int)num1*10;
		verificanum2 = (int)num2*10;
		
		if((verificanum1 % 10 == 0) && (verificanum2 % 10 == 0 ))
		{
			numInt1 = (int)num1;
			numInt2 = (int)num2;
		}
		else if((verificanum1 % 10 == 0) && (verificanum2 % 10 != 0))
		{
			numInt1 = (int)num1;
			num2 = num2;			
		}
		else if((verificanum1 % 10 != 0) && (verificanum2 % 10 == 0)) 
		{
			num1 = num1;
			numInt2 = (int)num2;
		}
		else 
		{
			num1 = num1;
			num2 = num2;
		}
		
		System.out.println("Escolha a operação abaixo:");
		System.out.println("a)Soma");
		System.out.println("b)Subtração");
		System.out.println("c)Multiplicação");
		System.out.println("d)Divisão");
		System.out.println("Digite a escolha ao lado: ");
		escolha = input.next();
				
		if(escolha.equals("a"))
		{
			soma();
		}
		else if(escolha.equals("b"))
		{
			subtracao();
		}
		else if(escolha.equals("c"))
		{
			multiplicacao();
		}
		else if(escolha.equals("d"))
		{
			if(num2 == 0)
			{
				System.out.println("Não é possível dividir por zero. Tente novamente");
			}
			else
			{
				divisao();
			}
		}
		else
		{
			System.out.println("Escolha inválida! Tente de novo.");
		}					
	}
	
	static void soma()
	{
		float somar = num1 + num2;
		System.out.println(+num1+" + "+num2+" = "+somar);
	}
	static void subtracao()
	{
		float subtrair = num1 - num2;
		System.out.println(+num1+" - "+num2+" = "+subtrair);
	}
	static void multiplicacao()
	{
		float multiplicar = num1 * num2;
		System.out.println(+num1+" * "+num2+" = "+multiplicar);
	}
	static void divisao()
	{
		float dividir = num1 * num2;
		System.out.println(+num1+" * "+num2+" = "+dividir);
	}
}
