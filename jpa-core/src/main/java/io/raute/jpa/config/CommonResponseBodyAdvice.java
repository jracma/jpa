package io.raute.jpa.config;


import io.raute.jpa.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


@RestControllerAdvice(basePackages = "cn.wntime")
public class CommonResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    private static final Logger logger = LoggerFactory.getLogger(CommonResponseBodyAdvice.class);

    @ExceptionHandler(Exception.class)
    public final Result exceptionHandler(Exception ex, WebRequest request) {

        logger.error("URL:{} throw exception,msg:{}",
                ((ServletWebRequest) request).getRequest().getRequestURI(),
                ex.getMessage());
        Result result = new Result();
        result.setCode(500);
        result.setMessage(ex.getLocalizedMessage());
        return result;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        if (Result.class.isAssignableFrom(returnType.getParameterType())) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        Result<Object> result = new Result<>();
        result.setData(body);
        return result;
    }


}
