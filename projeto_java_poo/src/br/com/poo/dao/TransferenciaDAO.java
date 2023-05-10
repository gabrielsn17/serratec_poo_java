package br.com.poo.dao;

import java.text.DecimalFormat;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import br.com.poo.conexao.Conexao;
import br.com.poo.vo.MenuClienteVO;

public class TransferenciaDAO {

    public static void Transferir(String cpfsenha,double saldo){
 
    	if(saldo<=0){
    		JOptionPane.showMessageDialog(null,"Saldo insuficiente!");
    		MenuClienteVO.MenuClienteC(cpfsenha, cpfsenha);	
    		}
    	else {   		
    		Saque(cpfsenha, saldo, cpfsenha, cpfsenha, cpfsenha);
    	}
		   	
    }
	public static void Saque(String cpfsenha, double saldo, String agencia, String cargo, String tipoconta ) {
    
		String valorst = JOptionPane.showInputDialog("Qual o valor deseja transferir? ");
        double valor = Double.parseDouble(valorst);

		if(saldo < valor || valor <= 0){
			JOptionPane.showMessageDialog(null,"Não foi possível realizar a transação\nVerifique seu saldo ou o valor digitado!");
			MenuClienteVO.MenuClienteC(cpfsenha, cpfsenha);	
		}
		else{
			Conexao con = new Conexao();
			
			String sql = "update funcionario f set saldo=saldo-" + valor + " where cpfsenha=" + "'" + cpfsenha + "'"+";";
			System.out.println("Saque="+valor);
			int res = con.excutaSql(sql);
			if (res > 0) {
				
				Deposito(cpfsenha, valor,agencia,cargo,tipoconta);
				
			} else {
				System.out.println("Erro durante o cadastro");
			}
			
		}


	}
    public static void Deposito(String cpfsenha,Double valor, String agencia, String cargo, String tipoconta) {
		String cpf =  JOptionPane.showInputDialog("Digite o CPF de quem vai receber o valor");	
		System.out.println("Deposito="+valor);

        Conexao con = new Conexao();

        String sql = "update funcionario f set saldo=saldo+" + valor + " where cpf=" + "'" + cpf + "'"+";";
        
		
		
		int res = con.excutaSql(sql);
		if (res > 0) {
			JOptionPane.showMessageDialog(null,"Transferência realizada!");
			Tributação(cpfsenha,agencia,valor,cargo,tipoconta);
		} else {
			System.out.println("Erro durante o cadastro");
		}

	}   
    
    
    public static void Tributação(String cpfsenha, String agencia, double valor, String cargo, String tipoconta) {
		DecimalFormat df = new DecimalFormat("R$ #,###.00");
		GregorianCalendar gre = new GregorianCalendar();
		Conexao con = new Conexao();
		double tributo=0.10;
		String relatorio="Tributo da Transeferência de " +df.format(valor)+" da Conta Corrente realizado na agência "+agencia+" em "+gre.getTime();
		
		String sql = "insert into tributacao(cpfsenha,relatorio,tributo)"
				+ "values ("+"'"+cpfsenha+"'"+",'"+relatorio+"'"+",'"+tributo+"')"; 
		int res = con.excutaSql(sql);

		if (res > 0) {
			
			Relatorio(cpfsenha, agencia, valor, cargo, tipoconta);
			
			
			
		} else {
			System.out.println("Erro durante o cadastro");
		}
		
		
	}
       
    public static void Relatorio(String cpfsenha, String agencia, double valord, String cargo, String tipoconta) {
		DecimalFormat df = new DecimalFormat("R$ #,###.00");
		GregorianCalendar gre = new GregorianCalendar();
		Conexao con = new Conexao();
		String descricao="Transferência de " +df.format(valord)+" da Conta Corrente realizado na agência "+agencia+" em "+gre.getTime();
		
		String sql = "insert into relatorio(cpfsenha,descricao,agencia)"
				+ "values ("+"'"+cpfsenha+"'"+",'"+descricao+"'"+",'"+agencia+"')"; 
		int res = con.excutaSql(sql);

		if (res > 0) {
			
			
		} else {
			System.out.println("Erro durante o cadastro");
		}
	}
    
    
    
    
 

}
