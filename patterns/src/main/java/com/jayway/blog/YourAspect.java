package com.jayway.blog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;

@Aspect
public class YourAspect {

    //Patterns
    //blank = modifier (public/private/protected or default(blank) should be looked for
    //* = return type to look for. Void/Object/Primitive type
    //com.jayway.YourClass.yourMethodBefore(..) = PackageName . ClassName . methodName (parameters)
    @Before("execution (* com.jayway.blog.YourClass.yourMethodBefore(..))")
    //JointPoint = the reference of the call to the method
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("YourAspect's BeforeAdvice's body is now executed Before yourMethodBefore is called.");
    }
    //Patterns
    //public = look for the specific modifier named public
    //!Object = Basically we are looking for void or primitives. But if we specified Object we could get a good pattern
    //com.jayway.YourClass.yourMethodBefore(..) = PackageName . ClassName . methodName (parameters)
    @After("execution (public !Object com.jayway.blog.YourClass.yourMethodAfter(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("YourAspect's afterAdvice's body is now executed After yourMethodAfter is called.");
    }
    //Patterns
    //!private = look for any modifier that's not private
    //void = looking for method with void
    //com.jayway.YourClass.yourMethodBefore(..) = PackageName . ClassName . methodName (parameters)
    @Around("execution (!private void com.jayway.blog.YourClass.yourMethodAround(Integer,..))")
    //ProceedingJointPoint = the reference of the call to the method.
    //Difference between ProceedingJointPoint and JointPoint is that a JointPoint can't be continued(proceeded)
    //A ProceedingJointPoint can be continued(proceeded) and is needed for an Around advice
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        //Default Object that we can use to return to the consumer
        Object returnObject = null;
        try {
            System.out.println("YourAspect's aroundAdvice's body is now executed Before yourMethodAround is called.");
            //We choose to continue the call to the method in question
            returnObject = joinPoint.proceed();
            //If no exception is thrown we should land here and we can modify the returnObject, if we want to.
        } catch (Throwable throwable) {
            //Here we can catch and modify any exceptions that are called
            //We could potentially not throw the exception to the caller and instead return "null" or a default object.
            throw throwable;
        }
        finally {
            //If we want to be sure that some of our code is executed even if we get an exception
            System.out.println("YourAspect's aroundAdvice's body is now executed After yourMethodAround is called.");
        }

        return returnObject;
    }
    //Patterns
    //blank = modifier (public/private/protected or default(blank) should be looked for
    //* = return type to look for. Void/Object/Primitive type
    //com.jayway.YourClass.yourMethod*(..) = PackageName . ClassName . * (parameters)
    //Where the "*" will catch any method name
    @After("execution ( * com.jayway.blog.YourClass.*(..))")
    //JointPoint = the reference of the call to the method
    public void printNewLine(JoinPoint pointcut){
        //Just prints new lines after each method that's executed in
        System.out.print("\n\r");
    }
}
