package at.spengergasse.med_px.surgery;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class SurgeryMvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/doctor/surgery").setViewName("/surgery/SurgeryFormular");
        registry.addViewController("/doctor/surgerytb").setViewName("/surgery/Surgeryhtml");

    }
}
