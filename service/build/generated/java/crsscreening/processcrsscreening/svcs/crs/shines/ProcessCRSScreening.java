
package processcrsscreening.svcs.crs.shines;

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
 *         &lt;element name="clientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clientLastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clientMiddleName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clientFirstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clientSuffix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clientSSN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clientdateOfBirth" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clientSex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MainframeRACFID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UserID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="africanAmerican" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="white" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="asian" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pacificislander" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AmericanIndian" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ethnicity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ResultsreturnedfromCRS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="returnCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "clientID",
    "clientLastName",
    "clientMiddleName",
    "clientFirstName",
    "clientSuffix",
    "clientSSN",
    "clientdateOfBirth",
    "clientSex",
    "mainframeRACFID",
    "userID",
    "africanAmerican",
    "white",
    "asian",
    "pacificislander",
    "americanIndian",
    "ethnicity",
    "resultsreturnedfromCRS",
    "returnCode"
})
@XmlRootElement(name = "processCRSScreening")
public class ProcessCRSScreening {

    @XmlElement(required = true, nillable = true)
    protected String clientID;
    @XmlElement(required = true, nillable = true)
    protected String clientLastName;
    @XmlElement(required = true, nillable = true)
    protected String clientMiddleName;
    @XmlElement(required = true, nillable = true)
    protected String clientFirstName;
    @XmlElement(required = true, nillable = true)
    protected String clientSuffix;
    @XmlElement(required = true, nillable = true)
    protected String clientSSN;
    @XmlElement(required = true, nillable = true)
    protected String clientdateOfBirth;
    @XmlElement(required = true, nillable = true)
    protected String clientSex;
    @XmlElement(name = "MainframeRACFID", required = true, nillable = true)
    protected String mainframeRACFID;
    @XmlElement(name = "UserID", required = true, nillable = true)
    protected String userID;
    @XmlElement(required = true, nillable = true)
    protected String africanAmerican;
    @XmlElement(required = true, nillable = true)
    protected String white;
    @XmlElement(required = true, nillable = true)
    protected String asian;
    @XmlElement(required = true, nillable = true)
    protected String pacificislander;
    @XmlElement(name = "AmericanIndian", required = true, nillable = true)
    protected String americanIndian;
    @XmlElement(required = true, nillable = true)
    protected String ethnicity;
    @XmlElement(name = "ResultsreturnedfromCRS", required = true, nillable = true)
    protected String resultsreturnedfromCRS;
    @XmlElement(required = true, nillable = true)
    protected String returnCode;

    /**
     * Gets the value of the clientID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientID() {
        return clientID;
    }

    /**
     * Sets the value of the clientID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientID(String value) {
        this.clientID = value;
    }

    /**
     * Gets the value of the clientLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientLastName() {
        return clientLastName;
    }

    /**
     * Sets the value of the clientLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientLastName(String value) {
        this.clientLastName = value;
    }

    /**
     * Gets the value of the clientMiddleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientMiddleName() {
        return clientMiddleName;
    }

    /**
     * Sets the value of the clientMiddleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientMiddleName(String value) {
        this.clientMiddleName = value;
    }

    /**
     * Gets the value of the clientFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientFirstName() {
        return clientFirstName;
    }

    /**
     * Sets the value of the clientFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientFirstName(String value) {
        this.clientFirstName = value;
    }

    /**
     * Gets the value of the clientSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientSuffix() {
        return clientSuffix;
    }

    /**
     * Sets the value of the clientSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientSuffix(String value) {
        this.clientSuffix = value;
    }

    /**
     * Gets the value of the clientSSN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientSSN() {
        return clientSSN;
    }

    /**
     * Sets the value of the clientSSN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientSSN(String value) {
        this.clientSSN = value;
    }

    /**
     * Gets the value of the clientdateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientdateOfBirth() {
        return clientdateOfBirth;
    }

    /**
     * Sets the value of the clientdateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientdateOfBirth(String value) {
        this.clientdateOfBirth = value;
    }

    /**
     * Gets the value of the clientSex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientSex() {
        return clientSex;
    }

    /**
     * Sets the value of the clientSex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientSex(String value) {
        this.clientSex = value;
    }

    /**
     * Gets the value of the mainframeRACFID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainframeRACFID() {
        return mainframeRACFID;
    }

    /**
     * Sets the value of the mainframeRACFID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainframeRACFID(String value) {
        this.mainframeRACFID = value;
    }

    /**
     * Gets the value of the userID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID(String value) {
        this.userID = value;
    }

    /**
     * Gets the value of the africanAmerican property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAfricanAmerican() {
        return africanAmerican;
    }

    /**
     * Sets the value of the africanAmerican property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAfricanAmerican(String value) {
        this.africanAmerican = value;
    }

    /**
     * Gets the value of the white property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWhite() {
        return white;
    }

    /**
     * Sets the value of the white property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWhite(String value) {
        this.white = value;
    }

    /**
     * Gets the value of the asian property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsian() {
        return asian;
    }

    /**
     * Sets the value of the asian property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsian(String value) {
        this.asian = value;
    }

    /**
     * Gets the value of the pacificislander property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPacificislander() {
        return pacificislander;
    }

    /**
     * Sets the value of the pacificislander property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPacificislander(String value) {
        this.pacificislander = value;
    }

    /**
     * Gets the value of the americanIndian property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmericanIndian() {
        return americanIndian;
    }

    /**
     * Sets the value of the americanIndian property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmericanIndian(String value) {
        this.americanIndian = value;
    }

    /**
     * Gets the value of the ethnicity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEthnicity() {
        return ethnicity;
    }

    /**
     * Sets the value of the ethnicity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEthnicity(String value) {
        this.ethnicity = value;
    }

    /**
     * Gets the value of the resultsreturnedfromCRS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultsreturnedfromCRS() {
        return resultsreturnedfromCRS;
    }

    /**
     * Sets the value of the resultsreturnedfromCRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultsreturnedfromCRS(String value) {
        this.resultsreturnedfromCRS = value;
    }

    /**
     * Gets the value of the returnCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * Sets the value of the returnCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnCode(String value) {
        this.returnCode = value;
    }

}
