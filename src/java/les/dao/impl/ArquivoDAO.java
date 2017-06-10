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
import les.dominio.Meteorologia;
import les.dominio.Propriedade;
import les.dominio.Talhao;

/**
 *
 * @author gustavo
 */
public class ArquivoDAO extends PostgresDAO{
    public boolean salvar(EntidadeDominio entidade) {
        return true;
    }


    public boolean excluir(EntidadeDominio entidade) {
            // TODO Auto-generated method stub
            return false;
    }


    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
            HistoricoDAO histDAO = new HistoricoDAO();
            try {
                Connection conn;
                conn = newConnection();
                
                Meteorologia met = (Meteorologia)entidade;
                List<EntidadeDominio> mets = new ArrayList<EntidadeDominio>();
                
                Statement st = conn.createStatement();
                String sql;

                sql = "SELECT * "
                      + "FROM METEOROLOGIA"
                      + " JOIN dispositivo on dispositivo.id = dispositivo_id "
                      + " JOIN talhao on talhao.propriedade_id = dispositivo.propriedade_id"
                    + " WHERE talhao.id = "+met.getId()
                    + " ORDER BY data DESC"
                    + " LIMIT 1";
                



                
                ResultSet rs = st.executeQuery(sql); 
                while (rs.next()) {
                    Meteorologia met1 = new Meteorologia();
                    

                    met1.setMm_chuva(rs.getInt("mm_chuva"));
                    met1.setTemperatura(rs.getDouble("temperatura"));
                    met1.setUmidade(rs.getInt("umidade"));
                    mets.add(met1);
                    
             
                } 
                st.close();
                conn.close();
                return mets;

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
