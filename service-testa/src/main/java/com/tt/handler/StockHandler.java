package com.tt.handler;

import com.tt.entity.StockDTO;

/**
 * @author dangwu
 * @since 2021/1/25 11:08 上午
 */
public interface StockHandler {
    /**
     * 获取handler类型
     * @return
     */
    String getHandlerType();

    /**
     * 更新库存
     * @param stockDTO
     */
    void updateStock(StockDTO stockDTO);
}
