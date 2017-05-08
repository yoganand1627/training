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
 * Class CINT14WLB_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINT14WLB_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CINT14WLBList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB> _CINT14WLBList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINT14WLB_ARRAY() 
     {
        super();
        this._CINT14WLBList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCINT14WLB
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINT14WLB(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB vCINT14WLB)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINT14WLBList.size() >= 65) {
            throw new IndexOutOfBoundsException("addCINT14WLB has a maximum of 65");
        }
        
        this._CINT14WLBList.add(vCINT14WLB);
    } //-- void addCINT14WLB(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB) 

    /**
     * 
     * 
     * @param index
     * @param vCINT14WLB
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINT14WLB(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB vCINT14WLB)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINT14WLBList.size() >= 65) {
            throw new IndexOutOfBoundsException("addCINT14WLB has a maximum of 65");
        }
        
        this._CINT14WLBList.add(index, vCINT14WLB);
    } //-- void addCINT14WLB(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCINT14WLB
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB> enumerateCINT14WLB()
    {
        return java.util.Collections.enumeration(this._CINT14WLBList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB> enumerateCINT14WLB() 

    /**
     * Method getCINT14WLB
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB getCINT14WLB(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINT14WLBList.size()) {
            throw new IndexOutOfBoundsException("getCINT14WLB: Index value '" + index + "' not in range [0.." + (this._CINT14WLBList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB) _CINT14WLBList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB getCINT14WLB(int) 

    /**
     * Method getCINT14WLB
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB[] getCINT14WLB()
    {
        int size = this._CINT14WLBList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB) _CINT14WLBList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB[] getCINT14WLB() 

    /**
     * Method getCINT14WLBAsReference
     * 
     * Returns a reference to '_CINT14WLBList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB> getCINT14WLBAsReference()
    {
        return this._CINT14WLBList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB> getCINT14WLBAsReference() 

    /**
     * Method getCINT14WLBCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCINT14WLBCount()
    {
        return this._CINT14WLBList.size();
    } //-- int getCINT14WLBCount() 

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
     * Method iterateCINT14WLB
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB> iterateCINT14WLB()
    {
        return this._CINT14WLBList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB> iterateCINT14WLB() 

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
    public void removeAllCINT14WLB()
    {
        this._CINT14WLBList.clear();
    } //-- void removeAllCINT14WLB() 

    /**
     * Method removeCINT14WLB
     * 
     * 
     * 
     * @param vCINT14WLB
     * @return true if the object was removed from the collection.
     */
    public boolean removeCINT14WLB(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB vCINT14WLB)
    {
        boolean removed = _CINT14WLBList.remove(vCINT14WLB);
        return removed;
    } //-- boolean removeCINT14WLB(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB) 

    /**
     * Method removeCINT14WLBAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB removeCINT14WLBAt(int index)
    {
        Object obj = this._CINT14WLBList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB removeCINT14WLBAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vCINT14WLB
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCINT14WLB(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB vCINT14WLB)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINT14WLBList.size()) {
            throw new IndexOutOfBoundsException("setCINT14WLB: Index value '" + index + "' not in range [0.." + (this._CINT14WLBList.size() - 1) + "]");
        }
        
        this._CINT14WLBList.set(index, vCINT14WLB);
    } //-- void setCINT14WLB(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB) 

    /**
     * 
     * 
     * @param vCINT14WLBArray
     */
    public void setCINT14WLB(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB[] vCINT14WLBArray)
    {
        //-- copy array
        _CINT14WLBList.clear();
        
        for (int i = 0; i < vCINT14WLBArray.length; i++) {
                this._CINT14WLBList.add(vCINT14WLBArray[i]);
        }
    } //-- void setCINT14WLB(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB) 

    /**
     * Sets the value of '_CINT14WLBList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vCINT14WLBList the Vector to copy.
     */
    public void setCINT14WLB(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB> vCINT14WLBList)
    {
        // copy vector
        this._CINT14WLBList.clear();
        
        this._CINT14WLBList.addAll(vCINT14WLBList);
    } //-- void setCINT14WLB(java.util.List) 

    /**
     * Sets the value of '_CINT14WLBList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param CINT14WLBVector the Vector to set.
     */
    public void setCINT14WLBAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB> CINT14WLBVector)
    {
        this._CINT14WLBList = CINT14WLBVector;
    } //-- void setCINT14WLBAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY unmarshal(java.io.Reader) 

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
