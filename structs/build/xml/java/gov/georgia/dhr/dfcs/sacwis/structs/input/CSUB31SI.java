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
 * Class CSUB31SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB31SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ulIdPlcmtChild
     */
    private int _ulIdPlcmtChild;

    /**
     * keeps track of state for field: _ulIdPlcmtChild
     */
    private boolean _has_ulIdPlcmtChild;

    /**
     * Field _dtDtPlcmtStart
     */
    private java.util.Date _dtDtPlcmtStart;

    /**
     * Field _szCdPlcmtType
     */
    private java.lang.String _szCdPlcmtType;

    /**
     * Field _szCdRsrcFacilType
     */
    private java.lang.String _szCdRsrcFacilType;

    /**
     * Field _cIndPlcmetEmerg
     */
    private java.lang.String _cIndPlcmetEmerg;

    /**
     * Field _szAddrPlcmtCnty
     */
    private java.lang.String _szAddrPlcmtCnty;

    /**
     * Field _szCdTempPlcmtType
     */
    private java.lang.String _szCdTempPlcmtType;

    /**
     * Field _ulIdWaiver
     */
    private int _ulIdWaiver;

    /**
     * keeps track of state for field: _ulIdWaiver
     */
    private boolean _has_ulIdWaiver;

    /**
     * Field _ulIdPlcmtEvent
     */
    private int _ulIdPlcmtEvent;

    /**
     * keeps track of state for field: _ulIdPlcmtEvent
     */
    private boolean _has_ulIdPlcmtEvent;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB31SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB31SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPlcmtChild()
    {
        this._has_ulIdPlcmtChild= false;
    } //-- void deleteUlIdPlcmtChild() 

    /**
     */
    public void deleteUlIdPlcmtEvent()
    {
        this._has_ulIdPlcmtEvent= false;
    } //-- void deleteUlIdPlcmtEvent() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     */
    public void deleteUlIdWaiver()
    {
        this._has_ulIdWaiver= false;
    } //-- void deleteUlIdWaiver() 

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
     * Returns the value of field 'cIndPlcmetEmerg'.
     * 
     * @return the value of field 'CIndPlcmetEmerg'.
     */
    public java.lang.String getCIndPlcmetEmerg()
    {
        return this._cIndPlcmetEmerg;
    } //-- java.lang.String getCIndPlcmetEmerg() 

    /**
     * Returns the value of field 'dtDtPlcmtStart'.
     * 
     * @return the value of field 'DtDtPlcmtStart'.
     */
    public java.util.Date getDtDtPlcmtStart()
    {
        return this._dtDtPlcmtStart;
    } //-- java.util.Date getDtDtPlcmtStart() 

    /**
     * Returns the value of field 'szAddrPlcmtCnty'.
     * 
     * @return the value of field 'SzAddrPlcmtCnty'.
     */
    public java.lang.String getSzAddrPlcmtCnty()
    {
        return this._szAddrPlcmtCnty;
    } //-- java.lang.String getSzAddrPlcmtCnty() 

    /**
     * Returns the value of field 'szCdPlcmtType'.
     * 
     * @return the value of field 'SzCdPlcmtType'.
     */
    public java.lang.String getSzCdPlcmtType()
    {
        return this._szCdPlcmtType;
    } //-- java.lang.String getSzCdPlcmtType() 

    /**
     * Returns the value of field 'szCdRsrcFacilType'.
     * 
     * @return the value of field 'SzCdRsrcFacilType'.
     */
    public java.lang.String getSzCdRsrcFacilType()
    {
        return this._szCdRsrcFacilType;
    } //-- java.lang.String getSzCdRsrcFacilType() 

    /**
     * Returns the value of field 'szCdTempPlcmtType'.
     * 
     * @return the value of field 'SzCdTempPlcmtType'.
     */
    public java.lang.String getSzCdTempPlcmtType()
    {
        return this._szCdTempPlcmtType;
    } //-- java.lang.String getSzCdTempPlcmtType() 

    /**
     * Returns the value of field 'ulIdPlcmtChild'.
     * 
     * @return the value of field 'UlIdPlcmtChild'.
     */
    public int getUlIdPlcmtChild()
    {
        return this._ulIdPlcmtChild;
    } //-- int getUlIdPlcmtChild() 

    /**
     * Returns the value of field 'ulIdPlcmtEvent'.
     * 
     * @return the value of field 'UlIdPlcmtEvent'.
     */
    public int getUlIdPlcmtEvent()
    {
        return this._ulIdPlcmtEvent;
    } //-- int getUlIdPlcmtEvent() 

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
     * Returns the value of field 'ulIdStage'.
     * 
     * @return the value of field 'UlIdStage'.
     */
    public int getUlIdStage()
    {
        return this._ulIdStage;
    } //-- int getUlIdStage() 

    /**
     * Returns the value of field 'ulIdWaiver'.
     * 
     * @return the value of field 'UlIdWaiver'.
     */
    public int getUlIdWaiver()
    {
        return this._ulIdWaiver;
    } //-- int getUlIdWaiver() 

    /**
     * Method hasUlIdPlcmtChild
     * 
     * 
     * 
     * @return true if at least one UlIdPlcmtChild has been added
     */
    public boolean hasUlIdPlcmtChild()
    {
        return this._has_ulIdPlcmtChild;
    } //-- boolean hasUlIdPlcmtChild() 

    /**
     * Method hasUlIdPlcmtEvent
     * 
     * 
     * 
     * @return true if at least one UlIdPlcmtEvent has been added
     */
    public boolean hasUlIdPlcmtEvent()
    {
        return this._has_ulIdPlcmtEvent;
    } //-- boolean hasUlIdPlcmtEvent() 

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
     * Method hasUlIdStage
     * 
     * 
     * 
     * @return true if at least one UlIdStage has been added
     */
    public boolean hasUlIdStage()
    {
        return this._has_ulIdStage;
    } //-- boolean hasUlIdStage() 

    /**
     * Method hasUlIdWaiver
     * 
     * 
     * 
     * @return true if at least one UlIdWaiver has been added
     */
    public boolean hasUlIdWaiver()
    {
        return this._has_ulIdWaiver;
    } //-- boolean hasUlIdWaiver() 

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
     * Sets the value of field 'cIndPlcmetEmerg'.
     * 
     * @param cIndPlcmetEmerg the value of field 'cIndPlcmetEmerg'.
     */
    public void setCIndPlcmetEmerg(java.lang.String cIndPlcmetEmerg)
    {
        this._cIndPlcmetEmerg = cIndPlcmetEmerg;
    } //-- void setCIndPlcmetEmerg(java.lang.String) 

    /**
     * Sets the value of field 'dtDtPlcmtStart'.
     * 
     * @param dtDtPlcmtStart the value of field 'dtDtPlcmtStart'.
     */
    public void setDtDtPlcmtStart(java.util.Date dtDtPlcmtStart)
    {
        this._dtDtPlcmtStart = dtDtPlcmtStart;
    } //-- void setDtDtPlcmtStart(java.util.Date) 

    /**
     * Sets the value of field 'szAddrPlcmtCnty'.
     * 
     * @param szAddrPlcmtCnty the value of field 'szAddrPlcmtCnty'.
     */
    public void setSzAddrPlcmtCnty(java.lang.String szAddrPlcmtCnty)
    {
        this._szAddrPlcmtCnty = szAddrPlcmtCnty;
    } //-- void setSzAddrPlcmtCnty(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlcmtType'.
     * 
     * @param szCdPlcmtType the value of field 'szCdPlcmtType'.
     */
    public void setSzCdPlcmtType(java.lang.String szCdPlcmtType)
    {
        this._szCdPlcmtType = szCdPlcmtType;
    } //-- void setSzCdPlcmtType(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcFacilType'.
     * 
     * @param szCdRsrcFacilType the value of field
     * 'szCdRsrcFacilType'.
     */
    public void setSzCdRsrcFacilType(java.lang.String szCdRsrcFacilType)
    {
        this._szCdRsrcFacilType = szCdRsrcFacilType;
    } //-- void setSzCdRsrcFacilType(java.lang.String) 

    /**
     * Sets the value of field 'szCdTempPlcmtType'.
     * 
     * @param szCdTempPlcmtType the value of field
     * 'szCdTempPlcmtType'.
     */
    public void setSzCdTempPlcmtType(java.lang.String szCdTempPlcmtType)
    {
        this._szCdTempPlcmtType = szCdTempPlcmtType;
    } //-- void setSzCdTempPlcmtType(java.lang.String) 

    /**
     * Sets the value of field 'ulIdPlcmtChild'.
     * 
     * @param ulIdPlcmtChild the value of field 'ulIdPlcmtChild'.
     */
    public void setUlIdPlcmtChild(int ulIdPlcmtChild)
    {
        this._ulIdPlcmtChild = ulIdPlcmtChild;
        this._has_ulIdPlcmtChild = true;
    } //-- void setUlIdPlcmtChild(int) 

    /**
     * Sets the value of field 'ulIdPlcmtEvent'.
     * 
     * @param ulIdPlcmtEvent the value of field 'ulIdPlcmtEvent'.
     */
    public void setUlIdPlcmtEvent(int ulIdPlcmtEvent)
    {
        this._ulIdPlcmtEvent = ulIdPlcmtEvent;
        this._has_ulIdPlcmtEvent = true;
    } //-- void setUlIdPlcmtEvent(int) 

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
     * Sets the value of field 'ulIdStage'.
     * 
     * @param ulIdStage the value of field 'ulIdStage'.
     */
    public void setUlIdStage(int ulIdStage)
    {
        this._ulIdStage = ulIdStage;
        this._has_ulIdStage = true;
    } //-- void setUlIdStage(int) 

    /**
     * Sets the value of field 'ulIdWaiver'.
     * 
     * @param ulIdWaiver the value of field 'ulIdWaiver'.
     */
    public void setUlIdWaiver(int ulIdWaiver)
    {
        this._ulIdWaiver = ulIdWaiver;
        this._has_ulIdWaiver = true;
    } //-- void setUlIdWaiver(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB31SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB31SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB31SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB31SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB31SI unmarshal(java.io.Reader) 

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
