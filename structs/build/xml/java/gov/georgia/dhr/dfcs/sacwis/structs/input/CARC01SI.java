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
 * Class CARC01SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CARC01SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szIdEmployeeLogon
     */
    private java.lang.String _szIdEmployeeLogon;

    /**
     * Field _bIndLoginPersonType
     */
    private java.lang.String _bIndLoginPersonType;


      //----------------/
     //- Constructors -/
    //----------------/

    public CARC01SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CARC01SI()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'bIndLoginPersonType'.
     * 
     * @return the value of field 'BIndLoginPersonType'.
     */
    public java.lang.String getBIndLoginPersonType()
    {
        return this._bIndLoginPersonType;
    } //-- java.lang.String getBIndLoginPersonType() 

    /**
     * Returns the value of field 'szIdEmployeeLogon'.
     * 
     * @return the value of field 'SzIdEmployeeLogon'.
     */
    public java.lang.String getSzIdEmployeeLogon()
    {
        return this._szIdEmployeeLogon;
    } //-- java.lang.String getSzIdEmployeeLogon() 

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
     * Sets the value of field 'bIndLoginPersonType'.
     * 
     * @param bIndLoginPersonType the value of field
     * 'bIndLoginPersonType'.
     */
    public void setBIndLoginPersonType(java.lang.String bIndLoginPersonType)
    {
        this._bIndLoginPersonType = bIndLoginPersonType;
    } //-- void setBIndLoginPersonType(java.lang.String) 

    /**
     * Sets the value of field 'szIdEmployeeLogon'.
     * 
     * @param szIdEmployeeLogon the value of field
     * 'szIdEmployeeLogon'.
     */
    public void setSzIdEmployeeLogon(java.lang.String szIdEmployeeLogon)
    {
        this._szIdEmployeeLogon = szIdEmployeeLogon;
    } //-- void setSzIdEmployeeLogon(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CARC01SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CARC01SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CARC01SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CARC01SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CARC01SI unmarshal(java.io.Reader) 

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
