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
 * Class CFIN21SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFIN21SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _dScrAmtFinPayhistTotpy
     */
    private double _dScrAmtFinPayhistTotpy;

    /**
     * keeps track of state for field: _dScrAmtFinPayhistTotpy
     */
    private boolean _has_dScrAmtFinPayhistTotpy;

    /**
     * Field _ROWCFIN21SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN21SOG00_ARRAY _ROWCFIN21SOG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFIN21SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN21SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteDScrAmtFinPayhistTotpy()
    {
        this._has_dScrAmtFinPayhistTotpy= false;
    } //-- void deleteDScrAmtFinPayhistTotpy() 

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
     * Returns the value of field 'dScrAmtFinPayhistTotpy'.
     * 
     * @return the value of field 'DScrAmtFinPayhistTotpy'.
     */
    public double getDScrAmtFinPayhistTotpy()
    {
        return this._dScrAmtFinPayhistTotpy;
    } //-- double getDScrAmtFinPayhistTotpy() 

    /**
     * Returns the value of field 'ROWCFIN21SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCFIN21SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN21SOG00_ARRAY getROWCFIN21SOG00_ARRAY()
    {
        return this._ROWCFIN21SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN21SOG00_ARRAY getROWCFIN21SOG00_ARRAY() 

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
     * Method hasDScrAmtFinPayhistTotpy
     * 
     * 
     * 
     * @return true if at least one DScrAmtFinPayhistTotpy has been
     * added
     */
    public boolean hasDScrAmtFinPayhistTotpy()
    {
        return this._has_dScrAmtFinPayhistTotpy;
    } //-- boolean hasDScrAmtFinPayhistTotpy() 

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
     * Sets the value of field 'dScrAmtFinPayhistTotpy'.
     * 
     * @param dScrAmtFinPayhistTotpy the value of field
     * 'dScrAmtFinPayhistTotpy'.
     */
    public void setDScrAmtFinPayhistTotpy(double dScrAmtFinPayhistTotpy)
    {
        this._dScrAmtFinPayhistTotpy = dScrAmtFinPayhistTotpy;
        this._has_dScrAmtFinPayhistTotpy = true;
    } //-- void setDScrAmtFinPayhistTotpy(double) 

    /**
     * Sets the value of field 'ROWCFIN21SOG00_ARRAY'.
     * 
     * @param ROWCFIN21SOG00_ARRAY the value of field
     * 'ROWCFIN21SOG00_ARRAY'.
     */
    public void setROWCFIN21SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN21SOG00_ARRAY ROWCFIN21SOG00_ARRAY)
    {
        this._ROWCFIN21SOG00_ARRAY = ROWCFIN21SOG00_ARRAY;
    } //-- void setROWCFIN21SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN21SOG00_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN21SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN21SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN21SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN21SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN21SO unmarshal(java.io.Reader) 

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
