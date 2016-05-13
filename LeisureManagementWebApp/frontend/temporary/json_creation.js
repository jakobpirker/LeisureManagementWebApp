var app = angular.module("app", []);
app.controller("HttpGetController", function ($scope, $http)
{
	// list for the binding of the attribute contents 
	$scope.list = [];
	// default url
	$scope.url = "http://localhost:8080/greeting";

    $scope.SendData = function ()
    {
		var jsonData = {};
		
		// create json object from the created form
		for (i = 0; i < $scope.list.length; i++) { 
			jsonData[$scope.attributes[i]] = $scope.list[i];
		}
		
		$scope.test = jsonData;
		
		var response = $http.post($scope.url, jsonData);
		response.success(function(data, status, headers, config) {
			$scope.PostDataResponse = data;
		});
		response.error(function(data, status, headers, config) {
			$scope.PostDataResponse = data;
		});
    };
	
	$scope.GetData = function ()
    {		
		var response = $http.get($scope.url);
		response.success(function(data, status, headers, config) {
			$scope.PostDataResponse = data;
			$scope.attributes = Object.keys(data);
		});
		response.error(function(data, status, headers, config) {
			$scope.PostDataResponse = data;
		});
    };
});
