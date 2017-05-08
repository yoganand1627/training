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
 * Class UsSysNbrMessageCode_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UsSysNbrMessageCode_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _usSysNbrMessageCodeList
     */
    private java.util.List<Integer> _usSysNbrMessageCodeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UsSysNbrMessageCode_ARRAY() 
     {
        super();
        this._usSysNbrMessageCodeList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrMessageCode_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUsSysNbrMessageCode
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUsSysNbrMessageCode(int vUsSysNbrMessageCode)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._usSysNbrMessageCodeList.size() >= 10) {
            throw new IndexOutOfBoundsException("addUsSysNbrMessageCode has a maximum of 10");
        }
        
        this._usSysNbrMessageCodeList.add(new java.lang.Integer(vUsSysNbrMessageCode));
    } //-- void addUsSysNbrMessageCode(int) 

    /**
     * 
     * 
     * @param index
     * @param vUsSysNbrMessageCode
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUsSysNbrMessageCode(int index, int vUsSysNbrMessageCode)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._usSysNbrMessageCodeList.size() >= 10) {
            throw new IndexOutOfBoundsException("addUsSysNbrMessageCode has a maximum of 10");
        }
        
        this._usSysNbrMessageCodeList.add(index, new java.lang.Integer(vUsSysNbrMessageCode));
    } //-- void addUsSysNbrMessageCode(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUsSysNbrMessageCode
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUsSysNbrMessageCode()
    {
        return java.util.Collections.enumeration(this._usSysNbrMessageCodeList);
    } //-- java.util.Enumeration<Integer> enumerateUsSysNbrMessageCode() 

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
     * Method getUsSysNbrMessageCode
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUsSysNbrMessageCode(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._usSysNbrMessageCodeList.size()) {
            throw new IndexOutOfBoundsException("getUsSysNbrMessageCode: Index value '" + index + "' not in range [0.." + (this._usSysNbrMessageCodeList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_usSysNbrMessageCodeList.get(index)).intValue();
    } //-- int getUsSysNbrMessageCode(int) 

    /**
     * Method getUsSysNbrMessageCode
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUsSysNbrMessageCode()
    {
        int size = this._usSysNbrMessageCodeList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_usSysNbrMessageCodeList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUsSysNbrMessageCode() 

    /**
     * Method getUsSysNbrMessageCodeAsReference
     * 
     * Returns a reference to '_usSysNbrMessageCodeList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUsSysNbrMessageCodeAsReference()
    {
        return this._usSysNbrMessageCodeList;
    } //-- java.util.List<Integer> getUsSysNbrMessageCodeAsReference() 

    /**
     * Method getUsSysNbrMessageCodeCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUsSysNbrMessageCodeCount()
    {
        return this._usSysNbrMessageCodeList.size();
    } //-- int getUsSysNbrMessageCodeCount() 

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
     * Method iterateUsSysNbrMessageCode
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUsSysNbrMessageCode()
    {
        return this._usSysNbrMessageCodeList.iterator();
    } //-- java.util.Iterator<Integer> iterateUsSysNbrMessageCode() 

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
    public void removeAllUsSysNbrMessageCode()
    {
        this._usSysNbrMessageCodeList.clear();
    } //-- void removeAllUsSysNbrMessageCode() 

    /**
     * Method removeUsSysNbrMessageCode
     * 
     * 
     * 
     * @param vUsSysNbrMessageCode
     * @return true if the object was removed from the collection.
     */
    public boolean removeUsSysNbrMessageCode(int vUsSysNbrMessageCode)
    {
        boolean removed = _usSysNbrMessageCodeList.remove(new java.lang.Integer(vUsSysNbrMessageCode));
        return removed;
    } //-- boolean removeUsSysNbrMessageCode(int) 

    /**
     * Method removeUsSysNbrMessageCodeAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUsSysNbrMessageCodeAt(int index)
    {
        Object obj = this._usSysNbrMessageCodeList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUsSysNbrMessageCodeAt(int) 

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
     * 
     * 
     * @param index
     * @param vUsSysNbrMessageCode
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUsSysNbrMessageCode(int index, int vUsSysNbrMessageCode)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._usSysNbrMessageCodeList.size()) {
            throw new IndexOutOfBoundsException("setUsSysNbrMessageCode: Index value '" + index + "' not in range [0.." + (this._usSysNbrMessageCodeList.size() - 1) + "]");
        }
        
        this._usSysNbrMessageCodeList.set(index, new java.lang.Integer(vUsSysNbrMessageCode));
    } //-- void setUsSysNbrMessageCode(int, int) 

    /**
     * 
     * 
     * @param vUsSysNbrMessageCodeArray
     */
    public void setUsSysNbrMessageCode(int[] vUsSysNbrMessageCodeArray)
    {
        //-- copy array
        _usSysNbrMessageCodeList.clear();
        
        for (int i = 0; i < vUsSysNbrMessageCodeArray.length; i++) {
                this._usSysNbrMessageCodeList.add(new java.lang.Integer(vUsSysNbrMessageCodeArray[i]));
        }
    } //-- void setUsSysNbrMessageCode(int) 

    /**
     * Sets the value of '_usSysNbrMessageCodeList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vUsSysNbrMessageCodeList the Vector to copy.
     */
    public void setUsSysNbrMessageCode(java.util.List<Integer> vUsSysNbrMessageCodeList)
    {
        // copy vector
        this._usSysNbrMessageCodeList.clear();
        
        this._usSysNbrMessageCodeList.addAll(vUsSysNbrMessageCodeList);
    } //-- void setUsSysNbrMessageCode(java.util.List) 

    /**
     * Sets the value of '_usSysNbrMessageCodeList' by setting it
     * to the given Vector. No type checking is performed.
     * 
     * @param UsSysNbrMessageCodeVector the Vector to set.
     */
    public void setUsSysNbrMessageCodeAsReference(java.util.Vector<Integer> UsSysNbrMessageCodeVector)
    {
        this._usSysNbrMessageCodeList = UsSysNbrMessageCodeVector;
    } //-- void setUsSysNbrMessageCodeAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrMessageCode_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrMessageCode_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrMessageCode_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrMessageCode_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrMessageCode_ARRAY unmarshal(java.io.Reader) 

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
