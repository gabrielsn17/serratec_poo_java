package br.com.poo.contas;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import br.com.poo.dao.DepositoContaCorrenteDAO;
import br.com.poo.dao.DepositoPoupanca;
import br.com.poo.dao.SaqueContaCorrenteDAO;
import br.com.poo.dao.SaquePoupancaDAO;

public class Conta {
	protected String agencia;
	protected String numeroConta;
	protected String titular;
	protected Double saldo = 0.0;

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getSaldo() {
		DecimalFormat df = new DecimalFormat("R$ #,###.00");
		if (this.saldo == 0.0) {
			return "R$ 0,00";
		} else {
			return df.format(saldo);
		}
	}

	@Override
	public String toString() {
		return "Conta [agencia=" + agencia + ", numeroConta=" + numeroConta + ", titular=" + titular + ", saldo="
				+ saldo + "]";
	}

	public Conta() {
	}

	public Conta(String titular) {
		this.titular = titular;
	}

	public Conta(String agencia, String numeroConta, String titular, Double saldo) {
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.saldo = saldo;
	}

	public static boolean saque(String cpfsenha, String agencia, double valor, String cargo, String tipoconta,
			double saldo) {
		if (saldo < valor) {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente");
			return false;
		}

		else if (valor <= 0) {
			JOptionPane.showMessageDialog(null, "Não foi possivel sacar valores negativos");

			return false;

		} else {

			SaqueContaCorrenteDAO.Saque(cpfsenha, agencia, valor, cargo, tipoconta, saldo);

			return true;
		}

	}

	public static boolean sacarPoup(String cpfsenha, String agencia, double valor, String cargo, String tipoconta,
			double saldo) {
		if (saldo < valor) {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente");
			return false;
		}

		if (valor <= 0) {
			JOptionPane.showMessageDialog(null, "Não foi possivel sacar valores negativos");

			return false;

		} else {
			SaquePoupancaDAO.Saque(cpfsenha, agencia, valor, cargo, tipoconta, saldo);

			return true;
		}

	}

	public static boolean depositarDinheiro(String cpfsenha, String agencia, double valord, String cargo,
			String tipoconta) {
		if (valord <= 0) {
			JOptionPane.showMessageDialog(null, "Não é possivel depositar valores negativos");
			return false;
		} else {

			DepositoContaCorrenteDAO.Deposito(cpfsenha, agencia, valord, cargo, tipoconta);

			return true;

		}
	}

	public static boolean depositarDinheiroPoup(String cpfsenha, String agencia, double valord, String cargo,
			String tipoconta) {
		if (valord <= 0) {
			JOptionPane.showMessageDialog(null, "Não é possivel depositar valores negativos");
			return false;
		} else {

			DepositoPoupanca.Deposito(cpfsenha, agencia, valord, cargo, tipoconta);

			return true;

		}
	}

	public boolean depositarCheque(double valor) {
		if (valor <= 0 || valor > 50000) {
			return false;
		} else {
			this.saldo += valor;
			return true;
		}
	}

	public boolean transferirSaque(double valor) {
		if (valor <= 0) {
			return false;
		} else {
			this.saldo += valor;
			return true;
		}
	}

//	public boolean transferir(String cpfsenha, String agencia,double valor,String cargo,String tipoconta,double saldo)
//	{
//		if(sacar(tipoconta, tipoconta, saldo, tipoconta, tipoconta, saldo) && destino.transferirSaque(valor))
//		{			
//			return true;
//		}
//		else
//		{
//			return false;
//		}			
//	}

}
