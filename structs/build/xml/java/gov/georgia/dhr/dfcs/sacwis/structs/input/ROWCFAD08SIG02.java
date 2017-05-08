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
 * Class ROWCFAD08SIG02.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFAD08SIG02 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdRsrcCharChrctr
     */
    private java.lang.String _szCdRsrcCharChrctr;

    /**
     * Field _dtDtRsrcCharDateAdded
     */
    private org.exolab.castor.types.Date _dtDtRsrcCharDateAdded;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFAD08SIG02() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG02()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'dtDtRsrcCharDateAdded'.
     * 
     * @return the value of field 'DtDtRsrcCharDateAdded'.
     */
    public org.exolab.castor.types.Date getDtDtRsrcCharDateAdded()
    {
        return this._dtDtRsrcCharDateAdded;
    } //-- org.exolab.castor.types.Date getDtDtRsrcCharDateAdded() 

    /**
     * Returns the value of field 'szCdRsrcCharChrctr'.
     * 
     * @return the value of field 'SzCdRsrcCharChrctr'.
     */
    public java.lang.String getSzCdRsrcCharChrctr()
    {
        return this._szCdRsrcCharChrctr;
    } //-- java.lang.String getSzCdRsrcCharChrctr() 

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
     * Sets the value of field 'dtDtRsrcCharDateAdded'.
     * 
     * @param dtDtRsrcCharDateAdded the value of field
     * 'dtDtRsrcCharDateAdded'.
     */
    public void setDtDtRsrcCharDateAdded(org.exolab.castor.types.Date dtDtRsrcCharDateAdded)
    {
        this._dtDtRsrcCharDateAdded = dtDtRsrcCharDateAdded;
    } //-- void setDtDtRsrcCharDateAdded(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdRsrcCharChrctr'.
     * 
     * @param szCdRsrcCharChrctr the value of field
     * 'szCdRsrcCharChrctr'.
     */
    public void setSzCdRsrcCharChrctr(java.lang.String szCdRsrcCharChrctr)
    {
        this._szCdRsrcCharChrctr = szCdRsrcCharChrctr;
    } //-- void setSzCdRsrcCharChrctr(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG02
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG02 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG02) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG02.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG02 unmarshal(java.io.Reader) 

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
