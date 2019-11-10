/** Path: theme  styles_udea.' **/
/*
 * @author    Monica Diaz - Leonardo Pérez
 * @package   theme_aardvark_ministerio_udea
 * @license   http://www.gnu.org/copyleft/gpl.html GNU GPL v3 or later
/*

 /* ESTILOS PARA REDIMENSIONAR EL ANCHO DE LOS BLOQUES IZQUIERDO Y CENTRAL*/

 /*
 estilos para el curso novedades moodle 2.
 */

 .cambios_cursos {
 background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=cambios_moodle%2Fbckg_image) top right repeat-y transparent;
  -webkit-box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
  -moz-box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
  box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
  margin: 10px;
 }

.cambios_cursos h2 {
	color: #3D3C42;
}

.cambios_cursos h3 {
  color: #6A754A;
  font-size: 16px;
  line-height: 18px;
 }

 .cambios_cursos .section_cursos:nth-of-type(odd) {
	background-color: rgba(61, 60, 66, 0.8);
	color: #fff;
}

 .cambios_cursos .section_cursos:nth-of-type(odd) h2 {
 color:#FBB44F;
 }
.cambios_cursos .section_cursos:nth-of-type(odd) h3 {
 color:#FBB44F;
 }

 .cambios_cursos .section_cursos:nth-of-type(odd) a.subir:link, .cambios_cursos .section_cursos:nth-of-type(odd) a.subir:active, .cambios_cursos .section_cursos:nth-of-type(odd) a.subir:visited {
 color:#FBB44F;
 }


.cambios_cursos .section_cursos:nth-of-type(even) {
	background-color: rgba(255,255,255,0.8);
}
.cambios_cursos .section_cursos{
	  padding: 30px 30px 60px 30px;
	  position: relative;
}
.cambios_cursos #intro {
													/*background-color:#5F3A8C;*/
													background-color:#CFC5DD;
	padding-bottom: 60px;
}

.cambios_cursos  #intro ul li p a{
	font-size: 18px;
	font-weight: normal;
}

.cambios_cursos  #intro ul li {
	list-style-type: none;
	margin-top: 25px;
}

.cambios_cursos  #intro ul li a:link, .cambios_cursos  #intro ul li a:visited, .cambios_cursos  #intro ul li a:active {
	color: #37215A;;
	text-decoration: none;
}

.cambios_cursos  #intro .fa-pencil:before {
    font-size: 22px;
}

.cambios_cursos  #intro ul li a:hover {
	color: #5F3A8C;
	text-decoration: underline;
}


.cambios_cursos .section_cursos .float_left img{
	float: left;
	margin-right: 20px;
	box-shadow: -2px 2px 4px #BA7152;
}

.cambios_cursos .section_cursos  #dark_bgrnd.float_left img {
	box-shadow: -2px 2px 4px #DBD4C8;
}

.cambios_cursos .section_cursos .float_right img{
	float: right;
	margin-left: 20px;
	box-shadow: 2px 2px 4px #DBD4C8;
}

.cambios_cursos .section_cursos .no_float img {
	box-shadow: 0px -1px 3px 0px #D3D7DB;
}
.cambios_cursos .section_cursos .no_float.tiles {
	display: table;
}
/*.cambios_cursos .section_cursos .no_float.tiles li {
  display: inline-block;
  width: 290px;
  min-height:180px;
  padding: 5px 5px;
  float: left;
  margin: 5px;
  background-color: #F2F0CC;
  box-shadow:0px 0px 5px 0px #6A754A;
  color: #353739;
}

.cambios_cursos .section_cursos .no_float.tiles li strong {
  display: block;
  text-transform:uppercase;
  width:295px;
  margin-top: -5px;
  margin-left: -5px;
  padding: 3px 0px 2px 6px;
  color: #FBC71C;
  background-color: #353739;

}*/

.cambios_cursos #section1.section_cursos .no_float.tiles li {
  display: block;
  min-height: 0;
  padding: 10px 9px;
  margin: 15px auto;
  background-color: #D3D7DB;
  box-shadow: 1px 1px 2px 0px #D3D7DB;
  color: #3D3C42;
  position: relative;
  float: none;
  width: auto;
  border-radius: 2px;
}

.cambios_cursos #section1.section_cursos .no_float.tiles li strong {
  display: inline;
  text-transform: uppercase;
  color: #3D3C42;
  background-color: transparent;
  width: auto;
}

.pit_tooltip {
	cursor: pointer;
}

.cambios_cursos .tooltip_tiles ul li {
  float: left;
  display: block;
  background-color: #E6E1D4;
  padding: 0;
  margin: 15px;
  border-radius: 4px;
  width: 115px;
  height:45px;
  text-align: center;
  box-shadow: 1px 1px 2px 0px #ffffff;
  position: relative;
}

.cambios_cursos .tooltip_tiles ul li span.pit_tooltip {
  padding: 5px;
  color: #3D3C42;
}
.cambios_cursos .tooltip_tiles ul li span.pit_tooltip.twolines {
  padding: 2px;
  color: #3D3C42;
  position: absolute;
  top: 0;
  left: 0;
}

.cambios_cursos .tooltip_tiles ul li span.pit_tooltip.oneline {
  padding: 13px 0;
  color: #3D3C42;
  position: absolute;
  top: 0;
  left: 0;
  right:0
}

.cambios_cursos .tooltip-inner {
  width: 270px;
  max-width: 300px;
  padding: 8px;
  color: #60605F;
  text-align: center;
  text-decoration: none;
  background-color: #fafafa;
  -webkit-border-radius: 6px;
  -moz-border-radius: 6px;
  border-radius: 6px;
  border: 1px solid #FBB44F;
  position: relative;
  top: 4px;
  font-size: 13px;
  left: -84px;
}

.cambios_cursos .tooltip.in {
	opacity: 0.98;
}

.cambios_cursos .tooltip.top .tooltip-arrow {
	display: none;
	border-top-color: #FBB44F;
	bottom: -3px;
	border-width: 9px 7px 0;
}

.cambios_cursos .tooltip.top {
  margin-top: -5px;
}


 /*********************************************************************************************************************************/
 .cambios_plataforma {
 background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=cambios_moodle%2Fbckg_image) top right repeat-y transparent;
  -webkit-box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
  -moz-box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
  box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
  margin: 10px;
 }

.cambios_plataforma h2 {
	color: #096020;
}

.cambios_plataforma h3 {
  color: #6A754A;
  font-size: 16px;
  line-height: 18px;
 }

 .cambios_plataforma .section_plataforma:nth-of-type(odd) {
	background-color: rgba(195, 218, 189 , 0.8);
}

.cambios_plataforma .section_plataforma:nth-of-type(even) {
	background-color: rgba(255,255,255,0.8);
}
.cambios_plataforma .section_plataforma{
	  padding: 30px 30px 60px 30px;
	  position: relative;
}
.cambios_plataforma .section_plataforma::before {
  content: "";
  background-color: #67880C;
  height: 4px;
  width: 500px;
  position: absolute;
  left: -1px;
  top: -2px;
}
.cambios_plataforma #intro {
																/*background-color:#0C8A2D;*/
																background-color:#C3DABD;
	padding-bottom: 60px;
}

