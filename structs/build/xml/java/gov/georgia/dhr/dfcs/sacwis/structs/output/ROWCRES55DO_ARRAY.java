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
 * Class ROWCRES55DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCRES55DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCRES55DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO> _ROWCRES55DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCRES55DO_ARRAY() 
     {
        super();
        this._ROWCRES55DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCRES55DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCRES55DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO vROWCRES55DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCRES55DOList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCRES55DO has a maximum of 50");
        }
        
        this._ROWCRES55DOList.add(vROWCRES55DO);
    } //-- void addROWCRES55DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCRES55DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCRES55DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO vROWCRES55DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCRES55DOList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCRES55DO has a maximum of 50");
        }
        
        this._ROWCRES55DOList.add(index, vROWCRES55DO);
    } //-- void addROWCRES55DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCRES55DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO> enumerateROWCRES55DO()
    {
        return java.util.Collections.enumeration(this._ROWCRES55DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO> enumerateROWCRES55DO() 

    /**
     * Method getROWCRES55DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO getROWCRES55DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCRES55DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCRES55DO: Index value '" + index + "' not in range [0.." + (this._ROWCRES55DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO) _ROWCRES55DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO getROWCRES55DO(int) 

    /**
     * Method getROWCRES55DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO[] getROWCRES55DO()
    {
        int size = this._ROWCRES55DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO) _ROWCRES55DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO[] getROWCRES55DO() 

    /**
     * Method getROWCRES55DOAsReference
     * 
     * Returns a reference to '_ROWCRES55DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO> getROWCRES55DOAsReference()
    {
        return this._ROWCRES55DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO> getROWCRES55DOAsReference() 

    /**
     * Method getROWCRES55DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCRES55DOCount()
    {
        return this._ROWCRES55DOList.size();
    } //-- int getROWCRES55DOCount() 

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
     * Method iterateROWCRES55DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO> iterateROWCRES55DO()
    {
        return this._ROWCRES55DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO> iterateROWCRES55DO() 

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
    public void removeAllROWCRES55DO()
    {
        this._ROWCRES55DOList.clear();
    } //-- void removeAllROWCRES55DO() 

    /**
     * Method removeROWCRES55DO
     * 
     * 
     * 
     * @param vROWCRES55DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCRES55DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO vROWCRES55DO)
    {
        boolean removed = _ROWCRES55DOList.remove(vROWCRES55DO);
        return removed;
    } //-- boolean removeROWCRES55DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO) 

    /**
     * Method removeROWCRES55DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO removeROWCRES55DOAt(int index)
    {
        Object obj = this._ROWCRES55DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO removeROWCRES55DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCRES55DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCRES55DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO vROWCRES55DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCRES55DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCRES55DO: Index value '" + index + "' not in range [0.." + (this._ROWCRES55DOList.size() - 1) + "]");
        }
        
        this._ROWCRES55DOList.set(index, vROWCRES55DO);
    } //-- void setROWCRES55DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO) 

    /**
     * 
     * 
     * @param vROWCRES55DOArray
     */
    public void setROWCRES55DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO[] vROWCRES55DOArray)
    {
        //-- copy array
        _ROWCRES55DOList.clear();
        
        for (int i = 0; i < vROWCRES55DOArray.length; i++) {
                this._ROWCRES55DOList.add(vROWCRES55DOArray[i]);
        }
    } //-- void setROWCRES55DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO) 

    /**
     * Sets the value of '_ROWCRES55DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCRES55DOList the Vector to copy.
     */
    public void setROWCRES55DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO> vROWCRES55DOList)
    {
        // copy vector
        this._ROWCRES55DOList.clear();
        
        this._ROWCRES55DOList.addAll(vROWCRES55DOList);
    } //-- void setROWCRES55DO(java.util.List) 

    /**
     * Sets the value of '_ROWCRES55DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCRES55DOVector the Vector to set.
     */
    public void setROWCRES55DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO> ROWCRES55DOVector)
    {
        this._ROWCRES55DOList = ROWCRES55DOVector;
    } //-- void setROWCRES55DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO_ARRAY unmarshal(java.io.Reader) 

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
