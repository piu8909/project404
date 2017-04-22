package com.ProjectPhh.www;

public class ThreadEx2 {

	public static void main(String[] args) {
		MyThreadEx2_1 t1 = new MyThreadEx2_1();
		t1.start();
	}
}

class MyThreadEx2_1 extends Thread {
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
 * 새로 생성한 쓰레드에서 고의로 예외를 발생시키고 printStackTreace()를 이용해서 예외가 발생한 당시의 호출스택을
 * 출력하는 예제이다. 호출스택의 첫번째 메서드가 mian메서드가 아니라 run메서드인 것을 확인하자.
 * 한 쓰레드에서 예외가 알샘해서 종료되어도 다른 쓰레드의 실행에 는 영항을 미치지 않는다
 */


