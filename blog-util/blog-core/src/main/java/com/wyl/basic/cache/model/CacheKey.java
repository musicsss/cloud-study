package com.wyl.basic.cache.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.Duration;

/**
 * cloud-study CacheKey
 *
 * <p>
 * 缓存 key 封装
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/14 22:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CacheKey {
    /**
     * redis key
     */
    @NonNull
    private String key;
    /**
     * 超时时间 秒
     */
    private Duration expire;

    public CacheKey(final @NonNull String key) {
        this.key = key;
    }


}