.cambios_plataforma  #intro::before, .cambios_plataforma  #section1::before {
	content: none;
}

.cambios_plataforma  #intro ul li p a{
	font-size: 18px;
	font-weight: normal;
}

.cambios_plataforma  #intro ul li {
	list-style-type: none;
	margin-top: 25px;
}

.cambios_plataforma  #intro ul li a:link, .cambios_plataforma  #intro ul li a:visited, .cambios_plataforma  #intro ul li a:active {
	color: #01632F;
	text-decoration: none;
}

.cambios_plataforma  #intro .fa-pencil:before {
    font-size: 22px;
}

.cambios_plataforma  #intro ul li a:hover {
	color: #779E27;
	text-decoration: underline;
}


.cambios_plataforma .section_plataforma .float_left img{
	float: left;
	margin-right: 20px;
	box-shadow: -2px 2px 4px #31524E;
}

.cambios_plataforma .section_plataforma .no_float img {
	box-shadow: 0px -1px 3px 0px #31524E;
}

.cambios_plataforma .section_plataforma .three-column {
	-webkit-column-count: 3; /* Chrome, Safari, Opera */
    -moz-column-count: 3; /* Firefox */
    column-count: 3;
	padding: 0;
}

.cambios_plataforma .section_plataforma .no_float.tiles {
	display: table;
}


.cambios_plataforma .section_plataforma .no_float.tiles li {
  display: inline-block;
  width: 290px;
  min-height:180px;
  padding: 5px 5px;
  float: left;
  margin: 5px;
  background-color: #C3DABD;
  box-shadow:0px 0px 5px 0px #31524E;
  color: #3E2E36;
}

.cambios_plataforma .section_plataforma .no_float.tiles li strong {
  display: block;
  text-transform:uppercase;
  width:295px;
  margin-top: -5px;
  margin-left: -5px;
  padding: 3px 0px 2px 6px;
  color: #DBD56E;
  background-color: #223B45;

}

.cambios_plataforma .section_plataforma .three-column h3{
  color: #FBC71C;
  font-size: 16px;
  line-height: 16px;
}

.cambios_plataforma .section_plataforma .float_right img{
	float: right;
	margin-left: 20px;
	box-shadow: 2px 2px 4px #31524E;
}
.cambios_plataforma #section1.section_plataforma .float_right{
  max-width: 700px;
  margin: auto;
}
.cambios_plataforma .section_plataforma .float_right .small_div{
  max-width: 300px;
  float: right;
}

/*********************************************************************************************************************************/
 /*********************************************************************************************************************************/
 .cambios_informacion {
 background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=cambios_moodle%2Fbckg_image) top right repeat-y transparent;
  -webkit-box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
  -moz-box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
  box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
  margin: 10px;
 }

.cambios_informacion h2 {
	color: #115262;
}

.cambios_informacion h3 {
  color: #115262;
  font-size: 16px;
  line-height: 18px;
 }

 .cambios_informacion .section_informacion:nth-of-type(odd) {
	background-color: rgba(195, 222, 234, 0.8);
	color: #fff;
}

/*.cambios_informacion .section_informacion:nth-of-type(odd) h2 {
	color:#F2EBE8;
}*/

.cambios_informacion .section_informacion:nth-of-type(even) {
	background-color: rgba(255,255,255,0.8);
}

/*.cambios_informacion .section_informacion:nth-of-type(odd) a.subir:link, .cambios_informacion .section_informacion:nth-of-type(odd) a.subir:active, .cambios_informacion .section_informacion:nth-of-type(odd) a.subir:visited {
 color:#F2EBE8;
 }*/

.cambios_informacion .section_informacion{
	  padding: 30px 30px 60px 30px;
	  position: relative;
}

.cambios_informacion #intro {
																					/*background-color:#2EAADC;*/
																					background-color:#C3DEEA;
	padding-bottom: 60px;
}


.cambios_informacion  #intro ul li p a {
	font-size: 18px;
	font-weight: normal;
}

.cambios_informacion  #intro ul li {
	list-style-type: none;
	margin-top: 25px;
}

.cambios_informacion  #intro ul li a:link, .cambios_informacion  #intro ul li a:visited, .cambios_informacion  #intro ul li a:active {
	color: #115262;
	text-decoration: none;
}

.cambios_informacion  #intro .fa-pencil::before {
    font-size: 22px;
}

.cambios_informacion  #intro ul li a:hover {
	color: #172280;
	text-decoration: underline;
}


.cambios_informacion .section_informacion .float_left img{
	float: left;
	margin-right: 20px;
	box-shadow: -2px 2px 4px #6A754A;
}

.cambios_informacion .section_informacion .no_float img {
	box-shadow: 0px -1px 3px 0px #6A754A;
}

.cambios_informacion .section_informacion .three-column {
	-webkit-column-count: 3; /* Chrome, Safari, Opera */
    -moz-column-count: 3; /* Firefox */
    column-count: 3;
	padding: 0;
}

.cambios_informacion #section2.section_informacion .no_float img {
	box-shadow: none;
}

.cambios_informacion #section2.section_informacion .no_float{
	max-width: 750px;
	padding: 0;
	box-shadow: -2px 0px 3px 0px #FFFFFF;
	background-color: #F2EBE8;
	color: #0D1240;
	margin-top: 35px;
}

.cambios_informacion #section2.section_informacion .no_float div {
	padding: 15px;
	padding-top: 5px;
}

.cambios_informacion #section2.section_informacion .no_float.left{
	float: left;
	clear: both;
}

.cambios_informacion #section2.section_informacion .no_float.right{
	float: right;
	clear: both;
}

.cambios_informacion #section2.section_informacion .no_float h3 {
  color: #172280;
  font-size: 16px;
  line-height: 18px;
}


.cambios_informacion .section_informacion .no_float.tiles {
	display: table;
}


.cambios_informacion .section_informacion .no_float.tiles li {
  display: inline-block;
  width: 290px;
  min-height:180px;
  padding: 5px 5px;
  float: left;
  margin: 5px;
  background-color: #F2F0CC;
  box-shadow:0px 0px 5px 0px #6A754A;
  color: #353739;
}

.cambios_informacion .section_informacion .no_float.tiles li strong {
  display: block;
  text-transform:uppercase;
  width:295px;
  margin-top: -5px;
  margin-left: -5px;
  padding: 3px 0px 2px 6px;
  color: #FBC71C;
  background-color: #353739;

}

.cambios_informacion .section_informacion .three-column h3{
  color: #FBC71C;
  font-size: 16px;
  line-height: 16px;
}

.cambios_informacion .section_informacion .float_right img{
	float: right;
	margin-left: 20px;
	box-shadow: 2px 2px 4px #6A754A;
}

/*********************************************************************************************************************************/


