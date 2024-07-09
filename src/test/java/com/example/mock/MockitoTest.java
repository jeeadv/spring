package com.example.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class MockitoTest
{
    @Test
    public void testArrayList()
    {
        List<String> arrayList = Mockito.mock(ArrayList.class);
        Mockito.when(arrayList.size()).thenReturn(99);
        Mockito.when(arrayList.add(Mockito.anyString())).thenCallRealMethod();
        Mockito.when(arrayList.get(Mockito.anyInt())).thenCallRealMethod();
        arrayList.add("kumar");
        arrayList.add("gaurav");

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.size());
    }
}
