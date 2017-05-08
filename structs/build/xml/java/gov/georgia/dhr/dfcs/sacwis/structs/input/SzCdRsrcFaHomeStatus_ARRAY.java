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
 * Class SzCdRsrcFaHomeStatus_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdRsrcFaHomeStatus_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdRsrcFaHomeStatusList
     */
    private java.util.List<java.lang.String> _szCdRsrcFaHomeStatusList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdRsrcFaHomeStatus_ARRAY() 
     {
        super();
        this._szCdRsrcFaHomeStatusList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcFaHomeStatus_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdRsrcFaHomeStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdRsrcFaHomeStatus(java.lang.String vSzCdRsrcFaHomeStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdRsrcFaHomeStatusList.size() >= 2) {
            throw new IndexOutOfBoundsException("addSzCdRsrcFaHomeStatus has a maximum of 2");
        }
        
        this._szCdRsrcFaHomeStatusList.add(vSzCdRsrcFaHomeStatus);
    } //-- void addSzCdRsrcFaHomeStatus(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdRsrcFaHomeStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdRsrcFaHomeStatus(int index, java.lang.String vSzCdRsrcFaHomeStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdRsrcFaHomeStatusList.size() >= 2) {
            throw new IndexOutOfBoundsException("addSzCdRsrcFaHomeStatus has a maximum of 2");
        }
        
        this._szCdRsrcFaHomeStatusList.add(index, vSzCdRsrcFaHomeStatus);
    } //-- void addSzCdRsrcFaHomeStatus(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdRsrcFaHomeStatus
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdRsrcFaHomeStatus()
    {
        return java.util.Collections.enumeration(this._szCdRsrcFaHomeStatusList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdRsrcFaHomeStatus() 

    /**
     * Method getSzCdRsrcFaHomeStatus
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdRsrcFaHomeStatus(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdRsrcFaHomeStatusList.size()) {
            throw new IndexOutOfBoundsException("getSzCdRsrcFaHomeStatus: Index value '" + index + "' not in range [0.." + (this._szCdRsrcFaHomeStatusList.size() - 1) + "]");
        }
        
        return (String)_szCdRsrcFaHomeStatusList.get(index);
    } //-- java.lang.String getSzCdRsrcFaHomeStatus(int) 

    /**
     * Method getSzCdRsrcFaHomeStatus
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdRsrcFaHomeStatus()
    {
        int size = this._szCdRsrcFaHomeStatusList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdRsrcFaHomeStatusList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdRsrcFaHomeStatus() 

    /**
     * Method getSzCdRsrcFaHomeStatusAsReference
     * 
     * Returns a reference to '_szCdRsrcFaHomeStatusList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdRsrcFaHomeStatusAsReference()
    {
        return this._szCdRsrcFaHomeStatusList;
    } //-- java.util.List<java.lang.String> getSzCdRsrcFaHomeStatusAsReference() 

    /**
     * Method getSzCdRsrcFaHomeStatusCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdRsrcFaHomeStatusCount()
    {
        return this._szCdRsrcFaHomeStatusList.size();
    } //-- int getSzCdRsrcFaHomeStatusCount() 

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
     * Method iterateSzCdRsrcFaHomeStatus
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdRsrcFaHomeStatus()
    {
        return this._szCdRsrcFaHomeStatusList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdRsrcFaHomeStatus() 

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
    public void removeAllSzCdRsrcFaHomeStatus()
    {
        this._szCdRsrcFaHomeStatusList.clear();
    } //-- void removeAllSzCdRsrcFaHomeStatus() 

    /**
     * Method removeSzCdRsrcFaHomeStatus
     * 
     * 
     * 
     * @param vSzCdRsrcFaHomeStatus
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdRsrcFaHomeStatus(java.lang.String vSzCdRsrcFaHomeStatus)
    {
        boolean removed = _szCdRsrcFaHomeStatusList.remove(vSzCdRsrcFaHomeStatus);
        return removed;
    } //-- boolean removeSzCdRsrcFaHomeStatus(java.lang.String) 

    /**
     * Method removeSzCdRsrcFaHomeStatusAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdRsrcFaHomeStatusAt(int index)
    {
        Object obj = this._szCdRsrcFaHomeStatusList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdRsrcFaHomeStatusAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdRsrcFaHomeStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdRsrcFaHomeStatus(int index, java.lang.String vSzCdRsrcFaHomeStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdRsrcFaHomeStatusList.size()) {
            throw new IndexOutOfBoundsException("setSzCdRsrcFaHomeStatus: Index value '" + index + "' not in range [0.." + (this._szCdRsrcFaHomeStatusList.size() - 1) + "]");
        }
        
        this._szCdRsrcFaHomeStatusList.set(index, vSzCdRsrcFaHomeStatus);
    } //-- void setSzCdRsrcFaHomeStatus(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdRsrcFaHomeStatusArray
     */
    public void setSzCdRsrcFaHomeStatus(java.lang.String[] vSzCdRsrcFaHomeStatusArray)
    {
        //-- copy array
        _szCdRsrcFaHomeStatusList.clear();
        
        for (int i = 0; i < vSzCdRsrcFaHomeStatusArray.length; i++) {
                this._szCdRsrcFaHomeStatusList.add(vSzCdRsrcFaHomeStatusArray[i]);
        }
    } //-- void setSzCdRsrcFaHomeStatus(java.lang.String) 

    /**
     * Sets the value of '_szCdRsrcFaHomeStatusList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdRsrcFaHomeStatusList the Vector to copy.
     */
    public void setSzCdRsrcFaHomeStatus(java.util.List<java.lang.String> vSzCdRsrcFaHomeStatusList)
    {
        // copy vector
        this._szCdRsrcFaHomeStatusList.clear();
        
        this._szCdRsrcFaHomeStatusList.addAll(vSzCdRsrcFaHomeStatusList);
    } //-- void setSzCdRsrcFaHomeStatus(java.util.List) 

    /**
     * Sets the value of '_szCdRsrcFaHomeStatusList' by setting it
     * to the given Vector. No type checking is performed.
     * 
     * @param SzCdRsrcFaHomeStatusVector the Vector to set.
     */
    public void setSzCdRsrcFaHomeStatusAsReference(java.util.Vector<java.lang.String> SzCdRsrcFaHomeStatusVector)
    {
        this._szCdRsrcFaHomeStatusList = SzCdRsrcFaHomeStatusVector;
    } //-- void setSzCdRsrcFaHomeStatusAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcFaHomeStatus_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcFaHomeStatus_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcFaHomeStatus_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcFaHomeStatus_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcFaHomeStatus_ARRAY unmarshal(java.io.Reader) 

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
