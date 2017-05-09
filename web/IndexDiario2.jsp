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
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>


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
                <span>Opra��es</span>
              </li>
              <li>
                <a href="/CRUD-web/IndexDiario.jsp" id="OPERACAO" name="OPERACAO" value="CONSULTAR">
                  <i class="icon-notebook"></i>
                  <span>Di�rio</span>
                </a>
              </li>
              
              <li>
                <a href="/CRUD-web/IndexDiario.jsp" id="OPERACAO" name="OPERACAO" value="CONSULTAR">
                  <i class="icon-bar-chart"></i>
                  <span>Relat�rios</span>
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
    <div class="col-sm-6"></div>
    <div class="col-sm-1">
        <select>
            <%
                for(int i = 0; talhoes.size() > i; i++) {
                        Talhao pp = (Talhao)talhoes.get(i);

                        out.println("<option value=\""+ pp.getId() +"\">"+pp.getDescricao()+"</option>");
                }
            
            %>
        </select> 
    </div>
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
                    <th data-breakpoints="xs sm md" data-title="Chance de Doen�a">Chance de Doen�a</th>
                    <th data-breakpoints="xs sm md" data-title="Sim">Sim</th>
                    <th data-breakpoints="xs sm md" data-title="Nao">Nao</th>
                  </tr>
                </thead>
                <tbody>

                    <% for(int i = 0; talhoes.size() > i; i++) {
                        Talhao pp = (Talhao)talhoes.get(i);
                        Date date = new Date();
                        boolean l = false;
                         

                        out.println("<tr>");    
                        out.println("<td id=\"id\">"+pp.getId()+"</td>");
                        out.println("<td>"+pp.getDescricao()+"</td>");
                        out.println("<td>"+pp.getCultura()+"</td>");
                        out.println("<td>0%</td>");
                        
                        for(Historico hist: pp.getHistoricos()){
                            if(hist.getData().equals(date)){
                                System.out.print(hist.getData());
                                System.out.print(date);
                                l = true;
                            }
                         }
                        if (!l) {
                            out.println("<td><input type=\"checkbox\"</td>");
                            out.println("<td><input type=\"checkbox\"/td>");
                        }
                        out.println("</tr>");    
                        
                    }
                    %>  

                </tbody>
              </table>
 
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
                    <caption>Historico de Doen�as</caption>
                    <thead>
                        <tr>
                            <th data-breakpoints="xs sm md" data-title="Data">Data</th>
                            <th data-breakpoints="xs">ID Talhao</th>
                            <th>Descricao Talhao</th>
                            <th data-breakpoints="xs sm md" data-title="Pct Doen�a">Pct Doen�a</th>
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
                                out.println("</tr>");
                            }

                        }


                    %>
                    </tbody>
                </table>  
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group">
            <div class="col-sm-10">
            </div>
            <div class="col-sm-2">
                <button class="btn m-b-xs btn-sm btn-default btn-addon">
                    <a  href="/CRUD-web/NewDiario.jsp"><i class="fa fa-plus"></i>Add Diario</a>
                </button>
            </div>
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
    <script type="text/javascript">
      google.charts.load('current', {'packages':['line']});
      google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        <% Talhao pp = (Talhao)talhoes.get(0); %>
      var data = new google.visualization.DataTable();
      data.addColumn('number', 'Day');
      data.addColumn('number', '<%= pp.getDescricao() %>');
      data.addColumn('number', 'The Avengers');
      data.addColumn('number', 'Transformers: Age of Extinction');

      data.addRows([
        [1/10,  100, 80.8, 41.8],
        [2/10,  30.9, 69.5, 32.4],
        [3,  25.4,   57, 25.7],
        [4,  11.7, 18.8, 10.5],
        [5,  11.9, 17.6, 10.4],
        [6,   8.8, 13.6,  7.7],
        [7,   7.6, 12.3,  9.6],
        [8,  12.3, 29.2, 10.6],
        [9,  16.9, 42.9, 14.8],
        [10, 12.8, 30.9, 11.6],
        [11,  5.3,  7.9,  4.7],
        [12,  6.6,  8.4,  5.2],
        [13,  4.8,  6.3,  3.6],
        [14,  4.2,  6.2,  3.4]
      ]);

      var options = {
        chart: {
          title: 'Box Office Earnings in First Two Weeks of Opening',
          subtitle: 'in millions of dollars (USD)'
        },
        width: 900,
        height: 500,
        axes: {
          x: {
            0: {side: 'top'}
          }
        }
      };

      var chart = new google.charts.Line(document.getElementById('line_top_x'));

      chart.draw(data, google.charts.Line.convertOptions(options));
    }
    </script>
    <script>
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
