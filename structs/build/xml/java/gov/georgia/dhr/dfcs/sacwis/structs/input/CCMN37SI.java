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
 * Class CCMN37SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN37SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _szCdStageProgram
     */
    private java.lang.String _szCdStageProgram;

    /**
     * Field _cScrIndSealed
     */
    private java.lang.String _cScrIndSealed;

    /**
     * Field _bIndPadCase
     */
    private java.lang.String _bIndPadCase;

    /**
     * Field _ulIdAdoCase
     */
    private int _ulIdAdoCase;

    /**
     * keeps track of state for field: _ulIdAdoCase
     */
    private boolean _has_ulIdAdoCase;

    /**
     * Field _ulIdPadCase
     */
    private int _ulIdPadCase;

    /**
     * keeps track of state for field: _ulIdPadCase
     */
    private boolean _has_ulIdPadCase;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN37SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN37SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdAdoCase()
    {
        this._has_ulIdAdoCase= false;
    } //-- void deleteUlIdAdoCase() 

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

    /**
     */
    public void deleteUlIdPadCase()
    {
        this._has_ulIdPadCase= false;
    } //-- void deleteUlIdPadCase() 

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
     * Returns the value of field 'bIndPadCase'.
     * 
     * @return the value of field 'BIndPadCase'.
     */
    public java.lang.String getBIndPadCase()
    {
        return this._bIndPadCase;
    } //-- java.lang.String getBIndPadCase() 

    /**
     * Returns the value of field 'cScrIndSealed'.
     * 
     * @return the value of field 'CScrIndSealed'.
     */
    public java.lang.String getCScrIndSealed()
    {
        return this._cScrIndSealed;
    } //-- java.lang.String getCScrIndSealed() 

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
     * Returns the value of field 'ulIdAdoCase'.
     * 
     * @return the value of field 'UlIdAdoCase'.
     */
    public int getUlIdAdoCase()
    {
        return this._ulIdAdoCase;
    } //-- int getUlIdAdoCase() 

    /**
     * Returns the value of field 'ulIdCase'.
     * 
     * @return the value of field 'UlIdCase'.
     */
    public int getUlIdCase()
    {
        return this._ulIdCase;
    } //-- int getUlIdCase() 

    /**
     * Returns the value of field 'ulIdPadCase'.
     * 
     * @return the value of field 'UlIdPadCase'.
     */
    public int getUlIdPadCase()
    {
        return this._ulIdPadCase;
    } //-- int getUlIdPadCase() 

    /**
     * Method hasUlIdAdoCase
     * 
     * 
     * 
     * @return true if at least one UlIdAdoCase has been added
     */
    public boolean hasUlIdAdoCase()
    {
        return this._has_ulIdAdoCase;
    } //-- boolean hasUlIdAdoCase() 

    /**
     * Method hasUlIdCase
     * 
     * 
     * 
     * @return true if at least one UlIdCase has been added
     */
    public boolean hasUlIdCase()
    {
        return this._has_ulIdCase;
    } //-- boolean hasUlIdCase() 

    /**
     * Method hasUlIdPadCase
     * 
     * 
     * 
     * @return true if at least one UlIdPadCase has been added
     */
    public boolean hasUlIdPadCase()
    {
        return this._has_ulIdPadCase;
    } //-- boolean hasUlIdPadCase() 

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
     * Sets the value of field 'bIndPadCase'.
     * 
     * @param bIndPadCase the value of field 'bIndPadCase'.
     */
    public void setBIndPadCase(java.lang.String bIndPadCase)
    {
        this._bIndPadCase = bIndPadCase;
    } //-- void setBIndPadCase(java.lang.String) 

    /**
     * Sets the value of field 'cScrIndSealed'.
     * 
     * @param cScrIndSealed the value of field 'cScrIndSealed'.
     */
    public void setCScrIndSealed(java.lang.String cScrIndSealed)
    {
        this._cScrIndSealed = cScrIndSealed;
    } //-- void setCScrIndSealed(java.lang.String) 

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
     * Sets the value of field 'ulIdAdoCase'.
     * 
     * @param ulIdAdoCase the value of field 'ulIdAdoCase'.
     */
    public void setUlIdAdoCase(int ulIdAdoCase)
    {
        this._ulIdAdoCase = ulIdAdoCase;
        this._has_ulIdAdoCase = true;
    } //-- void setUlIdAdoCase(int) 

    /**
     * Sets the value of field 'ulIdCase'.
     * 
     * @param ulIdCase the value of field 'ulIdCase'.
     */
    public void setUlIdCase(int ulIdCase)
    {
        this._ulIdCase = ulIdCase;
        this._has_ulIdCase = true;
    } //-- void setUlIdCase(int) 

    /**
     * Sets the value of field 'ulIdPadCase'.
     * 
     * @param ulIdPadCase the value of field 'ulIdPadCase'.
     */
    public void setUlIdPadCase(int ulIdPadCase)
    {
        this._ulIdPadCase = ulIdPadCase;
        this._has_ulIdPadCase = true;
    } //-- void setUlIdPadCase(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN37SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN37SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN37SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN37SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN37SI unmarshal(java.io.Reader) 

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
