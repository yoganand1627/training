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
 * Class ROWCINT49DO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINT49DO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdIncomingName
     */
    private int _ulIdIncomingName;

    /**
     * keeps track of state for field: _ulIdIncomingName
     */
    private boolean _has_ulIdIncomingName;

    /**
     * Field _ulIdIncmgPerson
     */
    private int _ulIdIncmgPerson;

    /**
     * keeps track of state for field: _ulIdIncmgPerson
     */
    private boolean _has_ulIdIncmgPerson;

    /**
     * Field _szNmIncmgNameFirst
     */
    private java.lang.String _szNmIncmgNameFirst;

    /**
     * Field _szNmIncmgNameMiddle
     */
    private java.lang.String _szNmIncmgNameMiddle;

    /**
     * Field _szNmIncmgNameLast
     */
    private java.lang.String _szNmIncmgNameLast;

    /**
     * Field _cIndIncmgNameInvalid
     */
    private java.lang.String _cIndIncmgNameInvalid;

    /**
     * Field _cIndIncmgNamePrimary
     */
    private java.lang.String _cIndIncmgNamePrimary;

    /**
     * Field _szCdIncmgNameSuffix
     */
    private java.lang.String _szCdIncmgNameSuffix;

    /**
     * Field _dtDtIncmgNameStart
     */
    private org.exolab.castor.types.Date _dtDtIncmgNameStart;

    /**
     * Field _dtDtIncmgNameEnd
     */
    private org.exolab.castor.types.Date _dtDtIncmgNameEnd;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINT49DO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO()


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
    public void deleteUlIdIncomingName()
    {
        this._has_ulIdIncomingName= false;
    } //-- void deleteUlIdIncomingName() 

    /**
     * Returns the value of field 'cIndIncmgNameInvalid'.
     * 
     * @return the value of field 'CIndIncmgNameInvalid'.
     */
    public java.lang.String getCIndIncmgNameInvalid()
    {
        return this._cIndIncmgNameInvalid;
    } //-- java.lang.String getCIndIncmgNameInvalid() 

    /**
     * Returns the value of field 'cIndIncmgNamePrimary'.
     * 
     * @return the value of field 'CIndIncmgNamePrimary'.
     */
    public java.lang.String getCIndIncmgNamePrimary()
    {
        return this._cIndIncmgNamePrimary;
    } //-- java.lang.String getCIndIncmgNamePrimary() 

    /**
     * Returns the value of field 'dtDtIncmgNameEnd'.
     * 
     * @return the value of field 'DtDtIncmgNameEnd'.
     */
    public org.exolab.castor.types.Date getDtDtIncmgNameEnd()
    {
        return this._dtDtIncmgNameEnd;
    } //-- org.exolab.castor.types.Date getDtDtIncmgNameEnd() 

    /**
     * Returns the value of field 'dtDtIncmgNameStart'.
     * 
     * @return the value of field 'DtDtIncmgNameStart'.
     */
    public org.exolab.castor.types.Date getDtDtIncmgNameStart()
    {
        return this._dtDtIncmgNameStart;
    } //-- org.exolab.castor.types.Date getDtDtIncmgNameStart() 

    /**
     * Returns the value of field 'szCdIncmgNameSuffix'.
     * 
     * @return the value of field 'SzCdIncmgNameSuffix'.
     */
    public java.lang.String getSzCdIncmgNameSuffix()
    {
        return this._szCdIncmgNameSuffix;
    } //-- java.lang.String getSzCdIncmgNameSuffix() 

    /**
     * Returns the value of field 'szNmIncmgNameFirst'.
     * 
     * @return the value of field 'SzNmIncmgNameFirst'.
     */
    public java.lang.String getSzNmIncmgNameFirst()
    {
        return this._szNmIncmgNameFirst;
    } //-- java.lang.String getSzNmIncmgNameFirst() 

    /**
     * Returns the value of field 'szNmIncmgNameLast'.
     * 
     * @return the value of field 'SzNmIncmgNameLast'.
     */
    public java.lang.String getSzNmIncmgNameLast()
    {
        return this._szNmIncmgNameLast;
    } //-- java.lang.String getSzNmIncmgNameLast() 

    /**
     * Returns the value of field 'szNmIncmgNameMiddle'.
     * 
     * @return the value of field 'SzNmIncmgNameMiddle'.
     */
    public java.lang.String getSzNmIncmgNameMiddle()
    {
        return this._szNmIncmgNameMiddle;
    } //-- java.lang.String getSzNmIncmgNameMiddle() 

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
     * Returns the value of field 'ulIdIncomingName'.
     * 
     * @return the value of field 'UlIdIncomingName'.
     */
    public int getUlIdIncomingName()
    {
        return this._ulIdIncomingName;
    } //-- int getUlIdIncomingName() 

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
     * Method hasUlIdIncomingName
     * 
     * 
     * 
     * @return true if at least one UlIdIncomingName has been added
     */
    public boolean hasUlIdIncomingName()
    {
        return this._has_ulIdIncomingName;
    } //-- boolean hasUlIdIncomingName() 

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
     * Sets the value of field 'cIndIncmgNameInvalid'.
     * 
     * @param cIndIncmgNameInvalid the value of field
     * 'cIndIncmgNameInvalid'.
     */
    public void setCIndIncmgNameInvalid(java.lang.String cIndIncmgNameInvalid)
    {
        this._cIndIncmgNameInvalid = cIndIncmgNameInvalid;
    } //-- void setCIndIncmgNameInvalid(java.lang.String) 

    /**
     * Sets the value of field 'cIndIncmgNamePrimary'.
     * 
     * @param cIndIncmgNamePrimary the value of field
     * 'cIndIncmgNamePrimary'.
     */
    public void setCIndIncmgNamePrimary(java.lang.String cIndIncmgNamePrimary)
    {
        this._cIndIncmgNamePrimary = cIndIncmgNamePrimary;
    } //-- void setCIndIncmgNamePrimary(java.lang.String) 

    /**
     * Sets the value of field 'dtDtIncmgNameEnd'.
     * 
     * @param dtDtIncmgNameEnd the value of field 'dtDtIncmgNameEnd'
     */
    public void setDtDtIncmgNameEnd(org.exolab.castor.types.Date dtDtIncmgNameEnd)
    {
        this._dtDtIncmgNameEnd = dtDtIncmgNameEnd;
    } //-- void setDtDtIncmgNameEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtIncmgNameStart'.
     * 
     * @param dtDtIncmgNameStart the value of field
     * 'dtDtIncmgNameStart'.
     */
    public void setDtDtIncmgNameStart(org.exolab.castor.types.Date dtDtIncmgNameStart)
    {
        this._dtDtIncmgNameStart = dtDtIncmgNameStart;
    } //-- void setDtDtIncmgNameStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdIncmgNameSuffix'.
     * 
     * @param szCdIncmgNameSuffix the value of field
     * 'szCdIncmgNameSuffix'.
     */
    public void setSzCdIncmgNameSuffix(java.lang.String szCdIncmgNameSuffix)
    {
        this._szCdIncmgNameSuffix = szCdIncmgNameSuffix;
    } //-- void setSzCdIncmgNameSuffix(java.lang.String) 

    /**
     * Sets the value of field 'szNmIncmgNameFirst'.
     * 
     * @param szNmIncmgNameFirst the value of field
     * 'szNmIncmgNameFirst'.
     */
    public void setSzNmIncmgNameFirst(java.lang.String szNmIncmgNameFirst)
    {
        this._szNmIncmgNameFirst = szNmIncmgNameFirst;
    } //-- void setSzNmIncmgNameFirst(java.lang.String) 

    /**
     * Sets the value of field 'szNmIncmgNameLast'.
     * 
     * @param szNmIncmgNameLast the value of field
     * 'szNmIncmgNameLast'.
     */
    public void setSzNmIncmgNameLast(java.lang.String szNmIncmgNameLast)
    {
        this._szNmIncmgNameLast = szNmIncmgNameLast;
    } //-- void setSzNmIncmgNameLast(java.lang.String) 

    /**
     * Sets the value of field 'szNmIncmgNameMiddle'.
     * 
     * @param szNmIncmgNameMiddle the value of field
     * 'szNmIncmgNameMiddle'.
     */
    public void setSzNmIncmgNameMiddle(java.lang.String szNmIncmgNameMiddle)
    {
        this._szNmIncmgNameMiddle = szNmIncmgNameMiddle;
    } //-- void setSzNmIncmgNameMiddle(java.lang.String) 

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
     * Sets the value of field 'ulIdIncomingName'.
     * 
     * @param ulIdIncomingName the value of field 'ulIdIncomingName'
     */
    public void setUlIdIncomingName(int ulIdIncomingName)
    {
        this._ulIdIncomingName = ulIdIncomingName;
        this._has_ulIdIncomingName = true;
    } //-- void setUlIdIncomingName(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO unmarshal(java.io.Reader) 

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
