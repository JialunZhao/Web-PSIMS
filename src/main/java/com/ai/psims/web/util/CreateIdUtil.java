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
		if (str.equals(Constants.ImportStatus.GOODSLITARRIVAL)) {
			result = Constants.ImportStatus.GOODSLITARRIVAL01;
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
		if (str.equals(Constants.DiscountMed.NO)) {
			result = Constants.DiscountMed.NO01;
		}
		if (str.equals(Constants.DiscountMed.YES)) {
			result = Constants.DiscountMed.YES01;
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
		if (str.equals(Constants.SalesStatus.CREDIT)) {
			result = Constants.SalesStatus.CREDIT01;
		}
		if (str.equals(Constants.SalesStatus.DOWNORDER)) {
			result = Constants.SalesStatus.DOWNORDER01;
		}
		if (str.equals(Constants.SalesStatus.OUTORDER)) {
			result = Constants.SalesStatus.OUTORDER01;
		}
		if (str.equals(Constants.SalesStatus.OUTSTORE)) {
			result = Constants.SalesStatus.OUTSTORE01;
		}
		if (str.equals(Constants.SalesStatus.SQUARE)) {
			result = Constants.SalesStatus.SQUARE01;
		}
		if (str.equals(Constants.BackType.BACKGOODS)) {
			result = Constants.BackType.BACKGOODS01;
		}
		if (str.equals(Constants.BackType.CHANGEGOODS)) {
			result = Constants.BackType.CHANGEGOODS01;
		}
		return result;
	}
}
