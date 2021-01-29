package com.tt.handler;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dangwu
 * @since 2021/1/25 11:12 上午
 */
@Component
public class StockHandlerFactory implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;
    private static final ConcurrentHashMap<String,StockHandler> STOCK_HANDLER_MAP = new ConcurrentHashMap<>(10);

    @Override
    public void afterPropertiesSet() throws Exception {
        applicationContext.getBeansOfType(StockHandler.class).values().forEach(stockHandler -> {
            STOCK_HANDLER_MAP.put(stockHandler.getHandlerType(),stockHandler);
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 通过stockType获取对应的StockHandler
     * @param stockType 获取StockHandler的入参类型
     * @return StockHandler
     */
    public StockHandler getStockHandler(String stockType){
        return STOCK_HANDLER_MAP.get(stockType);
    }
}
