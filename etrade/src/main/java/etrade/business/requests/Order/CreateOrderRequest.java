package etrade.business.requests.Order;

import etrade.Entities.concretes.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {

    @NotNull
    @NotBlank
    private int clientId;

    @NotNull
    @NotBlank
    private String adress;

    @NotNull
    @Size(min=3)
    private int orderDeliveryNumber;

}
