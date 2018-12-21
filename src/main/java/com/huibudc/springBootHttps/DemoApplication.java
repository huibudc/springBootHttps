package com.huibudc.springBootHttps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.Ssl;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;

/**
*
* @author
* @since
*/ @SpringBootApplication
public class DemoApplication implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		factory.setPort(8090);
		factory.setContextPath("/https-demo");
		factory.setSsl(getSsl());
	}

	private Ssl getSsl() {
		Ssl ssl = new Ssl();
		ssl.setEnabled(true);
		ssl.setKeyStore("classpath:keystore.p12");
		ssl.setKeyStorePassword("123456"); //use setKeyPassword will cause exception : Private key must be accompanied by certificate chain
		ssl.setKeyStoreType("PKCS12");
		ssl.setKeyAlias("tomcat");
		return ssl;
	}
}

