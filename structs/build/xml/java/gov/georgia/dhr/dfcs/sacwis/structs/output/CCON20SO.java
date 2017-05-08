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
 * Class CCON20SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCON20SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _ulNbrCncntyPeriod
     */
    private int _ulNbrCncntyPeriod;

    /**
     * keeps track of state for field: _ulNbrCncntyPeriod
     */
    private boolean _has_ulNbrCncntyPeriod;

    /**
     * Field _ulNbrCncntyVersion
     */
    private int _ulNbrCncntyVersion;

    /**
     * keeps track of state for field: _ulNbrCncntyVersion
     */
    private boolean _has_ulNbrCncntyVersion;

    /**
     * Field _szCdCntrctRegion
     */
    private java.lang.String _szCdCntrctRegion;

    /**
     * Field _ulIdCntrctManager
     */
    private int _ulIdCntrctManager;

    /**
     * keeps track of state for field: _ulIdCntrctManager
     */
    private boolean _has_ulIdCntrctManager;

    /**
     * Field _dtDtCnperStart
     */
    private org.exolab.castor.types.Date _dtDtCnperStart;

    /**
     * Field _dtDtCnperClosure
     */
    private org.exolab.castor.types.Date _dtDtCnperClosure;

    /**
     * Field _szCdCnperStatus
     */
    private java.lang.String _szCdCnperStatus;

    /**
     * Field _cIndCntrctBudgLimit
     */
    private java.lang.String _cIndCntrctBudgLimit;

    /**
     * Field _cIndCnperRenewal
     */
    private java.lang.String _cIndCnperRenewal;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCON20SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCON20SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCntrctManager()
    {
        this._has_ulIdCntrctManager= false;
    } //-- void deleteUlIdCntrctManager() 

    /**
     */
    public void deleteUlIdContract()
    {
        this._has_ulIdContract= false;
    } //-- void deleteUlIdContract() 

    /**
     */
    public void deleteUlNbrCncntyPeriod()
    {
        this._has_ulNbrCncntyPeriod= false;
    } //-- void deleteUlNbrCncntyPeriod() 

    /**
     */
    public void deleteUlNbrCncntyVersion()
    {
        this._has_ulNbrCncntyVersion= false;
    } //-- void deleteUlNbrCncntyVersion() 

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
     * Returns the value of field 'cIndCnperRenewal'.
     * 
     * @return the value of field 'CIndCnperRenewal'.
     */
    public java.lang.String getCIndCnperRenewal()
    {
        return this._cIndCnperRenewal;
    } //-- java.lang.String getCIndCnperRenewal() 

    /**
     * Returns the value of field 'cIndCntrctBudgLimit'.
     * 
     * @return the value of field 'CIndCntrctBudgLimit'.
     */
    public java.lang.String getCIndCntrctBudgLimit()
    {
        return this._cIndCntrctBudgLimit;
    } //-- java.lang.String getCIndCntrctBudgLimit() 

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
     * Returns the value of field 'szCdCnperStatus'.
     * 
     * @return the value of field 'SzCdCnperStatus'.
     */
    public java.lang.String getSzCdCnperStatus()
    {
        return this._szCdCnperStatus;
    } //-- java.lang.String getSzCdCnperStatus() 

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
     * Returns the value of field 'ulIdCntrctManager'.
     * 
     * @return the value of field 'UlIdCntrctManager'.
     */
    public int getUlIdCntrctManager()
    {
        return this._ulIdCntrctManager;
    } //-- int getUlIdCntrctManager() 

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
     * Returns the value of field 'ulNbrCncntyPeriod'.
     * 
     * @return the value of field 'UlNbrCncntyPeriod'.
     */
    public int getUlNbrCncntyPeriod()
    {
        return this._ulNbrCncntyPeriod;
    } //-- int getUlNbrCncntyPeriod() 

    /**
     * Returns the value of field 'ulNbrCncntyVersion'.
     * 
     * @return the value of field 'UlNbrCncntyVersion'.
     */
    public int getUlNbrCncntyVersion()
    {
        return this._ulNbrCncntyVersion;
    } //-- int getUlNbrCncntyVersion() 

    /**
     * Method hasUlIdCntrctManager
     * 
     * 
     * 
     * @return true if at least one UlIdCntrctManager has been added
     */
    public boolean hasUlIdCntrctManager()
    {
        return this._has_ulIdCntrctManager;
    } //-- boolean hasUlIdCntrctManager() 

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
     * Method hasUlNbrCncntyPeriod
     * 
     * 
     * 
     * @return true if at least one UlNbrCncntyPeriod has been added
     */
    public boolean hasUlNbrCncntyPeriod()
    {
        return this._has_ulNbrCncntyPeriod;
    } //-- boolean hasUlNbrCncntyPeriod() 

    /**
     * Method hasUlNbrCncntyVersion
     * 
     * 
     * 
     * @return true if at least one UlNbrCncntyVersion has been adde
     */
    public boolean hasUlNbrCncntyVersion()
    {
        return this._has_ulNbrCncntyVersion;
    } //-- boolean hasUlNbrCncntyVersion() 

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
     * Sets the value of field 'cIndCnperRenewal'.
     * 
     * @param cIndCnperRenewal the value of field 'cIndCnperRenewal'
     */
    public void setCIndCnperRenewal(java.lang.String cIndCnperRenewal)
    {
        this._cIndCnperRenewal = cIndCnperRenewal;
    } //-- void setCIndCnperRenewal(java.lang.String) 

    /**
     * Sets the value of field 'cIndCntrctBudgLimit'.
     * 
     * @param cIndCntrctBudgLimit the value of field
     * 'cIndCntrctBudgLimit'.
     */
    public void setCIndCntrctBudgLimit(java.lang.String cIndCntrctBudgLimit)
    {
        this._cIndCntrctBudgLimit = cIndCntrctBudgLimit;
    } //-- void setCIndCntrctBudgLimit(java.lang.String) 

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
     * Sets the value of field 'szCdCnperStatus'.
     * 
     * @param szCdCnperStatus the value of field 'szCdCnperStatus'.
     */
    public void setSzCdCnperStatus(java.lang.String szCdCnperStatus)
    {
        this._szCdCnperStatus = szCdCnperStatus;
    } //-- void setSzCdCnperStatus(java.lang.String) 

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
     * Sets the value of field 'ulIdCntrctManager'.
     * 
     * @param ulIdCntrctManager the value of field
     * 'ulIdCntrctManager'.
     */
    public void setUlIdCntrctManager(int ulIdCntrctManager)
    {
        this._ulIdCntrctManager = ulIdCntrctManager;
        this._has_ulIdCntrctManager = true;
    } //-- void setUlIdCntrctManager(int) 

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
     * Sets the value of field 'ulNbrCncntyPeriod'.
     * 
     * @param ulNbrCncntyPeriod the value of field
     * 'ulNbrCncntyPeriod'.
     */
    public void setUlNbrCncntyPeriod(int ulNbrCncntyPeriod)
    {
        this._ulNbrCncntyPeriod = ulNbrCncntyPeriod;
        this._has_ulNbrCncntyPeriod = true;
    } //-- void setUlNbrCncntyPeriod(int) 

    /**
     * Sets the value of field 'ulNbrCncntyVersion'.
     * 
     * @param ulNbrCncntyVersion the value of field
     * 'ulNbrCncntyVersion'.
     */
    public void setUlNbrCncntyVersion(int ulNbrCncntyVersion)
    {
        this._ulNbrCncntyVersion = ulNbrCncntyVersion;
        this._has_ulNbrCncntyVersion = true;
    } //-- void setUlNbrCncntyVersion(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCON20SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCON20SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCON20SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCON20SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCON20SO unmarshal(java.io.Reader) 

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
