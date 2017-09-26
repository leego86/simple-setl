package com.lppz.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.lppz.dubbo.BaseMicroStartup;

@Configuration
@ImportResource({"classpath:/META-INF/micro-server-spring.xml"})
//@Import({DubboKafkaProducerConfiguration.class})
public class EtlServiceStartup extends BaseMicroStartup{
	static Logger logger = LoggerFactory.getLogger(EtlServiceStartup.class);
	private static AnnotationConfigApplicationContext context;
	static {
		context = new AnnotationConfigApplicationContext(EtlServiceStartup.class);
	}
	
	public static void main(String[] args) {
		startup(context, 10);
	}
}
