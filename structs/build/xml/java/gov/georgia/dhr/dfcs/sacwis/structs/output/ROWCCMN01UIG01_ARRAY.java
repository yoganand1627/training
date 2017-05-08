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
 * Class ROWCCMN01UIG01_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN01UIG01_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN01UIG01List
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01> _ROWCCMN01UIG01List;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN01UIG01_ARRAY() 
     {
        super();
        this._ROWCCMN01UIG01List = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN01UIG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN01UIG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01 vROWCCMN01UIG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN01UIG01List.size() >= 30) {
            throw new IndexOutOfBoundsException("addROWCCMN01UIG01 has a maximum of 30");
        }
        
        this._ROWCCMN01UIG01List.add(vROWCCMN01UIG01);
    } //-- void addROWCCMN01UIG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN01UIG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN01UIG01(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01 vROWCCMN01UIG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN01UIG01List.size() >= 30) {
            throw new IndexOutOfBoundsException("addROWCCMN01UIG01 has a maximum of 30");
        }
        
        this._ROWCCMN01UIG01List.add(index, vROWCCMN01UIG01);
    } //-- void addROWCCMN01UIG01(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN01UIG01
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01> enumerateROWCCMN01UIG01()
    {
        return java.util.Collections.enumeration(this._ROWCCMN01UIG01List);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01> enumerateROWCCMN01UIG01() 

    /**
     * Method getROWCCMN01UIG01
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01 at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01 getROWCCMN01UIG01(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN01UIG01List.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN01UIG01: Index value '" + index + "' not in range [0.." + (this._ROWCCMN01UIG01List.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01) _ROWCCMN01UIG01List.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01 getROWCCMN01UIG01(int) 

    /**
     * Method getROWCCMN01UIG01
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01[] getROWCCMN01UIG01()
    {
        int size = this._ROWCCMN01UIG01List.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01) _ROWCCMN01UIG01List.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01[] getROWCCMN01UIG01() 

    /**
     * Method getROWCCMN01UIG01AsReference
     * 
     * Returns a reference to '_ROWCCMN01UIG01List'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01> getROWCCMN01UIG01AsReference()
    {
        return this._ROWCCMN01UIG01List;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01> getROWCCMN01UIG01AsReference() 

    /**
     * Method getROWCCMN01UIG01Count
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN01UIG01Count()
    {
        return this._ROWCCMN01UIG01List.size();
    } //-- int getROWCCMN01UIG01Count() 

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
     * Method iterateROWCCMN01UIG01
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01> iterateROWCCMN01UIG01()
    {
        return this._ROWCCMN01UIG01List.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01> iterateROWCCMN01UIG01() 

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
    public void removeAllROWCCMN01UIG01()
    {
        this._ROWCCMN01UIG01List.clear();
    } //-- void removeAllROWCCMN01UIG01() 

    /**
     * Method removeROWCCMN01UIG01
     * 
     * 
     * 
     * @param vROWCCMN01UIG01
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN01UIG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01 vROWCCMN01UIG01)
    {
        boolean removed = _ROWCCMN01UIG01List.remove(vROWCCMN01UIG01);
        return removed;
    } //-- boolean removeROWCCMN01UIG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01) 

    /**
     * Method removeROWCCMN01UIG01At
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01 removeROWCCMN01UIG01At(int index)
    {
        Object obj = this._ROWCCMN01UIG01List.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01 removeROWCCMN01UIG01At(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN01UIG01
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN01UIG01(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01 vROWCCMN01UIG01)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN01UIG01List.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN01UIG01: Index value '" + index + "' not in range [0.." + (this._ROWCCMN01UIG01List.size() - 1) + "]");
        }
        
        this._ROWCCMN01UIG01List.set(index, vROWCCMN01UIG01);
    } //-- void setROWCCMN01UIG01(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01) 

    /**
     * 
     * 
     * @param vROWCCMN01UIG01Array
     */
    public void setROWCCMN01UIG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01[] vROWCCMN01UIG01Array)
    {
        //-- copy array
        _ROWCCMN01UIG01List.clear();
        
        for (int i = 0; i < vROWCCMN01UIG01Array.length; i++) {
                this._ROWCCMN01UIG01List.add(vROWCCMN01UIG01Array[i]);
        }
    } //-- void setROWCCMN01UIG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01) 

    /**
     * Sets the value of '_ROWCCMN01UIG01List' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN01UIG01List the Vector to copy.
     */
    public void setROWCCMN01UIG01(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01> vROWCCMN01UIG01List)
    {
        // copy vector
        this._ROWCCMN01UIG01List.clear();
        
        this._ROWCCMN01UIG01List.addAll(vROWCCMN01UIG01List);
    } //-- void setROWCCMN01UIG01(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN01UIG01List' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN01UIG01Vector the Vector to set.
     */
    public void setROWCCMN01UIG01AsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01> ROWCCMN01UIG01Vector)
    {
        this._ROWCCMN01UIG01List = ROWCCMN01UIG01Vector;
    } //-- void setROWCCMN01UIG01AsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01_ARRAY unmarshal(java.io.Reader) 

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
