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
 * Class ROWCINV36SOG02_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV36SOG02_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINV36SOG02List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02> _ROWCINV36SOG02List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV36SOG02_ARRAY() 
     {
        super();
        this._ROWCINV36SOG02List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINV36SOG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV36SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02 vROWCINV36SOG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV36SOG02List.size() >= 30) {
            throw new IndexOutOfBoundsException("addROWCINV36SOG02 has a maximum of 30");
        }
        
        this._ROWCINV36SOG02List.add(vROWCINV36SOG02);
    } //-- void addROWCINV36SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV36SOG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV36SOG02(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02 vROWCINV36SOG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV36SOG02List.size() >= 30) {
            throw new IndexOutOfBoundsException("addROWCINV36SOG02 has a maximum of 30");
        }
        
        this._ROWCINV36SOG02List.add(index, vROWCINV36SOG02);
    } //-- void addROWCINV36SOG02(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINV36SOG02
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02> enumerateROWCINV36SOG02()
    {
        return java.util.Collections.enumeration(this._ROWCINV36SOG02List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02> enumerateROWCINV36SOG02() 

    /**
     * Method getROWCINV36SOG02
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02 getROWCINV36SOG02(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV36SOG02List.size()) {
            throw new IndexOutOfBoundsException("getROWCINV36SOG02: Index value '" + index + "' not in range [0.." + (this._ROWCINV36SOG02List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02) _ROWCINV36SOG02List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02 getROWCINV36SOG02(int) 

    /**
     * Method getROWCINV36SOG02
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02[] getROWCINV36SOG02()
    {
        int size = this._ROWCINV36SOG02List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02) _ROWCINV36SOG02List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02[] getROWCINV36SOG02() 

    /**
     * Method getROWCINV36SOG02AsReference
     * 
     * Returns a reference to '_ROWCINV36SOG02List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02> getROWCINV36SOG02AsReference()
    {
        return this._ROWCINV36SOG02List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02> getROWCINV36SOG02AsReference() 

    /**
     * Method getROWCINV36SOG02Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINV36SOG02Count()
    {
        return this._ROWCINV36SOG02List.size();
    } //-- int getROWCINV36SOG02Count() 

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
     * Method iterateROWCINV36SOG02
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02> iterateROWCINV36SOG02()
    {
        return this._ROWCINV36SOG02List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02> iterateROWCINV36SOG02() 

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
    public void removeAllROWCINV36SOG02()
    {
        this._ROWCINV36SOG02List.clear();
    } //-- void removeAllROWCINV36SOG02() 

    /**
     * Method removeROWCINV36SOG02
     * 
     * 
     * 
     * @param vROWCINV36SOG02
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINV36SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02 vROWCINV36SOG02)
    {
        boolean removed = _ROWCINV36SOG02List.remove(vROWCINV36SOG02);
        return removed;
    } //-- boolean removeROWCINV36SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02) 

    /**
     * Method removeROWCINV36SOG02At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02 removeROWCINV36SOG02At(int index)
    {
        Object obj = this._ROWCINV36SOG02List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02 removeROWCINV36SOG02At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV36SOG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINV36SOG02(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02 vROWCINV36SOG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV36SOG02List.size()) {
            throw new IndexOutOfBoundsException("setROWCINV36SOG02: Index value '" + index + "' not in range [0.." + (this._ROWCINV36SOG02List.size() - 1) + "]");
        }
        
        this._ROWCINV36SOG02List.set(index, vROWCINV36SOG02);
    } //-- void setROWCINV36SOG02(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02) 

    /**
     * 
     * 
     * @param vROWCINV36SOG02Array
     */
    public void setROWCINV36SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02[] vROWCINV36SOG02Array)
    {
        //-- copy array
        _ROWCINV36SOG02List.clear();
        
        for (int i = 0; i < vROWCINV36SOG02Array.length; i++) {
                this._ROWCINV36SOG02List.add(vROWCINV36SOG02Array[i]);
        }
    } //-- void setROWCINV36SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02) 

    /**
     * Sets the value of '_ROWCINV36SOG02List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINV36SOG02List the Vector to copy.
     */
    public void setROWCINV36SOG02(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02> vROWCINV36SOG02List)
    {
        // copy vector
        this._ROWCINV36SOG02List.clear();
        
        this._ROWCINV36SOG02List.addAll(vROWCINV36SOG02List);
    } //-- void setROWCINV36SOG02(java.util.List) 

    /**
     * Sets the value of '_ROWCINV36SOG02List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINV36SOG02Vector the Vector to set.
     */
    public void setROWCINV36SOG02AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02> ROWCINV36SOG02Vector)
    {
        this._ROWCINV36SOG02List = ROWCINV36SOG02Vector;
    } //-- void setROWCINV36SOG02AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG02_ARRAY unmarshal(java.io.Reader) 

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
