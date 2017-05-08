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
 * Class ROWCSYS03SOG01_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSYS03SOG01_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCSYS03SOG01List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01> _ROWCSYS03SOG01List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSYS03SOG01_ARRAY() 
     {
        super();
        this._ROWCSYS03SOG01List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCSYS03SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSYS03SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01 vROWCSYS03SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSYS03SOG01List.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCSYS03SOG01 has a maximum of 50");
        }
        
        this._ROWCSYS03SOG01List.add(vROWCSYS03SOG01);
    } //-- void addROWCSYS03SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSYS03SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSYS03SOG01(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01 vROWCSYS03SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSYS03SOG01List.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCSYS03SOG01 has a maximum of 50");
        }
        
        this._ROWCSYS03SOG01List.add(index, vROWCSYS03SOG01);
    } //-- void addROWCSYS03SOG01(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCSYS03SOG01
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01> enumerateROWCSYS03SOG01()
    {
        return java.util.Collections.enumeration(this._ROWCSYS03SOG01List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01> enumerateROWCSYS03SOG01() 

    /**
     * Method getROWCSYS03SOG01
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01 getROWCSYS03SOG01(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSYS03SOG01List.size()) {
            throw new IndexOutOfBoundsException("getROWCSYS03SOG01: Index value '" + index + "' not in range [0.." + (this._ROWCSYS03SOG01List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01) _ROWCSYS03SOG01List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01 getROWCSYS03SOG01(int) 

    /**
     * Method getROWCSYS03SOG01
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01[] getROWCSYS03SOG01()
    {
        int size = this._ROWCSYS03SOG01List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01) _ROWCSYS03SOG01List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01[] getROWCSYS03SOG01() 

    /**
     * Method getROWCSYS03SOG01AsReference
     * 
     * Returns a reference to '_ROWCSYS03SOG01List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01> getROWCSYS03SOG01AsReference()
    {
        return this._ROWCSYS03SOG01List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01> getROWCSYS03SOG01AsReference() 

    /**
     * Method getROWCSYS03SOG01Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCSYS03SOG01Count()
    {
        return this._ROWCSYS03SOG01List.size();
    } //-- int getROWCSYS03SOG01Count() 

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
     * Method iterateROWCSYS03SOG01
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01> iterateROWCSYS03SOG01()
    {
        return this._ROWCSYS03SOG01List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01> iterateROWCSYS03SOG01() 

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
    public void removeAllROWCSYS03SOG01()
    {
        this._ROWCSYS03SOG01List.clear();
    } //-- void removeAllROWCSYS03SOG01() 

    /**
     * Method removeROWCSYS03SOG01
     * 
     * 
     * 
     * @param vROWCSYS03SOG01
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCSYS03SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01 vROWCSYS03SOG01)
    {
        boolean removed = _ROWCSYS03SOG01List.remove(vROWCSYS03SOG01);
        return removed;
    } //-- boolean removeROWCSYS03SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01) 

    /**
     * Method removeROWCSYS03SOG01At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01 removeROWCSYS03SOG01At(int index)
    {
        Object obj = this._ROWCSYS03SOG01List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01 removeROWCSYS03SOG01At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSYS03SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCSYS03SOG01(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01 vROWCSYS03SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSYS03SOG01List.size()) {
            throw new IndexOutOfBoundsException("setROWCSYS03SOG01: Index value '" + index + "' not in range [0.." + (this._ROWCSYS03SOG01List.size() - 1) + "]");
        }
        
        this._ROWCSYS03SOG01List.set(index, vROWCSYS03SOG01);
    } //-- void setROWCSYS03SOG01(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01) 

    /**
     * 
     * 
     * @param vROWCSYS03SOG01Array
     */
    public void setROWCSYS03SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01[] vROWCSYS03SOG01Array)
    {
        //-- copy array
        _ROWCSYS03SOG01List.clear();
        
        for (int i = 0; i < vROWCSYS03SOG01Array.length; i++) {
                this._ROWCSYS03SOG01List.add(vROWCSYS03SOG01Array[i]);
        }
    } //-- void setROWCSYS03SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01) 

    /**
     * Sets the value of '_ROWCSYS03SOG01List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCSYS03SOG01List the Vector to copy.
     */
    public void setROWCSYS03SOG01(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01> vROWCSYS03SOG01List)
    {
        // copy vector
        this._ROWCSYS03SOG01List.clear();
        
        this._ROWCSYS03SOG01List.addAll(vROWCSYS03SOG01List);
    } //-- void setROWCSYS03SOG01(java.util.List) 

    /**
     * Sets the value of '_ROWCSYS03SOG01List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCSYS03SOG01Vector the Vector to set.
     */
    public void setROWCSYS03SOG01AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01> ROWCSYS03SOG01Vector)
    {
        this._ROWCSYS03SOG01List = ROWCSYS03SOG01Vector;
    } //-- void setROWCSYS03SOG01AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01_ARRAY unmarshal(java.io.Reader) 

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
