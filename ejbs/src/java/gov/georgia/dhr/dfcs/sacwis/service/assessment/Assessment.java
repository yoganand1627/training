/**
 * Created on Jun 28, 2006 at 12:54:02 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.assessment;

import gov.georgia.dhr.dfcs.sacwis.core.spring.SlsbFacade;

public interface Assessment
        extends DeleteSafetyAssessment, SlsbFacade, RetrieveIsDrugExposedNewborn, RetrievePrincipals,
                RetrievePrincipalsForRiskAssessment, RetrieveRiskFactors, RetrieveServicesReferralsChecklist,
                RetrieveSafetyAssessment, SaveSafetyAssessment, SaveServicesAndReferrals, RetrieveSafetyPlan,
                SaveSafetyPlan  {
}
