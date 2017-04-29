package com.fabs;

import com.fabs.model.Audit;
import com.fabs.service.TestService;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private final static Logger logger = LogManager.getLogger();

    // https://examples.javacodegeeks.com/enterprise-java/spring/jpaorm/spring-hibernate-mysql-and-maven-showcase/

    public static void main(String[] args){
        logger.info("Loading Spring applicationContext");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Audit audit = new Audit();
        audit.setIp("127.0.0.1");
        audit.setActivity("Testing");
        audit.setDevice("MAC");
        audit.setDescription("TestDescription");
        audit.setLocation(new GeometryFactory().createPoint(new Coordinate(5,2.5)));

        TestService testService = (TestService) context.getBean("testService");
        testService.runTest(audit);

        logger.debug(audit.toString());

        context.close();
    }
}
