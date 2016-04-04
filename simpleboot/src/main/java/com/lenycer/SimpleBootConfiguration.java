package com.lenycer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.lenycer.sample.SampleBeans;

/**
 * @SpringBootApplication 에 @Configuration가 존재하지만 test 및 설정 유형별 관리를 위해 뺄 수도 있음.
 * @author 현석
 *
 */
@Configuration
public class SimpleBootConfiguration {

	@Bean
	public SampleBeans sampleBeans() {
		return new SampleBeans();
	}
}
