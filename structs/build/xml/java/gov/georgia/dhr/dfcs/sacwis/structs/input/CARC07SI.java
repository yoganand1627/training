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
 * Class CARC07SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CARC07SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szNmRptSqrName
     */
    private java.lang.String _szNmRptSqrName;

    /**
     * Field _szNmRptSqrVer
     */
    private java.lang.String _szNmRptSqrVer;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _szTxtEmailMessage
     */
    private java.lang.String _szTxtEmailMessage;

    /**
     * Field _txtRptParmList
     */
    private java.lang.String _txtRptParmList;

    /**
     * Field _ulRptLstCfpStamp
     */
    private int _ulRptLstCfpStamp;

    /**
     * keeps track of state for field: _ulRptLstCfpStamp
     */
    private boolean _has_ulRptLstCfpStamp;

    /**
     * Field _szPassword
     */
    private java.lang.String _szPassword;

    /**
     * Field _szUsername
     */
    private java.lang.String _szUsername;

    /**
     * Field _szTxtNmRptType
     */
    private java.lang.String _szTxtNmRptType;

    /**
     * Field _szIndCaseSensitive
     */
    private java.lang.String _szIndCaseSensitive;


      //----------------/
     //- Constructors -/
    //----------------/

    public CARC07SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CARC07SI()


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
    public void deleteUlRptLstCfpStamp()
    {
        this._has_ulRptLstCfpStamp= false;
    } //-- void deleteUlRptLstCfpStamp() 

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
     * Returns the value of field 'szIndCaseSensitive'.
     * 
     * @return the value of field 'SzIndCaseSensitive'.
     */
    public java.lang.String getSzIndCaseSensitive()
    {
        return this._szIndCaseSensitive;
    } //-- java.lang.String getSzIndCaseSensitive() 

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
     * Returns the value of field 'szNmRptSqrName'.
     * 
     * @return the value of field 'SzNmRptSqrName'.
     */
    public java.lang.String getSzNmRptSqrName()
    {
        return this._szNmRptSqrName;
    } //-- java.lang.String getSzNmRptSqrName() 

    /**
     * Returns the value of field 'szNmRptSqrVer'.
     * 
     * @return the value of field 'SzNmRptSqrVer'.
     */
    public java.lang.String getSzNmRptSqrVer()
    {
        return this._szNmRptSqrVer;
    } //-- java.lang.String getSzNmRptSqrVer() 

    /**
     * Returns the value of field 'szPassword'.
     * 
     * @return the value of field 'SzPassword'.
     */
    public java.lang.String getSzPassword()
    {
        return this._szPassword;
    } //-- java.lang.String getSzPassword() 

    /**
     * Returns the value of field 'szTxtEmailMessage'.
     * 
     * @return the value of field 'SzTxtEmailMessage'.
     */
    public java.lang.String getSzTxtEmailMessage()
    {
        return this._szTxtEmailMessage;
    } //-- java.lang.String getSzTxtEmailMessage() 

    /**
     * Returns the value of field 'szTxtNmRptType'.
     * 
     * @return the value of field 'SzTxtNmRptType'.
     */
    public java.lang.String getSzTxtNmRptType()
    {
        return this._szTxtNmRptType;
    } //-- java.lang.String getSzTxtNmRptType() 

    /**
     * Returns the value of field 'szUsername'.
     * 
     * @return the value of field 'SzUsername'.
     */
    public java.lang.String getSzUsername()
    {
        return this._szUsername;
    } //-- java.lang.String getSzUsername() 

    /**
     * Returns the value of field 'txtRptParmList'.
     * 
     * @return the value of field 'TxtRptParmList'.
     */
    public java.lang.String getTxtRptParmList()
    {
        return this._txtRptParmList;
    } //-- java.lang.String getTxtRptParmList() 

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
     * Returns the value of field 'ulRptLstCfpStamp'.
     * 
     * @return the value of field 'UlRptLstCfpStamp'.
     */
    public int getUlRptLstCfpStamp()
    {
        return this._ulRptLstCfpStamp;
    } //-- int getUlRptLstCfpStamp() 

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
     * Method hasUlRptLstCfpStamp
     * 
     * 
     * 
     * @return true if at least one UlRptLstCfpStamp has been added
     */
    public boolean hasUlRptLstCfpStamp()
    {
        return this._has_ulRptLstCfpStamp;
    } //-- boolean hasUlRptLstCfpStamp() 

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
     * Sets the value of field 'szIndCaseSensitive'.
     * 
     * @param szIndCaseSensitive the value of field
     * 'szIndCaseSensitive'.
     */
    public void setSzIndCaseSensitive(java.lang.String szIndCaseSensitive)
    {
        this._szIndCaseSensitive = szIndCaseSensitive;
    } //-- void setSzIndCaseSensitive(java.lang.String) 

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
     * Sets the value of field 'szNmRptSqrName'.
     * 
     * @param szNmRptSqrName the value of field 'szNmRptSqrName'.
     */
    public void setSzNmRptSqrName(java.lang.String szNmRptSqrName)
    {
        this._szNmRptSqrName = szNmRptSqrName;
    } //-- void setSzNmRptSqrName(java.lang.String) 

    /**
     * Sets the value of field 'szNmRptSqrVer'.
     * 
     * @param szNmRptSqrVer the value of field 'szNmRptSqrVer'.
     */
    public void setSzNmRptSqrVer(java.lang.String szNmRptSqrVer)
    {
        this._szNmRptSqrVer = szNmRptSqrVer;
    } //-- void setSzNmRptSqrVer(java.lang.String) 

    /**
     * Sets the value of field 'szPassword'.
     * 
     * @param szPassword the value of field 'szPassword'.
     */
    public void setSzPassword(java.lang.String szPassword)
    {
        this._szPassword = szPassword;
    } //-- void setSzPassword(java.lang.String) 

    /**
     * Sets the value of field 'szTxtEmailMessage'.
     * 
     * @param szTxtEmailMessage the value of field
     * 'szTxtEmailMessage'.
     */
    public void setSzTxtEmailMessage(java.lang.String szTxtEmailMessage)
    {
        this._szTxtEmailMessage = szTxtEmailMessage;
    } //-- void setSzTxtEmailMessage(java.lang.String) 

    /**
     * Sets the value of field 'szTxtNmRptType'.
     * 
     * @param szTxtNmRptType the value of field 'szTxtNmRptType'.
     */
    public void setSzTxtNmRptType(java.lang.String szTxtNmRptType)
    {
        this._szTxtNmRptType = szTxtNmRptType;
    } //-- void setSzTxtNmRptType(java.lang.String) 

    /**
     * Sets the value of field 'szUsername'.
     * 
     * @param szUsername the value of field 'szUsername'.
     */
    public void setSzUsername(java.lang.String szUsername)
    {
        this._szUsername = szUsername;
    } //-- void setSzUsername(java.lang.String) 

    /**
     * Sets the value of field 'txtRptParmList'.
     * 
     * @param txtRptParmList the value of field 'txtRptParmList'.
     */
    public void setTxtRptParmList(java.lang.String txtRptParmList)
    {
        this._txtRptParmList = txtRptParmList;
    } //-- void setTxtRptParmList(java.lang.String) 

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
     * Sets the value of field 'ulRptLstCfpStamp'.
     * 
     * @param ulRptLstCfpStamp the value of field 'ulRptLstCfpStamp'
     */
    public void setUlRptLstCfpStamp(int ulRptLstCfpStamp)
    {
        this._ulRptLstCfpStamp = ulRptLstCfpStamp;
        this._has_ulRptLstCfpStamp = true;
    } //-- void setUlRptLstCfpStamp(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CARC07SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CARC07SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CARC07SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CARC07SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CARC07SI unmarshal(java.io.Reader) 

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
