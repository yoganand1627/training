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
 * Class CallDcsnAUD.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CallDcsnAUD extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdStageClassification
     */
    private java.lang.String _szCdStageClassification;

    /**
     * Field _szCdIncmgAllegType
     */
    private java.lang.String _szCdIncmgAllegType;

    /**
     * Field _szCdIncmgSpecHandling
     */
    private java.lang.String _szCdIncmgSpecHandling;

    /**
     * Field _bIndIncmgSensitive
     */
    private java.lang.String _bIndIncmgSensitive;

    /**
     * Field _bIndMRLetter
     */
    private java.lang.String _bIndMRLetter;

    /**
     * Field _bIndIncmgWorkerSafety
     */
    private java.lang.String _bIndIncmgWorkerSafety;

    /**
     * Field _bIndIncmgSuspMeth
     */
    private java.lang.String _bIndIncmgSuspMeth;

    /**
     * Field _txtIncmgWorkerSafety
     */
    private java.lang.String _txtIncmgWorkerSafety;

    /**
     * Field _txtIncomgSensitive
     */
    private java.lang.String _txtIncomgSensitive;

    /**
     * Field _txtIncomgSuspMeth
     */
    private java.lang.String _txtIncomgSuspMeth;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szCdStageReasonClosed
     */
    private java.lang.String _szCdStageReasonClosed;

    /**
     * Field _szCdAllegType
     */
    private java.lang.String _szCdAllegType;

    /**
     * Field _bIndIncmgNoFactor
     */
    private java.lang.String _bIndIncmgNoFactor;

    /**
     * Field _szCdStageInitialPriority
     */
    private java.lang.String _szCdStageInitialPriority;

    /**
     * Field _szCdStageCurrPriority
     */
    private java.lang.String _szCdStageCurrPriority;

    /**
     * Field _szCdStageRsnPriorityChgd
     */
    private java.lang.String _szCdStageRsnPriorityChgd;

    /**
     * Field _szNmStage
     */
    private java.lang.String _szNmStage;

    /**
     * Field _szTxtStagePriorityCmnts
     */
    private java.lang.String _szTxtStagePriorityCmnts;

    /**
     * Field _ulIdUnit
     */
    private int _ulIdUnit;

    /**
     * keeps track of state for field: _ulIdUnit
     */
    private boolean _has_ulIdUnit;

    /**
     * Field _szNmJurisdiction
     */
    private java.lang.String _szNmJurisdiction;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _cIndIncmgLawEnfInvol
     */
    private java.lang.String _cIndIncmgLawEnfInvol;

    /**
     * Field _szCdIncomingDisposition
     */
    private java.lang.String _szCdIncomingDisposition;

    /**
     * Field _szCdStageScroutReason
     */
    private java.lang.String _szCdStageScroutReason;

    /**
     * Field _szTxtStageSplInstrtCmnt
     */
    private java.lang.String _szTxtStageSplInstrtCmnt;

    /**
     * Field _ulIdRefferedResource
     */
    private int _ulIdRefferedResource;

    /**
     * keeps track of state for field: _ulIdRefferedResource
     */
    private boolean _has_ulIdRefferedResource;

    /**
     * Field _szCdServiceProviderName
     */
    private java.lang.String _szCdServiceProviderName;

    /**
     * Field _cIndPolicyViolation
     */
    private java.lang.String _cIndPolicyViolation;


      //----------------/
     //- Constructors -/
    //----------------/

    public CallDcsnAUD() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUD()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdRefferedResource()
    {
        this._has_ulIdRefferedResource= false;
    } //-- void deleteUlIdRefferedResource() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     */
    public void deleteUlIdUnit()
    {
        this._has_ulIdUnit= false;
    } //-- void deleteUlIdUnit() 

    /**
     * Returns the value of field 'bIndIncmgNoFactor'.
     * 
     * @return the value of field 'BIndIncmgNoFactor'.
     */
    public java.lang.String getBIndIncmgNoFactor()
    {
        return this._bIndIncmgNoFactor;
    } //-- java.lang.String getBIndIncmgNoFactor() 

    /**
     * Returns the value of field 'bIndIncmgSensitive'.
     * 
     * @return the value of field 'BIndIncmgSensitive'.
     */
    public java.lang.String getBIndIncmgSensitive()
    {
        return this._bIndIncmgSensitive;
    } //-- java.lang.String getBIndIncmgSensitive() 

    /**
     * Returns the value of field 'bIndIncmgSuspMeth'.
     * 
     * @return the value of field 'BIndIncmgSuspMeth'.
     */
    public java.lang.String getBIndIncmgSuspMeth()
    {
        return this._bIndIncmgSuspMeth;
    } //-- java.lang.String getBIndIncmgSuspMeth() 

    /**
     * Returns the value of field 'bIndIncmgWorkerSafety'.
     * 
     * @return the value of field 'BIndIncmgWorkerSafety'.
     */
    public java.lang.String getBIndIncmgWorkerSafety()
    {
        return this._bIndIncmgWorkerSafety;
    } //-- java.lang.String getBIndIncmgWorkerSafety() 

    /**
     * Returns the value of field 'bIndMRLetter'.
     * 
     * @return the value of field 'BIndMRLetter'.
     */
    public java.lang.String getBIndMRLetter()
    {
        return this._bIndMRLetter;
    } //-- java.lang.String getBIndMRLetter() 

    /**
     * Returns the value of field 'cIndIncmgLawEnfInvol'.
     * 
     * @return the value of field 'CIndIncmgLawEnfInvol'.
     */
    public java.lang.String getCIndIncmgLawEnfInvol()
    {
        return this._cIndIncmgLawEnfInvol;
    } //-- java.lang.String getCIndIncmgLawEnfInvol() 

    /**
     * Returns the value of field 'cIndPolicyViolation'.
     * 
     * @return the value of field 'CIndPolicyViolation'.
     */
    public java.lang.String getCIndPolicyViolation()
    {
        return this._cIndPolicyViolation;
    } //-- java.lang.String getCIndPolicyViolation() 

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
     * Returns the value of field 'szCdIncmgAllegType'.
     * 
     * @return the value of field 'SzCdIncmgAllegType'.
     */
    public java.lang.String getSzCdIncmgAllegType()
    {
        return this._szCdIncmgAllegType;
    } //-- java.lang.String getSzCdIncmgAllegType() 

    /**
     * Returns the value of field 'szCdIncmgSpecHandling'.
     * 
     * @return the value of field 'SzCdIncmgSpecHandling'.
     */
    public java.lang.String getSzCdIncmgSpecHandling()
    {
        return this._szCdIncmgSpecHandling;
    } //-- java.lang.String getSzCdIncmgSpecHandling() 

    /**
     * Returns the value of field 'szCdIncomingDisposition'.
     * 
     * @return the value of field 'SzCdIncomingDisposition'.
     */
    public java.lang.String getSzCdIncomingDisposition()
    {
        return this._szCdIncomingDisposition;
    } //-- java.lang.String getSzCdIncomingDisposition() 

    /**
     * Returns the value of field 'szCdServiceProviderName'.
     * 
     * @return the value of field 'SzCdServiceProviderName'.
     */
    public java.lang.String getSzCdServiceProviderName()
    {
        return this._szCdServiceProviderName;
    } //-- java.lang.String getSzCdServiceProviderName() 

    /**
     * Returns the value of field 'szCdStageClassification'.
     * 
     * @return the value of field 'SzCdStageClassification'.
     */
    public java.lang.String getSzCdStageClassification()
    {
        return this._szCdStageClassification;
    } //-- java.lang.String getSzCdStageClassification() 

    /**
     * Returns the value of field 'szCdStageCurrPriority'.
     * 
     * @return the value of field 'SzCdStageCurrPriority'.
     */
    public java.lang.String getSzCdStageCurrPriority()
    {
        return this._szCdStageCurrPriority;
    } //-- java.lang.String getSzCdStageCurrPriority() 

    /**
     * Returns the value of field 'szCdStageInitialPriority'.
     * 
     * @return the value of field 'SzCdStageInitialPriority'.
     */
    public java.lang.String getSzCdStageInitialPriority()
    {
        return this._szCdStageInitialPriority;
    } //-- java.lang.String getSzCdStageInitialPriority() 

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
     * Returns the value of field 'szCdStageRsnPriorityChgd'.
     * 
     * @return the value of field 'SzCdStageRsnPriorityChgd'.
     */
    public java.lang.String getSzCdStageRsnPriorityChgd()
    {
        return this._szCdStageRsnPriorityChgd;
    } //-- java.lang.String getSzCdStageRsnPriorityChgd() 

    /**
     * Returns the value of field 'szCdStageScroutReason'.
     * 
     * @return the value of field 'SzCdStageScroutReason'.
     */
    public java.lang.String getSzCdStageScroutReason()
    {
        return this._szCdStageScroutReason;
    } //-- java.lang.String getSzCdStageScroutReason() 

    /**
     * Returns the value of field 'szNmJurisdiction'.
     * 
     * @return the value of field 'SzNmJurisdiction'.
     */
    public java.lang.String getSzNmJurisdiction()
    {
        return this._szNmJurisdiction;
    } //-- java.lang.String getSzNmJurisdiction() 

    /**
     * Returns the value of field 'szNmStage'.
     * 
     * @return the value of field 'SzNmStage'.
     */
    public java.lang.String getSzNmStage()
    {
        return this._szNmStage;
    } //-- java.lang.String getSzNmStage() 

    /**
     * Returns the value of field 'szTxtStagePriorityCmnts'.
     * 
     * @return the value of field 'SzTxtStagePriorityCmnts'.
     */
    public java.lang.String getSzTxtStagePriorityCmnts()
    {
        return this._szTxtStagePriorityCmnts;
    } //-- java.lang.String getSzTxtStagePriorityCmnts() 

    /**
     * Returns the value of field 'szTxtStageSplInstrtCmnt'.
     * 
     * @return the value of field 'SzTxtStageSplInstrtCmnt'.
     */
    public java.lang.String getSzTxtStageSplInstrtCmnt()
    {
        return this._szTxtStageSplInstrtCmnt;
    } //-- java.lang.String getSzTxtStageSplInstrtCmnt() 

    /**
     * Returns the value of field 'txtIncmgWorkerSafety'.
     * 
     * @return the value of field 'TxtIncmgWorkerSafety'.
     */
    public java.lang.String getTxtIncmgWorkerSafety()
    {
        return this._txtIncmgWorkerSafety;
    } //-- java.lang.String getTxtIncmgWorkerSafety() 

    /**
     * Returns the value of field 'txtIncomgSensitive'.
     * 
     * @return the value of field 'TxtIncomgSensitive'.
     */
    public java.lang.String getTxtIncomgSensitive()
    {
        return this._txtIncomgSensitive;
    } //-- java.lang.String getTxtIncomgSensitive() 

    /**
     * Returns the value of field 'txtIncomgSuspMeth'.
     * 
     * @return the value of field 'TxtIncomgSuspMeth'.
     */
    public java.lang.String getTxtIncomgSuspMeth()
    {
        return this._txtIncomgSuspMeth;
    } //-- java.lang.String getTxtIncomgSuspMeth() 

    /**
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Returns the value of field 'ulIdRefferedResource'.
     * 
     * @return the value of field 'UlIdRefferedResource'.
     */
    public int getUlIdRefferedResource()
    {
        return this._ulIdRefferedResource;
    } //-- int getUlIdRefferedResource() 

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
     * Returns the value of field 'ulIdUnit'.
     * 
     * @return the value of field 'UlIdUnit'.
     */
    public int getUlIdUnit()
    {
        return this._ulIdUnit;
    } //-- int getUlIdUnit() 

    /**
     * Method hasUlIdPerson
     * 
     * 
     * 
     * @return true if at least one UlIdPerson has been added
     */
    public boolean hasUlIdPerson()
    {
        return this._has_ulIdPerson;
    } //-- boolean hasUlIdPerson() 

    /**
     * Method hasUlIdRefferedResource
     * 
     * 
     * 
     * @return true if at least one UlIdRefferedResource has been
     * added
     */
    public boolean hasUlIdRefferedResource()
    {
        return this._has_ulIdRefferedResource;
    } //-- boolean hasUlIdRefferedResource() 

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
     * Method hasUlIdUnit
     * 
     * 
     * 
     * @return true if at least one UlIdUnit has been added
     */
    public boolean hasUlIdUnit()
    {
        return this._has_ulIdUnit;
    } //-- boolean hasUlIdUnit() 

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
     * Sets the value of field 'bIndIncmgNoFactor'.
     * 
     * @param bIndIncmgNoFactor the value of field
     * 'bIndIncmgNoFactor'.
     */
    public void setBIndIncmgNoFactor(java.lang.String bIndIncmgNoFactor)
    {
        this._bIndIncmgNoFactor = bIndIncmgNoFactor;
    } //-- void setBIndIncmgNoFactor(java.lang.String) 

    /**
     * Sets the value of field 'bIndIncmgSensitive'.
     * 
     * @param bIndIncmgSensitive the value of field
     * 'bIndIncmgSensitive'.
     */
    public void setBIndIncmgSensitive(java.lang.String bIndIncmgSensitive)
    {
        this._bIndIncmgSensitive = bIndIncmgSensitive;
    } //-- void setBIndIncmgSensitive(java.lang.String) 

    /**
     * Sets the value of field 'bIndIncmgSuspMeth'.
     * 
     * @param bIndIncmgSuspMeth the value of field
     * 'bIndIncmgSuspMeth'.
     */
    public void setBIndIncmgSuspMeth(java.lang.String bIndIncmgSuspMeth)
    {
        this._bIndIncmgSuspMeth = bIndIncmgSuspMeth;
    } //-- void setBIndIncmgSuspMeth(java.lang.String) 

    /**
     * Sets the value of field 'bIndIncmgWorkerSafety'.
     * 
     * @param bIndIncmgWorkerSafety the value of field
     * 'bIndIncmgWorkerSafety'.
     */
    public void setBIndIncmgWorkerSafety(java.lang.String bIndIncmgWorkerSafety)
    {
        this._bIndIncmgWorkerSafety = bIndIncmgWorkerSafety;
    } //-- void setBIndIncmgWorkerSafety(java.lang.String) 

    /**
     * Sets the value of field 'bIndMRLetter'.
     * 
     * @param bIndMRLetter the value of field 'bIndMRLetter'.
     */
    public void setBIndMRLetter(java.lang.String bIndMRLetter)
    {
        this._bIndMRLetter = bIndMRLetter;
    } //-- void setBIndMRLetter(java.lang.String) 

    /**
     * Sets the value of field 'cIndIncmgLawEnfInvol'.
     * 
     * @param cIndIncmgLawEnfInvol the value of field
     * 'cIndIncmgLawEnfInvol'.
     */
    public void setCIndIncmgLawEnfInvol(java.lang.String cIndIncmgLawEnfInvol)
    {
        this._cIndIncmgLawEnfInvol = cIndIncmgLawEnfInvol;
    } //-- void setCIndIncmgLawEnfInvol(java.lang.String) 

    /**
     * Sets the value of field 'cIndPolicyViolation'.
     * 
     * @param cIndPolicyViolation the value of field
     * 'cIndPolicyViolation'.
     */
    public void setCIndPolicyViolation(java.lang.String cIndPolicyViolation)
    {
        this._cIndPolicyViolation = cIndPolicyViolation;
    } //-- void setCIndPolicyViolation(java.lang.String) 

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
     * Sets the value of field 'szCdIncmgAllegType'.
     * 
     * @param szCdIncmgAllegType the value of field
     * 'szCdIncmgAllegType'.
     */
    public void setSzCdIncmgAllegType(java.lang.String szCdIncmgAllegType)
    {
        this._szCdIncmgAllegType = szCdIncmgAllegType;
    } //-- void setSzCdIncmgAllegType(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgSpecHandling'.
     * 
     * @param szCdIncmgSpecHandling the value of field
     * 'szCdIncmgSpecHandling'.
     */
    public void setSzCdIncmgSpecHandling(java.lang.String szCdIncmgSpecHandling)
    {
        this._szCdIncmgSpecHandling = szCdIncmgSpecHandling;
    } //-- void setSzCdIncmgSpecHandling(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncomingDisposition'.
     * 
     * @param szCdIncomingDisposition the value of field
     * 'szCdIncomingDisposition'.
     */
    public void setSzCdIncomingDisposition(java.lang.String szCdIncomingDisposition)
    {
        this._szCdIncomingDisposition = szCdIncomingDisposition;
    } //-- void setSzCdIncomingDisposition(java.lang.String) 

    /**
     * Sets the value of field 'szCdServiceProviderName'.
     * 
     * @param szCdServiceProviderName the value of field
     * 'szCdServiceProviderName'.
     */
    public void setSzCdServiceProviderName(java.lang.String szCdServiceProviderName)
    {
        this._szCdServiceProviderName = szCdServiceProviderName;
    } //-- void setSzCdServiceProviderName(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageClassification'.
     * 
     * @param szCdStageClassification the value of field
     * 'szCdStageClassification'.
     */
    public void setSzCdStageClassification(java.lang.String szCdStageClassification)
    {
        this._szCdStageClassification = szCdStageClassification;
    } //-- void setSzCdStageClassification(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageCurrPriority'.
     * 
     * @param szCdStageCurrPriority the value of field
     * 'szCdStageCurrPriority'.
     */
    public void setSzCdStageCurrPriority(java.lang.String szCdStageCurrPriority)
    {
        this._szCdStageCurrPriority = szCdStageCurrPriority;
    } //-- void setSzCdStageCurrPriority(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageInitialPriority'.
     * 
     * @param szCdStageInitialPriority the value of field
     * 'szCdStageInitialPriority'.
     */
    public void setSzCdStageInitialPriority(java.lang.String szCdStageInitialPriority)
    {
        this._szCdStageInitialPriority = szCdStageInitialPriority;
    } //-- void setSzCdStageInitialPriority(java.lang.String) 

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
     * Sets the value of field 'szCdStageRsnPriorityChgd'.
     * 
     * @param szCdStageRsnPriorityChgd the value of field
     * 'szCdStageRsnPriorityChgd'.
     */
    public void setSzCdStageRsnPriorityChgd(java.lang.String szCdStageRsnPriorityChgd)
    {
        this._szCdStageRsnPriorityChgd = szCdStageRsnPriorityChgd;
    } //-- void setSzCdStageRsnPriorityChgd(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageScroutReason'.
     * 
     * @param szCdStageScroutReason the value of field
     * 'szCdStageScroutReason'.
     */
    public void setSzCdStageScroutReason(java.lang.String szCdStageScroutReason)
    {
        this._szCdStageScroutReason = szCdStageScroutReason;
    } //-- void setSzCdStageScroutReason(java.lang.String) 

    /**
     * Sets the value of field 'szNmJurisdiction'.
     * 
     * @param szNmJurisdiction the value of field 'szNmJurisdiction'
     */
    public void setSzNmJurisdiction(java.lang.String szNmJurisdiction)
    {
        this._szNmJurisdiction = szNmJurisdiction;
    } //-- void setSzNmJurisdiction(java.lang.String) 

    /**
     * Sets the value of field 'szNmStage'.
     * 
     * @param szNmStage the value of field 'szNmStage'.
     */
    public void setSzNmStage(java.lang.String szNmStage)
    {
        this._szNmStage = szNmStage;
    } //-- void setSzNmStage(java.lang.String) 

    /**
     * Sets the value of field 'szTxtStagePriorityCmnts'.
     * 
     * @param szTxtStagePriorityCmnts the value of field
     * 'szTxtStagePriorityCmnts'.
     */
    public void setSzTxtStagePriorityCmnts(java.lang.String szTxtStagePriorityCmnts)
    {
        this._szTxtStagePriorityCmnts = szTxtStagePriorityCmnts;
    } //-- void setSzTxtStagePriorityCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtStageSplInstrtCmnt'.
     * 
     * @param szTxtStageSplInstrtCmnt the value of field
     * 'szTxtStageSplInstrtCmnt'.
     */
    public void setSzTxtStageSplInstrtCmnt(java.lang.String szTxtStageSplInstrtCmnt)
    {
        this._szTxtStageSplInstrtCmnt = szTxtStageSplInstrtCmnt;
    } //-- void setSzTxtStageSplInstrtCmnt(java.lang.String) 

    /**
     * Sets the value of field 'txtIncmgWorkerSafety'.
     * 
     * @param txtIncmgWorkerSafety the value of field
     * 'txtIncmgWorkerSafety'.
     */
    public void setTxtIncmgWorkerSafety(java.lang.String txtIncmgWorkerSafety)
    {
        this._txtIncmgWorkerSafety = txtIncmgWorkerSafety;
    } //-- void setTxtIncmgWorkerSafety(java.lang.String) 

    /**
     * Sets the value of field 'txtIncomgSensitive'.
     * 
     * @param txtIncomgSensitive the value of field
     * 'txtIncomgSensitive'.
     */
    public void setTxtIncomgSensitive(java.lang.String txtIncomgSensitive)
    {
        this._txtIncomgSensitive = txtIncomgSensitive;
    } //-- void setTxtIncomgSensitive(java.lang.String) 

    /**
     * Sets the value of field 'txtIncomgSuspMeth'.
     * 
     * @param txtIncomgSuspMeth the value of field
     * 'txtIncomgSuspMeth'.
     */
    public void setTxtIncomgSuspMeth(java.lang.String txtIncomgSuspMeth)
    {
        this._txtIncomgSuspMeth = txtIncomgSuspMeth;
    } //-- void setTxtIncomgSuspMeth(java.lang.String) 

    /**
     * Sets the value of field 'ulIdPerson'.
     * 
     * @param ulIdPerson the value of field 'ulIdPerson'.
     */
    public void setUlIdPerson(int ulIdPerson)
    {
        this._ulIdPerson = ulIdPerson;
        this._has_ulIdPerson = true;
    } //-- void setUlIdPerson(int) 

    /**
     * Sets the value of field 'ulIdRefferedResource'.
     * 
     * @param ulIdRefferedResource the value of field
     * 'ulIdRefferedResource'.
     */
    public void setUlIdRefferedResource(int ulIdRefferedResource)
    {
        this._ulIdRefferedResource = ulIdRefferedResource;
        this._has_ulIdRefferedResource = true;
    } //-- void setUlIdRefferedResource(int) 

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
     * Sets the value of field 'ulIdUnit'.
     * 
     * @param ulIdUnit the value of field 'ulIdUnit'.
     */
    public void setUlIdUnit(int ulIdUnit)
    {
        this._ulIdUnit = ulIdUnit;
        this._has_ulIdUnit = true;
    } //-- void setUlIdUnit(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUD
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUD unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUD) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUD.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUD unmarshal(java.io.Reader) 

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
