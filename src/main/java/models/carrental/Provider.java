
package models.carrental;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "company_code",
    "company_name"
})
public class Provider {

    @JsonProperty("company_code")
    private String companyCode;
    @JsonProperty("company_name")
    private String companyName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("company_code")
    public String getCompanyCode() {
        return companyCode;
    }

    @JsonProperty("company_code")
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @JsonProperty("company_name")
    public String getCompanyName() {
        return companyName;
    }

    @JsonProperty("company_name")
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
        return new ToStringBuilder(this).append("companyCode", companyCode).append("companyName", companyName).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(companyName).append(companyCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Provider) == false) {
            return false;
        }
        Provider rhs = ((Provider) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(companyName, rhs.companyName).append(companyCode, rhs.companyCode).isEquals();
    }

}