a.subir {
  position: absolute;
  bottom: 8px;
  left: 7px;
  font-weight: bold;
}

 /*********************************************************************************************************************************/
 .cambios_actividades {
 background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=cambios_moodle%2Fbckg_image) top right repeat-y transparent;
  -webkit-box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
  -moz-box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
  box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
  margin: 10px;
 }

.cambios_actividades h2 {
	color: #6A754A;
}

.cambios_actividades h3 {
  color: #6A754A;
  font-size: 16px;
  line-height: 18px;
 }

 .cambios_actividades .section_actividades:nth-of-type(odd) {
	background-color: rgba(254, 248, 231 , 0.8);
}

.cambios_actividades .section_actividades:nth-of-type(even) {
	background-color: rgba(255,255,255,0.8);
}
.cambios_actividades .section_actividades{
	  padding: 30px 30px 60px 30px;
	  position: relative;
}
.cambios_actividades .section_actividades:before {
  content: "";
  background-color: #e7501E;
  height: 4px;
  width: 500px;
  position: absolute;
  left: -1px;
  top: -2px;
}
.cambios_actividades #intro {
													/*background-color:#FDC61A;*/
													background-color:#F9EAC1;
	padding-bottom: 60px;
}

.cambios_actividades  #intro:before {
	content: none;
}

.cambios_actividades  #intro ul li p a{
	font-size: 18px;
	font-weight: normal;
}

.cambios_actividades  #intro ul li {
	list-style-type: none;
	margin-top: 25px;
}

.cambios_actividades  #intro ul li a:link, .cambios_actividades  #intro ul li a:visited, .cambios_actividades  #intro ul li a:active {
	color: #353739;
	text-decoration: none;
}

.cambios_actividades  #intro .fa-pencil:before {
    font-size: 22px;
}

.cambios_actividades  #intro ul li a:hover {
	color: #C24022;
	text-decoration: underline;
}


.cambios_actividades .section_actividades .float_left img{
	float: left;
	margin-right: 20px;
	box-shadow: -2px 2px 4px #6A754A;
}

.cambios_actividades .section_actividades .no_float img {
	box-shadow: 0px -1px 3px 0px #6A754A;
}

.cambios_actividades .section_actividades .three-column {
	-webkit-column-count: 3; /* Chrome, Safari, Opera */
    -moz-column-count: 3; /* Firefox */
    column-count: 3;
	padding: 0;
}

.cambios_actividades #section2.section_actividades .no_float img {
	box-shadow: none;
}

.cambios_actividades #section2.section_actividades .no_float{
	max-width: 750px;
	padding: 0;
	box-shadow: -2px 0px 3px 0px #6A754A;
												/*background-color: rgb(53, 55, 57);*/
												background-color: #B17B1E;
	color: #F2F0CC;
	margin-top: 35px;
}

.cambios_actividades #section2.section_actividades .no_float div {
	padding: 15px;
}

.cambios_actividades #section2.section_actividades .no_float.left{
	float: left;
	clear: both;
}

.cambios_actividades #section2.section_actividades .no_float.right{
	float: right;
	clear: both;
}

.cambios_actividades #section2.section_actividades .no_float h3 {
  color: #FBC71C;
  font-size: 16px;
  line-height: 18px;
}


.cambios_actividades .section_actividades .no_float.tiles {
	display: table;
}


.cambios_actividades .section_actividades .no_float.tiles li {
  display: inline-block;
  width: 290px;
  min-height:180px;
  padding: 5px 5px;
  float: left;
  margin: 5px;
  background-color: #FDF9EB;
  box-shadow:0px 0px 5px 0px #6A754A;
  color: #353739;
}

.cambios_actividades .section_actividades .no_float.tiles li strong {
  display: block;
  text-transform:uppercase;
  width:295px;
  margin-top: -5px;
  margin-left: -5px;
  padding: 3px 0px 2px 6px;
  color: #FBC71C;
  background-color: #353739;

}

.cambios_actividades .section_actividades .three-column h3{
  color: #FBC71C;
  font-size: 16px;
  line-height: 16px;
}

.cambios_actividades .section_actividades .float_right img{
	float: right;
	margin-left: 20px;
	box-shadow: 2px 2px 4px #6A754A;
}
.cambios_actividades #section1.section_actividades .float_right{
  max-width: 700px;
  margin: auto;
}
.cambios_actividades .section_actividades .float_right .small_div{
  max-width: 300px;
  float: right;
}



 /*
 fin novedades moodle 2.7
 */



 /******************************************************************************************************/
/******** estilos Curso Nuevo TIC: Inicio 2015-09-28 *********/
/******************************************************************************************************/

#pit_tic_body, .pit_tic_body  {
	font-family: Arial, Helvetica, sans-serif;
	font-size:13px;
	padding: 10px;
	background-image: url(img/bg.png);
	background-repeat: no-repeat;
	background-position: right top;
	line-height:20px;
	text-align:justify;
	color: #444;
	margin:auto;
	text-decoration:none;
}

#pit_tic_body *, .pit_tic_body  *{
	font-family: Arial, Helvetica, sans-serif;
	font-size:13px;
	line-height:20px;
	text-align:justify;
	color: #444;
}

#pit_tic_body h2, .pit_tic_body  h2{
    border-bottom-width: 2px;
    border-bottom-style: solid;
    border-bottom-color: #bfbfbf;
    margin-right: 150px;
    padding: 11px;
    color: #e47a62;
    text-align: left;
    font-size: 25px;
    display: block;
}

#pit_tic_body h3, , .pit_tic_body h3{
    color: #e47a62;
    text-align: left;
    font-size: 22px;
    font-variant: small-caps;
    font-weight: bold;
    border-bottom-width: 2px;
    border-bottom-style: solid;
    border-bottom-color: #B7B7B7;
    clear: both;
    padding-top: 40px;
}


#pit_tic_body h3, .pit_tic_body  h3 {
	color: #299495;
    text-align: left;
    font-size: 18px;
    font-variant: small-caps;
    font-weight: bold;
    border-bottom-width: 2px;
    border-bottom-style: solid;
    border-bottom-color: #B7B7B7;
    clear: both;
    padding-top: 20px;
}

#pit_tic_body ul li , .pit_tic_body ul li{
    list-style: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=curso_tic%2Ficonlist);
    padding-bottom: 10px;
    padding-top: 10px;
    margin-left: 30px;
    font-weight: bold;
    color: #666;
}

#pit_tic_body ul li ul li, .pit_tic_body  ul li ul li{
	list-style:url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=curso_tic%2Fic_li-04-05);
}


#pit_tic_body .pit_tic_recuerde , .pit_tic_body .pit_tic_recuerde{
    background-color: #EAEAEA;
    margin: 60px 35px;
    padding: 20px;
	position:relative;
}

#pit_tic_body .pit_tic_recuerde, #pit_tic_body .pit_tic_recuerde *, .pit_tic_body .pit_tic_recuerde, .pit_tic_body .pit_tic_recuerde *{
	font-size: 14px;
    color: #666;
}

