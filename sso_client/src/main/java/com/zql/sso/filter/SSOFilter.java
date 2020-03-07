package com.zql.sso.filter;



import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SSOFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletRequest;
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null && session.getAttribute("user") != "") {
            filterChain.doFilter(request,response);
            return;
        }
        // 跳转至SSO认证中心
        response.sendRedirect("sso-server-url");
    }

    @Override
    public void destroy() {

    }
}
