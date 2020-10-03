package data.gen;

import data.dao.MethodDao;
import data.dto.Method;
import util.userInput;

import java.util.Set;

public class methodGen {

    private MethodDao methodDao;

    public Method getMethodFromUser() {
        Method method = new Method();
        if (useMethodFromDB()) {
            method = getMethodFromDB();
        }
        return method;
    }

    private Method getMethodFromDB() {
        System.out.print("Enter method name: ");
        String methodName = userInput.getStringInput();
        System.out.print("Do you want to search by number of bells as well(y/n): ");
        String input = userInput.getStringInputMulti();
        Set<Method> dbReturn;
        if (input.toLowerCase().contains("y")) {
            System.out.print("Enter number of bells: ");
            int numBells = userInput.getIntInput();
            dbReturn = methodDao.getMethodsForStageAndName(methodName,numBells);
        } else {
            dbReturn = methodDao.getMethodsForName(methodName);
        }
        return null;
    }

    private static boolean useMethodFromDB() {
        System.out.print("Use an existing method (y/n): ");
        String input = userInput.getStringInput();
        if (input.toLowerCase().contains("y")) {
            return true;
        } else {
            return false;
        }
    }

    public void setMethodDao(MethodDao methodDao) {
        this.methodDao = methodDao;
    }
}
