package com.fabs.dao;

import com.fabs.dao.core.*;
import com.fabs.model.core.*;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;
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
@Transactional(value = "transactionManagerCore")
@Rollback(true)
public class LocalSuggestionsCoreDAOImplTest {

    @Autowired private ActionDAO actionDAO;
    @Autowired private AttachmentDAO attachmentDAO;
    @Autowired private AuditDAO auditDAO;
    @Autowired private CommentAttachmentDAO commentAttachmentDAO;
    @Autowired private CommentDAO commentDAO;
    @Autowired private CommentLocationDAO commentLocationDAO;
    @Autowired private SuggestionActionDAO suggestionActionDAO;
    @Autowired private SuggestionAttachmentDAO suggestionAttachmentDAO;
    @Autowired private SuggestionDAO suggestionDAO;
    @Autowired private SuggestionTagDAO suggestionTagDAO;
    @Autowired private UserDecorationOverrideDAO userDecorationOverrideDAO;

    // BASIC TESTS [For all local_suggestions_core Entities]
    @Test
    public void actionDAOBasic() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)3L, actionDAO.count());
        Assert.assertEquals("Validate Find Id", (Integer) 1, actionDAO.find(1).getId());
    }
    @Test
    public void attachmentDAOBasic() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)0L, attachmentDAO.count());
    }
    @Test
    public void commentDAOBasic() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)3L, commentDAO.count());
        Assert.assertEquals("Validate Find Id", (Long)1L, commentDAO.find(1L).getId());
    }
    @Test
    public void commentAttachmentDAOBasic() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)0L, commentAttachmentDAO.count());
    }
    @Test
    public void commentLocationDAOBasic() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)2L, commentLocationDAO.count());
        Assert.assertEquals("Validate Find Id", (Integer) 1, commentLocationDAO.find(1).getId());
    }
    @Test
    public void suggestionDAOBasic() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)3L, suggestionDAO.count());
        Assert.assertEquals("Validate Find Id", (Long)1L, suggestionDAO.find(1L).getId());
    }
    @Test
    public void suggestionActionDAOBasic() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)4L, suggestionActionDAO.count());
        Assert.assertEquals("Validate Find Id", (Long)1L, suggestionActionDAO.find(1L).getId());
    }
    @Test
    public void suggestionAttachmentDAOBasic() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)0L, suggestionAttachmentDAO.count());
    }
    @Test
    public void suggestionTagDAOBasic() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)9L, suggestionTagDAO.count());
        Assert.assertEquals("Validate Find Id", (Long)1L, suggestionTagDAO.find(1L).getId());
    }
    @Test
    public void userDAOBasic() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)2L, userDecorationOverrideDAO.count());
        Assert.assertEquals("Validate Find Id", (Integer) 1, userDecorationOverrideDAO.find(1).getId());
    }

    // ID FIND EXCEPTION TESTS
    @Test(expected=NotFoundException.class)
    public void suggestionNotFound() throws NotFoundException, MissingDataException {
        suggestionDAO.find(999L);
    }
    @Test(expected=NotFoundException.class)
    public void checkNegativeId() throws NotFoundException, MissingDataException {
        suggestionDAO.find(-1L);
    }
    @Test(expected=NotFoundException.class)
    public void checkNullId() throws NotFoundException, MissingDataException {
        Long id = null;
        suggestionDAO.find(id);
    }

    // DELETE / INSERT / UPDATE TESTS
    @Test
    public void actionUpdate() throws NotFoundException, MissingDataException {
        Action action = actionDAO.find(2);
        Assert.assertEquals("Check text before Update", "UPVOTE", action.getActionText());

        Integer version = action.getVersion();
        action.setActionText("UPVOTE2");
        actionDAO.saveOrUpdate(action);

        action = actionDAO.find(2);

        Assert.assertEquals("Check text after update", "UPVOTE2", action.getActionText());
        Assert.assertEquals("Check version after update", (Integer)(version+1), action.getVersion());
    }
    @Test
    public void actionDelete() throws NotFoundException, MissingDataException {
        Action action = actionDAO.find(2);
        Assert.assertEquals("Checking Counts before delete", (Long)3L, actionDAO.count());
        Assert.assertEquals("Check deleted before", false, action.getIsDeleted());

        Integer version = action.getVersion();
        actionDAO.delete(action);

        action = actionDAO.find(2);

        Assert.assertEquals("Check deleted after", true, action.getIsDeleted());
        Assert.assertEquals("Check version after delete", (Integer)(version+1), action.getVersion());

        Assert.assertEquals("Checking Counts after delete", (Long)2L, actionDAO.count());
        Assert.assertEquals("Checking Total Count", (Long)3L, actionDAO.count(true));
    }
    @Test
    public void actionAdd() throws NotFoundException, MissingDataException {
        Assert.assertEquals("Checking Counts", (Long)3L, actionDAO.count());

        Action action = new Action();
        action.setActionText("NEWACTION1");
        Assert.assertNull("Checking Id Null for new Entity (Before Add)", action.getId());
        actionDAO.saveOrUpdate(action);
        Assert.assertNotNull("Checking Id Not Null for Entity (After Add)", action.getId());
        Assert.assertEquals("Checking New Id version", (Integer) 1, action.getVersion());

        Assert.assertEquals("Checking Counts", (Long)4L, actionDAO.count());
    }
    @Test(expected = MissingDataException.class)
    public void actionAddException() throws MissingDataException, NotFoundException {
        Action action = actionDAO.find(1);
        action.setIsDeleted(null);
        actionDAO.saveOrUpdate(action);
    }

    // UPDATE / DELETE SET TESTS
    @Test
    public void suggestionTagDAOUpdateSet() throws NotFoundException, MissingDataException {

        Assert.assertEquals("Checking Counts before", (Long)9L, suggestionTagDAO.count());

        Suggestion suggestion = suggestionDAO.find(1L);

        SuggestionTag suggestionTag1 = new SuggestionTag();
        suggestionTag1.setSuggestion(suggestion);
        suggestionTag1.setTag("TAG1");

        SuggestionTag suggestionTag2 = new SuggestionTag();
        suggestionTag2.setSuggestion(suggestion);
        suggestionTag2.setTag("TAG2");

        Set<SuggestionTag> suggestionTags = new HashSet<>(Arrays.asList(suggestionTag1, suggestionTag2));
        suggestionTagDAO.saveOrUpdate(suggestionTags);

        Assert.assertEquals("Checking Counts after", (Long)11L, suggestionTagDAO.count());
    }
    @Test
    public void suggestionTagDAODeleteSet() throws NotFoundException, MissingDataException {

        Assert.assertEquals("Checking Counts before", (Long)9L, suggestionTagDAO.count());

        SuggestionTag suggestionTag1 = suggestionTagDAO.find(7L);
        SuggestionTag suggestionTag2 = suggestionTagDAO.find(8L);
        SuggestionTag suggestionTag3 = suggestionTagDAO.find(9L);

        Set<SuggestionTag> suggestionTags = new HashSet<>(Arrays.asList(suggestionTag1, suggestionTag2, suggestionTag3));
        suggestionTagDAO.delete(suggestionTags);

        Assert.assertEquals("Checking Counts after", (Long)6L, suggestionTagDAO.count());
        Assert.assertEquals("Checking Total Count", (Long)9L, suggestionTagDAO.count(true));
    }

    // CHECKING JOIN SETS (ONE-MANY)
    @Test
    public void suggestionOneToManyEntities() throws NotFoundException {
        Suggestion suggestion = suggestionDAO.find(1L);

        Assert.assertEquals("Checking Comments count", 2, suggestion.getComments().size());
        Assert.assertEquals("Checking SuggestionTags count", 6, suggestion.getSuggestionTags().size());
        Assert.assertEquals("Checking SuggestionAttachments count", 0, suggestion.getSuggestionAttachments().size());
        Assert.assertEquals("Checking SuggestionActions count", 3, suggestion.getSuggestionActions().size());
    }

    // CUSTOM QUERIES
    @Test
    public void suggestionFindByUser() throws NotFoundException {
        Set<Suggestion> suggestions = suggestionDAO.findByUser(1);

        Assert.assertEquals("Checking Suggestion count", 2, suggestions.size());
    }
    @Test
    public void suggestionFindByLocation() throws NotFoundException {
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 26910);
        Point location = geometryFactory.createPoint(new Coordinate(-0.1620211, 51.4346670));
        Set<Suggestion> suggestions = suggestionDAO.find(location,10.0);

        Assert.assertEquals("Checking Suggestion count", 2, suggestions.size());
    }
}
