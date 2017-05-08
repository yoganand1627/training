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
 * Class AvailStaffGroup_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AvailStaffGroup_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _availStaffGroupList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup> _availStaffGroupList;


      //----------------/
     //- Constructors -/
    //----------------/

    public AvailStaffGroup_ARRAY() 
     {
        super();
        this._availStaffGroupList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAvailStaffGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAvailStaffGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup vAvailStaffGroup)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._availStaffGroupList.size() >= 90) {
            throw new IndexOutOfBoundsException("addAvailStaffGroup has a maximum of 90");
        }
        
        this._availStaffGroupList.add(vAvailStaffGroup);
    } //-- void addAvailStaffGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup) 

    /**
     * 
     * 
     * @param index
     * @param vAvailStaffGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAvailStaffGroup(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup vAvailStaffGroup)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._availStaffGroupList.size() >= 90) {
            throw new IndexOutOfBoundsException("addAvailStaffGroup has a maximum of 90");
        }
        
        this._availStaffGroupList.add(index, vAvailStaffGroup);
    } //-- void addAvailStaffGroup(int, gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateAvailStaffGroup
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup> enumerateAvailStaffGroup()
    {
        return java.util.Collections.enumeration(this._availStaffGroupList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup> enumerateAvailStaffGroup() 

    /**
     * Method getAvailStaffGroup
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup getAvailStaffGroup(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._availStaffGroupList.size()) {
            throw new IndexOutOfBoundsException("getAvailStaffGroup: Index value '" + index + "' not in range [0.." + (this._availStaffGroupList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup) _availStaffGroupList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup getAvailStaffGroup(int) 

    /**
     * Method getAvailStaffGroup
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup[] getAvailStaffGroup()
    {
        int size = this._availStaffGroupList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup) _availStaffGroupList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup[] getAvailStaffGroup() 

    /**
     * Method getAvailStaffGroupAsReference
     * 
     * Returns a reference to '_availStaffGroupList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup> getAvailStaffGroupAsReference()
    {
        return this._availStaffGroupList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup> getAvailStaffGroupAsReference() 

    /**
     * Method getAvailStaffGroupCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getAvailStaffGroupCount()
    {
        return this._availStaffGroupList.size();
    } //-- int getAvailStaffGroupCount() 

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
     * Method iterateAvailStaffGroup
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup> iterateAvailStaffGroup()
    {
        return this._availStaffGroupList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup> iterateAvailStaffGroup() 

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
    public void removeAllAvailStaffGroup()
    {
        this._availStaffGroupList.clear();
    } //-- void removeAllAvailStaffGroup() 

    /**
     * Method removeAvailStaffGroup
     * 
     * 
     * 
     * @param vAvailStaffGroup
     * @return true if the object was removed from the collection.
     */
    public boolean removeAvailStaffGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup vAvailStaffGroup)
    {
        boolean removed = _availStaffGroupList.remove(vAvailStaffGroup);
        return removed;
    } //-- boolean removeAvailStaffGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup) 

    /**
     * Method removeAvailStaffGroupAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup removeAvailStaffGroupAt(int index)
    {
        Object obj = this._availStaffGroupList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup removeAvailStaffGroupAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vAvailStaffGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAvailStaffGroup(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup vAvailStaffGroup)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._availStaffGroupList.size()) {
            throw new IndexOutOfBoundsException("setAvailStaffGroup: Index value '" + index + "' not in range [0.." + (this._availStaffGroupList.size() - 1) + "]");
        }
        
        this._availStaffGroupList.set(index, vAvailStaffGroup);
    } //-- void setAvailStaffGroup(int, gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup) 

    /**
     * 
     * 
     * @param vAvailStaffGroupArray
     */
    public void setAvailStaffGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup[] vAvailStaffGroupArray)
    {
        //-- copy array
        _availStaffGroupList.clear();
        
        for (int i = 0; i < vAvailStaffGroupArray.length; i++) {
                this._availStaffGroupList.add(vAvailStaffGroupArray[i]);
        }
    } //-- void setAvailStaffGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup) 

    /**
     * Sets the value of '_availStaffGroupList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vAvailStaffGroupList the Vector to copy.
     */
    public void setAvailStaffGroup(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup> vAvailStaffGroupList)
    {
        // copy vector
        this._availStaffGroupList.clear();
        
        this._availStaffGroupList.addAll(vAvailStaffGroupList);
    } //-- void setAvailStaffGroup(java.util.List) 

    /**
     * Sets the value of '_availStaffGroupList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param AvailStaffGroupVector the Vector to set.
     */
    public void setAvailStaffGroupAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup> AvailStaffGroupVector)
    {
        this._availStaffGroupList = AvailStaffGroupVector;
    } //-- void setAvailStaffGroupAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup_ARRAY unmarshal(java.io.Reader) 

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
