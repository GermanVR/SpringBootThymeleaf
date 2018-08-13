package com.german.springboot.service;

import java.util.List;

import com.german.springboot.entity.Log;

public interface LogService {

	public List<Log> listaLogs();

	public Log logPorId(int log);

}
