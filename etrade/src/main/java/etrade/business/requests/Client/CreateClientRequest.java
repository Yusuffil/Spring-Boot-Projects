package etrade.business.requests.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateClientRequest {

    @NotNull
    @NotBlank
    private String fullname;

    @NotNull
    @NotBlank
    @Size(min = 11, max = 11)
    private String identityNumber;
}
