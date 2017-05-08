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
 * Class CINV05SIG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV05SIG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CINV05SIGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG> _CINV05SIGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV05SIG_ARRAY() 
     {
        super();
        this._CINV05SIGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCINV05SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV05SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG vCINV05SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV05SIGList.size() >= 25) {
            throw new IndexOutOfBoundsException("addCINV05SIG has a maximum of 25");
        }
        
        this._CINV05SIGList.add(vCINV05SIG);
    } //-- void addCINV05SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG) 

    /**
     * 
     * 
     * @param index
     * @param vCINV05SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV05SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG vCINV05SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV05SIGList.size() >= 25) {
            throw new IndexOutOfBoundsException("addCINV05SIG has a maximum of 25");
        }
        
        this._CINV05SIGList.add(index, vCINV05SIG);
    } //-- void addCINV05SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCINV05SIG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG> enumerateCINV05SIG()
    {
        return java.util.Collections.enumeration(this._CINV05SIGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG> enumerateCINV05SIG() 

    /**
     * Method getCINV05SIG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG getCINV05SIG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV05SIGList.size()) {
            throw new IndexOutOfBoundsException("getCINV05SIG: Index value '" + index + "' not in range [0.." + (this._CINV05SIGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG) _CINV05SIGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG getCINV05SIG(int) 

    /**
     * Method getCINV05SIG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG[] getCINV05SIG()
    {
        int size = this._CINV05SIGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG) _CINV05SIGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG[] getCINV05SIG() 

    /**
     * Method getCINV05SIGAsReference
     * 
     * Returns a reference to '_CINV05SIGList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG> getCINV05SIGAsReference()
    {
        return this._CINV05SIGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG> getCINV05SIGAsReference() 

    /**
     * Method getCINV05SIGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCINV05SIGCount()
    {
        return this._CINV05SIGList.size();
    } //-- int getCINV05SIGCount() 

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
     * Method iterateCINV05SIG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG> iterateCINV05SIG()
    {
        return this._CINV05SIGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG> iterateCINV05SIG() 

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
    public void removeAllCINV05SIG()
    {
        this._CINV05SIGList.clear();
    } //-- void removeAllCINV05SIG() 

    /**
     * Method removeCINV05SIG
     * 
     * 
     * 
     * @param vCINV05SIG
     * @return true if the object was removed from the collection.
     */
    public boolean removeCINV05SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG vCINV05SIG)
    {
        boolean removed = _CINV05SIGList.remove(vCINV05SIG);
        return removed;
    } //-- boolean removeCINV05SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG) 

    /**
     * Method removeCINV05SIGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG removeCINV05SIGAt(int index)
    {
        Object obj = this._CINV05SIGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG removeCINV05SIGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vCINV05SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCINV05SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG vCINV05SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV05SIGList.size()) {
            throw new IndexOutOfBoundsException("setCINV05SIG: Index value '" + index + "' not in range [0.." + (this._CINV05SIGList.size() - 1) + "]");
        }
        
        this._CINV05SIGList.set(index, vCINV05SIG);
    } //-- void setCINV05SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG) 

    /**
     * 
     * 
     * @param vCINV05SIGArray
     */
    public void setCINV05SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG[] vCINV05SIGArray)
    {
        //-- copy array
        _CINV05SIGList.clear();
        
        for (int i = 0; i < vCINV05SIGArray.length; i++) {
                this._CINV05SIGList.add(vCINV05SIGArray[i]);
        }
    } //-- void setCINV05SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG) 

    /**
     * Sets the value of '_CINV05SIGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vCINV05SIGList the Vector to copy.
     */
    public void setCINV05SIG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG> vCINV05SIGList)
    {
        // copy vector
        this._CINV05SIGList.clear();
        
        this._CINV05SIGList.addAll(vCINV05SIGList);
    } //-- void setCINV05SIG(java.util.List) 

    /**
     * Sets the value of '_CINV05SIGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param CINV05SIGVector the Vector to set.
     */
    public void setCINV05SIGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG> CINV05SIGVector)
    {
        this._CINV05SIGList = CINV05SIGVector;
    } //-- void setCINV05SIGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG_ARRAY unmarshal(java.io.Reader) 

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
