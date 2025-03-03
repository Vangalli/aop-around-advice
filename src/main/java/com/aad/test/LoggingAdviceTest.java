package com.aad.test;

public class LoggingAdviceTest package com.aad.test;

import com.aad.advice.LoggingAdvice;
import com.aad.beans.Calculator;
import com.aad.pointcut.LoggingDynamicPointcut;
import com.aad.pointcut.LoggingPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class LoggingAdviceTest {
    public static void main(String[] args) {
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(new Calculator());
        //pf.addAdvice(new LoggingAdvice());
        //pf.addAdvisor(new DefaultPointcutAdvisor(new LoggingPointcut(), new LoggingAdvice()));
        pf.addAdvisor(new DefaultPointcutAdvisor(new LoggingDynamicPointcut(), new LoggingAdvice()));

        Calculator proxy = (Calculator) pf.getProxy();
        int sum = proxy.add(10, 20);
        System.out.println("sum : " + sum);

        sum = proxy.add(10, 20);
        System.out.println("sum : " + sum);

        sum = proxy.add(100, 200);
        System.out.println("sum : " + sum);

        int mul = proxy.multiply(10, 20);
        System.out.println("multiply : "+ mul);
    }
}
{
}
