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
 * Class AssignSaveGroup_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AssignSaveGroup_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _assignSaveGroupList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup> _assignSaveGroupList;


      //----------------/
     //- Constructors -/
    //----------------/

    public AssignSaveGroup_ARRAY() 
     {
        super();
        this._assignSaveGroupList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAssignSaveGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAssignSaveGroup(gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup vAssignSaveGroup)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._assignSaveGroupList.size() >= 100) {
            throw new IndexOutOfBoundsException("addAssignSaveGroup has a maximum of 100");
        }
        
        this._assignSaveGroupList.add(vAssignSaveGroup);
    } //-- void addAssignSaveGroup(gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup) 

    /**
     * 
     * 
     * @param index
     * @param vAssignSaveGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAssignSaveGroup(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup vAssignSaveGroup)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._assignSaveGroupList.size() >= 100) {
            throw new IndexOutOfBoundsException("addAssignSaveGroup has a maximum of 100");
        }
        
        this._assignSaveGroupList.add(index, vAssignSaveGroup);
    } //-- void addAssignSaveGroup(int, gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateAssignSaveGroup
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup> enumerateAssignSaveGroup()
    {
        return java.util.Collections.enumeration(this._assignSaveGroupList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup> enumerateAssignSaveGroup() 

    /**
     * Method getAssignSaveGroup
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup getAssignSaveGroup(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._assignSaveGroupList.size()) {
            throw new IndexOutOfBoundsException("getAssignSaveGroup: Index value '" + index + "' not in range [0.." + (this._assignSaveGroupList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup) _assignSaveGroupList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup getAssignSaveGroup(int) 

    /**
     * Method getAssignSaveGroup
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup[] getAssignSaveGroup()
    {
        int size = this._assignSaveGroupList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup) _assignSaveGroupList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup[] getAssignSaveGroup() 

    /**
     * Method getAssignSaveGroupAsReference
     * 
     * Returns a reference to '_assignSaveGroupList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup> getAssignSaveGroupAsReference()
    {
        return this._assignSaveGroupList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup> getAssignSaveGroupAsReference() 

    /**
     * Method getAssignSaveGroupCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getAssignSaveGroupCount()
    {
        return this._assignSaveGroupList.size();
    } //-- int getAssignSaveGroupCount() 

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
     * Method iterateAssignSaveGroup
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup> iterateAssignSaveGroup()
    {
        return this._assignSaveGroupList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup> iterateAssignSaveGroup() 

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
    public void removeAllAssignSaveGroup()
    {
        this._assignSaveGroupList.clear();
    } //-- void removeAllAssignSaveGroup() 

    /**
     * Method removeAssignSaveGroup
     * 
     * 
     * 
     * @param vAssignSaveGroup
     * @return true if the object was removed from the collection.
     */
    public boolean removeAssignSaveGroup(gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup vAssignSaveGroup)
    {
        boolean removed = _assignSaveGroupList.remove(vAssignSaveGroup);
        return removed;
    } //-- boolean removeAssignSaveGroup(gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup) 

    /**
     * Method removeAssignSaveGroupAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup removeAssignSaveGroupAt(int index)
    {
        Object obj = this._assignSaveGroupList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup removeAssignSaveGroupAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vAssignSaveGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAssignSaveGroup(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup vAssignSaveGroup)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._assignSaveGroupList.size()) {
            throw new IndexOutOfBoundsException("setAssignSaveGroup: Index value '" + index + "' not in range [0.." + (this._assignSaveGroupList.size() - 1) + "]");
        }
        
        this._assignSaveGroupList.set(index, vAssignSaveGroup);
    } //-- void setAssignSaveGroup(int, gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup) 

    /**
     * 
     * 
     * @param vAssignSaveGroupArray
     */
    public void setAssignSaveGroup(gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup[] vAssignSaveGroupArray)
    {
        //-- copy array
        _assignSaveGroupList.clear();
        
        for (int i = 0; i < vAssignSaveGroupArray.length; i++) {
                this._assignSaveGroupList.add(vAssignSaveGroupArray[i]);
        }
    } //-- void setAssignSaveGroup(gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup) 

    /**
     * Sets the value of '_assignSaveGroupList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vAssignSaveGroupList the Vector to copy.
     */
    public void setAssignSaveGroup(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup> vAssignSaveGroupList)
    {
        // copy vector
        this._assignSaveGroupList.clear();
        
        this._assignSaveGroupList.addAll(vAssignSaveGroupList);
    } //-- void setAssignSaveGroup(java.util.List) 

    /**
     * Sets the value of '_assignSaveGroupList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param AssignSaveGroupVector the Vector to set.
     */
    public void setAssignSaveGroupAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup> AssignSaveGroupVector)
    {
        this._assignSaveGroupList = AssignSaveGroupVector;
    } //-- void setAssignSaveGroupAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup_ARRAY unmarshal(java.io.Reader) 

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
