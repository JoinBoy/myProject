package com.ccj.filter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * 
 * @author Administrator
 * 用户登录拦截注解
 *
 */
@Target({
	ElementType.TYPE,
	ElementType.METHOD
})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserLogined {
	String value() default "logined";
}
