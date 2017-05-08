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
 * Class AssignedStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AssignedStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdTodoPersAssigned
     */
    private int _ulIdTodoPersAssigned;

    /**
     * keeps track of state for field: _ulIdTodoPersAssigned
     */
    private boolean _has_ulIdTodoPersAssigned;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;


      //----------------/
     //- Constructors -/
    //----------------/

    public AssignedStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AssignedStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdTodoPersAssigned()
    {
        this._has_ulIdTodoPersAssigned= false;
    } //-- void deleteUlIdTodoPersAssigned() 

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
     * Returns the value of field 'ulIdTodoPersAssigned'.
     * 
     * @return the value of field 'UlIdTodoPersAssigned'.
     */
    public int getUlIdTodoPersAssigned()
    {
        return this._ulIdTodoPersAssigned;
    } //-- int getUlIdTodoPersAssigned() 

    /**
     * Method hasUlIdTodoPersAssigned
     * 
     * 
     * 
     * @return true if at least one UlIdTodoPersAssigned has been
     * added
     */
    public boolean hasUlIdTodoPersAssigned()
    {
        return this._has_ulIdTodoPersAssigned;
    } //-- boolean hasUlIdTodoPersAssigned() 

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
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

    /**
     * Sets the value of field 'ulIdTodoPersAssigned'.
     * 
     * @param ulIdTodoPersAssigned the value of field
     * 'ulIdTodoPersAssigned'.
     */
    public void setUlIdTodoPersAssigned(int ulIdTodoPersAssigned)
    {
        this._ulIdTodoPersAssigned = ulIdTodoPersAssigned;
        this._has_ulIdTodoPersAssigned = true;
    } //-- void setUlIdTodoPersAssigned(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.AssignedStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.AssignedStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AssignedStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.AssignedStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AssignedStruct unmarshal(java.io.Reader) 

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
