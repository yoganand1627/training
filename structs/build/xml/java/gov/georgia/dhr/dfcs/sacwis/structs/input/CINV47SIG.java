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
 * Class CINV47SIG.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV47SIG extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _cdAllegDisposition
     */
    private java.lang.String _cdAllegDisposition;

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
     * Field _ulIdAllegation
     */
    private int _ulIdAllegation;

    /**
     * keeps track of state for field: _ulIdAllegation
     */
    private boolean _has_ulIdAllegation;

    /**
     * Field _ulIdAllegedPerpetrator
     */
    private int _ulIdAllegedPerpetrator;

    /**
     * keeps track of state for field: _ulIdAllegedPerpetrator
     */
    private boolean _has_ulIdAllegedPerpetrator;

    /**
     * Field _szCdStagePersRole
     */
    private java.lang.String _szCdStagePersRole;

    /**
     * Field _tsSysTsLastUpdate3
     */
    private java.util.Date _tsSysTsLastUpdate3;

    /**
     * Field _ulIdVictim
     */
    private int _ulIdVictim;

    /**
     * keeps track of state for field: _ulIdVictim
     */
    private boolean _has_ulIdVictim;

    /**
     * Field _szCdStagePersRole2
     */
    private java.lang.String _szCdStagePersRole2;

    /**
     * Field _tsSysTsLastUpdate4
     */
    private java.util.Date _tsSysTsLastUpdate4;

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
     * Field _bIndFacilAllegCancelHist
     */
    private java.lang.String _bIndFacilAllegCancelHist;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szTxtEvidenceSummary
     */
    private java.lang.String _szTxtEvidenceSummary;

    /**
     * Field _indPriorNearFatality
     */
    private java.lang.String _indPriorNearFatality;

    /**
     * Field _allegEvidenceCode_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode_ARRAY _allegEvidenceCode_ARRAY;

    /**
     * Field _cIndMaltreatInCare
     */
    private java.lang.String _cIndMaltreatInCare;

    /**
     * Field _cIndUnsubMIC
     */
    private java.lang.String _cIndUnsubMIC;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV47SIG() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV47SIG()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdAllegation()
    {
        this._has_ulIdAllegation= false;
    } //-- void deleteUlIdAllegation() 

    /**
     */
    public void deleteUlIdAllegedPerpetrator()
    {
        this._has_ulIdAllegedPerpetrator= false;
    } //-- void deleteUlIdAllegedPerpetrator() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     */
    public void deleteUlIdVictim()
    {
        this._has_ulIdVictim= false;
    } //-- void deleteUlIdVictim() 

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
     * Returns the value of field 'bIndFacilAllegCancelHist'.
     * 
     * @return the value of field 'BIndFacilAllegCancelHist'.
     */
    public java.lang.String getBIndFacilAllegCancelHist()
    {
        return this._bIndFacilAllegCancelHist;
    } //-- java.lang.String getBIndFacilAllegCancelHist() 

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
     * Returns the value of field 'indPriorNearFatality'.
     * 
     * @return the value of field 'IndPriorNearFatality'.
     */
    public java.lang.String getIndPriorNearFatality()
    {
        return this._indPriorNearFatality;
    } //-- java.lang.String getIndPriorNearFatality() 

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
     * Returns the value of field 'szCdStagePersRole'.
     * 
     * @return the value of field 'SzCdStagePersRole'.
     */
    public java.lang.String getSzCdStagePersRole()
    {
        return this._szCdStagePersRole;
    } //-- java.lang.String getSzCdStagePersRole() 

    /**
     * Returns the value of field 'szCdStagePersRole2'.
     * 
     * @return the value of field 'SzCdStagePersRole2'.
     */
    public java.lang.String getSzCdStagePersRole2()
    {
        return this._szCdStagePersRole2;
    } //-- java.lang.String getSzCdStagePersRole2() 

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
     * Returns the value of field 'tsLastUpdate'.
     * 
     * @return the value of field 'TsLastUpdate'.
     */
    public java.util.Date getTsLastUpdate()
    {
        return this._tsLastUpdate;
    } //-- java.util.Date getTsLastUpdate() 

    /**
     * Returns the value of field 'tsSysTsLastUpdate3'.
     * 
     * @return the value of field 'TsSysTsLastUpdate3'.
     */
    public java.util.Date getTsSysTsLastUpdate3()
    {
        return this._tsSysTsLastUpdate3;
    } //-- java.util.Date getTsSysTsLastUpdate3() 

    /**
     * Returns the value of field 'tsSysTsLastUpdate4'.
     * 
     * @return the value of field 'TsSysTsLastUpdate4'.
     */
    public java.util.Date getTsSysTsLastUpdate4()
    {
        return this._tsSysTsLastUpdate4;
    } //-- java.util.Date getTsSysTsLastUpdate4() 

    /**
     * Returns the value of field 'ulIdAllegation'.
     * 
     * @return the value of field 'UlIdAllegation'.
     */
    public int getUlIdAllegation()
    {
        return this._ulIdAllegation;
    } //-- int getUlIdAllegation() 

    /**
     * Returns the value of field 'ulIdAllegedPerpetrator'.
     * 
     * @return the value of field 'UlIdAllegedPerpetrator'.
     */
    public int getUlIdAllegedPerpetrator()
    {
        return this._ulIdAllegedPerpetrator;
    } //-- int getUlIdAllegedPerpetrator() 

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
     * Returns the value of field 'ulIdVictim'.
     * 
     * @return the value of field 'UlIdVictim'.
     */
    public int getUlIdVictim()
    {
        return this._ulIdVictim;
    } //-- int getUlIdVictim() 

    /**
     * Method hasUlIdAllegation
     * 
     * 
     * 
     * @return true if at least one UlIdAllegation has been added
     */
    public boolean hasUlIdAllegation()
    {
        return this._has_ulIdAllegation;
    } //-- boolean hasUlIdAllegation() 

    /**
     * Method hasUlIdAllegedPerpetrator
     * 
     * 
     * 
     * @return true if at least one UlIdAllegedPerpetrator has been
     * added
     */
    public boolean hasUlIdAllegedPerpetrator()
    {
        return this._has_ulIdAllegedPerpetrator;
    } //-- boolean hasUlIdAllegedPerpetrator() 

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
     * Method hasUlIdVictim
     * 
     * 
     * 
     * @return true if at least one UlIdVictim has been added
     */
    public boolean hasUlIdVictim()
    {
        return this._has_ulIdVictim;
    } //-- boolean hasUlIdVictim() 

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
     * Sets the value of field 'bIndFacilAllegCancelHist'.
     * 
     * @param bIndFacilAllegCancelHist the value of field
     * 'bIndFacilAllegCancelHist'.
     */
    public void setBIndFacilAllegCancelHist(java.lang.String bIndFacilAllegCancelHist)
    {
        this._bIndFacilAllegCancelHist = bIndFacilAllegCancelHist;
    } //-- void setBIndFacilAllegCancelHist(java.lang.String) 

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
     * Sets the value of field 'indPriorNearFatality'.
     * 
     * @param indPriorNearFatality the value of field
     * 'indPriorNearFatality'.
     */
    public void setIndPriorNearFatality(java.lang.String indPriorNearFatality)
    {
        this._indPriorNearFatality = indPriorNearFatality;
    } //-- void setIndPriorNearFatality(java.lang.String) 

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
     * Sets the value of field 'szCdStagePersRole'.
     * 
     * @param szCdStagePersRole the value of field
     * 'szCdStagePersRole'.
     */
    public void setSzCdStagePersRole(java.lang.String szCdStagePersRole)
    {
        this._szCdStagePersRole = szCdStagePersRole;
    } //-- void setSzCdStagePersRole(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersRole2'.
     * 
     * @param szCdStagePersRole2 the value of field
     * 'szCdStagePersRole2'.
     */
    public void setSzCdStagePersRole2(java.lang.String szCdStagePersRole2)
    {
        this._szCdStagePersRole2 = szCdStagePersRole2;
    } //-- void setSzCdStagePersRole2(java.lang.String) 

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
     * Sets the value of field 'tsLastUpdate'.
     * 
     * @param tsLastUpdate the value of field 'tsLastUpdate'.
     */
    public void setTsLastUpdate(java.util.Date tsLastUpdate)
    {
        this._tsLastUpdate = tsLastUpdate;
    } //-- void setTsLastUpdate(java.util.Date) 

    /**
     * Sets the value of field 'tsSysTsLastUpdate3'.
     * 
     * @param tsSysTsLastUpdate3 the value of field
     * 'tsSysTsLastUpdate3'.
     */
    public void setTsSysTsLastUpdate3(java.util.Date tsSysTsLastUpdate3)
    {
        this._tsSysTsLastUpdate3 = tsSysTsLastUpdate3;
    } //-- void setTsSysTsLastUpdate3(java.util.Date) 

    /**
     * Sets the value of field 'tsSysTsLastUpdate4'.
     * 
     * @param tsSysTsLastUpdate4 the value of field
     * 'tsSysTsLastUpdate4'.
     */
    public void setTsSysTsLastUpdate4(java.util.Date tsSysTsLastUpdate4)
    {
        this._tsSysTsLastUpdate4 = tsSysTsLastUpdate4;
    } //-- void setTsSysTsLastUpdate4(java.util.Date) 

    /**
     * Sets the value of field 'ulIdAllegation'.
     * 
     * @param ulIdAllegation the value of field 'ulIdAllegation'.
     */
    public void setUlIdAllegation(int ulIdAllegation)
    {
        this._ulIdAllegation = ulIdAllegation;
        this._has_ulIdAllegation = true;
    } //-- void setUlIdAllegation(int) 

    /**
     * Sets the value of field 'ulIdAllegedPerpetrator'.
     * 
     * @param ulIdAllegedPerpetrator the value of field
     * 'ulIdAllegedPerpetrator'.
     */
    public void setUlIdAllegedPerpetrator(int ulIdAllegedPerpetrator)
    {
        this._ulIdAllegedPerpetrator = ulIdAllegedPerpetrator;
        this._has_ulIdAllegedPerpetrator = true;
    } //-- void setUlIdAllegedPerpetrator(int) 

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
     * Sets the value of field 'ulIdVictim'.
     * 
     * @param ulIdVictim the value of field 'ulIdVictim'.
     */
    public void setUlIdVictim(int ulIdVictim)
    {
        this._ulIdVictim = ulIdVictim;
        this._has_ulIdVictim = true;
    } //-- void setUlIdVictim(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINV47SIG
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CINV47SIG unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV47SIG) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV47SIG.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV47SIG unmarshal(java.io.Reader) 

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
