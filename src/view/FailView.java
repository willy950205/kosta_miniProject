package view;

public class FailView {
	public static void printFailMessage(String message) {
		System.out.println(message);
	}
	
	public static void getOutMessage() {
		System.out.println("관리자 이외의 회원은 접근할수없습니다");
	}
}
