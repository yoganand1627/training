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
 * Class ROWCFIN19SOG.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFIN19SOG extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

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
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _szCdInvoApproved
     */
    private java.lang.String _szCdInvoApproved;

    /**
     * Field _szCdInvoPhase
     */
    private java.lang.String _szCdInvoPhase;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _szNmResource
     */
    private java.lang.String _szNmResource;

    /**
     * Field _szTxtUASCodes
     */
    private java.lang.String _szTxtUASCodes;

    /**
     * Field _dAmtInvoValidAmount
     */
    private double _dAmtInvoValidAmount;

    /**
     * keeps track of state for field: _dAmtInvoValidAmount
     */
    private boolean _has_dAmtInvoValidAmount;

    /**
     * Field _dtDtInvoReceivedDate
     */
    private org.exolab.castor.types.Date _dtDtInvoReceivedDate;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _dtDtInvoApprovalDate
     */
    private org.exolab.castor.types.Date _dtDtInvoApprovalDate;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFIN19SOG() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteDAmtInvoValidAmount()
    {
        this._has_dAmtInvoValidAmount= false;
    } //-- void deleteDAmtInvoValidAmount() 

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
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

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
     * Returns the value of field 'dtDtInvoApprovalDate'.
     * 
     * @return the value of field 'DtDtInvoApprovalDate'.
     */
    public org.exolab.castor.types.Date getDtDtInvoApprovalDate()
    {
        return this._dtDtInvoApprovalDate;
    } //-- org.exolab.castor.types.Date getDtDtInvoApprovalDate() 

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
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

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
     * Returns the value of field 'szTxtUASCodes'.
     * 
     * @return the value of field 'SzTxtUASCodes'.
     */
    public java.lang.String getSzTxtUASCodes()
    {
        return this._szTxtUASCodes;
    } //-- java.lang.String getSzTxtUASCodes() 

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
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

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
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

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
     * Sets the value of field 'szTxtUASCodes'.
     * 
     * @param szTxtUASCodes the value of field 'szTxtUASCodes'.
     */
    public void setSzTxtUASCodes(java.lang.String szTxtUASCodes)
    {
        this._szTxtUASCodes = szTxtUASCodes;
    } //-- void setSzTxtUASCodes(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG unmarshal(java.io.Reader) 

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
