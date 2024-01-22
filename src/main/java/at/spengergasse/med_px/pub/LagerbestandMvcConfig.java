package at.spengergasse.med_px.pub;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * define routes for public pages
 */
@Configuration
public class LagerbestandMvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/doctor/formular").setViewName("/lagerbestand/createLagerbestand"); //http://localhost:8080/formular
        registry.addViewController("/doctor/lagerbestandtabelle").setViewName("/lagerbestand/lagerbestandTabelle");
    }

}