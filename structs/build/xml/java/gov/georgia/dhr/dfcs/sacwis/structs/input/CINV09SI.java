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
 * Class CINV09SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV09SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CINV09SIG_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG_ARRAY _CINV09SIG_ARRAY;

    /**
     * Field _cdAllegDisposition_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.CdAllegDisposition_ARRAY _cdAllegDisposition_ARRAY;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szCdTask
     */
    private java.lang.String _szCdTask;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _szCdStageProgram
     */
    private java.lang.String _szCdStageProgram;

    /**
     * Field _szCdAllegSeverity
     */
    private java.lang.String _szCdAllegSeverity;

    /**
     * Field _szTxtAllegDuration
     */
    private java.lang.String _szTxtAllegDuration;

    /**
     * Field _szTxtEvidenceSummary
     */
    private java.lang.String _szTxtEvidenceSummary;

    /**
     * Field _allegEvidenceCode_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode_ARRAY _allegEvidenceCode_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV09SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SI()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'allegEvidenceCode_ARRAY'.
     * 
     * @return the value of field 'AllegEvidenceCode_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode_ARRAY getAllegEvidenceCode_ARRAY()
    {
        return this._allegEvidenceCode_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode_ARRAY getAllegEvidenceCode_ARRAY() 

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
     * Returns the value of field 'CINV09SIG_ARRAY'.
     * 
     * @return the value of field 'CINV09SIG_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG_ARRAY getCINV09SIG_ARRAY()
    {
        return this._CINV09SIG_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG_ARRAY getCINV09SIG_ARRAY() 

    /**
     * Returns the value of field 'cdAllegDisposition_ARRAY'.
     * 
     * @return the value of field 'CdAllegDisposition_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CdAllegDisposition_ARRAY getCdAllegDisposition_ARRAY()
    {
        return this._cdAllegDisposition_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CdAllegDisposition_ARRAY getCdAllegDisposition_ARRAY() 

    /**
     * Returns the value of field 'szCdAllegSeverity'.
     * 
     * @return the value of field 'SzCdAllegSeverity'.
     */
    public java.lang.String getSzCdAllegSeverity()
    {
        return this._szCdAllegSeverity;
    } //-- java.lang.String getSzCdAllegSeverity() 

    /**
     * Returns the value of field 'szCdStage'.
     * 
     * @return the value of field 'SzCdStage'.
     */
    public java.lang.String getSzCdStage()
    {
        return this._szCdStage;
    } //-- java.lang.String getSzCdStage() 

    /**
     * Returns the value of field 'szCdStageProgram'.
     * 
     * @return the value of field 'SzCdStageProgram'.
     */
    public java.lang.String getSzCdStageProgram()
    {
        return this._szCdStageProgram;
    } //-- java.lang.String getSzCdStageProgram() 

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
     * Returns the value of field 'szTxtAllegDuration'.
     * 
     * @return the value of field 'SzTxtAllegDuration'.
     */
    public java.lang.String getSzTxtAllegDuration()
    {
        return this._szTxtAllegDuration;
    } //-- java.lang.String getSzTxtAllegDuration() 

    /**
     * Returns the value of field 'szTxtEvidenceSummary'.
     * 
     * @return the value of field 'SzTxtEvidenceSummary'.
     */
    public java.lang.String getSzTxtEvidenceSummary()
    {
        return this._szTxtEvidenceSummary;
    } //-- java.lang.String getSzTxtEvidenceSummary() 

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
     * Sets the value of field 'allegEvidenceCode_ARRAY'.
     * 
     * @param allegEvidenceCode_ARRAY the value of field
     * 'allegEvidenceCode_ARRAY'.
     */
    public void setAllegEvidenceCode_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode_ARRAY allegEvidenceCode_ARRAY)
    {
        this._allegEvidenceCode_ARRAY = allegEvidenceCode_ARRAY;
    } //-- void setAllegEvidenceCode_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode_ARRAY) 

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
     * Sets the value of field 'CINV09SIG_ARRAY'.
     * 
     * @param CINV09SIG_ARRAY the value of field 'CINV09SIG_ARRAY'.
     */
    public void setCINV09SIG_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG_ARRAY CINV09SIG_ARRAY)
    {
        this._CINV09SIG_ARRAY = CINV09SIG_ARRAY;
    } //-- void setCINV09SIG_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG_ARRAY) 

    /**
     * Sets the value of field 'cdAllegDisposition_ARRAY'.
     * 
     * @param cdAllegDisposition_ARRAY the value of field
     * 'cdAllegDisposition_ARRAY'.
     */
    public void setCdAllegDisposition_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.CdAllegDisposition_ARRAY cdAllegDisposition_ARRAY)
    {
        this._cdAllegDisposition_ARRAY = cdAllegDisposition_ARRAY;
    } //-- void setCdAllegDisposition_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.CdAllegDisposition_ARRAY) 

    /**
     * Sets the value of field 'szCdAllegSeverity'.
     * 
     * @param szCdAllegSeverity the value of field
     * 'szCdAllegSeverity'.
     */
    public void setSzCdAllegSeverity(java.lang.String szCdAllegSeverity)
    {
        this._szCdAllegSeverity = szCdAllegSeverity;
    } //-- void setSzCdAllegSeverity(java.lang.String) 

    /**
     * Sets the value of field 'szCdStage'.
     * 
     * @param szCdStage the value of field 'szCdStage'.
     */
    public void setSzCdStage(java.lang.String szCdStage)
    {
        this._szCdStage = szCdStage;
    } //-- void setSzCdStage(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageProgram'.
     * 
     * @param szCdStageProgram the value of field 'szCdStageProgram'
     */
    public void setSzCdStageProgram(java.lang.String szCdStageProgram)
    {
        this._szCdStageProgram = szCdStageProgram;
    } //-- void setSzCdStageProgram(java.lang.String) 

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
     * Sets the value of field 'szTxtAllegDuration'.
     * 
     * @param szTxtAllegDuration the value of field
     * 'szTxtAllegDuration'.
     */
    public void setSzTxtAllegDuration(java.lang.String szTxtAllegDuration)
    {
        this._szTxtAllegDuration = szTxtAllegDuration;
    } //-- void setSzTxtAllegDuration(java.lang.String) 

    /**
     * Sets the value of field 'szTxtEvidenceSummary'.
     * 
     * @param szTxtEvidenceSummary the value of field
     * 'szTxtEvidenceSummary'.
     */
    public void setSzTxtEvidenceSummary(java.lang.String szTxtEvidenceSummary)
    {
        this._szTxtEvidenceSummary = szTxtEvidenceSummary;
    } //-- void setSzTxtEvidenceSummary(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SI unmarshal(java.io.Reader) 

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
