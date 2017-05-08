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
 * Class ROWCCMN22DI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN22DI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _usNbrEmpOnCallCntctOrd
     */
    private int _usNbrEmpOnCallCntctOrd;

    /**
     * keeps track of state for field: _usNbrEmpOnCallCntctOrd
     */
    private boolean _has_usNbrEmpOnCallCntctOrd;

    /**
     * Field _szCdEmpOnCallDesig
     */
    private java.lang.String _szCdEmpOnCallDesig;

    /**
     * Field _szNbrEmpOnCallPhone1
     */
    private java.lang.String _szNbrEmpOnCallPhone1;

    /**
     * Field _lNbrEmpOnCallExt1
     */
    private java.lang.String _lNbrEmpOnCallExt1;

    /**
     * Field _szNbrEmpOnCallPhone2
     */
    private java.lang.String _szNbrEmpOnCallPhone2;

    /**
     * Field _lNbrEmpOnCallExt2
     */
    private java.lang.String _lNbrEmpOnCallExt2;

    /**
     * Field _ulIdEmpOnCallLink
     */
    private int _ulIdEmpOnCallLink;

    /**
     * keeps track of state for field: _ulIdEmpOnCallLink
     */
    private boolean _has_ulIdEmpOnCallLink;

    /**
     * Field _ulIdOnCall
     */
    private int _ulIdOnCall;

    /**
     * keeps track of state for field: _ulIdOnCall
     */
    private boolean _has_ulIdOnCall;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdTitle
     */
    private java.lang.String _szCdTitle;

    /**
     * Field _szCdOnCallProgram
     */
    private java.lang.String _szCdOnCallProgram;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN22DI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEmpOnCallLink()
    {
        this._has_ulIdEmpOnCallLink= false;
    } //-- void deleteUlIdEmpOnCallLink() 

    /**
     */
    public void deleteUlIdOnCall()
    {
        this._has_ulIdOnCall= false;
    } //-- void deleteUlIdOnCall() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUsNbrEmpOnCallCntctOrd()
    {
        this._has_usNbrEmpOnCallCntctOrd= false;
    } //-- void deleteUsNbrEmpOnCallCntctOrd() 

    /**
     * Returns the value of field 'lNbrEmpOnCallExt1'.
     * 
     * @return the value of field 'LNbrEmpOnCallExt1'.
     */
    public java.lang.String getLNbrEmpOnCallExt1()
    {
        return this._lNbrEmpOnCallExt1;
    } //-- java.lang.String getLNbrEmpOnCallExt1() 

    /**
     * Returns the value of field 'lNbrEmpOnCallExt2'.
     * 
     * @return the value of field 'LNbrEmpOnCallExt2'.
     */
    public java.lang.String getLNbrEmpOnCallExt2()
    {
        return this._lNbrEmpOnCallExt2;
    } //-- java.lang.String getLNbrEmpOnCallExt2() 

    /**
     * Returns the value of field 'szCdEmpOnCallDesig'.
     * 
     * @return the value of field 'SzCdEmpOnCallDesig'.
     */
    public java.lang.String getSzCdEmpOnCallDesig()
    {
        return this._szCdEmpOnCallDesig;
    } //-- java.lang.String getSzCdEmpOnCallDesig() 

    /**
     * Returns the value of field 'szCdOnCallProgram'.
     * 
     * @return the value of field 'SzCdOnCallProgram'.
     */
    public java.lang.String getSzCdOnCallProgram()
    {
        return this._szCdOnCallProgram;
    } //-- java.lang.String getSzCdOnCallProgram() 

    /**
     * Returns the value of field 'szCdScrDataAction'.
     * 
     * @return the value of field 'SzCdScrDataAction'.
     */
    public java.lang.String getSzCdScrDataAction()
    {
        return this._szCdScrDataAction;
    } //-- java.lang.String getSzCdScrDataAction() 

    /**
     * Returns the value of field 'szCdTitle'.
     * 
     * @return the value of field 'SzCdTitle'.
     */
    public java.lang.String getSzCdTitle()
    {
        return this._szCdTitle;
    } //-- java.lang.String getSzCdTitle() 

    /**
     * Returns the value of field 'szNbrEmpOnCallPhone1'.
     * 
     * @return the value of field 'SzNbrEmpOnCallPhone1'.
     */
    public java.lang.String getSzNbrEmpOnCallPhone1()
    {
        return this._szNbrEmpOnCallPhone1;
    } //-- java.lang.String getSzNbrEmpOnCallPhone1() 

    /**
     * Returns the value of field 'szNbrEmpOnCallPhone2'.
     * 
     * @return the value of field 'SzNbrEmpOnCallPhone2'.
     */
    public java.lang.String getSzNbrEmpOnCallPhone2()
    {
        return this._szNbrEmpOnCallPhone2;
    } //-- java.lang.String getSzNbrEmpOnCallPhone2() 

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
     * Returns the value of field 'ulIdEmpOnCallLink'.
     * 
     * @return the value of field 'UlIdEmpOnCallLink'.
     */
    public int getUlIdEmpOnCallLink()
    {
        return this._ulIdEmpOnCallLink;
    } //-- int getUlIdEmpOnCallLink() 

    /**
     * Returns the value of field 'ulIdOnCall'.
     * 
     * @return the value of field 'UlIdOnCall'.
     */
    public int getUlIdOnCall()
    {
        return this._ulIdOnCall;
    } //-- int getUlIdOnCall() 

    /**
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Returns the value of field 'usNbrEmpOnCallCntctOrd'.
     * 
     * @return the value of field 'UsNbrEmpOnCallCntctOrd'.
     */
    public int getUsNbrEmpOnCallCntctOrd()
    {
        return this._usNbrEmpOnCallCntctOrd;
    } //-- int getUsNbrEmpOnCallCntctOrd() 

    /**
     * Method hasUlIdEmpOnCallLink
     * 
     * 
     * 
     * @return true if at least one UlIdEmpOnCallLink has been added
     */
    public boolean hasUlIdEmpOnCallLink()
    {
        return this._has_ulIdEmpOnCallLink;
    } //-- boolean hasUlIdEmpOnCallLink() 

    /**
     * Method hasUlIdOnCall
     * 
     * 
     * 
     * @return true if at least one UlIdOnCall has been added
     */
    public boolean hasUlIdOnCall()
    {
        return this._has_ulIdOnCall;
    } //-- boolean hasUlIdOnCall() 

    /**
     * Method hasUlIdPerson
     * 
     * 
     * 
     * @return true if at least one UlIdPerson has been added
     */
    public boolean hasUlIdPerson()
    {
        return this._has_ulIdPerson;
    } //-- boolean hasUlIdPerson() 

    /**
     * Method hasUsNbrEmpOnCallCntctOrd
     * 
     * 
     * 
     * @return true if at least one UsNbrEmpOnCallCntctOrd has been
     * added
     */
    public boolean hasUsNbrEmpOnCallCntctOrd()
    {
        return this._has_usNbrEmpOnCallCntctOrd;
    } //-- boolean hasUsNbrEmpOnCallCntctOrd() 

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
     * Sets the value of field 'lNbrEmpOnCallExt1'.
     * 
     * @param lNbrEmpOnCallExt1 the value of field
     * 'lNbrEmpOnCallExt1'.
     */
    public void setLNbrEmpOnCallExt1(java.lang.String lNbrEmpOnCallExt1)
    {
        this._lNbrEmpOnCallExt1 = lNbrEmpOnCallExt1;
    } //-- void setLNbrEmpOnCallExt1(java.lang.String) 

    /**
     * Sets the value of field 'lNbrEmpOnCallExt2'.
     * 
     * @param lNbrEmpOnCallExt2 the value of field
     * 'lNbrEmpOnCallExt2'.
     */
    public void setLNbrEmpOnCallExt2(java.lang.String lNbrEmpOnCallExt2)
    {
        this._lNbrEmpOnCallExt2 = lNbrEmpOnCallExt2;
    } //-- void setLNbrEmpOnCallExt2(java.lang.String) 

    /**
     * Sets the value of field 'szCdEmpOnCallDesig'.
     * 
     * @param szCdEmpOnCallDesig the value of field
     * 'szCdEmpOnCallDesig'.
     */
    public void setSzCdEmpOnCallDesig(java.lang.String szCdEmpOnCallDesig)
    {
        this._szCdEmpOnCallDesig = szCdEmpOnCallDesig;
    } //-- void setSzCdEmpOnCallDesig(java.lang.String) 

    /**
     * Sets the value of field 'szCdOnCallProgram'.
     * 
     * @param szCdOnCallProgram the value of field
     * 'szCdOnCallProgram'.
     */
    public void setSzCdOnCallProgram(java.lang.String szCdOnCallProgram)
    {
        this._szCdOnCallProgram = szCdOnCallProgram;
    } //-- void setSzCdOnCallProgram(java.lang.String) 

    /**
     * Sets the value of field 'szCdScrDataAction'.
     * 
     * @param szCdScrDataAction the value of field
     * 'szCdScrDataAction'.
     */
    public void setSzCdScrDataAction(java.lang.String szCdScrDataAction)
    {
        this._szCdScrDataAction = szCdScrDataAction;
    } //-- void setSzCdScrDataAction(java.lang.String) 

    /**
     * Sets the value of field 'szCdTitle'.
     * 
     * @param szCdTitle the value of field 'szCdTitle'.
     */
    public void setSzCdTitle(java.lang.String szCdTitle)
    {
        this._szCdTitle = szCdTitle;
    } //-- void setSzCdTitle(java.lang.String) 

    /**
     * Sets the value of field 'szNbrEmpOnCallPhone1'.
     * 
     * @param szNbrEmpOnCallPhone1 the value of field
     * 'szNbrEmpOnCallPhone1'.
     */
    public void setSzNbrEmpOnCallPhone1(java.lang.String szNbrEmpOnCallPhone1)
    {
        this._szNbrEmpOnCallPhone1 = szNbrEmpOnCallPhone1;
    } //-- void setSzNbrEmpOnCallPhone1(java.lang.String) 

    /**
     * Sets the value of field 'szNbrEmpOnCallPhone2'.
     * 
     * @param szNbrEmpOnCallPhone2 the value of field
     * 'szNbrEmpOnCallPhone2'.
     */
    public void setSzNbrEmpOnCallPhone2(java.lang.String szNbrEmpOnCallPhone2)
    {
        this._szNbrEmpOnCallPhone2 = szNbrEmpOnCallPhone2;
    } //-- void setSzNbrEmpOnCallPhone2(java.lang.String) 

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
     * Sets the value of field 'ulIdEmpOnCallLink'.
     * 
     * @param ulIdEmpOnCallLink the value of field
     * 'ulIdEmpOnCallLink'.
     */
    public void setUlIdEmpOnCallLink(int ulIdEmpOnCallLink)
    {
        this._ulIdEmpOnCallLink = ulIdEmpOnCallLink;
        this._has_ulIdEmpOnCallLink = true;
    } //-- void setUlIdEmpOnCallLink(int) 

    /**
     * Sets the value of field 'ulIdOnCall'.
     * 
     * @param ulIdOnCall the value of field 'ulIdOnCall'.
     */
    public void setUlIdOnCall(int ulIdOnCall)
    {
        this._ulIdOnCall = ulIdOnCall;
        this._has_ulIdOnCall = true;
    } //-- void setUlIdOnCall(int) 

    /**
     * Sets the value of field 'ulIdPerson'.
     * 
     * @param ulIdPerson the value of field 'ulIdPerson'.
     */
    public void setUlIdPerson(int ulIdPerson)
    {
        this._ulIdPerson = ulIdPerson;
        this._has_ulIdPerson = true;
    } //-- void setUlIdPerson(int) 

    /**
     * Sets the value of field 'usNbrEmpOnCallCntctOrd'.
     * 
     * @param usNbrEmpOnCallCntctOrd the value of field
     * 'usNbrEmpOnCallCntctOrd'.
     */
    public void setUsNbrEmpOnCallCntctOrd(int usNbrEmpOnCallCntctOrd)
    {
        this._usNbrEmpOnCallCntctOrd = usNbrEmpOnCallCntctOrd;
        this._has_usNbrEmpOnCallCntctOrd = true;
    } //-- void setUsNbrEmpOnCallCntctOrd(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI unmarshal(java.io.Reader) 

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
