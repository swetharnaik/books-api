/*
 * Copyright (C) 2021  Karan Kumar
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.

 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE.  See the GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License along with this program.
 * If not, see <https://www.gnu.org/licenses/>.
 */

package com.karankumar.booksapi.repository;

import com.karankumar.booksapi.model.AwardName;
import com.karankumar.booksapi.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    // TODO: this is kept in for quick testing, but will be removed at a later date
    @Query("SELECT DISTINCT b FROM Book b LEFT JOIN FETCH b.authors")
    List<Book> findAllBooks();
  
    @Query("SELECT a.books FROM Author a where a.fullName=?1")
    List<Book> findByAuthor(String fullName);

    Book findBookByIsbn13(String isbn13);
  
    Book findByTitleIgnoreCase(String title);

    @Query("SELECT a.books FROM Award a where a.awardName=?1")
    List<Book> findByAwardName(AwardName awardName);
}
