var app=angular.module("mainApp",[]);

app.controller("libraryController",['$scope','$http',function($scope,$http){
	
	$http.get("/viewAllBooks").success(function(data){
		//console.log(data);
		$scope.Books=data;
		//console.log($scope.Books);
	});
	$scope.AddBook=function(book){
		$http.post("/addBook",book).success(function(dat){
		$http.get("/viewAllBooks").success(function(data){
			//console.log(data);
			$scope.Books=data;
			$scope.newbook={};
			});	
			
		});
	};
	$scope.DelBook=function(book){
		$http.post("/delBook",book).success(function(data){
			$http.get("/viewAllBooks").success(function(data){
				$scope.Books=data;
			});
		});
	};
	$scope.ModifyBook=function(book){
		book.EditAllowed=true;
		$scope.modifiedbook=book;
	};
	$scope.UpdateBook=function(book){
		//console.log(book);
		delete book['EditAllowed'];
		$http.post("/updateBook",book).success(function(data){
			$http.get("/viewAllBooks").success(function(data){
				$scope.Books=data;
			});
		});
	};
	
	
}]);
