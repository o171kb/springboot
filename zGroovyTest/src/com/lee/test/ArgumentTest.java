package com.lee.test;

public class ArgumentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// 옵션 개수 검사. 옵션 없으면 에러 메시지 출력하고 종료
	    if (args.length == 0) {
	      System.err.println("옵션을 입력하세요");
	      System.exit(1);
	    }


	    // 옵션 개수 출력
	    System.out.println("모두 " + args.length + "개의 옵션을 입력하셨군요.");

	    System.out.println(); // 줄바꿈


	    // 모든 옵션 하나씩 화면에 출력
	    for (int i = 0; i < args.length; i++)
	      System.out.format("args[%d] : %s%n", i, args[i]);

		
	}

}
