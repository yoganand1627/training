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
 * Class CCFC38SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC38SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ldAmtPersonAnnualIncome
     */
    private double _ldAmtPersonAnnualIncome;

    /**
     * keeps track of state for field: _ldAmtPersonAnnualIncome
     */
    private boolean _has_ldAmtPersonAnnualIncome;

    /**
     * Field _szCdPersonBirthCity
     */
    private java.lang.String _szCdPersonBirthCity;

    /**
     * Field _szCdPersonBirthCountry
     */
    private java.lang.String _szCdPersonBirthCountry;

    /**
     * Field _szCdPersonBirthCounty
     */
    private java.lang.String _szCdPersonBirthCounty;

    /**
     * Field _szCdPersonBirthState
     */
    private java.lang.String _szCdPersonBirthState;

    /**
     * Field _szCdPersonCitizenship
     */
    private java.lang.String _szCdPersonCitizenship;

    /**
     * Field _szCdPersonEyeColor
     */
    private java.lang.String _szCdPersonEyeColor;

    /**
     * Field _szCdPersonFaHomeRole
     */
    private java.lang.String _szCdPersonFaHomeRole;

    /**
     * Field _szCdPersonHairColor
     */
    private java.lang.String _szCdPersonHairColor;

    /**
     * Field _szCdPersonHighestEduc
     */
    private java.lang.String _szCdPersonHighestEduc;

    /**
     * Field _cIndPersonNoUsBrn
     */
    private java.lang.String _cIndPersonNoUsBrn;

    /**
     * Field _szNmPersonLastEmployer
     */
    private java.lang.String _szNmPersonLastEmployer;

    /**
     * Field _szNmPersonMaidenName
     */
    private java.lang.String _szNmPersonMaidenName;

    /**
     * Field _sQtyPersonHeightFeet
     */
    private int _sQtyPersonHeightFeet;

    /**
     * keeps track of state for field: _sQtyPersonHeightFeet
     */
    private boolean _has_sQtyPersonHeightFeet;

    /**
     * Field _sQtyPersonHeightInches
     */
    private int _sQtyPersonHeightInches;

    /**
     * keeps track of state for field: _sQtyPersonHeightInches
     */
    private boolean _has_sQtyPersonHeightInches;

    /**
     * Field _lQtyPersonWeight
     */
    private int _lQtyPersonWeight;

    /**
     * keeps track of state for field: _lQtyPersonWeight
     */
    private boolean _has_lQtyPersonWeight;

    /**
     * Field _cCdRemovalMothrMarrd
     */
    private java.lang.String _cCdRemovalMothrMarrd;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC38SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC38SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLQtyPersonWeight()
    {
        this._has_lQtyPersonWeight= false;
    } //-- void deleteLQtyPersonWeight() 

    /**
     */
    public void deleteLdAmtPersonAnnualIncome()
    {
        this._has_ldAmtPersonAnnualIncome= false;
    } //-- void deleteLdAmtPersonAnnualIncome() 

    /**
     */
    public void deleteSQtyPersonHeightFeet()
    {
        this._has_sQtyPersonHeightFeet= false;
    } //-- void deleteSQtyPersonHeightFeet() 

    /**
     */
    public void deleteSQtyPersonHeightInches()
    {
        this._has_sQtyPersonHeightInches= false;
    } //-- void deleteSQtyPersonHeightInches() 

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
     * Returns the value of field 'cCdRemovalMothrMarrd'.
     * 
     * @return the value of field 'CCdRemovalMothrMarrd'.
     */
    public java.lang.String getCCdRemovalMothrMarrd()
    {
        return this._cCdRemovalMothrMarrd;
    } //-- java.lang.String getCCdRemovalMothrMarrd() 

    /**
     * Returns the value of field 'cIndPersonNoUsBrn'.
     * 
     * @return the value of field 'CIndPersonNoUsBrn'.
     */
    public java.lang.String getCIndPersonNoUsBrn()
    {
        return this._cIndPersonNoUsBrn;
    } //-- java.lang.String getCIndPersonNoUsBrn() 

    /**
     * Returns the value of field 'lQtyPersonWeight'.
     * 
     * @return the value of field 'LQtyPersonWeight'.
     */
    public int getLQtyPersonWeight()
    {
        return this._lQtyPersonWeight;
    } //-- int getLQtyPersonWeight() 

    /**
     * Returns the value of field 'ldAmtPersonAnnualIncome'.
     * 
     * @return the value of field 'LdAmtPersonAnnualIncome'.
     */
    public double getLdAmtPersonAnnualIncome()
    {
        return this._ldAmtPersonAnnualIncome;
    } //-- double getLdAmtPersonAnnualIncome() 

    /**
     * Returns the value of field 'sQtyPersonHeightFeet'.
     * 
     * @return the value of field 'SQtyPersonHeightFeet'.
     */
    public int getSQtyPersonHeightFeet()
    {
        return this._sQtyPersonHeightFeet;
    } //-- int getSQtyPersonHeightFeet() 

    /**
     * Returns the value of field 'sQtyPersonHeightInches'.
     * 
     * @return the value of field 'SQtyPersonHeightInches'.
     */
    public int getSQtyPersonHeightInches()
    {
        return this._sQtyPersonHeightInches;
    } //-- int getSQtyPersonHeightInches() 

    /**
     * Returns the value of field 'szCdPersonBirthCity'.
     * 
     * @return the value of field 'SzCdPersonBirthCity'.
     */
    public java.lang.String getSzCdPersonBirthCity()
    {
        return this._szCdPersonBirthCity;
    } //-- java.lang.String getSzCdPersonBirthCity() 

    /**
     * Returns the value of field 'szCdPersonBirthCountry'.
     * 
     * @return the value of field 'SzCdPersonBirthCountry'.
     */
    public java.lang.String getSzCdPersonBirthCountry()
    {
        return this._szCdPersonBirthCountry;
    } //-- java.lang.String getSzCdPersonBirthCountry() 

    /**
     * Returns the value of field 'szCdPersonBirthCounty'.
     * 
     * @return the value of field 'SzCdPersonBirthCounty'.
     */
    public java.lang.String getSzCdPersonBirthCounty()
    {
        return this._szCdPersonBirthCounty;
    } //-- java.lang.String getSzCdPersonBirthCounty() 

    /**
     * Returns the value of field 'szCdPersonBirthState'.
     * 
     * @return the value of field 'SzCdPersonBirthState'.
     */
    public java.lang.String getSzCdPersonBirthState()
    {
        return this._szCdPersonBirthState;
    } //-- java.lang.String getSzCdPersonBirthState() 

    /**
     * Returns the value of field 'szCdPersonCitizenship'.
     * 
     * @return the value of field 'SzCdPersonCitizenship'.
     */
    public java.lang.String getSzCdPersonCitizenship()
    {
        return this._szCdPersonCitizenship;
    } //-- java.lang.String getSzCdPersonCitizenship() 

    /**
     * Returns the value of field 'szCdPersonEyeColor'.
     * 
     * @return the value of field 'SzCdPersonEyeColor'.
     */
    public java.lang.String getSzCdPersonEyeColor()
    {
        return this._szCdPersonEyeColor;
    } //-- java.lang.String getSzCdPersonEyeColor() 

    /**
     * Returns the value of field 'szCdPersonFaHomeRole'.
     * 
     * @return the value of field 'SzCdPersonFaHomeRole'.
     */
    public java.lang.String getSzCdPersonFaHomeRole()
    {
        return this._szCdPersonFaHomeRole;
    } //-- java.lang.String getSzCdPersonFaHomeRole() 

    /**
     * Returns the value of field 'szCdPersonHairColor'.
     * 
     * @return the value of field 'SzCdPersonHairColor'.
     */
    public java.lang.String getSzCdPersonHairColor()
    {
        return this._szCdPersonHairColor;
    } //-- java.lang.String getSzCdPersonHairColor() 

    /**
     * Returns the value of field 'szCdPersonHighestEduc'.
     * 
     * @return the value of field 'SzCdPersonHighestEduc'.
     */
    public java.lang.String getSzCdPersonHighestEduc()
    {
        return this._szCdPersonHighestEduc;
    } //-- java.lang.String getSzCdPersonHighestEduc() 

    /**
     * Returns the value of field 'szNmPersonLastEmployer'.
     * 
     * @return the value of field 'SzNmPersonLastEmployer'.
     */
    public java.lang.String getSzNmPersonLastEmployer()
    {
        return this._szNmPersonLastEmployer;
    } //-- java.lang.String getSzNmPersonLastEmployer() 

    /**
     * Returns the value of field 'szNmPersonMaidenName'.
     * 
     * @return the value of field 'SzNmPersonMaidenName'.
     */
    public java.lang.String getSzNmPersonMaidenName()
    {
        return this._szNmPersonMaidenName;
    } //-- java.lang.String getSzNmPersonMaidenName() 

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
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Method hasLQtyPersonWeight
     * 
     * 
     * 
     * @return true if at least one LQtyPersonWeight has been added
     */
    public boolean hasLQtyPersonWeight()
    {
        return this._has_lQtyPersonWeight;
    } //-- boolean hasLQtyPersonWeight() 

    /**
     * Method hasLdAmtPersonAnnualIncome
     * 
     * 
     * 
     * @return true if at least one LdAmtPersonAnnualIncome has
     * been added
     */
    public boolean hasLdAmtPersonAnnualIncome()
    {
        return this._has_ldAmtPersonAnnualIncome;
    } //-- boolean hasLdAmtPersonAnnualIncome() 

    /**
     * Method hasSQtyPersonHeightFeet
     * 
     * 
     * 
     * @return true if at least one SQtyPersonHeightFeet has been
     * added
     */
    public boolean hasSQtyPersonHeightFeet()
    {
        return this._has_sQtyPersonHeightFeet;
    } //-- boolean hasSQtyPersonHeightFeet() 

    /**
     * Method hasSQtyPersonHeightInches
     * 
     * 
     * 
     * @return true if at least one SQtyPersonHeightInches has been
     * added
     */
    public boolean hasSQtyPersonHeightInches()
    {
        return this._has_sQtyPersonHeightInches;
    } //-- boolean hasSQtyPersonHeightInches() 

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
     * Sets the value of field 'cCdRemovalMothrMarrd'.
     * 
     * @param cCdRemovalMothrMarrd the value of field
     * 'cCdRemovalMothrMarrd'.
     */
    public void setCCdRemovalMothrMarrd(java.lang.String cCdRemovalMothrMarrd)
    {
        this._cCdRemovalMothrMarrd = cCdRemovalMothrMarrd;
    } //-- void setCCdRemovalMothrMarrd(java.lang.String) 

    /**
     * Sets the value of field 'cIndPersonNoUsBrn'.
     * 
     * @param cIndPersonNoUsBrn the value of field
     * 'cIndPersonNoUsBrn'.
     */
    public void setCIndPersonNoUsBrn(java.lang.String cIndPersonNoUsBrn)
    {
        this._cIndPersonNoUsBrn = cIndPersonNoUsBrn;
    } //-- void setCIndPersonNoUsBrn(java.lang.String) 

    /**
     * Sets the value of field 'lQtyPersonWeight'.
     * 
     * @param lQtyPersonWeight the value of field 'lQtyPersonWeight'
     */
    public void setLQtyPersonWeight(int lQtyPersonWeight)
    {
        this._lQtyPersonWeight = lQtyPersonWeight;
        this._has_lQtyPersonWeight = true;
    } //-- void setLQtyPersonWeight(int) 

    /**
     * Sets the value of field 'ldAmtPersonAnnualIncome'.
     * 
     * @param ldAmtPersonAnnualIncome the value of field
     * 'ldAmtPersonAnnualIncome'.
     */
    public void setLdAmtPersonAnnualIncome(double ldAmtPersonAnnualIncome)
    {
        this._ldAmtPersonAnnualIncome = ldAmtPersonAnnualIncome;
        this._has_ldAmtPersonAnnualIncome = true;
    } //-- void setLdAmtPersonAnnualIncome(double) 

    /**
     * Sets the value of field 'sQtyPersonHeightFeet'.
     * 
     * @param sQtyPersonHeightFeet the value of field
     * 'sQtyPersonHeightFeet'.
     */
    public void setSQtyPersonHeightFeet(int sQtyPersonHeightFeet)
    {
        this._sQtyPersonHeightFeet = sQtyPersonHeightFeet;
        this._has_sQtyPersonHeightFeet = true;
    } //-- void setSQtyPersonHeightFeet(int) 

    /**
     * Sets the value of field 'sQtyPersonHeightInches'.
     * 
     * @param sQtyPersonHeightInches the value of field
     * 'sQtyPersonHeightInches'.
     */
    public void setSQtyPersonHeightInches(int sQtyPersonHeightInches)
    {
        this._sQtyPersonHeightInches = sQtyPersonHeightInches;
        this._has_sQtyPersonHeightInches = true;
    } //-- void setSQtyPersonHeightInches(int) 

    /**
     * Sets the value of field 'szCdPersonBirthCity'.
     * 
     * @param szCdPersonBirthCity the value of field
     * 'szCdPersonBirthCity'.
     */
    public void setSzCdPersonBirthCity(java.lang.String szCdPersonBirthCity)
    {
        this._szCdPersonBirthCity = szCdPersonBirthCity;
    } //-- void setSzCdPersonBirthCity(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonBirthCountry'.
     * 
     * @param szCdPersonBirthCountry the value of field
     * 'szCdPersonBirthCountry'.
     */
    public void setSzCdPersonBirthCountry(java.lang.String szCdPersonBirthCountry)
    {
        this._szCdPersonBirthCountry = szCdPersonBirthCountry;
    } //-- void setSzCdPersonBirthCountry(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonBirthCounty'.
     * 
     * @param szCdPersonBirthCounty the value of field
     * 'szCdPersonBirthCounty'.
     */
    public void setSzCdPersonBirthCounty(java.lang.String szCdPersonBirthCounty)
    {
        this._szCdPersonBirthCounty = szCdPersonBirthCounty;
    } //-- void setSzCdPersonBirthCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonBirthState'.
     * 
     * @param szCdPersonBirthState the value of field
     * 'szCdPersonBirthState'.
     */
    public void setSzCdPersonBirthState(java.lang.String szCdPersonBirthState)
    {
        this._szCdPersonBirthState = szCdPersonBirthState;
    } //-- void setSzCdPersonBirthState(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonCitizenship'.
     * 
     * @param szCdPersonCitizenship the value of field
     * 'szCdPersonCitizenship'.
     */
    public void setSzCdPersonCitizenship(java.lang.String szCdPersonCitizenship)
    {
        this._szCdPersonCitizenship = szCdPersonCitizenship;
    } //-- void setSzCdPersonCitizenship(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonEyeColor'.
     * 
     * @param szCdPersonEyeColor the value of field
     * 'szCdPersonEyeColor'.
     */
    public void setSzCdPersonEyeColor(java.lang.String szCdPersonEyeColor)
    {
        this._szCdPersonEyeColor = szCdPersonEyeColor;
    } //-- void setSzCdPersonEyeColor(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonFaHomeRole'.
     * 
     * @param szCdPersonFaHomeRole the value of field
     * 'szCdPersonFaHomeRole'.
     */
    public void setSzCdPersonFaHomeRole(java.lang.String szCdPersonFaHomeRole)
    {
        this._szCdPersonFaHomeRole = szCdPersonFaHomeRole;
    } //-- void setSzCdPersonFaHomeRole(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonHairColor'.
     * 
     * @param szCdPersonHairColor the value of field
     * 'szCdPersonHairColor'.
     */
    public void setSzCdPersonHairColor(java.lang.String szCdPersonHairColor)
    {
        this._szCdPersonHairColor = szCdPersonHairColor;
    } //-- void setSzCdPersonHairColor(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonHighestEduc'.
     * 
     * @param szCdPersonHighestEduc the value of field
     * 'szCdPersonHighestEduc'.
     */
    public void setSzCdPersonHighestEduc(java.lang.String szCdPersonHighestEduc)
    {
        this._szCdPersonHighestEduc = szCdPersonHighestEduc;
    } //-- void setSzCdPersonHighestEduc(java.lang.String) 

    /**
     * Sets the value of field 'szNmPersonLastEmployer'.
     * 
     * @param szNmPersonLastEmployer the value of field
     * 'szNmPersonLastEmployer'.
     */
    public void setSzNmPersonLastEmployer(java.lang.String szNmPersonLastEmployer)
    {
        this._szNmPersonLastEmployer = szNmPersonLastEmployer;
    } //-- void setSzNmPersonLastEmployer(java.lang.String) 

    /**
     * Sets the value of field 'szNmPersonMaidenName'.
     * 
     * @param szNmPersonMaidenName the value of field
     * 'szNmPersonMaidenName'.
     */
    public void setSzNmPersonMaidenName(java.lang.String szNmPersonMaidenName)
    {
        this._szNmPersonMaidenName = szNmPersonMaidenName;
    } //-- void setSzNmPersonMaidenName(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC38SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC38SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC38SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC38SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC38SI unmarshal(java.io.Reader) 

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
