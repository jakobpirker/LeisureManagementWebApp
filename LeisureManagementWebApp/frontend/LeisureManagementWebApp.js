var app = angular.module('LMWebApp', ['ngSanitize']);

app.controller("WebAppController", function ($scope, $http)
{
    $scope.tables = []; // holding the entries for the dynamical tables
    this.tab = 0;       // currently selected tab
    $scope.list = [];   // list for the binding of the attribute contents

    //---------------------------------------------------------
    // list of tabs
    $scope.tabs = [];
    $scope.tabs.push({label: "Greeting Creation", execute: getEntityForm, fkt_params: "http://localhost:8080/greeting"});
    $scope.tabs.push({label: "Person Creation", execute: getEntityForm, fkt_params: "http://localhost:8080/person"});
    $scope.tabs.push({label: "Greeting - List", execute: getList, fkt_params: "http://localhost:8080/greeting/list"});
    $scope.tabs.push({label: "Person - List", execute: getList, fkt_params: "http://localhost:8080/person/list"});
    //---------------------------------------------------------

    function getList(url)
    {
        var response = $http.get(url);
        response.success(function(data, status, headers, config) {
            // response.data contains the actual data (JSON) of the http response
            // tables.push adds two entries to the "tables"-array: rows and cols
            // Object.keys takes all the keys from the first row, so they can be accessed in the view
            // $scope.tables.push({rows: response.data, cols: Object.keys(response.data[0])});
            $scope.request_data = data;
            $scope.tables = []; // clear object before pushing
            $scope.tables.push({cols: Object.keys(data[0]), rows: data});
        });
        response.error(function(data, status, headers, config) {
            $scope.request_data = data;
        });
    };

    function getEntityForm(url)
    {
        var response = $http.get(url);
        response.success(function(data, status, headers, config) {
            $scope.request_data = data;
            $scope.attributes = Object.keys(data);
        });
        response.error(function(data, status, headers, config) {
            $scope.request_data = data;
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

        $scope.test = $scope.tabs[selected_tab].fkt_params;
    
        var response = $http.post($scope.tabs[selected_tab].fkt_params, jsonData);
        response.success(function(data, status, headers, config) {
            $scope.request_data = data;
        });
        response.error(function(data, status, headers, config) {
            $scope.request_data = data;
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