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
 * Class ROWCFAD07SOG02_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFAD07SOG02_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCFAD07SOG02List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02> _ROWCFAD07SOG02List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFAD07SOG02_ARRAY() 
     {
        super();
        this._ROWCFAD07SOG02List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCFAD07SOG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFAD07SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02 vROWCFAD07SOG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFAD07SOG02List.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCFAD07SOG02 has a maximum of 100");
        }
        
        this._ROWCFAD07SOG02List.add(vROWCFAD07SOG02);
    } //-- void addROWCFAD07SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFAD07SOG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFAD07SOG02(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02 vROWCFAD07SOG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFAD07SOG02List.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCFAD07SOG02 has a maximum of 100");
        }
        
        this._ROWCFAD07SOG02List.add(index, vROWCFAD07SOG02);
    } //-- void addROWCFAD07SOG02(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCFAD07SOG02
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02> enumerateROWCFAD07SOG02()
    {
        return java.util.Collections.enumeration(this._ROWCFAD07SOG02List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02> enumerateROWCFAD07SOG02() 

    /**
     * Method getROWCFAD07SOG02
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02 getROWCFAD07SOG02(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFAD07SOG02List.size()) {
            throw new IndexOutOfBoundsException("getROWCFAD07SOG02: Index value '" + index + "' not in range [0.." + (this._ROWCFAD07SOG02List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02) _ROWCFAD07SOG02List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02 getROWCFAD07SOG02(int) 

    /**
     * Method getROWCFAD07SOG02
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02[] getROWCFAD07SOG02()
    {
        int size = this._ROWCFAD07SOG02List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02) _ROWCFAD07SOG02List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02[] getROWCFAD07SOG02() 

    /**
     * Method getROWCFAD07SOG02AsReference
     * 
     * Returns a reference to '_ROWCFAD07SOG02List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02> getROWCFAD07SOG02AsReference()
    {
        return this._ROWCFAD07SOG02List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02> getROWCFAD07SOG02AsReference() 

    /**
     * Method getROWCFAD07SOG02Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCFAD07SOG02Count()
    {
        return this._ROWCFAD07SOG02List.size();
    } //-- int getROWCFAD07SOG02Count() 

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
     * Method iterateROWCFAD07SOG02
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02> iterateROWCFAD07SOG02()
    {
        return this._ROWCFAD07SOG02List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02> iterateROWCFAD07SOG02() 

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
    public void removeAllROWCFAD07SOG02()
    {
        this._ROWCFAD07SOG02List.clear();
    } //-- void removeAllROWCFAD07SOG02() 

    /**
     * Method removeROWCFAD07SOG02
     * 
     * 
     * 
     * @param vROWCFAD07SOG02
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCFAD07SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02 vROWCFAD07SOG02)
    {
        boolean removed = _ROWCFAD07SOG02List.remove(vROWCFAD07SOG02);
        return removed;
    } //-- boolean removeROWCFAD07SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02) 

    /**
     * Method removeROWCFAD07SOG02At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02 removeROWCFAD07SOG02At(int index)
    {
        Object obj = this._ROWCFAD07SOG02List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02 removeROWCFAD07SOG02At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFAD07SOG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCFAD07SOG02(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02 vROWCFAD07SOG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFAD07SOG02List.size()) {
            throw new IndexOutOfBoundsException("setROWCFAD07SOG02: Index value '" + index + "' not in range [0.." + (this._ROWCFAD07SOG02List.size() - 1) + "]");
        }
        
        this._ROWCFAD07SOG02List.set(index, vROWCFAD07SOG02);
    } //-- void setROWCFAD07SOG02(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02) 

    /**
     * 
     * 
     * @param vROWCFAD07SOG02Array
     */
    public void setROWCFAD07SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02[] vROWCFAD07SOG02Array)
    {
        //-- copy array
        _ROWCFAD07SOG02List.clear();
        
        for (int i = 0; i < vROWCFAD07SOG02Array.length; i++) {
                this._ROWCFAD07SOG02List.add(vROWCFAD07SOG02Array[i]);
        }
    } //-- void setROWCFAD07SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02) 

    /**
     * Sets the value of '_ROWCFAD07SOG02List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCFAD07SOG02List the Vector to copy.
     */
    public void setROWCFAD07SOG02(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02> vROWCFAD07SOG02List)
    {
        // copy vector
        this._ROWCFAD07SOG02List.clear();
        
        this._ROWCFAD07SOG02List.addAll(vROWCFAD07SOG02List);
    } //-- void setROWCFAD07SOG02(java.util.List) 

    /**
     * Sets the value of '_ROWCFAD07SOG02List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCFAD07SOG02Vector the Vector to set.
     */
    public void setROWCFAD07SOG02AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02> ROWCFAD07SOG02Vector)
    {
        this._ROWCFAD07SOG02List = ROWCFAD07SOG02Vector;
    } //-- void setROWCFAD07SOG02AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02_ARRAY unmarshal(java.io.Reader) 

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
