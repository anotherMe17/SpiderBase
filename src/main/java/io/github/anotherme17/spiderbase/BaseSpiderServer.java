package io.github.anotherme17.spiderbase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class BaseSpiderServer {

    public static void main(String[] args) {
        BaseSpiderServer spiderServer = new BaseSpiderServer();
        spiderServer.start(args);
    }

    public ApplicationContext start(String args[]) {
        SpringApplication springApplication = new SpringApplication(BaseSpiderServer.class);
        ApplicationContext ctx = springApplication.run(args);
        String[] beanName = ctx.getBeanDefinitionNames();
        log.info("Spring Boot load {} Beans", beanName.length);

        if (log.isDebugEnabled()) {
            Arrays.sort(beanName);
            log.debug("Load Bean: ");
            for (String aBeanName : beanName) {
                log.debug(aBeanName);
            }
        }

        return ctx;
    }
}
