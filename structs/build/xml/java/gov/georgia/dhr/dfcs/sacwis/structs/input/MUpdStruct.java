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
 * Class MUpdStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MUpdStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szNmNameLast
     */
    private java.lang.String _szNmNameLast;

    /**
     * Field _szNmPersonFull_ARRAY_CINT35SI
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY_CINT35SI _szNmPersonFull_ARRAY_CINT35SI;

    /**
     * Field _bIndStagePersInLaw
     */
    private java.lang.String _bIndStagePersInLaw;

    /**
     * Field _szCdPersonEthnicGroup
     */
    private java.lang.String _szCdPersonEthnicGroup;

    /**
     * Field _szCdPersonLanguage
     */
    private java.lang.String _szCdPersonLanguage;

    /**
     * Field _szCdDisasterRlf
     */
    private java.lang.String _szCdDisasterRlf;

    /**
     * Field _szCdStagePersRelInt
     */
    private java.lang.String _szCdStagePersRelInt;

    /**
     * Field _szCdStagePersRole
     */
    private java.lang.String _szCdStagePersRole;

    /**
     * Field _szCdStagePersType
     */
    private java.lang.String _szCdStagePersType;

    /**
     * Field _szAddrPersAddrStLn1
     */
    private java.lang.String _szAddrPersAddrStLn1;

    /**
     * Field _szAddrPersAddrStLn2
     */
    private java.lang.String _szAddrPersAddrStLn2;

    /**
     * Field _szAddrCity
     */
    private java.lang.String _szAddrCity;

    /**
     * Field _lAddrZip
     */
    private java.lang.String _lAddrZip;

    /**
     * Field _szCdPersAddrLinkType
     */
    private java.lang.String _szCdPersAddrLinkType;

    /**
     * Field _szCdAddrCounty
     */
    private java.lang.String _szCdAddrCounty;

    /**
     * Field _szCdAddrState
     */
    private java.lang.String _szCdAddrState;

    /**
     * Field _lNbrPhone
     */
    private java.lang.String _lNbrPhone;

    /**
     * Field _lNbrPhoneExtension
     */
    private java.lang.String _lNbrPhoneExtension;

    /**
     * Field _szCdPhoneType
     */
    private java.lang.String _szCdPhoneType;

    /**
     * Field _bIndPersCancelHist
     */
    private java.lang.String _bIndPersCancelHist;

    /**
     * Field _cdPKHouseholdMember
     */
    private java.lang.String _cdPKHouseholdMember;


      //----------------/
     //- Constructors -/
    //----------------/

    public MUpdStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'bIndPersCancelHist'.
     * 
     * @return the value of field 'BIndPersCancelHist'.
     */
    public java.lang.String getBIndPersCancelHist()
    {
        return this._bIndPersCancelHist;
    } //-- java.lang.String getBIndPersCancelHist() 

    /**
     * Returns the value of field 'bIndStagePersInLaw'.
     * 
     * @return the value of field 'BIndStagePersInLaw'.
     */
    public java.lang.String getBIndStagePersInLaw()
    {
        return this._bIndStagePersInLaw;
    } //-- java.lang.String getBIndStagePersInLaw() 

    /**
     * Returns the value of field 'cdPKHouseholdMember'.
     * 
     * @return the value of field 'CdPKHouseholdMember'.
     */
    public java.lang.String getCdPKHouseholdMember()
    {
        return this._cdPKHouseholdMember;
    } //-- java.lang.String getCdPKHouseholdMember() 

    /**
     * Returns the value of field 'lAddrZip'.
     * 
     * @return the value of field 'LAddrZip'.
     */
    public java.lang.String getLAddrZip()
    {
        return this._lAddrZip;
    } //-- java.lang.String getLAddrZip() 

    /**
     * Returns the value of field 'lNbrPhone'.
     * 
     * @return the value of field 'LNbrPhone'.
     */
    public java.lang.String getLNbrPhone()
    {
        return this._lNbrPhone;
    } //-- java.lang.String getLNbrPhone() 

    /**
     * Returns the value of field 'lNbrPhoneExtension'.
     * 
     * @return the value of field 'LNbrPhoneExtension'.
     */
    public java.lang.String getLNbrPhoneExtension()
    {
        return this._lNbrPhoneExtension;
    } //-- java.lang.String getLNbrPhoneExtension() 

    /**
     * Returns the value of field 'szAddrCity'.
     * 
     * @return the value of field 'SzAddrCity'.
     */
    public java.lang.String getSzAddrCity()
    {
        return this._szAddrCity;
    } //-- java.lang.String getSzAddrCity() 

    /**
     * Returns the value of field 'szAddrPersAddrStLn1'.
     * 
     * @return the value of field 'SzAddrPersAddrStLn1'.
     */
    public java.lang.String getSzAddrPersAddrStLn1()
    {
        return this._szAddrPersAddrStLn1;
    } //-- java.lang.String getSzAddrPersAddrStLn1() 

    /**
     * Returns the value of field 'szAddrPersAddrStLn2'.
     * 
     * @return the value of field 'SzAddrPersAddrStLn2'.
     */
    public java.lang.String getSzAddrPersAddrStLn2()
    {
        return this._szAddrPersAddrStLn2;
    } //-- java.lang.String getSzAddrPersAddrStLn2() 

    /**
     * Returns the value of field 'szCdAddrCounty'.
     * 
     * @return the value of field 'SzCdAddrCounty'.
     */
    public java.lang.String getSzCdAddrCounty()
    {
        return this._szCdAddrCounty;
    } //-- java.lang.String getSzCdAddrCounty() 

    /**
     * Returns the value of field 'szCdAddrState'.
     * 
     * @return the value of field 'SzCdAddrState'.
     */
    public java.lang.String getSzCdAddrState()
    {
        return this._szCdAddrState;
    } //-- java.lang.String getSzCdAddrState() 

    /**
     * Returns the value of field 'szCdDisasterRlf'.
     * 
     * @return the value of field 'SzCdDisasterRlf'.
     */
    public java.lang.String getSzCdDisasterRlf()
    {
        return this._szCdDisasterRlf;
    } //-- java.lang.String getSzCdDisasterRlf() 

    /**
     * Returns the value of field 'szCdPersAddrLinkType'.
     * 
     * @return the value of field 'SzCdPersAddrLinkType'.
     */
    public java.lang.String getSzCdPersAddrLinkType()
    {
        return this._szCdPersAddrLinkType;
    } //-- java.lang.String getSzCdPersAddrLinkType() 

    /**
     * Returns the value of field 'szCdPersonEthnicGroup'.
     * 
     * @return the value of field 'SzCdPersonEthnicGroup'.
     */
    public java.lang.String getSzCdPersonEthnicGroup()
    {
        return this._szCdPersonEthnicGroup;
    } //-- java.lang.String getSzCdPersonEthnicGroup() 

    /**
     * Returns the value of field 'szCdPersonLanguage'.
     * 
     * @return the value of field 'SzCdPersonLanguage'.
     */
    public java.lang.String getSzCdPersonLanguage()
    {
        return this._szCdPersonLanguage;
    } //-- java.lang.String getSzCdPersonLanguage() 

    /**
     * Returns the value of field 'szCdPhoneType'.
     * 
     * @return the value of field 'SzCdPhoneType'.
     */
    public java.lang.String getSzCdPhoneType()
    {
        return this._szCdPhoneType;
    } //-- java.lang.String getSzCdPhoneType() 

    /**
     * Returns the value of field 'szCdStagePersRelInt'.
     * 
     * @return the value of field 'SzCdStagePersRelInt'.
     */
    public java.lang.String getSzCdStagePersRelInt()
    {
        return this._szCdStagePersRelInt;
    } //-- java.lang.String getSzCdStagePersRelInt() 

    /**
     * Returns the value of field 'szCdStagePersRole'.
     * 
     * @return the value of field 'SzCdStagePersRole'.
     */
    public java.lang.String getSzCdStagePersRole()
    {
        return this._szCdStagePersRole;
    } //-- java.lang.String getSzCdStagePersRole() 

    /**
     * Returns the value of field 'szCdStagePersType'.
     * 
     * @return the value of field 'SzCdStagePersType'.
     */
    public java.lang.String getSzCdStagePersType()
    {
        return this._szCdStagePersType;
    } //-- java.lang.String getSzCdStagePersType() 

    /**
     * Returns the value of field 'szNmNameLast'.
     * 
     * @return the value of field 'SzNmNameLast'.
     */
    public java.lang.String getSzNmNameLast()
    {
        return this._szNmNameLast;
    } //-- java.lang.String getSzNmNameLast() 

    /**
     * Returns the value of field 'szNmPersonFull_ARRAY_CINT35SI'.
     * 
     * @return the value of field 'SzNmPersonFull_ARRAY_CINT35SI'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY_CINT35SI getSzNmPersonFull_ARRAY_CINT35SI()
    {
        return this._szNmPersonFull_ARRAY_CINT35SI;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY_CINT35SI getSzNmPersonFull_ARRAY_CINT35SI() 

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
     * Sets the value of field 'bIndPersCancelHist'.
     * 
     * @param bIndPersCancelHist the value of field
     * 'bIndPersCancelHist'.
     */
    public void setBIndPersCancelHist(java.lang.String bIndPersCancelHist)
    {
        this._bIndPersCancelHist = bIndPersCancelHist;
    } //-- void setBIndPersCancelHist(java.lang.String) 

    /**
     * Sets the value of field 'bIndStagePersInLaw'.
     * 
     * @param bIndStagePersInLaw the value of field
     * 'bIndStagePersInLaw'.
     */
    public void setBIndStagePersInLaw(java.lang.String bIndStagePersInLaw)
    {
        this._bIndStagePersInLaw = bIndStagePersInLaw;
    } //-- void setBIndStagePersInLaw(java.lang.String) 

    /**
     * Sets the value of field 'cdPKHouseholdMember'.
     * 
     * @param cdPKHouseholdMember the value of field
     * 'cdPKHouseholdMember'.
     */
    public void setCdPKHouseholdMember(java.lang.String cdPKHouseholdMember)
    {
        this._cdPKHouseholdMember = cdPKHouseholdMember;
    } //-- void setCdPKHouseholdMember(java.lang.String) 

    /**
     * Sets the value of field 'lAddrZip'.
     * 
     * @param lAddrZip the value of field 'lAddrZip'.
     */
    public void setLAddrZip(java.lang.String lAddrZip)
    {
        this._lAddrZip = lAddrZip;
    } //-- void setLAddrZip(java.lang.String) 

    /**
     * Sets the value of field 'lNbrPhone'.
     * 
     * @param lNbrPhone the value of field 'lNbrPhone'.
     */
    public void setLNbrPhone(java.lang.String lNbrPhone)
    {
        this._lNbrPhone = lNbrPhone;
    } //-- void setLNbrPhone(java.lang.String) 

    /**
     * Sets the value of field 'lNbrPhoneExtension'.
     * 
     * @param lNbrPhoneExtension the value of field
     * 'lNbrPhoneExtension'.
     */
    public void setLNbrPhoneExtension(java.lang.String lNbrPhoneExtension)
    {
        this._lNbrPhoneExtension = lNbrPhoneExtension;
    } //-- void setLNbrPhoneExtension(java.lang.String) 

    /**
     * Sets the value of field 'szAddrCity'.
     * 
     * @param szAddrCity the value of field 'szAddrCity'.
     */
    public void setSzAddrCity(java.lang.String szAddrCity)
    {
        this._szAddrCity = szAddrCity;
    } //-- void setSzAddrCity(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPersAddrStLn1'.
     * 
     * @param szAddrPersAddrStLn1 the value of field
     * 'szAddrPersAddrStLn1'.
     */
    public void setSzAddrPersAddrStLn1(java.lang.String szAddrPersAddrStLn1)
    {
        this._szAddrPersAddrStLn1 = szAddrPersAddrStLn1;
    } //-- void setSzAddrPersAddrStLn1(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPersAddrStLn2'.
     * 
     * @param szAddrPersAddrStLn2 the value of field
     * 'szAddrPersAddrStLn2'.
     */
    public void setSzAddrPersAddrStLn2(java.lang.String szAddrPersAddrStLn2)
    {
        this._szAddrPersAddrStLn2 = szAddrPersAddrStLn2;
    } //-- void setSzAddrPersAddrStLn2(java.lang.String) 

    /**
     * Sets the value of field 'szCdAddrCounty'.
     * 
     * @param szCdAddrCounty the value of field 'szCdAddrCounty'.
     */
    public void setSzCdAddrCounty(java.lang.String szCdAddrCounty)
    {
        this._szCdAddrCounty = szCdAddrCounty;
    } //-- void setSzCdAddrCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdAddrState'.
     * 
     * @param szCdAddrState the value of field 'szCdAddrState'.
     */
    public void setSzCdAddrState(java.lang.String szCdAddrState)
    {
        this._szCdAddrState = szCdAddrState;
    } //-- void setSzCdAddrState(java.lang.String) 

    /**
     * Sets the value of field 'szCdDisasterRlf'.
     * 
     * @param szCdDisasterRlf the value of field 'szCdDisasterRlf'.
     */
    public void setSzCdDisasterRlf(java.lang.String szCdDisasterRlf)
    {
        this._szCdDisasterRlf = szCdDisasterRlf;
    } //-- void setSzCdDisasterRlf(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersAddrLinkType'.
     * 
     * @param szCdPersAddrLinkType the value of field
     * 'szCdPersAddrLinkType'.
     */
    public void setSzCdPersAddrLinkType(java.lang.String szCdPersAddrLinkType)
    {
        this._szCdPersAddrLinkType = szCdPersAddrLinkType;
    } //-- void setSzCdPersAddrLinkType(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonEthnicGroup'.
     * 
     * @param szCdPersonEthnicGroup the value of field
     * 'szCdPersonEthnicGroup'.
     */
    public void setSzCdPersonEthnicGroup(java.lang.String szCdPersonEthnicGroup)
    {
        this._szCdPersonEthnicGroup = szCdPersonEthnicGroup;
    } //-- void setSzCdPersonEthnicGroup(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonLanguage'.
     * 
     * @param szCdPersonLanguage the value of field
     * 'szCdPersonLanguage'.
     */
    public void setSzCdPersonLanguage(java.lang.String szCdPersonLanguage)
    {
        this._szCdPersonLanguage = szCdPersonLanguage;
    } //-- void setSzCdPersonLanguage(java.lang.String) 

    /**
     * Sets the value of field 'szCdPhoneType'.
     * 
     * @param szCdPhoneType the value of field 'szCdPhoneType'.
     */
    public void setSzCdPhoneType(java.lang.String szCdPhoneType)
    {
        this._szCdPhoneType = szCdPhoneType;
    } //-- void setSzCdPhoneType(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersRelInt'.
     * 
     * @param szCdStagePersRelInt the value of field
     * 'szCdStagePersRelInt'.
     */
    public void setSzCdStagePersRelInt(java.lang.String szCdStagePersRelInt)
    {
        this._szCdStagePersRelInt = szCdStagePersRelInt;
    } //-- void setSzCdStagePersRelInt(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersRole'.
     * 
     * @param szCdStagePersRole the value of field
     * 'szCdStagePersRole'.
     */
    public void setSzCdStagePersRole(java.lang.String szCdStagePersRole)
    {
        this._szCdStagePersRole = szCdStagePersRole;
    } //-- void setSzCdStagePersRole(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersType'.
     * 
     * @param szCdStagePersType the value of field
     * 'szCdStagePersType'.
     */
    public void setSzCdStagePersType(java.lang.String szCdStagePersType)
    {
        this._szCdStagePersType = szCdStagePersType;
    } //-- void setSzCdStagePersType(java.lang.String) 

    /**
     * Sets the value of field 'szNmNameLast'.
     * 
     * @param szNmNameLast the value of field 'szNmNameLast'.
     */
    public void setSzNmNameLast(java.lang.String szNmNameLast)
    {
        this._szNmNameLast = szNmNameLast;
    } //-- void setSzNmNameLast(java.lang.String) 

    /**
     * Sets the value of field 'szNmPersonFull_ARRAY_CINT35SI'.
     * 
     * @param szNmPersonFull_ARRAY_CINT35SI the value of field
     * 'szNmPersonFull_ARRAY_CINT35SI'.
     */
    public void setSzNmPersonFull_ARRAY_CINT35SI(gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY_CINT35SI szNmPersonFull_ARRAY_CINT35SI)
    {
        this._szNmPersonFull_ARRAY_CINT35SI = szNmPersonFull_ARRAY_CINT35SI;
    } //-- void setSzNmPersonFull_ARRAY_CINT35SI(gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY_CINT35SI) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdStruct unmarshal(java.io.Reader) 

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
