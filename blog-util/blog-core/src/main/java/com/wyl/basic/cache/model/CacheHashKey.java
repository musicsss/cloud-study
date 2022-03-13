package com.wyl.basic.cache.model;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

import java.time.Duration;

import static com.wyl.basic.utils.StrPool.COLON;

/**
 * cloud-study CacheHashKey
 *
 * <p>
 * hash 缓存 key 封装
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/14 22:56
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CacheHashKey extends CacheKey {
    /**
     * redis hash field
     */
    @NonNull
    private Object field;

    public CacheHashKey(@NonNull String key, final @NonNull Object field) {
        super(key);
        this.field = field;
    }

    public CacheHashKey(@NonNull String key, final @NonNull Object field, Duration expire) {
        super(key, expire);
        this.field = field;
    }

    public CacheKey tran() {
        return new CacheKey(StrUtil.join(COLON, getKey(), getField()), getExpire());
    }
}
