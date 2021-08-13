package com.unittestingproject.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ListMockTest {


    List<String> mock = mock(List.class);

    @Test
    public void size_basic(){
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters(){
        when(mock.get(0)).thenReturn("testToReturn");
        assertEquals("testToReturn", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    public void returnWithGenericParameters(){
        when(mock.get(anyInt())).thenReturn("testToReturn");
        assertEquals("testToReturn", mock.get(0));
        assertEquals("testToReturn", mock.get(1));
    }

    @Test
    public void verificationBasic(){
        //SUT: System under Test
        String value = mock.get(0);
        String value2 = mock.get(1);
        // Verifications
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atMost(7)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing(){
        //SUT: System under Test
        mock.add("SomeString");
        // Verifications
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("SomeString", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing(){
        //SUT: System under Test
        mock.add("SomeString1");
        mock.add("SomeString2");
        // Verifications
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());
        List<String> allValues = captor.getAllValues();
        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    @Test
    public void mockingRealClass(){
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); // null
        System.out.println(arrayListMock.size()); // 0
        arrayListMock.add("Test1");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size()); // 0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); // 5
    }

    @Test
    public void spyingRealClass(){
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0)); // Test0
        System.out.println(arrayListSpy.size()); // 1
        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size()); // 3
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size()); // 5
        arrayListSpy.add("Test3");
        System.out.println(arrayListSpy.size()); // 5
        verify(arrayListSpy).add("Test3");
    }
}
