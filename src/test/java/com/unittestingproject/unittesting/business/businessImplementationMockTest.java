package com.unittestingproject.unittesting.business;

import com.unittestingproject.unittesting.data.DataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// This Unit test example uses Mockito
@ExtendWith(MockitoExtension.class)
public class businessImplementationMockTest {

    @InjectMocks
    businessImplementation business = new businessImplementation();

    @Mock
    DataService dataServiceMock = mock(DataService.class);

    // This is unnecessary when using @InjectMocks and @Mock Mockito annotations,
    // Mockito will automatically call the setter when injecting the mock
    /*
    @BeforeEach
    public void before (){
        business.setDataService(dataServiceMock);
    }*/

    @Test
    public void calculateSum_mock_basic() {
        when(dataServiceMock.retrieveAllData()).thenReturn( new int[] { 1, 2, 3 } );
        assertEquals (6, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSum_mock_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn( new int[] { } );
        assertEquals (0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSum_mock_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn( new int[] { 5 } );
        assertEquals (5, business.calculateSumUsingDataService());
    }
}
