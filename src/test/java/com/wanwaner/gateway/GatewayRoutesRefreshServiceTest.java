package com.wanwaner.gateway;

import com.wanwaner.gateway.route.GatewayRoutesRefreshService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GatewayRoutesRefreshServiceTest {

  @Autowired
  private GatewayRoutesRefreshService gatewayRoutesRefreshService;

  @Test
  public void testSave() {
    gatewayRoutesRefreshService.save();
  }
}
