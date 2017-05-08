
package gov.georgia.dhr.dfcs.sacwis.ws.crsregistration;

import javax.jws.WebService;
import gov.ga.gta.eiss.shines.crs.crsregistration.ShinesRegistrationResponse;
import processcrsregistration.svcs.crs.shines.ProcessCRSRegistration;

@WebService(serviceName = "SHINES_CRS_Svcs_processCRSRegistrationService", targetNamespace = "http://167.192.98.180/", endpointInterface = "gov.georgia.dhr.dfcs.sacwis.ws.crsregistration.SHINES_CRS_Svcs_processCRSRegistrationPortType")
public class SHINES_CRS_Svcs_processCRSRegistrationServiceImpl
    implements SHINES_CRS_Svcs_processCRSRegistrationPortType
{


    public ShinesRegistrationResponse shines_CRSRegistration(ProcessCRSRegistration processCRSRegistration) {
        throw new UnsupportedOperationException();
    }

}
