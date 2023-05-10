package br.com.poo.vo;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import br.com.poo.conexao.Conexao;
import br.com.poo.contas.Conta;


import br.com.poo.dao.ExtratoCliente;
import br.com.poo.dao.ExtratoTributacao;
import br.com.poo.dao.TransferenciaDAO;
import br.com.poo.interfac.Interface;

public class MenuClienteVO {
	static DecimalFormat df = new DecimalFormat("R$ #,###.00");

	public static void MenuClienteC(String cpfsenha, String agencia) {

		GregorianCalendar gre = new GregorianCalendar();
		Conexao con = new Conexao();
		String sql = "select * from funcionario f where cpfsenha=" + "'" + cpfsenha + "'" + ";";
		ResultSet rs = con.executaBusca(sql);
		try {
			while (rs.next()) {

				String nome = rs.getString("nome");
				String saldos = rs.getString("saldo");
				double saldo = Double.parseDouble(saldos);
				String cargo = rs.getString("cargo");
				String tipoconta = rs.getString("tipoconta");

				if (cargo.equalsIgnoreCase("cliente")) {
				}

				
				int operacao = Integer.parseInt(JOptionPane.showInputDialog(null,
						nome + "\n" + gre.getTime() + "\n\n------Selecione uma operação------\n" + "| Opção 1 -Saque\n"
								+ "| Opção 2 -Saldo\n" + "| Opção 3 -Deposito\n" + "| Opção 4 -Transferir\n"
								+ "| Opção 5 -Extratos\n" + "| Opção 6- Mudar tipo de Conta\n"
								+ "| Opção 7- Mudar acesso para empresa\n" +  "| Opção 8- Relatório de tributação\n"+
								"| Digite 0 para sair",
						"Menu Cliente", JOptionPane.INFORMATION_MESSAGE));

				switch (operacao) {
				case 1:
					Object valors = JOptionPane.showInputDialog(null, "Qual valor gostaria de sacar?", "Sacar",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon("res/saque.png"), null, null);
					double valor = Double.parseDouble((String) valors);
					Conta.saque(cpfsenha, agencia, valor, cargo, tipoconta, saldo);
					MenuClienteC(cpfsenha, agencia);
					break;
				case 2:

					JOptionPane.showInternalMessageDialog(null, "Seu saldo é: " + df.format(saldo));
					MenuClienteC(cpfsenha, agencia);

					break;
				case 3:
					Object deposito = JOptionPane.showInputDialog(null, "Qual valor gostaria de depositar?", "Deposito",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon("res/qr.jpg"), null, null);
					double valord = Double.parseDouble((String) deposito);
					Conta.depositarDinheiro(cpfsenha, agencia, valord, cargo, tipoconta);
					MenuClienteC(cpfsenha, agencia);
					break;
				case 4:
					TransferenciaDAO.Transferir(cpfsenha, saldo);
					MenuClienteC(cpfsenha,agencia);
					break;
				case 5:
					ExtratoCliente.ExtratoClienteConta(cpfsenha, agencia);
					MenuClienteC(cpfsenha, agencia);
					break;
				case 6:
					MenuCliente(cpfsenha, agencia);
					break;
				case 7:
					if (cargo.equalsIgnoreCase("Gerente")) {
						MenuGerenteVO.MenuGerente(cpfsenha, agencia);
					} else if (cargo.equalsIgnoreCase("Diretor")) {
						Interface.MenuDiretor(cpfsenha);
					} else if (cargo.equalsIgnoreCase("Caixa")) {
						Interface.MenuCaixa(cpfsenha);
					} else if (cargo.equalsIgnoreCase("Presidente")) {
						Interface.MenuPresidente(cpfsenha);
						;
					} else {
						JOptionPane.showMessageDialog(null, "Você não possui um cargo dentro desta Empresa");
						MenuClienteVO.MenuClienteC(cpfsenha, agencia);
					}
					break;
				case 8: 
					ExtratoTributacao.ExtratoClienteTributacao(cpfsenha, agencia);
					MenuClienteC(cpfsenha, agencia);
					break;
				case 0:
					JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia");
					System.exit(0);
				default:
					JOptionPane.showMessageDialog(null, "Opção Invalida");
					MenuClienteC(cpfsenha, agencia);
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void MenuClienteP(String cpfsenha, String agencia) {

		GregorianCalendar gre = new GregorianCalendar();
		Conexao con = new Conexao();
		String sql = "select * from funcionario f where cpfsenha=" + "'" + cpfsenha + "'" + ";";
		ResultSet rs = con.executaBusca(sql);
		try {
			while (rs.next()) {

		
			
				String nome = rs.getString("nome");
				
			
				;
				String poupancas = rs.getString("poupanca");
				double poupanca = Double.parseDouble(poupancas);
				String cargo = rs.getString("cargo");
				String tipoconta = rs.getString("tipoconta");

				int operacao = Integer.parseInt(JOptionPane.showInputDialog(null,
						nome + "\n" + gre.getTime() + "\n\n------Selecione uma operação------\n"
								+ "| Opção 1 -Resgate Poupança\n" + "| Opção 2 -Saldo Poupança\n"
								+ "| Opção 3 -Depósito\n" + "| Opção 4 -Extrato Poupança\n"
								+ "| Opção 5 -Simulação Rendimento\n" + "| Opção 6 -Mudar tipo de conta\n"
								+ "| Digite 0 para sair",
						"Menu Cliente", JOptionPane.INFORMATION_MESSAGE));

				switch (operacao) {
				case 1:
					Object valors = JOptionPane.showInputDialog(null, "Qual valor gostaria de sacar?", "Sacar",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon("res/saque.png"), null, null);
					double valor = Double.parseDouble((String) valors);
					double saldo = poupanca;
					Conta.sacarPoup(cpfsenha, agencia, valor, cargo, tipoconta, saldo);
					MenuClienteP(cpfsenha, agencia);
					break;

				case 2:
					JOptionPane.showInternalMessageDialog(null, "Seu saldo na Poupança é de : " + df.format(poupanca));

					MenuClienteVO.MenuClienteP(cpfsenha, agencia);

					break;
				case 3:
					Object deposito = JOptionPane.showInputDialog(null, "Qual valor gostaria de depositar?", "Deposito",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon("res/qr.jpg"), null, null);
					double valord = Double.parseDouble((String) deposito);
					Conta.depositarDinheiroPoup(cpfsenha, agencia, valord, cargo, tipoconta);
					MenuClienteP(cpfsenha, agencia);
				case 4:
					ExtratoCliente.ExtratoClienteConta(cpfsenha, agencia);
					MenuClienteP(cpfsenha, agencia);
					break;
				case 5:

					String valorIni = JOptionPane.showInputDialog(null, "Digite o valor inicial");
					String dias = JOptionPane.showInputDialog(null, "Dia da aplicação ");
					String meses = JOptionPane.showInputDialog(null, "Mês da aplicação");
					String anos = JOptionPane.showInputDialog(null, "Ano da aplicação ");
					String dayst = JOptionPane.showInputDialog(null, "Dia de Resgate ");
					String mounthst = JOptionPane.showInputDialog(null, "Mês de Resgate");
					String yearst = JOptionPane.showInputDialog(null, "Ano de Resgate ");

					double valorRen = Double.parseDouble(valorIni);
					int dia = Integer.parseInt(dias);
					int mes = Integer.parseInt(meses);
					int ano = Integer.parseInt(anos);
					int day = Integer.parseInt(dayst);
					int mounth = Integer.parseInt(mounthst);
					int year = Integer.parseInt(yearst);
					double taxa = 0.01;
					Calendar datainicial = Calendar.getInstance();
					datainicial.set(ano, mes, dia);
					Calendar datafinal = Calendar.getInstance();
					datafinal.set(year, mounth, day);
					// Calendar hoje = Calendar.getInstance();
					int intervalo = (datafinal.get(Calendar.YEAR) * 12 + datafinal.get(Calendar.MONTH))
							- (datainicial.get(Calendar.YEAR) * 12 + datainicial.get(Calendar.MONTH));
					System.out.println(intervalo);
					double intervaloD = intervalo;
					double simulacao = valorRen * Math.pow((1 + taxa), intervaloD);
					DecimalFormat df = new DecimalFormat("R$ #,###.00");
					JOptionPane.showMessageDialog(null, "O valor final no prazo de " + intervalo
							+ " meses, com uma taxa de 1% a.m é de\n" + df.format(simulacao));
					System.out.println();
					MenuClienteP(cpfsenha, agencia);
					break;
				case 6:
					MenuCliente(cpfsenha, agencia);
					break;

				case 0:
					JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia");
					System.exit(0);
				default:
					JOptionPane.showMessageDialog(null, "Opção Invalida");
					MenuClienteVO.MenuClienteC(cpfsenha, agencia);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void MenuCliente(String cpfsenha, String agencia) {
		Conexao con = new Conexao();
		String sql = "select * from funcionario f where cpfsenha=" + "'" + cpfsenha + "'" + ";";
		ResultSet rs = con.executaBusca(sql);
		try {
			while (rs.next()) {

				String tipo = rs.getString("tipoconta");

				Object[] escolha = { "Corrente", "Poupança" };
				Object opcao = JOptionPane.showInputDialog(null, "Escolha", "Escolha o tipo de Conta:",
						JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[1]);
				String selecao = (String) opcao;

				if (selecao.equalsIgnoreCase("Corrente") && tipo.equalsIgnoreCase("Corrente")) {
					MenuClienteC(cpfsenha, agencia);
				} else if (selecao.equalsIgnoreCase("Corrente") && tipo.equalsIgnoreCase("ambos")) {
					MenuClienteC(cpfsenha, agencia);
				} else if (selecao.equalsIgnoreCase("Corrente") && tipo.equalsIgnoreCase("Poupanca")) {
					JOptionPane.showMessageDialog(null, "Você ainda não possui uma Conta Corrente");
					MenuCliente(cpfsenha, agencia);
				} else if (selecao.equalsIgnoreCase("Poupança") && tipo.equalsIgnoreCase("ambos")) {
					MenuClienteP(cpfsenha, agencia);
				} else if (selecao.equalsIgnoreCase("Poupança") && tipo.equalsIgnoreCase("Poupanca")) {
					MenuClienteP(cpfsenha, agencia);
				} else if (selecao.equalsIgnoreCase("Poupança") && tipo.equalsIgnoreCase("Corrente")) {
					JOptionPane.showMessageDialog(null, "Você ainda não possui uma Conta Poupanca");
					MenuCliente(cpfsenha, agencia);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
