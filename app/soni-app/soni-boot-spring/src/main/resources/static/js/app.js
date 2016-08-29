var app=angular.module("MyCat",[]);
app.controller("MyCatalouge",function($scope,$http){
	$scope.product=[];
	$scope.searhItem=null;
	$scope.pageCourante=0;
	$scope.searchProduct=function(){
		$http.get("/getProductByName?name="+$scope.searhItem+"&page="+$scope.pageCourante).success(function(data){
			$scope.product=data;
			$scope.pages=new Array(data.totalPages);
		});
		$scope.gotoPage=function(p){
			$scope.pageCourante=p;
			$scope.searchProduct();
		};
		
	};
		
	
	
	
});