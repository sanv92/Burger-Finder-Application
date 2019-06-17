package com.example.foursquareapi.model.photo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo {

    private String id;
    private Long createdAt;
    private Integer width;
    private Integer height;
    private String prefix;
    private String suffix;
}
