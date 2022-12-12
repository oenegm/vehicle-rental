package com.project.vehiclerental;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Aspect
public class CleanAssNameAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.project.vehiclerental.services.UserService.saveUser(..))")
    public void logToConsole(ProceedingJoinPoint joinPoint) throws Throwable {
        List<String> validNames = new ArrayList<String>();
        validNames.add("Jamal");
        validNames.add("Johnson");
        validNames.add("Denzel");
        logger.info("Checking if username complies with the rules...");

        if (validNames.contains(joinPoint.getArgs()[0])) {
            logger.info("Username is valid");
            joinPoint.proceed();
        } else {
            logger.info("Username is invalid");
        }
    }
}
