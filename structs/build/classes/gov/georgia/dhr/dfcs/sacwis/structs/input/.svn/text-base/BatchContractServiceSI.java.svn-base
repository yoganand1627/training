package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BatchContractServiceSI implements Serializable {
  private List<BatchContractServiceRow> BatchContractServiceRowList = new ArrayList<BatchContractServiceRow>();
  private ArchInputStruct input;
  private int userId;
  private int idResource;
  private int idContract;
  private int ulNbrContractPeriod;
  private int ulNbrContractVersion;
  private String contractFunctionType;
  private Date countyEffective;
  private Date countyEnd;
  
  public int getIdResource() {
    return idResource;
  }
  public void setIdResource(int idResource) {
    this.idResource = idResource;
  }
  public Date getCountyEffective() {
    return countyEffective;
  }
  public void setCountyEffective(Date countyEffective) {
    this.countyEffective = countyEffective;
  }
  public Date getCountyEnd() {
    return countyEnd;
  }
  public void setCountyEnd(Date countyEnd) {
    this.countyEnd = countyEnd;
  }
  public String getContractFunctionType() {
    return contractFunctionType;
  }
  public void setContractFunctionType(String contractFunctionType) {
    this.contractFunctionType = contractFunctionType;
  }
 
  public int getUlNbrContractPeriod() {
    return ulNbrContractPeriod;
  }

  public void setUlNbrContractPeriod(int ulNbrContractPeriod) {
    this.ulNbrContractPeriod = ulNbrContractPeriod;
  }

  public int getUlNbrContractVersion() {
    return ulNbrContractVersion;
  }

  public void setUlNbrContractVersion(int ulNbrContractVersion) {
    this.ulNbrContractVersion = ulNbrContractVersion;
  }

  public int getIdContract() {
    return idContract;
  }

  public void setIdContract(int idContract) {
    this.idContract = idContract;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public List<BatchContractServiceRow> getBatchContractServiceRowList() {
    return BatchContractServiceRowList;
  }

  public void setBatchContractServiceRowList(List<BatchContractServiceRow> batchContractServiceRowList) {
    BatchContractServiceRowList = batchContractServiceRowList;
  }
  
  public BatchContractServiceRow getBatchContractServiceRow(){
    return new BatchContractServiceRow();
  }
  
  public void setInput(ArchInputStruct input) {
    this.input = input;
  }

  public ArchInputStruct getInput() {
    return input;
  }

  public class BatchContractServiceRow{
    private String serviceCode;
    private String unitType;
    private String paymentType;
    private Double unitRate;
    private int federalMatch;
    private int localMatch;
    private int ulNbrCnsvcLineItem;
    
    public int getUlNbrCnsvcLineItem() {
      return ulNbrCnsvcLineItem;
    }
    public void setUlNbrCnsvcLineItem(int ulNbrCnsvcLineItem) {
      this.ulNbrCnsvcLineItem = ulNbrCnsvcLineItem;
    }
    public String getServiceCode() {
      return serviceCode;
    }
    public void setServiceCode(String serviceCode) {
      this.serviceCode = serviceCode;
    }
    public String getUnitType() {
      return unitType;
    }
    public void setUnitType(String unitType) {
      this.unitType = unitType;
    }
    public String getPaymentType() {
      return paymentType;
    }
    public void setPaymentType(String paymentType) {
      this.paymentType = paymentType;
    }
    public Double getUnitRate() {
      return unitRate;
    }
    public void setUnitRate(Double unitRate) {
      this.unitRate = unitRate;
    }
    public int getFederalMatch() {
      return federalMatch;
    }
    public void setFederalMatch(int federalMatch) {
      this.federalMatch = federalMatch;
    }
    public int getLocalMatch() {
      return localMatch;
    }
    public void setLocalMatch(int localMatch) {
      this.localMatch = localMatch;
    }
  }
}
