package com.fabs;

import com.fabs.model.core.Audit;
import com.fabs.model.users.UserAccess;
import com.fabs.model.users.UserDecoration;
import com.fabs.service.TestService;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://examples.javacodegeeks.com/enterprise-java/spring/jpaorm/spring-hibernate-mysql-and-maven-showcase/
public class Main {

    private final static Logger logger = LogManager.getLogger();


    public static void main(String[] args){
        logger.info("Loading Spring applicationContext");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Audit audit = new Audit();
        audit.setUserId(12);
        audit.setIp("127.0.0.1");
        audit.setActivity("Testing");
        audit.setDevice("MAC");
        audit.setDescription("TestDescription");
        audit.setLocation(new GeometryFactory().createPoint(new Coordinate(5,2.5)));

        UserDecoration userDecoration = new UserDecoration();
        userDecoration.setUserAccess("BASIC");
        userDecoration.setUserDecorationName("locationUpdate");
        userDecoration.setDefaultValue("false");

        UserAccess userAccess = new UserAccess();
        userAccess.setId(1);
        userAccess.setUserAccessText("BASIC");

        TestService testService = (TestService) context.getBean("testService");
//        testService.runTest(audit);
//        testService.runUsersTest(userDecoration);
        testService.runUserAccessTest(userAccess);

        logger.debug(audit.toString());

        context.close();
    }
}
