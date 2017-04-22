package com.ProjectPhh.www;


/*
 * 쓰레드 구룹(thread group)
 * 
 * 쓰레드 그룹은 서로 관련된 쓰레드를 그룹으로 다루기 위한 것으로, 폴더를 생성해서 관련된 파일들을 함께 넣어서 관리하는 것처럼
 * 쓰레드 그룹을 생성해서 쓰레드를 그룹으로 묶어서 관리 할 수 있다.
 *   
 * 폴도 안에 폴더를 생성할 수 있듯이 쓰레드 그룹에 다른 쓰레드 구릅을 포함 시킬 수 있다.
 * 
 * 쓰레드 그룹은 보안상의 이유로 도입된 개념으로, 자신이 속한 쓰레드 그룹이나 
 * 하위 쓰레드 그룹은 변경할 수 있지만 다른쓰레드 그룹의 쓰레드를 변경 할 수는 없다.
 * 
 * ※ 모든 쓰레드는 반듯이 쓰레드 그룹에 포함되어야 한다.
 * 
 * 모든 쓰레드는 반듯이 쓰레드 그룹에 포함되어 있어야 하기 때문에, 
 * 위와 같은 쓰레드 그룹을 지정하는 생성자를 사용하지 않는 쓰레드는 기본적으로 자신을
 * 생성한 쓰레드와 같은 쓰레드 그룹에 속하게 된다.
 * 
 * 자바 어플리케이션이 실행되면 , JVM은 main과 system이라는 쓰레드 그룹을 만들고
 * JMV운영에 필요한 쓰레드들을 생성해서 이 쓰레드 그룹에 포함시킨다. 
 * 우리가 흔히 쓰는 main메서드는 mainThread 그룹에 속하고, 
 * 가비지컬렉션을 수행하는 FinalizerThread는 system 그룹에 속한다.
 * 
 * TheadGroup은 폴더 개념처럼 폴더 안에 폴더를 생성하듯이 ThreadGroup안에 ThreadGroup을 생성하여 사용된다.
 * 우리가 생성하는 모든 ThreadGroup은 mainTreadGroup에 속하게 된다.
 * 
 */


public class ThreadEx10 {
	public static void main(String args[]){
		//System.out.println(Thread.currentThread().getThreadGroup());
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup grp1 = new ThreadGroup("Group1");
		ThreadGroup grp2 = new ThreadGroup("Group1");
		
		ThreadGroup subGrp1 = new ThreadGroup(grp1 , "SubGroup1");
		
		grp1.setMaxPriority(3);  // 쓰레드 그룹 grp1의 최대우선순위를 3으로 변경,
		
		Thread th1 = new Thread(grp1,"th1");
		Thread th2 = new Thread(subGrp1,"th2");
		Thread th3 = new Thread(grp2,"th3");
		
		
		th1.start();
		th2.start();
		th3.start();
		
		System.out.println("List of ThreadGroupb : " + main.getName() + "Active ThreadGroup : " + main.activeGroupCount() + " , Acrive Thread: " + main.activeCount());
		
		main.list();
		
		
/*	------실행결과-------------------------------------------------------
 
 		List of ThreadGroupb : mainActive ThreadGroup : 3 , Acrive Thread: 3
		java.lang.ThreadGroup[name=main,maxpri=10]
		    Thread[main,5,main]
		    java.lang.ThreadGroup[name=Group1,maxpri=3]
		        java.lang.ThreadGroup[name=SubGroup1,maxpri=3]
		            Thread[th2,3,SubGroup1]
		    java.lang.ThreadGroup[name=Group1,maxpri=10]
		    
		    
		    쓰레드 그룹과 쓰레드를 생성하고 main.list()를 호출해서 Main쓰레드의 그룹의 정보를 출력하는 예제이다.
		    결과를 보면 하위 쓰레드 그룹에 포함된 하위 쓰레드 그룹이나 쓰레드는 들여쓰기를 이용해서 구별되도록 하였음을 알 수 있다.
		    새로 생성한 모든 쓰레드 그룹은 main쓰레드 그룹의 하위 쓰레드 그룹으로 포함되어 있다는 것과 ,
		    SetMaxPriority()는 쓰레드가 쓰레드 그룹에 추가되기 이전에 호출되어야 하며 , 쓰레드 그룹 grp1의 최대 우선순위를 3으로 했기
		    때문에 , 후에 여기에 속하게 된 쓰레드 그룹과 쓰레드가 영향을 받았음을 확인 하자.
		    
*/
	}
}






