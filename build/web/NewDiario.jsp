<%-- 
    Document   : index
    Created on : Mar 26, 2017, 11:04:17 AM
    Author     : gustavo
--%>




<%@page import="java.util.ArrayList"%>
<%@page import="les.dominio.Doenca"%>
<%@page import="les.dominio.Cultura"%>
<%@page import="java.util.Date"%>
<%@page import="les.dominio.Historico"%>
<%@page import="les.dominio.EntidadeDominio"%>
<%@page import="java.util.List"%>
<%@page import="les.aplicacao.Resultado"%>
<%@page import="les.dominio.Talhao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="">
<head>
  <meta charset="utf-8" />
  <title>Html version | Angulr</title>
  <meta name="description" content="app, web app, responsive, responsive layout, admin, admin panel, admin dashboard, flat, flat ui, ui kit, AngularJS, ui route, charts, widgets, components" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
  <link rel="stylesheet" href="libs/assets/animate.css/animate.css" type="text/css" />
  <link rel="stylesheet" href="libs/assets/font-awesome/css/font-awesome.min.css" type="text/css" />
  <link rel="stylesheet" href="libs/assets/simple-line-icons/css/simple-line-icons.css" type="text/css" />
  <link rel="stylesheet" href="libs/jquery/bootstrap/dist/css/bootstrap.css" type="text/css" />

  <link rel="stylesheet" href="css/font.css" type="text/css" />
  <link rel="stylesheet" href="css/app.css" type="text/css" />

</head>
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
        <a href="/CRUD-web" class="navbar-brand text-lt">
          <i class="fa fa-btc"></i>
          <img src="img/logo.png" alt="." class="hide">
          <span class="hidden-folded m-l-xs">SPD</span>
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

      </div>
      <!-- / navbar collapse -->
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
                <a href="/CRUD-web/IndexTalhao.jsp" id="OPERACAO" name="OPERACAO" value="CONSULTAR">
                  <i class="icon-pointer"></i>
                  <span>Talhao </span>
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
          </nav>
          <!-- nav -->
        </div>
      </div>
  </aside>
  <!-- / aside -->


  <%
    Talhao talhao = new Talhao();
    Cultura cultura = new Cultura();
    Doenca doenca = new Doenca();
    List<Doenca> doencas = new ArrayList<Doenca>();
    
    Resultado result = new Resultado();

    result = (Resultado) request.getAttribute("ConsultaTalhao");       
    

    List<EntidadeDominio> talhoes = (List<EntidadeDominio>) result.getEntidades();   
    talhao = (Talhao)talhoes.get(0);
    cultura = talhao.getCultura();
    doencas = cultura.getDoencas();
    
%>

  <!-- content -->
  <div id="content" class="app-content" role="main">
  	<div class="app-content-body ">
	    

<div class="bg-light lter b-b wrapper-md">
  <h1 class="m-n font-thin h3">Diaria</h1>
</div>
        <form role="form" name="form" action="Diario">
            <div class="wrapper-md">
            <div class="panel panel-default">
                <input type="hidden" name="culturaID" value="<%=cultura.getId()%>">
                <input type="hidden" name="talhaoID" value="<%=talhao.getId()%>">


                <%

                    for(int i = 0; cultura.getDoencas().size() > i; i++) {
                        out.println("<div class=\"row\">"); 
                        out.println("<div class=\"col-sm-1\"></div>");
                        out.println("<div class=\"col-sm-8\">");
                        out.println(cultura.getDoencas().get(i).getDescricao()); 
                        
                        out.println("</div>");
                        out.println("</div>");
                        for(int y = 0; cultura.getDoencas().get(i).perguntasDoencas().size() > y; y++) {
                            
                            
                            out.println("<div class=\"row\">"); 
                            out.println("<div class=\"col-sm-1\"></div>");
                            out.println("<div class=\"col-sm-8\">");
                            out.println(cultura.getDoencas().get(i).perguntasDoencas().get(y).getDescricao());
                            out.println("<input type=\"hidden\" name=\"qtDoencas\" value="+ cultura.getDoencas().size() +">");
                            out.println("<input type=\"hidden\" name=\"doencaID"+i+"\" value="+ cultura.getDoencas().get(i).getId() +">");
                            
                            out.println("<input type=\"hidden\" name=\"qtPergunas"+i+"\" value="+ cultura.getDoencas().get(i).perguntasDoencas().size() +">");


                            if(cultura.getDoencas().get(i).perguntasDoencas().get(y).getTipo().equals("Boolean")){
                                out.println("<input type=\"hidden\" name=\"nmDoenca"+i+"\" value="+ cultura.getDoencas().get(i).getDescricao() +">");
                                out.println("<select name=\"combo"+ i + y +"\">");
                                out.println("<option value=\"Nao\">Nao</option>");
                                out.println("<option value=\"Sim\">Sim</option>");
                                out.println("</select>");
                            }else{
                                out.println("<input  type=\"text\" id=\"txtNome\" name=\"txt"+ i + y +"\" class=\"form-control\" >");
                            }

                            out.println("</div>");
                            out.println("</div>");
                        }

                    }

                %>
                    <button type="submit" class="btn btn-sm btn-primary" id="OPERACAO" name="OPERACAO" value="SALVAR">Salvar</button>
                    <button type="button" class="btn btn-sm btn-primary" onclick="window.location.href='SelectTalhao?OPERACAO=CONSULTAR'">Voltar</button>

            </div>    
        </div>
    </form>

<div class="row">
    <div class="col-sm-1"></div>
    <div class="col-sm-6">
        <div id="line_top_x"></div>
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

<script src="libs/jquery/jquery/dist/jquery.js"></script>
<script src="libs/jquery/bootstrap/dist/js/bootstrap.js"></script>
<script src="js/ui-load.js"></script>
<script src="js/ui-jp.config.js"></script>
<script src="js/ui-jp.js"></script>
<script src="js/ui-nav.js"></script>
<script src="js/ui-toggle.js"></script>
<script src="js/ui-client.js"></script>

</body>
</html>

