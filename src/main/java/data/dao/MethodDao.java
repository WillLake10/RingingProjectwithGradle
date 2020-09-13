package data.dao;

import data.dto.Method;

import java.util.Set;

public interface MethodDao {

    void addMethod(Method method);

    Set<Method> getAllMethod();

    Set<Method> fullFieldSearch(String searchTerm);

    Set<Method> getMethodsForStage(int stage);

    Set<Method> getMethodsForStageAndName(String name, int stage);
}
