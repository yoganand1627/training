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
 * Class ROWCCON05SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCON05SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulNbrCnperPeriod
     */
    private int _ulNbrCnperPeriod;

    /**
     * keeps track of state for field: _ulNbrCnperPeriod
     */
    private boolean _has_ulNbrCnperPeriod;

    /**
     * Field _ulNbrLegalIdentifier
     */
    private int _ulNbrLegalIdentifier;

    /**
     * keeps track of state for field: _ulNbrLegalIdentifier
     */
    private boolean _has_ulNbrLegalIdentifier;

    /**
     * Field _dtDtCnperClosure
     */
    private org.exolab.castor.types.Date _dtDtCnperClosure;

    /**
     * Field _dtDtCnperStart
     */
    private org.exolab.castor.types.Date _dtDtCnperStart;

    /**
     * Field _dtDtCnperTerm
     */
    private org.exolab.castor.types.Date _dtDtCnperTerm;

    /**
     * Field _szCdCnperStatus
     */
    private java.lang.String _szCdCnperStatus;

    /**
     * Field _cIndCnperRenewal
     */
    private java.lang.String _cIndCnperRenewal;

    /**
     * Field _cIndCnperSigned
     */
    private java.lang.String _cIndCnperSigned;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szTxtCnperClosureCmt
     */
    private java.lang.String _szTxtCnperClosureCmt;

    /**
     * Field _txtLastUpdatedBy
     */
    private java.lang.String _txtLastUpdatedBy;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCON05SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlNbrCnperPeriod()
    {
        this._has_ulNbrCnperPeriod= false;
    } //-- void deleteUlNbrCnperPeriod() 

    /**
     */
    public void deleteUlNbrLegalIdentifier()
    {
        this._has_ulNbrLegalIdentifier= false;
    } //-- void deleteUlNbrLegalIdentifier() 

    /**
     * Returns the value of field 'cIndCnperRenewal'.
     * 
     * @return the value of field 'CIndCnperRenewal'.
     */
    public java.lang.String getCIndCnperRenewal()
    {
        return this._cIndCnperRenewal;
    } //-- java.lang.String getCIndCnperRenewal() 

    /**
     * Returns the value of field 'cIndCnperSigned'.
     * 
     * @return the value of field 'CIndCnperSigned'.
     */
    public java.lang.String getCIndCnperSigned()
    {
        return this._cIndCnperSigned;
    } //-- java.lang.String getCIndCnperSigned() 

    /**
     * Returns the value of field 'dtDtCnperClosure'.
     * 
     * @return the value of field 'DtDtCnperClosure'.
     */
    public org.exolab.castor.types.Date getDtDtCnperClosure()
    {
        return this._dtDtCnperClosure;
    } //-- org.exolab.castor.types.Date getDtDtCnperClosure() 

    /**
     * Returns the value of field 'dtDtCnperStart'.
     * 
     * @return the value of field 'DtDtCnperStart'.
     */
    public org.exolab.castor.types.Date getDtDtCnperStart()
    {
        return this._dtDtCnperStart;
    } //-- org.exolab.castor.types.Date getDtDtCnperStart() 

    /**
     * Returns the value of field 'dtDtCnperTerm'.
     * 
     * @return the value of field 'DtDtCnperTerm'.
     */
    public org.exolab.castor.types.Date getDtDtCnperTerm()
    {
        return this._dtDtCnperTerm;
    } //-- org.exolab.castor.types.Date getDtDtCnperTerm() 

    /**
     * Returns the value of field 'szCdCnperStatus'.
     * 
     * @return the value of field 'SzCdCnperStatus'.
     */
    public java.lang.String getSzCdCnperStatus()
    {
        return this._szCdCnperStatus;
    } //-- java.lang.String getSzCdCnperStatus() 

    /**
     * Returns the value of field 'szTxtCnperClosureCmt'.
     * 
     * @return the value of field 'SzTxtCnperClosureCmt'.
     */
    public java.lang.String getSzTxtCnperClosureCmt()
    {
        return this._szTxtCnperClosureCmt;
    } //-- java.lang.String getSzTxtCnperClosureCmt() 

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
     * Returns the value of field 'txtLastUpdatedBy'.
     * 
     * @return the value of field 'TxtLastUpdatedBy'.
     */
    public java.lang.String getTxtLastUpdatedBy()
    {
        return this._txtLastUpdatedBy;
    } //-- java.lang.String getTxtLastUpdatedBy() 

    /**
     * Returns the value of field 'ulNbrCnperPeriod'.
     * 
     * @return the value of field 'UlNbrCnperPeriod'.
     */
    public int getUlNbrCnperPeriod()
    {
        return this._ulNbrCnperPeriod;
    } //-- int getUlNbrCnperPeriod() 

    /**
     * Returns the value of field 'ulNbrLegalIdentifier'.
     * 
     * @return the value of field 'UlNbrLegalIdentifier'.
     */
    public int getUlNbrLegalIdentifier()
    {
        return this._ulNbrLegalIdentifier;
    } //-- int getUlNbrLegalIdentifier() 

    /**
     * Method hasUlNbrCnperPeriod
     * 
     * 
     * 
     * @return true if at least one UlNbrCnperPeriod has been added
     */
    public boolean hasUlNbrCnperPeriod()
    {
        return this._has_ulNbrCnperPeriod;
    } //-- boolean hasUlNbrCnperPeriod() 

    /**
     * Method hasUlNbrLegalIdentifier
     * 
     * 
     * 
     * @return true if at least one UlNbrLegalIdentifier has been
     * added
     */
    public boolean hasUlNbrLegalIdentifier()
    {
        return this._has_ulNbrLegalIdentifier;
    } //-- boolean hasUlNbrLegalIdentifier() 

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
     * Sets the value of field 'cIndCnperRenewal'.
     * 
     * @param cIndCnperRenewal the value of field 'cIndCnperRenewal'
     */
    public void setCIndCnperRenewal(java.lang.String cIndCnperRenewal)
    {
        this._cIndCnperRenewal = cIndCnperRenewal;
    } //-- void setCIndCnperRenewal(java.lang.String) 

    /**
     * Sets the value of field 'cIndCnperSigned'.
     * 
     * @param cIndCnperSigned the value of field 'cIndCnperSigned'.
     */
    public void setCIndCnperSigned(java.lang.String cIndCnperSigned)
    {
        this._cIndCnperSigned = cIndCnperSigned;
    } //-- void setCIndCnperSigned(java.lang.String) 

    /**
     * Sets the value of field 'dtDtCnperClosure'.
     * 
     * @param dtDtCnperClosure the value of field 'dtDtCnperClosure'
     */
    public void setDtDtCnperClosure(org.exolab.castor.types.Date dtDtCnperClosure)
    {
        this._dtDtCnperClosure = dtDtCnperClosure;
    } //-- void setDtDtCnperClosure(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCnperStart'.
     * 
     * @param dtDtCnperStart the value of field 'dtDtCnperStart'.
     */
    public void setDtDtCnperStart(org.exolab.castor.types.Date dtDtCnperStart)
    {
        this._dtDtCnperStart = dtDtCnperStart;
    } //-- void setDtDtCnperStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCnperTerm'.
     * 
     * @param dtDtCnperTerm the value of field 'dtDtCnperTerm'.
     */
    public void setDtDtCnperTerm(org.exolab.castor.types.Date dtDtCnperTerm)
    {
        this._dtDtCnperTerm = dtDtCnperTerm;
    } //-- void setDtDtCnperTerm(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdCnperStatus'.
     * 
     * @param szCdCnperStatus the value of field 'szCdCnperStatus'.
     */
    public void setSzCdCnperStatus(java.lang.String szCdCnperStatus)
    {
        this._szCdCnperStatus = szCdCnperStatus;
    } //-- void setSzCdCnperStatus(java.lang.String) 

    /**
     * Sets the value of field 'szTxtCnperClosureCmt'.
     * 
     * @param szTxtCnperClosureCmt the value of field
     * 'szTxtCnperClosureCmt'.
     */
    public void setSzTxtCnperClosureCmt(java.lang.String szTxtCnperClosureCmt)
    {
        this._szTxtCnperClosureCmt = szTxtCnperClosureCmt;
    } //-- void setSzTxtCnperClosureCmt(java.lang.String) 

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
     * Sets the value of field 'txtLastUpdatedBy'.
     * 
     * @param txtLastUpdatedBy the value of field 'txtLastUpdatedBy'
     */
    public void setTxtLastUpdatedBy(java.lang.String txtLastUpdatedBy)
    {
        this._txtLastUpdatedBy = txtLastUpdatedBy;
    } //-- void setTxtLastUpdatedBy(java.lang.String) 

    /**
     * Sets the value of field 'ulNbrCnperPeriod'.
     * 
     * @param ulNbrCnperPeriod the value of field 'ulNbrCnperPeriod'
     */
    public void setUlNbrCnperPeriod(int ulNbrCnperPeriod)
    {
        this._ulNbrCnperPeriod = ulNbrCnperPeriod;
        this._has_ulNbrCnperPeriod = true;
    } //-- void setUlNbrCnperPeriod(int) 

    /**
     * Sets the value of field 'ulNbrLegalIdentifier'.
     * 
     * @param ulNbrLegalIdentifier the value of field
     * 'ulNbrLegalIdentifier'.
     */
    public void setUlNbrLegalIdentifier(int ulNbrLegalIdentifier)
    {
        this._ulNbrLegalIdentifier = ulNbrLegalIdentifier;
        this._has_ulNbrLegalIdentifier = true;
    } //-- void setUlNbrLegalIdentifier(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00 unmarshal(java.io.Reader) 

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
