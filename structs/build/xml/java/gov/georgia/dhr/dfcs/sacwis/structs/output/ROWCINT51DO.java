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
 * Class ROWCINT51DO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINT51DO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ulIdIncmgPerson
     */
    private int _ulIdIncmgPerson;

    /**
     * keeps track of state for field: _ulIdIncmgPerson
     */
    private boolean _has_ulIdIncmgPerson;

    /**
     * Field _usNbrIncmgPersAge
     */
    private int _usNbrIncmgPersAge;

    /**
     * keeps track of state for field: _usNbrIncmgPersAge
     */
    private boolean _has_usNbrIncmgPersAge;

    /**
     * Field _dtDtIncmgPersDeath
     */
    private org.exolab.castor.types.Date _dtDtIncmgPersDeath;

    /**
     * Field _dtDtIncmgPersBirth
     */
    private org.exolab.castor.types.Date _dtDtIncmgPersBirth;

    /**
     * Field _cIndPersonDobApprox
     */
    private java.lang.String _cIndPersonDobApprox;

    /**
     * Field _szCdIncmgPersDeath
     */
    private java.lang.String _szCdIncmgPersDeath;

    /**
     * Field _szCdIncmgPersMaritlStat
     */
    private java.lang.String _szCdIncmgPersMaritlStat;

    /**
     * Field _szCdIncmgPersLanguage
     */
    private java.lang.String _szCdIncmgPersLanguage;

    /**
     * Field _szCdIncmgPersSex
     */
    private java.lang.String _szCdIncmgPersSex;

    /**
     * Field _szNmIncmgPersFull
     */
    private java.lang.String _szNmIncmgPersFull;

    /**
     * Field _szCdIncmgPersEthnic
     */
    private java.lang.String _szCdIncmgPersEthnic;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINT51DO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT51DO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdIncmgPerson()
    {
        this._has_ulIdIncmgPerson= false;
    } //-- void deleteUlIdIncmgPerson() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     */
    public void deleteUsNbrIncmgPersAge()
    {
        this._has_usNbrIncmgPersAge= false;
    } //-- void deleteUsNbrIncmgPersAge() 

    /**
     * Returns the value of field 'cIndPersonDobApprox'.
     * 
     * @return the value of field 'CIndPersonDobApprox'.
     */
    public java.lang.String getCIndPersonDobApprox()
    {
        return this._cIndPersonDobApprox;
    } //-- java.lang.String getCIndPersonDobApprox() 

    /**
     * Returns the value of field 'dtDtIncmgPersBirth'.
     * 
     * @return the value of field 'DtDtIncmgPersBirth'.
     */
    public org.exolab.castor.types.Date getDtDtIncmgPersBirth()
    {
        return this._dtDtIncmgPersBirth;
    } //-- org.exolab.castor.types.Date getDtDtIncmgPersBirth() 

    /**
     * Returns the value of field 'dtDtIncmgPersDeath'.
     * 
     * @return the value of field 'DtDtIncmgPersDeath'.
     */
    public org.exolab.castor.types.Date getDtDtIncmgPersDeath()
    {
        return this._dtDtIncmgPersDeath;
    } //-- org.exolab.castor.types.Date getDtDtIncmgPersDeath() 

    /**
     * Returns the value of field 'szCdIncmgPersDeath'.
     * 
     * @return the value of field 'SzCdIncmgPersDeath'.
     */
    public java.lang.String getSzCdIncmgPersDeath()
    {
        return this._szCdIncmgPersDeath;
    } //-- java.lang.String getSzCdIncmgPersDeath() 

    /**
     * Returns the value of field 'szCdIncmgPersEthnic'.
     * 
     * @return the value of field 'SzCdIncmgPersEthnic'.
     */
    public java.lang.String getSzCdIncmgPersEthnic()
    {
        return this._szCdIncmgPersEthnic;
    } //-- java.lang.String getSzCdIncmgPersEthnic() 

    /**
     * Returns the value of field 'szCdIncmgPersLanguage'.
     * 
     * @return the value of field 'SzCdIncmgPersLanguage'.
     */
    public java.lang.String getSzCdIncmgPersLanguage()
    {
        return this._szCdIncmgPersLanguage;
    } //-- java.lang.String getSzCdIncmgPersLanguage() 

    /**
     * Returns the value of field 'szCdIncmgPersMaritlStat'.
     * 
     * @return the value of field 'SzCdIncmgPersMaritlStat'.
     */
    public java.lang.String getSzCdIncmgPersMaritlStat()
    {
        return this._szCdIncmgPersMaritlStat;
    } //-- java.lang.String getSzCdIncmgPersMaritlStat() 

    /**
     * Returns the value of field 'szCdIncmgPersSex'.
     * 
     * @return the value of field 'SzCdIncmgPersSex'.
     */
    public java.lang.String getSzCdIncmgPersSex()
    {
        return this._szCdIncmgPersSex;
    } //-- java.lang.String getSzCdIncmgPersSex() 

    /**
     * Returns the value of field 'szNmIncmgPersFull'.
     * 
     * @return the value of field 'SzNmIncmgPersFull'.
     */
    public java.lang.String getSzNmIncmgPersFull()
    {
        return this._szNmIncmgPersFull;
    } //-- java.lang.String getSzNmIncmgPersFull() 

    /**
     * Returns the value of field 'ulIdIncmgPerson'.
     * 
     * @return the value of field 'UlIdIncmgPerson'.
     */
    public int getUlIdIncmgPerson()
    {
        return this._ulIdIncmgPerson;
    } //-- int getUlIdIncmgPerson() 

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
     * Returns the value of field 'ulIdStage'.
     * 
     * @return the value of field 'UlIdStage'.
     */
    public int getUlIdStage()
    {
        return this._ulIdStage;
    } //-- int getUlIdStage() 

    /**
     * Returns the value of field 'usNbrIncmgPersAge'.
     * 
     * @return the value of field 'UsNbrIncmgPersAge'.
     */
    public int getUsNbrIncmgPersAge()
    {
        return this._usNbrIncmgPersAge;
    } //-- int getUsNbrIncmgPersAge() 

    /**
     * Method hasUlIdIncmgPerson
     * 
     * 
     * 
     * @return true if at least one UlIdIncmgPerson has been added
     */
    public boolean hasUlIdIncmgPerson()
    {
        return this._has_ulIdIncmgPerson;
    } //-- boolean hasUlIdIncmgPerson() 

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
     * Method hasUsNbrIncmgPersAge
     * 
     * 
     * 
     * @return true if at least one UsNbrIncmgPersAge has been added
     */
    public boolean hasUsNbrIncmgPersAge()
    {
        return this._has_usNbrIncmgPersAge;
    } //-- boolean hasUsNbrIncmgPersAge() 

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
     * Sets the value of field 'cIndPersonDobApprox'.
     * 
     * @param cIndPersonDobApprox the value of field
     * 'cIndPersonDobApprox'.
     */
    public void setCIndPersonDobApprox(java.lang.String cIndPersonDobApprox)
    {
        this._cIndPersonDobApprox = cIndPersonDobApprox;
    } //-- void setCIndPersonDobApprox(java.lang.String) 

    /**
     * Sets the value of field 'dtDtIncmgPersBirth'.
     * 
     * @param dtDtIncmgPersBirth the value of field
     * 'dtDtIncmgPersBirth'.
     */
    public void setDtDtIncmgPersBirth(org.exolab.castor.types.Date dtDtIncmgPersBirth)
    {
        this._dtDtIncmgPersBirth = dtDtIncmgPersBirth;
    } //-- void setDtDtIncmgPersBirth(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtIncmgPersDeath'.
     * 
     * @param dtDtIncmgPersDeath the value of field
     * 'dtDtIncmgPersDeath'.
     */
    public void setDtDtIncmgPersDeath(org.exolab.castor.types.Date dtDtIncmgPersDeath)
    {
        this._dtDtIncmgPersDeath = dtDtIncmgPersDeath;
    } //-- void setDtDtIncmgPersDeath(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdIncmgPersDeath'.
     * 
     * @param szCdIncmgPersDeath the value of field
     * 'szCdIncmgPersDeath'.
     */
    public void setSzCdIncmgPersDeath(java.lang.String szCdIncmgPersDeath)
    {
        this._szCdIncmgPersDeath = szCdIncmgPersDeath;
    } //-- void setSzCdIncmgPersDeath(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgPersEthnic'.
     * 
     * @param szCdIncmgPersEthnic the value of field
     * 'szCdIncmgPersEthnic'.
     */
    public void setSzCdIncmgPersEthnic(java.lang.String szCdIncmgPersEthnic)
    {
        this._szCdIncmgPersEthnic = szCdIncmgPersEthnic;
    } //-- void setSzCdIncmgPersEthnic(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgPersLanguage'.
     * 
     * @param szCdIncmgPersLanguage the value of field
     * 'szCdIncmgPersLanguage'.
     */
    public void setSzCdIncmgPersLanguage(java.lang.String szCdIncmgPersLanguage)
    {
        this._szCdIncmgPersLanguage = szCdIncmgPersLanguage;
    } //-- void setSzCdIncmgPersLanguage(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgPersMaritlStat'.
     * 
     * @param szCdIncmgPersMaritlStat the value of field
     * 'szCdIncmgPersMaritlStat'.
     */
    public void setSzCdIncmgPersMaritlStat(java.lang.String szCdIncmgPersMaritlStat)
    {
        this._szCdIncmgPersMaritlStat = szCdIncmgPersMaritlStat;
    } //-- void setSzCdIncmgPersMaritlStat(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgPersSex'.
     * 
     * @param szCdIncmgPersSex the value of field 'szCdIncmgPersSex'
     */
    public void setSzCdIncmgPersSex(java.lang.String szCdIncmgPersSex)
    {
        this._szCdIncmgPersSex = szCdIncmgPersSex;
    } //-- void setSzCdIncmgPersSex(java.lang.String) 

    /**
     * Sets the value of field 'szNmIncmgPersFull'.
     * 
     * @param szNmIncmgPersFull the value of field
     * 'szNmIncmgPersFull'.
     */
    public void setSzNmIncmgPersFull(java.lang.String szNmIncmgPersFull)
    {
        this._szNmIncmgPersFull = szNmIncmgPersFull;
    } //-- void setSzNmIncmgPersFull(java.lang.String) 

    /**
     * Sets the value of field 'ulIdIncmgPerson'.
     * 
     * @param ulIdIncmgPerson the value of field 'ulIdIncmgPerson'.
     */
    public void setUlIdIncmgPerson(int ulIdIncmgPerson)
    {
        this._ulIdIncmgPerson = ulIdIncmgPerson;
        this._has_ulIdIncmgPerson = true;
    } //-- void setUlIdIncmgPerson(int) 

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
     * Sets the value of field 'usNbrIncmgPersAge'.
     * 
     * @param usNbrIncmgPersAge the value of field
     * 'usNbrIncmgPersAge'.
     */
    public void setUsNbrIncmgPersAge(int usNbrIncmgPersAge)
    {
        this._usNbrIncmgPersAge = usNbrIncmgPersAge;
        this._has_usNbrIncmgPersAge = true;
    } //-- void setUsNbrIncmgPersAge(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT51DO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT51DO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT51DO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT51DO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT51DO unmarshal(java.io.Reader) 

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
