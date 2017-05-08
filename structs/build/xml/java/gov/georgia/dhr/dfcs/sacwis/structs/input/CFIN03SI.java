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
 * Class CFIN03SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFIN03SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dAmtInvoClaimedAmount
     */
    private double _dAmtInvoClaimedAmount;

    /**
     * keeps track of state for field: _dAmtInvoClaimedAmount
     */
    private boolean _has_dAmtInvoClaimedAmount;

    /**
     * Field _szCdInvoAdjustmentRb
     */
    private java.lang.String _szCdInvoAdjustmentRb;

    /**
     * Field _szCdInvoPhase
     */
    private java.lang.String _szCdInvoPhase;

    /**
     * Field _szCdInvoType
     */
    private java.lang.String _szCdInvoType;

    /**
     * Field _dtDtInvoReceivedDate
     */
    private org.exolab.castor.types.Date _dtDtInvoReceivedDate;

    /**
     * Field _dtDtInvoEntryCompleted
     */
    private org.exolab.castor.types.Date _dtDtInvoEntryCompleted;

    /**
     * Field _dtDtInvoEntryStarted
     */
    private org.exolab.castor.types.Date _dtDtInvoEntryStarted;

    /**
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _ulIdInvoInvoice
     */
    private int _ulIdInvoInvoice;

    /**
     * keeps track of state for field: _ulIdInvoInvoice
     */
    private boolean _has_ulIdInvoInvoice;

    /**
     * Field _cIndInvoReadyForValid
     */
    private java.lang.String _cIndInvoReadyForValid;

    /**
     * Field _uMoInvoMonth
     */
    private int _uMoInvoMonth;

    /**
     * keeps track of state for field: _uMoInvoMonth
     */
    private boolean _has_uMoInvoMonth;

    /**
     * Field _uYrInvoYear
     */
    private int _uYrInvoYear;

    /**
     * keeps track of state for field: _uYrInvoYear
     */
    private boolean _has_uYrInvoYear;

    /**
     * Field _szNbrInvoVid
     */
    private java.lang.String _szNbrInvoVid;

    /**
     * Field _szNbrInvProvider
     */
    private java.lang.String _szNbrInvProvider;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdCounty
     */
    private java.lang.String _szCdCounty;

    /**
     * Field _bIndEmergencyPayment
     */
    private boolean _bIndEmergencyPayment;

    /**
     * keeps track of state for field: _bIndEmergencyPayment
     */
    private boolean _has_bIndEmergencyPayment;

    /**
     * Field _dtDtInvoSubmitDate
     */
    private org.exolab.castor.types.Date _dtDtInvoSubmitDate;

    /**
     * Field _dtDtInvoWarrantDate
     */
    private org.exolab.castor.types.Date _dtDtInvoWarrantDate;

    /**
     * Field _szNbrInvoWarrant
     */
    private java.lang.String _szNbrInvoWarrant;

    /**
     * Field _szTxtInvoContact
     */
    private java.lang.String _szTxtInvoContact;

    /**
     * Field _dAmtInvoValidAmount
     */
    private double _dAmtInvoValidAmount;

    /**
     * keeps track of state for field: _dAmtInvoValidAmount
     */
    private boolean _has_dAmtInvoValidAmount;

    /**
     * Field _dAmtInvoWarrant
     */
    private double _dAmtInvoWarrant;

    /**
     * keeps track of state for field: _dAmtInvoWarrant
     */
    private boolean _has_dAmtInvoWarrant;

    /**
     * Field _szCdInvoApproved
     */
    private java.lang.String _szCdInvoApproved;

    /**
     * Field _dtDtInvoApprovalDate
     */
    private org.exolab.castor.types.Date _dtDtInvoApprovalDate;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szCdRegion
     */
    private java.lang.String _szCdRegion;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFIN03SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN03SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteBIndEmergencyPayment()
    {
        this._has_bIndEmergencyPayment= false;
    } //-- void deleteBIndEmergencyPayment() 

    /**
     */
    public void deleteDAmtInvoClaimedAmount()
    {
        this._has_dAmtInvoClaimedAmount= false;
    } //-- void deleteDAmtInvoClaimedAmount() 

    /**
     */
    public void deleteDAmtInvoValidAmount()
    {
        this._has_dAmtInvoValidAmount= false;
    } //-- void deleteDAmtInvoValidAmount() 

    /**
     */
    public void deleteDAmtInvoWarrant()
    {
        this._has_dAmtInvoWarrant= false;
    } //-- void deleteDAmtInvoWarrant() 

    /**
     */
    public void deleteUMoInvoMonth()
    {
        this._has_uMoInvoMonth= false;
    } //-- void deleteUMoInvoMonth() 

    /**
     */
    public void deleteUYrInvoYear()
    {
        this._has_uYrInvoYear= false;
    } //-- void deleteUYrInvoYear() 

    /**
     */
    public void deleteUlIdContract()
    {
        this._has_ulIdContract= false;
    } //-- void deleteUlIdContract() 

    /**
     */
    public void deleteUlIdInvoInvoice()
    {
        this._has_ulIdInvoInvoice= false;
    } //-- void deleteUlIdInvoInvoice() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

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
     * Returns the value of field 'bIndEmergencyPayment'.
     * 
     * @return the value of field 'BIndEmergencyPayment'.
     */
    public boolean getBIndEmergencyPayment()
    {
        return this._bIndEmergencyPayment;
    } //-- boolean getBIndEmergencyPayment() 

    /**
     * Returns the value of field 'cIndInvoReadyForValid'.
     * 
     * @return the value of field 'CIndInvoReadyForValid'.
     */
    public java.lang.String getCIndInvoReadyForValid()
    {
        return this._cIndInvoReadyForValid;
    } //-- java.lang.String getCIndInvoReadyForValid() 

    /**
     * Returns the value of field 'dAmtInvoClaimedAmount'.
     * 
     * @return the value of field 'DAmtInvoClaimedAmount'.
     */
    public double getDAmtInvoClaimedAmount()
    {
        return this._dAmtInvoClaimedAmount;
    } //-- double getDAmtInvoClaimedAmount() 

    /**
     * Returns the value of field 'dAmtInvoValidAmount'.
     * 
     * @return the value of field 'DAmtInvoValidAmount'.
     */
    public double getDAmtInvoValidAmount()
    {
        return this._dAmtInvoValidAmount;
    } //-- double getDAmtInvoValidAmount() 

    /**
     * Returns the value of field 'dAmtInvoWarrant'.
     * 
     * @return the value of field 'DAmtInvoWarrant'.
     */
    public double getDAmtInvoWarrant()
    {
        return this._dAmtInvoWarrant;
    } //-- double getDAmtInvoWarrant() 

    /**
     * Returns the value of field 'dtDtInvoApprovalDate'.
     * 
     * @return the value of field 'DtDtInvoApprovalDate'.
     */
    public org.exolab.castor.types.Date getDtDtInvoApprovalDate()
    {
        return this._dtDtInvoApprovalDate;
    } //-- org.exolab.castor.types.Date getDtDtInvoApprovalDate() 

    /**
     * Returns the value of field 'dtDtInvoEntryCompleted'.
     * 
     * @return the value of field 'DtDtInvoEntryCompleted'.
     */
    public org.exolab.castor.types.Date getDtDtInvoEntryCompleted()
    {
        return this._dtDtInvoEntryCompleted;
    } //-- org.exolab.castor.types.Date getDtDtInvoEntryCompleted() 

    /**
     * Returns the value of field 'dtDtInvoEntryStarted'.
     * 
     * @return the value of field 'DtDtInvoEntryStarted'.
     */
    public org.exolab.castor.types.Date getDtDtInvoEntryStarted()
    {
        return this._dtDtInvoEntryStarted;
    } //-- org.exolab.castor.types.Date getDtDtInvoEntryStarted() 

    /**
     * Returns the value of field 'dtDtInvoReceivedDate'.
     * 
     * @return the value of field 'DtDtInvoReceivedDate'.
     */
    public org.exolab.castor.types.Date getDtDtInvoReceivedDate()
    {
        return this._dtDtInvoReceivedDate;
    } //-- org.exolab.castor.types.Date getDtDtInvoReceivedDate() 

    /**
     * Returns the value of field 'dtDtInvoSubmitDate'.
     * 
     * @return the value of field 'DtDtInvoSubmitDate'.
     */
    public org.exolab.castor.types.Date getDtDtInvoSubmitDate()
    {
        return this._dtDtInvoSubmitDate;
    } //-- org.exolab.castor.types.Date getDtDtInvoSubmitDate() 

    /**
     * Returns the value of field 'dtDtInvoWarrantDate'.
     * 
     * @return the value of field 'DtDtInvoWarrantDate'.
     */
    public org.exolab.castor.types.Date getDtDtInvoWarrantDate()
    {
        return this._dtDtInvoWarrantDate;
    } //-- org.exolab.castor.types.Date getDtDtInvoWarrantDate() 

    /**
     * Returns the value of field 'szCdCounty'.
     * 
     * @return the value of field 'SzCdCounty'.
     */
    public java.lang.String getSzCdCounty()
    {
        return this._szCdCounty;
    } //-- java.lang.String getSzCdCounty() 

    /**
     * Returns the value of field 'szCdInvoAdjustmentRb'.
     * 
     * @return the value of field 'SzCdInvoAdjustmentRb'.
     */
    public java.lang.String getSzCdInvoAdjustmentRb()
    {
        return this._szCdInvoAdjustmentRb;
    } //-- java.lang.String getSzCdInvoAdjustmentRb() 

    /**
     * Returns the value of field 'szCdInvoApproved'.
     * 
     * @return the value of field 'SzCdInvoApproved'.
     */
    public java.lang.String getSzCdInvoApproved()
    {
        return this._szCdInvoApproved;
    } //-- java.lang.String getSzCdInvoApproved() 

    /**
     * Returns the value of field 'szCdInvoPhase'.
     * 
     * @return the value of field 'SzCdInvoPhase'.
     */
    public java.lang.String getSzCdInvoPhase()
    {
        return this._szCdInvoPhase;
    } //-- java.lang.String getSzCdInvoPhase() 

    /**
     * Returns the value of field 'szCdInvoType'.
     * 
     * @return the value of field 'SzCdInvoType'.
     */
    public java.lang.String getSzCdInvoType()
    {
        return this._szCdInvoType;
    } //-- java.lang.String getSzCdInvoType() 

    /**
     * Returns the value of field 'szCdRegion'.
     * 
     * @return the value of field 'SzCdRegion'.
     */
    public java.lang.String getSzCdRegion()
    {
        return this._szCdRegion;
    } //-- java.lang.String getSzCdRegion() 

    /**
     * Returns the value of field 'szNbrInvProvider'.
     * 
     * @return the value of field 'SzNbrInvProvider'.
     */
    public java.lang.String getSzNbrInvProvider()
    {
        return this._szNbrInvProvider;
    } //-- java.lang.String getSzNbrInvProvider() 

    /**
     * Returns the value of field 'szNbrInvoVid'.
     * 
     * @return the value of field 'SzNbrInvoVid'.
     */
    public java.lang.String getSzNbrInvoVid()
    {
        return this._szNbrInvoVid;
    } //-- java.lang.String getSzNbrInvoVid() 

    /**
     * Returns the value of field 'szNbrInvoWarrant'.
     * 
     * @return the value of field 'SzNbrInvoWarrant'.
     */
    public java.lang.String getSzNbrInvoWarrant()
    {
        return this._szNbrInvoWarrant;
    } //-- java.lang.String getSzNbrInvoWarrant() 

    /**
     * Returns the value of field 'szTxtInvoContact'.
     * 
     * @return the value of field 'SzTxtInvoContact'.
     */
    public java.lang.String getSzTxtInvoContact()
    {
        return this._szTxtInvoContact;
    } //-- java.lang.String getSzTxtInvoContact() 

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
     * Returns the value of field 'uMoInvoMonth'.
     * 
     * @return the value of field 'UMoInvoMonth'.
     */
    public int getUMoInvoMonth()
    {
        return this._uMoInvoMonth;
    } //-- int getUMoInvoMonth() 

    /**
     * Returns the value of field 'uYrInvoYear'.
     * 
     * @return the value of field 'UYrInvoYear'.
     */
    public int getUYrInvoYear()
    {
        return this._uYrInvoYear;
    } //-- int getUYrInvoYear() 

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
     * Returns the value of field 'ulIdInvoInvoice'.
     * 
     * @return the value of field 'UlIdInvoInvoice'.
     */
    public int getUlIdInvoInvoice()
    {
        return this._ulIdInvoInvoice;
    } //-- int getUlIdInvoInvoice() 

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
     * Method hasBIndEmergencyPayment
     * 
     * 
     * 
     * @return true if at least one BIndEmergencyPayment has been
     * added
     */
    public boolean hasBIndEmergencyPayment()
    {
        return this._has_bIndEmergencyPayment;
    } //-- boolean hasBIndEmergencyPayment() 

    /**
     * Method hasDAmtInvoClaimedAmount
     * 
     * 
     * 
     * @return true if at least one DAmtInvoClaimedAmount has been
     * added
     */
    public boolean hasDAmtInvoClaimedAmount()
    {
        return this._has_dAmtInvoClaimedAmount;
    } //-- boolean hasDAmtInvoClaimedAmount() 

    /**
     * Method hasDAmtInvoValidAmount
     * 
     * 
     * 
     * @return true if at least one DAmtInvoValidAmount has been
     * added
     */
    public boolean hasDAmtInvoValidAmount()
    {
        return this._has_dAmtInvoValidAmount;
    } //-- boolean hasDAmtInvoValidAmount() 

    /**
     * Method hasDAmtInvoWarrant
     * 
     * 
     * 
     * @return true if at least one DAmtInvoWarrant has been added
     */
    public boolean hasDAmtInvoWarrant()
    {
        return this._has_dAmtInvoWarrant;
    } //-- boolean hasDAmtInvoWarrant() 

    /**
     * Method hasUMoInvoMonth
     * 
     * 
     * 
     * @return true if at least one UMoInvoMonth has been added
     */
    public boolean hasUMoInvoMonth()
    {
        return this._has_uMoInvoMonth;
    } //-- boolean hasUMoInvoMonth() 

    /**
     * Method hasUYrInvoYear
     * 
     * 
     * 
     * @return true if at least one UYrInvoYear has been added
     */
    public boolean hasUYrInvoYear()
    {
        return this._has_uYrInvoYear;
    } //-- boolean hasUYrInvoYear() 

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
     * Method hasUlIdInvoInvoice
     * 
     * 
     * 
     * @return true if at least one UlIdInvoInvoice has been added
     */
    public boolean hasUlIdInvoInvoice()
    {
        return this._has_ulIdInvoInvoice;
    } //-- boolean hasUlIdInvoInvoice() 

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
     * Returns the value of field 'bIndEmergencyPayment'.
     * 
     * @return the value of field 'BIndEmergencyPayment'.
     */
    public boolean isBIndEmergencyPayment()
    {
        return this._bIndEmergencyPayment;
    } //-- boolean isBIndEmergencyPayment() 

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
     * Sets the value of field 'bIndEmergencyPayment'.
     * 
     * @param bIndEmergencyPayment the value of field
     * 'bIndEmergencyPayment'.
     */
    public void setBIndEmergencyPayment(boolean bIndEmergencyPayment)
    {
        this._bIndEmergencyPayment = bIndEmergencyPayment;
        this._has_bIndEmergencyPayment = true;
    } //-- void setBIndEmergencyPayment(boolean) 

    /**
     * Sets the value of field 'cIndInvoReadyForValid'.
     * 
     * @param cIndInvoReadyForValid the value of field
     * 'cIndInvoReadyForValid'.
     */
    public void setCIndInvoReadyForValid(java.lang.String cIndInvoReadyForValid)
    {
        this._cIndInvoReadyForValid = cIndInvoReadyForValid;
    } //-- void setCIndInvoReadyForValid(java.lang.String) 

    /**
     * Sets the value of field 'dAmtInvoClaimedAmount'.
     * 
     * @param dAmtInvoClaimedAmount the value of field
     * 'dAmtInvoClaimedAmount'.
     */
    public void setDAmtInvoClaimedAmount(double dAmtInvoClaimedAmount)
    {
        this._dAmtInvoClaimedAmount = dAmtInvoClaimedAmount;
        this._has_dAmtInvoClaimedAmount = true;
    } //-- void setDAmtInvoClaimedAmount(double) 

    /**
     * Sets the value of field 'dAmtInvoValidAmount'.
     * 
     * @param dAmtInvoValidAmount the value of field
     * 'dAmtInvoValidAmount'.
     */
    public void setDAmtInvoValidAmount(double dAmtInvoValidAmount)
    {
        this._dAmtInvoValidAmount = dAmtInvoValidAmount;
        this._has_dAmtInvoValidAmount = true;
    } //-- void setDAmtInvoValidAmount(double) 

    /**
     * Sets the value of field 'dAmtInvoWarrant'.
     * 
     * @param dAmtInvoWarrant the value of field 'dAmtInvoWarrant'.
     */
    public void setDAmtInvoWarrant(double dAmtInvoWarrant)
    {
        this._dAmtInvoWarrant = dAmtInvoWarrant;
        this._has_dAmtInvoWarrant = true;
    } //-- void setDAmtInvoWarrant(double) 

    /**
     * Sets the value of field 'dtDtInvoApprovalDate'.
     * 
     * @param dtDtInvoApprovalDate the value of field
     * 'dtDtInvoApprovalDate'.
     */
    public void setDtDtInvoApprovalDate(org.exolab.castor.types.Date dtDtInvoApprovalDate)
    {
        this._dtDtInvoApprovalDate = dtDtInvoApprovalDate;
    } //-- void setDtDtInvoApprovalDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtInvoEntryCompleted'.
     * 
     * @param dtDtInvoEntryCompleted the value of field
     * 'dtDtInvoEntryCompleted'.
     */
    public void setDtDtInvoEntryCompleted(org.exolab.castor.types.Date dtDtInvoEntryCompleted)
    {
        this._dtDtInvoEntryCompleted = dtDtInvoEntryCompleted;
    } //-- void setDtDtInvoEntryCompleted(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtInvoEntryStarted'.
     * 
     * @param dtDtInvoEntryStarted the value of field
     * 'dtDtInvoEntryStarted'.
     */
    public void setDtDtInvoEntryStarted(org.exolab.castor.types.Date dtDtInvoEntryStarted)
    {
        this._dtDtInvoEntryStarted = dtDtInvoEntryStarted;
    } //-- void setDtDtInvoEntryStarted(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtInvoReceivedDate'.
     * 
     * @param dtDtInvoReceivedDate the value of field
     * 'dtDtInvoReceivedDate'.
     */
    public void setDtDtInvoReceivedDate(org.exolab.castor.types.Date dtDtInvoReceivedDate)
    {
        this._dtDtInvoReceivedDate = dtDtInvoReceivedDate;
    } //-- void setDtDtInvoReceivedDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtInvoSubmitDate'.
     * 
     * @param dtDtInvoSubmitDate the value of field
     * 'dtDtInvoSubmitDate'.
     */
    public void setDtDtInvoSubmitDate(org.exolab.castor.types.Date dtDtInvoSubmitDate)
    {
        this._dtDtInvoSubmitDate = dtDtInvoSubmitDate;
    } //-- void setDtDtInvoSubmitDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtInvoWarrantDate'.
     * 
     * @param dtDtInvoWarrantDate the value of field
     * 'dtDtInvoWarrantDate'.
     */
    public void setDtDtInvoWarrantDate(org.exolab.castor.types.Date dtDtInvoWarrantDate)
    {
        this._dtDtInvoWarrantDate = dtDtInvoWarrantDate;
    } //-- void setDtDtInvoWarrantDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdCounty'.
     * 
     * @param szCdCounty the value of field 'szCdCounty'.
     */
    public void setSzCdCounty(java.lang.String szCdCounty)
    {
        this._szCdCounty = szCdCounty;
    } //-- void setSzCdCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdInvoAdjustmentRb'.
     * 
     * @param szCdInvoAdjustmentRb the value of field
     * 'szCdInvoAdjustmentRb'.
     */
    public void setSzCdInvoAdjustmentRb(java.lang.String szCdInvoAdjustmentRb)
    {
        this._szCdInvoAdjustmentRb = szCdInvoAdjustmentRb;
    } //-- void setSzCdInvoAdjustmentRb(java.lang.String) 

    /**
     * Sets the value of field 'szCdInvoApproved'.
     * 
     * @param szCdInvoApproved the value of field 'szCdInvoApproved'
     */
    public void setSzCdInvoApproved(java.lang.String szCdInvoApproved)
    {
        this._szCdInvoApproved = szCdInvoApproved;
    } //-- void setSzCdInvoApproved(java.lang.String) 

    /**
     * Sets the value of field 'szCdInvoPhase'.
     * 
     * @param szCdInvoPhase the value of field 'szCdInvoPhase'.
     */
    public void setSzCdInvoPhase(java.lang.String szCdInvoPhase)
    {
        this._szCdInvoPhase = szCdInvoPhase;
    } //-- void setSzCdInvoPhase(java.lang.String) 

    /**
     * Sets the value of field 'szCdInvoType'.
     * 
     * @param szCdInvoType the value of field 'szCdInvoType'.
     */
    public void setSzCdInvoType(java.lang.String szCdInvoType)
    {
        this._szCdInvoType = szCdInvoType;
    } //-- void setSzCdInvoType(java.lang.String) 

    /**
     * Sets the value of field 'szCdRegion'.
     * 
     * @param szCdRegion the value of field 'szCdRegion'.
     */
    public void setSzCdRegion(java.lang.String szCdRegion)
    {
        this._szCdRegion = szCdRegion;
    } //-- void setSzCdRegion(java.lang.String) 

    /**
     * Sets the value of field 'szNbrInvProvider'.
     * 
     * @param szNbrInvProvider the value of field 'szNbrInvProvider'
     */
    public void setSzNbrInvProvider(java.lang.String szNbrInvProvider)
    {
        this._szNbrInvProvider = szNbrInvProvider;
    } //-- void setSzNbrInvProvider(java.lang.String) 

    /**
     * Sets the value of field 'szNbrInvoVid'.
     * 
     * @param szNbrInvoVid the value of field 'szNbrInvoVid'.
     */
    public void setSzNbrInvoVid(java.lang.String szNbrInvoVid)
    {
        this._szNbrInvoVid = szNbrInvoVid;
    } //-- void setSzNbrInvoVid(java.lang.String) 

    /**
     * Sets the value of field 'szNbrInvoWarrant'.
     * 
     * @param szNbrInvoWarrant the value of field 'szNbrInvoWarrant'
     */
    public void setSzNbrInvoWarrant(java.lang.String szNbrInvoWarrant)
    {
        this._szNbrInvoWarrant = szNbrInvoWarrant;
    } //-- void setSzNbrInvoWarrant(java.lang.String) 

    /**
     * Sets the value of field 'szTxtInvoContact'.
     * 
     * @param szTxtInvoContact the value of field 'szTxtInvoContact'
     */
    public void setSzTxtInvoContact(java.lang.String szTxtInvoContact)
    {
        this._szTxtInvoContact = szTxtInvoContact;
    } //-- void setSzTxtInvoContact(java.lang.String) 

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
     * Sets the value of field 'uMoInvoMonth'.
     * 
     * @param uMoInvoMonth the value of field 'uMoInvoMonth'.
     */
    public void setUMoInvoMonth(int uMoInvoMonth)
    {
        this._uMoInvoMonth = uMoInvoMonth;
        this._has_uMoInvoMonth = true;
    } //-- void setUMoInvoMonth(int) 

    /**
     * Sets the value of field 'uYrInvoYear'.
     * 
     * @param uYrInvoYear the value of field 'uYrInvoYear'.
     */
    public void setUYrInvoYear(int uYrInvoYear)
    {
        this._uYrInvoYear = uYrInvoYear;
        this._has_uYrInvoYear = true;
    } //-- void setUYrInvoYear(int) 

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
     * Sets the value of field 'ulIdInvoInvoice'.
     * 
     * @param ulIdInvoInvoice the value of field 'ulIdInvoInvoice'.
     */
    public void setUlIdInvoInvoice(int ulIdInvoInvoice)
    {
        this._ulIdInvoInvoice = ulIdInvoInvoice;
        this._has_ulIdInvoInvoice = true;
    } //-- void setUlIdInvoInvoice(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN03SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN03SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN03SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN03SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN03SI unmarshal(java.io.Reader) 

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
