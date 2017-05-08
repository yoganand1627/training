
package processcrsregistration.svcs.crs.shines;

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
 *         &lt;element name="client_first_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="client_last_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="client_mid_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="client_suf_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="client_race_cd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clint_native_american" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="client_asian" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="client_african_american" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="client_pacific_islander" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="client_white" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="client_ethnicity_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="client_sex_cd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="client_ssn_num" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clint_dob_dt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clint_dob_ver_cd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clint_city_cd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias_first_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias_last_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias_mid_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias_suf_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias_race_cd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias_native_american" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias_asian" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias_african_american" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias_pacific_islander" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias_white" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias_ethnicity_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias_sex_cd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias_ssn_num_0" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias_ssn_num_1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias_ssn_num_2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias_ssn_num_3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias_ssn_num_4" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UserID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cycleDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MaritalStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="primaryLanguage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="birthStateCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="birthcityName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clientIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="returnValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="benifitMonth" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "clientFirstName",
    "clientLastName",
    "clientMidName",
    "clientSufName",
    "clientRaceCd",
    "clintNativeAmerican",
    "clientAsian",
    "clientAfricanAmerican",
    "clientPacificIslander",
    "clientWhite",
    "clientEthnicityCode",
    "clientSexCd",
    "clientSsnNum",
    "clintDobDt",
    "clintDobVerCd",
    "clintCityCd",
    "aliasFirstName",
    "aliasLastName",
    "aliasMidName",
    "aliasSufName",
    "aliasRaceCd",
    "aliasNativeAmerican",
    "aliasAsian",
    "aliasAfricanAmerican",
    "aliasPacificIslander",
    "aliasWhite",
    "aliasEthnicityCode",
    "aliasSexCd",
    "aliasSsnNum0",
    "aliasSsnNum1",
    "aliasSsnNum2",
    "aliasSsnNum3",
    "aliasSsnNum4",
    "userID",
    "cycleDate",
    "maritalStatus",
    "primaryLanguage",
    "birthStateCode",
    "birthcityName",
    "clientIdentifier",
    "returnValue",
    "benifitMonth"
})
@XmlRootElement(name = "processCRSRegistration")
public class ProcessCRSRegistration {

