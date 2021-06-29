package org.acme.sakamoto.models;

import lombok.Data;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotBlank;

@Data
public class Movie {

    private int id;
    @JsonbProperty("Title")
    @NotBlank(message = "Title shouldn't be blank")
    private String title;
    @JsonbProperty("Year")
    @NotBlank(message = "Year shouldn't be blank")
    private String year;
    @JsonbProperty("Genre")
    private String genre;
    @JsonbProperty("Director")
    @NotBlank(message = "Director shouldn't be blank")
    private String director;
    @JsonbProperty("Type")
    private String type;

}
