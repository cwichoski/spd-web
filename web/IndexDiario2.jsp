<%@page import="java.util.ArrayList"%>
<%@page import="les.dominio.Doenca"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="les.dominio.Historico"%>
<%@page import="les.dominio.EntidadeDominio"%>
<%@page import="les.dominio.Talhao"%>
<%@page import="les.aplicacao.Resultado"%>
<%@page import="les.dominio.Propriedade"%>
<%@page import="les.dominio.Grupo"%>
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
  <link rel="stylesheet" href="libs/assets/animate.css/animate.css" type="text/css" />
  <link rel="stylesheet" href="libs/assets/font-awesome/css/font-awesome.min.css" type="text/css" />
  <link rel="stylesheet" href="libs/assets/simple-line-icons/css/simple-line-icons.css" type="text/css" />
  <link rel="stylesheet" href="libs/jquery/bootstrap/dist/css/bootstrap.css" type="text/css" />
  <link rel="stylesheet" href="css/footable.bootstrap.min.css" type="text/css" />
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
                <a href="/CRUD-web/IndexCultura.jsp" id="OPERACAO" name="OPERACAO" value="CONSULTAR">
                  <i class="icon-basket-loaded"></i>
                  <span>Cultura </span>
                </a>
            </li>            
            
            <li>
                <a href="/CRUD-web/IndexDoenca.jsp" id="OPERACAO" name="OPERACAO" value="CONSULTAR">
                  <i class="icon-plus"></i>
                  <span>Doença</span>
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
<%
    Talhao talhao = new Talhao();
    Resultado result = new Resultado();

    result = (Resultado) request.getAttribute("SelectTalhao");         

    List<EntidadeDominio> talhoes = (List<EntidadeDominio>) result.getEntidades();   

%>

  <!-- content -->
  <div id="content" class="app-content" role="main">
  	<div class="app-content-body ">
	    

<div class="bg-light lter b-b wrapper-md">
  <h1 class="m-n font-thin h3">Diaria</h1>
</div>

<div class="row">
    <div class="col-sm-6">
        <div class="wrapper-md">
          <div class="panel panel-default">
            <div>
                
               
                    <table class="table" ui-jq="footable" ui-options='{
                      "paging": {
                        "enabled": true
                      },
                      "filtering": {
                        "enabled": true
                      },
                      "sorting": {
                        "enabled": true
                      }}'>
                        <caption>Talhoes</caption>
                      <thead>
                        <tr>
                          <th data-breakpoints="xs">ID</th>
                          <th>Descricao</th>
                          <th data-breakpoints="xs sm md" data-title="Cultura">Cultura</th>
                          <th data-breakpoints="xs sm md" data-title="Doença">Doença</th>
                          
                          <th data-breakpoints="xs sm md" data-title="Consultar"></th>
                        </tr>
                      </thead>
                      <tbody>

                          <% for(int i = 0; talhoes.size() > i; i++) {
                              Talhao pp = (Talhao)talhoes.get(i);
                              DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                              Date date = new Date();
                              date = formatter.parse(formatter.format(date));
                              boolean l = false;
                              
                                for(Doenca dd: pp.getCultura().getDoencas()){
                                    out.println("<tr>");
                                    out.println("<td id=\"id\" name=\"id\">"+ pp.getId() +"</td>");
                                    out.println("<td>"+pp.getDescricao()+"</td>");
                                    out.println("<td>"+pp.getCultura().getDescricao()+"</td>");
                                    out.println("<td>"+ dd.getDescricao()+"</td>");
                                    
                                    for(Historico hist: pp.getHistoricos()){
                                        
                                        if(hist.getData().equals(date)){                             
                                            l = true;
                                        }
                                     }
                                    if (!l) {
                                      out.println("<td><button class=\"btn m-b-xs w-xs btn-default\" onclick=\"var id = getId($(this)); window.location.href='SelectTalhao2?OPERACAO=NOVO&txtDoenca_id="+ dd.getId() +"&txtTalhao_ID='+id\">Visualizar</button></td>");
                                    }else{
                                      out.println("<td><button class=\"btn m-b-xs w-xs btn-default\" onclick=\"var id = getId($(this)); window.location.href='SelectTalhao2?OPERACAO=NOVO&txtTalhao_ID='+id\" disabled>Visualizar</button></td>");
                                    }
                                }

                              
                              
   
                              out.println("</tr>");

                          }
                          %>  
                      </tbody>

                    </table>
                        <% for(int i = 0; talhoes.size() > i; i++) {
                              Talhao pp = (Talhao)talhoes.get(i);                   
                              out.println(" <form action=\"Diario\" id=\"id"+ pp.getId() +"\">");
                              out.println("<input name=\"id\" value=\""+ pp.getId() +"\" type=\"hidden\" />");
                              out.println("<input name=\"hide_chk_s\" type=\"checkbox\" id=\""+pp.getId()+"_s\" checked=\"checked\" hidden>");
                              out.println("<input name=\"hide_chk_n\" type=\"checkbox\" id=\""+pp.getId()+"_n\" checked=\"checked\" hidden>");
                              out.println("</form>");
                        }%>
            </div>
          </div>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="wrapper-md">
          <div class="panel panel-default">
                <table class="table" ui-jq="footable" ui-options='{
                        "paging": {
                          "enabled": true
                        },
                        "filtering": {
                          "enabled": true
                        },
                        "sorting": {
                          "enabled": true
                        }}'>
                    <caption>Historico de Doenças</caption>
                    <thead>
                        <tr>
                            <th data-breakpoints="xs sm md" data-title="Data">Data</th>
                            <th data-breakpoints="xs">ID Talhao</th>
                            <th>Descricao Talhao</th>
                            <th data-breakpoints="xs sm md" data-title="Pct Doença">Pct Doença</th>
                            <th>Doença</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%  for(int i = 0; talhoes.size() > i; i++) {
                                Talhao pp = (Talhao)talhoes.get(i);

                            for(Historico hist: pp.getHistoricos()){
                                out.println("<tr>"); 
                                out.println("<td data-breakpoints=\"xs\">"+ hist.getData()+"</td>");
                                out.println("<td data-breakpoints=\"xs\">"+ pp.getId() +"</td>");
                                out.println("<td data-breakpoints=\"xs\">"+ pp.getDescricao()+"</td>");
                                out.println("<td data-breakpoints=\"xs\">"+ hist.getPct_doenca()+" %</td>");
                                out.println("<td data-breakpoints=\"xs\">"+ hist.getDoenca().getDescricao()+"</td>");
                                out.println("</tr>");
                            }

                        }


                    %>
                    </tbody>
                </table>  
                    
            </div>
        </div>
    </div>
    
