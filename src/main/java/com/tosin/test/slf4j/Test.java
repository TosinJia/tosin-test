package com.tosin.test.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 如何配置SLF4J不同的日志实现
 * https://segmentfault.com/a/1190000003806086
 * */
public class Test {
	static Logger logger=LoggerFactory.getLogger(Test.class);
	public static void main(String[] args) {
		for(int i = 0;i < 10;i++){
			if(i%2==0){
				logger.info("logger.info:"+i);
			}else{
				logger.debug("logger.debug:"+i);
			}
		}
	}
}
