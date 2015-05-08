package com.ai.psims;


public class TestNull {  
   String s = "";  
   //循环十亿次，比较判空效率  
   double n = 1000000000;     
   //方法1  
   private void function1() {  
     //存下起始时间  
     long startTime = System.currentTimeMillis();  
     for (int i = 0; i < n; i ++) {  
       if (s != null || s.equals("")) ;  
     }  
     //存下结束时间  
     long endTime = System.currentTimeMillis();  
     System.out.println("方法1用时：" + (endTime - startTime) + "ms");  
   }  
   //方法2  
   private void function2() {  
     long startTime = System.currentTimeMillis();  
     for (int i = 0; i < n; i ++) {  
       if (s == null || s.length() <= 0) ;  
     }  
     long endTime = System.currentTimeMillis();  
     System.out.println("方法2用时：" + (endTime - startTime) + "ms");  
   }  
   //方法2  
   private void function22() {  
     long startTime = System.currentTimeMillis();  
     for (int i = 0; i < n; i ++) {  
       if (s == null || s.length() < 1) ;  
     }  
     long endTime = System.currentTimeMillis();  
     System.out.println("方法2.2用时：" + (endTime - startTime) + "ms");  
   }  
   //方法3  
   private void function3() {  
     long startTime = System.currentTimeMillis();  
     for (int i = 0; i < n; i ++) {  
       if (s == null || s.isEmpty()) ;  
     }  
     long endTime = System.currentTimeMillis();  
     System.out.println("方法3用时：" + (endTime - startTime) + "ms");  
   }  

   public static void main(String[] args) {  
	   TestNull sec = new TestNull();  
     sec.function1();  
     sec.function2();  
     sec.function22();  
     sec.function3();   
   }  
 }  