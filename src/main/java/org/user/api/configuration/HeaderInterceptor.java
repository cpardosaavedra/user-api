package org.user.api.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Enumeration;

@AllArgsConstructor
public class HeaderInterceptor implements HandlerInterceptor {

    private final Header header;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        this.header.setToken(null);
        this.header.setAppName(null);
        this.header.setClient(null);

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();

            if ("session-token".equals(headerName)) {
                this.header.setToken(request.getHeader(headerName));
            }

            if ("application-name".equals(headerName)) {
                this.header.setAppName(request.getHeader(headerName));
            }

            if ("client-name".equals(headerName)) {
                this.header.setAppName(request.getHeader(headerName));
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // Resto de la lógica después de que se maneje la solicitud por el controlador
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        // Lógica que se ejecuta después de completar la respuesta
    }
}
