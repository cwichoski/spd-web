package les.controle;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import les.aplicacao.Resultado;
import les.dominio.Cargo;
import les.dominio.Funcionario;
import les.dominio.Endereco;
import les.dominio.EntidadeDominio;
import les.dominio.Grupo;
import static org.apache.coyote.ajp.Constants.a;

public class FuncionarioVH extends AbstractVH{
	public FuncionarioVH(){
		super("Funcionario");
	}
	
	
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		operacao = request.getParameter("OPERACAO");		
		int id=0;
		String nome=null;	
		String cpf=null;
		Date dt_nasc = null;
		String rua=null;
		String cep=null;
		String cidade=null;
		Endereco end=null;
                int grupo_id = 0;
                int cargo_id = 0;
                List<Integer> propriedades_id = new ArrayList<Integer>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                
		if(operacao.equals("SALVAR")){
			
                    nome = request.getParameter("txtNome");
                    cpf = request.getParameter("txtCpf");
                    
                    try {
                        dt_nasc = formatter.parse(request.getParameter("txtDtNasc"));
                    } catch (ParseException ex) {
                        Logger.getLogger(FuncionarioVH.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    rua = request.getParameter("txtRua");
                    cep = request.getParameter("txtCep");
                    cidade = request.getParameter("txtCidade");			
                    end = new Endereco(rua, cep, cidade);
                    grupo_id = Integer.parseInt(request.getParameter("txtGrupo"));
                    cargo_id = Integer.parseInt(request.getParameter("txtCargo"));
                    String[] pp_id = null;
                    pp_id = request.getParameterValues("txtPropriedade");
                    
                    if (!pp_id.equals(null)){
                        for (int i = 0; pp_id.length > i; i++){
                            propriedades_id.add(Integer.parseInt(pp_id[i]));
                        }

                    }
                
		}else if(operacao.equals("EXCLUIR")){		
                    id  = Integer.parseInt(request.getParameter("txtID"));
                }else if(operacao.equals("CONSULTAR") ){		
                    if (request.getParameter("txtID") != null){
                        id  = Integer.parseInt(request.getParameter("txtID"));
                    }
                    
		}else if(operacao.equals("EDITAR")){
                    if (request.getParameter("txtID") != null){
                        id  = Integer.parseInt(request.getParameter("txtID"));
                    }
 
                    nome = request.getParameter("txtNome");
                    cpf = request.getParameter("txtCpf");
                    try {
                        dt_nasc = formatter.parse(request.getParameter("txtDtNasc"));
                    } catch (ParseException ex) {
                        Logger.getLogger(FuncionarioVH.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    rua = request.getParameter("txtRua");
                    cep = request.getParameter("txtCep");
                    cidade = request.getParameter("txtCidade");			
                    end = new Endereco(rua, cep, cidade);
                    grupo_id = Integer.parseInt(request.getParameter("txtGrupo"));
                    cargo_id = Integer.parseInt(request.getParameter("txtCargo"));
                    String[] pp_id = null;
                    pp_id = request.getParameterValues("txtPropriedade");
                    
                    for (int i = 0; pp_id.length > i; i++){
                        propriedades_id.add(Integer.parseInt(pp_id[i]));
                    }
                    
                    

                    
                }else if(operacao.equals("NOVO")){
                    
                }	
		
		Funcionario funcionario = new Funcionario(nome, cpf, end, dt_nasc, grupo_id, cargo_id,propriedades_id);
		funcionario.setId(id);
		
		return funcionario;
	}
        
     public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        operacao = request.getParameter("OPERACAO");		
        
        if(operacao.equals("SALVAR")){
 
            request.setAttribute("ConsultaFuncionario", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("/Funcionario?OPERACAO=CONSULTAR&txtID=0");	
            servlet.init(request);
            rd.forward(request, response);
        } else if(operacao.equals("EXCLUIR")){
            
            request.setAttribute("ConsultaFuncionario", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("/Funcionario?OPERACAO=CONSULTAR&txtID=0");		
            servlet.init(request);
            rd.forward(request, response);
        } else if(operacao.equals("EDITAR")){
            request.setAttribute("ConsultaFuncionario", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("/Funcionario?OPERACAO=CONSULTAR&txtID=0");		
            servlet.init(request);
            rd.forward(request, response);
        } else if(operacao.equals("NOVO")){
            request.setAttribute("ConsultaFuncionario", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("NewFuncionario2.jsp");		

            rd.forward(request, response);
        }else {
            
            String uri = request.getRequestURI();
            request.setAttribute("SelectFuncionario", resultado);
            RequestDispatcher rd;
            Resultado result = (Resultado)resultado;
            List<EntidadeDominio> ls = result.getEntidades();
            
            
            if (uri.equals("/CRUD-web/SelectFuncionario")){//se trazer apenas um objeto, manda para tela de editar
                request.setAttribute("ConsultaFuncionario", resultado);
                rd = request.getRequestDispatcher("EditFuncionario.jsp");		
            } else {
                rd = request.getRequestDispatcher("IndexFuncionario2.jsp");		
            }
            
            rd.forward(request, response);
        }
    }
}
