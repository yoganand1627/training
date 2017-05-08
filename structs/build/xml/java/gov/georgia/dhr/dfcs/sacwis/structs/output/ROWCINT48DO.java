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
 * Class ROWCINT48DO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINT48DO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdIncomingAddress
     */
    private int _ulIdIncomingAddress;

    /**
     * keeps track of state for field: _ulIdIncomingAddress
     */
    private boolean _has_ulIdIncomingAddress;

    /**
     * Field _szAddrIncmgAddrAttn
     */
    private java.lang.String _szAddrIncmgAddrAttn;

    /**
     * Field _ulIdIncmgPerson
     */
    private int _ulIdIncmgPerson;

    /**
     * keeps track of state for field: _ulIdIncmgPerson
     */
    private boolean _has_ulIdIncmgPerson;

    /**
     * Field _szAddrIncmgAddrZip
     */
    private java.lang.String _szAddrIncmgAddrZip;

    /**
     * Field _szCdIncmgAddrState
     */
    private java.lang.String _szCdIncmgAddrState;

    /**
     * Field _szAddrIncmgAddrCity
     */
    private java.lang.String _szAddrIncmgAddrCity;

    /**
     * Field _dtDtIncmgAddrStart
     */
    private org.exolab.castor.types.Date _dtDtIncmgAddrStart;

    /**
     * Field _dtDtIncmgAddrEnd
     */
    private org.exolab.castor.types.Date _dtDtIncmgAddrEnd;

    /**
     * Field _cIndIncmgAddrInvalid
     */
    private java.lang.String _cIndIncmgAddrInvalid;

    /**
     * Field _szAddrIncmgAddrStLn1
     */
    private java.lang.String _szAddrIncmgAddrStLn1;

    /**
     * Field _szAddrIncmgAddrStLn2
     */
    private java.lang.String _szAddrIncmgAddrStLn2;

    /**
     * Field _szCdIncmgAddrCounty
     */
    private java.lang.String _szCdIncmgAddrCounty;

    /**
     * Field _szTxtIncmgAddrComments
     */
    private java.lang.String _szTxtIncmgAddrComments;

    /**
     * Field _szCdIncmgAddrType
     */
    private java.lang.String _szCdIncmgAddrType;

    /**
     * Field _cIndIncmgAddrPrimary
     */
    private java.lang.String _cIndIncmgAddrPrimary;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINT48DO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO()


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
    public void deleteUlIdIncomingAddress()
    {
        this._has_ulIdIncomingAddress= false;
    } //-- void deleteUlIdIncomingAddress() 

    /**
     * Returns the value of field 'cIndIncmgAddrInvalid'.
     * 
     * @return the value of field 'CIndIncmgAddrInvalid'.
     */
    public java.lang.String getCIndIncmgAddrInvalid()
    {
        return this._cIndIncmgAddrInvalid;
    } //-- java.lang.String getCIndIncmgAddrInvalid() 

    /**
     * Returns the value of field 'cIndIncmgAddrPrimary'.
     * 
     * @return the value of field 'CIndIncmgAddrPrimary'.
     */
    public java.lang.String getCIndIncmgAddrPrimary()
    {
        return this._cIndIncmgAddrPrimary;
    } //-- java.lang.String getCIndIncmgAddrPrimary() 

    /**
     * Returns the value of field 'dtDtIncmgAddrEnd'.
     * 
     * @return the value of field 'DtDtIncmgAddrEnd'.
     */
    public org.exolab.castor.types.Date getDtDtIncmgAddrEnd()
    {
        return this._dtDtIncmgAddrEnd;
    } //-- org.exolab.castor.types.Date getDtDtIncmgAddrEnd() 

    /**
     * Returns the value of field 'dtDtIncmgAddrStart'.
     * 
     * @return the value of field 'DtDtIncmgAddrStart'.
     */
    public org.exolab.castor.types.Date getDtDtIncmgAddrStart()
    {
        return this._dtDtIncmgAddrStart;
    } //-- org.exolab.castor.types.Date getDtDtIncmgAddrStart() 

    /**
     * Returns the value of field 'szAddrIncmgAddrAttn'.
     * 
     * @return the value of field 'SzAddrIncmgAddrAttn'.
     */
    public java.lang.String getSzAddrIncmgAddrAttn()
    {
        return this._szAddrIncmgAddrAttn;
    } //-- java.lang.String getSzAddrIncmgAddrAttn() 

    /**
     * Returns the value of field 'szAddrIncmgAddrCity'.
     * 
     * @return the value of field 'SzAddrIncmgAddrCity'.
     */
    public java.lang.String getSzAddrIncmgAddrCity()
    {
        return this._szAddrIncmgAddrCity;
    } //-- java.lang.String getSzAddrIncmgAddrCity() 

    /**
     * Returns the value of field 'szAddrIncmgAddrStLn1'.
     * 
     * @return the value of field 'SzAddrIncmgAddrStLn1'.
     */
    public java.lang.String getSzAddrIncmgAddrStLn1()
    {
        return this._szAddrIncmgAddrStLn1;
    } //-- java.lang.String getSzAddrIncmgAddrStLn1() 

    /**
     * Returns the value of field 'szAddrIncmgAddrStLn2'.
     * 
     * @return the value of field 'SzAddrIncmgAddrStLn2'.
     */
    public java.lang.String getSzAddrIncmgAddrStLn2()
    {
        return this._szAddrIncmgAddrStLn2;
    } //-- java.lang.String getSzAddrIncmgAddrStLn2() 

    /**
     * Returns the value of field 'szAddrIncmgAddrZip'.
     * 
     * @return the value of field 'SzAddrIncmgAddrZip'.
     */
    public java.lang.String getSzAddrIncmgAddrZip()
    {
        return this._szAddrIncmgAddrZip;
    } //-- java.lang.String getSzAddrIncmgAddrZip() 

    /**
     * Returns the value of field 'szCdIncmgAddrCounty'.
     * 
     * @return the value of field 'SzCdIncmgAddrCounty'.
     */
    public java.lang.String getSzCdIncmgAddrCounty()
    {
        return this._szCdIncmgAddrCounty;
    } //-- java.lang.String getSzCdIncmgAddrCounty() 

    /**
     * Returns the value of field 'szCdIncmgAddrState'.
     * 
     * @return the value of field 'SzCdIncmgAddrState'.
     */
    public java.lang.String getSzCdIncmgAddrState()
    {
        return this._szCdIncmgAddrState;
    } //-- java.lang.String getSzCdIncmgAddrState() 

    /**
     * Returns the value of field 'szCdIncmgAddrType'.
     * 
     * @return the value of field 'SzCdIncmgAddrType'.
     */
    public java.lang.String getSzCdIncmgAddrType()
    {
        return this._szCdIncmgAddrType;
    } //-- java.lang.String getSzCdIncmgAddrType() 

    /**
     * Returns the value of field 'szTxtIncmgAddrComments'.
     * 
     * @return the value of field 'SzTxtIncmgAddrComments'.
     */
    public java.lang.String getSzTxtIncmgAddrComments()
    {
        return this._szTxtIncmgAddrComments;
    } //-- java.lang.String getSzTxtIncmgAddrComments() 

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
     * Returns the value of field 'ulIdIncomingAddress'.
     * 
     * @return the value of field 'UlIdIncomingAddress'.
     */
    public int getUlIdIncomingAddress()
    {
        return this._ulIdIncomingAddress;
    } //-- int getUlIdIncomingAddress() 

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
     * Method hasUlIdIncomingAddress
     * 
     * 
     * 
     * @return true if at least one UlIdIncomingAddress has been
     * added
     */
    public boolean hasUlIdIncomingAddress()
    {
        return this._has_ulIdIncomingAddress;
    } //-- boolean hasUlIdIncomingAddress() 

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
     * Sets the value of field 'cIndIncmgAddrInvalid'.
     * 
     * @param cIndIncmgAddrInvalid the value of field
     * 'cIndIncmgAddrInvalid'.
     */
    public void setCIndIncmgAddrInvalid(java.lang.String cIndIncmgAddrInvalid)
    {
        this._cIndIncmgAddrInvalid = cIndIncmgAddrInvalid;
    } //-- void setCIndIncmgAddrInvalid(java.lang.String) 

    /**
     * Sets the value of field 'cIndIncmgAddrPrimary'.
     * 
     * @param cIndIncmgAddrPrimary the value of field
     * 'cIndIncmgAddrPrimary'.
     */
    public void setCIndIncmgAddrPrimary(java.lang.String cIndIncmgAddrPrimary)
    {
        this._cIndIncmgAddrPrimary = cIndIncmgAddrPrimary;
    } //-- void setCIndIncmgAddrPrimary(java.lang.String) 

    /**
     * Sets the value of field 'dtDtIncmgAddrEnd'.
     * 
     * @param dtDtIncmgAddrEnd the value of field 'dtDtIncmgAddrEnd'
     */
    public void setDtDtIncmgAddrEnd(org.exolab.castor.types.Date dtDtIncmgAddrEnd)
    {
        this._dtDtIncmgAddrEnd = dtDtIncmgAddrEnd;
    } //-- void setDtDtIncmgAddrEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtIncmgAddrStart'.
     * 
     * @param dtDtIncmgAddrStart the value of field
     * 'dtDtIncmgAddrStart'.
     */
    public void setDtDtIncmgAddrStart(org.exolab.castor.types.Date dtDtIncmgAddrStart)
    {
        this._dtDtIncmgAddrStart = dtDtIncmgAddrStart;
    } //-- void setDtDtIncmgAddrStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szAddrIncmgAddrAttn'.
     * 
     * @param szAddrIncmgAddrAttn the value of field
     * 'szAddrIncmgAddrAttn'.
     */
    public void setSzAddrIncmgAddrAttn(java.lang.String szAddrIncmgAddrAttn)
    {
        this._szAddrIncmgAddrAttn = szAddrIncmgAddrAttn;
    } //-- void setSzAddrIncmgAddrAttn(java.lang.String) 

    /**
     * Sets the value of field 'szAddrIncmgAddrCity'.
     * 
     * @param szAddrIncmgAddrCity the value of field
     * 'szAddrIncmgAddrCity'.
     */
    public void setSzAddrIncmgAddrCity(java.lang.String szAddrIncmgAddrCity)
    {
        this._szAddrIncmgAddrCity = szAddrIncmgAddrCity;
    } //-- void setSzAddrIncmgAddrCity(java.lang.String) 

    /**
     * Sets the value of field 'szAddrIncmgAddrStLn1'.
     * 
     * @param szAddrIncmgAddrStLn1 the value of field
     * 'szAddrIncmgAddrStLn1'.
     */
    public void setSzAddrIncmgAddrStLn1(java.lang.String szAddrIncmgAddrStLn1)
    {
        this._szAddrIncmgAddrStLn1 = szAddrIncmgAddrStLn1;
    } //-- void setSzAddrIncmgAddrStLn1(java.lang.String) 

    /**
     * Sets the value of field 'szAddrIncmgAddrStLn2'.
     * 
     * @param szAddrIncmgAddrStLn2 the value of field
     * 'szAddrIncmgAddrStLn2'.
     */
    public void setSzAddrIncmgAddrStLn2(java.lang.String szAddrIncmgAddrStLn2)
    {
        this._szAddrIncmgAddrStLn2 = szAddrIncmgAddrStLn2;
    } //-- void setSzAddrIncmgAddrStLn2(java.lang.String) 

    /**
     * Sets the value of field 'szAddrIncmgAddrZip'.
     * 
     * @param szAddrIncmgAddrZip the value of field
     * 'szAddrIncmgAddrZip'.
     */
    public void setSzAddrIncmgAddrZip(java.lang.String szAddrIncmgAddrZip)
    {
        this._szAddrIncmgAddrZip = szAddrIncmgAddrZip;
    } //-- void setSzAddrIncmgAddrZip(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgAddrCounty'.
     * 
     * @param szCdIncmgAddrCounty the value of field
     * 'szCdIncmgAddrCounty'.
     */
    public void setSzCdIncmgAddrCounty(java.lang.String szCdIncmgAddrCounty)
    {
        this._szCdIncmgAddrCounty = szCdIncmgAddrCounty;
    } //-- void setSzCdIncmgAddrCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgAddrState'.
     * 
     * @param szCdIncmgAddrState the value of field
     * 'szCdIncmgAddrState'.
     */
    public void setSzCdIncmgAddrState(java.lang.String szCdIncmgAddrState)
    {
        this._szCdIncmgAddrState = szCdIncmgAddrState;
    } //-- void setSzCdIncmgAddrState(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgAddrType'.
     * 
     * @param szCdIncmgAddrType the value of field
     * 'szCdIncmgAddrType'.
     */
    public void setSzCdIncmgAddrType(java.lang.String szCdIncmgAddrType)
    {
        this._szCdIncmgAddrType = szCdIncmgAddrType;
    } //-- void setSzCdIncmgAddrType(java.lang.String) 

    /**
     * Sets the value of field 'szTxtIncmgAddrComments'.
     * 
     * @param szTxtIncmgAddrComments the value of field
     * 'szTxtIncmgAddrComments'.
     */
    public void setSzTxtIncmgAddrComments(java.lang.String szTxtIncmgAddrComments)
    {
        this._szTxtIncmgAddrComments = szTxtIncmgAddrComments;
    } //-- void setSzTxtIncmgAddrComments(java.lang.String) 

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
     * Sets the value of field 'ulIdIncomingAddress'.
     * 
     * @param ulIdIncomingAddress the value of field
     * 'ulIdIncomingAddress'.
     */
    public void setUlIdIncomingAddress(int ulIdIncomingAddress)
    {
        this._ulIdIncomingAddress = ulIdIncomingAddress;
        this._has_ulIdIncomingAddress = true;
    } //-- void setUlIdIncomingAddress(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO unmarshal(java.io.Reader) 

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
