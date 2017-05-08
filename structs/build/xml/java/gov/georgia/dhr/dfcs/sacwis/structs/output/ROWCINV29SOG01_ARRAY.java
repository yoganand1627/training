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
 * Class ROWCINV29SOG01_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV29SOG01_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINV29SOG01List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01> _ROWCINV29SOG01List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV29SOG01_ARRAY() 
     {
        super();
        this._ROWCINV29SOG01List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINV29SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV29SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01 vROWCINV29SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV29SOG01List.size() >= 20) {
            throw new IndexOutOfBoundsException("addROWCINV29SOG01 has a maximum of 20");
        }
        
        this._ROWCINV29SOG01List.add(vROWCINV29SOG01);
    } //-- void addROWCINV29SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV29SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV29SOG01(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01 vROWCINV29SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV29SOG01List.size() >= 20) {
            throw new IndexOutOfBoundsException("addROWCINV29SOG01 has a maximum of 20");
        }
        
        this._ROWCINV29SOG01List.add(index, vROWCINV29SOG01);
    } //-- void addROWCINV29SOG01(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINV29SOG01
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01> enumerateROWCINV29SOG01()
    {
        return java.util.Collections.enumeration(this._ROWCINV29SOG01List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01> enumerateROWCINV29SOG01() 

    /**
     * Method getROWCINV29SOG01
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01 getROWCINV29SOG01(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV29SOG01List.size()) {
            throw new IndexOutOfBoundsException("getROWCINV29SOG01: Index value '" + index + "' not in range [0.." + (this._ROWCINV29SOG01List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01) _ROWCINV29SOG01List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01 getROWCINV29SOG01(int) 

    /**
     * Method getROWCINV29SOG01
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01[] getROWCINV29SOG01()
    {
        int size = this._ROWCINV29SOG01List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01) _ROWCINV29SOG01List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01[] getROWCINV29SOG01() 

    /**
     * Method getROWCINV29SOG01AsReference
     * 
     * Returns a reference to '_ROWCINV29SOG01List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01> getROWCINV29SOG01AsReference()
    {
        return this._ROWCINV29SOG01List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01> getROWCINV29SOG01AsReference() 

    /**
     * Method getROWCINV29SOG01Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINV29SOG01Count()
    {
        return this._ROWCINV29SOG01List.size();
    } //-- int getROWCINV29SOG01Count() 

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
     * Method iterateROWCINV29SOG01
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01> iterateROWCINV29SOG01()
    {
        return this._ROWCINV29SOG01List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01> iterateROWCINV29SOG01() 

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
    public void removeAllROWCINV29SOG01()
    {
        this._ROWCINV29SOG01List.clear();
    } //-- void removeAllROWCINV29SOG01() 

    /**
     * Method removeROWCINV29SOG01
     * 
     * 
     * 
     * @param vROWCINV29SOG01
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINV29SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01 vROWCINV29SOG01)
    {
        boolean removed = _ROWCINV29SOG01List.remove(vROWCINV29SOG01);
        return removed;
    } //-- boolean removeROWCINV29SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01) 

    /**
     * Method removeROWCINV29SOG01At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01 removeROWCINV29SOG01At(int index)
    {
        Object obj = this._ROWCINV29SOG01List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01 removeROWCINV29SOG01At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV29SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINV29SOG01(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01 vROWCINV29SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV29SOG01List.size()) {
            throw new IndexOutOfBoundsException("setROWCINV29SOG01: Index value '" + index + "' not in range [0.." + (this._ROWCINV29SOG01List.size() - 1) + "]");
        }
        
        this._ROWCINV29SOG01List.set(index, vROWCINV29SOG01);
    } //-- void setROWCINV29SOG01(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01) 

    /**
     * 
     * 
     * @param vROWCINV29SOG01Array
     */
    public void setROWCINV29SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01[] vROWCINV29SOG01Array)
    {
        //-- copy array
        _ROWCINV29SOG01List.clear();
        
        for (int i = 0; i < vROWCINV29SOG01Array.length; i++) {
                this._ROWCINV29SOG01List.add(vROWCINV29SOG01Array[i]);
        }
    } //-- void setROWCINV29SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01) 

    /**
     * Sets the value of '_ROWCINV29SOG01List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINV29SOG01List the Vector to copy.
     */
    public void setROWCINV29SOG01(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01> vROWCINV29SOG01List)
    {
        // copy vector
        this._ROWCINV29SOG01List.clear();
        
        this._ROWCINV29SOG01List.addAll(vROWCINV29SOG01List);
    } //-- void setROWCINV29SOG01(java.util.List) 

    /**
     * Sets the value of '_ROWCINV29SOG01List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINV29SOG01Vector the Vector to set.
     */
    public void setROWCINV29SOG01AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01> ROWCINV29SOG01Vector)
    {
        this._ROWCINV29SOG01List = ROWCINV29SOG01Vector;
    } //-- void setROWCINV29SOG01AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01_ARRAY unmarshal(java.io.Reader) 

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
