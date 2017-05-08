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
 * Class FacDetailEntStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class FacDetailEntStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szAddrIncmgFacilCity
     */
    private java.lang.String _szAddrIncmgFacilCity;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szCdIncFacilOperBy
     */
    private java.lang.String _szCdIncFacilOperBy;

    /**
     * Field _bIndIncmgFacilAbSupvd
     */
    private java.lang.String _bIndIncmgFacilAbSupvd;

    /**
     * Field _bIndIncmgFacilSearch
     */
    private java.lang.String _bIndIncmgFacilSearch;

    /**
     * Field _szAddrIncmgFacilStLn1
     */
    private java.lang.String _szAddrIncmgFacilStLn1;

    /**
     * Field _szAddrIncmgFacilStLn2
     */
    private java.lang.String _szAddrIncmgFacilStLn2;

    /**
     * Field _szAddrIncmgFacilZip
     */
    private java.lang.String _szAddrIncmgFacilZip;

    /**
     * Field _szCdIncmgFacilCnty
     */
    private java.lang.String _szCdIncmgFacilCnty;

    /**
     * Field _szCdIncmgFacilState
     */
    private java.lang.String _szCdIncmgFacilState;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _szCdIncmgFacilType
     */
    private java.lang.String _szCdIncmgFacilType;

    /**
     * Field _szNbrIncmgFacilPhone
     */
    private java.lang.String _szNbrIncmgFacilPhone;

    /**
     * Field _szNbrIncmgFacilPhoneExt
     */
    private java.lang.String _szNbrIncmgFacilPhoneExt;

    /**
     * Field _szNmUnitWard
     */
    private java.lang.String _szNmUnitWard;

    /**
     * Field _szNmIncmgFacilAffiliated
     */
    private java.lang.String _szNmIncmgFacilAffiliated;

    /**
     * Field _nmIncmgFacilName
     */
    private java.lang.String _nmIncmgFacilName;

    /**
     * Field _bIndIncmgOnGrnds
     */
    private java.lang.String _bIndIncmgOnGrnds;

    /**
     * Field _szTxtFacilCmnts
     */
    private java.lang.String _szTxtFacilCmnts;

    /**
     * Field _szNmIncmgFacilSuprtdant
     */
    private java.lang.String _szNmIncmgFacilSuprtdant;

    /**
     * Field _szCdRsrcType
     */
    private java.lang.String _szCdRsrcType;


      //----------------/
     //- Constructors -/
    //----------------/

    public FacDetailEntStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.FacDetailEntStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     * Returns the value of field 'bIndIncmgFacilAbSupvd'.
     * 
     * @return the value of field 'BIndIncmgFacilAbSupvd'.
     */
    public java.lang.String getBIndIncmgFacilAbSupvd()
    {
        return this._bIndIncmgFacilAbSupvd;
    } //-- java.lang.String getBIndIncmgFacilAbSupvd() 

    /**
     * Returns the value of field 'bIndIncmgFacilSearch'.
     * 
     * @return the value of field 'BIndIncmgFacilSearch'.
     */
    public java.lang.String getBIndIncmgFacilSearch()
    {
        return this._bIndIncmgFacilSearch;
    } //-- java.lang.String getBIndIncmgFacilSearch() 

    /**
     * Returns the value of field 'bIndIncmgOnGrnds'.
     * 
     * @return the value of field 'BIndIncmgOnGrnds'.
     */
    public java.lang.String getBIndIncmgOnGrnds()
    {
        return this._bIndIncmgOnGrnds;
    } //-- java.lang.String getBIndIncmgOnGrnds() 

    /**
     * Returns the value of field 'nmIncmgFacilName'.
     * 
     * @return the value of field 'NmIncmgFacilName'.
     */
    public java.lang.String getNmIncmgFacilName()
    {
        return this._nmIncmgFacilName;
    } //-- java.lang.String getNmIncmgFacilName() 

    /**
     * Returns the value of field 'szAddrIncmgFacilCity'.
     * 
     * @return the value of field 'SzAddrIncmgFacilCity'.
     */
    public java.lang.String getSzAddrIncmgFacilCity()
    {
        return this._szAddrIncmgFacilCity;
    } //-- java.lang.String getSzAddrIncmgFacilCity() 

    /**
     * Returns the value of field 'szAddrIncmgFacilStLn1'.
     * 
     * @return the value of field 'SzAddrIncmgFacilStLn1'.
     */
    public java.lang.String getSzAddrIncmgFacilStLn1()
    {
        return this._szAddrIncmgFacilStLn1;
    } //-- java.lang.String getSzAddrIncmgFacilStLn1() 

    /**
     * Returns the value of field 'szAddrIncmgFacilStLn2'.
     * 
     * @return the value of field 'SzAddrIncmgFacilStLn2'.
     */
    public java.lang.String getSzAddrIncmgFacilStLn2()
    {
        return this._szAddrIncmgFacilStLn2;
    } //-- java.lang.String getSzAddrIncmgFacilStLn2() 

    /**
     * Returns the value of field 'szAddrIncmgFacilZip'.
     * 
     * @return the value of field 'SzAddrIncmgFacilZip'.
     */
    public java.lang.String getSzAddrIncmgFacilZip()
    {
        return this._szAddrIncmgFacilZip;
    } //-- java.lang.String getSzAddrIncmgFacilZip() 

    /**
     * Returns the value of field 'szCdIncFacilOperBy'.
     * 
     * @return the value of field 'SzCdIncFacilOperBy'.
     */
    public java.lang.String getSzCdIncFacilOperBy()
    {
        return this._szCdIncFacilOperBy;
    } //-- java.lang.String getSzCdIncFacilOperBy() 

    /**
     * Returns the value of field 'szCdIncmgFacilCnty'.
     * 
     * @return the value of field 'SzCdIncmgFacilCnty'.
     */
    public java.lang.String getSzCdIncmgFacilCnty()
    {
        return this._szCdIncmgFacilCnty;
    } //-- java.lang.String getSzCdIncmgFacilCnty() 

    /**
     * Returns the value of field 'szCdIncmgFacilState'.
     * 
     * @return the value of field 'SzCdIncmgFacilState'.
     */
    public java.lang.String getSzCdIncmgFacilState()
    {
        return this._szCdIncmgFacilState;
    } //-- java.lang.String getSzCdIncmgFacilState() 

    /**
     * Returns the value of field 'szCdIncmgFacilType'.
     * 
     * @return the value of field 'SzCdIncmgFacilType'.
     */
    public java.lang.String getSzCdIncmgFacilType()
    {
        return this._szCdIncmgFacilType;
    } //-- java.lang.String getSzCdIncmgFacilType() 

    /**
     * Returns the value of field 'szCdRsrcType'.
     * 
     * @return the value of field 'SzCdRsrcType'.
     */
    public java.lang.String getSzCdRsrcType()
    {
        return this._szCdRsrcType;
    } //-- java.lang.String getSzCdRsrcType() 

    /**
     * Returns the value of field 'szNbrIncmgFacilPhone'.
     * 
     * @return the value of field 'SzNbrIncmgFacilPhone'.
     */
    public java.lang.String getSzNbrIncmgFacilPhone()
    {
        return this._szNbrIncmgFacilPhone;
    } //-- java.lang.String getSzNbrIncmgFacilPhone() 

    /**
     * Returns the value of field 'szNbrIncmgFacilPhoneExt'.
     * 
     * @return the value of field 'SzNbrIncmgFacilPhoneExt'.
     */
    public java.lang.String getSzNbrIncmgFacilPhoneExt()
    {
        return this._szNbrIncmgFacilPhoneExt;
    } //-- java.lang.String getSzNbrIncmgFacilPhoneExt() 

    /**
     * Returns the value of field 'szNmIncmgFacilAffiliated'.
     * 
     * @return the value of field 'SzNmIncmgFacilAffiliated'.
     */
    public java.lang.String getSzNmIncmgFacilAffiliated()
    {
        return this._szNmIncmgFacilAffiliated;
    } //-- java.lang.String getSzNmIncmgFacilAffiliated() 

    /**
     * Returns the value of field 'szNmIncmgFacilSuprtdant'.
     * 
     * @return the value of field 'SzNmIncmgFacilSuprtdant'.
     */
    public java.lang.String getSzNmIncmgFacilSuprtdant()
    {
        return this._szNmIncmgFacilSuprtdant;
    } //-- java.lang.String getSzNmIncmgFacilSuprtdant() 

    /**
     * Returns the value of field 'szNmUnitWard'.
     * 
     * @return the value of field 'SzNmUnitWard'.
     */
    public java.lang.String getSzNmUnitWard()
    {
        return this._szNmUnitWard;
    } //-- java.lang.String getSzNmUnitWard() 

    /**
     * Returns the value of field 'szTxtFacilCmnts'.
     * 
     * @return the value of field 'SzTxtFacilCmnts'.
     */
    public java.lang.String getSzTxtFacilCmnts()
    {
        return this._szTxtFacilCmnts;
    } //-- java.lang.String getSzTxtFacilCmnts() 

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
     * Returns the value of field 'ulIdStage'.
     * 
     * @return the value of field 'UlIdStage'.
     */
    public int getUlIdStage()
    {
        return this._ulIdStage;
    } //-- int getUlIdStage() 

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
     * Sets the value of field 'bIndIncmgFacilAbSupvd'.
     * 
     * @param bIndIncmgFacilAbSupvd the value of field
     * 'bIndIncmgFacilAbSupvd'.
     */
    public void setBIndIncmgFacilAbSupvd(java.lang.String bIndIncmgFacilAbSupvd)
    {
        this._bIndIncmgFacilAbSupvd = bIndIncmgFacilAbSupvd;
    } //-- void setBIndIncmgFacilAbSupvd(java.lang.String) 

    /**
     * Sets the value of field 'bIndIncmgFacilSearch'.
     * 
     * @param bIndIncmgFacilSearch the value of field
     * 'bIndIncmgFacilSearch'.
     */
    public void setBIndIncmgFacilSearch(java.lang.String bIndIncmgFacilSearch)
    {
        this._bIndIncmgFacilSearch = bIndIncmgFacilSearch;
    } //-- void setBIndIncmgFacilSearch(java.lang.String) 

    /**
     * Sets the value of field 'bIndIncmgOnGrnds'.
     * 
     * @param bIndIncmgOnGrnds the value of field 'bIndIncmgOnGrnds'
     */
    public void setBIndIncmgOnGrnds(java.lang.String bIndIncmgOnGrnds)
    {
        this._bIndIncmgOnGrnds = bIndIncmgOnGrnds;
    } //-- void setBIndIncmgOnGrnds(java.lang.String) 

    /**
     * Sets the value of field 'nmIncmgFacilName'.
     * 
     * @param nmIncmgFacilName the value of field 'nmIncmgFacilName'
     */
    public void setNmIncmgFacilName(java.lang.String nmIncmgFacilName)
    {
        this._nmIncmgFacilName = nmIncmgFacilName;
    } //-- void setNmIncmgFacilName(java.lang.String) 

    /**
     * Sets the value of field 'szAddrIncmgFacilCity'.
     * 
     * @param szAddrIncmgFacilCity the value of field
     * 'szAddrIncmgFacilCity'.
     */
    public void setSzAddrIncmgFacilCity(java.lang.String szAddrIncmgFacilCity)
    {
        this._szAddrIncmgFacilCity = szAddrIncmgFacilCity;
    } //-- void setSzAddrIncmgFacilCity(java.lang.String) 

    /**
     * Sets the value of field 'szAddrIncmgFacilStLn1'.
     * 
     * @param szAddrIncmgFacilStLn1 the value of field
     * 'szAddrIncmgFacilStLn1'.
     */
    public void setSzAddrIncmgFacilStLn1(java.lang.String szAddrIncmgFacilStLn1)
    {
        this._szAddrIncmgFacilStLn1 = szAddrIncmgFacilStLn1;
    } //-- void setSzAddrIncmgFacilStLn1(java.lang.String) 

    /**
     * Sets the value of field 'szAddrIncmgFacilStLn2'.
     * 
     * @param szAddrIncmgFacilStLn2 the value of field
     * 'szAddrIncmgFacilStLn2'.
     */
    public void setSzAddrIncmgFacilStLn2(java.lang.String szAddrIncmgFacilStLn2)
    {
        this._szAddrIncmgFacilStLn2 = szAddrIncmgFacilStLn2;
    } //-- void setSzAddrIncmgFacilStLn2(java.lang.String) 

    /**
     * Sets the value of field 'szAddrIncmgFacilZip'.
     * 
     * @param szAddrIncmgFacilZip the value of field
     * 'szAddrIncmgFacilZip'.
     */
    public void setSzAddrIncmgFacilZip(java.lang.String szAddrIncmgFacilZip)
    {
        this._szAddrIncmgFacilZip = szAddrIncmgFacilZip;
    } //-- void setSzAddrIncmgFacilZip(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncFacilOperBy'.
     * 
     * @param szCdIncFacilOperBy the value of field
     * 'szCdIncFacilOperBy'.
     */
    public void setSzCdIncFacilOperBy(java.lang.String szCdIncFacilOperBy)
    {
        this._szCdIncFacilOperBy = szCdIncFacilOperBy;
    } //-- void setSzCdIncFacilOperBy(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgFacilCnty'.
     * 
     * @param szCdIncmgFacilCnty the value of field
     * 'szCdIncmgFacilCnty'.
     */
    public void setSzCdIncmgFacilCnty(java.lang.String szCdIncmgFacilCnty)
    {
        this._szCdIncmgFacilCnty = szCdIncmgFacilCnty;
    } //-- void setSzCdIncmgFacilCnty(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgFacilState'.
     * 
     * @param szCdIncmgFacilState the value of field
     * 'szCdIncmgFacilState'.
     */
    public void setSzCdIncmgFacilState(java.lang.String szCdIncmgFacilState)
    {
        this._szCdIncmgFacilState = szCdIncmgFacilState;
    } //-- void setSzCdIncmgFacilState(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgFacilType'.
     * 
     * @param szCdIncmgFacilType the value of field
     * 'szCdIncmgFacilType'.
     */
    public void setSzCdIncmgFacilType(java.lang.String szCdIncmgFacilType)
    {
        this._szCdIncmgFacilType = szCdIncmgFacilType;
    } //-- void setSzCdIncmgFacilType(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcType'.
     * 
     * @param szCdRsrcType the value of field 'szCdRsrcType'.
     */
    public void setSzCdRsrcType(java.lang.String szCdRsrcType)
    {
        this._szCdRsrcType = szCdRsrcType;
    } //-- void setSzCdRsrcType(java.lang.String) 

    /**
     * Sets the value of field 'szNbrIncmgFacilPhone'.
     * 
     * @param szNbrIncmgFacilPhone the value of field
     * 'szNbrIncmgFacilPhone'.
     */
    public void setSzNbrIncmgFacilPhone(java.lang.String szNbrIncmgFacilPhone)
    {
        this._szNbrIncmgFacilPhone = szNbrIncmgFacilPhone;
    } //-- void setSzNbrIncmgFacilPhone(java.lang.String) 

    /**
     * Sets the value of field 'szNbrIncmgFacilPhoneExt'.
     * 
     * @param szNbrIncmgFacilPhoneExt the value of field
     * 'szNbrIncmgFacilPhoneExt'.
     */
    public void setSzNbrIncmgFacilPhoneExt(java.lang.String szNbrIncmgFacilPhoneExt)
    {
        this._szNbrIncmgFacilPhoneExt = szNbrIncmgFacilPhoneExt;
    } //-- void setSzNbrIncmgFacilPhoneExt(java.lang.String) 

    /**
     * Sets the value of field 'szNmIncmgFacilAffiliated'.
     * 
     * @param szNmIncmgFacilAffiliated the value of field
     * 'szNmIncmgFacilAffiliated'.
     */
    public void setSzNmIncmgFacilAffiliated(java.lang.String szNmIncmgFacilAffiliated)
    {
        this._szNmIncmgFacilAffiliated = szNmIncmgFacilAffiliated;
    } //-- void setSzNmIncmgFacilAffiliated(java.lang.String) 

    /**
     * Sets the value of field 'szNmIncmgFacilSuprtdant'.
     * 
     * @param szNmIncmgFacilSuprtdant the value of field
     * 'szNmIncmgFacilSuprtdant'.
     */
    public void setSzNmIncmgFacilSuprtdant(java.lang.String szNmIncmgFacilSuprtdant)
    {
        this._szNmIncmgFacilSuprtdant = szNmIncmgFacilSuprtdant;
    } //-- void setSzNmIncmgFacilSuprtdant(java.lang.String) 

    /**
     * Sets the value of field 'szNmUnitWard'.
     * 
     * @param szNmUnitWard the value of field 'szNmUnitWard'.
     */
    public void setSzNmUnitWard(java.lang.String szNmUnitWard)
    {
        this._szNmUnitWard = szNmUnitWard;
    } //-- void setSzNmUnitWard(java.lang.String) 

    /**
     * Sets the value of field 'szTxtFacilCmnts'.
     * 
     * @param szTxtFacilCmnts the value of field 'szTxtFacilCmnts'.
     */
    public void setSzTxtFacilCmnts(java.lang.String szTxtFacilCmnts)
    {
        this._szTxtFacilCmnts = szTxtFacilCmnts;
    } //-- void setSzTxtFacilCmnts(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.FacDetailEntStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.FacDetailEntStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.FacDetailEntStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.FacDetailEntStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.FacDetailEntStruct unmarshal(java.io.Reader) 

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
