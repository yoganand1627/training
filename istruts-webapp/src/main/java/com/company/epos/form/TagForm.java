package com.company.epos.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class TagForm extends ActionForm {

	private List<String> logicEmpty = new ArrayList<String>();
	
	private List<String> logicNotEmpty = new ArrayList<String>();
	
	private int number = 100;
	
	private String emailId = "google@gmail.com";
	
	private String url = "www.google.com";
	

	public List<String> getLogicEmpty() {
		return logicEmpty;
	}

	public void setLogicEmpty(List<String> logicEmpty) {
		this.logicEmpty = logicEmpty;
	}

	public List<String> getLogicNotEmpty() {
		return logicNotEmpty;
	}

	public int getNumber() {
		return number;
	}

	public String getEmailId() {
		return emailId;
	}
}
