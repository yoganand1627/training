package com.company.epos.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.company.epos.form.TagForm;

public class TagAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("=======================================");
		TagForm aForm = (TagForm)form;
		
		List<String> listMsg0 = new ArrayList<String>();
		 
		listMsg0.add("Message A");
		listMsg0.add("Message B");
		listMsg0.add("Message C");
		listMsg0.add("Message D");
 
		request.setAttribute("listMsg0", listMsg0);
		
		return mapping.findForward("success");
	}
}
