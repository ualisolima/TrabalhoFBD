package br.ufc.TrabalhoFBD.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptadorGeral extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String URI = request.getRequestURI();
		if(URI.contains("login") ||
				   URI.contains("inserirUsuario"))
				return true;
		 
		
		if(request.getSession().getAttribute("usuario_logado")!=null){
			return true;
		}
		
		response.sendRedirect("loginFormulario");
		return false;
	}
}
