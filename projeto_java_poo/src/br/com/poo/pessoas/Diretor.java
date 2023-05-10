package br.com.poo.pessoas;

import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.poo.conexao.Conexao;
import br.com.poo.interfac.Interface;
import br.com.poo.vo.CadastroClienteVO;
import br.com.poo.vo.CadastroFuncionarioVO;

public class Diretor extends Gerente {
	public Diretor(String nome, String sobrenome, String cpf, String email, String contato, double salario) {
		super(nome, sobrenome, cpf, email, contato, salario);

	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void Consulta() {

		Conexao con = new Conexao();
		Scanner input = new Scanner(System.in);
		System.out.println("Qual Funcionario?");
		String name = input.next();
		String sql = "select * from funcionario f where nome=" + "'" + name + "'" + ";";
		ResultSet rs = con.executaBusca(sql);

		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				String agencia = rs.getString("agencia");
				System.out.println(id + " - " + nome + " - " + sobrenome + " - " + email + " - " + cpf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

		public static void cadastroFuncionario(String cpfsenha) {
		Object[] escolha = { "Corrente", "Poupança", "Ambos" };
		Object opcao = JOptionPane.showInputDialog(null, "Tipo conta", "Informe o tipo de conta:",
				JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[2]);
		String tipo = (String) opcao;

		if (tipo.equalsIgnoreCase("Corrente")) {
			cadastroFuncionarioC(cpfsenha);
		}
		if (tipo.equalsIgnoreCase("Poupança")) {
			cadastroFuncionarioP(cpfsenha);
		}
		if (tipo.equalsIgnoreCase("Ambos")) {
			cadastroFuncionarioA(cpfsenha);
		}

	}

	public static void cadastroFuncionarioC(String cpfsenha) {
		Conexao con = new Conexao();
		Object[] escolha = { "3344", "4455", "6678", "0022" };
		Object opcao = JOptionPane.showInputDialog(null, "Escolha", "Informe a agencia:",
				JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[3]);
		String agencia = (String) opcao;
		System.out.println(agencia);
		CadastroFuncionarioVO cadastro = new CadastroFuncionarioVO();

		cadastro.setNome(JOptionPane.showInputDialog("Insira o nome "));
		cadastro.setSobrenome(JOptionPane.showInputDialog("Insira o sobrenome"));
		cadastro.setCpf(JOptionPane.showInputDialog("Insira o CPF"));
		cadastro.setEmail(JOptionPane.showInputDialog("Insira o email"));
		cadastro.setContato(JOptionPane.showInputDialog("Insira telefone para Contato"));
		Object[] escolha2 = { "Caixa", "Gerente" };
		Object opcao2 = JOptionPane.showInputDialog(null, "Cargo", "Informe o Cargo:", JOptionPane.INFORMATION_MESSAGE,
				null, escolha2, escolha2[1]);
		String cargo = (String) opcao2;
		cadastro.setSenha(JOptionPane.showInputDialog("Crie uma senha"));
		cadastro.setSaldos(JOptionPane.showInputDialog("Deposite um valor minimo de R$100,00"));
		cadastro.setSalarios(JOptionPane.showInputDialog("Defina o salário do " + cargo + ": "));

		String tipoconta = "Corrente";

		String sql = " Insert into funcionario (id, nome , sobrenome, cpf, email, contato,salario,cpfsenha,cargo,saldo,agencia,tipoconta)"
				+ "values (default," + "'" + cadastro.getNome() + "'" + ",'" + cadastro.getSobrenome() + "'" + ",'"
				+ cadastro.getCpf() + "'" + ",'" + cadastro.getEmail() + "','" + cadastro.getContato() + "'" + ",'"
				+ cadastro.getSalario() + "'" + ",'" + cadastro.getCpf() + cadastro.getSenha() + "'" + ",'" + cargo
				+ "'" + ",'" + cadastro.getSaldo() + "'" + ",'" + agencia + "'" + ",'" + tipoconta + "'" + ")";

		int res = con.excutaSql(sql);

		if (res > 0) {
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
		} else {
			System.out.println("Erro durante o cadastro");
		}
		Interface.MenuDiretor(cpfsenha);
	}

	public static void cadastroFuncionarioP(String cpfsenha) {
		Conexao con = new Conexao();
		Object[] escolha = { "3344", "4455", "6678", "0022" };
		Object opcao = JOptionPane.showInputDialog(null, "Escolha", "Informe a agencia:",
				JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[3]);
		String agencia = (String) opcao;
		System.out.println(agencia);
		CadastroFuncionarioVO cadastro = new CadastroFuncionarioVO();

		cadastro.setNome(JOptionPane.showInputDialog("Insira o nome "));
		cadastro.setSobrenome(JOptionPane.showInputDialog("Insira o sobrenome"));
		cadastro.setCpf(JOptionPane.showInputDialog("Insira o CPF"));
		cadastro.setEmail(JOptionPane.showInputDialog("Insira o email"));
		cadastro.setContato(JOptionPane.showInputDialog("Insira telefone para Contato"));
		Object[] escolha2 = { "Caixa", "Gerente" };
		Object opcao2 = JOptionPane.showInputDialog(null, "Cargo", "Informe o Cargo:", JOptionPane.INFORMATION_MESSAGE,
				null, escolha2, escolha2[1]);
		String cargo = (String) opcao2;
		cadastro.setSenha(JOptionPane.showInputDialog("Crie uma senha"));
		cadastro.setSaldosp(JOptionPane.showInputDialog("Deposite um valor minimo de R$50,00"));
		cadastro.setSalarios(JOptionPane.showInputDialog("Defina o salário do " + cargo + ": "));
		String tipoconta = "Poupanca";

		String sql = " Insert into funcionario (id, nome , sobrenome, cpf, email, contato,salario,cpfsenha,cargo,poupanca,agencia,tipoconta)"
				+ "values (default," + "'" + cadastro.getNome() + "'" + ",'" + cadastro.getSobrenome() + "'" + ",'"
				+ cadastro.getCpf() + "'" + ",'" + cadastro.getEmail() + "','" + cadastro.getContato() + "'" + ",'"
				+ cadastro.getSalario() + "'" + ",'" + cadastro.getCpf() + cadastro.getSenha() + "'" + ",'" + cargo
				+ "'" + ",'" + cadastro.getSaldop() + "'" + ",'" + agencia + "'" + ",'" + tipoconta + "'" + ")";

		int res = con.excutaSql(sql);

		if (res > 0) {
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
		} else {
			System.out.println("Erro durante o cadastro");
		}
		Interface.MenuDiretor(cpfsenha);
	}

	public static void cadastroFuncionarioA(String cpfsenha) {
		Conexao con = new Conexao();
		Object[] escolha = { "3344", "4455", "6678", "0022" };
		Object opcao = JOptionPane.showInputDialog(null, "Escolha", "Informe a agencia:",
				JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[3]);
		String agencia = (String) opcao;
		System.out.println(agencia);
		CadastroFuncionarioVO cadastro = new CadastroFuncionarioVO();

		cadastro.setNome(JOptionPane.showInputDialog("Insira o nome "));
		cadastro.setSobrenome(JOptionPane.showInputDialog("Insira o sobrenome"));
		cadastro.setCpf(JOptionPane.showInputDialog("Insira o CPF"));
		cadastro.setEmail(JOptionPane.showInputDialog("Insira o email"));
		cadastro.setContato(JOptionPane.showInputDialog("Insira telefone para Contato"));
		Object[] escolha2 = { "Caixa", "Gerente" };
		Object opcao2 = JOptionPane.showInputDialog(null, "Cargo", "Informe o Cargo:", JOptionPane.INFORMATION_MESSAGE,
				null, escolha2, escolha2[1]);
		String cargo = (String) opcao2;
		System.out.println(cargo);
		cadastro.setSenha(JOptionPane.showInputDialog("Crie uma senha"));
		cadastro.setSaldos(JOptionPane.showInputDialog("Deposite um valor minimo de R$100,00"));
		cadastro.setSaldosp(JOptionPane.showInputDialog("Deposite um valor minimo de R$50,00"));
		cadastro.setSalarios(JOptionPane.showInputDialog("Defina o salário do " + cargo + ": "));
		String tipoconta = "Ambos";

		String sql = " Insert into funcionario (id, nome , sobrenome, cpf, email, contato,salario,cpfsenha,cargo,saldo,poupanca,agencia,tipoconta)"
				+ "values (default," + "'" + cadastro.getNome() + "'" + ",'" + cadastro.getSobrenome() + "'" + ",'"
				+ cadastro.getCpf() + "'" + ",'" + cadastro.getEmail() + "','" + cadastro.getContato() + "'" + ",'"
				+ cadastro.getSalario() + "'" + ",'" + cadastro.getCpf() + cadastro.getSenha() + "'" + ",'" + cargo
				+ "'" + ",'" + cadastro.getSaldo() + "'" + ",'" + cadastro.getSaldop() + "'" + ",'" + agencia + "'"
				+ ",'" + tipoconta + "'" + ")";

		int res = con.excutaSql(sql);

		if (res > 0) {
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
		} else {
			System.out.println("Erro durante o cadastro");
		}
		Interface.MenuDiretor(cpfsenha);

	}







}
