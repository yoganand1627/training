package gov.georgia.dhr.dfcs.sacwis.service.external.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.service.external.AddressValidator;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AddressValidatorSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorListSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorSO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;

import com.mapinfo.mapmarker.CandidateAddress;
import com.mapinfo.mapmarker.USA.USA_GeocodeConstraints;
import com.mapinfo.mapmarker.USA.USA_UserCandidateAddress;
import com.mapinfo.mapmarker.USA.USA_UserInputAddress;
import com.mapinfo.mapmarker.user.ClientGeocodeResponse;
import com.mapinfo.mapmarker.user.MMJClient;
import com.mapinfo.mapmarker.user.MapMarkerException;
import com.mapinfo.mapmarker.user.MapMarkerFatalException;
import com.mapinfo.util.DoublePoint;

/**
 * Service Name: AddressValidator
 * <p/>
 * <pre>
 *  Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 * </pre>
 */
public class AddressValidatorImpl implements AddressValidator {

  public static final String TRACE_TAG = "AddressValidatorImpl";
  public static final int RETURN_LIMIT = 5;
  public static final String DPV_CONFCODE_N = "N"; //This address does not exist.
  public static final String DPV_CONFCODE_Y = "Y"; //This address exists.
  public static final String DPV_CONFCODE_S = "S"; //The street address exists, but the unit does not.
  public static final String DPV_CONFCODE_D = "D"; //Address is incomplete (highrise with no unit, or rural route with no box number
  
  private AddressValidatorSO geocode(USA_UserInputAddress inAddr, List<String >dpvConfCodes) {
    String url = GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "mapServer");

    if (url == null) {
      //error situation
      GrndsTrace.msg(TRACE_TAG, 7, "No mapServer URL found.");
      return null;
    }
    USA_GeocodeConstraints geoCon = new USA_GeocodeConstraints();
    DoublePoint pnt;
    double x = 0.0;
    double y = 0.0;
    AddressValidatorSO addrValidatorSO = null;

    geoCon.setMustMatchAddressNumber(false);
    geoCon.setMustMatchMainAddress(false);
    geoCon.setMaxCandidates(5);
    geoCon.setReturnCloseCandidatesOnly(true);
    geoCon.setFallbackToPostal(true);
    geoCon.setMatchMode(USA_GeocodeConstraints.CASS_MODE);
    geoCon.setDPVMode(true);

    geoCon.setMustMatchState(true);
    geoCon.setMustMatchCity(true);
    geoCon.setMustMatchPostalCode(false);
    geoCon.setFallbackToGeographic(false);

    int type = MMJClient.GEOCODE_TYPE_ADDRESS;

