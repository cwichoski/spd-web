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
    <link rel="stylesheet" href="libs/assets/animate.css/animate.css" type="text/css" />
    <link rel="stylesheet" href="libs/assets/font-awesome/css/font-awesome.min.css" type="text/css" />
    <link rel="stylesheet" href="libs/assets/simple-line-icons/css/simple-line-icons.css" type="text/css" />
    <link rel="stylesheet" href="libs/jquery/bootstrap/dist/css/bootstrap.css" type="text/css" />


    <link rel="stylesheet" href="css/font.css" type="text/css" />
    <link rel="stylesheet" href="css/app.css" type="text/css" />
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        height: 100%;
      }
    </style></head>
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
            <div  class="col-sm-2">
            </div>
            <div class="col-sm-8">
                <div class="panel panel-default">
                    <div class="panel-heading font-bold">Funcionario</div>
                    <div class="panel-body">
                        <form role="form">
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-sm-1">
                                        <label>id</label>
                                        <input  type="text" id="txtNome" name="txtNome" class="form-control" placeholder="Nome" value="1">
                                    </div>
                                    <div class="col-sm-4">
                                        <label>Descricao</label>
                                        <input  type="text" id="txtNome" name="txtNome" class="form-control" placeholder="Nome" value="Propriedade 1 de Caqui">
                                    </div>
                                    <div class="col-sm-3">
                                    </div>
                                    <div class="col-sm-1">
                                        <br><br>
                                        <label>Sim</label>
                                    </div>
                                    <div class="col-sm-1">
                                        <br><br>
                                        <label>Não</label>
                                    </div>

                                    
                                </div>
                            </div>    
                            <br>
                            <div class="row">
                                <div class="col-sm-6    ">
                                    
                                </div>
                                <div class="col-sm-2">
                                    <label>Apresenta folhas secas</label><br>
                                    <label>Apresenta Manchas</label>
                                </div>
                                <div class="col-sm-1">
                                    <label class="checkbox-inline">
                                        <input type="checkbox"><br>
                                        <input type="checkbox"><br>
                                    </label>
                                </div>
                                <div class="col-sm-1">
                                    <label class="checkbox-inline">
                                        <input type="checkbox"><br>
                                        <input type="checkbox"><br>
                                    </label>
                                </div>


                            </div>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-sm-3">
                                      <label>Data</label>
                                      <input  type="date" value="2017-04-05" id="txtDtNasc" name="txtDtNasc" class="form-control" disabled>
                                    </div>

                                    <div class="col-sm-3">
                                      <label>Data prevista para próxima colheita</label>
                                      <input  type="date" value="2017-09-01" id="txtDtNasc" name="txtDtNasc" class="form-control" disabled>
                                    </div>
                                    <div class="col-sm-2">
                                      <label>Príodo para Semeio (dias)</label>
                                      <input  type="text" value="180" id="txtDtNasc" name="txtDtNasc" class="form-control" disabled>
                                    </div>
                                    <div class="col-sm-1">
                                      <label>Ha</label>
                                      <input  type="text" value="2" id="txtDtNasc" name="txtDtNasc" class="form-control" disabled>
                                    </div>


                                </div>
                            </div>
                            <div class="row">
                                
                            </div>

                            <div class="row">
                                <div class="form-group">
                                    <div class="col-sm-5">
                                      <label>Rua: </label>
                                      <input value="José Guimarães Pera" type="text" id="txtRua" name="txtRua" class="form-control" disabled>
                                    </div>
                                    <div class="col-sm-4">
                                      <label>Cidade: </label>
                                      <input value="Mogi das Cruzes" type="text" id="txtCidade" name="txtCidade" class="form-control" disabled>
                                    </div>
                                    <div class="col-sm-2">
                                      <label>Número: </label>
                                      <input value="86" type="number" id="txtNumero" name="txtNumero" class="form-control" disabled>
                                    </div>
                                    <div class="col-sm-1">
                                      <label>Estado: </label>
                                      <input value="SP" id="txtNumero" name="txtNumero" class="form-control" disabled>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <button type="button" class="btn btn-sm btn-primary" onclick="disableBtn();">Editar</button>
                            <button type="submit" class="btn btn-sm btn-primary">Salvar</button>
                            <button type="button" class="btn btn-sm btn-primary" onclick="window.location.href='Funcionario?OPERACAO=CONSULTAR'">Voltar</button>
                        </form>                       
                    </div>
                </div>
            </div>
            <div  class="col-sm-1">
            </div>

        </div>
    </div>
  </div>
<div id="map"></div>
<script>

  var map;
  function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
      center: {lat: -34.397, lng: 150.644},
      zoom: 8
    });
  }

</script>

     
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCgr3x8ShPCyzgRfEOhGPh2vWtJxLqjJ4E&callback=initMap">
    </script>

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
