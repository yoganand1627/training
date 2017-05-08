/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.5</a>, using an XML
 * Schema.
 * $Id$
 */

package gov.georgia.dhr.dfcs.sacwis.structs.output;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class AvailStaffGroup.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AvailStaffGroup extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szNbrUnit
     */
    private java.lang.String _szNbrUnit;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _szBjnJob
     */
    private java.lang.String _szBjnJob;

    /**
     * Field _dtDtEmpLastAssigned
     */
    private org.exolab.castor.types.Date _dtDtEmpLastAssigned;

    /**
     * Field _tmScrTmEmpLastAssigned
     */
    private java.lang.String _tmScrTmEmpLastAssigned;

    /**
     * Field _lNbrPhone
     */
    private java.lang.String _lNbrPhone;

    /**
     * Field _lNbrPhoneExtension
     */
    private java.lang.String _lNbrPhoneExtension;

    /**
     * Field _szNbrEmpOnCallPhone1
     */
    private java.lang.String _szNbrEmpOnCallPhone1;

    /**
     * Field _lNbrEmpOnCallExt1
     */
    private java.lang.String _lNbrEmpOnCallExt1;

    /**
     * Field _szCdEmpOnCallDesig
     */
    private java.lang.String _szCdEmpOnCallDesig;

    /**
     * Field _szNmOfficeName
     */
    private java.lang.String _szNmOfficeName;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdUnit
     */
    private int _ulIdUnit;

    /**
     * keeps track of state for field: _ulIdUnit
     */
    private boolean _has_ulIdUnit;

    /**
     * Field _usNbrEmpOnCallCntctOrd
     */
    private int _usNbrEmpOnCallCntctOrd;

    /**
     * keeps track of state for field: _usNbrEmpOnCallCntctOrd
     */
    private boolean _has_usNbrEmpOnCallCntctOrd;

    /**
     * Field _bIndOverPolicyLimit
     */
    private boolean _bIndOverPolicyLimit;

    /**
     * keeps track of state for field: _bIndOverPolicyLimit
     */
    private boolean _has_bIndOverPolicyLimit;


      //----------------/
     //- Constructors -/
    //----------------/

    public AvailStaffGroup() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteBIndOverPolicyLimit()
    {
        this._has_bIndOverPolicyLimit= false;
    } //-- void deleteBIndOverPolicyLimit() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdUnit()
    {
        this._has_ulIdUnit= false;
    } //-- void deleteUlIdUnit() 

    /**
     */
    public void deleteUsNbrEmpOnCallCntctOrd()
    {
        this._has_usNbrEmpOnCallCntctOrd= false;
    } //-- void deleteUsNbrEmpOnCallCntctOrd() 

    /**
     * Returns the value of field 'bIndOverPolicyLimit'.
     * 
     * @return the value of field 'BIndOverPolicyLimit'.
     */
    public boolean getBIndOverPolicyLimit()
    {
        return this._bIndOverPolicyLimit;
    } //-- boolean getBIndOverPolicyLimit() 

    /**
     * Returns the value of field 'dtDtEmpLastAssigned'.
     * 
     * @return the value of field 'DtDtEmpLastAssigned'.
     */
    public org.exolab.castor.types.Date getDtDtEmpLastAssigned()
    {
        return this._dtDtEmpLastAssigned;
    } //-- org.exolab.castor.types.Date getDtDtEmpLastAssigned() 

    /**
     * Returns the value of field 'lNbrEmpOnCallExt1'.
     * 
     * @return the value of field 'LNbrEmpOnCallExt1'.
     */
    public java.lang.String getLNbrEmpOnCallExt1()
    {
        return this._lNbrEmpOnCallExt1;
    } //-- java.lang.String getLNbrEmpOnCallExt1() 

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
     * Returns the value of field 'szBjnJob'.
     * 
     * @return the value of field 'SzBjnJob'.
     */
    public java.lang.String getSzBjnJob()
    {
        return this._szBjnJob;
    } //-- java.lang.String getSzBjnJob() 

    /**
     * Returns the value of field 'szCdEmpOnCallDesig'.
     * 
     * @return the value of field 'SzCdEmpOnCallDesig'.
     */
    public java.lang.String getSzCdEmpOnCallDesig()
    {
        return this._szCdEmpOnCallDesig;
    } //-- java.lang.String getSzCdEmpOnCallDesig() 

    /**
     * Returns the value of field 'szNbrEmpOnCallPhone1'.
     * 
     * @return the value of field 'SzNbrEmpOnCallPhone1'.
     */
    public java.lang.String getSzNbrEmpOnCallPhone1()
    {
        return this._szNbrEmpOnCallPhone1;
    } //-- java.lang.String getSzNbrEmpOnCallPhone1() 

    /**
     * Returns the value of field 'szNbrUnit'.
     * 
     * @return the value of field 'SzNbrUnit'.
     */
    public java.lang.String getSzNbrUnit()
    {
        return this._szNbrUnit;
    } //-- java.lang.String getSzNbrUnit() 

    /**
     * Returns the value of field 'szNmOfficeName'.
     * 
     * @return the value of field 'SzNmOfficeName'.
     */
    public java.lang.String getSzNmOfficeName()
    {
        return this._szNmOfficeName;
    } //-- java.lang.String getSzNmOfficeName() 

    /**
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

    /**
     * Returns the value of field 'tmScrTmEmpLastAssigned'.
     * 
     * @return the value of field 'TmScrTmEmpLastAssigned'.
     */
    public java.lang.String getTmScrTmEmpLastAssigned()
    {
        return this._tmScrTmEmpLastAssigned;
    } //-- java.lang.String getTmScrTmEmpLastAssigned() 

    /**
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Returns the value of field 'ulIdUnit'.
     * 
     * @return the value of field 'UlIdUnit'.
     */
    public int getUlIdUnit()
    {
        return this._ulIdUnit;
    } //-- int getUlIdUnit() 

    /**
     * Returns the value of field 'usNbrEmpOnCallCntctOrd'.
     * 
     * @return the value of field 'UsNbrEmpOnCallCntctOrd'.
     */
    public int getUsNbrEmpOnCallCntctOrd()
    {
        return this._usNbrEmpOnCallCntctOrd;
    } //-- int getUsNbrEmpOnCallCntctOrd() 

    /**
     * Method hasBIndOverPolicyLimit
     * 
     * 
     * 
     * @return true if at least one BIndOverPolicyLimit has been
     * added
     */
    public boolean hasBIndOverPolicyLimit()
    {
        return this._has_bIndOverPolicyLimit;
    } //-- boolean hasBIndOverPolicyLimit() 

    /**
     * Method hasUlIdPerson
     * 
     * 
     * 
     * @return true if at least one UlIdPerson has been added
     */
    public boolean hasUlIdPerson()
    {
        return this._has_ulIdPerson;
    } //-- boolean hasUlIdPerson() 

    /**
     * Method hasUlIdUnit
     * 
     * 
     * 
     * @return true if at least one UlIdUnit has been added
     */
    public boolean hasUlIdUnit()
    {
        return this._has_ulIdUnit;
    } //-- boolean hasUlIdUnit() 

    /**
     * Method hasUsNbrEmpOnCallCntctOrd
     * 
     * 
     * 
     * @return true if at least one UsNbrEmpOnCallCntctOrd has been
     * added
     */
    public boolean hasUsNbrEmpOnCallCntctOrd()
    {
        return this._has_usNbrEmpOnCallCntctOrd;
    } //-- boolean hasUsNbrEmpOnCallCntctOrd() 

    /**
     * Returns the value of field 'bIndOverPolicyLimit'.
     * 
     * @return the value of field 'BIndOverPolicyLimit'.
     */
    public boolean isBIndOverPolicyLimit()
    {
        return this._bIndOverPolicyLimit;
    } //-- boolean isBIndOverPolicyLimit() 

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
     * Sets the value of field 'bIndOverPolicyLimit'.
     * 
     * @param bIndOverPolicyLimit the value of field
     * 'bIndOverPolicyLimit'.
     */
    public void setBIndOverPolicyLimit(boolean bIndOverPolicyLimit)
    {
        this._bIndOverPolicyLimit = bIndOverPolicyLimit;
        this._has_bIndOverPolicyLimit = true;
    } //-- void setBIndOverPolicyLimit(boolean) 

    /**
     * Sets the value of field 'dtDtEmpLastAssigned'.
     * 
     * @param dtDtEmpLastAssigned the value of field
     * 'dtDtEmpLastAssigned'.
     */
    public void setDtDtEmpLastAssigned(org.exolab.castor.types.Date dtDtEmpLastAssigned)
    {
        this._dtDtEmpLastAssigned = dtDtEmpLastAssigned;
    } //-- void setDtDtEmpLastAssigned(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'lNbrEmpOnCallExt1'.
     * 
     * @param lNbrEmpOnCallExt1 the value of field
     * 'lNbrEmpOnCallExt1'.
     */
    public void setLNbrEmpOnCallExt1(java.lang.String lNbrEmpOnCallExt1)
    {
        this._lNbrEmpOnCallExt1 = lNbrEmpOnCallExt1;
    } //-- void setLNbrEmpOnCallExt1(java.lang.String) 

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
     * Sets the value of field 'szBjnJob'.
     * 
     * @param szBjnJob the value of field 'szBjnJob'.
     */
    public void setSzBjnJob(java.lang.String szBjnJob)
    {
        this._szBjnJob = szBjnJob;
    } //-- void setSzBjnJob(java.lang.String) 

    /**
     * Sets the value of field 'szCdEmpOnCallDesig'.
     * 
     * @param szCdEmpOnCallDesig the value of field
     * 'szCdEmpOnCallDesig'.
     */
    public void setSzCdEmpOnCallDesig(java.lang.String szCdEmpOnCallDesig)
    {
        this._szCdEmpOnCallDesig = szCdEmpOnCallDesig;
    } //-- void setSzCdEmpOnCallDesig(java.lang.String) 

    /**
     * Sets the value of field 'szNbrEmpOnCallPhone1'.
     * 
     * @param szNbrEmpOnCallPhone1 the value of field
     * 'szNbrEmpOnCallPhone1'.
     */
    public void setSzNbrEmpOnCallPhone1(java.lang.String szNbrEmpOnCallPhone1)
    {
        this._szNbrEmpOnCallPhone1 = szNbrEmpOnCallPhone1;
    } //-- void setSzNbrEmpOnCallPhone1(java.lang.String) 

    /**
     * Sets the value of field 'szNbrUnit'.
     * 
     * @param szNbrUnit the value of field 'szNbrUnit'.
     */
    public void setSzNbrUnit(java.lang.String szNbrUnit)
    {
        this._szNbrUnit = szNbrUnit;
    } //-- void setSzNbrUnit(java.lang.String) 

    /**
     * Sets the value of field 'szNmOfficeName'.
     * 
     * @param szNmOfficeName the value of field 'szNmOfficeName'.
     */
    public void setSzNmOfficeName(java.lang.String szNmOfficeName)
    {
        this._szNmOfficeName = szNmOfficeName;
    } //-- void setSzNmOfficeName(java.lang.String) 

    /**
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

    /**
     * Sets the value of field 'tmScrTmEmpLastAssigned'.
     * 
     * @param tmScrTmEmpLastAssigned the value of field
     * 'tmScrTmEmpLastAssigned'.
     */
    public void setTmScrTmEmpLastAssigned(java.lang.String tmScrTmEmpLastAssigned)
    {
        this._tmScrTmEmpLastAssigned = tmScrTmEmpLastAssigned;
    } //-- void setTmScrTmEmpLastAssigned(java.lang.String) 

    /**
     * Sets the value of field 'ulIdPerson'.
     * 
     * @param ulIdPerson the value of field 'ulIdPerson'.
     */
    public void setUlIdPerson(int ulIdPerson)
    {
        this._ulIdPerson = ulIdPerson;
        this._has_ulIdPerson = true;
    } //-- void setUlIdPerson(int) 

    /**
     * Sets the value of field 'ulIdUnit'.
     * 
     * @param ulIdUnit the value of field 'ulIdUnit'.
     */
    public void setUlIdUnit(int ulIdUnit)
    {
        this._ulIdUnit = ulIdUnit;
        this._has_ulIdUnit = true;
    } //-- void setUlIdUnit(int) 

    /**
     * Sets the value of field 'usNbrEmpOnCallCntctOrd'.
     * 
     * @param usNbrEmpOnCallCntctOrd the value of field
     * 'usNbrEmpOnCallCntctOrd'.
     */
    public void setUsNbrEmpOnCallCntctOrd(int usNbrEmpOnCallCntctOrd)
    {
        this._usNbrEmpOnCallCntctOrd = usNbrEmpOnCallCntctOrd;
        this._has_usNbrEmpOnCallCntctOrd = true;
    } //-- void setUsNbrEmpOnCallCntctOrd(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup unmarshal(java.io.Reader) 

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
