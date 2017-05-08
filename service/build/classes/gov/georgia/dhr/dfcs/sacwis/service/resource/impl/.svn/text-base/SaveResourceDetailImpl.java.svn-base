package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.InvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourcePhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.VendorOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.db.ResourcePhone;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveVendorOutbound;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.SaveResourceDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourcePersonBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.VendorOutboundSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04SO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/** Change History:
  **  Date        User              Description
  **  --------    ----------------  --------------------------------------------------
  **  04/10/2008  charden           STGAP00005794: Added StringHelpers to variables to get rid of
  *                                 nulls and called findCapsResourceByIdResc() from capsResourceDAO
  *                                 and used this to set the capacity of the resource
  *                                 
  *   07/16/2008  alwilliams        STGAP00009217 - Set the resource facility capacity (nbrRsrcFacilCapacity) 
  *                                 to zero in method saveResourceDetail when database value for 
  *                                 the corresponding field is null.
  *                                 
  *   09/30/2008 charden            STGAP00009378 - put in check to insert null persWorker object if sysIdPriorPerson = 0.  
  *   
  *   01/19/2009 pcoogan            STGAP00011971- MR-027, add logic to send vendor update transaction if there is an
  *                                 active contract, even if not originally sent through the interface 
  *                                 
  *   09/12/2011 charden            STGAP00017058 - adding code to update vendor ID's for resource
  *                                 
  **/
  
public class SaveResourceDetailImpl extends BaseServiceImpl implements SaveResourceDetail {
  
  
  public static final String PHONE_TYPE = "01";
  public static final String FAX_TYPE = "03";
  public static final String FAX2_TYPE = "08";
  
  //-- temporary message
  private static final String MSG_VID_REQ = "The Resource Details can not be updated until Vendor ID is assigned by SMILE";

  private CapsResourceDAO capsResourceDAO = null;
  
  //STGAP00011971 added ContractPeriodDAO to determine if active contract
  
  private ContractPeriodDAO contractPeriodDAO = null;

  private ResourceAddressDAO resourceAddressDAO = null;

  private ResourcePhoneDAO resourcePhoneDAO = null;

  private SaveVendorOutbound saveVendorOutbound;

  private InvoiceDAO invoiceDAO = null;

  private TodoDAO todoDAO = null;

  private VendorOutboundDAO vendorOutboundDAO = null;

  private UnitEmpLinkDAO unitEmpLinkDAO;

  private PlacementDAO placementDAO;

  public void setSaveVendorOutbound(SaveVendorOutbound saveVendorOutbound) {
    this.saveVendorOutbound = saveVendorOutbound;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setContractPeriodDAO(ContractPeriodDAO contractPeriodDAO) {
    this.contractPeriodDAO = contractPeriodDAO;
  }
  
  public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }

  public void setResourcePhoneDAO(ResourcePhoneDAO resourcePhoneDAO) {
    this.resourcePhoneDAO = resourcePhoneDAO;
  }

