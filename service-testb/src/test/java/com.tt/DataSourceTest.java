package com.tt;

import com.tt.entity.Attr;
import com.tt.service.ShopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dangwu
 * @since 2021/2/1 5:28 下午
 */
public class DataSourceTest extends BaseServiceTest{
    @Autowired
    private ShopService shopService;
//    @Test
//    public void queryShopList(){
//        Shop shop = shopService.queryShopList();
//        logger.info("打印店铺信息：{}",shop);
//    }

    @Test
    public void queryAttr(){
        Attr attr = shopService.queryAttr(1L);
        logger.info("打印店铺信息：{}",attr);
    }
}
