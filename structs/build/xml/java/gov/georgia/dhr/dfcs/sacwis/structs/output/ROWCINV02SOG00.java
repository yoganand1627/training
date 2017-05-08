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
 * Class ROWCINV02SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV02SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdInvstActionAns
     */
    private java.lang.String _szCdInvstActionAns;

    /**
     * Field _szCdInvstActionQuest
     */
    private java.lang.String _szCdInvstActionQuest;

    /**
     * Field _szTxtInvstActionCmnts
     */
    private java.lang.String _szTxtInvstActionCmnts;

    /**
     * Field _ulIdInvstActionQuest
     */
    private int _ulIdInvstActionQuest;

    /**
     * keeps track of state for field: _ulIdInvstActionQuest
     */
    private boolean _has_ulIdInvstActionQuest;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV02SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV02SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdInvstActionQuest()
    {
        this._has_ulIdInvstActionQuest= false;
    } //-- void deleteUlIdInvstActionQuest() 

    /**
     * Returns the value of field 'szCdInvstActionAns'.
     * 
     * @return the value of field 'SzCdInvstActionAns'.
     */
    public java.lang.String getSzCdInvstActionAns()
    {
        return this._szCdInvstActionAns;
    } //-- java.lang.String getSzCdInvstActionAns() 

    /**
     * Returns the value of field 'szCdInvstActionQuest'.
     * 
     * @return the value of field 'SzCdInvstActionQuest'.
     */
    public java.lang.String getSzCdInvstActionQuest()
    {
        return this._szCdInvstActionQuest;
    } //-- java.lang.String getSzCdInvstActionQuest() 

    /**
     * Returns the value of field 'szTxtInvstActionCmnts'.
     * 
     * @return the value of field 'SzTxtInvstActionCmnts'.
     */
    public java.lang.String getSzTxtInvstActionCmnts()
    {
        return this._szTxtInvstActionCmnts;
    } //-- java.lang.String getSzTxtInvstActionCmnts() 

    /**
     * Returns the value of field 'tsLastUpdate'.
     * 
     * @return the value of field 'TsLastUpdate'.
     */
    public java.util.Date getTsLastUpdate()
    {
        return this._tsLastUpdate;
    } //-- java.util.Date getTsLastUpdate() 

    /**
     * Returns the value of field 'ulIdInvstActionQuest'.
     * 
     * @return the value of field 'UlIdInvstActionQuest'.
     */
    public int getUlIdInvstActionQuest()
    {
        return this._ulIdInvstActionQuest;
    } //-- int getUlIdInvstActionQuest() 

    /**
     * Method hasUlIdInvstActionQuest
     * 
     * 
     * 
     * @return true if at least one UlIdInvstActionQuest has been
     * added
     */
    public boolean hasUlIdInvstActionQuest()
    {
        return this._has_ulIdInvstActionQuest;
    } //-- boolean hasUlIdInvstActionQuest() 

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
     * Sets the value of field 'szCdInvstActionAns'.
     * 
     * @param szCdInvstActionAns the value of field
     * 'szCdInvstActionAns'.
     */
    public void setSzCdInvstActionAns(java.lang.String szCdInvstActionAns)
    {
        this._szCdInvstActionAns = szCdInvstActionAns;
    } //-- void setSzCdInvstActionAns(java.lang.String) 

    /**
     * Sets the value of field 'szCdInvstActionQuest'.
     * 
     * @param szCdInvstActionQuest the value of field
     * 'szCdInvstActionQuest'.
     */
    public void setSzCdInvstActionQuest(java.lang.String szCdInvstActionQuest)
    {
        this._szCdInvstActionQuest = szCdInvstActionQuest;
    } //-- void setSzCdInvstActionQuest(java.lang.String) 

    /**
     * Sets the value of field 'szTxtInvstActionCmnts'.
     * 
     * @param szTxtInvstActionCmnts the value of field
     * 'szTxtInvstActionCmnts'.
     */
    public void setSzTxtInvstActionCmnts(java.lang.String szTxtInvstActionCmnts)
    {
        this._szTxtInvstActionCmnts = szTxtInvstActionCmnts;
    } //-- void setSzTxtInvstActionCmnts(java.lang.String) 

    /**
     * Sets the value of field 'tsLastUpdate'.
     * 
     * @param tsLastUpdate the value of field 'tsLastUpdate'.
     */
    public void setTsLastUpdate(java.util.Date tsLastUpdate)
    {
        this._tsLastUpdate = tsLastUpdate;
    } //-- void setTsLastUpdate(java.util.Date) 

    /**
     * Sets the value of field 'ulIdInvstActionQuest'.
     * 
     * @param ulIdInvstActionQuest the value of field
     * 'ulIdInvstActionQuest'.
     */
    public void setUlIdInvstActionQuest(int ulIdInvstActionQuest)
    {
        this._ulIdInvstActionQuest = ulIdInvstActionQuest;
        this._has_ulIdInvstActionQuest = true;
    } //-- void setUlIdInvstActionQuest(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV02SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV02SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV02SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV02SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV02SOG00 unmarshal(java.io.Reader) 

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
