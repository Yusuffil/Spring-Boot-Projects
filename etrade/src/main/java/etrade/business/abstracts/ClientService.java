package etrade.business.abstracts;

import etrade.business.requests.Client.CreateClientRequest;
import etrade.business.requests.Client.UpdateClientRequest;
import etrade.business.responses.Clients.CreateClientResponse;
import etrade.business.responses.Clients.GetAllClientsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {
    Page<GetAllClientsResponse> getAll(Pageable pageable);

    CreateClientResponse add(CreateClientRequest createClientRequest);

    void update(UpdateClientRequest updateClientRequest);

    boolean delete(int id);
}
