package com.tt.service.impl;

import com.tt.entity.StockDTO;
import com.tt.enums.StockHandlerTypeEnum;
import com.tt.handler.StockHandlerFactory;
import com.tt.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dangwu
 * @since 2021/1/28 8:48 下午
 */
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockHandlerFactory stockHandlerFactory;

    @Override
    public void updateStock(StockDTO stockDTO,StockHandlerTypeEnum stockHandlerTypeEnum) {
        stockHandlerFactory.getStockHandler(stockHandlerTypeEnum.getCode()).updateStock(stockDTO);

    }
}
