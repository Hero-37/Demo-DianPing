package com.dianping;

import com.dianping.service.impl.ShopServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoDianPingApplicationTests {

    @Resource
    private ShopServiceImpl shopService;

    @Test
    void contextLoads() {
    }

    @Test
    void testSaveShop() {
        shopService.saveShop2Redis(1L, 10L);
    }

}
