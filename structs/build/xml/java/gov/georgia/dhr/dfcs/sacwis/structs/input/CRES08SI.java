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
 * Class CRES08SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CRES08SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _ulIdResourceService
     */
    private int _ulIdResourceService;

    /**
     * keeps track of state for field: _ulIdResourceService
     */
    private boolean _has_ulIdResourceService;

    /**
     * Field _szCdRsrcCharRegion
     */
    private java.lang.String _szCdRsrcCharRegion;

    /**
     * Field _szCdRsrcCharService
     */
    private java.lang.String _szCdRsrcCharService;

    /**
     * Field _ulRowQty
     */
    private int _ulRowQty;

    /**
     * keeps track of state for field: _ulRowQty
     */
    private boolean _has_ulRowQty;

    /**
     * Field _ROWCRES08SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG00_ARRAY _ROWCRES08SIG00_ARRAY;

    /**
     * Field _ROWCRES08SIG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG01_ARRAY _ROWCRES08SIG01_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CRES08SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CRES08SI()


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
     */
    public void deleteUlIdResourceService()
    {
        this._has_ulIdResourceService= false;
    } //-- void deleteUlIdResourceService() 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

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
     * Returns the value of field 'ROWCRES08SIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCRES08SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG00_ARRAY getROWCRES08SIG00_ARRAY()
    {
        return this._ROWCRES08SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG00_ARRAY getROWCRES08SIG00_ARRAY() 

    /**
     * Returns the value of field 'ROWCRES08SIG01_ARRAY'.
     * 
     * @return the value of field 'ROWCRES08SIG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG01_ARRAY getROWCRES08SIG01_ARRAY()
    {
        return this._ROWCRES08SIG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG01_ARRAY getROWCRES08SIG01_ARRAY() 

    /**
     * Returns the value of field 'szCdRsrcCharRegion'.
     * 
     * @return the value of field 'SzCdRsrcCharRegion'.
     */
    public java.lang.String getSzCdRsrcCharRegion()
    {
        return this._szCdRsrcCharRegion;
    } //-- java.lang.String getSzCdRsrcCharRegion() 

    /**
     * Returns the value of field 'szCdRsrcCharService'.
     * 
     * @return the value of field 'SzCdRsrcCharService'.
     */
    public java.lang.String getSzCdRsrcCharService()
    {
        return this._szCdRsrcCharService;
    } //-- java.lang.String getSzCdRsrcCharService() 

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
     * Returns the value of field 'ulIdResourceService'.
     * 
     * @return the value of field 'UlIdResourceService'.
     */
    public int getUlIdResourceService()
    {
        return this._ulIdResourceService;
    } //-- int getUlIdResourceService() 

    /**
     * Returns the value of field 'ulRowQty'.
     * 
     * @return the value of field 'UlRowQty'.
     */
    public int getUlRowQty()
    {
        return this._ulRowQty;
    } //-- int getUlRowQty() 

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
     * Method hasUlIdResourceService
     * 
     * 
     * 
     * @return true if at least one UlIdResourceService has been
     * added
     */
    public boolean hasUlIdResourceService()
    {
        return this._has_ulIdResourceService;
    } //-- boolean hasUlIdResourceService() 

    /**
     * Method hasUlRowQty
     * 
     * 
     * 
     * @return true if at least one UlRowQty has been added
     */
    public boolean hasUlRowQty()
    {
        return this._has_ulRowQty;
    } //-- boolean hasUlRowQty() 

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
     * Sets the value of field 'ROWCRES08SIG00_ARRAY'.
     * 
     * @param ROWCRES08SIG00_ARRAY the value of field
     * 'ROWCRES08SIG00_ARRAY'.
     */
    public void setROWCRES08SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG00_ARRAY ROWCRES08SIG00_ARRAY)
    {
        this._ROWCRES08SIG00_ARRAY = ROWCRES08SIG00_ARRAY;
    } //-- void setROWCRES08SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG00_ARRAY) 

    /**
     * Sets the value of field 'ROWCRES08SIG01_ARRAY'.
     * 
     * @param ROWCRES08SIG01_ARRAY the value of field
     * 'ROWCRES08SIG01_ARRAY'.
     */
    public void setROWCRES08SIG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG01_ARRAY ROWCRES08SIG01_ARRAY)
    {
        this._ROWCRES08SIG01_ARRAY = ROWCRES08SIG01_ARRAY;
    } //-- void setROWCRES08SIG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG01_ARRAY) 

    /**
     * Sets the value of field 'szCdRsrcCharRegion'.
     * 
     * @param szCdRsrcCharRegion the value of field
     * 'szCdRsrcCharRegion'.
     */
    public void setSzCdRsrcCharRegion(java.lang.String szCdRsrcCharRegion)
    {
        this._szCdRsrcCharRegion = szCdRsrcCharRegion;
    } //-- void setSzCdRsrcCharRegion(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcCharService'.
     * 
     * @param szCdRsrcCharService the value of field
     * 'szCdRsrcCharService'.
     */
    public void setSzCdRsrcCharService(java.lang.String szCdRsrcCharService)
    {
        this._szCdRsrcCharService = szCdRsrcCharService;
    } //-- void setSzCdRsrcCharService(java.lang.String) 

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
     * Sets the value of field 'ulIdResourceService'.
     * 
     * @param ulIdResourceService the value of field
     * 'ulIdResourceService'.
     */
    public void setUlIdResourceService(int ulIdResourceService)
    {
        this._ulIdResourceService = ulIdResourceService;
        this._has_ulIdResourceService = true;
    } //-- void setUlIdResourceService(int) 

    /**
     * Sets the value of field 'ulRowQty'.
     * 
     * @param ulRowQty the value of field 'ulRowQty'.
     */
    public void setUlRowQty(int ulRowQty)
    {
        this._ulRowQty = ulRowQty;
        this._has_ulRowQty = true;
    } //-- void setUlRowQty(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CRES08SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CRES08SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CRES08SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CRES08SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CRES08SI unmarshal(java.io.Reader) 

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
