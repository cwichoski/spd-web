package les.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import les.dao.IDAO;
import les.dominio.Arquivo;
import les.dominio.Doenca;
import les.dominio.Doenca;

import les.dominio.Endereco;
import les.dominio.EntidadeDominio;
import les.dominio.Funcionario;
import les.dominio.PerguntasDoenca;

public class PerguntaDoencaDAO extends PostgresDAO{
    public boolean salvar(EntidadeDominio entidade) {
        return false;
    }


    public boolean excluir(EntidadeDominio entidade) {
            // TODO Auto-generated method stub
            return false;
    }


    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
            ArrayList<EntidadeDominio> doencas                                                               = new ArrayList<EntidadeDominio>();			            
            Doenca doenca = (Doenca)entidade;
            try {
                Connection conn;
                Connection conn2;
                conn = newConnection();
                conn2 = newConnection();
                int doenca_id;
                Statement st = conn.createStatement();
                Statement st2 = conn2.createStatement();
                String sql = null;
                String sql2 = null;
                ResultSet rs2 = null;
                List<PerguntasDoenca> perguntas = new ArrayList<PerguntasDoenca>();
                
                if(doenca.getId() != 0){
                    sql = "SELECT * FROM DOENCA WHERE ID = "+doenca.getId() +";";
                    sql2 = "SELECT * FROM DOENCA_PERGUNTA WHERE DOENCA_ID = "+doenca.getId() +" ORDER BY 2;";
                    rs2 = st2.executeQuery(sql2); 
                }else{
                    sql = "SELECT * FROM DOENCA;";
                }
                
                ResultSet rs = st.executeQuery(sql); 
                

                while (rs.next()) {
                    
                    Doenca cgo = new Doenca();
                    Arquivo arq = new Arquivo();
                    
                    cgo.setId(rs.getInt("ID"));
                    cgo.setDescricao(rs.getString("DESCRICAO").trim());
                    arq.setNomeDoArquivo(rs.getString("ARQUIVO_WEKA").trim());
                    cgo.setArquivo(arq);
                    if(doenca.getId() != 0){
                        while (rs2.next()) {
                            PerguntasDoenca pergunta = new PerguntasDoenca();
                            pergunta.setDescricao(rs2.getString("DESCRICAO").trim());
                            pergunta.setOrdem(rs2.getInt("ORDEM"));
                            pergunta.setTipo(rs2.getString("TIPO"));
                            perguntas.add(pergunta);
                            
                        }
                    }
                    cgo.setDoencas(perguntas);
                    doencas.add(cgo);
                    
                    
                }


                st.close();
                conn.close();
                return doencas;

            }catch (SQLException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Erro de SQL");
                    return null;
            }

    }

    @Override
    public boolean alterar(EntidadeDominio entidade) {
                    Doenca doenca = (Doenca)entidade;
                
		try {
			
                    Connection conn;
                    Connection conn2;
                    Connection conn3;
                    conn = newConnection();
                    conn2 = newConnection();
                    conn3 = newConnection();
                    Statement st = conn.createStatement();
                    Statement st2 = conn.createStatement();
                    Statement st3 = conn.createStatement();
                    String sql = "UPDATE doenca" +
                                 "   SET descricao='"+doenca.getDescricao()+"', arquivo_weka='"+doenca.getArquivo()+"'" +
                                 " WHERE id = "+doenca.getId()+";";
                    
                    String sql2 = "DELETE FROM DOENCA_PERGUNTA WHERE DOENCA_ID = "+ doenca.getId();
                    String sql3 = "";
                    for (int i = 0; doenca.perguntasDoencas().size() > i; i++){
                        sql3 = sql3 + " INSERT INTO DOENCA_PERGUNTA VALUES ( " + doenca.getId() + ", " + doenca.perguntasDoencas().get(i).getOrdem()+", '" + doenca.perguntasDoencas().get(i).getDescricao()+"') ;";
                    }
                    
                    st.executeUpdate(sql);
                    st2.executeUpdate(sql2);
                    st3.executeUpdate(sql3);
                    st.close();
                    st2.close();
                    st3.close();
                    conn.close();
                    conn2.close();
                    conn3.close();
                    
	            return true;
                        
                } catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro de SQL");
			return false;
		}
    }




}
