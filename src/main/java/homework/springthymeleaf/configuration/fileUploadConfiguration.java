package homework.springthymeleaf.configuration;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class fileUploadConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("file:src/main/resources/Image/aaa.png");
        registry.addResourceHandler("/resources/**").addResourceLocations("file:src/main/resources/Image/");
    }
}


