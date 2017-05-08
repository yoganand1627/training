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
 * Class CFIN02SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFIN02SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdInvoInvoice
     */
    private int _ulIdInvoInvoice;

    /**
     * keeps track of state for field: _ulIdInvoInvoice
     */
    private boolean _has_ulIdInvoInvoice;

    /**
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _szNmResource
     */
    private java.lang.String _szNmResource;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _szNbrInvoVid
     */
    private java.lang.String _szNbrInvoVid;

    /**
     * Field _szCdCntrctRegion
     */
    private java.lang.String _szCdCntrctRegion;

    /**
     * Field _szCdInvoType
     */
    private java.lang.String _szCdInvoType;

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
     * Field _dtScrDtCurrentDate
     */
    private org.exolab.castor.types.Date _dtScrDtCurrentDate;

    /**
     * Field _dAmtInvoClaimedAmount
     */
    private double _dAmtInvoClaimedAmount;

    /**
     * keeps track of state for field: _dAmtInvoClaimedAmount
     */
    private boolean _has_dAmtInvoClaimedAmount;

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
     * Field _szNbrInvoWarrant
     */
    private java.lang.String _szNbrInvoWarrant;

    /**
     * Field _dtDtInvoReceivedDate
     */
    private org.exolab.castor.types.Date _dtDtInvoReceivedDate;

    /**
     * Field _dtDtInvoSubmitDate
     */
    private org.exolab.castor.types.Date _dtDtInvoSubmitDate;

    /**
     * Field _dtDtInvoWarrantDate
     */
    private org.exolab.castor.types.Date _dtDtInvoWarrantDate;

    /**
     * Field _dtDtInvoEntryCompleted
     */
    private org.exolab.castor.types.Date _dtDtInvoEntryCompleted;

    /**
     * Field _dtDtInvoEntryStarted
     */
    private org.exolab.castor.types.Date _dtDtInvoEntryStarted;

    /**
     * Field _szCdInvoAdjustmentRb
     */
    private java.lang.String _szCdInvoAdjustmentRb;

    /**
     * Field _cIndInvoReadyForValid
     */
    private java.lang.String _cIndInvoReadyForValid;

    /**
     * Field _szCdInvoPhase
     */
    private java.lang.String _szCdInvoPhase;

    /**
     * Field _szCdInvoApproved
     */
    private java.lang.String _szCdInvoApproved;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdCntrctProgramType
     */
    private java.lang.String _szCdCntrctProgramType;

    /**
     * Field _szTxtInvoContact
     */
    private java.lang.String _szTxtInvoContact;

    /**
     * Field _szNbrInvProvider
     */
    private java.lang.String _szNbrInvProvider;

    /**
     * Field _szCdCounty
     */
    private java.lang.String _szCdCounty;

    /**
     * Field _szCdCounty_Array
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCounty_Array _szCdCounty_Array;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFIN02SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO()


      //-----------/
     //- Methods -/
    //-----------/

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
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

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
     * Returns the value of field 'dtScrDtCurrentDate'.
     * 
     * @return the value of field 'DtScrDtCurrentDate'.
     */
    public org.exolab.castor.types.Date getDtScrDtCurrentDate()
    {
        return this._dtScrDtCurrentDate;
    } //-- org.exolab.castor.types.Date getDtScrDtCurrentDate() 

    /**
     * Returns the value of field 'szCdCntrctProgramType'.
     * 
     * @return the value of field 'SzCdCntrctProgramType'.
     */
    public java.lang.String getSzCdCntrctProgramType()
    {
        return this._szCdCntrctProgramType;
    } //-- java.lang.String getSzCdCntrctProgramType() 

    /**
     * Returns the value of field 'szCdCntrctRegion'.
     * 
     * @return the value of field 'SzCdCntrctRegion'.
     */
    public java.lang.String getSzCdCntrctRegion()
    {
        return this._szCdCntrctRegion;
    } //-- java.lang.String getSzCdCntrctRegion() 

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
     * Returns the value of field 'szCdCounty_Array'.
     * 
     * @return the value of field 'SzCdCounty_Array'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCounty_Array getSzCdCounty_Array()
    {
        return this._szCdCounty_Array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCounty_Array getSzCdCounty_Array() 

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
     * Returns the value of field 'szNmResource'.
     * 
     * @return the value of field 'SzNmResource'.
     */
    public java.lang.String getSzNmResource()
    {
        return this._szNmResource;
    } //-- java.lang.String getSzNmResource() 

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
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

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
     * Sets the value of field 'dtScrDtCurrentDate'.
     * 
     * @param dtScrDtCurrentDate the value of field
     * 'dtScrDtCurrentDate'.
     */
    public void setDtScrDtCurrentDate(org.exolab.castor.types.Date dtScrDtCurrentDate)
    {
        this._dtScrDtCurrentDate = dtScrDtCurrentDate;
    } //-- void setDtScrDtCurrentDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdCntrctProgramType'.
     * 
     * @param szCdCntrctProgramType the value of field
     * 'szCdCntrctProgramType'.
     */
    public void setSzCdCntrctProgramType(java.lang.String szCdCntrctProgramType)
    {
        this._szCdCntrctProgramType = szCdCntrctProgramType;
    } //-- void setSzCdCntrctProgramType(java.lang.String) 

    /**
     * Sets the value of field 'szCdCntrctRegion'.
     * 
     * @param szCdCntrctRegion the value of field 'szCdCntrctRegion'
     */
    public void setSzCdCntrctRegion(java.lang.String szCdCntrctRegion)
    {
        this._szCdCntrctRegion = szCdCntrctRegion;
    } //-- void setSzCdCntrctRegion(java.lang.String) 

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
     * Sets the value of field 'szCdCounty_Array'.
     * 
     * @param szCdCounty_Array the value of field 'szCdCounty_Array'
     */
    public void setSzCdCounty_Array(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCounty_Array szCdCounty_Array)
    {
        this._szCdCounty_Array = szCdCounty_Array;
    } //-- void setSzCdCounty_Array(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCounty_Array) 

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
     * Sets the value of field 'szNmResource'.
     * 
     * @param szNmResource the value of field 'szNmResource'.
     */
    public void setSzNmResource(java.lang.String szNmResource)
    {
        this._szNmResource = szNmResource;
    } //-- void setSzNmResource(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO unmarshal(java.io.Reader) 

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
