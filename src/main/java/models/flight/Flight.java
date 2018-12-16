
package models.flight;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "departs_at",
    "arrives_at",
    "origin",
    "destination",
    "marketing_airline",
    "operating_airline",
    "flight_number",
    "aircraft",
    "booking_info"
})
public class Flight {

    @JsonProperty("departs_at")
    private String departsAt;
    @JsonProperty("arrives_at")
    private String arrivesAt;
    @JsonProperty("origin")
    private Origin origin;
    @JsonProperty("destination")
    private Destination destination;
    @JsonProperty("marketing_airline")
    private String marketingAirline;
    @JsonProperty("operating_airline")
    private String operatingAirline;
    @JsonProperty("flight_number")
    private String flightNumber;
    @JsonProperty("aircraft")
    private String aircraft;
    @JsonProperty("booking_info")
    private BookingInfo bookingInfo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Flight() {
    }

    /**
     *
     * @param departsAt
     * @param arrivesAt
     * @param bookingInfo
     * @param aircraft
     * @param origin
     * @param flightNumber
     * @param operatingAirline
     * @param marketingAirline
     * @param destination
     */
    public Flight(String departsAt, String arrivesAt, Origin origin, Destination destination, String marketingAirline, String operatingAirline, String flightNumber, String aircraft, BookingInfo bookingInfo) {
        super();
        this.departsAt = departsAt;
        this.arrivesAt = arrivesAt;
        this.origin = origin;
        this.destination = destination;
        this.marketingAirline = marketingAirline;
        this.operatingAirline = operatingAirline;
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.bookingInfo = bookingInfo;
    }

    @JsonProperty("departs_at")
    public String getDepartsAt() {
        return departsAt;
    }

    @JsonProperty("departs_at")
    public void setDepartsAt(String departsAt) {
        this.departsAt = departsAt;
    }

    @JsonProperty("arrives_at")
    public String getArrivesAt() {
        return arrivesAt;
    }

    @JsonProperty("arrives_at")
    public void setArrivesAt(String arrivesAt) {
        this.arrivesAt = arrivesAt;
    }

    @JsonProperty("origin")
    public Origin getOrigin() {
        return origin;
    }

    @JsonProperty("origin")
    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    @JsonProperty("destination")
    public Destination getDestination() {
        return destination;
    }

    @JsonProperty("destination")
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    @JsonProperty("marketing_airline")
    public String getMarketingAirline() {
        return marketingAirline;
    }

    @JsonProperty("marketing_airline")
    public void setMarketingAirline(String marketingAirline) {
        this.marketingAirline = marketingAirline;
    }

    @JsonProperty("operating_airline")
    public String getOperatingAirline() {
        return operatingAirline;
    }

    @JsonProperty("operating_airline")
    public void setOperatingAirline(String operatingAirline) {
        this.operatingAirline = operatingAirline;
    }

    @JsonProperty("flight_number")
    public String getFlightNumber() {
        return flightNumber;
    }

    @JsonProperty("flight_number")
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @JsonProperty("aircraft")
    public String getAircraft() {
        return aircraft;
    }

    @JsonProperty("aircraft")
    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    @JsonProperty("booking_info")
    public BookingInfo getBookingInfo() {
        return bookingInfo;
    }

    @JsonProperty("booking_info")
    public void setBookingInfo(BookingInfo bookingInfo) {
        this.bookingInfo = bookingInfo;
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
        return new ToStringBuilder(this).append("departsAt", departsAt).append("arrivesAt", arrivesAt).append("origin", origin).append("destination", destination).append("marketingAirline", marketingAirline).append("operatingAirline", operatingAirline).append("flightNumber", flightNumber).append("aircraft", aircraft).append("bookingInfo", bookingInfo).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(departsAt).append(arrivesAt).append(bookingInfo).append(additionalProperties).append(aircraft).append(origin).append(flightNumber).append(operatingAirline).append(marketingAirline).append(destination).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Flight) == false) {
            return false;
        }
        Flight rhs = ((Flight) other);
        return new EqualsBuilder().append(departsAt, rhs.departsAt).append(arrivesAt, rhs.arrivesAt).append(bookingInfo, rhs.bookingInfo).append(additionalProperties, rhs.additionalProperties).append(aircraft, rhs.aircraft).append(origin, rhs.origin).append(flightNumber, rhs.flightNumber).append(operatingAirline, rhs.operatingAirline).append(marketingAirline, rhs.marketingAirline).append(destination, rhs.destination).isEquals();
    }

}
