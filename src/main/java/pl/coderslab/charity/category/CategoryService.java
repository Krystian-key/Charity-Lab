package pl.coderslab.charity.category;


import org.springframework.stereotype.Repository;
import pl.coderslab.charity.category.domain.Category;

import java.util.List;

@Repository
public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    Category create(Category category);

    Category update(Category category, Long id);

    void delete(Long id);
}
