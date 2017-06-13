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
import les.dominio.Arquivo;
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
           Arquivo arq = (Arquivo)entidade;
           List<EntidadeDominio> arquivos = new ArrayList<EntidadeDominio>();
           arquivos.add(arq);
           return arquivos;
    }

    @Override
    public boolean alterar(EntidadeDominio entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
}
