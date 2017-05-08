package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ComplexStagePersonLinkDAO {
  static final String MORE = "More";

  /**
   * Based on the ReqFuncCode passed in either OPEN or CLOSE count the number of stages (open or closed) for the
   * id_person with a specified role for a specified cd_stage. (ex. check if the id_person with a cd_stage_pers_role =
   * PC for cd_stage 'PAL' exists in any other PAL stage or any other OPEN PAL stage.)
   *
   * @param openFlag
   * @param idPerson
   * @param cdStagePersRole
   * @param cdStage
   * @return
   */
  long countOpenStagesForIdPerson(String openFlag, int idPerson, String cdStagePersRole, String cdStage);

  /**
   * Returns a list of complex results for the Call Person List window
   *
   * @param idStage
   * @param dtSysTsQuery
   * @return
   */
  List<Map> findCallPersonList(String cdIncmgStatus, int idStage, Date dtSysTsQuery);

  /**
   * This DAM performs the retrieval necessary to populate one row on the Call Person List window.  As a result, it
   * performs 7 different SELECTs from various tables.</p>
   *
   * @param idPerson
   * @param idStage
   * @return Map
   */
  @SuppressWarnings({"unchecked"})
  Map findCallPerson(int idStage, int idPerson);

  /**
   * Complex update of StagePersonLink and PersonCategories table during intake process
   *
   * @param idPerson
   * @param idRelatedPerson
   * @param idStage
   * @param cdStagePersSearchInd
   */
  void updateIntakeRelateUnrelate(int idPerson, int idRelatedPerson, int idStage, String cdStagePersSearchInd,
                                  boolean bDeleteUnrelated);

  /**
   * Updates all necessary tables for the intake person detail data for multi-row updates
   *
   * @param indStagePersInLaw
   * @param idPerson
   * @param idStage
   * @param cdPersonEthnicGroup
   * @param indPersCancelHist
   * @param cdPersonLanguage
   * @param cdStagePersRelInt
   * @param cdStagePersRole
   * @param cdStagePersType
   * @param nmNameLast
   * @param idName
   * @param nmPersonFull
   * @param cdPersAddrLinkType
   * @param idAddress
   * @param idAddrPersonLink
   * @param addrPersAddrStLn1
   * @param addrPersAddrStLn2
   * @param addrCity
   * @param addrZip
   * @param cdAddrCounty
   * @param cdAddrState
   * @param cdPhoneType
   * @param nbrPhone
   * @param nbrPhoneExtension
   * @param cdPKHouseholdMember
   * @param idPhone
   */
  //STGAP15485: Added cdPKHouseholdMember
  void updateStagePersonLink(String indStagePersInLaw, int idPerson, int idStage, String cdPersonEthnicGroup,
                             String indPersCancelHist, String cdPersonLanguage, String cdStagePersRelInt,
                             String cdStagePersRole, String cdStagePersType, String nmNameLast, int idName,
                             String nmPersonFull, String cdPersAddrLinkType, int idAddress, int idAddrPersonLink,
                             String addrPersAddrStLn1, String addrPersAddrStLn2, String addrCity, String addrZip,
                             String cdAddrCounty, String cdAddrState, String cdPhoneType, String nbrPhone,
                             String nbrPhoneExtension, int idPhone, String cdPKHouseholdMember);

  /**
   * Performs a full row add in the STAGE_PERSON_LINK table.
   *
   * @param idStage
   * @param idPerson
   * @param cdStagePersRole
   * @param cdStagePersType
   * @param cdStagePersSearchInd
   * @param txtStagePersNotes
   * @param dtStagePersLink
   * @param cdStagePersRelInt
   * @param indStagePersReporter
   * @param indStagePersInLaw
   * @param indStagePersEmpNew
   * @param cdPKHouseholdMember
   * @return Date
   */
  Date addStageToWorker(int idStage, int idPerson, String cdStagePersRole, String cdStagePersType,
                        String cdStagePersSearchInd, String txtStagePersNotes, Date dtStagePersLink,
                        String cdStagePersRelInt, String indStagePersReporter, String indStagePersInLaw,
                        String indStagePersEmpNew, String cdPKHouseholdMember);

  /**
   * Deleted a StagePersonLink object based on idStage and idPerson
   *
   * @param idStage
   * @param idPerson
   */
  void deleteStagePersonLink(int idStage, int idPerson);

  /**
   * Selects a list of idStages from stage person link
   *
   * @param idPersons
   * @param cdStagePersType
   */
  List<Integer> findIdStageByIdPersonStagePersType(Collection<Integer> idPersons, String cdStagePersType);
}