package net.codejava;


import static  org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import net.codejava.Model.Department;
import net.codejava.Repository.DepartmentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoryRepositoryTest {

    @Autowired
    private DepartmentRepository repo;

    @Test
    public void testCreateCategory(){
        Department savedCategory = repo.save(new Department("Electronics"));

        assertThat(savedCategory.getId()).isGreaterThan(0);
    }
}
