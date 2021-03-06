package com.ProjectPhh.www;

/*데몬 쓰레드 [daemon thread]

데몬 쓰레드는 다른 일반 쓰레드(데몬 스레드가 아닌 쓰레드)의 작업을 돕는 보조적인 역활을 수행하는 쓰레드이다.
일반 쓰레드가 모두 실행되고 나면 데몬 쓰레드도 자동 종료가 된다. why? 데몬 쓰레드는 일반 쓰레드를 보조하는 것이기 떄문에
일반 쓰레드가 모두 종료되었다면  남아 있을 필요가 없기 때문에

데몬 쓰레드의 예로는 가비지 컬렉터 , 워드프로세서의 자동저장 , 화면자동갱신 등이 있다.
*/

public class ThreadEx11 {
	public static void main(String args[]){
		
		ThreadEx11_1 th1 = new ThreadEx11_1();
		
		th1.setDaemon(true);  //이 부분이 없으면 종료되지 않는다.
		th1.start();
		
		
		for(int i = 1 ; i <= 10 ; i ++){
			try{
				Thread.sleep(1000);
			}catch (InterruptedException e) {}
			System.out.println(i);
				if (i == 5){
					th1.autoSave = true;
				}else{
					th1.autoSave = false;
				}
		}
	}		
}	

class ThreadEx11_1 extends Thread{
	public static boolean autoSave = false;
	public void run(){
		while(true){
			try {
				Thread.sleep(3*1000);
			}catch(InterruptedException e){}
			if(autoSave){
				autoSave();
			}
			
		  }
		
	}
	
	public void autoSave(){
		System.out.println("작업이 저장되었습니다.");
	}
	
	public void Exit(){
		System.out.println("종료되었습니다.");
	}
	
}






