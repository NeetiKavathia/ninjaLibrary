var Library=angular.module('Library',[]);
Library.factory('Library',function(){
	var Library={};
	Library.books=[];
	
	Library.addBook=function (book){
		Library.books.push(book);
	}
	Library.getAllBooks = function(){
		return Library.books;
	}
	Library.removeBook=function(book){
		var _index = Library.books.indexOf(book);  
        Library.books.splice(_index, 1);  
	}
	return Library;
});