#pit_tic_body .pit_tic_recuerde::before, .pit_tic_body .pit_tic_recuerde::before {
    content: " ";
    height: 35px;
    width: 262px;
    background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=curso_tic%2Ftit-tengaencuenta);
    position: absolute;
    top: -38px;
    left: -20px;
}


#pit_tic_body .pit_tic_nota, .pit_tic_body .pit_tic_nota{
    width: 60%;
    margin-top: 45px;
    margin-right: auto;
    margin-bottom: 55px;
    margin-left: auto;
    font-weight: bold;
    padding-top: 20px;
    padding-right: 15px;
    padding-bottom: 15px;
    padding-left: 15px;
    clear: both;
	position: relative;
	padding: 20px;
    font-size: 13px;
    background-color: rgba(34,34,34,0.5);
	display: block;
	color: #FFF;
}

#pit_tic_body .pit_tic_nota em, .pit_tic_body .pit_tic_nota em {
	color: #444;
}

#pit_tic_body .pit_tic_nota strong, .pit_tic_body .pit_tic_nota strong{
	font-weight:bold;
	color: #f7b9a0;
	font-size: 15px;
}

#pit_tic_body .pit_tic_nota::before, .pit_tic_body .pit_tic_nota::before{
	content:" ";
	background-image: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=curso_tic%2Fbg_nota);
	background-repeat: repeat-x;
	position: absolute;
	height: 29px;
	top: -20px;
	left: -15px;
	right: -15px;
	z-index: -1;
}

#pit_tic_body .pit_tic_nota::after , .pit_tic_body .pit_tic_nota::after {
	border-bottom-width: 3px;
    border-bottom-style: dotted;
    border-bottom-color: #51c3bb;
	content:" ";
	position: absolute;
	height: 10px;
	bottom: -20px;
	left: -16px;
	right: -16px;
	opacity: 1;
}


#pit_tic_body .pit_tic_tabla table , .pit_tic_body .pit_tic_tabla table {
	border: 1px solid #7b8e92;
    margin: auto;
    border-collapse: collapse;
    border-spacing: 1px 1px;
}
#pit_tic_body .pit_tic_tabla th, .pit_tic_body .pit_tic_tabla th{
    border: 1px #aeadae solid;
    background-color: #53a9ad;
    font-size: medium;
    font-weight: bold;
    padding: 3px;
    color: #ffffff;
}
#pit_tic_body .pit_tic_tabla td, .pit_tic_body .pit_tic_tabla td{
    border: 1px #aeadae solid;
    background-color: #ffffff;
    font-size: small;
    padding: 3px;
    color: #333333;
}
#pit_tic_body .pit_tic_tabla tr:nth-child(odd) td, .pit_tic_body .pit_tic_tabla tr:nth-child(odd) td{
    background-color: #f2f2f2;
}
#pit_tic_body .pit_tic_tabla td em, .pit_tic_body .pit_tic_tabla td em{
	font-size:small;font-style:normal;
	font-weight:bold;
	color:#333333;
}
.glossarypost .entry {
  display: table-cell;
  background-color: #EFF2F5;
  padding: 0px;
  font-size: 10pt;
  color: #4e4b49;
  text-align: left;
  margin-left: 10px;
}

.glossarypost.dictionary .entry .concept, .glossarypost.dictionary .entry .concept * {
  background-color: #ffffff;
  margin: 0;
  padding: 0;
}

.glossarypost {
	box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
	border-radius: 3px;
}


@media (max-width: 480px) {
	.pit_presentacion img {
		display: none;
	}
	.pit_presentacion > div.texto  ul{
    margin-left: 0;
	}
	.pit_presentacion > div.texto  ul li{
    margin-top: 9px;
}
}


/******************************************************************************************************/
/******** estilos Curso Nuevo TIC: Fin 2015-09-28 *********/
/******************************************************************************************************/



 a:hover{
	color:#008e6a;
 }

 #inst3.block .content{
 background-image: none;
 }
 /*.row-fluid .span3{margin-left: 2.27%;}*/

 @media(min-width:1200px){
	.empty-region-side-post.used-region-side-pre #region-main.span8,.jsenabled.docked-region-side-post.used-region-side-pre

	#region-main.span8{width:80.35897435897436%;*width:80.30578286961266%}

	.row-fluid .span9{width:80.35897435897436%;*width:80.30578286961266%}

	.row-fluid .span3{width:18.076923076923077%;*width:18.023731587561375%; margin-left: 1.564102564102564%;}

	.empty-region-side-post.used-region-side-pre #block-region-side-pre.span4,.jsenabled.docked-region-side-post.used-region-side-pre #block-region-side-pre.span4
	{width:18.076923076923077%;*width:18.023731587561375%}

	.row-fluid .span4{width:25.623931623931625%;*width:25.570740134569924%}

	.row-fluid .span8{width:72.81196581196582%;*width:70.75877432260411%}

	.empty-region-side-post.used-region-side-pre #block-region-side-pre.span4, .jsenabled.docked-region-side-post.used-region-side-pre #block-region-side-pre.span4{
	margin-left:12px;
	}

}

 @media(min-width:768px) and (max-width:979px){
	.empty-region-side-post.used-region-side-pre #region-main.span8,.jsenabled.docked-region-side-post.used-region-side-pre #region-main.span8{width:79.30939226519337%;*width:79.25620077583166%}

	.row-fluid .span3{width:17.92817679558011%;*width:17.87498530621841%;}

	.row-fluid .span9{width:79.30939226519337%;*width:79.25620077583166%}

	.empty-region-side-post.used-region-side-pre #block-region-side-pre.span4,.jsenabled.docked-region-side-post.used-region-side-pre #block-region-side-pre.span4{width:17.92817679558011%;*width:17.87498530621841%}

}

@media(min-width:1200px) and (max-width:1600px){
	#course-category-listings.columns-3 #category-listing,#course-category-listings.columns-3 #course-listing{width:48.717948717948715%;*width:48.664757228587014%;margin-left:1.564102564102564%;*margin-left:2.5109110747408616%}
}

 /***** estilos leo para modales personalizados: Inicio 2015-04-07 ***/
  #launcher_plataforma:hover{
	background-color: rgba(26, 81, 38,0.15);
 }
  #launcher_informacion:hover{
	background-color: rgba(36, 74, 87,0.15);
 }

 #launcher_actividades:hover{
	background-color: rgba(166, 78, 38,0.15);
 }

  #launcher_cursos:hover{
	background-color: rgba(87, 33, 104,0.15);
 }

 .modal-backdrop {
  z-index: 6000;
}

 .modal {
	  z-index: 6001;
 }

 div.modal.modal_950px.fade.in .modal-body {
  padding: 0 10px;
}

 div.modal.modal_950px.fade.in .modal-header h4.modal-title {
  margin: 0;
  padding: 10px 18px;
}

 div.modal.modal_950px.fade.in .modal-header {
  padding: 0;
  height: 35px;
}


 div.modal.modal_950px.fade.in .modal-header .close {
  margin: 5px 10px;
  padding: 0;
  font-size: 35px;
  line-height: 25px;
}

 @media(min-width:980px){

 div.modal.modal_950px.fade.in {
  width: 950px;
  left: 50%;
  top: 15px;
  bottom: 15px;
  margin-left: -476px;
}


 div.modal.modal_950px.fade.in .modal-body {
  position: fixed;
  max-width: 920px;
  padding: 0 15px;
  overflow-y: auto;
  bottom: 25px;
  top: 52px;
  max-height: 3000px;
}
}


