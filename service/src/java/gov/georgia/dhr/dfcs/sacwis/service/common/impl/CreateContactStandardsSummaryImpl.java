package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactRuleDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CsSummaryCompLookupDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CsSummaryCompLookup;
import gov.georgia.dhr.dfcs.sacwis.service.common.CreateContactStandardsSummary;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactStandardsSummarySI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactRuleBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactRuleBeanComparator;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsSummarySO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author Herve Jean-Baptiste March 01, 2010
 * 
 * <pre>
 *   Change History:
 *   Date         User                     Description
 *   ----------   -------------------      ---------------------------------------------------------
 *   03/01/2010   hjbaptiste               Initial Creation
 *   03/11/2010   hjbaptiste               MR-62: Set the parental role indicators to 'U' if an Unknown is the only
 *                                         rule that was created for the particular role. Instantiated the indicators
 *                                         that will be passed to the DAO to lookup for a match in the DB to a blank
 *                                         space (" ")
 *   
 * </pre>
 * 
 */
public class CreateContactStandardsSummaryImpl extends BaseServiceImpl implements CreateContactStandardsSummary {

  private static final int NUM_COLUMNS = 5;
  private static final String FATHER_ROLE = CodesTables.CPARROLE_FAT;
  private static final String MOTHER_ROLE = CodesTables.CPARROLE_MOT;
  private static final String CARETAKER_ROLE = CodesTables.CPARROLE_CTK;
  private static final String UNKNOWN_FATHER = "Unknown Father";
  private static final String UNKNOWN_MOTHER = "Unknown Mother";
  
  private ContactRuleDAO contactRuleDAO = null;
  private CsSummaryCompLookupDAO csSummaryCompLookupDAO = null;
  
  public void setContactRuleDAO(ContactRuleDAO contactRuleDAO) {
    this.contactRuleDAO = contactRuleDAO;
  }

