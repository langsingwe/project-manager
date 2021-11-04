package org.example.aop;



import org.example.enums.BusinessType;
import org.example.enums.OperatorType;

import java.lang.annotation.*;

/**
 * @author : weilc
 * @version : 1.0
 * @date : 2020/12/9 23:06
 * @description : 操作日志注解
 * @email : weilc@si-tech.com.cn
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 模块
     */
    String title() default "";

    /**
     * 功能
     */
    BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;

}
