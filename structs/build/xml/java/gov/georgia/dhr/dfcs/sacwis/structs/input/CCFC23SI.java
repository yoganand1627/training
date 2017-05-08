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
 * Class CCFC23SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC23SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _cWcdPersonPassedIn
     */
    private java.lang.String _cWcdPersonPassedIn;

    /**
     * Field _ulIdPersMergeClosed
     */
    private int _ulIdPersMergeClosed;

    /**
     * keeps track of state for field: _ulIdPersMergeClosed
     */
    private boolean _has_ulIdPersMergeClosed;

    /**
     * Field _ulIdPersMergeForward
     */
    private int _ulIdPersMergeForward;

    /**
     * keeps track of state for field: _ulIdPersMergeForward
     */
    private boolean _has_ulIdPersMergeForward;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC23SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC23SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPersMergeClosed()
    {
        this._has_ulIdPersMergeClosed= false;
    } //-- void deleteUlIdPersMergeClosed() 

    /**
     */
    public void deleteUlIdPersMergeForward()
    {
        this._has_ulIdPersMergeForward= false;
    } //-- void deleteUlIdPersMergeForward() 

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
     * Returns the value of field 'cWcdPersonPassedIn'.
     * 
     * @return the value of field 'CWcdPersonPassedIn'.
     */
    public java.lang.String getCWcdPersonPassedIn()
    {
        return this._cWcdPersonPassedIn;
    } //-- java.lang.String getCWcdPersonPassedIn() 

    /**
     * Returns the value of field 'ulIdPersMergeClosed'.
     * 
     * @return the value of field 'UlIdPersMergeClosed'.
     */
    public int getUlIdPersMergeClosed()
    {
        return this._ulIdPersMergeClosed;
    } //-- int getUlIdPersMergeClosed() 

    /**
     * Returns the value of field 'ulIdPersMergeForward'.
     * 
     * @return the value of field 'UlIdPersMergeForward'.
     */
    public int getUlIdPersMergeForward()
    {
        return this._ulIdPersMergeForward;
    } //-- int getUlIdPersMergeForward() 

    /**
     * Method hasUlIdPersMergeClosed
     * 
     * 
     * 
     * @return true if at least one UlIdPersMergeClosed has been
     * added
     */
    public boolean hasUlIdPersMergeClosed()
    {
        return this._has_ulIdPersMergeClosed;
    } //-- boolean hasUlIdPersMergeClosed() 

    /**
     * Method hasUlIdPersMergeForward
     * 
     * 
     * 
     * @return true if at least one UlIdPersMergeForward has been
     * added
     */
    public boolean hasUlIdPersMergeForward()
    {
        return this._has_ulIdPersMergeForward;
    } //-- boolean hasUlIdPersMergeForward() 

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
     * Sets the value of field 'cWcdPersonPassedIn'.
     * 
     * @param cWcdPersonPassedIn the value of field
     * 'cWcdPersonPassedIn'.
     */
    public void setCWcdPersonPassedIn(java.lang.String cWcdPersonPassedIn)
    {
        this._cWcdPersonPassedIn = cWcdPersonPassedIn;
    } //-- void setCWcdPersonPassedIn(java.lang.String) 

    /**
     * Sets the value of field 'ulIdPersMergeClosed'.
     * 
     * @param ulIdPersMergeClosed the value of field
     * 'ulIdPersMergeClosed'.
     */
    public void setUlIdPersMergeClosed(int ulIdPersMergeClosed)
    {
        this._ulIdPersMergeClosed = ulIdPersMergeClosed;
        this._has_ulIdPersMergeClosed = true;
    } //-- void setUlIdPersMergeClosed(int) 

    /**
     * Sets the value of field 'ulIdPersMergeForward'.
     * 
     * @param ulIdPersMergeForward the value of field
     * 'ulIdPersMergeForward'.
     */
    public void setUlIdPersMergeForward(int ulIdPersMergeForward)
    {
        this._ulIdPersMergeForward = ulIdPersMergeForward;
        this._has_ulIdPersMergeForward = true;
    } //-- void setUlIdPersMergeForward(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC23SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC23SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC23SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC23SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC23SI unmarshal(java.io.Reader) 

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
