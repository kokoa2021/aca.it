package com.kokoa.acait.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kokoa.acait.mapper.MainMapper;
import com.kokoa.acait.service.MainService;

@Service
public class MainServiceImpl implements MainService{
	@Autowired
	private MainMapper mainMapper;

	@Override
	public String getTime() throws RuntimeException {
		return mainMapper.getTime();
	}
	
}
