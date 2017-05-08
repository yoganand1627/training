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
 * Class ROWCARC18SIG00_ARRAY_CARC17SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCARC18SIG00_ARRAY_CARC17SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCARC18SIG00List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00> _ROWCARC18SIG00List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCARC18SIG00_ARRAY_CARC17SI() 
     {
        super();
        this._ROWCARC18SIG00List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00_ARRAY_CARC17SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCARC18SIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCARC18SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00 vROWCARC18SIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCARC18SIG00List.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCARC18SIG00 has a maximum of 50");
        }
        
        this._ROWCARC18SIG00List.add(vROWCARC18SIG00);
    } //-- void addROWCARC18SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00) 

    /**
     * 
     * 
     * @param index
     * @param vROWCARC18SIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCARC18SIG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00 vROWCARC18SIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCARC18SIG00List.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCARC18SIG00 has a maximum of 50");
        }
        
        this._ROWCARC18SIG00List.add(index, vROWCARC18SIG00);
    } //-- void addROWCARC18SIG00(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCARC18SIG00
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00> enumerateROWCARC18SIG00()
    {
        return java.util.Collections.enumeration(this._ROWCARC18SIG00List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00> enumerateROWCARC18SIG00() 

    /**
     * Method getROWCARC18SIG00
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00 getROWCARC18SIG00(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCARC18SIG00List.size()) {
            throw new IndexOutOfBoundsException("getROWCARC18SIG00: Index value '" + index + "' not in range [0.." + (this._ROWCARC18SIG00List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00) _ROWCARC18SIG00List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00 getROWCARC18SIG00(int) 

    /**
     * Method getROWCARC18SIG00
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00[] getROWCARC18SIG00()
    {
        int size = this._ROWCARC18SIG00List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00) _ROWCARC18SIG00List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00[] getROWCARC18SIG00() 

    /**
     * Method getROWCARC18SIG00AsReference
     * 
     * Returns a reference to '_ROWCARC18SIG00List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00> getROWCARC18SIG00AsReference()
    {
        return this._ROWCARC18SIG00List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00> getROWCARC18SIG00AsReference() 

    /**
     * Method getROWCARC18SIG00Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCARC18SIG00Count()
    {
        return this._ROWCARC18SIG00List.size();
    } //-- int getROWCARC18SIG00Count() 

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
     * Method iterateROWCARC18SIG00
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00> iterateROWCARC18SIG00()
    {
        return this._ROWCARC18SIG00List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00> iterateROWCARC18SIG00() 

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
    public void removeAllROWCARC18SIG00()
    {
        this._ROWCARC18SIG00List.clear();
    } //-- void removeAllROWCARC18SIG00() 

    /**
     * Method removeROWCARC18SIG00
     * 
     * 
     * 
     * @param vROWCARC18SIG00
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCARC18SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00 vROWCARC18SIG00)
    {
        boolean removed = _ROWCARC18SIG00List.remove(vROWCARC18SIG00);
        return removed;
    } //-- boolean removeROWCARC18SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00) 

    /**
     * Method removeROWCARC18SIG00At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00 removeROWCARC18SIG00At(int index)
    {
        Object obj = this._ROWCARC18SIG00List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00 removeROWCARC18SIG00At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCARC18SIG00
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCARC18SIG00(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00 vROWCARC18SIG00)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCARC18SIG00List.size()) {
            throw new IndexOutOfBoundsException("setROWCARC18SIG00: Index value '" + index + "' not in range [0.." + (this._ROWCARC18SIG00List.size() - 1) + "]");
        }
        
        this._ROWCARC18SIG00List.set(index, vROWCARC18SIG00);
    } //-- void setROWCARC18SIG00(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00) 

    /**
     * 
     * 
     * @param vROWCARC18SIG00Array
     */
    public void setROWCARC18SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00[] vROWCARC18SIG00Array)
    {
        //-- copy array
        _ROWCARC18SIG00List.clear();
        
        for (int i = 0; i < vROWCARC18SIG00Array.length; i++) {
                this._ROWCARC18SIG00List.add(vROWCARC18SIG00Array[i]);
        }
    } //-- void setROWCARC18SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00) 

    /**
     * Sets the value of '_ROWCARC18SIG00List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCARC18SIG00List the Vector to copy.
     */
    public void setROWCARC18SIG00(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00> vROWCARC18SIG00List)
    {
        // copy vector
        this._ROWCARC18SIG00List.clear();
        
        this._ROWCARC18SIG00List.addAll(vROWCARC18SIG00List);
    } //-- void setROWCARC18SIG00(java.util.List) 

    /**
     * Sets the value of '_ROWCARC18SIG00List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCARC18SIG00Vector the Vector to set.
     */
    public void setROWCARC18SIG00AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00> ROWCARC18SIG00Vector)
    {
        this._ROWCARC18SIG00List = ROWCARC18SIG00Vector;
    } //-- void setROWCARC18SIG00AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00_ARRAY_CARC17SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00_ARRAY_CARC17SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00_ARRAY_CARC17SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00_ARRAY_CARC17SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00_ARRAY_CARC17SI unmarshal(java.io.Reader) 

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
