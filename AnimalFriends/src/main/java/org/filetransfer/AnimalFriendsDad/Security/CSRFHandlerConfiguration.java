package org.filetransfer.AnimalFriendsDad.Security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class CSRFHandlerConfiguration extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CSRFHandlerInterceptor());
	}
}

/*
 * @SuppressWarnings("deprecation") class CSRFHandlerInterceptor extends
 * HandlerInterceptorAdapter {
 * 
 * @Override public void postHandle (final HttpServletRequest request, final
 * HttpServletResponse response, final Object handler, final ModelAndView
 * modelAndView) throws Exception{ // //CsrfToken token = (CsrfToken)
 * request.getAttribute("_csrf"); //modelAndView.addObject("token",
 * token.getToken());
 * 
 * } }
 */

class CSRFHandlerInterceptor implements HandlerInterceptor {

	@Override
	public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
			final ModelAndView modelAndView) throws Exception {

		if (modelAndView != null) {

			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			if (token != null) {
				modelAndView.addObject("token", token.getToken());
			}
		}
	}
}
