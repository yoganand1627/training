package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;

public class SiblingPlacementGroupSO implements Serializable {
	private int idSiblingGroup;

	private int nbrInGroup;

	private int nbrAvailable;

	private int idCase;
	
	public int getIdSiblingGroup() {
		return idSiblingGroup;
	}

	public void setIdSiblingGroup(int idSiblingGroup) {
		this.idSiblingGroup = idSiblingGroup;
	}

	public int getNbrInGroup() {
		return nbrInGroup;
	}

	public void setNbrInGroup(int nbrInGroup) {
		this.nbrInGroup = nbrInGroup;
	}

	public int getNbrAvailable() {
		return nbrAvailable;
	}

	public void setNbrAvailable(int nbrAvailable) {
		this.nbrAvailable = nbrAvailable;
	}
	
	public int getIdCase() {
		return idCase;
	}

	public void setIdCase(int idCase) {
		this.idCase = idCase;
	}
	
	@Override
	public int hashCode(){
		if(idSiblingGroup == 0){
			return super.hashCode();
		} else {
			return idSiblingGroup;
		}
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof SiblingSO){
			if(this.idSiblingGroup == 0) {
				return super.equals(o);
			} else {
				SiblingSO s =(SiblingSO)o;
				return s.getIdSiblingGroup() == this.idSiblingGroup;
			}
		}
		return false;
	}	
}
