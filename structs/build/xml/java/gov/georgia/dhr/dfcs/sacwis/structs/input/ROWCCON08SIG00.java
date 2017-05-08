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
 * Class ROWCCON08SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCON08SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulNbrCnverVersion
     */
    private int _ulNbrCnverVersion;

    /**
     * keeps track of state for field: _ulNbrCnverVersion
     */
    private boolean _has_ulNbrCnverVersion;

    /**
     * Field _ulIdCnver
     */
    private int _ulIdCnver;

    /**
     * keeps track of state for field: _ulIdCnver
     */
    private boolean _has_ulIdCnver;

    /**
     * Field _dtDtCnverEffective
     */
    private org.exolab.castor.types.Date _dtDtCnverEffective;

    /**
     * Field _dtDtCnverEnd
     */
    private org.exolab.castor.types.Date _dtDtCnverEnd;

    /**
     * Field _dtDtCnverCreate
     */
    private org.exolab.castor.types.Date _dtDtCnverCreate;

    /**
     * Field _cIndCnverVerLock
     */
    private java.lang.String _cIndCnverVerLock;

    /**
     * Field _ulNbrCnverNoShowPct
     */
    private int _ulNbrCnverNoShowPct;

    /**
     * keeps track of state for field: _ulNbrCnverNoShowPct
     */
    private boolean _has_ulNbrCnverNoShowPct;

    /**
     * Field _szTxtCnverComment
     */
    private java.lang.String _szTxtCnverComment;

    /**
     * Field _bIndEndDateMod
     */
    private java.lang.String _bIndEndDateMod;

    /**
     * Field _bSysIndVersionLockMod
     */
    private java.lang.String _bSysIndVersionLockMod;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _txtLastUpdatedBy
     */
    private java.lang.String _txtLastUpdatedBy;

    /**
     * Field _dtDtPrevCnverEffective
     */
    private org.exolab.castor.types.Date _dtDtPrevCnverEffective;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCON08SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON08SIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCnver()
    {
        this._has_ulIdCnver= false;
    } //-- void deleteUlIdCnver() 

    /**
     */
    public void deleteUlNbrCnverNoShowPct()
    {
        this._has_ulNbrCnverNoShowPct= false;
    } //-- void deleteUlNbrCnverNoShowPct() 

    /**
     */
    public void deleteUlNbrCnverVersion()
    {
        this._has_ulNbrCnverVersion= false;
    } //-- void deleteUlNbrCnverVersion() 

    /**
     * Returns the value of field 'bIndEndDateMod'.
     * 
     * @return the value of field 'BIndEndDateMod'.
     */
    public java.lang.String getBIndEndDateMod()
    {
        return this._bIndEndDateMod;
    } //-- java.lang.String getBIndEndDateMod() 

    /**
     * Returns the value of field 'bSysIndVersionLockMod'.
     * 
     * @return the value of field 'BSysIndVersionLockMod'.
     */
    public java.lang.String getBSysIndVersionLockMod()
    {
        return this._bSysIndVersionLockMod;
    } //-- java.lang.String getBSysIndVersionLockMod() 

    /**
     * Returns the value of field 'cIndCnverVerLock'.
     * 
     * @return the value of field 'CIndCnverVerLock'.
     */
    public java.lang.String getCIndCnverVerLock()
    {
        return this._cIndCnverVerLock;
    } //-- java.lang.String getCIndCnverVerLock() 

    /**
     * Returns the value of field 'dtDtCnverCreate'.
     * 
     * @return the value of field 'DtDtCnverCreate'.
     */
    public org.exolab.castor.types.Date getDtDtCnverCreate()
    {
        return this._dtDtCnverCreate;
    } //-- org.exolab.castor.types.Date getDtDtCnverCreate() 

    /**
     * Returns the value of field 'dtDtCnverEffective'.
     * 
     * @return the value of field 'DtDtCnverEffective'.
     */
    public org.exolab.castor.types.Date getDtDtCnverEffective()
    {
        return this._dtDtCnverEffective;
    } //-- org.exolab.castor.types.Date getDtDtCnverEffective() 

    /**
     * Returns the value of field 'dtDtCnverEnd'.
     * 
     * @return the value of field 'DtDtCnverEnd'.
     */
    public org.exolab.castor.types.Date getDtDtCnverEnd()
    {
        return this._dtDtCnverEnd;
    } //-- org.exolab.castor.types.Date getDtDtCnverEnd() 

    /**
     * Returns the value of field 'dtDtPrevCnverEffective'.
     * 
     * @return the value of field 'DtDtPrevCnverEffective'.
     */
    public org.exolab.castor.types.Date getDtDtPrevCnverEffective()
    {
        return this._dtDtPrevCnverEffective;
    } //-- org.exolab.castor.types.Date getDtDtPrevCnverEffective() 

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
     * Returns the value of field 'szTxtCnverComment'.
     * 
     * @return the value of field 'SzTxtCnverComment'.
     */
    public java.lang.String getSzTxtCnverComment()
    {
        return this._szTxtCnverComment;
    } //-- java.lang.String getSzTxtCnverComment() 

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
     * Returns the value of field 'txtLastUpdatedBy'.
     * 
     * @return the value of field 'TxtLastUpdatedBy'.
     */
    public java.lang.String getTxtLastUpdatedBy()
    {
        return this._txtLastUpdatedBy;
    } //-- java.lang.String getTxtLastUpdatedBy() 

    /**
     * Returns the value of field 'ulIdCnver'.
     * 
     * @return the value of field 'UlIdCnver'.
     */
    public int getUlIdCnver()
    {
        return this._ulIdCnver;
    } //-- int getUlIdCnver() 

    /**
     * Returns the value of field 'ulNbrCnverNoShowPct'.
     * 
     * @return the value of field 'UlNbrCnverNoShowPct'.
     */
    public int getUlNbrCnverNoShowPct()
    {
        return this._ulNbrCnverNoShowPct;
    } //-- int getUlNbrCnverNoShowPct() 

    /**
     * Returns the value of field 'ulNbrCnverVersion'.
     * 
     * @return the value of field 'UlNbrCnverVersion'.
     */
    public int getUlNbrCnverVersion()
    {
        return this._ulNbrCnverVersion;
    } //-- int getUlNbrCnverVersion() 

    /**
     * Method hasUlIdCnver
     * 
     * 
     * 
     * @return true if at least one UlIdCnver has been added
     */
    public boolean hasUlIdCnver()
    {
        return this._has_ulIdCnver;
    } //-- boolean hasUlIdCnver() 

    /**
     * Method hasUlNbrCnverNoShowPct
     * 
     * 
     * 
     * @return true if at least one UlNbrCnverNoShowPct has been
     * added
     */
    public boolean hasUlNbrCnverNoShowPct()
    {
        return this._has_ulNbrCnverNoShowPct;
    } //-- boolean hasUlNbrCnverNoShowPct() 

    /**
     * Method hasUlNbrCnverVersion
     * 
     * 
     * 
     * @return true if at least one UlNbrCnverVersion has been added
     */
    public boolean hasUlNbrCnverVersion()
    {
        return this._has_ulNbrCnverVersion;
    } //-- boolean hasUlNbrCnverVersion() 

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
     * Sets the value of field 'bIndEndDateMod'.
     * 
     * @param bIndEndDateMod the value of field 'bIndEndDateMod'.
     */
    public void setBIndEndDateMod(java.lang.String bIndEndDateMod)
    {
        this._bIndEndDateMod = bIndEndDateMod;
    } //-- void setBIndEndDateMod(java.lang.String) 

    /**
     * Sets the value of field 'bSysIndVersionLockMod'.
     * 
     * @param bSysIndVersionLockMod the value of field
     * 'bSysIndVersionLockMod'.
     */
    public void setBSysIndVersionLockMod(java.lang.String bSysIndVersionLockMod)
    {
        this._bSysIndVersionLockMod = bSysIndVersionLockMod;
    } //-- void setBSysIndVersionLockMod(java.lang.String) 

    /**
     * Sets the value of field 'cIndCnverVerLock'.
     * 
     * @param cIndCnverVerLock the value of field 'cIndCnverVerLock'
     */
    public void setCIndCnverVerLock(java.lang.String cIndCnverVerLock)
    {
        this._cIndCnverVerLock = cIndCnverVerLock;
    } //-- void setCIndCnverVerLock(java.lang.String) 

    /**
     * Sets the value of field 'dtDtCnverCreate'.
     * 
     * @param dtDtCnverCreate the value of field 'dtDtCnverCreate'.
     */
    public void setDtDtCnverCreate(org.exolab.castor.types.Date dtDtCnverCreate)
    {
        this._dtDtCnverCreate = dtDtCnverCreate;
    } //-- void setDtDtCnverCreate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCnverEffective'.
     * 
     * @param dtDtCnverEffective the value of field
     * 'dtDtCnverEffective'.
     */
    public void setDtDtCnverEffective(org.exolab.castor.types.Date dtDtCnverEffective)
    {
        this._dtDtCnverEffective = dtDtCnverEffective;
    } //-- void setDtDtCnverEffective(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCnverEnd'.
     * 
     * @param dtDtCnverEnd the value of field 'dtDtCnverEnd'.
     */
    public void setDtDtCnverEnd(org.exolab.castor.types.Date dtDtCnverEnd)
    {
        this._dtDtCnverEnd = dtDtCnverEnd;
    } //-- void setDtDtCnverEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPrevCnverEffective'.
     * 
     * @param dtDtPrevCnverEffective the value of field
     * 'dtDtPrevCnverEffective'.
     */
    public void setDtDtPrevCnverEffective(org.exolab.castor.types.Date dtDtPrevCnverEffective)
    {
        this._dtDtPrevCnverEffective = dtDtPrevCnverEffective;
    } //-- void setDtDtPrevCnverEffective(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'szTxtCnverComment'.
     * 
     * @param szTxtCnverComment the value of field
     * 'szTxtCnverComment'.
     */
    public void setSzTxtCnverComment(java.lang.String szTxtCnverComment)
    {
        this._szTxtCnverComment = szTxtCnverComment;
    } //-- void setSzTxtCnverComment(java.lang.String) 

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
     * Sets the value of field 'txtLastUpdatedBy'.
     * 
     * @param txtLastUpdatedBy the value of field 'txtLastUpdatedBy'
     */
    public void setTxtLastUpdatedBy(java.lang.String txtLastUpdatedBy)
    {
        this._txtLastUpdatedBy = txtLastUpdatedBy;
    } //-- void setTxtLastUpdatedBy(java.lang.String) 

    /**
     * Sets the value of field 'ulIdCnver'.
     * 
     * @param ulIdCnver the value of field 'ulIdCnver'.
     */
    public void setUlIdCnver(int ulIdCnver)
    {
        this._ulIdCnver = ulIdCnver;
        this._has_ulIdCnver = true;
    } //-- void setUlIdCnver(int) 

    /**
     * Sets the value of field 'ulNbrCnverNoShowPct'.
     * 
     * @param ulNbrCnverNoShowPct the value of field
     * 'ulNbrCnverNoShowPct'.
     */
    public void setUlNbrCnverNoShowPct(int ulNbrCnverNoShowPct)
    {
        this._ulNbrCnverNoShowPct = ulNbrCnverNoShowPct;
        this._has_ulNbrCnverNoShowPct = true;
    } //-- void setUlNbrCnverNoShowPct(int) 

    /**
     * Sets the value of field 'ulNbrCnverVersion'.
     * 
     * @param ulNbrCnverVersion the value of field
     * 'ulNbrCnverVersion'.
     */
    public void setUlNbrCnverVersion(int ulNbrCnverVersion)
    {
        this._ulNbrCnverVersion = ulNbrCnverVersion;
        this._has_ulNbrCnverVersion = true;
    } //-- void setUlNbrCnverVersion(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON08SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON08SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON08SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON08SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON08SIG00 unmarshal(java.io.Reader) 

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
