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
 * Class TmScrTmCntct_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class TmScrTmCntct_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _tmScrTmCntctList
     */
    private java.util.List<java.lang.String> _tmScrTmCntctList;


      //----------------/
     //- Constructors -/
    //----------------/

    public TmScrTmCntct_ARRAY() 
     {
        super();
        this._tmScrTmCntctList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vTmScrTmCntct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTmScrTmCntct(java.lang.String vTmScrTmCntct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._tmScrTmCntctList.size() >= 2) {
            throw new IndexOutOfBoundsException("addTmScrTmCntct has a maximum of 2");
        }
        
        this._tmScrTmCntctList.add(vTmScrTmCntct);
    } //-- void addTmScrTmCntct(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vTmScrTmCntct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTmScrTmCntct(int index, java.lang.String vTmScrTmCntct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._tmScrTmCntctList.size() >= 2) {
            throw new IndexOutOfBoundsException("addTmScrTmCntct has a maximum of 2");
        }
        
        this._tmScrTmCntctList.add(index, vTmScrTmCntct);
    } //-- void addTmScrTmCntct(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateTmScrTmCntct
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateTmScrTmCntct()
    {
        return java.util.Collections.enumeration(this._tmScrTmCntctList);
    } //-- java.util.Enumeration<java.lang.String> enumerateTmScrTmCntct() 

    /**
     * Method getTmScrTmCntct
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getTmScrTmCntct(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._tmScrTmCntctList.size()) {
            throw new IndexOutOfBoundsException("getTmScrTmCntct: Index value '" + index + "' not in range [0.." + (this._tmScrTmCntctList.size() - 1) + "]");
        }
        
        return (String)_tmScrTmCntctList.get(index);
    } //-- java.lang.String getTmScrTmCntct(int) 

    /**
     * Method getTmScrTmCntct
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getTmScrTmCntct()
    {
        int size = this._tmScrTmCntctList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_tmScrTmCntctList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getTmScrTmCntct() 

    /**
     * Method getTmScrTmCntctAsReference
     * 
     * Returns a reference to '_tmScrTmCntctList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getTmScrTmCntctAsReference()
    {
        return this._tmScrTmCntctList;
    } //-- java.util.List<java.lang.String> getTmScrTmCntctAsReference() 

    /**
     * Method getTmScrTmCntctCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getTmScrTmCntctCount()
    {
        return this._tmScrTmCntctList.size();
    } //-- int getTmScrTmCntctCount() 

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
     * Method iterateTmScrTmCntct
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateTmScrTmCntct()
    {
        return this._tmScrTmCntctList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateTmScrTmCntct() 

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
    public void removeAllTmScrTmCntct()
    {
        this._tmScrTmCntctList.clear();
    } //-- void removeAllTmScrTmCntct() 

    /**
     * Method removeTmScrTmCntct
     * 
     * 
     * 
     * @param vTmScrTmCntct
     * @return true if the object was removed from the collection.
     */
    public boolean removeTmScrTmCntct(java.lang.String vTmScrTmCntct)
    {
        boolean removed = _tmScrTmCntctList.remove(vTmScrTmCntct);
        return removed;
    } //-- boolean removeTmScrTmCntct(java.lang.String) 

    /**
     * Method removeTmScrTmCntctAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeTmScrTmCntctAt(int index)
    {
        Object obj = this._tmScrTmCntctList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeTmScrTmCntctAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vTmScrTmCntct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setTmScrTmCntct(int index, java.lang.String vTmScrTmCntct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._tmScrTmCntctList.size()) {
            throw new IndexOutOfBoundsException("setTmScrTmCntct: Index value '" + index + "' not in range [0.." + (this._tmScrTmCntctList.size() - 1) + "]");
        }
        
        this._tmScrTmCntctList.set(index, vTmScrTmCntct);
    } //-- void setTmScrTmCntct(int, java.lang.String) 

    /**
     * 
     * 
     * @param vTmScrTmCntctArray
     */
    public void setTmScrTmCntct(java.lang.String[] vTmScrTmCntctArray)
    {
        //-- copy array
        _tmScrTmCntctList.clear();
        
        for (int i = 0; i < vTmScrTmCntctArray.length; i++) {
                this._tmScrTmCntctList.add(vTmScrTmCntctArray[i]);
        }
    } //-- void setTmScrTmCntct(java.lang.String) 

    /**
     * Sets the value of '_tmScrTmCntctList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vTmScrTmCntctList the Vector to copy.
     */
    public void setTmScrTmCntct(java.util.List<java.lang.String> vTmScrTmCntctList)
    {
        // copy vector
        this._tmScrTmCntctList.clear();
        
        this._tmScrTmCntctList.addAll(vTmScrTmCntctList);
    } //-- void setTmScrTmCntct(java.util.List) 

    /**
     * Sets the value of '_tmScrTmCntctList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param TmScrTmCntctVector the Vector to set.
     */
    public void setTmScrTmCntctAsReference(java.util.Vector<java.lang.String> TmScrTmCntctVector)
    {
        this._tmScrTmCntctList = TmScrTmCntctVector;
    } //-- void setTmScrTmCntctAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY unmarshal(java.io.Reader) 

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
