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
 * Class PreFillData.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PreFillData extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _subGroupTemplate
     */
    private java.lang.String _subGroupTemplate;

    /**
     * Field _bookmarkList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark> _bookmarkList;

    /**
     * Field _blobDataList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData> _blobDataList;

    /**
     * Field _formDataGroupList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup> _formDataGroupList;

    /**
     * Field _formDataGroupBookmark
     */
    private java.lang.String _formDataGroupBookmark;


      //----------------/
     //- Constructors -/
    //----------------/

    public PreFillData() 
     {
        super();
        this._bookmarkList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark>();
        this._blobDataList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData>();
        this._formDataGroupList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vBlobData
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addBlobData(gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData vBlobData)
        throws java.lang.IndexOutOfBoundsException
    {
        this._blobDataList.add(vBlobData);
    } //-- void addBlobData(gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData) 

    /**
     * 
     * 
     * @param index
     * @param vBlobData
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addBlobData(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData vBlobData)
        throws java.lang.IndexOutOfBoundsException
    {
        this._blobDataList.add(index, vBlobData);
    } //-- void addBlobData(int, gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData) 

    /**
     * 
     * 
     * @param vBookmark
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addBookmark(gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark vBookmark)
        throws java.lang.IndexOutOfBoundsException
    {
        this._bookmarkList.add(vBookmark);
    } //-- void addBookmark(gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark) 

    /**
     * 
     * 
     * @param index
     * @param vBookmark
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addBookmark(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark vBookmark)
        throws java.lang.IndexOutOfBoundsException
    {
        this._bookmarkList.add(index, vBookmark);
    } //-- void addBookmark(int, gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark) 

    /**
     * 
     * 
     * @param vFormDataGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFormDataGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup vFormDataGroup)
        throws java.lang.IndexOutOfBoundsException
    {
        this._formDataGroupList.add(vFormDataGroup);
    } //-- void addFormDataGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup) 

    /**
     * 
     * 
     * @param index
     * @param vFormDataGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFormDataGroup(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup vFormDataGroup)
        throws java.lang.IndexOutOfBoundsException
    {
        this._formDataGroupList.add(index, vFormDataGroup);
    } //-- void addFormDataGroup(int, gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup) 

    /**
     * Method enumerateBlobData
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData> enumerateBlobData()
    {
        return java.util.Collections.enumeration(this._blobDataList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData> enumerateBlobData() 

    /**
     * Method enumerateBookmark
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark> enumerateBookmark()
    {
        return java.util.Collections.enumeration(this._bookmarkList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark> enumerateBookmark() 

    /**
     * Method enumerateFormDataGroup
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup> enumerateFormDataGroup()
    {
        return java.util.Collections.enumeration(this._formDataGroupList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup> enumerateFormDataGroup() 

    /**
     * Method getBlobData
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData getBlobData(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._blobDataList.size()) {
            throw new IndexOutOfBoundsException("getBlobData: Index value '" + index + "' not in range [0.." + (this._blobDataList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData) _blobDataList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData getBlobData(int) 

    /**
     * Method getBlobData
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData[] getBlobData()
    {
        int size = this._blobDataList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData) _blobDataList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData[] getBlobData() 

    /**
     * Method getBlobDataAsReference
     * 
     * Returns a reference to '_blobDataList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData> getBlobDataAsReference()
    {
        return this._blobDataList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData> getBlobDataAsReference() 

    /**
     * Method getBlobDataCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getBlobDataCount()
    {
        return this._blobDataList.size();
    } //-- int getBlobDataCount() 

    /**
     * Method getBookmark
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark getBookmark(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._bookmarkList.size()) {
            throw new IndexOutOfBoundsException("getBookmark: Index value '" + index + "' not in range [0.." + (this._bookmarkList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark) _bookmarkList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark getBookmark(int) 

    /**
     * Method getBookmark
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark[] getBookmark()
    {
        int size = this._bookmarkList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark) _bookmarkList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark[] getBookmark() 

    /**
     * Method getBookmarkAsReference
     * 
     * Returns a reference to '_bookmarkList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark> getBookmarkAsReference()
    {
        return this._bookmarkList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark> getBookmarkAsReference() 

    /**
     * Method getBookmarkCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getBookmarkCount()
    {
        return this._bookmarkList.size();
    } //-- int getBookmarkCount() 

    /**
     * Method getFormDataGroup
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup getFormDataGroup(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._formDataGroupList.size()) {
            throw new IndexOutOfBoundsException("getFormDataGroup: Index value '" + index + "' not in range [0.." + (this._formDataGroupList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup) _formDataGroupList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup getFormDataGroup(int) 

    /**
     * Method getFormDataGroup
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup[] getFormDataGroup()
    {
        int size = this._formDataGroupList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup) _formDataGroupList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup[] getFormDataGroup() 

    /**
     * Method getFormDataGroupAsReference
     * 
     * Returns a reference to '_formDataGroupList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup> getFormDataGroupAsReference()
    {
        return this._formDataGroupList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup> getFormDataGroupAsReference() 

    /**
     * Returns the value of field 'formDataGroupBookmark'.
     * 
     * @return the value of field 'FormDataGroupBookmark'.
     */
    public java.lang.String getFormDataGroupBookmark()
    {
        return this._formDataGroupBookmark;
    } //-- java.lang.String getFormDataGroupBookmark() 

    /**
     * Method getFormDataGroupCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getFormDataGroupCount()
    {
        return this._formDataGroupList.size();
    } //-- int getFormDataGroupCount() 

    /**
     * Returns the value of field 'subGroupTemplate'.
     * 
     * @return the value of field 'SubGroupTemplate'.
     */
    public java.lang.String getSubGroupTemplate()
    {
        return this._subGroupTemplate;
    } //-- java.lang.String getSubGroupTemplate() 

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
     * Method iterateBlobData
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData> iterateBlobData()
    {
        return this._blobDataList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData> iterateBlobData() 

    /**
     * Method iterateBookmark
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark> iterateBookmark()
    {
        return this._bookmarkList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark> iterateBookmark() 

    /**
     * Method iterateFormDataGroup
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup> iterateFormDataGroup()
    {
        return this._formDataGroupList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup> iterateFormDataGroup() 

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
    public void removeAllBlobData()
    {
        this._blobDataList.clear();
    } //-- void removeAllBlobData() 

    /**
     */
    public void removeAllBookmark()
    {
        this._bookmarkList.clear();
    } //-- void removeAllBookmark() 

    /**
     */
    public void removeAllFormDataGroup()
    {
        this._formDataGroupList.clear();
    } //-- void removeAllFormDataGroup() 

    /**
     * Method removeBlobData
     * 
     * 
     * 
     * @param vBlobData
     * @return true if the object was removed from the collection.
     */
    public boolean removeBlobData(gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData vBlobData)
    {
        boolean removed = _blobDataList.remove(vBlobData);
        return removed;
    } //-- boolean removeBlobData(gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData) 

    /**
     * Method removeBlobDataAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData removeBlobDataAt(int index)
    {
        Object obj = this._blobDataList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData removeBlobDataAt(int) 

    /**
     * Method removeBookmark
     * 
     * 
     * 
     * @param vBookmark
     * @return true if the object was removed from the collection.
     */
    public boolean removeBookmark(gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark vBookmark)
    {
        boolean removed = _bookmarkList.remove(vBookmark);
        return removed;
    } //-- boolean removeBookmark(gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark) 

    /**
     * Method removeBookmarkAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark removeBookmarkAt(int index)
    {
        Object obj = this._bookmarkList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark removeBookmarkAt(int) 

    /**
     * Method removeFormDataGroup
     * 
     * 
     * 
     * @param vFormDataGroup
     * @return true if the object was removed from the collection.
     */
    public boolean removeFormDataGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup vFormDataGroup)
    {
        boolean removed = _formDataGroupList.remove(vFormDataGroup);
        return removed;
    } //-- boolean removeFormDataGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup) 

    /**
     * Method removeFormDataGroupAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup removeFormDataGroupAt(int index)
    {
        Object obj = this._formDataGroupList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup removeFormDataGroupAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vBlobData
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setBlobData(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData vBlobData)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._blobDataList.size()) {
            throw new IndexOutOfBoundsException("setBlobData: Index value '" + index + "' not in range [0.." + (this._blobDataList.size() - 1) + "]");
        }
        
        this._blobDataList.set(index, vBlobData);
    } //-- void setBlobData(int, gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData) 

    /**
     * 
     * 
     * @param vBlobDataArray
     */
    public void setBlobData(gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData[] vBlobDataArray)
    {
        //-- copy array
        _blobDataList.clear();
        
        for (int i = 0; i < vBlobDataArray.length; i++) {
                this._blobDataList.add(vBlobDataArray[i]);
        }
    } //-- void setBlobData(gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData) 

    /**
     * Sets the value of '_blobDataList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vBlobDataList the Vector to copy.
     */
    public void setBlobData(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData> vBlobDataList)
    {
        // copy vector
        this._blobDataList.clear();
        
        this._blobDataList.addAll(vBlobDataList);
    } //-- void setBlobData(java.util.List) 

    /**
     * Sets the value of '_blobDataList' by setting it to the given
     * Vector. No type checking is performed.
     * 
     * @param BlobDataVector the Vector to set.
     */
    public void setBlobDataAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData> BlobDataVector)
    {
        this._blobDataList = BlobDataVector;
    } //-- void setBlobDataAsReference(java.util.Vector) 

    /**
     * 
     * 
     * @param index
     * @param vBookmark
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setBookmark(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark vBookmark)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._bookmarkList.size()) {
            throw new IndexOutOfBoundsException("setBookmark: Index value '" + index + "' not in range [0.." + (this._bookmarkList.size() - 1) + "]");
        }
        
        this._bookmarkList.set(index, vBookmark);
    } //-- void setBookmark(int, gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark) 

    /**
     * 
     * 
     * @param vBookmarkArray
     */
    public void setBookmark(gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark[] vBookmarkArray)
    {
        //-- copy array
        _bookmarkList.clear();
        
        for (int i = 0; i < vBookmarkArray.length; i++) {
                this._bookmarkList.add(vBookmarkArray[i]);
        }
    } //-- void setBookmark(gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark) 

    /**
     * Sets the value of '_bookmarkList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vBookmarkList the Vector to copy.
     */
    public void setBookmark(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark> vBookmarkList)
    {
        // copy vector
        this._bookmarkList.clear();
        
        this._bookmarkList.addAll(vBookmarkList);
    } //-- void setBookmark(java.util.List) 

    /**
     * Sets the value of '_bookmarkList' by setting it to the given
     * Vector. No type checking is performed.
     * 
     * @param BookmarkVector the Vector to set.
     */
    public void setBookmarkAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark> BookmarkVector)
    {
        this._bookmarkList = BookmarkVector;
    } //-- void setBookmarkAsReference(java.util.Vector) 

    /**
     * 
     * 
     * @param index
     * @param vFormDataGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setFormDataGroup(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup vFormDataGroup)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._formDataGroupList.size()) {
            throw new IndexOutOfBoundsException("setFormDataGroup: Index value '" + index + "' not in range [0.." + (this._formDataGroupList.size() - 1) + "]");
        }
        
        this._formDataGroupList.set(index, vFormDataGroup);
    } //-- void setFormDataGroup(int, gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup) 

    /**
     * 
     * 
     * @param vFormDataGroupArray
     */
    public void setFormDataGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup[] vFormDataGroupArray)
    {
        //-- copy array
        _formDataGroupList.clear();
        
        for (int i = 0; i < vFormDataGroupArray.length; i++) {
                this._formDataGroupList.add(vFormDataGroupArray[i]);
        }
    } //-- void setFormDataGroup(gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup) 

    /**
     * Sets the value of '_formDataGroupList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vFormDataGroupList the Vector to copy.
     */
    public void setFormDataGroup(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup> vFormDataGroupList)
    {
        // copy vector
        this._formDataGroupList.clear();
        
        this._formDataGroupList.addAll(vFormDataGroupList);
    } //-- void setFormDataGroup(java.util.List) 

    /**
     * Sets the value of '_formDataGroupList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param FormDataGroupVector the Vector to set.
     */
    public void setFormDataGroupAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup> FormDataGroupVector)
    {
        this._formDataGroupList = FormDataGroupVector;
    } //-- void setFormDataGroupAsReference(java.util.Vector) 

    /**
     * Sets the value of field 'formDataGroupBookmark'.
     * 
     * @param formDataGroupBookmark the value of field
     * 'formDataGroupBookmark'.
     */
    public void setFormDataGroupBookmark(java.lang.String formDataGroupBookmark)
    {
        this._formDataGroupBookmark = formDataGroupBookmark;
    } //-- void setFormDataGroupBookmark(java.lang.String) 

    /**
     * Sets the value of field 'subGroupTemplate'.
     * 
     * @param subGroupTemplate the value of field 'subGroupTemplate'
     */
    public void setSubGroupTemplate(java.lang.String subGroupTemplate)
    {
        this._subGroupTemplate = subGroupTemplate;
    } //-- void setSubGroupTemplate(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData unmarshal(java.io.Reader) 

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
