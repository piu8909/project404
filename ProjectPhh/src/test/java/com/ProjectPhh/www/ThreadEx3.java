package com.ProjectPhh.www;

public class ThreadEx3 {

	public static void main(String[] args) {
		MyThreadEx3_1 t1 = new MyThreadEx3_1();
		t1.run();
	}

}

class MyThreadEx3_1 extends Thread {
	public void run(){
		throwExceoption();
	}

	private void throwExceoption() {
		try{
			throw new Exception();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}

/*
 * run() 메소드를 호출해서 사용 할 경우 무슨 이전 예제와 달리 main 메서드가 호출스택에 포함되어있다.
 * 즉 start()메소드를 호출해서 호출스택을 새로히 생성하지 않았기 때문에 main메소드에 영향을 받는 것이다.
 * 
 */



