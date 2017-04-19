package les.controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import les.aplicacao.Resultado;

import les.dao.IDAO;
import les.dao.impl.FuncionarioDAO;
import les.dominio.Funcionario;
import les.dominio.EntidadeDominio;
import les.negocio.IStrategy;
import les.negocio.ValidadorFuncionario;


public class Fachada implements IFachada{
	private Map<String, List<IStrategy>> rns;
	private Map<String, IDAO> daos;
        Resultado result = new Resultado();
	
	public Fachada(){
		rns = new HashMap<String, List<IStrategy>>();
		daos = new HashMap<String, IDAO>();
		
		List<IStrategy> estrategiasFuncionario = new ArrayList<IStrategy>();
		estrategiasFuncionario.add(new ValidadorFuncionario());
		
		
		List<IStrategy> estrategiasFornecedor = new ArrayList<IStrategy>();
		
		
		rns.put(Funcionario.class.getName(), estrategiasFuncionario);
		
		
		daos.put(Funcionario.class.getName(), new FuncionarioDAO());
		
		
	}
	
	public Resultado salvar(EntidadeDominio entidade) {
		
		StringBuilder sb = new StringBuilder();
		String nmEntidade = entidade.getClass().getName();
		List<IStrategy> regrasEntidade = rns.get(nmEntidade);

                
		String msg=null;
		for(IStrategy st: regrasEntidade){
			msg = st.processar(entidade);
			validarMsg(sb, msg);
		}	
		
			
		if(sb.length() > 0){
                    result.setMsg(sb.toString());
                    return result;
		}else{
                    IDAO dao = daos.get(nmEntidade);
                    if (dao.salvar(entidade)){
                        msg = "Funcionario salvo com suesso";   
                        result.setMsg(msg);
                        return result;
                    }else {
                        msg = "Deu erro";
                        result.setMsg(msg);
                        return result;
                    }
                        
		}		
		
	
	}

	/** 
	 * TODO Descri��o do M�todo
	 * @param entidade
	 * @return
	 * @see les.controle.IFachada#alterar(les.dominio.EntidadeDominio)
	 */
	public Resultado alterar(EntidadeDominio entidade) {
		IDAO dao = daos.get(entidade.getClass().getName());
		dao.alterar(entidade);
		return null;
	}

	/** 
	 * TODO Descri��o do M�todo
	 * @param entidade
	 * @return
	 * @see les.controle.IFachada#excluir(les.dominio.EntidadeDominio)
	 */
	public Resultado excluir(EntidadeDominio entidade) {
		IDAO dao = daos.get(entidade.getClass().getName());
                String msg;
                if (dao.excluir(entidade)){
                    msg = "Funcionario excluido com suesso";
                    result.setMsg(msg);
                    return result;
                }else {
                   msg = "Funcionario não existe";
                    result.setMsg(msg);
                    return result;
                }
		
	}

	/** 
	 * TODO Descri��o do M�todo
	 * @param entidade
	 * @return
	 * @see les.controle.IFachada#consultar(les.dominio.EntidadeDominio)
	 */

	public Resultado consultar(EntidadeDominio entidade) {
		IDAO dao = daos.get(entidade.getClass().getName());
		result.setEntidades(dao.consultar(entidade));
                return result;
		
	}
	
	private void validarMsg(StringBuilder sb, String msg){
		if(msg != null){
			sb.append(msg);
			sb.append("\n");
		}
	}


}
