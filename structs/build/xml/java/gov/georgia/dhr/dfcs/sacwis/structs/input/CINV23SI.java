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
 * Class CINV23SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV23SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _szCdExtDocSort
     */
    private java.lang.String _szCdExtDocSort;

    /**
     * Field _szTxtExtDocLocation
     */
    private java.lang.String _szTxtExtDocLocation;

    /**
     * Field _dtScrSearchDateFrom
     */
    private org.exolab.castor.types.Date _dtScrSearchDateFrom;

    /**
     * Field _dtScrSearchDateTo
     */
    private org.exolab.castor.types.Date _dtScrSearchDateTo;

    /**
     * Field _bIndSealed
     */
    private java.lang.String _bIndSealed;

    /**
     * Field _bIndSort
     */
    private java.lang.String _bIndSort;

    /**
     * Field _bIndICPCDoc
     */
    private java.lang.String _bIndICPCDoc;

    /**
     * Field _ROWCINV23SI00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00_ARRAY _ROWCINV23SI00_ARRAY;

    /**
     * Field _ROWCINV23SI01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01_ARRAY _ROWCINV23SI01_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV23SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV23SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

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
     * Returns the value of field 'bIndICPCDoc'.
     * 
     * @return the value of field 'BIndICPCDoc'.
     */
    public java.lang.String getBIndICPCDoc()
    {
        return this._bIndICPCDoc;
    } //-- java.lang.String getBIndICPCDoc() 

    /**
     * Returns the value of field 'bIndSealed'.
     * 
     * @return the value of field 'BIndSealed'.
     */
    public java.lang.String getBIndSealed()
    {
        return this._bIndSealed;
    } //-- java.lang.String getBIndSealed() 

    /**
     * Returns the value of field 'bIndSort'.
     * 
     * @return the value of field 'BIndSort'.
     */
    public java.lang.String getBIndSort()
    {
        return this._bIndSort;
    } //-- java.lang.String getBIndSort() 

    /**
     * Returns the value of field 'dtScrSearchDateFrom'.
     * 
     * @return the value of field 'DtScrSearchDateFrom'.
     */
    public org.exolab.castor.types.Date getDtScrSearchDateFrom()
    {
        return this._dtScrSearchDateFrom;
    } //-- org.exolab.castor.types.Date getDtScrSearchDateFrom() 

    /**
     * Returns the value of field 'dtScrSearchDateTo'.
     * 
     * @return the value of field 'DtScrSearchDateTo'.
     */
    public org.exolab.castor.types.Date getDtScrSearchDateTo()
    {
        return this._dtScrSearchDateTo;
    } //-- org.exolab.castor.types.Date getDtScrSearchDateTo() 

    /**
     * Returns the value of field 'ROWCINV23SI00_ARRAY'.
     * 
     * @return the value of field 'ROWCINV23SI00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00_ARRAY getROWCINV23SI00_ARRAY()
    {
        return this._ROWCINV23SI00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00_ARRAY getROWCINV23SI00_ARRAY() 

    /**
     * Returns the value of field 'ROWCINV23SI01_ARRAY'.
     * 
     * @return the value of field 'ROWCINV23SI01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01_ARRAY getROWCINV23SI01_ARRAY()
    {
        return this._ROWCINV23SI01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01_ARRAY getROWCINV23SI01_ARRAY() 

    /**
     * Returns the value of field 'szCdExtDocSort'.
     * 
     * @return the value of field 'SzCdExtDocSort'.
     */
    public java.lang.String getSzCdExtDocSort()
    {
        return this._szCdExtDocSort;
    } //-- java.lang.String getSzCdExtDocSort() 

    /**
     * Returns the value of field 'szTxtExtDocLocation'.
     * 
     * @return the value of field 'SzTxtExtDocLocation'.
     */
    public java.lang.String getSzTxtExtDocLocation()
    {
        return this._szTxtExtDocLocation;
    } //-- java.lang.String getSzTxtExtDocLocation() 

    /**
     * Returns the value of field 'ulIdCase'.
     * 
     * @return the value of field 'UlIdCase'.
     */
    public int getUlIdCase()
    {
        return this._ulIdCase;
    } //-- int getUlIdCase() 

    /**
     * Method hasUlIdCase
     * 
     * 
     * 
     * @return true if at least one UlIdCase has been added
     */
    public boolean hasUlIdCase()
    {
        return this._has_ulIdCase;
    } //-- boolean hasUlIdCase() 

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
     * Sets the value of field 'bIndICPCDoc'.
     * 
     * @param bIndICPCDoc the value of field 'bIndICPCDoc'.
     */
    public void setBIndICPCDoc(java.lang.String bIndICPCDoc)
    {
        this._bIndICPCDoc = bIndICPCDoc;
    } //-- void setBIndICPCDoc(java.lang.String) 

    /**
     * Sets the value of field 'bIndSealed'.
     * 
     * @param bIndSealed the value of field 'bIndSealed'.
     */
    public void setBIndSealed(java.lang.String bIndSealed)
    {
        this._bIndSealed = bIndSealed;
    } //-- void setBIndSealed(java.lang.String) 

    /**
     * Sets the value of field 'bIndSort'.
     * 
     * @param bIndSort the value of field 'bIndSort'.
     */
    public void setBIndSort(java.lang.String bIndSort)
    {
        this._bIndSort = bIndSort;
    } //-- void setBIndSort(java.lang.String) 

    /**
     * Sets the value of field 'dtScrSearchDateFrom'.
     * 
     * @param dtScrSearchDateFrom the value of field
     * 'dtScrSearchDateFrom'.
     */
    public void setDtScrSearchDateFrom(org.exolab.castor.types.Date dtScrSearchDateFrom)
    {
        this._dtScrSearchDateFrom = dtScrSearchDateFrom;
    } //-- void setDtScrSearchDateFrom(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtScrSearchDateTo'.
     * 
     * @param dtScrSearchDateTo the value of field
     * 'dtScrSearchDateTo'.
     */
    public void setDtScrSearchDateTo(org.exolab.castor.types.Date dtScrSearchDateTo)
    {
        this._dtScrSearchDateTo = dtScrSearchDateTo;
    } //-- void setDtScrSearchDateTo(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCINV23SI00_ARRAY'.
     * 
     * @param ROWCINV23SI00_ARRAY the value of field
     * 'ROWCINV23SI00_ARRAY'.
     */
    public void setROWCINV23SI00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00_ARRAY ROWCINV23SI00_ARRAY)
    {
        this._ROWCINV23SI00_ARRAY = ROWCINV23SI00_ARRAY;
    } //-- void setROWCINV23SI00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI00_ARRAY) 

    /**
     * Sets the value of field 'ROWCINV23SI01_ARRAY'.
     * 
     * @param ROWCINV23SI01_ARRAY the value of field
     * 'ROWCINV23SI01_ARRAY'.
     */
    public void setROWCINV23SI01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01_ARRAY ROWCINV23SI01_ARRAY)
    {
        this._ROWCINV23SI01_ARRAY = ROWCINV23SI01_ARRAY;
    } //-- void setROWCINV23SI01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01_ARRAY) 

    /**
     * Sets the value of field 'szCdExtDocSort'.
     * 
     * @param szCdExtDocSort the value of field 'szCdExtDocSort'.
     */
    public void setSzCdExtDocSort(java.lang.String szCdExtDocSort)
    {
        this._szCdExtDocSort = szCdExtDocSort;
    } //-- void setSzCdExtDocSort(java.lang.String) 

    /**
     * Sets the value of field 'szTxtExtDocLocation'.
     * 
     * @param szTxtExtDocLocation the value of field
     * 'szTxtExtDocLocation'.
     */
    public void setSzTxtExtDocLocation(java.lang.String szTxtExtDocLocation)
    {
        this._szTxtExtDocLocation = szTxtExtDocLocation;
    } //-- void setSzTxtExtDocLocation(java.lang.String) 

    /**
     * Sets the value of field 'ulIdCase'.
     * 
     * @param ulIdCase the value of field 'ulIdCase'.
     */
    public void setUlIdCase(int ulIdCase)
    {
        this._ulIdCase = ulIdCase;
        this._has_ulIdCase = true;
    } //-- void setUlIdCase(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINV23SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CINV23SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV23SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV23SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV23SI unmarshal(java.io.Reader) 

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
