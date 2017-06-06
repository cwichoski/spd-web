package les.controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import les.aplicacao.Resultado;

import les.dao.IDAO;
import les.dao.impl.CargoDAO;
import les.dao.impl.CulturaDAO;
import les.dao.impl.DiarioDAO;
import les.dao.impl.DoencaDAO;
import les.dao.impl.FuncionarioDAO;
import les.dao.impl.GrupoDAO;
import les.dao.impl.HistoricoDAO;
import les.dao.impl.PropriedadeDAO;
import les.dao.impl.TalhaoDAO;
import les.dominio.Cargo;
import les.dominio.Cultura;
import les.dominio.Diario;
import les.dominio.Doenca;
import les.dominio.Funcionario;
import les.dominio.EntidadeDominio;
import les.dominio.Grupo;
import les.dominio.Historico;
import les.dominio.Propriedade;
import les.dominio.Talhao;
import les.negocio.IStrategy;
import les.negocio.ValidadorCultura;
import les.negocio.ValidadorDiario;
import les.negocio.ValidadorDoenca;
import les.negocio.ValidadorFuncionario;
import les.negocio.ValidadorGrupo;
import les.negocio.ValidadorPropriedade;
import les.negocio.ValidadorTalhao;


public class Fachada implements IFachada{
	private Map<String, List<IStrategy>> rns;
	private Map<String, IDAO> daos;
        Resultado result = new Resultado();
	
	public Fachada(){
		rns = new HashMap<String, List<IStrategy>>();
		daos = new HashMap<String, IDAO>();
		
		List<IStrategy> estrategiasFuncionario = new ArrayList<IStrategy>();
		estrategiasFuncionario.add(new ValidadorFuncionario());
                
                List<IStrategy> estrategiasGrupo = new ArrayList<IStrategy>();
		estrategiasGrupo.add(new ValidadorGrupo());
		
		List<IStrategy> estrategiasPropriedade = new ArrayList<IStrategy>();
                estrategiasGrupo.add(new ValidadorPropriedade());
		
                List<IStrategy> estrategiasTalhao = new ArrayList<IStrategy>();
                estrategiasTalhao.add(new ValidadorTalhao());
                
                List<IStrategy> estrategiasDiario = new ArrayList<IStrategy>();
                estrategiasDiario.add(new ValidadorDiario());

                List<IStrategy> estrategiasCultura = new ArrayList<IStrategy>();
                estrategiasCultura.add(new ValidadorCultura());

                List<IStrategy> estrategiasDoenca = new ArrayList<IStrategy>();
                estrategiasDoenca.add(new ValidadorDoenca());

		
		rns.put(Funcionario.class.getName(), estrategiasFuncionario);
                rns.put(Grupo.class.getName(), estrategiasGrupo);
                rns.put(Diario.class.getName(), estrategiasDiario);
                rns.put(Cultura.class.getName(), estrategiasCultura);
                rns.put(Doenca.class.getName(), estrategiasDoenca);
		
		daos.put(Funcionario.class.getName(), new FuncionarioDAO());
                daos.put(Cargo.class.getName(), new CargoDAO());
                daos.put(Grupo.class.getName(), new GrupoDAO());
                daos.put(Propriedade.class.getName(), new PropriedadeDAO());
                daos.put(Talhao.class.getName(), new TalhaoDAO());
                daos.put(Historico.class.getName(), new HistoricoDAO());
                daos.put(Diario.class.getName(), new DiarioDAO());
                daos.put(Cultura.class.getName(), new CulturaDAO());
                daos.put(Doenca.class.getName(), new DoencaDAO());
                
		
		
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
                        msg = "Entidade salvo com suesso";   
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
