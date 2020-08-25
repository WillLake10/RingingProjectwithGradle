package data.dao;

import data.dto.Method;

import java.util.Set;

public interface MethodDao {

    void addMethod(Method method);

    Set<Method> getAllMethod();
}