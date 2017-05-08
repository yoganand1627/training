package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexContactStandardsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactForDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactRuleDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelationshipDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContactRule;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ----------------------------------------------
 * 02/18/10  Bhavna Gehlot              Initial creation
 * 
 * </pre>
 *
 * @author Bhavna Gehlot, Februrary 18, 2010
 */

public class ComplexContactStandardsDAOImpl extends BaseDAOImpl implements ComplexContactStandardsDAO {  
  private ContactRuleDAO contactRuleDAO = null;
  private RelationshipDAO relationshipDAO = null;
  private PersonDAO personDAO = null;
  private ContactForDAO contactForDAO = null;

  public void setContactRuleDAO(ContactRuleDAO contactRuleDAO){
    this.contactRuleDAO = contactRuleDAO;
  }

  public void setRelationshipDAO(RelationshipDAO relationshipDAO) {
    this.relationshipDAO = relationshipDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setContactForDAO(ContactForDAO contactForDAO){
    this.contactForDAO = contactForDAO;
  }

  /**
   * Saves the children in CONTACT_RULE table
   * @param childrenList
   * @param childContactRule
   */
  public void saveChildContactRule(List<Integer> childrenList, Event event){
  }

  /**
   * Saves the related to persons in CONTACT_RULE table
   * @param relatedToPersonList
   * @param parentContactRule
   */
  public void saveParentContactRule(List<Integer> childrenList, Event event){
    
  }
  

  private static ArrayList<Integer> GetUniqueValues(Collection<Integer> values)
  {
    return (ArrayList<Integer>)Union(values, values);
  }

  private static Collection<Integer> Union(Collection<Integer> coll1, Collection<Integer> coll2)
  {
    Set<Integer> union = new HashSet<Integer>(coll1);
    union.addAll(new HashSet<Integer>(coll2));
    return new ArrayList<Integer>(union);
  }

}
