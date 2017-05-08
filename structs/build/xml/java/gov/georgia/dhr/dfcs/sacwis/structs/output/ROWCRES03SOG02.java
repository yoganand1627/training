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
 * Class ROWCRES03SOG02.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCRES03SOG02 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szNmOrsFacilName
     */
    private java.lang.String _szNmOrsFacilName;

    /**
     * Field _szNbrOrsRsrcId
     */
    private java.lang.String _szNbrOrsRsrcId;

    /**
     * Field _szNmOrsFacType
     */
    private java.lang.String _szNmOrsFacType;

    /**
     * Field _szTxtOrsFacStatus
     */
    private java.lang.String _szTxtOrsFacStatus;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCRES03SOG02() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'szNbrOrsRsrcId'.
     * 
     * @return the value of field 'SzNbrOrsRsrcId'.
     */
    public java.lang.String getSzNbrOrsRsrcId()
    {
        return this._szNbrOrsRsrcId;
    } //-- java.lang.String getSzNbrOrsRsrcId() 

    /**
     * Returns the value of field 'szNmOrsFacType'.
     * 
     * @return the value of field 'SzNmOrsFacType'.
     */
    public java.lang.String getSzNmOrsFacType()
    {
        return this._szNmOrsFacType;
    } //-- java.lang.String getSzNmOrsFacType() 

    /**
     * Returns the value of field 'szNmOrsFacilName'.
     * 
     * @return the value of field 'SzNmOrsFacilName'.
     */
    public java.lang.String getSzNmOrsFacilName()
    {
        return this._szNmOrsFacilName;
    } //-- java.lang.String getSzNmOrsFacilName() 

    /**
     * Returns the value of field 'szTxtOrsFacStatus'.
     * 
     * @return the value of field 'SzTxtOrsFacStatus'.
     */
    public java.lang.String getSzTxtOrsFacStatus()
    {
        return this._szTxtOrsFacStatus;
    } //-- java.lang.String getSzTxtOrsFacStatus() 

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
     * Sets the value of field 'szNbrOrsRsrcId'.
     * 
     * @param szNbrOrsRsrcId the value of field 'szNbrOrsRsrcId'.
     */
    public void setSzNbrOrsRsrcId(java.lang.String szNbrOrsRsrcId)
    {
        this._szNbrOrsRsrcId = szNbrOrsRsrcId;
    } //-- void setSzNbrOrsRsrcId(java.lang.String) 

    /**
     * Sets the value of field 'szNmOrsFacType'.
     * 
     * @param szNmOrsFacType the value of field 'szNmOrsFacType'.
     */
    public void setSzNmOrsFacType(java.lang.String szNmOrsFacType)
    {
        this._szNmOrsFacType = szNmOrsFacType;
    } //-- void setSzNmOrsFacType(java.lang.String) 

    /**
     * Sets the value of field 'szNmOrsFacilName'.
     * 
     * @param szNmOrsFacilName the value of field 'szNmOrsFacilName'
     */
    public void setSzNmOrsFacilName(java.lang.String szNmOrsFacilName)
    {
        this._szNmOrsFacilName = szNmOrsFacilName;
    } //-- void setSzNmOrsFacilName(java.lang.String) 

    /**
     * Sets the value of field 'szTxtOrsFacStatus'.
     * 
     * @param szTxtOrsFacStatus the value of field
     * 'szTxtOrsFacStatus'.
     */
    public void setSzTxtOrsFacStatus(java.lang.String szTxtOrsFacStatus)
    {
        this._szTxtOrsFacStatus = szTxtOrsFacStatus;
    } //-- void setSzTxtOrsFacStatus(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02 unmarshal(java.io.Reader) 

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
