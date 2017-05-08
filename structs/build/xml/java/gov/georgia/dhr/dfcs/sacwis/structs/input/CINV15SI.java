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
 * Class CINV15SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV15SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtDtCPSInvstDtlBegun
     */
    private org.exolab.castor.types.Date _dtDtCPSInvstDtlBegun;

    /**
     * Field _szCdTask
     */
    private java.lang.String _szCdTask;

    /**
     * Field _szCdRiskAssmtRiskFind
     */
    private java.lang.String _szCdRiskAssmtRiskFind;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _bIndCpsInvstEaConcl
     */
    private java.lang.String _bIndCpsInvstEaConcl;

    /**
     * Field _szDcdEditProcess
     */
    private java.lang.String _szDcdEditProcess;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _szCdStageReasonClosed
     */
    private java.lang.String _szCdStageReasonClosed;

    /**
     * Field _szCdPersonDeath
     */
    private java.lang.String _szCdPersonDeath;

    /**
     * Field _cIndCpsInvstDtlRaNa
     */
    private java.lang.String _cIndCpsInvstDtlRaNa;

    /**
     * Field _cIndCpsInvstAbbrv
     */
    private java.lang.String _cIndCpsInvstAbbrv;

    /**
     * Field _bIndValidateAssessments
     */
    private java.lang.String _bIndValidateAssessments;

    /**
     * Field _cdCpsOverallDisptn
     */
    private java.lang.String _cdCpsOverallDisptn;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV15SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV15SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

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
     * Returns the value of field 'bIndCpsInvstEaConcl'.
     * 
     * @return the value of field 'BIndCpsInvstEaConcl'.
     */
    public java.lang.String getBIndCpsInvstEaConcl()
    {
        return this._bIndCpsInvstEaConcl;
    } //-- java.lang.String getBIndCpsInvstEaConcl() 

    /**
     * Returns the value of field 'bIndValidateAssessments'.
     * 
     * @return the value of field 'BIndValidateAssessments'.
     */
    public java.lang.String getBIndValidateAssessments()
    {
        return this._bIndValidateAssessments;
    } //-- java.lang.String getBIndValidateAssessments() 

    /**
     * Returns the value of field 'cIndCpsInvstAbbrv'.
     * 
     * @return the value of field 'CIndCpsInvstAbbrv'.
     */
    public java.lang.String getCIndCpsInvstAbbrv()
    {
        return this._cIndCpsInvstAbbrv;
    } //-- java.lang.String getCIndCpsInvstAbbrv() 

    /**
     * Returns the value of field 'cIndCpsInvstDtlRaNa'.
     * 
     * @return the value of field 'CIndCpsInvstDtlRaNa'.
     */
    public java.lang.String getCIndCpsInvstDtlRaNa()
    {
        return this._cIndCpsInvstDtlRaNa;
    } //-- java.lang.String getCIndCpsInvstDtlRaNa() 

    /**
     * Returns the value of field 'cdCpsOverallDisptn'.
     * 
     * @return the value of field 'CdCpsOverallDisptn'.
     */
    public java.lang.String getCdCpsOverallDisptn()
    {
        return this._cdCpsOverallDisptn;
    } //-- java.lang.String getCdCpsOverallDisptn() 

    /**
     * Returns the value of field 'dtDtCPSInvstDtlBegun'.
     * 
     * @return the value of field 'DtDtCPSInvstDtlBegun'.
     */
    public org.exolab.castor.types.Date getDtDtCPSInvstDtlBegun()
    {
        return this._dtDtCPSInvstDtlBegun;
    } //-- org.exolab.castor.types.Date getDtDtCPSInvstDtlBegun() 

    /**
     * Returns the value of field 'szCdPersonDeath'.
     * 
     * @return the value of field 'SzCdPersonDeath'.
     */
    public java.lang.String getSzCdPersonDeath()
    {
        return this._szCdPersonDeath;
    } //-- java.lang.String getSzCdPersonDeath() 

    /**
     * Returns the value of field 'szCdRiskAssmtRiskFind'.
     * 
     * @return the value of field 'SzCdRiskAssmtRiskFind'.
     */
    public java.lang.String getSzCdRiskAssmtRiskFind()
    {
        return this._szCdRiskAssmtRiskFind;
    } //-- java.lang.String getSzCdRiskAssmtRiskFind() 

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
     * Returns the value of field 'szDcdEditProcess'.
     * 
     * @return the value of field 'SzDcdEditProcess'.
     */
    public java.lang.String getSzDcdEditProcess()
    {
        return this._szDcdEditProcess;
    } //-- java.lang.String getSzDcdEditProcess() 

    /**
     * Returns the value of field 'ulIdCase'.
     * 
     * @return the value of field 'UlIdCase'.
     */
    public int getUlIdCase()
    {
        return this._ulIdCase;
    } //-- int getUlIdCase() 

    /**
     * Returns the value of field 'ulIdEvent'.
     * 
     * @return the value of field 'UlIdEvent'.
     */
    public int getUlIdEvent()
    {
        return this._ulIdEvent;
    } //-- int getUlIdEvent() 

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
     * Method hasUlIdCase
     * 
     * 
     * 
     * @return true if at least one UlIdCase has been added
     */
    public boolean hasUlIdCase()
    {
        return this._has_ulIdCase;
    } //-- boolean hasUlIdCase() 

    /**
     * Method hasUlIdEvent
     * 
     * 
     * 
     * @return true if at least one UlIdEvent has been added
     */
    public boolean hasUlIdEvent()
    {
        return this._has_ulIdEvent;
    } //-- boolean hasUlIdEvent() 

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
     * Sets the value of field 'bIndCpsInvstEaConcl'.
     * 
     * @param bIndCpsInvstEaConcl the value of field
     * 'bIndCpsInvstEaConcl'.
     */
    public void setBIndCpsInvstEaConcl(java.lang.String bIndCpsInvstEaConcl)
    {
        this._bIndCpsInvstEaConcl = bIndCpsInvstEaConcl;
    } //-- void setBIndCpsInvstEaConcl(java.lang.String) 

    /**
     * Sets the value of field 'bIndValidateAssessments'.
     * 
     * @param bIndValidateAssessments the value of field
     * 'bIndValidateAssessments'.
     */
    public void setBIndValidateAssessments(java.lang.String bIndValidateAssessments)
    {
        this._bIndValidateAssessments = bIndValidateAssessments;
    } //-- void setBIndValidateAssessments(java.lang.String) 

    /**
     * Sets the value of field 'cIndCpsInvstAbbrv'.
     * 
     * @param cIndCpsInvstAbbrv the value of field
     * 'cIndCpsInvstAbbrv'.
     */
    public void setCIndCpsInvstAbbrv(java.lang.String cIndCpsInvstAbbrv)
    {
        this._cIndCpsInvstAbbrv = cIndCpsInvstAbbrv;
    } //-- void setCIndCpsInvstAbbrv(java.lang.String) 

    /**
     * Sets the value of field 'cIndCpsInvstDtlRaNa'.
     * 
     * @param cIndCpsInvstDtlRaNa the value of field
     * 'cIndCpsInvstDtlRaNa'.
     */
    public void setCIndCpsInvstDtlRaNa(java.lang.String cIndCpsInvstDtlRaNa)
    {
        this._cIndCpsInvstDtlRaNa = cIndCpsInvstDtlRaNa;
    } //-- void setCIndCpsInvstDtlRaNa(java.lang.String) 

    /**
     * Sets the value of field 'cdCpsOverallDisptn'.
     * 
     * @param cdCpsOverallDisptn the value of field
     * 'cdCpsOverallDisptn'.
     */
    public void setCdCpsOverallDisptn(java.lang.String cdCpsOverallDisptn)
    {
        this._cdCpsOverallDisptn = cdCpsOverallDisptn;
    } //-- void setCdCpsOverallDisptn(java.lang.String) 

    /**
     * Sets the value of field 'dtDtCPSInvstDtlBegun'.
     * 
     * @param dtDtCPSInvstDtlBegun the value of field
     * 'dtDtCPSInvstDtlBegun'.
     */
    public void setDtDtCPSInvstDtlBegun(org.exolab.castor.types.Date dtDtCPSInvstDtlBegun)
    {
        this._dtDtCPSInvstDtlBegun = dtDtCPSInvstDtlBegun;
    } //-- void setDtDtCPSInvstDtlBegun(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdPersonDeath'.
     * 
     * @param szCdPersonDeath the value of field 'szCdPersonDeath'.
     */
    public void setSzCdPersonDeath(java.lang.String szCdPersonDeath)
    {
        this._szCdPersonDeath = szCdPersonDeath;
    } //-- void setSzCdPersonDeath(java.lang.String) 

    /**
     * Sets the value of field 'szCdRiskAssmtRiskFind'.
     * 
     * @param szCdRiskAssmtRiskFind the value of field
     * 'szCdRiskAssmtRiskFind'.
     */
    public void setSzCdRiskAssmtRiskFind(java.lang.String szCdRiskAssmtRiskFind)
    {
        this._szCdRiskAssmtRiskFind = szCdRiskAssmtRiskFind;
    } //-- void setSzCdRiskAssmtRiskFind(java.lang.String) 

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
     * Sets the value of field 'szDcdEditProcess'.
     * 
     * @param szDcdEditProcess the value of field 'szDcdEditProcess'
     */
    public void setSzDcdEditProcess(java.lang.String szDcdEditProcess)
    {
        this._szDcdEditProcess = szDcdEditProcess;
    } //-- void setSzDcdEditProcess(java.lang.String) 

    /**
     * Sets the value of field 'ulIdCase'.
     * 
     * @param ulIdCase the value of field 'ulIdCase'.
     */
    public void setUlIdCase(int ulIdCase)
    {
        this._ulIdCase = ulIdCase;
        this._has_ulIdCase = true;
    } //-- void setUlIdCase(int) 

    /**
     * Sets the value of field 'ulIdEvent'.
     * 
     * @param ulIdEvent the value of field 'ulIdEvent'.
     */
    public void setUlIdEvent(int ulIdEvent)
    {
        this._ulIdEvent = ulIdEvent;
        this._has_ulIdEvent = true;
    } //-- void setUlIdEvent(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINV15SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CINV15SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV15SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV15SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV15SI unmarshal(java.io.Reader) 

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
