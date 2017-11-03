package com.fasterweb.dao;

import com.fasterweb.model.Log;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface LogMapper {

    Log getLogById();

    Log getLogByLiushui();

    Log addLog(Log log);

}