    @XmlElement(name = "client_first_name", required = true, nillable = true)
    protected String clientFirstName;
    @XmlElement(name = "client_last_name", required = true, nillable = true)
    protected String clientLastName;
    @XmlElement(name = "client_mid_name", required = true, nillable = true)
    protected String clientMidName;
    @XmlElement(name = "client_suf_name", required = true, nillable = true)
    protected String clientSufName;
    @XmlElement(name = "client_race_cd", required = true, nillable = true)
    protected String clientRaceCd;
    @XmlElement(name = "clint_native_american", required = true, nillable = true)
    protected String clintNativeAmerican;
    @XmlElement(name = "client_asian", required = true, nillable = true)
    protected String clientAsian;
    @XmlElement(name = "client_african_american", required = true, nillable = true)
    protected String clientAfricanAmerican;
    @XmlElement(name = "client_pacific_islander", required = true, nillable = true)
    protected String clientPacificIslander;
    @XmlElement(name = "client_white", required = true, nillable = true)
    protected String clientWhite;
    @XmlElement(name = "client_ethnicity_code", required = true, nillable = true)
    protected String clientEthnicityCode;
    @XmlElement(name = "client_sex_cd", required = true, nillable = true)
    protected String clientSexCd;
    @XmlElement(name = "client_ssn_num", required = true, nillable = true)
    protected String clientSsnNum;
    @XmlElement(name = "clint_dob_dt", required = true, nillable = true)
    protected String clintDobDt;
    @XmlElement(name = "clint_dob_ver_cd", required = true, nillable = true)
    protected String clintDobVerCd;
    @XmlElement(name = "clint_city_cd", required = true, nillable = true)
    protected String clintCityCd;
    @XmlElement(name = "Alias_first_name", required = true, nillable = true)
    protected String aliasFirstName;
    @XmlElement(name = "Alias_last_name", required = true, nillable = true)
    protected String aliasLastName;
    @XmlElement(name = "Alias_mid_name", required = true, nillable = true)
    protected String aliasMidName;
    @XmlElement(name = "Alias_suf_name", required = true, nillable = true)
    protected String aliasSufName;
    @XmlElement(name = "Alias_race_cd", required = true, nillable = true)
    protected String aliasRaceCd;
    @XmlElement(name = "Alias_native_american", required = true, nillable = true)
    protected String aliasNativeAmerican;
    @XmlElement(name = "Alias_asian", required = true, nillable = true)
    protected String aliasAsian;
    @XmlElement(name = "Alias_african_american", required = true, nillable = true)
    protected String aliasAfricanAmerican;
    @XmlElement(name = "Alias_pacific_islander", required = true, nillable = true)
    protected String aliasPacificIslander;
    @XmlElement(name = "Alias_white", required = true, nillable = true)
    protected String aliasWhite;
    @XmlElement(name = "Alias_ethnicity_code", required = true, nillable = true)
    protected String aliasEthnicityCode;
    @XmlElement(name = "Alias_sex_cd", required = true, nillable = true)
    protected String aliasSexCd;
    @XmlElement(name = "Alias_ssn_num_0", required = true, nillable = true)
    protected String aliasSsnNum0;
    @XmlElement(name = "Alias_ssn_num_1", required = true, nillable = true)
    protected String aliasSsnNum1;
    @XmlElement(name = "Alias_ssn_num_2", required = true, nillable = true)
    protected String aliasSsnNum2;
    @XmlElement(name = "Alias_ssn_num_3", required = true, nillable = true)
    protected String aliasSsnNum3;
    @XmlElement(name = "Alias_ssn_num_4", required = true, nillable = true)
    protected String aliasSsnNum4;
    @XmlElement(name = "UserID", required = true, nillable = true)
    protected String userID;
    @XmlElement(required = true, nillable = true)
    protected String cycleDate;
    @XmlElement(name = "MaritalStatus", required = true, nillable = true)
    protected String maritalStatus;
    @XmlElement(required = true, nillable = true)
    protected String primaryLanguage;
    @XmlElement(required = true, nillable = true)
    protected String birthStateCode;
    @XmlElement(required = true, nillable = true)
    protected String birthcityName;
    @XmlElement(required = true, nillable = true)
    protected String clientIdentifier;
    @XmlElement(required = true, nillable = true)
    protected String returnValue;
    @XmlElement(required = true, nillable = true)
    protected String benifitMonth;

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
     * Gets the value of the clientMidName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientMidName() {
        return clientMidName;
    }

