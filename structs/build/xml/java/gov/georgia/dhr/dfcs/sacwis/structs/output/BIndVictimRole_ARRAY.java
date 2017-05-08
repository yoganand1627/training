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
 * Class BIndVictimRole_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class BIndVictimRole_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _bIndVictimRoleList
     */
    private java.util.List<java.lang.String> _bIndVictimRoleList;


      //----------------/
     //- Constructors -/
    //----------------/

    public BIndVictimRole_ARRAY() 
     {
        super();
        this._bIndVictimRoleList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.BIndVictimRole_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vBIndVictimRole
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addBIndVictimRole(java.lang.String vBIndVictimRole)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._bIndVictimRoleList.size() >= 50) {
            throw new IndexOutOfBoundsException("addBIndVictimRole has a maximum of 50");
        }
        
        this._bIndVictimRoleList.add(vBIndVictimRole);
    } //-- void addBIndVictimRole(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vBIndVictimRole
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addBIndVictimRole(int index, java.lang.String vBIndVictimRole)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._bIndVictimRoleList.size() >= 50) {
            throw new IndexOutOfBoundsException("addBIndVictimRole has a maximum of 50");
        }
        
        this._bIndVictimRoleList.add(index, vBIndVictimRole);
    } //-- void addBIndVictimRole(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateBIndVictimRole
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateBIndVictimRole()
    {
        return java.util.Collections.enumeration(this._bIndVictimRoleList);
    } //-- java.util.Enumeration<java.lang.String> enumerateBIndVictimRole() 

    /**
     * Method getBIndVictimRole
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getBIndVictimRole(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._bIndVictimRoleList.size()) {
            throw new IndexOutOfBoundsException("getBIndVictimRole: Index value '" + index + "' not in range [0.." + (this._bIndVictimRoleList.size() - 1) + "]");
        }
        
        return (String)_bIndVictimRoleList.get(index);
    } //-- java.lang.String getBIndVictimRole(int) 

    /**
     * Method getBIndVictimRole
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getBIndVictimRole()
    {
        int size = this._bIndVictimRoleList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_bIndVictimRoleList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getBIndVictimRole() 

    /**
     * Method getBIndVictimRoleAsReference
     * 
     * Returns a reference to '_bIndVictimRoleList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getBIndVictimRoleAsReference()
    {
        return this._bIndVictimRoleList;
    } //-- java.util.List<java.lang.String> getBIndVictimRoleAsReference() 

    /**
     * Method getBIndVictimRoleCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getBIndVictimRoleCount()
    {
        return this._bIndVictimRoleList.size();
    } //-- int getBIndVictimRoleCount() 

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
     * Method iterateBIndVictimRole
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateBIndVictimRole()
    {
        return this._bIndVictimRoleList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateBIndVictimRole() 

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
    public void removeAllBIndVictimRole()
    {
        this._bIndVictimRoleList.clear();
    } //-- void removeAllBIndVictimRole() 

    /**
     * Method removeBIndVictimRole
     * 
     * 
     * 
     * @param vBIndVictimRole
     * @return true if the object was removed from the collection.
     */
    public boolean removeBIndVictimRole(java.lang.String vBIndVictimRole)
    {
        boolean removed = _bIndVictimRoleList.remove(vBIndVictimRole);
        return removed;
    } //-- boolean removeBIndVictimRole(java.lang.String) 

    /**
     * Method removeBIndVictimRoleAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeBIndVictimRoleAt(int index)
    {
        Object obj = this._bIndVictimRoleList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeBIndVictimRoleAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vBIndVictimRole
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setBIndVictimRole(int index, java.lang.String vBIndVictimRole)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._bIndVictimRoleList.size()) {
            throw new IndexOutOfBoundsException("setBIndVictimRole: Index value '" + index + "' not in range [0.." + (this._bIndVictimRoleList.size() - 1) + "]");
        }
        
        this._bIndVictimRoleList.set(index, vBIndVictimRole);
    } //-- void setBIndVictimRole(int, java.lang.String) 

    /**
     * 
     * 
     * @param vBIndVictimRoleArray
     */
    public void setBIndVictimRole(java.lang.String[] vBIndVictimRoleArray)
    {
        //-- copy array
        _bIndVictimRoleList.clear();
        
        for (int i = 0; i < vBIndVictimRoleArray.length; i++) {
                this._bIndVictimRoleList.add(vBIndVictimRoleArray[i]);
        }
    } //-- void setBIndVictimRole(java.lang.String) 

    /**
     * Sets the value of '_bIndVictimRoleList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vBIndVictimRoleList the Vector to copy.
     */
    public void setBIndVictimRole(java.util.List<java.lang.String> vBIndVictimRoleList)
    {
        // copy vector
        this._bIndVictimRoleList.clear();
        
        this._bIndVictimRoleList.addAll(vBIndVictimRoleList);
    } //-- void setBIndVictimRole(java.util.List) 

    /**
     * Sets the value of '_bIndVictimRoleList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param BIndVictimRoleVector the Vector to set.
     */
    public void setBIndVictimRoleAsReference(java.util.Vector<java.lang.String> BIndVictimRoleVector)
    {
        this._bIndVictimRoleList = BIndVictimRoleVector;
    } //-- void setBIndVictimRoleAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.BIndVictimRole_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.BIndVictimRole_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.BIndVictimRole_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.BIndVictimRole_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.BIndVictimRole_ARRAY unmarshal(java.io.Reader) 

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
