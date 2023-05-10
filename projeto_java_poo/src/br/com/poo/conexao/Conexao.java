package br.com.poo.conexao;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	
	
 public Conexao(){
	 url ="jdbc:postgresql://localhost:5432/projetoj";
	 usuario="postgres";
	 senha="123456";
	 
	 try {
			
		 Class.forName("org.postgresql.Driver");
		 con = DriverManager.getConnection(url,usuario,senha);
		 System.out.println("Conexão Realizada com sucesso!!!");
	} catch (Exception e) {
		e.printStackTrace();
	}
	 
 }
 public int excutaSql(String sql) {
	 try {
		 Statement stm = con.createStatement();
		 int res = stm.executeUpdate(sql);
		 con.close();
		 return res;
	} catch (Exception e) {
		e.printStackTrace();
		return 0;
	}
	 
 }
 public ResultSet executaBusca(String sql) {
	 try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		con.close();
		return rs;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	 
 }

public ResultSet Count(String sql){
	

	 try {
            Statement comando = con.createStatement();
            ResultSet rs = comando.executeQuery(sql);            
            con.close();
			return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
	return null;
}

}
