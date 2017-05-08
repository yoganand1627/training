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
 * Class CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY> _CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY() 
     {
        super();
        this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCINV04SO_ADD_PERSON_TO_STAGES_HISTORY
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV04SO_ADD_PERSON_TO_STAGES_HISTORY(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY vCINV04SO_ADD_PERSON_TO_STAGES_HISTORY)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.size() >= 50) {
            throw new IndexOutOfBoundsException("addCINV04SO_ADD_PERSON_TO_STAGES_HISTORY has a maximum of 50");
        }
        
        this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.add(vCINV04SO_ADD_PERSON_TO_STAGES_HISTORY);
    } //-- void addCINV04SO_ADD_PERSON_TO_STAGES_HISTORY(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY) 

    /**
     * 
     * 
     * @param index
     * @param vCINV04SO_ADD_PERSON_TO_STAGES_HISTORY
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV04SO_ADD_PERSON_TO_STAGES_HISTORY(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY vCINV04SO_ADD_PERSON_TO_STAGES_HISTORY)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.size() >= 50) {
            throw new IndexOutOfBoundsException("addCINV04SO_ADD_PERSON_TO_STAGES_HISTORY has a maximum of 50");
        }
        
        this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.add(index, vCINV04SO_ADD_PERSON_TO_STAGES_HISTORY);
    } //-- void addCINV04SO_ADD_PERSON_TO_STAGES_HISTORY(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCINV04SO_ADD_PERSON_TO_STAGES_HISTORY
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY> enumerateCINV04SO_ADD_PERSON_TO_STAGES_HISTORY()
    {
        return java.util.Collections.enumeration(this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY> enumerateCINV04SO_ADD_PERSON_TO_STAGES_HISTORY() 

    /**
     * Method getCINV04SO_ADD_PERSON_TO_STAGES_HISTORY
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY getCINV04SO_ADD_PERSON_TO_STAGES_HISTORY(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.size()) {
            throw new IndexOutOfBoundsException("getCINV04SO_ADD_PERSON_TO_STAGES_HISTORY: Index value '" + index + "' not in range [0.." + (this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY) _CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY getCINV04SO_ADD_PERSON_TO_STAGES_HISTORY(int) 

    /**
     * Method getCINV04SO_ADD_PERSON_TO_STAGES_HISTORY
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY[] getCINV04SO_ADD_PERSON_TO_STAGES_HISTORY()
    {
        int size = this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY) _CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY[] getCINV04SO_ADD_PERSON_TO_STAGES_HISTORY() 

    /**
     * Method getCINV04SO_ADD_PERSON_TO_STAGES_HISTORYAsReference
     * 
     * Returns a reference to
     * '_CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY> getCINV04SO_ADD_PERSON_TO_STAGES_HISTORYAsReference()
    {
        return this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY> getCINV04SO_ADD_PERSON_TO_STAGES_HISTORYAsReference() 

    /**
     * Method getCINV04SO_ADD_PERSON_TO_STAGES_HISTORYCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCINV04SO_ADD_PERSON_TO_STAGES_HISTORYCount()
    {
        return this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.size();
    } //-- int getCINV04SO_ADD_PERSON_TO_STAGES_HISTORYCount() 

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
     * Method iterateCINV04SO_ADD_PERSON_TO_STAGES_HISTORY
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY> iterateCINV04SO_ADD_PERSON_TO_STAGES_HISTORY()
    {
        return this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY> iterateCINV04SO_ADD_PERSON_TO_STAGES_HISTORY() 

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
    public void removeAllCINV04SO_ADD_PERSON_TO_STAGES_HISTORY()
    {
        this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.clear();
    } //-- void removeAllCINV04SO_ADD_PERSON_TO_STAGES_HISTORY() 

    /**
     * Method removeCINV04SO_ADD_PERSON_TO_STAGES_HISTORY
     * 
     * 
     * 
     * @param vCINV04SO_ADD_PERSON_TO_STAGES_HISTORY
     * @return true if the object was removed from the collection.
     */
    public boolean removeCINV04SO_ADD_PERSON_TO_STAGES_HISTORY(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY vCINV04SO_ADD_PERSON_TO_STAGES_HISTORY)
    {
        boolean removed = _CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.remove(vCINV04SO_ADD_PERSON_TO_STAGES_HISTORY);
        return removed;
    } //-- boolean removeCINV04SO_ADD_PERSON_TO_STAGES_HISTORY(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY) 

    /**
     * Method removeCINV04SO_ADD_PERSON_TO_STAGES_HISTORYAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY removeCINV04SO_ADD_PERSON_TO_STAGES_HISTORYAt(int index)
    {
        Object obj = this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY removeCINV04SO_ADD_PERSON_TO_STAGES_HISTORYAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vCINV04SO_ADD_PERSON_TO_STAGES_HISTORY
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCINV04SO_ADD_PERSON_TO_STAGES_HISTORY(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY vCINV04SO_ADD_PERSON_TO_STAGES_HISTORY)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.size()) {
            throw new IndexOutOfBoundsException("setCINV04SO_ADD_PERSON_TO_STAGES_HISTORY: Index value '" + index + "' not in range [0.." + (this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.size() - 1) + "]");
        }
        
        this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.set(index, vCINV04SO_ADD_PERSON_TO_STAGES_HISTORY);
    } //-- void setCINV04SO_ADD_PERSON_TO_STAGES_HISTORY(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY) 

    /**
     * 
     * 
     * @param vCINV04SO_ADD_PERSON_TO_STAGES_HISTORYArray
     */
    public void setCINV04SO_ADD_PERSON_TO_STAGES_HISTORY(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY[] vCINV04SO_ADD_PERSON_TO_STAGES_HISTORYArray)
    {
        //-- copy array
        _CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.clear();
        
        for (int i = 0; i < vCINV04SO_ADD_PERSON_TO_STAGES_HISTORYArray.length; i++) {
                this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.add(vCINV04SO_ADD_PERSON_TO_STAGES_HISTORYArray[i]);
        }
    } //-- void setCINV04SO_ADD_PERSON_TO_STAGES_HISTORY(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY) 

    /**
     * Sets the value of
     * '_CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vCINV04SO_ADD_PERSON_TO_STAGES_HISTORYList the Vector
     * to copy.
     */
    public void setCINV04SO_ADD_PERSON_TO_STAGES_HISTORY(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY> vCINV04SO_ADD_PERSON_TO_STAGES_HISTORYList)
    {
        // copy vector
        this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.clear();
        
        this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList.addAll(vCINV04SO_ADD_PERSON_TO_STAGES_HISTORYList);
    } //-- void setCINV04SO_ADD_PERSON_TO_STAGES_HISTORY(java.util.List) 

    /**
     * Sets the value of
     * '_CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList' by setting it
     * to the given Vector. No type checking is performed.
     * 
     * @param CINV04SO_ADD_PERSON_TO_STAGES_HISTORYVector the
     * Vector to set.
     */
    public void setCINV04SO_ADD_PERSON_TO_STAGES_HISTORYAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY> CINV04SO_ADD_PERSON_TO_STAGES_HISTORYVector)
    {
        this._CINV04SO_ADD_PERSON_TO_STAGES_HISTORYList = CINV04SO_ADD_PERSON_TO_STAGES_HISTORYVector;
    } //-- void setCINV04SO_ADD_PERSON_TO_STAGES_HISTORYAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY unmarshal(java.io.Reader) 

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
