/**
 * Created on May 23, 2006 at 11:24:48 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DynamicCapsResourceDAO {
  static final String SORT_BY_RESOURCE_NAME = "N";
  static final String SORT_BY_TYPE = "T";
  static final String SORT_BY_COUNTY = "C";

  /**
   * This retreieves resource information using the given criteria.  No parameters are required.  Use zero's and nulls
   * for parameters that are not used.
   * <p/>
   * Unlike most dynamic DAO's, this DAO returns a map with keys for: nmResource, addrRsrcStLn1, addrRsrcStLn2,
   * addrRsrcCity, nbrRsrcPhn, cdRsrcType, idResource, nmRsrcContact, cdRsrcSchDist, cdRsrcStatus, cdRsrcMaintainer,
   * addrRsrcZip, nbrRsrcPhoneExt, cdRsrcState, addrRsrcAttn, and cdRsrcOperBy.  Depending on inputs, cdRsrcFacilType,
   * cdRsrcMhmrCompCode, and cdRsrcFacilAcclaim may be selected, as well.
   *
   * @param cdRsrcType
   * @param cdRsrcSvcProgram
   * @param nmResource
   * @param nmRsrcNmInd
   * @param idResource
   * @param cdRsrcSvcCategRsrc
   * @param cdRsrcFacilType
   * @param cdRsrcSvcState
   * @param cdRsrcSvcRegion
   * @param nmCity
   * @param cdRsrcSvcCnty
   * @param addrRsrcAddrZip
   * @param indRsrcTransport
   * @param indRsrcInactive
   * @param scrYrRsrcCharMin
   * @param cdRsrcCharSex
   * @param nbrRsrcFacilAcclaim
   * @param scrCdRsrcSort
   * @param cdRsrcCharChrctr
   * @param cdFloc
   * @param cdRsrcSvcService
   * @param scrCdRsrcSvcContract
   * @param scrIndRsrcLocation
   * @param dtSvcAuthEff
   * @param cdMhmrCompCode
   * @return See description.
   */
  List<Map> findResources(String cdRsrcType, String cdRsrcSvcProgram, String nmResource, String nmRsrcNmInd,
                          int idResource, String cdRsrcSvcCategRsrc, String cdRsrcFacilType, String cdRsrcSvcState,
                          String cdRsrcSvcRegion, String nmCity, String cdRsrcSvcCnty, String addrRsrcAddrZip,
                          String indRsrcTransport, String indRsrcInactive, int scrYrRsrcCharMin, String cdRsrcCharSex,
                          int nbrRsrcFacilAcclaim, String scrCdRsrcSort, String cdRsrcCharChrctr, String cdFloc,
                          String cdRsrcSvcService, String scrCdRsrcSvcContract, String scrIndRsrcLocation,
                          Date dtSvcAuthEff, String cdMhmrCompCode);
}