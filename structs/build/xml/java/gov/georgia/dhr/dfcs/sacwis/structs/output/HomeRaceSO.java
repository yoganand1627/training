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
 * Class HomeRaceSO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class HomeRaceSO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdFaHomeIntRace
     */
    private java.lang.String _szCdFaHomeIntRace;

    /**
     * Field _dtScrDtFaHomeDtRaceAdd
     */
    private org.exolab.castor.types.Date _dtScrDtFaHomeDtRaceAdd;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public HomeRaceSO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'dtScrDtFaHomeDtRaceAdd'.
     * 
     * @return the value of field 'DtScrDtFaHomeDtRaceAdd'.
     */
    public org.exolab.castor.types.Date getDtScrDtFaHomeDtRaceAdd()
    {
        return this._dtScrDtFaHomeDtRaceAdd;
    } //-- org.exolab.castor.types.Date getDtScrDtFaHomeDtRaceAdd() 

    /**
     * Returns the value of field 'szCdFaHomeIntRace'.
     * 
     * @return the value of field 'SzCdFaHomeIntRace'.
     */
    public java.lang.String getSzCdFaHomeIntRace()
    {
        return this._szCdFaHomeIntRace;
    } //-- java.lang.String getSzCdFaHomeIntRace() 

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
     * Sets the value of field 'dtScrDtFaHomeDtRaceAdd'.
     * 
     * @param dtScrDtFaHomeDtRaceAdd the value of field
     * 'dtScrDtFaHomeDtRaceAdd'.
     */
    public void setDtScrDtFaHomeDtRaceAdd(org.exolab.castor.types.Date dtScrDtFaHomeDtRaceAdd)
    {
        this._dtScrDtFaHomeDtRaceAdd = dtScrDtFaHomeDtRaceAdd;
    } //-- void setDtScrDtFaHomeDtRaceAdd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdFaHomeIntRace'.
     * 
     * @param szCdFaHomeIntRace the value of field
     * 'szCdFaHomeIntRace'.
     */
    public void setSzCdFaHomeIntRace(java.lang.String szCdFaHomeIntRace)
    {
        this._szCdFaHomeIntRace = szCdFaHomeIntRace;
    } //-- void setSzCdFaHomeIntRace(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO unmarshal(java.io.Reader) 

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
