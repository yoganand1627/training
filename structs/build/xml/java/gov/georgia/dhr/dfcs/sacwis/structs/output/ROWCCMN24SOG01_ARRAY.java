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
 * Class ROWCCMN24SOG01_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN24SOG01_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN24SOG01List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01> _ROWCCMN24SOG01List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN24SOG01_ARRAY() 
     {
        super();
        this._ROWCCMN24SOG01List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN24SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN24SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01 vROWCCMN24SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN24SOG01List.size() >= 250) {
            throw new IndexOutOfBoundsException("addROWCCMN24SOG01 has a maximum of 250");
        }
        
        this._ROWCCMN24SOG01List.add(vROWCCMN24SOG01);
    } //-- void addROWCCMN24SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN24SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN24SOG01(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01 vROWCCMN24SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN24SOG01List.size() >= 250) {
            throw new IndexOutOfBoundsException("addROWCCMN24SOG01 has a maximum of 250");
        }
        
        this._ROWCCMN24SOG01List.add(index, vROWCCMN24SOG01);
    } //-- void addROWCCMN24SOG01(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN24SOG01
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01> enumerateROWCCMN24SOG01()
    {
        return java.util.Collections.enumeration(this._ROWCCMN24SOG01List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01> enumerateROWCCMN24SOG01() 

    /**
     * Method getROWCCMN24SOG01
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01 getROWCCMN24SOG01(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN24SOG01List.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN24SOG01: Index value '" + index + "' not in range [0.." + (this._ROWCCMN24SOG01List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01) _ROWCCMN24SOG01List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01 getROWCCMN24SOG01(int) 

    /**
     * Method getROWCCMN24SOG01
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01[] getROWCCMN24SOG01()
    {
        int size = this._ROWCCMN24SOG01List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01) _ROWCCMN24SOG01List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01[] getROWCCMN24SOG01() 

    /**
     * Method getROWCCMN24SOG01AsReference
     * 
     * Returns a reference to '_ROWCCMN24SOG01List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01> getROWCCMN24SOG01AsReference()
    {
        return this._ROWCCMN24SOG01List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01> getROWCCMN24SOG01AsReference() 

    /**
     * Method getROWCCMN24SOG01Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN24SOG01Count()
    {
        return this._ROWCCMN24SOG01List.size();
    } //-- int getROWCCMN24SOG01Count() 

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
     * Method iterateROWCCMN24SOG01
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01> iterateROWCCMN24SOG01()
    {
        return this._ROWCCMN24SOG01List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01> iterateROWCCMN24SOG01() 

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
    public void removeAllROWCCMN24SOG01()
    {
        this._ROWCCMN24SOG01List.clear();
    } //-- void removeAllROWCCMN24SOG01() 

    /**
     * Method removeROWCCMN24SOG01
     * 
     * 
     * 
     * @param vROWCCMN24SOG01
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN24SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01 vROWCCMN24SOG01)
    {
        boolean removed = _ROWCCMN24SOG01List.remove(vROWCCMN24SOG01);
        return removed;
    } //-- boolean removeROWCCMN24SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01) 

    /**
     * Method removeROWCCMN24SOG01At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01 removeROWCCMN24SOG01At(int index)
    {
        Object obj = this._ROWCCMN24SOG01List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01 removeROWCCMN24SOG01At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN24SOG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN24SOG01(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01 vROWCCMN24SOG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN24SOG01List.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN24SOG01: Index value '" + index + "' not in range [0.." + (this._ROWCCMN24SOG01List.size() - 1) + "]");
        }
        
        this._ROWCCMN24SOG01List.set(index, vROWCCMN24SOG01);
    } //-- void setROWCCMN24SOG01(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01) 

    /**
     * 
     * 
     * @param vROWCCMN24SOG01Array
     */
    public void setROWCCMN24SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01[] vROWCCMN24SOG01Array)
    {
        //-- copy array
        _ROWCCMN24SOG01List.clear();
        
        for (int i = 0; i < vROWCCMN24SOG01Array.length; i++) {
                this._ROWCCMN24SOG01List.add(vROWCCMN24SOG01Array[i]);
        }
    } //-- void setROWCCMN24SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01) 

    /**
     * Sets the value of '_ROWCCMN24SOG01List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN24SOG01List the Vector to copy.
     */
    public void setROWCCMN24SOG01(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01> vROWCCMN24SOG01List)
    {
        // copy vector
        this._ROWCCMN24SOG01List.clear();
        
        this._ROWCCMN24SOG01List.addAll(vROWCCMN24SOG01List);
    } //-- void setROWCCMN24SOG01(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN24SOG01List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN24SOG01Vector the Vector to set.
     */
    public void setROWCCMN24SOG01AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01> ROWCCMN24SOG01Vector)
    {
        this._ROWCCMN24SOG01List = ROWCCMN24SOG01Vector;
    } //-- void setROWCCMN24SOG01AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01_ARRAY unmarshal(java.io.Reader) 

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
