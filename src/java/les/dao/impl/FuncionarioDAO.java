package les.dao.impl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import les.dao.IDAO;
import les.dominio.EntidadeDominio;
import les.dominio.Funcionario;

public class FuncionarioDAO extends PostgresDAO{
	public boolean salvar(EntidadeDominio entidade) {
	Funcionario func = (Funcionario)entidade;
        
        try {
			Connection conn;
			conn = newConnection();
			String sql = " INSERT INTO FUNCIONARIO (";
			sql = sql+"nome,";
			sql = sql+"dt_nasc,";
			sql = sql+"cpf)";
			sql = sql+"VALUES (";
                        sql = sql+"'"+func.getNome()+"', ";
                        sql = sql+"'"+func.getDt_nasc()+"', ";
                        sql = sql+"'"+func.getCpf()+"');";
			Statement st = conn.createStatement();
			st.executeUpdate( sql );
			st.close();
			conn.close();
			IDAO func_end = new Funcionario_EnderecoDAO(); 
			return func_end.salvar(func.getEnd());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro de SQL");
			return false;
		}
	}


	public boolean alterar(EntidadeDominio entidade) {
                Funcionario func = (Funcionario)entidade;
		try {
			
                    Connection conn;
                    conn = newConnection();
                    Statement st = conn.createStatement();
                    String sql = "UPDATE funcionario" +
                                 "   SET nome='"+func.getNome()+"', cpf='"+func.getCpf()+"', dt_nasc='"+func.getDt_nasc()+"'" +
                                 " WHERE id="+func.getId()+";";
                    IDAO func_end = new Funcionario_EnderecoDAO(); 
                    func_end.alterar(func.getEnd());
                    st.executeUpdate(sql);
                    st.close();
                    conn.close();
                    
	            return false;
                        
                } catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro de SQL");
			return false;
		}
	}


	public boolean excluir(EntidadeDominio entidade) {
		Funcionario func = (Funcionario)entidade;
		
		try {
			
                    Connection conn;
                    conn = newConnection();
                    Statement st = conn.createStatement();
                    String sql = "DELETE FROM FUNCIONARIO_ENDERECO WHERE FUNCIONARIO_ID = (SELECT ID FROM FUNCIONARIO WHERE CPF = '"+func.getCpf()+"');";
                    sql = sql+"DELETE FROM FUNCIONARIO WHERE CPF = '"+func.getCpf()+"'  ;";
                    st.executeQuery(sql);
                    st.close();
                    conn.close();
                    return true;
                        
                } catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro de SQL");
			return false;
		}
	}


	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		Funcionario func = (Funcionario)entidade;
		
		try {
			Connection conn;
			conn = newConnection();
			Statement st = conn.createStatement();
			// Verfica se tem um ID, para que posso efetuar uma consulta especifica se = 0, traz todos
			if (func.getId() == 0){
				String sql = "SELECT * FROM FUNCIONARIO"; 
				       sql = sql+" JOIN FUNCIONARIO_ENDERECO ON FUNCIONARIO_ID = FUNCIONARIO.ID";
				ResultSet rs = st.executeQuery(sql);
				String msg = null;
                                while (rs.next()) {
					if (msg == null){
                                            msg = rs.getString("ID").trim()+" ";
                                        } else {
                                            msg = msg+rs.getString("ID").trim()+" ";
                                        }
					
					msg = msg+rs.getString("NOME").trim()+" ";
					msg = msg+rs.getString("CPF").trim()+" ";
					msg = msg+rs.getString("DT_NASC").trim()+" ";
					msg = msg+rs.getString("RUA").trim()+" ";
					msg = msg+rs.getString("CEP").trim()+" ";
					msg = msg+rs.getString("CIDADE").trim()+"\n";
										
				}
                                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                                JOptionPane.showMessageDialog(frame,msg, "Consulta Simples",JOptionPane.PLAIN_MESSAGE);
				rs.close();
				st.close();
				conn.close();
				return null;
			}else{// consulta específica
				String sql = "SELECT * FROM FUNCIONARIO"; 
				sql = sql+" JOIN FUNCIONARIO_ENDERECO ON FUNCIONARIO_ID = FUNCIONARIO.ID";
			    sql = sql+" WHERE funcionario.id ="+func.getId();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
                                    // create a jframe
				    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
				    
                                    // String to receive the message
				    String msg;
					
                                    msg = rs.getString("ID").trim()+" ";
                                    msg = msg+rs.getString("NOME").trim()+" ";
                                    msg = msg+rs.getString("CPF").trim()+" ";
                                    msg = msg+rs.getString("DT_NASC").trim()+" ";
                                    msg = msg+rs.getString("RUA").trim()+" ";
                                    msg = msg+rs.getString("CEP").trim()+" ";
                                    msg = msg+rs.getString("CIDADE").trim()+"\n";

                                    JOptionPane.showMessageDialog(frame,msg, "Consulta exata",JOptionPane.PLAIN_MESSAGE);
				}
				rs.close();
				st.close();
				conn.close();
				return null;
			} 
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro de SQL");
			return null;
		}
	}
}

