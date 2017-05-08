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
 * Class SzCdRsrcStatus_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdRsrcStatus_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdRsrcStatusList
     */
    private java.util.List<java.lang.String> _szCdRsrcStatusList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdRsrcStatus_ARRAY() 
     {
        super();
        this._szCdRsrcStatusList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcStatus_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdRsrcStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdRsrcStatus(java.lang.String vSzCdRsrcStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdRsrcStatusList.size() >= 2) {
            throw new IndexOutOfBoundsException("addSzCdRsrcStatus has a maximum of 2");
        }
        
        this._szCdRsrcStatusList.add(vSzCdRsrcStatus);
    } //-- void addSzCdRsrcStatus(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdRsrcStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdRsrcStatus(int index, java.lang.String vSzCdRsrcStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdRsrcStatusList.size() >= 2) {
            throw new IndexOutOfBoundsException("addSzCdRsrcStatus has a maximum of 2");
        }
        
        this._szCdRsrcStatusList.add(index, vSzCdRsrcStatus);
    } //-- void addSzCdRsrcStatus(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdRsrcStatus
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdRsrcStatus()
    {
        return java.util.Collections.enumeration(this._szCdRsrcStatusList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdRsrcStatus() 

    /**
     * Method getSzCdRsrcStatus
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdRsrcStatus(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdRsrcStatusList.size()) {
            throw new IndexOutOfBoundsException("getSzCdRsrcStatus: Index value '" + index + "' not in range [0.." + (this._szCdRsrcStatusList.size() - 1) + "]");
        }
        
        return (String)_szCdRsrcStatusList.get(index);
    } //-- java.lang.String getSzCdRsrcStatus(int) 

    /**
     * Method getSzCdRsrcStatus
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdRsrcStatus()
    {
        int size = this._szCdRsrcStatusList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdRsrcStatusList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdRsrcStatus() 

    /**
     * Method getSzCdRsrcStatusAsReference
     * 
     * Returns a reference to '_szCdRsrcStatusList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdRsrcStatusAsReference()
    {
        return this._szCdRsrcStatusList;
    } //-- java.util.List<java.lang.String> getSzCdRsrcStatusAsReference() 

    /**
     * Method getSzCdRsrcStatusCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdRsrcStatusCount()
    {
        return this._szCdRsrcStatusList.size();
    } //-- int getSzCdRsrcStatusCount() 

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
     * Method iterateSzCdRsrcStatus
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdRsrcStatus()
    {
        return this._szCdRsrcStatusList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdRsrcStatus() 

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
    public void removeAllSzCdRsrcStatus()
    {
        this._szCdRsrcStatusList.clear();
    } //-- void removeAllSzCdRsrcStatus() 

    /**
     * Method removeSzCdRsrcStatus
     * 
     * 
     * 
     * @param vSzCdRsrcStatus
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdRsrcStatus(java.lang.String vSzCdRsrcStatus)
    {
        boolean removed = _szCdRsrcStatusList.remove(vSzCdRsrcStatus);
        return removed;
    } //-- boolean removeSzCdRsrcStatus(java.lang.String) 

    /**
     * Method removeSzCdRsrcStatusAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdRsrcStatusAt(int index)
    {
        Object obj = this._szCdRsrcStatusList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdRsrcStatusAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdRsrcStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdRsrcStatus(int index, java.lang.String vSzCdRsrcStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdRsrcStatusList.size()) {
            throw new IndexOutOfBoundsException("setSzCdRsrcStatus: Index value '" + index + "' not in range [0.." + (this._szCdRsrcStatusList.size() - 1) + "]");
        }
        
        this._szCdRsrcStatusList.set(index, vSzCdRsrcStatus);
    } //-- void setSzCdRsrcStatus(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdRsrcStatusArray
     */
    public void setSzCdRsrcStatus(java.lang.String[] vSzCdRsrcStatusArray)
    {
        //-- copy array
        _szCdRsrcStatusList.clear();
        
        for (int i = 0; i < vSzCdRsrcStatusArray.length; i++) {
                this._szCdRsrcStatusList.add(vSzCdRsrcStatusArray[i]);
        }
    } //-- void setSzCdRsrcStatus(java.lang.String) 

    /**
     * Sets the value of '_szCdRsrcStatusList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdRsrcStatusList the Vector to copy.
     */
    public void setSzCdRsrcStatus(java.util.List<java.lang.String> vSzCdRsrcStatusList)
    {
        // copy vector
        this._szCdRsrcStatusList.clear();
        
        this._szCdRsrcStatusList.addAll(vSzCdRsrcStatusList);
    } //-- void setSzCdRsrcStatus(java.util.List) 

    /**
     * Sets the value of '_szCdRsrcStatusList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param SzCdRsrcStatusVector the Vector to set.
     */
    public void setSzCdRsrcStatusAsReference(java.util.Vector<java.lang.String> SzCdRsrcStatusVector)
    {
        this._szCdRsrcStatusList = SzCdRsrcStatusVector;
    } //-- void setSzCdRsrcStatusAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcStatus_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcStatus_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcStatus_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcStatus_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcStatus_ARRAY unmarshal(java.io.Reader) 

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
