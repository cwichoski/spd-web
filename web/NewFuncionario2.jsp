<%@page import="les.dominio.Propriedade"%>
<%@page import="les.aplicacao.Resultado"%>
<%@page import="les.dominio.Grupo"%>
<%@page import="les.dominio.Cargo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="les.dominio.EntidadeDominio"%>
<%@page import="les.dominio.Endereco"%>
<%@page import="java.util.List"%>
<%@page import="les.dominio.Funcionario"%>
<!DOCTYPE html>
<html lang="en" class="">
<head>
    <meta charset="utf-8" />
    <title>Html version | Angulr</title>
    <meta name="description" content="app, web app, responsive, responsive layout, admin, admin panel, admin dashboard, flat, flat ui, ui kit, AngularJS, ui route, charts, widgets, components" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <script src="libs/jquery/jquery/dist/jquery.js"></script>
    <script src="libs/jquery/bootstrap/dist/js/bootstrap.js"></script>
    <script src="libs/jquery/chosen/chosen.jquery.min.js"></script>
    <script src="js/ui-load.js"></script>
    <script src="js/ui-jp.config.js"></script>
    <script src="js/ui-jp.js"></script>
    <script src="js/ui-nav.js"></script>
    <script src="js/ui-toggle.js"></script>
    <script src="js/ui-client.js"></script>
    <script src="js/get-id.js"></script>
    <script src="js/MascaraValidacao.js"></script>
    <link rel="stylesheet" href="libs/assets/animate.css/animate.css" type="text/css" />
    <link rel="stylesheet" href="libs/assets/font-awesome/css/font-awesome.min.css" type="text/css" />
    <link rel="stylesheet" href="libs/assets/simple-line-icons/css/simple-line-icons.css" type="text/css" />
    <link rel="stylesheet" href="libs/jquery/bootstrap/dist/css/bootstrap.css" type="text/css" />


    <link rel="stylesheet" href="css/font.css" type="text/css" />
    <link rel="stylesheet" href="css/app.css" type="text/css" />
  
  head>
