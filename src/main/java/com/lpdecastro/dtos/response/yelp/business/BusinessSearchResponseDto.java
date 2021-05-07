/**
 *
 */
package com.lpdecastro.dtos.response.yelp.business;

import java.util.List;

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
public class BusinessSearchResponseDto {

    @JsonProperty("total")
    private Integer total;

    @JsonProperty("businesses")
    private List<BusinessResponseDto> businesses;

    @JsonProperty("region")
    private RegionResponseDto region;
}
