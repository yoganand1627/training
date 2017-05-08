
package gov.ga.gta.eiss.shines.crs.crsscreening;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="szLName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InIrnClientId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InCrsReturnValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="szFName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="szMName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uDob" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="szSexCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uSsn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="szRaceCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="szBInNtvAmerican" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="szBInAsian" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="szBInAfAmerican" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="szBInPcfcislander" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="szBInWhite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="szRacfid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="szEthnCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="szSuffix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uNoRows" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ulSsnErrInd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "szLName",
    "inIrnClientId",
    "inCrsReturnValue",
    "szFName",
    "szMName",
    "uDob",
    "szSexCode",
    "uSsn",
    "szRaceCode",
    "szBInNtvAmerican",
    "szBInAsian",
    "szBInAfAmerican",
    "szBInPcfcislander",
    "szBInWhite",
    "szRacfid",
    "szEthnCode",
    "szSuffix",
    "uNoRows",
    "ulSsnErrInd"
})
@XmlRootElement(name = "ShinesScreeningResponseList")
public class ShinesScreeningResponseList {

    @XmlElement(required = true, nillable = true)
    protected String szLName;
    @XmlElement(name = "InIrnClientId", required = true, nillable = true)
    protected String inIrnClientId;
    @XmlElement(name = "InCrsReturnValue", required = true, nillable = true)
    protected String inCrsReturnValue;
    @XmlElement(required = true, nillable = true)
    protected String szFName;
    @XmlElement(required = true, nillable = true)
    protected String szMName;
    @XmlElement(required = true, nillable = true)
    protected String uDob;
    @XmlElement(required = true, nillable = true)
    protected String szSexCode;
    @XmlElement(required = true, nillable = true)
    protected String uSsn;
    @XmlElement(required = true, nillable = true)
    protected String szRaceCode;
    @XmlElement(required = true, nillable = true)
    protected String szBInNtvAmerican;
    @XmlElement(required = true, nillable = true)
    protected String szBInAsian;
    @XmlElement(required = true, nillable = true)
    protected String szBInAfAmerican;
    @XmlElement(required = true, nillable = true)
    protected String szBInPcfcislander;
    @XmlElement(required = true, nillable = true)
    protected String szBInWhite;
    @XmlElement(required = true, nillable = true)
    protected String szRacfid;
    @XmlElement(required = true, nillable = true)
    protected String szEthnCode;
    @XmlElement(required = true, nillable = true)
    protected String szSuffix;
    @XmlElement(required = true, nillable = true)
    protected String uNoRows;
    @XmlElement(required = true, nillable = true)
    protected String ulSsnErrInd;

    /**
     * Gets the value of the szLName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSzLName() {
        return szLName;
    }

    /**
     * Sets the value of the szLName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSzLName(String value) {
        this.szLName = value;
    }

    /**
     * Gets the value of the inIrnClientId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInIrnClientId() {
        return inIrnClientId;
    }

    /**
     * Sets the value of the inIrnClientId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInIrnClientId(String value) {
        this.inIrnClientId = value;
    }

    /**
     * Gets the value of the inCrsReturnValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInCrsReturnValue() {
        return inCrsReturnValue;
    }

    /**
     * Sets the value of the inCrsReturnValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInCrsReturnValue(String value) {
        this.inCrsReturnValue = value;
    }

    /**
     * Gets the value of the szFName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSzFName() {
        return szFName;
    }

    /**
     * Sets the value of the szFName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSzFName(String value) {
        this.szFName = value;
    }

    /**
     * Gets the value of the szMName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSzMName() {
        return szMName;
    }

    /**
     * Sets the value of the szMName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSzMName(String value) {
        this.szMName = value;
    }

    /**
     * Gets the value of the uDob property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUDob() {
        return uDob;
    }

    /**
     * Sets the value of the uDob property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUDob(String value) {
        this.uDob = value;
    }

    /**
     * Gets the value of the szSexCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSzSexCode() {
        return szSexCode;
    }

    /**
     * Sets the value of the szSexCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSzSexCode(String value) {
        this.szSexCode = value;
    }

    /**
     * Gets the value of the uSsn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSsn() {
        return uSsn;
    }

    /**
     * Sets the value of the uSsn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSsn(String value) {
        this.uSsn = value;
    }

    /**
     * Gets the value of the szRaceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSzRaceCode() {
        return szRaceCode;
    }

    /**
     * Sets the value of the szRaceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSzRaceCode(String value) {
        this.szRaceCode = value;
    }

    /**
     * Gets the value of the szBInNtvAmerican property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSzBInNtvAmerican() {
        return szBInNtvAmerican;
    }

    /**
     * Sets the value of the szBInNtvAmerican property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSzBInNtvAmerican(String value) {
        this.szBInNtvAmerican = value;
    }

    /**
     * Gets the value of the szBInAsian property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSzBInAsian() {
        return szBInAsian;
    }

    /**
     * Sets the value of the szBInAsian property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSzBInAsian(String value) {
        this.szBInAsian = value;
    }

    /**
     * Gets the value of the szBInAfAmerican property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSzBInAfAmerican() {
        return szBInAfAmerican;
    }

    /**
     * Sets the value of the szBInAfAmerican property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSzBInAfAmerican(String value) {
        this.szBInAfAmerican = value;
    }

    /**
     * Gets the value of the szBInPcfcislander property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSzBInPcfcislander() {
        return szBInPcfcislander;
    }

    /**
     * Sets the value of the szBInPcfcislander property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSzBInPcfcislander(String value) {
        this.szBInPcfcislander = value;
    }

    /**
     * Gets the value of the szBInWhite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSzBInWhite() {
        return szBInWhite;
    }

    /**
     * Sets the value of the szBInWhite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSzBInWhite(String value) {
        this.szBInWhite = value;
    }

    /**
     * Gets the value of the szRacfid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSzRacfid() {
        return szRacfid;
    }

    /**
     * Sets the value of the szRacfid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSzRacfid(String value) {
        this.szRacfid = value;
    }

    /**
     * Gets the value of the szEthnCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSzEthnCode() {
        return szEthnCode;
    }

    /**
     * Sets the value of the szEthnCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSzEthnCode(String value) {
        this.szEthnCode = value;
    }

    /**
     * Gets the value of the szSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSzSuffix() {
        return szSuffix;
    }

    /**
     * Sets the value of the szSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSzSuffix(String value) {
        this.szSuffix = value;
    }

    /**
     * Gets the value of the uNoRows property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNoRows() {
        return uNoRows;
    }

    /**
     * Sets the value of the uNoRows property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNoRows(String value) {
        this.uNoRows = value;
    }

    /**
     * Gets the value of the ulSsnErrInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUlSsnErrInd() {
        return ulSsnErrInd;
    }

    /**
     * Sets the value of the ulSsnErrInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUlSsnErrInd(String value) {
        this.ulSsnErrInd = value;
    }

}
