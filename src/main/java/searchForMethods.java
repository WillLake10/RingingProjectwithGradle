import data.dao.MethodDao;
import data.dto.Method;

import java.util.Set;

public class searchForMethods {

    private MethodDao methodDao;

    public Set<Method> findMethodByStageAndName(String name, int stage){
        Set<Method> methodsForStage  = methodDao.getMethodsForStage(stage);
        return methodsForStage;
    }

    public void setMethodDao(MethodDao methodDao) {
        this.methodDao = methodDao;
    }
}
