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
 * Class HierSrchOutRec.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class HierSrchOutRec extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _lSysNbrUniqueLBKey
     */
    private int _lSysNbrUniqueLBKey;

    /**
     * keeps track of state for field: _lSysNbrUniqueLBKey
     */
    private boolean _has_lSysNbrUniqueLBKey;

    /**
     * Field _prsnSrchListpInit_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit_ARRAY _prsnSrchListpInit_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public HierSrchOutRec() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.HierSrchOutRec()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLSysNbrUniqueLBKey()
    {
        this._has_lSysNbrUniqueLBKey= false;
    } //-- void deleteLSysNbrUniqueLBKey() 

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
     * Returns the value of field 'lSysNbrUniqueLBKey'.
     * 
     * @return the value of field 'LSysNbrUniqueLBKey'.
     */
    public int getLSysNbrUniqueLBKey()
    {
        return this._lSysNbrUniqueLBKey;
    } //-- int getLSysNbrUniqueLBKey() 

    /**
     * Returns the value of field 'prsnSrchListpInit_ARRAY'.
     * 
     * @return the value of field 'PrsnSrchListpInit_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit_ARRAY getPrsnSrchListpInit_ARRAY()
    {
        return this._prsnSrchListpInit_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit_ARRAY getPrsnSrchListpInit_ARRAY() 

    /**
     * Method hasLSysNbrUniqueLBKey
     * 
     * 
     * 
     * @return true if at least one LSysNbrUniqueLBKey has been adde
     */
    public boolean hasLSysNbrUniqueLBKey()
    {
        return this._has_lSysNbrUniqueLBKey;
    } //-- boolean hasLSysNbrUniqueLBKey() 

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
     * Sets the value of field 'lSysNbrUniqueLBKey'.
     * 
     * @param lSysNbrUniqueLBKey the value of field
     * 'lSysNbrUniqueLBKey'.
     */
    public void setLSysNbrUniqueLBKey(int lSysNbrUniqueLBKey)
    {
        this._lSysNbrUniqueLBKey = lSysNbrUniqueLBKey;
        this._has_lSysNbrUniqueLBKey = true;
    } //-- void setLSysNbrUniqueLBKey(int) 

    /**
     * Sets the value of field 'prsnSrchListpInit_ARRAY'.
     * 
     * @param prsnSrchListpInit_ARRAY the value of field
     * 'prsnSrchListpInit_ARRAY'.
     */
    public void setPrsnSrchListpInit_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit_ARRAY prsnSrchListpInit_ARRAY)
    {
        this._prsnSrchListpInit_ARRAY = prsnSrchListpInit_ARRAY;
    } //-- void setPrsnSrchListpInit_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.HierSrchOutRec
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.HierSrchOutRec unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.HierSrchOutRec) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.HierSrchOutRec.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.HierSrchOutRec unmarshal(java.io.Reader) 

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
