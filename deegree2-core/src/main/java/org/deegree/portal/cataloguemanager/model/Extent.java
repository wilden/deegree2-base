//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.12.16 at 05:01:18 PM GMT 
//


package org.deegree.portal.cataloguemanager.model;

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
 *       &lt;choice>
 *         &lt;element ref="{http://www.isotc211.org/2005/gmd}EX_Extent"/>
 *         &lt;element ref="{http://www.opengis.net/gml}TimePeriod"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "exExtent",
    "timePeriod"
})
@XmlRootElement(name = "extent")
public class Extent {

    @XmlElement(name = "EX_Extent")
    protected EXExtent exExtent;
    @XmlElement(name = "TimePeriod", namespace = "http://www.opengis.net/gml")
    protected TimePeriod timePeriod;

    /**
     * Gets the value of the exExtent property.
     * 
     * @return
     *     possible object is
     *     {@link EXExtent }
     *     
     */
    public EXExtent getEXExtent() {
        return exExtent;
    }

    /**
     * Sets the value of the exExtent property.
     * 
     * @param value
     *     allowed object is
     *     {@link EXExtent }
     *     
     */
    public void setEXExtent(EXExtent value) {
        this.exExtent = value;
    }

    /**
     * Gets the value of the timePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriod }
     *     
     */
    public TimePeriod getTimePeriod() {
        return timePeriod;
    }

    /**
     * Sets the value of the timePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriod }
     *     
     */
    public void setTimePeriod(TimePeriod value) {
        this.timePeriod = value;
    }

}