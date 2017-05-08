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
 * Class CCMN88SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN88SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _szCdStageOpen
     */
    private java.lang.String _szCdStageOpen;

    /**
     * Field _szCdStageReasonClosed
     */
    private java.lang.String _szCdStageReasonClosed;

    /**
     * Field _szCdStageProgram
     */
    private java.lang.String _szCdStageProgram;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _ulScrIdPrimChild
     */
    private int _ulScrIdPrimChild;

    /**
     * keeps track of state for field: _ulScrIdPrimChild
     */
    private boolean _has_ulScrIdPrimChild;

    /**
     * Field _cSysIndSStgOpenOnly
     */
    private java.lang.String _cSysIndSStgOpenOnly;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN88SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN88SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     */
    public void deleteUlScrIdPrimChild()
    {
        this._has_ulScrIdPrimChild= false;
    } //-- void deleteUlScrIdPrimChild() 

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
     * Returns the value of field 'cSysIndSStgOpenOnly'.
     * 
     * @return the value of field 'CSysIndSStgOpenOnly'.
     */
    public java.lang.String getCSysIndSStgOpenOnly()
    {
        return this._cSysIndSStgOpenOnly;
    } //-- java.lang.String getCSysIndSStgOpenOnly() 

    /**
     * Returns the value of field 'szCdStage'.
     * 
     * @return the value of field 'SzCdStage'.
     */
    public java.lang.String getSzCdStage()
    {
        return this._szCdStage;
    } //-- java.lang.String getSzCdStage() 

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
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

    /**
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

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
     * Returns the value of field 'ulScrIdPrimChild'.
     * 
     * @return the value of field 'UlScrIdPrimChild'.
     */
    public int getUlScrIdPrimChild()
    {
        return this._ulScrIdPrimChild;
    } //-- int getUlScrIdPrimChild() 

    /**
     * Method hasUlIdPerson
     * 
     * 
     * 
     * @return true if at least one UlIdPerson has been added
     */
    public boolean hasUlIdPerson()
    {
        return this._has_ulIdPerson;
    } //-- boolean hasUlIdPerson() 

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
     * Method hasUlScrIdPrimChild
     * 
     * 
     * 
     * @return true if at least one UlScrIdPrimChild has been added
     */
    public boolean hasUlScrIdPrimChild()
    {
        return this._has_ulScrIdPrimChild;
    } //-- boolean hasUlScrIdPrimChild() 

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
     * Sets the value of field 'cSysIndSStgOpenOnly'.
     * 
     * @param cSysIndSStgOpenOnly the value of field
     * 'cSysIndSStgOpenOnly'.
     */
    public void setCSysIndSStgOpenOnly(java.lang.String cSysIndSStgOpenOnly)
    {
        this._cSysIndSStgOpenOnly = cSysIndSStgOpenOnly;
    } //-- void setCSysIndSStgOpenOnly(java.lang.String) 

    /**
     * Sets the value of field 'szCdStage'.
     * 
     * @param szCdStage the value of field 'szCdStage'.
     */
    public void setSzCdStage(java.lang.String szCdStage)
    {
        this._szCdStage = szCdStage;
    } //-- void setSzCdStage(java.lang.String) 

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
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

    /**
     * Sets the value of field 'ulIdPerson'.
     * 
     * @param ulIdPerson the value of field 'ulIdPerson'.
     */
    public void setUlIdPerson(int ulIdPerson)
    {
        this._ulIdPerson = ulIdPerson;
        this._has_ulIdPerson = true;
    } //-- void setUlIdPerson(int) 

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
     * Sets the value of field 'ulScrIdPrimChild'.
     * 
     * @param ulScrIdPrimChild the value of field 'ulScrIdPrimChild'
     */
    public void setUlScrIdPrimChild(int ulScrIdPrimChild)
    {
        this._ulScrIdPrimChild = ulScrIdPrimChild;
        this._has_ulScrIdPrimChild = true;
    } //-- void setUlScrIdPrimChild(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN88SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN88SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN88SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN88SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN88SI unmarshal(java.io.Reader) 

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
