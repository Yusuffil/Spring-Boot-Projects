package com.example.RealEstate.business.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCategoryRequest {

    @NotNull
    @NotBlank
    @Size(max=50)
    private String name;

    private boolean status=true;

}
