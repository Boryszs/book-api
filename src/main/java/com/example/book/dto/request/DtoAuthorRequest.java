package com.example.book.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoAuthorRequest {

    @JsonProperty(value = "authors")
    private List<DtoAuthorsRequest> dtoAuthorsRequest;
    @JsonProperty(value = "book")
    private DtoBooksRequest dtoBooksRequest;
}
