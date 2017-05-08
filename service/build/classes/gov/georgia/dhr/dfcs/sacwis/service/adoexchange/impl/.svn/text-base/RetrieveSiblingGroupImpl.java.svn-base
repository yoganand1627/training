package gov.georgia.dhr.dfcs.sacwis.service.adoexchange.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SiblingDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SiblingGroupDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChild;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.SiblingGroup;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.RetrieveSiblingGroup;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SiblingGroupSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingGroupSO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * The RetrieveSiblingGroupImpl is used to retrieve the overall gender ('M', 'F' or 'B'), races, ethnicities, background factors and
 * max severity of the special needs characteristics of all of the children in a sibling group
 * 
 * 
 * @author 
 * 
 * <PRE>
 * 
 * Date        Updated by      Description
 * ---------   ------------    -------------------------------------
 * 05/15/09    hjbaptiste      STGAP00013455: Determine the races, ethnicities, background factors and max severity of all 
 *                             checked special needs characteristic of all children in the sibling group
 * 06/09/09    mchillman       STGAP00014147: added code to check if exchangeChild is not null
 * </PRE>
 */
public class RetrieveSiblingGroupImpl extends BaseServiceImpl implements RetrieveSiblingGroup {

  SiblingGroupDAO siblingGroupDAO = null;
  SiblingDAO siblingDAO = null;
  ExchangeChildDAO exchangeChildDAO = null;
  PersonRaceDAO personRaceDAO = null;
  PersonEthnicityDAO personEthnicityDAO = null;
  
  PersonDAO personDAO = null;

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setSiblingGroupDAO(SiblingGroupDAO siblingGroupDAO) {
    this.siblingGroupDAO = siblingGroupDAO;
  }

  public void setSiblingDAO(SiblingDAO siblingDAO) {
    this.siblingDAO = siblingDAO;
  }

  public void setExchangeChildDAO(ExchangeChildDAO exchangeChildDAO) {
    this.exchangeChildDAO = exchangeChildDAO;
  }

