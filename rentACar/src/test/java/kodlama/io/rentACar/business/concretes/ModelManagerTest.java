package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import kodlama.io.rentACar.entities.concretes.Model;
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

@ExtendWith(SpringExtension.class)
class ModelManagerTest {

    @InjectMocks
    private ModelManager modelManager;

    @Mock
    private ModelRepository modelRepository;

    @Mock
    private ModelMapperService modelMapperService;

    @Test
    void getAll() {

        var brand = new Brand();
        brand.setName("BMW");
        brand.setId(1);

        var model = new Model();
        model.setName("3.20");
        model.setBrand(brand);
        model.setId(1);

        List<Model> modelList = new ArrayList<>();
        modelList.add(model);

        var modelMapper = new ModelMapper();

        Mockito.when(modelRepository.findAll()).thenReturn(modelList);
        Mockito.when(modelMapperService.forResponse()).thenReturn(modelMapper);

        var response = modelManager.getAll();

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(modelList.get(0).getName()).isEqualTo(response.get(0).getName());
        Assertions.assertThat(modelList.get(0).getId()).isEqualTo(response.get(0).getId());
        Assertions.assertThat(modelList.get(0).getBrand().getName()).isEqualTo(response.get(0).getBrandName());

        Mockito.verify(modelRepository, Mockito.times(1)).findAll();
        Mockito.verify(modelMapperService, Mockito.times(1)).forResponse();

    }

    @Test
    void add() {
        var brand = new Brand();
        brand.setName("Renault");
        brand.setId(1);

        var model = new Model();
        model.setName("Clio");
        model.setBrand(brand);
        model.setId(1);

        var modelMapper = new ModelMapper();


        Mockito.when(modelMapperService.forRequest()).thenReturn(modelMapper);
        Mockito.when(modelRepository.save(model)).thenReturn(model);


        Mockito.verify(modelMapperService, Mockito.times(1)).forResponse();
        Mockito.verify(modelRepository, Mockito.times(1)).save(model);
    }
}