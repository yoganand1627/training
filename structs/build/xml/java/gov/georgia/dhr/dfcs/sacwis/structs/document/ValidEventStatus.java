/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.5</a>, using an XML
 * Schema.
 * $Id$
 */

package gov.georgia.dhr.dfcs.sacwis.structs.document;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class ValidEventStatus.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ValidEventStatus implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _validStatusList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType> _validStatusList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ValidEventStatus() 
     {
        super();
        this._validStatusList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.ValidEventStatus()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vValidStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addValidStatus(gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType vValidStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        this._validStatusList.add(vValidStatus);
    } //-- void addValidStatus(gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType) 

    /**
     * 
     * 
     * @param index
     * @param vValidStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addValidStatus(int index, gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType vValidStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        this._validStatusList.add(index, vValidStatus);
    } //-- void addValidStatus(int, gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType) 

    /**
     * Method enumerateValidStatus
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType> enumerateValidStatus()
    {
        return java.util.Collections.enumeration(this._validStatusList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType> enumerateValidStatus() 

    /**
     * Method getValidStatus
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType getValidStatus(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._validStatusList.size()) {
            throw new IndexOutOfBoundsException("getValidStatus: Index value '" + index + "' not in range [0.." + (this._validStatusList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType) _validStatusList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType getValidStatus(int) 

    /**
     * Method getValidStatus
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType[] getValidStatus()
    {
        int size = this._validStatusList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType[] array = new gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType) _validStatusList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType[] getValidStatus() 

    /**
     * Method getValidStatusAsReference
     * 
     * Returns a reference to '_validStatusList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType> getValidStatusAsReference()
    {
        return this._validStatusList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType> getValidStatusAsReference() 

    /**
     * Method getValidStatusCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getValidStatusCount()
    {
        return this._validStatusList.size();
    } //-- int getValidStatusCount() 

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
     * Method iterateValidStatus
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType> iterateValidStatus()
    {
        return this._validStatusList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType> iterateValidStatus() 

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
    public void removeAllValidStatus()
    {
        this._validStatusList.clear();
    } //-- void removeAllValidStatus() 

    /**
     * Method removeValidStatus
     * 
     * 
     * 
     * @param vValidStatus
     * @return true if the object was removed from the collection.
     */
    public boolean removeValidStatus(gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType vValidStatus)
    {
        boolean removed = _validStatusList.remove(vValidStatus);
        return removed;
    } //-- boolean removeValidStatus(gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType) 

    /**
     * Method removeValidStatusAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType removeValidStatusAt(int index)
    {
        Object obj = this._validStatusList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType removeValidStatusAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vValidStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setValidStatus(int index, gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType vValidStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._validStatusList.size()) {
            throw new IndexOutOfBoundsException("setValidStatus: Index value '" + index + "' not in range [0.." + (this._validStatusList.size() - 1) + "]");
        }
        
        this._validStatusList.set(index, vValidStatus);
    } //-- void setValidStatus(int, gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType) 

    /**
     * 
     * 
     * @param vValidStatusArray
     */
    public void setValidStatus(gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType[] vValidStatusArray)
    {
        //-- copy array
        _validStatusList.clear();
        
        for (int i = 0; i < vValidStatusArray.length; i++) {
                this._validStatusList.add(vValidStatusArray[i]);
        }
    } //-- void setValidStatus(gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType) 

    /**
     * Sets the value of '_validStatusList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vValidStatusList the Vector to copy.
     */
    public void setValidStatus(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType> vValidStatusList)
    {
        // copy vector
        this._validStatusList.clear();
        
        this._validStatusList.addAll(vValidStatusList);
    } //-- void setValidStatus(java.util.List) 

    /**
     * Sets the value of '_validStatusList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ValidStatusVector the Vector to set.
     */
    public void setValidStatusAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType> ValidStatusVector)
    {
        this._validStatusList = ValidStatusVector;
    } //-- void setValidStatusAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.document.ValidEventStatus
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.document.ValidEventStatus unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.ValidEventStatus) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.document.ValidEventStatus.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.ValidEventStatus unmarshal(java.io.Reader) 

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
