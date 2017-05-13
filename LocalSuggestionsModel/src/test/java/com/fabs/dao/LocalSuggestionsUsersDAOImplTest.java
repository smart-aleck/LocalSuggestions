package com.fabs.dao;

import com.fabs.dao.users.*;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.Access;
import com.fabs.model.users.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional(value = "transactionManagerUsers")
@Rollback(true)
public class LocalSuggestionsUsersDAOImplTest {

    @Autowired private AccessDAO accessDAO;
    @Autowired private AddressDAO addressDAO;
    @Autowired private DecorationDAO decorationDAO;
    @Autowired private PhoneDAO phoneDAO;
    @Autowired private ProfileDAO profileDAO;
    @Autowired private UserDAO userDAO;

    // BASIC TESTS [For all local_suggestions_users Entities]
    @Test
    public void accessDAOBasic() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)3L, accessDAO.count());
        Assert.assertEquals("Validate Find Id", (Integer) 1, accessDAO.find(1).getId());
    }
    @Test
    public void addressDAOBasic() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)2L, addressDAO.count());
        Assert.assertEquals("Validate Find Id", (Integer) 1, addressDAO.find(1).getId());
    }
    @Test
    public void decorationDAOBasic() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)12L, decorationDAO.count());
        Assert.assertEquals("Validate Find Id", (Integer) 1, decorationDAO.find(1).getId());
    }
    @Test
    public void phoneDAOBasic() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)5L, phoneDAO.count());
        Assert.assertEquals("Validate Find Id", (Integer) 1, phoneDAO.find(1).getId());
    }
    @Test
    public void profileDAOBasic() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)6L, profileDAO.count());
        Assert.assertEquals("Validate Find Id", (Integer) 1, profileDAO.find(1).getId());
    }
    @Test
    public void userDAOBasic() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)4L, userDAO.count());
        Assert.assertEquals("Validate Find Id", (Integer) 1, userDAO.find(1).getId());
    }

    // FIND SET TESTS
    @Test
    public void userDAOSelectSet() throws NotFoundException, MissingDataException {
        Set<Integer> usersToFind = new HashSet<>(Arrays.asList(1,2,3,4));
        Set<User> users = userDAO.find(usersToFind);
        Assert.assertEquals("Find Multiple Ids (All Exist)", 4, users.size());

        usersToFind = new HashSet<>(Arrays.asList(3,999));
        users = userDAO.find(usersToFind);
        Assert.assertEquals("Find Multiple Ids (Partially Exist)", 1, users.size());

        usersToFind = new HashSet<>(Arrays.asList(999,1000));
        users = userDAO.find(usersToFind);
        Assert.assertEquals("Find Multiple Ids (None Exist)", 0, users.size());

        usersToFind = new HashSet<>();
        users = userDAO.find(usersToFind);
        Assert.assertEquals("Find Multiple Ids (Empty Set)", 0, users.size());
    }

    // ID FIND EXCEPTION TESTS
    @Test(expected=NotFoundException.class)
    public void userNotFound() throws NotFoundException, MissingDataException {
        userDAO.find(999);
    }
    @Test(expected=NotFoundException.class)
    public void checkNegativeId() throws NotFoundException, MissingDataException {
        userDAO.find(-1);
    }
    @Test(expected=NotFoundException.class)
    public void checkNullId() throws NotFoundException, MissingDataException {
        Integer id = null;
        userDAO.find(id);
    }

    // DELETE / INSERT / UPDATE TESTS
    @Test
    public void accessUpdate() throws NotFoundException, MissingDataException {
        Access access = accessDAO.find(2);
        Assert.assertEquals("Check text before Update", "PRO", access.getAccessText());

        Integer version = access.getVersion();
        access.setAccessText("PRO2");
        accessDAO.saveOrUpdate(access);

        access = accessDAO.find(2);

        Assert.assertEquals("Check text after update", "PRO2", access.getAccessText());
        Assert.assertEquals("Check version after update", (Integer)(version+1), access.getVersion());
    }
    @Test
    public void accessDelete() throws NotFoundException, MissingDataException {
        Access access = accessDAO.find(1);
        Assert.assertEquals("Checking Counts before delete", (Long)3L, accessDAO.count());
        Assert.assertEquals("Check deleted before", false, access.getIsDeleted());

        Integer version = access.getVersion();
        accessDAO.delete(access);

        access = accessDAO.find(1);

        Assert.assertEquals("Check deleted after", true, access.getIsDeleted());
        Assert.assertEquals("Check version after delete", (Integer)(version+1), access.getVersion());

        Assert.assertEquals("Checking Counts after delete", (Long)2L, accessDAO.count());
        Assert.assertEquals("Checking Total Count", (Long)3L, accessDAO.count(true));
    }
    @Test
    public void accessAdd() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)3L, accessDAO.count());

        Access access = new Access();
        access.setAccessText("NEWACCESS1");
        Assert.assertNull("Checking Id Null for new Entity (Before Add)", access.getId());
        accessDAO.saveOrUpdate(access);
        Assert.assertNotNull("Checking Id Not Null for Entity (After Add)", access.getId());
        Assert.assertEquals("Checking New Id version", (Integer) 1, access.getVersion());

        Assert.assertEquals("Checking Counts", (Long)4L, accessDAO.count());
    }
    @Test(expected = MissingDataException.class)
    public void accessUpdateException() throws NotFoundException, MissingDataException {
        Access access = accessDAO.find(3);
        access.setIsDeleted(null);
        accessDAO.saveOrUpdate(access);
    }
}
