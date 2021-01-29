package com.tt.service;

import com.tt.entity.StockDTO;
import com.tt.enums.StockHandlerTypeEnum;

/**
 * @author dangwu
 * @since 2021/1/28 8:48 下午
 */
public interface StockService {
    void updateStock(StockDTO stockDTO, StockHandlerTypeEnum stockHandlerTypeEnum);
}
