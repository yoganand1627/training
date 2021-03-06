package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;

/** @author ade.odutayo */
public class HomeApplicantSaveSI implements Serializable {
  /**
   * <p>fields required for save</p>
   * <p/>
   * <p>inquiry information section</p>
   */
  private int idHomeApplicant;
  private int idResource;
  private Date inquiryDate;
  private Date dateApplied;
  private String inquiryRecvdBy;
  private String infoPacktRequested;
  private Date infPacktSent;
  private int iRequestedNbrOfChildren;
  private String childSpecInterest;
  private String inquiryComments;

  /** <p>orientation preservice section</p> */
  private Date dtOrientation1;
  private Date dtOrientation2;
  private Date dtOrientation3;
  private String strOrientationStatus1;
  private String strOrientationStatus2;
  private String strOrientationStatus3;
  private Date dtInvitation1;
  private String strInvitationStatus1;
  private String strLocation1;
  private Date dtInvitation2;
  private String strInvitationStatus2;
  private String strLocation2;
  private Date dtInvitation3;
  private String strInvitationStatus3;
  private String strLocation3;
  private String orientationComments;
  private ROWCFAD08SIG07 sourceOfInquiry;
  private ROWCFAD08SIG07_ARRAY arraySourceOfInquiry;
  private ROWCFAD08SIG07 informationCovered;
  private ROWCFAD08SIG07_ARRAY arrayInformationCovered;
  private ROWCFAD08SIG07 programsOfInterest;
  private ROWCFAD08SIG07_ARRAY arrayProgramsOfInterest;

  private ArchInputStruct archInputStruct;
  private Date tsLastUpdate;

  public Date getTsLastUpdate() {
    return tsLastUpdate;
  }

  public void setTsLastUpdate(Date tsLastUpdate) {
    this.tsLastUpdate = tsLastUpdate;
  }

  public ArchInputStruct getArchInputStruct() {
    return archInputStruct;
  }

  public void setArchInputStruct(ArchInputStruct archInputStruct) {
    this.archInputStruct = archInputStruct;
  }

  public ROWCFAD08SIG07_ARRAY getArrayInformationCovered() {
    return arrayInformationCovered;
  }

  public void setArrayInformationCovered(ROWCFAD08SIG07_ARRAY arrayInformationCovered) {
    this.arrayInformationCovered = arrayInformationCovered;
  }

  public ROWCFAD08SIG07_ARRAY getArraySourceOfInquiry() {
    return arraySourceOfInquiry;
  }

  public void setArraySourceOfInquiry(ROWCFAD08SIG07_ARRAY arraySourceOfInquiry) {
    this.arraySourceOfInquiry = arraySourceOfInquiry;
  }

  public ROWCFAD08SIG07 getInformationCovered() {
    return informationCovered;
  }

  public void setInformationCovered(ROWCFAD08SIG07 informationCovered) {
    this.informationCovered = informationCovered;
  }

  public ROWCFAD08SIG07 getSourceOfInquiry() {
    return sourceOfInquiry;
  }

  public void setSourceOfInquiry(ROWCFAD08SIG07 sourceOfInquiry) {
    this.sourceOfInquiry = sourceOfInquiry;
  }

  public ROWCFAD08SIG07 getProgramsOfInterest() {
    return programsOfInterest;
  }

  public void setProgramsOfInterest(ROWCFAD08SIG07 programsOfInterest) {
    this.programsOfInterest = programsOfInterest;
  }

  public ROWCFAD08SIG07_ARRAY getArrayProgramsOfInterest() {
    return arrayProgramsOfInterest;
  }

  public void setArrayProgramsOfInterest(ROWCFAD08SIG07_ARRAY arrayProgramsOfInterest) {
    this.arrayProgramsOfInterest = arrayProgramsOfInterest;
  }

  public String getChildSpecInterest() {
    return childSpecInterest;
  }

  public void setChildSpecInterest(String childSpecInterest) {
    this.childSpecInterest = childSpecInterest;
  }

  public Date getDtInvitation1() {
    return dtInvitation1;
  }

  public void setDtInvitation1(Date dtInvitation1) {
    this.dtInvitation1 = dtInvitation1;
  }

  public Date getDtInvitation2() {
    return dtInvitation2;
  }

  public void setDtInvitation2(Date dtInvitation2) {
    this.dtInvitation2 = dtInvitation2;
  }

  public Date getDtInvitation3() {
    return dtInvitation3;
  }

