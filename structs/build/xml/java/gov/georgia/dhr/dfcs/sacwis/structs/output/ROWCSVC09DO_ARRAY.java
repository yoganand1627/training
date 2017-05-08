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
 * Class ROWCSVC09DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSVC09DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCSVC09DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO> _ROWCSVC09DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSVC09DO_ARRAY() 
     {
        super();
        this._ROWCSVC09DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCSVC09DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSVC09DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO vROWCSVC09DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSVC09DOList.size() >= 500) {
            throw new IndexOutOfBoundsException("addROWCSVC09DO has a maximum of 500");
        }
        
        this._ROWCSVC09DOList.add(vROWCSVC09DO);
    } //-- void addROWCSVC09DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSVC09DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSVC09DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO vROWCSVC09DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSVC09DOList.size() >= 500) {
            throw new IndexOutOfBoundsException("addROWCSVC09DO has a maximum of 500");
        }
        
        this._ROWCSVC09DOList.add(index, vROWCSVC09DO);
    } //-- void addROWCSVC09DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCSVC09DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO> enumerateROWCSVC09DO()
    {
        return java.util.Collections.enumeration(this._ROWCSVC09DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO> enumerateROWCSVC09DO() 

    /**
     * Method getROWCSVC09DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO getROWCSVC09DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSVC09DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCSVC09DO: Index value '" + index + "' not in range [0.." + (this._ROWCSVC09DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO) _ROWCSVC09DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO getROWCSVC09DO(int) 

    /**
     * Method getROWCSVC09DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO[] getROWCSVC09DO()
    {
        int size = this._ROWCSVC09DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO) _ROWCSVC09DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO[] getROWCSVC09DO() 

    /**
     * Method getROWCSVC09DOAsReference
     * 
     * Returns a reference to '_ROWCSVC09DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO> getROWCSVC09DOAsReference()
    {
        return this._ROWCSVC09DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO> getROWCSVC09DOAsReference() 

    /**
     * Method getROWCSVC09DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCSVC09DOCount()
    {
        return this._ROWCSVC09DOList.size();
    } //-- int getROWCSVC09DOCount() 

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
     * Method iterateROWCSVC09DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO> iterateROWCSVC09DO()
    {
        return this._ROWCSVC09DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO> iterateROWCSVC09DO() 

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
    public void removeAllROWCSVC09DO()
    {
        this._ROWCSVC09DOList.clear();
    } //-- void removeAllROWCSVC09DO() 

    /**
     * Method removeROWCSVC09DO
     * 
     * 
     * 
     * @param vROWCSVC09DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCSVC09DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO vROWCSVC09DO)
    {
        boolean removed = _ROWCSVC09DOList.remove(vROWCSVC09DO);
        return removed;
    } //-- boolean removeROWCSVC09DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO) 

    /**
     * Method removeROWCSVC09DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO removeROWCSVC09DOAt(int index)
    {
        Object obj = this._ROWCSVC09DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO removeROWCSVC09DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSVC09DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCSVC09DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO vROWCSVC09DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSVC09DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCSVC09DO: Index value '" + index + "' not in range [0.." + (this._ROWCSVC09DOList.size() - 1) + "]");
        }
        
        this._ROWCSVC09DOList.set(index, vROWCSVC09DO);
    } //-- void setROWCSVC09DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO) 

    /**
     * 
     * 
     * @param vROWCSVC09DOArray
     */
    public void setROWCSVC09DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO[] vROWCSVC09DOArray)
    {
        //-- copy array
        _ROWCSVC09DOList.clear();
        
        for (int i = 0; i < vROWCSVC09DOArray.length; i++) {
                this._ROWCSVC09DOList.add(vROWCSVC09DOArray[i]);
        }
    } //-- void setROWCSVC09DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO) 

    /**
     * Sets the value of '_ROWCSVC09DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCSVC09DOList the Vector to copy.
     */
    public void setROWCSVC09DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO> vROWCSVC09DOList)
    {
        // copy vector
        this._ROWCSVC09DOList.clear();
        
        this._ROWCSVC09DOList.addAll(vROWCSVC09DOList);
    } //-- void setROWCSVC09DO(java.util.List) 

    /**
     * Sets the value of '_ROWCSVC09DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCSVC09DOVector the Vector to set.
     */
    public void setROWCSVC09DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO> ROWCSVC09DOVector)
    {
        this._ROWCSVC09DOList = ROWCSVC09DOVector;
    } //-- void setROWCSVC09DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO_ARRAY unmarshal(java.io.Reader) 

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
