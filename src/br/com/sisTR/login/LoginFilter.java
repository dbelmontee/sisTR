package br.com.sisTR.login;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter(servletNames = { "Faces Servlet" })
public class LoginFilter implements Filter {


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		if ((session.getAttribute("USUARIOLogado") != null) || (req.getRequestURI().endsWith("login.xhtml"))
				|| (req.getRequestURI().contains("javax.faces.resource/"))) {

			chain.doFilter(request, response);
		} else {
			redireciona("/sisTR/content/login.xhtml", response);
		}
	}

	private void redireciona(String url, ServletResponse response) throws IOException {
		HttpServletResponse res = (HttpServletResponse) response;
		res.sendRedirect(url);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}


}