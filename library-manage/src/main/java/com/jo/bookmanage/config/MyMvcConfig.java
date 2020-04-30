package com.jo.bookmanage.config;

import com.jo.bookmanage.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //所有的WebMvcConfigurer组件会一起起作用
    @Bean
    public WebMvcConfigurer mvcconfigurer() {
        WebMvcConfigurer configurer = new WebMvcConfigurerAdapter() {
            //注册视图解析器
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //设置输入路径映射到指定的视图字段到templates文件夹下给模板引擎解析
                registry.addViewController("/login.html").setViewName("login");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {

                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/path");
//                        .excludePathPatterns("/login.html", "/","/login", "/webjars/**");
            }
        };
        return configurer;
    }


}
