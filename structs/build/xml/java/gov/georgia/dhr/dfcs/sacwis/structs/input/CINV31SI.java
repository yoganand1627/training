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
 * Class CINV31SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV31SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN46DI
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN46DI _ROWCCMN46DI;

    /**
     * Field _ROWCCMN01UIG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01 _ROWCCMN01UIG01;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdPersonPrincipal
     */
    private int _ulIdPersonPrincipal;

    /**
     * keeps track of state for field: _ulIdPersonPrincipal
     */
    private boolean _has_ulIdPersonPrincipal;

    /**
     * Field _ulIdPersonProfessional
     */
    private int _ulIdPersonProfessional;

    /**
     * keeps track of state for field: _ulIdPersonProfessional
     */
    private boolean _has_ulIdPersonProfessional;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;

    /**
     * Field _szTxtProfAssmtFindings
     */
    private java.lang.String _szTxtProfAssmtFindings;

    /**
     * Field _szTxtProfAssmtOther
     */
    private java.lang.String _szTxtProfAssmtOther;

    /**
     * Field _szNmProfAssmtPrincipal
     */
    private java.lang.String _szNmProfAssmtPrincipal;

    /**
     * Field _cdProfAssmtApptRsn
     */
    private java.lang.String _cdProfAssmtApptRsn;

    /**
     * Field _szCdProfAssmtCounty
     */
    private java.lang.String _szCdProfAssmtCounty;

    /**
     * Field _szAddrProfAssmtState
     */
    private java.lang.String _szAddrProfAssmtState;

    /**
     * Field _dtProfAssmtAppt
     */
    private org.exolab.castor.types.Date _dtProfAssmtAppt;

    /**
     * Field _szAddrProfAssmtCity
     */
    private java.lang.String _szAddrProfAssmtCity;

    /**
     * Field _szAddrProfAssmtStLn1
     */
    private java.lang.String _szAddrProfAssmtStLn1;

    /**
     * Field _szAddrProfAssmtStLn2
     */
    private java.lang.String _szAddrProfAssmtStLn2;

    /**
     * Field _szAddrProfAssmtZip
     */
    private java.lang.String _szAddrProfAssmtZip;

    /**
     * Field _lNbrPhone
     */
    private java.lang.String _lNbrPhone;

    /**
     * Field _lNbrPhoneExtension
     */
    private java.lang.String _lNbrPhoneExtension;

    /**
     * Field _szTxtProfAssmtCmnts
     */
    private java.lang.String _szTxtProfAssmtCmnts;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szNmProfAssmtName
     */
    private java.lang.String _szNmProfAssmtName;

    /**
     * Field _cIndOutNetworkAuth
     */
    private java.lang.String _cIndOutNetworkAuth;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV31SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV31SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

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
    public void deleteUlIdPersonProfessional()
    {
        this._has_ulIdPersonProfessional= false;
    } //-- void deleteUlIdPersonProfessional() 

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
     * Returns the value of field 'cIndOutNetworkAuth'.
     * 
     * @return the value of field 'CIndOutNetworkAuth'.
     */
    public java.lang.String getCIndOutNetworkAuth()
    {
        return this._cIndOutNetworkAuth;
    } //-- java.lang.String getCIndOutNetworkAuth() 

    /**
     * Returns the value of field 'cdProfAssmtApptRsn'.
     * 
     * @return the value of field 'CdProfAssmtApptRsn'.
     */
    public java.lang.String getCdProfAssmtApptRsn()
    {
        return this._cdProfAssmtApptRsn;
    } //-- java.lang.String getCdProfAssmtApptRsn() 

    /**
     * Returns the value of field 'dtProfAssmtAppt'.
     * 
     * @return the value of field 'DtProfAssmtAppt'.
     */
    public org.exolab.castor.types.Date getDtProfAssmtAppt()
    {
        return this._dtProfAssmtAppt;
    } //-- org.exolab.castor.types.Date getDtProfAssmtAppt() 

    /**
     * Returns the value of field 'lNbrPhone'.
     * 
     * @return the value of field 'LNbrPhone'.
     */
    public java.lang.String getLNbrPhone()
    {
        return this._lNbrPhone;
    } //-- java.lang.String getLNbrPhone() 

    /**
     * Returns the value of field 'lNbrPhoneExtension'.
     * 
     * @return the value of field 'LNbrPhoneExtension'.
     */
    public java.lang.String getLNbrPhoneExtension()
    {
        return this._lNbrPhoneExtension;
    } //-- java.lang.String getLNbrPhoneExtension() 

    /**
     * Returns the value of field 'ROWCCMN01UIG01'.
     * 
     * @return the value of field 'ROWCCMN01UIG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01 getROWCCMN01UIG01()
    {
        return this._ROWCCMN01UIG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01 getROWCCMN01UIG01() 

    /**
     * Returns the value of field 'ROWCCMN46DI'.
     * 
     * @return the value of field 'ROWCCMN46DI'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN46DI getROWCCMN46DI()
    {
        return this._ROWCCMN46DI;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN46DI getROWCCMN46DI() 

    /**
     * Returns the value of field 'szAddrProfAssmtCity'.
     * 
     * @return the value of field 'SzAddrProfAssmtCity'.
     */
    public java.lang.String getSzAddrProfAssmtCity()
    {
        return this._szAddrProfAssmtCity;
    } //-- java.lang.String getSzAddrProfAssmtCity() 

    /**
     * Returns the value of field 'szAddrProfAssmtStLn1'.
     * 
     * @return the value of field 'SzAddrProfAssmtStLn1'.
     */
    public java.lang.String getSzAddrProfAssmtStLn1()
    {
        return this._szAddrProfAssmtStLn1;
    } //-- java.lang.String getSzAddrProfAssmtStLn1() 

    /**
     * Returns the value of field 'szAddrProfAssmtStLn2'.
     * 
     * @return the value of field 'SzAddrProfAssmtStLn2'.
     */
    public java.lang.String getSzAddrProfAssmtStLn2()
    {
        return this._szAddrProfAssmtStLn2;
    } //-- java.lang.String getSzAddrProfAssmtStLn2() 

    /**
     * Returns the value of field 'szAddrProfAssmtState'.
     * 
     * @return the value of field 'SzAddrProfAssmtState'.
     */
    public java.lang.String getSzAddrProfAssmtState()
    {
        return this._szAddrProfAssmtState;
    } //-- java.lang.String getSzAddrProfAssmtState() 

    /**
     * Returns the value of field 'szAddrProfAssmtZip'.
     * 
     * @return the value of field 'SzAddrProfAssmtZip'.
     */
    public java.lang.String getSzAddrProfAssmtZip()
    {
        return this._szAddrProfAssmtZip;
    } //-- java.lang.String getSzAddrProfAssmtZip() 

    /**
     * Returns the value of field 'szCdProfAssmtCounty'.
     * 
     * @return the value of field 'SzCdProfAssmtCounty'.
     */
    public java.lang.String getSzCdProfAssmtCounty()
    {
        return this._szCdProfAssmtCounty;
    } //-- java.lang.String getSzCdProfAssmtCounty() 

    /**
     * Returns the value of field 'szCdScrDataAction'.
     * 
     * @return the value of field 'SzCdScrDataAction'.
     */
    public java.lang.String getSzCdScrDataAction()
    {
        return this._szCdScrDataAction;
    } //-- java.lang.String getSzCdScrDataAction() 

    /**
     * Returns the value of field 'szNmProfAssmtName'.
     * 
     * @return the value of field 'SzNmProfAssmtName'.
     */
    public java.lang.String getSzNmProfAssmtName()
    {
        return this._szNmProfAssmtName;
    } //-- java.lang.String getSzNmProfAssmtName() 

    /**
     * Returns the value of field 'szNmProfAssmtPrincipal'.
     * 
     * @return the value of field 'SzNmProfAssmtPrincipal'.
     */
    public java.lang.String getSzNmProfAssmtPrincipal()
    {
        return this._szNmProfAssmtPrincipal;
    } //-- java.lang.String getSzNmProfAssmtPrincipal() 

    /**
     * Returns the value of field 'szTxtProfAssmtCmnts'.
     * 
     * @return the value of field 'SzTxtProfAssmtCmnts'.
     */
    public java.lang.String getSzTxtProfAssmtCmnts()
    {
        return this._szTxtProfAssmtCmnts;
    } //-- java.lang.String getSzTxtProfAssmtCmnts() 

    /**
     * Returns the value of field 'szTxtProfAssmtFindings'.
     * 
     * @return the value of field 'SzTxtProfAssmtFindings'.
     */
    public java.lang.String getSzTxtProfAssmtFindings()
    {
        return this._szTxtProfAssmtFindings;
    } //-- java.lang.String getSzTxtProfAssmtFindings() 

    /**
     * Returns the value of field 'szTxtProfAssmtOther'.
     * 
     * @return the value of field 'SzTxtProfAssmtOther'.
     */
    public java.lang.String getSzTxtProfAssmtOther()
    {
        return this._szTxtProfAssmtOther;
    } //-- java.lang.String getSzTxtProfAssmtOther() 

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
     * Returns the value of field 'ulIdPersonProfessional'.
     * 
     * @return the value of field 'UlIdPersonProfessional'.
     */
    public int getUlIdPersonProfessional()
    {
        return this._ulIdPersonProfessional;
    } //-- int getUlIdPersonProfessional() 

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
     * Method hasUlIdPersonProfessional
     * 
     * 
     * 
     * @return true if at least one UlIdPersonProfessional has been
     * added
     */
    public boolean hasUlIdPersonProfessional()
    {
        return this._has_ulIdPersonProfessional;
    } //-- boolean hasUlIdPersonProfessional() 

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
     * Sets the value of field 'cIndOutNetworkAuth'.
     * 
     * @param cIndOutNetworkAuth the value of field
     * 'cIndOutNetworkAuth'.
     */
    public void setCIndOutNetworkAuth(java.lang.String cIndOutNetworkAuth)
    {
        this._cIndOutNetworkAuth = cIndOutNetworkAuth;
    } //-- void setCIndOutNetworkAuth(java.lang.String) 

    /**
     * Sets the value of field 'cdProfAssmtApptRsn'.
     * 
     * @param cdProfAssmtApptRsn the value of field
     * 'cdProfAssmtApptRsn'.
     */
    public void setCdProfAssmtApptRsn(java.lang.String cdProfAssmtApptRsn)
    {
        this._cdProfAssmtApptRsn = cdProfAssmtApptRsn;
    } //-- void setCdProfAssmtApptRsn(java.lang.String) 

    /**
     * Sets the value of field 'dtProfAssmtAppt'.
     * 
     * @param dtProfAssmtAppt the value of field 'dtProfAssmtAppt'.
     */
    public void setDtProfAssmtAppt(org.exolab.castor.types.Date dtProfAssmtAppt)
    {
        this._dtProfAssmtAppt = dtProfAssmtAppt;
    } //-- void setDtProfAssmtAppt(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'lNbrPhone'.
     * 
     * @param lNbrPhone the value of field 'lNbrPhone'.
     */
    public void setLNbrPhone(java.lang.String lNbrPhone)
    {
        this._lNbrPhone = lNbrPhone;
    } //-- void setLNbrPhone(java.lang.String) 

    /**
     * Sets the value of field 'lNbrPhoneExtension'.
     * 
     * @param lNbrPhoneExtension the value of field
     * 'lNbrPhoneExtension'.
     */
    public void setLNbrPhoneExtension(java.lang.String lNbrPhoneExtension)
    {
        this._lNbrPhoneExtension = lNbrPhoneExtension;
    } //-- void setLNbrPhoneExtension(java.lang.String) 

    /**
     * Sets the value of field 'ROWCCMN01UIG01'.
     * 
     * @param ROWCCMN01UIG01 the value of field 'ROWCCMN01UIG01'.
     */
    public void setROWCCMN01UIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01 ROWCCMN01UIG01)
    {
        this._ROWCCMN01UIG01 = ROWCCMN01UIG01;
    } //-- void setROWCCMN01UIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01) 

    /**
     * Sets the value of field 'ROWCCMN46DI'.
     * 
     * @param ROWCCMN46DI the value of field 'ROWCCMN46DI'.
     */
    public void setROWCCMN46DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN46DI ROWCCMN46DI)
    {
        this._ROWCCMN46DI = ROWCCMN46DI;
    } //-- void setROWCCMN46DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN46DI) 

    /**
     * Sets the value of field 'szAddrProfAssmtCity'.
     * 
     * @param szAddrProfAssmtCity the value of field
     * 'szAddrProfAssmtCity'.
     */
    public void setSzAddrProfAssmtCity(java.lang.String szAddrProfAssmtCity)
    {
        this._szAddrProfAssmtCity = szAddrProfAssmtCity;
    } //-- void setSzAddrProfAssmtCity(java.lang.String) 

    /**
     * Sets the value of field 'szAddrProfAssmtStLn1'.
     * 
     * @param szAddrProfAssmtStLn1 the value of field
     * 'szAddrProfAssmtStLn1'.
     */
    public void setSzAddrProfAssmtStLn1(java.lang.String szAddrProfAssmtStLn1)
    {
        this._szAddrProfAssmtStLn1 = szAddrProfAssmtStLn1;
    } //-- void setSzAddrProfAssmtStLn1(java.lang.String) 

    /**
     * Sets the value of field 'szAddrProfAssmtStLn2'.
     * 
     * @param szAddrProfAssmtStLn2 the value of field
     * 'szAddrProfAssmtStLn2'.
     */
    public void setSzAddrProfAssmtStLn2(java.lang.String szAddrProfAssmtStLn2)
    {
        this._szAddrProfAssmtStLn2 = szAddrProfAssmtStLn2;
    } //-- void setSzAddrProfAssmtStLn2(java.lang.String) 

    /**
     * Sets the value of field 'szAddrProfAssmtState'.
     * 
     * @param szAddrProfAssmtState the value of field
     * 'szAddrProfAssmtState'.
     */
    public void setSzAddrProfAssmtState(java.lang.String szAddrProfAssmtState)
    {
        this._szAddrProfAssmtState = szAddrProfAssmtState;
    } //-- void setSzAddrProfAssmtState(java.lang.String) 

    /**
     * Sets the value of field 'szAddrProfAssmtZip'.
     * 
     * @param szAddrProfAssmtZip the value of field
     * 'szAddrProfAssmtZip'.
     */
    public void setSzAddrProfAssmtZip(java.lang.String szAddrProfAssmtZip)
    {
        this._szAddrProfAssmtZip = szAddrProfAssmtZip;
    } //-- void setSzAddrProfAssmtZip(java.lang.String) 

    /**
     * Sets the value of field 'szCdProfAssmtCounty'.
     * 
     * @param szCdProfAssmtCounty the value of field
     * 'szCdProfAssmtCounty'.
     */
    public void setSzCdProfAssmtCounty(java.lang.String szCdProfAssmtCounty)
    {
        this._szCdProfAssmtCounty = szCdProfAssmtCounty;
    } //-- void setSzCdProfAssmtCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdScrDataAction'.
     * 
     * @param szCdScrDataAction the value of field
     * 'szCdScrDataAction'.
     */
    public void setSzCdScrDataAction(java.lang.String szCdScrDataAction)
    {
        this._szCdScrDataAction = szCdScrDataAction;
    } //-- void setSzCdScrDataAction(java.lang.String) 

    /**
     * Sets the value of field 'szNmProfAssmtName'.
     * 
     * @param szNmProfAssmtName the value of field
     * 'szNmProfAssmtName'.
     */
    public void setSzNmProfAssmtName(java.lang.String szNmProfAssmtName)
    {
        this._szNmProfAssmtName = szNmProfAssmtName;
    } //-- void setSzNmProfAssmtName(java.lang.String) 

    /**
     * Sets the value of field 'szNmProfAssmtPrincipal'.
     * 
     * @param szNmProfAssmtPrincipal the value of field
     * 'szNmProfAssmtPrincipal'.
     */
    public void setSzNmProfAssmtPrincipal(java.lang.String szNmProfAssmtPrincipal)
    {
        this._szNmProfAssmtPrincipal = szNmProfAssmtPrincipal;
    } //-- void setSzNmProfAssmtPrincipal(java.lang.String) 

    /**
     * Sets the value of field 'szTxtProfAssmtCmnts'.
     * 
     * @param szTxtProfAssmtCmnts the value of field
     * 'szTxtProfAssmtCmnts'.
     */
    public void setSzTxtProfAssmtCmnts(java.lang.String szTxtProfAssmtCmnts)
    {
        this._szTxtProfAssmtCmnts = szTxtProfAssmtCmnts;
    } //-- void setSzTxtProfAssmtCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtProfAssmtFindings'.
     * 
     * @param szTxtProfAssmtFindings the value of field
     * 'szTxtProfAssmtFindings'.
     */
    public void setSzTxtProfAssmtFindings(java.lang.String szTxtProfAssmtFindings)
    {
        this._szTxtProfAssmtFindings = szTxtProfAssmtFindings;
    } //-- void setSzTxtProfAssmtFindings(java.lang.String) 

    /**
     * Sets the value of field 'szTxtProfAssmtOther'.
     * 
     * @param szTxtProfAssmtOther the value of field
     * 'szTxtProfAssmtOther'.
     */
    public void setSzTxtProfAssmtOther(java.lang.String szTxtProfAssmtOther)
    {
        this._szTxtProfAssmtOther = szTxtProfAssmtOther;
    } //-- void setSzTxtProfAssmtOther(java.lang.String) 

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
     * Sets the value of field 'ulIdPersonProfessional'.
     * 
     * @param ulIdPersonProfessional the value of field
     * 'ulIdPersonProfessional'.
     */
    public void setUlIdPersonProfessional(int ulIdPersonProfessional)
    {
        this._ulIdPersonProfessional = ulIdPersonProfessional;
        this._has_ulIdPersonProfessional = true;
    } //-- void setUlIdPersonProfessional(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINV31SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CINV31SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV31SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV31SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV31SI unmarshal(java.io.Reader) 

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
