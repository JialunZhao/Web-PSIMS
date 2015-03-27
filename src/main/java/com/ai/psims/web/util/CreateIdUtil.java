package com.ai.psims.web.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ai.psims.web.dao.SelectIdMapper;
public class CreateIdUtil {	
	public static Integer getNewId(SelectIdMapper selectIdMapper){
		List<Integer> IdList=new ArrayList<Integer>();
		IdList=selectIdMapper.selectId();
		Integer id=new Random().nextInt(99999);
		for (Integer integer : IdList) {
			if (integer==id) {
				getNewId(selectIdMapper);
			}
		}
		return id;
	}
}
