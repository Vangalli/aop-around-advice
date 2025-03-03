package com.aad.pointcut;

import com.aad.beans.Calculator;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class LoggingDynamicPointcut extends DynamicMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        System.out.println("matches(...)");
        if (targetClass.isAssignableFrom(Calculator.class) && method.getName().equals("add")
                && (Integer) args[0] >= 100 && (Integer) args[1] >= 100) {
            return true;
        }
        return false;
    }
}
