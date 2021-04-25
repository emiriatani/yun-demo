package com.myf.demo.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.utils.ReflectUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.rpc.filter.ExceptionFilter;
import com.alibaba.dubbo.rpc.service.GenericService;

/**
 * @ClassName com.myf.demo.filter MyDubboExceptionFilter
 * @Description
 * @Author Afengis
 * @Date 2021/4/21 10:21
 * @Version V1.0
 **/
@Activate(group = Constants.PROVIDER)
public class MyDubboExceptionFilter implements Filter {

    private final Logger logger;

    public MyDubboExceptionFilter() {
        this(LoggerFactory.getLogger(ExceptionFilter.class));
    }

    public MyDubboExceptionFilter(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            Result result = invoker.invoke(invocation);
            if (result.hasException() && GenericService.class != invoker.getInterface()) {
                try {
                    Throwable exception = result.getException();

                    // directly throw if it's checked exception
                    if (!(exception instanceof RuntimeException) && (exception instanceof Exception)) {
                        return result;
                    }
//                    // directly throw if the exception appears in the signature
//                    try {
//                        Method method = invoker.getInterface().getMethod(invocation.getMethodName(), invocation.getParameterTypes());
//                        Class<?>[] exceptionClassses = method.getExceptionTypes();
//                        for (Class<?> exceptionClass : exceptionClassses) {
//                            if (exception.getClass().equals(exceptionClass)) {
//                                return result;
//                            }
//                        }
//                    } catch (NoSuchMethodException e) {
//                        return result;
//                    }
//
//                    // for the exception not found in method's signature, print ERROR message in server's log.
//                    logger.error("Got unchecked and undeclared exception which called by " + RpcContext.getContext().getRemoteHost()
//                            + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName()
//                            + ", exception: " + exception.getClass().getName() + ": " + exception.getMessage(), exception);

                    // directly throw if exception class and interface class are in the same jar file.
                    String serviceFile = ReflectUtils.getCodeBase(invoker.getInterface());
                    String exceptionFile = ReflectUtils.getCodeBase(exception.getClass());
                    if (serviceFile == null || exceptionFile == null || serviceFile.equals(exceptionFile)) {
                        return result;
                    }
                    // directly throw if it's JDK exception
                    String className = exception.getClass().getName();
                    if (className.startsWith("java.") || className.startsWith("javax.")) {
                        return result;
                    }
                    // directly throw if it's dubbo exception
                    if (exception instanceof RpcException) {
                        return result;
                    }
                    // 如果是自定义异常,直接抛出
                    if (className.startsWith("com.myf.demo")){
                        return result;
                    }

                    // otherwise, wrap with RuntimeException and throw back to the client
                    return new RpcResult(new RuntimeException(StringUtils.toString(exception)));
                } catch (Throwable e) {
                    logger.warn("Fail to ExceptionFilter when called by " + RpcContext.getContext().getRemoteHost()
                            + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName()
                            + ", exception: " + e.getClass().getName() + ": " + e.getMessage(), e);
                    return result;
                }
            }
            return result;
        } catch (RuntimeException e) {
            logger.error("Got unchecked and undeclared exception which called by " + RpcContext.getContext().getRemoteHost()
                    + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName()
                    + ", exception: " + e.getClass().getName() + ": " + e.getMessage(), e);
            throw e;
        }
    }
}
