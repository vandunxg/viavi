package com.viavi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitApplication implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(InitApplication.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("------------START----------");
    }
}
