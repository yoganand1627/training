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
 * Class STFFASSGNMTHIST_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class STFFASSGNMTHIST_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _STFFASSGNMTHISTList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST> _STFFASSGNMTHISTList;


      //----------------/
     //- Constructors -/
    //----------------/

    public STFFASSGNMTHIST_ARRAY() 
     {
        super();
        this._STFFASSGNMTHISTList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSTFFASSGNMTHIST
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSTFFASSGNMTHIST(gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST vSTFFASSGNMTHIST)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._STFFASSGNMTHISTList.size() >= 50) {
            throw new IndexOutOfBoundsException("addSTFFASSGNMTHIST has a maximum of 50");
        }
        
        this._STFFASSGNMTHISTList.add(vSTFFASSGNMTHIST);
    } //-- void addSTFFASSGNMTHIST(gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST) 

    /**
     * 
     * 
     * @param index
     * @param vSTFFASSGNMTHIST
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSTFFASSGNMTHIST(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST vSTFFASSGNMTHIST)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._STFFASSGNMTHISTList.size() >= 50) {
            throw new IndexOutOfBoundsException("addSTFFASSGNMTHIST has a maximum of 50");
        }
        
        this._STFFASSGNMTHISTList.add(index, vSTFFASSGNMTHIST);
    } //-- void addSTFFASSGNMTHIST(int, gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSTFFASSGNMTHIST
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST> enumerateSTFFASSGNMTHIST()
    {
        return java.util.Collections.enumeration(this._STFFASSGNMTHISTList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST> enumerateSTFFASSGNMTHIST() 

    /**
     * Method getSTFFASSGNMTHIST
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST getSTFFASSGNMTHIST(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._STFFASSGNMTHISTList.size()) {
            throw new IndexOutOfBoundsException("getSTFFASSGNMTHIST: Index value '" + index + "' not in range [0.." + (this._STFFASSGNMTHISTList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST) _STFFASSGNMTHISTList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST getSTFFASSGNMTHIST(int) 

    /**
     * Method getSTFFASSGNMTHIST
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST[] getSTFFASSGNMTHIST()
    {
        int size = this._STFFASSGNMTHISTList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST) _STFFASSGNMTHISTList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST[] getSTFFASSGNMTHIST() 

    /**
     * Method getSTFFASSGNMTHISTAsReference
     * 
     * Returns a reference to '_STFFASSGNMTHISTList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST> getSTFFASSGNMTHISTAsReference()
    {
        return this._STFFASSGNMTHISTList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST> getSTFFASSGNMTHISTAsReference() 

    /**
     * Method getSTFFASSGNMTHISTCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSTFFASSGNMTHISTCount()
    {
        return this._STFFASSGNMTHISTList.size();
    } //-- int getSTFFASSGNMTHISTCount() 

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
     * Method iterateSTFFASSGNMTHIST
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST> iterateSTFFASSGNMTHIST()
    {
        return this._STFFASSGNMTHISTList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST> iterateSTFFASSGNMTHIST() 

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
    public void removeAllSTFFASSGNMTHIST()
    {
        this._STFFASSGNMTHISTList.clear();
    } //-- void removeAllSTFFASSGNMTHIST() 

    /**
     * Method removeSTFFASSGNMTHIST
     * 
     * 
     * 
     * @param vSTFFASSGNMTHIST
     * @return true if the object was removed from the collection.
     */
    public boolean removeSTFFASSGNMTHIST(gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST vSTFFASSGNMTHIST)
    {
        boolean removed = _STFFASSGNMTHISTList.remove(vSTFFASSGNMTHIST);
        return removed;
    } //-- boolean removeSTFFASSGNMTHIST(gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST) 

    /**
     * Method removeSTFFASSGNMTHISTAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST removeSTFFASSGNMTHISTAt(int index)
    {
        Object obj = this._STFFASSGNMTHISTList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST removeSTFFASSGNMTHISTAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSTFFASSGNMTHIST
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSTFFASSGNMTHIST(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST vSTFFASSGNMTHIST)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._STFFASSGNMTHISTList.size()) {
            throw new IndexOutOfBoundsException("setSTFFASSGNMTHIST: Index value '" + index + "' not in range [0.." + (this._STFFASSGNMTHISTList.size() - 1) + "]");
        }
        
        this._STFFASSGNMTHISTList.set(index, vSTFFASSGNMTHIST);
    } //-- void setSTFFASSGNMTHIST(int, gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST) 

    /**
     * 
     * 
     * @param vSTFFASSGNMTHISTArray
     */
    public void setSTFFASSGNMTHIST(gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST[] vSTFFASSGNMTHISTArray)
    {
        //-- copy array
        _STFFASSGNMTHISTList.clear();
        
        for (int i = 0; i < vSTFFASSGNMTHISTArray.length; i++) {
                this._STFFASSGNMTHISTList.add(vSTFFASSGNMTHISTArray[i]);
        }
    } //-- void setSTFFASSGNMTHIST(gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST) 

    /**
     * Sets the value of '_STFFASSGNMTHISTList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vSTFFASSGNMTHISTList the Vector to copy.
     */
    public void setSTFFASSGNMTHIST(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST> vSTFFASSGNMTHISTList)
    {
        // copy vector
        this._STFFASSGNMTHISTList.clear();
        
        this._STFFASSGNMTHISTList.addAll(vSTFFASSGNMTHISTList);
    } //-- void setSTFFASSGNMTHIST(java.util.List) 

    /**
     * Sets the value of '_STFFASSGNMTHISTList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param STFFASSGNMTHISTVector the Vector to set.
     */
    public void setSTFFASSGNMTHISTAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST> STFFASSGNMTHISTVector)
    {
        this._STFFASSGNMTHISTList = STFFASSGNMTHISTVector;
    } //-- void setSTFFASSGNMTHISTAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST_ARRAY unmarshal(java.io.Reader) 

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
