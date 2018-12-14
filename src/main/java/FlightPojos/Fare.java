
package FlightPojos;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "total_price",
    "price_per_adult",
    "price_per_child",
    "price_per_infant",
    "restrictions"
})
public class Fare {

    @JsonProperty("total_price")
    private String totalPrice;
    @JsonProperty("price_per_adult")
    private PricePerAdult pricePerAdult;
    @JsonProperty("price_per_child")
    private PricePerChild pricePerChild;
    @JsonProperty("price_per_infant")
    private PricePerInfant pricePerInfant;
    @JsonProperty("restrictions")
    private Restrictions restrictions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Fare() {
    }

    /**
     * 
     * @param restrictions
     * @param pricePerChild
     * @param pricePerInfant
     * @param pricePerAdult
     * @param totalPrice
     */
    public Fare(String totalPrice, PricePerAdult pricePerAdult, PricePerChild pricePerChild, PricePerInfant pricePerInfant, Restrictions restrictions) {
        super();
        this.totalPrice = totalPrice;
        this.pricePerAdult = pricePerAdult;
        this.pricePerChild = pricePerChild;
        this.pricePerInfant = pricePerInfant;
        this.restrictions = restrictions;
    }

    @JsonProperty("total_price")
    public String getTotalPrice() {
        return totalPrice;
    }

    @JsonProperty("total_price")
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    @JsonProperty("price_per_adult")
    public PricePerAdult getPricePerAdult() {
        return pricePerAdult;
    }

    @JsonProperty("price_per_adult")
    public void setPricePerAdult(PricePerAdult pricePerAdult) {
        this.pricePerAdult = pricePerAdult;
    }

    @JsonProperty("price_per_child")
    public PricePerChild getPricePerChild() {
        return pricePerChild;
    }

    @JsonProperty("price_per_child")
    public void setPricePerChild(PricePerChild pricePerChild) {
        this.pricePerChild = pricePerChild;
    }

    @JsonProperty("price_per_infant")
    public PricePerInfant getPricePerInfant() {
        return pricePerInfant;
    }

    @JsonProperty("price_per_infant")
    public void setPricePerInfant(PricePerInfant pricePerInfant) {
        this.pricePerInfant = pricePerInfant;
    }

    @JsonProperty("restrictions")
    public Restrictions getRestrictions() {
        return restrictions;
    }

    @JsonProperty("restrictions")
    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("totalPrice", totalPrice).append("pricePerAdult", pricePerAdult).append("pricePerChild", pricePerChild).append("pricePerInfant", pricePerInfant).append("restrictions", restrictions).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(restrictions).append(pricePerChild).append(additionalProperties).append(pricePerInfant).append(pricePerAdult).append(totalPrice).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Fare) == false) {
            return false;
        }
        Fare rhs = ((Fare) other);
        return new EqualsBuilder().append(restrictions, rhs.restrictions).append(pricePerChild, rhs.pricePerChild).append(additionalProperties, rhs.additionalProperties).append(pricePerInfant, rhs.pricePerInfant).append(pricePerAdult, rhs.pricePerAdult).append(totalPrice, rhs.totalPrice).isEquals();
    }

}
