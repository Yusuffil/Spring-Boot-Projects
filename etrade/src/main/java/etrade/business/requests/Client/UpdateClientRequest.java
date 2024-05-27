package etrade.business.requests.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class UpdateClientRequest {

    @NotNull
    @NotBlank
    private int id;

    @NotNull
    @NotBlank
    private String fullname;
}
