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
 * Class ArchOutputStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ArchOutputStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _bMoreDataInd
     */
    private java.lang.String _bMoreDataInd;

    /**
     * Field _ulRowQty
     */
    private int _ulRowQty;

    /**
     * keeps track of state for field: _ulRowQty
     */
    private boolean _has_ulRowQty;

    /**
     * Field _bPerfErrInd
     */
    private java.lang.String _bPerfErrInd;

    /**
     * Field _ulPerfTmTotQty
     */
    private int _ulPerfTmTotQty;

    /**
     * keeps track of state for field: _ulPerfTmTotQty
     */
    private boolean _has_ulPerfTmTotQty;

    /**
     * Field _szSvcStrtTs
     */
    private java.lang.String _szSvcStrtTs;

    /**
     * Field _ulSvcTmTotQty
     */
    private int _ulSvcTmTotQty;

    /**
     * keeps track of state for field: _ulSvcTmTotQty
     */
    private boolean _has_ulSvcTmTotQty;

    /**
     * Field _ulSrvrDstrbTmTotQ
     */
    private int _ulSrvrDstrbTmTotQ;

    /**
     * keeps track of state for field: _ulSrvrDstrbTmTotQ
     */
    private boolean _has_ulSrvrDstrbTmTotQ;


      //----------------/
     //- Constructors -/
    //----------------/

    public ArchOutputStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlPerfTmTotQty()
    {
        this._has_ulPerfTmTotQty= false;
    } //-- void deleteUlPerfTmTotQty() 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     */
    public void deleteUlSrvrDstrbTmTotQ()
    {
        this._has_ulSrvrDstrbTmTotQ= false;
    } //-- void deleteUlSrvrDstrbTmTotQ() 

    /**
     */
    public void deleteUlSvcTmTotQty()
    {
        this._has_ulSvcTmTotQty= false;
    } //-- void deleteUlSvcTmTotQty() 

    /**
     * Returns the value of field 'bMoreDataInd'.
     * 
     * @return the value of field 'BMoreDataInd'.
     */
    public java.lang.String getBMoreDataInd()
    {
        return this._bMoreDataInd;
    } //-- java.lang.String getBMoreDataInd() 

    /**
     * Returns the value of field 'bPerfErrInd'.
     * 
     * @return the value of field 'BPerfErrInd'.
     */
    public java.lang.String getBPerfErrInd()
    {
        return this._bPerfErrInd;
    } //-- java.lang.String getBPerfErrInd() 

    /**
     * Returns the value of field 'szSvcStrtTs'.
     * 
     * @return the value of field 'SzSvcStrtTs'.
     */
    public java.lang.String getSzSvcStrtTs()
    {
        return this._szSvcStrtTs;
    } //-- java.lang.String getSzSvcStrtTs() 

    /**
     * Returns the value of field 'ulPerfTmTotQty'.
     * 
     * @return the value of field 'UlPerfTmTotQty'.
     */
    public int getUlPerfTmTotQty()
    {
        return this._ulPerfTmTotQty;
    } //-- int getUlPerfTmTotQty() 

    /**
     * Returns the value of field 'ulRowQty'.
     * 
     * @return the value of field 'UlRowQty'.
     */
    public int getUlRowQty()
    {
        return this._ulRowQty;
    } //-- int getUlRowQty() 

    /**
     * Returns the value of field 'ulSrvrDstrbTmTotQ'.
     * 
     * @return the value of field 'UlSrvrDstrbTmTotQ'.
     */
    public int getUlSrvrDstrbTmTotQ()
    {
        return this._ulSrvrDstrbTmTotQ;
    } //-- int getUlSrvrDstrbTmTotQ() 

    /**
     * Returns the value of field 'ulSvcTmTotQty'.
     * 
     * @return the value of field 'UlSvcTmTotQty'.
     */
    public int getUlSvcTmTotQty()
    {
        return this._ulSvcTmTotQty;
    } //-- int getUlSvcTmTotQty() 

    /**
     * Method hasUlPerfTmTotQty
     * 
     * 
     * 
     * @return true if at least one UlPerfTmTotQty has been added
     */
    public boolean hasUlPerfTmTotQty()
    {
        return this._has_ulPerfTmTotQty;
    } //-- boolean hasUlPerfTmTotQty() 

    /**
     * Method hasUlRowQty
     * 
     * 
     * 
     * @return true if at least one UlRowQty has been added
     */
    public boolean hasUlRowQty()
    {
        return this._has_ulRowQty;
    } //-- boolean hasUlRowQty() 

    /**
     * Method hasUlSrvrDstrbTmTotQ
     * 
     * 
     * 
     * @return true if at least one UlSrvrDstrbTmTotQ has been added
     */
    public boolean hasUlSrvrDstrbTmTotQ()
    {
        return this._has_ulSrvrDstrbTmTotQ;
    } //-- boolean hasUlSrvrDstrbTmTotQ() 

    /**
     * Method hasUlSvcTmTotQty
     * 
     * 
     * 
     * @return true if at least one UlSvcTmTotQty has been added
     */
    public boolean hasUlSvcTmTotQty()
    {
        return this._has_ulSvcTmTotQty;
    } //-- boolean hasUlSvcTmTotQty() 

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
     * Sets the value of field 'bMoreDataInd'.
     * 
     * @param bMoreDataInd the value of field 'bMoreDataInd'.
     */
    public void setBMoreDataInd(java.lang.String bMoreDataInd)
    {
        this._bMoreDataInd = bMoreDataInd;
    } //-- void setBMoreDataInd(java.lang.String) 

    /**
     * Sets the value of field 'bPerfErrInd'.
     * 
     * @param bPerfErrInd the value of field 'bPerfErrInd'.
     */
    public void setBPerfErrInd(java.lang.String bPerfErrInd)
    {
        this._bPerfErrInd = bPerfErrInd;
    } //-- void setBPerfErrInd(java.lang.String) 

    /**
     * Sets the value of field 'szSvcStrtTs'.
     * 
     * @param szSvcStrtTs the value of field 'szSvcStrtTs'.
     */
    public void setSzSvcStrtTs(java.lang.String szSvcStrtTs)
    {
        this._szSvcStrtTs = szSvcStrtTs;
    } //-- void setSzSvcStrtTs(java.lang.String) 

    /**
     * Sets the value of field 'ulPerfTmTotQty'.
     * 
     * @param ulPerfTmTotQty the value of field 'ulPerfTmTotQty'.
     */
    public void setUlPerfTmTotQty(int ulPerfTmTotQty)
    {
        this._ulPerfTmTotQty = ulPerfTmTotQty;
        this._has_ulPerfTmTotQty = true;
    } //-- void setUlPerfTmTotQty(int) 

    /**
     * Sets the value of field 'ulRowQty'.
     * 
     * @param ulRowQty the value of field 'ulRowQty'.
     */
    public void setUlRowQty(int ulRowQty)
    {
        this._ulRowQty = ulRowQty;
        this._has_ulRowQty = true;
    } //-- void setUlRowQty(int) 

    /**
     * Sets the value of field 'ulSrvrDstrbTmTotQ'.
     * 
     * @param ulSrvrDstrbTmTotQ the value of field
     * 'ulSrvrDstrbTmTotQ'.
     */
    public void setUlSrvrDstrbTmTotQ(int ulSrvrDstrbTmTotQ)
    {
        this._ulSrvrDstrbTmTotQ = ulSrvrDstrbTmTotQ;
        this._has_ulSrvrDstrbTmTotQ = true;
    } //-- void setUlSrvrDstrbTmTotQ(int) 

    /**
     * Sets the value of field 'ulSvcTmTotQty'.
     * 
     * @param ulSvcTmTotQty the value of field 'ulSvcTmTotQty'.
     */
    public void setUlSvcTmTotQty(int ulSvcTmTotQty)
    {
        this._ulSvcTmTotQty = ulSvcTmTotQty;
        this._has_ulSvcTmTotQty = true;
    } //-- void setUlSvcTmTotQty(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct unmarshal(java.io.Reader) 

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
