package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9



/**
 * PersonMergeViewId generated by hbm2java
 */
public class PersonMergeViewId  implements java.io.Serializable {


     private Integer idPersonInput;
     private Integer idPersonOutput;

    public PersonMergeViewId() {
    }

    public PersonMergeViewId(Integer idPersonInput, Integer idPersonOutput) {
       this.idPersonInput = idPersonInput;
       this.idPersonOutput = idPersonOutput;
    }
   
    public Integer getIdPersonInput() {
        return this.idPersonInput;
    }
    
    public void setIdPersonInput(Integer idPersonInput) {
        this.idPersonInput = idPersonInput;
    }
    public Integer getIdPersonOutput() {
        return this.idPersonOutput;
    }
    
    public void setIdPersonOutput(Integer idPersonOutput) {
        this.idPersonOutput = idPersonOutput;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PersonMergeViewId) ) return false;
		 PersonMergeViewId castOther = ( PersonMergeViewId ) other; 
         
		 return ( (this.getIdPersonInput()==castOther.getIdPersonInput()) || ( this.getIdPersonInput()!=null && castOther.getIdPersonInput()!=null && this.getIdPersonInput().equals(castOther.getIdPersonInput()) ) )
 && ( (this.getIdPersonOutput()==castOther.getIdPersonOutput()) || ( this.getIdPersonOutput()!=null && castOther.getIdPersonOutput()!=null && this.getIdPersonOutput().equals(castOther.getIdPersonOutput()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdPersonInput() == null ? 0 : this.getIdPersonInput().hashCode() );
         result = 37 * result + ( getIdPersonOutput() == null ? 0 : this.getIdPersonOutput().hashCode() );
         return result;
   }   


}


