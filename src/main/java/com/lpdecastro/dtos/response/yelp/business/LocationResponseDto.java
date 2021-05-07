/**
 *
 */
package com.lpdecastro.dtos.response.yelp.business;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liandre.p.de.castro
 *
 * @since 2021/05/07
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LocationResponseDto {

    @JsonProperty("address1")
    private String address1;

    @JsonProperty("address2")
    private String address2;

    @JsonProperty("address3")
    private String address3;

    @JsonProperty("city")
    private String city;

    @JsonProperty("country")
    private String country;

    @JsonProperty("state")
    private String state;

    @JsonProperty("zip_code")
    private String zipCode;
}
