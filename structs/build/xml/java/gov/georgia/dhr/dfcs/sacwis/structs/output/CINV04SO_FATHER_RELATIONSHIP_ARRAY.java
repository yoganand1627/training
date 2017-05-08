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
 * Class CINV04SO_FATHER_RELATIONSHIP_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV04SO_FATHER_RELATIONSHIP_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CINV04SO_FATHER_RELATIONSHIPList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP> _CINV04SO_FATHER_RELATIONSHIPList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV04SO_FATHER_RELATIONSHIP_ARRAY() 
     {
        super();
        this._CINV04SO_FATHER_RELATIONSHIPList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCINV04SO_FATHER_RELATIONSHIP
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV04SO_FATHER_RELATIONSHIP(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP vCINV04SO_FATHER_RELATIONSHIP)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV04SO_FATHER_RELATIONSHIPList.size() >= 50) {
            throw new IndexOutOfBoundsException("addCINV04SO_FATHER_RELATIONSHIP has a maximum of 50");
        }
        
        this._CINV04SO_FATHER_RELATIONSHIPList.add(vCINV04SO_FATHER_RELATIONSHIP);
    } //-- void addCINV04SO_FATHER_RELATIONSHIP(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP) 

    /**
     * 
     * 
     * @param index
     * @param vCINV04SO_FATHER_RELATIONSHIP
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV04SO_FATHER_RELATIONSHIP(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP vCINV04SO_FATHER_RELATIONSHIP)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV04SO_FATHER_RELATIONSHIPList.size() >= 50) {
            throw new IndexOutOfBoundsException("addCINV04SO_FATHER_RELATIONSHIP has a maximum of 50");
        }
        
        this._CINV04SO_FATHER_RELATIONSHIPList.add(index, vCINV04SO_FATHER_RELATIONSHIP);
    } //-- void addCINV04SO_FATHER_RELATIONSHIP(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCINV04SO_FATHER_RELATIONSHIP
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP> enumerateCINV04SO_FATHER_RELATIONSHIP()
    {
        return java.util.Collections.enumeration(this._CINV04SO_FATHER_RELATIONSHIPList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP> enumerateCINV04SO_FATHER_RELATIONSHIP() 

    /**
     * Method getCINV04SO_FATHER_RELATIONSHIP
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP getCINV04SO_FATHER_RELATIONSHIP(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV04SO_FATHER_RELATIONSHIPList.size()) {
            throw new IndexOutOfBoundsException("getCINV04SO_FATHER_RELATIONSHIP: Index value '" + index + "' not in range [0.." + (this._CINV04SO_FATHER_RELATIONSHIPList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP) _CINV04SO_FATHER_RELATIONSHIPList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP getCINV04SO_FATHER_RELATIONSHIP(int) 

    /**
     * Method getCINV04SO_FATHER_RELATIONSHIP
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP[] getCINV04SO_FATHER_RELATIONSHIP()
    {
        int size = this._CINV04SO_FATHER_RELATIONSHIPList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP) _CINV04SO_FATHER_RELATIONSHIPList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP[] getCINV04SO_FATHER_RELATIONSHIP() 

    /**
     * Method getCINV04SO_FATHER_RELATIONSHIPAsReference
     * 
     * Returns a reference to '_CINV04SO_FATHER_RELATIONSHIPList'.
     * No type checking is performed on any modifications to the
     * Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP> getCINV04SO_FATHER_RELATIONSHIPAsReference()
    {
        return this._CINV04SO_FATHER_RELATIONSHIPList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP> getCINV04SO_FATHER_RELATIONSHIPAsReference() 

    /**
     * Method getCINV04SO_FATHER_RELATIONSHIPCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCINV04SO_FATHER_RELATIONSHIPCount()
    {
        return this._CINV04SO_FATHER_RELATIONSHIPList.size();
    } //-- int getCINV04SO_FATHER_RELATIONSHIPCount() 

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
     * Method iterateCINV04SO_FATHER_RELATIONSHIP
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP> iterateCINV04SO_FATHER_RELATIONSHIP()
    {
        return this._CINV04SO_FATHER_RELATIONSHIPList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP> iterateCINV04SO_FATHER_RELATIONSHIP() 

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
    public void removeAllCINV04SO_FATHER_RELATIONSHIP()
    {
        this._CINV04SO_FATHER_RELATIONSHIPList.clear();
    } //-- void removeAllCINV04SO_FATHER_RELATIONSHIP() 

    /**
     * Method removeCINV04SO_FATHER_RELATIONSHIP
     * 
     * 
     * 
     * @param vCINV04SO_FATHER_RELATIONSHIP
     * @return true if the object was removed from the collection.
     */
    public boolean removeCINV04SO_FATHER_RELATIONSHIP(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP vCINV04SO_FATHER_RELATIONSHIP)
    {
        boolean removed = _CINV04SO_FATHER_RELATIONSHIPList.remove(vCINV04SO_FATHER_RELATIONSHIP);
        return removed;
    } //-- boolean removeCINV04SO_FATHER_RELATIONSHIP(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP) 

    /**
     * Method removeCINV04SO_FATHER_RELATIONSHIPAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP removeCINV04SO_FATHER_RELATIONSHIPAt(int index)
    {
        Object obj = this._CINV04SO_FATHER_RELATIONSHIPList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP removeCINV04SO_FATHER_RELATIONSHIPAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vCINV04SO_FATHER_RELATIONSHIP
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCINV04SO_FATHER_RELATIONSHIP(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP vCINV04SO_FATHER_RELATIONSHIP)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV04SO_FATHER_RELATIONSHIPList.size()) {
            throw new IndexOutOfBoundsException("setCINV04SO_FATHER_RELATIONSHIP: Index value '" + index + "' not in range [0.." + (this._CINV04SO_FATHER_RELATIONSHIPList.size() - 1) + "]");
        }
        
        this._CINV04SO_FATHER_RELATIONSHIPList.set(index, vCINV04SO_FATHER_RELATIONSHIP);
    } //-- void setCINV04SO_FATHER_RELATIONSHIP(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP) 

    /**
     * 
     * 
     * @param vCINV04SO_FATHER_RELATIONSHIPArray
     */
    public void setCINV04SO_FATHER_RELATIONSHIP(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP[] vCINV04SO_FATHER_RELATIONSHIPArray)
    {
        //-- copy array
        _CINV04SO_FATHER_RELATIONSHIPList.clear();
        
        for (int i = 0; i < vCINV04SO_FATHER_RELATIONSHIPArray.length; i++) {
                this._CINV04SO_FATHER_RELATIONSHIPList.add(vCINV04SO_FATHER_RELATIONSHIPArray[i]);
        }
    } //-- void setCINV04SO_FATHER_RELATIONSHIP(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP) 

    /**
     * Sets the value of '_CINV04SO_FATHER_RELATIONSHIPList' by
     * copying the given Vector. All elements will be checked for
     * type safety.
     * 
     * @param vCINV04SO_FATHER_RELATIONSHIPList the Vector to copy.
     */
    public void setCINV04SO_FATHER_RELATIONSHIP(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP> vCINV04SO_FATHER_RELATIONSHIPList)
    {
        // copy vector
        this._CINV04SO_FATHER_RELATIONSHIPList.clear();
        
        this._CINV04SO_FATHER_RELATIONSHIPList.addAll(vCINV04SO_FATHER_RELATIONSHIPList);
    } //-- void setCINV04SO_FATHER_RELATIONSHIP(java.util.List) 

    /**
     * Sets the value of '_CINV04SO_FATHER_RELATIONSHIPList' by
     * setting it to the given Vector. No type checking is
     * performed.
     * 
     * @param CINV04SO_FATHER_RELATIONSHIPVector the Vector to set.
     */
    public void setCINV04SO_FATHER_RELATIONSHIPAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP> CINV04SO_FATHER_RELATIONSHIPVector)
    {
        this._CINV04SO_FATHER_RELATIONSHIPList = CINV04SO_FATHER_RELATIONSHIPVector;
    } //-- void setCINV04SO_FATHER_RELATIONSHIPAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP_ARRAY unmarshal(java.io.Reader) 

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
