package br.com.poo.dao;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.com.poo.conexao.Conexao;
import br.com.poo.interfac.Interface;

public class RelatorioPresidente {

	public static void Totalagencia(String cpfsenha, String agencia) {

		Conexao con = new Conexao();

		String sql = "select count(agencia) as count from funcionario;";

		ResultSet rs = con.Count(sql);
		try {

			while (rs.next()) {

				int count = rs.getInt("count");
				JOptionPane.showMessageDialog(null, "Easy Bank possui: " + count + " contas ativas");
				Interface.MenuPresidente(cpfsenha);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void RelatorioCliente(String cpfsenha, String agencia) {
		Conexao con = new Conexao();

		String sql = "select * from funcionario f order by ascii(nome);";

		ResultSet rs = con.executaBusca(sql);
		try {
			String mensagem = "";
			while (rs.next()) {



				mensagem += "" + rs.getString("nome");
				mensagem += " " + rs.getString("sobrenome") + "\n";
				mensagem += "CPF: "  + rs.getString("cpf") + "\n";
				mensagem += "Email: " + rs.getString("email") + "\n";
				mensagem += "Telefone: " + rs.getString("contato") + "\n";
				mensagem += "Tipo de conta: " + rs.getString("tipoconta") + "\n";
				mensagem += "Agência: " + rs.getString("agencia") + "\n";
				mensagem += "Saldo Conta Corrente: R$" + rs.getString("saldo") + "\n";
				mensagem += "Saldo Conta Poupança: R$" + rs.getString("poupanca") + "\n----------------------------\n";

			}
			JTextArea textarea = new JTextArea(mensagem);
			JScrollPane scrollPane = new JScrollPane(textarea);
			scrollPane.setPreferredSize(new Dimension(400, 800));
			JOptionPane.showMessageDialog(null, scrollPane, "Título da janela", JOptionPane.PLAIN_MESSAGE);
			Interface.MenuPresidente(cpfsenha);

			// JOptionPane.showMessageDialog(null, mensagem, "Relatório de clientes
			// cadastrados", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void TotalFinanceiro(String cpfsenha, String agencia) {
		DecimalFormat df = new DecimalFormat("R$ #,###.00");
		Conexao con = new Conexao();

		String sql = "select sum (saldo+poupanca) as count from funcionario f";

		ResultSet rs = con.Count(sql);
		try {

			while (rs.next()) {

				int count = rs.getInt("count");
				JOptionPane.showMessageDialog(null, "Easy Bank administra até o momento: " + df.format(count));
				Interface.MenuPresidente(cpfsenha);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
