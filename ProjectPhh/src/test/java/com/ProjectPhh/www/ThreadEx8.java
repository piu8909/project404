package com.ProjectPhh.www;


import javax.swing.JOptionPane;

public class ThreadEx8 {
	public static void main(String args[]){
		
		ThreadEx8_1 th8 = new ThreadEx8_1();
		
		th8.start();
		
		String input  = JOptionPane.showInputDialog("아무 값이니 입력하세요 . " ) ;
		System.out.println( " 입릭하신 값은 " + input + " 입니다 . " );
		
		for (int i= 10 ; i> 0 ; i --) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			}catch(Exception e ) {
				
			}
		}
	}
}

class ThreadEx8_1 extends Thread{
	public void run(){
		for(int i = 10 ; i > 0 ; i--){
			System.out.println(i);
			
			try {
				sleep(1000);
			}catch(Exception e){
				
			}
		}
		System.out.println("10초 동안 값이 입력되지 않아 종료합니다.");
		System.exit(0);
	}
}







