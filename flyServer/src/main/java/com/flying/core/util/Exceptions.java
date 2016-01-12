/**
 * Copyright (c) 2005-2012 springside.org.cn
 */
package com.flying.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 关于异常的工具类.
 * @author calvin
 * @version 2013-01-15
 */
public class Exceptions {

	public static Logger log = LoggerFactory.getLogger(Exceptions.class);

    private Exceptions() {}

	/**
	 * 将CheckedException转换为UncheckedException.
	 */
	public static RuntimeException unchecked(Exception e) {
		if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		} else {
			return new RuntimeException(e);
		}
	}

	/**
	 * 将ErrorStack转化为String.
	 */
	public static String getStackTraceAsString(Throwable e) {
		if (e == null){
			return "";
		}
		StringWriter stringWriter = new StringWriter();
		try {
			e.printStackTrace(new PrintWriter(stringWriter));
		} catch(Exception e1) {
            log.debug("faild {}",e1.getMessage());
		}

		return stringWriter.toString();
	}

	/**
	 * 判断异常是否由某些底层的异常引起.
	 */
	public static boolean isCausedBy(Exception ex, Class<? extends Exception>... causeExceptionClasses) {
		Throwable cause = ex.getCause();
		while (cause != null) {
			for (Class<? extends Exception> causeClass : causeExceptionClasses) {
				if (causeClass.isInstance(cause)) {
					return true;
				}
			}
			cause = cause.getCause();
		}
		return false;
	}

	/**
	 * 在request中获取异常类
	 * @param request
	 * @return  ex
	 */
	public static Throwable getThrowable(HttpServletRequest request){
		Throwable ex = null;
        Object e1 = request.getAttribute("exception");
        Object e2 = request.getAttribute("javax.servlet.error.exception");
		if (e1 != null) {
			ex = (Throwable) e1;
		} else if (e2 != null) {
			ex = (Throwable)e2;
		}
		return ex;
	}
	
}
