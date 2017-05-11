/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import les.dominio.Cargo;
import les.dominio.Endereco;
import les.dominio.EntidadeDominio;
import les.dominio.Historico;
import les.dominio.Propriedade;
import les.dominio.Talhao;

/**
 *
 * @author gustavo
 */
public class DiarioDAO extends PostgresDAO{
    public boolean salvar(EntidadeDominio entidade) {
        return false;
    }


    public boolean excluir(EntidadeDominio entidade) {
            // TODO Auto-generated method stub
            return false;
    }


    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
            ArrayList<EntidadeDominio> historicos = new ArrayList<EntidadeDominio>();	
            Talhao tlh = (Talhao)entidade;
            try {
                Connection conn;
                conn = newConnection();
                
                Statement st = conn.createStatement();
                String sql;



                if(entidade.getId() != 0){
                    if (tlh.getId() != 0){
                        sql = "SELECT * FROM HISTORICO_TALHAO WHERE TALHAO_ID = "+tlh.getId();
                    }else {
                        sql = "SELECT * FROM HISTORICO_TALHAO WHERE ID = "+tlh.getId();
                    }


                }else {

                    sql = "SELECT * FROM HISTORICO_TALHAO ;";
                }




                
                ResultSet rs = st.executeQuery(sql); 
                while (rs.next()) {
                    Historico hist = new Historico();


                    hist.setId(rs.getInt("ID"));
                    hist.setData(rs.getDate("DATA"));
                    hist.setPct_doenca(rs.getInt("PCT_DOENCA"));
               
                    historicos.add(hist);

                } 
                st.close();
                conn.close();
                return historicos;

            }catch (SQLException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Erro de SQL");
                    return null;
            }

    }

    @Override
    public boolean alterar(EntidadeDominio entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
}
