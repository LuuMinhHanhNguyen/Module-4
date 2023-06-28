package com.example.ex1.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.Arrays;
@Component
@Aspect
public class Logger {
    private long numOfRequestsToServer = 0;

    @Pointcut("within(com.example.ex1.controller.*)")
    public void countNumOfRequestToServer(){

    }

    @AfterThrowing(pointcut = "execution(public * com.example.ex1.service.BookService.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format(" :))) Errors detected: %s.%s%s: %s", className, method, args, e.getMessage()));
    }

    @AfterThrowing(pointcut = "execution(public * com.example.ex1.service.BorrowCodeService.*(..))", throwing = "e")
    public void logForBorrowCodes(JoinPoint joinPoint, Exception e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format(" :))) Errors detected: %s.%s%s: %s", className, method, args, e.getMessage()));
    }

    @AfterReturning("countNumOfRequestToServer()")
    public void afterCountNumOfRequestToServer(){
        this.numOfRequestsToServer ++;
        System.out.println("Number of requests to server: " + this.numOfRequestsToServer);
    }
    @AfterReturning( pointcut = "execution(* com.example.ex1.controller.BookController.borrowBooks(..))")
    public void logBookBorrowingProcess(JoinPoint joinPoint){
        System.out.println(" A book has been borrowed! Book ID: " + joinPoint.getArgs()[0]);
    }

    @AfterReturning( pointcut = "execution(* com.example.ex1.controller.BorrowCodeController.returnBorrowedBooks(..))")
    public void logBookReturnProcess(JoinPoint joinPoint){
        System.out.println(" A book has been returned! Codes: " + joinPoint.getArgs()[0]);
    }

}
