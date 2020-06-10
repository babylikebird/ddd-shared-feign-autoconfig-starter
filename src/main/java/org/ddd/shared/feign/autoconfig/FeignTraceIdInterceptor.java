package org.ddd.shared.feign.autoconfig;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author Mr.Yangxiufeng
 * @date 2020-06-09
 * @time 19:45
 */
public class FeignTraceIdInterceptor implements RequestInterceptor {
    public static final String REQUEST_ID = "requestId";
    private static final String HEADER_X_REQUEST_ID = "x-request-id";
    Logger log = LoggerFactory.getLogger(FeignTraceIdInterceptor.class);
    @Override
    public void apply(RequestTemplate template) {
        String traceId = MDC.get(REQUEST_ID);
        traceId = StringUtils.isEmpty(traceId) ? UUID.randomUUID().toString() : traceId;
        log.info("traceId is {}",traceId);
        template.header(HEADER_X_REQUEST_ID, traceId);
    }
}
