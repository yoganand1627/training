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
 * Class SzCdStagePersRole_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdStagePersRole_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdStagePersRoleList
     */
    private java.util.List<java.lang.String> _szCdStagePersRoleList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdStagePersRole_ARRAY() 
     {
        super();
        this._szCdStagePersRoleList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStagePersRole_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdStagePersRole
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdStagePersRole(java.lang.String vSzCdStagePersRole)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdStagePersRoleList.size() >= 200) {
            throw new IndexOutOfBoundsException("addSzCdStagePersRole has a maximum of 200");
        }
        
        this._szCdStagePersRoleList.add(vSzCdStagePersRole);
    } //-- void addSzCdStagePersRole(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdStagePersRole
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdStagePersRole(int index, java.lang.String vSzCdStagePersRole)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdStagePersRoleList.size() >= 200) {
            throw new IndexOutOfBoundsException("addSzCdStagePersRole has a maximum of 200");
        }
        
        this._szCdStagePersRoleList.add(index, vSzCdStagePersRole);
    } //-- void addSzCdStagePersRole(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdStagePersRole
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdStagePersRole()
    {
        return java.util.Collections.enumeration(this._szCdStagePersRoleList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdStagePersRole() 

    /**
     * Method getSzCdStagePersRole
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdStagePersRole(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdStagePersRoleList.size()) {
            throw new IndexOutOfBoundsException("getSzCdStagePersRole: Index value '" + index + "' not in range [0.." + (this._szCdStagePersRoleList.size() - 1) + "]");
        }
        
        return (String)_szCdStagePersRoleList.get(index);
    } //-- java.lang.String getSzCdStagePersRole(int) 

    /**
     * Method getSzCdStagePersRole
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdStagePersRole()
    {
        int size = this._szCdStagePersRoleList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdStagePersRoleList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdStagePersRole() 

    /**
     * Method getSzCdStagePersRoleAsReference
     * 
     * Returns a reference to '_szCdStagePersRoleList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdStagePersRoleAsReference()
    {
        return this._szCdStagePersRoleList;
    } //-- java.util.List<java.lang.String> getSzCdStagePersRoleAsReference() 

    /**
     * Method getSzCdStagePersRoleCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdStagePersRoleCount()
    {
        return this._szCdStagePersRoleList.size();
    } //-- int getSzCdStagePersRoleCount() 

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
     * Method iterateSzCdStagePersRole
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdStagePersRole()
    {
        return this._szCdStagePersRoleList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdStagePersRole() 

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
    public void removeAllSzCdStagePersRole()
    {
        this._szCdStagePersRoleList.clear();
    } //-- void removeAllSzCdStagePersRole() 

    /**
     * Method removeSzCdStagePersRole
     * 
     * 
     * 
     * @param vSzCdStagePersRole
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdStagePersRole(java.lang.String vSzCdStagePersRole)
    {
        boolean removed = _szCdStagePersRoleList.remove(vSzCdStagePersRole);
        return removed;
    } //-- boolean removeSzCdStagePersRole(java.lang.String) 

    /**
     * Method removeSzCdStagePersRoleAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdStagePersRoleAt(int index)
    {
        Object obj = this._szCdStagePersRoleList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdStagePersRoleAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdStagePersRole
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdStagePersRole(int index, java.lang.String vSzCdStagePersRole)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdStagePersRoleList.size()) {
            throw new IndexOutOfBoundsException("setSzCdStagePersRole: Index value '" + index + "' not in range [0.." + (this._szCdStagePersRoleList.size() - 1) + "]");
        }
        
        this._szCdStagePersRoleList.set(index, vSzCdStagePersRole);
    } //-- void setSzCdStagePersRole(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdStagePersRoleArray
     */
    public void setSzCdStagePersRole(java.lang.String[] vSzCdStagePersRoleArray)
    {
        //-- copy array
        _szCdStagePersRoleList.clear();
        
        for (int i = 0; i < vSzCdStagePersRoleArray.length; i++) {
                this._szCdStagePersRoleList.add(vSzCdStagePersRoleArray[i]);
        }
    } //-- void setSzCdStagePersRole(java.lang.String) 

    /**
     * Sets the value of '_szCdStagePersRoleList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdStagePersRoleList the Vector to copy.
     */
    public void setSzCdStagePersRole(java.util.List<java.lang.String> vSzCdStagePersRoleList)
    {
        // copy vector
        this._szCdStagePersRoleList.clear();
        
        this._szCdStagePersRoleList.addAll(vSzCdStagePersRoleList);
    } //-- void setSzCdStagePersRole(java.util.List) 

    /**
     * Sets the value of '_szCdStagePersRoleList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param SzCdStagePersRoleVector the Vector to set.
     */
    public void setSzCdStagePersRoleAsReference(java.util.Vector<java.lang.String> SzCdStagePersRoleVector)
    {
        this._szCdStagePersRoleList = SzCdStagePersRoleVector;
    } //-- void setSzCdStagePersRoleAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStagePersRole_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStagePersRole_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStagePersRole_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStagePersRole_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStagePersRole_ARRAY unmarshal(java.io.Reader) 

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
