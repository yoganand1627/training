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
 * Class CFAD31SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD31SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _CFAD31SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00_ARRAY _CFAD31SOG00_ARRAY;

    /**
     * Field _currPlacementStats
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CurrPlacementStats _currPlacementStats;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD31SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

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
     * Returns the value of field 'CFAD31SOG00_ARRAY'.
     * 
     * @return the value of field 'CFAD31SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00_ARRAY getCFAD31SOG00_ARRAY()
    {
        return this._CFAD31SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00_ARRAY getCFAD31SOG00_ARRAY() 

    /**
     * Returns the value of field 'currPlacementStats'.
     * 
     * @return the value of field 'CurrPlacementStats'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CurrPlacementStats getCurrPlacementStats()
    {
        return this._currPlacementStats;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CurrPlacementStats getCurrPlacementStats() 

    /**
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Method hasUlIdResource
     * 
     * 
     * 
     * @return true if at least one UlIdResource has been added
     */
    public boolean hasUlIdResource()
    {
        return this._has_ulIdResource;
    } //-- boolean hasUlIdResource() 

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
     * Sets the value of field 'CFAD31SOG00_ARRAY'.
     * 
     * @param CFAD31SOG00_ARRAY the value of field
     * 'CFAD31SOG00_ARRAY'.
     */
    public void setCFAD31SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00_ARRAY CFAD31SOG00_ARRAY)
    {
        this._CFAD31SOG00_ARRAY = CFAD31SOG00_ARRAY;
    } //-- void setCFAD31SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00_ARRAY) 

    /**
     * Sets the value of field 'currPlacementStats'.
     * 
     * @param currPlacementStats the value of field
     * 'currPlacementStats'.
     */
    public void setCurrPlacementStats(gov.georgia.dhr.dfcs.sacwis.structs.output.CurrPlacementStats currPlacementStats)
    {
        this._currPlacementStats = currPlacementStats;
    } //-- void setCurrPlacementStats(gov.georgia.dhr.dfcs.sacwis.structs.output.CurrPlacementStats) 

    /**
     * Sets the value of field 'ulIdResource'.
     * 
     * @param ulIdResource the value of field 'ulIdResource'.
     */
    public void setUlIdResource(int ulIdResource)
    {
        this._ulIdResource = ulIdResource;
        this._has_ulIdResource = true;
    } //-- void setUlIdResource(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SO unmarshal(java.io.Reader) 

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
