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
 * Class DetermCmntsAUD.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class DetermCmntsAUD extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _txtSzTxtOthCmnts
     */
    private java.lang.String _txtSzTxtOthCmnts;

    /**
     * Field _txtSzTxtSxAbsCmnts
     */
    private java.lang.String _txtSzTxtSxAbsCmnts;

    /**
     * Field _txtSzTxtEmAbsCmnts
     */
    private java.lang.String _txtSzTxtEmAbsCmnts;

    /**
     * Field _txtSzTxtNegAbsCmnts
     */
    private java.lang.String _txtSzTxtNegAbsCmnts;

    /**
     * Field _txtSzTxtPhyAbsCmnts
     */
    private java.lang.String _txtSzTxtPhyAbsCmnts;


      //----------------/
     //- Constructors -/
    //----------------/

    public DetermCmntsAUD() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.DetermCmntsAUD()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'txtSzTxtEmAbsCmnts'.
     * 
     * @return the value of field 'TxtSzTxtEmAbsCmnts'.
     */
    public java.lang.String getTxtSzTxtEmAbsCmnts()
    {
        return this._txtSzTxtEmAbsCmnts;
    } //-- java.lang.String getTxtSzTxtEmAbsCmnts() 

    /**
     * Returns the value of field 'txtSzTxtNegAbsCmnts'.
     * 
     * @return the value of field 'TxtSzTxtNegAbsCmnts'.
     */
    public java.lang.String getTxtSzTxtNegAbsCmnts()
    {
        return this._txtSzTxtNegAbsCmnts;
    } //-- java.lang.String getTxtSzTxtNegAbsCmnts() 

    /**
     * Returns the value of field 'txtSzTxtOthCmnts'.
     * 
     * @return the value of field 'TxtSzTxtOthCmnts'.
     */
    public java.lang.String getTxtSzTxtOthCmnts()
    {
        return this._txtSzTxtOthCmnts;
    } //-- java.lang.String getTxtSzTxtOthCmnts() 

    /**
     * Returns the value of field 'txtSzTxtPhyAbsCmnts'.
     * 
     * @return the value of field 'TxtSzTxtPhyAbsCmnts'.
     */
    public java.lang.String getTxtSzTxtPhyAbsCmnts()
    {
        return this._txtSzTxtPhyAbsCmnts;
    } //-- java.lang.String getTxtSzTxtPhyAbsCmnts() 

    /**
     * Returns the value of field 'txtSzTxtSxAbsCmnts'.
     * 
     * @return the value of field 'TxtSzTxtSxAbsCmnts'.
     */
    public java.lang.String getTxtSzTxtSxAbsCmnts()
    {
        return this._txtSzTxtSxAbsCmnts;
    } //-- java.lang.String getTxtSzTxtSxAbsCmnts() 

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
     * Sets the value of field 'txtSzTxtEmAbsCmnts'.
     * 
     * @param txtSzTxtEmAbsCmnts the value of field
     * 'txtSzTxtEmAbsCmnts'.
     */
    public void setTxtSzTxtEmAbsCmnts(java.lang.String txtSzTxtEmAbsCmnts)
    {
        this._txtSzTxtEmAbsCmnts = txtSzTxtEmAbsCmnts;
    } //-- void setTxtSzTxtEmAbsCmnts(java.lang.String) 

    /**
     * Sets the value of field 'txtSzTxtNegAbsCmnts'.
     * 
     * @param txtSzTxtNegAbsCmnts the value of field
     * 'txtSzTxtNegAbsCmnts'.
     */
    public void setTxtSzTxtNegAbsCmnts(java.lang.String txtSzTxtNegAbsCmnts)
    {
        this._txtSzTxtNegAbsCmnts = txtSzTxtNegAbsCmnts;
    } //-- void setTxtSzTxtNegAbsCmnts(java.lang.String) 

    /**
     * Sets the value of field 'txtSzTxtOthCmnts'.
     * 
     * @param txtSzTxtOthCmnts the value of field 'txtSzTxtOthCmnts'
     */
    public void setTxtSzTxtOthCmnts(java.lang.String txtSzTxtOthCmnts)
    {
        this._txtSzTxtOthCmnts = txtSzTxtOthCmnts;
    } //-- void setTxtSzTxtOthCmnts(java.lang.String) 

    /**
     * Sets the value of field 'txtSzTxtPhyAbsCmnts'.
     * 
     * @param txtSzTxtPhyAbsCmnts the value of field
     * 'txtSzTxtPhyAbsCmnts'.
     */
    public void setTxtSzTxtPhyAbsCmnts(java.lang.String txtSzTxtPhyAbsCmnts)
    {
        this._txtSzTxtPhyAbsCmnts = txtSzTxtPhyAbsCmnts;
    } //-- void setTxtSzTxtPhyAbsCmnts(java.lang.String) 

    /**
     * Sets the value of field 'txtSzTxtSxAbsCmnts'.
     * 
     * @param txtSzTxtSxAbsCmnts the value of field
     * 'txtSzTxtSxAbsCmnts'.
     */
    public void setTxtSzTxtSxAbsCmnts(java.lang.String txtSzTxtSxAbsCmnts)
    {
        this._txtSzTxtSxAbsCmnts = txtSzTxtSxAbsCmnts;
    } //-- void setTxtSzTxtSxAbsCmnts(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.DetermCmntsAUD
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.DetermCmntsAUD unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.DetermCmntsAUD) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.DetermCmntsAUD.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.DetermCmntsAUD unmarshal(java.io.Reader) 

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
