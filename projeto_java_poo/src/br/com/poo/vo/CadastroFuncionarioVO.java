package br.com.poo.vo;

import javax.swing.JOptionPane;

import br.com.poo.conexao.Conexao;

public class CadastroFuncionarioVO {

	private String nome;
	private String sobrenome;
	private String cpf;
	private String email;
	private String contato;
	private String salarios;
	private double salario;
	private String cargo;
	private String senha;
	private String tipoconta;
	private double saldo;
	private String saldos;
	private String saldosp;
	private double saldop;

	public CadastroFuncionarioVO(String nome, String sobrenome, String cpf, String email, String contato,
			String salarios, double salario, String cargo, String senha, String tipoconta) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.contato = contato;
		this.salarios = salarios;
		this.salario = salario;
		this.cargo = cargo;
		this.senha = senha;
		this.tipoconta = tipoconta;
	}

	public CadastroFuncionarioVO() {
		super();

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getSalarios() {
		return salarios;
	}

	public void setSalarios(String salarios) {
		this.salarios = salarios;
	}

	public double getSalario() {
		return Double.parseDouble(salarios);
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoConta() {
		return tipoconta;
	}

	public void setTipoConta(String tipoconta) {
		this.tipoconta = tipoconta;
	}

	public double getSaldo() {
		return Double.parseDouble(saldos);
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getSaldos() {
		return saldos;
	}

	public void setSaldos(String saldos) {
		this.saldos = saldos;
	}

	public String getSaldosp() {
		return saldosp;
	}

	public void setSaldosp(String saldosp) {
		this.saldosp = saldosp;
	}

	public double getSaldop() {
		return Double.parseDouble(saldosp);
	}

	public void setSaldop(double saldop) {
		this.saldop = saldop;
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
		MenuGerenteVO.MenuGerente(cpfsenha, agencia);
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
		MenuGerenteVO.MenuGerente(cpfsenha, agencia);
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
		MenuGerenteVO.MenuGerente(cpfsenha, agencia);

	}

}
