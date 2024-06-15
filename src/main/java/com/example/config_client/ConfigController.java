package com.example.config_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.OriginTrackedValue;
import org.springframework.cloud.bootstrap.config.BootstrapPropertySource;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/config")
public class ConfigController {

	@Autowired
	private ConfigurableEnvironment environment;

	@GetMapping("/all")
	public Map<String, Map<String, Object>> getAllConfig() {
		Map<String, Map<String, Object>> configProperties = new HashMap<>();

		for (PropertySource<?> propertySource : environment.getPropertySources()) {
//			System.out.println("PropertySource: " + propertySource.getName());
			if (isConfigServerPropertySource(propertySource)) {
				if (propertySource instanceof BootstrapPropertySource) {
					LinkedHashMap<String, Object> source = (LinkedHashMap<String, Object>) (((BootstrapPropertySource) propertySource).getSource());
					for (Map.Entry<String, Object> entry : source.entrySet()) {
						OriginTrackedValue value = (OriginTrackedValue) entry.getValue();
//						System.out.println(value.getOrigin());
						configProperties.put(String.valueOf(value.getOrigin()), Map.of(entry.getKey(), value.getValue()));
					}
				}
			}
		}

		return configProperties;
	}

	private boolean isConfigServerPropertySource(PropertySource<?> propertySource) {
		return propertySource.getName().contains("git@github.com:mibackend/quiz-pro-react_config-service.git");
	}
}


