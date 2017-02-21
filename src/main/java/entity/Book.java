package entity;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedNativeQueries;



@Entity
@Table(name = "books")
@NamedNativeQueries({
	@NamedNativeQuery(
			name="Book.viewAllBooks",
			query="select * from books",
			resultClass=Book.class
			),
	@NamedNativeQuery(
			name="Book.delBook",
			query="delete from books where id= :id",
			resultClass=Book.class
			),
	
	@NamedNativeQuery(
			name="Book.addBook",
			query="insert into books(name,author,category,price) values(:name,:author,:category,:price )",
			resultClass=Book.class
			),
	@NamedNativeQuery(
			name="Book.updateBook",
			query="update name=:name,author=:author,category=:category,price=:price",
			resultClass=Book.class
			)
	
})
public class Book {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "author")
	private String author;
	@Column(name = "category")
	private String category;
	@Column(name = "price")
	private String price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}

