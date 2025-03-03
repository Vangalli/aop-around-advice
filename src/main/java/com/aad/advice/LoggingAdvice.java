package com.aad.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class LoggingAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        Object[] args = invocation.getArguments();
        StringBuilder builder = new StringBuilder();

        builder.append("entered into " + method.getName() + "(");
        for (int i = 0; i < args.length; i++) {
            if (i == 0) {
                builder.append(args[i]);
                continue;
            }
            builder.append("," + args[i]);
        }
        builder.append(")");
        System.out.println(builder.toString());

        args[0] = (Integer) args[0] + 1;
        args[1] = (Integer) args[1] + 1;

        Object ret = invocation.proceed();

        System.out.println("exiting from " + method.getName() + " with ret val : " + ret);

        ret = (Integer) ret + 1;

        return ret;
    }
}
