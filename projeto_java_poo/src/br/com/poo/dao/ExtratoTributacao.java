package br.com.poo.dao;

import java.awt.Dimension;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.com.poo.conexao.Conexao;

public class ExtratoTributacao {

	public static void ExtratoClienteTributacao(String cpfsenha, String agencia) {
		
		Conexao con = new Conexao();

		String sql = "select * from tributacao where cpfsenha=" + "'" + cpfsenha + "'" + ";";

		ResultSet rs = con.executaBusca(sql);
		try {
			String mensagem = "";
			while (rs.next()) {
				
				mensagem += "" + rs.getString("relatorio")+"\n";
				mensagem += "Tributo R$"+ rs.getString("tributo")+"\n**********************************************************\n";
			

			}
			JTextArea textarea = new JTextArea(mensagem);
			JScrollPane scrollPane = new JScrollPane(textarea);
			scrollPane.setPreferredSize(new Dimension(400, 800));
			JOptionPane.showMessageDialog(null, scrollPane, "Extrato", JOptionPane.PLAIN_MESSAGE);
			



		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
