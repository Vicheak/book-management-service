package com.vicheak.book.bookservice.mapper;

import com.vicheak.book.bookservice.dto.BookDto;
import com.vicheak.book.bookservice.entity.Book;

public abstract class BookMapper {

    public static BookDto toBookDto(Book book) {
        return BookDto.builder()
                .name(book.getName())
                .author(book.getAuthor())
                .publishDate(book.getPublishDate().toString())
                .build();
    }

}
