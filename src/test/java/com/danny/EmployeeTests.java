package com.danny;

import com.danny.model.Employee;
import com.danny.repository.EmployeeRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeTests {

    @Autowired
    private EmployeeRepository repo;

    @Test
    public void testCreateEmployee() {
        Employee savedEmployee = repo.save(new Employee(1, "Sarah", "Manager"));

        assertThat(savedEmployee.getId()).isEqualTo(1);
    }
}
