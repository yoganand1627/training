/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.5</a>, using an XML
 * Schema.
 * $Id$
 */

package gov.georgia.dhr.dfcs.sacwis.structs.input;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class CourtLanguage_Array.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CourtLanguage_Array extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _courtLanguageList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage> _courtLanguageList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CourtLanguage_Array() 
     {
        super();
        this._courtLanguageList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage_Array()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCourtLanguage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCourtLanguage(gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage vCourtLanguage)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._courtLanguageList.size() >= 100) {
            throw new IndexOutOfBoundsException("addCourtLanguage has a maximum of 100");
        }
        
        this._courtLanguageList.add(vCourtLanguage);
    } //-- void addCourtLanguage(gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage) 

    /**
     * 
     * 
     * @param index
     * @param vCourtLanguage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCourtLanguage(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage vCourtLanguage)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._courtLanguageList.size() >= 100) {
            throw new IndexOutOfBoundsException("addCourtLanguage has a maximum of 100");
        }
        
        this._courtLanguageList.add(index, vCourtLanguage);
    } //-- void addCourtLanguage(int, gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCourtLanguage
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage> enumerateCourtLanguage()
    {
        return java.util.Collections.enumeration(this._courtLanguageList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage> enumerateCourtLanguage() 

    /**
     * Method getCourtLanguage
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage getCourtLanguage(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._courtLanguageList.size()) {
            throw new IndexOutOfBoundsException("getCourtLanguage: Index value '" + index + "' not in range [0.." + (this._courtLanguageList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage) _courtLanguageList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage getCourtLanguage(int) 

    /**
     * Method getCourtLanguage
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage[] getCourtLanguage()
    {
        int size = this._courtLanguageList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage) _courtLanguageList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage[] getCourtLanguage() 

    /**
     * Method getCourtLanguageAsReference
     * 
     * Returns a reference to '_courtLanguageList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage> getCourtLanguageAsReference()
    {
        return this._courtLanguageList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage> getCourtLanguageAsReference() 

    /**
     * Method getCourtLanguageCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCourtLanguageCount()
    {
        return this._courtLanguageList.size();
    } //-- int getCourtLanguageCount() 

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
     * Method iterateCourtLanguage
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage> iterateCourtLanguage()
    {
        return this._courtLanguageList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage> iterateCourtLanguage() 

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
    public void removeAllCourtLanguage()
    {
        this._courtLanguageList.clear();
    } //-- void removeAllCourtLanguage() 

    /**
     * Method removeCourtLanguage
     * 
     * 
     * 
     * @param vCourtLanguage
     * @return true if the object was removed from the collection.
     */
    public boolean removeCourtLanguage(gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage vCourtLanguage)
    {
        boolean removed = _courtLanguageList.remove(vCourtLanguage);
        return removed;
    } //-- boolean removeCourtLanguage(gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage) 

    /**
     * Method removeCourtLanguageAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage removeCourtLanguageAt(int index)
    {
        Object obj = this._courtLanguageList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage removeCourtLanguageAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vCourtLanguage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCourtLanguage(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage vCourtLanguage)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._courtLanguageList.size()) {
            throw new IndexOutOfBoundsException("setCourtLanguage: Index value '" + index + "' not in range [0.." + (this._courtLanguageList.size() - 1) + "]");
        }
        
        this._courtLanguageList.set(index, vCourtLanguage);
    } //-- void setCourtLanguage(int, gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage) 

    /**
     * 
     * 
     * @param vCourtLanguageArray
     */
    public void setCourtLanguage(gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage[] vCourtLanguageArray)
    {
        //-- copy array
        _courtLanguageList.clear();
        
        for (int i = 0; i < vCourtLanguageArray.length; i++) {
                this._courtLanguageList.add(vCourtLanguageArray[i]);
        }
    } //-- void setCourtLanguage(gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage) 

    /**
     * Sets the value of '_courtLanguageList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vCourtLanguageList the Vector to copy.
     */
    public void setCourtLanguage(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage> vCourtLanguageList)
    {
        // copy vector
        this._courtLanguageList.clear();
        
        this._courtLanguageList.addAll(vCourtLanguageList);
    } //-- void setCourtLanguage(java.util.List) 

    /**
     * Sets the value of '_courtLanguageList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param CourtLanguageVector the Vector to set.
     */
    public void setCourtLanguageAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage> CourtLanguageVector)
    {
        this._courtLanguageList = CourtLanguageVector;
    } //-- void setCourtLanguageAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage_Array
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage_Array unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage_Array) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage_Array.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage_Array unmarshal(java.io.Reader) 

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
