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
 * Class CCMN29SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN29SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdUnitCounty
     */
    private java.lang.String _szCdUnitCounty;

    /**
     * Field _szCdUnitRegion
     */
    private java.lang.String _szCdUnitRegion;

    /**
     * Field _szNbrUnit
     */
    private java.lang.String _szNbrUnit;

    /**
     * Field _ulIdPerson_ARRAY_CCMN29SI
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN29SI _ulIdPerson_ARRAY_CCMN29SI;

    /**
     * Field _cScrIndAsgnTotal
     */
    private java.lang.String _cScrIndAsgnTotal;

    /**
     * Field _szOrderBy
     */
    private java.lang.String _szOrderBy;

    /**
     * Field _szSortDir
     */
    private java.lang.String _szSortDir;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN29SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN29SI()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'cScrIndAsgnTotal'.
     * 
     * @return the value of field 'CScrIndAsgnTotal'.
     */
    public java.lang.String getCScrIndAsgnTotal()
    {
        return this._cScrIndAsgnTotal;
    } //-- java.lang.String getCScrIndAsgnTotal() 

    /**
     * Returns the value of field 'szCdUnitCounty'.
     * 
     * @return the value of field 'SzCdUnitCounty'.
     */
    public java.lang.String getSzCdUnitCounty()
    {
        return this._szCdUnitCounty;
    } //-- java.lang.String getSzCdUnitCounty() 

    /**
     * Returns the value of field 'szCdUnitRegion'.
     * 
     * @return the value of field 'SzCdUnitRegion'.
     */
    public java.lang.String getSzCdUnitRegion()
    {
        return this._szCdUnitRegion;
    } //-- java.lang.String getSzCdUnitRegion() 

    /**
     * Returns the value of field 'szNbrUnit'.
     * 
     * @return the value of field 'SzNbrUnit'.
     */
    public java.lang.String getSzNbrUnit()
    {
        return this._szNbrUnit;
    } //-- java.lang.String getSzNbrUnit() 

    /**
     * Returns the value of field 'szOrderBy'.
     * 
     * @return the value of field 'SzOrderBy'.
     */
    public java.lang.String getSzOrderBy()
    {
        return this._szOrderBy;
    } //-- java.lang.String getSzOrderBy() 

    /**
     * Returns the value of field 'szSortDir'.
     * 
     * @return the value of field 'SzSortDir'.
     */
    public java.lang.String getSzSortDir()
    {
        return this._szSortDir;
    } //-- java.lang.String getSzSortDir() 

    /**
     * Returns the value of field 'ulIdPerson_ARRAY_CCMN29SI'.
     * 
     * @return the value of field 'UlIdPerson_ARRAY_CCMN29SI'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN29SI getUlIdPerson_ARRAY_CCMN29SI()
    {
        return this._ulIdPerson_ARRAY_CCMN29SI;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN29SI getUlIdPerson_ARRAY_CCMN29SI() 

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
     * Sets the value of field 'cScrIndAsgnTotal'.
     * 
     * @param cScrIndAsgnTotal the value of field 'cScrIndAsgnTotal'
     */
    public void setCScrIndAsgnTotal(java.lang.String cScrIndAsgnTotal)
    {
        this._cScrIndAsgnTotal = cScrIndAsgnTotal;
    } //-- void setCScrIndAsgnTotal(java.lang.String) 

    /**
     * Sets the value of field 'szCdUnitCounty'.
     * 
     * @param szCdUnitCounty the value of field 'szCdUnitCounty'.
     */
    public void setSzCdUnitCounty(java.lang.String szCdUnitCounty)
    {
        this._szCdUnitCounty = szCdUnitCounty;
    } //-- void setSzCdUnitCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdUnitRegion'.
     * 
     * @param szCdUnitRegion the value of field 'szCdUnitRegion'.
     */
    public void setSzCdUnitRegion(java.lang.String szCdUnitRegion)
    {
        this._szCdUnitRegion = szCdUnitRegion;
    } //-- void setSzCdUnitRegion(java.lang.String) 

    /**
     * Sets the value of field 'szNbrUnit'.
     * 
     * @param szNbrUnit the value of field 'szNbrUnit'.
     */
    public void setSzNbrUnit(java.lang.String szNbrUnit)
    {
        this._szNbrUnit = szNbrUnit;
    } //-- void setSzNbrUnit(java.lang.String) 

    /**
     * Sets the value of field 'szOrderBy'.
     * 
     * @param szOrderBy the value of field 'szOrderBy'.
     */
    public void setSzOrderBy(java.lang.String szOrderBy)
    {
        this._szOrderBy = szOrderBy;
    } //-- void setSzOrderBy(java.lang.String) 

    /**
     * Sets the value of field 'szSortDir'.
     * 
     * @param szSortDir the value of field 'szSortDir'.
     */
    public void setSzSortDir(java.lang.String szSortDir)
    {
        this._szSortDir = szSortDir;
    } //-- void setSzSortDir(java.lang.String) 

    /**
     * Sets the value of field 'ulIdPerson_ARRAY_CCMN29SI'.
     * 
     * @param ulIdPerson_ARRAY_CCMN29SI the value of field
     * 'ulIdPerson_ARRAY_CCMN29SI'.
     */
    public void setUlIdPerson_ARRAY_CCMN29SI(gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN29SI ulIdPerson_ARRAY_CCMN29SI)
    {
        this._ulIdPerson_ARRAY_CCMN29SI = ulIdPerson_ARRAY_CCMN29SI;
    } //-- void setUlIdPerson_ARRAY_CCMN29SI(gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN29SI) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN29SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN29SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN29SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN29SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN29SI unmarshal(java.io.Reader) 

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
