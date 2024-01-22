/**
 * Created: 2022-12-10
 * Author: Rudolf Radlbauer
 */
package at.spengergasse.med_px.abrechnungen;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * define routes for public pages
 */
@Configuration
public class AbrechnungMvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/doctor/abrechnungformular").setViewName("/abrechnung/Abrechnungs_Formular");
        registry.addViewController("/doctor/abrechnungtabelle").setViewName("/abrechnung/tabelle");
    }

}
