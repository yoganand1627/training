/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.5</a>, using an XML
 * Schema.
 * $Id$
 */

package gov.georgia.dhr.dfcs.sacwis.structs.document;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class Documents.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Documents implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _documentMetaDataList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData> _documentMetaDataList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Documents() 
     {
        super();
        this._documentMetaDataList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.Documents()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vDocumentMetaData
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDocumentMetaData(gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData vDocumentMetaData)
        throws java.lang.IndexOutOfBoundsException
    {
        this._documentMetaDataList.add(vDocumentMetaData);
    } //-- void addDocumentMetaData(gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData) 

    /**
     * 
     * 
     * @param index
     * @param vDocumentMetaData
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDocumentMetaData(int index, gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData vDocumentMetaData)
        throws java.lang.IndexOutOfBoundsException
    {
        this._documentMetaDataList.add(index, vDocumentMetaData);
    } //-- void addDocumentMetaData(int, gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData) 

    /**
     * Method enumerateDocumentMetaData
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData> enumerateDocumentMetaData()
    {
        return java.util.Collections.enumeration(this._documentMetaDataList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData> enumerateDocumentMetaData() 

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return the value of field 'ChoiceValue'.
     */
    public java.lang.Object getChoiceValue()
    {
        return this._choiceValue;
    } //-- java.lang.Object getChoiceValue() 

    /**
     * Method getDocumentMetaData
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData getDocumentMetaData(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._documentMetaDataList.size()) {
            throw new IndexOutOfBoundsException("getDocumentMetaData: Index value '" + index + "' not in range [0.." + (this._documentMetaDataList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData) _documentMetaDataList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData getDocumentMetaData(int) 

    /**
     * Method getDocumentMetaData
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData[] getDocumentMetaData()
    {
        int size = this._documentMetaDataList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData[] array = new gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData) _documentMetaDataList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData[] getDocumentMetaData() 

    /**
     * Method getDocumentMetaDataAsReference
     * 
     * Returns a reference to '_documentMetaDataList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData> getDocumentMetaDataAsReference()
    {
        return this._documentMetaDataList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData> getDocumentMetaDataAsReference() 

    /**
     * Method getDocumentMetaDataCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getDocumentMetaDataCount()
    {
        return this._documentMetaDataList.size();
    } //-- int getDocumentMetaDataCount() 

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
     * Method iterateDocumentMetaData
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData> iterateDocumentMetaData()
    {
        return this._documentMetaDataList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData> iterateDocumentMetaData() 

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
    public void removeAllDocumentMetaData()
    {
        this._documentMetaDataList.clear();
    } //-- void removeAllDocumentMetaData() 

    /**
     * Method removeDocumentMetaData
     * 
     * 
     * 
     * @param vDocumentMetaData
     * @return true if the object was removed from the collection.
     */
    public boolean removeDocumentMetaData(gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData vDocumentMetaData)
    {
        boolean removed = _documentMetaDataList.remove(vDocumentMetaData);
        return removed;
    } //-- boolean removeDocumentMetaData(gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData) 

    /**
     * Method removeDocumentMetaDataAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData removeDocumentMetaDataAt(int index)
    {
        Object obj = this._documentMetaDataList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData removeDocumentMetaDataAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vDocumentMetaData
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setDocumentMetaData(int index, gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData vDocumentMetaData)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._documentMetaDataList.size()) {
            throw new IndexOutOfBoundsException("setDocumentMetaData: Index value '" + index + "' not in range [0.." + (this._documentMetaDataList.size() - 1) + "]");
        }
        
        this._documentMetaDataList.set(index, vDocumentMetaData);
    } //-- void setDocumentMetaData(int, gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData) 

    /**
     * 
     * 
     * @param vDocumentMetaDataArray
     */
    public void setDocumentMetaData(gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData[] vDocumentMetaDataArray)
    {
        //-- copy array
        _documentMetaDataList.clear();
        
        for (int i = 0; i < vDocumentMetaDataArray.length; i++) {
                this._documentMetaDataList.add(vDocumentMetaDataArray[i]);
        }
    } //-- void setDocumentMetaData(gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData) 

    /**
     * Sets the value of '_documentMetaDataList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vDocumentMetaDataList the Vector to copy.
     */
    public void setDocumentMetaData(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData> vDocumentMetaDataList)
    {
        // copy vector
        this._documentMetaDataList.clear();
        
        this._documentMetaDataList.addAll(vDocumentMetaDataList);
    } //-- void setDocumentMetaData(java.util.List) 

    /**
     * Sets the value of '_documentMetaDataList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param DocumentMetaDataVector the Vector to set.
     */
    public void setDocumentMetaDataAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData> DocumentMetaDataVector)
    {
        this._documentMetaDataList = DocumentMetaDataVector;
    } //-- void setDocumentMetaDataAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.document.Documents
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.document.Documents unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.Documents) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.document.Documents.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.Documents unmarshal(java.io.Reader) 

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
