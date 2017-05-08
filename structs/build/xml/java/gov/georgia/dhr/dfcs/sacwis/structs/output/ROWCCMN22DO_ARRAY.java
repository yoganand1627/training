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
 * Class ROWCCMN22DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN22DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN22DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO> _ROWCCMN22DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN22DO_ARRAY() 
     {
        super();
        this._ROWCCMN22DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN22DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN22DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO vROWCCMN22DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN22DOList.size() >= 9) {
            throw new IndexOutOfBoundsException("addROWCCMN22DO has a maximum of 9");
        }
        
        this._ROWCCMN22DOList.add(vROWCCMN22DO);
    } //-- void addROWCCMN22DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN22DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN22DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO vROWCCMN22DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN22DOList.size() >= 9) {
            throw new IndexOutOfBoundsException("addROWCCMN22DO has a maximum of 9");
        }
        
        this._ROWCCMN22DOList.add(index, vROWCCMN22DO);
    } //-- void addROWCCMN22DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN22DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO> enumerateROWCCMN22DO()
    {
        return java.util.Collections.enumeration(this._ROWCCMN22DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO> enumerateROWCCMN22DO() 

    /**
     * Method getROWCCMN22DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO getROWCCMN22DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN22DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN22DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN22DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO) _ROWCCMN22DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO getROWCCMN22DO(int) 

    /**
     * Method getROWCCMN22DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO[] getROWCCMN22DO()
    {
        int size = this._ROWCCMN22DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO) _ROWCCMN22DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO[] getROWCCMN22DO() 

    /**
     * Method getROWCCMN22DOAsReference
     * 
     * Returns a reference to '_ROWCCMN22DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO> getROWCCMN22DOAsReference()
    {
        return this._ROWCCMN22DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO> getROWCCMN22DOAsReference() 

    /**
     * Method getROWCCMN22DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN22DOCount()
    {
        return this._ROWCCMN22DOList.size();
    } //-- int getROWCCMN22DOCount() 

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
     * Method iterateROWCCMN22DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO> iterateROWCCMN22DO()
    {
        return this._ROWCCMN22DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO> iterateROWCCMN22DO() 

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
    public void removeAllROWCCMN22DO()
    {
        this._ROWCCMN22DOList.clear();
    } //-- void removeAllROWCCMN22DO() 

    /**
     * Method removeROWCCMN22DO
     * 
     * 
     * 
     * @param vROWCCMN22DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN22DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO vROWCCMN22DO)
    {
        boolean removed = _ROWCCMN22DOList.remove(vROWCCMN22DO);
        return removed;
    } //-- boolean removeROWCCMN22DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO) 

    /**
     * Method removeROWCCMN22DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO removeROWCCMN22DOAt(int index)
    {
        Object obj = this._ROWCCMN22DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO removeROWCCMN22DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN22DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN22DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO vROWCCMN22DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN22DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN22DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN22DOList.size() - 1) + "]");
        }
        
        this._ROWCCMN22DOList.set(index, vROWCCMN22DO);
    } //-- void setROWCCMN22DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO) 

    /**
     * 
     * 
     * @param vROWCCMN22DOArray
     */
    public void setROWCCMN22DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO[] vROWCCMN22DOArray)
    {
        //-- copy array
        _ROWCCMN22DOList.clear();
        
        for (int i = 0; i < vROWCCMN22DOArray.length; i++) {
                this._ROWCCMN22DOList.add(vROWCCMN22DOArray[i]);
        }
    } //-- void setROWCCMN22DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO) 

    /**
     * Sets the value of '_ROWCCMN22DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN22DOList the Vector to copy.
     */
    public void setROWCCMN22DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO> vROWCCMN22DOList)
    {
        // copy vector
        this._ROWCCMN22DOList.clear();
        
        this._ROWCCMN22DOList.addAll(vROWCCMN22DOList);
    } //-- void setROWCCMN22DO(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN22DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN22DOVector the Vector to set.
     */
    public void setROWCCMN22DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO> ROWCCMN22DOVector)
    {
        this._ROWCCMN22DOList = ROWCCMN22DOVector;
    } //-- void setROWCCMN22DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN22DO_ARRAY unmarshal(java.io.Reader) 

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
