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
 * Class CINT14WLB.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINT14WLB extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdPersonIdType
     */
    private java.lang.String _szCdPersonIdType;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;

    /**
     * Field _bIndPersonIDInvalid
     */
    private java.lang.String _bIndPersonIDInvalid;

    /**
     * Field _szDescPersonID
     */
    private java.lang.String _szDescPersonID;

    /**
     * Field _dtPersonIDStart
     */
    private org.exolab.castor.types.Date _dtPersonIDStart;

    /**
     * Field _dtPersonIDEnd
     */
    private org.exolab.castor.types.Date _dtPersonIDEnd;

    /**
     * Field _szNbrPersonIdNumber
     */
    private java.lang.String _szNbrPersonIdNumber;

    /**
     * Field _ulIdPersonId
     */
    private int _ulIdPersonId;

    /**
     * keeps track of state for field: _ulIdPersonId
     */
    private boolean _has_ulIdPersonId;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _tsSysTsLastUpdate2
     */
    private java.util.Date _tsSysTsLastUpdate2;

    /**
     * Field _bIndValidateByInterface
     */
    private java.lang.String _bIndValidateByInterface;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINT14WLB() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdPersonId()
    {
        this._has_ulIdPersonId= false;
    } //-- void deleteUlIdPersonId() 

    /**
     * Returns the value of field 'bIndPersonIDInvalid'.
     * 
     * @return the value of field 'BIndPersonIDInvalid'.
     */
    public java.lang.String getBIndPersonIDInvalid()
    {
        return this._bIndPersonIDInvalid;
    } //-- java.lang.String getBIndPersonIDInvalid() 

    /**
     * Returns the value of field 'bIndValidateByInterface'.
     * 
     * @return the value of field 'BIndValidateByInterface'.
     */
    public java.lang.String getBIndValidateByInterface()
    {
        return this._bIndValidateByInterface;
    } //-- java.lang.String getBIndValidateByInterface() 

    /**
     * Returns the value of field 'dtPersonIDEnd'.
     * 
     * @return the value of field 'DtPersonIDEnd'.
     */
    public org.exolab.castor.types.Date getDtPersonIDEnd()
    {
        return this._dtPersonIDEnd;
    } //-- org.exolab.castor.types.Date getDtPersonIDEnd() 

    /**
     * Returns the value of field 'dtPersonIDStart'.
     * 
     * @return the value of field 'DtPersonIDStart'.
     */
    public org.exolab.castor.types.Date getDtPersonIDStart()
    {
        return this._dtPersonIDStart;
    } //-- org.exolab.castor.types.Date getDtPersonIDStart() 

    /**
     * Returns the value of field 'szCdPersonIdType'.
     * 
     * @return the value of field 'SzCdPersonIdType'.
     */
    public java.lang.String getSzCdPersonIdType()
    {
        return this._szCdPersonIdType;
    } //-- java.lang.String getSzCdPersonIdType() 

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
     * Returns the value of field 'szDescPersonID'.
     * 
     * @return the value of field 'SzDescPersonID'.
     */
    public java.lang.String getSzDescPersonID()
    {
        return this._szDescPersonID;
    } //-- java.lang.String getSzDescPersonID() 

    /**
     * Returns the value of field 'szNbrPersonIdNumber'.
     * 
     * @return the value of field 'SzNbrPersonIdNumber'.
     */
    public java.lang.String getSzNbrPersonIdNumber()
    {
        return this._szNbrPersonIdNumber;
    } //-- java.lang.String getSzNbrPersonIdNumber() 

    /**
     * Returns the value of field 'tsSysTsLastUpdate2'.
     * 
     * @return the value of field 'TsSysTsLastUpdate2'.
     */
    public java.util.Date getTsSysTsLastUpdate2()
    {
        return this._tsSysTsLastUpdate2;
    } //-- java.util.Date getTsSysTsLastUpdate2() 

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
     * Returns the value of field 'ulIdPersonId'.
     * 
     * @return the value of field 'UlIdPersonId'.
     */
    public int getUlIdPersonId()
    {
        return this._ulIdPersonId;
    } //-- int getUlIdPersonId() 

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
     * Method hasUlIdPersonId
     * 
     * 
     * 
     * @return true if at least one UlIdPersonId has been added
     */
    public boolean hasUlIdPersonId()
    {
        return this._has_ulIdPersonId;
    } //-- boolean hasUlIdPersonId() 

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
     * Sets the value of field 'bIndPersonIDInvalid'.
     * 
     * @param bIndPersonIDInvalid the value of field
     * 'bIndPersonIDInvalid'.
     */
    public void setBIndPersonIDInvalid(java.lang.String bIndPersonIDInvalid)
    {
        this._bIndPersonIDInvalid = bIndPersonIDInvalid;
    } //-- void setBIndPersonIDInvalid(java.lang.String) 

    /**
     * Sets the value of field 'bIndValidateByInterface'.
     * 
     * @param bIndValidateByInterface the value of field
     * 'bIndValidateByInterface'.
     */
    public void setBIndValidateByInterface(java.lang.String bIndValidateByInterface)
    {
        this._bIndValidateByInterface = bIndValidateByInterface;
    } //-- void setBIndValidateByInterface(java.lang.String) 

    /**
     * Sets the value of field 'dtPersonIDEnd'.
     * 
     * @param dtPersonIDEnd the value of field 'dtPersonIDEnd'.
     */
    public void setDtPersonIDEnd(org.exolab.castor.types.Date dtPersonIDEnd)
    {
        this._dtPersonIDEnd = dtPersonIDEnd;
    } //-- void setDtPersonIDEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtPersonIDStart'.
     * 
     * @param dtPersonIDStart the value of field 'dtPersonIDStart'.
     */
    public void setDtPersonIDStart(org.exolab.castor.types.Date dtPersonIDStart)
    {
        this._dtPersonIDStart = dtPersonIDStart;
    } //-- void setDtPersonIDStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdPersonIdType'.
     * 
     * @param szCdPersonIdType the value of field 'szCdPersonIdType'
     */
    public void setSzCdPersonIdType(java.lang.String szCdPersonIdType)
    {
        this._szCdPersonIdType = szCdPersonIdType;
    } //-- void setSzCdPersonIdType(java.lang.String) 

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
     * Sets the value of field 'szDescPersonID'.
     * 
     * @param szDescPersonID the value of field 'szDescPersonID'.
     */
    public void setSzDescPersonID(java.lang.String szDescPersonID)
    {
        this._szDescPersonID = szDescPersonID;
    } //-- void setSzDescPersonID(java.lang.String) 

    /**
     * Sets the value of field 'szNbrPersonIdNumber'.
     * 
     * @param szNbrPersonIdNumber the value of field
     * 'szNbrPersonIdNumber'.
     */
    public void setSzNbrPersonIdNumber(java.lang.String szNbrPersonIdNumber)
    {
        this._szNbrPersonIdNumber = szNbrPersonIdNumber;
    } //-- void setSzNbrPersonIdNumber(java.lang.String) 

    /**
     * Sets the value of field 'tsSysTsLastUpdate2'.
     * 
     * @param tsSysTsLastUpdate2 the value of field
     * 'tsSysTsLastUpdate2'.
     */
    public void setTsSysTsLastUpdate2(java.util.Date tsSysTsLastUpdate2)
    {
        this._tsSysTsLastUpdate2 = tsSysTsLastUpdate2;
    } //-- void setTsSysTsLastUpdate2(java.util.Date) 

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
     * Sets the value of field 'ulIdPersonId'.
     * 
     * @param ulIdPersonId the value of field 'ulIdPersonId'.
     */
    public void setUlIdPersonId(int ulIdPersonId)
    {
        this._ulIdPersonId = ulIdPersonId;
        this._has_ulIdPersonId = true;
    } //-- void setUlIdPersonId(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB unmarshal(java.io.Reader) 

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
