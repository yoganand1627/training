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
 * Class ROWCSUB15SIG03_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSUB15SIG03_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCSUB15SIG03List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03> _ROWCSUB15SIG03List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSUB15SIG03_ARRAY() 
     {
        super();
        this._ROWCSUB15SIG03List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCSUB15SIG03
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSUB15SIG03(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03 vROWCSUB15SIG03)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSUB15SIG03List.size() >= 30) {
            throw new IndexOutOfBoundsException("addROWCSUB15SIG03 has a maximum of 30");
        }
        
        this._ROWCSUB15SIG03List.add(vROWCSUB15SIG03);
    } //-- void addROWCSUB15SIG03(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSUB15SIG03
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSUB15SIG03(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03 vROWCSUB15SIG03)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSUB15SIG03List.size() >= 30) {
            throw new IndexOutOfBoundsException("addROWCSUB15SIG03 has a maximum of 30");
        }
        
        this._ROWCSUB15SIG03List.add(index, vROWCSUB15SIG03);
    } //-- void addROWCSUB15SIG03(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCSUB15SIG03
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03> enumerateROWCSUB15SIG03()
    {
        return java.util.Collections.enumeration(this._ROWCSUB15SIG03List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03> enumerateROWCSUB15SIG03() 

    /**
     * Method getROWCSUB15SIG03
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03 getROWCSUB15SIG03(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSUB15SIG03List.size()) {
            throw new IndexOutOfBoundsException("getROWCSUB15SIG03: Index value '" + index + "' not in range [0.." + (this._ROWCSUB15SIG03List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03) _ROWCSUB15SIG03List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03 getROWCSUB15SIG03(int) 

    /**
     * Method getROWCSUB15SIG03
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03[] getROWCSUB15SIG03()
    {
        int size = this._ROWCSUB15SIG03List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03) _ROWCSUB15SIG03List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03[] getROWCSUB15SIG03() 

    /**
     * Method getROWCSUB15SIG03AsReference
     * 
     * Returns a reference to '_ROWCSUB15SIG03List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03> getROWCSUB15SIG03AsReference()
    {
        return this._ROWCSUB15SIG03List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03> getROWCSUB15SIG03AsReference() 

    /**
     * Method getROWCSUB15SIG03Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCSUB15SIG03Count()
    {
        return this._ROWCSUB15SIG03List.size();
    } //-- int getROWCSUB15SIG03Count() 

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
     * Method iterateROWCSUB15SIG03
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03> iterateROWCSUB15SIG03()
    {
        return this._ROWCSUB15SIG03List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03> iterateROWCSUB15SIG03() 

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
    public void removeAllROWCSUB15SIG03()
    {
        this._ROWCSUB15SIG03List.clear();
    } //-- void removeAllROWCSUB15SIG03() 

    /**
     * Method removeROWCSUB15SIG03
     * 
     * 
     * 
     * @param vROWCSUB15SIG03
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCSUB15SIG03(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03 vROWCSUB15SIG03)
    {
        boolean removed = _ROWCSUB15SIG03List.remove(vROWCSUB15SIG03);
        return removed;
    } //-- boolean removeROWCSUB15SIG03(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03) 

    /**
     * Method removeROWCSUB15SIG03At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03 removeROWCSUB15SIG03At(int index)
    {
        Object obj = this._ROWCSUB15SIG03List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03 removeROWCSUB15SIG03At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSUB15SIG03
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCSUB15SIG03(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03 vROWCSUB15SIG03)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSUB15SIG03List.size()) {
            throw new IndexOutOfBoundsException("setROWCSUB15SIG03: Index value '" + index + "' not in range [0.." + (this._ROWCSUB15SIG03List.size() - 1) + "]");
        }
        
        this._ROWCSUB15SIG03List.set(index, vROWCSUB15SIG03);
    } //-- void setROWCSUB15SIG03(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03) 

    /**
     * 
     * 
     * @param vROWCSUB15SIG03Array
     */
    public void setROWCSUB15SIG03(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03[] vROWCSUB15SIG03Array)
    {
        //-- copy array
        _ROWCSUB15SIG03List.clear();
        
        for (int i = 0; i < vROWCSUB15SIG03Array.length; i++) {
                this._ROWCSUB15SIG03List.add(vROWCSUB15SIG03Array[i]);
        }
    } //-- void setROWCSUB15SIG03(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03) 

    /**
     * Sets the value of '_ROWCSUB15SIG03List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCSUB15SIG03List the Vector to copy.
     */
    public void setROWCSUB15SIG03(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03> vROWCSUB15SIG03List)
    {
        // copy vector
        this._ROWCSUB15SIG03List.clear();
        
        this._ROWCSUB15SIG03List.addAll(vROWCSUB15SIG03List);
    } //-- void setROWCSUB15SIG03(java.util.List) 

    /**
     * Sets the value of '_ROWCSUB15SIG03List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCSUB15SIG03Vector the Vector to set.
     */
    public void setROWCSUB15SIG03AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03> ROWCSUB15SIG03Vector)
    {
        this._ROWCSUB15SIG03List = ROWCSUB15SIG03Vector;
    } //-- void setROWCSUB15SIG03AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03_ARRAY unmarshal(java.io.Reader) 

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
