package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9



/**
 * PalPublicAssistId generated by hbm2java
 */
public class PalPublicAssistId  implements java.io.Serializable {


     private Integer idPalPublicAssistStge;
     private String cdPalPublicAssist;
     private int idPalFollowUp;

    public PalPublicAssistId() {
    }

    public PalPublicAssistId(Integer idPalPublicAssistStge, String cdPalPublicAssist, int idPalFollowUp) {
       this.idPalPublicAssistStge = idPalPublicAssistStge;
       this.cdPalPublicAssist = cdPalPublicAssist;
       this.idPalFollowUp = idPalFollowUp;
    }
   
    public Integer getIdPalPublicAssistStge() {
        return this.idPalPublicAssistStge;
    }
    
    public void setIdPalPublicAssistStge(Integer idPalPublicAssistStge) {
        this.idPalPublicAssistStge = idPalPublicAssistStge;
    }
    public String getCdPalPublicAssist() {
        return this.cdPalPublicAssist;
    }
    
    public void setCdPalPublicAssist(String cdPalPublicAssist) {
        this.cdPalPublicAssist = cdPalPublicAssist;
    }
    public int getIdPalFollowUp() {
        return this.idPalFollowUp;
    }
    
    public void setIdPalFollowUp(int idPalFollowUp) {
        this.idPalFollowUp = idPalFollowUp;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PalPublicAssistId) ) return false;
		 PalPublicAssistId castOther = ( PalPublicAssistId ) other; 
         
		 return ( (this.getIdPalPublicAssistStge()==castOther.getIdPalPublicAssistStge()) || ( this.getIdPalPublicAssistStge()!=null && castOther.getIdPalPublicAssistStge()!=null && this.getIdPalPublicAssistStge().equals(castOther.getIdPalPublicAssistStge()) ) )
 && ( (this.getCdPalPublicAssist()==castOther.getCdPalPublicAssist()) || ( this.getCdPalPublicAssist()!=null && castOther.getCdPalPublicAssist()!=null && this.getCdPalPublicAssist().equals(castOther.getCdPalPublicAssist()) ) )
 && (this.getIdPalFollowUp()==castOther.getIdPalFollowUp());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdPalPublicAssistStge() == null ? 0 : this.getIdPalPublicAssistStge().hashCode() );
         result = 37 * result + ( getCdPalPublicAssist() == null ? 0 : this.getCdPalPublicAssist().hashCode() );
         result = 37 * result + this.getIdPalFollowUp();
         return result;
   }   


}


