package at.spengergasse.med_px.Medication;

import at.spengergasse.med_px.entities.Medication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MedicationMcvConfig implements WebMvcConfigurer {

    public void addViewController(ViewControllerRegistry registry) {
        registry.addViewController("/doctor/medication").setViewName("/medication/index");
    }
}
