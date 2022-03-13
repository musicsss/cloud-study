package com.wyl.basic.annotation.echo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static cn.hutool.core.text.CharSequenceUtil.EMPTY;

/**
 * cloud-study Echo
 * <p>
 * 在某个对象的字段上标记该注解，该字段的值将被主动注入
 * <p>
 * 如：
 * \@Echo(api = "dictionaryServiceImpl")
 * private String nation;
 * \@Echo(api = "dictionaryServiceImpl")
 * private RemoteData<String,String>  nation;
 * \@Echo(api = "dictionaryApi")
 * private RemoteData<String,String>  nation;
 * \@Echo(api = "xxx.xxx.xxx.UserApi", beanClass = User.class)
 * private RemoteData<String, User>  user;
 *
 * <p>
 * 强烈建议：不要对象之间互相依赖
 * 如： User 想要注入 File， File也想注入User
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/11 21:33
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
public @interface Echo {
    /**
     * 回显到那个字段
     *
     * @return 回显到那个字段
     */
    String ref() default EMPTY;

    /**
     * 提供自动注入值的 查询类
     * <p/>
     * api()  和 apiClass() 任选其一,  使用 api时，请填写实现类， 使用feign时，填写接口即可
     * <p>
     * 如： @Echo(api="userServiceImpl") 等价于 @Echo(apiClass=UserService.class)
     * 如： @Echo(api="userApi") 等价于 @Echo(apiClass=UserApi.class)
     * <p/>
     * 注意： 用 @Echo(api = "xxxServiceImpl")时，要保证当前服务有 xxxServiceImpl 类. 没这个类就要用 xxxApi  (FeignClient)
     *
     * @return 查询类的Spring Name
     */
    String api();

    /**
     * 自动注入值的类型， 用于强制转换
     * <p>
     * api()  或 apiClass() 配置了FeignClient时，通过api/apiClass + method 反射调用的结果会因为序列化的关系丢失类型
     * 如：实际返回值中 Map<Serializable, Object> 的value值为 User 对象，但由于通过FeignClient调用时，会自动进行序列化和房序列化，
     * 导致返回值Map中Object类型的value值丢失类型，故通过该参数进行类型强制转换。
     *
     * @return 待强壮的类
     */
    Class<?> beanClass() default Object.class;

    /**
     * 自动注入值是字典时，需要指定该字典的 类型（c_dictionary 表的 type 字段）
     *
     * @return 字典类型
     */
    String dictType() default EMPTY;
}
