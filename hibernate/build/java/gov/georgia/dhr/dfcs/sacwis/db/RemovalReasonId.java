package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9



/**
 * RemovalReasonId generated by hbm2java
 */
public class RemovalReasonId  implements java.io.Serializable {


     private Integer idRemovalEvent;
     private String cdRemovalReason;

    public RemovalReasonId() {
    }

    public RemovalReasonId(Integer idRemovalEvent, String cdRemovalReason) {
       this.idRemovalEvent = idRemovalEvent;
       this.cdRemovalReason = cdRemovalReason;
    }
   
    public Integer getIdRemovalEvent() {
        return this.idRemovalEvent;
    }
    
    public void setIdRemovalEvent(Integer idRemovalEvent) {
        this.idRemovalEvent = idRemovalEvent;
    }
    public String getCdRemovalReason() {
        return this.cdRemovalReason;
    }
    
    public void setCdRemovalReason(String cdRemovalReason) {
        this.cdRemovalReason = cdRemovalReason;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RemovalReasonId) ) return false;
		 RemovalReasonId castOther = ( RemovalReasonId ) other; 
         
		 return ( (this.getIdRemovalEvent()==castOther.getIdRemovalEvent()) || ( this.getIdRemovalEvent()!=null && castOther.getIdRemovalEvent()!=null && this.getIdRemovalEvent().equals(castOther.getIdRemovalEvent()) ) )
 && ( (this.getCdRemovalReason()==castOther.getCdRemovalReason()) || ( this.getCdRemovalReason()!=null && castOther.getCdRemovalReason()!=null && this.getCdRemovalReason().equals(castOther.getCdRemovalReason()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdRemovalEvent() == null ? 0 : this.getIdRemovalEvent().hashCode() );
         result = 37 * result + ( getCdRemovalReason() == null ? 0 : this.getCdRemovalReason().hashCode() );
         return result;
   }   


}


