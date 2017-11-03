package com.fasterweb.service;

import com.fasterweb.model.Log;

import javax.annotation.Resource;

public class LogService {

    @Resource
    private LogService logService;

    public Log getLogById(Integer id){
        return logService.getLogById(id);
    }

    public Log addLog(Log log){
        return logService.addLog(log);
    }

    public Log getLogByLiushui(String liushui){
        return logService.getLogByLiushui(liushui);
    }
}

