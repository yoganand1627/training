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
 * Class ROWCINT49DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINT49DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINT49DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO> _ROWCINT49DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINT49DO_ARRAY() 
     {
        super();
        this._ROWCINT49DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINT49DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINT49DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO vROWCINT49DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINT49DOList.size() >= 4) {
            throw new IndexOutOfBoundsException("addROWCINT49DO has a maximum of 4");
        }
        
        this._ROWCINT49DOList.add(vROWCINT49DO);
    } //-- void addROWCINT49DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINT49DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINT49DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO vROWCINT49DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINT49DOList.size() >= 4) {
            throw new IndexOutOfBoundsException("addROWCINT49DO has a maximum of 4");
        }
        
        this._ROWCINT49DOList.add(index, vROWCINT49DO);
    } //-- void addROWCINT49DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINT49DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO> enumerateROWCINT49DO()
    {
        return java.util.Collections.enumeration(this._ROWCINT49DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO> enumerateROWCINT49DO() 

    /**
     * Method getROWCINT49DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO getROWCINT49DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINT49DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCINT49DO: Index value '" + index + "' not in range [0.." + (this._ROWCINT49DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO) _ROWCINT49DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO getROWCINT49DO(int) 

    /**
     * Method getROWCINT49DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO[] getROWCINT49DO()
    {
        int size = this._ROWCINT49DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO) _ROWCINT49DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO[] getROWCINT49DO() 

    /**
     * Method getROWCINT49DOAsReference
     * 
     * Returns a reference to '_ROWCINT49DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO> getROWCINT49DOAsReference()
    {
        return this._ROWCINT49DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO> getROWCINT49DOAsReference() 

    /**
     * Method getROWCINT49DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINT49DOCount()
    {
        return this._ROWCINT49DOList.size();
    } //-- int getROWCINT49DOCount() 

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
     * Method iterateROWCINT49DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO> iterateROWCINT49DO()
    {
        return this._ROWCINT49DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO> iterateROWCINT49DO() 

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
    public void removeAllROWCINT49DO()
    {
        this._ROWCINT49DOList.clear();
    } //-- void removeAllROWCINT49DO() 

    /**
     * Method removeROWCINT49DO
     * 
     * 
     * 
     * @param vROWCINT49DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINT49DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO vROWCINT49DO)
    {
        boolean removed = _ROWCINT49DOList.remove(vROWCINT49DO);
        return removed;
    } //-- boolean removeROWCINT49DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO) 

    /**
     * Method removeROWCINT49DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO removeROWCINT49DOAt(int index)
    {
        Object obj = this._ROWCINT49DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO removeROWCINT49DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINT49DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINT49DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO vROWCINT49DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINT49DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCINT49DO: Index value '" + index + "' not in range [0.." + (this._ROWCINT49DOList.size() - 1) + "]");
        }
        
        this._ROWCINT49DOList.set(index, vROWCINT49DO);
    } //-- void setROWCINT49DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO) 

    /**
     * 
     * 
     * @param vROWCINT49DOArray
     */
    public void setROWCINT49DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO[] vROWCINT49DOArray)
    {
        //-- copy array
        _ROWCINT49DOList.clear();
        
        for (int i = 0; i < vROWCINT49DOArray.length; i++) {
                this._ROWCINT49DOList.add(vROWCINT49DOArray[i]);
        }
    } //-- void setROWCINT49DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO) 

    /**
     * Sets the value of '_ROWCINT49DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINT49DOList the Vector to copy.
     */
    public void setROWCINT49DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO> vROWCINT49DOList)
    {
        // copy vector
        this._ROWCINT49DOList.clear();
        
        this._ROWCINT49DOList.addAll(vROWCINT49DOList);
    } //-- void setROWCINT49DO(java.util.List) 

    /**
     * Sets the value of '_ROWCINT49DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINT49DOVector the Vector to set.
     */
    public void setROWCINT49DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO> ROWCINT49DOVector)
    {
        this._ROWCINT49DOList = ROWCINT49DOVector;
    } //-- void setROWCINT49DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO_ARRAY unmarshal(java.io.Reader) 

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
