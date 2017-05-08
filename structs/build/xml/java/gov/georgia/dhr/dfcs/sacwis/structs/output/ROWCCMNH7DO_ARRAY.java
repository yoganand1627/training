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
 * Class ROWCCMNH7DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMNH7DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMNH7DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO> _ROWCCMNH7DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMNH7DO_ARRAY() 
     {
        super();
        this._ROWCCMNH7DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMNH7DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMNH7DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO vROWCCMNH7DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMNH7DOList.size() >= 350) {
            throw new IndexOutOfBoundsException("addROWCCMNH7DO has a maximum of 350");
        }
        
        this._ROWCCMNH7DOList.add(vROWCCMNH7DO);
    } //-- void addROWCCMNH7DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMNH7DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMNH7DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO vROWCCMNH7DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMNH7DOList.size() >= 350) {
            throw new IndexOutOfBoundsException("addROWCCMNH7DO has a maximum of 350");
        }
        
        this._ROWCCMNH7DOList.add(index, vROWCCMNH7DO);
    } //-- void addROWCCMNH7DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMNH7DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO> enumerateROWCCMNH7DO()
    {
        return java.util.Collections.enumeration(this._ROWCCMNH7DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO> enumerateROWCCMNH7DO() 

    /**
     * Method getROWCCMNH7DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO getROWCCMNH7DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMNH7DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMNH7DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMNH7DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO) _ROWCCMNH7DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO getROWCCMNH7DO(int) 

    /**
     * Method getROWCCMNH7DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO[] getROWCCMNH7DO()
    {
        int size = this._ROWCCMNH7DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO) _ROWCCMNH7DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO[] getROWCCMNH7DO() 

    /**
     * Method getROWCCMNH7DOAsReference
     * 
     * Returns a reference to '_ROWCCMNH7DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO> getROWCCMNH7DOAsReference()
    {
        return this._ROWCCMNH7DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO> getROWCCMNH7DOAsReference() 

    /**
     * Method getROWCCMNH7DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMNH7DOCount()
    {
        return this._ROWCCMNH7DOList.size();
    } //-- int getROWCCMNH7DOCount() 

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
     * Method iterateROWCCMNH7DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO> iterateROWCCMNH7DO()
    {
        return this._ROWCCMNH7DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO> iterateROWCCMNH7DO() 

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
    public void removeAllROWCCMNH7DO()
    {
        this._ROWCCMNH7DOList.clear();
    } //-- void removeAllROWCCMNH7DO() 

    /**
     * Method removeROWCCMNH7DO
     * 
     * 
     * 
     * @param vROWCCMNH7DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMNH7DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO vROWCCMNH7DO)
    {
        boolean removed = _ROWCCMNH7DOList.remove(vROWCCMNH7DO);
        return removed;
    } //-- boolean removeROWCCMNH7DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO) 

    /**
     * Method removeROWCCMNH7DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO removeROWCCMNH7DOAt(int index)
    {
        Object obj = this._ROWCCMNH7DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO removeROWCCMNH7DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMNH7DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMNH7DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO vROWCCMNH7DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMNH7DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMNH7DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMNH7DOList.size() - 1) + "]");
        }
        
        this._ROWCCMNH7DOList.set(index, vROWCCMNH7DO);
    } //-- void setROWCCMNH7DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO) 

    /**
     * 
     * 
     * @param vROWCCMNH7DOArray
     */
    public void setROWCCMNH7DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO[] vROWCCMNH7DOArray)
    {
        //-- copy array
        _ROWCCMNH7DOList.clear();
        
        for (int i = 0; i < vROWCCMNH7DOArray.length; i++) {
                this._ROWCCMNH7DOList.add(vROWCCMNH7DOArray[i]);
        }
    } //-- void setROWCCMNH7DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO) 

    /**
     * Sets the value of '_ROWCCMNH7DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMNH7DOList the Vector to copy.
     */
    public void setROWCCMNH7DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO> vROWCCMNH7DOList)
    {
        // copy vector
        this._ROWCCMNH7DOList.clear();
        
        this._ROWCCMNH7DOList.addAll(vROWCCMNH7DOList);
    } //-- void setROWCCMNH7DO(java.util.List) 

    /**
     * Sets the value of '_ROWCCMNH7DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMNH7DOVector the Vector to set.
     */
    public void setROWCCMNH7DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO> ROWCCMNH7DOVector)
    {
        this._ROWCCMNH7DOList = ROWCCMNH7DOVector;
    } //-- void setROWCCMNH7DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO_ARRAY unmarshal(java.io.Reader) 

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
