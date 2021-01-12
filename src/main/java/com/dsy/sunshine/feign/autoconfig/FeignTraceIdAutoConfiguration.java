package com.dsy.sunshine.feign.autoconfig;

import feign.Client;
import feign.Feign;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr.Yangxiufeng
 * @date 2020-06-09
 * @time 19:51
 */
@Configuration
@ConditionalOnClass(Feign.class)
@ConditionalOnBean(Client.class)
@ConditionalOnProperty(value = "feign.traceId.enabled", matchIfMissing = true)
@AutoConfigureAfter(FeignAutoConfiguration.class)
public class FeignTraceIdAutoConfiguration {

    @Bean
    public RequestInterceptor feignTraceIdInterceptor(){
        return new FeignTraceIdInterceptor();
    }

}
