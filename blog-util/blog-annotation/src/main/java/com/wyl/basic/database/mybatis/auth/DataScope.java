package com.wyl.basic.database.mybatis.auth;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.List;

/**
 * cloud-study DataScope
 *
 * <p>
 * 数据权限查询参数
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/11 21:42
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DataScope extends HashMap {
    /**
     * 限制范围的字段名称 （除个人外）
     */
    private String scopeName = "org_id";
    /**
     * 限制范围为个人时的字段名称
     */
    private String selfScopeName = "created_by";
    /**
     * 当前用户ID
     */
    private Long userId;

    /**
     * 具体的数据范围
     */
    private List<Long> orgIds;

}
