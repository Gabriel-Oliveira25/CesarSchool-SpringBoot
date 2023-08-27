package next.cesar.school.springaula6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import next.cesar.school.springaula6.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{

}
