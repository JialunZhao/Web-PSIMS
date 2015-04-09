package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.MenuMapper;
import com.ai.psims.web.model.Menu;
import com.ai.psims.web.model.MenuExample;
import com.ai.psims.web.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {
	
	@Resource
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> getMenu() {
		MenuExample example = new MenuExample();
		return menuMapper.selectByExample(example);
	}

}