  public void setCsSummaryCompLookupDAO(CsSummaryCompLookupDAO csSummaryCompLookupDAO) {
    this.csSummaryCompLookupDAO = csSummaryCompLookupDAO;
  }
  
  
  public ContactStandardsSummarySO createContactStandardsSummary(ContactStandardsSummarySI contactStandardsSummarySI)
                                                                                                                     throws ServiceException {
    ContactStandardsSummarySO contactStandardsSummarySO = new ContactStandardsSummarySO();
    int idEvent = contactStandardsSummarySI.getUlIdEvent();
    String indContactStandardsComplete = ServiceConstants.FND_NO;
    String[][] contactStandardsSummary = null;
    List<String> roles = new ArrayList<String>();
    roles = new ArrayList<String>();
    roles.add(CodesTables.CPARROLE_CHL);
    // Get the list of Children with Contact Rules. These children's full name will be displayed in the Child column.
    List<ContactRuleBean> childContactRuleBeanList = contactStandardsSummarySI.getChildContactRuleBeanList();
    ContactRuleBeanComparator ruleBeanComparator = new ContactRuleBeanComparator();
    if(childContactRuleBeanList != null && !childContactRuleBeanList.isEmpty()){
      Collections.sort(childContactRuleBeanList, ruleBeanComparator);
      contactStandardsSummary = new String[childContactRuleBeanList.size()][NUM_COLUMNS];
      for (int i = 0; i < childContactRuleBeanList.size(); i++) {
        ContactRuleBean childContactRuleBean = childContactRuleBeanList.get(i);
        int idChild = childContactRuleBean.getUlIdPerson();
        // Initialize some string buffers to append the names of the Parental person. It can also be an 'Unknown' person.
        StringBuffer father_sb = new StringBuffer();
        StringBuffer mother_sb = new StringBuffer();
        StringBuffer caretaker_sb = new StringBuffer();
        boolean fatherRoleHasBeenSet = false;
        boolean motherRoleHasBeenSet = false;
        boolean caretakerRoleHasBeenSet = false;
        // Create the inner loop which will populate the columns for this row (which is the outer loop).
        for (int j = 0; j < NUM_COLUMNS; j++) {
          switch (j) {
          case 0:
            // The first column is populated with the name of the child
            String nmChildFull = childContactRuleBean.getNmPersonFull();
            contactStandardsSummary[i][j] = nmChildFull;
            break;
          case 1:
            // The second column is populated with the full name of the list of people that have a Father Parental role to the child. Due to 
            // time constraints, we will first get the list of 'Unknown Father'. Then we will get the list of all
            // people referenced to the PERSON_ENC table. This can be done with one call to the DB by using an outer join to the 
            // PERSON_ENC table. For some strange reason, Hibernate will not return the 'Unknown Father' in the list using an outer
            // join since they don't have an ID_PERSON. This can be revised later.
            String unknownFatherContact = contactRuleDAO.findUnknownContactRulesByIdEventIdChild(idEvent, idChild, FATHER_ROLE);
            if (unknownFatherContact != null && !StringHelper.EMPTY_STRING.equals(unknownFatherContact)) {
              father_sb.append(Lookup.simpleDecodeSafe(CodesTables.CUNPRENT, unknownFatherContact));
              // Indicates that a father role has been set in order to append the ' | ' symbol to seperate the names
              fatherRoleHasBeenSet = true;
            }
            String nmFatherFull = StringHelper.EMPTY_STRING;
            List<String> fatherContacts = contactRuleDAO.findContactRulesByIdEventIdChild(idEvent, idChild, FATHER_ROLE);
            if (fatherContacts != null && !fatherContacts.isEmpty()){
              // Loop thru the full names and append them to the buffer seperated by the ' | ' symbol
              for (int k = 0; k < fatherContacts.size(); k++) {
                nmFatherFull = fatherContacts.get(k);
                if(fatherRoleHasBeenSet) {
                  father_sb.append(" | ");
                }
                father_sb.append(nmFatherFull);
                fatherRoleHasBeenSet = true;
              }
            }
            // Add the list of full father names to the column for this row
            contactStandardsSummary[i][j] = father_sb.toString();
            break;
          case 2:
            // The third column is populated with the full name of the list of people that have a Mother Parental role to the child. 
            // Again, Due to time constraints, we will first get the list of 'Unknown Mother'. Then we will get the list of all
            // people referenced to the PERSON_ENC table. This can be done with one call to the DB by using an outer join to the 
            // PERSON_ENC table. For some strange reason, Hibernate will not return the 'Unknown Mother' in the list using an outer
            // join since they don't have an ID_PERSON. This can be revised later.
            String unknownMotherContact = contactRuleDAO.findUnknownContactRulesByIdEventIdChild(idEvent, idChild, MOTHER_ROLE);
            if (unknownMotherContact != null && !StringHelper.EMPTY_STRING.equals(unknownMotherContact)) {
              mother_sb.append(Lookup.simpleDecodeSafe(CodesTables.CUNPRENT, unknownMotherContact));
              // Indicates that a mother role has been set in order to append the ' | ' symbol to seperate the names
              motherRoleHasBeenSet = true;
            }
            String nmMotherFull = StringHelper.EMPTY_STRING;
            List<String> motherContacts = contactRuleDAO.findContactRulesByIdEventIdChild(idEvent, idChild, MOTHER_ROLE);
            if (motherContacts != null && !motherContacts.isEmpty()){
              // Loop thru the full names and append them to the buffer seperated by the ' | ' symbol
              for (int k = 0; k < motherContacts.size(); k++) {
                nmMotherFull = motherContacts.get(k);
                if(motherRoleHasBeenSet) {
                  mother_sb.append(" | ");
                }
                mother_sb.append(nmMotherFull);
                motherRoleHasBeenSet = true;
              }
            }
            // Add the list of full mother names to the column for this row
            contactStandardsSummary[i][j] = mother_sb.toString();
            break;
          case 3:
            // The third column is populated with the full name of the list of people that have a Caretaker Parental role to the child.
            // We do not need two queries for Caretaker as there can not be an 'Unknown Caretaker'.
            String nmCaretakerFull = StringHelper.EMPTY_STRING;
            List<String> catetakerContacts = contactRuleDAO.findContactRulesByIdEventIdChild(idEvent, idChild, CARETAKER_ROLE);
            if (catetakerContacts != null && !catetakerContacts.isEmpty()){
              // Loop thru the full names and append them to the buffer seperated by the ' | ' symbol
              for (int k = 0; k < catetakerContacts.size(); k++) {
                nmCaretakerFull = catetakerContacts.get(k);
                if(caretakerRoleHasBeenSet) {
                  caretaker_sb.append(" | ");
                }
                caretaker_sb.append(nmCaretakerFull);
                // Indicates that a caretaker role has been set in order to append the ' | ' symbol to separate the names
                caretakerRoleHasBeenSet = true;
              }
            }
            // Add the list of full caretaker names to the column for this row
            contactStandardsSummary[i][j] = caretaker_sb.toString();
            break;
          case 4:
            // As of now, we don't know if the Contact Rule is complete. We put an empty string for the fourth row
            contactStandardsSummary[i][j] = StringHelper.EMPTY_STRING;
            break;
          }
        }
      }
    }
    
    // Now that we have the two dimensional array populated with the names of Father, Mother and Caretaker Parental Roles,
    // we need to determine if the All Contact Rules for each child is complete. We do this by setting a 'Y' for each child's
    // Parental Role column (column 4 in the array) if that position in the array doesn't contain a null or an empty string. 
    // An indicator is also set to 'Y' reflecting this completeness. We will use this indicator later to determine if all 
    // of the children's Contact Rules have been completed. The Contact Rule can only be submitted if all of the rules are complete.
    int countCompletedRules = 0;
    if (contactStandardsSummary != null && contactStandardsSummary.length > 0) {
      for (int i = 0; i < contactStandardsSummary.length; i++) {
        // These variables are instantiated with a space (" ") on purpose. A space had to be inserted in the database
        // columns of the lookup table CS_SUMMARY_COMP_LOOKUP. Oracle doesn't differentiate an empty string with a null. 
        // Therefore in order to get back a row that matches the summary's Father, Mother and Caretaker, we have to pass
        // a space where the child doesn't have a rule for that particular parental role. Note that when looking at the DB,
        // the space can not be seen in the column.
        String nmFather = " ";
        String nmMother = " ";
        String nmCaretaker = " ";
        String indFather = " ";
        String indMother = " ";
        String indCaretaker = " ";
        // Start at the second column since the first column (index 0) contains the child's name. 
        for (int j = 1; j < contactStandardsSummary[i].length - 1; j++) {
          switch (j) {
          case 1:
            // Contains the full names of the Father Parental Role(s)
            nmFather = contactStandardsSummary[i][j];
            if (nmFather != null && !StringHelper.EMPTY_STRING.equals(nmFather)) {
              if (!UNKNOWN_FATHER.equals(nmFather)) {
                indFather = ServiceConstants.FND_YES;
              } else {
                indFather = "U";
              }
            }
            break;
          case 2:
            // Contains the full names of the Mother Parental Role(s)
            nmMother = contactStandardsSummary[i][j];
            if (nmMother != null && !StringHelper.EMPTY_STRING.equals(nmMother)) {
              if (!UNKNOWN_MOTHER.equals(nmMother)) {
                indMother = ServiceConstants.FND_YES;
              } else {
                indMother = "U";
              }
            }
            break;
          case 3:
            // Contains the full names of the Catetaker Parental Role(s)
            nmCaretaker = contactStandardsSummary[i][j];
            if (nmCaretaker != null && !StringHelper.EMPTY_STRING.equals(nmCaretaker)) {
              indCaretaker = ServiceConstants.FND_YES;
            } 
            break;
          }
        }
        // Use the Lookup table to see if there's a rule in the table that matches the Parent, Mother, Caretaker combination.
        // If we find a match populate the fifth and final column with a 'Y' to indicate that the Contact Rule is comple
        CsSummaryCompLookup csSummaryCompLookup = csSummaryCompLookupDAO.findCsSummaryCompLookupByMotherFatherCaretaker(indFather, indMother, indCaretaker);
        if (csSummaryCompLookup != null) {
          contactStandardsSummary[i][4] = ServiceConstants.FND_YES;
          // Increment the overall completed Rules for the Contact Standards.
          countCompletedRules++;
        }
      }
    }
    // If we have the same number of overall completed Rules as the number of children that we have to create contacts for
    // the All of the Parental Rules have been completed for The Contact Standards which will allow submit.
    if (childContactRuleBeanList.size() == countCompletedRules) {
      indContactStandardsComplete = ServiceConstants.FND_YES;
    } else {
      indContactStandardsComplete = ServiceConstants.FND_NO;
    }
    contactStandardsSummarySO.setContactStandardsSummary(contactStandardsSummary); 
    contactStandardsSummarySO.setIndContactStandardsComplete(indContactStandardsComplete);
   
    return contactStandardsSummarySO;
  }

}
