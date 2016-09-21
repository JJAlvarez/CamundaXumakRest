package org.xumak.camunda.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by xumak on 14/09/16.
 */

@Configuration
@Import(JpaConfiguration.class)
@EnableWebMvc
@ComponentScan(basePackages = "org.xumak.camunda.spring")
public class CamundaRestConfiguration extends WebMvcConfigurerAdapter {

}
