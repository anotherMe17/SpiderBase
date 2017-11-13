package io.github.anotherme17.spiderdemo;

import io.github.anotherme17.spiderbase.BaseSpiderServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author lirenhao
 * date: 2017/11/13 上午11:01
 */
@Slf4j
@SpringBootApplication
public class SpiderDemoApplication {

    public static void main(String[] args) {
        BaseSpiderServer server = new BaseSpiderServer();
        ApplicationContext ctx = server.start(args);
    }
}
