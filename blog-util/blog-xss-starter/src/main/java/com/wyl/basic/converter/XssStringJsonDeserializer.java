package com.wyl.basic.converter;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.wyl.basic.utils.XssUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * cloud-study XssStringJsonDeserializer
 *
 * <p>
 * 过滤跨站脚本的 反序列化工具
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/15 21:09
 */
public class XssStringJsonDeserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser p, DeserializationContext dc) throws IOException {
        if (!p.hasToken(JsonToken.VALUE_STRING)) {
            return null;
        }
        String value = p.getValueAsString();
        if (StrUtil.isEmpty(value)) {
            return value;
        }

        List<String> list = new ArrayList<>();
        list.add("<script>");
        list.add("</script>");
        list.add("<iframe>");
        list.add("</iframe>");
        list.add("<noscript>");
        list.add("</noscript>");
        list.add("<frameset>");
        list.add("</frameset>");
        list.add("<frame>");
        list.add("</frame>");
        list.add("<noframes>");
        list.add("</noframes>");
        list.add("<embed>");
        list.add("</embed>");
        list.add("<object>");
        list.add("</object>");
        list.add("<meta>");
        list.add("</meta>");
        list.add("<link>");
        list.add("</link>");
        if (list.stream().anyMatch(value::contains)) {
            return XssUtils.xssClean(value, null);
        }
        return value;
    }

}
