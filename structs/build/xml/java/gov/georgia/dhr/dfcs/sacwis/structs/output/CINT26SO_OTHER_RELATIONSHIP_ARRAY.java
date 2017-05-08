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
 * Class CINT26SO_OTHER_RELATIONSHIP_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINT26SO_OTHER_RELATIONSHIP_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CINT26SO_OTHER_RELATIONSHIPList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP> _CINT26SO_OTHER_RELATIONSHIPList;

    /**
     * Field _error_message
     */
    private int _error_message;

    /**
     * keeps track of state for field: _error_message
     */
    private boolean _has_error_message;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINT26SO_OTHER_RELATIONSHIP_ARRAY() 
     {
        super();
        this._CINT26SO_OTHER_RELATIONSHIPList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCINT26SO_OTHER_RELATIONSHIP
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINT26SO_OTHER_RELATIONSHIP(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP vCINT26SO_OTHER_RELATIONSHIP)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINT26SO_OTHER_RELATIONSHIPList.size() >= 100) {
            throw new IndexOutOfBoundsException("addCINT26SO_OTHER_RELATIONSHIP has a maximum of 100");
        }
        
        this._CINT26SO_OTHER_RELATIONSHIPList.add(vCINT26SO_OTHER_RELATIONSHIP);
    } //-- void addCINT26SO_OTHER_RELATIONSHIP(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP) 

    /**
     * 
     * 
     * @param index
     * @param vCINT26SO_OTHER_RELATIONSHIP
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINT26SO_OTHER_RELATIONSHIP(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP vCINT26SO_OTHER_RELATIONSHIP)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINT26SO_OTHER_RELATIONSHIPList.size() >= 100) {
            throw new IndexOutOfBoundsException("addCINT26SO_OTHER_RELATIONSHIP has a maximum of 100");
        }
        
        this._CINT26SO_OTHER_RELATIONSHIPList.add(index, vCINT26SO_OTHER_RELATIONSHIP);
    } //-- void addCINT26SO_OTHER_RELATIONSHIP(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP) 

    /**
     */
    public void deleteError_message()
    {
        this._has_error_message= false;
    } //-- void deleteError_message() 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCINT26SO_OTHER_RELATIONSHIP
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP> enumerateCINT26SO_OTHER_RELATIONSHIP()
    {
        return java.util.Collections.enumeration(this._CINT26SO_OTHER_RELATIONSHIPList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP> enumerateCINT26SO_OTHER_RELATIONSHIP() 

    /**
     * Method getCINT26SO_OTHER_RELATIONSHIP
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP getCINT26SO_OTHER_RELATIONSHIP(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINT26SO_OTHER_RELATIONSHIPList.size()) {
            throw new IndexOutOfBoundsException("getCINT26SO_OTHER_RELATIONSHIP: Index value '" + index + "' not in range [0.." + (this._CINT26SO_OTHER_RELATIONSHIPList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP) _CINT26SO_OTHER_RELATIONSHIPList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP getCINT26SO_OTHER_RELATIONSHIP(int) 

    /**
     * Method getCINT26SO_OTHER_RELATIONSHIP
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP[] getCINT26SO_OTHER_RELATIONSHIP()
    {
        int size = this._CINT26SO_OTHER_RELATIONSHIPList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP) _CINT26SO_OTHER_RELATIONSHIPList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP[] getCINT26SO_OTHER_RELATIONSHIP() 

    /**
     * Method getCINT26SO_OTHER_RELATIONSHIPAsReference
     * 
     * Returns a reference to '_CINT26SO_OTHER_RELATIONSHIPList'.
     * No type checking is performed on any modifications to the
     * Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP> getCINT26SO_OTHER_RELATIONSHIPAsReference()
    {
        return this._CINT26SO_OTHER_RELATIONSHIPList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP> getCINT26SO_OTHER_RELATIONSHIPAsReference() 

    /**
     * Method getCINT26SO_OTHER_RELATIONSHIPCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCINT26SO_OTHER_RELATIONSHIPCount()
    {
        return this._CINT26SO_OTHER_RELATIONSHIPList.size();
    } //-- int getCINT26SO_OTHER_RELATIONSHIPCount() 

    /**
     * Returns the value of field 'error_message'.
     * 
     * @return the value of field 'Error_message'.
     */
    public int getError_message()
    {
        return this._error_message;
    } //-- int getError_message() 

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
     * Method hasError_message
     * 
     * 
     * 
     * @return true if at least one Error_message has been added
     */
    public boolean hasError_message()
    {
        return this._has_error_message;
    } //-- boolean hasError_message() 

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
     * Method iterateCINT26SO_OTHER_RELATIONSHIP
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP> iterateCINT26SO_OTHER_RELATIONSHIP()
    {
        return this._CINT26SO_OTHER_RELATIONSHIPList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP> iterateCINT26SO_OTHER_RELATIONSHIP() 

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
    public void removeAllCINT26SO_OTHER_RELATIONSHIP()
    {
        this._CINT26SO_OTHER_RELATIONSHIPList.clear();
    } //-- void removeAllCINT26SO_OTHER_RELATIONSHIP() 

    /**
     * Method removeCINT26SO_OTHER_RELATIONSHIP
     * 
     * 
     * 
     * @param vCINT26SO_OTHER_RELATIONSHIP
     * @return true if the object was removed from the collection.
     */
    public boolean removeCINT26SO_OTHER_RELATIONSHIP(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP vCINT26SO_OTHER_RELATIONSHIP)
    {
        boolean removed = _CINT26SO_OTHER_RELATIONSHIPList.remove(vCINT26SO_OTHER_RELATIONSHIP);
        return removed;
    } //-- boolean removeCINT26SO_OTHER_RELATIONSHIP(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP) 

    /**
     * Method removeCINT26SO_OTHER_RELATIONSHIPAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP removeCINT26SO_OTHER_RELATIONSHIPAt(int index)
    {
        Object obj = this._CINT26SO_OTHER_RELATIONSHIPList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP removeCINT26SO_OTHER_RELATIONSHIPAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vCINT26SO_OTHER_RELATIONSHIP
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCINT26SO_OTHER_RELATIONSHIP(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP vCINT26SO_OTHER_RELATIONSHIP)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINT26SO_OTHER_RELATIONSHIPList.size()) {
            throw new IndexOutOfBoundsException("setCINT26SO_OTHER_RELATIONSHIP: Index value '" + index + "' not in range [0.." + (this._CINT26SO_OTHER_RELATIONSHIPList.size() - 1) + "]");
        }
        
        this._CINT26SO_OTHER_RELATIONSHIPList.set(index, vCINT26SO_OTHER_RELATIONSHIP);
    } //-- void setCINT26SO_OTHER_RELATIONSHIP(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP) 

    /**
     * 
     * 
     * @param vCINT26SO_OTHER_RELATIONSHIPArray
     */
    public void setCINT26SO_OTHER_RELATIONSHIP(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP[] vCINT26SO_OTHER_RELATIONSHIPArray)
    {
        //-- copy array
        _CINT26SO_OTHER_RELATIONSHIPList.clear();
        
        for (int i = 0; i < vCINT26SO_OTHER_RELATIONSHIPArray.length; i++) {
                this._CINT26SO_OTHER_RELATIONSHIPList.add(vCINT26SO_OTHER_RELATIONSHIPArray[i]);
        }
    } //-- void setCINT26SO_OTHER_RELATIONSHIP(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP) 

    /**
     * Sets the value of '_CINT26SO_OTHER_RELATIONSHIPList' by
     * copying the given Vector. All elements will be checked for
     * type safety.
     * 
     * @param vCINT26SO_OTHER_RELATIONSHIPList the Vector to copy.
     */
    public void setCINT26SO_OTHER_RELATIONSHIP(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP> vCINT26SO_OTHER_RELATIONSHIPList)
    {
        // copy vector
        this._CINT26SO_OTHER_RELATIONSHIPList.clear();
        
        this._CINT26SO_OTHER_RELATIONSHIPList.addAll(vCINT26SO_OTHER_RELATIONSHIPList);
    } //-- void setCINT26SO_OTHER_RELATIONSHIP(java.util.List) 

    /**
     * Sets the value of '_CINT26SO_OTHER_RELATIONSHIPList' by
     * setting it to the given Vector. No type checking is
     * performed.
     * 
     * @param CINT26SO_OTHER_RELATIONSHIPVector the Vector to set.
     */
    public void setCINT26SO_OTHER_RELATIONSHIPAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP> CINT26SO_OTHER_RELATIONSHIPVector)
    {
        this._CINT26SO_OTHER_RELATIONSHIPList = CINT26SO_OTHER_RELATIONSHIPVector;
    } //-- void setCINT26SO_OTHER_RELATIONSHIPAsReference(java.util.Vector) 

    /**
     * Sets the value of field 'error_message'.
     * 
     * @param error_message the value of field 'error_message'.
     */
    public void setError_message(int error_message)
    {
        this._error_message = error_message;
        this._has_error_message = true;
    } //-- void setError_message(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP_ARRAY unmarshal(java.io.Reader) 

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
