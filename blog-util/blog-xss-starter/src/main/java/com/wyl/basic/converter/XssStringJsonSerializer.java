package com.wyl.basic.converter;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.wyl.basic.utils.XssUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * cloud-study XssStringJsonSerializer
 *
 * <p>
 * 基于xss的 json 序列化器
 * 在本项目中，没有使用该类
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/15 21:08
 */
@Slf4j
public class XssStringJsonSerializer extends JsonSerializer<String> {
    @Override
    public Class<String> handledType() {
        return String.class;
    }

    @Override
    public void serialize(String value, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) {
        if (StrUtil.isEmpty(value)) {
            return;
        }
        try {
            String encodedValue = XssUtils.xssClean(value, null);
            jsonGenerator.writeString(encodedValue);
        } catch (Exception e) {
            log.error("序列化失败:[{}]", value, e);
        }
    }

}
