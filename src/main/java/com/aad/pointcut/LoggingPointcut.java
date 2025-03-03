package com.aad.pointcut;

import com.aad.beans.Calculator;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class LoggingPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("in pointcut: " + method.getName());

        if (targetClass.isAssignableFrom(Calculator.class) && method.getName().equals("add")) {
            return true;
        }
        return false;
    }
}
