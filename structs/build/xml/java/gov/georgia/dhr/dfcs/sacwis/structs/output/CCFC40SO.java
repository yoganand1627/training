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
 * Class CCFC40SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC40SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _cSysIndMergeAccess
     */
    private java.lang.String _cSysIndMergeAccess;

    /**
     * Field _cScrIndFromCaseCld
     */
    private java.lang.String _cScrIndFromCaseCld;

    /**
     * Field _szScrNmCaseMrgFrom
     */
    private java.lang.String _szScrNmCaseMrgFrom;

    /**
     * Field _ROWCCFC40SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC40SOG00_ARRAY _ROWCCFC40SOG00_ARRAY;

    /**
     * Field _szCdCaseFromCCLStatus
     */
    private java.lang.String _szCdCaseFromCCLStatus;

    /**
     * Field _szCdCaseToCCLStatus
     */
    private java.lang.String _szCdCaseToCCLStatus;

    /**
     * Field _szCdCasePendEvent
     */
    private java.lang.String _szCdCasePendEvent;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC40SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC40SO()


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
     * Returns the value of field 'cScrIndFromCaseCld'.
     * 
     * @return the value of field 'CScrIndFromCaseCld'.
     */
    public java.lang.String getCScrIndFromCaseCld()
    {
        return this._cScrIndFromCaseCld;
    } //-- java.lang.String getCScrIndFromCaseCld() 

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
     * Returns the value of field 'ROWCCFC40SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCCFC40SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC40SOG00_ARRAY getROWCCFC40SOG00_ARRAY()
    {
        return this._ROWCCFC40SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC40SOG00_ARRAY getROWCCFC40SOG00_ARRAY() 

    /**
     * Returns the value of field 'szCdCaseFromCCLStatus'.
     * 
     * @return the value of field 'SzCdCaseFromCCLStatus'.
     */
    public java.lang.String getSzCdCaseFromCCLStatus()
    {
        return this._szCdCaseFromCCLStatus;
    } //-- java.lang.String getSzCdCaseFromCCLStatus() 

    /**
     * Returns the value of field 'szCdCasePendEvent'.
     * 
     * @return the value of field 'SzCdCasePendEvent'.
     */
    public java.lang.String getSzCdCasePendEvent()
    {
        return this._szCdCasePendEvent;
    } //-- java.lang.String getSzCdCasePendEvent() 

    /**
     * Returns the value of field 'szCdCaseToCCLStatus'.
     * 
     * @return the value of field 'SzCdCaseToCCLStatus'.
     */
    public java.lang.String getSzCdCaseToCCLStatus()
    {
        return this._szCdCaseToCCLStatus;
    } //-- java.lang.String getSzCdCaseToCCLStatus() 

    /**
     * Returns the value of field 'szScrNmCaseMrgFrom'.
     * 
     * @return the value of field 'SzScrNmCaseMrgFrom'.
     */
    public java.lang.String getSzScrNmCaseMrgFrom()
    {
        return this._szScrNmCaseMrgFrom;
    } //-- java.lang.String getSzScrNmCaseMrgFrom() 

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
     * Sets the value of field 'cScrIndFromCaseCld'.
     * 
     * @param cScrIndFromCaseCld the value of field
     * 'cScrIndFromCaseCld'.
     */
    public void setCScrIndFromCaseCld(java.lang.String cScrIndFromCaseCld)
    {
        this._cScrIndFromCaseCld = cScrIndFromCaseCld;
    } //-- void setCScrIndFromCaseCld(java.lang.String) 

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
     * Sets the value of field 'ROWCCFC40SOG00_ARRAY'.
     * 
     * @param ROWCCFC40SOG00_ARRAY the value of field
     * 'ROWCCFC40SOG00_ARRAY'.
     */
    public void setROWCCFC40SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC40SOG00_ARRAY ROWCCFC40SOG00_ARRAY)
    {
        this._ROWCCFC40SOG00_ARRAY = ROWCCFC40SOG00_ARRAY;
    } //-- void setROWCCFC40SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC40SOG00_ARRAY) 

    /**
     * Sets the value of field 'szCdCaseFromCCLStatus'.
     * 
     * @param szCdCaseFromCCLStatus the value of field
     * 'szCdCaseFromCCLStatus'.
     */
    public void setSzCdCaseFromCCLStatus(java.lang.String szCdCaseFromCCLStatus)
    {
        this._szCdCaseFromCCLStatus = szCdCaseFromCCLStatus;
    } //-- void setSzCdCaseFromCCLStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdCasePendEvent'.
     * 
     * @param szCdCasePendEvent the value of field
     * 'szCdCasePendEvent'.
     */
    public void setSzCdCasePendEvent(java.lang.String szCdCasePendEvent)
    {
        this._szCdCasePendEvent = szCdCasePendEvent;
    } //-- void setSzCdCasePendEvent(java.lang.String) 

    /**
     * Sets the value of field 'szCdCaseToCCLStatus'.
     * 
     * @param szCdCaseToCCLStatus the value of field
     * 'szCdCaseToCCLStatus'.
     */
    public void setSzCdCaseToCCLStatus(java.lang.String szCdCaseToCCLStatus)
    {
        this._szCdCaseToCCLStatus = szCdCaseToCCLStatus;
    } //-- void setSzCdCaseToCCLStatus(java.lang.String) 

    /**
     * Sets the value of field 'szScrNmCaseMrgFrom'.
     * 
     * @param szScrNmCaseMrgFrom the value of field
     * 'szScrNmCaseMrgFrom'.
     */
    public void setSzScrNmCaseMrgFrom(java.lang.String szScrNmCaseMrgFrom)
    {
        this._szScrNmCaseMrgFrom = szScrNmCaseMrgFrom;
    } //-- void setSzScrNmCaseMrgFrom(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC40SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC40SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC40SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC40SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC40SO unmarshal(java.io.Reader) 

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
