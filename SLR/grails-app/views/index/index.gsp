<!DOCTYPE html>
<html lang="en">
  <head>
    
    <%-- Head Meta --%>
	<g:render template="headMeta" contextPath="/"/>
    
    <link rel="icon" href="favicon.ico">

    <title>Systematic Literature Review</title>

    <!-- Bootstrap core CSS -->
    <link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="bower_components/bootstrap/dist/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->
    <link href="bower_components/bootstrap/dist/css/carousel.css" rel="stylesheet">
    
  </head>
<!-- NAVBAR
================================================== -->
  <body onload="activeGalery();">
    <div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">Systematic Literature Review</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <!-- <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <li><g:link controller="index" action="faqs">FAQS</g:link></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li role="separator" class="divider"></li>
                    <li class="dropdown-header">Nav header</li>
                    <li><a href="#">Separated link</a></li>
                    <li><a href="#">One more separated link</a></li>
                  </ul>
                </li>
              </ul> -->
            </div>
          </div>
        </nav>

      </div>
    </div>


    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="${resource(dir:'images/galery_index', file:'portada1.jpg')}" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Systematic Literature Review.</h1>
              <p>Web for the creation of systematic literature reviews for the University of Cádiz, based on Mendeley</p>
              <p><g:link class="btn btn-lg btn-primary" role="button" controller="login">Sign up today</g:link> <g:link class="btn btn-lg btn-success" role="button" controller="register">Register now</g:link></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="${resource(dir:'images/galery_index', file:'portada2.jpg')}" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Systematic Literature Review.</h1>
              <p>Web for the creation of systematic literature reviews for the University of Cádiz, based on Mendeley</p>
              <p><g:link class="btn btn-lg btn-primary" role="button" controller="login">Sign up today</g:link> <g:link class="btn btn-lg btn-success" role="button" controller="register">Register now</g:link></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="${resource(dir:'images/galery_index', file:'portada3.jpg')}" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Systematic Literature Review.</h1>
              <p>Web for the creation of systematic literature reviews for the University of Cádiz, based on Mendeley</p>
              <p><g:link class="btn btn-lg btn-primary" role="button" controller="login">Sign up today</g:link> <g:link class="btn btn-lg btn-success" role="button" controller="register">Register now</g:link></p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
          <img class="img-circle" src="https://pbs.twimg.com/profile_images/876736380801568768/ld3Nygxz.jpg" alt="Generic placeholder image" width="140" height="140">
          <h2>Universidad de Cádiz</h2>
          <p>Systematic Literature Review is a project created in the <a href="http://esingenieria.uca.es/">High School of Engineering</a> from University of Cádiz.</p>
          <!--<p><a class="btn btn-default" href="#" role="button">Ver más &raquo;</a></p> -->
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-rounded" src="${resource(dir:'images/index', file:'imgHeader5.png')}" alt="Generic placeholder image" width="140" height="140">
          <h2>Group SPI&FM</h2>
          <p>The members of the group <a href="http://tic195.uca.es/">SPI & FM</a> need a tool for the automation of the creation of the systematic literature reviews.</p>
          <!--<p><a class="btn btn-default" href="#" role="button">Ver más &raquo;</a></p>-->
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="${resource(dir:'images/index', file:'imgHeader1.png')}" alt="Generic placeholder image" width="140" height="140">
          <h2>Parallel Searchs</h2>
          <p>You can do a lot of searchs in several engines of searchs that the aplication proposes. You must only choose the engine's parameters and the web will do the work for you.</p>
          <!--<p><a class="btn btn-default" href="#" role="button">Ver más &raquo;</a></p>-->
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->
	  <div class="row">
        <div class="col-lg-4">
          <img class="img-rounded" src="${resource(dir:'images/index', file:'imgHeader3.png')}" alt="Generic placeholder image" width="140" height="140">
          <h2>Mendeley</h2>
          <p>All references founds will be imported directly in your account of <a href="https://www.mendeley.com/">Mendeley</a>. You can also synchronizate between both plataforms of a simple and confortable way.</p>
          <!--<p><a class="btn btn-default" href="#" role="button">Ver más &raquo;</a></p>-->
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="${resource(dir:'images/index', file:'imgHeader4.png')}" alt="Generic placeholder image" width="140" height="140">
          <h2>Google Chart</h2>
          <p>The web application offers to the user the posibility of create graphs for extract finals conclusions of SLR. These SLR are created with the API of <a href="https://developers.google.com/chart/">Google Chart</a>.</p>
          <!--<p><a class="btn btn-default" href="#" role="button">Ver más &raquo;</a></p>-->
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="${resource(dir:'images/index', file:'imgHeader6.ico')}" alt="Generic placeholder image" width="140" height="140">
          <h2>About us</h2>
          <p>You can click <g:link controller="index" action="about">here</g:link> for know more about this web.</p>
          <!--<p><a class="btn btn-default" href="#" role="button">Ver más &raquo;</a></p>-->
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->

      <!-- START THE FEATURETTES -->
<!-- 
       <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">Búsquedas en paralelo. <span class="text-muted"></span></h2>
          <p class="lead">Puedes realizar varias búsquedas en los diferentes motores de búsquedas que proponemos. Sólo tienes que indicar tus parámetros de búsqueda y la web lo hará por tí.</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" src="${resource(dir:'images/index', file:'imgHeader1.png')}" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading">Sincronización Mendeley<span class="text-muted"></span></h2>
          <p class="lead">Todas las referencias bibliográficas encontradas serán importadas directamente en tu cuenta de Mendeley. Además, podrás sincronizar entre ambas plataformas de una forma fácil y cómoda.</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="featurette-image img-responsive center-block" src="${resource(dir:'images/index', file:'imgHeader3.png')}" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">Google Chart<span class="text-muted"></span></h2>
          <p class="lead">La aplicación web ofrece al usuario gráficos para facilitar la extracción de conclusiones en una revisión sistemática. Dichos gráficos están realizados gracias a la API de Google Chart.</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" src="${resource(dir:'images/index', file:'imgHeader4.png')}" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">
 -->
      <!-- /END THE FEATURETTES -->

		<hr class="featurette-divider">

      <!-- FOOTER -->
      <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; <script>document.write(new Date().getFullYear())</script> Universidad de Cádiz. &middot; <!-- <a href="#">Privacy</a> &middot; <a href="#">Terms</a> --></p>
      </footer>

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="bower_components/bootstrap/js/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="bower_components/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
