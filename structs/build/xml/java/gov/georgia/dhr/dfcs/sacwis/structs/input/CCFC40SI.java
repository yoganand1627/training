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
 * Class CCFC40SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC40SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _cSysIndMergeAccess
     */
    private java.lang.String _cSysIndMergeAccess;

    /**
     * Field _cSysIndMergePend
     */
    private java.lang.String _cSysIndMergePend;

    /**
     * Field _cSysIndPostAdopt
     */
    private java.lang.String _cSysIndPostAdopt;

    /**
     * Field _cScrIndToCaseCld
     */
    private java.lang.String _cScrIndToCaseCld;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdCaseMergeFrom
     */
    private int _ulIdCaseMergeFrom;

    /**
     * keeps track of state for field: _ulIdCaseMergeFrom
     */
    private boolean _has_ulIdCaseMergeFrom;

    /**
     * Field _ulIdCaseMergeTo
     */
    private int _ulIdCaseMergeTo;

    /**
     * keeps track of state for field: _ulIdCaseMergeTo
     */
    private boolean _has_ulIdCaseMergeTo;

    /**
     * Field _szCdCaseProgram
     */
    private java.lang.String _szCdCaseProgram;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC40SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC40SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCaseMergeFrom()
    {
        this._has_ulIdCaseMergeFrom= false;
    } //-- void deleteUlIdCaseMergeFrom() 

    /**
     */
    public void deleteUlIdCaseMergeTo()
    {
        this._has_ulIdCaseMergeTo= false;
    } //-- void deleteUlIdCaseMergeTo() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

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
     * Returns the value of field 'cScrIndToCaseCld'.
     * 
     * @return the value of field 'CScrIndToCaseCld'.
     */
    public java.lang.String getCScrIndToCaseCld()
    {
        return this._cScrIndToCaseCld;
    } //-- java.lang.String getCScrIndToCaseCld() 

    /**
     * Returns the value of field 'cSysIndMergeAccess'.
     * 
     * @return the value of field 'CSysIndMergeAccess'.
     */
    public java.lang.String getCSysIndMergeAccess()
    {
        return this._cSysIndMergeAccess;
    } //-- java.lang.String getCSysIndMergeAccess() 

    /**
     * Returns the value of field 'cSysIndMergePend'.
     * 
     * @return the value of field 'CSysIndMergePend'.
     */
    public java.lang.String getCSysIndMergePend()
    {
        return this._cSysIndMergePend;
    } //-- java.lang.String getCSysIndMergePend() 

    /**
     * Returns the value of field 'cSysIndPostAdopt'.
     * 
     * @return the value of field 'CSysIndPostAdopt'.
     */
    public java.lang.String getCSysIndPostAdopt()
    {
        return this._cSysIndPostAdopt;
    } //-- java.lang.String getCSysIndPostAdopt() 

    /**
     * Returns the value of field 'szCdCaseProgram'.
     * 
     * @return the value of field 'SzCdCaseProgram'.
     */
    public java.lang.String getSzCdCaseProgram()
    {
        return this._szCdCaseProgram;
    } //-- java.lang.String getSzCdCaseProgram() 

    /**
     * Returns the value of field 'ulIdCaseMergeFrom'.
     * 
     * @return the value of field 'UlIdCaseMergeFrom'.
     */
    public int getUlIdCaseMergeFrom()
    {
        return this._ulIdCaseMergeFrom;
    } //-- int getUlIdCaseMergeFrom() 

    /**
     * Returns the value of field 'ulIdCaseMergeTo'.
     * 
     * @return the value of field 'UlIdCaseMergeTo'.
     */
    public int getUlIdCaseMergeTo()
    {
        return this._ulIdCaseMergeTo;
    } //-- int getUlIdCaseMergeTo() 

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
     * Method hasUlIdCaseMergeFrom
     * 
     * 
     * 
     * @return true if at least one UlIdCaseMergeFrom has been added
     */
    public boolean hasUlIdCaseMergeFrom()
    {
        return this._has_ulIdCaseMergeFrom;
    } //-- boolean hasUlIdCaseMergeFrom() 

    /**
     * Method hasUlIdCaseMergeTo
     * 
     * 
     * 
     * @return true if at least one UlIdCaseMergeTo has been added
     */
    public boolean hasUlIdCaseMergeTo()
    {
        return this._has_ulIdCaseMergeTo;
    } //-- boolean hasUlIdCaseMergeTo() 

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
     * Sets the value of field 'cScrIndToCaseCld'.
     * 
     * @param cScrIndToCaseCld the value of field 'cScrIndToCaseCld'
     */
    public void setCScrIndToCaseCld(java.lang.String cScrIndToCaseCld)
    {
        this._cScrIndToCaseCld = cScrIndToCaseCld;
    } //-- void setCScrIndToCaseCld(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndMergeAccess'.
     * 
     * @param cSysIndMergeAccess the value of field
     * 'cSysIndMergeAccess'.
     */
    public void setCSysIndMergeAccess(java.lang.String cSysIndMergeAccess)
    {
        this._cSysIndMergeAccess = cSysIndMergeAccess;
    } //-- void setCSysIndMergeAccess(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndMergePend'.
     * 
     * @param cSysIndMergePend the value of field 'cSysIndMergePend'
     */
    public void setCSysIndMergePend(java.lang.String cSysIndMergePend)
    {
        this._cSysIndMergePend = cSysIndMergePend;
    } //-- void setCSysIndMergePend(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndPostAdopt'.
     * 
     * @param cSysIndPostAdopt the value of field 'cSysIndPostAdopt'
     */
    public void setCSysIndPostAdopt(java.lang.String cSysIndPostAdopt)
    {
        this._cSysIndPostAdopt = cSysIndPostAdopt;
    } //-- void setCSysIndPostAdopt(java.lang.String) 

    /**
     * Sets the value of field 'szCdCaseProgram'.
     * 
     * @param szCdCaseProgram the value of field 'szCdCaseProgram'.
     */
    public void setSzCdCaseProgram(java.lang.String szCdCaseProgram)
    {
        this._szCdCaseProgram = szCdCaseProgram;
    } //-- void setSzCdCaseProgram(java.lang.String) 

    /**
     * Sets the value of field 'ulIdCaseMergeFrom'.
     * 
     * @param ulIdCaseMergeFrom the value of field
     * 'ulIdCaseMergeFrom'.
     */
    public void setUlIdCaseMergeFrom(int ulIdCaseMergeFrom)
    {
        this._ulIdCaseMergeFrom = ulIdCaseMergeFrom;
        this._has_ulIdCaseMergeFrom = true;
    } //-- void setUlIdCaseMergeFrom(int) 

    /**
     * Sets the value of field 'ulIdCaseMergeTo'.
     * 
     * @param ulIdCaseMergeTo the value of field 'ulIdCaseMergeTo'.
     */
    public void setUlIdCaseMergeTo(int ulIdCaseMergeTo)
    {
        this._ulIdCaseMergeTo = ulIdCaseMergeTo;
        this._has_ulIdCaseMergeTo = true;
    } //-- void setUlIdCaseMergeTo(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC40SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC40SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC40SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC40SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC40SI unmarshal(java.io.Reader) 

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
