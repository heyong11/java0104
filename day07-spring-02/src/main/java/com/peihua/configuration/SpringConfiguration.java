package com.peihua.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration //当前类是spring配置类，相当于xml
@ComponentScan(basePackages = "com.peihua")

@Import(value = DataSourceConfig.class)
public class SpringConfiguration {

}
