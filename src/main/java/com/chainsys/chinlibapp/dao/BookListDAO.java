package com.chainsys.ldm.bookList;

import java.util.List;

public interface BookListDAO {
int addBooks(BookList books);
int removeBooks(long isbn);
public List<BookList> viewBooks();
}