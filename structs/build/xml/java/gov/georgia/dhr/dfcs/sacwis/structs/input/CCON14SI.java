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
 * Class CCON14SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCON14SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdRsrcSvcService
     */
    private java.lang.String _szCdRsrcSvcService;

    /**
     * Field _dtDtCncntyEffective
     */
    private org.exolab.castor.types.Date _dtDtCncntyEffective;

    /**
     * Field _dtDtCncntyEnd
     */
    private org.exolab.castor.types.Date _dtDtCncntyEnd;

    /**
     * Field _ulIdCntrctWkr
     */
    private int _ulIdCntrctWkr;

    /**
     * keeps track of state for field: _ulIdCntrctWkr
     */
    private boolean _has_ulIdCntrctWkr;

    /**
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _ulNbrCncntyLineItem
     */
    private int _ulNbrCncntyLineItem;

    /**
     * keeps track of state for field: _ulNbrCncntyLineItem
     */
    private boolean _has_ulNbrCncntyLineItem;

    /**
     * Field _ulNbrCncntyPeriod
     */
    private int _ulNbrCncntyPeriod;

    /**
     * keeps track of state for field: _ulNbrCncntyPeriod
     */
    private boolean _has_ulNbrCncntyPeriod;

    /**
     * Field _ulNbrCncntyVersion
     */
    private int _ulNbrCncntyVersion;

    /**
     * keeps track of state for field: _ulNbrCncntyVersion
     */
    private boolean _has_ulNbrCncntyVersion;

    /**
     * Field _ROWCCON14SIG_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG_ARRAY _ROWCCON14SIG_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCON14SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON14SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCntrctWkr()
    {
        this._has_ulIdCntrctWkr= false;
    } //-- void deleteUlIdCntrctWkr() 

    /**
     */
    public void deleteUlIdContract()
    {
        this._has_ulIdContract= false;
    } //-- void deleteUlIdContract() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlNbrCncntyLineItem()
    {
        this._has_ulNbrCncntyLineItem= false;
    } //-- void deleteUlNbrCncntyLineItem() 

    /**
     */
    public void deleteUlNbrCncntyPeriod()
    {
        this._has_ulNbrCncntyPeriod= false;
    } //-- void deleteUlNbrCncntyPeriod() 

    /**
     */
    public void deleteUlNbrCncntyVersion()
    {
        this._has_ulNbrCncntyVersion= false;
    } //-- void deleteUlNbrCncntyVersion() 

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
     * Returns the value of field 'dtDtCncntyEffective'.
     * 
     * @return the value of field 'DtDtCncntyEffective'.
     */
    public org.exolab.castor.types.Date getDtDtCncntyEffective()
    {
        return this._dtDtCncntyEffective;
    } //-- org.exolab.castor.types.Date getDtDtCncntyEffective() 

    /**
     * Returns the value of field 'dtDtCncntyEnd'.
     * 
     * @return the value of field 'DtDtCncntyEnd'.
     */
    public org.exolab.castor.types.Date getDtDtCncntyEnd()
    {
        return this._dtDtCncntyEnd;
    } //-- org.exolab.castor.types.Date getDtDtCncntyEnd() 

    /**
     * Returns the value of field 'ROWCCON14SIG_ARRAY'.
     * 
     * @return the value of field 'ROWCCON14SIG_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG_ARRAY getROWCCON14SIG_ARRAY()
    {
        return this._ROWCCON14SIG_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG_ARRAY getROWCCON14SIG_ARRAY() 

    /**
     * Returns the value of field 'szCdRsrcSvcService'.
     * 
     * @return the value of field 'SzCdRsrcSvcService'.
     */
    public java.lang.String getSzCdRsrcSvcService()
    {
        return this._szCdRsrcSvcService;
    } //-- java.lang.String getSzCdRsrcSvcService() 

    /**
     * Returns the value of field 'ulIdCntrctWkr'.
     * 
     * @return the value of field 'UlIdCntrctWkr'.
     */
    public int getUlIdCntrctWkr()
    {
        return this._ulIdCntrctWkr;
    } //-- int getUlIdCntrctWkr() 

    /**
     * Returns the value of field 'ulIdContract'.
     * 
     * @return the value of field 'UlIdContract'.
     */
    public int getUlIdContract()
    {
        return this._ulIdContract;
    } //-- int getUlIdContract() 

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
     * Returns the value of field 'ulNbrCncntyLineItem'.
     * 
     * @return the value of field 'UlNbrCncntyLineItem'.
     */
    public int getUlNbrCncntyLineItem()
    {
        return this._ulNbrCncntyLineItem;
    } //-- int getUlNbrCncntyLineItem() 

    /**
     * Returns the value of field 'ulNbrCncntyPeriod'.
     * 
     * @return the value of field 'UlNbrCncntyPeriod'.
     */
    public int getUlNbrCncntyPeriod()
    {
        return this._ulNbrCncntyPeriod;
    } //-- int getUlNbrCncntyPeriod() 

    /**
     * Returns the value of field 'ulNbrCncntyVersion'.
     * 
     * @return the value of field 'UlNbrCncntyVersion'.
     */
    public int getUlNbrCncntyVersion()
    {
        return this._ulNbrCncntyVersion;
    } //-- int getUlNbrCncntyVersion() 

    /**
     * Method hasUlIdCntrctWkr
     * 
     * 
     * 
     * @return true if at least one UlIdCntrctWkr has been added
     */
    public boolean hasUlIdCntrctWkr()
    {
        return this._has_ulIdCntrctWkr;
    } //-- boolean hasUlIdCntrctWkr() 

    /**
     * Method hasUlIdContract
     * 
     * 
     * 
     * @return true if at least one UlIdContract has been added
     */
    public boolean hasUlIdContract()
    {
        return this._has_ulIdContract;
    } //-- boolean hasUlIdContract() 

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
     * Method hasUlNbrCncntyLineItem
     * 
     * 
     * 
     * @return true if at least one UlNbrCncntyLineItem has been
     * added
     */
    public boolean hasUlNbrCncntyLineItem()
    {
        return this._has_ulNbrCncntyLineItem;
    } //-- boolean hasUlNbrCncntyLineItem() 

    /**
     * Method hasUlNbrCncntyPeriod
     * 
     * 
     * 
     * @return true if at least one UlNbrCncntyPeriod has been added
     */
    public boolean hasUlNbrCncntyPeriod()
    {
        return this._has_ulNbrCncntyPeriod;
    } //-- boolean hasUlNbrCncntyPeriod() 

    /**
     * Method hasUlNbrCncntyVersion
     * 
     * 
     * 
     * @return true if at least one UlNbrCncntyVersion has been adde
     */
    public boolean hasUlNbrCncntyVersion()
    {
        return this._has_ulNbrCncntyVersion;
    } //-- boolean hasUlNbrCncntyVersion() 

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
     * Sets the value of field 'dtDtCncntyEffective'.
     * 
     * @param dtDtCncntyEffective the value of field
     * 'dtDtCncntyEffective'.
     */
    public void setDtDtCncntyEffective(org.exolab.castor.types.Date dtDtCncntyEffective)
    {
        this._dtDtCncntyEffective = dtDtCncntyEffective;
    } //-- void setDtDtCncntyEffective(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCncntyEnd'.
     * 
     * @param dtDtCncntyEnd the value of field 'dtDtCncntyEnd'.
     */
    public void setDtDtCncntyEnd(org.exolab.castor.types.Date dtDtCncntyEnd)
    {
        this._dtDtCncntyEnd = dtDtCncntyEnd;
    } //-- void setDtDtCncntyEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCCON14SIG_ARRAY'.
     * 
     * @param ROWCCON14SIG_ARRAY the value of field
     * 'ROWCCON14SIG_ARRAY'.
     */
    public void setROWCCON14SIG_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG_ARRAY ROWCCON14SIG_ARRAY)
    {
        this._ROWCCON14SIG_ARRAY = ROWCCON14SIG_ARRAY;
    } //-- void setROWCCON14SIG_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG_ARRAY) 

    /**
     * Sets the value of field 'szCdRsrcSvcService'.
     * 
     * @param szCdRsrcSvcService the value of field
     * 'szCdRsrcSvcService'.
     */
    public void setSzCdRsrcSvcService(java.lang.String szCdRsrcSvcService)
    {
        this._szCdRsrcSvcService = szCdRsrcSvcService;
    } //-- void setSzCdRsrcSvcService(java.lang.String) 

    /**
     * Sets the value of field 'ulIdCntrctWkr'.
     * 
     * @param ulIdCntrctWkr the value of field 'ulIdCntrctWkr'.
     */
    public void setUlIdCntrctWkr(int ulIdCntrctWkr)
    {
        this._ulIdCntrctWkr = ulIdCntrctWkr;
        this._has_ulIdCntrctWkr = true;
    } //-- void setUlIdCntrctWkr(int) 

    /**
     * Sets the value of field 'ulIdContract'.
     * 
     * @param ulIdContract the value of field 'ulIdContract'.
     */
    public void setUlIdContract(int ulIdContract)
    {
        this._ulIdContract = ulIdContract;
        this._has_ulIdContract = true;
    } //-- void setUlIdContract(int) 

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
     * Sets the value of field 'ulNbrCncntyLineItem'.
     * 
     * @param ulNbrCncntyLineItem the value of field
     * 'ulNbrCncntyLineItem'.
     */
    public void setUlNbrCncntyLineItem(int ulNbrCncntyLineItem)
    {
        this._ulNbrCncntyLineItem = ulNbrCncntyLineItem;
        this._has_ulNbrCncntyLineItem = true;
    } //-- void setUlNbrCncntyLineItem(int) 

    /**
     * Sets the value of field 'ulNbrCncntyPeriod'.
     * 
     * @param ulNbrCncntyPeriod the value of field
     * 'ulNbrCncntyPeriod'.
     */
    public void setUlNbrCncntyPeriod(int ulNbrCncntyPeriod)
    {
        this._ulNbrCncntyPeriod = ulNbrCncntyPeriod;
        this._has_ulNbrCncntyPeriod = true;
    } //-- void setUlNbrCncntyPeriod(int) 

    /**
     * Sets the value of field 'ulNbrCncntyVersion'.
     * 
     * @param ulNbrCncntyVersion the value of field
     * 'ulNbrCncntyVersion'.
     */
    public void setUlNbrCncntyVersion(int ulNbrCncntyVersion)
    {
        this._ulNbrCncntyVersion = ulNbrCncntyVersion;
        this._has_ulNbrCncntyVersion = true;
    } //-- void setUlNbrCncntyVersion(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCON14SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCON14SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCON14SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCON14SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON14SI unmarshal(java.io.Reader) 

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
