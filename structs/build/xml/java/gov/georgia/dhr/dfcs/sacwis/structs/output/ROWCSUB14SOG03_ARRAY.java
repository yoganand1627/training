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
 * Class ROWCSUB14SOG03_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSUB14SOG03_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCSUB14SOG03List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03> _ROWCSUB14SOG03List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSUB14SOG03_ARRAY() 
     {
        super();
        this._ROWCSUB14SOG03List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCSUB14SOG03
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSUB14SOG03(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03 vROWCSUB14SOG03)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSUB14SOG03List.size() >= 30) {
            throw new IndexOutOfBoundsException("addROWCSUB14SOG03 has a maximum of 30");
        }
        
        this._ROWCSUB14SOG03List.add(vROWCSUB14SOG03);
    } //-- void addROWCSUB14SOG03(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSUB14SOG03
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSUB14SOG03(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03 vROWCSUB14SOG03)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSUB14SOG03List.size() >= 30) {
            throw new IndexOutOfBoundsException("addROWCSUB14SOG03 has a maximum of 30");
        }
        
        this._ROWCSUB14SOG03List.add(index, vROWCSUB14SOG03);
    } //-- void addROWCSUB14SOG03(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCSUB14SOG03
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03> enumerateROWCSUB14SOG03()
    {
        return java.util.Collections.enumeration(this._ROWCSUB14SOG03List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03> enumerateROWCSUB14SOG03() 

    /**
     * Method getROWCSUB14SOG03
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03 getROWCSUB14SOG03(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSUB14SOG03List.size()) {
            throw new IndexOutOfBoundsException("getROWCSUB14SOG03: Index value '" + index + "' not in range [0.." + (this._ROWCSUB14SOG03List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03) _ROWCSUB14SOG03List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03 getROWCSUB14SOG03(int) 

    /**
     * Method getROWCSUB14SOG03
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03[] getROWCSUB14SOG03()
    {
        int size = this._ROWCSUB14SOG03List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03) _ROWCSUB14SOG03List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03[] getROWCSUB14SOG03() 

    /**
     * Method getROWCSUB14SOG03AsReference
     * 
     * Returns a reference to '_ROWCSUB14SOG03List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03> getROWCSUB14SOG03AsReference()
    {
        return this._ROWCSUB14SOG03List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03> getROWCSUB14SOG03AsReference() 

    /**
     * Method getROWCSUB14SOG03Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCSUB14SOG03Count()
    {
        return this._ROWCSUB14SOG03List.size();
    } //-- int getROWCSUB14SOG03Count() 

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
     * Method iterateROWCSUB14SOG03
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03> iterateROWCSUB14SOG03()
    {
        return this._ROWCSUB14SOG03List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03> iterateROWCSUB14SOG03() 

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
    public void removeAllROWCSUB14SOG03()
    {
        this._ROWCSUB14SOG03List.clear();
    } //-- void removeAllROWCSUB14SOG03() 

    /**
     * Method removeROWCSUB14SOG03
     * 
     * 
     * 
     * @param vROWCSUB14SOG03
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCSUB14SOG03(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03 vROWCSUB14SOG03)
    {
        boolean removed = _ROWCSUB14SOG03List.remove(vROWCSUB14SOG03);
        return removed;
    } //-- boolean removeROWCSUB14SOG03(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03) 

    /**
     * Method removeROWCSUB14SOG03At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03 removeROWCSUB14SOG03At(int index)
    {
        Object obj = this._ROWCSUB14SOG03List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03 removeROWCSUB14SOG03At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSUB14SOG03
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCSUB14SOG03(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03 vROWCSUB14SOG03)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSUB14SOG03List.size()) {
            throw new IndexOutOfBoundsException("setROWCSUB14SOG03: Index value '" + index + "' not in range [0.." + (this._ROWCSUB14SOG03List.size() - 1) + "]");
        }
        
        this._ROWCSUB14SOG03List.set(index, vROWCSUB14SOG03);
    } //-- void setROWCSUB14SOG03(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03) 

    /**
     * 
     * 
     * @param vROWCSUB14SOG03Array
     */
    public void setROWCSUB14SOG03(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03[] vROWCSUB14SOG03Array)
    {
        //-- copy array
        _ROWCSUB14SOG03List.clear();
        
        for (int i = 0; i < vROWCSUB14SOG03Array.length; i++) {
                this._ROWCSUB14SOG03List.add(vROWCSUB14SOG03Array[i]);
        }
    } //-- void setROWCSUB14SOG03(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03) 

    /**
     * Sets the value of '_ROWCSUB14SOG03List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCSUB14SOG03List the Vector to copy.
     */
    public void setROWCSUB14SOG03(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03> vROWCSUB14SOG03List)
    {
        // copy vector
        this._ROWCSUB14SOG03List.clear();
        
        this._ROWCSUB14SOG03List.addAll(vROWCSUB14SOG03List);
    } //-- void setROWCSUB14SOG03(java.util.List) 

    /**
     * Sets the value of '_ROWCSUB14SOG03List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCSUB14SOG03Vector the Vector to set.
     */
    public void setROWCSUB14SOG03AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03> ROWCSUB14SOG03Vector)
    {
        this._ROWCSUB14SOG03List = ROWCSUB14SOG03Vector;
    } //-- void setROWCSUB14SOG03AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03_ARRAY unmarshal(java.io.Reader) 

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
