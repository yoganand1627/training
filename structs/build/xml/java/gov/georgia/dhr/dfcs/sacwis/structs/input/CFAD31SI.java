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
 * Class CFAD31SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD31SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _indSystem
     */
    private java.lang.String _indSystem;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _bWcdCdSortBy
     */
    private java.lang.String _bWcdCdSortBy;

    /**
     * Field _ROWCFAD31SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD31SIG00_ARRAY _ROWCFAD31SIG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD31SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD31SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

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
     * Returns the value of field 'bWcdCdSortBy'.
     * 
     * @return the value of field 'BWcdCdSortBy'.
     */
    public java.lang.String getBWcdCdSortBy()
    {
        return this._bWcdCdSortBy;
    } //-- java.lang.String getBWcdCdSortBy() 

    /**
     * Returns the value of field 'indSystem'.
     * 
     * @return the value of field 'IndSystem'.
     */
    public java.lang.String getIndSystem()
    {
        return this._indSystem;
    } //-- java.lang.String getIndSystem() 

    /**
     * Returns the value of field 'ROWCFAD31SIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCFAD31SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD31SIG00_ARRAY getROWCFAD31SIG00_ARRAY()
    {
        return this._ROWCFAD31SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD31SIG00_ARRAY getROWCFAD31SIG00_ARRAY() 

    /**
     * Returns the value of field 'ulIdStage'.
     * 
     * @return the value of field 'UlIdStage'.
     */
    public int getUlIdStage()
    {
        return this._ulIdStage;
    } //-- int getUlIdStage() 

    /**
     * Method hasUlIdStage
     * 
     * 
     * 
     * @return true if at least one UlIdStage has been added
     */
    public boolean hasUlIdStage()
    {
        return this._has_ulIdStage;
    } //-- boolean hasUlIdStage() 

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
     * Sets the value of field 'bWcdCdSortBy'.
     * 
     * @param bWcdCdSortBy the value of field 'bWcdCdSortBy'.
     */
    public void setBWcdCdSortBy(java.lang.String bWcdCdSortBy)
    {
        this._bWcdCdSortBy = bWcdCdSortBy;
    } //-- void setBWcdCdSortBy(java.lang.String) 

    /**
     * Sets the value of field 'indSystem'.
     * 
     * @param indSystem the value of field 'indSystem'.
     */
    public void setIndSystem(java.lang.String indSystem)
    {
        this._indSystem = indSystem;
    } //-- void setIndSystem(java.lang.String) 

    /**
     * Sets the value of field 'ROWCFAD31SIG00_ARRAY'.
     * 
     * @param ROWCFAD31SIG00_ARRAY the value of field
     * 'ROWCFAD31SIG00_ARRAY'.
     */
    public void setROWCFAD31SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD31SIG00_ARRAY ROWCFAD31SIG00_ARRAY)
    {
        this._ROWCFAD31SIG00_ARRAY = ROWCFAD31SIG00_ARRAY;
    } //-- void setROWCFAD31SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD31SIG00_ARRAY) 

    /**
     * Sets the value of field 'ulIdStage'.
     * 
     * @param ulIdStage the value of field 'ulIdStage'.
     */
    public void setUlIdStage(int ulIdStage)
    {
        this._ulIdStage = ulIdStage;
        this._has_ulIdStage = true;
    } //-- void setUlIdStage(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD31SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD31SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD31SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD31SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD31SI unmarshal(java.io.Reader) 

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