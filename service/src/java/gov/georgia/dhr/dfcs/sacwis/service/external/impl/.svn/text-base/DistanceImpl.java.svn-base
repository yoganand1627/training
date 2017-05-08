package gov.georgia.dhr.dfcs.sacwis.service.external.impl;

import com.mapinfo.coordsys.CoordSys;
import com.mapinfo.unit.LinearUnit;
import gov.georgia.dhr.dfcs.sacwis.service.external.Distance;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorSO;

/**
 * Service Name:  Distance
 * <pre>
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 * </pre>
 */
public class DistanceImpl extends BaseServiceImpl implements Distance {

  public double calculate(AddressValidatorSO start, AddressValidatorSO end) {
    double distance = 0.0;
    try {
      CoordSys CsysIn = CoordSys.longLatDatumless;
      distance = CsysIn.sphericalDistance(start.getX(), start.getY(), end.getX(), end.getY(), LinearUnit.foot);
    } catch (Exception mmfe) {
      System.out.println(mmfe);
    }
    return distance;
  }
}
