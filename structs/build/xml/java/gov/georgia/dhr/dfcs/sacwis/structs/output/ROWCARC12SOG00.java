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
 * Class ROWCARC12SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCARC12SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szNmSecurityClass
     */
    private java.lang.String _szNmSecurityClass;

    /**
     * Field _cIndRestrict
     */
    private java.lang.String _cIndRestrict;

    /**
     * Field _szTxtSecurityClassProfil
     */
    private java.lang.String _szTxtSecurityClassProfil;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCARC12SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC12SOG00()


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
     * Returns the value of field 'cIndRestrict'.
     * 
     * @return the value of field 'CIndRestrict'.
     */
    public java.lang.String getCIndRestrict()
    {
        return this._cIndRestrict;
    } //-- java.lang.String getCIndRestrict() 

    /**
     * Returns the value of field 'szNmSecurityClass'.
     * 
     * @return the value of field 'SzNmSecurityClass'.
     */
    public java.lang.String getSzNmSecurityClass()
    {
        return this._szNmSecurityClass;
    } //-- java.lang.String getSzNmSecurityClass() 

    /**
     * Returns the value of field 'szTxtSecurityClassProfil'.
     * 
     * @return the value of field 'SzTxtSecurityClassProfil'.
     */
    public java.lang.String getSzTxtSecurityClassProfil()
    {
        return this._szTxtSecurityClassProfil;
    } //-- java.lang.String getSzTxtSecurityClassProfil() 

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
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

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
     * Sets the value of field 'cIndRestrict'.
     * 
     * @param cIndRestrict the value of field 'cIndRestrict'.
     */
    public void setCIndRestrict(java.lang.String cIndRestrict)
    {
        this._cIndRestrict = cIndRestrict;
    } //-- void setCIndRestrict(java.lang.String) 

    /**
     * Sets the value of field 'szNmSecurityClass'.
     * 
     * @param szNmSecurityClass the value of field
     * 'szNmSecurityClass'.
     */
    public void setSzNmSecurityClass(java.lang.String szNmSecurityClass)
    {
        this._szNmSecurityClass = szNmSecurityClass;
    } //-- void setSzNmSecurityClass(java.lang.String) 

    /**
     * Sets the value of field 'szTxtSecurityClassProfil'.
     * 
     * @param szTxtSecurityClassProfil the value of field
     * 'szTxtSecurityClassProfil'.
     */
    public void setSzTxtSecurityClassProfil(java.lang.String szTxtSecurityClassProfil)
    {
        this._szTxtSecurityClassProfil = szTxtSecurityClassProfil;
    } //-- void setSzTxtSecurityClassProfil(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC12SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC12SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC12SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC12SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC12SOG00 unmarshal(java.io.Reader) 

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
