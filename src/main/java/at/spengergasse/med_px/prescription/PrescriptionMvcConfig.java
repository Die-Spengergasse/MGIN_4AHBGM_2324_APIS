/**
 * Created: 2022-12-10
 * Author: Rudolf Radlbauer
 */
package at.spengergasse.med_px.prescription;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * define route for user administration page
 */
@Configuration
public class PrescriptionMvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/doctor/prescription").setViewName("/prescription/prescription");
        registry.addViewController("/admin/prescription").setViewName("/prescription/prescription");

    }
}
