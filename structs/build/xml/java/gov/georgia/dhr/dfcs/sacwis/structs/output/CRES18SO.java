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
 * Class CRES18SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CRES18SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtSysDtGenericSysdate
     */
    private org.exolab.castor.types.Date _dtSysDtGenericSysdate;

    /**
     * Field _ROWCRES55DO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO_ARRAY _ROWCRES55DO_ARRAY;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _ulHmResourceId
     */
    private int _ulHmResourceId;

    /**
     * keeps track of state for field: _ulHmResourceId
     */
    private boolean _has_ulHmResourceId;

    /**
     * Field _szNmResource
     */
    private java.lang.String _szNmResource;

    /**
     * Field _szCpaName
     */
    private java.lang.String _szCpaName;

    /**
     * Field _cd_Home_Marital_Status
     */
    private java.lang.String _cd_Home_Marital_Status;


      //----------------/
     //- Constructors -/
    //----------------/

    public CRES18SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CRES18SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlHmResourceId()
    {
        this._has_ulHmResourceId= false;
    } //-- void deleteUlHmResourceId() 

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
     * Returns the value of field 'cd_Home_Marital_Status'.
     * 
     * @return the value of field 'Cd_Home_Marital_Status'.
     */
    public java.lang.String getCd_Home_Marital_Status()
    {
        return this._cd_Home_Marital_Status;
    } //-- java.lang.String getCd_Home_Marital_Status() 

    /**
     * Returns the value of field 'dtSysDtGenericSysdate'.
     * 
     * @return the value of field 'DtSysDtGenericSysdate'.
     */
    public org.exolab.castor.types.Date getDtSysDtGenericSysdate()
    {
        return this._dtSysDtGenericSysdate;
    } //-- org.exolab.castor.types.Date getDtSysDtGenericSysdate() 

    /**
     * Returns the value of field 'ROWCRES55DO_ARRAY'.
     * 
     * @return the value of field 'ROWCRES55DO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO_ARRAY getROWCRES55DO_ARRAY()
    {
        return this._ROWCRES55DO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO_ARRAY getROWCRES55DO_ARRAY() 

    /**
     * Returns the value of field 'szCpaName'.
     * 
     * @return the value of field 'SzCpaName'.
     */
    public java.lang.String getSzCpaName()
    {
        return this._szCpaName;
    } //-- java.lang.String getSzCpaName() 

    /**
     * Returns the value of field 'szNmResource'.
     * 
     * @return the value of field 'SzNmResource'.
     */
    public java.lang.String getSzNmResource()
    {
        return this._szNmResource;
    } //-- java.lang.String getSzNmResource() 

    /**
     * Returns the value of field 'ulHmResourceId'.
     * 
     * @return the value of field 'UlHmResourceId'.
     */
    public int getUlHmResourceId()
    {
        return this._ulHmResourceId;
    } //-- int getUlHmResourceId() 

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
     * Method hasUlHmResourceId
     * 
     * 
     * 
     * @return true if at least one UlHmResourceId has been added
     */
    public boolean hasUlHmResourceId()
    {
        return this._has_ulHmResourceId;
    } //-- boolean hasUlHmResourceId() 

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
     * Sets the value of field 'cd_Home_Marital_Status'.
     * 
     * @param cd_Home_Marital_Status the value of field
     * 'cd_Home_Marital_Status'.
     */
    public void setCd_Home_Marital_Status(java.lang.String cd_Home_Marital_Status)
    {
        this._cd_Home_Marital_Status = cd_Home_Marital_Status;
    } //-- void setCd_Home_Marital_Status(java.lang.String) 

    /**
     * Sets the value of field 'dtSysDtGenericSysdate'.
     * 
     * @param dtSysDtGenericSysdate the value of field
     * 'dtSysDtGenericSysdate'.
     */
    public void setDtSysDtGenericSysdate(org.exolab.castor.types.Date dtSysDtGenericSysdate)
    {
        this._dtSysDtGenericSysdate = dtSysDtGenericSysdate;
    } //-- void setDtSysDtGenericSysdate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCRES55DO_ARRAY'.
     * 
     * @param ROWCRES55DO_ARRAY the value of field
     * 'ROWCRES55DO_ARRAY'.
     */
    public void setROWCRES55DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO_ARRAY ROWCRES55DO_ARRAY)
    {
        this._ROWCRES55DO_ARRAY = ROWCRES55DO_ARRAY;
    } //-- void setROWCRES55DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO_ARRAY) 

    /**
     * Sets the value of field 'szCpaName'.
     * 
     * @param szCpaName the value of field 'szCpaName'.
     */
    public void setSzCpaName(java.lang.String szCpaName)
    {
        this._szCpaName = szCpaName;
    } //-- void setSzCpaName(java.lang.String) 

    /**
     * Sets the value of field 'szNmResource'.
     * 
     * @param szNmResource the value of field 'szNmResource'.
     */
    public void setSzNmResource(java.lang.String szNmResource)
    {
        this._szNmResource = szNmResource;
    } //-- void setSzNmResource(java.lang.String) 

    /**
     * Sets the value of field 'ulHmResourceId'.
     * 
     * @param ulHmResourceId the value of field 'ulHmResourceId'.
     */
    public void setUlHmResourceId(int ulHmResourceId)
    {
        this._ulHmResourceId = ulHmResourceId;
        this._has_ulHmResourceId = true;
    } //-- void setUlHmResourceId(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CRES18SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CRES18SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CRES18SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CRES18SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CRES18SO unmarshal(java.io.Reader) 

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
