package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * WebServicesTestTable generated by hbm2java
 */
public class WebServicesTestTable  implements java.io.Serializable {


     private Integer idws;
     private Integer testColumnNum;
     private String testColumnChar;
     private String testColumnVar2;
     private Date testColumnDate;

    public WebServicesTestTable() {
    }

    public WebServicesTestTable(Integer testColumnNum, String testColumnChar, String testColumnVar2, Date testColumnDate) {
       this.testColumnNum = testColumnNum;
       this.testColumnChar = testColumnChar;
       this.testColumnVar2 = testColumnVar2;
       this.testColumnDate = testColumnDate;
    }
   
    public Integer getIdws() {
        return this.idws;
    }
    
    public void setIdws(Integer idws) {
        this.idws = idws;
    }
    public Integer getTestColumnNum() {
        return this.testColumnNum;
    }
    
    public void setTestColumnNum(Integer testColumnNum) {
        this.testColumnNum = testColumnNum;
    }
    public String getTestColumnChar() {
        return this.testColumnChar;
    }
    
    public void setTestColumnChar(String testColumnChar) {
        this.testColumnChar = testColumnChar;
    }
    public String getTestColumnVar2() {
        return this.testColumnVar2;
    }
    
    public void setTestColumnVar2(String testColumnVar2) {
        this.testColumnVar2 = testColumnVar2;
    }
    public Date getTestColumnDate() {
        return this.testColumnDate;
    }
    
    public void setTestColumnDate(Date testColumnDate) {
        this.testColumnDate = testColumnDate;
    }




}

