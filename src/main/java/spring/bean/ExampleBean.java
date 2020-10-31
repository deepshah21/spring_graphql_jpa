package spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ExampleBean implements DisposableBean,InitializingBean {

//	Methods annotated with @PostConstruct
//	afterPropertiesSet() as defined by the InitializingBean callback interface
//	A custom configured init() method
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

//	Methods annotated with @PreDestroy
//	destroy() as defined by the DisposableBean callback interface
//	A custom configured destroy() method

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
