package com.zbooks.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project: zbooks
 * Description: 跨域拦截器
 * Version: 1.0
 * Create Time: 2022/7/16 12:30
 *
 * @author TBH
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 10)
public class CorsFilter extends GenericFilterBean {

    private static final String ALLOW_HEADERS = StringUtils
            // todo token放行
            .joinWith(",", HttpHeaders.CONTENT_TYPE);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // Set customized header
        String originHeaderValue = httpServletRequest.getHeader(HttpHeaders.ORIGIN);
        if (StringUtils.isNotBlank(originHeaderValue)) {
            httpServletResponse
                    .setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, originHeaderValue);
        }
        httpServletResponse.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, ALLOW_HEADERS);
        httpServletResponse
                .setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, DELETE, OPTIONS");
        httpServletResponse.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        httpServletResponse.setHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "3600");

        if (!CorsUtils.isPreFlightRequest(httpServletRequest)) {
            chain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}