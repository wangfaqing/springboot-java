package org.wfq.demo.common.annotation;


import org.wfq.demo.common.constants.DataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Ds {

	public DataSourceType value() default DataSourceType.MASTER_DATASOURCE;
}
