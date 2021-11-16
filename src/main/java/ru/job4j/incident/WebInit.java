package ru.job4j.incident;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import ru.job4j.incident.config.HbmConfig;
import ru.job4j.incident.config.JdbcConfig;
import ru.job4j.incident.config.WebConfig;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInit implements WebApplicationInitializer  {
    @Override
    public void onStartup(ServletContext servletCxt) throws ServletException {
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
//        ac.register(WebConfig.class);
        ac.register(WebConfig.class, HbmConfig.class);
        ac.refresh();

        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        filter.setForceRequestEncoding(true);
        FilterRegistration.Dynamic encoding = servletCxt.addFilter("encoding", filter);
        encoding.addMappingForUrlPatterns(null, false, "/*");

        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}