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
 * Class CRES10SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CRES10SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdSpecSvc
     */
    private int _ulIdSpecSvc;

    /**
     * keeps track of state for field: _ulIdSpecSvc
     */
    private boolean _has_ulIdSpecSvc;

    /**
     * Field _ulIdSpecSvcRsrc
     */
    private int _ulIdSpecSvcRsrc;

    /**
     * keeps track of state for field: _ulIdSpecSvcRsrc
     */
    private boolean _has_ulIdSpecSvcRsrc;

    /**
     * Field _szCdSpecSvcs
     */
    private java.lang.String _szCdSpecSvcs;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;


      //----------------/
     //- Constructors -/
    //----------------/

    public CRES10SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdSpecSvc()
    {
        this._has_ulIdSpecSvc= false;
    } //-- void deleteUlIdSpecSvc() 

    /**
     */
    public void deleteUlIdSpecSvcRsrc()
    {
        this._has_ulIdSpecSvcRsrc= false;
    } //-- void deleteUlIdSpecSvcRsrc() 

    /**
     * Returns the value of field 'szCdScrDataAction'.
     * 
     * @return the value of field 'SzCdScrDataAction'.
     */
    public java.lang.String getSzCdScrDataAction()
    {
        return this._szCdScrDataAction;
    } //-- java.lang.String getSzCdScrDataAction() 

    /**
     * Returns the value of field 'szCdSpecSvcs'.
     * 
     * @return the value of field 'SzCdSpecSvcs'.
     */
    public java.lang.String getSzCdSpecSvcs()
    {
        return this._szCdSpecSvcs;
    } //-- java.lang.String getSzCdSpecSvcs() 

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
     * Returns the value of field 'ulIdSpecSvc'.
     * 
     * @return the value of field 'UlIdSpecSvc'.
     */
    public int getUlIdSpecSvc()
    {
        return this._ulIdSpecSvc;
    } //-- int getUlIdSpecSvc() 

    /**
     * Returns the value of field 'ulIdSpecSvcRsrc'.
     * 
     * @return the value of field 'UlIdSpecSvcRsrc'.
     */
    public int getUlIdSpecSvcRsrc()
    {
        return this._ulIdSpecSvcRsrc;
    } //-- int getUlIdSpecSvcRsrc() 

    /**
     * Method hasUlIdSpecSvc
     * 
     * 
     * 
     * @return true if at least one UlIdSpecSvc has been added
     */
    public boolean hasUlIdSpecSvc()
    {
        return this._has_ulIdSpecSvc;
    } //-- boolean hasUlIdSpecSvc() 

    /**
     * Method hasUlIdSpecSvcRsrc
     * 
     * 
     * 
     * @return true if at least one UlIdSpecSvcRsrc has been added
     */
    public boolean hasUlIdSpecSvcRsrc()
    {
        return this._has_ulIdSpecSvcRsrc;
    } //-- boolean hasUlIdSpecSvcRsrc() 

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
     * Sets the value of field 'szCdScrDataAction'.
     * 
     * @param szCdScrDataAction the value of field
     * 'szCdScrDataAction'.
     */
    public void setSzCdScrDataAction(java.lang.String szCdScrDataAction)
    {
        this._szCdScrDataAction = szCdScrDataAction;
    } //-- void setSzCdScrDataAction(java.lang.String) 

    /**
     * Sets the value of field 'szCdSpecSvcs'.
     * 
     * @param szCdSpecSvcs the value of field 'szCdSpecSvcs'.
     */
    public void setSzCdSpecSvcs(java.lang.String szCdSpecSvcs)
    {
        this._szCdSpecSvcs = szCdSpecSvcs;
    } //-- void setSzCdSpecSvcs(java.lang.String) 

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
     * Sets the value of field 'ulIdSpecSvc'.
     * 
     * @param ulIdSpecSvc the value of field 'ulIdSpecSvc'.
     */
    public void setUlIdSpecSvc(int ulIdSpecSvc)
    {
        this._ulIdSpecSvc = ulIdSpecSvc;
        this._has_ulIdSpecSvc = true;
    } //-- void setUlIdSpecSvc(int) 

    /**
     * Sets the value of field 'ulIdSpecSvcRsrc'.
     * 
     * @param ulIdSpecSvcRsrc the value of field 'ulIdSpecSvcRsrc'.
     */
    public void setUlIdSpecSvcRsrc(int ulIdSpecSvcRsrc)
    {
        this._ulIdSpecSvcRsrc = ulIdSpecSvcRsrc;
        this._has_ulIdSpecSvcRsrc = true;
    } //-- void setUlIdSpecSvcRsrc(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG00 unmarshal(java.io.Reader) 

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
