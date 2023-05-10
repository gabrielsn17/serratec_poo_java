package br.com.poo.dao;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.poo.conexao.Conexao;

public class ConsultaSaldoCliente {
	
	
	public static void Corrente(String cfpsenha) {

		String cpf = JOptionPane.showInputDialog("Informe o CPF do usuário:");
		Conexao con = new Conexao();
		String sql = "select * from funcionario f where cpf=" + "'" + cpf + "'" + ";";
		ResultSet rs = con.executaBusca(sql);

		try {
			while (rs.next()) {

				String saldo = rs.getString("saldo");
				String poupanca = rs.getString("poupanca");
				String tipoconta=rs.getString("tipoconta");
				if(tipoconta.equalsIgnoreCase("corrente")){
					JOptionPane.showMessageDialog(null, "Seu saldo na Conta Corrente é de: R$"+saldo);					
				}
				else if(tipoconta.equalsIgnoreCase("Poupanca")) {
					JOptionPane.showMessageDialog(null, "Seu saldo na Conta Poupança é de: R$"+poupanca);
				}
				else if(tipoconta.equalsIgnoreCase("ambos")){
					JOptionPane.showMessageDialog(null, "Seu saldo na Conta Corrente é de: R$"+saldo
					+"\nSeu saldo na Conta Poupança é de: R$"+poupanca);
				}
				
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}
