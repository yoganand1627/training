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
 * Class ROWCCFC40SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCFC40SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdUerrorMsgNbr
     */
    private int _szCdUerrorMsgNbr;

    /**
     * keeps track of state for field: _szCdUerrorMsgNbr
     */
    private boolean _has_szCdUerrorMsgNbr;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCFC40SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC40SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteSzCdUerrorMsgNbr()
    {
        this._has_szCdUerrorMsgNbr= false;
    } //-- void deleteSzCdUerrorMsgNbr() 

    /**
     * Returns the value of field 'szCdUerrorMsgNbr'.
     * 
     * @return the value of field 'SzCdUerrorMsgNbr'.
     */
    public int getSzCdUerrorMsgNbr()
    {
        return this._szCdUerrorMsgNbr;
    } //-- int getSzCdUerrorMsgNbr() 

    /**
     * Method hasSzCdUerrorMsgNbr
     * 
     * 
     * 
     * @return true if at least one SzCdUerrorMsgNbr has been added
     */
    public boolean hasSzCdUerrorMsgNbr()
    {
        return this._has_szCdUerrorMsgNbr;
    } //-- boolean hasSzCdUerrorMsgNbr() 

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
     * Sets the value of field 'szCdUerrorMsgNbr'.
     * 
     * @param szCdUerrorMsgNbr the value of field 'szCdUerrorMsgNbr'
     */
    public void setSzCdUerrorMsgNbr(int szCdUerrorMsgNbr)
    {
        this._szCdUerrorMsgNbr = szCdUerrorMsgNbr;
        this._has_szCdUerrorMsgNbr = true;
    } //-- void setSzCdUerrorMsgNbr(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC40SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC40SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC40SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC40SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC40SOG00 unmarshal(java.io.Reader) 

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
