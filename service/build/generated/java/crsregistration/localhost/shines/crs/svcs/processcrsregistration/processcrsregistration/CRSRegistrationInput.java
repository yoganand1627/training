
package localhost.shines.crs.svcs.processcrsregistration.processcrsregistration;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;
import processcrsregistration.svcs.crs.shines.ProcessCRSRegistration;


/**
 * <p>Java class for CRSRegistrationInput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CRSRegistrationInput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{SHINES.CRS.Svcs.processCRSRegistration}processCRSRegistration"/>
 *         &lt;any/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CRSRegistrationInput", propOrder = {
    "processCRSRegistration",
    "any"
})
public class CRSRegistrationInput {

    @XmlElement(namespace = "SHINES.CRS.Svcs.processCRSRegistration", required = true)
    protected ProcessCRSRegistration processCRSRegistration;
    @XmlAnyElement(lax = true)
    protected Object any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the processCRSRegistration property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessCRSRegistration }
     *     
     */
    public ProcessCRSRegistration getProcessCRSRegistration() {
        return processCRSRegistration;
    }

    /**
     * Sets the value of the processCRSRegistration property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessCRSRegistration }
     *     
     */
    public void setProcessCRSRegistration(ProcessCRSRegistration value) {
        this.processCRSRegistration = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     {@link Element }
     *     
     */
    public Object getAny() {
        return any;
    }

    /**
     * Sets the value of the any property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     {@link Element }
     *     
     */
    public void setAny(Object value) {
        this.any = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
