package io.github.anotherme17.spiderbase.listener;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;
import io.github.anotherme17.spiderbase.common.BaseConstants;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * @author lirenhao
 * date: 2017/11/10 下午11:04
 */
@Slf4j
public class LogbackContextListener extends ContextAwareBase implements LoggerContextListener, LifeCycle {

    private boolean started = false;

    private static final String DEFAULT_LOG_PATH = "/var/another/log";

    @Override
    public void start() {
        if (started)
            return;

        String serviceName;
        Properties bootStrapProps = new Properties();

        try {
            bootStrapProps.load(this.getClass().getClassLoader().getResourceAsStream("bootstrap.properties"));
            serviceName = bootStrapProps.getProperty(BaseConstants.SERVER_NAME_KEY);
            String baseLogPath = System.getProperty("log.path", DEFAULT_LOG_PATH);
            getContext().putProperty("BASE_LOG_PATH", baseLogPath);
            getContext().putProperty("SERVICE_NAME", serviceName);
            log.info("init logback listener");
        } catch (Exception e) {
            log.error("bootStrap 加载异常");
            return;
        }

        started = true;
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isStarted() {
        return started;
    }

    @Override
    public boolean isResetResistant() {
        return false;
    }

    @Override
    public void onStart(LoggerContext loggerContext) {

    }

    @Override
    public void onReset(LoggerContext loggerContext) {

    }

    @Override
    public void onStop(LoggerContext loggerContext) {

    }

    @Override
    public void onLevelChange(Logger logger, Level level) {

    }
}
