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
 * Class CINV46SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV46SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtDtTodaysDate
     */
    private org.exolab.castor.types.Date _dtDtTodaysDate;

    /**
     * Field _cdAllegDisposition
     */
    private java.lang.String _cdAllegDisposition;

    /**
     * Field _cIndMaltreatInCare
     */
    private java.lang.String _cIndMaltreatInCare;

    /**
     * Field _cIndUnsubMIC
     */
    private java.lang.String _cIndUnsubMIC;

    /**
     * Field _cIndCpsPolicyViolation
     */
    private java.lang.String _cIndCpsPolicyViolation;

    /**
     * Field _szCdAllegIncidentStage
     */
    private java.lang.String _szCdAllegIncidentStage;

    /**
     * Field _dtDtAllegedIncident
     */
    private org.exolab.castor.types.Date _dtDtAllegedIncident;

    /**
     * Field _dtPriorNearFatalMaltrtmnt
     */
    private org.exolab.castor.types.Date _dtPriorNearFatalMaltrtmnt;

    /**
     * Field _szCdAllegedMalLocation
     */
    private java.lang.String _szCdAllegedMalLocation;

    /**
     * Field _szCdAllegSeverity
     */
    private java.lang.String _szCdAllegSeverity;

    /**
     * Field _indCrimChrgsFiled
     */
    private java.lang.String _indCrimChrgsFiled;

    /**
     * Field _indChildDeathSeverity
     */
    private java.lang.String _indChildDeathSeverity;

    /**
     * Field _szCdAllegType
     */
    private java.lang.String _szCdAllegType;

    /**
     * Field _szTxtAllegDuration
     */
    private java.lang.String _szTxtAllegDuration;

    /**
     * Field _szCdMaltreatorRel
     */
    private java.lang.String _szCdMaltreatorRel;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _CINV46SOG1_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1_ARRAY _CINV46SOG1_ARRAY;

    /**
     * Field _dtDtPersonBirth_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.DtDtPersonBirth_ARRAY _dtDtPersonBirth_ARRAY;

    /**
     * Field _szCdPersonMaritalStatus_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPersonMaritalStatus_ARRAY _szCdPersonMaritalStatus_ARRAY;

    /**
     * Field _szTxtEvidenceSummary
     */
    private java.lang.String _szTxtEvidenceSummary;

    /**
     * Field _allegEvidence_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY _allegEvidence_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV46SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'allegEvidence_ARRAY'.
     * 
     * @return the value of field 'AllegEvidence_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY getAllegEvidence_ARRAY()
    {
        return this._allegEvidence_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY getAllegEvidence_ARRAY() 

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
     * Returns the value of field 'CINV46SOG1_ARRAY'.
     * 
     * @return the value of field 'CINV46SOG1_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1_ARRAY getCINV46SOG1_ARRAY()
    {
        return this._CINV46SOG1_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1_ARRAY getCINV46SOG1_ARRAY() 

    /**
     * Returns the value of field 'cIndCpsPolicyViolation'.
     * 
     * @return the value of field 'CIndCpsPolicyViolation'.
     */
    public java.lang.String getCIndCpsPolicyViolation()
    {
        return this._cIndCpsPolicyViolation;
    } //-- java.lang.String getCIndCpsPolicyViolation() 

    /**
     * Returns the value of field 'cIndMaltreatInCare'.
     * 
     * @return the value of field 'CIndMaltreatInCare'.
     */
    public java.lang.String getCIndMaltreatInCare()
    {
        return this._cIndMaltreatInCare;
    } //-- java.lang.String getCIndMaltreatInCare() 

    /**
     * Returns the value of field 'cIndUnsubMIC'.
     * 
     * @return the value of field 'CIndUnsubMIC'.
     */
    public java.lang.String getCIndUnsubMIC()
    {
        return this._cIndUnsubMIC;
    } //-- java.lang.String getCIndUnsubMIC() 

    /**
     * Returns the value of field 'cdAllegDisposition'.
     * 
     * @return the value of field 'CdAllegDisposition'.
     */
    public java.lang.String getCdAllegDisposition()
    {
        return this._cdAllegDisposition;
    } //-- java.lang.String getCdAllegDisposition() 

    /**
     * Returns the value of field 'dtDtAllegedIncident'.
     * 
     * @return the value of field 'DtDtAllegedIncident'.
     */
    public org.exolab.castor.types.Date getDtDtAllegedIncident()
    {
        return this._dtDtAllegedIncident;
    } //-- org.exolab.castor.types.Date getDtDtAllegedIncident() 

    /**
     * Returns the value of field 'dtDtPersonBirth_ARRAY'.
     * 
     * @return the value of field 'DtDtPersonBirth_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.DtDtPersonBirth_ARRAY getDtDtPersonBirth_ARRAY()
    {
        return this._dtDtPersonBirth_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.DtDtPersonBirth_ARRAY getDtDtPersonBirth_ARRAY() 

    /**
     * Returns the value of field 'dtDtTodaysDate'.
     * 
     * @return the value of field 'DtDtTodaysDate'.
     */
    public org.exolab.castor.types.Date getDtDtTodaysDate()
    {
        return this._dtDtTodaysDate;
    } //-- org.exolab.castor.types.Date getDtDtTodaysDate() 

    /**
     * Returns the value of field 'dtPriorNearFatalMaltrtmnt'.
     * 
     * @return the value of field 'DtPriorNearFatalMaltrtmnt'.
     */
    public org.exolab.castor.types.Date getDtPriorNearFatalMaltrtmnt()
    {
        return this._dtPriorNearFatalMaltrtmnt;
    } //-- org.exolab.castor.types.Date getDtPriorNearFatalMaltrtmnt() 

    /**
     * Returns the value of field 'indChildDeathSeverity'.
     * 
     * @return the value of field 'IndChildDeathSeverity'.
     */
    public java.lang.String getIndChildDeathSeverity()
    {
        return this._indChildDeathSeverity;
    } //-- java.lang.String getIndChildDeathSeverity() 

    /**
     * Returns the value of field 'indCrimChrgsFiled'.
     * 
     * @return the value of field 'IndCrimChrgsFiled'.
     */
    public java.lang.String getIndCrimChrgsFiled()
    {
        return this._indCrimChrgsFiled;
    } //-- java.lang.String getIndCrimChrgsFiled() 

    /**
     * Returns the value of field 'szCdAllegIncidentStage'.
     * 
     * @return the value of field 'SzCdAllegIncidentStage'.
     */
    public java.lang.String getSzCdAllegIncidentStage()
    {
        return this._szCdAllegIncidentStage;
    } //-- java.lang.String getSzCdAllegIncidentStage() 

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
     * Returns the value of field 'szCdAllegType'.
     * 
     * @return the value of field 'SzCdAllegType'.
     */
    public java.lang.String getSzCdAllegType()
    {
        return this._szCdAllegType;
    } //-- java.lang.String getSzCdAllegType() 

    /**
     * Returns the value of field 'szCdAllegedMalLocation'.
     * 
     * @return the value of field 'SzCdAllegedMalLocation'.
     */
    public java.lang.String getSzCdAllegedMalLocation()
    {
        return this._szCdAllegedMalLocation;
    } //-- java.lang.String getSzCdAllegedMalLocation() 

    /**
     * Returns the value of field 'szCdMaltreatorRel'.
     * 
     * @return the value of field 'SzCdMaltreatorRel'.
     */
    public java.lang.String getSzCdMaltreatorRel()
    {
        return this._szCdMaltreatorRel;
    } //-- java.lang.String getSzCdMaltreatorRel() 

    /**
     * Returns the value of field 'szCdPersonMaritalStatus_ARRAY'.
     * 
     * @return the value of field 'SzCdPersonMaritalStatus_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPersonMaritalStatus_ARRAY getSzCdPersonMaritalStatus_ARRAY()
    {
        return this._szCdPersonMaritalStatus_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPersonMaritalStatus_ARRAY getSzCdPersonMaritalStatus_ARRAY() 

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
     * Sets the value of field 'allegEvidence_ARRAY'.
     * 
     * @param allegEvidence_ARRAY the value of field
     * 'allegEvidence_ARRAY'.
     */
    public void setAllegEvidence_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY allegEvidence_ARRAY)
    {
        this._allegEvidence_ARRAY = allegEvidence_ARRAY;
    } //-- void setAllegEvidence_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY) 

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
     * Sets the value of field 'CINV46SOG1_ARRAY'.
     * 
     * @param CINV46SOG1_ARRAY the value of field 'CINV46SOG1_ARRAY'
     */
    public void setCINV46SOG1_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1_ARRAY CINV46SOG1_ARRAY)
    {
        this._CINV46SOG1_ARRAY = CINV46SOG1_ARRAY;
    } //-- void setCINV46SOG1_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1_ARRAY) 

    /**
     * Sets the value of field 'cIndCpsPolicyViolation'.
     * 
     * @param cIndCpsPolicyViolation the value of field
     * 'cIndCpsPolicyViolation'.
     */
    public void setCIndCpsPolicyViolation(java.lang.String cIndCpsPolicyViolation)
    {
        this._cIndCpsPolicyViolation = cIndCpsPolicyViolation;
    } //-- void setCIndCpsPolicyViolation(java.lang.String) 

    /**
     * Sets the value of field 'cIndMaltreatInCare'.
     * 
     * @param cIndMaltreatInCare the value of field
     * 'cIndMaltreatInCare'.
     */
    public void setCIndMaltreatInCare(java.lang.String cIndMaltreatInCare)
    {
        this._cIndMaltreatInCare = cIndMaltreatInCare;
    } //-- void setCIndMaltreatInCare(java.lang.String) 

    /**
     * Sets the value of field 'cIndUnsubMIC'.
     * 
     * @param cIndUnsubMIC the value of field 'cIndUnsubMIC'.
     */
    public void setCIndUnsubMIC(java.lang.String cIndUnsubMIC)
    {
        this._cIndUnsubMIC = cIndUnsubMIC;
    } //-- void setCIndUnsubMIC(java.lang.String) 

    /**
     * Sets the value of field 'cdAllegDisposition'.
     * 
     * @param cdAllegDisposition the value of field
     * 'cdAllegDisposition'.
     */
    public void setCdAllegDisposition(java.lang.String cdAllegDisposition)
    {
        this._cdAllegDisposition = cdAllegDisposition;
    } //-- void setCdAllegDisposition(java.lang.String) 

    /**
     * Sets the value of field 'dtDtAllegedIncident'.
     * 
     * @param dtDtAllegedIncident the value of field
     * 'dtDtAllegedIncident'.
     */
    public void setDtDtAllegedIncident(org.exolab.castor.types.Date dtDtAllegedIncident)
    {
        this._dtDtAllegedIncident = dtDtAllegedIncident;
    } //-- void setDtDtAllegedIncident(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPersonBirth_ARRAY'.
     * 
     * @param dtDtPersonBirth_ARRAY the value of field
     * 'dtDtPersonBirth_ARRAY'.
     */
    public void setDtDtPersonBirth_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.DtDtPersonBirth_ARRAY dtDtPersonBirth_ARRAY)
    {
        this._dtDtPersonBirth_ARRAY = dtDtPersonBirth_ARRAY;
    } //-- void setDtDtPersonBirth_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.DtDtPersonBirth_ARRAY) 

    /**
     * Sets the value of field 'dtDtTodaysDate'.
     * 
     * @param dtDtTodaysDate the value of field 'dtDtTodaysDate'.
     */
    public void setDtDtTodaysDate(org.exolab.castor.types.Date dtDtTodaysDate)
    {
        this._dtDtTodaysDate = dtDtTodaysDate;
    } //-- void setDtDtTodaysDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtPriorNearFatalMaltrtmnt'.
     * 
     * @param dtPriorNearFatalMaltrtmnt the value of field
     * 'dtPriorNearFatalMaltrtmnt'.
     */
    public void setDtPriorNearFatalMaltrtmnt(org.exolab.castor.types.Date dtPriorNearFatalMaltrtmnt)
    {
        this._dtPriorNearFatalMaltrtmnt = dtPriorNearFatalMaltrtmnt;
    } //-- void setDtPriorNearFatalMaltrtmnt(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'indChildDeathSeverity'.
     * 
     * @param indChildDeathSeverity the value of field
     * 'indChildDeathSeverity'.
     */
    public void setIndChildDeathSeverity(java.lang.String indChildDeathSeverity)
    {
        this._indChildDeathSeverity = indChildDeathSeverity;
    } //-- void setIndChildDeathSeverity(java.lang.String) 

    /**
     * Sets the value of field 'indCrimChrgsFiled'.
     * 
     * @param indCrimChrgsFiled the value of field
     * 'indCrimChrgsFiled'.
     */
    public void setIndCrimChrgsFiled(java.lang.String indCrimChrgsFiled)
    {
        this._indCrimChrgsFiled = indCrimChrgsFiled;
    } //-- void setIndCrimChrgsFiled(java.lang.String) 

    /**
     * Sets the value of field 'szCdAllegIncidentStage'.
     * 
     * @param szCdAllegIncidentStage the value of field
     * 'szCdAllegIncidentStage'.
     */
    public void setSzCdAllegIncidentStage(java.lang.String szCdAllegIncidentStage)
    {
        this._szCdAllegIncidentStage = szCdAllegIncidentStage;
    } //-- void setSzCdAllegIncidentStage(java.lang.String) 

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
     * Sets the value of field 'szCdAllegType'.
     * 
     * @param szCdAllegType the value of field 'szCdAllegType'.
     */
    public void setSzCdAllegType(java.lang.String szCdAllegType)
    {
        this._szCdAllegType = szCdAllegType;
    } //-- void setSzCdAllegType(java.lang.String) 

    /**
     * Sets the value of field 'szCdAllegedMalLocation'.
     * 
     * @param szCdAllegedMalLocation the value of field
     * 'szCdAllegedMalLocation'.
     */
    public void setSzCdAllegedMalLocation(java.lang.String szCdAllegedMalLocation)
    {
        this._szCdAllegedMalLocation = szCdAllegedMalLocation;
    } //-- void setSzCdAllegedMalLocation(java.lang.String) 

    /**
     * Sets the value of field 'szCdMaltreatorRel'.
     * 
     * @param szCdMaltreatorRel the value of field
     * 'szCdMaltreatorRel'.
     */
    public void setSzCdMaltreatorRel(java.lang.String szCdMaltreatorRel)
    {
        this._szCdMaltreatorRel = szCdMaltreatorRel;
    } //-- void setSzCdMaltreatorRel(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonMaritalStatus_ARRAY'.
     * 
     * @param szCdPersonMaritalStatus_ARRAY the value of field
     * 'szCdPersonMaritalStatus_ARRAY'.
     */
    public void setSzCdPersonMaritalStatus_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPersonMaritalStatus_ARRAY szCdPersonMaritalStatus_ARRAY)
    {
        this._szCdPersonMaritalStatus_ARRAY = szCdPersonMaritalStatus_ARRAY;
    } //-- void setSzCdPersonMaritalStatus_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPersonMaritalStatus_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SO unmarshal(java.io.Reader) 

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