  public void setDtInvitation3(Date dtInvitation3) {
    this.dtInvitation3 = dtInvitation3;
  }

  public Date getDtOrientation1() {
    return dtOrientation1;
  }

  public void setDtOrientation1(Date dtOrientation1) {
    this.dtOrientation1 = dtOrientation1;
  }

  public Date getDtOrientation2() {
    return dtOrientation2;
  }

  public void setDtOrientation2(Date dtOrientation2) {
    this.dtOrientation2 = dtOrientation2;
  }

  public Date getDtOrientation3() {
    return dtOrientation3;
  }

  public void setDtOrientation3(Date dtOrientation3) {
    this.dtOrientation3 = dtOrientation3;
  }

  public int getIdHomeApplicant() {
    return idHomeApplicant;
  }

  public void setIdHomeApplicant(int idHomeApplicant) {
    this.idHomeApplicant = idHomeApplicant;
  }

  public int getIdResource() {
    return idResource;
  }

  public void setIdResource(int idResource) {
    this.idResource = idResource;
  }

  public String getInfoPacktRequested() {
    return infoPacktRequested;
  }

  public void setInfoPacktRequested(String infoPacktRequested) {
    this.infoPacktRequested = infoPacktRequested;
  }

  public Date getInfPacktSent() {
    return infPacktSent;
  }

  public void setInfPacktSent(Date infPacktSent) {
    this.infPacktSent = infPacktSent;
  }

  public String getInquiryComments() {
    return inquiryComments;
  }

  public void setInquiryComments(String inquiryComments) {
    this.inquiryComments = inquiryComments;
  }

  public Date getInquiryDate() {
    return inquiryDate;
  }

  public void setInquiryDate(Date inquiryDate) {
    this.inquiryDate = inquiryDate;
  }

  public int getIRequestedNbrOfChildren() {
    return iRequestedNbrOfChildren;
  }

  public void setIRequestedNbrOfChildren(int requestedNbrOfChildren) {
    iRequestedNbrOfChildren = requestedNbrOfChildren;
  }

  public String getOrientationComments() {
    return orientationComments;
  }

  public void setOrientationComments(String orientationComments) {
    this.orientationComments = orientationComments;
  }

  public String getStrInvitationStatus1() {
    return strInvitationStatus1;
  }

  public void setStrInvitationStatus1(String strInvitationStatus1) {
    this.strInvitationStatus1 = strInvitationStatus1;
  }

  public String getStrInvitationStatus2() {
    return strInvitationStatus2;
  }

  public void setStrInvitationStatus2(String strInvitationStatus2) {
    this.strInvitationStatus2 = strInvitationStatus2;
  }

  public String getStrInvitationStatus3() {
    return strInvitationStatus3;
  }

  public void setStrInvitationStatus3(String strInvitationStatus3) {
    this.strInvitationStatus3 = strInvitationStatus3;
  }

  public String getStrLocation1() {
    return strLocation1;
  }

  public void setStrLocation1(String strLocation1) {
    this.strLocation1 = strLocation1;
  }

  public String getStrLocation2() {
    return strLocation2;
  }

  public void setStrLocation2(String strLocation2) {
    this.strLocation2 = strLocation2;
  }

  public String getStrLocation3() {
    return strLocation3;
  }

  public void setStrLocation3(String strLocation3) {
    this.strLocation3 = strLocation3;
  }

  public String getStrOrientationStatus1() {
    return strOrientationStatus1;
  }

  public void setStrOrientationStatus1(String strOrientationStatus1) {
    this.strOrientationStatus1 = strOrientationStatus1;
  }

  public String getStrOrientationStatus2() {
    return strOrientationStatus2;
  }

  public void setStrOrientationStatus2(String strOrientationStatus2) {
    this.strOrientationStatus2 = strOrientationStatus2;
  }

  public String getStrOrientationStatus3() {
    return strOrientationStatus3;
  }

  public void setStrOrientationStatus3(String strOrientationStatus3) {
    this.strOrientationStatus3 = strOrientationStatus3;
  }

  public String getInquiryRecvdBy() {
    return inquiryRecvdBy;
  }

  public void setInquiryRecvdBy(String inquiryRecvdBy) {
    this.inquiryRecvdBy = inquiryRecvdBy;
  }

  public Date getDateApplied() {
    return dateApplied;
  }

  public void setDateApplied(Date dateApplied) {
    this.dateApplied = dateApplied;
  }
}
