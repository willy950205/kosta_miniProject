package view;

import java.util.Scanner;

import Controller.UserController;
import DTO.UserDTO;

public class MainView {
	
	Scanner scn = new Scanner(System.in);
	
	UserController controller = new UserController(); //��Ʈ�ѷ� ����;
	
	UserDTO account;
	
	public MainView() {
		
		String choice = null;
		
		do {
			System.out.println();
			System.out.println("================================================");
			System.out.println("**ġ�� �˻� �ý��ۿ� �����ϽŰ��� ȯ���մϴ�~**");
			System.out.println("================================================");
			System.out.println();
			System.out.println("���ϴ� ���񽺿� �ش��ϴ� ��ȣ�� �Է����ּ���!");
			System.out.println();
			System.out.println("1. �α���		2. ȸ������");
			System.out.print("��ȣ �Է� : ");
			choice = scn.next();

			switch (choice) {
			case "1":
				login(); 
				break;

			case "2":
				signup();
				break;
				
			default :
				System.out.println("1�� �ƴϸ� 2���� �Է����ּ���");
			}
		}while(choice != "1" || choice != "2");

		
	}
	
	public void login() {
		
		System.out.println();	
		System.out.println();
		System.out.println("======================");
		System.out.println("*****�α��� ȭ��*****");
		System.out.println("======================");
		System.out.println();
		System.out.print("ID : ");
		String id = scn.next();
		System.out.print("PW : ");
		String password = scn.next();
		
		/**
		 * �׸��� ��Ʈ�ѷ� �θ���
		 * */
		account = controller.logIn(id, password);
				
		if(account != null) {
			this.serviceCoice(id);
		}

		
	}
	
	public void signup() {
		
		System.out.println();
		System.out.println("*****ȸ������ ȭ��*****");
		System.out.print("���ϴ� ID�� �Է����ּ��� : ");
		String id = scn.next();
		System.out.print("���Ͻô� PW�� �Է����ּ���. : ");
		String password = scn.next();
	      System.out.println("�������� ��ȣ�� �Է����ּ���. : ");
	      System.out.print("1. ����      ");
	      System.out.print("2.�λ�       ");
	      System.out.print("3.�뱸      ");
	      System.out.print("4.��õ      ");
	      System.out.print("5.����      ");
	      System.out.print("6.����      ");
	      System.out.println("7.���    ");
	      System.out.print("8. ��Ⳳ��  ");
	      System.out.print("9.���Ϻ�   ");
	      System.out.print("10.����    ");
	      System.out.print("11.���     ");
	      System.out.println("12.�泲    ");
	      System.out.print("13.����     ");
	      System.out.print("14.����       ");
	      System.out.print("15.���    ");
	      System.out.print("16.�泲     ");
	      System.out.println("17.����     ");
	      System.out.print("��ȣ �Է� :");
		int res = scn.nextInt();

		/**
		 * �׸��� ��Ʈ�ѷ� �θ���
		 *signUp
		 * */
		account = controller.signUp(id, password, res);
		
		
		if(account != null) {
			this.serviceCoice(id);
		}
		
	}
	
	public void serviceCoice(String id) {
		
		while(true) {
			System.out.println();
			System.out.println();
			System.out.println("=================");
			System.out.println(id+"�� ȯ���մϴ�!");
			System.out.println("=================");
			System.out.println("���Ͻô� ���񽺸� �������ּ���!");
			System.out.println();
			System.out.println("1. �� ������ Ȯ���ϱ�");
			System.out.println("2. ������ ġ�� ��� Ȯ��");
			System.out.println("3. ���� �Ű��ϱ�(������ ����)");
			System.out.println("4. ��������");
			System.out.println("5. ���α׷� ����");
			System.out.print("�ش� ���� ��ȣ �Է�: ");
			String choice = scn.next();
			
			switch (choice) {
			case "1":
				//�� ������ Ȯ���ϱ�
				controller.myResidence(id);
				printQuestion();
				String ch = scn.next();
				ask(ch);
				break;

			case "2":
				//������ ġ�� ��� Ȯ��
				controller.checkSecurity(account.getResidence());
				detail();
				ch = scn.next();				
				askver2(ch);
				break;

			case "3":
				//���� �Ű��ϱ�(������ ����)
			      System.out.println();
			      System.out.println();
			      System.out.println("������ ���Ͻô� �������� ��ȣ�� �������ּ���. : ");
			      System.out.print("1. ����      ");
			      System.out.print("2.�λ�       ");
			      System.out.print("3.�뱸      ");
			      System.out.print("4.��õ      ");
			      System.out.print("5.����      ");
			      System.out.print("6.����      ");
			      System.out.println("7.���    ");
			      System.out.print("8. ��Ⳳ��  ");
			      System.out.print("9.���Ϻ�   ");
			      System.out.print("10.����    ");
			      System.out.print("11.���     ");
			      System.out.println("12.�泲    ");
			      System.out.print("13.����     ");
			      System.out.print("14.����       ");
			      System.out.print("15.���    ");
			      System.out.print("16.�泲     ");
			      System.out.println("17.����     ");
			      System.out.print("��ȣ �Է� :");
				int res = scn.nextInt();
				controller.changeResidence(account.getId(),res );
				
				printQuestion();
				ch = scn.next();
				ask(ch);
				break;
				
			case "4":
				//ġ�� ���� ������ ����
				System.out.println();
				System.out.println();
				if(!account.getId().equals("ADMIN")) {
					FailView.getOutMessage();
					break;
				}

				controller.selectAll();
				
				System.out.println();
				System.out.println();
				System.out.println("������ ������ �Է��� �ּ���");
				String order = scn.next();				
				controller.deleteID(order);
				System.out.println();
				printQuestion();
				ch = scn.next();
				ask(ch);
				break;
				
			case "5":
				//���α׷� ����
				System.exit(0);
				break;
			}

			
		}
		
		
		
	}
	
	public void printQuestion() {
		System.out.println("1. �ʱ�ȭ������ ���ư���");
		System.out.println("2. ���α׷� ����");
		System.out.print("��ȣ �Է� : ");
	}
	
	public void detail() {
		System.out.println("1. �ʱ�ȭ������ ���ư���");
		System.out.println("2. ���α׷� ����");
		System.out.println("3. ġ�� ��� ���� �󼼺���");
		System.out.print("��ȣ �Է� : ");
		
	}
	
	public void ask(String ch) {
		switch (ch) {
		case "1":
			//�ʱ�ȭ������ ���ư���
			break;

		case "2":
			//����
			System.out.println();
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
			break;
		}
		
		
	}
	
	public void askver2(String ch) {
		switch (ch) {
		case "1":
			//�ʱ�ȭ������ ���ư���
			break;
			

		case "2":
			//����
			System.out.println();
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
			break;
		case "3":
			controller.checkDetail(account.getId());
			printQuestion();
			String str = scn.next();
			ask(str);
			break;
		}
		
		
	}

}
