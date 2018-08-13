package com.german.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.german.springboot.entity.Log;
import com.german.springboot.repository.LogRepository;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogRepository logRepository;

	@Override
	public List<Log> listaLogs() {
		return logRepository.findAll();
	}

	@Override
	public Log logPorId(int log) {
		return logRepository.findById(log).get();
	}

}
