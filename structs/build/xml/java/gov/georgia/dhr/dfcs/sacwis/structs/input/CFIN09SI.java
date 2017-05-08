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
 * Class CFIN09SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFIN09SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdRejRsnRejItemId
     */
    private java.lang.String _szCdRejRsnRejItemId;

    /**
     * Field _ulIdRejectedItemId
     */
    private int _ulIdRejectedItemId;

    /**
     * keeps track of state for field: _ulIdRejectedItemId
     */
    private boolean _has_ulIdRejectedItemId;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFIN09SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN09SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdRejectedItemId()
    {
        this._has_ulIdRejectedItemId= false;
    } //-- void deleteUlIdRejectedItemId() 

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
     * Returns the value of field 'szCdRejRsnRejItemId'.
     * 
     * @return the value of field 'SzCdRejRsnRejItemId'.
     */
    public java.lang.String getSzCdRejRsnRejItemId()
    {
        return this._szCdRejRsnRejItemId;
    } //-- java.lang.String getSzCdRejRsnRejItemId() 

    /**
     * Returns the value of field 'ulIdRejectedItemId'.
     * 
     * @return the value of field 'UlIdRejectedItemId'.
     */
    public int getUlIdRejectedItemId()
    {
        return this._ulIdRejectedItemId;
    } //-- int getUlIdRejectedItemId() 

    /**
     * Method hasUlIdRejectedItemId
     * 
     * 
     * 
     * @return true if at least one UlIdRejectedItemId has been adde
     */
    public boolean hasUlIdRejectedItemId()
    {
        return this._has_ulIdRejectedItemId;
    } //-- boolean hasUlIdRejectedItemId() 

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
     * Sets the value of field 'szCdRejRsnRejItemId'.
     * 
     * @param szCdRejRsnRejItemId the value of field
     * 'szCdRejRsnRejItemId'.
     */
    public void setSzCdRejRsnRejItemId(java.lang.String szCdRejRsnRejItemId)
    {
        this._szCdRejRsnRejItemId = szCdRejRsnRejItemId;
    } //-- void setSzCdRejRsnRejItemId(java.lang.String) 

    /**
     * Sets the value of field 'ulIdRejectedItemId'.
     * 
     * @param ulIdRejectedItemId the value of field
     * 'ulIdRejectedItemId'.
     */
    public void setUlIdRejectedItemId(int ulIdRejectedItemId)
    {
        this._ulIdRejectedItemId = ulIdRejectedItemId;
        this._has_ulIdRejectedItemId = true;
    } //-- void setUlIdRejectedItemId(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN09SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN09SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN09SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN09SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN09SI unmarshal(java.io.Reader) 

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