<body>
<div class="app app-header-fixed ">
  

    <!-- header -->
  <header id="header" class="app-header navbar" role="menu">
      <!-- navbar header -->
      <div class="navbar-header bg-dark">
        <button class="pull-right visible-xs dk" ui-toggle-class="show" target=".navbar-collapse">
          <i class="glyphicon glyphicon-cog"></i>
        </button>
        <button class="pull-right visible-xs" ui-toggle-class="off-screen" target=".app-aside" ui-scroll="app">
          <i class="glyphicon glyphicon-align-justify"></i>
        </button>
        <!-- brand -->
        <a href="#/" class="navbar-brand text-lt">
          <i class="fa fa-btc"></i>
          <img src="img/logo.png" alt="." class="hide">
          <span class="hidden-folded m-l-xs">Angulr</span>
        </a>
        <!-- / brand -->
      </div>
      <!-- / navbar header -->

      <!-- navbar collapse -->
      <div class="collapse pos-rlt navbar-collapse box-shadow bg-white-only">
        <!-- buttons -->
        <div class="nav navbar-nav hidden-xs">
          <a href="#" class="btn no-shadow navbar-btn" ui-toggle-class="app-aside-folded" target=".app">
            <i class="fa fa-dedent fa-fw text"></i>
            <i class="fa fa-indent fa-fw text-active"></i>
          </a>
          
        </div>
        <!-- / buttons -->


  </header>
  <!-- / header -->


    <!-- aside -->
  <aside id="aside" class="app-aside hidden-xs bg-dark">
      <div class="aside-wrap">
        <div class="navi-wrap">
     
          <!-- nav -->
          <nav ui-nav class="navi clearfix">
            <ul class="nav">
              <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                <span>Cadastro</span>
              </li>
              <li>
                <a href="Funcionario?OPERACAO=CONSULTAR" id="OPERACAO" name="OPERACAO" value="CONSULTAR">
                  <i class="icon-user-follow"></i>
                  <input type="hidden" id="OPERACAO" name="OPERACAO" value="CONSULTAR">
                  <span>Funcionario</span>
                </a>
              </li>
              <li>
                <a href="/CRUD-web/IndexGrupo.jsp" id="OPERACAO" name="OPERACAO" value="CONSULTAR">
                  <i class="fa fa-group"></i>
                  <span>Grupo</span>
                </a>
              </li>
              <li>
                <a href="/CRUD-web/IndexPropriedade.jsp" id="OPERACAO" name="OPERACAO" value="CONSULTAR">
                  <i class="icon-map"></i>
                  <span>Propriedade </span>
                </a>
              </li>
              
              <li>
                <a href="/CRUD-web/IndexCargo.jsp" id="OPERACAO" name="OPERACAO" value="CONSULTAR">
                  <i class="icon-wrench"></i>
                  <span>Cargo </span>
                </a>
              </li>
              
              <li>
                <a href="/CRUD-web/IndexDispositivo.jsp" id="OPERACAO" name="OPERACAO" value="CONSULTAR">
                  <i class="icon-rocket"></i>
                  <span>Dispositivo</span>
                </a>
              </li>
              <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                <span>Oprações</span>
              </li>
              <li>
                <a href="/CRUD-web/IndexDiario.jsp" id="OPERACAO" name="OPERACAO" value="CONSULTAR">
                  <i class="icon-notebook"></i>
                  <span>Diário</span>
                </a>
              </li>
              
              <li>
                <a href="/CRUD-web/IndexDiario.jsp" id="OPERACAO" name="OPERACAO" value="CONSULTAR">
                  <i class="icon-bar-chart"></i>
                  <span>Relatórios</span>
                </a>
              </li>
              <li>
                <a href="/CRUD-web/IndexMsg.jsp" id="OPERACAO" name="OPERACAO" value="CONSULTAR">
                  <i class="icon-envelope-open"></i>
                  <span>Mesagens</span>
                </a>
              </li>              
        </div>
      </div>
  </aside>
  <!-- / aside -->


  <!-- content -->
  <div id="content" class="app-content" role="main">
    <div class="app-content-body ">
        <div class="row">
            <div  class="col-sm-1">
            </div>
            <div class="col-sm-10">
                <div class="panel panel-default">
                    <div class="panel-heading font-bold">Funcionario</div>
                    <div class="panel-body">
                        <form role="form" name="form">
                            <div class="row">
                                <div class="form-group">
                                    
                                    <% // traz lista de funcionarios para colocar no form
                                       Resultado result = (Resultado) request.getAttribute("ConsultaFuncionario");
                                       
                                       List<EntidadeDominio> funcionarios = (List<EntidadeDominio>) result.getEntidades();    
                                       
                                       Funcionario func = (Funcionario)funcionarios.get(0);
                                    %>
                                    <div class="col-sm-1">
                                        <label>ID</label>
                                        <input  type="text" id="txtID" name="txtID" class="form-control" readonly>
                                    </div>

                                    <div class="col-sm-7">
                                        <label>Nome completo</label>
                                        <input  type="text" id="txtNome" name="txtNome" class="form-control" placeholder="Nome completo" >
                                    </div>
                                    
                                    <div class="col-sm-4">
                                      <label>Dt. Nasc</label>
                                      <input  type="text" onKeyPress="MascaraData(form.txtDtNasc);"  maxlength="10" onBlur= "ValidaData(form.txtDtNasc);" id="txtDtNasc" name="txtDtNasc" class="form-control" placeholder="aaaa-mm-dd">
                                    </div>
                                </div>
                            </div>    
                            <br>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-sm-4">
                                      <label>CPF: </label>
                                      <input type="text"  onBlur="ValidarCPF(form.txtCpf);" onKeyPress="MascaraCPF(form.txtCpf);" maxlength="14" id="txtCpf" name="txtCpf" class="form-control">
                                    </div>
                                    <div class="col-sm-4">
                                        <label control-label>Grupo</label>
                                        <%  List<Grupo> groups = new ArrayList<Grupo>();	
                                            for (int i = 0; func.getGrupos().size() > i; i++){
                                                Grupo group = (Grupo)func.getGrupos().get(i);
                                                groups.add(group);
                                            }
                                        %>
                                        <select id="txtGrupo" name="txtGrupo" name="account" class="form-control m-b" >
                                        <% for(Grupo gp: groups){ 
                                                out.println("<option value=\""+gp.getId()+"\">"+gp.getDescricao()+"</option>");
                                            }
                                        %>   
                                        </select>
                                    </div>
                                    <div class="col-sm-4">
                                        <label control-label>Cargo</label>
                                        <%  List<Cargo> cargos = new ArrayList<Cargo>();	
                                            for (int i = 0; func.getCargos().size() > i; i++){
                                                Cargo cargo = (Cargo)func.getCargos().get(i);
                                                cargos.add(cargo);
                                            }
                                        %>
                                        <select id="txtCargo" name="txtCargo" name="account" class="form-control m-b" >
                                          <% for(Cargo cg: cargos){ 
                                            
                                                out.println("<option value=\""+cg.getId()+"\">"+cg.getDescricao()+"</option>");
                                            
                                            }
                                          %>    
                                        </select>
                                    </div>

                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-sm-4">
                                      <label>Propriedade Relacionada</label><br>
                                      
                                        <%  List<Propriedade> propriedades = new ArrayList<Propriedade>();	
                                            for (int i = 0; func.getPropiedades().size() > i; i++){
                                                Propriedade prop = (Propriedade)func.getPropiedades().get(i);
                                                propriedades.add(prop);
                                            }
                                            String selected = "selected";
                                        %>
                                        <select id="txtPropriedade" name="txtPropriedade" ui-jq="chosen" multiple class="w-md">
                                          <% for(Propriedade pp: propriedades){ 
                                                selected = null;
                                                for (int i = 0; func.getPropriedades_id().size() > i; i++){
                                                    if(func.getPropriedades_id().get(i) == pp.getId() ){
                                                        selected = "selected";
                                                    }
                                                }
                                                out.println("<option value=\""+pp.getId()+"\" "+ selected +">"+pp.getDescricao()+"</option>");
                                            }
                                          %>   
                                      </select>
                                    </div>
                               </div>
                            </div>

                            <div class="row">
                                <div class="form-group">
                                    <div class="col-sm-4">
                                      
                                      <label>Rua: </label>
                                      <input  type="text" id="txtRua" name="txtRua" class="form-control" >
                                    </div>
                                    <div class="col-sm-2">
                                      <label>Cidade: </label>
                                      <input  type="text" id="txtCidade" name="txtCidade" class="form-control" >
                                    </div>
                                    
                                    <div class="col-sm-2">
                                      <label>CEP: </label>
                                      <input  type="text" id="txtCep" name="txtCep" class="form-control" >
                                    </div>

                                </div>
                            </div>
                            <br>
                            <button type="submit" class="btn btn-sm btn-primary" id="OPERACAO" name="OPERACAO" value="SALVAR">Salvar</button>
                            <button type="button" class="btn btn-sm btn-primary" onclick="window.location.href='Funcionario?OPERACAO=CONSULTAR'">Voltar</button>
                        </form  >                       
                    </div>
                </div>
            </div>
            <div  class="col-sm-1">
            </div>
        </div>
    </div>
  </div>
  <!-- /content -->
  
  <!-- footer -->
  <footer id="footer" class="app-footer" role="footer">
    <div class="wrapper b-t bg-light">
      <span class="pull-right">2.2.0 <a href ui-scroll="app" class="m-l-sm text-muted"><i class="fa fa-long-arrow-up"></i></a></span>
      &copy; 2016 Copyright.
    </div>
  </footer>
  <!-- / footer -->



</div>
    <script>
        function disableBtn(){
            $("input").prop('disabled', false);
            $("select").prop('disabled', false);
        }
    </script>
</body>
</html>
