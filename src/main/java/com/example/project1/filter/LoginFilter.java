package com.example.project1.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

@WebFilter("/*")
@Component
public class LoginFilter extends OncePerRequestFilter {

    private static final Set<String> ADMIN_ONLY_PATHS = new java.util.HashSet<String>() {{
        add("/admin-home");
        add("/contact-us-management");
        add("/quiz-result-management");
        add("/question-management");
    }};

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        String path = request.getRequestURI();

        // Allow access if it's a public path (handled in shouldNotFilter)
        // or user is logged in and (if needed) admin
        if (session != null && session.getAttribute("userId") != null) {
            Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
            if (ADMIN_ONLY_PATHS.contains(path)) {
                if (Boolean.TRUE.equals(isAdmin)) {
                    filterChain.doFilter(request, response);
                } else {
                    request.getRequestDispatcher("/unauthorized").forward(request, response);
                }
            } else {
                filterChain.doFilter(request, response);
            }
        } else {
            response.sendRedirect("/login");
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();

        return "/login".equals(path)
                || "/WEB-INF/jsp/login.jsp".equals(path)
                || "/contact".equals(path)
                || "/WEB-INF/jsp/contact.jsp".equals(path)
                || "/register".equals(path)
                || "/WEB-INF/jsp/register.jsp".equals(path);
    }
}
