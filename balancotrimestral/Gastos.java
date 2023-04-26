package br.com.poo.balancotrimestral;

public class Gastos 
{
	private double gastosMes;

	public double getGastosMes() 
	{		
		return gastosMes;
	}

	public void setGastosMes(double gastosMes) 
	{
		if(gastosMes < 0)
		{
			System.out.println("Os gastos não podem ser negativos!");
		}
		else 
		{
			this.gastosMes = gastosMes;
		}		
	}		
}
