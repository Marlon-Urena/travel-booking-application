
package models.flight;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "travel_class",
    "booking_code",
    "seats_remaining"
})
public class BookingInfo {

    @JsonProperty("travel_class")
    private String travelClass;
    @JsonProperty("booking_code")
    private String bookingCode;
    @JsonProperty("seats_remaining")
    private Integer seatsRemaining;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BookingInfo() {
    }

    /**
     * 
     * @param travelClass
     * @param seatsRemaining
     * @param bookingCode
     */
    public BookingInfo(String travelClass, String bookingCode, Integer seatsRemaining) {
        super();
        this.travelClass = travelClass;
        this.bookingCode = bookingCode;
        this.seatsRemaining = seatsRemaining;
    }

    @JsonProperty("travel_class")
    public String getTravelClass() {
        return travelClass;
    }

    @JsonProperty("travel_class")
    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    @JsonProperty("booking_code")
    public String getBookingCode() {
        return bookingCode;
    }

    @JsonProperty("booking_code")
    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    @JsonProperty("seats_remaining")
    public Integer getSeatsRemaining() {
        return seatsRemaining;
    }

    @JsonProperty("seats_remaining")
    public void setSeatsRemaining(Integer seatsRemaining) {
        this.seatsRemaining = seatsRemaining;
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
        return new ToStringBuilder(this).append("travelClass", travelClass).append("bookingCode", bookingCode).append("seatsRemaining", seatsRemaining).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(travelClass).append(additionalProperties).append(seatsRemaining).append(bookingCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BookingInfo) == false) {
            return false;
        }
        BookingInfo rhs = ((BookingInfo) other);
        return new EqualsBuilder().append(travelClass, rhs.travelClass).append(additionalProperties, rhs.additionalProperties).append(seatsRemaining, rhs.seatsRemaining).append(bookingCode, rhs.bookingCode).isEquals();
    }

}
