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
 * Class CCMN40SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN40SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archOutputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct _archOutputStruct;

    /**
     * Field _szAddrMailCode
     */
    private java.lang.String _szAddrMailCode;

    /**
     * Field _szCdOfficeProgram
     */
    private java.lang.String _szCdOfficeProgram;

    /**
     * Field _ulIdOffice
     */
    private int _ulIdOffice;

    /**
     * keeps track of state for field: _ulIdOffice
     */
    private boolean _has_ulIdOffice;

    /**
     * Field _szNmOfficeName
     */
    private java.lang.String _szNmOfficeName;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN40SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN40SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdOffice()
    {
        this._has_ulIdOffice= false;
    } //-- void deleteUlIdOffice() 

    /**
     * Returns the value of field 'archOutputStruct'.
     * 
     * @return the value of field 'ArchOutputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct()
    {
        return this._archOutputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct() 

    /**
     * Returns the value of field 'szAddrMailCode'.
     * 
     * @return the value of field 'SzAddrMailCode'.
     */
    public java.lang.String getSzAddrMailCode()
    {
        return this._szAddrMailCode;
    } //-- java.lang.String getSzAddrMailCode() 

    /**
     * Returns the value of field 'szCdOfficeProgram'.
     * 
     * @return the value of field 'SzCdOfficeProgram'.
     */
    public java.lang.String getSzCdOfficeProgram()
    {
        return this._szCdOfficeProgram;
    } //-- java.lang.String getSzCdOfficeProgram() 

    /**
     * Returns the value of field 'szNmOfficeName'.
     * 
     * @return the value of field 'SzNmOfficeName'.
     */
    public java.lang.String getSzNmOfficeName()
    {
        return this._szNmOfficeName;
    } //-- java.lang.String getSzNmOfficeName() 

    /**
     * Returns the value of field 'ulIdOffice'.
     * 
     * @return the value of field 'UlIdOffice'.
     */
    public int getUlIdOffice()
    {
        return this._ulIdOffice;
    } //-- int getUlIdOffice() 

    /**
     * Method hasUlIdOffice
     * 
     * 
     * 
     * @return true if at least one UlIdOffice has been added
     */
    public boolean hasUlIdOffice()
    {
        return this._has_ulIdOffice;
    } //-- boolean hasUlIdOffice() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

    /**
     * Sets the value of field 'szAddrMailCode'.
     * 
     * @param szAddrMailCode the value of field 'szAddrMailCode'.
     */
    public void setSzAddrMailCode(java.lang.String szAddrMailCode)
    {
        this._szAddrMailCode = szAddrMailCode;
    } //-- void setSzAddrMailCode(java.lang.String) 

    /**
     * Sets the value of field 'szCdOfficeProgram'.
     * 
     * @param szCdOfficeProgram the value of field
     * 'szCdOfficeProgram'.
     */
    public void setSzCdOfficeProgram(java.lang.String szCdOfficeProgram)
    {
        this._szCdOfficeProgram = szCdOfficeProgram;
    } //-- void setSzCdOfficeProgram(java.lang.String) 

    /**
     * Sets the value of field 'szNmOfficeName'.
     * 
     * @param szNmOfficeName the value of field 'szNmOfficeName'.
     */
    public void setSzNmOfficeName(java.lang.String szNmOfficeName)
    {
        this._szNmOfficeName = szNmOfficeName;
    } //-- void setSzNmOfficeName(java.lang.String) 

    /**
     * Sets the value of field 'ulIdOffice'.
     * 
     * @param ulIdOffice the value of field 'ulIdOffice'.
     */
    public void setUlIdOffice(int ulIdOffice)
    {
        this._ulIdOffice = ulIdOffice;
        this._has_ulIdOffice = true;
    } //-- void setUlIdOffice(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN40SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN40SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN40SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN40SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN40SO unmarshal(java.io.Reader) 

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
