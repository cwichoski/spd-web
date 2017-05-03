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
import les.dominio.Propriedade;
import les.dominio.Talhao;

/**
 *
 * @author gustavo
 */
public class TalhaoDAO extends PostgresDAO{
    public boolean salvar(EntidadeDominio entidade) {
        return false;
    }


    public boolean excluir(EntidadeDominio entidade) {
            // TODO Auto-generated method stub
            return false;
    }


    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
            ArrayList<EntidadeDominio> talhoes = new ArrayList<EntidadeDominio>();	
            Talhao tlh = (Talhao)entidade;
            try {
                Connection conn;
                conn = newConnection();
                Propriedade pro = new Propriedade();
                pro = tlh.getPropriedade();
                
                Statement st = conn.createStatement();
                String sql;



                if(entidade.getId() != 0){
                    if (pro.getId() != 0){
                        sql = "SELECT * FROM TALHAO WHERE PROPRIEDADE_ID = "+pro.getId();
                    }else {
                        sql = "SELECT * FROM TALHAO WHERE ID = "+entidade.getId();
                    }


                }else {

                    sql = "SELECT * FROM TALHAO ;";
                }




                
                ResultSet rs = st.executeQuery(sql); 
                while (rs.next()) {
                    Talhao talhao = new Talhao();


                    talhao.setId(rs.getInt("ID"));
                    talhao.setDescricao(rs.getString("DESCRICAO").trim());
                    talhao.setCultura(rs.getString("CULTURA").trim());
                    talhao.setHectares(rs.getDouble("HECTARES"));
                    talhao.setDt_ultima_colheita(rs.getDate("dt_ultima_colheita"));
                    talhao.setTipo_terra(rs.getString("TIPO_TERRA").trim());

                    talhoes.add(talhao);

                } 
                st.close();
                conn.close();
                return talhoes;

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
