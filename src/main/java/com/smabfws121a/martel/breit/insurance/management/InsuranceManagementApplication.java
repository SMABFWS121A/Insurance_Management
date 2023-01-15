package com.smabfws121a.martel.breit.insurance.management;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@Theme(value = "abc_insurance")
@PWA(name = "ABC Insurance", shortName = "ABC Insurance", offlineResources = {})
@NpmPackage(value = "line-awesome", version = "1.3.0")
public class InsuranceManagementApplication implements AppShellConfigurator {

    public InsuranceManagementApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(InsuranceManagementApplication.class, args);
    }
}
