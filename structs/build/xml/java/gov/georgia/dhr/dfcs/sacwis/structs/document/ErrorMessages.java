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
 * Class ErrorMessages.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ErrorMessages implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _errorList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.Error> _errorList;

    /**
     * Field _default
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.document.Default _default;


      //----------------/
     //- Constructors -/
    //----------------/

    public ErrorMessages() 
     {
        super();
        this._errorList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.document.Error>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.ErrorMessages()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vError
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addError(gov.georgia.dhr.dfcs.sacwis.structs.document.Error vError)
        throws java.lang.IndexOutOfBoundsException
    {
        this._errorList.add(vError);
    } //-- void addError(gov.georgia.dhr.dfcs.sacwis.structs.document.Error) 

    /**
     * 
     * 
     * @param index
     * @param vError
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addError(int index, gov.georgia.dhr.dfcs.sacwis.structs.document.Error vError)
        throws java.lang.IndexOutOfBoundsException
    {
        this._errorList.add(index, vError);
    } //-- void addError(int, gov.georgia.dhr.dfcs.sacwis.structs.document.Error) 

    /**
     * Method enumerateError
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.document.Error> enumerateError()
    {
        return java.util.Collections.enumeration(this._errorList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.document.Error> enumerateError() 

    /**
     * Returns the value of field 'default'.
     * 
     * @return the value of field 'Default'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.Default getDefault()
    {
        return this._default;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.Default getDefault() 

    /**
     * Method getError
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.document.Error at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.Error getError(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._errorList.size()) {
            throw new IndexOutOfBoundsException("getError: Index value '" + index + "' not in range [0.." + (this._errorList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.Error) _errorList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.Error getError(int) 

    /**
     * Method getError
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.Error[] getError()
    {
        int size = this._errorList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.document.Error[] array = new gov.georgia.dhr.dfcs.sacwis.structs.document.Error[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.document.Error) _errorList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.Error[] getError() 

    /**
     * Method getErrorAsReference
     * 
     * Returns a reference to '_errorList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.Error> getErrorAsReference()
    {
        return this._errorList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.Error> getErrorAsReference() 

    /**
     * Method getErrorCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getErrorCount()
    {
        return this._errorList.size();
    } //-- int getErrorCount() 

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
     * Method iterateError
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.document.Error> iterateError()
    {
        return this._errorList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.document.Error> iterateError() 

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
    public void removeAllError()
    {
        this._errorList.clear();
    } //-- void removeAllError() 

    /**
     * Method removeError
     * 
     * 
     * 
     * @param vError
     * @return true if the object was removed from the collection.
     */
    public boolean removeError(gov.georgia.dhr.dfcs.sacwis.structs.document.Error vError)
    {
        boolean removed = _errorList.remove(vError);
        return removed;
    } //-- boolean removeError(gov.georgia.dhr.dfcs.sacwis.structs.document.Error) 

    /**
     * Method removeErrorAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.Error removeErrorAt(int index)
    {
        Object obj = this._errorList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.Error) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.Error removeErrorAt(int) 

    /**
     * Sets the value of field 'default'.
     * 
     * @param _default
     * @param default the value of field 'default'.
     */
    public void setDefault(gov.georgia.dhr.dfcs.sacwis.structs.document.Default _default)
    {
        this._default = _default;
    } //-- void setDefault(gov.georgia.dhr.dfcs.sacwis.structs.document.Default) 

    /**
     * 
     * 
     * @param index
     * @param vError
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setError(int index, gov.georgia.dhr.dfcs.sacwis.structs.document.Error vError)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._errorList.size()) {
            throw new IndexOutOfBoundsException("setError: Index value '" + index + "' not in range [0.." + (this._errorList.size() - 1) + "]");
        }
        
        this._errorList.set(index, vError);
    } //-- void setError(int, gov.georgia.dhr.dfcs.sacwis.structs.document.Error) 

    /**
     * 
     * 
     * @param vErrorArray
     */
    public void setError(gov.georgia.dhr.dfcs.sacwis.structs.document.Error[] vErrorArray)
    {
        //-- copy array
        _errorList.clear();
        
        for (int i = 0; i < vErrorArray.length; i++) {
                this._errorList.add(vErrorArray[i]);
        }
    } //-- void setError(gov.georgia.dhr.dfcs.sacwis.structs.document.Error) 

    /**
     * Sets the value of '_errorList' by copying the given Vector.
     * All elements will be checked for type safety.
     * 
     * @param vErrorList the Vector to copy.
     */
    public void setError(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.Error> vErrorList)
    {
        // copy vector
        this._errorList.clear();
        
        this._errorList.addAll(vErrorList);
    } //-- void setError(java.util.List) 

    /**
     * Sets the value of '_errorList' by setting it to the given
     * Vector. No type checking is performed.
     * 
     * @param ErrorVector the Vector to set.
     */
    public void setErrorAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.document.Error> ErrorVector)
    {
        this._errorList = ErrorVector;
    } //-- void setErrorAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.document.ErrorMessages
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.document.ErrorMessages unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.ErrorMessages) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.document.ErrorMessages.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.ErrorMessages unmarshal(java.io.Reader) 

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
