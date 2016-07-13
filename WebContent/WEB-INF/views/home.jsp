<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
@import url(http://fonts.googleapis.com/css?family=Lato:100,300,400,700);
@import url(http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css);

html, body {
    background: #e5e5e5;
    font-family: 'Lato', sans-serif;
    margin: 0px auto;
}
::selection{
  background: rgba(82,179,217,0.3);
  color: inherit;
}
a{
  color: rgba(82,179,217,0.9);
}

/* M E N U */

.menu {
    position: relative 
    top: 0px;
    left: 0px;
    right: 0px;
    width: 100%;
    height: 50px;
    background: rgba(82,179,217,0.9);
    z-index: 100;
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
}

.back {
    position: relative;
    width: 90px;
    height: 50px;
    top: 0px;
    left: 0px;
    color: #fff;
    line-height: 50px;
    font-size: 30px;
    padding-left: 10px;
    cursor: pointer;
}
.back img {
    position: relative;
    top: 5px;
    left: 30px;
    width: 40px;
    height: 40px;
    background-color: rgba(255,255,255,0.98);
    border-radius: 100%;
    -webkit-border-radius: 100%;
    -moz-border-radius: 100%;
    -ms-border-radius: 100%;
    margin-left: 15px;
    }
.back:active {
    background: rgba(255,255,255,0.2);
}
.name{
    position: relative;
    top: 3px;
    left: 110px;
    font-family: 'Lato';
    font-size: 25px;
    font-weight: 300;
    color: rgba(255,255,255,0.98);
    cursor: default;
}
.last{
    position: inherit;
    top: 30px;
    left: 115px;
    font-family: 'Lato';
    font-size: 11px;
    font-weight: 400;
    color: rgba(255,255,255,0.6);
    cursor: default;
}

/* M E S S A G E S */

.chat {
    list-style: none;
    background: none;
    margin: 0;
    padding: 0 0 50px 0;
    margin-top: 60px;
    margin-bottom: 10px;
    width: 480px;
    height: 400px;
    overflow-y: auto;
    overflow-x: hidden;
}
.chat li {
    padding: 0.5rem;
    overflow: hidden;
    display: flex;
}
.chat .avatar {
    width: 40px;
    height: 40px;
    position: relative;
    display: block;
    z-index: 2;
    border-radius: 100%;
    -webkit-border-radius: 100%;
    -moz-border-radius: 100%;
    -ms-border-radius: 100%;
    background-color: rgba(255,255,255,0.9);
}
.chat .avatar img {
    width: 40px;
    height: 40px;
    border-radius: 100%;
    -webkit-border-radius: 100%;
    -moz-border-radius: 100%;
    -ms-border-radius: 100%;
    background-color: rgba(255,255,255,0.9);
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
}
.chat .day {
    position: relative;
    display: block;
    text-align: center;
    color: #c0c0c0;
    height: 20px;
    text-shadow: 7px 0px 0px #e5e5e5, 6px 0px 0px #e5e5e5, 5px 0px 0px #e5e5e5, 4px 0px 0px #e5e5e5, 3px 0px 0px #e5e5e5, 2px 0px 0px #e5e5e5, 1px 0px 0px #e5e5e5, 1px 0px 0px #e5e5e5, 0px 0px 0px #e5e5e5, -1px 0px 0px #e5e5e5, -2px 0px 0px #e5e5e5, -3px 0px 0px #e5e5e5, -4px 0px 0px #e5e5e5, -5px 0px 0px #e5e5e5, -6px 0px 0px #e5e5e5, -7px 0px 0px #e5e5e5;
    box-shadow: inset 20px 0px 0px #e5e5e5, inset -20px 0px 0px #e5e5e5, inset 0px -2px 0px #d7d7d7;
    line-height: 38px;
    margin-top: 5px;
    margin-bottom: 20px;
    cursor: default;
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
}

.other .msg {
    order: 1;
    border-top-left-radius: 0px;
    box-shadow: -1px 2px 0px #D4D4D4;
}
.other:before {
    content: "";
    position: relative;
    top: 0px;
    right: 0px;
    left: 40px;
    width: 0px;
    height: 0px;
    border: 5px solid #fff;
    border-left-color: transparent;
    border-bottom-color: transparent;
}

.self {
    justify-content: flex-end;
    align-items: flex-end;
}
.self .msg {
    order: 1;
    border-bottom-right-radius: 0px;
    box-shadow: 1px 2px 0px #D4D4D4;
}
.self .avatar {
    order: 2;
}
.self .avatar:after {
    content: "";
    position: relative;
    display: inline-block;
    bottom: 19px;
    right: 0px;
    width: 0px;
    height: 0px;
    border: 5px solid #fff;
    border-right-color: transparent;
    border-top-color: transparent;
    box-shadow: 0px 2px 0px #D4D4D4;
}

.msg {
    background: white;
    min-width: 50px;
    padding: 10px;
    border-radius: 2px;
    box-shadow: 0px 2px 0px rgba(0, 0, 0, 0.07);
}
.msg p {
    font-size: 0.8rem;
    margin: 0 0 0.2rem 0;
    color: #777;
}
.msg img {
    position: relative;
    display: block;
    width: 450px;
    border-radius: 5px;
    box-shadow: 0px 0px 3px #eee;
    transition: all .4s cubic-bezier(0.565, -0.260, 0.255, 1.410);
    cursor: default;
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
}
@media screen and (max-width: 800px) {
    .msg img {
    width: 300px;
}
}
@media screen and (max-width: 550px) {
    .msg img {
    width: 200px;
}
}

.msg time {
    font-size: 0.7rem;
    color: #ccc;
    margin-top: 3px;
    float: right;
    cursor: default;
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
}
.msg time:before{
    content:"\f017";
    color: #ddd;
    font-family: FontAwesome;
    display: inline-block;
    margin-right: 4px;
}

@-webikt-keyframes pulse {
  from { opacity: 0; }
  to { opacity: 0.5; }
}

/* T Y P E */

input.textarea {
    position: relative;
    bottom: 0px;
    left: 0px;
    right: 0px;
    width: 480px;
    height: 50px;
    z-index: 99;
    background: #fafafa;
    border: none;
    outline: none;
    padding-left: 5px;
    padding-right: 5px;
    color: #666;
    font-weight: 400;
}

#container {
    width: 960px;
    margin: 0 auto;
}

