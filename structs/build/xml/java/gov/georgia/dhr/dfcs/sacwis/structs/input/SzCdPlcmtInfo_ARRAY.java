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
 * Class SzCdPlcmtInfo_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdPlcmtInfo_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulRowQty
     */
    private int _ulRowQty;

    /**
     * keeps track of state for field: _ulRowQty
     */
    private boolean _has_ulRowQty;

    /**
     * Field _szCdPlcmtInfoList
     */
    private java.util.List<java.lang.String> _szCdPlcmtInfoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdPlcmtInfo_ARRAY() 
     {
        super();
        this._szCdPlcmtInfoList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdPlcmtInfo_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdPlcmtInfo
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdPlcmtInfo(java.lang.String vSzCdPlcmtInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdPlcmtInfoList.size() >= 17) {
            throw new IndexOutOfBoundsException("addSzCdPlcmtInfo has a maximum of 17");
        }
        
        this._szCdPlcmtInfoList.add(vSzCdPlcmtInfo);
    } //-- void addSzCdPlcmtInfo(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdPlcmtInfo
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdPlcmtInfo(int index, java.lang.String vSzCdPlcmtInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdPlcmtInfoList.size() >= 17) {
            throw new IndexOutOfBoundsException("addSzCdPlcmtInfo has a maximum of 17");
        }
        
        this._szCdPlcmtInfoList.add(index, vSzCdPlcmtInfo);
    } //-- void addSzCdPlcmtInfo(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdPlcmtInfo
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdPlcmtInfo()
    {
        return java.util.Collections.enumeration(this._szCdPlcmtInfoList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdPlcmtInfo() 

    /**
     * Method getSzCdPlcmtInfo
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdPlcmtInfo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdPlcmtInfoList.size()) {
            throw new IndexOutOfBoundsException("getSzCdPlcmtInfo: Index value '" + index + "' not in range [0.." + (this._szCdPlcmtInfoList.size() - 1) + "]");
        }
        
        return (String)_szCdPlcmtInfoList.get(index);
    } //-- java.lang.String getSzCdPlcmtInfo(int) 

    /**
     * Method getSzCdPlcmtInfo
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdPlcmtInfo()
    {
        int size = this._szCdPlcmtInfoList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdPlcmtInfoList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdPlcmtInfo() 

    /**
     * Method getSzCdPlcmtInfoAsReference
     * 
     * Returns a reference to '_szCdPlcmtInfoList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdPlcmtInfoAsReference()
    {
        return this._szCdPlcmtInfoList;
    } //-- java.util.List<java.lang.String> getSzCdPlcmtInfoAsReference() 

    /**
     * Method getSzCdPlcmtInfoCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdPlcmtInfoCount()
    {
        return this._szCdPlcmtInfoList.size();
    } //-- int getSzCdPlcmtInfoCount() 

    /**
     * Returns the value of field 'ulRowQty'.
     * 
     * @return the value of field 'UlRowQty'.
     */
    public int getUlRowQty()
    {
        return this._ulRowQty;
    } //-- int getUlRowQty() 

    /**
     * Method hasUlRowQty
     * 
     * 
     * 
     * @return true if at least one UlRowQty has been added
     */
    public boolean hasUlRowQty()
    {
        return this._has_ulRowQty;
    } //-- boolean hasUlRowQty() 

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
     * Method iterateSzCdPlcmtInfo
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdPlcmtInfo()
    {
        return this._szCdPlcmtInfoList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdPlcmtInfo() 

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
     */
    public void removeAllSzCdPlcmtInfo()
    {
        this._szCdPlcmtInfoList.clear();
    } //-- void removeAllSzCdPlcmtInfo() 

    /**
     * Method removeSzCdPlcmtInfo
     * 
     * 
     * 
     * @param vSzCdPlcmtInfo
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdPlcmtInfo(java.lang.String vSzCdPlcmtInfo)
    {
        boolean removed = _szCdPlcmtInfoList.remove(vSzCdPlcmtInfo);
        return removed;
    } //-- boolean removeSzCdPlcmtInfo(java.lang.String) 

    /**
     * Method removeSzCdPlcmtInfoAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdPlcmtInfoAt(int index)
    {
        Object obj = this._szCdPlcmtInfoList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdPlcmtInfoAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdPlcmtInfo
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdPlcmtInfo(int index, java.lang.String vSzCdPlcmtInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdPlcmtInfoList.size()) {
            throw new IndexOutOfBoundsException("setSzCdPlcmtInfo: Index value '" + index + "' not in range [0.." + (this._szCdPlcmtInfoList.size() - 1) + "]");
        }
        
        this._szCdPlcmtInfoList.set(index, vSzCdPlcmtInfo);
    } //-- void setSzCdPlcmtInfo(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdPlcmtInfoArray
     */
    public void setSzCdPlcmtInfo(java.lang.String[] vSzCdPlcmtInfoArray)
    {
        //-- copy array
        _szCdPlcmtInfoList.clear();
        
        for (int i = 0; i < vSzCdPlcmtInfoArray.length; i++) {
                this._szCdPlcmtInfoList.add(vSzCdPlcmtInfoArray[i]);
        }
    } //-- void setSzCdPlcmtInfo(java.lang.String) 

    /**
     * Sets the value of '_szCdPlcmtInfoList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdPlcmtInfoList the Vector to copy.
     */
    public void setSzCdPlcmtInfo(java.util.List<java.lang.String> vSzCdPlcmtInfoList)
    {
        // copy vector
        this._szCdPlcmtInfoList.clear();
        
        this._szCdPlcmtInfoList.addAll(vSzCdPlcmtInfoList);
    } //-- void setSzCdPlcmtInfo(java.util.List) 

    /**
     * Sets the value of '_szCdPlcmtInfoList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param SzCdPlcmtInfoVector the Vector to set.
     */
    public void setSzCdPlcmtInfoAsReference(java.util.Vector<java.lang.String> SzCdPlcmtInfoVector)
    {
        this._szCdPlcmtInfoList = SzCdPlcmtInfoVector;
    } //-- void setSzCdPlcmtInfoAsReference(java.util.Vector) 

    /**
     * Sets the value of field 'ulRowQty'.
     * 
     * @param ulRowQty the value of field 'ulRowQty'.
     */
    public void setUlRowQty(int ulRowQty)
    {
        this._ulRowQty = ulRowQty;
        this._has_ulRowQty = true;
    } //-- void setUlRowQty(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdPlcmtInfo_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdPlcmtInfo_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdPlcmtInfo_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdPlcmtInfo_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdPlcmtInfo_ARRAY unmarshal(java.io.Reader) 

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
