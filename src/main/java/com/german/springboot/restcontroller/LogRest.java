package com.german.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.german.springboot.entity.Log;
import com.german.springboot.service.LogService;

@RestController
@RequestMapping("/rest")
public class LogRest {

	@Autowired
	private LogService logService;

	@GetMapping(value = "/logs")
	public ResponseEntity<List<Log>> obtieneLogs() {
		return new ResponseEntity<List<Log>>(logService.listaLogs(), HttpStatus.OK);
	}

	@GetMapping(value = "/log/{id}")
	public ResponseEntity<Log> obtieneLogPorId(@PathVariable int id) {
		return new ResponseEntity<Log>(logService.logPorId(id), HttpStatus.OK);
	}

}
