package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   11/10/2010  schoi             SMS #81140: MR-074 Added two new fields on the Person Characteristics page                                    
 *   10/20/2011  hnguyen           STGAP00017267: MR-092 Updated pre-population for Was Previously Adoption based
 *                                 on ADO leading up to current PAD for child not previously history of adoption.                                     
 *   11/03/2011  hnguyen           STGAP00017399: MR-092 Updated pre-population for previous adoption to first look
 *                                 at current stage, if PAD1 then look back at associated ADO1 to get old child id and
 *                                 then using old child id find a PAD2 prior to ADO1 and all previous adopt info will 
 *                                 be retrieved from ADO2 prior to that PAD2, if found then child is previously adopted.
 *                                 If current stage not PAD, then just look back to see if current child has a PAD stage
 *                                 with an associated ADO then child is previously and placement information to pre-populate
 *                                 based on that ADO placement.                                     
 *   11/16/2011  hnguyen           STGAP00017653: MR-092 Update previously adopted pre-population.
 *
 **/

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CharacteristicsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecialNeedsDeterminationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Characteristics;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.SpecialNeedsDetermination;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrievePerson;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV24SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG_ARRAY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RetrievePersonImpl extends BaseServiceImpl implements RetrievePerson {

  private CharacteristicsDAO characteristicsDAO = null;

  private LegalStatusDAO legalStatusDAO = null;

  private PersonDAO personDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private PlacementDAO placementDAO = null;

  private CapsResourceDAO capsResourceDAO = null;

  private SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO = null;

  public void setCharacteristicsDAO(CharacteristicsDAO characteristicsDAO) {
    this.characteristicsDAO = characteristicsDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setSpecialNeedsDeterminationDAO(SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO) {
    this.specialNeedsDeterminationDAO = specialNeedsDeterminationDAO;
  }

  private static final Set<String> ADOPTIVE_PARENT_RELATIONSHIPS = new HashSet<String>(
                  Arrays.asList(new String[]{CodesTables.CRELVICT_PT, // Adoptive Parent
                                             CodesTables.CRELVICT_FP, // Foster Parent (DFCS)
                                             CodesTables.CRELVICT_AF, // Foster/Adoptive Parent (Legal Risk)
                                             CodesTables.CRELVICT_FA})); // Foster Parent (CPA/CCI)
  
  public CINV24SO retrievePerson(CINV24SI cinv24si) throws ServiceException {
    CINV24SO cinv24so = new CINV24SO();
    ROWCINV24SOG_ARRAY rowcinv24sog_array = new ROWCINV24SOG_ARRAY();
    if (DateHelper.isNull(cinv24si.getDtScrDtCharEffDate())) {
      // ccmn44d
      Person person = personDAO.findPersonByIdPerson(cinv24si.getUlIdPerson());
      if (person == null) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }

      cinv24so.setBIndPersonDobApprox(person.getIndPersonDobApprox());
      cinv24so.setSzCdPersonLivArr(person.getCdPersonLivArr());
      cinv24so.setSzCdPersonDeath(person.getCdPersonDeath());
      cinv24so.setSzCdPersonEthnicGroup(person.getCdPersonEthnicGroup());
      cinv24so.setSzCdPersonLanguage(person.getCdPersonLanguage());
      cinv24so.setSzCdPersonMaritalStatus(person.getCdPersonMaritalStatus());

      // Risk Assessment Enhancement: Added the following to
      // the Retrieve Service to obtain a count of any AP's that
      // are Active PRS Foster/Adoptive Parents for the stage.
      cinv24so.setSzCdPersonReligion(person.getCdPersonReligion());
      cinv24so.setCCdPersonSex(person.getCdPersonSex());
      cinv24so.setCdPersonStatus(person.getCdPersonStatus());
      cinv24so.setDtDtPersonBirth(DateHelper.toCastorDate(person.getDtPersonBirth()));
      cinv24so.setDtDtPersonDeath(DateHelper.toCastorDate(person.getDtPersonDeath()));
      cinv24so.setSzNmPersonFull(person.getNmPersonFull());
      cinv24so.setSzTxtOccupation(person.getTxtPersonOccupation());
      cinv24so.setTsLastUpdate(person.getDtLastUpdate());
      cinv24so.setBCdPersonChar(person.getCdPersonChar());
      cinv24so.setBCdPersNotYetDiag(person.getCdPersNotYetDiag());
      cinv24so.setSzTxtCharCmnts(person.getTxtCharCmnts());
      cinv24so.setIndAdoptnDislutn(person.getIndAdoptDisluton());
      cinv24so.setIndIntlAdoptn(person.getIndIntrntl());
      cinv24so.setIndPrevAdopt(person.getIndPrevAdopted());
      cinv24so.setTxtPrevAdopt(DateHelper.toCastorDate(person.getDtPrevAdoption()));

      // MR-074
      cinv24so.setIndSingleParAdpt(person.getIndSingleParAdopt());
      cinv24so.setSzCdSngleMomOrFar(person.getCdSingleMotherFather());
      // End of MR-074

      // MR-092 Fostering Connection
      cinv24so.setBIndIVEPriorAdoption(person.getIndIvePriorAdoption());
      String prevAdopted = person.getIndPrevAdopted();
      // If child has a prior adoptive history within the system and no previous data
      // was saved for the adoption section, it will automatically pre-populate
      // with information currently in the system for those who are 18 years old or younger
      Integer age = person.getNbrPersonAge();
      Date birth = person.getDtPersonBirth();
      if (birth != null) {
        age = new Integer(DateHelper.getAge(birth));
      } else {
        age = new Integer(0);
      }
      if (age <= 18) {
        if (!StringHelper.isValid(prevAdopted)) {
          // STGAP00017267 looking for previous adoption finalized ado stage
          int idPersonInAdo = person.getIdPerson();

          // For PAD we will look back twice, any other stage we look back once
          if (CodesTables.CSTAGES_PAD.equals(cinv24si.getSzCdStage())) {
            Map<String, Integer> priorAdoptionInfo = stagePersonLinkDAO.findPriorAdoptionIdPersonIdAdoStage(idPersonInAdo);

            if (priorAdoptionInfo != null) {
              idPersonInAdo = priorAdoptionInfo.get("idPerson");
            } else {
              // reset if no ado history found, a possible non-incident PAD.
              idPersonInAdo = 0;
            }
          }
          long padCount = stagePersonLinkDAO.countStagesByIdPersonAndIdStage(idPersonInAdo, CodesTables.CROLEALL_PC,
                                                                             CodesTables.CSTAGES_PAD);
          if (padCount > 0) {
            // If a previous adoption stage was found, pre-populate the previously adopted question with 'Yes'
            Map<String, Integer> priorAdoptionInfo = stagePersonLinkDAO.findPriorAdoptionIdPersonIdAdoStage(idPersonInAdo);
            if (priorAdoptionInfo != null) {
              int idPersonInPriorAdo = priorAdoptionInfo.get("idPerson");
              int idPriorAdoptionStage = priorAdoptionInfo.get("idStage");
              cinv24so.setIndPrevAdopt(CodesTables.CYESNOUN_Y);

              // find most recent adoption finalized legal status by prior idChild
              LegalStatus legalStatusNAF = legalStatusDAO.findMostRecentLegalStatusbyIdPersonAndLegalStatStatus(idPersonInPriorAdo,
                                                                                                                CodesTables.CLEGSTAT_NAF);
              cinv24so.setTxtPrevAdopt(DateHelper.toCastorDate(legalStatusNAF != null ? legalStatusNAF.getDtLegalStatStatusDt()
                                                                                     : null));

              Placement priorAdoPlacement = placementDAO.findLastPlcmtByIdPersonByIdStage(idPersonInPriorAdo,
                                                                                          idPriorAdoptionStage);
              if (priorAdoPlacement != null) {
                int idAdoPlacementResource = priorAdoPlacement.getCapsResourceByIdRsrcFacil().getIdResource();
                CapsResource adoPlacementResource = capsResourceDAO.findCapsResourceByIdResc(idAdoPlacementResource);
                if (adoPlacementResource != null) {
                  Stage fadStage = adoPlacementResource.getStage();
                  // If The Resource is a Home, get the resource household members to determine
                  // if it's a single parent adoption home and the gender of the single parent.
                  // If the placement resource is not a home and may be a relative placement in which case
                  // the system doesn't have the list of principals living in the home.
                  if (fadStage != null) {
                    List<Person> rsrcAdoptiveParentList = new ArrayList<Person>();
                    int numOfAdoptiveParents = 0;
                    List<StagePersonLink> principalList = stagePersonLinkDAO.findAllPrincipalsLinkedToStage(fadStage.getIdStage(),
                                                                                                            CodesTables.CPRSNTYP_PRN);
                    if (principalList != null && !principalList.isEmpty()) {
                      Iterator<StagePersonLink> it = principalList.iterator();

                      while (it.hasNext()) {
                        StagePersonLink relatedPrsn = it.next();
                        // If the resource principal has any of the Adoptive parent relationships
                        if (ADOPTIVE_PARENT_RELATIONSHIPS.contains(relatedPrsn.getCdStagePersRelInt())) {
                          rsrcAdoptiveParentList.add(relatedPrsn.getPerson());
                          numOfAdoptiveParents++;
                        }
                      } // ends while
                    } // ends principalList
                    // If there is only one adoptive parent in the home, indicate a single parent adoption
                    if (numOfAdoptiveParents == 1) {
                      cinv24so.setIndSingleParAdpt(CodesTables.CYESNOUN_Y);
                      Person p = rsrcAdoptiveParentList.get(0);
                      // Indicate whether the single adoptive parent is a mother or father
                      String cdGender = p.getCdPersonSex();
                      if (CodesTables.CSEX_F.equals(cdGender)) {
                        cinv24so.setSzCdSngleMomOrFar(CodesTables.CSPATYPE_SM);
                      } else if (CodesTables.CSEX_M.equals(cdGender)) {
                        cinv24so.setSzCdSngleMomOrFar(CodesTables.CSPATYPE_SF);
                      }
                    } else {
                      cinv24so.setIndSingleParAdpt(CodesTables.CYESNOUN_N);
                    }
                  }

                  // Determine if the child was eligible for Title IV-E in the prior adoption by getting the
                  // Special Needs application and look at the eligibility determination
                  Stage priorAdoStage = stageDAO.findStageByIdStage(idPriorAdoptionStage);
                  SpecialNeedsDetermination snd = specialNeedsDeterminationDAO.findSpclDeterminationByIdStageByIdPerson(idPriorAdoptionStage,
                                                                                                                        idPersonInPriorAdo,
                                                                                                                        priorAdoStage.getCapsCase()
                                                                                                                                     .getIdCase());
                  // Check the funding type and pre-populate the IV-E in Prior Adoption question
                  if (snd != null) {
                    String cdFundingType = snd.getCdFundingType();
                    if (CodesTables.CAAFDTYP_IVE.equals(cdFundingType)) {
                      cinv24so.setBIndIVEPriorAdoption(CodesTables.CYESNOUN_Y);
                    } else if (CodesTables.CAAFDTYP_PST.equals(cdFundingType)) {
                      cinv24so.setBIndIVEPriorAdoption(CodesTables.CYESNOUN_N);
                    } else {
                      cinv24so.setBIndIVEPriorAdoption(CodesTables.CYESNOUN_U);
                    }
                  }
                }
              }
              cinv24so.setIndPrivateAdoptn(person.getIndPrivate());
              cinv24so.setIndPublicAdoptn(person.getIndPublic());
              cinv24so.setSzAgency(person.getTxtNameOfAdoAgency());
              cinv24so.setTxtDissolutionDate(DateHelper.toCastorDate(person.getDtDissolution()));
              cinv24so.setSzCdCntry(person.getCdAdoptCntry());
              cinv24so.setSzCdCounty(person.getCdAdoptCounty());
              cinv24so.setSzCdState(person.getCdAdoptState());
            }
          }
        }
      }

      if (CHAR_CHECKED.equals(person.getCdPersonChar()) || CHAR_CHECKED.equals(person.getCdPersNotYetDiag())) {
        // Predisplay Query -- Grab the latest info
        // cinv27d
        List<Characteristics> characteristicsInfo = characteristicsDAO.findCharacteristicsByIdPersonAndDtCharEnd(cinv24si.getUlIdPerson(),
                                                                                                                 DateHelper.MAX_JAVA_DATE);

        if (characteristicsInfo != null && !characteristicsInfo.isEmpty()) {
          rowcinv24sog_array = getROWCINV24SOG_ARRAY(characteristicsInfo);
        }
      }
    } else {
      // Effective Date Query -- Grab info by effective date
      // cinv28d
      Date dtCharEffDate = DateHelper.toJavaDate(cinv24si.getDtScrDtCharEffDate());
      List<Characteristics> characteristicsInfo = characteristicsDAO.findCharacteristicsByIdPersonAndEffectiveDate(cinv24si.getUlIdPerson(),
                                                                                                                   dtCharEffDate);
      if (characteristicsInfo == null || characteristicsInfo.isEmpty()) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }
      rowcinv24sog_array = getROWCINV24SOG_ARRAY(characteristicsInfo);
    }
    cinv24so.setROWCINV24SOG_ARRAY(rowcinv24sog_array);

    return cinv24so;
  }

  private ROWCINV24SOG_ARRAY getROWCINV24SOG_ARRAY(List<Characteristics> characteristicsInfo) {
    ROWCINV24SOG_ARRAY rowcinv24sog_array = new ROWCINV24SOG_ARRAY();
    for (Iterator<Characteristics> it = characteristicsInfo.iterator(); it.hasNext();) {
      Characteristics characteristics = it.next();
      ROWCINV24SOG rowcinv24sog = new ROWCINV24SOG();
      rowcinv24sog.setUlIdCharacteristics(characteristics.getIdCharacteristics() != null ? characteristics.getIdCharacteristics()
                                                                                        : 0);
      rowcinv24sog.setSzCdCharCategory(characteristics.getCdCharCategory());
      rowcinv24sog.setCdCharacteristic(characteristics.getCdCharacteristic());
      rowcinv24sog.setDtDtCharStart(DateHelper.toCastorDate(characteristics.getDtCharStart()));
      rowcinv24sog.setDtDtCharEnd(DateHelper.toCastorDate(characteristics.getDtCharEnd()));
      rowcinv24sog.setTsLastUpdate(characteristics.getDtLastUpdate());
      rowcinv24sog_array.addROWCINV24SOG(rowcinv24sog);
    }
    return rowcinv24sog_array;
  }
}