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
 * Class CFIN01SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFIN01SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdInvoPhase
     */
    private java.lang.String _szCdInvoPhase;

    /**
     * Field _szCdInvoType
     */
    private java.lang.String _szCdInvoType;

    /**
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _ulIdClientPerson
     */
    private int _ulIdClientPerson;

    /**
     * keeps track of state for field: _ulIdClientPerson
     */
    private boolean _has_ulIdClientPerson;

    /**
     * Field _ulIdInvoInvoice
     */
    private int _ulIdInvoInvoice;

    /**
     * keeps track of state for field: _ulIdInvoInvoice
     */
    private boolean _has_ulIdInvoInvoice;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

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
     * Field _szCdCntrctRegion
     */
    private java.lang.String _szCdCntrctRegion;

    /**
     * Field _szCdCounty
     */
    private java.lang.String _szCdCounty;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFIN01SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN01SI()


      //-----------/
     //- Methods -/
    //-----------/

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
    public void deleteUlIdClientPerson()
    {
        this._has_ulIdClientPerson= false;
    } //-- void deleteUlIdClientPerson() 

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
     * Returns the value of field 'archInputStruct'.
     * 
     * @return the value of field 'ArchInputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct()
    {
        return this._archInputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct() 

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
     * Returns the value of field 'ulIdClientPerson'.
     * 
     * @return the value of field 'UlIdClientPerson'.
     */
    public int getUlIdClientPerson()
    {
        return this._ulIdClientPerson;
    } //-- int getUlIdClientPerson() 

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
     * Method hasUlIdClientPerson
     * 
     * 
     * 
     * @return true if at least one UlIdClientPerson has been added
     */
    public boolean hasUlIdClientPerson()
    {
        return this._has_ulIdClientPerson;
    } //-- boolean hasUlIdClientPerson() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

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
     * Sets the value of field 'ulIdClientPerson'.
     * 
     * @param ulIdClientPerson the value of field 'ulIdClientPerson'
     */
    public void setUlIdClientPerson(int ulIdClientPerson)
    {
        this._ulIdClientPerson = ulIdClientPerson;
        this._has_ulIdClientPerson = true;
    } //-- void setUlIdClientPerson(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN01SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN01SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN01SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN01SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN01SI unmarshal(java.io.Reader) 

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
