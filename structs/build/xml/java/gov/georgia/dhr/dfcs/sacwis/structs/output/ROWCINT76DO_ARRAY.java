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
 * Class ROWCINT76DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINT76DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINT76DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO> _ROWCINT76DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINT76DO_ARRAY() 
     {
        super();
        this._ROWCINT76DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINT76DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINT76DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO vROWCINT76DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINT76DOList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCINT76DO has a maximum of 50");
        }
        
        this._ROWCINT76DOList.add(vROWCINT76DO);
    } //-- void addROWCINT76DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINT76DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINT76DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO vROWCINT76DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINT76DOList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCINT76DO has a maximum of 50");
        }
        
        this._ROWCINT76DOList.add(index, vROWCINT76DO);
    } //-- void addROWCINT76DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINT76DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO> enumerateROWCINT76DO()
    {
        return java.util.Collections.enumeration(this._ROWCINT76DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO> enumerateROWCINT76DO() 

    /**
     * Method getROWCINT76DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO getROWCINT76DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINT76DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCINT76DO: Index value '" + index + "' not in range [0.." + (this._ROWCINT76DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO) _ROWCINT76DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO getROWCINT76DO(int) 

    /**
     * Method getROWCINT76DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO[] getROWCINT76DO()
    {
        int size = this._ROWCINT76DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO) _ROWCINT76DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO[] getROWCINT76DO() 

    /**
     * Method getROWCINT76DOAsReference
     * 
     * Returns a reference to '_ROWCINT76DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO> getROWCINT76DOAsReference()
    {
        return this._ROWCINT76DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO> getROWCINT76DOAsReference() 

    /**
     * Method getROWCINT76DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINT76DOCount()
    {
        return this._ROWCINT76DOList.size();
    } //-- int getROWCINT76DOCount() 

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
     * Method iterateROWCINT76DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO> iterateROWCINT76DO()
    {
        return this._ROWCINT76DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO> iterateROWCINT76DO() 

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
    public void removeAllROWCINT76DO()
    {
        this._ROWCINT76DOList.clear();
    } //-- void removeAllROWCINT76DO() 

    /**
     * Method removeROWCINT76DO
     * 
     * 
     * 
     * @param vROWCINT76DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINT76DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO vROWCINT76DO)
    {
        boolean removed = _ROWCINT76DOList.remove(vROWCINT76DO);
        return removed;
    } //-- boolean removeROWCINT76DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO) 

    /**
     * Method removeROWCINT76DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO removeROWCINT76DOAt(int index)
    {
        Object obj = this._ROWCINT76DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO removeROWCINT76DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINT76DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINT76DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO vROWCINT76DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINT76DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCINT76DO: Index value '" + index + "' not in range [0.." + (this._ROWCINT76DOList.size() - 1) + "]");
        }
        
        this._ROWCINT76DOList.set(index, vROWCINT76DO);
    } //-- void setROWCINT76DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO) 

    /**
     * 
     * 
     * @param vROWCINT76DOArray
     */
    public void setROWCINT76DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO[] vROWCINT76DOArray)
    {
        //-- copy array
        _ROWCINT76DOList.clear();
        
        for (int i = 0; i < vROWCINT76DOArray.length; i++) {
                this._ROWCINT76DOList.add(vROWCINT76DOArray[i]);
        }
    } //-- void setROWCINT76DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO) 

    /**
     * Sets the value of '_ROWCINT76DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINT76DOList the Vector to copy.
     */
    public void setROWCINT76DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO> vROWCINT76DOList)
    {
        // copy vector
        this._ROWCINT76DOList.clear();
        
        this._ROWCINT76DOList.addAll(vROWCINT76DOList);
    } //-- void setROWCINT76DO(java.util.List) 

    /**
     * Sets the value of '_ROWCINT76DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINT76DOVector the Vector to set.
     */
    public void setROWCINT76DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO> ROWCINT76DOVector)
    {
        this._ROWCINT76DOList = ROWCINT76DOVector;
    } //-- void setROWCINT76DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY unmarshal(java.io.Reader) 

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
