/**
 *
 */
package com.lpdecastro.dtos.request;

import java.util.Map;

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
public class YelpReviewsRequestDto {

    private String term;

    private String location; // TODO: add custom validation required if latitude and longitude is not specified

    private Double latitude; // TODO: add custom validation required location is not specified

    private Double longitude; // TODO: add custom validation required location is not specified

    private Integer radius;

    private String categories;

    private String locale;

    private Integer limit;

    private Integer offset;

    private String sortBy;

    private String price;

    private Boolean openNow;

    private Integer openAt;

    private String attributes;

    public YelpReviewsRequestDto(Map<String, String> params) {

        for (Map.Entry<String, String> e : params.entrySet()) {
            String paramKey = e.getKey();
            switch (paramKey) {
                case "term":
                    this.term = e.getValue();
                    break;

                case "location":
                    this.location = e.getValue();
                    break;

                case "latitude":
                    this.latitude = Double.valueOf(e.getValue()); // TODO: handle numberError and null
                    break;

                case "longitude":
                    this.longitude = Double.valueOf(e.getValue()); // TODO: handle numberError and null
                    break;

                case "radius":
                    this.radius = Integer.valueOf(e.getValue()); // TODO: handle numberError and null
                    break;

                case "categories":
                    this.categories = e.getValue();
                    break;

                case "locale":
                    this.locale = e.getValue();
                    break;

                case "limit":
                    this.limit = Integer.valueOf(e.getValue()); // TODO: handle numberError and null
                    break;

                case "offset":
                    this.offset = Integer.valueOf(e.getValue()); // TODO: handle numberError and null
                    break;

                case "sort_by":
                    this.sortBy = e.getValue();
                    break;

                case "price":
                    this.price = e.getValue();
                    break;

                case "open_now":
                    this.openNow = Boolean.valueOf(e.getValue()); // TODO: handle booleanError and null
                    break;

                case "open_at":
                    this.openAt = Integer.valueOf(e.getValue()); // TODO: handle numberError and null
                    break;

                case "attributes":
                    this.attributes = e.getValue();
                    break;
            }
        }
    }

}
