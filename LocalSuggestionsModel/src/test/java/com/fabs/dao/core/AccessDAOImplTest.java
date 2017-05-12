package com.fabs.dao.core;

import com.fabs.dao.users.AccessDAO;
import com.fabs.dao.users.impl.AccessDAOImpl;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.Access;
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
        Access access = accessDAO.find(1);
        Assert.assertEquals(Long.parseLong(String.valueOf(access.getId())) , 1);
    }
}
