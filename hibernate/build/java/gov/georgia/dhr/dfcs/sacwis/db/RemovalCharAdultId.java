package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9



/**
 * RemovalCharAdultId generated by hbm2java
 */
public class RemovalCharAdultId  implements java.io.Serializable {


     private int idRemovalEvent;
     private String cdRemovAdultChar;

    public RemovalCharAdultId() {
    }

    public RemovalCharAdultId(int idRemovalEvent, String cdRemovAdultChar) {
       this.idRemovalEvent = idRemovalEvent;
       this.cdRemovAdultChar = cdRemovAdultChar;
    }
   
    public int getIdRemovalEvent() {
        return this.idRemovalEvent;
    }
    
    public void setIdRemovalEvent(int idRemovalEvent) {
        this.idRemovalEvent = idRemovalEvent;
    }
    public String getCdRemovAdultChar() {
        return this.cdRemovAdultChar;
    }
    
    public void setCdRemovAdultChar(String cdRemovAdultChar) {
        this.cdRemovAdultChar = cdRemovAdultChar;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RemovalCharAdultId) ) return false;
		 RemovalCharAdultId castOther = ( RemovalCharAdultId ) other; 
         
		 return (this.getIdRemovalEvent()==castOther.getIdRemovalEvent())
 && ( (this.getCdRemovAdultChar()==castOther.getCdRemovAdultChar()) || ( this.getCdRemovAdultChar()!=null && castOther.getCdRemovAdultChar()!=null && this.getCdRemovAdultChar().equals(castOther.getCdRemovAdultChar()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdRemovalEvent();
         result = 37 * result + ( getCdRemovAdultChar() == null ? 0 : this.getCdRemovAdultChar().hashCode() );
         return result;
   }   


}

