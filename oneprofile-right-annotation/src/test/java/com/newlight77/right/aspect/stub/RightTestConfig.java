package com.newlight77.right.aspect.stub;

import com.newlight77.right.aspect.RightAspect;
import com.newlight77.right.aspect.RightAspectUsage;
import com.newlight77.right.service.HasRightService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = false)
@ComponentScan(value={"com.newlight77.right.aspect"})
public class RightTestConfig {

    @MockBean
    private RightRepository rightRepositoryMock;

    @Bean
    public HasRightService hasRightService() {
        return new RightServiceStub(rightRepositoryMock);
    }

    @Bean
    public RightAspect rightAspect() throws Exception {
        return new RightAspect(hasRightService());
    }

    @Bean
    public RightAspectUsage rightAspectUsage() {
        return new RightAspectUsage();
    }

}
