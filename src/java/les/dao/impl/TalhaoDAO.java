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
import les.dominio.Cultura;
import les.dominio.Endereco;
import les.dominio.EntidadeDominio;
import les.dominio.Historico;
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
            HistoricoDAO histDAO = new HistoricoDAO();
            try {
                Connection conn;
                conn = newConnection();
                Propriedade pro = new Propriedade();
                
                
                
                pro = tlh.getPropriedade();
                
                
                
                Statement st = conn.createStatement();
                String sql;



                if(entidade.getId() != 0){
                    if (pro.getId() != 0){
                        sql = "SELECT * FROM TALHAO WHERE PROPRIEDADE_ID = "+pro.getId()+" ORDER BY ID;";
                    }else {
                        sql = "SELECT * FROM TALHAO WHERE ID = "+entidade.getId()+" ORDER BY ID;";
                    }


                }else {

                    sql = "SELECT * FROM TALHAO ORDER BY ID;";
                }




                
                ResultSet rs = st.executeQuery(sql); 
                while (rs.next()) {
                    Talhao talhao = new Talhao();
                    CulturaDAO culturaDAO = new CulturaDAO();
                    Cultura cultura = new Cultura();
                    List<Historico> historicos = new ArrayList<Historico>();
                    List<EntidadeDominio> culturas = new ArrayList<EntidadeDominio>();

                    talhao.setId(rs.getInt("ID"));
                    talhao.setDescricao(rs.getString("DESCRICAO").trim());
                    
                    // consultar entidade cultura para retrornar no objeto de talhao
                    cultura.setId(rs.getInt("CULTURA_ID"));
                    if(tlh.getCultura() != null){
                        cultura.setDoencas(tlh.getCultura().getDoencas());
                    }
                    
                    culturas = (List<EntidadeDominio>)culturaDAO.consultar(cultura);
                    
                    talhao.setCultura((Cultura)culturas.get(0));
                    talhao.setHectares(rs.getDouble("HECTARES"));
                    talhao.setDt_ultima_colheita(rs.getDate("dt_ultima_colheita"));
                    talhao.setTipo_terra(rs.getString("TIPO_TERRA").trim());
                    
                    if(entidade.getId() != 0){
                        
                        for(EntidadeDominio hist: histDAO.consultar(talhao)){
                            historicos.add((Historico)hist);
                        }
                        talhao.setHistoricos(historicos);
                        
                    
                    }

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
