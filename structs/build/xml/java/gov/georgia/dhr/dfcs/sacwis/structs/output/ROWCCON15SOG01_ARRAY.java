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
 * Class ROWCCON15SOG01_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCON15SOG01_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCON15SOG01List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01> _ROWCCON15SOG01List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCON15SOG01_ARRAY() 
     {
        super();
        this._ROWCCON15SOG01List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCON15SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCON15SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01 vROWCCON15SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCON15SOG01List.size() >= 200) {
            throw new IndexOutOfBoundsException("addROWCCON15SOG01 has a maximum of 200");
        }
        
        this._ROWCCON15SOG01List.add(vROWCCON15SOG01);
    } //-- void addROWCCON15SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCON15SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCON15SOG01(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01 vROWCCON15SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCON15SOG01List.size() >= 200) {
            throw new IndexOutOfBoundsException("addROWCCON15SOG01 has a maximum of 200");
        }
        
        this._ROWCCON15SOG01List.add(index, vROWCCON15SOG01);
    } //-- void addROWCCON15SOG01(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCON15SOG01
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01> enumerateROWCCON15SOG01()
    {
        return java.util.Collections.enumeration(this._ROWCCON15SOG01List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01> enumerateROWCCON15SOG01() 

    /**
     * Method getROWCCON15SOG01
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01 getROWCCON15SOG01(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCON15SOG01List.size()) {
            throw new IndexOutOfBoundsException("getROWCCON15SOG01: Index value '" + index + "' not in range [0.." + (this._ROWCCON15SOG01List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01) _ROWCCON15SOG01List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01 getROWCCON15SOG01(int) 

    /**
     * Method getROWCCON15SOG01
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01[] getROWCCON15SOG01()
    {
        int size = this._ROWCCON15SOG01List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01) _ROWCCON15SOG01List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01[] getROWCCON15SOG01() 

    /**
     * Method getROWCCON15SOG01AsReference
     * 
     * Returns a reference to '_ROWCCON15SOG01List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01> getROWCCON15SOG01AsReference()
    {
        return this._ROWCCON15SOG01List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01> getROWCCON15SOG01AsReference() 

    /**
     * Method getROWCCON15SOG01Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCON15SOG01Count()
    {
        return this._ROWCCON15SOG01List.size();
    } //-- int getROWCCON15SOG01Count() 

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
     * Method iterateROWCCON15SOG01
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01> iterateROWCCON15SOG01()
    {
        return this._ROWCCON15SOG01List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01> iterateROWCCON15SOG01() 

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
    public void removeAllROWCCON15SOG01()
    {
        this._ROWCCON15SOG01List.clear();
    } //-- void removeAllROWCCON15SOG01() 

    /**
     * Method removeROWCCON15SOG01
     * 
     * 
     * 
     * @param vROWCCON15SOG01
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCON15SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01 vROWCCON15SOG01)
    {
        boolean removed = _ROWCCON15SOG01List.remove(vROWCCON15SOG01);
        return removed;
    } //-- boolean removeROWCCON15SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01) 

    /**
     * Method removeROWCCON15SOG01At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01 removeROWCCON15SOG01At(int index)
    {
        Object obj = this._ROWCCON15SOG01List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01 removeROWCCON15SOG01At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCON15SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCON15SOG01(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01 vROWCCON15SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCON15SOG01List.size()) {
            throw new IndexOutOfBoundsException("setROWCCON15SOG01: Index value '" + index + "' not in range [0.." + (this._ROWCCON15SOG01List.size() - 1) + "]");
        }
        
        this._ROWCCON15SOG01List.set(index, vROWCCON15SOG01);
    } //-- void setROWCCON15SOG01(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01) 

    /**
     * 
     * 
     * @param vROWCCON15SOG01Array
     */
    public void setROWCCON15SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01[] vROWCCON15SOG01Array)
    {
        //-- copy array
        _ROWCCON15SOG01List.clear();
        
        for (int i = 0; i < vROWCCON15SOG01Array.length; i++) {
                this._ROWCCON15SOG01List.add(vROWCCON15SOG01Array[i]);
        }
    } //-- void setROWCCON15SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01) 

    /**
     * Sets the value of '_ROWCCON15SOG01List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCON15SOG01List the Vector to copy.
     */
    public void setROWCCON15SOG01(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01> vROWCCON15SOG01List)
    {
        // copy vector
        this._ROWCCON15SOG01List.clear();
        
        this._ROWCCON15SOG01List.addAll(vROWCCON15SOG01List);
    } //-- void setROWCCON15SOG01(java.util.List) 

    /**
     * Sets the value of '_ROWCCON15SOG01List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCON15SOG01Vector the Vector to set.
     */
    public void setROWCCON15SOG01AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01> ROWCCON15SOG01Vector)
    {
        this._ROWCCON15SOG01List = ROWCCON15SOG01Vector;
    } //-- void setROWCCON15SOG01AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01_ARRAY unmarshal(java.io.Reader) 

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
