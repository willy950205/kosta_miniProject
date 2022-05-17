package Controller;

import java.sql.SQLException;
import java.util.List;

import DTO.UserDTO;
import service.UserService;
import service.UserServiceImpl;
import view.FailView;
import view.SuccessView;

public class UserController {
   private UserService service = new UserServiceImpl();
   private int a;
   

   public UserDTO signUp(String id, String password, int residence){
      UserDTO dto = null;
      
      try{
         dto = service.signUp(id, password, residence);
         SuccessView.printMessage("ȸ�������� ���������� �Ϸ�Ǿ����ϴ�.");
      }catch (SQLException e) {
         FailView.printFailMessage(e.getMessage());
      }
      
      return dto;
   }


   
   public UserDTO logIn(String id, String password) {
      UserDTO dto = null;
      
      try{
         dto = service.logIn(id, password);
         SuccessView.printMessage("�α��� �Ǿ����ϴ�.");
      }catch (SQLException e) {
         FailView.printFailMessage(e.getMessage());
      }
      
      return dto;
   }


   public String myResidence(String id){
      String myResidence = null;
      try {
         myResidence = service.myResidence(id);
         SuccessView.printMessage("\n"+id+"���� �������� "+myResidence+"�Դϴ�."+"\n\n");
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return myResidence;
   }


   public String checkSecurity(int residence){
      String securityGrade = null;
      
      try {
         securityGrade = service.checkSecurity(residence);
         SuccessView.printMessage("\n"+"��� �������� ġ�ȵ���� " +securityGrade+"��� �Դϴ�."+"\n\n");
      }catch (SQLException e) {
         FailView.printFailMessage(e.getMessage());
      }
      
      return securityGrade;
   }


   public int changeResidence(String id, int residence){
      int result = 0;
      
      try {
         result = service.changeResidence(id, residence);
         SuccessView.printMessage("\n"+"���� �Ű� �Ϸ�Ǿ����ϴ�."+"\n\n");
         }catch (SQLException e) {
            FailView.printFailMessage(e.getMessage());
         }
         
      return result;
      
   }

   public void checkDetail(String id){
	   String message = null;
	   
	   try {
		   message = service.checkDetail(id);
		   SuccessView.printMessage("\n"+id+"���� ������ : "+message+"\n\n");
	   }catch (SQLException e) {
		   FailView.printFailMessage(e.getMessage());
	}
      
   }
   /////////////////////////
   public void selectAll() {
	      List<UserDTO> list = null;
	      try {
	         list = service.selectAll();
	         for(UserDTO dto : list) {
	            SuccessView.printUserInfo(dto);
	         }
	         
	      }catch (SQLException e) {
	      FailView.printFailMessage(e.getMessage());
	   }
   }
   
   public void deleteID(String id) {
	   int result = 0;
	   try {
		   result = service.deleteID(id);
		   SuccessView.printMessage("�������� ����");
	   }catch (SQLException e) {
		FailView.printFailMessage(e.getMessage());
	}
   }
   
}