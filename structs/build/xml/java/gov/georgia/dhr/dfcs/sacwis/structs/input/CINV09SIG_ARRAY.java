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
 * Class CINV09SIG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV09SIG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CINV09SIGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG> _CINV09SIGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV09SIG_ARRAY() 
     {
        super();
        this._CINV09SIGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCINV09SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV09SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG vCINV09SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV09SIGList.size() >= 50) {
            throw new IndexOutOfBoundsException("addCINV09SIG has a maximum of 50");
        }
        
        this._CINV09SIGList.add(vCINV09SIG);
    } //-- void addCINV09SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG) 

    /**
     * 
     * 
     * @param index
     * @param vCINV09SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV09SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG vCINV09SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV09SIGList.size() >= 50) {
            throw new IndexOutOfBoundsException("addCINV09SIG has a maximum of 50");
        }
        
        this._CINV09SIGList.add(index, vCINV09SIG);
    } //-- void addCINV09SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCINV09SIG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG> enumerateCINV09SIG()
    {
        return java.util.Collections.enumeration(this._CINV09SIGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG> enumerateCINV09SIG() 

    /**
     * Method getCINV09SIG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG getCINV09SIG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV09SIGList.size()) {
            throw new IndexOutOfBoundsException("getCINV09SIG: Index value '" + index + "' not in range [0.." + (this._CINV09SIGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG) _CINV09SIGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG getCINV09SIG(int) 

    /**
     * Method getCINV09SIG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG[] getCINV09SIG()
    {
        int size = this._CINV09SIGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG) _CINV09SIGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG[] getCINV09SIG() 

    /**
     * Method getCINV09SIGAsReference
     * 
     * Returns a reference to '_CINV09SIGList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG> getCINV09SIGAsReference()
    {
        return this._CINV09SIGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG> getCINV09SIGAsReference() 

    /**
     * Method getCINV09SIGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCINV09SIGCount()
    {
        return this._CINV09SIGList.size();
    } //-- int getCINV09SIGCount() 

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
     * Method iterateCINV09SIG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG> iterateCINV09SIG()
    {
        return this._CINV09SIGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG> iterateCINV09SIG() 

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
    public void removeAllCINV09SIG()
    {
        this._CINV09SIGList.clear();
    } //-- void removeAllCINV09SIG() 

    /**
     * Method removeCINV09SIG
     * 
     * 
     * 
     * @param vCINV09SIG
     * @return true if the object was removed from the collection.
     */
    public boolean removeCINV09SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG vCINV09SIG)
    {
        boolean removed = _CINV09SIGList.remove(vCINV09SIG);
        return removed;
    } //-- boolean removeCINV09SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG) 

    /**
     * Method removeCINV09SIGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG removeCINV09SIGAt(int index)
    {
        Object obj = this._CINV09SIGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG removeCINV09SIGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vCINV09SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCINV09SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG vCINV09SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV09SIGList.size()) {
            throw new IndexOutOfBoundsException("setCINV09SIG: Index value '" + index + "' not in range [0.." + (this._CINV09SIGList.size() - 1) + "]");
        }
        
        this._CINV09SIGList.set(index, vCINV09SIG);
    } //-- void setCINV09SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG) 

    /**
     * 
     * 
     * @param vCINV09SIGArray
     */
    public void setCINV09SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG[] vCINV09SIGArray)
    {
        //-- copy array
        _CINV09SIGList.clear();
        
        for (int i = 0; i < vCINV09SIGArray.length; i++) {
                this._CINV09SIGList.add(vCINV09SIGArray[i]);
        }
    } //-- void setCINV09SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG) 

    /**
     * Sets the value of '_CINV09SIGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vCINV09SIGList the Vector to copy.
     */
    public void setCINV09SIG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG> vCINV09SIGList)
    {
        // copy vector
        this._CINV09SIGList.clear();
        
        this._CINV09SIGList.addAll(vCINV09SIGList);
    } //-- void setCINV09SIG(java.util.List) 

    /**
     * Sets the value of '_CINV09SIGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param CINV09SIGVector the Vector to set.
     */
    public void setCINV09SIGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG> CINV09SIGVector)
    {
        this._CINV09SIGList = CINV09SIGVector;
    } //-- void setCINV09SIGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG_ARRAY unmarshal(java.io.Reader) 

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
