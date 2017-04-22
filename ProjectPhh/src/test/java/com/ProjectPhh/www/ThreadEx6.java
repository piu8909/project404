package com.ProjectPhh.www;

import javax.swing.JOptionPane;

/*멀티쓰레드를 이용한 처리
 *멀티쓰레드를 이용하면 사용자의 입력을 받아야 하는 로직을 실행 시
 *무작정 기다리지 않고 입력 대기 동안 다른 일을 처리 할 수 있다. 
 *
 *
 *아래의 예제는 멀티쓰레드를 사용하지 않아 사용자가 입력값이 없는 경우엔 무작정 기다린다.
 * */


public class ThreadEx6 {
	public static void main(String args[]){
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






