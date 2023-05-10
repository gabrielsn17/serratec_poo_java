package br.com.poo.dao;

import java.awt.Dimension;
import java.sql.ResultSet;
import static javax.swing.ScrollPaneConstants.*;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.com.poo.conexao.Conexao;

public class ExtratoCliente {
	
	public static void ExtratoClienteConta(String cpfsenha, String agencia) {
	
		Conexao con = new Conexao();

		String sql = "select descricao from relatorio where cpfsenha=" + "'" + cpfsenha + "'" + ";";

		ResultSet rs = con.executaBusca(sql);
		try {
			String mensagem = "";
			while (rs.next()) {
				
				mensagem += "" + rs.getString("descricao")+"\n**********************************************************\n";
			

			}
		
	        JTextArea textarea = new JTextArea(mensagem);
	        textarea.setLineWrap(true);
	        textarea.setWrapStyleWord(true);
	        JScrollPane scrollPane = new JScrollPane(textarea);
	        scrollPane.setPreferredSize(new Dimension(400, 800));
	        scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
	    
	        JOptionPane.showMessageDialog(null, scrollPane, "Extrato", JOptionPane.PLAIN_MESSAGE);
			
			


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
