package com.dce;

import com.dce.log.LogBack;

import ch.qos.logback.core.joran.spi.JoranException;

public class StartMain {

	public static void main(String[] args) {
		try {
			
			LogBack.initLogBack();
			
		} catch (JoranException e) {
			e.printStackTrace();
		}
	}
}
