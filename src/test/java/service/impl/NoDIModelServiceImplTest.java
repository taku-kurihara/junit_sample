package service.impl;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.impl.ModelRepositoryImpl;

import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class NoDIModelServiceImplTest {

    @InjectMocks
    private NoDIModelServiceImpl noDIModelService;

    @Mock
    private ModelRepositoryImpl modelRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void foo() {
        try {
            when(modelRepository.findById(anyInt())).thenReturn(Optional.empty());

        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThat(
                "John Doe",
                Is.is(noDIModelService.getModelById(2).getName())
        );
    }
}
