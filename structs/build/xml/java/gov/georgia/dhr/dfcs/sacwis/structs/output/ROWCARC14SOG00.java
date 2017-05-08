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
 * Class ROWCARC14SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCARC14SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdEmpTempAssign
     */
    private int _ulIdEmpTempAssign;

    /**
     * keeps track of state for field: _ulIdEmpTempAssign
     */
    private boolean _has_ulIdEmpTempAssign;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdPersonDesignee
     */
    private int _ulIdPersonDesignee;

    /**
     * keeps track of state for field: _ulIdPersonDesignee
     */
    private boolean _has_ulIdPersonDesignee;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _dtDtAssignExpiration
     */
    private org.exolab.castor.types.Date _dtDtAssignExpiration;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCARC14SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEmpTempAssign()
    {
        this._has_ulIdEmpTempAssign= false;
    } //-- void deleteUlIdEmpTempAssign() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdPersonDesignee()
    {
        this._has_ulIdPersonDesignee= false;
    } //-- void deleteUlIdPersonDesignee() 

    /**
     * Returns the value of field 'dtDtAssignExpiration'.
     * 
     * @return the value of field 'DtDtAssignExpiration'.
     */
    public org.exolab.castor.types.Date getDtDtAssignExpiration()
    {
        return this._dtDtAssignExpiration;
    } //-- org.exolab.castor.types.Date getDtDtAssignExpiration() 

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
     * Returns the value of field 'tsLastUpdate'.
     * 
     * @return the value of field 'TsLastUpdate'.
     */
    public java.util.Date getTsLastUpdate()
    {
        return this._tsLastUpdate;
    } //-- java.util.Date getTsLastUpdate() 

    /**
     * Returns the value of field 'ulIdEmpTempAssign'.
     * 
     * @return the value of field 'UlIdEmpTempAssign'.
     */
    public int getUlIdEmpTempAssign()
    {
        return this._ulIdEmpTempAssign;
    } //-- int getUlIdEmpTempAssign() 

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
     * Returns the value of field 'ulIdPersonDesignee'.
     * 
     * @return the value of field 'UlIdPersonDesignee'.
     */
    public int getUlIdPersonDesignee()
    {
        return this._ulIdPersonDesignee;
    } //-- int getUlIdPersonDesignee() 

    /**
     * Method hasUlIdEmpTempAssign
     * 
     * 
     * 
     * @return true if at least one UlIdEmpTempAssign has been added
     */
    public boolean hasUlIdEmpTempAssign()
    {
        return this._has_ulIdEmpTempAssign;
    } //-- boolean hasUlIdEmpTempAssign() 

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
     * Method hasUlIdPersonDesignee
     * 
     * 
     * 
     * @return true if at least one UlIdPersonDesignee has been adde
     */
    public boolean hasUlIdPersonDesignee()
    {
        return this._has_ulIdPersonDesignee;
    } //-- boolean hasUlIdPersonDesignee() 

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
     * Sets the value of field 'dtDtAssignExpiration'.
     * 
     * @param dtDtAssignExpiration the value of field
     * 'dtDtAssignExpiration'.
     */
    public void setDtDtAssignExpiration(org.exolab.castor.types.Date dtDtAssignExpiration)
    {
        this._dtDtAssignExpiration = dtDtAssignExpiration;
    } //-- void setDtDtAssignExpiration(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'tsLastUpdate'.
     * 
     * @param tsLastUpdate the value of field 'tsLastUpdate'.
     */
    public void setTsLastUpdate(java.util.Date tsLastUpdate)
    {
        this._tsLastUpdate = tsLastUpdate;
    } //-- void setTsLastUpdate(java.util.Date) 

    /**
     * Sets the value of field 'ulIdEmpTempAssign'.
     * 
     * @param ulIdEmpTempAssign the value of field
     * 'ulIdEmpTempAssign'.
     */
    public void setUlIdEmpTempAssign(int ulIdEmpTempAssign)
    {
        this._ulIdEmpTempAssign = ulIdEmpTempAssign;
        this._has_ulIdEmpTempAssign = true;
    } //-- void setUlIdEmpTempAssign(int) 

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
     * Sets the value of field 'ulIdPersonDesignee'.
     * 
     * @param ulIdPersonDesignee the value of field
     * 'ulIdPersonDesignee'.
     */
    public void setUlIdPersonDesignee(int ulIdPersonDesignee)
    {
        this._ulIdPersonDesignee = ulIdPersonDesignee;
        this._has_ulIdPersonDesignee = true;
    } //-- void setUlIdPersonDesignee(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00 unmarshal(java.io.Reader) 

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
