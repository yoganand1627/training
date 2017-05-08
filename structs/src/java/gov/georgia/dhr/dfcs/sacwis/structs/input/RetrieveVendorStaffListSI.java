package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;

public class RetrieveVendorStaffListSI implements Serializable {
	private List<Integer> adminList;
	private ArchInputStruct input;
	private Integer idUser;
	private String cdSearchType;
	

	
	public List<Integer> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<Integer> adminList) {
		this.adminList = adminList;
	}
   
	public ArchInputStruct getArchInputStruct() {
		return input;
	}

	public void setArchInputStruct(ArchInputStruct input) {
		this.input = input;
	}

	
	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getCdSearchType() {
		return this.cdSearchType;
	}

	public void setCdSearchType(String cdSearchType) {
		this.cdSearchType = cdSearchType;
	}
}