@media (min-width: 768px) and (max-width: 979px) {

 div.modal.modal_950px.fade.in {
  width: 748px;
  left: 50%;
  top: 15px;
  bottom: 15px;
  margin-left: -374px;
}


 div.modal.modal_950px.fade.in .modal-body {
  position: fixed;
  max-width: 728px;
  overflow-y: auto;
  bottom: 25px;
  top: 52px;
  max-height: 3000px;
}
}

/***** estilos leo para modales personalizados: Fin 2015-04-07***/

/******************************************************************************************************/
/******** estilos cambios Diploma salud sexual para docentes de secundaria: Inicio 2015-08-12 *********/
/******************************************************************************************************/





 div#pit_emss_body.pit_emss_presentacion {
    background: #b3b3b3;
    background: -moz-linear-gradient(top, #b3b3b3 1%, #ffffff 15%);
    background: -webkit-gradient(linear, left top, left bottom, color-stop(1%,#b3b3b3), color-stop(15%,#ffffff));
    background: -webkit-linear-gradient(top, #b3b3b3 1%,#ffffff 15%);
    background: -o-linear-gradient(top, #b3b3b3 1%,#ffffff 15%);
    background: -ms-linear-gradient(top, #b3b3b3 1%,#ffffff 15%);
    background: linear-gradient(to bottom, #b3b3b3 1%,#ffffff 15%);
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#b3b3b3', endColorstr='#ffffff',GradientType=0 );
    padding: 40px 30px 10px 45px;
    position: relative;
    border-radius: 10px 10px 25px 25px;
    box-shadow: 2px 3px 6px 0px #B3B3B3;
    margin: 90px 6px 10px 120px;
}


div#pit_emss_body.pit_emss_presentacion > img {
    position: absolute;
    top: -37px;
    left: -131px;
}

div#pit_emss_body.pit_emss_presentacion > p {
    font-size: 10pt;
    color: #333333;
    font-family: verdana,arial,sans-serif;
    line-height: 13pt;
}

div#pit_emss_body.pit_emss_presentacion>p.pit_emss_horas {
    font-weight: bold;
    color: #96B300;
    text-align: right;
    font-size: 11pt;
}

#pit_emss_body h2 {
    font-weight: normal;
    font-size: 28px;
    font-family: "trebuchet MS";
    letter-spacing: -0.2px;
	color: #6B6B6B;
}


/******************************************************************************************************/
/******** estilos cambios Diploma salud sexual para docentes de secundaria: Final 2015-08-12 *********/
/******************************************************************************************************/



 html, body {
	font-family: Arial, Verdana, Helvetica, sans-serif;
	/*background-color:#ffffff;*/
	font-size:12px;
	/*background-image: -webkit-gradient(linear, left bottom, left top, color-stop(0.33, rgb(206, 229, 229)), color-stop(0.67, rgb(255, 255, 255)));
    background-image: -moz-linear-gradient( center bottom, rgb(206, 229, 229) 33%, rgb(255, 255, 255) 67%);
    filter: progid:DXImageTransform.Microsoft.gradient(endColorstr='#45A2BB', startColorstr='#cfebd5');*/
	background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=header%2Fintegratic_bckg_image) left bottom no-repeat;


}

div#page {
    background:rgba(252, 255, 255,0.92);
	margin-top:-11px;
	padding-top:11px
}

.pagelayout-secure >header.navbar{
    display: none;
}

.navbar {
    background-color: #fff;
}

.navbar .navbar-inner.affix .nav>li>a{
    width: 100%;
}


::-webkit-scrollbar{
background-color: #fff;
}

::-webkit-scrollbar-thumb {
    background-color: #008e6a;
    border: 0px;
}




/*Estilos para el boton entrar*/


.btn{
background: none;
color: #000;
/*border:none;*/
/*padding-right:138px;*/
font-style: italic;

}

.btn:hover{
background:none;
color: #008e6a;
}

