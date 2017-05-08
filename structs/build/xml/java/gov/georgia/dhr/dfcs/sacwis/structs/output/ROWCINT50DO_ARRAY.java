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
 * Class ROWCINT50DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINT50DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINT50DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO> _ROWCINT50DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINT50DO_ARRAY() 
     {
        super();
        this._ROWCINT50DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINT50DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINT50DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO vROWCINT50DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINT50DOList.size() >= 16) {
            throw new IndexOutOfBoundsException("addROWCINT50DO has a maximum of 16");
        }
        
        this._ROWCINT50DOList.add(vROWCINT50DO);
    } //-- void addROWCINT50DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINT50DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINT50DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO vROWCINT50DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINT50DOList.size() >= 16) {
            throw new IndexOutOfBoundsException("addROWCINT50DO has a maximum of 16");
        }
        
        this._ROWCINT50DOList.add(index, vROWCINT50DO);
    } //-- void addROWCINT50DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINT50DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO> enumerateROWCINT50DO()
    {
        return java.util.Collections.enumeration(this._ROWCINT50DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO> enumerateROWCINT50DO() 

    /**
     * Method getROWCINT50DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO getROWCINT50DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINT50DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCINT50DO: Index value '" + index + "' not in range [0.." + (this._ROWCINT50DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO) _ROWCINT50DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO getROWCINT50DO(int) 

    /**
     * Method getROWCINT50DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO[] getROWCINT50DO()
    {
        int size = this._ROWCINT50DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO) _ROWCINT50DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO[] getROWCINT50DO() 

    /**
     * Method getROWCINT50DOAsReference
     * 
     * Returns a reference to '_ROWCINT50DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO> getROWCINT50DOAsReference()
    {
        return this._ROWCINT50DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO> getROWCINT50DOAsReference() 

    /**
     * Method getROWCINT50DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINT50DOCount()
    {
        return this._ROWCINT50DOList.size();
    } //-- int getROWCINT50DOCount() 

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
     * Method iterateROWCINT50DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO> iterateROWCINT50DO()
    {
        return this._ROWCINT50DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO> iterateROWCINT50DO() 

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
    public void removeAllROWCINT50DO()
    {
        this._ROWCINT50DOList.clear();
    } //-- void removeAllROWCINT50DO() 

    /**
     * Method removeROWCINT50DO
     * 
     * 
     * 
     * @param vROWCINT50DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINT50DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO vROWCINT50DO)
    {
        boolean removed = _ROWCINT50DOList.remove(vROWCINT50DO);
        return removed;
    } //-- boolean removeROWCINT50DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO) 

    /**
     * Method removeROWCINT50DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO removeROWCINT50DOAt(int index)
    {
        Object obj = this._ROWCINT50DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO removeROWCINT50DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINT50DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINT50DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO vROWCINT50DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINT50DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCINT50DO: Index value '" + index + "' not in range [0.." + (this._ROWCINT50DOList.size() - 1) + "]");
        }
        
        this._ROWCINT50DOList.set(index, vROWCINT50DO);
    } //-- void setROWCINT50DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO) 

    /**
     * 
     * 
     * @param vROWCINT50DOArray
     */
    public void setROWCINT50DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO[] vROWCINT50DOArray)
    {
        //-- copy array
        _ROWCINT50DOList.clear();
        
        for (int i = 0; i < vROWCINT50DOArray.length; i++) {
                this._ROWCINT50DOList.add(vROWCINT50DOArray[i]);
        }
    } //-- void setROWCINT50DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO) 

    /**
     * Sets the value of '_ROWCINT50DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINT50DOList the Vector to copy.
     */
    public void setROWCINT50DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO> vROWCINT50DOList)
    {
        // copy vector
        this._ROWCINT50DOList.clear();
        
        this._ROWCINT50DOList.addAll(vROWCINT50DOList);
    } //-- void setROWCINT50DO(java.util.List) 

    /**
     * Sets the value of '_ROWCINT50DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINT50DOVector the Vector to set.
     */
    public void setROWCINT50DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO> ROWCINT50DOVector)
    {
        this._ROWCINT50DOList = ROWCINT50DOVector;
    } //-- void setROWCINT50DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO_ARRAY unmarshal(java.io.Reader) 

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
