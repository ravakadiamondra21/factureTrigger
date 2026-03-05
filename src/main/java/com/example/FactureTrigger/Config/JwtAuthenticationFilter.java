package com.example.FactureTrigger.Config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.FactureTrigger.Model.User;
import com.example.FactureTrigger.Repository.UserRepo;
import com.example.FactureTrigger.Service.JwtService;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	private final JwtService jwtService;
	private final UserRepo userRepo;
	
	public JwtAuthenticationFilter(JwtService jwtService, UserRepo userRepo) {
		super();
		this.jwtService = jwtService;
		this.userRepo = userRepo;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		throws ServletException, java.io.IOException {
		
		final String authHeader = request.getHeader("Authorization");
		String token = null;
		String email = null;
		
		if (request.getServletPath().equals("/auth/login")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		if(authHeader != null && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7);
			
			try {
				email = jwtService.extractSubject(token);
			} catch(Exception e) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write("token invalide ou expiré");
				return;
			}
		}
		
		if(email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			User user = userRepo.findByUserEmail(email).orElseThrow();
			
			if(user != null && jwtService.isTokenValid(token, user)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		
		filterChain.doFilter(request, response);
	}
	
}
