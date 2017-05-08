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
 * Class StageIdInStruct_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class StageIdInStruct_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _stageIdInStructList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct> _stageIdInStructList;


      //----------------/
     //- Constructors -/
    //----------------/

    public StageIdInStruct_ARRAY() 
     {
        super();
        this._stageIdInStructList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vStageIdInStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addStageIdInStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct vStageIdInStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._stageIdInStructList.size() >= 40) {
            throw new IndexOutOfBoundsException("addStageIdInStruct has a maximum of 40");
        }
        
        this._stageIdInStructList.add(vStageIdInStruct);
    } //-- void addStageIdInStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct) 

    /**
     * 
     * 
     * @param index
     * @param vStageIdInStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addStageIdInStruct(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct vStageIdInStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._stageIdInStructList.size() >= 40) {
            throw new IndexOutOfBoundsException("addStageIdInStruct has a maximum of 40");
        }
        
        this._stageIdInStructList.add(index, vStageIdInStruct);
    } //-- void addStageIdInStruct(int, gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateStageIdInStruct
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct> enumerateStageIdInStruct()
    {
        return java.util.Collections.enumeration(this._stageIdInStructList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct> enumerateStageIdInStruct() 

    /**
     * Method getStageIdInStruct
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct getStageIdInStruct(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._stageIdInStructList.size()) {
            throw new IndexOutOfBoundsException("getStageIdInStruct: Index value '" + index + "' not in range [0.." + (this._stageIdInStructList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct) _stageIdInStructList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct getStageIdInStruct(int) 

    /**
     * Method getStageIdInStruct
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct[] getStageIdInStruct()
    {
        int size = this._stageIdInStructList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct) _stageIdInStructList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct[] getStageIdInStruct() 

    /**
     * Method getStageIdInStructAsReference
     * 
     * Returns a reference to '_stageIdInStructList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct> getStageIdInStructAsReference()
    {
        return this._stageIdInStructList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct> getStageIdInStructAsReference() 

    /**
     * Method getStageIdInStructCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getStageIdInStructCount()
    {
        return this._stageIdInStructList.size();
    } //-- int getStageIdInStructCount() 

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
     * Method iterateStageIdInStruct
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct> iterateStageIdInStruct()
    {
        return this._stageIdInStructList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct> iterateStageIdInStruct() 

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
    public void removeAllStageIdInStruct()
    {
        this._stageIdInStructList.clear();
    } //-- void removeAllStageIdInStruct() 

    /**
     * Method removeStageIdInStruct
     * 
     * 
     * 
     * @param vStageIdInStruct
     * @return true if the object was removed from the collection.
     */
    public boolean removeStageIdInStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct vStageIdInStruct)
    {
        boolean removed = _stageIdInStructList.remove(vStageIdInStruct);
        return removed;
    } //-- boolean removeStageIdInStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct) 

    /**
     * Method removeStageIdInStructAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct removeStageIdInStructAt(int index)
    {
        Object obj = this._stageIdInStructList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct removeStageIdInStructAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vStageIdInStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setStageIdInStruct(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct vStageIdInStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._stageIdInStructList.size()) {
            throw new IndexOutOfBoundsException("setStageIdInStruct: Index value '" + index + "' not in range [0.." + (this._stageIdInStructList.size() - 1) + "]");
        }
        
        this._stageIdInStructList.set(index, vStageIdInStruct);
    } //-- void setStageIdInStruct(int, gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct) 

    /**
     * 
     * 
     * @param vStageIdInStructArray
     */
    public void setStageIdInStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct[] vStageIdInStructArray)
    {
        //-- copy array
        _stageIdInStructList.clear();
        
        for (int i = 0; i < vStageIdInStructArray.length; i++) {
                this._stageIdInStructList.add(vStageIdInStructArray[i]);
        }
    } //-- void setStageIdInStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct) 

    /**
     * Sets the value of '_stageIdInStructList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vStageIdInStructList the Vector to copy.
     */
    public void setStageIdInStruct(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct> vStageIdInStructList)
    {
        // copy vector
        this._stageIdInStructList.clear();
        
        this._stageIdInStructList.addAll(vStageIdInStructList);
    } //-- void setStageIdInStruct(java.util.List) 

    /**
     * Sets the value of '_stageIdInStructList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param StageIdInStructVector the Vector to set.
     */
    public void setStageIdInStructAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct> StageIdInStructVector)
    {
        this._stageIdInStructList = StageIdInStructVector;
    } //-- void setStageIdInStructAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct_ARRAY unmarshal(java.io.Reader) 

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
