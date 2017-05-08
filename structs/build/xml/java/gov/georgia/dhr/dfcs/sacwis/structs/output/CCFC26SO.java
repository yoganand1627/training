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
 * Class CCFC26SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC26SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _cIndRecCheckDpsIncomplete
     */
    private java.lang.String _cIndRecCheckDpsIncomplete;

    /**
     * Field _cCdPersonSex
     */
    private java.lang.String _cCdPersonSex;

    /**
     * Field _dtDtPersonBirth
     */
    private org.exolab.castor.types.Date _dtDtPersonBirth;

    /**
     * Field _bIndPersonDobApprox
     */
    private java.lang.String _bIndPersonDobApprox;

    /**
     * Field _szCdPersonEthnicGroup
     */
    private java.lang.String _szCdPersonEthnicGroup;

    /**
     * Field _szNmNameFirst
     */
    private java.lang.String _szNmNameFirst;

    /**
     * Field _szNmNameLast
     */
    private java.lang.String _szNmNameLast;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _szScrNmRequestedBy
     */
    private java.lang.String _szScrNmRequestedBy;

    /**
     * Field _ROWCCFC26SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00_ARRAY _ROWCCFC26SOG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC26SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO()


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
     * Returns the value of field 'bIndPersonDobApprox'.
     * 
     * @return the value of field 'BIndPersonDobApprox'.
     */
    public java.lang.String getBIndPersonDobApprox()
    {
        return this._bIndPersonDobApprox;
    } //-- java.lang.String getBIndPersonDobApprox() 

    /**
     * Returns the value of field 'cCdPersonSex'.
     * 
     * @return the value of field 'CCdPersonSex'.
     */
    public java.lang.String getCCdPersonSex()
    {
        return this._cCdPersonSex;
    } //-- java.lang.String getCCdPersonSex() 

    /**
     * Returns the value of field 'cIndRecCheckDpsIncomplete'.
     * 
     * @return the value of field 'CIndRecCheckDpsIncomplete'.
     */
    public java.lang.String getCIndRecCheckDpsIncomplete()
    {
        return this._cIndRecCheckDpsIncomplete;
    } //-- java.lang.String getCIndRecCheckDpsIncomplete() 

    /**
     * Returns the value of field 'dtDtPersonBirth'.
     * 
     * @return the value of field 'DtDtPersonBirth'.
     */
    public org.exolab.castor.types.Date getDtDtPersonBirth()
    {
        return this._dtDtPersonBirth;
    } //-- org.exolab.castor.types.Date getDtDtPersonBirth() 

    /**
     * Returns the value of field 'dtWCDDtSystemDate'.
     * 
     * @return the value of field 'DtWCDDtSystemDate'.
     */
    public org.exolab.castor.types.Date getDtWCDDtSystemDate()
    {
        return this._dtWCDDtSystemDate;
    } //-- org.exolab.castor.types.Date getDtWCDDtSystemDate() 

    /**
     * Returns the value of field 'ROWCCFC26SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCCFC26SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00_ARRAY getROWCCFC26SOG00_ARRAY()
    {
        return this._ROWCCFC26SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00_ARRAY getROWCCFC26SOG00_ARRAY() 

    /**
     * Returns the value of field 'szCdPersonEthnicGroup'.
     * 
     * @return the value of field 'SzCdPersonEthnicGroup'.
     */
    public java.lang.String getSzCdPersonEthnicGroup()
    {
        return this._szCdPersonEthnicGroup;
    } //-- java.lang.String getSzCdPersonEthnicGroup() 

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
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

    /**
     * Returns the value of field 'szScrNmRequestedBy'.
     * 
     * @return the value of field 'SzScrNmRequestedBy'.
     */
    public java.lang.String getSzScrNmRequestedBy()
    {
        return this._szScrNmRequestedBy;
    } //-- java.lang.String getSzScrNmRequestedBy() 

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
     * Sets the value of field 'bIndPersonDobApprox'.
     * 
     * @param bIndPersonDobApprox the value of field
     * 'bIndPersonDobApprox'.
     */
    public void setBIndPersonDobApprox(java.lang.String bIndPersonDobApprox)
    {
        this._bIndPersonDobApprox = bIndPersonDobApprox;
    } //-- void setBIndPersonDobApprox(java.lang.String) 

    /**
     * Sets the value of field 'cCdPersonSex'.
     * 
     * @param cCdPersonSex the value of field 'cCdPersonSex'.
     */
    public void setCCdPersonSex(java.lang.String cCdPersonSex)
    {
        this._cCdPersonSex = cCdPersonSex;
    } //-- void setCCdPersonSex(java.lang.String) 

    /**
     * Sets the value of field 'cIndRecCheckDpsIncomplete'.
     * 
     * @param cIndRecCheckDpsIncomplete the value of field
     * 'cIndRecCheckDpsIncomplete'.
     */
    public void setCIndRecCheckDpsIncomplete(java.lang.String cIndRecCheckDpsIncomplete)
    {
        this._cIndRecCheckDpsIncomplete = cIndRecCheckDpsIncomplete;
    } //-- void setCIndRecCheckDpsIncomplete(java.lang.String) 

    /**
     * Sets the value of field 'dtDtPersonBirth'.
     * 
     * @param dtDtPersonBirth the value of field 'dtDtPersonBirth'.
     */
    public void setDtDtPersonBirth(org.exolab.castor.types.Date dtDtPersonBirth)
    {
        this._dtDtPersonBirth = dtDtPersonBirth;
    } //-- void setDtDtPersonBirth(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtWCDDtSystemDate'.
     * 
     * @param dtWCDDtSystemDate the value of field
     * 'dtWCDDtSystemDate'.
     */
    public void setDtWCDDtSystemDate(org.exolab.castor.types.Date dtWCDDtSystemDate)
    {
        this._dtWCDDtSystemDate = dtWCDDtSystemDate;
    } //-- void setDtWCDDtSystemDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCCFC26SOG00_ARRAY'.
     * 
     * @param ROWCCFC26SOG00_ARRAY the value of field
     * 'ROWCCFC26SOG00_ARRAY'.
     */
    public void setROWCCFC26SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00_ARRAY ROWCCFC26SOG00_ARRAY)
    {
        this._ROWCCFC26SOG00_ARRAY = ROWCCFC26SOG00_ARRAY;
    } //-- void setROWCCFC26SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00_ARRAY) 

    /**
     * Sets the value of field 'szCdPersonEthnicGroup'.
     * 
     * @param szCdPersonEthnicGroup the value of field
     * 'szCdPersonEthnicGroup'.
     */
    public void setSzCdPersonEthnicGroup(java.lang.String szCdPersonEthnicGroup)
    {
        this._szCdPersonEthnicGroup = szCdPersonEthnicGroup;
    } //-- void setSzCdPersonEthnicGroup(java.lang.String) 

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
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

    /**
     * Sets the value of field 'szScrNmRequestedBy'.
     * 
     * @param szScrNmRequestedBy the value of field
     * 'szScrNmRequestedBy'.
     */
    public void setSzScrNmRequestedBy(java.lang.String szScrNmRequestedBy)
    {
        this._szScrNmRequestedBy = szScrNmRequestedBy;
    } //-- void setSzScrNmRequestedBy(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO unmarshal(java.io.Reader) 

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
