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
 * Class SzCdEventStatus_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdEventStatus_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdEventStatusList
     */
    private java.util.List<java.lang.String> _szCdEventStatusList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdEventStatus_ARRAY() 
     {
        super();
        this._szCdEventStatusList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdEventStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdEventStatus(java.lang.String vSzCdEventStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdEventStatusList.size() >= 2) {
            throw new IndexOutOfBoundsException("addSzCdEventStatus has a maximum of 2");
        }
        
        this._szCdEventStatusList.add(vSzCdEventStatus);
    } //-- void addSzCdEventStatus(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdEventStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdEventStatus(int index, java.lang.String vSzCdEventStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdEventStatusList.size() >= 2) {
            throw new IndexOutOfBoundsException("addSzCdEventStatus has a maximum of 2");
        }
        
        this._szCdEventStatusList.add(index, vSzCdEventStatus);
    } //-- void addSzCdEventStatus(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdEventStatus
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdEventStatus()
    {
        return java.util.Collections.enumeration(this._szCdEventStatusList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdEventStatus() 

    /**
     * Method getSzCdEventStatus
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdEventStatus(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdEventStatusList.size()) {
            throw new IndexOutOfBoundsException("getSzCdEventStatus: Index value '" + index + "' not in range [0.." + (this._szCdEventStatusList.size() - 1) + "]");
        }
        
        return (String)_szCdEventStatusList.get(index);
    } //-- java.lang.String getSzCdEventStatus(int) 

    /**
     * Method getSzCdEventStatus
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdEventStatus()
    {
        int size = this._szCdEventStatusList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdEventStatusList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdEventStatus() 

    /**
     * Method getSzCdEventStatusAsReference
     * 
     * Returns a reference to '_szCdEventStatusList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdEventStatusAsReference()
    {
        return this._szCdEventStatusList;
    } //-- java.util.List<java.lang.String> getSzCdEventStatusAsReference() 

    /**
     * Method getSzCdEventStatusCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdEventStatusCount()
    {
        return this._szCdEventStatusList.size();
    } //-- int getSzCdEventStatusCount() 

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
     * Method iterateSzCdEventStatus
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdEventStatus()
    {
        return this._szCdEventStatusList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdEventStatus() 

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
    public void removeAllSzCdEventStatus()
    {
        this._szCdEventStatusList.clear();
    } //-- void removeAllSzCdEventStatus() 

    /**
     * Method removeSzCdEventStatus
     * 
     * 
     * 
     * @param vSzCdEventStatus
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdEventStatus(java.lang.String vSzCdEventStatus)
    {
        boolean removed = _szCdEventStatusList.remove(vSzCdEventStatus);
        return removed;
    } //-- boolean removeSzCdEventStatus(java.lang.String) 

    /**
     * Method removeSzCdEventStatusAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdEventStatusAt(int index)
    {
        Object obj = this._szCdEventStatusList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdEventStatusAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdEventStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdEventStatus(int index, java.lang.String vSzCdEventStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdEventStatusList.size()) {
            throw new IndexOutOfBoundsException("setSzCdEventStatus: Index value '" + index + "' not in range [0.." + (this._szCdEventStatusList.size() - 1) + "]");
        }
        
        this._szCdEventStatusList.set(index, vSzCdEventStatus);
    } //-- void setSzCdEventStatus(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdEventStatusArray
     */
    public void setSzCdEventStatus(java.lang.String[] vSzCdEventStatusArray)
    {
        //-- copy array
        _szCdEventStatusList.clear();
        
        for (int i = 0; i < vSzCdEventStatusArray.length; i++) {
                this._szCdEventStatusList.add(vSzCdEventStatusArray[i]);
        }
    } //-- void setSzCdEventStatus(java.lang.String) 

    /**
     * Sets the value of '_szCdEventStatusList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdEventStatusList the Vector to copy.
     */
    public void setSzCdEventStatus(java.util.List<java.lang.String> vSzCdEventStatusList)
    {
        // copy vector
        this._szCdEventStatusList.clear();
        
        this._szCdEventStatusList.addAll(vSzCdEventStatusList);
    } //-- void setSzCdEventStatus(java.util.List) 

    /**
     * Sets the value of '_szCdEventStatusList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param SzCdEventStatusVector the Vector to set.
     */
    public void setSzCdEventStatusAsReference(java.util.Vector<java.lang.String> SzCdEventStatusVector)
    {
        this._szCdEventStatusList = SzCdEventStatusVector;
    } //-- void setSzCdEventStatusAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY unmarshal(java.io.Reader) 

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
