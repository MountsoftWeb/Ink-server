package com.ink.utils.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author Created by carlos
 */
public class JwtFilter extends GenericFilterBean {
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
            throws IOException, ServletException {

        // Change the req and res to HttpServletRequest and HttpServletResponse
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        final HttpSession session = request.getSession();


        // Get authorization from Http request
        final String authHeader = request.getHeader("authorization");
        System.out.println(authHeader);

        // If the Http request is OPTIONS then just return the status code 200
        // which is HttpServletResponse.SC_OK in this code
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);

            chain.doFilter(req, res);
        }
        // Except OPTIONS, other request should be checked by JWT
        else {

            // Check the authorization, check if the token is started by "Bearer "
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                // 返回登录页面
                response.sendRedirect("/login");
                System.out.println("++++++++++++++++");
                
                // chain.doFilter(req, res);
                return;
            //    throw new ServletException("Missing or invalid Authorization header");
            }

            // Then get the JWT token from authorization
            final String token = authHeader.substring(7);

            try {
                // Use JWT parser to check if the signature is valid with the Key "secretkey"
                final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();

                System.out.println(claims.getSubject() + " =================== ");
                request.setAttribute("name", claims.getSubject());
                // session.setAttribute("name", claims.getSubject());
                // Add the claim to request header
                request.setAttribute("claims", claims);
                chain.doFilter(req, res);
            } catch (final SignatureException e) {
                throw new ServletException("Invalid token");
            }

            // chain.doFilter(req, res);
        }
    }
}
