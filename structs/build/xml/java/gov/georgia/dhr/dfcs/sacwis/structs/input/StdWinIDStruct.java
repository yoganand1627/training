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
 * Class StdWinIDStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class StdWinIDStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _sysStdWinHandle
     */
    private java.lang.String _sysStdWinHandle;

    /**
     * Field _szScrTxtStdWinName
     */
    private java.lang.String _szScrTxtStdWinName;

    /**
     * Field _szScrTxtStdWinInst
     */
    private java.lang.String _szScrTxtStdWinInst;


      //----------------/
     //- Constructors -/
    //----------------/

    public StdWinIDStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.StdWinIDStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'sysStdWinHandle'.
     * 
     * @return the value of field 'SysStdWinHandle'.
     */
    public java.lang.String getSysStdWinHandle()
    {
        return this._sysStdWinHandle;
    } //-- java.lang.String getSysStdWinHandle() 

    /**
     * Returns the value of field 'szScrTxtStdWinInst'.
     * 
     * @return the value of field 'SzScrTxtStdWinInst'.
     */
    public java.lang.String getSzScrTxtStdWinInst()
    {
        return this._szScrTxtStdWinInst;
    } //-- java.lang.String getSzScrTxtStdWinInst() 

    /**
     * Returns the value of field 'szScrTxtStdWinName'.
     * 
     * @return the value of field 'SzScrTxtStdWinName'.
     */
    public java.lang.String getSzScrTxtStdWinName()
    {
        return this._szScrTxtStdWinName;
    } //-- java.lang.String getSzScrTxtStdWinName() 

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
     * Sets the value of field 'sysStdWinHandle'.
     * 
     * @param sysStdWinHandle the value of field 'sysStdWinHandle'.
     */
    public void setSysStdWinHandle(java.lang.String sysStdWinHandle)
    {
        this._sysStdWinHandle = sysStdWinHandle;
    } //-- void setSysStdWinHandle(java.lang.String) 

    /**
     * Sets the value of field 'szScrTxtStdWinInst'.
     * 
     * @param szScrTxtStdWinInst the value of field
     * 'szScrTxtStdWinInst'.
     */
    public void setSzScrTxtStdWinInst(java.lang.String szScrTxtStdWinInst)
    {
        this._szScrTxtStdWinInst = szScrTxtStdWinInst;
    } //-- void setSzScrTxtStdWinInst(java.lang.String) 

    /**
     * Sets the value of field 'szScrTxtStdWinName'.
     * 
     * @param szScrTxtStdWinName the value of field
     * 'szScrTxtStdWinName'.
     */
    public void setSzScrTxtStdWinName(java.lang.String szScrTxtStdWinName)
    {
        this._szScrTxtStdWinName = szScrTxtStdWinName;
    } //-- void setSzScrTxtStdWinName(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.StdWinIDStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.StdWinIDStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.StdWinIDStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.StdWinIDStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.StdWinIDStruct unmarshal(java.io.Reader) 

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
