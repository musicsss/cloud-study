package com.wyl.basic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * cloud-study Kv
 *
 * <p>
 * 键值对 通用对象
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/11 21:46
 */
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Kv implements Serializable {
    private String key;
    private String value;
}
