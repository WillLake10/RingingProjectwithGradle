package data.dao;

import com.google.common.collect.Iterables;
import data.dto.Method;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MethodDaoTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MethodDao methodDao;

    @Test
    public void canCreateandRetreveMethod(){
        methodDao.addMethod(new Method("Bob", 11, 22, 1, "135274068E9", "", "palindromic", "Plain", "Plain Bob Cinques", "E.1.E.1.E.1.E.1.E.1.E,12E", "m14065", "Bob Cinques methods with a lead length of 22 and 1 hunt bell"));

        Set<Method> allMethods = methodDao.getAllMethod();
        assertNotNull(allMethods);
        assertEquals(1, allMethods.size());

        Method method = Iterables.getOnlyElement(allMethods);
    }
}
