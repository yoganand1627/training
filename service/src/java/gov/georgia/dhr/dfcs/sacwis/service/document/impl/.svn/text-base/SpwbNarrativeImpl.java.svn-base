package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateUtility;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexSpwbChckListLookupDAO;
import gov.georgia.dhr.dfcs.sacwis.service.document.SpwbNarrative;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpwbNarrativeSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpwbNarrativeSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;



public class SpwbNarrativeImpl extends BaseDocumentServiceImpl implements SpwbNarrative {
  private PersonDAO personDAO;
  private ComplexSpwbChckListLookupDAO complexSpwbChckListLookupDAO;
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  public void setComplexSpwbChckListLookupDAO(ComplexSpwbChckListLookupDAO complexSpwbChckListLookupDAO) {
    this.complexSpwbChckListLookupDAO = complexSpwbChckListLookupDAO;
  }
  
  public SpwbNarrativeSO retrieveGuidedChecklist(SpwbNarrativeSI spwbNarrativeSI) {

    SpwbNarrativeSO spwbNarrativeSO = new SpwbNarrativeSO();
    PreFillData preFillData = new PreFillData();

    // Must send at least one bookmark within the preFillData node to be
    // compliant with the forms architecture.  This bookmark is ignored.
    preFillData.addBookmark(createBookmark("DUMMY","DUMMY"));
    
    // Find the primary children in the case
    List<Person> primaryChildren = null;
    if ( FCC.equals(spwbNarrativeSI.getSzCdStage())|| ADO.equals(spwbNarrativeSI.getSzCdStage())
        || FCF.equals(spwbNarrativeSI.getSzCdStage())) {
      primaryChildren = personDAO.findPrimaryChildrenInCase(spwbNarrativeSI.getUlIdCase());
    } else {
      primaryChildren = personDAO.findPrincipleChildrenInCaseUnder18(spwbNarrativeSI.getUlIdStage());
    }
      
    ArrayList<Integer> childrenAges = new ArrayList<Integer>();

    if (primaryChildren != null) {
      Iterator<Person> it = primaryChildren.iterator();
      while (it.hasNext()) {
        Person child = it.next();
        childrenAges.add(DateUtility.getAgeInMonths(child.getDtPersonBirth(), new Date()));
      }
    }

   
    // Basic Safety Question List
    populateQuestionList(primaryChildren, childrenAges, SAFETY_CATEGORY, BASIC_SAFETY_CATEGORY, CAREGIVER,
                         TMPLAT_BASIC_SAFETY, preFillData);

    // Preventing Falls Question List
    populateQuestionList(primaryChildren, childrenAges, SAFETY_CATEGORY, PREVENTING_FALLS_CATEGORY, CAREGIVER,
                         TMPLAT_PREVENTING_FALLS, preFillData);    
    
    // Sleep Time Safety Question List
    populateQuestionList(primaryChildren, childrenAges, SAFETY_CATEGORY, SLEEP_TIME_CATEGORY, CAREGIVER,
                         TMPLAT_SLEEP_TIME_SAFETY, preFillData);     
    
    // Crib Safety Question List
    populateQuestionList(primaryChildren, childrenAges, SAFETY_CATEGORY, CRIB_SAFETY_CATEGORY, CAREGIVER,
                         TMPLAT_CRIB_SAFETY, preFillData); 
    
    // Child Care Question List
    populateQuestionList(primaryChildren, childrenAges, SAFETY_CATEGORY, CHILD_CARE_CATEGORY, CAREGIVER,
                         TMPLAT_CHILD_CARE_SAFETY, preFillData);
    
    // Bath Safety Question List
    populateQuestionList(primaryChildren, childrenAges, SAFETY_CATEGORY, BATH_SAFETY_CATEGORY, CAREGIVER,
                         TMPLAT_BATH_SAFETY, preFillData);    
    
    // Safety in the Streets Question List
    populateQuestionList(primaryChildren, childrenAges, SAFETY_CATEGORY, STREET_SAFETY_CATEGORY, CAREGIVER,
                         TMPLAT_STREET_SAFETY, preFillData);    
    
    // Safety for Children Above 6 Years
    populateQuestionList(primaryChildren, childrenAges, SAFETY_CATEGORY, ABOVE_6_CATEGORY, CAREGIVER,
                         TMPLAT_ABOVE_6_SAFETY, preFillData);   
    
    // Safety Checklist for Children
    populateQuestionList(primaryChildren, childrenAges, SAFETY_CATEGORY, null, CHILD,
                         TMPLAT_CHILD_SAFETY, preFillData);    
    
    // Well Being and Permanency Questions for Caregiver
    populateQuestionList(primaryChildren, childrenAges, WELLBEING_PERMANENCY_CATEGORY, null, CAREGIVER,
                         TMPLAT_CG_WELL_BEING, preFillData);      

    // Living Arrangement
    populateQuestionList(primaryChildren, childrenAges, WELLBEING_PERMANENCY_CATEGORY, LIVING_ARRANGEMENT_CATEGORY,
                         CHILD, TMPLAT_LIVING_ARRANGEMENT, preFillData);      
    
    // Daily Routine
    populateQuestionList(primaryChildren, childrenAges, WELLBEING_PERMANENCY_CATEGORY, DAILY_ROUTINE_CATEGORY,
                         CHILD, TMPLAT_DAILY_ROUTINE, preFillData); 
    
    // Special Interests
    populateQuestionList(primaryChildren, childrenAges, WELLBEING_PERMANENCY_CATEGORY, SPECIAL_INTERESTS_CATEGORY,
                         CHILD, TMPLAT_SPECIAL_INTERESTS, preFillData);     

    // Social/Emotional
    populateQuestionList(primaryChildren, childrenAges, WELLBEING_PERMANENCY_CATEGORY, SOCIAL_EMOTIONAL_CATEGORY,
                         CHILD, TMPLAT_SOCIAL_EMOTIONAL, preFillData);     
 
    // Education
    populateQuestionList(primaryChildren, childrenAges, WELLBEING_PERMANENCY_CATEGORY, EDUCATION_CATEGORY,
                         CHILD, TMPLAT_EDUCATION, preFillData);   
  
    // Friends and Family
    populateQuestionList(primaryChildren, childrenAges, WELLBEING_PERMANENCY_CATEGORY, FRIENDS_FAMILY_CATEGORY,
                         CHILD, TMPLAT_FRIENDS_FAMILY, preFillData);   
    
    // Health
    populateQuestionList(primaryChildren, childrenAges, WELLBEING_PERMANENCY_CATEGORY, HEALTH_CATEGORY,
                         CHILD, TMPLAT_HEALTH, preFillData);   
    
    // Goal Setting
    populateQuestionList(primaryChildren, childrenAges, WELLBEING_PERMANENCY_CATEGORY, GOAL_SETTING_CATEGORY,
                         CHILD, TMPLAT_GOAL_SETTING, preFillData);   
    
    // Employment
    populateQuestionList(primaryChildren, childrenAges, WELLBEING_PERMANENCY_CATEGORY, EMPLOYMENT_CATEGORY,
                         CHILD, TMPLAT_EMPLOYMENT, preFillData);       
    
    // Cultural Awareness
    populateQuestionList(primaryChildren, childrenAges, WELLBEING_PERMANENCY_CATEGORY, CULTURAL_AWARENESS_CATEGORY,
                         CHILD, TMPLAT_CULTURAL_AWARENESS, preFillData);   
    
    // Social Skills
    populateQuestionList(primaryChildren, childrenAges, WELLBEING_PERMANENCY_CATEGORY, SOCIAL_SKILLS_CATEGORY,
                         CHILD, TMPLAT_SOCIAL_SKILLS, preFillData);   
    
    // Housing
    populateQuestionList(primaryChildren, childrenAges, WELLBEING_PERMANENCY_CATEGORY, HOUSING_CATEGORY,
                         CHILD, TMPLAT_HOUSING, preFillData);    
    
    // Life Skills
    populateQuestionList(primaryChildren, childrenAges, WELLBEING_PERMANENCY_CATEGORY, LIFE_SKILLS_CATEGORY,
                         CHILD, TMPLAT_LIFE_SKILLS, preFillData);      
   
    spwbNarrativeSO.setPreFillData(preFillData);
    return spwbNarrativeSO;
  }
  private void populateQuestionList(List<Person> primaryChildren, ArrayList<Integer> childrenAges,
                                    String cdMainCategory, String cdSubCategory, String cdAudience, 
                                    String templateGroup, PreFillData preFillData) {
    List<Map> questionList = complexSpwbChckListLookupDAO.findCheckListQuestions(childrenAges, cdMainCategory, cdSubCategory, cdAudience);

    String cdChckList = null;
    String txtChckList = null;
    Integer monthMin = null;
    Integer monthMax = null;
    String children = null;
    FormDataGroup questionHeading =  null;
    
    if (questionList.size()>0) {
      questionHeading = createFormDataGroup(templateGroup, "");
    }
    for (Iterator<Map> it = questionList.iterator(); it.hasNext();) {
      
      Map question = it.next();
      
      // If this is the first checklist item ignore it.  Otherwise compare to the next question
      // to make sure it's not duplicated b/c the age groups are not contigous.
      if (cdChckList != null && !cdChckList.equals((String) question.get("cdChckList")) ) {
        FormDataGroup questionGroup = createFormDataGroup(templateGroup + "_" + QUESTION, "");
        questionGroup.addBookmark(createBookmark(QUESTION, txtChckList));
        questionGroup.addBookmark(createBookmark(CHILDREN, children));
        questionHeading.addFormDataGroup(questionGroup);
        children = null;
      }
      
      // Get the new checklist item and age ranges
      cdChckList = (String) question.get("cdChckList");
      txtChckList = (String) question.get("txtChckList");
      monthMin = (Integer) question.get("nbrMonthMin");
      monthMax = (Integer) question.get("nbrMonthMax");
      
      if (primaryChildren != null) {
        Iterator<Person> iz = primaryChildren.iterator();
        while(iz.hasNext()){
          Person child = iz.next();
          int ageInMonths = DateUtility.getAgeInMonths(child.getDtPersonBirth(), new Date());          
          if (monthMin <= ageInMonths && monthMax> ageInMonths){
            if (children == null) {
              children = child.getNmPersonFirst();
            }else {
              children = children + ", <br>" + child.getNmPersonFirst();
            }
          }
        }
      }      
    }
    
    // It is necessary to add the last record in the resultset b/c the loop will not include
    // the last record.
    if (cdChckList != null) {
      FormDataGroup questionGroup = createFormDataGroup(templateGroup + "_" + QUESTION, "");
      questionGroup.addBookmark(createBookmark(QUESTION, txtChckList));
      questionGroup.addBookmark(createBookmark(CHILDREN, children));
      questionHeading.addFormDataGroup(questionGroup);
    }
    
    // Add the heading to PreFillData if there were any questions
    if (questionHeading != null) {
      preFillData.addFormDataGroup(questionHeading);
    }
    
  }
}
    

