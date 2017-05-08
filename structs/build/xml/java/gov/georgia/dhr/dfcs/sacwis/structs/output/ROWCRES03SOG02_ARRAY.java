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
 * Class ROWCRES03SOG02_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCRES03SOG02_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCRES03SOG02List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02> _ROWCRES03SOG02List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCRES03SOG02_ARRAY() 
     {
        super();
        this._ROWCRES03SOG02List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCRES03SOG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCRES03SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02 vROWCRES03SOG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCRES03SOG02List.size() >= 15) {
            throw new IndexOutOfBoundsException("addROWCRES03SOG02 has a maximum of 15");
        }
        
        this._ROWCRES03SOG02List.add(vROWCRES03SOG02);
    } //-- void addROWCRES03SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02) 

    /**
     * 
     * 
     * @param index
     * @param vROWCRES03SOG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCRES03SOG02(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02 vROWCRES03SOG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCRES03SOG02List.size() >= 15) {
            throw new IndexOutOfBoundsException("addROWCRES03SOG02 has a maximum of 15");
        }
        
        this._ROWCRES03SOG02List.add(index, vROWCRES03SOG02);
    } //-- void addROWCRES03SOG02(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCRES03SOG02
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02> enumerateROWCRES03SOG02()
    {
        return java.util.Collections.enumeration(this._ROWCRES03SOG02List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02> enumerateROWCRES03SOG02() 

    /**
     * Method getROWCRES03SOG02
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02 getROWCRES03SOG02(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCRES03SOG02List.size()) {
            throw new IndexOutOfBoundsException("getROWCRES03SOG02: Index value '" + index + "' not in range [0.." + (this._ROWCRES03SOG02List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02) _ROWCRES03SOG02List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02 getROWCRES03SOG02(int) 

    /**
     * Method getROWCRES03SOG02
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02[] getROWCRES03SOG02()
    {
        int size = this._ROWCRES03SOG02List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02) _ROWCRES03SOG02List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02[] getROWCRES03SOG02() 

    /**
     * Method getROWCRES03SOG02AsReference
     * 
     * Returns a reference to '_ROWCRES03SOG02List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02> getROWCRES03SOG02AsReference()
    {
        return this._ROWCRES03SOG02List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02> getROWCRES03SOG02AsReference() 

    /**
     * Method getROWCRES03SOG02Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCRES03SOG02Count()
    {
        return this._ROWCRES03SOG02List.size();
    } //-- int getROWCRES03SOG02Count() 

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
     * Method iterateROWCRES03SOG02
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02> iterateROWCRES03SOG02()
    {
        return this._ROWCRES03SOG02List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02> iterateROWCRES03SOG02() 

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
    public void removeAllROWCRES03SOG02()
    {
        this._ROWCRES03SOG02List.clear();
    } //-- void removeAllROWCRES03SOG02() 

    /**
     * Method removeROWCRES03SOG02
     * 
     * 
     * 
     * @param vROWCRES03SOG02
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCRES03SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02 vROWCRES03SOG02)
    {
        boolean removed = _ROWCRES03SOG02List.remove(vROWCRES03SOG02);
        return removed;
    } //-- boolean removeROWCRES03SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02) 

    /**
     * Method removeROWCRES03SOG02At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02 removeROWCRES03SOG02At(int index)
    {
        Object obj = this._ROWCRES03SOG02List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02 removeROWCRES03SOG02At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCRES03SOG02
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCRES03SOG02(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02 vROWCRES03SOG02)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCRES03SOG02List.size()) {
            throw new IndexOutOfBoundsException("setROWCRES03SOG02: Index value '" + index + "' not in range [0.." + (this._ROWCRES03SOG02List.size() - 1) + "]");
        }
        
        this._ROWCRES03SOG02List.set(index, vROWCRES03SOG02);
    } //-- void setROWCRES03SOG02(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02) 

    /**
     * 
     * 
     * @param vROWCRES03SOG02Array
     */
    public void setROWCRES03SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02[] vROWCRES03SOG02Array)
    {
        //-- copy array
        _ROWCRES03SOG02List.clear();
        
        for (int i = 0; i < vROWCRES03SOG02Array.length; i++) {
                this._ROWCRES03SOG02List.add(vROWCRES03SOG02Array[i]);
        }
    } //-- void setROWCRES03SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02) 

    /**
     * Sets the value of '_ROWCRES03SOG02List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCRES03SOG02List the Vector to copy.
     */
    public void setROWCRES03SOG02(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02> vROWCRES03SOG02List)
    {
        // copy vector
        this._ROWCRES03SOG02List.clear();
        
        this._ROWCRES03SOG02List.addAll(vROWCRES03SOG02List);
    } //-- void setROWCRES03SOG02(java.util.List) 

    /**
     * Sets the value of '_ROWCRES03SOG02List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCRES03SOG02Vector the Vector to set.
     */
    public void setROWCRES03SOG02AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02> ROWCRES03SOG02Vector)
    {
        this._ROWCRES03SOG02List = ROWCRES03SOG02Vector;
    } //-- void setROWCRES03SOG02AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02_ARRAY unmarshal(java.io.Reader) 

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