#primary {
    float: left;
    width: 240px;
}

#content {
	
    float: left;
    width: 480px;
}

#secondary {
    float: left;
    width: 240px;
}

#footer {
    clear: both;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>

	<div id="container">
		<div id="header">
			<a href="root">Home </a>
			<a href="logout">Logout</a>
		</div>
		
		<div id="primary">
			<c:forEach var="u" items="${usuario_logado.amigos}">
				<a href="listarConversa?idUsuario1=${u.idUsuario}&idUsuario2=${usuario_logado.idUsuario}">${u.pNome} ${u.uNome}<br /></a>
			</c:forEach>
			<c:forEach var="g" items="${usuario_logado.grupoParticipa}">
				<a href="listarConversaGrupo?idGrupo=${g.idGrupo}">${g.nomeGrupo}<br /></a>
			</c:forEach>
		</div>
		<div id="content">
		<div class="menu">
			<div class="back"><i class="fa fa-chevron-left"></i> <img src="http://i.imgur.com/DY6gND0.png" draggable="false" /></div>
		    <c:choose>
	    	<c:when test="${not empty amigo and not empty conversa}">
		    <div class="name">${amigo.pNome} ${amigo.uNome}</div>
		    	<div class="chat"><ol>
					<c:forEach var="m" items="${conversa}">
						<c:choose>
				    		<c:when test="${m.remetente.idUsuario eq usuario_logado.idUsuario}">
								<li class="self">
						    		<div class="avatar"><img src="http://i.imgur.com/HYcn9xO.png" draggable="false" /></div>
							      	<div class="msg">
							        	<p>${m.corpo}</p>
							        	<time>${m.dataHoraEnvio}</time>
							    	</div>
					    	 	</li>
					    	 </c:when>
					    	<c:when test="${m.remetente.idUsuario eq amigo.idUsuario}">
					    	 	<li class="other">
							 		<div class="avatar"><img src="http://i.imgur.com/DY6gND0.png" draggable="false"/></div>
								    <div class="msg">
								    	<p>${m.corpo}</p>
							        	<time>${m.dataHoraEnvio}</time>
								    </div>
							    </li> 
					   	 	</c:when>
				     	</c:choose>
		    		</c:forEach>
		    	
	    	</ol>
	    	</div>
	    	</c:when>
	    	<c:when test="${not empty grupo and not empty conversaGrupo}">
	    	<div class="name">${grupo.nomeGrupo}</div>
		    <div class="chat"><ol>
				<c:forEach var="m" items="${conversaGrupo}">
					<c:choose>
				    	<c:when test="${m.remetente.idUsuario eq usuario_logado.idUsuario}">
							<li class="self">
						    	<div class="avatar"><img src="http://i.imgur.com/HYcn9xO.png" draggable="false" /></div>
						      	<div class="msg">
						        	<p>${m.corpo}</p>
						        	<time>${m.dataHoraEnvio}</time>
						        	<time>${m.remetente.pNome}</time>
						    	</div>
				    	 	</li>
				    	 </c:when>
				    	<c:otherwise>
				    	 	<li class="other">
						 		<div class="avatar"><img src="http://i.imgur.com/DY6gND0.png" draggable="false"/></div>
							    <div class="msg">
							    	<p>${m.corpo}</p>
						        	<time>${m.dataHoraEnvio}</time>
						        	<time>${m.remetente.pNome}</time>
							    </div>
						    </li> 
				   	 	</c:otherwise>
			     	</c:choose>
		    	</c:forEach>
	    	</ol>
	    	</div>
	    	</c:when>
	    	</c:choose>
	    	<c:choose>
		    	<c:when test="${not empty amigo}">
			    	<form action="inserirMensagem?destinatario=${amigo.idUsuario}&remetente=${usuario_logado.idUsuario}&corpo=${c}" method="post">
				    	<input class="textarea" name="corpo" type="text" placeholder="Type here!"/>
				    	<c:set var="c" value="${param.corpo}"/>
				    </form>
			    </c:when>
			    <c:when test="${not empty grupo}">
			    	<form action="inserirMensagemGrupo?destinatario=${grupo.idGrupo}&remetente=${usuario_logado.idUsuario}&corpo=${c}" method="post">
				    	<input class="textarea" name="corpo" type="text" placeholder="Type here!"/>
				    	<c:set var="c" value="${param.corpo}"/>
				    </form>
			    </c:when>
		    </c:choose>	    
	    </div>
	    </div>
	</div>
</body>
</html>