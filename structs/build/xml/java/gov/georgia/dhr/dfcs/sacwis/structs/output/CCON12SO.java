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
 * Class CCON12SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCON12SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archOutputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct _archOutputStruct;

    /**
     * Field _ulSysNbrGenericCntr
     */
    private int _ulSysNbrGenericCntr;

    /**
     * keeps track of state for field: _ulSysNbrGenericCntr
     */
    private boolean _has_ulSysNbrGenericCntr;

    /**
     * Field _csli_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.Csli_ARRAY _csli_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCON12SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCON12SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlSysNbrGenericCntr()
    {
        this._has_ulSysNbrGenericCntr= false;
    } //-- void deleteUlSysNbrGenericCntr() 

    /**
     * Returns the value of field 'archOutputStruct'.
     * 
     * @return the value of field 'ArchOutputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct()
    {
        return this._archOutputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct() 

    /**
     * Returns the value of field 'csli_ARRAY'.
     * 
     * @return the value of field 'Csli_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.Csli_ARRAY getCsli_ARRAY()
    {
        return this._csli_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.Csli_ARRAY getCsli_ARRAY() 

    /**
     * Returns the value of field 'ulSysNbrGenericCntr'.
     * 
     * @return the value of field 'UlSysNbrGenericCntr'.
     */
    public int getUlSysNbrGenericCntr()
    {
        return this._ulSysNbrGenericCntr;
    } //-- int getUlSysNbrGenericCntr() 

    /**
     * Method hasUlSysNbrGenericCntr
     * 
     * 
     * 
     * @return true if at least one UlSysNbrGenericCntr has been
     * added
     */
    public boolean hasUlSysNbrGenericCntr()
    {
        return this._has_ulSysNbrGenericCntr;
    } //-- boolean hasUlSysNbrGenericCntr() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

    /**
     * Sets the value of field 'csli_ARRAY'.
     * 
     * @param csli_ARRAY the value of field 'csli_ARRAY'.
     */
    public void setCsli_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.Csli_ARRAY csli_ARRAY)
    {
        this._csli_ARRAY = csli_ARRAY;
    } //-- void setCsli_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.Csli_ARRAY) 

    /**
     * Sets the value of field 'ulSysNbrGenericCntr'.
     * 
     * @param ulSysNbrGenericCntr the value of field
     * 'ulSysNbrGenericCntr'.
     */
    public void setUlSysNbrGenericCntr(int ulSysNbrGenericCntr)
    {
        this._ulSysNbrGenericCntr = ulSysNbrGenericCntr;
        this._has_ulSysNbrGenericCntr = true;
    } //-- void setUlSysNbrGenericCntr(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCON12SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCON12SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCON12SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCON12SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCON12SO unmarshal(java.io.Reader) 

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
