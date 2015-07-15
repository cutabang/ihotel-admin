package com.iHotel.managedBean;

import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import com.iHotel.entity.AdminUser;
import com.iHotel.service.UserService;
import com.iHotel.service.UserServiceImpl;
import com.iHotel.util.GeneralConstant;

@ManagedBean
@RequestScoped
public class LoginManagedBean {
    private String userId;
    private String password;
    private String loginResult;
    
    UserService userService;
    
    public String login() throws Exception {
    	AdminUser adminUser = null;
    	userService = new UserServiceImpl();
    	
    	adminUser = userService.login(userId, password);
    	
		if (adminUser != null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("adminUser", adminUser);
			
			return GeneralConstant.SUCCESS;
		} else {
    		ResourceBundle bundle = ResourceBundle.getBundle("com.iHotel.message.bundle");
    		
    		loginResult = bundle.getString("home.login.result.failed");
    		
    		return GeneralConstant.FAILED;
    	}
    }

    public String logout () {
    	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    	
    	return GeneralConstant.SUCCESS;
    }
    
	public String getLoginResult() {
		return loginResult;
	}

	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
