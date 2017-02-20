var app=angular.module("mainApp",[]);

app.controller("libraryController",['$scope','$http',function($scope,$http){
	
	$http.get("/viewAllBooks").success(function(data){
		console.log(data);
		$scope.Books=data;
		console.log($scope.Books);
	});
	$scope.AddBook=function(book){
		$http.post("/addBook",book).then(function(dat){
			
			
		});
	};
	$http.get("/viewAllBooks").success(function(data){
		console.log(data);
		$scope.Books=data;
		$scope.newbook={};
	});
	
}]);
