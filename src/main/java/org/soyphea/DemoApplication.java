package org.soyphea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

import static org.soyphea.MySinger.*;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    String name = DemoApplication.class.getName();

    Logger logger = LoggerFactory.getLogger(name);

    private final RedisUtil redisUtil;

    public DemoApplication(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        redisUtil.saveCache();
        logger.info("List all the singer/song:{}",redisUtil.findAllSinger());
        logger.info("Song by singer:{}",redisUtil.findSongBySinger(PREAP_SOVATH));
        logger.info("Song by multi singer:{}",redisUtil.findSongByMultiSinger(Arrays.asList(MySinger.PREAP_SOVATH, MySinger.SHEERAN)));

    }
}
