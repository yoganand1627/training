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
 * Class ROWCSUB45SOG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSUB45SOG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdLegalStatEvent
     */
    private int _ulIdLegalStatEvent;

    /**
     * keeps track of state for field: _ulIdLegalStatEvent
     */
    private boolean _has_ulIdLegalStatEvent;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szCdLegalStatCnty
     */
    private java.lang.String _szCdLegalStatCnty;

    /**
     * Field _szCdLegalStatStatus
     */
    private java.lang.String _szCdLegalStatStatus;

    /**
     * Field _dtDtLegalStatStatusDt
     */
    private org.exolab.castor.types.Date _dtDtLegalStatStatusDt;

    /**
     * Field _dtDtLegalStatCrtOrdExpDt
     */
    private org.exolab.castor.types.Date _dtDtLegalStatCrtOrdExpDt;

    /**
     * Field _dtDtLegalStatCustExpDt
     */
    private org.exolab.castor.types.Date _dtDtLegalStatCustExpDt;

    /**
     * Field _dtDtLegalStatPMDueDt
     */
    private org.exolab.castor.types.Date _dtDtLegalStatPMDueDt;

    /**
     * Field _szTxtLegalStatCourtNbr
     */
    private java.lang.String _szTxtLegalStatCourtNbr;

    /**
     * Field _szCdCourtNbr
     */
    private java.lang.String _szCdCourtNbr;

    /**
     * Field _bIndLegalStatRisk
     */
    private java.lang.String _bIndLegalStatRisk;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSUB45SOG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG01()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdLegalStatEvent()
    {
        this._has_ulIdLegalStatEvent= false;
    } //-- void deleteUlIdLegalStatEvent() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     * Returns the value of field 'bIndLegalStatRisk'.
     * 
     * @return the value of field 'BIndLegalStatRisk'.
     */
    public java.lang.String getBIndLegalStatRisk()
    {
        return this._bIndLegalStatRisk;
    } //-- java.lang.String getBIndLegalStatRisk() 

    /**
     * Returns the value of field 'dtDtLegalStatCrtOrdExpDt'.
     * 
     * @return the value of field 'DtDtLegalStatCrtOrdExpDt'.
     */
    public org.exolab.castor.types.Date getDtDtLegalStatCrtOrdExpDt()
    {
        return this._dtDtLegalStatCrtOrdExpDt;
    } //-- org.exolab.castor.types.Date getDtDtLegalStatCrtOrdExpDt() 

    /**
     * Returns the value of field 'dtDtLegalStatCustExpDt'.
     * 
     * @return the value of field 'DtDtLegalStatCustExpDt'.
     */
    public org.exolab.castor.types.Date getDtDtLegalStatCustExpDt()
    {
        return this._dtDtLegalStatCustExpDt;
    } //-- org.exolab.castor.types.Date getDtDtLegalStatCustExpDt() 

    /**
     * Returns the value of field 'dtDtLegalStatPMDueDt'.
     * 
     * @return the value of field 'DtDtLegalStatPMDueDt'.
     */
    public org.exolab.castor.types.Date getDtDtLegalStatPMDueDt()
    {
        return this._dtDtLegalStatPMDueDt;
    } //-- org.exolab.castor.types.Date getDtDtLegalStatPMDueDt() 

    /**
     * Returns the value of field 'dtDtLegalStatStatusDt'.
     * 
     * @return the value of field 'DtDtLegalStatStatusDt'.
     */
    public org.exolab.castor.types.Date getDtDtLegalStatStatusDt()
    {
        return this._dtDtLegalStatStatusDt;
    } //-- org.exolab.castor.types.Date getDtDtLegalStatStatusDt() 

    /**
     * Returns the value of field 'szCdCourtNbr'.
     * 
     * @return the value of field 'SzCdCourtNbr'.
     */
    public java.lang.String getSzCdCourtNbr()
    {
        return this._szCdCourtNbr;
    } //-- java.lang.String getSzCdCourtNbr() 

    /**
     * Returns the value of field 'szCdLegalStatCnty'.
     * 
     * @return the value of field 'SzCdLegalStatCnty'.
     */
    public java.lang.String getSzCdLegalStatCnty()
    {
        return this._szCdLegalStatCnty;
    } //-- java.lang.String getSzCdLegalStatCnty() 

    /**
     * Returns the value of field 'szCdLegalStatStatus'.
     * 
     * @return the value of field 'SzCdLegalStatStatus'.
     */
    public java.lang.String getSzCdLegalStatStatus()
    {
        return this._szCdLegalStatStatus;
    } //-- java.lang.String getSzCdLegalStatStatus() 

    /**
     * Returns the value of field 'szTxtLegalStatCourtNbr'.
     * 
     * @return the value of field 'SzTxtLegalStatCourtNbr'.
     */
    public java.lang.String getSzTxtLegalStatCourtNbr()
    {
        return this._szTxtLegalStatCourtNbr;
    } //-- java.lang.String getSzTxtLegalStatCourtNbr() 

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
     * Returns the value of field 'ulIdLegalStatEvent'.
     * 
     * @return the value of field 'UlIdLegalStatEvent'.
     */
    public int getUlIdLegalStatEvent()
    {
        return this._ulIdLegalStatEvent;
    } //-- int getUlIdLegalStatEvent() 

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
     * Method hasUlIdLegalStatEvent
     * 
     * 
     * 
     * @return true if at least one UlIdLegalStatEvent has been adde
     */
    public boolean hasUlIdLegalStatEvent()
    {
        return this._has_ulIdLegalStatEvent;
    } //-- boolean hasUlIdLegalStatEvent() 

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
     * Sets the value of field 'bIndLegalStatRisk'.
     * 
     * @param bIndLegalStatRisk the value of field
     * 'bIndLegalStatRisk'.
     */
    public void setBIndLegalStatRisk(java.lang.String bIndLegalStatRisk)
    {
        this._bIndLegalStatRisk = bIndLegalStatRisk;
    } //-- void setBIndLegalStatRisk(java.lang.String) 

    /**
     * Sets the value of field 'dtDtLegalStatCrtOrdExpDt'.
     * 
     * @param dtDtLegalStatCrtOrdExpDt the value of field
     * 'dtDtLegalStatCrtOrdExpDt'.
     */
    public void setDtDtLegalStatCrtOrdExpDt(org.exolab.castor.types.Date dtDtLegalStatCrtOrdExpDt)
    {
        this._dtDtLegalStatCrtOrdExpDt = dtDtLegalStatCrtOrdExpDt;
    } //-- void setDtDtLegalStatCrtOrdExpDt(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtLegalStatCustExpDt'.
     * 
     * @param dtDtLegalStatCustExpDt the value of field
     * 'dtDtLegalStatCustExpDt'.
     */
    public void setDtDtLegalStatCustExpDt(org.exolab.castor.types.Date dtDtLegalStatCustExpDt)
    {
        this._dtDtLegalStatCustExpDt = dtDtLegalStatCustExpDt;
    } //-- void setDtDtLegalStatCustExpDt(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtLegalStatPMDueDt'.
     * 
     * @param dtDtLegalStatPMDueDt the value of field
     * 'dtDtLegalStatPMDueDt'.
     */
    public void setDtDtLegalStatPMDueDt(org.exolab.castor.types.Date dtDtLegalStatPMDueDt)
    {
        this._dtDtLegalStatPMDueDt = dtDtLegalStatPMDueDt;
    } //-- void setDtDtLegalStatPMDueDt(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtLegalStatStatusDt'.
     * 
     * @param dtDtLegalStatStatusDt the value of field
     * 'dtDtLegalStatStatusDt'.
     */
    public void setDtDtLegalStatStatusDt(org.exolab.castor.types.Date dtDtLegalStatStatusDt)
    {
        this._dtDtLegalStatStatusDt = dtDtLegalStatStatusDt;
    } //-- void setDtDtLegalStatStatusDt(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdCourtNbr'.
     * 
     * @param szCdCourtNbr the value of field 'szCdCourtNbr'.
     */
    public void setSzCdCourtNbr(java.lang.String szCdCourtNbr)
    {
        this._szCdCourtNbr = szCdCourtNbr;
    } //-- void setSzCdCourtNbr(java.lang.String) 

    /**
     * Sets the value of field 'szCdLegalStatCnty'.
     * 
     * @param szCdLegalStatCnty the value of field
     * 'szCdLegalStatCnty'.
     */
    public void setSzCdLegalStatCnty(java.lang.String szCdLegalStatCnty)
    {
        this._szCdLegalStatCnty = szCdLegalStatCnty;
    } //-- void setSzCdLegalStatCnty(java.lang.String) 

    /**
     * Sets the value of field 'szCdLegalStatStatus'.
     * 
     * @param szCdLegalStatStatus the value of field
     * 'szCdLegalStatStatus'.
     */
    public void setSzCdLegalStatStatus(java.lang.String szCdLegalStatStatus)
    {
        this._szCdLegalStatStatus = szCdLegalStatStatus;
    } //-- void setSzCdLegalStatStatus(java.lang.String) 

    /**
     * Sets the value of field 'szTxtLegalStatCourtNbr'.
     * 
     * @param szTxtLegalStatCourtNbr the value of field
     * 'szTxtLegalStatCourtNbr'.
     */
    public void setSzTxtLegalStatCourtNbr(java.lang.String szTxtLegalStatCourtNbr)
    {
        this._szTxtLegalStatCourtNbr = szTxtLegalStatCourtNbr;
    } //-- void setSzTxtLegalStatCourtNbr(java.lang.String) 

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
     * Sets the value of field 'ulIdLegalStatEvent'.
     * 
     * @param ulIdLegalStatEvent the value of field
     * 'ulIdLegalStatEvent'.
     */
    public void setUlIdLegalStatEvent(int ulIdLegalStatEvent)
    {
        this._ulIdLegalStatEvent = ulIdLegalStatEvent;
        this._has_ulIdLegalStatEvent = true;
    } //-- void setUlIdLegalStatEvent(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG01 unmarshal(java.io.Reader) 

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
