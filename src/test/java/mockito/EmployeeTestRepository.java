package mockito;

import org.example.domain.Employee;
import org.example.repository.EmployeeRepositoryImpl;
import org.example.service.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeTestRepository {
    EmployeeRepositoryImpl repositoryMock;
    EmployeeServiceImpl service;

    @Before
    public void setUp(){
        repositoryMock = mock(EmployeeRepositoryImpl.class);
        service = new EmployeeServiceImpl(repositoryMock);
    }
    @Test
    public void count(){
        when(repositoryMock.count()).thenReturn(5);
        Integer result = service.count();
        assertNotNull(result);
        assertEquals(Integer.valueOf(5), result);
    }
    @Test
    public void findAllTest(){
        List<Employee> mocklist = new ArrayList<>();
        mocklist.add(new Employee());
        when(repositoryMock.findAll()).thenReturn(mocklist);

        List<Employee> result = service.findAll();
        assertNotNull(result);
        assertEquals(1,result.size());
    }
    @Test
    public void findOneTest(){
        Employee mockEmploye = new Employee();
        Long id = 3L;
        when(repositoryMock.findOne(id)).thenReturn(mockEmploye);
        Employee result = service.findOne(id);
        assertNotNull(result);
    }
    @Test
    public void findOneOptionalOKTest(){
        Employee mockEmploye = new Employee();
        Long id = 3L;
        when(repositoryMock.findOne(id)).thenReturn(mockEmploye);
        Optional<Employee> result = service.findOneOptional(id);
        assertTrue(result.isPresent());
        assertEquals(mockEmploye, result.get());
    }
    @Test
    public void findOineOptionalExceptionTest(){
        Long idNok = 3L;
        when(repositoryMock.findOne(idNok)).thenThrow(new IllegalArgumentException("id no valido"));
        Optional<Employee> result = service.findOneOptional(idNok);
        assertFalse(result.isPresent());
        assertEquals(Optional.empty(),result);
    }
    @Test
    public void saveTest(){
        Employee employeeMock = new Employee();
        when(repositoryMock.save(employeeMock)).thenReturn(employeeMock);
        Employee resultado = service.save(employeeMock);
        assertNotNull(resultado);
        assertEquals(employeeMock,resultado);
    }
}
