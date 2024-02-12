package com.vicheak.book.bookservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {

    private String name;
    private String author;
    private String publishDate;

}
