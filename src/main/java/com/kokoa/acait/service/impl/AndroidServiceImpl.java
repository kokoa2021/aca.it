package com.kokoa.acait.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kokoa.acait.mapper.AndroidMapper;
import com.kokoa.acait.mapper.MainMapper;
import com.kokoa.acait.service.AndroidService;
import com.kokoa.acait.service.MainService;

@Service
public class AndroidServiceImpl implements AndroidService{
	@Autowired
	private AndroidMapper androidMapper;
	
}
