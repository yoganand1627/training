/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.5</a>, using an XML
 * Schema.
 * $Id$
 */

package gov.georgia.dhr.dfcs.sacwis.structs.input;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class CCON19SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCON19SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archInputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct _archInputStruct;

    /**
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _ulIdSvcAuth
     */
    private int _ulIdSvcAuth;

    /**
     * keeps track of state for field: _ulIdSvcAuth
     */
    private boolean _has_ulIdSvcAuth;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _ulIdCntrctManager
     */
    private int _ulIdCntrctManager;

    /**
     * keeps track of state for field: _ulIdCntrctManager
     */
    private boolean _has_ulIdCntrctManager;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ldIdTodo
     */
    private int _ldIdTodo;

    /**
     * keeps track of state for field: _ldIdTodo
     */
    private boolean _has_ldIdTodo;

    /**
     * Field _ulIdPrimaryClient
     */
    private int _ulIdPrimaryClient;

    /**
     * keeps track of state for field: _ulIdPrimaryClient
     */
    private boolean _has_ulIdPrimaryClient;

    /**
     * Field _szCdEventStatus
     */
    private java.lang.String _szCdEventStatus;

    /**
     * Field _szCdUnitProgram
     */
    private java.lang.String _szCdUnitProgram;

    /**
     * Field _szTxtSvcAuthComments
     */
    private java.lang.String _szTxtSvcAuthComments;

    /**
     * Field _szTxtSvcAuthSecProvdr
     */
    private java.lang.String _szTxtSvcAuthSecProvdr;

    /**
     * Field _cIndSvcAuthComplete
     */
    private java.lang.String _cIndSvcAuthComplete;

    /**
     * Field _szCdSvcAuthRegion
     */
    private java.lang.String _szCdSvcAuthRegion;

    /**
     * Field _szCdSvcAuthService
     */
    private java.lang.String _szCdSvcAuthService;

    /**
     * Field _szCdSvcAuthCategory
     */
    private java.lang.String _szCdSvcAuthCategory;

    /**
     * Field _szCdSvcAuthCounty
     */
    private java.lang.String _szCdSvcAuthCounty;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _bScrIndFrstTmComp
     */
    private java.lang.String _bScrIndFrstTmComp;

    /**
     * Field _bScrIndAuthDiffRegion
     */
    private java.lang.String _bScrIndAuthDiffRegion;

    /**
     * Field _ulIdPersonPrincipal
     */
    private int _ulIdPersonPrincipal;

    /**
     * keeps track of state for field: _ulIdPersonPrincipal
     */
    private boolean _has_ulIdPersonPrincipal;

    /**
     * Field _dtDtSvcAuthEff
     */
    private org.exolab.castor.types.Date _dtDtSvcAuthEff;

    /**
     * Field _cIndDntdCmmtySvc
     */
    private java.lang.String _cIndDntdCmmtySvc;

    /**
     * Field _szCdPayCnty
     */
    private java.lang.String _szCdPayCnty;

    /**
     * Field _cIndWaiverReqd
     */
    private java.lang.String _cIndWaiverReqd;

    /**
     * Field _dtDtRefSent
     */
    private org.exolab.castor.types.Date _dtDtRefSent;

    /**
     * Field _szCdErlyCaseTyp
     */
    private java.lang.String _szCdErlyCaseTyp;

    /**
     * Field _szCdPupTyp
     */
    private java.lang.String _szCdPupTyp;

    /**
     * Field _szCdPupOtcme
     */
    private java.lang.String _szCdPupOtcme;

    /**
     * Field _ulIdWaiver
     */
    private int _ulIdWaiver;

    /**
     * keeps track of state for field: _ulIdWaiver
     */
    private boolean _has_ulIdWaiver;

    /**
     * Field _szTxtSvcAmtAuthd
     */
    private double _szTxtSvcAmtAuthd;

    /**
     * keeps track of state for field: _szTxtSvcAmtAuthd
     */
    private boolean _has_szTxtSvcAmtAuthd;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCON19SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON19SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLdIdTodo()
    {
        this._has_ldIdTodo= false;
    } //-- void deleteLdIdTodo() 

    /**
     */
    public void deleteSzTxtSvcAmtAuthd()
    {
        this._has_szTxtSvcAmtAuthd= false;
    } //-- void deleteSzTxtSvcAmtAuthd() 

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

    /**
     */
    public void deleteUlIdCntrctManager()
    {
        this._has_ulIdCntrctManager= false;
    } //-- void deleteUlIdCntrctManager() 

    /**
     */
    public void deleteUlIdContract()
    {
        this._has_ulIdContract= false;
    } //-- void deleteUlIdContract() 

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

    /**
     */
    public void deleteUlIdPersonPrincipal()
    {
        this._has_ulIdPersonPrincipal= false;
    } //-- void deleteUlIdPersonPrincipal() 

    /**
     */
    public void deleteUlIdPrimaryClient()
    {
        this._has_ulIdPrimaryClient= false;
    } //-- void deleteUlIdPrimaryClient() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlIdSvcAuth()
    {
        this._has_ulIdSvcAuth= false;
    } //-- void deleteUlIdSvcAuth() 

    /**
     */
    public void deleteUlIdWaiver()
    {
        this._has_ulIdWaiver= false;
    } //-- void deleteUlIdWaiver() 

    /**
     * Returns the value of field 'archInputStruct'.
     * 
     * @return the value of field 'ArchInputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct()
    {
        return this._archInputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct() 

    /**
     * Returns the value of field 'bScrIndAuthDiffRegion'.
     * 
     * @return the value of field 'BScrIndAuthDiffRegion'.
     */
    public java.lang.String getBScrIndAuthDiffRegion()
    {
        return this._bScrIndAuthDiffRegion;
    } //-- java.lang.String getBScrIndAuthDiffRegion() 

    /**
     * Returns the value of field 'bScrIndFrstTmComp'.
     * 
     * @return the value of field 'BScrIndFrstTmComp'.
     */
    public java.lang.String getBScrIndFrstTmComp()
    {
        return this._bScrIndFrstTmComp;
    } //-- java.lang.String getBScrIndFrstTmComp() 

    /**
     * Returns the value of field 'cIndDntdCmmtySvc'.
     * 
     * @return the value of field 'CIndDntdCmmtySvc'.
     */
    public java.lang.String getCIndDntdCmmtySvc()
    {
        return this._cIndDntdCmmtySvc;
    } //-- java.lang.String getCIndDntdCmmtySvc() 

    /**
     * Returns the value of field 'cIndSvcAuthComplete'.
     * 
     * @return the value of field 'CIndSvcAuthComplete'.
     */
    public java.lang.String getCIndSvcAuthComplete()
    {
        return this._cIndSvcAuthComplete;
    } //-- java.lang.String getCIndSvcAuthComplete() 

    /**
     * Returns the value of field 'cIndWaiverReqd'.
     * 
     * @return the value of field 'CIndWaiverReqd'.
     */
    public java.lang.String getCIndWaiverReqd()
    {
        return this._cIndWaiverReqd;
    } //-- java.lang.String getCIndWaiverReqd() 

    /**
     * Returns the value of field 'dtDtRefSent'.
     * 
     * @return the value of field 'DtDtRefSent'.
     */
    public org.exolab.castor.types.Date getDtDtRefSent()
    {
        return this._dtDtRefSent;
    } //-- org.exolab.castor.types.Date getDtDtRefSent() 

    /**
     * Returns the value of field 'dtDtSvcAuthEff'.
     * 
     * @return the value of field 'DtDtSvcAuthEff'.
     */
    public org.exolab.castor.types.Date getDtDtSvcAuthEff()
    {
        return this._dtDtSvcAuthEff;
    } //-- org.exolab.castor.types.Date getDtDtSvcAuthEff() 

    /**
     * Returns the value of field 'ldIdTodo'.
     * 
     * @return the value of field 'LdIdTodo'.
     */
    public int getLdIdTodo()
    {
        return this._ldIdTodo;
    } //-- int getLdIdTodo() 

    /**
     * Returns the value of field 'ROWCCMN01UIG00'.
     * 
     * @return the value of field 'ROWCCMN01UIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00()
    {
        return this._ROWCCMN01UIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00() 

    /**
     * Returns the value of field 'szCdErlyCaseTyp'.
     * 
     * @return the value of field 'SzCdErlyCaseTyp'.
     */
    public java.lang.String getSzCdErlyCaseTyp()
    {
        return this._szCdErlyCaseTyp;
    } //-- java.lang.String getSzCdErlyCaseTyp() 

    /**
     * Returns the value of field 'szCdEventStatus'.
     * 
     * @return the value of field 'SzCdEventStatus'.
     */
    public java.lang.String getSzCdEventStatus()
    {
        return this._szCdEventStatus;
    } //-- java.lang.String getSzCdEventStatus() 

    /**
     * Returns the value of field 'szCdPayCnty'.
     * 
     * @return the value of field 'SzCdPayCnty'.
     */
    public java.lang.String getSzCdPayCnty()
    {
        return this._szCdPayCnty;
    } //-- java.lang.String getSzCdPayCnty() 

    /**
     * Returns the value of field 'szCdPupOtcme'.
     * 
     * @return the value of field 'SzCdPupOtcme'.
     */
    public java.lang.String getSzCdPupOtcme()
    {
        return this._szCdPupOtcme;
    } //-- java.lang.String getSzCdPupOtcme() 

    /**
     * Returns the value of field 'szCdPupTyp'.
     * 
     * @return the value of field 'SzCdPupTyp'.
     */
    public java.lang.String getSzCdPupTyp()
    {
        return this._szCdPupTyp;
    } //-- java.lang.String getSzCdPupTyp() 

    /**
     * Returns the value of field 'szCdSvcAuthCategory'.
     * 
     * @return the value of field 'SzCdSvcAuthCategory'.
     */
    public java.lang.String getSzCdSvcAuthCategory()
    {
        return this._szCdSvcAuthCategory;
    } //-- java.lang.String getSzCdSvcAuthCategory() 

    /**
     * Returns the value of field 'szCdSvcAuthCounty'.
     * 
     * @return the value of field 'SzCdSvcAuthCounty'.
     */
    public java.lang.String getSzCdSvcAuthCounty()
    {
        return this._szCdSvcAuthCounty;
    } //-- java.lang.String getSzCdSvcAuthCounty() 

    /**
     * Returns the value of field 'szCdSvcAuthRegion'.
     * 
     * @return the value of field 'SzCdSvcAuthRegion'.
     */
    public java.lang.String getSzCdSvcAuthRegion()
    {
        return this._szCdSvcAuthRegion;
    } //-- java.lang.String getSzCdSvcAuthRegion() 

    /**
     * Returns the value of field 'szCdSvcAuthService'.
     * 
     * @return the value of field 'SzCdSvcAuthService'.
     */
    public java.lang.String getSzCdSvcAuthService()
    {
        return this._szCdSvcAuthService;
    } //-- java.lang.String getSzCdSvcAuthService() 

    /**
     * Returns the value of field 'szCdUnitProgram'.
     * 
     * @return the value of field 'SzCdUnitProgram'.
     */
    public java.lang.String getSzCdUnitProgram()
    {
        return this._szCdUnitProgram;
    } //-- java.lang.String getSzCdUnitProgram() 

    /**
     * Returns the value of field 'szTxtSvcAmtAuthd'.
     * 
     * @return the value of field 'SzTxtSvcAmtAuthd'.
     */
    public double getSzTxtSvcAmtAuthd()
    {
        return this._szTxtSvcAmtAuthd;
    } //-- double getSzTxtSvcAmtAuthd() 

    /**
     * Returns the value of field 'szTxtSvcAuthComments'.
     * 
     * @return the value of field 'SzTxtSvcAuthComments'.
     */
    public java.lang.String getSzTxtSvcAuthComments()
    {
        return this._szTxtSvcAuthComments;
    } //-- java.lang.String getSzTxtSvcAuthComments() 

    /**
     * Returns the value of field 'szTxtSvcAuthSecProvdr'.
     * 
     * @return the value of field 'SzTxtSvcAuthSecProvdr'.
     */
    public java.lang.String getSzTxtSvcAuthSecProvdr()
    {
        return this._szTxtSvcAuthSecProvdr;
    } //-- java.lang.String getSzTxtSvcAuthSecProvdr() 

    /**
     * Returns the value of field 'tsLastUpdate'.
     * 
     * @return the value of field 'TsLastUpdate'.
     */
    public java.util.Date getTsLastUpdate()
    {
        return this._tsLastUpdate;
    } //-- java.util.Date getTsLastUpdate() 

    /**
     * Returns the value of field 'ulIdCase'.
     * 
     * @return the value of field 'UlIdCase'.
     */
    public int getUlIdCase()
    {
        return this._ulIdCase;
    } //-- int getUlIdCase() 

    /**
     * Returns the value of field 'ulIdCntrctManager'.
     * 
     * @return the value of field 'UlIdCntrctManager'.
     */
    public int getUlIdCntrctManager()
    {
        return this._ulIdCntrctManager;
    } //-- int getUlIdCntrctManager() 

    /**
     * Returns the value of field 'ulIdContract'.
     * 
     * @return the value of field 'UlIdContract'.
     */
    public int getUlIdContract()
    {
        return this._ulIdContract;
    } //-- int getUlIdContract() 

    /**
     * Returns the value of field 'ulIdEvent'.
     * 
     * @return the value of field 'UlIdEvent'.
     */
    public int getUlIdEvent()
    {
        return this._ulIdEvent;
    } //-- int getUlIdEvent() 

    /**
     * Returns the value of field 'ulIdPersonPrincipal'.
     * 
     * @return the value of field 'UlIdPersonPrincipal'.
     */
    public int getUlIdPersonPrincipal()
    {
        return this._ulIdPersonPrincipal;
    } //-- int getUlIdPersonPrincipal() 

    /**
     * Returns the value of field 'ulIdPrimaryClient'.
     * 
     * @return the value of field 'UlIdPrimaryClient'.
     */
    public int getUlIdPrimaryClient()
    {
        return this._ulIdPrimaryClient;
    } //-- int getUlIdPrimaryClient() 

    /**
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Returns the value of field 'ulIdSvcAuth'.
     * 
     * @return the value of field 'UlIdSvcAuth'.
     */
    public int getUlIdSvcAuth()
    {
        return this._ulIdSvcAuth;
    } //-- int getUlIdSvcAuth() 

    /**
     * Returns the value of field 'ulIdWaiver'.
     * 
     * @return the value of field 'UlIdWaiver'.
     */
    public int getUlIdWaiver()
    {
        return this._ulIdWaiver;
    } //-- int getUlIdWaiver() 

    /**
     * Method hasLdIdTodo
     * 
     * 
     * 
     * @return true if at least one LdIdTodo has been added
     */
    public boolean hasLdIdTodo()
    {
        return this._has_ldIdTodo;
    } //-- boolean hasLdIdTodo() 

    /**
     * Method hasSzTxtSvcAmtAuthd
     * 
     * 
     * 
     * @return true if at least one SzTxtSvcAmtAuthd has been added
     */
    public boolean hasSzTxtSvcAmtAuthd()
    {
        return this._has_szTxtSvcAmtAuthd;
    } //-- boolean hasSzTxtSvcAmtAuthd() 

    /**
     * Method hasUlIdCase
     * 
     * 
     * 
     * @return true if at least one UlIdCase has been added
     */
    public boolean hasUlIdCase()
    {
        return this._has_ulIdCase;
    } //-- boolean hasUlIdCase() 

    /**
     * Method hasUlIdCntrctManager
     * 
     * 
     * 
     * @return true if at least one UlIdCntrctManager has been added
     */
    public boolean hasUlIdCntrctManager()
    {
        return this._has_ulIdCntrctManager;
    } //-- boolean hasUlIdCntrctManager() 

    /**
     * Method hasUlIdContract
     * 
     * 
     * 
     * @return true if at least one UlIdContract has been added
     */
    public boolean hasUlIdContract()
    {
        return this._has_ulIdContract;
    } //-- boolean hasUlIdContract() 

    /**
     * Method hasUlIdEvent
     * 
     * 
     * 
     * @return true if at least one UlIdEvent has been added
     */
    public boolean hasUlIdEvent()
    {
        return this._has_ulIdEvent;
    } //-- boolean hasUlIdEvent() 

    /**
     * Method hasUlIdPersonPrincipal
     * 
     * 
     * 
     * @return true if at least one UlIdPersonPrincipal has been
     * added
     */
    public boolean hasUlIdPersonPrincipal()
    {
        return this._has_ulIdPersonPrincipal;
    } //-- boolean hasUlIdPersonPrincipal() 

    /**
     * Method hasUlIdPrimaryClient
     * 
     * 
     * 
     * @return true if at least one UlIdPrimaryClient has been added
     */
    public boolean hasUlIdPrimaryClient()
    {
        return this._has_ulIdPrimaryClient;
    } //-- boolean hasUlIdPrimaryClient() 

    /**
     * Method hasUlIdResource
     * 
     * 
     * 
     * @return true if at least one UlIdResource has been added
     */
    public boolean hasUlIdResource()
    {
        return this._has_ulIdResource;
    } //-- boolean hasUlIdResource() 

    /**
     * Method hasUlIdSvcAuth
     * 
     * 
     * 
     * @return true if at least one UlIdSvcAuth has been added
     */
    public boolean hasUlIdSvcAuth()
    {
        return this._has_ulIdSvcAuth;
    } //-- boolean hasUlIdSvcAuth() 

    /**
     * Method hasUlIdWaiver
     * 
     * 
     * 
     * @return true if at least one UlIdWaiver has been added
     */
    public boolean hasUlIdWaiver()
    {
        return this._has_ulIdWaiver;
    } //-- boolean hasUlIdWaiver() 

    /**
     * Method isValid
     * 
     * 
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

    /**
     * Sets the value of field 'bScrIndAuthDiffRegion'.
     * 
     * @param bScrIndAuthDiffRegion the value of field
     * 'bScrIndAuthDiffRegion'.
     */
    public void setBScrIndAuthDiffRegion(java.lang.String bScrIndAuthDiffRegion)
    {
        this._bScrIndAuthDiffRegion = bScrIndAuthDiffRegion;
    } //-- void setBScrIndAuthDiffRegion(java.lang.String) 

    /**
     * Sets the value of field 'bScrIndFrstTmComp'.
     * 
     * @param bScrIndFrstTmComp the value of field
     * 'bScrIndFrstTmComp'.
     */
    public void setBScrIndFrstTmComp(java.lang.String bScrIndFrstTmComp)
    {
        this._bScrIndFrstTmComp = bScrIndFrstTmComp;
    } //-- void setBScrIndFrstTmComp(java.lang.String) 

    /**
     * Sets the value of field 'cIndDntdCmmtySvc'.
     * 
     * @param cIndDntdCmmtySvc the value of field 'cIndDntdCmmtySvc'
     */
    public void setCIndDntdCmmtySvc(java.lang.String cIndDntdCmmtySvc)
    {
        this._cIndDntdCmmtySvc = cIndDntdCmmtySvc;
    } //-- void setCIndDntdCmmtySvc(java.lang.String) 

    /**
     * Sets the value of field 'cIndSvcAuthComplete'.
     * 
     * @param cIndSvcAuthComplete the value of field
     * 'cIndSvcAuthComplete'.
     */
    public void setCIndSvcAuthComplete(java.lang.String cIndSvcAuthComplete)
    {
        this._cIndSvcAuthComplete = cIndSvcAuthComplete;
    } //-- void setCIndSvcAuthComplete(java.lang.String) 

    /**
     * Sets the value of field 'cIndWaiverReqd'.
     * 
     * @param cIndWaiverReqd the value of field 'cIndWaiverReqd'.
     */
    public void setCIndWaiverReqd(java.lang.String cIndWaiverReqd)
    {
        this._cIndWaiverReqd = cIndWaiverReqd;
    } //-- void setCIndWaiverReqd(java.lang.String) 

    /**
     * Sets the value of field 'dtDtRefSent'.
     * 
     * @param dtDtRefSent the value of field 'dtDtRefSent'.
     */
    public void setDtDtRefSent(org.exolab.castor.types.Date dtDtRefSent)
    {
        this._dtDtRefSent = dtDtRefSent;
    } //-- void setDtDtRefSent(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtSvcAuthEff'.
     * 
     * @param dtDtSvcAuthEff the value of field 'dtDtSvcAuthEff'.
     */
    public void setDtDtSvcAuthEff(org.exolab.castor.types.Date dtDtSvcAuthEff)
    {
        this._dtDtSvcAuthEff = dtDtSvcAuthEff;
    } //-- void setDtDtSvcAuthEff(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ldIdTodo'.
     * 
     * @param ldIdTodo the value of field 'ldIdTodo'.
     */
    public void setLdIdTodo(int ldIdTodo)
    {
        this._ldIdTodo = ldIdTodo;
        this._has_ldIdTodo = true;
    } //-- void setLdIdTodo(int) 

    /**
     * Sets the value of field 'ROWCCMN01UIG00'.
     * 
     * @param ROWCCMN01UIG00 the value of field 'ROWCCMN01UIG00'.
     */
    public void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 ROWCCMN01UIG00)
    {
        this._ROWCCMN01UIG00 = ROWCCMN01UIG00;
    } //-- void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00) 

    /**
     * Sets the value of field 'szCdErlyCaseTyp'.
     * 
     * @param szCdErlyCaseTyp the value of field 'szCdErlyCaseTyp'.
     */
    public void setSzCdErlyCaseTyp(java.lang.String szCdErlyCaseTyp)
    {
        this._szCdErlyCaseTyp = szCdErlyCaseTyp;
    } //-- void setSzCdErlyCaseTyp(java.lang.String) 

    /**
     * Sets the value of field 'szCdEventStatus'.
     * 
     * @param szCdEventStatus the value of field 'szCdEventStatus'.
     */
    public void setSzCdEventStatus(java.lang.String szCdEventStatus)
    {
        this._szCdEventStatus = szCdEventStatus;
    } //-- void setSzCdEventStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdPayCnty'.
     * 
     * @param szCdPayCnty the value of field 'szCdPayCnty'.
     */
    public void setSzCdPayCnty(java.lang.String szCdPayCnty)
    {
        this._szCdPayCnty = szCdPayCnty;
    } //-- void setSzCdPayCnty(java.lang.String) 

    /**
     * Sets the value of field 'szCdPupOtcme'.
     * 
     * @param szCdPupOtcme the value of field 'szCdPupOtcme'.
     */
    public void setSzCdPupOtcme(java.lang.String szCdPupOtcme)
    {
        this._szCdPupOtcme = szCdPupOtcme;
    } //-- void setSzCdPupOtcme(java.lang.String) 

    /**
     * Sets the value of field 'szCdPupTyp'.
     * 
     * @param szCdPupTyp the value of field 'szCdPupTyp'.
     */
    public void setSzCdPupTyp(java.lang.String szCdPupTyp)
    {
        this._szCdPupTyp = szCdPupTyp;
    } //-- void setSzCdPupTyp(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcAuthCategory'.
     * 
     * @param szCdSvcAuthCategory the value of field
     * 'szCdSvcAuthCategory'.
     */
    public void setSzCdSvcAuthCategory(java.lang.String szCdSvcAuthCategory)
    {
        this._szCdSvcAuthCategory = szCdSvcAuthCategory;
    } //-- void setSzCdSvcAuthCategory(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcAuthCounty'.
     * 
     * @param szCdSvcAuthCounty the value of field
     * 'szCdSvcAuthCounty'.
     */
    public void setSzCdSvcAuthCounty(java.lang.String szCdSvcAuthCounty)
    {
        this._szCdSvcAuthCounty = szCdSvcAuthCounty;
    } //-- void setSzCdSvcAuthCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcAuthRegion'.
     * 
     * @param szCdSvcAuthRegion the value of field
     * 'szCdSvcAuthRegion'.
     */
    public void setSzCdSvcAuthRegion(java.lang.String szCdSvcAuthRegion)
    {
        this._szCdSvcAuthRegion = szCdSvcAuthRegion;
    } //-- void setSzCdSvcAuthRegion(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcAuthService'.
     * 
     * @param szCdSvcAuthService the value of field
     * 'szCdSvcAuthService'.
     */
    public void setSzCdSvcAuthService(java.lang.String szCdSvcAuthService)
    {
        this._szCdSvcAuthService = szCdSvcAuthService;
    } //-- void setSzCdSvcAuthService(java.lang.String) 

    /**
     * Sets the value of field 'szCdUnitProgram'.
     * 
     * @param szCdUnitProgram the value of field 'szCdUnitProgram'.
     */
    public void setSzCdUnitProgram(java.lang.String szCdUnitProgram)
    {
        this._szCdUnitProgram = szCdUnitProgram;
    } //-- void setSzCdUnitProgram(java.lang.String) 

    /**
     * Sets the value of field 'szTxtSvcAmtAuthd'.
     * 
     * @param szTxtSvcAmtAuthd the value of field 'szTxtSvcAmtAuthd'
     */
    public void setSzTxtSvcAmtAuthd(double szTxtSvcAmtAuthd)
    {
        this._szTxtSvcAmtAuthd = szTxtSvcAmtAuthd;
        this._has_szTxtSvcAmtAuthd = true;
    } //-- void setSzTxtSvcAmtAuthd(double) 

    /**
     * Sets the value of field 'szTxtSvcAuthComments'.
     * 
     * @param szTxtSvcAuthComments the value of field
     * 'szTxtSvcAuthComments'.
     */
    public void setSzTxtSvcAuthComments(java.lang.String szTxtSvcAuthComments)
    {
        this._szTxtSvcAuthComments = szTxtSvcAuthComments;
    } //-- void setSzTxtSvcAuthComments(java.lang.String) 

    /**
     * Sets the value of field 'szTxtSvcAuthSecProvdr'.
     * 
     * @param szTxtSvcAuthSecProvdr the value of field
     * 'szTxtSvcAuthSecProvdr'.
     */
    public void setSzTxtSvcAuthSecProvdr(java.lang.String szTxtSvcAuthSecProvdr)
    {
        this._szTxtSvcAuthSecProvdr = szTxtSvcAuthSecProvdr;
    } //-- void setSzTxtSvcAuthSecProvdr(java.lang.String) 

    /**
     * Sets the value of field 'tsLastUpdate'.
     * 
     * @param tsLastUpdate the value of field 'tsLastUpdate'.
     */
    public void setTsLastUpdate(java.util.Date tsLastUpdate)
    {
        this._tsLastUpdate = tsLastUpdate;
    } //-- void setTsLastUpdate(java.util.Date) 

    /**
     * Sets the value of field 'ulIdCase'.
     * 
     * @param ulIdCase the value of field 'ulIdCase'.
     */
    public void setUlIdCase(int ulIdCase)
    {
        this._ulIdCase = ulIdCase;
        this._has_ulIdCase = true;
    } //-- void setUlIdCase(int) 

    /**
     * Sets the value of field 'ulIdCntrctManager'.
     * 
     * @param ulIdCntrctManager the value of field
     * 'ulIdCntrctManager'.
     */
    public void setUlIdCntrctManager(int ulIdCntrctManager)
    {
        this._ulIdCntrctManager = ulIdCntrctManager;
        this._has_ulIdCntrctManager = true;
    } //-- void setUlIdCntrctManager(int) 

    /**
     * Sets the value of field 'ulIdContract'.
     * 
     * @param ulIdContract the value of field 'ulIdContract'.
     */
    public void setUlIdContract(int ulIdContract)
    {
        this._ulIdContract = ulIdContract;
        this._has_ulIdContract = true;
    } //-- void setUlIdContract(int) 

    /**
     * Sets the value of field 'ulIdEvent'.
     * 
     * @param ulIdEvent the value of field 'ulIdEvent'.
     */
    public void setUlIdEvent(int ulIdEvent)
    {
        this._ulIdEvent = ulIdEvent;
        this._has_ulIdEvent = true;
    } //-- void setUlIdEvent(int) 

    /**
     * Sets the value of field 'ulIdPersonPrincipal'.
     * 
     * @param ulIdPersonPrincipal the value of field
     * 'ulIdPersonPrincipal'.
     */
    public void setUlIdPersonPrincipal(int ulIdPersonPrincipal)
    {
        this._ulIdPersonPrincipal = ulIdPersonPrincipal;
        this._has_ulIdPersonPrincipal = true;
    } //-- void setUlIdPersonPrincipal(int) 

    /**
     * Sets the value of field 'ulIdPrimaryClient'.
     * 
     * @param ulIdPrimaryClient the value of field
     * 'ulIdPrimaryClient'.
     */
    public void setUlIdPrimaryClient(int ulIdPrimaryClient)
    {
        this._ulIdPrimaryClient = ulIdPrimaryClient;
        this._has_ulIdPrimaryClient = true;
    } //-- void setUlIdPrimaryClient(int) 

    /**
     * Sets the value of field 'ulIdResource'.
     * 
     * @param ulIdResource the value of field 'ulIdResource'.
     */
    public void setUlIdResource(int ulIdResource)
    {
        this._ulIdResource = ulIdResource;
        this._has_ulIdResource = true;
    } //-- void setUlIdResource(int) 

    /**
     * Sets the value of field 'ulIdSvcAuth'.
     * 
     * @param ulIdSvcAuth the value of field 'ulIdSvcAuth'.
     */
    public void setUlIdSvcAuth(int ulIdSvcAuth)
    {
        this._ulIdSvcAuth = ulIdSvcAuth;
        this._has_ulIdSvcAuth = true;
    } //-- void setUlIdSvcAuth(int) 

    /**
     * Sets the value of field 'ulIdWaiver'.
     * 
     * @param ulIdWaiver the value of field 'ulIdWaiver'.
     */
    public void setUlIdWaiver(int ulIdWaiver)
    {
        this._ulIdWaiver = ulIdWaiver;
        this._has_ulIdWaiver = true;
    } //-- void setUlIdWaiver(int) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCON19SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCON19SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCON19SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCON19SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON19SI unmarshal(java.io.Reader) 

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