.btn-primary{
	color: #fff;
    text-shadow: 0 -1px 0 rgba(0,0,0,.25);
    background-color: #005aa8;
    background-image: -moz-linear-gradient(top,#0070a8,#0038a8);
    background-image: -webkit-gradient(linear,0 0,0 100%,from(#0070a8),to(#0038a8));
    background-image: -webkit-linear-gradient(top,#0070a8,#0038a8);
    background-image: -o-linear-gradient(top,#0070a8,#0038a8);
    background-image: linear-gradient(to bottom,#0070a8,#0038a8);
    background-repeat: repeat-x;
    border-color: #0038a8 #0038a8 #001e5c;
    border-color: rgba(0,0,0,.1) rgba(0,0,0,.1) rgba(0,0,0,.25);
    filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
}

.btn-primary:hover{
	color: #fff;
    text-shadow: 0 -1px 0 rgba(0,0,0,.25);
    background-color: #005aa8;
    background-image: -moz-linear-gradient(top,#0070a8,#0038a8);
    background-image: -webkit-gradient(linear,0 0,0 100%,from(#0070a8),to(#0038a8));
    background-image: -webkit-linear-gradient(top,#0070a8,#0038a8);
    background-image: -o-linear-gradient(top,#0070a8,#0038a8);
    background-image: linear-gradient(to bottom,#0070a8,#0038a8);
    background-repeat: repeat-x;
    border-color: #0038a8 #0038a8 #001e5c;
    border-color: rgba(0,0,0,.1) rgba(0,0,0,.1) rgba(0,0,0,.25);
    filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
}


button{
    background: transparent;
    border: 0px;
    box-shadow: none;
    text-decoration: none;
    text-shadow: none;
}

button:hover{
	background: transparent;
	color:#008e6a;

}
.navbar .navbar-inner.affix button{
    background: transparent;
	color:#fff;
    border: 0px;
    box-shadow: none;
    text-decoration: none;
    text-shadow: none;
}

.nav-collapse .navbar-form, .nav-collapse .navbar-search{
	border:none;
	margin:-3px;
    margin-top: 3px;
    margin-right: 153px;
	color: #008E6A;
	font-size:15px;
	font-family: arial;

}


.navbar-inner.affix + #incrementador {
    height: 47px;
}



/*Estilos para el boton entrar*/



div.block {
	padding: 0px 0px 0px 0px;
	background-color:#ffffff;
	-webkit-box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
	-moz-box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
	box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
	-webkit-border-radius: 6px;
	-moz-border-radius: 6px;
	border-radius: 6px;
	margin-right: 15px;
}


div.block .header{
	color: #fff;
	background:#008e6a;
	/*background-image: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=degradados%2Fblq_rep1);*/
	background-repeat: repeat-x;
	margin: 0;
	padding: 0px 0px 0px 0px;
	border: none;
	-webkit-border-radius: 6px 6px 0px 0px;
	-moz-border-radius: 6px 6px 0px 0px;
	border-radius: 6px 6px 0px 0px;
}
.block .header .title h2{
	font-size:14px;
	font-weight: bold;
}
.block .header .title h2:before {
	background-color: transparent;
	font-weight: normal;
}

.block .header h2 {
	color: #FFF;
	text-transform: none;
}

div.block .content{
/*background-image: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=degradados%2Fblq_arrow);*/
background-repeat: no-repeat;
padding-top:15px;
}

.course-content{
margin-left:-10px;

}

a.block{
	color: #fhfhfh;
}

nav.navbar-inner {
	background: #ffffff;
	border: 0px;
	-webkit-border-radius: 0px;
	min-height:35px;
	border-top: #008e6a solid 2px;
	margin-bottom: 11px;
	border-bottom: 1px solid #e3e3e3;

}



.profilepic {
  width: 25px;
  height: 25px;
}

.navbar-inner.affix{
	background:-webkit-gradient(linear, left top, left bottom, from(rgb(0, 142, 106)), to(rgba(0, 142, 106,.7))) transparent;
	background-image: linear-gradient(to bottom, #008e6a, #40AB8F);
	height: 34px;
	border: 0px;
	right: 0px;
	left: 0px;
	padding-top: 0px;
	border-bottom: 0px;
}

.navbar .nav-collapse.active{
	border:none;
}

.navbar .nav>li>a {
   color: #008E6A;
   font-size:16px;
   font-weight:600;
   /*padding: 8px 128px 10px 15px;*/
   padding: 8px 29px;
   background-color:transparent;


}


.navbar .nav>li>a:hover {
  color: #CDDB4D;
}

.navbar .nav li.dropdown.open > .dropdown-toggle, .navbar .nav li.dropdown.active > .dropdown-toggle, .navbar .nav li.dropdown.open.active > .dropdown-toggle{
  color: #008e6a;
  height: 8px;
}

.dropdown-menu>li>a:hover, .dropdown-menu>li>a:focus, .dropdown-submenu:hover>a, .dropdown-submenu:focus>a {
 color: #008e6a;
}

.navbar .nav li.dropdown > a:hover .caret, .navbar .nav li.dropdown > a:focus .caret, .navbar .nav li.dropdown.open > .dropdown-toggle .caret, .navbar .nav li.dropdown.active > .dropdown-toggle .caret, .navbar .nav li.dropdown.open.active > .dropdown-toggle .caret {
  border-bottom-color: #008e6a;
  border-top-color: #008e6a;
  color: #008e6a;
}

.navbar .nav > li > a:hover, .navbar .nav > li > a:focus, .navbar .nav li.dropdown.open > .dropdown-toggle, .navbar .nav li.dropdown.active > .dropdown-toggle, .navbar .nav li.dropdown.open.active > .dropdown-toggle{
 color: #008e6a;
 background-color: transparent;
}

.breadcrumb a:hover {
  color: #008e6a;
}

#breadcrumb_navbar.affix *{
	text-shadow: none;
	color: #ffffff;
}

/*Cambio en el color y grosor de la letra del navbar*/
.navbar .navbar-inner.affix .nav > li > a{
	color: #fff;
	font-weight: 200;
}


.navbar .affix .nav-collapse.active .nav .dropdown-submenu.open>a, .navbar .nav-collapse.active .nav .dropdown-menu .dropdown-submenu.open>a{
	color:#000;
	font-weight: 200;
}

.navbar  .nav-collapse.active>.nav .dropdown-menu li>a:hover{
	color:#000;
	font-weight: 200;
}


/*menu del perfil*/
ul.dropdown-menu {
    position: absolute;
    top: 100%;
    z-index: 1000;
    display: none;
    float: left;
    min-width: 160px;
    margin: 9px -16px;
    list-style: none;
    background-color: #fff;
    border: 1px solid #ccc;
    border: 1px solid rgba(0,0,0,.2);
    -webkit-border-radius: 6px;
    -moz-border-radius: 6px;
    border-radius: 6px;
    -webkit-box-shadow: 0 5px 10px rgba(0,0,0,.2);
    -moz-box-shadow: 0 5px 10px rgba(0,0,0,.2);
    box-shadow: 0 5px 10px rgba(0,0,0,.2);
    -webkit-background-clip: padding-box;
    -moz-background-clip: padding;
    background-clip: padding-box;

}

.navbar .nav-collapse.active>.nav>li>a{
	font-weight:200;

}

/*despliegue del menu para vista normal y para affix*/
.navbar .affix .nav-collapse.active>.nav .dropdown-menu li>a{
	color:#000;
	font-weight: 200;
	background:rgba(252, 255, 255,0.7);
}

.navbar  .nav-collapse.active>.nav .dropdown-menu li>a{
	color:#000;
	font-weight: 200;
}

.navbar .affix .nav li.dropdown.open > .dropdown-toggle, .navbar .nav li.dropdown.active > .dropdown-toggle, .navbar .nav li.dropdown.open.active > .dropdown-toggle{
  background-color: transparent;
  color: #fff;
}

.navbar .nav-collapse.active>.nav .dropdown-menu li>a{
  background: #fff;
  margin: 0;
}

div.category.collapsed div.info h3.categoryname {
	background-color: #FAFAFA;
	color:#ffffff;
}

/*categorias centrales*/
div.category div.info h3.categoryname {
	background-color: transparent;
	font-family: 'Roboto';
	font-weight: 400;
	text-shadow: .2px .6px 1px #e3e3e3;
}

.navbar .navbar-inner .nav > li > a:link, .navbar .navbar-inner .nav > li > a:visited; .navbar .navbar-inner .nav > li > a:active,.navbar .navbar-inner .nav > li > a {
	color:#ffffff;
}

.categoryname a:link, .categoryname a:visited, .categoryname a:active{
	color: #ffffff;
	text-transform: none;
	font-family: Roboto;
	font-weight: 400;
	font-size: 18px;
	text-shadow: none;
	color:#343434;
}

.courses .coursebox:hover, .course_category_tree .courses>.paging.paging-morelink:hover {
    background-color: #F1F1F1;
}

.courses .coursebox.even:hover, .course_category_tree .courses>.paging.paging-morelink:hover{
	background-color: transparent;
}

.courses .coursebox.even{
	background-color: #FFFFFF;
}

/*cambiar imágenes de flechas en las categorías*/
.course_category_tree .category.with_children>.info>.categoryname {
	cursor: pointer;

}

.coursebox.clearfix.even.last.collapsed{
	margin: 0px;
    background-color: transparent;
    font-family: 'Roboto';
    font-weight: 400;
    border: 1px solid transparent;
    box-shadow: none;
}

/*texto -cursos- antes de las categorias*/
#site-news-forum h2, #frontpage-course-list h2, #frontpage-category-names h2, #frontpage-category-combo h2{
	margin: 1px;
	font-family: 'Roboto', sans-serif;
	color: #008e6a;
	font-weight: 500;
	font-size: 24px;
}

/*categoria cursos*/

.course_category_tree .category>.info{
	margin: 0px;
	background-color: transparent;
	font-family: 'Roboto';
	font-weight: 400;
	border:1px solid transparent;
	box-shadow:none;
}

.course_category_tree .category>.info:hover{
    border-bottom: 1px solid #c3c3c3;
}

.courses .coursebox.collapsed{
	margin: 0px;
    background-color: transparent;
    font-family: 'Roboto';
    font-weight: 400;
    border: 1px solid transparent;
    box-shadow: none;
}


/*categoria interna flotando a la izquierda para reducir el tamaño*/
 .coursebox>.info>.coursename a{
    float: left;
    text-transform: none;
    font-size: 16px;
	background-image:none;
}


 /*categorias frontpage*/

 .course_category_tree .category>.info>.categoryname {
	margin: 2px;
	background-color: transparent;
	border-radius: 7px;
	font-family: 'Roboto';
	font-weight: 400;
	text-shadow: none;

}

.course_category_tree.frontpage-category-names .category > .info {
	margin: 0;
	background: transparent;

}



 /*cambiar imágenes de flechas en las categorías*/
 .course_category_tree .category.with_children.collapsed>.info>.categoryname{
	/*background-image: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=flechas%2Fcollapsed_empty);*/
	background-color:transparent;
 }

.course_category_tree .category.with_children>.info>.categoryname {
	cursor: pointer;
	/*background-image: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=flechas%2Fexpandedcategoria);*/
	background-color:transparent;
}


 /*categorias colapsadas*/
 div.category.collapsed div.info h3.categoryname{
	background-color: #transparent;
	color:#343434;
 }

 /*Lista desplegable al darle clic a las categorías*/
 .singleselect form, .singleselect select{
	width: 100%;
 }


 /*mis cursos*/

 .pagelayout-incourse #region-main, .pagelayout-mydashboard #region-main {
	border: 0px;
	box-shadow: none;
	background: transparent;
 }

/*cambios en la miga de pan*/
.breadcrumb {
	/*margin-top:5px;
	padding: 7px;
	border: 1px solid #e3e3e3;
	background-color:#ffffff;
	border-radius: 6px;
	-webkit-box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
	-moz-box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
	box-shadow: 0px 0px 7px 0px rgba(0,0,0,0.14);
	  margin: -11px 0px 8px;*/
	  background:transparent;
}

.breadcrumb a{
	text-shadow: none;
    color: #000;
}

.breadcrumb>li .divider{
	text-shadow: none;
	color: #6E6E6E;
	text-decoration: none;
}

.breadcrumb-button {
  float: right;
  margin-top: 1px;
  height: 35px;
}

 i.fa.click_menu {
	margin-right: 13px;
	font-size: 18px;
}

.choosercontainer #chooseform .moduletypetitle {
		white-space: nowrap;
		padding-left: 10px;
}

#page-header a.logo {
  display: block;
  float: left;
  height: 65px;
  margin: 5px;
  width: 100%;
  background-size: contain;
  background-position: left center;
  background-repeat: no-repeat;
}

a.logo {
  background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=header%2Fcabecera);
}
.navbar .logo {
  max-height: 70px;
}

#page-header h1 {
	display:none;
}


@media(min-width:980px){

	header.navbar {
		min-height: 110px;
		margin: 0px;
	}

	.affix {
		position: fixed;
		top: 0;
		left: 0px;
		right: 1px;
		z-index: 1039;
	}

	div#breadcrumb_navbar.affix {
		top: 1px;
		left: 20px;
		width: 0;
	}

	div#breadcrumb_navbar.affix nav.breadcrumb-button {
		display:none;
	}

	div#breadcrumb_navbar.affix ul.breadcrumb{
		background-color: #ffffff;
		height: 32px;
		margin: 0;
		padding: 0;
		padding-top: 8px;
		white-space: nowrap;
		border: 0px;
	}

	div#breadcrumb_navbar.affix + h1 {
		margin-top: 51px;
	}

	/*#divCabecera {
		background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=header%2Fcabezote_izquierdo) no-repeat;
		height:70px;
	}

	#divCabeceraIzq {
		padding-left: 663px;
		height:70px;
	}

	#divCabeceraDer {
		background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=header%2Fcabezote_derecho) no-repeat right top;
		padding-right: 227px;
		height:70px;
	}

	#divCabeceraCen {
		width:100%;
		background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=header%2Fcabezote_centro) repeat-x;
		height:70px;
	}*/

	body{
		padding-top:0;
	}

	header#page-header h1 {
		min-height: 10px;
		font-size:12px;
		font-style: 'Roboto', sans-serif;
	}

	header.navbar .nav {
		float: right;
	}

	.click_menu.noshow {
			display: none;
	}
}


