	package br.com.poo.vo;

import java.awt.Dimension;
import java.sql.*;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import br.com.poo.conexao.Conexao;
import br.com.poo.dao.AlterarTipoConta;
import br.com.poo.pessoas.Gerente;

public class MenuGerenteVO {

	public static void PreMenu(String cpfsenha, String agencia) {
		Object[] escolha = { "Gerente", "Cliente" };
		Object opcao = JOptionPane.showInputDialog(null, "Escolha", "Deseja entrar como:",
				JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[1]);
		String selecao = (String) opcao;
		if (selecao.equalsIgnoreCase("cliente")) {
			MenuClienteVO.MenuCliente(cpfsenha, agencia);
		}
		if (selecao.equalsIgnoreCase("Gerente")) {
			MenuGerenteVO.MenuGerente(cpfsenha, agencia);
		}

	}

	public static void MenuGerente(String cpfsenha, String agencia) {


		GregorianCalendar gre = new GregorianCalendar();
		Conexao con = new Conexao();
		String sql = "select * from funcionario f where cpfsenha=" + "'" + cpfsenha + "'" + "and agencia=" + "'"
				+ agencia + "'" + ";";
		ResultSet rs = con.executaBusca(sql);
		try {
			while (rs.next()) {

				String nome = rs.getString("nome");

				int operacao = Integer.parseInt(JOptionPane.showInputDialog(null,
						nome + "\n" + gre.getTime() + "\n\n------Selecione uma operação------\n"
								+ "| Opção 1 -Relatorios da Agencia\n" + "| Opção 2 -Relatorio de Clientes\n"
								+ "| Opção 3 -Cadastrar Cliente\n" + "| Opção 4 -Mudar Acesso\n"
								+ "| Opção 5-Alterar Conta Cliente\n" + "| Digite 0 para sair",
						"Menu Gerente ", JOptionPane.INFORMATION_MESSAGE));
				switch (operacao) {
				case 1:
					Totalagencia(cpfsenha, agencia);
					MenuGerente(cpfsenha, agencia);
					break;

				case 2:
					RelatorioCliente(cpfsenha, agencia);
					MenuGerente(cpfsenha, agencia);
					break;
				case 3:
					Gerente.cadastroCliente(cpfsenha);
					MenuGerente(cpfsenha, agencia);
					break;

				case 4:
					MenuGerenteVO.PreMenu(cpfsenha, agencia);
					break;
				case 5:
					AlterarTipoConta.CheckConta(cpfsenha);
					MenuGerente(cpfsenha, agencia);
					break;
				case 0:
					JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia");
					System.exit(0);
				default:
					JOptionPane.showMessageDialog(null, "Esta não é uma opção válida");
					MenuGerente(cpfsenha, agencia);
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void Totalagencia(String cpfsenha, String agencia) {

		Conexao con = new Conexao();

		String sql = "select count(agencia) as count from funcionario f where cpfsenha=" + "'" + cpfsenha + "'"
				+ "or agencia=" + "'" + agencia + "'" + ";";

		ResultSet rs = con.Count(sql);
		try {

			while (rs.next()) {

				int count = rs.getInt("count");
				JOptionPane.showMessageDialog(null, "A agencia " + agencia + " possui : " + count + " contas ativas");
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void RelatorioCliente(String cpfsenha, String agencia) {
		Conexao con = new Conexao();

		String sql = "select * from funcionario f where agencia=" + "'" + agencia + "'" + "order by ascii(nome);";

		ResultSet rs = con.executaBusca(sql);
		try {
			String mensagem = "";
			while (rs.next()) {

				mensagem += "" + rs.getString("nome");
				mensagem += " " + rs.getString("sobrenome") + "\n";
				mensagem += "Email: " + rs.getString("email") + "\n";
				mensagem += "Telefone: " + rs.getString("contato") + "\n";
				mensagem += "Tipo de conta: " + rs.getString("tipoconta") + "\n";
				mensagem += "Saldo Conta Corrente: R$" + rs.getString("saldo") + "\n";
				mensagem += "Saldo Conta Poupança: R$" + rs.getString("poupanca") + "\n----------------------------\n";

			}
			JTextArea textarea = new JTextArea(mensagem);
			JScrollPane scrollPane = new JScrollPane(textarea);
			scrollPane.setPreferredSize(new Dimension(400, 800));
			JOptionPane.showMessageDialog(null, scrollPane, "Título da janela", JOptionPane.PLAIN_MESSAGE);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
