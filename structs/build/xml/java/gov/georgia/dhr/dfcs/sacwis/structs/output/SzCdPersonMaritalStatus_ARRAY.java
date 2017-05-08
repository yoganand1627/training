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
 * Class SzCdPersonMaritalStatus_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdPersonMaritalStatus_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdPersonMaritalStatusList
     */
    private java.util.List<java.lang.String> _szCdPersonMaritalStatusList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdPersonMaritalStatus_ARRAY() 
     {
        super();
        this._szCdPersonMaritalStatusList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPersonMaritalStatus_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdPersonMaritalStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdPersonMaritalStatus(java.lang.String vSzCdPersonMaritalStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdPersonMaritalStatusList.size() >= 50) {
            throw new IndexOutOfBoundsException("addSzCdPersonMaritalStatus has a maximum of 50");
        }
        
        this._szCdPersonMaritalStatusList.add(vSzCdPersonMaritalStatus);
    } //-- void addSzCdPersonMaritalStatus(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdPersonMaritalStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdPersonMaritalStatus(int index, java.lang.String vSzCdPersonMaritalStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdPersonMaritalStatusList.size() >= 50) {
            throw new IndexOutOfBoundsException("addSzCdPersonMaritalStatus has a maximum of 50");
        }
        
        this._szCdPersonMaritalStatusList.add(index, vSzCdPersonMaritalStatus);
    } //-- void addSzCdPersonMaritalStatus(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdPersonMaritalStatus
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdPersonMaritalStatus()
    {
        return java.util.Collections.enumeration(this._szCdPersonMaritalStatusList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdPersonMaritalStatus() 

    /**
     * Method getSzCdPersonMaritalStatus
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdPersonMaritalStatus(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdPersonMaritalStatusList.size()) {
            throw new IndexOutOfBoundsException("getSzCdPersonMaritalStatus: Index value '" + index + "' not in range [0.." + (this._szCdPersonMaritalStatusList.size() - 1) + "]");
        }
        
        return (String)_szCdPersonMaritalStatusList.get(index);
    } //-- java.lang.String getSzCdPersonMaritalStatus(int) 

    /**
     * Method getSzCdPersonMaritalStatus
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdPersonMaritalStatus()
    {
        int size = this._szCdPersonMaritalStatusList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdPersonMaritalStatusList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdPersonMaritalStatus() 

    /**
     * Method getSzCdPersonMaritalStatusAsReference
     * 
     * Returns a reference to '_szCdPersonMaritalStatusList'. No
     * type checking is performed on any modifications to the
     * Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdPersonMaritalStatusAsReference()
    {
        return this._szCdPersonMaritalStatusList;
    } //-- java.util.List<java.lang.String> getSzCdPersonMaritalStatusAsReference() 

    /**
     * Method getSzCdPersonMaritalStatusCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdPersonMaritalStatusCount()
    {
        return this._szCdPersonMaritalStatusList.size();
    } //-- int getSzCdPersonMaritalStatusCount() 

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
     * Method iterateSzCdPersonMaritalStatus
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdPersonMaritalStatus()
    {
        return this._szCdPersonMaritalStatusList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdPersonMaritalStatus() 

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
    public void removeAllSzCdPersonMaritalStatus()
    {
        this._szCdPersonMaritalStatusList.clear();
    } //-- void removeAllSzCdPersonMaritalStatus() 

    /**
     * Method removeSzCdPersonMaritalStatus
     * 
     * 
     * 
     * @param vSzCdPersonMaritalStatus
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdPersonMaritalStatus(java.lang.String vSzCdPersonMaritalStatus)
    {
        boolean removed = _szCdPersonMaritalStatusList.remove(vSzCdPersonMaritalStatus);
        return removed;
    } //-- boolean removeSzCdPersonMaritalStatus(java.lang.String) 

    /**
     * Method removeSzCdPersonMaritalStatusAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdPersonMaritalStatusAt(int index)
    {
        Object obj = this._szCdPersonMaritalStatusList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdPersonMaritalStatusAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdPersonMaritalStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdPersonMaritalStatus(int index, java.lang.String vSzCdPersonMaritalStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdPersonMaritalStatusList.size()) {
            throw new IndexOutOfBoundsException("setSzCdPersonMaritalStatus: Index value '" + index + "' not in range [0.." + (this._szCdPersonMaritalStatusList.size() - 1) + "]");
        }
        
        this._szCdPersonMaritalStatusList.set(index, vSzCdPersonMaritalStatus);
    } //-- void setSzCdPersonMaritalStatus(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdPersonMaritalStatusArray
     */
    public void setSzCdPersonMaritalStatus(java.lang.String[] vSzCdPersonMaritalStatusArray)
    {
        //-- copy array
        _szCdPersonMaritalStatusList.clear();
        
        for (int i = 0; i < vSzCdPersonMaritalStatusArray.length; i++) {
                this._szCdPersonMaritalStatusList.add(vSzCdPersonMaritalStatusArray[i]);
        }
    } //-- void setSzCdPersonMaritalStatus(java.lang.String) 

    /**
     * Sets the value of '_szCdPersonMaritalStatusList' by copying
     * the given Vector. All elements will be checked for type
     * safety.
     * 
     * @param vSzCdPersonMaritalStatusList the Vector to copy.
     */
    public void setSzCdPersonMaritalStatus(java.util.List<java.lang.String> vSzCdPersonMaritalStatusList)
    {
        // copy vector
        this._szCdPersonMaritalStatusList.clear();
        
        this._szCdPersonMaritalStatusList.addAll(vSzCdPersonMaritalStatusList);
    } //-- void setSzCdPersonMaritalStatus(java.util.List) 

    /**
     * Sets the value of '_szCdPersonMaritalStatusList' by setting
     * it to the given Vector. No type checking is performed.
     * 
     * @param SzCdPersonMaritalStatusVector the Vector to set.
     */
    public void setSzCdPersonMaritalStatusAsReference(java.util.Vector<java.lang.String> SzCdPersonMaritalStatusVector)
    {
        this._szCdPersonMaritalStatusList = SzCdPersonMaritalStatusVector;
    } //-- void setSzCdPersonMaritalStatusAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPersonMaritalStatus_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPersonMaritalStatus_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPersonMaritalStatus_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPersonMaritalStatus_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPersonMaritalStatus_ARRAY unmarshal(java.io.Reader) 

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
