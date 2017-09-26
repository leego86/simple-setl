package com.lppz.etl;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

//@Component
public class InitEtl implements InitializingBean{
	
	@Resource
	private OtterController otterController;

	@Override
	public void afterPropertiesSet() throws Exception {
		try {
			otterController.start();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
