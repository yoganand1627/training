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
 * Class ROWCINV23SOG02_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV23SOG02_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINV23SOG02List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02> _ROWCINV23SOG02List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV23SOG02_ARRAY() 
     {
        super();
        this._ROWCINV23SOG02List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINV23SOG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV23SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02 vROWCINV23SOG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV23SOG02List.size() >= 250) {
            throw new IndexOutOfBoundsException("addROWCINV23SOG02 has a maximum of 250");
        }
        
        this._ROWCINV23SOG02List.add(vROWCINV23SOG02);
    } //-- void addROWCINV23SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV23SOG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV23SOG02(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02 vROWCINV23SOG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV23SOG02List.size() >= 250) {
            throw new IndexOutOfBoundsException("addROWCINV23SOG02 has a maximum of 250");
        }
        
        this._ROWCINV23SOG02List.add(index, vROWCINV23SOG02);
    } //-- void addROWCINV23SOG02(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINV23SOG02
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02> enumerateROWCINV23SOG02()
    {
        return java.util.Collections.enumeration(this._ROWCINV23SOG02List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02> enumerateROWCINV23SOG02() 

    /**
     * Method getROWCINV23SOG02
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02 getROWCINV23SOG02(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV23SOG02List.size()) {
            throw new IndexOutOfBoundsException("getROWCINV23SOG02: Index value '" + index + "' not in range [0.." + (this._ROWCINV23SOG02List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02) _ROWCINV23SOG02List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02 getROWCINV23SOG02(int) 

    /**
     * Method getROWCINV23SOG02
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02[] getROWCINV23SOG02()
    {
        int size = this._ROWCINV23SOG02List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02) _ROWCINV23SOG02List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02[] getROWCINV23SOG02() 

    /**
     * Method getROWCINV23SOG02AsReference
     * 
     * Returns a reference to '_ROWCINV23SOG02List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02> getROWCINV23SOG02AsReference()
    {
        return this._ROWCINV23SOG02List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02> getROWCINV23SOG02AsReference() 

    /**
     * Method getROWCINV23SOG02Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINV23SOG02Count()
    {
        return this._ROWCINV23SOG02List.size();
    } //-- int getROWCINV23SOG02Count() 

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
     * Method iterateROWCINV23SOG02
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02> iterateROWCINV23SOG02()
    {
        return this._ROWCINV23SOG02List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02> iterateROWCINV23SOG02() 

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
    public void removeAllROWCINV23SOG02()
    {
        this._ROWCINV23SOG02List.clear();
    } //-- void removeAllROWCINV23SOG02() 

    /**
     * Method removeROWCINV23SOG02
     * 
     * 
     * 
     * @param vROWCINV23SOG02
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINV23SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02 vROWCINV23SOG02)
    {
        boolean removed = _ROWCINV23SOG02List.remove(vROWCINV23SOG02);
        return removed;
    } //-- boolean removeROWCINV23SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02) 

    /**
     * Method removeROWCINV23SOG02At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02 removeROWCINV23SOG02At(int index)
    {
        Object obj = this._ROWCINV23SOG02List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02 removeROWCINV23SOG02At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV23SOG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINV23SOG02(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02 vROWCINV23SOG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV23SOG02List.size()) {
            throw new IndexOutOfBoundsException("setROWCINV23SOG02: Index value '" + index + "' not in range [0.." + (this._ROWCINV23SOG02List.size() - 1) + "]");
        }
        
        this._ROWCINV23SOG02List.set(index, vROWCINV23SOG02);
    } //-- void setROWCINV23SOG02(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02) 

    /**
     * 
     * 
     * @param vROWCINV23SOG02Array
     */
    public void setROWCINV23SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02[] vROWCINV23SOG02Array)
    {
        //-- copy array
        _ROWCINV23SOG02List.clear();
        
        for (int i = 0; i < vROWCINV23SOG02Array.length; i++) {
                this._ROWCINV23SOG02List.add(vROWCINV23SOG02Array[i]);
        }
    } //-- void setROWCINV23SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02) 

    /**
     * Sets the value of '_ROWCINV23SOG02List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINV23SOG02List the Vector to copy.
     */
    public void setROWCINV23SOG02(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02> vROWCINV23SOG02List)
    {
        // copy vector
        this._ROWCINV23SOG02List.clear();
        
        this._ROWCINV23SOG02List.addAll(vROWCINV23SOG02List);
    } //-- void setROWCINV23SOG02(java.util.List) 

    /**
     * Sets the value of '_ROWCINV23SOG02List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINV23SOG02Vector the Vector to set.
     */
    public void setROWCINV23SOG02AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02> ROWCINV23SOG02Vector)
    {
        this._ROWCINV23SOG02List = ROWCINV23SOG02Vector;
    } //-- void setROWCINV23SOG02AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02_ARRAY unmarshal(java.io.Reader) 

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
