var app = angular.module('LMWebApp', ['ngSanitize']);

app.controller('TabsController', function() {
    this.tab = 0;

    this.selectTab = function(setTab)
    {
        this.tab = setTab;
    };

    this.isSelected = function(checkTab)
    {
        return this.tab === checkTab;
    };
});

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

app.controller('ArticlesCtrl', function($scope, $http)
{
    // create an empty array
    $scope.tables = [];
    // read data from file (via http request) -> results stored in "response"
    var response = $http.get("http://localhost:8080/greeting/list");
    response.success(function(data, status, headers, config) {
        // response.data contains the actual data (JSON) of the http response
        // tables.push adds two entries to the "tables"-array: rows and cols
        // Object.keys takes all the keys from the first row, so they can be accessed in the view
        $scope.error = "so far so good!";
        $scope.resp = response;
        $scope.tables.push({rows: response.data, cols: Object.keys(response.data[0])});
    });
    response.error(function(data, status, headers, config) {
        $scope.tables = response;
        $scope.error = "something went wrong!";
    });
});