package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.TbMenuMapper;
import com.ai.psims.web.model.TbMenu;
import com.ai.psims.web.model.TbMenuExample;
import com.ai.psims.web.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {
	
	@Resource
	private TbMenuMapper tbMenuMapper;
	
	@Override
	public List<TbMenu> getMenu() {
		TbMenuExample example = new TbMenuExample();
		example.setOrderByClause("menu_id");
		return tbMenuMapper.selectByExample(example);
	}

}
