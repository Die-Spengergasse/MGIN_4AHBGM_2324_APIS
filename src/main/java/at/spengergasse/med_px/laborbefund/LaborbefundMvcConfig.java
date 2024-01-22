package at.spengergasse.med_px.laborbefund;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LaborbefundMvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/doctor/laborbefund").setViewName("laborbefund/laborbefund");
        registry.addViewController("/doctor/create_laborbefund").setViewName("laborbefund/create_laborbefund");
    }
}
