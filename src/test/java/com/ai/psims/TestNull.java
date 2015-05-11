package com.ai.psims;

//public boolean foo(String param){
//	  //最好用这种方法来判断对象是不是空
//	  if(null == param && "".equals(param)){
//	    //Some Code
//	  }
//	  //Do someting
//	}
//if(str != null && str.length() != 0) { }
//方法0用时：78ms---999999999
//方法0.1用时：78ms---999999999
//方法0.1.1用时：63ms---999999999
//方法0.2用时：94ms---999999999
//方法0.3用时：93ms---999999999
//方法1用时：78ms---999999999
//方法2.1用时：79ms---999999999
//方法2.2用时：62ms---999999999
//方法3用时：78ms---999999999


public class TestNull {
	String s = "";
	String s2 = "1";
	// 循环十亿次，比较判空效率
	int n = 1000000000;
	int num = 0;

	// 方法0 不为空
	private void function0() {
		// 存下起始时间
		long startTime = System.currentTimeMillis();
		num = 0;
		for (int i = 0; i < n; i++) {
			if (null != s2 && !"".equals(s2))
				num = i;
		}
		// 存下结束时间
		long endTime = System.currentTimeMillis();
		System.out.println("方法0用时：" + (endTime - startTime) + "ms"+"---"+num);
	}

	// 方法0.1 不为空
	private void function01() {
		// 存下起始时间
		long startTime = System.currentTimeMillis();
		num = 0;
		for (int i = 0; i < n; i++) {
			if (null != s2 && s2.length() != 0)
				num = i;
		}
		// 存下结束时间
		long endTime = System.currentTimeMillis();
		System.out.println("方法0.1用时：" + (endTime - startTime) + "ms"+"---"+num);
	}
	
	// 方法0.1 不为空
	private void function011() {
		// 存下起始时间
		long startTime = System.currentTimeMillis();
		num = 0;
		for (int i = 0; i < n; i++) {
			if (null != s2 && s2.length() > 0)
				num = i;
		}
		// 存下结束时间
		long endTime = System.currentTimeMillis();
		System.out.println("方法0.1.1用时：" + (endTime - startTime) + "ms"+"---"+num);
	}

	// 方法0.2 不为空
	private void function02() {
		// 存下起始时间
		long startTime = System.currentTimeMillis();
		num = 0;
		for (int i = 0; i < n; i++) {
			if (s2 != null && s2.length() != 0)
				num = i;
		}
		// 存下结束时间
		long endTime = System.currentTimeMillis();
		System.out.println("方法0.2用时：" + (endTime - startTime) + "ms"+"---"+num);
	}

	// 方法0
	private void function03() {
		long startTime = System.currentTimeMillis();
		num = 0;
		for (int i = 0; i < n; i++) {
			if (s2 == null || s2.length() < 1) {
				;
			}
			else {
				num = i;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("方法0.3用时：" + (endTime - startTime) + "ms"+"---"+num);
	}

	// 方法1
	private void function1() {
		// 存下起始时间
		long startTime = System.currentTimeMillis();
		num = 0;
		for (int i = 0; i < n; i++) {
			if (s == null || s.equals(""))
				num = i;
		}
		// 存下结束时间
		long endTime = System.currentTimeMillis();
		System.out.println("方法1用时：" + (endTime - startTime) + "ms"+"---"+num);
	}

	// 方法2
	private void function21() {
		long startTime = System.currentTimeMillis();
		num = 0;
		for (int i = 0; i < n; i++) {
			if (s == null || s.length() <= 0)
				num = i;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("方法2.1用时：" + (endTime - startTime) + "ms"+"---"+num);
	}

	// 方法2
	private void function22() {
		long startTime = System.currentTimeMillis();
		num = 0;
		for (int i = 0; i < n; i++) {
			if (s == null || s.length() < 1)
				num = i;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("方法2.2用时：" + (endTime - startTime) + "ms"+"---"+num);
	}

	// 方法3
	private void function3() {
		long startTime = System.currentTimeMillis();
		num = 0;
		for (int i = 0; i < n; i++) {
			if (s == null || s.isEmpty())
				num = i;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("方法3用时：" + (endTime - startTime) + "ms"+"---"+num);
	}

	public static void main(String[] args) {
		TestNull sec = new TestNull();
		sec.function0();
		sec.function01();
		sec.function011();
		sec.function02();
		sec.function03();
		sec.function1();
		sec.function21();
		sec.function22();
		sec.function3();
	}
}