</div>
<div class="row">
        <div class="form-group">
            <div class="col-sm-2">
               <!-- <select>
                    <%
                       /* for(int i = 0; talhoes.size() > i; i++){
                            Talhao tlh = (Talhao)talhoes.get(i);
                            out.println("<option>"+tlh.getDescricao()+"</option>");
                        }*/
                    
                    %>
                </select>-->
            </div>
            <div class="col-sm-8">

                <div id="linechart_material" style="width: 100%; height: 500px;"></div>



            </div>
        </div>
    </div>
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
<script src="js/get-id.js"></script>
<script src="js/footable.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load('current', {'packages':['line']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = new google.visualization.DataTable();
        
        data.addColumn('string', 'Dia');
        <% 
            Talhao tlh = (Talhao)talhoes.get(0); 
            for(Doenca dd :tlh.getCultura().getDoencas()){
                out.println("data.addColumn('number', '"+ dd.getDescricao() +"');");
                
                }
                List<Historico> historicos = tlh.getHistoricos();
                List<Date> dates = new ArrayList<Date>();
                List<String> ids = new ArrayList<String>();
                List<Integer> pcts = new ArrayList<Integer>();
                int qt_doencas = tlh.getCultura().getDoencas().size();
                
                
                for(Historico hh: historicos){
                    dates.add(hh.getData());
                    ids.add(hh.getDoenca().getDescricao());
                    pcts.add(hh.getPct_doenca());

                }
                SimpleDateFormat format = new SimpleDateFormat("dd");
                out.print("data.addRows([");
                for(int i = 0; i < pcts.size();){
                    
                    out.print("['"+  Integer.parseInt(format.format(dates.get(i))) +"', "+ pcts.get(i) +", "+ pcts.get(i + 1) +"],");
                    i = i + 2; 
                }
                out.print("]);");
                

        %>


        var options = {
          title: 'Índice de doenca por talhao',
          hAxis: {title: 'Dia',  titleTextStyle: {color: '#333'}},
          vAxis: {minValue: 0}
        };

        var chart = new google.charts.Line(document.getElementById('linechart_material'));
        chart.draw(data, google.charts.Line.convertOptions(options));;
      }
</script>

<script>

    document.getElementsByName("hide_chk_s").value = "false";
    document.getElementsByName("hide_chk_n").value = "false";


    
    function toggleCheckbox_s(element){
        document.getElementById(element.value+"_s").value = element.checked;
    }    
    
    function toggleCheckbox_n(element){
        document.getElementById(element.value+"_n").value = element.checked;
    }    
        
    jQuery(function($){
        $('.table').footable({
                "paging": {
                        "enabled": true
                }
        });
    });
</script>
</body>
</html>

