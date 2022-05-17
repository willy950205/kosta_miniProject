package view;

import DTO.UserDTO;

public class SuccessView {
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
	
	public static void printUserInfo(UserDTO dto) {
		System.out.println(dto);
	}
	
}
