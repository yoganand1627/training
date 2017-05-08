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
 * Class CINV07SOG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV07SOG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdFacilInjuryBody
     */
    private java.lang.String _szCdFacilInjuryBody;

    /**
     * Field _dtFacilInjuryDtrmntn
     */
    private org.exolab.castor.types.Date _dtFacilInjuryDtrmntn;

    /**
     * Field _szCdFacilInjuryCause
     */
    private java.lang.String _szCdFacilInjuryCause;

    /**
     * Field _szCdFacilInjurySide
     */
    private java.lang.String _szCdFacilInjurySide;

    /**
     * Field _szCdFacilInjuryType
     */
    private java.lang.String _szCdFacilInjuryType;

    /**
     * Field _szTxtFacilInjuryCmnts
     */
    private java.lang.String _szTxtFacilInjuryCmnts;

    /**
     * Field _ulIdFacilityInjury
     */
    private int _ulIdFacilityInjury;

    /**
     * keeps track of state for field: _ulIdFacilityInjury
     */
    private boolean _has_ulIdFacilityInjury;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV07SOG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG01()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdFacilityInjury()
    {
        this._has_ulIdFacilityInjury= false;
    } //-- void deleteUlIdFacilityInjury() 

    /**
     * Returns the value of field 'dtFacilInjuryDtrmntn'.
     * 
     * @return the value of field 'DtFacilInjuryDtrmntn'.
     */
    public org.exolab.castor.types.Date getDtFacilInjuryDtrmntn()
    {
        return this._dtFacilInjuryDtrmntn;
    } //-- org.exolab.castor.types.Date getDtFacilInjuryDtrmntn() 

    /**
     * Returns the value of field 'szCdFacilInjuryBody'.
     * 
     * @return the value of field 'SzCdFacilInjuryBody'.
     */
    public java.lang.String getSzCdFacilInjuryBody()
    {
        return this._szCdFacilInjuryBody;
    } //-- java.lang.String getSzCdFacilInjuryBody() 

    /**
     * Returns the value of field 'szCdFacilInjuryCause'.
     * 
     * @return the value of field 'SzCdFacilInjuryCause'.
     */
    public java.lang.String getSzCdFacilInjuryCause()
    {
        return this._szCdFacilInjuryCause;
    } //-- java.lang.String getSzCdFacilInjuryCause() 

    /**
     * Returns the value of field 'szCdFacilInjurySide'.
     * 
     * @return the value of field 'SzCdFacilInjurySide'.
     */
    public java.lang.String getSzCdFacilInjurySide()
    {
        return this._szCdFacilInjurySide;
    } //-- java.lang.String getSzCdFacilInjurySide() 

    /**
     * Returns the value of field 'szCdFacilInjuryType'.
     * 
     * @return the value of field 'SzCdFacilInjuryType'.
     */
    public java.lang.String getSzCdFacilInjuryType()
    {
        return this._szCdFacilInjuryType;
    } //-- java.lang.String getSzCdFacilInjuryType() 

    /**
     * Returns the value of field 'szTxtFacilInjuryCmnts'.
     * 
     * @return the value of field 'SzTxtFacilInjuryCmnts'.
     */
    public java.lang.String getSzTxtFacilInjuryCmnts()
    {
        return this._szTxtFacilInjuryCmnts;
    } //-- java.lang.String getSzTxtFacilInjuryCmnts() 

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
     * Returns the value of field 'ulIdFacilityInjury'.
     * 
     * @return the value of field 'UlIdFacilityInjury'.
     */
    public int getUlIdFacilityInjury()
    {
        return this._ulIdFacilityInjury;
    } //-- int getUlIdFacilityInjury() 

    /**
     * Method hasUlIdFacilityInjury
     * 
     * 
     * 
     * @return true if at least one UlIdFacilityInjury has been adde
     */
    public boolean hasUlIdFacilityInjury()
    {
        return this._has_ulIdFacilityInjury;
    } //-- boolean hasUlIdFacilityInjury() 

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
     * Sets the value of field 'dtFacilInjuryDtrmntn'.
     * 
     * @param dtFacilInjuryDtrmntn the value of field
     * 'dtFacilInjuryDtrmntn'.
     */
    public void setDtFacilInjuryDtrmntn(org.exolab.castor.types.Date dtFacilInjuryDtrmntn)
    {
        this._dtFacilInjuryDtrmntn = dtFacilInjuryDtrmntn;
    } //-- void setDtFacilInjuryDtrmntn(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdFacilInjuryBody'.
     * 
     * @param szCdFacilInjuryBody the value of field
     * 'szCdFacilInjuryBody'.
     */
    public void setSzCdFacilInjuryBody(java.lang.String szCdFacilInjuryBody)
    {
        this._szCdFacilInjuryBody = szCdFacilInjuryBody;
    } //-- void setSzCdFacilInjuryBody(java.lang.String) 

    /**
     * Sets the value of field 'szCdFacilInjuryCause'.
     * 
     * @param szCdFacilInjuryCause the value of field
     * 'szCdFacilInjuryCause'.
     */
    public void setSzCdFacilInjuryCause(java.lang.String szCdFacilInjuryCause)
    {
        this._szCdFacilInjuryCause = szCdFacilInjuryCause;
    } //-- void setSzCdFacilInjuryCause(java.lang.String) 

    /**
     * Sets the value of field 'szCdFacilInjurySide'.
     * 
     * @param szCdFacilInjurySide the value of field
     * 'szCdFacilInjurySide'.
     */
    public void setSzCdFacilInjurySide(java.lang.String szCdFacilInjurySide)
    {
        this._szCdFacilInjurySide = szCdFacilInjurySide;
    } //-- void setSzCdFacilInjurySide(java.lang.String) 

    /**
     * Sets the value of field 'szCdFacilInjuryType'.
     * 
     * @param szCdFacilInjuryType the value of field
     * 'szCdFacilInjuryType'.
     */
    public void setSzCdFacilInjuryType(java.lang.String szCdFacilInjuryType)
    {
        this._szCdFacilInjuryType = szCdFacilInjuryType;
    } //-- void setSzCdFacilInjuryType(java.lang.String) 

    /**
     * Sets the value of field 'szTxtFacilInjuryCmnts'.
     * 
     * @param szTxtFacilInjuryCmnts the value of field
     * 'szTxtFacilInjuryCmnts'.
     */
    public void setSzTxtFacilInjuryCmnts(java.lang.String szTxtFacilInjuryCmnts)
    {
        this._szTxtFacilInjuryCmnts = szTxtFacilInjuryCmnts;
    } //-- void setSzTxtFacilInjuryCmnts(java.lang.String) 

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
     * Sets the value of field 'ulIdFacilityInjury'.
     * 
     * @param ulIdFacilityInjury the value of field
     * 'ulIdFacilityInjury'.
     */
    public void setUlIdFacilityInjury(int ulIdFacilityInjury)
    {
        this._ulIdFacilityInjury = ulIdFacilityInjury;
        this._has_ulIdFacilityInjury = true;
    } //-- void setUlIdFacilityInjury(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG01 unmarshal(java.io.Reader) 

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
