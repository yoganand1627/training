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
 * Class DetermListAUD.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class DetermListAUD extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _cdIncmgDeterm_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CdIncmgDeterm_ARRAY _cdIncmgDeterm_ARRAY;

    /**
     * Field _szCdIncmgDetermType_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdIncmgDetermType_ARRAY _szCdIncmgDetermType_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public DetermListAUD() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'cdIncmgDeterm_ARRAY'.
     * 
     * @return the value of field 'CdIncmgDeterm_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CdIncmgDeterm_ARRAY getCdIncmgDeterm_ARRAY()
    {
        return this._cdIncmgDeterm_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CdIncmgDeterm_ARRAY getCdIncmgDeterm_ARRAY() 

    /**
     * Returns the value of field 'szCdIncmgDetermType_ARRAY'.
     * 
     * @return the value of field 'SzCdIncmgDetermType_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdIncmgDetermType_ARRAY getSzCdIncmgDetermType_ARRAY()
    {
        return this._szCdIncmgDetermType_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdIncmgDetermType_ARRAY getSzCdIncmgDetermType_ARRAY() 

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
     * Sets the value of field 'cdIncmgDeterm_ARRAY'.
     * 
     * @param cdIncmgDeterm_ARRAY the value of field
     * 'cdIncmgDeterm_ARRAY'.
     */
    public void setCdIncmgDeterm_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CdIncmgDeterm_ARRAY cdIncmgDeterm_ARRAY)
    {
        this._cdIncmgDeterm_ARRAY = cdIncmgDeterm_ARRAY;
    } //-- void setCdIncmgDeterm_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CdIncmgDeterm_ARRAY) 

    /**
     * Sets the value of field 'szCdIncmgDetermType_ARRAY'.
     * 
     * @param szCdIncmgDetermType_ARRAY the value of field
     * 'szCdIncmgDetermType_ARRAY'.
     */
    public void setSzCdIncmgDetermType_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdIncmgDetermType_ARRAY szCdIncmgDetermType_ARRAY)
    {
        this._szCdIncmgDetermType_ARRAY = szCdIncmgDetermType_ARRAY;
    } //-- void setSzCdIncmgDetermType_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdIncmgDetermType_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD unmarshal(java.io.Reader) 

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
