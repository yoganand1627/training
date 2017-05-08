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
 * Class Code1OutStruct_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Code1OutStruct_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _code1OutStructList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct> _code1OutStructList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Code1OutStruct_ARRAY() 
     {
        super();
        this._code1OutStructList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCode1OutStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCode1OutStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct vCode1OutStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._code1OutStructList.size() >= 10) {
            throw new IndexOutOfBoundsException("addCode1OutStruct has a maximum of 10");
        }
        
        this._code1OutStructList.add(vCode1OutStruct);
    } //-- void addCode1OutStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct) 

    /**
     * 
     * 
     * @param index
     * @param vCode1OutStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCode1OutStruct(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct vCode1OutStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._code1OutStructList.size() >= 10) {
            throw new IndexOutOfBoundsException("addCode1OutStruct has a maximum of 10");
        }
        
        this._code1OutStructList.add(index, vCode1OutStruct);
    } //-- void addCode1OutStruct(int, gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCode1OutStruct
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct> enumerateCode1OutStruct()
    {
        return java.util.Collections.enumeration(this._code1OutStructList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct> enumerateCode1OutStruct() 

    /**
     * Method getCode1OutStruct
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct getCode1OutStruct(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._code1OutStructList.size()) {
            throw new IndexOutOfBoundsException("getCode1OutStruct: Index value '" + index + "' not in range [0.." + (this._code1OutStructList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct) _code1OutStructList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct getCode1OutStruct(int) 

    /**
     * Method getCode1OutStruct
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct[] getCode1OutStruct()
    {
        int size = this._code1OutStructList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct) _code1OutStructList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct[] getCode1OutStruct() 

    /**
     * Method getCode1OutStructAsReference
     * 
     * Returns a reference to '_code1OutStructList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct> getCode1OutStructAsReference()
    {
        return this._code1OutStructList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct> getCode1OutStructAsReference() 

    /**
     * Method getCode1OutStructCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCode1OutStructCount()
    {
        return this._code1OutStructList.size();
    } //-- int getCode1OutStructCount() 

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
     * Method iterateCode1OutStruct
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct> iterateCode1OutStruct()
    {
        return this._code1OutStructList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct> iterateCode1OutStruct() 

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
    public void removeAllCode1OutStruct()
    {
        this._code1OutStructList.clear();
    } //-- void removeAllCode1OutStruct() 

    /**
     * Method removeCode1OutStruct
     * 
     * 
     * 
     * @param vCode1OutStruct
     * @return true if the object was removed from the collection.
     */
    public boolean removeCode1OutStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct vCode1OutStruct)
    {
        boolean removed = _code1OutStructList.remove(vCode1OutStruct);
        return removed;
    } //-- boolean removeCode1OutStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct) 

    /**
     * Method removeCode1OutStructAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct removeCode1OutStructAt(int index)
    {
        Object obj = this._code1OutStructList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct removeCode1OutStructAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vCode1OutStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCode1OutStruct(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct vCode1OutStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._code1OutStructList.size()) {
            throw new IndexOutOfBoundsException("setCode1OutStruct: Index value '" + index + "' not in range [0.." + (this._code1OutStructList.size() - 1) + "]");
        }
        
        this._code1OutStructList.set(index, vCode1OutStruct);
    } //-- void setCode1OutStruct(int, gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct) 

    /**
     * 
     * 
     * @param vCode1OutStructArray
     */
    public void setCode1OutStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct[] vCode1OutStructArray)
    {
        //-- copy array
        _code1OutStructList.clear();
        
        for (int i = 0; i < vCode1OutStructArray.length; i++) {
                this._code1OutStructList.add(vCode1OutStructArray[i]);
        }
    } //-- void setCode1OutStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct) 

    /**
     * Sets the value of '_code1OutStructList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vCode1OutStructList the Vector to copy.
     */
    public void setCode1OutStruct(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct> vCode1OutStructList)
    {
        // copy vector
        this._code1OutStructList.clear();
        
        this._code1OutStructList.addAll(vCode1OutStructList);
    } //-- void setCode1OutStruct(java.util.List) 

    /**
     * Sets the value of '_code1OutStructList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param Code1OutStructVector the Vector to set.
     */
    public void setCode1OutStructAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct> Code1OutStructVector)
    {
        this._code1OutStructList = Code1OutStructVector;
    } //-- void setCode1OutStructAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct_ARRAY unmarshal(java.io.Reader) 

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
