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
 * Class CCON15SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCON15SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archInputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct _archInputStruct;

    /**
     * Field _uIdRsrcLinkParent
     */
    private int _uIdRsrcLinkParent;

    /**
     * keeps track of state for field: _uIdRsrcLinkParent
     */
    private boolean _has_uIdRsrcLinkParent;

    /**
     * Field _ulPageSizeNbr
     */
    private int _ulPageSizeNbr;

    /**
     * keeps track of state for field: _ulPageSizeNbr
     */
    private boolean _has_ulPageSizeNbr;

    /**
     * Field _bSysIndSbcntrPredisplay
     */
    private java.lang.String _bSysIndSbcntrPredisplay;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCON15SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON15SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUIdRsrcLinkParent()
    {
        this._has_uIdRsrcLinkParent= false;
    } //-- void deleteUIdRsrcLinkParent() 

    /**
     */
    public void deleteUlPageSizeNbr()
    {
        this._has_ulPageSizeNbr= false;
    } //-- void deleteUlPageSizeNbr() 

    /**
     * Returns the value of field 'archInputStruct'.
     * 
     * @return the value of field 'ArchInputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct()
    {
        return this._archInputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct() 

    /**
     * Returns the value of field 'bSysIndSbcntrPredisplay'.
     * 
     * @return the value of field 'BSysIndSbcntrPredisplay'.
     */
    public java.lang.String getBSysIndSbcntrPredisplay()
    {
        return this._bSysIndSbcntrPredisplay;
    } //-- java.lang.String getBSysIndSbcntrPredisplay() 

    /**
     * Returns the value of field 'uIdRsrcLinkParent'.
     * 
     * @return the value of field 'UIdRsrcLinkParent'.
     */
    public int getUIdRsrcLinkParent()
    {
        return this._uIdRsrcLinkParent;
    } //-- int getUIdRsrcLinkParent() 

    /**
     * Returns the value of field 'ulPageSizeNbr'.
     * 
     * @return the value of field 'UlPageSizeNbr'.
     */
    public int getUlPageSizeNbr()
    {
        return this._ulPageSizeNbr;
    } //-- int getUlPageSizeNbr() 

    /**
     * Method hasUIdRsrcLinkParent
     * 
     * 
     * 
     * @return true if at least one UIdRsrcLinkParent has been added
     */
    public boolean hasUIdRsrcLinkParent()
    {
        return this._has_uIdRsrcLinkParent;
    } //-- boolean hasUIdRsrcLinkParent() 

    /**
     * Method hasUlPageSizeNbr
     * 
     * 
     * 
     * @return true if at least one UlPageSizeNbr has been added
     */
    public boolean hasUlPageSizeNbr()
    {
        return this._has_ulPageSizeNbr;
    } //-- boolean hasUlPageSizeNbr() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

    /**
     * Sets the value of field 'bSysIndSbcntrPredisplay'.
     * 
     * @param bSysIndSbcntrPredisplay the value of field
     * 'bSysIndSbcntrPredisplay'.
     */
    public void setBSysIndSbcntrPredisplay(java.lang.String bSysIndSbcntrPredisplay)
    {
        this._bSysIndSbcntrPredisplay = bSysIndSbcntrPredisplay;
    } //-- void setBSysIndSbcntrPredisplay(java.lang.String) 

    /**
     * Sets the value of field 'uIdRsrcLinkParent'.
     * 
     * @param uIdRsrcLinkParent the value of field
     * 'uIdRsrcLinkParent'.
     */
    public void setUIdRsrcLinkParent(int uIdRsrcLinkParent)
    {
        this._uIdRsrcLinkParent = uIdRsrcLinkParent;
        this._has_uIdRsrcLinkParent = true;
    } //-- void setUIdRsrcLinkParent(int) 

    /**
     * Sets the value of field 'ulPageSizeNbr'.
     * 
     * @param ulPageSizeNbr the value of field 'ulPageSizeNbr'.
     */
    public void setUlPageSizeNbr(int ulPageSizeNbr)
    {
        this._ulPageSizeNbr = ulPageSizeNbr;
        this._has_ulPageSizeNbr = true;
    } //-- void setUlPageSizeNbr(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCON15SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCON15SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCON15SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCON15SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON15SI unmarshal(java.io.Reader) 

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
