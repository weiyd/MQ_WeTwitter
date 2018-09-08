package com.wetwitter.modules.common.config;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

@Configuration
public class CaptchaConfig {
	
 
	@Bean(name="captchaProducer")
	public DefaultKaptcha getKaptchaBean(){
		DefaultKaptcha defaultKaptcha=new DefaultKaptcha();
		Properties properties=new Properties();
		properties.setProperty("kaptcha.border", "yes");
		properties.setProperty("kaptcha.border.color", "105,179,90");
		properties.setProperty("kaptcha.textproducer.font.color", "red");
		properties.setProperty("kaptcha.image.width", "135");
		properties.setProperty("kaptcha.image.height", "50");
		properties.setProperty("kaptcha.textproducer.font.size", "43");
		properties.setProperty("kaptcha.noise.color", "black");
		properties.setProperty("kaptcha.textproducer.char.length", "4");
		properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");		
		Config config=new Config(properties);
		defaultKaptcha.setConfig(config);
		return defaultKaptcha;
	}
}