@media (max-width: 979px) {

	.click_menu {
		font-size: 14px;
		font-weight: bold;
		font-family: 'Roboto', sans-serif;
	}


}


@media (min-width: 768px) and (max-width: 979px) {

	.affix{
		top: 0;
		z-index: 5000;
	}

	#breadcrumb_navbar.affix {
		position: static;
    }

	.navbar-inner.affix{
		height:auto;
		max-height: 300px;

	}


	/*#divCabecera {
		background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=header%2Fmediano%2Fcabezote_izquierdo) no-repeat;
		height: 104px;
		border-radius: 8px 6px 0px 0px;
		box-shadow: -1px 0px 4px 2px #e3e3e3;
	}

	#divCabeceraIzq {
		padding-left: 392px;
		height:103px;
	}

	#divCabeceraDer {
		background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=header%2Fmediano%2Fcabezote_derecho) no-repeat right top;
		padding-right: 251px;
		border-radius:0px;
		height:104px;
	}

	#divCabeceraCen {
		width:100%;
		background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=header%2Fmediano%2Fcabezote_centro) repeat-x;
		height:104px;
	}*/
}

@media (max-width: 767px) {

	.affix{
		top: 0;
		z-index: 1039;
	}

	.navbar-inner.affix{
		height:auto;
		max-height: 300px;

		/*width:50px;*/
		/*border-radius: 0 0 14px 14px;*/
	}

	#breadcrumb_navbar.affix {
		position: static;
    }

	/*#divCabecera {
		background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=header%2Fpequeno%2Fcab_investigacion_izqP) no-repeat;
		height: 65px;
		border-radius: 8px 6px 0px 0px;
		box-shadow: -1px 0px 4px 2px #e3e3e3;
	}

	#divCabeceraIzq {
		padding-left: 316px;
		height:65px;
	}

	#divCabeceraCen {
		width:100%;
		background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=header%2Fpequeno%2Fcab_investigacion_centroP) repeat-x;
		height:65px;
	}

	#divCabeceraDer {
		background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=header%2Fpequeno%2Fcab_investigacion_derechaP) no-repeat right top;
		padding-right: 10px;
		border-radius:0px;
		height:65px;
	}*/
}



