package com.ProjectPhh.www;

/*멀티쓰레드를 이용한 처리*/


public class ThreadEx5 {
	public static long startTime;

	public static void main(String args[]){
		ThreadEx5_1 th1 = new ThreadEx5_1();
		th1.start();
		
		for(int i = 0 ; i < 300 ; i++){
			System.out.print("-");
		}
		System.out.println(" ");
		System.out.print( " 소요시간1 time : " + (System.currentTimeMillis() -ThreadEx5.startTime));
		
	}
}

class ThreadEx5_1 extends Thread{
	public void run(){
		for(int i = 0 ; i < 300 ; i++){
			System.out.print("|");
		}
		System.out.println(" ");
		System.out.print( " 소요시간2 time : " + (System.currentTimeMillis()-ThreadEx5.startTime));
	}
}





