package com.ProjectPhh.www;


/*쓰레드의 우선순위
 * 쓰레드는 우선순위(priority)라는 속성(멤버변수)를 가지고 있는데, 이 우선순위의 값에 따라
 * 쓰레드가 얻는 실행시간이 달라진다. 쓰레드가 수행하는 작업의 중요도에 따라 쓰레드의 우선순위를 서로 다르게 지정하여
 * 특정 쓰레드가 더 많은 작업 시간을 갖도록 할 수 있다.
 * 
 * priority 멤버변수를 통하여 쓰레드가 얻는 실행 시간을 설정할 수 있다.
 * 
 * 쓰레드가 가질 수 있는 우선순위의 범위는 1 ~ 10 이며 숫자가 높을 수록 우선순위가 높다.
 * 
 * 쓰레드의 우선순위는 쓰레드를 생성한 쓰레드로부터 상속받는다는 것이다. main메서드를 수행하는 쓰레드는 우선순위가 5이므로 main메서드
 * 내서 생성하는 쓰레드의 우선순위는 자동적으로 5가 된다.
 * 
 * 즉 쓰레드를 호출하는 쓰레드에게 우선순위를 상속 받는다.
 * 
 * 
 * 
 * 
 * */


public class ThreadEx9 {
	public static void main(String args[]){
		ThreadEx9_1 th1 = new ThreadEx9_1();
		ThreadEx9_2 th2 = new ThreadEx9_2();
		
		
		/*
		 *  th1 과 th2는 main메서드를 실행하는 쓰레드의 우선순위인 5를 상속 받기 때문에
		 *  getPriority(); defualt 값은 5이게 된다.
		 *  
		 */		
		
		th1.setPriority(7);
		
		
		/*th1.setPriority() 값을 7로 설정함으로써
		 * th1이 우선순위를 가지게 된다.
		 * */
		
		System.out.println("Priority of th1(-) : " + th1.getPriority());
		System.out.println("Priority of th1(|) : " + th2.getPriority());
		
		th1.start();
		th2.start();
		
		
		/*Priority 값이 1정도 차이나면 별반 차이가 없지만 2 이상 차이나면 확연한 차이를 느낄 수 있다.
		 * 
		 * */
		
	}
}

class ThreadEx9_1 extends Thread {
	public void run(){
		for(int i = 0 ; i < 300 ; i ++){
			System.out.print("-");
			for(int x = 0 ; x < 1000000; x++);
		}
	}
	
}

class ThreadEx9_2 extends Thread {
	public void run(){
		for(int i = 0 ; i < 300 ; i ++){
			System.out.print("|");			
			for(int x = 0 ; x < 1000000; x++);
		}		
	}	
}





