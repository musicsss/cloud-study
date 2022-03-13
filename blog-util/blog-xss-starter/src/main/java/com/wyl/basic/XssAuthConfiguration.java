package com.wyl.basic;

import cn.hutool.core.collection.CollUtil;
import com.wyl.basic.converter.XssStringJsonDeserializer;
import com.wyl.basic.filter.XssFilter;
import com.wyl.basic.properties.XssProperties;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

import static com.wyl.basic.filter.XssFilter.IGNORE_PARAM_VALUE;
import static com.wyl.basic.filter.XssFilter.IGNORE_PATH;

/**
 * cloud-study XssAuthConfiguration
 *
 * <p>
 * XSS 跨站攻击自动配置
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/15 20:52
 */
@AllArgsConstructor
@EnableConfigurationProperties({XssProperties.class})
public class XssAuthConfiguration {
    private final XssProperties xssProperties;

    /**
     * 配置跨站攻击 反序列化处理器
     */
    @Bean
    @ConditionalOnProperty(prefix = XssProperties.PREFIX, name = "requestBodyEnabled", havingValue = "true")
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer2() {
        return builder -> builder.deserializerByType(String.class, new XssStringJsonDeserializer());
    }


    /**
     * 配置跨站攻击过滤器
     */
    @Bean
    @ConditionalOnProperty(prefix = XssProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new XssFilter());
        filterRegistration.setEnabled(xssProperties.getEnabled());
        filterRegistration.addUrlPatterns(xssProperties.getPatterns().toArray(new String[0]));
        filterRegistration.setOrder(xssProperties.getOrder());

        Map<String, String> initParameters = new HashMap<>(4);
        initParameters.put(IGNORE_PATH, CollUtil.join(xssProperties.getIgnorePaths(), ","));
        initParameters.put(IGNORE_PARAM_VALUE, CollUtil.join(xssProperties.getIgnoreParamValues(), ","));
        filterRegistration.setInitParameters(initParameters);
        return filterRegistration;
    }

}
