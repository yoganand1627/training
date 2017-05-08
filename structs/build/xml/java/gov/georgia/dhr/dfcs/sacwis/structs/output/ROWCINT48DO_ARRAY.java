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
 * Class ROWCINT48DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINT48DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINT48DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO> _ROWCINT48DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINT48DO_ARRAY() 
     {
        super();
        this._ROWCINT48DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINT48DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINT48DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO vROWCINT48DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINT48DOList.size() >= 4) {
            throw new IndexOutOfBoundsException("addROWCINT48DO has a maximum of 4");
        }
        
        this._ROWCINT48DOList.add(vROWCINT48DO);
    } //-- void addROWCINT48DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINT48DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINT48DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO vROWCINT48DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINT48DOList.size() >= 4) {
            throw new IndexOutOfBoundsException("addROWCINT48DO has a maximum of 4");
        }
        
        this._ROWCINT48DOList.add(index, vROWCINT48DO);
    } //-- void addROWCINT48DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINT48DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO> enumerateROWCINT48DO()
    {
        return java.util.Collections.enumeration(this._ROWCINT48DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO> enumerateROWCINT48DO() 

    /**
     * Method getROWCINT48DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO getROWCINT48DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINT48DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCINT48DO: Index value '" + index + "' not in range [0.." + (this._ROWCINT48DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO) _ROWCINT48DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO getROWCINT48DO(int) 

    /**
     * Method getROWCINT48DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO[] getROWCINT48DO()
    {
        int size = this._ROWCINT48DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO) _ROWCINT48DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO[] getROWCINT48DO() 

    /**
     * Method getROWCINT48DOAsReference
     * 
     * Returns a reference to '_ROWCINT48DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO> getROWCINT48DOAsReference()
    {
        return this._ROWCINT48DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO> getROWCINT48DOAsReference() 

    /**
     * Method getROWCINT48DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINT48DOCount()
    {
        return this._ROWCINT48DOList.size();
    } //-- int getROWCINT48DOCount() 

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
     * Method iterateROWCINT48DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO> iterateROWCINT48DO()
    {
        return this._ROWCINT48DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO> iterateROWCINT48DO() 

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
    public void removeAllROWCINT48DO()
    {
        this._ROWCINT48DOList.clear();
    } //-- void removeAllROWCINT48DO() 

    /**
     * Method removeROWCINT48DO
     * 
     * 
     * 
     * @param vROWCINT48DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINT48DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO vROWCINT48DO)
    {
        boolean removed = _ROWCINT48DOList.remove(vROWCINT48DO);
        return removed;
    } //-- boolean removeROWCINT48DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO) 

    /**
     * Method removeROWCINT48DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO removeROWCINT48DOAt(int index)
    {
        Object obj = this._ROWCINT48DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO removeROWCINT48DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINT48DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINT48DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO vROWCINT48DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINT48DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCINT48DO: Index value '" + index + "' not in range [0.." + (this._ROWCINT48DOList.size() - 1) + "]");
        }
        
        this._ROWCINT48DOList.set(index, vROWCINT48DO);
    } //-- void setROWCINT48DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO) 

    /**
     * 
     * 
     * @param vROWCINT48DOArray
     */
    public void setROWCINT48DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO[] vROWCINT48DOArray)
    {
        //-- copy array
        _ROWCINT48DOList.clear();
        
        for (int i = 0; i < vROWCINT48DOArray.length; i++) {
                this._ROWCINT48DOList.add(vROWCINT48DOArray[i]);
        }
    } //-- void setROWCINT48DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO) 

    /**
     * Sets the value of '_ROWCINT48DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINT48DOList the Vector to copy.
     */
    public void setROWCINT48DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO> vROWCINT48DOList)
    {
        // copy vector
        this._ROWCINT48DOList.clear();
        
        this._ROWCINT48DOList.addAll(vROWCINT48DOList);
    } //-- void setROWCINT48DO(java.util.List) 

    /**
     * Sets the value of '_ROWCINT48DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINT48DOVector the Vector to set.
     */
    public void setROWCINT48DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO> ROWCINT48DOVector)
    {
        this._ROWCINT48DOList = ROWCINT48DOVector;
    } //-- void setROWCINT48DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO_ARRAY unmarshal(java.io.Reader) 

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
