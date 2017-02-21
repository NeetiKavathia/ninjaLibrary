/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import ninja.Result;
import ninja.Results;
import ninja.params.*;

import java.util.List;


import entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.inject.*;
import com.google.inject.persist.Transactional;
import com.google.inject.persist.*;
import ninja.jpa.UnitOfWork;

	
@Singleton
public class ApplicationController {
	
	@Inject
	Provider<EntityManager> entitiyManagerProvider;

    public Result index() {

        return Results.html();

    }
    
    public Result main() {

        return Results.html();

    }
    
    public Result helloWorldJson() {
        
        SimplePojo simplePojo = new SimplePojo();
        simplePojo.content = "Hello World! Hello Json!";

        return Results.json().render(simplePojo);

    }
        public static class SimplePojo {

        public String content;
        
    }
    @UnitOfWork
	public Result viewBooks() {
	    EntityManager entityManager = entitiyManagerProvider.get();
		//List<Book> l=entityManager.createQuery("from Book").getResultList();	
		Query l = entityManager.createNamedQuery("Book.viewAllBooks", Book.class);
		return Results.json().render(l.getResultList());
	}
	@Transactional
	public Result addBook(Book book){
		EntityManager entityManager = entitiyManagerProvider.get();
	//	List<Book> l=entityManager.createQuery("from Book where id="+ book.getId()).getResultList();
	Query l=entityManager.createNamedQuery("Book.addBook",Book.class);
	l.setParameter("name",book.getName());
	l.setParameter("author",book.getAuthor());
	l.setParameter("category",book.getCategory());
	l.setParameter("price",book.getPrice());

//		if(l.size()!=0)
//			return Results.badRequest();
		//entityManager.persist(book);
		l.executeUpdate();
		return Results.json().render("success");
	}
	@Transactional
	public Result delBook(Book book){
		EntityManager entityManager = entitiyManagerProvider.get();
//		Book bo=entityManager.find(Book.class,book.getId());
//		entityManager.remove(bo);
		Query l=entityManager.createNamedQuery("Book.delBook",Book.class);
		l.setParameter("id",book.getId());
		l.executeUpdate();
		return Results.json().render("success");
	}
	@Transactional
	public Result updateBook(Book book){
		EntityManager entityManager = entitiyManagerProvider.get();
//		Book bo=entityManager.find(Book.class,book.getId());
//		bo.setName(book.getName());
//		bo.setAuthor(book.getAuthor());
//		bo.setCategory(book.getCategory());
//		bo.setPrice(book.getPrice());
		Query l=entityManager.createNamedQuery("Book.updateBook",Book.class);
		l.setParameter("name",book.getName());
		l.setParameter("author",book.getAuthor());
		l.setParameter("category",book.getCategory());
		l.setParameter("price",book.getPrice());
		l.executeUpdate();
		return Results.json().render("success");
	}
	
}
