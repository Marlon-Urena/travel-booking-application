
package models.carrental;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vehicle_info",
    "rates",
    "images",
    "estimated_total"
})
public class Car {

    @JsonProperty("vehicle_info")
    private VehicleInfo vehicleInfo;
    @JsonProperty("rates")
    private List<Rate> rates = null;
    @JsonProperty("images")
    private List<Image> images = null;
    @JsonProperty("estimated_total")
    private EstimatedTotal estimatedTotal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("vehicle_info")
    public VehicleInfo getVehicleInfo() {
        return vehicleInfo;
    }

    @JsonProperty("vehicle_info")
    public void setVehicleInfo(VehicleInfo vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }

    @JsonProperty("rates")
    public List<Rate> getRates() {
        return rates;
    }

    @JsonProperty("rates")
    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    @JsonProperty("images")
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
    }

    @JsonProperty("estimated_total")
    public EstimatedTotal getEstimatedTotal() {
        return estimatedTotal;
    }

    @JsonProperty("estimated_total")
    public void setEstimatedTotal(EstimatedTotal estimatedTotal) {
        this.estimatedTotal = estimatedTotal;
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
        return new ToStringBuilder(this).append("vehicleInfo", vehicleInfo).append("rates", rates).append("images", images).append("estimatedTotal", estimatedTotal).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(images).append(rates).append(vehicleInfo).append(estimatedTotal).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Car) == false) {
            return false;
        }
        Car rhs = ((Car) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(images, rhs.images).append(rates, rhs.rates).append(vehicleInfo, rhs.vehicleInfo).append(estimatedTotal, rhs.estimatedTotal).isEquals();
    }

}
