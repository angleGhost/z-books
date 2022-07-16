package com.zbooks.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zbooks.model.entity.ErrorResult;
import com.zbooks.model.entity.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Description: 全局结果处理
 * Version: 1.0
 * Create Time: 2022/7/16 15:20
 *
 * @author TBH
 */

@ControllerAdvice(basePackages = "com.zbooks")
public class GlobalResultHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(@NonNull MethodParameter returnType,
                            @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, @NonNull MethodParameter methodParameter,
                                  @NonNull MediaType mediaType,
                                  @NonNull Class<? extends HttpMessageConverter<?>> aClass,
                                  @NonNull ServerHttpRequest serverHttpRequest,
                                  @NonNull ServerHttpResponse serverHttpResponse) {
        // 异常类就走异常处理，正常情况走json处理
        if (o instanceof ErrorResult errorHandler) {
            return Result.fail(errorHandler.getStatus(), errorHandler.getMessage());
        } else if (o instanceof String) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Result r = Result.success(o);
                return objectMapper.writeValueAsString(r);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return Result.success(o);
    }
}