
package gov.georgia.dhr.dfcs.sacwis.ws.crsregistration;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import gov.ga.gta.eiss.shines.crs.crsregistration.ShinesRegistrationResponse;
import processcrsregistration.svcs.crs.shines.ProcessCRSRegistration;

@WebService(name = "SHINES_CRS_Svcs_processCRSRegistrationPortType", targetNamespace = "http://167.192.98.180/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface SHINES_CRS_Svcs_processCRSRegistrationPortType {


    @WebMethod(operationName = "Shines_CRSRegistration", action = "")
    @WebResult(name = "ShinesRegistrationResponse", targetNamespace = "http://eiss.gta.ga.gov/shines/crs/CRSRegistration")
    public ShinesRegistrationResponse shines_CRSRegistration(
        @WebParam(name = "processCRSRegistration", targetNamespace = "SHINES.CRS.Svcs.processCRSRegistration")
        ProcessCRSRegistration processCRSRegistration);

}
