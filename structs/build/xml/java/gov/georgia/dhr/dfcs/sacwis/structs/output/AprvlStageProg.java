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
 * Class AprvlStageProg.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AprvlStageProg extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdStageProgram
     */
    private java.lang.String _szCdStageProgram;

    /**
     * Field _szCdStageReasonClosed
     */
    private java.lang.String _szCdStageReasonClosed;

    /**
     * Field _szCdStageOpen
     */
    private java.lang.String _szCdStageOpen;

    /**
     * Field _cWCDCdStageProgressMode
     */
    private java.lang.String _cWCDCdStageProgressMode;


      //----------------/
     //- Constructors -/
    //----------------/

    public AprvlStageProg() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AprvlStageProg()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'cWCDCdStageProgressMode'.
     * 
     * @return the value of field 'CWCDCdStageProgressMode'.
     */
    public java.lang.String getCWCDCdStageProgressMode()
    {
        return this._cWCDCdStageProgressMode;
    } //-- java.lang.String getCWCDCdStageProgressMode() 

    /**
     * Returns the value of field 'szCdStageOpen'.
     * 
     * @return the value of field 'SzCdStageOpen'.
     */
    public java.lang.String getSzCdStageOpen()
    {
        return this._szCdStageOpen;
    } //-- java.lang.String getSzCdStageOpen() 

    /**
     * Returns the value of field 'szCdStageProgram'.
     * 
     * @return the value of field 'SzCdStageProgram'.
     */
    public java.lang.String getSzCdStageProgram()
    {
        return this._szCdStageProgram;
    } //-- java.lang.String getSzCdStageProgram() 

    /**
     * Returns the value of field 'szCdStageReasonClosed'.
     * 
     * @return the value of field 'SzCdStageReasonClosed'.
     */
    public java.lang.String getSzCdStageReasonClosed()
    {
        return this._szCdStageReasonClosed;
    } //-- java.lang.String getSzCdStageReasonClosed() 

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
     * Sets the value of field 'cWCDCdStageProgressMode'.
     * 
     * @param cWCDCdStageProgressMode the value of field
     * 'cWCDCdStageProgressMode'.
     */
    public void setCWCDCdStageProgressMode(java.lang.String cWCDCdStageProgressMode)
    {
        this._cWCDCdStageProgressMode = cWCDCdStageProgressMode;
    } //-- void setCWCDCdStageProgressMode(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageOpen'.
     * 
     * @param szCdStageOpen the value of field 'szCdStageOpen'.
     */
    public void setSzCdStageOpen(java.lang.String szCdStageOpen)
    {
        this._szCdStageOpen = szCdStageOpen;
    } //-- void setSzCdStageOpen(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageProgram'.
     * 
     * @param szCdStageProgram the value of field 'szCdStageProgram'
     */
    public void setSzCdStageProgram(java.lang.String szCdStageProgram)
    {
        this._szCdStageProgram = szCdStageProgram;
    } //-- void setSzCdStageProgram(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageReasonClosed'.
     * 
     * @param szCdStageReasonClosed the value of field
     * 'szCdStageReasonClosed'.
     */
    public void setSzCdStageReasonClosed(java.lang.String szCdStageReasonClosed)
    {
        this._szCdStageReasonClosed = szCdStageReasonClosed;
    } //-- void setSzCdStageReasonClosed(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.AprvlStageProg
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.AprvlStageProg unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AprvlStageProg) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.AprvlStageProg.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AprvlStageProg unmarshal(java.io.Reader) 

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
