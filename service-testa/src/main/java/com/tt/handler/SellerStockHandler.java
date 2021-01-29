package com.tt.handler;

import com.tt.entity.StockDTO;
import com.tt.enums.StockHandlerTypeEnum;
import org.springframework.stereotype.Component;

/**
 * @author dangwu
 * @since 2021/1/25 3:06 下午
 */
@Component
public class SellerStockHandler implements StockHandler{
    @Override
    public String getHandlerType() {
        return StockHandlerTypeEnum.SELLER.getCode();
    }

    @Override
    public void updateStock(StockDTO stockDTO) {
        System.out.println("seller updateStock");
    }
}
