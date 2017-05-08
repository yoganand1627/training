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
 * Class CCFC23SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC23SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _cSysIndError
     */
    private java.lang.String _cSysIndError;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _szNmNameFirst
     */
    private java.lang.String _szNmNameFirst;

    /**
     * Field _szNmNameLast
     */
    private java.lang.String _szNmNameLast;

    /**
     * Field _szNmNameMiddle
     */
    private java.lang.String _szNmNameMiddle;

    /**
     * Field _szScrNmNameFirst
     */
    private java.lang.String _szScrNmNameFirst;

    /**
     * Field _szScrNmNameLast
     */
    private java.lang.String _szScrNmNameLast;

    /**
     * Field _szScrNmNameMiddle
     */
    private java.lang.String _szScrNmNameMiddle;

    /**
     * Field _ROWCCFC23SOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC23SOG00 _ROWCCFC23SOG00;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC23SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC23SO()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'cSysIndError'.
     * 
     * @return the value of field 'CSysIndError'.
     */
    public java.lang.String getCSysIndError()
    {
        return this._cSysIndError;
    } //-- java.lang.String getCSysIndError() 

    /**
     * Returns the value of field 'ROWCCFC23SOG00'.
     * 
     * @return the value of field 'ROWCCFC23SOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC23SOG00 getROWCCFC23SOG00()
    {
        return this._ROWCCFC23SOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC23SOG00 getROWCCFC23SOG00() 

    /**
     * Returns the value of field 'szNmNameFirst'.
     * 
     * @return the value of field 'SzNmNameFirst'.
     */
    public java.lang.String getSzNmNameFirst()
    {
        return this._szNmNameFirst;
    } //-- java.lang.String getSzNmNameFirst() 

    /**
     * Returns the value of field 'szNmNameLast'.
     * 
     * @return the value of field 'SzNmNameLast'.
     */
    public java.lang.String getSzNmNameLast()
    {
        return this._szNmNameLast;
    } //-- java.lang.String getSzNmNameLast() 

    /**
     * Returns the value of field 'szNmNameMiddle'.
     * 
     * @return the value of field 'SzNmNameMiddle'.
     */
    public java.lang.String getSzNmNameMiddle()
    {
        return this._szNmNameMiddle;
    } //-- java.lang.String getSzNmNameMiddle() 

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
     * Returns the value of field 'szScrNmNameFirst'.
     * 
     * @return the value of field 'SzScrNmNameFirst'.
     */
    public java.lang.String getSzScrNmNameFirst()
    {
        return this._szScrNmNameFirst;
    } //-- java.lang.String getSzScrNmNameFirst() 

    /**
     * Returns the value of field 'szScrNmNameLast'.
     * 
     * @return the value of field 'SzScrNmNameLast'.
     */
    public java.lang.String getSzScrNmNameLast()
    {
        return this._szScrNmNameLast;
    } //-- java.lang.String getSzScrNmNameLast() 

    /**
     * Returns the value of field 'szScrNmNameMiddle'.
     * 
     * @return the value of field 'SzScrNmNameMiddle'.
     */
    public java.lang.String getSzScrNmNameMiddle()
    {
        return this._szScrNmNameMiddle;
    } //-- java.lang.String getSzScrNmNameMiddle() 

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
     * Sets the value of field 'cSysIndError'.
     * 
     * @param cSysIndError the value of field 'cSysIndError'.
     */
    public void setCSysIndError(java.lang.String cSysIndError)
    {
        this._cSysIndError = cSysIndError;
    } //-- void setCSysIndError(java.lang.String) 

    /**
     * Sets the value of field 'ROWCCFC23SOG00'.
     * 
     * @param ROWCCFC23SOG00 the value of field 'ROWCCFC23SOG00'.
     */
    public void setROWCCFC23SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC23SOG00 ROWCCFC23SOG00)
    {
        this._ROWCCFC23SOG00 = ROWCCFC23SOG00;
    } //-- void setROWCCFC23SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC23SOG00) 

    /**
     * Sets the value of field 'szNmNameFirst'.
     * 
     * @param szNmNameFirst the value of field 'szNmNameFirst'.
     */
    public void setSzNmNameFirst(java.lang.String szNmNameFirst)
    {
        this._szNmNameFirst = szNmNameFirst;
    } //-- void setSzNmNameFirst(java.lang.String) 

    /**
     * Sets the value of field 'szNmNameLast'.
     * 
     * @param szNmNameLast the value of field 'szNmNameLast'.
     */
    public void setSzNmNameLast(java.lang.String szNmNameLast)
    {
        this._szNmNameLast = szNmNameLast;
    } //-- void setSzNmNameLast(java.lang.String) 

    /**
     * Sets the value of field 'szNmNameMiddle'.
     * 
     * @param szNmNameMiddle the value of field 'szNmNameMiddle'.
     */
    public void setSzNmNameMiddle(java.lang.String szNmNameMiddle)
    {
        this._szNmNameMiddle = szNmNameMiddle;
    } //-- void setSzNmNameMiddle(java.lang.String) 

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
     * Sets the value of field 'szScrNmNameFirst'.
     * 
     * @param szScrNmNameFirst the value of field 'szScrNmNameFirst'
     */
    public void setSzScrNmNameFirst(java.lang.String szScrNmNameFirst)
    {
        this._szScrNmNameFirst = szScrNmNameFirst;
    } //-- void setSzScrNmNameFirst(java.lang.String) 

    /**
     * Sets the value of field 'szScrNmNameLast'.
     * 
     * @param szScrNmNameLast the value of field 'szScrNmNameLast'.
     */
    public void setSzScrNmNameLast(java.lang.String szScrNmNameLast)
    {
        this._szScrNmNameLast = szScrNmNameLast;
    } //-- void setSzScrNmNameLast(java.lang.String) 

    /**
     * Sets the value of field 'szScrNmNameMiddle'.
     * 
     * @param szScrNmNameMiddle the value of field
     * 'szScrNmNameMiddle'.
     */
    public void setSzScrNmNameMiddle(java.lang.String szScrNmNameMiddle)
    {
        this._szScrNmNameMiddle = szScrNmNameMiddle;
    } //-- void setSzScrNmNameMiddle(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC23SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC23SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC23SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC23SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC23SO unmarshal(java.io.Reader) 

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