@media (max-width: 480px) {

	.affix{
		top: 0px;
		z-index: 1039;
	}

	.navbar-inner.affix{
		height: auto;
    }

	.navbar .nav>li>a{
	padding:none;
	width: 100%;
	}

	.navbar .navbar-inner.affix .nav>li>a{
    width: 100%;
	}

	#breadcrumb_navbar.affix {
		position: static;
    }

	/*#divCabecera {
		background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=header%2Fpequeno%2Fcab_investigacion_izqP) no-repeat;
		height: 65px;
		border-radius: 0px;
		box-shadow: -1px 0px 4px 2px #e3e3e3;
	}

	#divCabeceraIzq {
		padding-left: 318px;
		height:65px;
	}

	#divCabeceraCen {
		width:100%;
		background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=header%2Fpequeno%2Fcab_investigacion_centroP) repeat-x;
		height:65px;
	}

	#divCabeceraDer {
		width:100%;
		background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=header%2Fpequeno%2Fcab_investigacion_centroP) repeat-x;
		height:65px;
		border-radius: 0px;
		padding-right: 0px;
	}*/

}

/*
#divCabeceraIzq {
	padding-left: 470px;
}

#divCabeceraDer {
	background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=header%2FplataformaMEN_cabtema2013_der) no-repeat right top;
	padding-right: 520px;
}

#divCabeceraCen {
	height: 125px;
	width: 100%;
	background: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=header%2FplataformaMEN_cabtema2013_rep) repeat-x;
}
body{
	padding-top:0;
}
header#page-header {
	padding-top: 30px;
	min-height: 100px;
}
header.navbar .nav {
	float: right;
}*/
.back-to-top {
	background-color: rgba(0, 0, 0, 0.25);
	border-radius: 5px;
	box-shadow: 0 0 1px #FFFFFF;
	color: #FFFFFF;
	padding: 5px 12px;
	position: fixed;
	right: 15px;
	text-align: center;
	text-decoration: none;
	text-transform: uppercase;
	top: 85%;
	transition: all 0.3s ease 0s;
	font-size: 1.1em;
	display: none;
}
.back-to-top:hover {
	background-color: rgba(0, 0, 0, 0.5);
	color: #FFFFFF;
	cursor: pointer;
}
.box.generalbox .no-overflow a {
    color: #7baa39;
}
.box.generalbox .no-overflow a:hover {
    color: #008e6a;
}
.questionbankwindow.block {
    width: 29%;
}
#page-mod-quiz-edit div.quizcontents {
    width: 69%;
}
.forumpost.clearfix .content .posting.fullpost p a{
    color: #7baa39;
}
.forumpost.clearfix .content .posting.fullpost p a:hover {
    color: #008e6a;
}
/*Padding para corregir modal del Grid-Format*/

/**#gridshadebox_content {
  top: 280px !important;;
}

/***************************************************************************************/
/***** Estilos para taller de redes sociales - RS Inicio 2016-12-15 Daniel J***********/
/***************************************************************************************/
.pit-rs-primero,.pit-rs-segundo{
  position: relative;
}

.pit-rs-segundo .pit_intro::before{
  content: "";
  background-image: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=taller_redes_sociales%2Fedmodo_2);
  position: absolute;
  display: block;
  top: -70px;
  left: 0px;
  width: 428px;
  height: 71px;
  background-size: inherit;
  background-repeat: no-repeat;
}
.pit-rs-segundo  .pit_intro::after{
  content: "";
  background-image: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=taller_redes_sociales%2Fedmodo_1);
  position: absolute;
  display: block;
  bottom: -50px;
  right: 0px;
  width: 206px;
  height: 206px;
  background-size: 70%;
  background-repeat: no-repeat;
  background-position: right bottom;
}

.pit-body-rs-facebook div#pit_emss_body.pit_emss_presentacion ,.pit-body-rs-google div#pit_emss_body.pit_emss_presentacion,.pit-body-rs-twitter div#pit_emss_body.pit_emss_presentacion {
    background: none;
    padding: 20px;
    box-shadow: none;
    box-shadow: -7px -7px 0px #e1e1e1;
    background-color: #f7f7f7;
    margin-top: 70px;
    margin-left: 10px;
    border-radius: 0;
    margin-bottom: 50px;
}
/**Facebook **/
.pit-body-rs-facebook{
  position: relative;
}
.pit-body-rs-facebook div#pit_emss_body::before{
  content: "";
  background-image: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=taller_redes_sociales%2Ffacebook_2);
  position: absolute;
  display: block;
  top: -70px;
  left: 0px;
  width: 428px;
  height: 71px;
  background-size: inherit;
  background-repeat: no-repeat;
}

.pit-body-rs-facebook div#pit_emss_body::after{
  content: "";
  background-image: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=taller_redes_sociales%2Ffacebook_1);
  position: absolute;
  display: block;
  bottom: -50px;
  right: 0px;
  width: 206px;
  height: 206px;
  background-size: 70%;
  background-repeat: no-repeat;
  background-position: right bottom;
}
/*** Google ***/
.pit-body-rs-google{
  position: relative;
}
.pit-body-rs-google div#pit_emss_body::before{
  content: "";
  background-image: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=taller_redes_sociales%2Fgplus_2);
  position: absolute;
  display: block;
  top: -70px;
  left: 0px;
  width: 428px;
  height: 71px;
  background-size: inherit;
  background-repeat: no-repeat;
}
.pit-body-rs-google div#pit_emss_body::after{
  content: "";
  background-image: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=taller_redes_sociales%2Fgplus_1);
  position: absolute;
  display: block;
  bottom: -50px;
  right: 0px;
  width: 206px;
  height: 206px;
  background-size: 70%;
  background-repeat: no-repeat;
  background-position: right bottom;

}
/*** Twitter ***/
.pit-body-rs-twitter{
  position: relative;
}
.pit-body-rs-twitter div#pit_emss_body::before{
  content: "";
  background-image: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=taller_redes_sociales%2Ftwitter_2);
  position: absolute;
  display: block;
  top: -70px;
  left: 0px;
  width: 428px;
  height: 71px;
  background-size: inherit;
  background-repeat: no-repeat;
}
.pit-body-rs-twitter div#pit_emss_body::after{
  content: "";
  background-image: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=taller_redes_sociales%2Ftwitter_1);
  position: absolute;
  display: block;
  bottom: -50px;
  right: 0px;
  width: 206px;
  height: 206px;
  background-size: 70%;
  background-repeat: no-repeat;
  background-position: right bottom;
}

.pit-menu-rs::after{
  content: "";
  background-image: url(/lms/moodle/theme/image.php?theme=aardvark_academica&component=theme&image=taller_redes_sociales%2Fredes_sociales-01);
}
/**********************************************************************************************************/
/**Estilos para taller de redes sociales - RS Fin 2016-12-15 **/
/**********************************************************************************************************/




