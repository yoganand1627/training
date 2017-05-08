package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaretakerDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.MailCodeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.document.NonRecurOnlyAAAgreement;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NONRECURONLYAAAGRMNTSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NONRECURONLYAAAGRMNTSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  06/06/2011  schoi     SMS #109403: MR-082 Initial Creation
 *  06/09/2011  schoi     SMS #109403: MR-082 Updated code to retrieve Stage County not Case County   
 *  07/07/2011  htvo      SMS##113743: retrieve office address and phone based on stage county    
 */

public class NonRecurOnlyAAAgreementImpl extends BaseDocumentServiceImpl implements NonRecurOnlyAAAgreement {

  private static final String ADOPTIVE_FOSTER_PARENT = CodesTables.CRELVICT_AF;

  private static final String ADOPTIVE_PARENT = CodesTables.CRELVICT_PT;

  private static final String FOSTER_PARENT = CodesTables.CRELVICT_FP;

  private static final String FOSTER_PARENT_CPA_CCI = CodesTables.CRELVICT_FA;

  private CapsResourceDAO capsResourceDAO;
  
  private MailCodeDAO mailCodeDAO;
  
  private StageDAO stageDAO;

  private EmployeeDAO employeeDAO;

  private PlacementDAO placementDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private CapsCaretakerDAO capsCaretakerDAO = null;

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public MailCodeDAO getMailCodeDAO() {
    return mailCodeDAO;
  }

