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
 * Class STFFASSGNMTHIST.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class STFFASSGNMTHIST extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szNmFromPerson
     */
    private java.lang.String _szNmFromPerson;

    /**
     * Field _szNmToPerson
     */
    private java.lang.String _szNmToPerson;

    /**
     * Field _szNmEnteredByPerson
     */
    private java.lang.String _szNmEnteredByPerson;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _szCdFromCounty
     */
    private java.lang.String _szCdFromCounty;

    /**
     * Field _szCdToCounty
     */
    private java.lang.String _szCdToCounty;

    /**
     * Field _dtDtLastUpdate
     */
    private org.exolab.castor.types.Date _dtDtLastUpdate;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;


      //----------------/
     //- Constructors -/
    //----------------/

    public STFFASSGNMTHIST() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     * Returns the value of field 'dtDtLastUpdate'.
     * 
     * @return the value of field 'DtDtLastUpdate'.
     */
    public org.exolab.castor.types.Date getDtDtLastUpdate()
    {
        return this._dtDtLastUpdate;
    } //-- org.exolab.castor.types.Date getDtDtLastUpdate() 

    /**
     * Returns the value of field 'szCdFromCounty'.
     * 
     * @return the value of field 'SzCdFromCounty'.
     */
    public java.lang.String getSzCdFromCounty()
    {
        return this._szCdFromCounty;
    } //-- java.lang.String getSzCdFromCounty() 

    /**
     * Returns the value of field 'szCdStage'.
     * 
     * @return the value of field 'SzCdStage'.
     */
    public java.lang.String getSzCdStage()
    {
        return this._szCdStage;
    } //-- java.lang.String getSzCdStage() 

    /**
     * Returns the value of field 'szCdToCounty'.
     * 
     * @return the value of field 'SzCdToCounty'.
     */
    public java.lang.String getSzCdToCounty()
    {
        return this._szCdToCounty;
    } //-- java.lang.String getSzCdToCounty() 

    /**
     * Returns the value of field 'szNmEnteredByPerson'.
     * 
     * @return the value of field 'SzNmEnteredByPerson'.
     */
    public java.lang.String getSzNmEnteredByPerson()
    {
        return this._szNmEnteredByPerson;
    } //-- java.lang.String getSzNmEnteredByPerson() 

    /**
     * Returns the value of field 'szNmFromPerson'.
     * 
     * @return the value of field 'SzNmFromPerson'.
     */
    public java.lang.String getSzNmFromPerson()
    {
        return this._szNmFromPerson;
    } //-- java.lang.String getSzNmFromPerson() 

    /**
     * Returns the value of field 'szNmToPerson'.
     * 
     * @return the value of field 'SzNmToPerson'.
     */
    public java.lang.String getSzNmToPerson()
    {
        return this._szNmToPerson;
    } //-- java.lang.String getSzNmToPerson() 

    /**
     * Returns the value of field 'ulIdCase'.
     * 
     * @return the value of field 'UlIdCase'.
     */
    public int getUlIdCase()
    {
        return this._ulIdCase;
    } //-- int getUlIdCase() 

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
     * Method hasUlIdCase
     * 
     * 
     * 
     * @return true if at least one UlIdCase has been added
     */
    public boolean hasUlIdCase()
    {
        return this._has_ulIdCase;
    } //-- boolean hasUlIdCase() 

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
     * Sets the value of field 'dtDtLastUpdate'.
     * 
     * @param dtDtLastUpdate the value of field 'dtDtLastUpdate'.
     */
    public void setDtDtLastUpdate(org.exolab.castor.types.Date dtDtLastUpdate)
    {
        this._dtDtLastUpdate = dtDtLastUpdate;
    } //-- void setDtDtLastUpdate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdFromCounty'.
     * 
     * @param szCdFromCounty the value of field 'szCdFromCounty'.
     */
    public void setSzCdFromCounty(java.lang.String szCdFromCounty)
    {
        this._szCdFromCounty = szCdFromCounty;
    } //-- void setSzCdFromCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdStage'.
     * 
     * @param szCdStage the value of field 'szCdStage'.
     */
    public void setSzCdStage(java.lang.String szCdStage)
    {
        this._szCdStage = szCdStage;
    } //-- void setSzCdStage(java.lang.String) 

    /**
     * Sets the value of field 'szCdToCounty'.
     * 
     * @param szCdToCounty the value of field 'szCdToCounty'.
     */
    public void setSzCdToCounty(java.lang.String szCdToCounty)
    {
        this._szCdToCounty = szCdToCounty;
    } //-- void setSzCdToCounty(java.lang.String) 

    /**
     * Sets the value of field 'szNmEnteredByPerson'.
     * 
     * @param szNmEnteredByPerson the value of field
     * 'szNmEnteredByPerson'.
     */
    public void setSzNmEnteredByPerson(java.lang.String szNmEnteredByPerson)
    {
        this._szNmEnteredByPerson = szNmEnteredByPerson;
    } //-- void setSzNmEnteredByPerson(java.lang.String) 

    /**
     * Sets the value of field 'szNmFromPerson'.
     * 
     * @param szNmFromPerson the value of field 'szNmFromPerson'.
     */
    public void setSzNmFromPerson(java.lang.String szNmFromPerson)
    {
        this._szNmFromPerson = szNmFromPerson;
    } //-- void setSzNmFromPerson(java.lang.String) 

    /**
     * Sets the value of field 'szNmToPerson'.
     * 
     * @param szNmToPerson the value of field 'szNmToPerson'.
     */
    public void setSzNmToPerson(java.lang.String szNmToPerson)
    {
        this._szNmToPerson = szNmToPerson;
    } //-- void setSzNmToPerson(java.lang.String) 

    /**
     * Sets the value of field 'ulIdCase'.
     * 
     * @param ulIdCase the value of field 'ulIdCase'.
     */
    public void setUlIdCase(int ulIdCase)
    {
        this._ulIdCase = ulIdCase;
        this._has_ulIdCase = true;
    } //-- void setUlIdCase(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST unmarshal(java.io.Reader) 

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
