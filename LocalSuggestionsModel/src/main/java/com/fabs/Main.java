package com.fabs;

import com.fabs.model.core.Audit;
import com.fabs.model.core.UserDecorationOverride;
import com.fabs.model.users.Access;
import com.fabs.model.users.Decoration;
import com.fabs.model.users.User;
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

        Access access = new Access();
        access.setId(1);
        access.setAccessText("BASIC");

        TestService testService = (TestService) context.getBean("testService");
        testService.runAuditTest(audit);
        access = testService.runUserAccessTest(access);

        Decoration decoration = new Decoration();
        decoration.setId(1);
        decoration.setDecorationName("locationUpdate");
        decoration.setDefaultValue("false");
        decoration.setAccess(access);

        testService.runDecorationTest(decoration);

        User user = new User();
        user.setId(1);
        user.setEmail("ali.asghar@localsuggestions.com");
        user.setPasswordHash("passwordHash");
        user.setPasswordSalt("passwordSalt");
        user.setAccess(access);

        user = testService.runUserTest(user);

        UserDecorationOverride userDecorationOverride = new UserDecorationOverride();
        userDecorationOverride.setId(1);
        userDecorationOverride.setDecorationName("locationUpdate");
        userDecorationOverride.setDefaultValue("false");
        userDecorationOverride.setDecorationId(decoration.getId());
        userDecorationOverride.setUserId(user.getId());

        userDecorationOverride = testService.runUserDecorationOverrideTest(userDecorationOverride);

        logger.debug(audit.toString());
        logger.debug(access.toString());
        logger.debug(decoration.toString());
        logger.debug(user.toString());
        logger.debug(userDecorationOverride.toString());

        context.close();
    }
}
