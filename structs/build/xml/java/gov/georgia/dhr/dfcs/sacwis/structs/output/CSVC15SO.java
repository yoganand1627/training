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
 * Class CSVC15SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSVC15SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _dtDtSvcDelvDecision
     */
    private org.exolab.castor.types.Date _dtDtSvcDelvDecision;

    /**
     * Field _ROWCINV19SOG02
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV19SOG02 _ROWCINV19SOG02;

    /**
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _bIndReopenStageEvent
     */
    private java.lang.String _bIndReopenStageEvent;

    /**
     * Field _szCdStageReasonClosedFromReopen
     */
    private java.lang.String _szCdStageReasonClosedFromReopen;

    /**
     * Field _szTxtStageClosureCmntsFromReopen
     */
    private java.lang.String _szTxtStageClosureCmntsFromReopen;

    /**
     * Field _dtDtStageCloseFromReopen
     */
    private org.exolab.castor.types.Date _dtDtStageCloseFromReopen;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSVC15SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC15SO()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'bIndReopenStageEvent'.
     * 
     * @return the value of field 'BIndReopenStageEvent'.
     */
    public java.lang.String getBIndReopenStageEvent()
    {
        return this._bIndReopenStageEvent;
    } //-- java.lang.String getBIndReopenStageEvent() 

    /**
     * Returns the value of field 'dtDtStageCloseFromReopen'.
     * 
     * @return the value of field 'DtDtStageCloseFromReopen'.
     */
    public org.exolab.castor.types.Date getDtDtStageCloseFromReopen()
    {
        return this._dtDtStageCloseFromReopen;
    } //-- org.exolab.castor.types.Date getDtDtStageCloseFromReopen() 

    /**
     * Returns the value of field 'dtDtSvcDelvDecision'.
     * 
     * @return the value of field 'DtDtSvcDelvDecision'.
     */
    public org.exolab.castor.types.Date getDtDtSvcDelvDecision()
    {
        return this._dtDtSvcDelvDecision;
    } //-- org.exolab.castor.types.Date getDtDtSvcDelvDecision() 

    /**
     * Returns the value of field 'ROWCCMN01UIG00'.
     * 
     * @return the value of field 'ROWCCMN01UIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 getROWCCMN01UIG00()
    {
        return this._ROWCCMN01UIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 getROWCCMN01UIG00() 

    /**
     * Returns the value of field 'ROWCINV19SOG02'.
     * 
     * @return the value of field 'ROWCINV19SOG02'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV19SOG02 getROWCINV19SOG02()
    {
        return this._ROWCINV19SOG02;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV19SOG02 getROWCINV19SOG02() 

    /**
     * Returns the value of field
     * 'szCdStageReasonClosedFromReopen'.
     * 
     * @return the value of field 'SzCdStageReasonClosedFromReopen'.
     */
    public java.lang.String getSzCdStageReasonClosedFromReopen()
    {
        return this._szCdStageReasonClosedFromReopen;
    } //-- java.lang.String getSzCdStageReasonClosedFromReopen() 

    /**
     * Returns the value of field
     * 'szTxtStageClosureCmntsFromReopen'.
     * 
     * @return the value of field 'SzTxtStageClosureCmntsFromReopen'
     */
    public java.lang.String getSzTxtStageClosureCmntsFromReopen()
    {
        return this._szTxtStageClosureCmntsFromReopen;
    } //-- java.lang.String getSzTxtStageClosureCmntsFromReopen() 

    /**
     * Returns the value of field 'tsLastUpdate'.
     * 
     * @return the value of field 'TsLastUpdate'.
     */
    public java.util.Date getTsLastUpdate()
    {
        return this._tsLastUpdate;
    } //-- java.util.Date getTsLastUpdate() 

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
     * Sets the value of field 'bIndReopenStageEvent'.
     * 
     * @param bIndReopenStageEvent the value of field
     * 'bIndReopenStageEvent'.
     */
    public void setBIndReopenStageEvent(java.lang.String bIndReopenStageEvent)
    {
        this._bIndReopenStageEvent = bIndReopenStageEvent;
    } //-- void setBIndReopenStageEvent(java.lang.String) 

    /**
     * Sets the value of field 'dtDtStageCloseFromReopen'.
     * 
     * @param dtDtStageCloseFromReopen the value of field
     * 'dtDtStageCloseFromReopen'.
     */
    public void setDtDtStageCloseFromReopen(org.exolab.castor.types.Date dtDtStageCloseFromReopen)
    {
        this._dtDtStageCloseFromReopen = dtDtStageCloseFromReopen;
    } //-- void setDtDtStageCloseFromReopen(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtSvcDelvDecision'.
     * 
     * @param dtDtSvcDelvDecision the value of field
     * 'dtDtSvcDelvDecision'.
     */
    public void setDtDtSvcDelvDecision(org.exolab.castor.types.Date dtDtSvcDelvDecision)
    {
        this._dtDtSvcDelvDecision = dtDtSvcDelvDecision;
    } //-- void setDtDtSvcDelvDecision(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCCMN01UIG00'.
     * 
     * @param ROWCCMN01UIG00 the value of field 'ROWCCMN01UIG00'.
     */
    public void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 ROWCCMN01UIG00)
    {
        this._ROWCCMN01UIG00 = ROWCCMN01UIG00;
    } //-- void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00) 

    /**
     * Sets the value of field 'ROWCINV19SOG02'.
     * 
     * @param ROWCINV19SOG02 the value of field 'ROWCINV19SOG02'.
     */
    public void setROWCINV19SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV19SOG02 ROWCINV19SOG02)
    {
        this._ROWCINV19SOG02 = ROWCINV19SOG02;
    } //-- void setROWCINV19SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV19SOG02) 

    /**
     * Sets the value of field 'szCdStageReasonClosedFromReopen'.
     * 
     * @param szCdStageReasonClosedFromReopen the value of field
     * 'szCdStageReasonClosedFromReopen'.
     */
    public void setSzCdStageReasonClosedFromReopen(java.lang.String szCdStageReasonClosedFromReopen)
    {
        this._szCdStageReasonClosedFromReopen = szCdStageReasonClosedFromReopen;
    } //-- void setSzCdStageReasonClosedFromReopen(java.lang.String) 

    /**
     * Sets the value of field 'szTxtStageClosureCmntsFromReopen'.
     * 
     * @param szTxtStageClosureCmntsFromReopen the value of field
     * 'szTxtStageClosureCmntsFromReopen'.
     */
    public void setSzTxtStageClosureCmntsFromReopen(java.lang.String szTxtStageClosureCmntsFromReopen)
    {
        this._szTxtStageClosureCmntsFromReopen = szTxtStageClosureCmntsFromReopen;
    } //-- void setSzTxtStageClosureCmntsFromReopen(java.lang.String) 

    /**
     * Sets the value of field 'tsLastUpdate'.
     * 
     * @param tsLastUpdate the value of field 'tsLastUpdate'.
     */
    public void setTsLastUpdate(java.util.Date tsLastUpdate)
    {
        this._tsLastUpdate = tsLastUpdate;
    } //-- void setTsLastUpdate(java.util.Date) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC15SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC15SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC15SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC15SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC15SO unmarshal(java.io.Reader) 

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
