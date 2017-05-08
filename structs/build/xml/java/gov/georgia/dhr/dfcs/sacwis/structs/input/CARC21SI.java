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
 * Class CARC21SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CARC21SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdRptList
     */
    private int _ulIdRptList;

    /**
     * keeps track of state for field: _ulIdRptList
     */
    private boolean _has_ulIdRptList;

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
     * Field _szTxtEmailMessage
     */
    private java.lang.String _szTxtEmailMessage;

    /**
     * Field _szTxtNmRptType
     */
    private java.lang.String _szTxtNmRptType;


      //----------------/
     //- Constructors -/
    //----------------/

    public CARC21SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CARC21SI()


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
    public void deleteUlIdRptList()
    {
        this._has_ulIdRptList= false;
    } //-- void deleteUlIdRptList() 

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
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Returns the value of field 'ulIdRptList'.
     * 
     * @return the value of field 'UlIdRptList'.
     */
    public int getUlIdRptList()
    {
        return this._ulIdRptList;
    } //-- int getUlIdRptList() 

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
     * Method hasUlIdRptList
     * 
     * 
     * 
     * @return true if at least one UlIdRptList has been added
     */
    public boolean hasUlIdRptList()
    {
        return this._has_ulIdRptList;
    } //-- boolean hasUlIdRptList() 

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
     * Sets the value of field 'ulIdRptList'.
     * 
     * @param ulIdRptList the value of field 'ulIdRptList'.
     */
    public void setUlIdRptList(int ulIdRptList)
    {
        this._ulIdRptList = ulIdRptList;
        this._has_ulIdRptList = true;
    } //-- void setUlIdRptList(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CARC21SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CARC21SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CARC21SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CARC21SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CARC21SI unmarshal(java.io.Reader) 

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
