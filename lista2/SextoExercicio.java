package br.com.residencia.poo.segundalista;

public class SextoExercicio 
{

	public static void main(String[] args) 
	{
		System.out.println("Os primeiros 4 múltiplos de 4 depois de 1000 são: ");
		aguarde(2500);
		limpa();
		
		System.out.println("1004");
		System.out.println("1008");
		System.out.println("10012");
		System.out.println("10016");
		aguarde(2500);
		limpa();
		
		System.out.println("A soma desses números é igual a 4.040");
		aguarde(2500);
		limpa();
		
		System.out.println("Abaixo, a subtração desse número pelos primeiros 4 números primos, incluindo o 1: ");
		aguarde(3200);
		limpa();
		
		System.out.println("4040 - 1 = 4039");
		System.out.println("4040 - 2 = 4038");
		System.out.println("4040 - 3 = 4037");
		System.out.println("4040 - 5 = 4045");				
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
