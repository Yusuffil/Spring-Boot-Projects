package etrade.business.responses.Clients;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllClientsResponse {

    private int id;

    private String fullname;

    private String identityNumber;
}
