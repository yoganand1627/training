package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9



/**
 * ReferralHomeLinkId generated by hbm2java
 */
public class ReferralHomeLinkId  implements java.io.Serializable {


     private int idResource;
     private int idEvent;

    public ReferralHomeLinkId() {
    }

    public ReferralHomeLinkId(int idResource, int idEvent) {
       this.idResource = idResource;
       this.idEvent = idEvent;
    }
   
    public int getIdResource() {
        return this.idResource;
    }
    
    public void setIdResource(int idResource) {
        this.idResource = idResource;
    }
    public int getIdEvent() {
        return this.idEvent;
    }
    
    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ReferralHomeLinkId) ) return false;
		 ReferralHomeLinkId castOther = ( ReferralHomeLinkId ) other; 
         
		 return (this.getIdResource()==castOther.getIdResource())
 && (this.getIdEvent()==castOther.getIdEvent());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdResource();
         result = 37 * result + this.getIdEvent();
         return result;
   }   


}

