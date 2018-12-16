
package models.flight;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "total_fare",
    "tax"
})
public class PricePerChild {

    @JsonProperty("total_fare")
    private String totalFare;
    @JsonProperty("tax")
    private String tax;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PricePerChild() {
    }

    /**
     * 
     * @param totalFare
     * @param tax
     */
    public PricePerChild(String totalFare, String tax) {
        super();
        this.totalFare = totalFare;
        this.tax = tax;
    }

    @JsonProperty("total_fare")
    public String getTotalFare() {
        return totalFare;
    }

    @JsonProperty("total_fare")
    public void setTotalFare(String totalFare) {
        this.totalFare = totalFare;
    }

    @JsonProperty("tax")
    public String getTax() {
        return tax;
    }

    @JsonProperty("tax")
    public void setTax(String tax) {
        this.tax = tax;
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
        StringBuilder sb = new StringBuilder();
        sb.append(totalFare);
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(totalFare).append(tax).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PricePerChild) == false) {
            return false;
        }
        PricePerChild rhs = ((PricePerChild) other);
        return new EqualsBuilder().append(totalFare, rhs.totalFare).append(tax, rhs.tax).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
