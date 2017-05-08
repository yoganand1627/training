
package gov.georgia.dhr.dfcs.sacwis.ws.crsscreening;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import gov.ga.gta.eiss.shines.crs.crsscreening.ShinesScreeningResponse;
import processcrsscreening.svcs.crs.shines.ProcessCRSScreening;

@WebService(name = "SHINES_CRS_Svcs_processCRSScreeningPortType", targetNamespace = "http://167.192.98.180/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface SHINES_CRS_Svcs_processCRSScreeningPortType {


    @WebMethod(operationName = "Shines_CRSScreening", action = "")
    @WebResult(name = "ShinesScreeningResponse", targetNamespace = "http://eiss.gta.ga.gov/shines/crs/CRSScreening")
    public ShinesScreeningResponse shines_CRSScreening(
        @WebParam(name = "processCRSScreening", targetNamespace = "SHINES.CRS.Svcs.processCRSScreening")
        ProcessCRSScreening processCRSScreening);

}
