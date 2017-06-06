<%-- 
    Document   : index
    Created on : Mar 26, 2017, 11:04:17 AM
    Author     : gustavo
--%>

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
          </nav>
          <!-- nav -->
        </div>
      </div>
  </aside>
  <!-- / aside -->


  <!-- content -->
  <div id="content" class="app-content" role="main">
  	<div class="app-content-body ">
	    

<div class="hbox hbox-auto-xs hbox-auto-sm" ng-init="
    app.settings.asideFolded = false; 
    app.settings.asideDock = false;
  ">
  <!-- main -->
  <div class="col">
    <!-- main header -->
    <div class="bg-light lter b-b wrapper-md">
      <div class="row">
        <div class="col-sm-6 col-xs-12">
          <h1 class="m-n font-thin h3 text-black">Dashboard</h1>
          <small class="text-muted">Welcome to angulr application</small>
        </div>
        <div class="col-sm-6 text-right hidden-xs">
          <div class="inline m-r text-left">
          </div>
        </div>
      </div>
    </div>
    <!-- / main header -->
    <div class="wrapper-md" ng-controller="FlotChartDemoCtrl">
      <!-- stats -->
      <div class="row">
        <div class="col-md-5">
          <div class="row row-sm text-center">
            <div class="col-xs-6">
              <div class="panel padder-v item">
                <div class="h1 text-info font-thin h1">521</div>
                <span class="text-muted text-xs">New items</span>
                <div class="top text-right w-full">
                  <i class="fa fa-caret-down text-warning m-r-sm"></i>
                </div>
              </div>
            </div>
            <div class="col-xs-6">
              <a href class="block panel padder-v bg-primary item">
                <span class="text-white font-thin h1 block">930</span>
                <span class="text-muted text-xs">Uploads</span>
                <span class="bottom text-right w-full">
                  <i class="fa fa-cloud-upload text-muted m-r-sm"></i>
                </span>
              </a>
            </div>
            <div class="col-xs-6">
              <a href class="block panel padder-v bg-info item">
                <span class="text-white font-thin h1 block">432</span>
                <span class="text-muted text-xs">Comments</span>
                <span class="top">
                  <i class="fa fa-caret-up text-warning m-l-sm m-r-sm"></i>
                </span>
              </a>
            </div>
            <div class="col-xs-6">
              <div class="panel padder-v item">
                <div class="font-thin h1">129</div>
                <span class="text-muted text-xs">Feeds</span>
                <div class="bottom">
                  <i class="fa fa-caret-up text-warning m-l-sm m-r-sm"></i>
                </div>
              </div>
            </div>
            <div class="col-xs-12 m-b-md">
              <div class="r bg-light dker item hbox no-border">
                <div class="col w-xs v-middle hidden-md">
                  <div ng-init="d3_3=[60,40]" ui-jq="sparkline" ui-options="[60,40], {type:'pie', height:40, sliceColors:['#fad733','#fff']}" class="sparkline inline"></div>
                </div>
                <div class="col dk padder-v r-r">
                  <div class="text-primary-dk font-thin h1"><span>$12,670</span></div>
                  <span class="text-muted text-xs">Revenue, 60% of the goal</span>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-7">
          <div class="panel wrapper">
            <label class="i-switch bg-warning pull-right" ng-init="showSpline=true">
              <input type="checkbox" ng-model="showSpline">
              <i></i>
            </label>
            <h4 class="font-thin m-t-none m-b text-muted">Latest Campaign</h4>
            <div ui-jq="plot" ui-refresh="showSpline" ui-options="
              [
                { data: [ [0,7],[1,6.5],[2,12.5],[3,7],[4,9],[5,6],[6,11],[7,6.5],[8,8],[9,7] ], label:'TV', points: { show: true, radius: 1}, splines: { show: true, tension: 0.4, lineWidth: 1, fill: 0.8 } },
                { data: [ [0,4],[1,4.5],[2,7],[3,4.5],[4,3],[5,3.5],[6,6],[7,3],[8,4],[9,3] ], label:'Mag', points: { show: true, radius: 1}, splines: { show: true, tension: 0.4, lineWidth: 1, fill: 0.8 } }
              ], 
              {
                colors: ['#23b7e5', '#7266ba'],
                series: { shadowSize: 3 },
                xaxis:{ font: { color: '#a1a7ac' } },
                yaxis:{ font: { color: '#a1a7ac' }, max:20 },
                grid: { hoverable: true, clickable: true, borderWidth: 0, color: '#dce5ec' },
                tooltip: true,
                tooltipOpts: { content: 'Visits of %x.1 is %y.4',  defaultTheme: false, shifts: { x: 10, y: -25 } }
              }
            " style="height:246px" >
            </div>
          </div>
        </div>
      </div>
      <!-- / stats -->

      <!-- service -->
      <div class="panel hbox hbox-auto-xs no-border">
        <div class="col wrapper">
          <i class="fa fa-circle-o text-info m-r-sm pull-right"></i>
          <h4 class="font-thin m-t-none m-b-none text-primary-lt">Managed Services</h4>
          <span class="m-b block text-sm text-muted">Service report of this year (updated 1 hour ago)</span>
          <div ui-jq="plot" ui-options="
            [
              { data: [ [1,5.5],[2,6.5],[3,7],[4,8],[5,7.5],[6,7],[7,6.8],[8,7],[9,7.2],[10,7],[11,6.8],[12,7],[13,2.5],[14,3.5],[15,7],[16,7],[17,6],[18,7],[19,6.8],[20,5],[21,7],[22,8],[23,6.8],[24,7] ], lines: { show: true, lineWidth: 1, fill:true, fillColor: { colors: [{opacity: 0.2}, {opacity: 0.8}] } } }
            ], 
            {
              colors: ['#e8eff0'],
              series: { shadowSize: 3 },
              xaxis:{ show:false },
              yaxis:{ font: { color: '#a1a7ac' } },
              grid: { hoverable: true, clickable: true, borderWidth: 0, color: '#dce5ec' },
              tooltip: true,
              tooltipOpts: { content: '%s of %x.1 is %y.4',  defaultTheme: false, shifts: { x: 10, y: -25 } }
            }
          " style="height:240px" >
          </div>
        </div>
        <div class="col wrapper-lg w-lg bg-light dk r-r">
          <h4 class="font-thin m-t-none m-b">Reports</h4>
          <div class="">
            <div class="">
              <span class="pull-right text-primary">60%</span>
              <span>Consulting</span>
            </div>
            <div class="progress progress-xs m-t-sm bg-white">
              <div class="progress-bar bg-primary" data-toggle="tooltip" data-original-title="60%" style="width: 60%"></div>
            </div>
            <div class="">
              <span class="pull-right text-info">35%</span>
              <span>Online tutorials</span>
            </div>
            <div class="progress progress-xs m-t-sm bg-white">
              <div class="progress-bar bg-info" data-toggle="tooltip" data-original-title="35%" style="width: 35%"></div>
            </div>
            <div class="">
              <span class="pull-right text-warning">25%</span>
              <span>EDU management</span>
            </div>
            <div class="progress progress-xs m-t-sm bg-white">
              <div class="progress-bar bg-warning" data-toggle="tooltip" data-original-title="23%" style="width: 25%"></div>
            </div>
          </div>
          <p class="text-muted">Dales nisi nec adipiscing elit. Morbi id neque quam. Aliquam sollicitudin venenatis</p>
        </div>
      </div>
      <!-- / service -->

      <!-- tasks -->
      <div class="panel wrapper">
        <div class="row">
          <div class="col-md-6 b-r b-light no-border-xs">
            <a href class="text-muted pull-right text-lg"><i class="icon-arrow-right"></i></a>
            <h4 class="font-thin m-t-none m-b-md text-muted">My Tasks</h4>
            <div class=" m-b">
              <div class="m-b">
                <span class="label text-base bg-warning pos-rlt m-r"><i class="arrow right arrow-warning"></i> 19:30</span>
                <a href>Feed cat</a>
              </div>
              <div class="m-b">
                <span class="label text-base bg-info pos-rlt m-r"><i class="arrow right arrow-info"></i> 12:30</span>
                <a href>Fishing Time</a>
              </div>
              <div class="m-b">
                <span class="label text-base bg-primary pos-rlt m-r"><i class="arrow right arrow-primary"></i> 10:30</span>
                <a href>Kick-off meeting</a>
              </div>
              <div class="m-b">
                <span class="label text-base bg-light pos-rlt m-r"><i class="arrow right arrow-light"></i> 07:30</span>
                <a href>Morning running</a>
              </div>
            </div>
          </div>
          <div class="col-md-6">            
            <div class="row row-sm">
              <div class="col-xs-6 text-center">
                <div ui-jq="easyPieChart" ui-options="{
                    percent: 75,
                    lineWidth: 4,
                    trackColor: '#e8eff0',
                    barColor: '#7266ba',
                    scaleColor: false,
                    size: 115,
                    rotate: 90,
                    lineCap: 'butt'
                  }" class="inline m-t">
                  <div>
                    <span class="text-primary h4">75%</span>
                  </div>
                </div>
                <div class="text-muted font-bold text-xs m-t m-b">Work Done</div>
              </div>
              <div class="col-xs-6 text-center">
                <div ui-jq="easyPieChart" ui-options="{
                    percent: 50,
                    lineWidth: 4,
                    trackColor: '#e8eff0',
                    barColor: '#23b7e5',
                    scaleColor: false,
                    size: 115,
                    rotate: 180,
                    lineCap: 'butt'
                  }" class="inline m-t">
                  <div>
                    <span class="text-info h4">50%</span>
                  </div>
                </div>
                <div class="text-muted font-bold text-xs m-t m-b">Started</div>
              </div>
            </div>            
          </div>
        </div>
      </div>
      <!-- / tasks -->

  </div>
  
  <!-- / main -->
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

