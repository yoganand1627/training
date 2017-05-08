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
 * Class CSYS04SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSYS04SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdRsrcCategory
     */
    private java.lang.String _szCdRsrcCategory;

    /**
     * Field _indCanAddCntct
     */
    private java.lang.String _indCanAddCntct;

    /**
     * Field _archOutputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct _archOutputStruct;

    /**
     * Field _ulRowQty2
     */
    private int _ulRowQty2;

    /**
     * keeps track of state for field: _ulRowQty2
     */
    private boolean _has_ulRowQty2;

    /**
     * Field _ROWCSYS04SO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY _ROWCSYS04SO_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSYS04SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS04SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlRowQty2()
    {
        this._has_ulRowQty2= false;
    } //-- void deleteUlRowQty2() 

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
     * Returns the value of field 'indCanAddCntct'.
     * 
     * @return the value of field 'IndCanAddCntct'.
     */
    public java.lang.String getIndCanAddCntct()
    {
        return this._indCanAddCntct;
    } //-- java.lang.String getIndCanAddCntct() 

    /**
     * Returns the value of field 'ROWCSYS04SO_ARRAY'.
     * 
     * @return the value of field 'ROWCSYS04SO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY getROWCSYS04SO_ARRAY()
    {
        return this._ROWCSYS04SO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY getROWCSYS04SO_ARRAY() 

    /**
     * Returns the value of field 'szCdRsrcCategory'.
     * 
     * @return the value of field 'SzCdRsrcCategory'.
     */
    public java.lang.String getSzCdRsrcCategory()
    {
        return this._szCdRsrcCategory;
    } //-- java.lang.String getSzCdRsrcCategory() 

    /**
     * Returns the value of field 'ulRowQty2'.
     * 
     * @return the value of field 'UlRowQty2'.
     */
    public int getUlRowQty2()
    {
        return this._ulRowQty2;
    } //-- int getUlRowQty2() 

    /**
     * Method hasUlRowQty2
     * 
     * 
     * 
     * @return true if at least one UlRowQty2 has been added
     */
    public boolean hasUlRowQty2()
    {
        return this._has_ulRowQty2;
    } //-- boolean hasUlRowQty2() 

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
     * Sets the value of field 'indCanAddCntct'.
     * 
     * @param indCanAddCntct the value of field 'indCanAddCntct'.
     */
    public void setIndCanAddCntct(java.lang.String indCanAddCntct)
    {
        this._indCanAddCntct = indCanAddCntct;
    } //-- void setIndCanAddCntct(java.lang.String) 

    /**
     * Sets the value of field 'ROWCSYS04SO_ARRAY'.
     * 
     * @param ROWCSYS04SO_ARRAY the value of field
     * 'ROWCSYS04SO_ARRAY'.
     */
    public void setROWCSYS04SO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY ROWCSYS04SO_ARRAY)
    {
        this._ROWCSYS04SO_ARRAY = ROWCSYS04SO_ARRAY;
    } //-- void setROWCSYS04SO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY) 

    /**
     * Sets the value of field 'szCdRsrcCategory'.
     * 
     * @param szCdRsrcCategory the value of field 'szCdRsrcCategory'
     */
    public void setSzCdRsrcCategory(java.lang.String szCdRsrcCategory)
    {
        this._szCdRsrcCategory = szCdRsrcCategory;
    } //-- void setSzCdRsrcCategory(java.lang.String) 

    /**
     * Sets the value of field 'ulRowQty2'.
     * 
     * @param ulRowQty2 the value of field 'ulRowQty2'.
     */
    public void setUlRowQty2(int ulRowQty2)
    {
        this._ulRowQty2 = ulRowQty2;
        this._has_ulRowQty2 = true;
    } //-- void setUlRowQty2(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS04SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS04SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS04SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS04SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS04SO unmarshal(java.io.Reader) 

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
