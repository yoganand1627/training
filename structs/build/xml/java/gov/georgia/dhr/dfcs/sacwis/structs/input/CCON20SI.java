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
 * Class CCON20SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCON20SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdSvcAuthCounty
     */
    private java.lang.String _szCdSvcAuthCounty;

    /**
     * Field _szCdSvcAuthService
     */
    private java.lang.String _szCdSvcAuthService;

    /**
     * Field _dtDtSvcAuthEff
     */
    private org.exolab.castor.types.Date _dtDtSvcAuthEff;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCON20SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON20SI()


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
     * Returns the value of field 'archInputStruct'.
     * 
     * @return the value of field 'ArchInputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct()
    {
        return this._archInputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct() 

    /**
     * Returns the value of field 'dtDtSvcAuthEff'.
     * 
     * @return the value of field 'DtDtSvcAuthEff'.
     */
    public org.exolab.castor.types.Date getDtDtSvcAuthEff()
    {
        return this._dtDtSvcAuthEff;
    } //-- org.exolab.castor.types.Date getDtDtSvcAuthEff() 

    /**
     * Returns the value of field 'szCdSvcAuthCounty'.
     * 
     * @return the value of field 'SzCdSvcAuthCounty'.
     */
    public java.lang.String getSzCdSvcAuthCounty()
    {
        return this._szCdSvcAuthCounty;
    } //-- java.lang.String getSzCdSvcAuthCounty() 

    /**
     * Returns the value of field 'szCdSvcAuthService'.
     * 
     * @return the value of field 'SzCdSvcAuthService'.
     */
    public java.lang.String getSzCdSvcAuthService()
    {
        return this._szCdSvcAuthService;
    } //-- java.lang.String getSzCdSvcAuthService() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

    /**
     * Sets the value of field 'dtDtSvcAuthEff'.
     * 
     * @param dtDtSvcAuthEff the value of field 'dtDtSvcAuthEff'.
     */
    public void setDtDtSvcAuthEff(org.exolab.castor.types.Date dtDtSvcAuthEff)
    {
        this._dtDtSvcAuthEff = dtDtSvcAuthEff;
    } //-- void setDtDtSvcAuthEff(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdSvcAuthCounty'.
     * 
     * @param szCdSvcAuthCounty the value of field
     * 'szCdSvcAuthCounty'.
     */
    public void setSzCdSvcAuthCounty(java.lang.String szCdSvcAuthCounty)
    {
        this._szCdSvcAuthCounty = szCdSvcAuthCounty;
    } //-- void setSzCdSvcAuthCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcAuthService'.
     * 
     * @param szCdSvcAuthService the value of field
     * 'szCdSvcAuthService'.
     */
    public void setSzCdSvcAuthService(java.lang.String szCdSvcAuthService)
    {
        this._szCdSvcAuthService = szCdSvcAuthService;
    } //-- void setSzCdSvcAuthService(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCON20SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCON20SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCON20SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCON20SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON20SI unmarshal(java.io.Reader) 

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
