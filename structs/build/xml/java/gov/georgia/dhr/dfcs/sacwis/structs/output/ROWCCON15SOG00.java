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
 * Class ROWCCON15SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCON15SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdRsrcLinkService
     */
    private java.lang.String _szCdRsrcLinkService;

    /**
     * Field _uIdRsrcLink
     */
    private int _uIdRsrcLink;

    /**
     * keeps track of state for field: _uIdRsrcLink
     */
    private boolean _has_uIdRsrcLink;

    /**
     * Field _uIdRsrcLinkChild
     */
    private int _uIdRsrcLinkChild;

    /**
     * keeps track of state for field: _uIdRsrcLinkChild
     */
    private boolean _has_uIdRsrcLinkChild;

    /**
     * Field _szNmResource
     */
    private java.lang.String _szNmResource;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCON15SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUIdRsrcLink()
    {
        this._has_uIdRsrcLink= false;
    } //-- void deleteUIdRsrcLink() 

    /**
     */
    public void deleteUIdRsrcLinkChild()
    {
        this._has_uIdRsrcLinkChild= false;
    } //-- void deleteUIdRsrcLinkChild() 

    /**
     * Returns the value of field 'szCdRsrcLinkService'.
     * 
     * @return the value of field 'SzCdRsrcLinkService'.
     */
    public java.lang.String getSzCdRsrcLinkService()
    {
        return this._szCdRsrcLinkService;
    } //-- java.lang.String getSzCdRsrcLinkService() 

    /**
     * Returns the value of field 'szNmResource'.
     * 
     * @return the value of field 'SzNmResource'.
     */
    public java.lang.String getSzNmResource()
    {
        return this._szNmResource;
    } //-- java.lang.String getSzNmResource() 

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
     * Returns the value of field 'uIdRsrcLink'.
     * 
     * @return the value of field 'UIdRsrcLink'.
     */
    public int getUIdRsrcLink()
    {
        return this._uIdRsrcLink;
    } //-- int getUIdRsrcLink() 

    /**
     * Returns the value of field 'uIdRsrcLinkChild'.
     * 
     * @return the value of field 'UIdRsrcLinkChild'.
     */
    public int getUIdRsrcLinkChild()
    {
        return this._uIdRsrcLinkChild;
    } //-- int getUIdRsrcLinkChild() 

    /**
     * Method hasUIdRsrcLink
     * 
     * 
     * 
     * @return true if at least one UIdRsrcLink has been added
     */
    public boolean hasUIdRsrcLink()
    {
        return this._has_uIdRsrcLink;
    } //-- boolean hasUIdRsrcLink() 

    /**
     * Method hasUIdRsrcLinkChild
     * 
     * 
     * 
     * @return true if at least one UIdRsrcLinkChild has been added
     */
    public boolean hasUIdRsrcLinkChild()
    {
        return this._has_uIdRsrcLinkChild;
    } //-- boolean hasUIdRsrcLinkChild() 

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
     * Sets the value of field 'szCdRsrcLinkService'.
     * 
     * @param szCdRsrcLinkService the value of field
     * 'szCdRsrcLinkService'.
     */
    public void setSzCdRsrcLinkService(java.lang.String szCdRsrcLinkService)
    {
        this._szCdRsrcLinkService = szCdRsrcLinkService;
    } //-- void setSzCdRsrcLinkService(java.lang.String) 

    /**
     * Sets the value of field 'szNmResource'.
     * 
     * @param szNmResource the value of field 'szNmResource'.
     */
    public void setSzNmResource(java.lang.String szNmResource)
    {
        this._szNmResource = szNmResource;
    } //-- void setSzNmResource(java.lang.String) 

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
     * Sets the value of field 'uIdRsrcLink'.
     * 
     * @param uIdRsrcLink the value of field 'uIdRsrcLink'.
     */
    public void setUIdRsrcLink(int uIdRsrcLink)
    {
        this._uIdRsrcLink = uIdRsrcLink;
        this._has_uIdRsrcLink = true;
    } //-- void setUIdRsrcLink(int) 

    /**
     * Sets the value of field 'uIdRsrcLinkChild'.
     * 
     * @param uIdRsrcLinkChild the value of field 'uIdRsrcLinkChild'
     */
    public void setUIdRsrcLinkChild(int uIdRsrcLinkChild)
    {
        this._uIdRsrcLinkChild = uIdRsrcLinkChild;
        this._has_uIdRsrcLinkChild = true;
    } //-- void setUIdRsrcLinkChild(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00 unmarshal(java.io.Reader) 

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