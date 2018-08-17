package com.german.springboot.component;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TareaComponente {

	private static final Log log = LogFactory.getLog(TareaComponente.class);

	@Scheduled(fixedDelay = 100000)
	public void ejecutaTarea() {
		log.info("La hora es: " + new Date());
	}
}
