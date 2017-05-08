
package gov.georgia.dhr.dfcs.sacwis.ws.crsscreening;

import javax.jws.WebService;
import gov.ga.gta.eiss.shines.crs.crsscreening.ShinesScreeningResponse;
import processcrsscreening.svcs.crs.shines.ProcessCRSScreening;

@WebService(serviceName = "SHINES_CRS_Svcs_processCRSScreeningService", targetNamespace = "http://167.192.98.180/", endpointInterface = "gov.georgia.dhr.dfcs.sacwis.ws.crsscreening.SHINES_CRS_Svcs_processCRSScreeningPortType")
public class SHINES_CRS_Svcs_processCRSScreeningServiceImpl
    implements SHINES_CRS_Svcs_processCRSScreeningPortType
{


    public ShinesScreeningResponse shines_CRSScreening(ProcessCRSScreening processCRSScreening) {
        throw new UnsupportedOperationException();
    }

}
