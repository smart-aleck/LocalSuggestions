package com.fabs.dao.core;

import com.fabs.dao.users.AccessDAO;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AccessDAOImplTest {

    @Autowired
    private AccessDAO accessDAO;

    @Test
    @Transactional(value = "transactionManagerUsers")
    @Rollback(true)
    public void testAddDepartment() throws NotFoundException, MissingDataException {
        Assert.assertEquals(Long.parseLong(String.valueOf(accessDAO.find(1).getId())) , 1);
        Assert.assertEquals(Long.parseLong(String.valueOf(accessDAO.find(2).getId())) , 2);
        Assert.assertEquals(Long.parseLong(String.valueOf(accessDAO.find(3).getId())) , 3);

        Assert.assertEquals(Long.parseLong(String.valueOf(accessDAO.count())), 3L);
    }
}
