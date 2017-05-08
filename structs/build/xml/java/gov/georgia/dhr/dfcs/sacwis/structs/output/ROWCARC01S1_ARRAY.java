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
 * Class ROWCARC01S1_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCARC01S1_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCARC01S1List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1> _ROWCARC01S1List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCARC01S1_ARRAY() 
     {
        super();
        this._ROWCARC01S1List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCARC01S1
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCARC01S1(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1 vROWCARC01S1)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCARC01S1List.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCARC01S1 has a maximum of 100");
        }
        
        this._ROWCARC01S1List.add(vROWCARC01S1);
    } //-- void addROWCARC01S1(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1) 

    /**
     * 
     * 
     * @param index
     * @param vROWCARC01S1
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCARC01S1(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1 vROWCARC01S1)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCARC01S1List.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCARC01S1 has a maximum of 100");
        }
        
        this._ROWCARC01S1List.add(index, vROWCARC01S1);
    } //-- void addROWCARC01S1(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCARC01S1
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1> enumerateROWCARC01S1()
    {
        return java.util.Collections.enumeration(this._ROWCARC01S1List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1> enumerateROWCARC01S1() 

    /**
     * Method getROWCARC01S1
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1 getROWCARC01S1(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCARC01S1List.size()) {
            throw new IndexOutOfBoundsException("getROWCARC01S1: Index value '" + index + "' not in range [0.." + (this._ROWCARC01S1List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1) _ROWCARC01S1List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1 getROWCARC01S1(int) 

    /**
     * Method getROWCARC01S1
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1[] getROWCARC01S1()
    {
        int size = this._ROWCARC01S1List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1) _ROWCARC01S1List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1[] getROWCARC01S1() 

    /**
     * Method getROWCARC01S1AsReference
     * 
     * Returns a reference to '_ROWCARC01S1List'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1> getROWCARC01S1AsReference()
    {
        return this._ROWCARC01S1List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1> getROWCARC01S1AsReference() 

    /**
     * Method getROWCARC01S1Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCARC01S1Count()
    {
        return this._ROWCARC01S1List.size();
    } //-- int getROWCARC01S1Count() 

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
     * Method iterateROWCARC01S1
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1> iterateROWCARC01S1()
    {
        return this._ROWCARC01S1List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1> iterateROWCARC01S1() 

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
    public void removeAllROWCARC01S1()
    {
        this._ROWCARC01S1List.clear();
    } //-- void removeAllROWCARC01S1() 

    /**
     * Method removeROWCARC01S1
     * 
     * 
     * 
     * @param vROWCARC01S1
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCARC01S1(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1 vROWCARC01S1)
    {
        boolean removed = _ROWCARC01S1List.remove(vROWCARC01S1);
        return removed;
    } //-- boolean removeROWCARC01S1(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1) 

    /**
     * Method removeROWCARC01S1At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1 removeROWCARC01S1At(int index)
    {
        Object obj = this._ROWCARC01S1List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1 removeROWCARC01S1At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCARC01S1
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCARC01S1(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1 vROWCARC01S1)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCARC01S1List.size()) {
            throw new IndexOutOfBoundsException("setROWCARC01S1: Index value '" + index + "' not in range [0.." + (this._ROWCARC01S1List.size() - 1) + "]");
        }
        
        this._ROWCARC01S1List.set(index, vROWCARC01S1);
    } //-- void setROWCARC01S1(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1) 

    /**
     * 
     * 
     * @param vROWCARC01S1Array
     */
    public void setROWCARC01S1(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1[] vROWCARC01S1Array)
    {
        //-- copy array
        _ROWCARC01S1List.clear();
        
        for (int i = 0; i < vROWCARC01S1Array.length; i++) {
                this._ROWCARC01S1List.add(vROWCARC01S1Array[i]);
        }
    } //-- void setROWCARC01S1(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1) 

    /**
     * Sets the value of '_ROWCARC01S1List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCARC01S1List the Vector to copy.
     */
    public void setROWCARC01S1(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1> vROWCARC01S1List)
    {
        // copy vector
        this._ROWCARC01S1List.clear();
        
        this._ROWCARC01S1List.addAll(vROWCARC01S1List);
    } //-- void setROWCARC01S1(java.util.List) 

    /**
     * Sets the value of '_ROWCARC01S1List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCARC01S1Vector the Vector to set.
     */
    public void setROWCARC01S1AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1> ROWCARC01S1Vector)
    {
        this._ROWCARC01S1List = ROWCARC01S1Vector;
    } //-- void setROWCARC01S1AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1_ARRAY unmarshal(java.io.Reader) 

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
