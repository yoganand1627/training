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
 * Class CINV36SOG04.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV36SOG04 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _cdRiskAssmtPurpose
     */
    private java.lang.String _cdRiskAssmtPurpose;

    /**
     * Field _szCdRiskAssmtRiskFind
     */
    private java.lang.String _szCdRiskAssmtRiskFind;

    /**
     * Field _szCdRiskAssmtApAccess
     */
    private java.lang.String _szCdRiskAssmtApAccess;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV36SOG04() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG04()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'cdRiskAssmtPurpose'.
     * 
     * @return the value of field 'CdRiskAssmtPurpose'.
     */
    public java.lang.String getCdRiskAssmtPurpose()
    {
        return this._cdRiskAssmtPurpose;
    } //-- java.lang.String getCdRiskAssmtPurpose() 

    /**
     * Returns the value of field 'szCdRiskAssmtApAccess'.
     * 
     * @return the value of field 'SzCdRiskAssmtApAccess'.
     */
    public java.lang.String getSzCdRiskAssmtApAccess()
    {
        return this._szCdRiskAssmtApAccess;
    } //-- java.lang.String getSzCdRiskAssmtApAccess() 

    /**
     * Returns the value of field 'szCdRiskAssmtRiskFind'.
     * 
     * @return the value of field 'SzCdRiskAssmtRiskFind'.
     */
    public java.lang.String getSzCdRiskAssmtRiskFind()
    {
        return this._szCdRiskAssmtRiskFind;
    } //-- java.lang.String getSzCdRiskAssmtRiskFind() 

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
     * Sets the value of field 'cdRiskAssmtPurpose'.
     * 
     * @param cdRiskAssmtPurpose the value of field
     * 'cdRiskAssmtPurpose'.
     */
    public void setCdRiskAssmtPurpose(java.lang.String cdRiskAssmtPurpose)
    {
        this._cdRiskAssmtPurpose = cdRiskAssmtPurpose;
    } //-- void setCdRiskAssmtPurpose(java.lang.String) 

    /**
     * Sets the value of field 'szCdRiskAssmtApAccess'.
     * 
     * @param szCdRiskAssmtApAccess the value of field
     * 'szCdRiskAssmtApAccess'.
     */
    public void setSzCdRiskAssmtApAccess(java.lang.String szCdRiskAssmtApAccess)
    {
        this._szCdRiskAssmtApAccess = szCdRiskAssmtApAccess;
    } //-- void setSzCdRiskAssmtApAccess(java.lang.String) 

    /**
     * Sets the value of field 'szCdRiskAssmtRiskFind'.
     * 
     * @param szCdRiskAssmtRiskFind the value of field
     * 'szCdRiskAssmtRiskFind'.
     */
    public void setSzCdRiskAssmtRiskFind(java.lang.String szCdRiskAssmtRiskFind)
    {
        this._szCdRiskAssmtRiskFind = szCdRiskAssmtRiskFind;
    } //-- void setSzCdRiskAssmtRiskFind(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG04
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG04 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG04) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG04.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SOG04 unmarshal(java.io.Reader) 

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
