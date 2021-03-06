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
 * Class ROWCINT02SIG01_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINT02SIG01_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINT02SIG01List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01> _ROWCINT02SIG01List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINT02SIG01_ARRAY() 
     {
        super();
        this._ROWCINT02SIG01List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINT02SIG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINT02SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01 vROWCINT02SIG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINT02SIG01List.size() >= 10) {
            throw new IndexOutOfBoundsException("addROWCINT02SIG01 has a maximum of 10");
        }
        
        this._ROWCINT02SIG01List.add(vROWCINT02SIG01);
    } //-- void addROWCINT02SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINT02SIG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINT02SIG01(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01 vROWCINT02SIG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINT02SIG01List.size() >= 10) {
            throw new IndexOutOfBoundsException("addROWCINT02SIG01 has a maximum of 10");
        }
        
        this._ROWCINT02SIG01List.add(index, vROWCINT02SIG01);
    } //-- void addROWCINT02SIG01(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINT02SIG01
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01> enumerateROWCINT02SIG01()
    {
        return java.util.Collections.enumeration(this._ROWCINT02SIG01List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01> enumerateROWCINT02SIG01() 

    /**
     * Method getROWCINT02SIG01
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01 getROWCINT02SIG01(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINT02SIG01List.size()) {
            throw new IndexOutOfBoundsException("getROWCINT02SIG01: Index value '" + index + "' not in range [0.." + (this._ROWCINT02SIG01List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01) _ROWCINT02SIG01List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01 getROWCINT02SIG01(int) 

    /**
     * Method getROWCINT02SIG01
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01[] getROWCINT02SIG01()
    {
        int size = this._ROWCINT02SIG01List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01) _ROWCINT02SIG01List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01[] getROWCINT02SIG01() 

    /**
     * Method getROWCINT02SIG01AsReference
     * 
     * Returns a reference to '_ROWCINT02SIG01List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01> getROWCINT02SIG01AsReference()
    {
        return this._ROWCINT02SIG01List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01> getROWCINT02SIG01AsReference() 

    /**
     * Method getROWCINT02SIG01Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINT02SIG01Count()
    {
        return this._ROWCINT02SIG01List.size();
    } //-- int getROWCINT02SIG01Count() 

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
     * Method iterateROWCINT02SIG01
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01> iterateROWCINT02SIG01()
    {
        return this._ROWCINT02SIG01List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01> iterateROWCINT02SIG01() 

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
    public void removeAllROWCINT02SIG01()
    {
        this._ROWCINT02SIG01List.clear();
    } //-- void removeAllROWCINT02SIG01() 

    /**
     * Method removeROWCINT02SIG01
     * 
     * 
     * 
     * @param vROWCINT02SIG01
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINT02SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01 vROWCINT02SIG01)
    {
        boolean removed = _ROWCINT02SIG01List.remove(vROWCINT02SIG01);
        return removed;
    } //-- boolean removeROWCINT02SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01) 

    /**
     * Method removeROWCINT02SIG01At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01 removeROWCINT02SIG01At(int index)
    {
        Object obj = this._ROWCINT02SIG01List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01 removeROWCINT02SIG01At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINT02SIG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINT02SIG01(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01 vROWCINT02SIG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINT02SIG01List.size()) {
            throw new IndexOutOfBoundsException("setROWCINT02SIG01: Index value '" + index + "' not in range [0.." + (this._ROWCINT02SIG01List.size() - 1) + "]");
        }
        
        this._ROWCINT02SIG01List.set(index, vROWCINT02SIG01);
    } //-- void setROWCINT02SIG01(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01) 

    /**
     * 
     * 
     * @param vROWCINT02SIG01Array
     */
    public void setROWCINT02SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01[] vROWCINT02SIG01Array)
    {
        //-- copy array
        _ROWCINT02SIG01List.clear();
        
        for (int i = 0; i < vROWCINT02SIG01Array.length; i++) {
                this._ROWCINT02SIG01List.add(vROWCINT02SIG01Array[i]);
        }
    } //-- void setROWCINT02SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01) 

    /**
     * Sets the value of '_ROWCINT02SIG01List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINT02SIG01List the Vector to copy.
     */
    public void setROWCINT02SIG01(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01> vROWCINT02SIG01List)
    {
        // copy vector
        this._ROWCINT02SIG01List.clear();
        
        this._ROWCINT02SIG01List.addAll(vROWCINT02SIG01List);
    } //-- void setROWCINT02SIG01(java.util.List) 

    /**
     * Sets the value of '_ROWCINT02SIG01List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINT02SIG01Vector the Vector to set.
     */
    public void setROWCINT02SIG01AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01> ROWCINT02SIG01Vector)
    {
        this._ROWCINT02SIG01List = ROWCINT02SIG01Vector;
    } //-- void setROWCINT02SIG01AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01_ARRAY unmarshal(java.io.Reader) 

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
