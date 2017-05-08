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
 * Class CCMNH7SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMNH7SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdRegion
     */
    private java.lang.String _szCdRegion;

    /**
     * Field _szCdOnCallCounty
     */
    private java.lang.String _szCdOnCallCounty;

    /**
     * Field _cdIdOnCall
     */
    private int _cdIdOnCall;

    /**
     * keeps track of state for field: _cdIdOnCall
     */
    private boolean _has_cdIdOnCall;

    /**
     * Field _usPageNbr_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.UsPageNbr_ARRAY _usPageNbr_ARRAY;

    /**
     * Field _ulPageSizeNbr_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY _ulPageSizeNbr_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMNH7SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH7SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteCdIdOnCall()
    {
        this._has_cdIdOnCall= false;
    } //-- void deleteCdIdOnCall() 

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
     * Returns the value of field 'cdIdOnCall'.
     * 
     * @return the value of field 'CdIdOnCall'.
     */
    public int getCdIdOnCall()
    {
        return this._cdIdOnCall;
    } //-- int getCdIdOnCall() 

    /**
     * Returns the value of field 'szCdOnCallCounty'.
     * 
     * @return the value of field 'SzCdOnCallCounty'.
     */
    public java.lang.String getSzCdOnCallCounty()
    {
        return this._szCdOnCallCounty;
    } //-- java.lang.String getSzCdOnCallCounty() 

    /**
     * Returns the value of field 'szCdRegion'.
     * 
     * @return the value of field 'SzCdRegion'.
     */
    public java.lang.String getSzCdRegion()
    {
        return this._szCdRegion;
    } //-- java.lang.String getSzCdRegion() 

    /**
     * Returns the value of field 'ulPageSizeNbr_ARRAY'.
     * 
     * @return the value of field 'UlPageSizeNbr_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY getUlPageSizeNbr_ARRAY()
    {
        return this._ulPageSizeNbr_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY getUlPageSizeNbr_ARRAY() 

    /**
     * Returns the value of field 'usPageNbr_ARRAY'.
     * 
     * @return the value of field 'UsPageNbr_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.UsPageNbr_ARRAY getUsPageNbr_ARRAY()
    {
        return this._usPageNbr_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UsPageNbr_ARRAY getUsPageNbr_ARRAY() 

    /**
     * Method hasCdIdOnCall
     * 
     * 
     * 
     * @return true if at least one CdIdOnCall has been added
     */
    public boolean hasCdIdOnCall()
    {
        return this._has_cdIdOnCall;
    } //-- boolean hasCdIdOnCall() 

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
     * Sets the value of field 'cdIdOnCall'.
     * 
     * @param cdIdOnCall the value of field 'cdIdOnCall'.
     */
    public void setCdIdOnCall(int cdIdOnCall)
    {
        this._cdIdOnCall = cdIdOnCall;
        this._has_cdIdOnCall = true;
    } //-- void setCdIdOnCall(int) 

    /**
     * Sets the value of field 'szCdOnCallCounty'.
     * 
     * @param szCdOnCallCounty the value of field 'szCdOnCallCounty'
     */
    public void setSzCdOnCallCounty(java.lang.String szCdOnCallCounty)
    {
        this._szCdOnCallCounty = szCdOnCallCounty;
    } //-- void setSzCdOnCallCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdRegion'.
     * 
     * @param szCdRegion the value of field 'szCdRegion'.
     */
    public void setSzCdRegion(java.lang.String szCdRegion)
    {
        this._szCdRegion = szCdRegion;
    } //-- void setSzCdRegion(java.lang.String) 

    /**
     * Sets the value of field 'ulPageSizeNbr_ARRAY'.
     * 
     * @param ulPageSizeNbr_ARRAY the value of field
     * 'ulPageSizeNbr_ARRAY'.
     */
    public void setUlPageSizeNbr_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY ulPageSizeNbr_ARRAY)
    {
        this._ulPageSizeNbr_ARRAY = ulPageSizeNbr_ARRAY;
    } //-- void setUlPageSizeNbr_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY) 

    /**
     * Sets the value of field 'usPageNbr_ARRAY'.
     * 
     * @param usPageNbr_ARRAY the value of field 'usPageNbr_ARRAY'.
     */
    public void setUsPageNbr_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.UsPageNbr_ARRAY usPageNbr_ARRAY)
    {
        this._usPageNbr_ARRAY = usPageNbr_ARRAY;
    } //-- void setUsPageNbr_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.UsPageNbr_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH7SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH7SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH7SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH7SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH7SI unmarshal(java.io.Reader) 

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
