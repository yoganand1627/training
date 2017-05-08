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
 * Class ROWCINV51SOG01_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV51SOG01_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINV51SOG01List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01> _ROWCINV51SOG01List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV51SOG01_ARRAY() 
     {
        super();
        this._ROWCINV51SOG01List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINV51SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV51SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01 vROWCINV51SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV51SOG01List.size() >= 35) {
            throw new IndexOutOfBoundsException("addROWCINV51SOG01 has a maximum of 35");
        }
        
        this._ROWCINV51SOG01List.add(vROWCINV51SOG01);
    } //-- void addROWCINV51SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV51SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV51SOG01(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01 vROWCINV51SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV51SOG01List.size() >= 35) {
            throw new IndexOutOfBoundsException("addROWCINV51SOG01 has a maximum of 35");
        }
        
        this._ROWCINV51SOG01List.add(index, vROWCINV51SOG01);
    } //-- void addROWCINV51SOG01(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINV51SOG01
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01> enumerateROWCINV51SOG01()
    {
        return java.util.Collections.enumeration(this._ROWCINV51SOG01List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01> enumerateROWCINV51SOG01() 

    /**
     * Method getROWCINV51SOG01
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01 getROWCINV51SOG01(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV51SOG01List.size()) {
            throw new IndexOutOfBoundsException("getROWCINV51SOG01: Index value '" + index + "' not in range [0.." + (this._ROWCINV51SOG01List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01) _ROWCINV51SOG01List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01 getROWCINV51SOG01(int) 

    /**
     * Method getROWCINV51SOG01
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01[] getROWCINV51SOG01()
    {
        int size = this._ROWCINV51SOG01List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01) _ROWCINV51SOG01List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01[] getROWCINV51SOG01() 

    /**
     * Method getROWCINV51SOG01AsReference
     * 
     * Returns a reference to '_ROWCINV51SOG01List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01> getROWCINV51SOG01AsReference()
    {
        return this._ROWCINV51SOG01List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01> getROWCINV51SOG01AsReference() 

    /**
     * Method getROWCINV51SOG01Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINV51SOG01Count()
    {
        return this._ROWCINV51SOG01List.size();
    } //-- int getROWCINV51SOG01Count() 

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
     * Method iterateROWCINV51SOG01
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01> iterateROWCINV51SOG01()
    {
        return this._ROWCINV51SOG01List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01> iterateROWCINV51SOG01() 

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
    public void removeAllROWCINV51SOG01()
    {
        this._ROWCINV51SOG01List.clear();
    } //-- void removeAllROWCINV51SOG01() 

    /**
     * Method removeROWCINV51SOG01
     * 
     * 
     * 
     * @param vROWCINV51SOG01
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINV51SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01 vROWCINV51SOG01)
    {
        boolean removed = _ROWCINV51SOG01List.remove(vROWCINV51SOG01);
        return removed;
    } //-- boolean removeROWCINV51SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01) 

    /**
     * Method removeROWCINV51SOG01At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01 removeROWCINV51SOG01At(int index)
    {
        Object obj = this._ROWCINV51SOG01List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01 removeROWCINV51SOG01At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV51SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINV51SOG01(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01 vROWCINV51SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV51SOG01List.size()) {
            throw new IndexOutOfBoundsException("setROWCINV51SOG01: Index value '" + index + "' not in range [0.." + (this._ROWCINV51SOG01List.size() - 1) + "]");
        }
        
        this._ROWCINV51SOG01List.set(index, vROWCINV51SOG01);
    } //-- void setROWCINV51SOG01(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01) 

    /**
     * 
     * 
     * @param vROWCINV51SOG01Array
     */
    public void setROWCINV51SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01[] vROWCINV51SOG01Array)
    {
        //-- copy array
        _ROWCINV51SOG01List.clear();
        
        for (int i = 0; i < vROWCINV51SOG01Array.length; i++) {
                this._ROWCINV51SOG01List.add(vROWCINV51SOG01Array[i]);
        }
    } //-- void setROWCINV51SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01) 

    /**
     * Sets the value of '_ROWCINV51SOG01List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINV51SOG01List the Vector to copy.
     */
    public void setROWCINV51SOG01(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01> vROWCINV51SOG01List)
    {
        // copy vector
        this._ROWCINV51SOG01List.clear();
        
        this._ROWCINV51SOG01List.addAll(vROWCINV51SOG01List);
    } //-- void setROWCINV51SOG01(java.util.List) 

    /**
     * Sets the value of '_ROWCINV51SOG01List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINV51SOG01Vector the Vector to set.
     */
    public void setROWCINV51SOG01AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01> ROWCINV51SOG01Vector)
    {
        this._ROWCINV51SOG01List = ROWCINV51SOG01Vector;
    } //-- void setROWCINV51SOG01AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01_ARRAY unmarshal(java.io.Reader) 

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
