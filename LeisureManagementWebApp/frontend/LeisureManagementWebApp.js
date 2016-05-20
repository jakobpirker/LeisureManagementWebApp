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

app.controller("ArticlesCtrl", function ($scope, $http)
{
    // default url
    $scope.url = "http://localhost:8080/greeting/list";
    // create an empty array
    $scope.tables = [];

    $scope.GetData = function ()
    {
        var response = $http.get($scope.url);
        response.success(function(data, status, headers, config) {
            // response.data contains the actual data (JSON) of the http response
            // tables.push adds two entries to the "tables"-array: rows and cols
            // Object.keys takes all the keys from the first row, so they can be accessed in the view
            // $scope.tables.push({rows: response.data, cols: Object.keys(response.data[0])});
            $scope.PostDataResponse = data;
            $scope.tables.push({cols: Object.keys(data[0]), rows: data});
        });
        response.error(function(data, status, headers, config) {
            $scope.PostDataResponse = data;
        });
    };
});

app.controller("WebAppController", function ($scope, $http)
{
    $scope.tables = [];
    this.tab = 0;
    // list for the binding of the attribute contents
    $scope.list = [];

    //---------------------------------------------------------
    // list of tabs
    $scope.tabs = [];
    $scope.tabs.push({label: "JSON Creation", execute: getEntityForm, fkt_params: "http://localhost:8080/greeting"});
    $scope.tabs.push({label: "List", execute: getList, fkt_params: "http://localhost:8080/greeting/list"});
    //---------------------------------------------------------

    function getList(url)
    {
        var response = $http.get(url);
        response.success(function(data, status, headers, config) {
            // response.data contains the actual data (JSON) of the http response
            // tables.push adds two entries to the "tables"-array: rows and cols
            // Object.keys takes all the keys from the first row, so they can be accessed in the view
            // $scope.tables.push({rows: response.data, cols: Object.keys(response.data[0])});
            $scope.PostDataResponse = data;
            $scope.tables.push({cols: Object.keys(data[0]), rows: data});
        });
        response.error(function(data, status, headers, config) {
            $scope.PostDataResponse = data;
        });
    };

    function getEntityForm(url)
    {
        var response = $http.get(url);
        response.success(function(data, status, headers, config) {
            $scope.PostDataResponse = data;
            $scope.attributes = Object.keys(data);
        });
        response.error(function(data, status, headers, config) {
            $scope.PostDataResponse = data;
        });
    };

    $scope.postEntity = function(selected_tab)
    {
        var jsonData = {};

        //TODO:error when lists not equal in lenth?

        // create json object from the created form
        for (i = 0; i < $scope.list.length; i++) {
            jsonData[$scope.attributes[i]] = $scope.list[i];
        }

        $scope.test = jsonData;

        var response = $http.post($scope.tabs[selected_tab].fkt_params, jsonData);
        response.success(function(data, status, headers, config) {
            $scope.PostDataResponse = data;
        });
        response.error(function(data, status, headers, config) {
            $scope.PostDataResponse = data;
        });
    };

    this.selectTab = function(setTab)
    {
        this.tab = setTab;
        $scope.tabs[setTab].execute($scope.tabs[setTab].fkt_params);
    };

    this.isSelected = function(checkTab)
    {
        return this.tab === checkTab;
    };

    this.getSelected = function()
    {
        return this.tab;
    };
});