package com.bookmarket.controller;

import java.util.Map;

import com.bookmarket.dto.User;
import com.bookmarket.exception.InvalidPasswordException;
import com.bookmarket.exception.NotFoundUserIDException;
import com.bookmarket.service.OracleUserServiceImpl;
import com.bookmarket.service.UserService;
import com.bookmarket.session.ApplicationSession;
import com.bookmarket.view.LoginView;
import com.bookmarket.view.View;

public class LoginController extends Controller {

	private View view = new LoginView();
	private UserService service = new OracleUserServiceImpl();

	@Override
	public void execute(Map<String, Object> request)throws Exception  {
		do {
			Map<String, Object> dataMap = view.excute(null);

			String id = (String) dataMap.get("id");
			String pwd = (String) dataMap.get("pwd");

			try {
				service.login(id, pwd);
				
				User user = service.menuGuestInfo(id);
				ApplicationSession.getSession().setAttribute("loginUser", user);
				
				break;
			} catch (NotFoundUserIDException | InvalidPasswordException e) {
				System.out.println(e.getMessage());
			} 
			
		} while (true);
	}

}
