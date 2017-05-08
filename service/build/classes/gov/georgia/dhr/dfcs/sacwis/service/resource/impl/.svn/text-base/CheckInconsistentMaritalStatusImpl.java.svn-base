package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.CheckInconsistentMaritalStatus;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG04;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG06;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD08SO;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 *                                 
 *   11/19/2010  schoi             Initial Creation
 *                                 SMS #81140: MR-074 Added code to validate Marital Status, 
 *                                 Relationship and Gender in the Person Detail information 
 *                                 with the F/A Home’s Marital Status on submission for approval                                                                                                                                    
 **/

public class CheckInconsistentMaritalStatusImpl extends BaseServiceImpl implements CheckInconsistentMaritalStatus {

  private static final String PERSON_GENDER_FEMALE = "F";
  
  private static final String PERSON_GENDER_MALE = "M";
    
  private static final Integer PERSON_COUNT = 1; 
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public boolean checkInconsistentMaritalStatus(CFAD08SI cfad08si) throws ServiceException {

    boolean maritalStatusMismatch = false;

    ROWCFAD08SIG06 rowcfad08sig06 = cfad08si.getROWCFAD08SIG06();
    int idStage = 0;
    if (rowcfad08sig06 != null) {
      idStage = rowcfad08sig06.getUlIdStage();
    }

    ROWCFAD08SIG04 rowcfad08sig04 = cfad08si.getROWCFAD08SIG04();
    String cdRsrcMaritalStatus = "";
    if (rowcfad08sig04 != null) {
      cdRsrcMaritalStatus = rowcfad08sig04.getSzCdRshsMaritalStatus();
    }

    // Check Marital Status, Relationship and Gender on the Person Detail information 
    // to match with the F/A Home’s Marital Status on submission for approval
    // Get the Person records with the stage relationship of "Foster/Adoptive Parent (Legal Risk)", 
    // "Foster Parent (CPA/CCI)", "Foster Parent (DFCS)" or "Adoptive Parent"
    List<String> parentTypesAFCARS = new ArrayList<String>();
    parentTypesAFCARS.add(CodesTables.CRELVICT_AF);
    parentTypesAFCARS.add(CodesTables.CRELVICT_FA);
    parentTypesAFCARS.add(CodesTables.CRELVICT_FP);
    parentTypesAFCARS.add(CodesTables.CRELVICT_PT);
    
    List<String> faHomeMaritalStatusTypes = new ArrayList<String>();
    faHomeMaritalStatusTypes.add(CodesTables.CFAMSTRC_01);
    faHomeMaritalStatusTypes.add(CodesTables.CFAMSTRC_03);
    faHomeMaritalStatusTypes.add(CodesTables.CFAMSTRC_05);
    faHomeMaritalStatusTypes.add(CodesTables.CFAMSTRC_07);
    faHomeMaritalStatusTypes.add(CodesTables.CFAMSTRC_09);
    faHomeMaritalStatusTypes.add(CodesTables.CFAMSTRC_11);
    faHomeMaritalStatusTypes.add(CodesTables.CFAMSTRC_13);
    faHomeMaritalStatusTypes.add(CodesTables.CFAMSTRC_15);
    faHomeMaritalStatusTypes.add(CodesTables.CFAMSTRC_17);
    
    if (cdRsrcMaritalStatus != null) {
      if (faHomeMaritalStatusTypes.contains(cdRsrcMaritalStatus)) {
        // Find the Person records under the stage relationship stated above
        List<StagePersonLink> fosterAdptParents = stagePersonLinkDAO
                                                                    .findStagePersonLinkByIdStageAndCdStagePersRelInt(idStage,
                                                                                                               parentTypesAFCARS);
        
        // Count for each Marital Status by Gender
        Integer countMarriedFemale = 0;
        Integer countMarriedMale = 0;
        Integer countDivorcedFemale = 0;
        Integer countDivorcedMale = 0;
        Integer countSeparatedFemale = 0;
        Integer countSeparatedMale = 0;
        Integer countSingleFemale = 0;
        Integer countSingleMale = 0;
        Integer countWidowedFemale = 0;
        Integer countWidowedMale = 0;
        
        if (fosterAdptParents != null) {
          for (Iterator<StagePersonLink> it = fosterAdptParents.iterator(); it.hasNext();) {
            Boolean isPersonFemale = false;
            Boolean isPersonMale = false;
            StagePersonLink checkFosterAdptParent = it.next();
            String personMarStatus = checkFosterAdptParent.getPerson().getCdPersonMaritalStatus();
            String personGender = checkFosterAdptParent.getPerson().getCdPersonSex();
            // Check person gender
            if (personGender != null) {
              if (PERSON_GENDER_FEMALE.equals(personGender)) {
                isPersonFemale = true;
              } else if (PERSON_GENDER_MALE.equals(personGender)) {
                isPersonMale = true;
              } else {
                isPersonFemale = false;
                isPersonMale = false;
              }
            }
            // Compare F/A Home's Marital Status with Marital of the person record
            if (personMarStatus != null) {
              // Check for Married Couple (CFAMSTRC_01)
              if ((CodesTables.CFAMSTRC_01.equals(cdRsrcMaritalStatus))
                  && (CodesTables.CMARSTAT_MA.equals(personMarStatus))) {
                if (isPersonFemale) {
                  countMarriedFemale++;
                } else if (isPersonMale) {
                  countMarriedMale++;
                }
              }
              // Check for Divorced Female (CFAMSTRC_03)
              else if ((CodesTables.CFAMSTRC_03.equals(cdRsrcMaritalStatus))
                  && (CodesTables.CMARSTAT_DI.equals(personMarStatus)) && (isPersonFemale)) {
                countDivorcedFemale++;
              }
              // Check for Divorced Male (CFAMSTRC_05)
              else if ((CodesTables.CFAMSTRC_05.equals(cdRsrcMaritalStatus))
                  && (CodesTables.CMARSTAT_DI.equals(personMarStatus)) && (isPersonMale)) {
                countDivorcedMale++;
              }
              // Check for Separated Female (CFAMSTRC_07)
              else if ((CodesTables.CFAMSTRC_07.equals(cdRsrcMaritalStatus))
                  && (CodesTables.CMARSTAT_SE.equals(personMarStatus)) && (isPersonFemale)) {
                countSeparatedFemale++;
              }
              // Check for Separated Male (CFAMSTRC_09)
              else if ((CodesTables.CFAMSTRC_09.equals(cdRsrcMaritalStatus))
                  && (CodesTables.CMARSTAT_SE.equals(personMarStatus)) && (isPersonMale)) {
                countSeparatedMale++;
              }
              // Check for Single Fmle Never MA (CFAMSTRC_11)
              else if ((CodesTables.CFAMSTRC_11.equals(cdRsrcMaritalStatus))
                  && (CodesTables.CMARSTAT_SI.equals(personMarStatus)) && (isPersonFemale)) {
                countSingleFemale++;
              }
              // Check for Single Male Never MA (CFAMSTRC_13)
              else if ((CodesTables.CFAMSTRC_13.equals(cdRsrcMaritalStatus))
                  && (CodesTables.CMARSTAT_SI.equals(personMarStatus)) && (isPersonMale)) {
                countSingleMale++;
              }
              // Check for Widowed Female (CFAMSTRC_15)
              else if ((CodesTables.CFAMSTRC_15.equals(cdRsrcMaritalStatus))
                  && (CodesTables.CMARSTAT_WI.equals(personMarStatus)) && (isPersonFemale)) {
                countWidowedFemale++;
              }
              // Check for Widowed Male (CFAMSTRC_17)
              else if ((CodesTables.CFAMSTRC_17.equals(cdRsrcMaritalStatus))
                  && (CodesTables.CMARSTAT_WI.equals(personMarStatus)) && (isPersonMale)) {
                countWidowedMale++;
              }              
            }
          }
        } else {
          // throw error message
          maritalStatusMismatch = true;
        }
        
        // After the loop, check for the Gender and Marital match; 
        // otherwise, set the flag to true to throw the error message
        // Married Couple (CFAMSTRC_01)
        if (CodesTables.CFAMSTRC_01.equals(cdRsrcMaritalStatus)) {
          if (!(PERSON_COUNT.equals(countMarriedFemale) && PERSON_COUNT.equals(countMarriedMale) && fosterAdptParents
                                                                                                                     .size() == 2)) {
            maritalStatusMismatch = true;
          }
        }
        // Divorced Female (CFAMSTRC_03)
        else if (CodesTables.CFAMSTRC_03.equals(cdRsrcMaritalStatus)) {
          if (!(PERSON_COUNT.equals(countDivorcedFemale) && fosterAdptParents.size() == 1)) {
            maritalStatusMismatch = true;
          }
        }
        // Divorced Male (CFAMSTRC_05)
        else if (CodesTables.CFAMSTRC_05.equals(cdRsrcMaritalStatus)) {
          if (!(PERSON_COUNT.equals(countDivorcedMale) && fosterAdptParents.size() == 1)) {
            maritalStatusMismatch = true;
          }
        }
        // Separated Female (CFAMSTRC_07)
        else if (CodesTables.CFAMSTRC_07.equals(cdRsrcMaritalStatus)) {
          if (!(PERSON_COUNT.equals(countSeparatedFemale) && fosterAdptParents.size() == 1)) {
            maritalStatusMismatch = true;
          }
        }
        // Separated Male (CFAMSTRC_09)
        else if (CodesTables.CFAMSTRC_09.equals(cdRsrcMaritalStatus)) {
          if (!(PERSON_COUNT.equals(countSeparatedMale) && fosterAdptParents.size() == 1)) {
            maritalStatusMismatch = true;
          }
        }
        // Single Fmle Never MA (CFAMSTRC_11)
        else if (CodesTables.CFAMSTRC_11.equals(cdRsrcMaritalStatus)) {
          if (!(PERSON_COUNT.equals(countSingleFemale) && fosterAdptParents.size() == 1)) {
            maritalStatusMismatch = true;
          }
        }
        // Single Male Never MA (CFAMSTRC_13)
        else if (CodesTables.CFAMSTRC_13.equals(cdRsrcMaritalStatus)) {
          if (!(PERSON_COUNT.equals(countSingleMale) && fosterAdptParents.size() == 1)) {
            maritalStatusMismatch = true;
          }
        }
        // Widowed Female (CFAMSTRC_15)
        else if (CodesTables.CFAMSTRC_15.equals(cdRsrcMaritalStatus)) {
          if (!(PERSON_COUNT.equals(countWidowedFemale) && fosterAdptParents.size() == 1)) {
            maritalStatusMismatch = true;
          }
        }
        // Widowed Male (CFAMSTRC_17)
        else if (CodesTables.CFAMSTRC_17.equals(cdRsrcMaritalStatus)) {
          if (!(PERSON_COUNT.equals(countWidowedMale) && fosterAdptParents.size() == 1)) {
            maritalStatusMismatch = true;
          }
        }
      }
    }

    return maritalStatusMismatch;
  }

}
