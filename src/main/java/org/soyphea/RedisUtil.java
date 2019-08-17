package org.soyphea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

@Service
public class RedisUtil {


    String name = RedisUtil.class.getName();

    Logger logger = LoggerFactory.getLogger(name);

    private HashOperations hashOperations;

    private RedisTemplate redisTemplate;

    public RedisUtil(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void saveCache(){
        logger.info("Save....");
        hashOperations.put("SONG",Singer.PREAP_SOVATH, Arrays.asList("Shap Of You","Photograph"));
        hashOperations.put("SONG",Singer.SHEERAN, Arrays.asList("Songsa 1 Khae 2 Khae","Thnom"));
    }
    public Object findAllSinger(){
        return hashOperations.values("SONG");
    }

    public Object findSongBySinger(String singer){
        return hashOperations.get("SINGER",singer);
    }

    public Object findSongByMultiSinger(Collection list){
        return hashOperations.multiGet("SINGER", list);
    }
}
