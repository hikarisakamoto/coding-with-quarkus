package org.acme.sakamoto.models;

import lombok.Data;

import javax.json.bind.annotation.JsonbProperty;

@Data
public class Movie {

    private int id;
    @JsonbProperty("Title")
    private String title;
    @JsonbProperty("Year")
    private String year;
    @JsonbProperty("Genre")
    private String genre;
    @JsonbProperty("Director")
    private String director;
    @JsonbProperty("Type")
    private String type;
}
