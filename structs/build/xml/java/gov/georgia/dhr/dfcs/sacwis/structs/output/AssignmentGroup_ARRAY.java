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
 * Class AssignmentGroup_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AssignmentGroup_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _assignmentGroupList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup> _assignmentGroupList;


      //----------------/
     //- Constructors -/
    //----------------/

    public AssignmentGroup_ARRAY() 
     {
        super();
        this._assignmentGroupList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAssignmentGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAssignmentGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup vAssignmentGroup)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._assignmentGroupList.size() >= 100) {
            throw new IndexOutOfBoundsException("addAssignmentGroup has a maximum of 100");
        }
        
        this._assignmentGroupList.add(vAssignmentGroup);
    } //-- void addAssignmentGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup) 

    /**
     * 
     * 
     * @param index
     * @param vAssignmentGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAssignmentGroup(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup vAssignmentGroup)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._assignmentGroupList.size() >= 100) {
            throw new IndexOutOfBoundsException("addAssignmentGroup has a maximum of 100");
        }
        
        this._assignmentGroupList.add(index, vAssignmentGroup);
    } //-- void addAssignmentGroup(int, gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateAssignmentGroup
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup> enumerateAssignmentGroup()
    {
        return java.util.Collections.enumeration(this._assignmentGroupList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup> enumerateAssignmentGroup() 

    /**
     * Method getAssignmentGroup
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup getAssignmentGroup(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._assignmentGroupList.size()) {
            throw new IndexOutOfBoundsException("getAssignmentGroup: Index value '" + index + "' not in range [0.." + (this._assignmentGroupList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup) _assignmentGroupList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup getAssignmentGroup(int) 

    /**
     * Method getAssignmentGroup
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup[] getAssignmentGroup()
    {
        int size = this._assignmentGroupList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup) _assignmentGroupList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup[] getAssignmentGroup() 

    /**
     * Method getAssignmentGroupAsReference
     * 
     * Returns a reference to '_assignmentGroupList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup> getAssignmentGroupAsReference()
    {
        return this._assignmentGroupList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup> getAssignmentGroupAsReference() 

    /**
     * Method getAssignmentGroupCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getAssignmentGroupCount()
    {
        return this._assignmentGroupList.size();
    } //-- int getAssignmentGroupCount() 

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
     * Method iterateAssignmentGroup
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup> iterateAssignmentGroup()
    {
        return this._assignmentGroupList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup> iterateAssignmentGroup() 

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
    public void removeAllAssignmentGroup()
    {
        this._assignmentGroupList.clear();
    } //-- void removeAllAssignmentGroup() 

    /**
     * Method removeAssignmentGroup
     * 
     * 
     * 
     * @param vAssignmentGroup
     * @return true if the object was removed from the collection.
     */
    public boolean removeAssignmentGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup vAssignmentGroup)
    {
        boolean removed = _assignmentGroupList.remove(vAssignmentGroup);
        return removed;
    } //-- boolean removeAssignmentGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup) 

    /**
     * Method removeAssignmentGroupAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup removeAssignmentGroupAt(int index)
    {
        Object obj = this._assignmentGroupList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup removeAssignmentGroupAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vAssignmentGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAssignmentGroup(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup vAssignmentGroup)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._assignmentGroupList.size()) {
            throw new IndexOutOfBoundsException("setAssignmentGroup: Index value '" + index + "' not in range [0.." + (this._assignmentGroupList.size() - 1) + "]");
        }
        
        this._assignmentGroupList.set(index, vAssignmentGroup);
    } //-- void setAssignmentGroup(int, gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup) 

    /**
     * 
     * 
     * @param vAssignmentGroupArray
     */
    public void setAssignmentGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup[] vAssignmentGroupArray)
    {
        //-- copy array
        _assignmentGroupList.clear();
        
        for (int i = 0; i < vAssignmentGroupArray.length; i++) {
                this._assignmentGroupList.add(vAssignmentGroupArray[i]);
        }
    } //-- void setAssignmentGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup) 

    /**
     * Sets the value of '_assignmentGroupList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vAssignmentGroupList the Vector to copy.
     */
    public void setAssignmentGroup(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup> vAssignmentGroupList)
    {
        // copy vector
        this._assignmentGroupList.clear();
        
        this._assignmentGroupList.addAll(vAssignmentGroupList);
    } //-- void setAssignmentGroup(java.util.List) 

    /**
     * Sets the value of '_assignmentGroupList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param AssignmentGroupVector the Vector to set.
     */
    public void setAssignmentGroupAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup> AssignmentGroupVector)
    {
        this._assignmentGroupList = AssignmentGroupVector;
    } //-- void setAssignmentGroupAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY unmarshal(java.io.Reader) 

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
