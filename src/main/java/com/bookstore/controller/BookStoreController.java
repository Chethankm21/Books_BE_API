package com.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.entity.Book;
import com.bookstore.services.IBookStoreService;
import springfox.documentation.spring.web.json.Json;

@Controller
@RequestMapping("bookservice")
public class BookStoreController {
	
	@Autowired
	private IBookStoreService service;

	@GetMapping("booksfile")
	public ResponseEntity<List<Book>> getBooksFile(){
		List<Book> books = new ArrayList<>();
		books.add(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling"));
		books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
		books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
		books.add(new Book("1984", "George Orwell"));
		books.add(new Book("The Catcher in the Rye", "J.D. Salinger"));
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);


	}

	@GetMapping("books")
	public ResponseEntity<List<Book>> getBooks(){
		
		List<Book> books = service.getBooks();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		
	}
	
	@GetMapping("books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") Integer id){
		Book book = service.getBook(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@PostMapping("books")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		Book b = service.createBook(book);
		return new ResponseEntity<Book>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book){
		
		Book b = service.updateBook(id, book);
		return new ResponseEntity<Book>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("books/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") int id){
		boolean isDeleted = service.deleteBook(id);
		if(isDeleted){
			String responseContent = "Book has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting book from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
