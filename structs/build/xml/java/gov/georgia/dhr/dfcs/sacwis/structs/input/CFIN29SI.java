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
 * Class CFIN29SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFIN29SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _cIndSvcAuthComplete
     */
    private java.lang.String _cIndSvcAuthComplete;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _szCdSvcDtlCounty
     */
    private java.lang.String _szCdSvcDtlCounty;

    /**
     * Field _szCdSvcDtlService
     */
    private java.lang.String _szCdSvcDtlService;

    /**
     * Field _szCdInvoType
     */
    private java.lang.String _szCdInvoType;

    /**
     * Field _uMoSvcDtlSvcMonth
     */
    private int _uMoSvcDtlSvcMonth;

    /**
     * keeps track of state for field: _uMoSvcDtlSvcMonth
     */
    private boolean _has_uMoSvcDtlSvcMonth;

    /**
     * Field _uYrSvcDtlServiceYear
     */
    private int _uYrSvcDtlServiceYear;

    /**
     * keeps track of state for field: _uYrSvcDtlServiceYear
     */
    private boolean _has_uYrSvcDtlServiceYear;

    /**
     * Field _bWCDIndKeyChange
     */
    private java.lang.String _bWCDIndKeyChange;

    /**
     * Field _bWCDIndSearchChange
     */
    private java.lang.String _bWCDIndSearchChange;

    /**
     * Field _cIndRsrcTransport
     */
    private java.lang.String _cIndRsrcTransport;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFIN29SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN29SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUMoSvcDtlSvcMonth()
    {
        this._has_uMoSvcDtlSvcMonth= false;
    } //-- void deleteUMoSvcDtlSvcMonth() 

    /**
     */
    public void deleteUYrSvcDtlServiceYear()
    {
        this._has_uYrSvcDtlServiceYear= false;
    } //-- void deleteUYrSvcDtlServiceYear() 

    /**
     */
    public void deleteUlIdContract()
    {
        this._has_ulIdContract= false;
    } //-- void deleteUlIdContract() 

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
     * Returns the value of field 'bWCDIndKeyChange'.
     * 
     * @return the value of field 'BWCDIndKeyChange'.
     */
    public java.lang.String getBWCDIndKeyChange()
    {
        return this._bWCDIndKeyChange;
    } //-- java.lang.String getBWCDIndKeyChange() 

    /**
     * Returns the value of field 'bWCDIndSearchChange'.
     * 
     * @return the value of field 'BWCDIndSearchChange'.
     */
    public java.lang.String getBWCDIndSearchChange()
    {
        return this._bWCDIndSearchChange;
    } //-- java.lang.String getBWCDIndSearchChange() 

    /**
     * Returns the value of field 'cIndRsrcTransport'.
     * 
     * @return the value of field 'CIndRsrcTransport'.
     */
    public java.lang.String getCIndRsrcTransport()
    {
        return this._cIndRsrcTransport;
    } //-- java.lang.String getCIndRsrcTransport() 

    /**
     * Returns the value of field 'cIndSvcAuthComplete'.
     * 
     * @return the value of field 'CIndSvcAuthComplete'.
     */
    public java.lang.String getCIndSvcAuthComplete()
    {
        return this._cIndSvcAuthComplete;
    } //-- java.lang.String getCIndSvcAuthComplete() 

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
     * Returns the value of field 'szCdSvcDtlCounty'.
     * 
     * @return the value of field 'SzCdSvcDtlCounty'.
     */
    public java.lang.String getSzCdSvcDtlCounty()
    {
        return this._szCdSvcDtlCounty;
    } //-- java.lang.String getSzCdSvcDtlCounty() 

    /**
     * Returns the value of field 'szCdSvcDtlService'.
     * 
     * @return the value of field 'SzCdSvcDtlService'.
     */
    public java.lang.String getSzCdSvcDtlService()
    {
        return this._szCdSvcDtlService;
    } //-- java.lang.String getSzCdSvcDtlService() 

    /**
     * Returns the value of field 'uMoSvcDtlSvcMonth'.
     * 
     * @return the value of field 'UMoSvcDtlSvcMonth'.
     */
    public int getUMoSvcDtlSvcMonth()
    {
        return this._uMoSvcDtlSvcMonth;
    } //-- int getUMoSvcDtlSvcMonth() 

    /**
     * Returns the value of field 'uYrSvcDtlServiceYear'.
     * 
     * @return the value of field 'UYrSvcDtlServiceYear'.
     */
    public int getUYrSvcDtlServiceYear()
    {
        return this._uYrSvcDtlServiceYear;
    } //-- int getUYrSvcDtlServiceYear() 

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
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Method hasUMoSvcDtlSvcMonth
     * 
     * 
     * 
     * @return true if at least one UMoSvcDtlSvcMonth has been added
     */
    public boolean hasUMoSvcDtlSvcMonth()
    {
        return this._has_uMoSvcDtlSvcMonth;
    } //-- boolean hasUMoSvcDtlSvcMonth() 

    /**
     * Method hasUYrSvcDtlServiceYear
     * 
     * 
     * 
     * @return true if at least one UYrSvcDtlServiceYear has been
     * added
     */
    public boolean hasUYrSvcDtlServiceYear()
    {
        return this._has_uYrSvcDtlServiceYear;
    } //-- boolean hasUYrSvcDtlServiceYear() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

    /**
     * Sets the value of field 'bWCDIndKeyChange'.
     * 
     * @param bWCDIndKeyChange the value of field 'bWCDIndKeyChange'
     */
    public void setBWCDIndKeyChange(java.lang.String bWCDIndKeyChange)
    {
        this._bWCDIndKeyChange = bWCDIndKeyChange;
    } //-- void setBWCDIndKeyChange(java.lang.String) 

    /**
     * Sets the value of field 'bWCDIndSearchChange'.
     * 
     * @param bWCDIndSearchChange the value of field
     * 'bWCDIndSearchChange'.
     */
    public void setBWCDIndSearchChange(java.lang.String bWCDIndSearchChange)
    {
        this._bWCDIndSearchChange = bWCDIndSearchChange;
    } //-- void setBWCDIndSearchChange(java.lang.String) 

    /**
     * Sets the value of field 'cIndRsrcTransport'.
     * 
     * @param cIndRsrcTransport the value of field
     * 'cIndRsrcTransport'.
     */
    public void setCIndRsrcTransport(java.lang.String cIndRsrcTransport)
    {
        this._cIndRsrcTransport = cIndRsrcTransport;
    } //-- void setCIndRsrcTransport(java.lang.String) 

    /**
     * Sets the value of field 'cIndSvcAuthComplete'.
     * 
     * @param cIndSvcAuthComplete the value of field
     * 'cIndSvcAuthComplete'.
     */
    public void setCIndSvcAuthComplete(java.lang.String cIndSvcAuthComplete)
    {
        this._cIndSvcAuthComplete = cIndSvcAuthComplete;
    } //-- void setCIndSvcAuthComplete(java.lang.String) 

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
     * Sets the value of field 'szCdSvcDtlCounty'.
     * 
     * @param szCdSvcDtlCounty the value of field 'szCdSvcDtlCounty'
     */
    public void setSzCdSvcDtlCounty(java.lang.String szCdSvcDtlCounty)
    {
        this._szCdSvcDtlCounty = szCdSvcDtlCounty;
    } //-- void setSzCdSvcDtlCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcDtlService'.
     * 
     * @param szCdSvcDtlService the value of field
     * 'szCdSvcDtlService'.
     */
    public void setSzCdSvcDtlService(java.lang.String szCdSvcDtlService)
    {
        this._szCdSvcDtlService = szCdSvcDtlService;
    } //-- void setSzCdSvcDtlService(java.lang.String) 

    /**
     * Sets the value of field 'uMoSvcDtlSvcMonth'.
     * 
     * @param uMoSvcDtlSvcMonth the value of field
     * 'uMoSvcDtlSvcMonth'.
     */
    public void setUMoSvcDtlSvcMonth(int uMoSvcDtlSvcMonth)
    {
        this._uMoSvcDtlSvcMonth = uMoSvcDtlSvcMonth;
        this._has_uMoSvcDtlSvcMonth = true;
    } //-- void setUMoSvcDtlSvcMonth(int) 

    /**
     * Sets the value of field 'uYrSvcDtlServiceYear'.
     * 
     * @param uYrSvcDtlServiceYear the value of field
     * 'uYrSvcDtlServiceYear'.
     */
    public void setUYrSvcDtlServiceYear(int uYrSvcDtlServiceYear)
    {
        this._uYrSvcDtlServiceYear = uYrSvcDtlServiceYear;
        this._has_uYrSvcDtlServiceYear = true;
    } //-- void setUYrSvcDtlServiceYear(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN29SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN29SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN29SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN29SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN29SI unmarshal(java.io.Reader) 

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
