package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoSubsidyRateDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.OfficeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourcePhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecialNeedsDeterminationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoSubsidyRate;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.db.SpecialNeedsDetermination;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.document.SpecialServicesAdoptionAssistanceAgreementForm;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ADOFORMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ADOFORMSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *   Change History:
 *   Date         User                  Description
 *   --------     -------------------   --------------------------------------
 *   07/29/2008   Vishala Devarakonda   Initial creation of Special Services 
 *                                      Adoption Assistance Agreement form service  
 *   02/18/2009   Courtney Wells        Displaying office telephone number in correct formatt(###)###-####     
 *   07/06/2009   bgehlot               STGAP00014563: Basic rate recalculated depending on what's selected on Adoption Application                               
 *   07/13/2009   bgehlot               STGAP00014680: Calculation redone    
 *   11/16/2009   mchillman             SMS37389: display full date     
 *                                                   
 *                                                   
 * </pre>
 * 
 */
public class SpecialServicesAdoptionAssistanceAgreementFormImpl extends BaseDocumentServiceImpl implements
                                                                                               SpecialServicesAdoptionAssistanceAgreementForm {
  
  private static final int MONTHS = 12; 
  
  private static final int DAYS_IN_YEAR = 365; 

  private PersonPhoneDAO personPhoneDAO;

  private PlacementDAO placementDAO;

  private SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO;

  private ResourcePhoneDAO resourcePhoneDAO;

  private ResourceAddressDAO resourceAddressDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private CapsResourceDAO capsResourceDAO;

  private EmployeeDAO employeeDAO;

  private OfficeDAO officeDAO;

  private ApproversDAO approversDAO;

  private PersonDAO personDAO;
  
  private AdoSubsidyRateDAO adoSubsidyRateDAO;
  
  public PersonDAO getPersonDAO() {
    return personDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setSpecialNeedsDeterminationDAO(SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO) {
    this.specialNeedsDeterminationDAO = specialNeedsDeterminationDAO;
  }

  public void setResourcePhoneDAO(ResourcePhoneDAO resourcePhoneDAO) {
    this.resourcePhoneDAO = resourcePhoneDAO;
  }

  public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setOfficeDAO(OfficeDAO officeDAO) {
    this.officeDAO = officeDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public ADOFORMSO retrieveSpecialServicesAdoptionAssistanceAgreementForm(ADOFORMSI adoFormSI) {
    ADOFORMSO adoFormso = new ADOFORMSO();

    int idCase = adoFormSI.getUlIdCase();
    int idStage = adoFormSI.getUlIdStage();
    int idChildPrimary = adoFormSI.getUlIdPerson();
    int idEvent = adoFormSI.getUlIdEvent();
    PreFillData preFillData = new PreFillData();
    // ******************************** Build the Objects used in the form *****************//
   
    retrieveCaseMgrInfo(preFillData, idStage);
    retrieveResourceInfo(preFillData, idChildPrimary, idCase);
    retrieveAdoptionSubsidyInfo(preFillData, idCase, idEvent, idStage, idChildPrimary);
    adoFormso.setPreFillData(preFillData);
    return adoFormso;
  }

  // get the case manager for the ADO stage
  private Person getCaseManagerInfo(int idStage) {
    // Checking for current case manager as well as historical case manager
    StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdStageCdStagePersRoleAll(idStage);
    Person caseMngr = stagePersonLink.getPerson();
    return caseMngr;
  } // end getCaseManagerInfo()

  // if a person has a primary active & valid business office phone, select it, otherwise get the next active & valid
  // business phone available
  private String getPersonOfficePhone(int idPerson) {
    List<String> phoneTypes = new ArrayList<String>();
    phoneTypes.add(CodesTables.CPHNTYP_BC); // Business Cell
    phoneTypes.add(CodesTables.CPHNTYP_BP); // Business Pager
    phoneTypes.add(CodesTables.CPHNTYP_BS); // Business

    return getPersonOfficePhoneNbr(idPerson, phoneTypes);
  }

  private String getPersonOfficePhoneNbr(int idPerson, List<String> phoneTypes) {
    StringBuffer primPersonPhone = new StringBuffer();
    String indPersonPhoneInValid = "N";
    String indPersonPhonePrimary = "Y";

    Date maxDate = DateHelper.toJavaDate(DateHelper.MAX_CASTOR_DATE);
    List<PersonPhone> personPhones = personPhoneDAO
                                                   .findPersonPhoneByIdPersonDtPersonPhoneCdPersonPhoneTypes(
                                                                                                             idPerson,
                                                                                                             maxDate,
                                                                                                             indPersonPhoneInValid,
                                                                                                             phoneTypes);

    for (Iterator<PersonPhone> it = personPhones.iterator(); it.hasNext();) {

      PersonPhone personPhone = it.next();
      if (personPhone != null) {
        if (indPersonPhonePrimary.equals(personPhone.getIndPersonPhonePrimary())) {
          if (personPhone.getNbrPersonPhone() != null) {
            primPersonPhone.append(FormattingHelper.formatPhone(personPhone.getNbrPersonPhone()));
            if (personPhone.getNbrPersonPhoneExtension() != null) {
              primPersonPhone
                             .append("   Ext " + FormattingHelper.formatPhone(personPhone.getNbrPersonPhoneExtension()));
            }
            break;
          }
        } else {
          if (personPhone.getNbrPersonPhone() != null) {
            primPersonPhone.append(FormattingHelper.formatPhone(personPhone.getNbrPersonPhone()));
            if (personPhone.getNbrPersonPhoneExtension() != null) {
              primPersonPhone
                             .append("   Ext " + FormattingHelper.formatPhone(personPhone.getNbrPersonPhoneExtension()));
            }
            break;
          } // inner else
        } // end outer if indPersonPhonePrimary
      } // end if personPhone
    } // end for loop
    return primPersonPhone.toString();

  }

  private String getFullName(Person person) {
    StringBuffer fullName = new StringBuffer();
    if (person != null) {
      fullName.append(person.getNmPersonFirst());
      if (person.getNmPersonMiddle() != null) {
        fullName.append(" " + person.getNmPersonMiddle());
      }
      if (person.getNmPersonLast() != null) {
        fullName.append(" " + person.getNmPersonLast());
      }
    }
    return fullName.toString();
  }

  // Start Current Placement
  private Placement getCurrentPlacement(int idPrimaryChild, int idCase) {
    return placementDAO.findLatestApprovedPlacementByIdPersonByIdCase(idPrimaryChild, idCase, DateHelper.MAX_JAVA_DATE);
  }

  @SuppressWarnings( { "unchecked" })
  private void retrieveCaseMgrInfo(PreFillData preFillData, int idStage) {
    Person caseMngr = null;
    String nmCaseMngr = "";
    String phCaseMngr = "";
    String offCounty = "";
    String offcAddress = "";
    caseMngr = getCaseManagerInfo(idStage);
    if (caseMngr != null) {
      Employee employee = employeeDAO.findEmployeeByIdPerson(caseMngr.getIdPerson());
      if (employee != null) {
        offCounty = employee.getUnit() == null ? "" : employee.getUnit().getCdCounty();
      }
      nmCaseMngr = getFullName(caseMngr);
      phCaseMngr = getPersonOfficePhone(caseMngr.getIdPerson());
      Map address = officeDAO.findOffcAddressByIdPerson(caseMngr.getIdPerson());
      if (address != null) {
        StringBuffer addr = new StringBuffer();
        formatAddress((String) address.get("addrMailCodeStLn1"), (String) address.get("addrMailCodeStLn2"),
                      (String) address.get("addrMailCodeCity"), CodesTables.CSTATE_GA, (String) address.get("addrMailCodeZip"), addr);
        offcAddress = addr.toString();
      }

    }
    preFillData
               .addBookmark(createBookmark(ADO_ASST_CASE_COUNTY, Lookup.simpleDecodeSafe(CodesTables.CCOUNT, offCounty)));
    preFillData.addBookmark(createBookmark(ADO_ASST_NM_CASE_WORKER, nmCaseMngr));
    preFillData.addBookmark(createBookmark(ADO_ASST_NBR_OFFC_PHONE, FormattingHelper.formatPhone(phCaseMngr)));
    preFillData.addBookmark(createBookmark(ADO_ASST_OFFC_ADDR, offcAddress));
  }

  @SuppressWarnings( { "unchecked" })
  private void retrieveResourceInfo(PreFillData preFillData, int idChildPrimary, int idCase) {
    Placement adoPlcmt = null;
    String nmAdoptiveParents = "";
    String nbrPhone = "";
    int idFadStage = 0;
    String address = "";
    adoPlcmt = getCurrentPlacement(idChildPrimary, idCase);
    if (adoPlcmt != null) {
      int idResource = adoPlcmt.getCapsResourceByIdRsrcFacil() == null ? 0 : adoPlcmt.getCapsResourceByIdRsrcFacil()
                                                                                     .getIdResource();
      if (idResource > 0) {
        Map phoneInfo = resourcePhoneDAO.findResourcePhoneInfo(idResource);
        String phoneNbr = FormattingHelper.formatPhone((String) phoneInfo.get("nbrRsrcPhone"));
        String ext = (String) phoneInfo.get("nbrRsrcPhoneExt");
        if (phoneNbr != null) {
          nbrPhone = phoneNbr;
          if (ext != null) {
            nbrPhone = nbrPhone + "   Ext " + ext;
          }
        }
        ResourceAddress rsrcAddress = resourceAddressDAO.findRsrcAddressByAddressTypeOnly(idResource);
        if (rsrcAddress != null) {
          StringBuffer addr = new StringBuffer();
          formatAddress(rsrcAddress.getAddrRsrcAddrStLn1(), rsrcAddress.getAddrRsrcAddrStLn2(),
                        rsrcAddress.getAddrRsrcAddrCity(), rsrcAddress.getCdRsrcAddrState(),
                        rsrcAddress.getAddrRsrcAddrZip(), addr);
          address = addr.toString();
        }
        CapsResource resource = capsResourceDAO.findCapsResourceByIdResc(idResource);
        if (resource != null) {
          idFadStage = resource.getStage() == null ? 0 : resource.getStage().getIdStage();
          if (idFadStage > 0) {
            Collection cdStagePersTypes = new ArrayList<String>();
            cdStagePersTypes.add(CodesTables.CRELVICT_AF);
            cdStagePersTypes.add(CodesTables.CRELVICT_PT);
            cdStagePersTypes.add(CodesTables.CRELVICT_FP);
            cdStagePersTypes.add(CodesTables.CRELVICT_FA);
            List<StagePersonLink> personList = stagePersonLinkDAO
                                                                 .findStagePersonLinkByIdStageByCdStagePersRelInts(
                                                                                                                   idFadStage,
                                                                                                                   cdStagePersTypes);
            if (personList != null) {
              Iterator it = personList.iterator();
              StringBuffer fullName = new StringBuffer();
              while (it.hasNext()) {
                StagePersonLink stgPerson = (StagePersonLink) it.next();
                Person person = stgPerson.getPerson();
                if (person != null) {
                  if (fullName.length() > 0) {
                    fullName.append(", " + getFullName(person));
                  } else {
                    fullName.append(getFullName(person));
                  }
                }
              }
              nmAdoptiveParents = fullName.toString();
            }
          }
        }
      }
    }
    preFillData.addBookmark(createBookmark(ADO_ASST_NM_PARENTS, nmAdoptiveParents));
    preFillData.addBookmark(createBookmark(ADO_ASST_RSRC_ADDR, address));
    preFillData.addBookmark(createBookmark(ADO_ASST_NBR_RSRC_PHONE, nbrPhone));

  }

  @SuppressWarnings( { "unchecked" })
  private void retrieveAdoptionSubsidyInfo(PreFillData preFillData, int idCase, int idEvent, int idStage, int idChildPrimary) {
    // Adoption Subsidy detail
    String nmChildPrimary = "";
    Double amtMonthlyAsst = 0.0;
    Double amtApproved = 0.0;
    String svcType = "";
    Double amtReq = 0.0;
    String rsnReqDenied = "";
    String dtBegin = null;
    String dtEnd = null;
    Date beginDate = null;
    SpecialNeedsDetermination spclNdsDetem = specialNeedsDeterminationDAO
                                                                         .findSpecialNeedsDeterminationByIdEvent(idEvent);
    SpecialNeedsDetermination mostRecentSpclNdsDeterm = specialNeedsDeterminationDAO.findSpclDeterminationByIdStageByIdPerson(idStage, idChildPrimary, idCase);
    Date endDate = null;
    if (spclNdsDetem != null) {
      amtApproved = spclNdsDetem.getNbrApprvAmt();
      svcType = Lookup.simpleDecodeSafe(CodesTables.CSPLSERV, spclNdsDetem.getCdSpclSerType());
      amtReq = spclNdsDetem.getNbrReqAmt();
      String cdEventStatus = CodesTables.CEVTSTAT_APRV;
      Date dtApproved = null;
      endDate = spclNdsDetem.getDtExpirationDate();
      beginDate = spclNdsDetem.getDtApprvDate();
      if (beginDate != null) {
        dtBegin = DateHelper.toString(beginDate, DateHelper.SLASH_FORMAT);
      }
      if (endDate != null) {
        dtEnd = DateHelper.toString(endDate, DateHelper.SLASH_FORMAT);
      }
      Approvers approver = approversDAO.findApproverByIdEventIfEventIsApproved(idEvent, cdEventStatus);
      if (approver != null) {
        dtApproved = approver.getDtApproversDetermination();
      }
      if (spclNdsDetem.getIndSpclReqApproved() != null
          && ArchitectureConstants.Y.equals(spclNdsDetem.getIndSpclReqApproved())) {
        preFillData.addBookmark(createBookmark(ADO_ASST_IND_APPROVED, "CHECKED"));
        preFillData.addBookmark(createBookmark(ADO_ASST_AMT_APPROVED, FormattingHelper.formatMoney(amtApproved)));
        preFillData.addBookmark(createBookmark(ADO_ASST_DT_BEGIN, FormattingHelper.formatString(dtBegin)));
        preFillData.addBookmark(createBookmark(ADO_ASST_DT_END, FormattingHelper.formatString(dtEnd)));
        preFillData.addBookmark(createBookmark(ADO_ASST_DT_APPROVAL, FormattingHelper.formatDate(dtApproved)));
      } else if (spclNdsDetem.getIndSpclReqApproved() != null
                 && ArchitectureConstants.N.equals(spclNdsDetem.getIndSpclReqApproved())) {
        rsnReqDenied = spclNdsDetem.getTxtComments();
        preFillData.addBookmark(createBookmark(ADO_ASST_IND_DENIED, "CHECKED"));
        preFillData.addBookmark(createBookmark(ADO_ASST_RSN_DENIAL, FormattingHelper.formatString(rsnReqDenied)));
      }
      // Check if basic rate is requested and approved if it is than set the Monthly adoption assistance amount
      // to basic rate else check if the specialized rate is approved and the amount approved is greater than 0.0
      // if so set Monthly adoption assistance amount to specialized rate amount.
      
      //STGAP00014563: Get the basic rate as per the Basic Rate Type selected
      if (mostRecentSpclNdsDeterm != null) {
        if (ArchitectureConstants.Y.equals(mostRecentSpclNdsDeterm.getIndSpcNeedsApproved())) {
          Date dob = personDAO.findDateOfBirthByIdPerson(idChildPrimary);
          if (dob != null) {
            int age = DateHelper.getAge(dob);
            AdoSubsidyRate asr = null;
            if(CodesTables.CBRTYPE_PRE.equals(mostRecentSpclNdsDeterm.getCdBasicRateType())){
              Date endDateAdoRate = adoSubsidyRateDAO.findAdoptionSubsidyRateEndDate();
              asr = adoSubsidyRateDAO.findPreAdoptionSubsidyRateByAge(age, endDateAdoRate);
              if (asr != null) {
                //STGAP00014680: Calculation redone
                amtMonthlyAsst = asr.getAmtAdptSub() 
                      + Round(((mostRecentSpclNdsDeterm.getNbrCountyAddonAmt()* DAYS_IN_YEAR) / MONTHS) ,2 );
              }
            }else if(CodesTables.CBRTYPE_POS.equals(mostRecentSpclNdsDeterm.getCdBasicRateType())){
              Date startDate = adoSubsidyRateDAO.findAdoptionSubsidyRateStartDate();
              asr = adoSubsidyRateDAO.findPostAdoptionSubsidyRateByAge(age, startDate);
              if (asr != null) {
                amtMonthlyAsst = asr.getAmtAdptSub();
              }
            }else if(CodesTables.CBRTYPE_CUS.equals(mostRecentSpclNdsDeterm.getCdBasicRateType())){        
              amtMonthlyAsst = mostRecentSpclNdsDeterm.getNbrBasicRateAmt();
            }
          }
        } else if (ArchitectureConstants.Y.equals(mostRecentSpclNdsDeterm.getIndSpclRateAdoAppr())) {
          amtMonthlyAsst = mostRecentSpclNdsDeterm.getNbrTotalIveIvbAmt();
        }
      }
    }
    String cdStagePersRelInt = CodesTables.CROLES_PC;
    StagePersonLink stagePersonLink = stagePersonLinkDAO
                                                        .findStagePersonLinkByIdStageByCdStagePersRole(idStage,
                                                                                                       cdStagePersRelInt);
    if (stagePersonLink != null) {
      Person childPrimary = stagePersonLink.getPerson();
      if (childPrimary != null) {
        nmChildPrimary = getFullName(childPrimary);
      }
    }
    preFillData.addBookmark(createBookmark(ADO_ASST_NM_CHILD, FormattingHelper.formatString(nmChildPrimary)));
    preFillData.addBookmark(createBookmark(ADO_ASST_SVC_TYPE, FormattingHelper.formatString(svcType)));
    preFillData.addBookmark(createBookmark(ADO_ASST_AMT_REQUESTED, FormattingHelper.formatMoney(amtReq)));
    preFillData.addBookmark(createBookmark(ADO_ASST_AMT_MONTHLY, FormattingHelper.formatMoney(amtMonthlyAsst)));

  }

  private void formatAddress(String stLn1, String stLn2, String city, String state, String zip, StringBuffer addr) {
    if (stLn1 != null) {
      addr = addr.append(stLn1);
    }
    if (stLn2 != null) {
      addr = addr.append(", " + stLn2);
    }
    if (city != null) {
      addr = addr.append(", " + city);
    }
    if (state != null) {
      addr = addr.append(", " + state);
    }
    if (zip != null) {
      addr = addr.append(" " + zip);
    }
  }

  public AdoSubsidyRateDAO getAdoSubsidyRateDAO() {
    return adoSubsidyRateDAO;
  }

  public void setAdoSubsidyRateDAO(AdoSubsidyRateDAO adoSubsidyRateDAO) {
    this.adoSubsidyRateDAO = adoSubsidyRateDAO;
  }
  
  private static double Round(double Rval, int Rpl) {
    double p = (double)Math.pow(10,Rpl);
    Rval = Rval * p;
    double tmp = Math.round(Rval);
    return (double)tmp/p;
  }

}
