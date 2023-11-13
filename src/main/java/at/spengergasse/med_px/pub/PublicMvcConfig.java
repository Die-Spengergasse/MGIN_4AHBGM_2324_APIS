/**
 * Created: 2022-12-10
 * Author: Rudolf Radlbauer
 */
package at.spengergasse.med_px.pub;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * define routes for public pages
 */
@Configuration
public class PublicMvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/pub/welcome");
        registry.addViewController("/pub/welcome").setViewName("/pub/welcome");
        registry.addViewController("/pub/login").setViewName("/pub/login");
    }

}
