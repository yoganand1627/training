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
 * Class ROWCCON13SOG.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCON13SOG extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdCncntyCounty
     */
    private java.lang.String _szCdCncntyCounty;

    /**
     * Field _ulIdCncnty
     */
    private int _ulIdCncnty;

    /**
     * keeps track of state for field: _ulIdCncnty
     */
    private boolean _has_ulIdCncnty;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCON13SOG() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCncnty()
    {
        this._has_ulIdCncnty= false;
    } //-- void deleteUlIdCncnty() 

    /**
     * Returns the value of field 'szCdCncntyCounty'.
     * 
     * @return the value of field 'SzCdCncntyCounty'.
     */
    public java.lang.String getSzCdCncntyCounty()
    {
        return this._szCdCncntyCounty;
    } //-- java.lang.String getSzCdCncntyCounty() 

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
     * Returns the value of field 'ulIdCncnty'.
     * 
     * @return the value of field 'UlIdCncnty'.
     */
    public int getUlIdCncnty()
    {
        return this._ulIdCncnty;
    } //-- int getUlIdCncnty() 

    /**
     * Method hasUlIdCncnty
     * 
     * 
     * 
     * @return true if at least one UlIdCncnty has been added
     */
    public boolean hasUlIdCncnty()
    {
        return this._has_ulIdCncnty;
    } //-- boolean hasUlIdCncnty() 

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
     * Sets the value of field 'szCdCncntyCounty'.
     * 
     * @param szCdCncntyCounty the value of field 'szCdCncntyCounty'
     */
    public void setSzCdCncntyCounty(java.lang.String szCdCncntyCounty)
    {
        this._szCdCncntyCounty = szCdCncntyCounty;
    } //-- void setSzCdCncntyCounty(java.lang.String) 

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
     * Sets the value of field 'ulIdCncnty'.
     * 
     * @param ulIdCncnty the value of field 'ulIdCncnty'.
     */
    public void setUlIdCncnty(int ulIdCncnty)
    {
        this._ulIdCncnty = ulIdCncnty;
        this._has_ulIdCncnty = true;
    } //-- void setUlIdCncnty(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG unmarshal(java.io.Reader) 

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
