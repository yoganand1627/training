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
 * Class ROWCINT52DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINT52DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINT52DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO> _ROWCINT52DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINT52DO_ARRAY() 
     {
        super();
        this._ROWCINT52DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINT52DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINT52DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO vROWCINT52DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINT52DOList.size() >= 4) {
            throw new IndexOutOfBoundsException("addROWCINT52DO has a maximum of 4");
        }
        
        this._ROWCINT52DOList.add(vROWCINT52DO);
    } //-- void addROWCINT52DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINT52DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINT52DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO vROWCINT52DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINT52DOList.size() >= 4) {
            throw new IndexOutOfBoundsException("addROWCINT52DO has a maximum of 4");
        }
        
        this._ROWCINT52DOList.add(index, vROWCINT52DO);
    } //-- void addROWCINT52DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINT52DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO> enumerateROWCINT52DO()
    {
        return java.util.Collections.enumeration(this._ROWCINT52DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO> enumerateROWCINT52DO() 

    /**
     * Method getROWCINT52DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO getROWCINT52DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINT52DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCINT52DO: Index value '" + index + "' not in range [0.." + (this._ROWCINT52DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO) _ROWCINT52DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO getROWCINT52DO(int) 

    /**
     * Method getROWCINT52DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO[] getROWCINT52DO()
    {
        int size = this._ROWCINT52DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO) _ROWCINT52DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO[] getROWCINT52DO() 

    /**
     * Method getROWCINT52DOAsReference
     * 
     * Returns a reference to '_ROWCINT52DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO> getROWCINT52DOAsReference()
    {
        return this._ROWCINT52DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO> getROWCINT52DOAsReference() 

    /**
     * Method getROWCINT52DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINT52DOCount()
    {
        return this._ROWCINT52DOList.size();
    } //-- int getROWCINT52DOCount() 

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
     * Method iterateROWCINT52DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO> iterateROWCINT52DO()
    {
        return this._ROWCINT52DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO> iterateROWCINT52DO() 

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
    public void removeAllROWCINT52DO()
    {
        this._ROWCINT52DOList.clear();
    } //-- void removeAllROWCINT52DO() 

    /**
     * Method removeROWCINT52DO
     * 
     * 
     * 
     * @param vROWCINT52DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINT52DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO vROWCINT52DO)
    {
        boolean removed = _ROWCINT52DOList.remove(vROWCINT52DO);
        return removed;
    } //-- boolean removeROWCINT52DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO) 

    /**
     * Method removeROWCINT52DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO removeROWCINT52DOAt(int index)
    {
        Object obj = this._ROWCINT52DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO removeROWCINT52DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINT52DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINT52DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO vROWCINT52DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINT52DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCINT52DO: Index value '" + index + "' not in range [0.." + (this._ROWCINT52DOList.size() - 1) + "]");
        }
        
        this._ROWCINT52DOList.set(index, vROWCINT52DO);
    } //-- void setROWCINT52DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO) 

    /**
     * 
     * 
     * @param vROWCINT52DOArray
     */
    public void setROWCINT52DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO[] vROWCINT52DOArray)
    {
        //-- copy array
        _ROWCINT52DOList.clear();
        
        for (int i = 0; i < vROWCINT52DOArray.length; i++) {
                this._ROWCINT52DOList.add(vROWCINT52DOArray[i]);
        }
    } //-- void setROWCINT52DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO) 

    /**
     * Sets the value of '_ROWCINT52DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINT52DOList the Vector to copy.
     */
    public void setROWCINT52DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO> vROWCINT52DOList)
    {
        // copy vector
        this._ROWCINT52DOList.clear();
        
        this._ROWCINT52DOList.addAll(vROWCINT52DOList);
    } //-- void setROWCINT52DO(java.util.List) 

    /**
     * Sets the value of '_ROWCINT52DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINT52DOVector the Vector to set.
     */
    public void setROWCINT52DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO> ROWCINT52DOVector)
    {
        this._ROWCINT52DOList = ROWCINT52DOVector;
    } //-- void setROWCINT52DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO_ARRAY unmarshal(java.io.Reader) 

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
