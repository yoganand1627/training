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
 * Class ROWCINV22SIG1_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV22SIG1_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINV22SIG1List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1> _ROWCINV22SIG1List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV22SIG1_ARRAY() 
     {
        super();
        this._ROWCINV22SIG1List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINV22SIG1
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV22SIG1(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1 vROWCINV22SIG1)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV22SIG1List.size() >= 75) {
            throw new IndexOutOfBoundsException("addROWCINV22SIG1 has a maximum of 75");
        }
        
        this._ROWCINV22SIG1List.add(vROWCINV22SIG1);
    } //-- void addROWCINV22SIG1(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV22SIG1
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV22SIG1(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1 vROWCINV22SIG1)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV22SIG1List.size() >= 75) {
            throw new IndexOutOfBoundsException("addROWCINV22SIG1 has a maximum of 75");
        }
        
        this._ROWCINV22SIG1List.add(index, vROWCINV22SIG1);
    } //-- void addROWCINV22SIG1(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINV22SIG1
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1> enumerateROWCINV22SIG1()
    {
        return java.util.Collections.enumeration(this._ROWCINV22SIG1List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1> enumerateROWCINV22SIG1() 

    /**
     * Method getROWCINV22SIG1
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1 getROWCINV22SIG1(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV22SIG1List.size()) {
            throw new IndexOutOfBoundsException("getROWCINV22SIG1: Index value '" + index + "' not in range [0.." + (this._ROWCINV22SIG1List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1) _ROWCINV22SIG1List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1 getROWCINV22SIG1(int) 

    /**
     * Method getROWCINV22SIG1
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1[] getROWCINV22SIG1()
    {
        int size = this._ROWCINV22SIG1List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1) _ROWCINV22SIG1List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1[] getROWCINV22SIG1() 

    /**
     * Method getROWCINV22SIG1AsReference
     * 
     * Returns a reference to '_ROWCINV22SIG1List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1> getROWCINV22SIG1AsReference()
    {
        return this._ROWCINV22SIG1List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1> getROWCINV22SIG1AsReference() 

    /**
     * Method getROWCINV22SIG1Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINV22SIG1Count()
    {
        return this._ROWCINV22SIG1List.size();
    } //-- int getROWCINV22SIG1Count() 

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
     * Method iterateROWCINV22SIG1
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1> iterateROWCINV22SIG1()
    {
        return this._ROWCINV22SIG1List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1> iterateROWCINV22SIG1() 

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
    public void removeAllROWCINV22SIG1()
    {
        this._ROWCINV22SIG1List.clear();
    } //-- void removeAllROWCINV22SIG1() 

    /**
     * Method removeROWCINV22SIG1
     * 
     * 
     * 
     * @param vROWCINV22SIG1
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINV22SIG1(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1 vROWCINV22SIG1)
    {
        boolean removed = _ROWCINV22SIG1List.remove(vROWCINV22SIG1);
        return removed;
    } //-- boolean removeROWCINV22SIG1(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1) 

    /**
     * Method removeROWCINV22SIG1At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1 removeROWCINV22SIG1At(int index)
    {
        Object obj = this._ROWCINV22SIG1List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1 removeROWCINV22SIG1At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV22SIG1
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINV22SIG1(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1 vROWCINV22SIG1)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV22SIG1List.size()) {
            throw new IndexOutOfBoundsException("setROWCINV22SIG1: Index value '" + index + "' not in range [0.." + (this._ROWCINV22SIG1List.size() - 1) + "]");
        }
        
        this._ROWCINV22SIG1List.set(index, vROWCINV22SIG1);
    } //-- void setROWCINV22SIG1(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1) 

    /**
     * 
     * 
     * @param vROWCINV22SIG1Array
     */
    public void setROWCINV22SIG1(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1[] vROWCINV22SIG1Array)
    {
        //-- copy array
        _ROWCINV22SIG1List.clear();
        
        for (int i = 0; i < vROWCINV22SIG1Array.length; i++) {
                this._ROWCINV22SIG1List.add(vROWCINV22SIG1Array[i]);
        }
    } //-- void setROWCINV22SIG1(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1) 

    /**
     * Sets the value of '_ROWCINV22SIG1List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINV22SIG1List the Vector to copy.
     */
    public void setROWCINV22SIG1(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1> vROWCINV22SIG1List)
    {
        // copy vector
        this._ROWCINV22SIG1List.clear();
        
        this._ROWCINV22SIG1List.addAll(vROWCINV22SIG1List);
    } //-- void setROWCINV22SIG1(java.util.List) 

    /**
     * Sets the value of '_ROWCINV22SIG1List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINV22SIG1Vector the Vector to set.
     */
    public void setROWCINV22SIG1AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1> ROWCINV22SIG1Vector)
    {
        this._ROWCINV22SIG1List = ROWCINV22SIG1Vector;
    } //-- void setROWCINV22SIG1AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1_ARRAY unmarshal(java.io.Reader) 

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
