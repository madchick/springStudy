package com.example.aopdemo.aop;

import com.example.aopdemo.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.aopdemo.controller..*.*(..))")
    private void cut() {}

    @Pointcut("@annotation(com.example.aopdemo.annotation.Decode)")
    private void enableDecode() {}

    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        for(Object arg : args) {
            if(arg instanceof User) {
                User user = User.class.cast(arg);
                String base64Email = user.getEmail();
                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");
                user.setEmail(email);
            }
        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObject")
    public void afterReturn(JoinPoint joinPoint, Object returnObject) {
        if (returnObject instanceof User) {
            User user = User.class.cast(returnObject);

            String email = user.getEmail();
            String base64Email = Base64.getEncoder().encodeToString(email.getBytes());
            user.setEmail(base64Email);
        }
    }

}