    /**
     * Sets the value of the clientMidName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientMidName(String value) {
        this.clientMidName = value;
    }

    /**
     * Gets the value of the clientSufName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientSufName() {
        return clientSufName;
    }

    /**
     * Sets the value of the clientSufName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientSufName(String value) {
        this.clientSufName = value;
    }

    /**
     * Gets the value of the clientRaceCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientRaceCd() {
        return clientRaceCd;
    }

    /**
     * Sets the value of the clientRaceCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientRaceCd(String value) {
        this.clientRaceCd = value;
    }

    /**
     * Gets the value of the clintNativeAmerican property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClintNativeAmerican() {
        return clintNativeAmerican;
    }

    /**
     * Sets the value of the clintNativeAmerican property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClintNativeAmerican(String value) {
        this.clintNativeAmerican = value;
    }

    /**
     * Gets the value of the clientAsian property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientAsian() {
        return clientAsian;
    }

    /**
     * Sets the value of the clientAsian property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientAsian(String value) {
        this.clientAsian = value;
    }

    /**
     * Gets the value of the clientAfricanAmerican property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientAfricanAmerican() {
        return clientAfricanAmerican;
    }

    /**
     * Sets the value of the clientAfricanAmerican property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientAfricanAmerican(String value) {
        this.clientAfricanAmerican = value;
    }

    /**
     * Gets the value of the clientPacificIslander property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientPacificIslander() {
        return clientPacificIslander;
    }

    /**
     * Sets the value of the clientPacificIslander property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientPacificIslander(String value) {
        this.clientPacificIslander = value;
    }

    /**
     * Gets the value of the clientWhite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientWhite() {
        return clientWhite;
    }

    /**
     * Sets the value of the clientWhite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientWhite(String value) {
        this.clientWhite = value;
    }

    /**
     * Gets the value of the clientEthnicityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientEthnicityCode() {
        return clientEthnicityCode;
    }

    /**
     * Sets the value of the clientEthnicityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientEthnicityCode(String value) {
        this.clientEthnicityCode = value;
    }

    /**
     * Gets the value of the clientSexCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientSexCd() {
        return clientSexCd;
    }

    /**
     * Sets the value of the clientSexCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientSexCd(String value) {
        this.clientSexCd = value;
    }

    /**
     * Gets the value of the clientSsnNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientSsnNum() {
        return clientSsnNum;
    }

    /**
     * Sets the value of the clientSsnNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientSsnNum(String value) {
        this.clientSsnNum = value;
    }

    /**
     * Gets the value of the clintDobDt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClintDobDt() {
        return clintDobDt;
    }

    /**
     * Sets the value of the clintDobDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClintDobDt(String value) {
        this.clintDobDt = value;
    }

    /**
     * Gets the value of the clintDobVerCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClintDobVerCd() {
        return clintDobVerCd;
    }

    /**
     * Sets the value of the clintDobVerCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClintDobVerCd(String value) {
        this.clintDobVerCd = value;
    }

    /**
     * Gets the value of the clintCityCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClintCityCd() {
        return clintCityCd;
    }

    /**
     * Sets the value of the clintCityCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClintCityCd(String value) {
        this.clintCityCd = value;
    }

    /**
     * Gets the value of the aliasFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasFirstName() {
        return aliasFirstName;
    }

    /**
     * Sets the value of the aliasFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasFirstName(String value) {
        this.aliasFirstName = value;
    }

    /**
     * Gets the value of the aliasLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasLastName() {
        return aliasLastName;
    }

    /**
     * Sets the value of the aliasLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasLastName(String value) {
        this.aliasLastName = value;
    }

    /**
     * Gets the value of the aliasMidName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasMidName() {
        return aliasMidName;
    }

    /**
     * Sets the value of the aliasMidName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasMidName(String value) {
        this.aliasMidName = value;
    }

    /**
     * Gets the value of the aliasSufName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasSufName() {
        return aliasSufName;
    }

    /**
     * Sets the value of the aliasSufName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasSufName(String value) {
        this.aliasSufName = value;
    }

    /**
     * Gets the value of the aliasRaceCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasRaceCd() {
        return aliasRaceCd;
    }

    /**
     * Sets the value of the aliasRaceCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasRaceCd(String value) {
        this.aliasRaceCd = value;
    }

    /**
     * Gets the value of the aliasNativeAmerican property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasNativeAmerican() {
        return aliasNativeAmerican;
    }

    /**
     * Sets the value of the aliasNativeAmerican property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasNativeAmerican(String value) {
        this.aliasNativeAmerican = value;
    }

    /**
     * Gets the value of the aliasAsian property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasAsian() {
        return aliasAsian;
    }

    /**
     * Sets the value of the aliasAsian property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasAsian(String value) {
        this.aliasAsian = value;
    }

    /**
     * Gets the value of the aliasAfricanAmerican property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasAfricanAmerican() {
        return aliasAfricanAmerican;
    }

    /**
     * Sets the value of the aliasAfricanAmerican property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasAfricanAmerican(String value) {
        this.aliasAfricanAmerican = value;
    }

    /**
     * Gets the value of the aliasPacificIslander property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasPacificIslander() {
        return aliasPacificIslander;
    }

    /**
     * Sets the value of the aliasPacificIslander property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasPacificIslander(String value) {
        this.aliasPacificIslander = value;
    }

    /**
     * Gets the value of the aliasWhite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasWhite() {
        return aliasWhite;
    }

    /**
     * Sets the value of the aliasWhite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasWhite(String value) {
        this.aliasWhite = value;
    }

    /**
     * Gets the value of the aliasEthnicityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasEthnicityCode() {
        return aliasEthnicityCode;
    }

    /**
     * Sets the value of the aliasEthnicityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasEthnicityCode(String value) {
        this.aliasEthnicityCode = value;
    }

    /**
     * Gets the value of the aliasSexCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasSexCd() {
        return aliasSexCd;
    }

    /**
     * Sets the value of the aliasSexCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasSexCd(String value) {
        this.aliasSexCd = value;
    }

    /**
     * Gets the value of the aliasSsnNum0 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasSsnNum0() {
        return aliasSsnNum0;
    }

    /**
     * Sets the value of the aliasSsnNum0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasSsnNum0(String value) {
        this.aliasSsnNum0 = value;
    }

    /**
     * Gets the value of the aliasSsnNum1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasSsnNum1() {
        return aliasSsnNum1;
    }

    /**
     * Sets the value of the aliasSsnNum1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasSsnNum1(String value) {
        this.aliasSsnNum1 = value;
    }

    /**
     * Gets the value of the aliasSsnNum2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasSsnNum2() {
        return aliasSsnNum2;
    }

    /**
     * Sets the value of the aliasSsnNum2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasSsnNum2(String value) {
        this.aliasSsnNum2 = value;
    }

    /**
     * Gets the value of the aliasSsnNum3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasSsnNum3() {
        return aliasSsnNum3;
    }

    /**
     * Sets the value of the aliasSsnNum3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasSsnNum3(String value) {
        this.aliasSsnNum3 = value;
    }

    /**
     * Gets the value of the aliasSsnNum4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasSsnNum4() {
        return aliasSsnNum4;
    }

    /**
     * Sets the value of the aliasSsnNum4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasSsnNum4(String value) {
        this.aliasSsnNum4 = value;
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
     * Gets the value of the cycleDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCycleDate() {
        return cycleDate;
    }

    /**
     * Sets the value of the cycleDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCycleDate(String value) {
        this.cycleDate = value;
    }

    /**
     * Gets the value of the maritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Sets the value of the maritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaritalStatus(String value) {
        this.maritalStatus = value;
    }

    /**
     * Gets the value of the primaryLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

    /**
     * Sets the value of the primaryLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryLanguage(String value) {
        this.primaryLanguage = value;
    }

    /**
     * Gets the value of the birthStateCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthStateCode() {
        return birthStateCode;
    }

    /**
     * Sets the value of the birthStateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthStateCode(String value) {
        this.birthStateCode = value;
    }

    /**
     * Gets the value of the birthcityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthcityName() {
        return birthcityName;
    }

    /**
     * Sets the value of the birthcityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthcityName(String value) {
        this.birthcityName = value;
    }

    /**
     * Gets the value of the clientIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientIdentifier() {
        return clientIdentifier;
    }

    /**
     * Sets the value of the clientIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientIdentifier(String value) {
        this.clientIdentifier = value;
    }

    /**
     * Gets the value of the returnValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnValue() {
        return returnValue;
    }

    /**
     * Sets the value of the returnValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnValue(String value) {
        this.returnValue = value;
    }

    /**
     * Gets the value of the benifitMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBenifitMonth() {
        return benifitMonth;
    }

    /**
     * Sets the value of the benifitMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBenifitMonth(String value) {
        this.benifitMonth = value;
    }

}
