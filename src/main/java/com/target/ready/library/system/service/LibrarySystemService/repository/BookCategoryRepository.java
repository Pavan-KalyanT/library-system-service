package com.target.ready.library.system.service.LibrarySystemService.repository;

import com.target.ready.library.system.service.LibrarySystemService.entity.BookCategory;
import com.target.ready.library.system.service.LibrarySystemService.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory,Integer> {
    BookCategory findByBookId(int bookId);
//    @Query("SELECT id FROM BookCategory b WHERE b.categoryName=:categoryName")
//    Integer findBookCategoriesByCategoryName(String categoryName);

    List<BookCategory> deleteBookCategoriesByBookId(int bookId) throws ResourceNotFoundException;
    List<BookCategory> findAllCategoriesByBookId(int bookId);
    List<BookCategory> findByCategoryName(String categoryName) throws ResourceNotFoundException;
    Page<BookCategory> findByCategoryName(String categoryName, Pageable pageable);
    long countBooksByCategoryName(String categoryName);

}


