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
 * Class AllegLstOutStruct_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AllegLstOutStruct_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _allegLstOutStructList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct> _allegLstOutStructList;


      //----------------/
     //- Constructors -/
    //----------------/

    public AllegLstOutStruct_ARRAY() 
     {
        super();
        this._allegLstOutStructList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAllegLstOutStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAllegLstOutStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct vAllegLstOutStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._allegLstOutStructList.size() >= 50) {
            throw new IndexOutOfBoundsException("addAllegLstOutStruct has a maximum of 50");
        }
        
        this._allegLstOutStructList.add(vAllegLstOutStruct);
    } //-- void addAllegLstOutStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct) 

    /**
     * 
     * 
     * @param index
     * @param vAllegLstOutStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAllegLstOutStruct(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct vAllegLstOutStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._allegLstOutStructList.size() >= 50) {
            throw new IndexOutOfBoundsException("addAllegLstOutStruct has a maximum of 50");
        }
        
        this._allegLstOutStructList.add(index, vAllegLstOutStruct);
    } //-- void addAllegLstOutStruct(int, gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateAllegLstOutStruct
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct> enumerateAllegLstOutStruct()
    {
        return java.util.Collections.enumeration(this._allegLstOutStructList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct> enumerateAllegLstOutStruct() 

    /**
     * Method getAllegLstOutStruct
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct getAllegLstOutStruct(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._allegLstOutStructList.size()) {
            throw new IndexOutOfBoundsException("getAllegLstOutStruct: Index value '" + index + "' not in range [0.." + (this._allegLstOutStructList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct) _allegLstOutStructList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct getAllegLstOutStruct(int) 

    /**
     * Method getAllegLstOutStruct
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct[] getAllegLstOutStruct()
    {
        int size = this._allegLstOutStructList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct) _allegLstOutStructList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct[] getAllegLstOutStruct() 

    /**
     * Method getAllegLstOutStructAsReference
     * 
     * Returns a reference to '_allegLstOutStructList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct> getAllegLstOutStructAsReference()
    {
        return this._allegLstOutStructList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct> getAllegLstOutStructAsReference() 

    /**
     * Method getAllegLstOutStructCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getAllegLstOutStructCount()
    {
        return this._allegLstOutStructList.size();
    } //-- int getAllegLstOutStructCount() 

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
     * Method iterateAllegLstOutStruct
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct> iterateAllegLstOutStruct()
    {
        return this._allegLstOutStructList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct> iterateAllegLstOutStruct() 

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
    public void removeAllAllegLstOutStruct()
    {
        this._allegLstOutStructList.clear();
    } //-- void removeAllAllegLstOutStruct() 

    /**
     * Method removeAllegLstOutStruct
     * 
     * 
     * 
     * @param vAllegLstOutStruct
     * @return true if the object was removed from the collection.
     */
    public boolean removeAllegLstOutStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct vAllegLstOutStruct)
    {
        boolean removed = _allegLstOutStructList.remove(vAllegLstOutStruct);
        return removed;
    } //-- boolean removeAllegLstOutStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct) 

    /**
     * Method removeAllegLstOutStructAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct removeAllegLstOutStructAt(int index)
    {
        Object obj = this._allegLstOutStructList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct removeAllegLstOutStructAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vAllegLstOutStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAllegLstOutStruct(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct vAllegLstOutStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._allegLstOutStructList.size()) {
            throw new IndexOutOfBoundsException("setAllegLstOutStruct: Index value '" + index + "' not in range [0.." + (this._allegLstOutStructList.size() - 1) + "]");
        }
        
        this._allegLstOutStructList.set(index, vAllegLstOutStruct);
    } //-- void setAllegLstOutStruct(int, gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct) 

    /**
     * 
     * 
     * @param vAllegLstOutStructArray
     */
    public void setAllegLstOutStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct[] vAllegLstOutStructArray)
    {
        //-- copy array
        _allegLstOutStructList.clear();
        
        for (int i = 0; i < vAllegLstOutStructArray.length; i++) {
                this._allegLstOutStructList.add(vAllegLstOutStructArray[i]);
        }
    } //-- void setAllegLstOutStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct) 

    /**
     * Sets the value of '_allegLstOutStructList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vAllegLstOutStructList the Vector to copy.
     */
    public void setAllegLstOutStruct(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct> vAllegLstOutStructList)
    {
        // copy vector
        this._allegLstOutStructList.clear();
        
        this._allegLstOutStructList.addAll(vAllegLstOutStructList);
    } //-- void setAllegLstOutStruct(java.util.List) 

    /**
     * Sets the value of '_allegLstOutStructList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param AllegLstOutStructVector the Vector to set.
     */
    public void setAllegLstOutStructAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct> AllegLstOutStructVector)
    {
        this._allegLstOutStructList = AllegLstOutStructVector;
    } //-- void setAllegLstOutStructAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AllegLstOutStruct_ARRAY unmarshal(java.io.Reader) 

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
