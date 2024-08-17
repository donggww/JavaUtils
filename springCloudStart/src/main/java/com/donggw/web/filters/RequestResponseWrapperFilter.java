package com.donggw.web.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
@Component
public class RequestResponseWrapperFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("进入了过滤器");
		HttpServletRequest request = (HttpServletRequest) servletRequest;

		String requestData = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
		if (!requestData.isEmpty()) {
			System.out.println("Request Body: " + requestData);
		}

		filterChain.doFilter(servletRequest, servletResponse);
	}
}