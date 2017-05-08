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
 * Class ROWCCMN04SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN04SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdEmpProgram
     */
    private java.lang.String _szCdEmpProgram;

    /**
     * Field _szCdEmployeeClass
     */
    private java.lang.String _szCdEmployeeClass;

    /**
     * Field _dtDtEmpHire
     */
    private org.exolab.castor.types.Date _dtDtEmpHire;

    /**
     * Field _dtDtEmpLastAssigned
     */
    private org.exolab.castor.types.Date _dtDtEmpLastAssigned;

    /**
     * Field _dtDtEmpTermination
     */
    private org.exolab.castor.types.Date _dtDtEmpTermination;

    /**
     * Field _ulIdOffice
     */
    private int _ulIdOffice;

    /**
     * keeps track of state for field: _ulIdOffice
     */
    private boolean _has_ulIdOffice;

    /**
     * Field _ulIdEmpJobHistory
     */
    private int _ulIdEmpJobHistory;

    /**
     * keeps track of state for field: _ulIdEmpJobHistory
     */
    private boolean _has_ulIdEmpJobHistory;

    /**
     * Field _szIdEmployeeLogon
     */
    private java.lang.String _szIdEmployeeLogon;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _bIndActiveStatus
     */
    private java.lang.String _bIndActiveStatus;

    /**
     * Field _bIndEmpConfirmedHrmis
     */
    private java.lang.String _bIndEmpConfirmedHrmis;

    /**
     * Field _bIndEmpPendingHrmis
     */
    private java.lang.String _bIndEmpPendingHrmis;

    /**
     * Field _lNbrEmpActivePct
     */
    private int _lNbrEmpActivePct;

    /**
     * keeps track of state for field: _lNbrEmpActivePct
     */
    private boolean _has_lNbrEmpActivePct;

    /**
     * Field _szNmEmpEmailAddr
     */
    private java.lang.String _szNmEmpEmailAddr;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN04SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLNbrEmpActivePct()
    {
        this._has_lNbrEmpActivePct= false;
    } //-- void deleteLNbrEmpActivePct() 

    /**
     */
    public void deleteUlIdEmpJobHistory()
    {
        this._has_ulIdEmpJobHistory= false;
    } //-- void deleteUlIdEmpJobHistory() 

    /**
     */
    public void deleteUlIdOffice()
    {
        this._has_ulIdOffice= false;
    } //-- void deleteUlIdOffice() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     * Returns the value of field 'bIndActiveStatus'.
     * 
     * @return the value of field 'BIndActiveStatus'.
     */
    public java.lang.String getBIndActiveStatus()
    {
        return this._bIndActiveStatus;
    } //-- java.lang.String getBIndActiveStatus() 

    /**
     * Returns the value of field 'bIndEmpConfirmedHrmis'.
     * 
     * @return the value of field 'BIndEmpConfirmedHrmis'.
     */
    public java.lang.String getBIndEmpConfirmedHrmis()
    {
        return this._bIndEmpConfirmedHrmis;
    } //-- java.lang.String getBIndEmpConfirmedHrmis() 

    /**
     * Returns the value of field 'bIndEmpPendingHrmis'.
     * 
     * @return the value of field 'BIndEmpPendingHrmis'.
     */
    public java.lang.String getBIndEmpPendingHrmis()
    {
        return this._bIndEmpPendingHrmis;
    } //-- java.lang.String getBIndEmpPendingHrmis() 

    /**
     * Returns the value of field 'dtDtEmpHire'.
     * 
     * @return the value of field 'DtDtEmpHire'.
     */
    public org.exolab.castor.types.Date getDtDtEmpHire()
    {
        return this._dtDtEmpHire;
    } //-- org.exolab.castor.types.Date getDtDtEmpHire() 

    /**
     * Returns the value of field 'dtDtEmpLastAssigned'.
     * 
     * @return the value of field 'DtDtEmpLastAssigned'.
     */
    public org.exolab.castor.types.Date getDtDtEmpLastAssigned()
    {
        return this._dtDtEmpLastAssigned;
    } //-- org.exolab.castor.types.Date getDtDtEmpLastAssigned() 

    /**
     * Returns the value of field 'dtDtEmpTermination'.
     * 
     * @return the value of field 'DtDtEmpTermination'.
     */
    public org.exolab.castor.types.Date getDtDtEmpTermination()
    {
        return this._dtDtEmpTermination;
    } //-- org.exolab.castor.types.Date getDtDtEmpTermination() 

    /**
     * Returns the value of field 'lNbrEmpActivePct'.
     * 
     * @return the value of field 'LNbrEmpActivePct'.
     */
    public int getLNbrEmpActivePct()
    {
        return this._lNbrEmpActivePct;
    } //-- int getLNbrEmpActivePct() 

    /**
     * Returns the value of field 'szCdEmpProgram'.
     * 
     * @return the value of field 'SzCdEmpProgram'.
     */
    public java.lang.String getSzCdEmpProgram()
    {
        return this._szCdEmpProgram;
    } //-- java.lang.String getSzCdEmpProgram() 

    /**
     * Returns the value of field 'szCdEmployeeClass'.
     * 
     * @return the value of field 'SzCdEmployeeClass'.
     */
    public java.lang.String getSzCdEmployeeClass()
    {
        return this._szCdEmployeeClass;
    } //-- java.lang.String getSzCdEmployeeClass() 

    /**
     * Returns the value of field 'szIdEmployeeLogon'.
     * 
     * @return the value of field 'SzIdEmployeeLogon'.
     */
    public java.lang.String getSzIdEmployeeLogon()
    {
        return this._szIdEmployeeLogon;
    } //-- java.lang.String getSzIdEmployeeLogon() 

    /**
     * Returns the value of field 'szNmEmpEmailAddr'.
     * 
     * @return the value of field 'SzNmEmpEmailAddr'.
     */
    public java.lang.String getSzNmEmpEmailAddr()
    {
        return this._szNmEmpEmailAddr;
    } //-- java.lang.String getSzNmEmpEmailAddr() 

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
     * Returns the value of field 'ulIdEmpJobHistory'.
     * 
     * @return the value of field 'UlIdEmpJobHistory'.
     */
    public int getUlIdEmpJobHistory()
    {
        return this._ulIdEmpJobHistory;
    } //-- int getUlIdEmpJobHistory() 

    /**
     * Returns the value of field 'ulIdOffice'.
     * 
     * @return the value of field 'UlIdOffice'.
     */
    public int getUlIdOffice()
    {
        return this._ulIdOffice;
    } //-- int getUlIdOffice() 

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
     * Method hasLNbrEmpActivePct
     * 
     * 
     * 
     * @return true if at least one LNbrEmpActivePct has been added
     */
    public boolean hasLNbrEmpActivePct()
    {
        return this._has_lNbrEmpActivePct;
    } //-- boolean hasLNbrEmpActivePct() 

    /**
     * Method hasUlIdEmpJobHistory
     * 
     * 
     * 
     * @return true if at least one UlIdEmpJobHistory has been added
     */
    public boolean hasUlIdEmpJobHistory()
    {
        return this._has_ulIdEmpJobHistory;
    } //-- boolean hasUlIdEmpJobHistory() 

    /**
     * Method hasUlIdOffice
     * 
     * 
     * 
     * @return true if at least one UlIdOffice has been added
     */
    public boolean hasUlIdOffice()
    {
        return this._has_ulIdOffice;
    } //-- boolean hasUlIdOffice() 

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
     * Sets the value of field 'bIndActiveStatus'.
     * 
     * @param bIndActiveStatus the value of field 'bIndActiveStatus'
     */
    public void setBIndActiveStatus(java.lang.String bIndActiveStatus)
    {
        this._bIndActiveStatus = bIndActiveStatus;
    } //-- void setBIndActiveStatus(java.lang.String) 

    /**
     * Sets the value of field 'bIndEmpConfirmedHrmis'.
     * 
     * @param bIndEmpConfirmedHrmis the value of field
     * 'bIndEmpConfirmedHrmis'.
     */
    public void setBIndEmpConfirmedHrmis(java.lang.String bIndEmpConfirmedHrmis)
    {
        this._bIndEmpConfirmedHrmis = bIndEmpConfirmedHrmis;
    } //-- void setBIndEmpConfirmedHrmis(java.lang.String) 

    /**
     * Sets the value of field 'bIndEmpPendingHrmis'.
     * 
     * @param bIndEmpPendingHrmis the value of field
     * 'bIndEmpPendingHrmis'.
     */
    public void setBIndEmpPendingHrmis(java.lang.String bIndEmpPendingHrmis)
    {
        this._bIndEmpPendingHrmis = bIndEmpPendingHrmis;
    } //-- void setBIndEmpPendingHrmis(java.lang.String) 

    /**
     * Sets the value of field 'dtDtEmpHire'.
     * 
     * @param dtDtEmpHire the value of field 'dtDtEmpHire'.
     */
    public void setDtDtEmpHire(org.exolab.castor.types.Date dtDtEmpHire)
    {
        this._dtDtEmpHire = dtDtEmpHire;
    } //-- void setDtDtEmpHire(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtEmpLastAssigned'.
     * 
     * @param dtDtEmpLastAssigned the value of field
     * 'dtDtEmpLastAssigned'.
     */
    public void setDtDtEmpLastAssigned(org.exolab.castor.types.Date dtDtEmpLastAssigned)
    {
        this._dtDtEmpLastAssigned = dtDtEmpLastAssigned;
    } //-- void setDtDtEmpLastAssigned(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtEmpTermination'.
     * 
     * @param dtDtEmpTermination the value of field
     * 'dtDtEmpTermination'.
     */
    public void setDtDtEmpTermination(org.exolab.castor.types.Date dtDtEmpTermination)
    {
        this._dtDtEmpTermination = dtDtEmpTermination;
    } //-- void setDtDtEmpTermination(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'lNbrEmpActivePct'.
     * 
     * @param lNbrEmpActivePct the value of field 'lNbrEmpActivePct'
     */
    public void setLNbrEmpActivePct(int lNbrEmpActivePct)
    {
        this._lNbrEmpActivePct = lNbrEmpActivePct;
        this._has_lNbrEmpActivePct = true;
    } //-- void setLNbrEmpActivePct(int) 

    /**
     * Sets the value of field 'szCdEmpProgram'.
     * 
     * @param szCdEmpProgram the value of field 'szCdEmpProgram'.
     */
    public void setSzCdEmpProgram(java.lang.String szCdEmpProgram)
    {
        this._szCdEmpProgram = szCdEmpProgram;
    } //-- void setSzCdEmpProgram(java.lang.String) 

    /**
     * Sets the value of field 'szCdEmployeeClass'.
     * 
     * @param szCdEmployeeClass the value of field
     * 'szCdEmployeeClass'.
     */
    public void setSzCdEmployeeClass(java.lang.String szCdEmployeeClass)
    {
        this._szCdEmployeeClass = szCdEmployeeClass;
    } //-- void setSzCdEmployeeClass(java.lang.String) 

    /**
     * Sets the value of field 'szIdEmployeeLogon'.
     * 
     * @param szIdEmployeeLogon the value of field
     * 'szIdEmployeeLogon'.
     */
    public void setSzIdEmployeeLogon(java.lang.String szIdEmployeeLogon)
    {
        this._szIdEmployeeLogon = szIdEmployeeLogon;
    } //-- void setSzIdEmployeeLogon(java.lang.String) 

    /**
     * Sets the value of field 'szNmEmpEmailAddr'.
     * 
     * @param szNmEmpEmailAddr the value of field 'szNmEmpEmailAddr'
     */
    public void setSzNmEmpEmailAddr(java.lang.String szNmEmpEmailAddr)
    {
        this._szNmEmpEmailAddr = szNmEmpEmailAddr;
    } //-- void setSzNmEmpEmailAddr(java.lang.String) 

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
     * Sets the value of field 'ulIdEmpJobHistory'.
     * 
     * @param ulIdEmpJobHistory the value of field
     * 'ulIdEmpJobHistory'.
     */
    public void setUlIdEmpJobHistory(int ulIdEmpJobHistory)
    {
        this._ulIdEmpJobHistory = ulIdEmpJobHistory;
        this._has_ulIdEmpJobHistory = true;
    } //-- void setUlIdEmpJobHistory(int) 

    /**
     * Sets the value of field 'ulIdOffice'.
     * 
     * @param ulIdOffice the value of field 'ulIdOffice'.
     */
    public void setUlIdOffice(int ulIdOffice)
    {
        this._ulIdOffice = ulIdOffice;
        this._has_ulIdOffice = true;
    } //-- void setUlIdOffice(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG00 unmarshal(java.io.Reader) 

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
