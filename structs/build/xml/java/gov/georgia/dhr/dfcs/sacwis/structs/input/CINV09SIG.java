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
 * Class CINV09SIG.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV09SIG extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdAllegation
     */
    private int _ulIdAllegation;

    /**
     * keeps track of state for field: _ulIdAllegation
     */
    private boolean _has_ulIdAllegation;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV09SIG() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdAllegation()
    {
        this._has_ulIdAllegation= false;
    } //-- void deleteUlIdAllegation() 

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
     * Returns the value of field 'ulIdAllegation'.
     * 
     * @return the value of field 'UlIdAllegation'.
     */
    public int getUlIdAllegation()
    {
        return this._ulIdAllegation;
    } //-- int getUlIdAllegation() 

    /**
     * Method hasUlIdAllegation
     * 
     * 
     * 
     * @return true if at least one UlIdAllegation has been added
     */
    public boolean hasUlIdAllegation()
    {
        return this._has_ulIdAllegation;
    } //-- boolean hasUlIdAllegation() 

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
     * Sets the value of field 'tsLastUpdate'.
     * 
     * @param tsLastUpdate the value of field 'tsLastUpdate'.
     */
    public void setTsLastUpdate(java.util.Date tsLastUpdate)
    {
        this._tsLastUpdate = tsLastUpdate;
    } //-- void setTsLastUpdate(java.util.Date) 

    /**
     * Sets the value of field 'ulIdAllegation'.
     * 
     * @param ulIdAllegation the value of field 'ulIdAllegation'.
     */
    public void setUlIdAllegation(int ulIdAllegation)
    {
        this._ulIdAllegation = ulIdAllegation;
        this._has_ulIdAllegation = true;
    } //-- void setUlIdAllegation(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG unmarshal(java.io.Reader) 

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
