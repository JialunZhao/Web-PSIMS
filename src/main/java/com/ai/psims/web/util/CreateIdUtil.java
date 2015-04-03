package com.ai.psims.web.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ai.psims.web.dao.SelectIdMapper;

public class CreateIdUtil {
	public static Integer getNewId(SelectIdMapper selectIdMapper) {
		List<Integer> IdList = new ArrayList<Integer>();
		IdList = selectIdMapper.selectId();
		Integer id = new Random().nextInt(99999);
		for (Integer integer : IdList) {
			if (integer == id) {
				getNewId(selectIdMapper);
			} 
		}
		return id; 
	}

	public static String getTranslation(String str) {
		String result = null;
		if (str.equals(Constants.ImportStatus.GOODSARRIVAL)) {
			result = Constants.ImportStatus.GOODSARRIVAL01;
		}
		if (str.equals(Constants.ImportStatus.GOODSIMPORT)) {
			result = Constants.ImportStatus.GOODSIMPORT01;
		}
		if (str.equals(Constants.ImportStatus.ORDERNOPAY)) {
			result = Constants.ImportStatus.ORDERNOPAY01;
		}
		if (str.equals(Constants.ImportStatus.ORDERYESPAY)) {
			result = Constants.ImportStatus.ORDERYESPAY01;
		}
		if (str.equals(Constants.ImportGoodsStatus.CANSALE)) {
			result = Constants.ImportGoodsStatus.CANSALE01;
		}
		if (str.equals(Constants.ImportGoodsStatus.NOTSALE)) {
			result = Constants.ImportGoodsStatus.NOTSALE01;
		}
		if (str.equals(Constants.PayStatus.NOPAY)) {
			result = Constants.PayStatus.NOPAY01;
		}
		if (str.equals(Constants.PayStatus.YESPAY)) {
			result = Constants.PayStatus.YESPAY01;
		}
		if (str.equals(Constants.DiscountMed.AWARDFONT)) {
			result = Constants.DiscountMed.AWARDFONT01;
		}
		if (str.equals(Constants.DiscountMed.NODISCOUNT)) {
			result = Constants.DiscountMed.NODISCOUNT01;
		}
		if (str.equals(Constants.PayMed.CASH)) {
			result = Constants.PayMed.CASH01;
		}
		if (str.equals(Constants.PayMed.CHEQUE)) {
			result = Constants.PayMed.CHEQUE01;
		}
		if (str.equals(Constants.PayMed.TICK)) {
			result = Constants.PayMed.TICK01;
		}
		if (str.equals(Constants.PayMed.TRANSFERS)) {
			result = Constants.PayMed.TRANSFERS01;
		}
		return result;
	}
}
