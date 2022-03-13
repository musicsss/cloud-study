package com.wyl.basic.base;

import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * cloud-study BaseEnum
 *
 * <p>
 * 枚举类型基类
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/10/14 20:01
 */
public interface BaseEnum extends IEnum<String> {

    /**
     * 获取编码的默认实现
     *
     * @return 编码
     */
    default String getCode() {
        return toString();
    }

    /**
     * 描述
     *
     * @return 描述
     */
    String getDesc();

    /**
     * 扩展参数
     *
     * @return 扩展参数
     */
    default String getExtra() {
        return "";
    }

    /**
     * 判断val是否跟当前枚举值相等（忽略大小写）
     *
     * @param val 待判断值
     * @return 是否等于
     */
    default boolean eq(String val) {
        return this.getCode().equalsIgnoreCase(val);
    }

    /**
     * 枚举值
     *
     * @return 数据库中的值
     */
    @Override
    default String getValue() {
        return getCode();
    }
}