  public void setPersonRaceDAO(PersonRaceDAO personRaceDAO) {
    this.personRaceDAO = personRaceDAO;
  }

  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
  }

  public SiblingGroupSO retrieveSiblingGroup(SiblingGroupSI siblingGroupSI) {
    int idSiblingGroup = siblingGroupSI.getIdSiblingGroup();
    SiblingGroup siblingGroup = siblingGroupDAO.findSiblingGroupByIdSiblingGroup(idSiblingGroup);
    int idStiblingGroup = siblingGroup.getIdSiblingGroup();
    Map datesMap = personDAO.findMinAgeMaxAgeInSiblingGrpByIdSiblingGrp(idSiblingGroup);
    SiblingGroupSO siblingGroupSO = new SiblingGroupSO();
    if (siblingGroup != null) {
      siblingGroupSO.setDtLastUpdate(siblingGroup.getDtLastUpdate());
      siblingGroupSO.setIdSiblingGroup(idStiblingGroup);
      siblingGroupSO.setNbrAvail(siblingGroup.getNbrAvail());
      siblingGroupSO.setNbrInGroup(siblingGroup.getNbrInGroup());
    }
    if(datesMap!=null){
      siblingGroupSO.setMaxPersonDob((Date) datesMap.get("maxPersonDob"));
      siblingGroupSO.setMinPersonDob((Date) datesMap.get("minPersonDob"));
    }
    // Get the person ids of all of the children in the Sibling Group
    List<Integer> idOfSiblings = new ArrayList<Integer>();
    idOfSiblings = siblingDAO.findSiblingsByIdSiblingGroup(idSiblingGroup);
    String cdOverallGender = null;
    List<String> siblingGroupRaces = new ArrayList<String>();
    List<String> siblingGroupEthnicities = new ArrayList<String>();
    Map<String, String> siblingGroupBackgroundFactors = new HashMap<String, String>();
    Map<String, String> maxSevSpecialNeedsCharacteristics = new HashMap<String, String>();
    // Loop thru all of the children in the sibling group and set distinct races, ethnicities, background factors and 
    // special needs characteristics severity
    if (idOfSiblings != null && idOfSiblings.size() > 0) {
      Iterator idOfSiblings_it = idOfSiblings.iterator();
      while (idOfSiblings_it.hasNext()) {
        int idPerson = (Integer) idOfSiblings_it.next();
        // Get the most recent exchange child record for all of the children in the Sibling Group
        ExchangeChild exchangeChild = exchangeChildDAO.findMostRecentExchangeChildRecordByIdPerson(idPerson);
        if(exchangeChild != null) {
          String cdPersonSex = personDAO.findCdPersonSexByIdPerson(idPerson);
          // Determine if the gender code needs to be set to 'B' for both if the children in the sibling group are of different gender
          cdOverallGender = determineOverallGender(cdOverallGender, cdPersonSex);
          // compile a list of all distinct races for all of the children in the Sibling Group
          List<PersonRace> personraces = personRaceDAO.findPersonRaceByIdPerson(idPerson);
          populateSiblingGroupRaces(siblingGroupRaces, personraces);
          // compile a list of all distinct ethnicities for all of the children in the Sibling Group
          List<PersonEthnicity> personEthnicities = personEthnicityDAO.findPersonEthnicityByIdPerson(idPerson);
          populateSiblingGroupEthnicities(siblingGroupEthnicities, personEthnicities);
          // Check all children's exchange record to map all of the background factors checked in each record
          String indFamHxDrugsAlcohol = exchangeChild.getIndFamHxDrugsAlcohol();
          if (StringHelper.isValid(indFamHxDrugsAlcohol) && ServiceConstants.FND_YES.equals(indFamHxDrugsAlcohol)) {
            populateSiblingGroupBackgroundFactors(siblingGroupBackgroundFactors, "indFamHxDrugsAlcohol", indFamHxDrugsAlcohol);
          }
          String indFamHxMentalIll = exchangeChild.getIndFamHxMentalIll();
          if (StringHelper.isValid(indFamHxMentalIll) && ServiceConstants.FND_YES.equals(indFamHxMentalIll)) {
            populateSiblingGroupBackgroundFactors(siblingGroupBackgroundFactors, "indFamHxMentalIll", indFamHxMentalIll);
          }
          String indFamHxMr = exchangeChild.getIndFamHxMr();
          if (StringHelper.isValid(indFamHxMr) && ServiceConstants.FND_YES.equals(indFamHxMr)) {
            populateSiblingGroupBackgroundFactors(siblingGroupBackgroundFactors, "indFamHxMr", indFamHxMr);
          }
          String indChHxSexualAbuse = exchangeChild.getIndChHxSexualAbuse();
          if (StringHelper.isValid(indChHxSexualAbuse) && ServiceConstants.FND_YES.equals(indChHxSexualAbuse)) {
            populateSiblingGroupBackgroundFactors(siblingGroupBackgroundFactors, "indChHxSexualAbuse", indChHxSexualAbuse);
          }
          // Check all children's exchange record to map all of maximum severity of each child's special needs characteristic
          String cdSevMentalRetardation = exchangeChild.getCdSevMentalRetardation();
          if (StringHelper.isValid(cdSevMentalRetardation)) {
            populateMaxSevSpecialNeedsCharacteristics(maxSevSpecialNeedsCharacteristics, "cdSevMentalRetardation", cdSevMentalRetardation);
          }
          String cdSevVisualHearingImp = exchangeChild.getCdSevVisualHearingImp();
          if (StringHelper.isValid(cdSevVisualHearingImp)) {
            populateMaxSevSpecialNeedsCharacteristics(maxSevSpecialNeedsCharacteristics, "cdSevVisualHearingImp", cdSevVisualHearingImp);
          }
          String cdSevPhysicallyDisabled = exchangeChild.getCdSevPhysicallyDisabled();
          if (StringHelper.isValid(cdSevPhysicallyDisabled)) {
            populateMaxSevSpecialNeedsCharacteristics(maxSevSpecialNeedsCharacteristics, "cdSevPhysicallyDisabled", cdSevPhysicallyDisabled);
          }
          String cdSevEmotionallyDist = exchangeChild.getCdSevEmotionallyDist();
          if (StringHelper.isValid(cdSevEmotionallyDist)) {
            populateMaxSevSpecialNeedsCharacteristics(maxSevSpecialNeedsCharacteristics, "cdSevEmotionallyDist", cdSevEmotionallyDist);
          }
          String cdSevOtherMed = exchangeChild.getCdSevOtherMed();
          if (StringHelper.isValid(cdSevOtherMed)) {
            populateMaxSevSpecialNeedsCharacteristics(maxSevSpecialNeedsCharacteristics, "cdSevOtherMed", cdSevOtherMed);
          }
        }
      }
      siblingGroupSO.setCdOverallGender(cdOverallGender);
      siblingGroupSO.setSiblingGroupRaces(siblingGroupRaces);
      siblingGroupSO.setSiblingGroupEthnicities(siblingGroupEthnicities);
      siblingGroupSO.setSiblingGroupBackgroundFactors(siblingGroupBackgroundFactors);
      siblingGroupSO.setMaxSevSpecialNeedsCharacteristics(maxSevSpecialNeedsCharacteristics);
    }
    return siblingGroupSO;
  }
  
  
  private String determineOverallGender (String cdOverallGender, String cdPersonSex){
    // If the over gender is not already set to Both 'B' and this child sex is different than the previous children's sex
    // then we need to set to Both 'B'
    if (StringHelper.isValid(cdPersonSex) && StringHelper.isValid(cdOverallGender) && !CodesTables.CRSRCSEX_B.equals(cdOverallGender)) {
      if (!cdPersonSex.equals(cdOverallGender)){
        cdOverallGender = CodesTables.CRSRCSEX_B;
      }
    } 
    // Else if this is the first time we come into this method then we just need to set the overal gender code to this child's sex
    else if (cdOverallGender == null){
      cdOverallGender = cdPersonSex;
    }
    return cdOverallGender;
  }
  
  private void populateSiblingGroupRaces (List<String> siblingGroupRaces, List<PersonRace> personRaces) {
    if (personRaces != null && personRaces.size() > 0) {
      Iterator<PersonRace> personRaces_it = personRaces.iterator();
      while (personRaces_it.hasNext()) {
        PersonRace personRace = personRaces_it.next();
        // Only set this race if it's not already set in the list since we don't want duplicate races
        if (!siblingGroupRaces.contains(personRace.getCdRace())){
          siblingGroupRaces.add(personRace.getCdRace());
        }
      }
    }
  }
  
  private void populateSiblingGroupEthnicities (List<String> siblingGroupEthnicities, List<PersonEthnicity> personEthnicities) {
    if (personEthnicities != null && personEthnicities.size() > 0) {
      Iterator<PersonEthnicity> personEthnicities_it = personEthnicities.iterator();
      while (personEthnicities_it.hasNext()) {
        PersonEthnicity personEthnicity = personEthnicities_it.next();
        // Only set this ethnicity if it's not already set in the list since we don't want duplicate ethnicities
        if (!siblingGroupEthnicities.contains(personEthnicity.getCdEthnicity())) {
          siblingGroupEthnicities.add(personEthnicity.getCdEthnicity());
        }
      }
    }
  }
  
  private void populateSiblingGroupBackgroundFactors(Map<String, String> siblingGroupBackgroundFactors, String factorName, String indChildHasFactor){
    // If this background factor is already set in the Map, then we don't need to set it again
    if (!siblingGroupBackgroundFactors.containsKey(factorName)){
      siblingGroupBackgroundFactors.put(factorName, indChildHasFactor);
    }
  }
  
  private void populateMaxSevSpecialNeedsCharacteristics(Map<String, String> maxSevSpecialNeedsCharacteristics, String spclNeedsCharName, String cdSevSpclNeedsChar) {
    if (StringHelper.isValid(cdSevSpclNeedsChar)) { 
      // If the special needs character is already set then we need to check it's severity compared to the severity already set in the Map
      if (maxSevSpecialNeedsCharacteristics.containsKey(spclNeedsCharName)) {
        String maxSeverity = maxSevSpecialNeedsCharacteristics.get(spclNeedsCharName);
        // Only if the severity within the Map is not already set as 'severe' do we need to compare it with this child's severity code
        if (!CodesTables.CADSEVER_03.equals(maxSeverity)) {
          // If the severity is set to 'moderate' in the Map and this child's severity level is higher/'severe' then we need to set it to 'severe'
          if (CodesTables.CADSEVER_02.equals(maxSeverity) && CodesTables.CADSEVER_03.equals(cdSevSpclNeedsChar)) {
            maxSevSpecialNeedsCharacteristics.put(spclNeedsCharName, cdSevSpclNeedsChar);
          }
          // If the severity is set to 'mild' in the Map and this child's severity level is higher/'moderate'/'severe' then we need to set it to 'moderate'/'severe'
          if (CodesTables.CADSEVER_01.equals(maxSeverity) && !CodesTables.CADSEVER_01.equals(cdSevSpclNeedsChar)) {
            maxSevSpecialNeedsCharacteristics.put(spclNeedsCharName, cdSevSpclNeedsChar);
          }
        }
      } 
      // Else if it hasn't been set then we just need to set it
      else {
        maxSevSpecialNeedsCharacteristics.put(spclNeedsCharName, cdSevSpclNeedsChar);
      }
    }
  }
}