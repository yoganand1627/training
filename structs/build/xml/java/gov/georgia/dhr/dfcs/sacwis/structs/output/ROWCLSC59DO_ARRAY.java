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
 * Class ROWCLSC59DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCLSC59DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCLSC59DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO> _ROWCLSC59DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCLSC59DO_ARRAY() 
     {
        super();
        this._ROWCLSC59DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCLSC59DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCLSC59DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO vROWCLSC59DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCLSC59DOList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCLSC59DO has a maximum of 100");
        }
        
        this._ROWCLSC59DOList.add(vROWCLSC59DO);
    } //-- void addROWCLSC59DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCLSC59DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCLSC59DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO vROWCLSC59DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCLSC59DOList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCLSC59DO has a maximum of 100");
        }
        
        this._ROWCLSC59DOList.add(index, vROWCLSC59DO);
    } //-- void addROWCLSC59DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCLSC59DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO> enumerateROWCLSC59DO()
    {
        return java.util.Collections.enumeration(this._ROWCLSC59DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO> enumerateROWCLSC59DO() 

    /**
     * Method getROWCLSC59DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO getROWCLSC59DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCLSC59DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCLSC59DO: Index value '" + index + "' not in range [0.." + (this._ROWCLSC59DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO) _ROWCLSC59DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO getROWCLSC59DO(int) 

    /**
     * Method getROWCLSC59DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO[] getROWCLSC59DO()
    {
        int size = this._ROWCLSC59DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO) _ROWCLSC59DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO[] getROWCLSC59DO() 

    /**
     * Method getROWCLSC59DOAsReference
     * 
     * Returns a reference to '_ROWCLSC59DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO> getROWCLSC59DOAsReference()
    {
        return this._ROWCLSC59DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO> getROWCLSC59DOAsReference() 

    /**
     * Method getROWCLSC59DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCLSC59DOCount()
    {
        return this._ROWCLSC59DOList.size();
    } //-- int getROWCLSC59DOCount() 

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
     * Method iterateROWCLSC59DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO> iterateROWCLSC59DO()
    {
        return this._ROWCLSC59DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO> iterateROWCLSC59DO() 

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
    public void removeAllROWCLSC59DO()
    {
        this._ROWCLSC59DOList.clear();
    } //-- void removeAllROWCLSC59DO() 

    /**
     * Method removeROWCLSC59DO
     * 
     * 
     * 
     * @param vROWCLSC59DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCLSC59DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO vROWCLSC59DO)
    {
        boolean removed = _ROWCLSC59DOList.remove(vROWCLSC59DO);
        return removed;
    } //-- boolean removeROWCLSC59DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO) 

    /**
     * Method removeROWCLSC59DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO removeROWCLSC59DOAt(int index)
    {
        Object obj = this._ROWCLSC59DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO removeROWCLSC59DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCLSC59DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCLSC59DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO vROWCLSC59DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCLSC59DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCLSC59DO: Index value '" + index + "' not in range [0.." + (this._ROWCLSC59DOList.size() - 1) + "]");
        }
        
        this._ROWCLSC59DOList.set(index, vROWCLSC59DO);
    } //-- void setROWCLSC59DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO) 

    /**
     * 
     * 
     * @param vROWCLSC59DOArray
     */
    public void setROWCLSC59DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO[] vROWCLSC59DOArray)
    {
        //-- copy array
        _ROWCLSC59DOList.clear();
        
        for (int i = 0; i < vROWCLSC59DOArray.length; i++) {
                this._ROWCLSC59DOList.add(vROWCLSC59DOArray[i]);
        }
    } //-- void setROWCLSC59DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO) 

    /**
     * Sets the value of '_ROWCLSC59DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCLSC59DOList the Vector to copy.
     */
    public void setROWCLSC59DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO> vROWCLSC59DOList)
    {
        // copy vector
        this._ROWCLSC59DOList.clear();
        
        this._ROWCLSC59DOList.addAll(vROWCLSC59DOList);
    } //-- void setROWCLSC59DO(java.util.List) 

    /**
     * Sets the value of '_ROWCLSC59DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCLSC59DOVector the Vector to set.
     */
    public void setROWCLSC59DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO> ROWCLSC59DOVector)
    {
        this._ROWCLSC59DOList = ROWCLSC59DOVector;
    } //-- void setROWCLSC59DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO_ARRAY unmarshal(java.io.Reader) 

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
