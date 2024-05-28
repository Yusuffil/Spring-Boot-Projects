package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class BrandManagerTest {

    @InjectMocks
    private BrandManager brandManager;
    @Mock
    private BrandRepository brandRepository;
    @Mock
    private ModelMapperService modelMapperService;
    @Mock
    private BrandBusinessRules brandBusinessRules;

    @Test
    void getAll() {
        Brand brand = new Brand();
        brand.setName("Fiat");

        List<Brand> brandList = new ArrayList<>();
        brandList.add(brand);

        ModelMapper modelMapper = new ModelMapper();

        Mockito.when(brandRepository.findAll()).thenReturn(brandList);
        Mockito.when(modelMapperService.forResponse()).thenReturn(modelMapper);

        var response = brandManager.getAll();

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(brand.getName()).isEqualTo(response.get(0).getName());

        Mockito.verify(brandRepository, Mockito.times(1)).findAll();
        Mockito.verify(modelMapperService, Mockito.times(1)).forResponse();




    }

    @Test
    void getById() {
        var brand = new Brand();
        brand.setName("Mercedes");
        int id = 1;
        var modelMapper = new ModelMapper();

        //Mockito.doThrow(new RuntimeException()).when(brandRepository).findById(id); // Bunun içim ayrıca test metodu yazılmalıdır.
        Mockito.when(brandRepository.findById(id)).thenReturn(Optional.of(brand));
        Mockito.when(modelMapperService.forResponse()).thenReturn(modelMapper);
        var getByIdBrandResponse = brandManager.getById(id);

        Assertions.assertThat(getByIdBrandResponse).isNotNull();
        Assertions.assertThat(getByIdBrandResponse.getName()).isEqualTo(brand.getName());

        Mockito.verify(brandRepository, Mockito.times(1)).findById(id);
        Mockito.verify(modelMapperService, Mockito.times(1)).forResponse();


    }

    @Test
    void add() {
        var createBrandRequest = new CreateBrandRequest();
        createBrandRequest.setName("Fiat");
        var brand = new Brand();
        var modelMapper = new ModelMapper();

        Mockito.doNothing().when(brandBusinessRules).checkIfBrandNameExists(createBrandRequest.getName());
        Mockito.when(modelMapperService.forRequest()).thenReturn(modelMapper);
        Mockito.when(brandRepository.save(brand)).thenReturn(brand);


    }

    @Test
    void update() {
        UpdateBrandRequest updateBrandRequest =new UpdateBrandRequest();
        updateBrandRequest.setId(1);
        updateBrandRequest.setName("Daire");

        var brand = new Brand();
        var modelMapper = new ModelMapper();

        Mockito.when(modelMapperService.forRequest()).thenReturn(modelMapper);
        Mockito.when(brandRepository.save(brand));


    }

    @Test
    void delete() {
        int id = 1;

        Mockito.doNothing().when(brandRepository).deleteById(id);
    }
}