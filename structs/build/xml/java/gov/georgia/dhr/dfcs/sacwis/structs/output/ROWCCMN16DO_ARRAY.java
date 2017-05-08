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
 * Class ROWCCMN16DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN16DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN16DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO> _ROWCCMN16DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN16DO_ARRAY() 
     {
        super();
        this._ROWCCMN16DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN16DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN16DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO vROWCCMN16DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN16DOList.size() >= 350) {
            throw new IndexOutOfBoundsException("addROWCCMN16DO has a maximum of 350");
        }
        
        this._ROWCCMN16DOList.add(vROWCCMN16DO);
    } //-- void addROWCCMN16DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN16DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN16DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO vROWCCMN16DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN16DOList.size() >= 350) {
            throw new IndexOutOfBoundsException("addROWCCMN16DO has a maximum of 350");
        }
        
        this._ROWCCMN16DOList.add(index, vROWCCMN16DO);
    } //-- void addROWCCMN16DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN16DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO> enumerateROWCCMN16DO()
    {
        return java.util.Collections.enumeration(this._ROWCCMN16DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO> enumerateROWCCMN16DO() 

    /**
     * Method getROWCCMN16DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO getROWCCMN16DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN16DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN16DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN16DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO) _ROWCCMN16DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO getROWCCMN16DO(int) 

    /**
     * Method getROWCCMN16DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO[] getROWCCMN16DO()
    {
        int size = this._ROWCCMN16DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO) _ROWCCMN16DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO[] getROWCCMN16DO() 

    /**
     * Method getROWCCMN16DOAsReference
     * 
     * Returns a reference to '_ROWCCMN16DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO> getROWCCMN16DOAsReference()
    {
        return this._ROWCCMN16DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO> getROWCCMN16DOAsReference() 

    /**
     * Method getROWCCMN16DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN16DOCount()
    {
        return this._ROWCCMN16DOList.size();
    } //-- int getROWCCMN16DOCount() 

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
     * Method iterateROWCCMN16DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO> iterateROWCCMN16DO()
    {
        return this._ROWCCMN16DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO> iterateROWCCMN16DO() 

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
    public void removeAllROWCCMN16DO()
    {
        this._ROWCCMN16DOList.clear();
    } //-- void removeAllROWCCMN16DO() 

    /**
     * Method removeROWCCMN16DO
     * 
     * 
     * 
     * @param vROWCCMN16DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN16DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO vROWCCMN16DO)
    {
        boolean removed = _ROWCCMN16DOList.remove(vROWCCMN16DO);
        return removed;
    } //-- boolean removeROWCCMN16DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO) 

    /**
     * Method removeROWCCMN16DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO removeROWCCMN16DOAt(int index)
    {
        Object obj = this._ROWCCMN16DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO removeROWCCMN16DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN16DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN16DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO vROWCCMN16DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN16DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN16DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN16DOList.size() - 1) + "]");
        }
        
        this._ROWCCMN16DOList.set(index, vROWCCMN16DO);
    } //-- void setROWCCMN16DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO) 

    /**
     * 
     * 
     * @param vROWCCMN16DOArray
     */
    public void setROWCCMN16DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO[] vROWCCMN16DOArray)
    {
        //-- copy array
        _ROWCCMN16DOList.clear();
        
        for (int i = 0; i < vROWCCMN16DOArray.length; i++) {
                this._ROWCCMN16DOList.add(vROWCCMN16DOArray[i]);
        }
    } //-- void setROWCCMN16DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO) 

    /**
     * Sets the value of '_ROWCCMN16DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN16DOList the Vector to copy.
     */
    public void setROWCCMN16DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO> vROWCCMN16DOList)
    {
        // copy vector
        this._ROWCCMN16DOList.clear();
        
        this._ROWCCMN16DOList.addAll(vROWCCMN16DOList);
    } //-- void setROWCCMN16DO(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN16DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN16DOVector the Vector to set.
     */
    public void setROWCCMN16DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO> ROWCCMN16DOVector)
    {
        this._ROWCCMN16DOList = ROWCCMN16DOVector;
    } //-- void setROWCCMN16DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO_ARRAY unmarshal(java.io.Reader) 

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
