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
 * Class CFAD33SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD33SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdIndivTraining
     */
    private int _ulIdIndivTraining;

    /**
     * keeps track of state for field: _ulIdIndivTraining
     */
    private boolean _has_ulIdIndivTraining;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdIndivTrnType
     */
    private java.lang.String _szCdIndivTrnType;

    /**
     * Field _dtDtIndivTrn
     */
    private org.exolab.castor.types.Date _dtDtIndivTrn;

    /**
     * Field _cIndIndivTrnEc
     */
    private java.lang.String _cIndIndivTrnEc;

    /**
     * Field _ldNbrIndivTrnHrs
     */
    private double _ldNbrIndivTrnHrs;

    /**
     * keeps track of state for field: _ldNbrIndivTrnHrs
     */
    private boolean _has_ldNbrIndivTrnHrs;

    /**
     * Field _sNbrIndivTrnSession
     */
    private int _sNbrIndivTrnSession;

    /**
     * keeps track of state for field: _sNbrIndivTrnSession
     */
    private boolean _has_sNbrIndivTrnSession;

    /**
     * Field _szTxtIndivTrnTitle
     */
    private java.lang.String _szTxtIndivTrnTitle;

    /**
     * Field _szCdSysDataActionOutcome
     */
    private java.lang.String _szCdSysDataActionOutcome;

    /**
     * Field _ldCdTrain1Role
     */
    private java.lang.String _ldCdTrain1Role;

    /**
     * Field _ldCdTrain2Role
     */
    private java.lang.String _ldCdTrain2Role;

    /**
     * Field _ldCdTrain3Role
     */
    private java.lang.String _ldCdTrain3Role;

    /**
     * Field _ldCdTrain4Role
     */
    private java.lang.String _ldCdTrain4Role;

    /**
     * Field _ldNmTrain1
     */
    private java.lang.String _ldNmTrain1;

    /**
     * Field _ldNmTrain2
     */
    private java.lang.String _ldNmTrain2;

    /**
     * Field _ldNmTrain3
     */
    private java.lang.String _ldNmTrain3;

    /**
     * Field _ldNmTrain4
     */
    private java.lang.String _ldNmTrain4;

    /**
     * Field _ldIndCoTrain
     */
    private java.lang.String _ldIndCoTrain;

    /**
     * Field _nmAgency
     */
    private java.lang.String _nmAgency;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD33SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLdNbrIndivTrnHrs()
    {
        this._has_ldNbrIndivTrnHrs= false;
    } //-- void deleteLdNbrIndivTrnHrs() 

    /**
     */
    public void deleteSNbrIndivTrnSession()
    {
        this._has_sNbrIndivTrnSession= false;
    } //-- void deleteSNbrIndivTrnSession() 

    /**
     */
    public void deleteUlIdIndivTraining()
    {
        this._has_ulIdIndivTraining= false;
    } //-- void deleteUlIdIndivTraining() 

    /**
     * Returns the value of field 'cIndIndivTrnEc'.
     * 
     * @return the value of field 'CIndIndivTrnEc'.
     */
    public java.lang.String getCIndIndivTrnEc()
    {
        return this._cIndIndivTrnEc;
    } //-- java.lang.String getCIndIndivTrnEc() 

    /**
     * Returns the value of field 'dtDtIndivTrn'.
     * 
     * @return the value of field 'DtDtIndivTrn'.
     */
    public org.exolab.castor.types.Date getDtDtIndivTrn()
    {
        return this._dtDtIndivTrn;
    } //-- org.exolab.castor.types.Date getDtDtIndivTrn() 

    /**
     * Returns the value of field 'ldCdTrain1Role'.
     * 
     * @return the value of field 'LdCdTrain1Role'.
     */
    public java.lang.String getLdCdTrain1Role()
    {
        return this._ldCdTrain1Role;
    } //-- java.lang.String getLdCdTrain1Role() 

    /**
     * Returns the value of field 'ldCdTrain2Role'.
     * 
     * @return the value of field 'LdCdTrain2Role'.
     */
    public java.lang.String getLdCdTrain2Role()
    {
        return this._ldCdTrain2Role;
    } //-- java.lang.String getLdCdTrain2Role() 

    /**
     * Returns the value of field 'ldCdTrain3Role'.
     * 
     * @return the value of field 'LdCdTrain3Role'.
     */
    public java.lang.String getLdCdTrain3Role()
    {
        return this._ldCdTrain3Role;
    } //-- java.lang.String getLdCdTrain3Role() 

    /**
     * Returns the value of field 'ldCdTrain4Role'.
     * 
     * @return the value of field 'LdCdTrain4Role'.
     */
    public java.lang.String getLdCdTrain4Role()
    {
        return this._ldCdTrain4Role;
    } //-- java.lang.String getLdCdTrain4Role() 

    /**
     * Returns the value of field 'ldIndCoTrain'.
     * 
     * @return the value of field 'LdIndCoTrain'.
     */
    public java.lang.String getLdIndCoTrain()
    {
        return this._ldIndCoTrain;
    } //-- java.lang.String getLdIndCoTrain() 

    /**
     * Returns the value of field 'ldNbrIndivTrnHrs'.
     * 
     * @return the value of field 'LdNbrIndivTrnHrs'.
     */
    public double getLdNbrIndivTrnHrs()
    {
        return this._ldNbrIndivTrnHrs;
    } //-- double getLdNbrIndivTrnHrs() 

    /**
     * Returns the value of field 'ldNmTrain1'.
     * 
     * @return the value of field 'LdNmTrain1'.
     */
    public java.lang.String getLdNmTrain1()
    {
        return this._ldNmTrain1;
    } //-- java.lang.String getLdNmTrain1() 

    /**
     * Returns the value of field 'ldNmTrain2'.
     * 
     * @return the value of field 'LdNmTrain2'.
     */
    public java.lang.String getLdNmTrain2()
    {
        return this._ldNmTrain2;
    } //-- java.lang.String getLdNmTrain2() 

    /**
     * Returns the value of field 'ldNmTrain3'.
     * 
     * @return the value of field 'LdNmTrain3'.
     */
    public java.lang.String getLdNmTrain3()
    {
        return this._ldNmTrain3;
    } //-- java.lang.String getLdNmTrain3() 

    /**
     * Returns the value of field 'ldNmTrain4'.
     * 
     * @return the value of field 'LdNmTrain4'.
     */
    public java.lang.String getLdNmTrain4()
    {
        return this._ldNmTrain4;
    } //-- java.lang.String getLdNmTrain4() 

    /**
     * Returns the value of field 'nmAgency'.
     * 
     * @return the value of field 'NmAgency'.
     */
    public java.lang.String getNmAgency()
    {
        return this._nmAgency;
    } //-- java.lang.String getNmAgency() 

    /**
     * Returns the value of field 'sNbrIndivTrnSession'.
     * 
     * @return the value of field 'SNbrIndivTrnSession'.
     */
    public int getSNbrIndivTrnSession()
    {
        return this._sNbrIndivTrnSession;
    } //-- int getSNbrIndivTrnSession() 

    /**
     * Returns the value of field 'szCdIndivTrnType'.
     * 
     * @return the value of field 'SzCdIndivTrnType'.
     */
    public java.lang.String getSzCdIndivTrnType()
    {
        return this._szCdIndivTrnType;
    } //-- java.lang.String getSzCdIndivTrnType() 

    /**
     * Returns the value of field 'szCdSysDataActionOutcome'.
     * 
     * @return the value of field 'SzCdSysDataActionOutcome'.
     */
    public java.lang.String getSzCdSysDataActionOutcome()
    {
        return this._szCdSysDataActionOutcome;
    } //-- java.lang.String getSzCdSysDataActionOutcome() 

    /**
     * Returns the value of field 'szTxtIndivTrnTitle'.
     * 
     * @return the value of field 'SzTxtIndivTrnTitle'.
     */
    public java.lang.String getSzTxtIndivTrnTitle()
    {
        return this._szTxtIndivTrnTitle;
    } //-- java.lang.String getSzTxtIndivTrnTitle() 

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
     * Returns the value of field 'ulIdIndivTraining'.
     * 
     * @return the value of field 'UlIdIndivTraining'.
     */
    public int getUlIdIndivTraining()
    {
        return this._ulIdIndivTraining;
    } //-- int getUlIdIndivTraining() 

    /**
     * Method hasLdNbrIndivTrnHrs
     * 
     * 
     * 
     * @return true if at least one LdNbrIndivTrnHrs has been added
     */
    public boolean hasLdNbrIndivTrnHrs()
    {
        return this._has_ldNbrIndivTrnHrs;
    } //-- boolean hasLdNbrIndivTrnHrs() 

    /**
     * Method hasSNbrIndivTrnSession
     * 
     * 
     * 
     * @return true if at least one SNbrIndivTrnSession has been
     * added
     */
    public boolean hasSNbrIndivTrnSession()
    {
        return this._has_sNbrIndivTrnSession;
    } //-- boolean hasSNbrIndivTrnSession() 

    /**
     * Method hasUlIdIndivTraining
     * 
     * 
     * 
     * @return true if at least one UlIdIndivTraining has been added
     */
    public boolean hasUlIdIndivTraining()
    {
        return this._has_ulIdIndivTraining;
    } //-- boolean hasUlIdIndivTraining() 

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
     * Sets the value of field 'cIndIndivTrnEc'.
     * 
     * @param cIndIndivTrnEc the value of field 'cIndIndivTrnEc'.
     */
    public void setCIndIndivTrnEc(java.lang.String cIndIndivTrnEc)
    {
        this._cIndIndivTrnEc = cIndIndivTrnEc;
    } //-- void setCIndIndivTrnEc(java.lang.String) 

    /**
     * Sets the value of field 'dtDtIndivTrn'.
     * 
     * @param dtDtIndivTrn the value of field 'dtDtIndivTrn'.
     */
    public void setDtDtIndivTrn(org.exolab.castor.types.Date dtDtIndivTrn)
    {
        this._dtDtIndivTrn = dtDtIndivTrn;
    } //-- void setDtDtIndivTrn(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ldCdTrain1Role'.
     * 
     * @param ldCdTrain1Role the value of field 'ldCdTrain1Role'.
     */
    public void setLdCdTrain1Role(java.lang.String ldCdTrain1Role)
    {
        this._ldCdTrain1Role = ldCdTrain1Role;
    } //-- void setLdCdTrain1Role(java.lang.String) 

    /**
     * Sets the value of field 'ldCdTrain2Role'.
     * 
     * @param ldCdTrain2Role the value of field 'ldCdTrain2Role'.
     */
    public void setLdCdTrain2Role(java.lang.String ldCdTrain2Role)
    {
        this._ldCdTrain2Role = ldCdTrain2Role;
    } //-- void setLdCdTrain2Role(java.lang.String) 

    /**
     * Sets the value of field 'ldCdTrain3Role'.
     * 
     * @param ldCdTrain3Role the value of field 'ldCdTrain3Role'.
     */
    public void setLdCdTrain3Role(java.lang.String ldCdTrain3Role)
    {
        this._ldCdTrain3Role = ldCdTrain3Role;
    } //-- void setLdCdTrain3Role(java.lang.String) 

    /**
     * Sets the value of field 'ldCdTrain4Role'.
     * 
     * @param ldCdTrain4Role the value of field 'ldCdTrain4Role'.
     */
    public void setLdCdTrain4Role(java.lang.String ldCdTrain4Role)
    {
        this._ldCdTrain4Role = ldCdTrain4Role;
    } //-- void setLdCdTrain4Role(java.lang.String) 

    /**
     * Sets the value of field 'ldIndCoTrain'.
     * 
     * @param ldIndCoTrain the value of field 'ldIndCoTrain'.
     */
    public void setLdIndCoTrain(java.lang.String ldIndCoTrain)
    {
        this._ldIndCoTrain = ldIndCoTrain;
    } //-- void setLdIndCoTrain(java.lang.String) 

    /**
     * Sets the value of field 'ldNbrIndivTrnHrs'.
     * 
     * @param ldNbrIndivTrnHrs the value of field 'ldNbrIndivTrnHrs'
     */
    public void setLdNbrIndivTrnHrs(double ldNbrIndivTrnHrs)
    {
        this._ldNbrIndivTrnHrs = ldNbrIndivTrnHrs;
        this._has_ldNbrIndivTrnHrs = true;
    } //-- void setLdNbrIndivTrnHrs(double) 

    /**
     * Sets the value of field 'ldNmTrain1'.
     * 
     * @param ldNmTrain1 the value of field 'ldNmTrain1'.
     */
    public void setLdNmTrain1(java.lang.String ldNmTrain1)
    {
        this._ldNmTrain1 = ldNmTrain1;
    } //-- void setLdNmTrain1(java.lang.String) 

    /**
     * Sets the value of field 'ldNmTrain2'.
     * 
     * @param ldNmTrain2 the value of field 'ldNmTrain2'.
     */
    public void setLdNmTrain2(java.lang.String ldNmTrain2)
    {
        this._ldNmTrain2 = ldNmTrain2;
    } //-- void setLdNmTrain2(java.lang.String) 

    /**
     * Sets the value of field 'ldNmTrain3'.
     * 
     * @param ldNmTrain3 the value of field 'ldNmTrain3'.
     */
    public void setLdNmTrain3(java.lang.String ldNmTrain3)
    {
        this._ldNmTrain3 = ldNmTrain3;
    } //-- void setLdNmTrain3(java.lang.String) 

    /**
     * Sets the value of field 'ldNmTrain4'.
     * 
     * @param ldNmTrain4 the value of field 'ldNmTrain4'.
     */
    public void setLdNmTrain4(java.lang.String ldNmTrain4)
    {
        this._ldNmTrain4 = ldNmTrain4;
    } //-- void setLdNmTrain4(java.lang.String) 

    /**
     * Sets the value of field 'nmAgency'.
     * 
     * @param nmAgency the value of field 'nmAgency'.
     */
    public void setNmAgency(java.lang.String nmAgency)
    {
        this._nmAgency = nmAgency;
    } //-- void setNmAgency(java.lang.String) 

    /**
     * Sets the value of field 'sNbrIndivTrnSession'.
     * 
     * @param sNbrIndivTrnSession the value of field
     * 'sNbrIndivTrnSession'.
     */
    public void setSNbrIndivTrnSession(int sNbrIndivTrnSession)
    {
        this._sNbrIndivTrnSession = sNbrIndivTrnSession;
        this._has_sNbrIndivTrnSession = true;
    } //-- void setSNbrIndivTrnSession(int) 

    /**
     * Sets the value of field 'szCdIndivTrnType'.
     * 
     * @param szCdIndivTrnType the value of field 'szCdIndivTrnType'
     */
    public void setSzCdIndivTrnType(java.lang.String szCdIndivTrnType)
    {
        this._szCdIndivTrnType = szCdIndivTrnType;
    } //-- void setSzCdIndivTrnType(java.lang.String) 

    /**
     * Sets the value of field 'szCdSysDataActionOutcome'.
     * 
     * @param szCdSysDataActionOutcome the value of field
     * 'szCdSysDataActionOutcome'.
     */
    public void setSzCdSysDataActionOutcome(java.lang.String szCdSysDataActionOutcome)
    {
        this._szCdSysDataActionOutcome = szCdSysDataActionOutcome;
    } //-- void setSzCdSysDataActionOutcome(java.lang.String) 

    /**
     * Sets the value of field 'szTxtIndivTrnTitle'.
     * 
     * @param szTxtIndivTrnTitle the value of field
     * 'szTxtIndivTrnTitle'.
     */
    public void setSzTxtIndivTrnTitle(java.lang.String szTxtIndivTrnTitle)
    {
        this._szTxtIndivTrnTitle = szTxtIndivTrnTitle;
    } //-- void setSzTxtIndivTrnTitle(java.lang.String) 

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
     * Sets the value of field 'ulIdIndivTraining'.
     * 
     * @param ulIdIndivTraining the value of field
     * 'ulIdIndivTraining'.
     */
    public void setUlIdIndivTraining(int ulIdIndivTraining)
    {
        this._ulIdIndivTraining = ulIdIndivTraining;
        this._has_ulIdIndivTraining = true;
    } //-- void setUlIdIndivTraining(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00 unmarshal(java.io.Reader) 

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