  public void setMailCodeDAO(MailCodeDAO mailCodeDAO) {
    this.mailCodeDAO = mailCodeDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setCapsCaretakerDAO(CapsCaretakerDAO capsCaretakerDAO) {
    this.capsCaretakerDAO = capsCaretakerDAO;
  }
  
  private static final List<String> NON_GA_COUNTY_LIST = new ArrayList<String>(Arrays.asList(CodesTables.CCOUNT_999,CodesTables.CCOUNT_XXX));
  
  public NONRECURONLYAAAGRMNTSO retrieveNonRecurOnlyAAAgreement(NONRECURONLYAAAGRMNTSI nonRecurOnlyAAAgrmntSI) {
    NONRECURONLYAAAGRMNTSO nonRecurOnlyAAAgrmntSO = new NONRECURONLYAAAGRMNTSO();

    int idStage = nonRecurOnlyAAAgrmntSI.getUlIdStage();
    int idChildPrimary = nonRecurOnlyAAAgrmntSI.getUlIdPerson();
    int idEvent = nonRecurOnlyAAAgrmntSI.getUlIdEvent();
    int idCase = nonRecurOnlyAAAgrmntSI.getUlIdCase();
    PreFillData preFillData = new PreFillData();
    Stage stage = null;
    String cdStage = null;

    stage = stageDAO.findStageByIdStage(idStage);
    if (stage != null) {
      cdStage = stage.getCdStage();
    }
    
    // Non-Recurring Only Adoption Assistance Agreement form is displayed for PAD stage only
    // Return blank SO object if the stage is non-PAD
    if ((cdStage != null) && (!"PAD".equals(cdStage))) {
      return nonRecurOnlyAAAgrmntSO;
    } else {
      retrieveAgencyInfo(preFillData, idCase, idStage, stage); // Get agency info
      retrieveResourceInfo(preFillData, idChildPrimary); // Get adoptive parents info
      retrieveChildInfo(preFillData, idStage); // Get child info
      nonRecurOnlyAAAgrmntSO.setPreFillData(preFillData);

      return nonRecurOnlyAAAgrmntSO;
    }
  }

  @SuppressWarnings( { "unchecked" })
  private void retrieveAgencyInfo(PreFillData preFillData, int idCase, int idStage, Stage stage) {
    String agencyAddress = "";
    String agencyPhoneNumber = "";
    String countyName = "";
    
    if (stage != null) {
      countyName = stage.getCdStageCnty();
      // SMS##113743: retrieve office address and phone based on stage county and through a filter list of offices that handle
      // adoption forms, identified by the SSAU
      Object[] mailCode = mailCodeDAO.findMailCodeByCdCountyForSSAU(countyName);
      if (NON_GA_COUNTY_LIST.contains(countyName)) {
        // do nothing; if for some reason the county is out-of-state or -none- do not retrieve address and phone.
      } else {
        if (mailCode != null) {
          StringBuffer addr = new StringBuffer();
          // Concatenate address line 1, line 2, city, and zip
          formatAddress((String)mailCode[1], (String)mailCode[2],
                        (String)mailCode[3], "GA", (String)mailCode[4], addr);
          agencyAddress = addr.toString();
          agencyPhoneNumber = (String)mailCode[5];
        }
      }
    }

    preFillData.addBookmark(createBookmark(RELEVANT_AGENCY, Lookup.simpleDecodeSafe(CodesTables.CCOUNT, countyName)));
    preFillData.addBookmark(createBookmark(AGENCY_ADDRESS, agencyAddress));
    preFillData.addBookmark(createBookmark(AGENCY_PHONE, FormattingHelper.formatPhone(agencyPhoneNumber)));
  }

  @SuppressWarnings( { "unchecked" } )
  private void retrieveResourceInfo(PreFillData preFillData, int idChildPrimary) {
    Placement adoPlacement = null;
    String nmAdoptiveParents = "";
    String phoneNumber = "";
    String address = "";
    int idFadStage = 0;

    /*
     * Use the current placement to get the adoptive parent's names, address, and phone number
     */
    adoPlacement = getCurrentPlacement(idChildPrimary);
    if (adoPlacement != null) {

      int idResource = adoPlacement.getCapsResourceByIdRsrcFacil() == null ? 0
                                                                          : adoPlacement.getCapsResourceByIdRsrcFacil()
                                                                                        .getIdResource();

      if (idResource > 0) {

        CapsResource resource = capsResourceDAO.findCapsResourceByIdResc(idResource);

        if (resource != null) {
          StringBuffer addr = new StringBuffer();
          formatAddress(resource.getAddrRsrcStLn1(), resource.getAddrRsrcStLn2(), resource.getAddrRsrcCity(),
                        resource.getCdRsrcState(), resource.getAddrRsrcZip(), addr);
          if (addr != null) {
            address = addr.toString();
          }

          String phoneNbr = FormattingHelper.formatPhone(resource.getNbrRsrcPhn());
          String phoneExt = resource.getNbrRsrcPhoneExt();
          if (phoneNbr != null) {
            phoneNumber = phoneNbr;
            if (phoneExt != null) {
              phoneNumber = phoneNumber + "   Ext " + phoneExt;
            }
          }

          idFadStage = resource.getStage() == null ? 0 : resource.getStage().getIdStage();
          if (idFadStage > 0) {
            Collection cdStagePersTypes = new ArrayList<String>();
            cdStagePersTypes.add(ADOPTIVE_PARENT);
            cdStagePersTypes.add(FOSTER_PARENT);
            cdStagePersTypes.add(ADOPTIVE_FOSTER_PARENT);
            cdStagePersTypes.add(FOSTER_PARENT_CPA_CCI);
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
                  String personName = person.getNmPersonFirst() + " " + person.getNmPersonLast();
                  if (fullName.length() > 0) {
                    fullName.append(", " + personName);
                  } else {
                    fullName.append(personName);
                  }
                }
              }
              nmAdoptiveParents = fullName.toString();
            }
          } else { // When the adoptive parents are entered as a Resource-Non DFCS Private adoption.
            // Their caretaker information will be entered in the resource CareTaker Information.
            List<Map> capsCaretakerList = capsCaretakerDAO.findCapsCaretakerByIdResource(idResource);
            if (capsCaretakerList != null) {
              StringBuffer fullName = new StringBuffer();
              for (Iterator<Map> it = capsCaretakerList.iterator(); it.hasNext();) {
                Map capsCaretakerMap = it.next();
                String personName = (String) capsCaretakerMap.get("nmCaretkrFname") + " "
                                    + capsCaretakerMap.get("nmCaretkrLname");
                if (fullName.length() > 0) {
                  fullName.append(", " + personName);
                } else {
                  fullName.append(personName);
                }
              }
              nmAdoptiveParents = fullName.toString();
            }
          }
        }
      }
    }
    preFillData.addBookmark(createBookmark(ADO_PARENTS_FULL_NAMES, nmAdoptiveParents));
    preFillData.addBookmark(createBookmark(ADO_ADDRESS, address));
    preFillData.addBookmark(createBookmark(ADO_PHONE_NUMBER, phoneNumber));
  }

  @SuppressWarnings( { "unchecked" })
  private void retrieveChildInfo(PreFillData preFillData, int idStage) {
    String childName = "";
    Date childBirthDt = null;

    /*
     * Retrieve the stage/person link and retrieve the primary child from this link
     */
    String cdStagePersRelInt = CodesTables.CROLES_PC;
    StagePersonLink stagePersonLink = stagePersonLinkDAO
                                                        .findStagePersonLinkByIdStageByCdStagePersRole(idStage,
                                                                                                       cdStagePersRelInt);
    if (stagePersonLink != null) {
      Person childPrimary = stagePersonLink.getPerson();
      if (childPrimary != null) {
        // Displaying child's full first and last name
        childName = getFullName(childPrimary);
        childBirthDt = childPrimary.getDtPersonBirth();
      }
    }
    preFillData.addBookmark(createBookmark(CHILD_NAME, childName));
    preFillData.addBookmark(createBookmark(CHILD_DATE_OF_BIRTH, FormattingHelper.formatDate(childBirthDt)));
  }

  // Get the Current Placement
  private Placement getCurrentPlacement(int idChildPrimary) {
    return placementDAO.findLatestApprovedPlacementByIdPersonOrderByDtPlcmtStart(idChildPrimary, DateHelper.MAX_JAVA_DATE);
  }

  /**
   * Private Method used to display full names
   */
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

  private Person getCaseManager(int idStage) {
    // Checking for current case manager as well as historical case manager
    StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdStageCdStagePersRoleAll(idStage);
    Person caseMngr = stagePersonLink.getPerson();
    return caseMngr;
  }

  /**
   * Using the StringBuffer that is passed in, this method adds all the address information as a comma-delimited string.
   * 
   * @param strLn1
   * @param strLn2
   * @param city
   * @param state
   * @param zip
   * @param address
   */
  private void formatAddress(String strLn1, String strLn2, String city, String state, String zip, StringBuffer address) {
    if (strLn1 != null) {
      address = address.append(strLn1);
    }
    if (strLn2 != null) {
      address = address.append(", " + strLn2);
    }
    if (city != null) {
      address = address.append(", " + city);
    }
    if (state != null) {
      address = address.append(", " + state);
    }
    if (zip != null) {
      address = address.append(" " + zip);
    }
  }
}
