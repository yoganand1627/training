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
 * Class ROWCINV12SIG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV12SIG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _dtDtCpsInvstDtlComplt
     */
    private org.exolab.castor.types.Date _dtDtCpsInvstDtlComplt;

    /**
     * Field _dtDtCPSInvstDtlBegun
     */
    private org.exolab.castor.types.Date _dtDtCPSInvstDtlBegun;

    /**
     * Field _bIndCpsInvstSafetyPln
     */
    private java.lang.String _bIndCpsInvstSafetyPln;

    /**
     * Field _cIndCpsInvstDtlRaNa
     */
    private java.lang.String _cIndCpsInvstDtlRaNa;

    /**
     * Field _cIndCpsInvstAbbrv
     */
    private java.lang.String _cIndCpsInvstAbbrv;

    /**
     * Field _dtDtCPSInvstDtlAssigned
     */
    private org.exolab.castor.types.Date _dtDtCPSInvstDtlAssigned;

    /**
     * Field _dtDtCPSInvstDtlIntake
     */
    private java.util.Date _dtDtCPSInvstDtlIntake;

    /**
     * Field _szCdCpsInvstDtlFamIncm
     */
    private java.lang.String _szCdCpsInvstDtlFamIncm;

    /**
     * Field _bIndCpsInvstEaConcl
     */
    private java.lang.String _bIndCpsInvstEaConcl;

    /**
     * Field _cdCpsOverallDisptn
     */
    private java.lang.String _cdCpsOverallDisptn;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV12SIG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG01()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     * Returns the value of field 'bIndCpsInvstEaConcl'.
     * 
     * @return the value of field 'BIndCpsInvstEaConcl'.
     */
    public java.lang.String getBIndCpsInvstEaConcl()
    {
        return this._bIndCpsInvstEaConcl;
    } //-- java.lang.String getBIndCpsInvstEaConcl() 

    /**
     * Returns the value of field 'bIndCpsInvstSafetyPln'.
     * 
     * @return the value of field 'BIndCpsInvstSafetyPln'.
     */
    public java.lang.String getBIndCpsInvstSafetyPln()
    {
        return this._bIndCpsInvstSafetyPln;
    } //-- java.lang.String getBIndCpsInvstSafetyPln() 

    /**
     * Returns the value of field 'cIndCpsInvstAbbrv'.
     * 
     * @return the value of field 'CIndCpsInvstAbbrv'.
     */
    public java.lang.String getCIndCpsInvstAbbrv()
    {
        return this._cIndCpsInvstAbbrv;
    } //-- java.lang.String getCIndCpsInvstAbbrv() 

    /**
     * Returns the value of field 'cIndCpsInvstDtlRaNa'.
     * 
     * @return the value of field 'CIndCpsInvstDtlRaNa'.
     */
    public java.lang.String getCIndCpsInvstDtlRaNa()
    {
        return this._cIndCpsInvstDtlRaNa;
    } //-- java.lang.String getCIndCpsInvstDtlRaNa() 

    /**
     * Returns the value of field 'cdCpsOverallDisptn'.
     * 
     * @return the value of field 'CdCpsOverallDisptn'.
     */
    public java.lang.String getCdCpsOverallDisptn()
    {
        return this._cdCpsOverallDisptn;
    } //-- java.lang.String getCdCpsOverallDisptn() 

    /**
     * Returns the value of field 'dtDtCPSInvstDtlAssigned'.
     * 
     * @return the value of field 'DtDtCPSInvstDtlAssigned'.
     */
    public org.exolab.castor.types.Date getDtDtCPSInvstDtlAssigned()
    {
        return this._dtDtCPSInvstDtlAssigned;
    } //-- org.exolab.castor.types.Date getDtDtCPSInvstDtlAssigned() 

    /**
     * Returns the value of field 'dtDtCPSInvstDtlBegun'.
     * 
     * @return the value of field 'DtDtCPSInvstDtlBegun'.
     */
    public org.exolab.castor.types.Date getDtDtCPSInvstDtlBegun()
    {
        return this._dtDtCPSInvstDtlBegun;
    } //-- org.exolab.castor.types.Date getDtDtCPSInvstDtlBegun() 

    /**
     * Returns the value of field 'dtDtCPSInvstDtlIntake'.
     * 
     * @return the value of field 'DtDtCPSInvstDtlIntake'.
     */
    public java.util.Date getDtDtCPSInvstDtlIntake()
    {
        return this._dtDtCPSInvstDtlIntake;
    } //-- java.util.Date getDtDtCPSInvstDtlIntake() 

    /**
     * Returns the value of field 'dtDtCpsInvstDtlComplt'.
     * 
     * @return the value of field 'DtDtCpsInvstDtlComplt'.
     */
    public org.exolab.castor.types.Date getDtDtCpsInvstDtlComplt()
    {
        return this._dtDtCpsInvstDtlComplt;
    } //-- org.exolab.castor.types.Date getDtDtCpsInvstDtlComplt() 

    /**
     * Returns the value of field 'szCdCpsInvstDtlFamIncm'.
     * 
     * @return the value of field 'SzCdCpsInvstDtlFamIncm'.
     */
    public java.lang.String getSzCdCpsInvstDtlFamIncm()
    {
        return this._szCdCpsInvstDtlFamIncm;
    } //-- java.lang.String getSzCdCpsInvstDtlFamIncm() 

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
     * Returns the value of field 'ulIdEvent'.
     * 
     * @return the value of field 'UlIdEvent'.
     */
    public int getUlIdEvent()
    {
        return this._ulIdEvent;
    } //-- int getUlIdEvent() 

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
     * Method hasUlIdEvent
     * 
     * 
     * 
     * @return true if at least one UlIdEvent has been added
     */
    public boolean hasUlIdEvent()
    {
        return this._has_ulIdEvent;
    } //-- boolean hasUlIdEvent() 

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
     * Sets the value of field 'bIndCpsInvstEaConcl'.
     * 
     * @param bIndCpsInvstEaConcl the value of field
     * 'bIndCpsInvstEaConcl'.
     */
    public void setBIndCpsInvstEaConcl(java.lang.String bIndCpsInvstEaConcl)
    {
        this._bIndCpsInvstEaConcl = bIndCpsInvstEaConcl;
    } //-- void setBIndCpsInvstEaConcl(java.lang.String) 

    /**
     * Sets the value of field 'bIndCpsInvstSafetyPln'.
     * 
     * @param bIndCpsInvstSafetyPln the value of field
     * 'bIndCpsInvstSafetyPln'.
     */
    public void setBIndCpsInvstSafetyPln(java.lang.String bIndCpsInvstSafetyPln)
    {
        this._bIndCpsInvstSafetyPln = bIndCpsInvstSafetyPln;
    } //-- void setBIndCpsInvstSafetyPln(java.lang.String) 

    /**
     * Sets the value of field 'cIndCpsInvstAbbrv'.
     * 
     * @param cIndCpsInvstAbbrv the value of field
     * 'cIndCpsInvstAbbrv'.
     */
    public void setCIndCpsInvstAbbrv(java.lang.String cIndCpsInvstAbbrv)
    {
        this._cIndCpsInvstAbbrv = cIndCpsInvstAbbrv;
    } //-- void setCIndCpsInvstAbbrv(java.lang.String) 

    /**
     * Sets the value of field 'cIndCpsInvstDtlRaNa'.
     * 
     * @param cIndCpsInvstDtlRaNa the value of field
     * 'cIndCpsInvstDtlRaNa'.
     */
    public void setCIndCpsInvstDtlRaNa(java.lang.String cIndCpsInvstDtlRaNa)
    {
        this._cIndCpsInvstDtlRaNa = cIndCpsInvstDtlRaNa;
    } //-- void setCIndCpsInvstDtlRaNa(java.lang.String) 

    /**
     * Sets the value of field 'cdCpsOverallDisptn'.
     * 
     * @param cdCpsOverallDisptn the value of field
     * 'cdCpsOverallDisptn'.
     */
    public void setCdCpsOverallDisptn(java.lang.String cdCpsOverallDisptn)
    {
        this._cdCpsOverallDisptn = cdCpsOverallDisptn;
    } //-- void setCdCpsOverallDisptn(java.lang.String) 

    /**
     * Sets the value of field 'dtDtCPSInvstDtlAssigned'.
     * 
     * @param dtDtCPSInvstDtlAssigned the value of field
     * 'dtDtCPSInvstDtlAssigned'.
     */
    public void setDtDtCPSInvstDtlAssigned(org.exolab.castor.types.Date dtDtCPSInvstDtlAssigned)
    {
        this._dtDtCPSInvstDtlAssigned = dtDtCPSInvstDtlAssigned;
    } //-- void setDtDtCPSInvstDtlAssigned(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCPSInvstDtlBegun'.
     * 
     * @param dtDtCPSInvstDtlBegun the value of field
     * 'dtDtCPSInvstDtlBegun'.
     */
    public void setDtDtCPSInvstDtlBegun(org.exolab.castor.types.Date dtDtCPSInvstDtlBegun)
    {
        this._dtDtCPSInvstDtlBegun = dtDtCPSInvstDtlBegun;
    } //-- void setDtDtCPSInvstDtlBegun(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCPSInvstDtlIntake'.
     * 
     * @param dtDtCPSInvstDtlIntake the value of field
     * 'dtDtCPSInvstDtlIntake'.
     */
    public void setDtDtCPSInvstDtlIntake(java.util.Date dtDtCPSInvstDtlIntake)
    {
        this._dtDtCPSInvstDtlIntake = dtDtCPSInvstDtlIntake;
    } //-- void setDtDtCPSInvstDtlIntake(java.util.Date) 

    /**
     * Sets the value of field 'dtDtCpsInvstDtlComplt'.
     * 
     * @param dtDtCpsInvstDtlComplt the value of field
     * 'dtDtCpsInvstDtlComplt'.
     */
    public void setDtDtCpsInvstDtlComplt(org.exolab.castor.types.Date dtDtCpsInvstDtlComplt)
    {
        this._dtDtCpsInvstDtlComplt = dtDtCpsInvstDtlComplt;
    } //-- void setDtDtCpsInvstDtlComplt(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdCpsInvstDtlFamIncm'.
     * 
     * @param szCdCpsInvstDtlFamIncm the value of field
     * 'szCdCpsInvstDtlFamIncm'.
     */
    public void setSzCdCpsInvstDtlFamIncm(java.lang.String szCdCpsInvstDtlFamIncm)
    {
        this._szCdCpsInvstDtlFamIncm = szCdCpsInvstDtlFamIncm;
    } //-- void setSzCdCpsInvstDtlFamIncm(java.lang.String) 

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
     * Sets the value of field 'ulIdEvent'.
     * 
     * @param ulIdEvent the value of field 'ulIdEvent'.
     */
    public void setUlIdEvent(int ulIdEvent)
    {
        this._ulIdEvent = ulIdEvent;
        this._has_ulIdEvent = true;
    } //-- void setUlIdEvent(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG01 unmarshal(java.io.Reader) 

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
