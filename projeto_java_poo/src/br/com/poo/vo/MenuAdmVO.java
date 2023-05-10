package br.com.poo.vo;

import java.sql.ResultSet;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import br.com.poo.conexao.Conexao;
//import br.com.poo.dao.AlterarTipoConta;
//import br.com.poo.pessoas.Gerente;

public class MenuAdmVO {
	
	
	
	
	public static void ADM(String cpfsenha, String agencia) {
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
								+ "| Opção 1 -Cadastrar Diretor\n" + "| Opção 2 -Cadastrar Presidente\n"
								+ "| Opção 3 -Deletar Banco de Dados \n" + "| Digite 0 para sair",
						"Menu Gerente ", JOptionPane.INFORMATION_MESSAGE));
				switch (operacao) {
				case 1:
					CadastroDiretor(cpfsenha);
					MenuAdmVO.ADM(cpfsenha, agencia);
					break;

				case 2:
					CadastroPresidente(cpfsenha);
					MenuAdmVO.ADM(cpfsenha, agencia);
					break;
				case 3:
					JOptionPane.showMessageDialog(null, "Clique em ok para DROPDATABASE ou cancelar para sair");;
					JOptionPane.showMessageDialog(null, "CALMA MEU JOVEM\n Vai tomar um café que estará tudo resolvido");;
					MenuAdmVO.ADM(cpfsenha, agencia);
					break;
				case 0:
					JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia");
					System.exit(0);
					default:
					JOptionPane.showMessageDialog(null, "Esta não é uma opção válida");
					MenuAdmVO.ADM(cpfsenha, agencia);
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public static void CadastroDiretor(String cpfsenha) {
		Object[] escolha = { "Corrente", "Poupança", "Ambos" };
		Object opcao = JOptionPane.showInputDialog(null, "Tipo conta", "Informe o tipo de conta:",
				JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[2]);
		String tipo = (String) opcao;

		if (tipo.equalsIgnoreCase("Corrente")) {
			CadastroDiretorC(cpfsenha);
		}
		if (tipo.equalsIgnoreCase("Poupança")) {
			CadastroDiretorP(cpfsenha);
		}
		if (tipo.equalsIgnoreCase("Ambos")) {
			CadastroDiretorA(cpfsenha);
		}
	}

    public static void CadastroDiretorC(String cpfsenha){
        
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
		String cargo = "diretor";
		cadastro.setSenha(JOptionPane.showInputDialog("Crie uma senha"));
		cadastro.setSaldos(JOptionPane.showInputDialog("Deposite um valor minimo de R$100,00"));
		cadastro.setSalarios(JOptionPane.showInputDialog("Defina o salÃ¡rio do " + cargo + ": "));

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
		MenuAdmVO.ADM(cpfsenha, agencia);
    }

	public static void CadastroDiretorP(String cpfsenha) {
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
		String cargo = "diretor";
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
		MenuAdmVO.ADM(cpfsenha, agencia);
	}

	public static void CadastroDiretorA(String cpfsenha) {
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
		String cargo = "diretor";
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
		MenuAdmVO.ADM(cpfsenha, agencia);

	}







	 public static void CadastroPresidente(String cpfsenha) {
		Object[] escolha = { "Corrente", "Poupança", "Ambos" };
		Object opcao = JOptionPane.showInputDialog(null, "Tipo conta", "Informe o tipo de conta:",
				JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[2]);
		String tipo = (String) opcao;

		if (tipo.equalsIgnoreCase("Corrente")) {
			CadastroPresidenteC(cpfsenha);
		}
		if (tipo.equalsIgnoreCase("Poupança")) {
			CadastroPresidenteP(cpfsenha);
		}
		if (tipo.equalsIgnoreCase("Ambos")) {
			CadastroPresidenteA(cpfsenha);
		}

	}

    public static void CadastroPresidenteC(String cpfsenha){
        
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
		String cargo = "presidente";
		cadastro.setSenha(JOptionPane.showInputDialog("Crie uma senha"));
		cadastro.setSaldos(JOptionPane.showInputDialog("Deposite um valor minimo de R$100,00"));
		cadastro.setSalarios(JOptionPane.showInputDialog("Defina o salÃ¡rio do " + cargo + ": "));

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
		MenuAdmVO.ADM(cpfsenha, agencia);
    }

	public static void CadastroPresidenteP(String cpfsenha) {
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
		String cargo = "presidente";
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
		MenuAdmVO.ADM(cpfsenha, agencia);
	}

	public static void CadastroPresidenteA(String cpfsenha) {
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
		String cargo = "presidente";
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
		MenuAdmVO.ADM(cpfsenha, agencia);

	}




}

