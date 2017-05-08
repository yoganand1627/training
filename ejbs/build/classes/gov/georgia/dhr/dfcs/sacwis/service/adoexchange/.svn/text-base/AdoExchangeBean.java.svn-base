package gov.georgia.dhr.dfcs.sacwis.service.adoexchange;

import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExchangeChildDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExchangeChildDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExchangeHomeChildrenSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExchangeHomeDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterHomeConversionChildBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterHomeConversionSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NonIncidentAFCARSInformationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SiblingGroupInformationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SiblingGroupSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildLinkStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeChildDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeChildDetailSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeHomeDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterHomeConversionSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NonIncidentAFCARSInformationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RecruitmentActivitiesSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingGroupInformationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingGroupSO;

import java.util.List;

import javax.ejb.CreateException;

public class AdoExchangeBean extends BaseSpringStatelessSessionBean implements AdoExchange {

  private RetrieveExchangeChildDetail retrieveExchangeChildDetail;

  private SaveExchangeChildDetail saveExchangeChildDetail;
  
  private RetrieveExchangeHomeDetail retrieveExchangeHomeDetail;
  
  private SaveExchangeHomeDetail saveExchangeHomeDetail;
    
  private RetrieveFosterHomeConversion retrieveFosterHomeConversion;
  
  private SaveFosterHomeConversion saveFosterHomeConversion;
  
  private RemoveChildFromFosterHomeConversion removeChildFromFosterHomeConversion;
  
  private RetrieveNonIncidentAFCARSInformation retrieveNonIncidentAFCARSInformation;
  
  private SaveNonIncidentAFCARSInformation saveNonIncidentAFCARSInformation;
  
  private SaveExchangeHomeChildFamLink saveExchangeHomeChildFamLink;
  
  private SaveExChildFamLink saveExChildFamLink;
  
  private SaveExChildFamUnlink saveExChildFamUnlink;
  
  private RetrieveSiblingGroup retrieveSiblingGroup;
  
  private RetrieveRecruitmentActivities retrieveRecruitmentActivities;

  public ExchangeChildDetailRetrieveSO retrieveExchangeChildDetail(ExchangeChildDetailRetrieveSI exchangeChildDetail) {
    return retrieveExchangeChildDetail.retrieveExchangeChildDetail(exchangeChildDetail);
  }
  
  public  ExchangeChildDetailSaveSO saveExchangeChildDetail(ExchangeChildDetailSaveSI exchangeChildDetailSaveSI) {
    return saveExchangeChildDetail.saveExchangeChildDetail(exchangeChildDetailSaveSI);
  }
  
  public ExchangeHomeDetailSO retrieveExchangeHomeDetail(ExchangeHomeDetailSI exchangeHomeDetail) {
    return retrieveExchangeHomeDetail.retrieveExchangeHomeDetail(exchangeHomeDetail);
  }
  
  public ExchangeHomeDetailSO saveExchangeHomeDetail(ExchangeHomeDetailSI exchangeHomeDetail) {
    return saveExchangeHomeDetail.saveExchangeHomeDetail(exchangeHomeDetail);
  }
  
  public FosterHomeConversionSO retrieveFosterHomeConversion(FosterHomeConversionSI fosterHomeConversionSI) {
    return retrieveFosterHomeConversion.retrieveFosterHomeConversion(fosterHomeConversionSI);
  }
  
  public FosterHomeConversionSO saveFosterHomeConversion(FosterHomeConversionSI fosterHomeConversionSI){
    return saveFosterHomeConversion.saveFosterHomeConversion(fosterHomeConversionSI);
  }
  
  public int removeChildFromFosterHomeConversion(FosterHomeConversionChildBean fosterHomeConversionChildBean){
    return removeChildFromFosterHomeConversion.removeChildFromFosterHomeConversion(fosterHomeConversionChildBean);
  }
  
  public NonIncidentAFCARSInformationSO retrieveNonIncidentAFCARSInformation(NonIncidentAFCARSInformationSI nonIncidentAFCARSInformationSI) {
    return retrieveNonIncidentAFCARSInformation.retrieveNonIncidentAFCARSInformation(nonIncidentAFCARSInformationSI);
  }

