package com.tt.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @description: 日志打印类  
 * @program: mgn
 **/
//@Component
@Slf4j
public class LoggerFilter1 implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        if (request.getHeaders().getContentType() == null){
            return chain.filter(exchange);
        }
        String s = resolveBodyFromRequest(request);
        log.info("获取到的日志信息为：{}",s);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    private String  resolveBodyFromRequest(ServerHttpRequest serverHttpRequest){

        Flux<DataBuffer> body = serverHttpRequest.getBody();

        AtomicReference<String> bodyRef = new AtomicReference<>();

        body.subscribe(buffer -> {

            CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer.asByteBuffer());

            DataBufferUtils.release(buffer);

            bodyRef.set(charBuffer.toString());

        });

        return bodyRef.get();

    }
}
