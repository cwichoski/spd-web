package les.controle;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import les.dominio.EntidadeDominio;
import les.dominio.Funcionario;
import les.dominio.Endereco;
import les.dominio.ICommand;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;

public class Controle {
    private Map<String, ICommand> commands;
    private Map<String, FuncionarioVH> vhs;
    public Controle() {
    	commands = new HashMap<String, ICommand>();
        commands.put("SALVAR", new SalvarCommand());
        commands.put("EXCLUIR", new ExcluirCommand());
        commands.put("CONSULTAR", new ConsultarCommand());
        commands.put("ALTERAR", new AlterarCommand());
        
        vhs = new HashMap<String, FuncionarioVH>();
        
        vhs.put("/LES/SalvarFuncionario", new FuncionarioVH());
        
        //vhs.put("/ProjetoESIIIWeb2016/SalvarFornecedor", new FornecedorVH());
        
    }
    
    public void processar(String[] args, String btn) throws IOException{
    	// Obt�m um viewhelper indexado pela uri que invocou esta servlet
    		String uri = "/LES/SalvarFuncionario";
    		
    		FuncionarioVH vh = vhs.get(uri);
			// O viewhelper retorna a entidade especifica para a tela que chamou
					// esta servlet
    		String request = btn;
                //EntidadeDominio entidade = vh.getEntidade(request, args);


                String operacao = btn;


                ICommand cmd = commands.get(operacao);
                //String msg = cmd.executar(entidade);

                 //vh.setView(msg, request);

    }

}
