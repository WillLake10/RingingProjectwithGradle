package data.dao;

import com.google.common.collect.Iterables;
import data.dto.Method;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations={"/spring/testCtx-data.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MethodDaoTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MethodDao methodDao;

    @Test
    public void canCreateandRetreveMethod(){
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
        assertEquals("m14065", method.getMethodId());
        assertEquals("Bob Cinques methods with a lead length of 22 and 1 hunt bell", method.getNotes());
    }
}
