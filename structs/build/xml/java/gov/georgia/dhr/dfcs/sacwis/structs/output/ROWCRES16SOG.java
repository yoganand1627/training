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
 * Class ROWCRES16SOG.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCRES16SOG extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdRsrcAddrSchDist
     */
    private java.lang.String _szCdRsrcAddrSchDist;

    /**
     * Field _szTxtSchDistName
     */
    private java.lang.String _szTxtSchDistName;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCRES16SOG() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'szCdRsrcAddrSchDist'.
     * 
     * @return the value of field 'SzCdRsrcAddrSchDist'.
     */
    public java.lang.String getSzCdRsrcAddrSchDist()
    {
        return this._szCdRsrcAddrSchDist;
    } //-- java.lang.String getSzCdRsrcAddrSchDist() 

    /**
     * Returns the value of field 'szTxtSchDistName'.
     * 
     * @return the value of field 'SzTxtSchDistName'.
     */
    public java.lang.String getSzTxtSchDistName()
    {
        return this._szTxtSchDistName;
    } //-- java.lang.String getSzTxtSchDistName() 

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
     * Sets the value of field 'szCdRsrcAddrSchDist'.
     * 
     * @param szCdRsrcAddrSchDist the value of field
     * 'szCdRsrcAddrSchDist'.
     */
    public void setSzCdRsrcAddrSchDist(java.lang.String szCdRsrcAddrSchDist)
    {
        this._szCdRsrcAddrSchDist = szCdRsrcAddrSchDist;
    } //-- void setSzCdRsrcAddrSchDist(java.lang.String) 

    /**
     * Sets the value of field 'szTxtSchDistName'.
     * 
     * @param szTxtSchDistName the value of field 'szTxtSchDistName'
     */
    public void setSzTxtSchDistName(java.lang.String szTxtSchDistName)
    {
        this._szTxtSchDistName = szTxtSchDistName;
    } //-- void setSzTxtSchDistName(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG unmarshal(java.io.Reader) 

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
