package com.tosin.test.annotation.test02;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 源地址 http://www.importnew.com/14479.html
 * */
public class AnnotationParsing {

	public static void main(String[] args) {
		try {
			for (Method method : AnnotationParsing.class.getClassLoader()
					.loadClass(("com.tosin.test.annotation.test02.AnnotationExample")).getMethods()) {
				// checks if MethodInfo annotation is present for the method
				if (method.isAnnotationPresent(MethodInfo.class)) {
					try {
						// iterates all the annotations available in the method
						for (Annotation anno : method.getDeclaredAnnotations()) {
							System.out.println("Annotation in Method '" + method + "' : " + anno);
						}
						MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
						if (methodAnno.revision() == 1) {
							System.out.println("Method with revision no 1 = " + method);
						}

					} catch (Throwable ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}