    try {
      //Geocode Address
      ClientGeocodeResponse geoRes = MMJClient.geocode(type, inAddr, geoCon, url);

      // Get candidate count
      int candCount = geoRes.candidateCount();

      if (geoRes.isUniqueMatchFound()) {
        GrndsTrace.msg(TRACE_TAG, 7, "Unique match found for " + inAddr.getStreet());
      }

      String confCode;

      if (candCount > 0) {
        for (int i = 0; i < candCount; i++) {
          //Get candidate information
          CandidateAddress canAddr = geoRes.candidateAt(i);
          USA_UserCandidateAddress usaCand = new USA_UserCandidateAddress(canAddr);

          confCode = usaCand.getDpvConf();
          if ((usaCand.isCloseMatch()) && (confCode != null) && (dpvConfCodes.contains(confCode))) {
              pnt = usaCand.getLocation();
              if (pnt != null) {
                 /* Previous Code: x = pnt.x;
                                   y = pnt.y;
                   pnt.x is the longitude and pnt.y is the latitude. In all the conversations that are using 
                   this validate service is setting the x to the latitude and  y to the longitude. 
                   Hence values (Latitude and Longitude) that were saved in the DB were reversed.
                   Code below saves the latitude in x and longitude in y. 
                 * 
                 */
                x = pnt.y;
                y = pnt.x;
              }
            // DPV address match found.
            addrValidatorSO = new AddressValidatorSO(usaCand.getAddressNumber(), usaCand.getStreet(),
                                                     usaCand.getStreet2(),
                                                     usaCand.getPostThoroughfareType(), usaCand.getPostDirectional(),
                                                     usaCand.getCity(), usaCand.getState(), usaCand.getZipcode(),
                                                     usaCand.getZip4(), usaCand.getCensusBlock().substring(2, 5), usaCand.getFormattedStreetAddress(),
                                                     true, // validated
                                                     x, y, confCode);
            break;
          } else {
            // Found a candidate but it's not close or a dpv match.
          }
        }
      } else {
        // No matches
      }
    }
    catch (MapMarkerFatalException mmfe) {
      GrndsTrace.msg(TRACE_TAG, 7, "MapMarker Fatal Exception:" + mmfe.getMessage());
    }
    catch (MapMarkerException mme) {
      GrndsTrace.msg(TRACE_TAG, 7, "MapMarker Exception:" + mme.getMessage());
    }
    return addrValidatorSO;
  }
  
  private List<AddressValidatorSO> retrieveGeocodeAddresses(USA_UserInputAddress inAddr) {
    List<AddressValidatorSO> addressList = new ArrayList<AddressValidatorSO>();
    
    String url = GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "mapServer");
    if (url == null) {
      GrndsTrace.msg(TRACE_TAG, 7, "No mapServer URL found.");
      return null;
    }
    
    USA_GeocodeConstraints geoCon = new USA_GeocodeConstraints();
    geoCon.setMaxCandidates(5);
    geoCon.setReturnCloseCandidatesOnly(false);
    geoCon.setFallbackToPostal(true);
    geoCon.setMatchMode(USA_GeocodeConstraints.CASS_MODE);
    geoCon.setDPVMode(true);
    geoCon.setMustMatchMainAddress(false);
    
    try {
      ClientGeocodeResponse geoRes = MMJClient.geocode(MMJClient.GEOCODE_TYPE_ADDRESS, inAddr,
                                                       geoCon, url);
      int candCount = geoRes.candidateCount();
      if (candCount > 0) {
        for (int i = 0; i < candCount; i++) {
          //Get candidate information
          CandidateAddress canAddr = geoRes.candidateAt(i);
          USA_UserCandidateAddress usaCand = new USA_UserCandidateAddress(canAddr);

          AddressValidatorSO addrValidatorSO = new AddressValidatorSO(usaCand.getAddressNumber(), usaCand.getStreet(),
                                                   usaCand.getStreet2(),
                                                   usaCand.getPostThoroughfareType(), usaCand.getPostDirectional(),
                                                   usaCand.getCity(), usaCand.getState(), usaCand.getZipcode(),
                                                   usaCand.getZip4(), usaCand.getCensusBlock().substring(2, 5), usaCand.getFormattedStreetAddress(),
                                                   false, 0, 0);
          addressList.add(addrValidatorSO);
        }
      } 
    }
    catch (MapMarkerFatalException mmfe) {
      GrndsTrace.msg(TRACE_TAG, 7, "MapMarker Fatal Exception:" + mmfe.getMessage());
    }
    catch (MapMarkerException mme) {
      GrndsTrace.msg(TRACE_TAG, 7, "MapMarker Exception:" + mme.getMessage());
    }
    
    return addressList;
  }
  

  public AddressValidatorSO validate(AddressValidatorSI inAddressValidatorSI) {
    USA_UserInputAddress inAddr = new USA_UserInputAddress();
    inAddr.setStreet(inAddressValidatorSI.getAddress1());
    inAddr.setCity(inAddressValidatorSI.getCity());
    inAddr.setState(inAddressValidatorSI.getState());
    inAddr.setZipcode(inAddressValidatorSI.getZipCode());
    inAddr.setZip4(inAddressValidatorSI.getZip4());
    List<String> dpvConfCodes = new ArrayList<String>();
    dpvConfCodes.add(DPV_CONFCODE_Y);
    return geocode(inAddr, dpvConfCodes);
  }
  
  public AddressValidatorListSO validateAndOrFind(AddressValidatorSI inAddressValidatorSI){
    AddressValidatorListSO returnAdressSO = null;
    USA_UserInputAddress inAddr = new USA_UserInputAddress();
    inAddr.setStreet(inAddressValidatorSI.getAddress1());
    inAddr.setCity(inAddressValidatorSI.getCity());
    inAddr.setState(inAddressValidatorSI.getState());
    inAddr.setZipcode(inAddressValidatorSI.getZipCode());
    inAddr.setZip4(inAddressValidatorSI.getZip4());
    List<String> dpvConfCodes = new ArrayList<String>();
    dpvConfCodes.add(DPV_CONFCODE_Y);
    AddressValidatorSO validAddress = geocode(inAddr, dpvConfCodes);
    
    //if a null non address is returned then we have close valid match and just behave as before
    if(validAddress != null) {
      returnAdressSO = new AddressValidatorListSO();
      returnAdressSO.setInitialAddreessValid(true);
      List<AddressValidatorSO> vaildAddresses = new ArrayList<AddressValidatorSO>();
      vaildAddresses.add(validAddress);
      returnAdressSO.setVaildAddresses(vaildAddresses);
    } else {
      //try to find some similar addresses to present to the user
      List<AddressValidatorSO> potentialAddresses = retrieveGeocodeAddresses(inAddr);
      if(potentialAddresses != null && potentialAddresses.size() > 0){
        List<AddressValidatorSO> tempAddresses = new ArrayList<AddressValidatorSO>(); 
        dpvConfCodes.clear();
        dpvConfCodes.add(DPV_CONFCODE_Y);
        dpvConfCodes.add(DPV_CONFCODE_D);
        //note the addresses return by mapmarker will not have the dpv status so the code will need to test how valid they are
        Iterator<AddressValidatorSO> itr = potentialAddresses.iterator();
        while(itr.hasNext() && tempAddresses.size() <= RETURN_LIMIT) {
          AddressValidatorSO potentialAddress = itr.next();
          USA_UserInputAddress inNewAddr = new USA_UserInputAddress();
          inNewAddr.setStreet(potentialAddress.getFormattedStreetAddress());
          inNewAddr.setCity(potentialAddress.getCity());
          inNewAddr.setState(potentialAddress.getState());
          inNewAddr.setZipcode(potentialAddress.getZipCode());
          inNewAddr.setZip4(potentialAddress.getZip4());
          AddressValidatorSO address = geocode(inNewAddr, dpvConfCodes);
          if(address != null) {
            tempAddresses.add(address);
          }
        }
        if (tempAddresses.size() > 0) {
          returnAdressSO = new AddressValidatorListSO();
          returnAdressSO.setVaildAddresses(tempAddresses);
        }
      }
    }
    return returnAdressSO;
  }
}