  public void setInvoiceDAO(InvoiceDAO invoiceDAO) {
    this.invoiceDAO = invoiceDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setVendorOutboundDAO(VendorOutboundDAO vendorOutboundDAO) {
    this.vendorOutboundDAO = vendorOutboundDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public CRES04SO saveResourceDetail(CRES04SI cres04si) throws ServiceException
  {
    CRES04SO cres04so = new CRES04SO();
    String nmResource = StringHelper.getNonNullString(cres04si.getSzNmResource());
    String nmRsrcContact = StringHelper.getNonNullString(cres04si.getSzNmRsrcContact());
    String cdRsrcFacilType = StringHelper.getNonNullString(cres04si.getSzCdRsrcFacilType());
    int nbrRsrcFacilAcclaim = cres04si.getLNbrRsrcFacilAcclaim();
    String cdRsrcType = StringHelper.getNonNullString(cres04si.getSzCdRsrcType());
    String cdRsrcCampusType = StringHelper.getNonNullString(cres04si.getSzCdRsrcCampusType());
    int nbrSchCampusNbr = cres04si.getLNbrSchCampusNbr();
    String cdMhmrCompCode = StringHelper.getNonNullString(cres04si.getSzCdMhmrCompCode());
    String cdRsrcCertBy = StringHelper.getNonNullString(cres04si.getCreatedBy());
    String cdRsrcOperBy = "";
    String cdRsrcSetting = "";
    String cdRsrcPayment = "";
    int nbrRsrcFacilCapacity = cres04si.getLNbrRsrcFacilAcclaim();
    String cdRsrcMaintainer = StringHelper.getNonNullString(cres04si.getSzCdRsrcMaintainer());
    String cdRsrcOwnership = StringHelper.getNonNullString(cres04si.getSzCdRsrcOwnership());
    String cdRsrcStatus = StringHelper.getNonNullString(cres04si.getSzCdRsrcStatus());
    String nmRsrcLastUpdate = StringHelper.getNonNullString(cres04si.getSzNmRsrcLastUpdate());
    String indRsrcTransport = StringHelper.getNonNullString(cres04si.getCIndRsrcTransport());
    String txtRsrcComments = StringHelper.getNonNullString(cres04si.getSzTxtRsrcComments());
    String cdRsrcHub = StringHelper.getNonNullString(cres04si.getSzCdRsrcHub());
    String nmLegal = StringHelper.getNonNullString(cres04si.getSzNmLegal());
    String reqFuncCd = StringHelper.getNonNullString(cres04si.getArchInputStruct().getCReqFuncCd());
    int idResource = cres04si.getUlIdResource();
    Date tsLastUpdate = cres04si.getTsLastUpdate();
    if(DateHelper.isNull(tsLastUpdate)){
      tsLastUpdate = new Date();
    } 
    String nmRsrcContactTitle = StringHelper.getNonNullString(cres04si.getSzNmRsrcContactTitle());
    String nbrRsrcNtnlProvider = StringHelper.getNonNullString(cres04si.getSzNbrRsrcNtnlProvider());
    String cdAddrRsrcEmail = StringHelper.getNonNullString(cres04si.getSzAddrRsrcEmail());
    String cdAddrRsrcWebsite = StringHelper.getNonNullString(cres04si.getSzAddrRsrcWebsite());
    String cdSchoolType = StringHelper.getNonNullString(cres04si.getSzCdSchoolType());
    String cdPaymentDelivery = StringHelper.getNonNullString(cres04si.getSzCdPaymentDelivery());
    String cdSchoolDistrict = StringHelper.getNonNullString(cres04si.getSzCdSchoolDistrict());
    int sysIdPriorPerson = cres04si.getUlSysIdPriorPerson();
    Date dtRsrcUpdated = new Date();
    int ulUserId = Integer.parseInt(cres04si.getArchInputStruct().getSzUserId());
    
    // AUD the CAPS resource data

    // Do we need to delete capResouces? cres16d does not have any delete method.
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd))
    {
      // You must add a new address and phone number before saving a new resource.

      if (!cres04si.getROWCRES04SIG00_ARRAY().enumerateROWCRES04SIG00().hasMoreElements()
          || !cres04si.getROWCRES04SIG01_ARRAY().enumerateROWCRES04SIG01().hasMoreElements())
      {
        throw new ServiceException(Messages.MSG_RSRC_MUST_ADD);
      }
      
      idResource = commonDAO.getNextval("SEQ_CAPS_RESOURCE");
      // CallCRES16D
      if (ZERO == capsResourceDAO.insertCapsResource(idResource, nmResource, nmRsrcContact, cdRsrcFacilType,
                                                     nbrRsrcFacilAcclaim, cdRsrcType, cdRsrcCampusType,
                                                     nbrSchCampusNbr, cdMhmrCompCode, cdRsrcCertBy, cdRsrcOperBy,
                                                     cdRsrcSetting, cdRsrcPayment, nbrRsrcFacilCapacity,
                                                     cdRsrcMaintainer, cdRsrcOwnership, cdRsrcStatus, indRsrcTransport,
                                                     txtRsrcComments, cdRsrcHub, nmLegal, nmRsrcLastUpdate,
                                                     nmRsrcContactTitle, nbrRsrcNtnlProvider, cdAddrRsrcEmail,
                                                     cdAddrRsrcWebsite, cdSchoolType, cdPaymentDelivery,
                                                     cdSchoolDistrict))
      {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
      cres04so.setUlIdResource(idResource);
    }
    else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd))
    {
      // Get previous status of resource and compare with current status.
      // if status is move to inactive or close status send alerts

      CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResc(idResource);

      if (!capsResource.getCdRsrcStatus().equals(cdRsrcStatus)
          && (cdRsrcStatus.equals(CodesTables.CRSCSTAT_02) || cdRsrcStatus.equals(CodesTables.CRSCSTAT_03)))
      {

        List<Map> caseManagerList = placementDAO.findCaseManagerofFosterCareChildByResourceId(idResource);
        for (Iterator<Map> it = caseManagerList.iterator(); it.hasNext();)
        {
          Map placement = it.next();
          int idCaseManager = (Integer) placement.get("idPerson");
          int idStage = (Integer) placement.get("idStage");

          // Send an Alert to CaseManager
          createTodo(cdRsrcStatus, sysIdPriorPerson, capsResource, idCaseManager, idStage);

          // Send an Alert to Supervisor
          int idSupervisor = retrieveUnitSupervisorByCaseManagerId(idCaseManager).getIdPerson();
          createTodo(cdRsrcStatus, sysIdPriorPerson, capsResource, idSupervisor, idStage);
        }
      }
      CapsResource capsResc = capsResourceDAO.findCapsResourceByIdResc(idResource);
      
      // Set the resource facility capacity to zero if the database value is null
      Integer tempNbrRsrcFacilCapacity = capsResc.getNbrRsrcFacilCapacity();
      if (tempNbrRsrcFacilCapacity == null) {
        nbrRsrcFacilCapacity = 0;
      } else {  
        nbrRsrcFacilCapacity = tempNbrRsrcFacilCapacity;
      }
      
      // CallCRES16D
      if (ZERO == capsResourceDAO.updateCapsResource(nmResource, nmRsrcContact, cdRsrcFacilType, nbrRsrcFacilAcclaim,
                                                     cdRsrcType, cdRsrcCampusType, nbrSchCampusNbr, cdMhmrCompCode,
                                                     cdRsrcCertBy, cdRsrcOperBy, cdRsrcSetting, cdRsrcPayment,
                                                     nbrRsrcFacilCapacity, cdRsrcMaintainer, cdRsrcOwnership,
                                                     cdRsrcStatus, nmRsrcLastUpdate, indRsrcTransport, txtRsrcComments,
                                                     cdRsrcHub, nmLegal, idResource, tsLastUpdate, nmRsrcContactTitle,
                                                     nbrRsrcNtnlProvider, cdAddrRsrcEmail, cdAddrRsrcWebsite,
                                                     cdSchoolType, cdPaymentDelivery, cdSchoolDistrict))
      {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
      else
      {
        // code added by Srinivas to send the record to VendorOutbound Table
       //String VendorID = resourceAddressDAO.findResourceAddressVID(idResource);
        ROWCRES04SIG00_ARRAY rowcres04sog00_array2 = cres04si.getROWCRES04SIG00_ARRAY();
        ROWCRES04SIG01_ARRAY rowcres04sog01_array3 = cres04si.getROWCRES04SIG01_ARRAY();
        
        if((rowcres04sog00_array2 == null) && (rowcres04sog01_array3 == null))
        {
          int rsrcSntToSml = 0;
          rsrcSntToSml = vendorOutboundDAO.isRsrcSntToSmile(idResource) != null ? vendorOutboundDAO.isRsrcSntToSmile(idResource) : 0;
          
          //STGAP00011971 added call to determine if there is an active contract
          int intNumberContracts = 0;
          List<ContractPeriod> contractPeriodList = new ArrayList<ContractPeriod>(); 
          contractPeriodList = contractPeriodDAO.findListOfContractPeriodByIdResource(idResource); 
          intNumberContracts = contractPeriodList != null ? contractPeriodList.size() : 0;
          
          //Active resource with active contract
          boolean bActiveContract = (RSRC_ACTIVE.equals(cdRsrcStatus) && intNumberContracts >0);
          
          //Determine whether there is a current sent transaction without reply
          int iOpenRsrcSentToSml = 0;
          iOpenRsrcSentToSml = vendorOutboundDAO.isCurrentRsrcSntToSmile(idResource) != null ? vendorOutboundDAO.isCurrentRsrcSntToSmile(idResource) : 0;
          
          if((rsrcSntToSml != 0)||bActiveContract){  
                    
            String vendorID = resourceAddressDAO.findResourceAddressVID(idResource);          
            int vendorLength = 0;
            if(vendorID == null)
              vendorLength = 0;
            else
              vendorLength = vendorID.length();

            //If the name changed or the resource and contract are active and there is no pending transaction
            //send an update transaction
            
            if ( cres04si.getIndRsrcChanged()||(bActiveContract && (vendorLength==0) && iOpenRsrcSentToSml == 0))
            {
              if((vendorLength != 0)||bActiveContract){
              VendorOutboundSI vendorOutboundSI = new VendorOutboundSI();
              vendorOutboundSI.setRsrcNameFlag(true);
              vendorOutboundSI.setIdResource(idResource);            
              vendorOutboundSI.setNmResource(nmLegal);
              vendorOutboundSI.setNmRsrcContact(nmRsrcContact);
              vendorOutboundSI.setDtRsrcUpdated(dtRsrcUpdated);
              int idRsrcAddress = resourceAddressDAO.findIdResourceAddressByAddressTypeOnly(idResource);
              vendorOutboundSI.setIdRsrcAddr(idRsrcAddress);
              vendorOutboundSI.setUserId(ulUserId);
              saveVendorOutbound.saveNewVendor(vendorOutboundSI);
              }else{                
                //throw new ServiceException(Messages.MSG_VNDR_PEND);
                //throw new ServiceException(Messages.MSG_VID_REQ);
                throw new TempServiceException();
              }
              
            } //cres04si.getIndRsrcChanged() ends
          }
        }
      }// else ends
      cres04so.setUlIdResource(idResource);
    }
    else
    {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }

    // AUD the address data
    // CallCRES25D
    CapsResource capsResource = null;
    if (idResource != 0)
    {
      capsResource = getPersistentObject(CapsResource.class, idResource);
    }

    ROWCRES04SIG00_ARRAY rowcres04sog00_array = cres04si.getROWCRES04SIG00_ARRAY();
    if (rowcres04sog00_array != null)
    {
      Enumeration rowcres04sog00_enum = rowcres04sog00_array.enumerateROWCRES04SIG00();
      // Logic to be performed for every row in the list box
      while (rowcres04sog00_enum.hasMoreElements())
      {
        ROWCRES04SIG00 rowcres04sog00 = (ROWCRES04SIG00) rowcres04sog00_enum.nextElement();

        String dataAction = rowcres04sog00.getSzCdScrDataAction();

        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(dataAction))
        {
          
          ResourceAddress resourceAddress = new ResourceAddress();
          resourceAddress.setIdRsrcAddress(ZERO);
          resourceAddress.setIdRsrcAddress(rowcres04sog00.getUlIdRsrcAddress());
          resourceAddress.setNbrRsrcAddrVid(rowcres04sog00.getSzNbrRsrcAddrVid());
          Double x = (Double)rowcres04sog00.getNbrRsrcAddrLat() != null ? rowcres04sog00.getNbrRsrcAddrLat() : 0.0;
          Double y = (Double)rowcres04sog00.getNbrRsrcAddrLong() != null ? rowcres04sog00.getNbrRsrcAddrLong() : 0.0;
          resourceAddress.setNbrRsrcAddrLat(x);
          resourceAddress.setNbrRsrcAddrLong(y);
          resourceAddress.setCdRsrcAddrType(rowcres04sog00.getSzCdRsrcAddrType());
          resourceAddress.setCdRsrcAddrSchDist(rowcres04sog00.getSzCdRsrcAddrSchDist());
          resourceAddress.setAddrRsrcAddrStLn1(rowcres04sog00.getSzAddrRsrcAddrStLn1());
          resourceAddress.setAddrRsrcAddrStLn2(rowcres04sog00.getSzAddrRsrcAddrStLn2());
          resourceAddress.setAddrRsrcAddrAttn(rowcres04sog00.getSzAddrRsrcAddrAttn());
          resourceAddress.setAddrRsrcAddrCity(rowcres04sog00.getSzAddrRsrcAddrCity());
          resourceAddress.setCdRsrcAddrState(rowcres04sog00.getSzCdFacilityState());
          resourceAddress.setAddrRsrcAddrZip(rowcres04sog00.getSzAddrRsrcAddrZip());
          resourceAddress.setCdRsrcAddrCounty(rowcres04sog00.getSzAddrRsrcAddrCounty());
          resourceAddress.setTxtRsrcAddrComments(rowcres04sog00.getSzTxtRsrcAddrComments());
          resourceAddress.setDtLastUpdate(rowcres04sog00.getTsLastUpdate());
          resourceAddress.setCapsResource(capsResource);
          resourceAddressDAO.saveResourceAddress(resourceAddress);

          if (resourceAddress.getIdRsrcAddress() == ZERO)
          {
            throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          }

        } 
        else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(dataAction))
        {
          //retrieve resource address from state
          ResourceAddress resourceAddress = getPersistentObject(ResourceAddress.class, rowcres04sog00.getUlIdRsrcAddress());
          resourceAddress.setNbrRsrcAddrVid(rowcres04sog00.getSzNbrRsrcAddrVid());
          Double x = (Double)rowcres04sog00.getNbrRsrcAddrLat() != null ? rowcres04sog00.getNbrRsrcAddrLat() : 0.0;
          Double y = (Double)rowcres04sog00.getNbrRsrcAddrLong() != null ? rowcres04sog00.getNbrRsrcAddrLong() : 0.0;
          resourceAddress.setNbrRsrcAddrLat(x);
          resourceAddress.setNbrRsrcAddrLong(y);
          resourceAddress.setCdRsrcAddrType(rowcres04sog00.getSzCdRsrcAddrType());
          resourceAddress.setCdRsrcAddrSchDist(rowcres04sog00.getSzCdRsrcAddrSchDist());
          resourceAddress.setAddrRsrcAddrStLn1(rowcres04sog00.getSzAddrRsrcAddrStLn1());
          resourceAddress.setAddrRsrcAddrStLn2(rowcres04sog00.getSzAddrRsrcAddrStLn2());
          resourceAddress.setAddrRsrcAddrAttn(rowcres04sog00.getSzAddrRsrcAddrAttn());
          resourceAddress.setAddrRsrcAddrCity(rowcres04sog00.getSzAddrRsrcAddrCity());
          resourceAddress.setCdRsrcAddrState(rowcres04sog00.getSzCdFacilityState());
          resourceAddress.setAddrRsrcAddrZip(rowcres04sog00.getSzAddrRsrcAddrZip());
          resourceAddress.setCdRsrcAddrCounty(rowcres04sog00.getSzAddrRsrcAddrCounty());
          resourceAddress.setTxtRsrcAddrComments(rowcres04sog00.getSzTxtRsrcAddrComments());
          resourceAddress.setDtLastUpdate(rowcres04sog00.getTsLastUpdate());
          resourceAddress.setCapsResource(capsResource);
          resourceAddressDAO.saveResourceAddress(resourceAddress);
          
          // STGAP00017058 - if the vendorID has been changed, update the invoice record
          if (resourceAddress.getNbrRsrcAddrVid() != null && ServiceConstants.FND_YES.equals(cres04si.getBIndReview())){
            List<ResourceAddress> resourceAddressList = resourceAddressDAO.findResourceAddressByIdResource(resourceAddress.getCapsResource().getIdResource());
            for(ResourceAddress resourceAddr : resourceAddressList){
              resourceAddr.setNbrRsrcAddrVid(rowcres04sog00.getSzNbrRsrcAddrVid());
              resourceAddressDAO.saveResourceAddress(resourceAddr);
              invoiceDAO.updateInvoiceNbrInvoVid(resourceAddr.getNbrRsrcAddrVid(), resourceAddr.getIdRsrcAddress());
            }
          }
          
          /**
           * Follwing code comes into effect when the user is trying to change the resource primary address
           * where the resource is already referred to SMILE. If VendorID is not yet assigned by SMILE
           * the error message will be displayed on screen
           */
          int rsrcSntToSml = 0;
          rsrcSntToSml = vendorOutboundDAO.isRsrcSntToSmile(idResource) != null ? vendorOutboundDAO.isRsrcSntToSmile(idResource) : 0;
          
          //STGAP00011971 added call to determine if there is an active contract
          int intNumberContracts = 0;
          List<ContractPeriod> contractPeriodList = new ArrayList<ContractPeriod>(); 
          contractPeriodList = contractPeriodDAO.findListOfContractPeriodByIdResource(idResource); 
          intNumberContracts = contractPeriodList != null ? contractPeriodList.size() : 0;
          
          boolean bActiveContract = (RSRC_ACTIVE.equals(cdRsrcStatus) && intNumberContracts >0);
          
          //Send update if active contract, even if no VID and not sent originally through interface
          if((rsrcSntToSml != 0)||bActiveContract){       
          String vendorID = resourceAddress.getNbrRsrcAddrVid();
          //String vendorID = "22222";
          int vendorLength = 0;
          if(vendorID == null)
            vendorLength = 0;
          else
            vendorLength = vendorID.length();
          if(cres04si.isIndAddrChanged()){
          
          if ((vendorLength != 0)||bActiveContract)
          {
            VendorOutboundSI vendorOutboundSI = new VendorOutboundSI();
            vendorOutboundSI.setAddressFlag(true);
            vendorOutboundSI.setAddrRsrcStLn1(resourceAddress.getAddrRsrcAddrStLn1());
            vendorOutboundSI.setAddrRsrcStLn2(resourceAddress.getAddrRsrcAddrStLn2());
            vendorOutboundSI.setAddrRsrcCity(resourceAddress.getAddrRsrcAddrCity());
            vendorOutboundSI.setAddrRsrcZip(resourceAddress.getAddrRsrcAddrZip());
            vendorOutboundSI.setCdRsrcState(resourceAddress.getCdRsrcAddrState());
            vendorOutboundSI.setIdRsrcAddr(resourceAddress.getIdRsrcAddress());
            vendorOutboundSI.setIdResource(idResource);
            vendorOutboundSI.setDtRsrcUpdated(dtRsrcUpdated);
            vendorOutboundSI.setUserId(ulUserId);
            saveVendorOutbound.saveNewVendor(vendorOutboundSI);
            
            if (resourceAddress.getNbrRsrcAddrVid() != null) 
            {
              // caudc6dAUDdam;
              invoiceDAO.updateInvoiceNbrInvoVid(resourceAddress.getNbrRsrcAddrVid(), resourceAddress.getIdRsrcAddress());
            }
          }
          else{
             //throw new ServiceException(Messages.MSG_VNDR_PEND);
            //throw new ServiceException(Messages.MSG_VID_REQ);
            throw new TempServiceException();
          }
          }
            
        }
        }
        else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(dataAction))
        {
          //load address into state
          ResourceAddress resourceAddress2 = getPersistentObject(ResourceAddress.class, rowcres04sog00.getUlIdRsrcAddress());
          resourceAddressDAO.deleteResourceAddress(resourceAddress2);
        }
        else
        {
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
      }
    }
    // AUD the phone data
    // CallCRES26D
    ROWCRES04SIG01_ARRAY rowcres04sog01_array = cres04si.getROWCRES04SIG01_ARRAY();

    if (rowcres04sog01_array != null) {
      Enumeration rowcres04sog01_enum = rowcres04sog01_array.enumerateROWCRES04SIG01();
      // Logic to be performed for every row in the list box
      while (rowcres04sog01_enum.hasMoreElements()) {
        ROWCRES04SIG01 rowcres04sog01 = (ROWCRES04SIG01) rowcres04sog01_enum.nextElement();

        String dataAction = rowcres04sog01.getSzCdScrDataAction();

        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(dataAction)) {
          ResourcePhone resourcePhone = new ResourcePhone();
          resourcePhone.setIdRsrcPhone(ZERO);
          resourcePhone.setCdRsrcPhoneType(rowcres04sog01.getSzCdFacilPhoneType());
          resourcePhone.setNbrRsrcPhone(rowcres04sog01.getLNbrFacilPhoneNumber());
          resourcePhone.setNbrRsrcPhoneExt(rowcres04sog01.getLNbrFacilPhoneExtension());
          resourcePhone.setTxtRsrcPhoneComments(rowcres04sog01.getSzTxtRsrcPhoneComments());
          resourcePhone.setCapsResource(capsResource);
          resourcePhone.setDtLastUpdate(rowcres04sog01.getTsLastUpdate());
          resourcePhoneDAO.saveResourcePhone(resourcePhone);
          
          /**
           * Following code comes into effect when the user is trying to create a new fax or phone
           * if the resource is already referred to SMILE and Vendor ID is not yet assigned by SMILE
           * The error message will be displayed on screen.
           */
          int rsrcSntToSml = 0;
          rsrcSntToSml = vendorOutboundDAO.isRsrcSntToSmile(idResource) != null ? vendorOutboundDAO.isRsrcSntToSmile(idResource) : 0;
          
          //STGAP00011971 added call to determine if there is an active contract
          int intNumberContracts = 0;
          List<ContractPeriod> contractPeriodList = new ArrayList<ContractPeriod>(); 
          contractPeriodList = contractPeriodDAO.findListOfContractPeriodByIdResource(idResource); 
          intNumberContracts = contractPeriodList != null ? contractPeriodList.size() : 0;
          
          boolean bActiveContract = (RSRC_ACTIVE.equals(cdRsrcStatus) && intNumberContracts >0);
          
          //Perform the update to Vendor Outbound if active contract, even without VID or previous row
          if((rsrcSntToSml != 0)||bActiveContract){
            
            int idRsrcAddress = resourceAddressDAO.findIdResourceAddressByAddressTypeOnly(idResource);
            String vendorID = resourceAddressDAO.findResourceAddressVID(idResource);
            if((vendorID == null) &&!bActiveContract){
              //throw new ServiceException(Messages.MSG_VNDR_PEND);
             //  throw new ServiceException(Messages.MSG_VID_REQ);
              throw new TempServiceException();
            }
             else{
               VendorOutboundSI vendorOutboundSI = new VendorOutboundSI();
              if ( FAX_TYPE.equals(resourcePhone.getCdRsrcPhoneType()) || (FAX2_TYPE.equals(resourcePhone.getCdRsrcPhoneType())
                              && (idRsrcAddress != 0)))
                         {
                           vendorOutboundSI.setFaxFlag(true);
                           vendorOutboundSI.setNbrRsrcFax(resourcePhone.getNbrRsrcPhone());
                           vendorOutboundSI.setNbrRsrcFaxExt(resourcePhone.getNbrRsrcPhoneExt());
                           vendorOutboundSI.setDtRsrcUpdated(dtRsrcUpdated);
                           vendorOutboundSI.setIdResource(idResource);
                           vendorOutboundSI.setIdRsrcAddr(idRsrcAddress);
                           vendorOutboundSI.setUserId(ulUserId);
                           saveVendorOutbound.saveNewVendor(vendorOutboundSI);                           
                         }               
            }  
            
          }

          if (ZERO == resourcePhone.getIdRsrcPhone()) {
            throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          }
        } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(dataAction)) {
          //load phone into state
          ResourcePhone resourcePhone = getPersistentObject(ResourcePhone.class, rowcres04sog01.getUlIdRsrcPhone());
          resourcePhone.setCdRsrcPhoneType(rowcres04sog01.getSzCdFacilPhoneType());
          resourcePhone.setNbrRsrcPhone(rowcres04sog01.getLNbrFacilPhoneNumber());
          resourcePhone.setNbrRsrcPhoneExt(rowcres04sog01.getLNbrFacilPhoneExtension());
          resourcePhone.setTxtRsrcPhoneComments(rowcres04sog01.getSzTxtRsrcPhoneComments());
          resourcePhone.setCapsResource(capsResource);
          resourcePhone.setDtLastUpdate(rowcres04sog01.getTsLastUpdate());
          resourcePhoneDAO.saveResourcePhone(resourcePhone);
          
          /**
           * Following code comes into effect when the User is trying to change either phone 
           * or fax related to resource that is already referred to SMILE. If Vendor is not
           * yet assigned by SMILE the error message will be displayed else resource details
           * will be inserted into VENDOR_OUTBOUND table under modified record.
           */
          
          int rsrcSntToSml = 0;
          rsrcSntToSml = vendorOutboundDAO.isRsrcSntToSmile(idResource) != null ? vendorOutboundDAO.isRsrcSntToSmile(idResource) : 0;
          
          //STGAP00011971 added call to determine if there is an active contract
          int intNumberContracts = 0;
          List<ContractPeriod> contractPeriodList = new ArrayList<ContractPeriod>(); 
          contractPeriodList = contractPeriodDAO.findListOfContractPeriodByIdResource(idResource); 
          intNumberContracts = contractPeriodList != null ? contractPeriodList.size() : 0;
          
          boolean bActiveContract = (RSRC_ACTIVE.equals(cdRsrcStatus) && intNumberContracts >0);
          
          if((rsrcSntToSml != 0)||bActiveContract){
            
            if(cres04si.isIndPhoneChanged()){
          
          int idRsrcAddress = resourceAddressDAO.findIdResourceAddressByAddressTypeOnly(idResource);
            String vendorID = resourceAddressDAO.findResourceAddressVID(idResource);
            //String vendorID = "22222";
            int vendorLength = 0;
            if((vendorID == null)&&!bActiveContract){
                 vendorLength = 0;
                 //throw new ServiceException(Messages.MSG_VNDR_PEND);
                 //throw new ServiceException(Messages.MSG_VID_REQ);
                 throw new TempServiceException();
            }
            else
              vendorLength = vendorID != null ? vendorID.length(): 0;
            VendorOutboundSI vendorOutboundSI = new VendorOutboundSI();
            if ( (PHONE_TYPE.equals(resourcePhone.getCdRsrcPhoneType())) && 
                 (idRsrcAddress != 0) && 
                 ((vendorLength != 0)||bActiveContract) )
            {
              vendorOutboundSI.setPhoneFlag(true);
              vendorOutboundSI.setNbrRsrcPhn(resourcePhone.getNbrRsrcPhone());
              vendorOutboundSI.setNbrRsrcPhoneExt(resourcePhone.getNbrRsrcPhoneExt());
              vendorOutboundSI.setDtRsrcUpdated(dtRsrcUpdated);
              vendorOutboundSI.setIdResource(idResource);
              vendorOutboundSI.setIdRsrcAddr(idRsrcAddress);
              vendorOutboundSI.setUserId(ulUserId);
              saveVendorOutbound.saveNewVendor(vendorOutboundSI);
              
            } 
            else if ( (idRsrcAddress != 0)      && 
                      ((vendorLength != 0)||bActiveContract)       && 
                      (FAX_TYPE.equals(resourcePhone.getCdRsrcPhoneType()) || (FAX2_TYPE.equals(resourcePhone.getCdRsrcPhoneType())))) 
            {

              vendorOutboundSI.setFaxFlag(true);
              vendorOutboundSI.setNbrRsrcFax(resourcePhone.getNbrRsrcPhone());
              vendorOutboundSI.setNbrRsrcFaxExt(resourcePhone.getNbrRsrcPhoneExt());
              vendorOutboundSI.setDtRsrcUpdated(dtRsrcUpdated);
              vendorOutboundSI.setIdResource(idResource);
              vendorOutboundSI.setIdRsrcAddr(idRsrcAddress);
              vendorOutboundSI.setUserId(ulUserId);
              saveVendorOutbound.saveNewVendor(vendorOutboundSI);

            }
          }
          }
        } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(dataAction)) {
          //load phone into state
          ResourcePhone resourcePhone = getPersistentObject(ResourcePhone.class, rowcres04sog01.getUlIdRsrcPhone());
          
          resourcePhoneDAO.deleteResourcePhone(resourcePhone);

        } else {

        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
          
        }

      }
    }
    return cres04so;
  }

  private void createTodo(String cdRsrcStatus, int sysIdPriorPerson, CapsResource capsResource, int idCaseManager,
                          int idStage) {
    Todo todo = new Todo();
    todo.setCdTodoTask("");
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoTaskDue(null);
    todo.setDtTodoCreated(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setDtTodoCompleted(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setDtTodoDue(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setTxtTodoDesc(capsResource.getNmResource() + " status has changed to "
                        + Lookup.simpleDecodeSafe(CodesTables.CRSCSTAT, cdRsrcStatus));
    todo.setTxtTodoLongDesc("");

    Person persAssign = getPersistentObject(Person.class, idCaseManager);
    todo.setPersonByIdTodoPersAssigned(persAssign);
    
    //STGAP00009378 - put in check to insert null persWorker object if sysIdPriorPerson = 0.
    Person persWorker = null;
    
    if(sysIdPriorPerson != 0){
      persWorker = getPersistentObject(Person.class, sysIdPriorPerson);
    }
    todo.setPersonByIdTodoPersWorker(persWorker);

    CapsCase capsCase = null;
    todo.setCapsCase(capsCase);
    todo.setIdTodo(0);

    Stage stage = getPersistentObject(Stage.class, idStage);
    todo.setStage(stage);
    // Send Alert to Case Manager
    todoDAO.saveTodo(todo);
  }

  private Person retrieveUnitSupervisorByCaseManagerId(int idPerson) {
    // ccmn60d
    Map resultMap = unitEmpLinkDAO.findNmPersonFullAndIdPersonByIdPersonAndCdUnitMemberIn(idPerson);
    Integer idSupervisor = null;
    if ((resultMap != null) && (resultMap.size() > ZERO)) {
      idSupervisor = (Integer) resultMap.get("idPerson");
    }
    if (idSupervisor == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return getPersistentObject(Person.class, idSupervisor);
  }
  
  private static class TempServiceException extends ServiceException {
    @Override
    public int getErrorCode() {
      return Integer.MAX_VALUE;
    }
    
    @Override
    public String getErrorMessage() {
      return MSG_VID_REQ;
    }
  }
  
  private static final String RSRC_ACTIVE = CodesTables.CRSCSTAT_01;
  
}
