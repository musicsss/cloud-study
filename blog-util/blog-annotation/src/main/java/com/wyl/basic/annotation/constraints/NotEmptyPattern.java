package com.wyl.basic.annotation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * cloud-study NotEmptyPattern
 * 表单字段验证，正则表达式
 * <p>
 * 跟 javax.validation.constraints.Pattern 的区别在于： 本类校验时，传递过来的参数为null或者""时，不会校验正则表达式
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/11 21:23
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(NotEmptyPattern.List.class)
@Documented
@Constraint(validatedBy = {})
public @interface NotEmptyPattern {

    /**
     * @return 要匹配的正则表达式
     */
    String regexp();

    /**
     * @return array of {@code Flag}s considered when resolving the regular expression
     */
    Flag[] flags() default {};

    /**
     * @return 错误消息模板
     */
    String message() default "{javax.validation.constraints.Pattern.message}";

    /**
     * @return 约束所属的组
     */
    Class<?>[] groups() default {};

    /**
     * @return 与约束关联的有效负载
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * 可能的Regexp旗帜。
     */
    enum Flag {

        /**
         * 启用Unix行模式.
         *
         * @see java.util.regex.Pattern#UNIX_LINES
         */
        UNIX_LINES(java.util.regex.Pattern.UNIX_LINES),

        /**
         * Enables case-insensitive matching.
         *
         * @see java.util.regex.Pattern#CASE_INSENSITIVE
         */
        CASE_INSENSITIVE(java.util.regex.Pattern.CASE_INSENSITIVE),

        /**
         * Permits whitespace and comments in pattern.
         *
         * @see java.util.regex.Pattern#COMMENTS
         */
        COMMENTS(java.util.regex.Pattern.COMMENTS),

        /**
         * Enables multiline mode.
         *
         * @see java.util.regex.Pattern#MULTILINE
         */
        MULTILINE(java.util.regex.Pattern.MULTILINE),

        /**
         * Enables dotall mode.
         *
         * @see java.util.regex.Pattern#DOTALL
         */
        DOTALL(java.util.regex.Pattern.DOTALL),

        /**
         * Enables Unicode-aware case folding.
         *
         * @see java.util.regex.Pattern#UNICODE_CASE
         */
        UNICODE_CASE(java.util.regex.Pattern.UNICODE_CASE),

        /**
         * Enables canonical equivalence.
         *
         * @see java.util.regex.Pattern#CANON_EQ
         */
        CANON_EQ(java.util.regex.Pattern.CANON_EQ);

        /**
         * JDK flag value
         *
         * @author tangyh
         * @date 2021/8/15 10:18 下午
         * @create [2021/8/15 10:18 下午 ] [tangyh] [初始创建]
         */
        private final int value;

        private Flag(int value) {
            this.value = value;
        }

        /**
         * @return flag value as defined in {@link java.util.regex.Pattern}
         */
        public int getValue() {
            return value;
        }
    }

    /**
     * Defines several {@link NotEmptyPattern} annotations on the same element.
     *
     * @see NotEmptyPattern
     */
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {

        NotEmptyPattern[] value();
    }
}
