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
 * Class ROWCCFC26SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCFC26SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ulIdRecCheck
     */
    private int _ulIdRecCheck;

    /**
     * keeps track of state for field: _ulIdRecCheck
     */
    private boolean _has_ulIdRecCheck;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ulIdRecCheckRequestor
     */
    private int _ulIdRecCheckRequestor;

    /**
     * keeps track of state for field: _ulIdRecCheckRequestor
     */
    private boolean _has_ulIdRecCheckRequestor;

    /**
     * Field _szCdRecCheckCheckType
     */
    private java.lang.String _szCdRecCheckCheckType;

    /**
     * Field _szCdRecCheckEmpType
     */
    private java.lang.String _szCdRecCheckEmpType;

    /**
     * Field _szCdRecCheckStatus
     */
    private java.lang.String _szCdRecCheckStatus;

    /**
     * Field _szTxtRecCheckComments
     */
    private java.lang.String _szTxtRecCheckComments;

    /**
     * Field _dtDtRecCheckCompleted
     */
    private org.exolab.castor.types.Date _dtDtRecCheckCompleted;

    /**
     * Field _dtDtRecCheckRequest
     */
    private org.exolab.castor.types.Date _dtDtRecCheckRequest;

    /**
     * Field _szScrNmRequestedBy
     */
    private java.lang.String _szScrNmRequestedBy;

    /**
     * Field _cIndRecCheckHistory
     */
    private java.lang.String _cIndRecCheckHistory;

    /**
     * Field _selDtCriminalReleaseReceived
     */
    private org.exolab.castor.types.Date _selDtCriminalReleaseReceived;

    /**
     * Field _cbFingerprintCard
     */
    private java.lang.String _cbFingerprintCard;

    /**
     * Field _cbLiveScan
     */
    private java.lang.String _cbLiveScan;

    /**
     * Field _selDtFingerprintCardGiven
     */
    private org.exolab.castor.types.Date _selDtFingerprintCardGiven;

    /**
     * Field _selDtFingerprintCardReturn
     */
    private org.exolab.castor.types.Date _selDtFingerprintCardReturn;

    /**
     * Field _selDtLiveScanPerformed
     */
    private org.exolab.castor.types.Date _selDtLiveScanPerformed;

    /**
     * Field _selDtLiveScanResultReceived
     */
    private org.exolab.castor.types.Date _selDtLiveScanResultReceived;

    /**
     * Field _rbRefuseSignInvestigationClearance
     */
    private java.lang.String _rbRefuseSignInvestigationClearance;

    /**
     * Field _rbFingerPrintCkResult
     */
    private java.lang.String _rbFingerPrintCkResult;

    /**
     * Field _rbRecommendation
     */
    private java.lang.String _rbRecommendation;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCFC26SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdRecCheck()
    {
        this._has_ulIdRecCheck= false;
    } //-- void deleteUlIdRecCheck() 

    /**
     */
    public void deleteUlIdRecCheckRequestor()
    {
        this._has_ulIdRecCheckRequestor= false;
    } //-- void deleteUlIdRecCheckRequestor() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     * Returns the value of field 'cIndRecCheckHistory'.
     * 
     * @return the value of field 'CIndRecCheckHistory'.
     */
    public java.lang.String getCIndRecCheckHistory()
    {
        return this._cIndRecCheckHistory;
    } //-- java.lang.String getCIndRecCheckHistory() 

    /**
     * Returns the value of field 'cbFingerprintCard'.
     * 
     * @return the value of field 'CbFingerprintCard'.
     */
    public java.lang.String getCbFingerprintCard()
    {
        return this._cbFingerprintCard;
    } //-- java.lang.String getCbFingerprintCard() 

    /**
     * Returns the value of field 'cbLiveScan'.
     * 
     * @return the value of field 'CbLiveScan'.
     */
    public java.lang.String getCbLiveScan()
    {
        return this._cbLiveScan;
    } //-- java.lang.String getCbLiveScan() 

    /**
     * Returns the value of field 'dtDtRecCheckCompleted'.
     * 
     * @return the value of field 'DtDtRecCheckCompleted'.
     */
    public org.exolab.castor.types.Date getDtDtRecCheckCompleted()
    {
        return this._dtDtRecCheckCompleted;
    } //-- org.exolab.castor.types.Date getDtDtRecCheckCompleted() 

    /**
     * Returns the value of field 'dtDtRecCheckRequest'.
     * 
     * @return the value of field 'DtDtRecCheckRequest'.
     */
    public org.exolab.castor.types.Date getDtDtRecCheckRequest()
    {
        return this._dtDtRecCheckRequest;
    } //-- org.exolab.castor.types.Date getDtDtRecCheckRequest() 

    /**
     * Returns the value of field 'rbFingerPrintCkResult'.
     * 
     * @return the value of field 'RbFingerPrintCkResult'.
     */
    public java.lang.String getRbFingerPrintCkResult()
    {
        return this._rbFingerPrintCkResult;
    } //-- java.lang.String getRbFingerPrintCkResult() 

    /**
     * Returns the value of field 'rbRecommendation'.
     * 
     * @return the value of field 'RbRecommendation'.
     */
    public java.lang.String getRbRecommendation()
    {
        return this._rbRecommendation;
    } //-- java.lang.String getRbRecommendation() 

    /**
     * Returns the value of field
     * 'rbRefuseSignInvestigationClearance'.
     * 
     * @return the value of field
     * 'RbRefuseSignInvestigationClearance'.
     */
    public java.lang.String getRbRefuseSignInvestigationClearance()
    {
        return this._rbRefuseSignInvestigationClearance;
    } //-- java.lang.String getRbRefuseSignInvestigationClearance() 

    /**
     * Returns the value of field 'selDtCriminalReleaseReceived'.
     * 
     * @return the value of field 'SelDtCriminalReleaseReceived'.
     */
    public org.exolab.castor.types.Date getSelDtCriminalReleaseReceived()
    {
        return this._selDtCriminalReleaseReceived;
    } //-- org.exolab.castor.types.Date getSelDtCriminalReleaseReceived() 

    /**
     * Returns the value of field 'selDtFingerprintCardGiven'.
     * 
     * @return the value of field 'SelDtFingerprintCardGiven'.
     */
    public org.exolab.castor.types.Date getSelDtFingerprintCardGiven()
    {
        return this._selDtFingerprintCardGiven;
    } //-- org.exolab.castor.types.Date getSelDtFingerprintCardGiven() 

    /**
     * Returns the value of field 'selDtFingerprintCardReturn'.
     * 
     * @return the value of field 'SelDtFingerprintCardReturn'.
     */
    public org.exolab.castor.types.Date getSelDtFingerprintCardReturn()
    {
        return this._selDtFingerprintCardReturn;
    } //-- org.exolab.castor.types.Date getSelDtFingerprintCardReturn() 

    /**
     * Returns the value of field 'selDtLiveScanPerformed'.
     * 
     * @return the value of field 'SelDtLiveScanPerformed'.
     */
    public org.exolab.castor.types.Date getSelDtLiveScanPerformed()
    {
        return this._selDtLiveScanPerformed;
    } //-- org.exolab.castor.types.Date getSelDtLiveScanPerformed() 

    /**
     * Returns the value of field 'selDtLiveScanResultReceived'.
     * 
     * @return the value of field 'SelDtLiveScanResultReceived'.
     */
    public org.exolab.castor.types.Date getSelDtLiveScanResultReceived()
    {
        return this._selDtLiveScanResultReceived;
    } //-- org.exolab.castor.types.Date getSelDtLiveScanResultReceived() 

    /**
     * Returns the value of field 'szCdRecCheckCheckType'.
     * 
     * @return the value of field 'SzCdRecCheckCheckType'.
     */
    public java.lang.String getSzCdRecCheckCheckType()
    {
        return this._szCdRecCheckCheckType;
    } //-- java.lang.String getSzCdRecCheckCheckType() 

    /**
     * Returns the value of field 'szCdRecCheckEmpType'.
     * 
     * @return the value of field 'SzCdRecCheckEmpType'.
     */
    public java.lang.String getSzCdRecCheckEmpType()
    {
        return this._szCdRecCheckEmpType;
    } //-- java.lang.String getSzCdRecCheckEmpType() 

    /**
     * Returns the value of field 'szCdRecCheckStatus'.
     * 
     * @return the value of field 'SzCdRecCheckStatus'.
     */
    public java.lang.String getSzCdRecCheckStatus()
    {
        return this._szCdRecCheckStatus;
    } //-- java.lang.String getSzCdRecCheckStatus() 

    /**
     * Returns the value of field 'szScrNmRequestedBy'.
     * 
     * @return the value of field 'SzScrNmRequestedBy'.
     */
    public java.lang.String getSzScrNmRequestedBy()
    {
        return this._szScrNmRequestedBy;
    } //-- java.lang.String getSzScrNmRequestedBy() 

    /**
     * Returns the value of field 'szTxtRecCheckComments'.
     * 
     * @return the value of field 'SzTxtRecCheckComments'.
     */
    public java.lang.String getSzTxtRecCheckComments()
    {
        return this._szTxtRecCheckComments;
    } //-- java.lang.String getSzTxtRecCheckComments() 

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
     * Returns the value of field 'ulIdRecCheck'.
     * 
     * @return the value of field 'UlIdRecCheck'.
     */
    public int getUlIdRecCheck()
    {
        return this._ulIdRecCheck;
    } //-- int getUlIdRecCheck() 

    /**
     * Returns the value of field 'ulIdRecCheckRequestor'.
     * 
     * @return the value of field 'UlIdRecCheckRequestor'.
     */
    public int getUlIdRecCheckRequestor()
    {
        return this._ulIdRecCheckRequestor;
    } //-- int getUlIdRecCheckRequestor() 

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
     * Method hasUlIdRecCheck
     * 
     * 
     * 
     * @return true if at least one UlIdRecCheck has been added
     */
    public boolean hasUlIdRecCheck()
    {
        return this._has_ulIdRecCheck;
    } //-- boolean hasUlIdRecCheck() 

    /**
     * Method hasUlIdRecCheckRequestor
     * 
     * 
     * 
     * @return true if at least one UlIdRecCheckRequestor has been
     * added
     */
    public boolean hasUlIdRecCheckRequestor()
    {
        return this._has_ulIdRecCheckRequestor;
    } //-- boolean hasUlIdRecCheckRequestor() 

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
     * Sets the value of field 'cIndRecCheckHistory'.
     * 
     * @param cIndRecCheckHistory the value of field
     * 'cIndRecCheckHistory'.
     */
    public void setCIndRecCheckHistory(java.lang.String cIndRecCheckHistory)
    {
        this._cIndRecCheckHistory = cIndRecCheckHistory;
    } //-- void setCIndRecCheckHistory(java.lang.String) 

    /**
     * Sets the value of field 'cbFingerprintCard'.
     * 
     * @param cbFingerprintCard the value of field
     * 'cbFingerprintCard'.
     */
    public void setCbFingerprintCard(java.lang.String cbFingerprintCard)
    {
        this._cbFingerprintCard = cbFingerprintCard;
    } //-- void setCbFingerprintCard(java.lang.String) 

    /**
     * Sets the value of field 'cbLiveScan'.
     * 
     * @param cbLiveScan the value of field 'cbLiveScan'.
     */
    public void setCbLiveScan(java.lang.String cbLiveScan)
    {
        this._cbLiveScan = cbLiveScan;
    } //-- void setCbLiveScan(java.lang.String) 

    /**
     * Sets the value of field 'dtDtRecCheckCompleted'.
     * 
     * @param dtDtRecCheckCompleted the value of field
     * 'dtDtRecCheckCompleted'.
     */
    public void setDtDtRecCheckCompleted(org.exolab.castor.types.Date dtDtRecCheckCompleted)
    {
        this._dtDtRecCheckCompleted = dtDtRecCheckCompleted;
    } //-- void setDtDtRecCheckCompleted(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRecCheckRequest'.
     * 
     * @param dtDtRecCheckRequest the value of field
     * 'dtDtRecCheckRequest'.
     */
    public void setDtDtRecCheckRequest(org.exolab.castor.types.Date dtDtRecCheckRequest)
    {
        this._dtDtRecCheckRequest = dtDtRecCheckRequest;
    } //-- void setDtDtRecCheckRequest(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'rbFingerPrintCkResult'.
     * 
     * @param rbFingerPrintCkResult the value of field
     * 'rbFingerPrintCkResult'.
     */
    public void setRbFingerPrintCkResult(java.lang.String rbFingerPrintCkResult)
    {
        this._rbFingerPrintCkResult = rbFingerPrintCkResult;
    } //-- void setRbFingerPrintCkResult(java.lang.String) 

    /**
     * Sets the value of field 'rbRecommendation'.
     * 
     * @param rbRecommendation the value of field 'rbRecommendation'
     */
    public void setRbRecommendation(java.lang.String rbRecommendation)
    {
        this._rbRecommendation = rbRecommendation;
    } //-- void setRbRecommendation(java.lang.String) 

    /**
     * Sets the value of field
     * 'rbRefuseSignInvestigationClearance'.
     * 
     * @param rbRefuseSignInvestigationClearance the value of field
     * 'rbRefuseSignInvestigationClearance'.
     */
    public void setRbRefuseSignInvestigationClearance(java.lang.String rbRefuseSignInvestigationClearance)
    {
        this._rbRefuseSignInvestigationClearance = rbRefuseSignInvestigationClearance;
    } //-- void setRbRefuseSignInvestigationClearance(java.lang.String) 

    /**
     * Sets the value of field 'selDtCriminalReleaseReceived'.
     * 
     * @param selDtCriminalReleaseReceived the value of field
     * 'selDtCriminalReleaseReceived'.
     */
    public void setSelDtCriminalReleaseReceived(org.exolab.castor.types.Date selDtCriminalReleaseReceived)
    {
        this._selDtCriminalReleaseReceived = selDtCriminalReleaseReceived;
    } //-- void setSelDtCriminalReleaseReceived(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'selDtFingerprintCardGiven'.
     * 
     * @param selDtFingerprintCardGiven the value of field
     * 'selDtFingerprintCardGiven'.
     */
    public void setSelDtFingerprintCardGiven(org.exolab.castor.types.Date selDtFingerprintCardGiven)
    {
        this._selDtFingerprintCardGiven = selDtFingerprintCardGiven;
    } //-- void setSelDtFingerprintCardGiven(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'selDtFingerprintCardReturn'.
     * 
     * @param selDtFingerprintCardReturn the value of field
     * 'selDtFingerprintCardReturn'.
     */
    public void setSelDtFingerprintCardReturn(org.exolab.castor.types.Date selDtFingerprintCardReturn)
    {
        this._selDtFingerprintCardReturn = selDtFingerprintCardReturn;
    } //-- void setSelDtFingerprintCardReturn(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'selDtLiveScanPerformed'.
     * 
     * @param selDtLiveScanPerformed the value of field
     * 'selDtLiveScanPerformed'.
     */
    public void setSelDtLiveScanPerformed(org.exolab.castor.types.Date selDtLiveScanPerformed)
    {
        this._selDtLiveScanPerformed = selDtLiveScanPerformed;
    } //-- void setSelDtLiveScanPerformed(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'selDtLiveScanResultReceived'.
     * 
     * @param selDtLiveScanResultReceived the value of field
     * 'selDtLiveScanResultReceived'.
     */
    public void setSelDtLiveScanResultReceived(org.exolab.castor.types.Date selDtLiveScanResultReceived)
    {
        this._selDtLiveScanResultReceived = selDtLiveScanResultReceived;
    } //-- void setSelDtLiveScanResultReceived(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdRecCheckCheckType'.
     * 
     * @param szCdRecCheckCheckType the value of field
     * 'szCdRecCheckCheckType'.
     */
    public void setSzCdRecCheckCheckType(java.lang.String szCdRecCheckCheckType)
    {
        this._szCdRecCheckCheckType = szCdRecCheckCheckType;
    } //-- void setSzCdRecCheckCheckType(java.lang.String) 

    /**
     * Sets the value of field 'szCdRecCheckEmpType'.
     * 
     * @param szCdRecCheckEmpType the value of field
     * 'szCdRecCheckEmpType'.
     */
    public void setSzCdRecCheckEmpType(java.lang.String szCdRecCheckEmpType)
    {
        this._szCdRecCheckEmpType = szCdRecCheckEmpType;
    } //-- void setSzCdRecCheckEmpType(java.lang.String) 

    /**
     * Sets the value of field 'szCdRecCheckStatus'.
     * 
     * @param szCdRecCheckStatus the value of field
     * 'szCdRecCheckStatus'.
     */
    public void setSzCdRecCheckStatus(java.lang.String szCdRecCheckStatus)
    {
        this._szCdRecCheckStatus = szCdRecCheckStatus;
    } //-- void setSzCdRecCheckStatus(java.lang.String) 

    /**
     * Sets the value of field 'szScrNmRequestedBy'.
     * 
     * @param szScrNmRequestedBy the value of field
     * 'szScrNmRequestedBy'.
     */
    public void setSzScrNmRequestedBy(java.lang.String szScrNmRequestedBy)
    {
        this._szScrNmRequestedBy = szScrNmRequestedBy;
    } //-- void setSzScrNmRequestedBy(java.lang.String) 

    /**
     * Sets the value of field 'szTxtRecCheckComments'.
     * 
     * @param szTxtRecCheckComments the value of field
     * 'szTxtRecCheckComments'.
     */
    public void setSzTxtRecCheckComments(java.lang.String szTxtRecCheckComments)
    {
        this._szTxtRecCheckComments = szTxtRecCheckComments;
    } //-- void setSzTxtRecCheckComments(java.lang.String) 

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
     * Sets the value of field 'ulIdRecCheck'.
     * 
     * @param ulIdRecCheck the value of field 'ulIdRecCheck'.
     */
    public void setUlIdRecCheck(int ulIdRecCheck)
    {
        this._ulIdRecCheck = ulIdRecCheck;
        this._has_ulIdRecCheck = true;
    } //-- void setUlIdRecCheck(int) 

    /**
     * Sets the value of field 'ulIdRecCheckRequestor'.
     * 
     * @param ulIdRecCheckRequestor the value of field
     * 'ulIdRecCheckRequestor'.
     */
    public void setUlIdRecCheckRequestor(int ulIdRecCheckRequestor)
    {
        this._ulIdRecCheckRequestor = ulIdRecCheckRequestor;
        this._has_ulIdRecCheckRequestor = true;
    } //-- void setUlIdRecCheckRequestor(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00 unmarshal(java.io.Reader) 

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
