package com.ai.psims;

import java.math.BigDecimal;

public class String2Num {
	String str = "4.015.1"; // 100010
	String discount = "66"; // 60% 优惠

	long price = 0;
	long num = 0;
	// 1.将字符串乘以1000（1.0元 --》1000厘 ） 转化为数值类型
	// 循环十亿次，比较转换效率
	String numstr = null;
	String pricestr = null;

	int n = 10000000;

	private void function1() {
		// 存下起始时间
		long startTime = System.currentTimeMillis();
		num = 0;
		for (int i = 0; i < n; i++) {
			Double double1 = Double.parseDouble(str);
			double1 = double1 * 1000;
			num = double1.longValue();
			price = new Double(Double.parseDouble(str) * 1000
					* Double.parseDouble(discount) / 100).longValue();
		}
		// 存下结束时间
		long endTime = System.currentTimeMillis();
		System.out.println("方法1用时：" + (endTime - startTime) + "ms" + "---"
				+ num + "---" + price);
	}

	private void function2() {
		// 存下起始时间
		long startTime = System.currentTimeMillis();
		num = 0;
		for (int i = 0; i < n; i++) {
			BigDecimal loanAmount = new BigDecimal(str);
			numstr = loanAmount.toString();
			BigDecimal interestRate = new BigDecimal("0.66"); // 利率
			BigDecimal interest = loanAmount.multiply(interestRate); // 相乘
			pricestr = interest.toString();
		}
		// 存下结束时间
		long endTime = System.currentTimeMillis();
		System.out.println("方法2用时：" + (endTime - startTime) + "ms" + "---"
				+ numstr + "---" + pricestr);
	}

	private void function3() {
		// 存下起始时间
		long startTime = System.currentTimeMillis();
		num = 0;
		for (int i = 0; i < n; i++) {
			numstr = new BigDecimal(str).toString();
			pricestr = new BigDecimal(str).multiply(new BigDecimal("0.66"))
					.toString(); // 相乘

		}
		// 存下结束时间
		long endTime = System.currentTimeMillis();
		System.out.println("方法3用时：" + (endTime - startTime) + "ms" + "---"
				+ numstr + "---" + pricestr);
	}

	private void function4() {
		// 存下起始时间
		long startTime = System.currentTimeMillis();
		num = 0;
		for (int i = 0; i < n; i++) {
			numstr = new BigDecimal(str).toString();
			pricestr = new BigDecimal(str).multiply(
					new BigDecimal(discount).divide(new BigDecimal("100")))
					.toString(); // 相乘

		}
		// 存下结束时间
		long endTime = System.currentTimeMillis();
		System.out.println("方法4用时：" + (endTime - startTime) + "ms" + "---"
				+ numstr + "---" + pricestr);
	}

	private void functionTest() {
		// 存下起始时间
		long startTime = System.currentTimeMillis();
		num = 0;
		Double double1 = Double.parseDouble("4.015");
		Float float1 =Float.parseFloat("4.015");
		System.out.println(40.15 * 1000);
		System.out.println(10 / 3);
		System.out.println(double1*1000);
		System.out.println(float1*1000);
		
		num = double1.longValue();
		price = new Double(Double.parseDouble(str) * 1000
				* Double.parseDouble(discount) / 100).longValue();
		// 存下结束时间
		long endTime = System.currentTimeMillis();
		System.out.println("方法Test用时：" + (endTime - startTime) + "ms" + "---"
				+ num + "---" + price);
	}

	public static void main(String[] args) {

		String2Num sec = new String2Num();
		sec.functionTest();
		sec.function1();
		sec.function2();
		sec.function3();
		sec.function4();

		System.out.println(0.05 + 0.01);
		System.out.println(1.0 - 0.42);
		System.out.println(4.015 * 100);
		System.out.println(123.3 / 100);

	}
}
