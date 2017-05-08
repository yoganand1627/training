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
 * Class CCFC03SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC03SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _cSysIndPalIlsAssmt
     */
    private java.lang.String _cSysIndPalIlsAssmt;

    /**
     * Field _cSysIndPalLeadCoord
     */
    private java.lang.String _cSysIndPalLeadCoord;

    /**
     * Field _cSysIndPalSvcAuth
     */
    private java.lang.String _cSysIndPalSvcAuth;

    /**
     * Field _cSysIndPalOverEighteen
     */
    private java.lang.String _cSysIndPalOverEighteen;

    /**
     * Field _cSysIndPrimaryWorker
     */
    private java.lang.String _cSysIndPrimaryWorker;

    /**
     * Field _cSysIndDischargeDate
     */
    private java.lang.String _cSysIndDischargeDate;

    /**
     * Field _cSysIndPalStageMerged
     */
    private java.lang.String _cSysIndPalStageMerged;

    /**
     * Field _szCdEventStatus
     */
    private java.lang.String _szCdEventStatus;

    /**
     * Field _szCdPalCloseLivArr
     */
    private java.lang.String _szCdPalCloseLivArr;

    /**
     * Field _dtDtStageClose
     */
    private org.exolab.castor.types.Date _dtDtStageClose;

    /**
     * Field _szCdStageReasonClosed
     */
    private java.lang.String _szCdStageReasonClosed;

    /**
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _tsLastUpdate_ARRAY_CCFC03SO
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CCFC03SO _tsLastUpdate_ARRAY_CCFC03SO;

    /**
     * Field _szCdTask
     */
    private java.lang.String _szCdTask;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC03SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC03SO()


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
     * Returns the value of field 'cSysIndDischargeDate'.
     * 
     * @return the value of field 'CSysIndDischargeDate'.
     */
    public java.lang.String getCSysIndDischargeDate()
    {
        return this._cSysIndDischargeDate;
    } //-- java.lang.String getCSysIndDischargeDate() 

    /**
     * Returns the value of field 'cSysIndPalIlsAssmt'.
     * 
     * @return the value of field 'CSysIndPalIlsAssmt'.
     */
    public java.lang.String getCSysIndPalIlsAssmt()
    {
        return this._cSysIndPalIlsAssmt;
    } //-- java.lang.String getCSysIndPalIlsAssmt() 

    /**
     * Returns the value of field 'cSysIndPalLeadCoord'.
     * 
     * @return the value of field 'CSysIndPalLeadCoord'.
     */
    public java.lang.String getCSysIndPalLeadCoord()
    {
        return this._cSysIndPalLeadCoord;
    } //-- java.lang.String getCSysIndPalLeadCoord() 

    /**
     * Returns the value of field 'cSysIndPalOverEighteen'.
     * 
     * @return the value of field 'CSysIndPalOverEighteen'.
     */
    public java.lang.String getCSysIndPalOverEighteen()
    {
        return this._cSysIndPalOverEighteen;
    } //-- java.lang.String getCSysIndPalOverEighteen() 

    /**
     * Returns the value of field 'cSysIndPalStageMerged'.
     * 
     * @return the value of field 'CSysIndPalStageMerged'.
     */
    public java.lang.String getCSysIndPalStageMerged()
    {
        return this._cSysIndPalStageMerged;
    } //-- java.lang.String getCSysIndPalStageMerged() 

    /**
     * Returns the value of field 'cSysIndPalSvcAuth'.
     * 
     * @return the value of field 'CSysIndPalSvcAuth'.
     */
    public java.lang.String getCSysIndPalSvcAuth()
    {
        return this._cSysIndPalSvcAuth;
    } //-- java.lang.String getCSysIndPalSvcAuth() 

    /**
     * Returns the value of field 'cSysIndPrimaryWorker'.
     * 
     * @return the value of field 'CSysIndPrimaryWorker'.
     */
    public java.lang.String getCSysIndPrimaryWorker()
    {
        return this._cSysIndPrimaryWorker;
    } //-- java.lang.String getCSysIndPrimaryWorker() 

    /**
     * Returns the value of field 'dtDtStageClose'.
     * 
     * @return the value of field 'DtDtStageClose'.
     */
    public org.exolab.castor.types.Date getDtDtStageClose()
    {
        return this._dtDtStageClose;
    } //-- org.exolab.castor.types.Date getDtDtStageClose() 

    /**
     * Returns the value of field 'dtWCDDtSystemDate'.
     * 
     * @return the value of field 'DtWCDDtSystemDate'.
     */
    public org.exolab.castor.types.Date getDtWCDDtSystemDate()
    {
        return this._dtWCDDtSystemDate;
    } //-- org.exolab.castor.types.Date getDtWCDDtSystemDate() 

    /**
     * Returns the value of field 'szCdEventStatus'.
     * 
     * @return the value of field 'SzCdEventStatus'.
     */
    public java.lang.String getSzCdEventStatus()
    {
        return this._szCdEventStatus;
    } //-- java.lang.String getSzCdEventStatus() 

    /**
     * Returns the value of field 'szCdPalCloseLivArr'.
     * 
     * @return the value of field 'SzCdPalCloseLivArr'.
     */
    public java.lang.String getSzCdPalCloseLivArr()
    {
        return this._szCdPalCloseLivArr;
    } //-- java.lang.String getSzCdPalCloseLivArr() 

    /**
     * Returns the value of field 'szCdStageReasonClosed'.
     * 
     * @return the value of field 'SzCdStageReasonClosed'.
     */
    public java.lang.String getSzCdStageReasonClosed()
    {
        return this._szCdStageReasonClosed;
    } //-- java.lang.String getSzCdStageReasonClosed() 

    /**
     * Returns the value of field 'szCdTask'.
     * 
     * @return the value of field 'SzCdTask'.
     */
    public java.lang.String getSzCdTask()
    {
        return this._szCdTask;
    } //-- java.lang.String getSzCdTask() 

    /**
     * Returns the value of field 'tsLastUpdate_ARRAY_CCFC03SO'.
     * 
     * @return the value of field 'TsLastUpdate_ARRAY_CCFC03SO'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CCFC03SO getTsLastUpdate_ARRAY_CCFC03SO()
    {
        return this._tsLastUpdate_ARRAY_CCFC03SO;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CCFC03SO getTsLastUpdate_ARRAY_CCFC03SO() 

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
     * Sets the value of field 'cSysIndDischargeDate'.
     * 
     * @param cSysIndDischargeDate the value of field
     * 'cSysIndDischargeDate'.
     */
    public void setCSysIndDischargeDate(java.lang.String cSysIndDischargeDate)
    {
        this._cSysIndDischargeDate = cSysIndDischargeDate;
    } //-- void setCSysIndDischargeDate(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndPalIlsAssmt'.
     * 
     * @param cSysIndPalIlsAssmt the value of field
     * 'cSysIndPalIlsAssmt'.
     */
    public void setCSysIndPalIlsAssmt(java.lang.String cSysIndPalIlsAssmt)
    {
        this._cSysIndPalIlsAssmt = cSysIndPalIlsAssmt;
    } //-- void setCSysIndPalIlsAssmt(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndPalLeadCoord'.
     * 
     * @param cSysIndPalLeadCoord the value of field
     * 'cSysIndPalLeadCoord'.
     */
    public void setCSysIndPalLeadCoord(java.lang.String cSysIndPalLeadCoord)
    {
        this._cSysIndPalLeadCoord = cSysIndPalLeadCoord;
    } //-- void setCSysIndPalLeadCoord(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndPalOverEighteen'.
     * 
     * @param cSysIndPalOverEighteen the value of field
     * 'cSysIndPalOverEighteen'.
     */
    public void setCSysIndPalOverEighteen(java.lang.String cSysIndPalOverEighteen)
    {
        this._cSysIndPalOverEighteen = cSysIndPalOverEighteen;
    } //-- void setCSysIndPalOverEighteen(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndPalStageMerged'.
     * 
     * @param cSysIndPalStageMerged the value of field
     * 'cSysIndPalStageMerged'.
     */
    public void setCSysIndPalStageMerged(java.lang.String cSysIndPalStageMerged)
    {
        this._cSysIndPalStageMerged = cSysIndPalStageMerged;
    } //-- void setCSysIndPalStageMerged(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndPalSvcAuth'.
     * 
     * @param cSysIndPalSvcAuth the value of field
     * 'cSysIndPalSvcAuth'.
     */
    public void setCSysIndPalSvcAuth(java.lang.String cSysIndPalSvcAuth)
    {
        this._cSysIndPalSvcAuth = cSysIndPalSvcAuth;
    } //-- void setCSysIndPalSvcAuth(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndPrimaryWorker'.
     * 
     * @param cSysIndPrimaryWorker the value of field
     * 'cSysIndPrimaryWorker'.
     */
    public void setCSysIndPrimaryWorker(java.lang.String cSysIndPrimaryWorker)
    {
        this._cSysIndPrimaryWorker = cSysIndPrimaryWorker;
    } //-- void setCSysIndPrimaryWorker(java.lang.String) 

    /**
     * Sets the value of field 'dtDtStageClose'.
     * 
     * @param dtDtStageClose the value of field 'dtDtStageClose'.
     */
    public void setDtDtStageClose(org.exolab.castor.types.Date dtDtStageClose)
    {
        this._dtDtStageClose = dtDtStageClose;
    } //-- void setDtDtStageClose(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtWCDDtSystemDate'.
     * 
     * @param dtWCDDtSystemDate the value of field
     * 'dtWCDDtSystemDate'.
     */
    public void setDtWCDDtSystemDate(org.exolab.castor.types.Date dtWCDDtSystemDate)
    {
        this._dtWCDDtSystemDate = dtWCDDtSystemDate;
    } //-- void setDtWCDDtSystemDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdEventStatus'.
     * 
     * @param szCdEventStatus the value of field 'szCdEventStatus'.
     */
    public void setSzCdEventStatus(java.lang.String szCdEventStatus)
    {
        this._szCdEventStatus = szCdEventStatus;
    } //-- void setSzCdEventStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdPalCloseLivArr'.
     * 
     * @param szCdPalCloseLivArr the value of field
     * 'szCdPalCloseLivArr'.
     */
    public void setSzCdPalCloseLivArr(java.lang.String szCdPalCloseLivArr)
    {
        this._szCdPalCloseLivArr = szCdPalCloseLivArr;
    } //-- void setSzCdPalCloseLivArr(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageReasonClosed'.
     * 
     * @param szCdStageReasonClosed the value of field
     * 'szCdStageReasonClosed'.
     */
    public void setSzCdStageReasonClosed(java.lang.String szCdStageReasonClosed)
    {
        this._szCdStageReasonClosed = szCdStageReasonClosed;
    } //-- void setSzCdStageReasonClosed(java.lang.String) 

    /**
     * Sets the value of field 'szCdTask'.
     * 
     * @param szCdTask the value of field 'szCdTask'.
     */
    public void setSzCdTask(java.lang.String szCdTask)
    {
        this._szCdTask = szCdTask;
    } //-- void setSzCdTask(java.lang.String) 

    /**
     * Sets the value of field 'tsLastUpdate_ARRAY_CCFC03SO'.
     * 
     * @param tsLastUpdate_ARRAY_CCFC03SO the value of field
     * 'tsLastUpdate_ARRAY_CCFC03SO'.
     */
    public void setTsLastUpdate_ARRAY_CCFC03SO(gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CCFC03SO tsLastUpdate_ARRAY_CCFC03SO)
    {
        this._tsLastUpdate_ARRAY_CCFC03SO = tsLastUpdate_ARRAY_CCFC03SO;
    } //-- void setTsLastUpdate_ARRAY_CCFC03SO(gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CCFC03SO) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC03SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC03SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC03SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC03SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC03SO unmarshal(java.io.Reader) 

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
