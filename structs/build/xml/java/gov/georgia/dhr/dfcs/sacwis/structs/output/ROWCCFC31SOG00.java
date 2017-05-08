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
 * Class ROWCCFC31SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCFC31SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdCrimHistAction
     */
    private java.lang.String _szCdCrimHistAction;

    /**
     * Field _szTxtCrimHistCmnts
     */
    private java.lang.String _szTxtCrimHistCmnts;

    /**
     * Field _szNmCrimHistReturned
     */
    private java.lang.String _szNmCrimHistReturned;

    /**
     * Field _ulIdCrimHist
     */
    private int _ulIdCrimHist;

    /**
     * keeps track of state for field: _ulIdCrimHist
     */
    private boolean _has_ulIdCrimHist;

    /**
     * Field _cIndDeleteNarr
     */
    private java.lang.String _cIndDeleteNarr;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCFC31SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC31SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCrimHist()
    {
        this._has_ulIdCrimHist= false;
    } //-- void deleteUlIdCrimHist() 

    /**
     * Returns the value of field 'cIndDeleteNarr'.
     * 
     * @return the value of field 'CIndDeleteNarr'.
     */
    public java.lang.String getCIndDeleteNarr()
    {
        return this._cIndDeleteNarr;
    } //-- java.lang.String getCIndDeleteNarr() 

    /**
     * Returns the value of field 'szCdCrimHistAction'.
     * 
     * @return the value of field 'SzCdCrimHistAction'.
     */
    public java.lang.String getSzCdCrimHistAction()
    {
        return this._szCdCrimHistAction;
    } //-- java.lang.String getSzCdCrimHistAction() 

    /**
     * Returns the value of field 'szNmCrimHistReturned'.
     * 
     * @return the value of field 'SzNmCrimHistReturned'.
     */
    public java.lang.String getSzNmCrimHistReturned()
    {
        return this._szNmCrimHistReturned;
    } //-- java.lang.String getSzNmCrimHistReturned() 

    /**
     * Returns the value of field 'szTxtCrimHistCmnts'.
     * 
     * @return the value of field 'SzTxtCrimHistCmnts'.
     */
    public java.lang.String getSzTxtCrimHistCmnts()
    {
        return this._szTxtCrimHistCmnts;
    } //-- java.lang.String getSzTxtCrimHistCmnts() 

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
     * Returns the value of field 'ulIdCrimHist'.
     * 
     * @return the value of field 'UlIdCrimHist'.
     */
    public int getUlIdCrimHist()
    {
        return this._ulIdCrimHist;
    } //-- int getUlIdCrimHist() 

    /**
     * Method hasUlIdCrimHist
     * 
     * 
     * 
     * @return true if at least one UlIdCrimHist has been added
     */
    public boolean hasUlIdCrimHist()
    {
        return this._has_ulIdCrimHist;
    } //-- boolean hasUlIdCrimHist() 

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
     * Sets the value of field 'cIndDeleteNarr'.
     * 
     * @param cIndDeleteNarr the value of field 'cIndDeleteNarr'.
     */
    public void setCIndDeleteNarr(java.lang.String cIndDeleteNarr)
    {
        this._cIndDeleteNarr = cIndDeleteNarr;
    } //-- void setCIndDeleteNarr(java.lang.String) 

    /**
     * Sets the value of field 'szCdCrimHistAction'.
     * 
     * @param szCdCrimHistAction the value of field
     * 'szCdCrimHistAction'.
     */
    public void setSzCdCrimHistAction(java.lang.String szCdCrimHistAction)
    {
        this._szCdCrimHistAction = szCdCrimHistAction;
    } //-- void setSzCdCrimHistAction(java.lang.String) 

    /**
     * Sets the value of field 'szNmCrimHistReturned'.
     * 
     * @param szNmCrimHistReturned the value of field
     * 'szNmCrimHistReturned'.
     */
    public void setSzNmCrimHistReturned(java.lang.String szNmCrimHistReturned)
    {
        this._szNmCrimHistReturned = szNmCrimHistReturned;
    } //-- void setSzNmCrimHistReturned(java.lang.String) 

    /**
     * Sets the value of field 'szTxtCrimHistCmnts'.
     * 
     * @param szTxtCrimHistCmnts the value of field
     * 'szTxtCrimHistCmnts'.
     */
    public void setSzTxtCrimHistCmnts(java.lang.String szTxtCrimHistCmnts)
    {
        this._szTxtCrimHistCmnts = szTxtCrimHistCmnts;
    } //-- void setSzTxtCrimHistCmnts(java.lang.String) 

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
     * Sets the value of field 'ulIdCrimHist'.
     * 
     * @param ulIdCrimHist the value of field 'ulIdCrimHist'.
     */
    public void setUlIdCrimHist(int ulIdCrimHist)
    {
        this._ulIdCrimHist = ulIdCrimHist;
        this._has_ulIdCrimHist = true;
    } //-- void setUlIdCrimHist(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC31SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC31SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC31SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC31SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC31SOG00 unmarshal(java.io.Reader) 

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
