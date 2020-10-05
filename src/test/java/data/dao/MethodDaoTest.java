package data.dao;

import com.google.common.collect.Iterables;
import data.dto.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/testCtx-data.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MethodDaoTest {

    private final Logger log = LogManager.getLogger(this.getClass());

    @Autowired
    private MethodDao methodDao;

    @Test
    public void canCreateandRetreveMethod() {
        Method inMethod = new Method("Bob",
                11,
                22,
                1,
                "135274068E9",
                "",
                "palindromic",
                "Plain",
                "Plain Bob Cinques",
                "E.1.E.1.E.1.E.1.E.1.E,12E",
                "m14065",
                "Bob Cinques methods with a lead length of 22 and 1 hunt bell");
        methodDao.addMethod(inMethod);

        Set<Method> allMethods = methodDao.getAllMethod();
        assertNotNull(allMethods);
        assertEquals(1, allMethods.size());

        Method method = Iterables.getOnlyElement(allMethods);
        log.info("Found Evening [{}]", method.toString());
        assertEquals("Bob", method.getClassification());
        assertEquals(11, method.getStage());
        assertEquals(22, method.getLengthOfLead());
        assertEquals(1, method.getNumberOfHunts());
        assertEquals("135274068E9", method.getLeadHead());
        assertEquals("", method.getLeadHeadCode());
        assertEquals("palindromic", method.getSymmetry());
        assertEquals("Plain", method.getName());
        assertEquals("Plain Bob Cinques", method.getTitle());
        assertEquals("E.1.E.1.E.1.E.1.E.1.E,12E", method.getNotation());
        assertEquals("m14065", method.getCCCBRID());
        assertEquals("Bob Cinques methods with a lead length of 22 and 1 hunt bell", method.getNotes());
    }

    @Test
    public void canSearchAllFieldsTitle() {
        methodDao.addMethod(new Method("Bob",
                11,
                22,
                1,
                "135274068E9",
                "",
                "palindromic",
                "Plain",
                "Plain Bob Cinques",
                "E.1.E.1.E.1.E.1.E.1.E,12E",
                "m14065",
                "Bob Cinques methods with a lead length of 22 and 1 hunt bell"));
        methodDao.addMethod(new Method("Surprise",
                10,
                40,
                1,
                "1573920486",
                "b",
                "palindromic",
                "Braunstone",
                "Braunstone Surprise Royal",
                "-30-14-50-16-1270-38-14-50.78.16.78.90,12",
                "m21366",
                "Surprise Royal methods with a lead length of 40 and 1 hunt bell"));

        Set<Method> allMethods = methodDao.fullFieldSearch("Plain Bob");
        assertNotNull(allMethods);
        assertEquals(1, allMethods.size());

        Method method = Iterables.getOnlyElement(allMethods);
        log.info("Found Evening [{}]", method.toString());
        assertEquals("Bob", method.getClassification());
        assertEquals(11, method.getStage());
        assertEquals(22, method.getLengthOfLead());
        assertEquals(1, method.getNumberOfHunts());
        assertEquals("135274068E9", method.getLeadHead());
        assertEquals("", method.getLeadHeadCode());
        assertEquals("palindromic", method.getSymmetry());
        assertEquals("Plain", method.getName());
        assertEquals("Plain Bob Cinques", method.getTitle());
        assertEquals("E.1.E.1.E.1.E.1.E.1.E,12E", method.getNotation());
        assertEquals("m14065", method.getCCCBRID());
        assertEquals("Bob Cinques methods with a lead length of 22 and 1 hunt bell", method.getNotes());

    }

    @Test
    public void canSearchAllFieldsStage() {
        methodDao.addMethod(new Method("Bob",
                11,
                22,
                1,
                "135274068E9",
                "",
                "palindromic",
                "Plain",
                "Plain Bob Cinques",
                "E.1.E.1.E.1.E.1.E.1.E,12E",
                "m14065",
                "Bob Cinques methods with a lead length of 22 and 1 hunt bell"));
        methodDao.addMethod(new Method("Surprise",
                10,
                40,
                1,
                "1573920486",
                "b",
                "palindromic",
                "Braunstone",
                "Braunstone Surprise Royal",
                "-30-14-50-16-1270-38-14-50.78.16.78.90,12",
                "m21366",
                "Surprise Royal methods with a lead length of 40 and 1 hunt bell"));

        Set<Method> allMethods = methodDao.fullFieldSearch("11");
        assertNotNull(allMethods);
        assertEquals(1, allMethods.size());

        Method method = Iterables.getOnlyElement(allMethods);
        log.info("Found Evening [{}]", method.toString());
        assertEquals("Bob", method.getClassification());
        assertEquals(11, method.getStage());
        assertEquals(22, method.getLengthOfLead());
        assertEquals(1, method.getNumberOfHunts());
        assertEquals("135274068E9", method.getLeadHead());
        assertEquals("", method.getLeadHeadCode());
        assertEquals("palindromic", method.getSymmetry());
        assertEquals("Plain", method.getName());
        assertEquals("Plain Bob Cinques", method.getTitle());
        assertEquals("E.1.E.1.E.1.E.1.E.1.E,12E", method.getNotation());
        assertEquals("m14065", method.getCCCBRID());
        assertEquals("Bob Cinques methods with a lead length of 22 and 1 hunt bell", method.getNotes());

    }

    @Test
    public void canGetMethodsForStage() {
        methodDao.addMethod(new Method("Bob",
                11,
                22,
                1,
                "135274068E9",
                "",
                "palindromic",
                "Plain",
                "Plain Bob Cinques",
                "E.1.E.1.E.1.E.1.E.1.E,12E",
                "m14065",
                "Bob Cinques methods with a lead length of 22 and 1 hunt bell"));
        methodDao.addMethod(new Method("Surprise",
                10,
                40,
                1,
                "1573920486",
                "b",
                "palindromic",
                "Braunstone",
                "Braunstone Surprise Royal",
                "-30-14-50-16-1270-38-14-50.78.16.78.90,12",
                "m21366",
                "Surprise Royal methods with a lead length of 40 and 1 hunt bell"));
        methodDao.addMethod(new Method("Surprise",
                10,
                40,
                1,
                "1573920486",
                "b",
                "palindromic",
                "Cambridge",
                "Cambridge Surprise Royal",
                "x30x14x1250x36x1470x58x16x70x18x90,12",
                "m21365",
                "Surprise Royal methods with a lead length of 40 and 1 hunt bell"));

        Set<Method> allMethods = methodDao.getMethodsForStage(10);
        assertNotNull(allMethods);
        assertEquals(2, allMethods.size());
    }

    @Test
    public void canSearchMethodsByNameAndStage() {
        methodDao.addMethod(new Method("Bob",
                11,
                22,
                1,
                "135274068E9",
                "",
                "palindromic",
                "Plain",
                "Plain Bob Cinques",
                "E.1.E.1.E.1.E.1.E.1.E,12E",
                "m14065",
                "Bob Cinques methods with a lead length of 22 and 1 hunt bell"));
        methodDao.addMethod(new Method("Surprise",
                10,
                40,
                1,
                "1573920486",
                "b",
                "palindromic",
                "Braunstone",
                "Braunstone Surprise Royal",
                "-30-14-50-16-1270-38-14-50.78.16.78.90,12",
                "m21366",
                "Surprise Royal methods with a lead length of 40 and 1 hunt bell"));
        methodDao.addMethod(new Method("Surprise",
                10,
                40,
                1,
                "1573920486",
                "b",
                "palindromic",
                "Cambridge",
                "Cambridge Surprise Royal",
                "x30x14x1250x36x1470x58x16x70x18x90,12",
                "m21365",
                "Surprise Royal methods with a lead length of 40 and 1 hunt bell"));

        Set<Method> searchResults = methodDao.getMethodsForStageAndName("Cambridge", 10);
        assertNotNull(searchResults);
        assertEquals(1, searchResults.size());
    }

    @Test
    public void canSearchMethodsByName() {
        methodDao.addMethod(new Method("Surprise",
                10,
                40,
                1,
                "1573920486",
                "b",
                "palindromic",
                "Braunstone",
                "Braunstone Surprise Royal",
                "-30-14-50-16-1270-38-14-50.78.16.78.90,12",
                "m21366",
                "Surprise Royal methods with a lead length of 40 and 1 hunt bell"));
        methodDao.addMethod(new Method("Surprise",
                10,
                40,
                1,
                "1573920486",
                "b",
                "palindromic",
                "Cambridge",
                "Cambridge Surprise Royal",
                "x30x14x1250x36x1470x58x16x70x18x90,12",
                "m21365",
                "Surprise Royal methods with a lead length of 40 and 1 hunt bell"));

        Set<Method> searchResults = methodDao.getMethodsForName("Cambridge");
        assertNotNull(searchResults);
        assertEquals(1, searchResults.size());

        Method method = Iterables.getOnlyElement(searchResults);
        log.info("Found Evening [{}]", method.toString());
        assertEquals("Cambridge Surprise Royal", method.getTitle());
    }
}