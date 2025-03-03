package com.aad.advice;

import com.aad.helper.Cache;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class CacheAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        Object[] args = invocation.getArguments();
        Cache cache = null;
        String key = null;

        key = method.getName() + "(";
        for (int i = 0; i < args.length; i++) {
            if (i == 0) {
                key += args[i];
                continue;
            }
            key += "," + args[i];
        }
        key += ")";

        cache = Cache.getInstance();
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        Object ret = invocation.proceed();
        cache.put(key, ret);

        return ret;
    }
}










