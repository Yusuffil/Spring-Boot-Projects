package etrade.business.requests.Order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateOrderRequest {

    @NotNull
    @NotBlank
    private String adress;

}
