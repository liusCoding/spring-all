package com.liuscoding.aops;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;


/**
 * 切面类
 *
 * @Aspect: 告诉Spring当前类是一个切面类
 * @author liusoding
 */
@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    //1.本类引用
    //2.其它的切面引用

    @Pointcut("execution(public int com.liuscoding.aops.MathCalculator.*(..))")
    public void pointCut(){}

    /**
     * @Before 在目标方法之前切入： 切入点表达式（指定在哪个方法切入）
     * @param joinPoint
     */
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName() +"--> 运行之前...@Before --> 参数类表" + Arrays.asList(args) );
    }

    @After("com.liuscoding.aops.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() +"--> 运行结束...@After --> 方法结束"  );

    }

    //JoinPoint一定要出现在参数表的第一位
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName() +"--> 正常返回...@AfterReturning -->   结果：" + result  );
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println(joinPoint.getSignature().getName() +"--> 出现异常...@AfterThrowing --> 异常结果：" + exception  );
    }
}
