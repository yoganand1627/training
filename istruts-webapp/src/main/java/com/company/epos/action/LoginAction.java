package com.company.epos.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.company.epos.form.UserForm;

public class LoginAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		UserForm userForm = (UserForm)form;
		
		System.out.println("FirstName:::::"+userForm.getFirstName());
		System.out.println("LastName::::::"+userForm.getLastName());
		System.out.println("Gender::::::::"+userForm.getGender());
		System.out.println("EmailId:::::::"+userForm.getEmailId());
		System.out.println("Password::::::"+userForm.getPassword());
	
		
		if(userForm.getEmailId() != null && userForm.getPassword() != null){
			return mapping.findForward("showCustomerHomeScreen");
		}else{
			return mapping.findForward("showLoginScreen");
		}
	}
}
