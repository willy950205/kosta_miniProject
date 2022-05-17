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
         SuccessView.printMessage("회원가입이 성공적으로 완료되었습니다.");
      }catch (SQLException e) {
         FailView.printFailMessage(e.getMessage());
      }
      
      return dto;
   }


   
   public UserDTO logIn(String id, String password) {
      UserDTO dto = null;
      
      try{
         dto = service.logIn(id, password);
         SuccessView.printMessage("로그인 되었습니다.");
      }catch (SQLException e) {
         FailView.printFailMessage(e.getMessage());
      }
      
      return dto;
   }


   public String myResidence(String id){
      String myResidence = null;
      try {
         myResidence = service.myResidence(id);
         SuccessView.printMessage("\n"+id+"님의 거주지는 "+myResidence+"입니다."+"\n\n");
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return myResidence;
   }


   public String checkSecurity(int residence){
      String securityGrade = null;
      
      try {
         securityGrade = service.checkSecurity(residence);
         SuccessView.printMessage("\n"+"당신 거주지의 치안등급은 " +securityGrade+"등급 입니다."+"\n\n");
      }catch (SQLException e) {
         FailView.printFailMessage(e.getMessage());
      }
      
      return securityGrade;
   }


   public int changeResidence(String id, int residence){
      int result = 0;
      
      try {
         result = service.changeResidence(id, residence);
         SuccessView.printMessage("\n"+"전출 신고가 완료되었습니다."+"\n\n");
         }catch (SQLException e) {
            FailView.printFailMessage(e.getMessage());
         }
         
      return result;
      
   }

   public void checkDetail(String id){
	   String message = null;
	   
	   try {
		   message = service.checkDetail(id);
		   SuccessView.printMessage("\n"+id+"님의 상세정보 : "+message+"\n\n");
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
		   SuccessView.printMessage("계정삭제 성공");
	   }catch (SQLException e) {
		FailView.printFailMessage(e.getMessage());
	}
   }
   
}