  public void saveNonIncidentAFCARSInformation(NonIncidentAFCARSInformationSI nonIncidentAFCARSInformationSI) {
    saveNonIncidentAFCARSInformation.saveNonIncidentAFCARSInformation(nonIncidentAFCARSInformationSI);
    return;
  }
  
  public void saveLinkedExchangeHomeChildFamLink(List<ExchangeHomeChildrenSI> exchangeHomeChildren) {
    saveExchangeHomeChildFamLink.saveLinkedExchangeHomeChildFamLink(exchangeHomeChildren);
  }
  
  public void saveUnLinkedExchangeHomeChildFamLink(List<ExchangeHomeChildrenSI> exchangeHomeChildren) {
    saveExchangeHomeChildFamLink.saveUnLinkedExchangeHomeChildFamLink(exchangeHomeChildren);
  }
  
  public void updateExchangeHomeChildDateOuts(List<ExchangeHomeChildrenSI> exchangeHomeChildren) {
    saveExchangeHomeChildFamLink.updateExchangeHomeChildDateOuts(exchangeHomeChildren);
  }
  
  public void saveExChildFamLink(List<ChildLinkStruct> childLinkStructList) {
    saveExChildFamLink.saveExChildFamLink(childLinkStructList);
  }
  
  public void saveExChildFamUnlink(List<ChildLinkStruct> childLinkStructList) {
    saveExChildFamUnlink.saveExChildFamUnlink(childLinkStructList);
  }
  
  public SiblingGroupSO retrieveSiblingGroup(SiblingGroupSI siblingGroupSI) {
    return retrieveSiblingGroup.retrieveSiblingGroup(siblingGroupSI);
  }
  
  public Boolean hasAprvFosterHomeConversion(Integer idResource) {
    return retrieveFosterHomeConversion.hasAprvFosterHomeConversion(idResource);
  }
  
  public Boolean hasAprvFosterHomeConversionForCase(Integer idCase) {
    return retrieveFosterHomeConversion.hasAprvFosterHomeConversionForCase(idCase);
  }
  
  public void deleteExchangeHomeChildFamLink(List<ExchangeHomeChildrenSI> exchangeHomeChildren) {
    saveExchangeHomeChildFamLink.deleteExchangeHomeChildFamLink(exchangeHomeChildren);
  }
  
  public void deleteExChildFamUnlink(List<ChildLinkStruct> childLinkStructList) {
    saveExChildFamUnlink.deleteExChildFamUnlink(childLinkStructList);
  }
  
  public RecruitmentActivitiesSO retrieveRecruitmentActivities(int idEvent, String cdCbxCodeType) {
    return retrieveRecruitmentActivities.retrieveRecruitmentActivities(idEvent, cdCbxCodeType);
  }
  
  @Override
  protected void onEjbCreate() throws CreateException {
    retrieveExchangeChildDetail = getService(RetrieveExchangeChildDetail.class);
    saveExchangeChildDetail = getService(SaveExchangeChildDetail.class);
    retrieveExchangeHomeDetail = getService(RetrieveExchangeHomeDetail.class);
    saveExchangeHomeDetail = getService(SaveExchangeHomeDetail.class);
    retrieveFosterHomeConversion = getService(RetrieveFosterHomeConversion.class);
    saveFosterHomeConversion = getService(SaveFosterHomeConversion.class);
    retrieveNonIncidentAFCARSInformation = getService(RetrieveNonIncidentAFCARSInformation.class);
    saveNonIncidentAFCARSInformation = getService(SaveNonIncidentAFCARSInformation.class);
    saveExchangeHomeChildFamLink = getService(SaveExchangeHomeChildFamLink.class);
    saveExChildFamLink = getService(SaveExChildFamLink.class);
    saveExChildFamUnlink = getService(SaveExChildFamUnlink.class);
    removeChildFromFosterHomeConversion = getService(RemoveChildFromFosterHomeConversion.class);
    retrieveSiblingGroup = getService(RetrieveSiblingGroup.class);
    retrieveRecruitmentActivities = getService(RetrieveRecruitmentActivities.class);
  }
}
