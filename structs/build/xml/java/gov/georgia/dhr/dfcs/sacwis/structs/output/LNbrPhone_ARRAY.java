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
 * Class LNbrPhone_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class LNbrPhone_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _lNbrPhoneList
     */
    private java.util.List<java.lang.String> _lNbrPhoneList;

    /**
     * Field _lNbrPhoneExtensionList
     */
    private java.util.List<java.lang.String> _lNbrPhoneExtensionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public LNbrPhone_ARRAY() 
     {
        super();
        this._lNbrPhoneList = new java.util.ArrayList<java.lang.String>();
        this._lNbrPhoneExtensionList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.LNbrPhone_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vLNbrPhone
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLNbrPhone(java.lang.String vLNbrPhone)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._lNbrPhoneList.size() >= 20) {
            throw new IndexOutOfBoundsException("addLNbrPhone has a maximum of 20");
        }
        
        this._lNbrPhoneList.add(vLNbrPhone);
    } //-- void addLNbrPhone(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vLNbrPhone
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLNbrPhone(int index, java.lang.String vLNbrPhone)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._lNbrPhoneList.size() >= 20) {
            throw new IndexOutOfBoundsException("addLNbrPhone has a maximum of 20");
        }
        
        this._lNbrPhoneList.add(index, vLNbrPhone);
    } //-- void addLNbrPhone(int, java.lang.String) 

    /**
     * 
     * 
     * @param vLNbrPhoneExtension
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLNbrPhoneExtension(java.lang.String vLNbrPhoneExtension)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._lNbrPhoneExtensionList.size() >= 20) {
            throw new IndexOutOfBoundsException("addLNbrPhoneExtension has a maximum of 20");
        }
        
        this._lNbrPhoneExtensionList.add(vLNbrPhoneExtension);
    } //-- void addLNbrPhoneExtension(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vLNbrPhoneExtension
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLNbrPhoneExtension(int index, java.lang.String vLNbrPhoneExtension)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._lNbrPhoneExtensionList.size() >= 20) {
            throw new IndexOutOfBoundsException("addLNbrPhoneExtension has a maximum of 20");
        }
        
        this._lNbrPhoneExtensionList.add(index, vLNbrPhoneExtension);
    } //-- void addLNbrPhoneExtension(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateLNbrPhone
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateLNbrPhone()
    {
        return java.util.Collections.enumeration(this._lNbrPhoneList);
    } //-- java.util.Enumeration<java.lang.String> enumerateLNbrPhone() 

    /**
     * Method enumerateLNbrPhoneExtension
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateLNbrPhoneExtension()
    {
        return java.util.Collections.enumeration(this._lNbrPhoneExtensionList);
    } //-- java.util.Enumeration<java.lang.String> enumerateLNbrPhoneExtension() 

    /**
     * Method getLNbrPhone
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getLNbrPhone(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._lNbrPhoneList.size()) {
            throw new IndexOutOfBoundsException("getLNbrPhone: Index value '" + index + "' not in range [0.." + (this._lNbrPhoneList.size() - 1) + "]");
        }
        
        return (String)_lNbrPhoneList.get(index);
    } //-- java.lang.String getLNbrPhone(int) 

    /**
     * Method getLNbrPhone
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getLNbrPhone()
    {
        int size = this._lNbrPhoneList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_lNbrPhoneList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getLNbrPhone() 

    /**
     * Method getLNbrPhoneAsReference
     * 
     * Returns a reference to '_lNbrPhoneList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getLNbrPhoneAsReference()
    {
        return this._lNbrPhoneList;
    } //-- java.util.List<java.lang.String> getLNbrPhoneAsReference() 

    /**
     * Method getLNbrPhoneCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getLNbrPhoneCount()
    {
        return this._lNbrPhoneList.size();
    } //-- int getLNbrPhoneCount() 

    /**
     * Method getLNbrPhoneExtension
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getLNbrPhoneExtension(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._lNbrPhoneExtensionList.size()) {
            throw new IndexOutOfBoundsException("getLNbrPhoneExtension: Index value '" + index + "' not in range [0.." + (this._lNbrPhoneExtensionList.size() - 1) + "]");
        }
        
        return (String)_lNbrPhoneExtensionList.get(index);
    } //-- java.lang.String getLNbrPhoneExtension(int) 

    /**
     * Method getLNbrPhoneExtension
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getLNbrPhoneExtension()
    {
        int size = this._lNbrPhoneExtensionList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_lNbrPhoneExtensionList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getLNbrPhoneExtension() 

    /**
     * Method getLNbrPhoneExtensionAsReference
     * 
     * Returns a reference to '_lNbrPhoneExtensionList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getLNbrPhoneExtensionAsReference()
    {
        return this._lNbrPhoneExtensionList;
    } //-- java.util.List<java.lang.String> getLNbrPhoneExtensionAsReference() 

    /**
     * Method getLNbrPhoneExtensionCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getLNbrPhoneExtensionCount()
    {
        return this._lNbrPhoneExtensionList.size();
    } //-- int getLNbrPhoneExtensionCount() 

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
     * Method iterateLNbrPhone
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateLNbrPhone()
    {
        return this._lNbrPhoneList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateLNbrPhone() 

    /**
     * Method iterateLNbrPhoneExtension
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateLNbrPhoneExtension()
    {
        return this._lNbrPhoneExtensionList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateLNbrPhoneExtension() 

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
    public void removeAllLNbrPhone()
    {
        this._lNbrPhoneList.clear();
    } //-- void removeAllLNbrPhone() 

    /**
     */
    public void removeAllLNbrPhoneExtension()
    {
        this._lNbrPhoneExtensionList.clear();
    } //-- void removeAllLNbrPhoneExtension() 

    /**
     * Method removeLNbrPhone
     * 
     * 
     * 
     * @param vLNbrPhone
     * @return true if the object was removed from the collection.
     */
    public boolean removeLNbrPhone(java.lang.String vLNbrPhone)
    {
        boolean removed = _lNbrPhoneList.remove(vLNbrPhone);
        return removed;
    } //-- boolean removeLNbrPhone(java.lang.String) 

    /**
     * Method removeLNbrPhoneAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeLNbrPhoneAt(int index)
    {
        Object obj = this._lNbrPhoneList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeLNbrPhoneAt(int) 

    /**
     * Method removeLNbrPhoneExtension
     * 
     * 
     * 
     * @param vLNbrPhoneExtension
     * @return true if the object was removed from the collection.
     */
    public boolean removeLNbrPhoneExtension(java.lang.String vLNbrPhoneExtension)
    {
        boolean removed = _lNbrPhoneExtensionList.remove(vLNbrPhoneExtension);
        return removed;
    } //-- boolean removeLNbrPhoneExtension(java.lang.String) 

    /**
     * Method removeLNbrPhoneExtensionAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeLNbrPhoneExtensionAt(int index)
    {
        Object obj = this._lNbrPhoneExtensionList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeLNbrPhoneExtensionAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vLNbrPhone
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setLNbrPhone(int index, java.lang.String vLNbrPhone)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._lNbrPhoneList.size()) {
            throw new IndexOutOfBoundsException("setLNbrPhone: Index value '" + index + "' not in range [0.." + (this._lNbrPhoneList.size() - 1) + "]");
        }
        
        this._lNbrPhoneList.set(index, vLNbrPhone);
    } //-- void setLNbrPhone(int, java.lang.String) 

    /**
     * 
     * 
     * @param vLNbrPhoneArray
     */
    public void setLNbrPhone(java.lang.String[] vLNbrPhoneArray)
    {
        //-- copy array
        _lNbrPhoneList.clear();
        
        for (int i = 0; i < vLNbrPhoneArray.length; i++) {
                this._lNbrPhoneList.add(vLNbrPhoneArray[i]);
        }
    } //-- void setLNbrPhone(java.lang.String) 

    /**
     * Sets the value of '_lNbrPhoneList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vLNbrPhoneList the Vector to copy.
     */
    public void setLNbrPhone(java.util.List<java.lang.String> vLNbrPhoneList)
    {
        // copy vector
        this._lNbrPhoneList.clear();
        
        this._lNbrPhoneList.addAll(vLNbrPhoneList);
    } //-- void setLNbrPhone(java.util.List) 

    /**
     * Sets the value of '_lNbrPhoneList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param LNbrPhoneVector the Vector to set.
     */
    public void setLNbrPhoneAsReference(java.util.Vector<java.lang.String> LNbrPhoneVector)
    {
        this._lNbrPhoneList = LNbrPhoneVector;
    } //-- void setLNbrPhoneAsReference(java.util.Vector) 

    /**
     * 
     * 
     * @param index
     * @param vLNbrPhoneExtension
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setLNbrPhoneExtension(int index, java.lang.String vLNbrPhoneExtension)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._lNbrPhoneExtensionList.size()) {
            throw new IndexOutOfBoundsException("setLNbrPhoneExtension: Index value '" + index + "' not in range [0.." + (this._lNbrPhoneExtensionList.size() - 1) + "]");
        }
        
        this._lNbrPhoneExtensionList.set(index, vLNbrPhoneExtension);
    } //-- void setLNbrPhoneExtension(int, java.lang.String) 

    /**
     * 
     * 
     * @param vLNbrPhoneExtensionArray
     */
    public void setLNbrPhoneExtension(java.lang.String[] vLNbrPhoneExtensionArray)
    {
        //-- copy array
        _lNbrPhoneExtensionList.clear();
        
        for (int i = 0; i < vLNbrPhoneExtensionArray.length; i++) {
                this._lNbrPhoneExtensionList.add(vLNbrPhoneExtensionArray[i]);
        }
    } //-- void setLNbrPhoneExtension(java.lang.String) 

    /**
     * Sets the value of '_lNbrPhoneExtensionList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vLNbrPhoneExtensionList the Vector to copy.
     */
    public void setLNbrPhoneExtension(java.util.List<java.lang.String> vLNbrPhoneExtensionList)
    {
        // copy vector
        this._lNbrPhoneExtensionList.clear();
        
        this._lNbrPhoneExtensionList.addAll(vLNbrPhoneExtensionList);
    } //-- void setLNbrPhoneExtension(java.util.List) 

    /**
     * Sets the value of '_lNbrPhoneExtensionList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param LNbrPhoneExtensionVector the Vector to set.
     */
    public void setLNbrPhoneExtensionAsReference(java.util.Vector<java.lang.String> LNbrPhoneExtensionVector)
    {
        this._lNbrPhoneExtensionList = LNbrPhoneExtensionVector;
    } //-- void setLNbrPhoneExtensionAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.LNbrPhone_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.LNbrPhone_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.LNbrPhone_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.LNbrPhone_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.LNbrPhone_ARRAY unmarshal(java.io.Reader) 

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
