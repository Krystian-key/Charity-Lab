package pl.coderslab.charity.category.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.category.domain.Category;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final static String ERROR_MESSAGE = "Category not found with id: ";

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));
    }

    @Override
    public Long create(Category category) {
        Category create = categoryRepository.save(category);
        return create.getId();
    }

    @Override
    public Category update(Category category, Long id) {
        Category categoryById = categoryRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));
        return categoryRepository.save(categoryById);
    }

    @Override
    public void delete(Long id) {
        Category categoryById = categoryRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));
        categoryRepository.delete(categoryById);

    }
}
