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
 * Class ROWCCMN79DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN79DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN79DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO> _ROWCCMN79DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN79DO_ARRAY() 
     {
        super();
        this._ROWCCMN79DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN79DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN79DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO vROWCCMN79DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN79DOList.size() >= 90) {
            throw new IndexOutOfBoundsException("addROWCCMN79DO has a maximum of 90");
        }
        
        this._ROWCCMN79DOList.add(vROWCCMN79DO);
    } //-- void addROWCCMN79DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN79DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN79DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO vROWCCMN79DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN79DOList.size() >= 90) {
            throw new IndexOutOfBoundsException("addROWCCMN79DO has a maximum of 90");
        }
        
        this._ROWCCMN79DOList.add(index, vROWCCMN79DO);
    } //-- void addROWCCMN79DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN79DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO> enumerateROWCCMN79DO()
    {
        return java.util.Collections.enumeration(this._ROWCCMN79DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO> enumerateROWCCMN79DO() 

    /**
     * Method getROWCCMN79DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO getROWCCMN79DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN79DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN79DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN79DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO) _ROWCCMN79DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO getROWCCMN79DO(int) 

    /**
     * Method getROWCCMN79DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO[] getROWCCMN79DO()
    {
        int size = this._ROWCCMN79DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO) _ROWCCMN79DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO[] getROWCCMN79DO() 

    /**
     * Method getROWCCMN79DOAsReference
     * 
     * Returns a reference to '_ROWCCMN79DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO> getROWCCMN79DOAsReference()
    {
        return this._ROWCCMN79DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO> getROWCCMN79DOAsReference() 

    /**
     * Method getROWCCMN79DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN79DOCount()
    {
        return this._ROWCCMN79DOList.size();
    } //-- int getROWCCMN79DOCount() 

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
     * Method iterateROWCCMN79DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO> iterateROWCCMN79DO()
    {
        return this._ROWCCMN79DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO> iterateROWCCMN79DO() 

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
    public void removeAllROWCCMN79DO()
    {
        this._ROWCCMN79DOList.clear();
    } //-- void removeAllROWCCMN79DO() 

    /**
     * Method removeROWCCMN79DO
     * 
     * 
     * 
     * @param vROWCCMN79DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN79DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO vROWCCMN79DO)
    {
        boolean removed = _ROWCCMN79DOList.remove(vROWCCMN79DO);
        return removed;
    } //-- boolean removeROWCCMN79DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO) 

    /**
     * Method removeROWCCMN79DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO removeROWCCMN79DOAt(int index)
    {
        Object obj = this._ROWCCMN79DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO removeROWCCMN79DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN79DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN79DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO vROWCCMN79DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN79DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN79DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN79DOList.size() - 1) + "]");
        }
        
        this._ROWCCMN79DOList.set(index, vROWCCMN79DO);
    } //-- void setROWCCMN79DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO) 

    /**
     * 
     * 
     * @param vROWCCMN79DOArray
     */
    public void setROWCCMN79DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO[] vROWCCMN79DOArray)
    {
        //-- copy array
        _ROWCCMN79DOList.clear();
        
        for (int i = 0; i < vROWCCMN79DOArray.length; i++) {
                this._ROWCCMN79DOList.add(vROWCCMN79DOArray[i]);
        }
    } //-- void setROWCCMN79DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO) 

    /**
     * Sets the value of '_ROWCCMN79DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN79DOList the Vector to copy.
     */
    public void setROWCCMN79DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO> vROWCCMN79DOList)
    {
        // copy vector
        this._ROWCCMN79DOList.clear();
        
        this._ROWCCMN79DOList.addAll(vROWCCMN79DOList);
    } //-- void setROWCCMN79DO(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN79DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN79DOVector the Vector to set.
     */
    public void setROWCCMN79DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO> ROWCCMN79DOVector)
    {
        this._ROWCCMN79DOList = ROWCCMN79DOVector;
    } //-- void setROWCCMN79DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN79DO_ARRAY unmarshal(java.io.Reader) 

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
