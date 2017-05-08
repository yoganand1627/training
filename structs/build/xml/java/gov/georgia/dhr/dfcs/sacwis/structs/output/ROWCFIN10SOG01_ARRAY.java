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
 * Class ROWCFIN10SOG01_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFIN10SOG01_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCFIN10SOG01List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01> _ROWCFIN10SOG01List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFIN10SOG01_ARRAY() 
     {
        super();
        this._ROWCFIN10SOG01List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCFIN10SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFIN10SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01 vROWCFIN10SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFIN10SOG01List.size() >= 300) {
            throw new IndexOutOfBoundsException("addROWCFIN10SOG01 has a maximum of 300");
        }
        
        this._ROWCFIN10SOG01List.add(vROWCFIN10SOG01);
    } //-- void addROWCFIN10SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFIN10SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFIN10SOG01(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01 vROWCFIN10SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFIN10SOG01List.size() >= 300) {
            throw new IndexOutOfBoundsException("addROWCFIN10SOG01 has a maximum of 300");
        }
        
        this._ROWCFIN10SOG01List.add(index, vROWCFIN10SOG01);
    } //-- void addROWCFIN10SOG01(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCFIN10SOG01
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01> enumerateROWCFIN10SOG01()
    {
        return java.util.Collections.enumeration(this._ROWCFIN10SOG01List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01> enumerateROWCFIN10SOG01() 

    /**
     * Method getROWCFIN10SOG01
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01 getROWCFIN10SOG01(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFIN10SOG01List.size()) {
            throw new IndexOutOfBoundsException("getROWCFIN10SOG01: Index value '" + index + "' not in range [0.." + (this._ROWCFIN10SOG01List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01) _ROWCFIN10SOG01List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01 getROWCFIN10SOG01(int) 

    /**
     * Method getROWCFIN10SOG01
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01[] getROWCFIN10SOG01()
    {
        int size = this._ROWCFIN10SOG01List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01) _ROWCFIN10SOG01List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01[] getROWCFIN10SOG01() 

    /**
     * Method getROWCFIN10SOG01AsReference
     * 
     * Returns a reference to '_ROWCFIN10SOG01List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01> getROWCFIN10SOG01AsReference()
    {
        return this._ROWCFIN10SOG01List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01> getROWCFIN10SOG01AsReference() 

    /**
     * Method getROWCFIN10SOG01Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCFIN10SOG01Count()
    {
        return this._ROWCFIN10SOG01List.size();
    } //-- int getROWCFIN10SOG01Count() 

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
     * Method iterateROWCFIN10SOG01
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01> iterateROWCFIN10SOG01()
    {
        return this._ROWCFIN10SOG01List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01> iterateROWCFIN10SOG01() 

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
    public void removeAllROWCFIN10SOG01()
    {
        this._ROWCFIN10SOG01List.clear();
    } //-- void removeAllROWCFIN10SOG01() 

    /**
     * Method removeROWCFIN10SOG01
     * 
     * 
     * 
     * @param vROWCFIN10SOG01
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCFIN10SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01 vROWCFIN10SOG01)
    {
        boolean removed = _ROWCFIN10SOG01List.remove(vROWCFIN10SOG01);
        return removed;
    } //-- boolean removeROWCFIN10SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01) 

    /**
     * Method removeROWCFIN10SOG01At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01 removeROWCFIN10SOG01At(int index)
    {
        Object obj = this._ROWCFIN10SOG01List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01 removeROWCFIN10SOG01At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFIN10SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCFIN10SOG01(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01 vROWCFIN10SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFIN10SOG01List.size()) {
            throw new IndexOutOfBoundsException("setROWCFIN10SOG01: Index value '" + index + "' not in range [0.." + (this._ROWCFIN10SOG01List.size() - 1) + "]");
        }
        
        this._ROWCFIN10SOG01List.set(index, vROWCFIN10SOG01);
    } //-- void setROWCFIN10SOG01(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01) 

    /**
     * 
     * 
     * @param vROWCFIN10SOG01Array
     */
    public void setROWCFIN10SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01[] vROWCFIN10SOG01Array)
    {
        //-- copy array
        _ROWCFIN10SOG01List.clear();
        
        for (int i = 0; i < vROWCFIN10SOG01Array.length; i++) {
                this._ROWCFIN10SOG01List.add(vROWCFIN10SOG01Array[i]);
        }
    } //-- void setROWCFIN10SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01) 

    /**
     * Sets the value of '_ROWCFIN10SOG01List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCFIN10SOG01List the Vector to copy.
     */
    public void setROWCFIN10SOG01(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01> vROWCFIN10SOG01List)
    {
        // copy vector
        this._ROWCFIN10SOG01List.clear();
        
        this._ROWCFIN10SOG01List.addAll(vROWCFIN10SOG01List);
    } //-- void setROWCFIN10SOG01(java.util.List) 

    /**
     * Sets the value of '_ROWCFIN10SOG01List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCFIN10SOG01Vector the Vector to set.
     */
    public void setROWCFIN10SOG01AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01> ROWCFIN10SOG01Vector)
    {
        this._ROWCFIN10SOG01List = ROWCFIN10SOG01Vector;
    } //-- void setROWCFIN10SOG01AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01_ARRAY unmarshal(java.io.Reader) 

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
