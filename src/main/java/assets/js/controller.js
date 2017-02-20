var app=angular.module("mainApp",['Library']);

app.controller("libraryController",['$scope','Library',function($scope,Library){
	
	$scope.EditAllowed=false;
	$scope.id=-1;
	$scope.Book={Name:"",Price:"",Author:"",EditAllowed:false};
	$scope.Books = Library.getAllBooks();
	$scope.AddBook=function(book){
		var a={Name:book.Name,Price:book.Price,Author:book.Author,EditAllowed:false};
		Library.addBook(a);
		$scope.newbook={};
	}
	$scope.UpdateBook=function(book){
		book.EditAllowed=false;
	}
	$scope.ModifyBook=function(book){
		$scope.id=Library.books.indexOf(book);
		book.EditAllowed=true;
		$scope.modifiedbook=book;
	}
	$scope.DeleteBook=function(book){
		Library.removeBook(book);
	}

}]);
