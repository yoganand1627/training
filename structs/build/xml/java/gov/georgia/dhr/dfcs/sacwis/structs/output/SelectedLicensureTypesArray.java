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
 * Class SelectedLicensureTypesArray.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SelectedLicensureTypesArray extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szPrgmLicensureTypeList
     */
    private java.util.List<java.lang.String> _szPrgmLicensureTypeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SelectedLicensureTypesArray() 
     {
        super();
        this._szPrgmLicensureTypeList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SelectedLicensureTypesArray()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzPrgmLicensureType
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzPrgmLicensureType(java.lang.String vSzPrgmLicensureType)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szPrgmLicensureTypeList.size() >= 20) {
            throw new IndexOutOfBoundsException("addSzPrgmLicensureType has a maximum of 20");
        }
        
        this._szPrgmLicensureTypeList.add(vSzPrgmLicensureType);
    } //-- void addSzPrgmLicensureType(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzPrgmLicensureType
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzPrgmLicensureType(int index, java.lang.String vSzPrgmLicensureType)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szPrgmLicensureTypeList.size() >= 20) {
            throw new IndexOutOfBoundsException("addSzPrgmLicensureType has a maximum of 20");
        }
        
        this._szPrgmLicensureTypeList.add(index, vSzPrgmLicensureType);
    } //-- void addSzPrgmLicensureType(int, java.lang.String) 

    /**
     * Method enumerateSzPrgmLicensureType
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzPrgmLicensureType()
    {
        return java.util.Collections.enumeration(this._szPrgmLicensureTypeList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzPrgmLicensureType() 

    /**
     * Method getSzPrgmLicensureType
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzPrgmLicensureType(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szPrgmLicensureTypeList.size()) {
            throw new IndexOutOfBoundsException("getSzPrgmLicensureType: Index value '" + index + "' not in range [0.." + (this._szPrgmLicensureTypeList.size() - 1) + "]");
        }
        
        return (String)_szPrgmLicensureTypeList.get(index);
    } //-- java.lang.String getSzPrgmLicensureType(int) 

    /**
     * Method getSzPrgmLicensureType
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzPrgmLicensureType()
    {
        int size = this._szPrgmLicensureTypeList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szPrgmLicensureTypeList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzPrgmLicensureType() 

    /**
     * Method getSzPrgmLicensureTypeAsReference
     * 
     * Returns a reference to '_szPrgmLicensureTypeList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzPrgmLicensureTypeAsReference()
    {
        return this._szPrgmLicensureTypeList;
    } //-- java.util.List<java.lang.String> getSzPrgmLicensureTypeAsReference() 

    /**
     * Method getSzPrgmLicensureTypeCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzPrgmLicensureTypeCount()
    {
        return this._szPrgmLicensureTypeList.size();
    } //-- int getSzPrgmLicensureTypeCount() 

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
     * Method iterateSzPrgmLicensureType
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzPrgmLicensureType()
    {
        return this._szPrgmLicensureTypeList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzPrgmLicensureType() 

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
    public void removeAllSzPrgmLicensureType()
    {
        this._szPrgmLicensureTypeList.clear();
    } //-- void removeAllSzPrgmLicensureType() 

    /**
     * Method removeSzPrgmLicensureType
     * 
     * 
     * 
     * @param vSzPrgmLicensureType
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzPrgmLicensureType(java.lang.String vSzPrgmLicensureType)
    {
        boolean removed = _szPrgmLicensureTypeList.remove(vSzPrgmLicensureType);
        return removed;
    } //-- boolean removeSzPrgmLicensureType(java.lang.String) 

    /**
     * Method removeSzPrgmLicensureTypeAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzPrgmLicensureTypeAt(int index)
    {
        Object obj = this._szPrgmLicensureTypeList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzPrgmLicensureTypeAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzPrgmLicensureType
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzPrgmLicensureType(int index, java.lang.String vSzPrgmLicensureType)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szPrgmLicensureTypeList.size()) {
            throw new IndexOutOfBoundsException("setSzPrgmLicensureType: Index value '" + index + "' not in range [0.." + (this._szPrgmLicensureTypeList.size() - 1) + "]");
        }
        
        this._szPrgmLicensureTypeList.set(index, vSzPrgmLicensureType);
    } //-- void setSzPrgmLicensureType(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzPrgmLicensureTypeArray
     */
    public void setSzPrgmLicensureType(java.lang.String[] vSzPrgmLicensureTypeArray)
    {
        //-- copy array
        _szPrgmLicensureTypeList.clear();
        
        for (int i = 0; i < vSzPrgmLicensureTypeArray.length; i++) {
                this._szPrgmLicensureTypeList.add(vSzPrgmLicensureTypeArray[i]);
        }
    } //-- void setSzPrgmLicensureType(java.lang.String) 

    /**
     * Sets the value of '_szPrgmLicensureTypeList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vSzPrgmLicensureTypeList the Vector to copy.
     */
    public void setSzPrgmLicensureType(java.util.List<java.lang.String> vSzPrgmLicensureTypeList)
    {
        // copy vector
        this._szPrgmLicensureTypeList.clear();
        
        this._szPrgmLicensureTypeList.addAll(vSzPrgmLicensureTypeList);
    } //-- void setSzPrgmLicensureType(java.util.List) 

    /**
     * Sets the value of '_szPrgmLicensureTypeList' by setting it
     * to the given Vector. No type checking is performed.
     * 
     * @param SzPrgmLicensureTypeVector the Vector to set.
     */
    public void setSzPrgmLicensureTypeAsReference(java.util.Vector<java.lang.String> SzPrgmLicensureTypeVector)
    {
        this._szPrgmLicensureTypeList = SzPrgmLicensureTypeVector;
    } //-- void setSzPrgmLicensureTypeAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.SelectedLicensureTypesArray
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.SelectedLicensureTypesArray unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.SelectedLicensureTypesArray) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.SelectedLicensureTypesArray.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SelectedLicensureTypesArray unmarshal(java.io.Reader) 

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
