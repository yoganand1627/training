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
 * Class ROWCARC01SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCARC01SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szNmSecurityClass
     */
    private java.lang.String _szNmSecurityClass;

    /**
     * Field _szCdEmployeeClass
     */
    private java.lang.String _szCdEmployeeClass;

    /**
     * Field _dtTempAssignExpir
     */
    private org.exolab.castor.types.Date _dtTempAssignExpir;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCARC01SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO()


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
     * Returns the value of field 'dtTempAssignExpir'.
     * 
     * @return the value of field 'DtTempAssignExpir'.
     */
    public org.exolab.castor.types.Date getDtTempAssignExpir()
    {
        return this._dtTempAssignExpir;
    } //-- org.exolab.castor.types.Date getDtTempAssignExpir() 

    /**
     * Returns the value of field 'szCdEmployeeClass'.
     * 
     * @return the value of field 'SzCdEmployeeClass'.
     */
    public java.lang.String getSzCdEmployeeClass()
    {
        return this._szCdEmployeeClass;
    } //-- java.lang.String getSzCdEmployeeClass() 

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
     * Sets the value of field 'dtTempAssignExpir'.
     * 
     * @param dtTempAssignExpir the value of field
     * 'dtTempAssignExpir'.
     */
    public void setDtTempAssignExpir(org.exolab.castor.types.Date dtTempAssignExpir)
    {
        this._dtTempAssignExpir = dtTempAssignExpir;
    } //-- void setDtTempAssignExpir(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdEmployeeClass'.
     * 
     * @param szCdEmployeeClass the value of field
     * 'szCdEmployeeClass'.
     */
    public void setSzCdEmployeeClass(java.lang.String szCdEmployeeClass)
    {
        this._szCdEmployeeClass = szCdEmployeeClass;
    } //-- void setSzCdEmployeeClass(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO unmarshal(java.io.Reader) 

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
