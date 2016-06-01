var app = angular.module('LMWebApp', ['ngSanitize']);

app.controller("WebAppController", function ($scope, $http, $q)
{
    //---------------------------------------------------------
    // list of tabs
    $scope.tabs = [];
    //
    // add new tabs following the pattern:
    // $scope.tabs.push({label: "<your_tab_name>", execute: <your_function_name>, fkt_params: <function_params>});
    // EXAMPLE: $scope.tabs.push({label: "Tab", execute: test, fkt_params: "test_string"});
    //
    // NOTE: if there's no function to call just give the object the label-property
    // EXAMPLE: $scope.tabs.push({label: "Tab"});
    //---------------------------------------------------------

    $scope.list = [];   // list for the binding of the attribute contents
    $scope.available_entities = [];

    $scope.error_msg = "";
    $scope.new_entry_visible = false;   // visibility state for the new-entity-entrys
    // TODO: implement proper error-message for all functions

    //---------------------------------------------------------------------
    // initializes the web-page
    this.initializePage = function()
    {
        var wa_ctrl = this;        // temp
        $scope.available_entities = [];

        // get all entities, that can be displayed and edited/added
        var response = $http.get("http://localhost:8080/init/entities");
        response.success(function(data, status, headers, config) {
            $scope.available_entities = data;

            // map the entities to the according tabs (for tab behavior)
            $scope.available_entities.forEach(function(entity)
            {
                $scope.tabs.push({label:entity.label, execute: getList, fkt_params: entity.label});
            });

            wa_ctrl.selectTab($scope.tabs[0].label);
        });
        response.error(function(data, status, headers, config) {
            $scope.error_msg = "Failed get-request to http://localhost:8080/init/entities"
        });
    };

    //---------------------------------------------------------------------
    // gets a list of a specific entitiy
    function getList(entity_tab_name)
    {
        // search for the according functions of the selected tab
        $scope.available_entities.forEach(function(entry)
        {
            if(entity_tab_name === entry.label)
            {
                $http.get(entry.entity_url)
                .then(
                    function(response) {    // success
                        $scope.request_data = response.data;
                        $scope.attributes = Object.keys(response.data);
                        // on success conduct next request, to get the actual object-list
                        return $http.get(entry.list_url);
                    },
                    function(response) {   // fail
                        $scope.request_data = response;
                    })
                .then(
                    function(response) {    // success
                        $scope.request_data = response.data;
                        $scope.obj_list = response.data;
                    },
                    function(response) {    // fail
                $scope.request_data = response;
            });
            }
        });

    };

    this.showNewEntityFields = function()
    {
        $scope.new_entry_visible = true;

    };

    this.postEntity = function()
    {
        var jsonData = {};
        var wa_ctrl = this;    // temp

        //TODO:error when lists not equal in lenth?

        // create json object from the created form
        for (i = 0; i < $scope.list.length; i++) {
            jsonData[$scope.attributes[i]] = $scope.list[i];
        }

        $scope.available_entities.forEach(function(entry)
        {
            if(wa_ctrl.tab === entry.label)
            {
                var response = $http.post(entry.entity_url, jsonData);
                response.success(function(data, status, headers, config) {
                    $scope.request_data = data;
                    $scope.new_entry_visible = false;
                    getList(wa_ctrl.tab);
                });
                response.error(function(data, status, headers, config) {
                    $scope.request_data = data;
                });
            }
        });
    };

    //---------------------------------------------------------------------
    // triggered, when a tab is selected in the html
    this.selectTab = function(setTab)
    {
        this.tab = setTab;
        // search for the tab with the name setTab
        $scope.tabs.forEach(function(entry)
        {
            if(setTab === entry.label)
            {
                // execute function on tab-selection (if defined)
                if(entry.hasOwnProperty('execute'))
                {
                    entry.execute(entry.fkt_params);
                }
            }
        });
    };

    //---------------------------------------------------------------------
    // accessed by the view, to check if a specific tab is selected
    this.isSelected = function(checkTab)
    {
        return this.tab === checkTab;
    };

    //---------------------------------------------------------------------
    // checks if the list-body is visible (a tab is selected, where a database-list
    // should be displayed) -> one body in view but multiple tabs
    this.isListTabSelected = function()
    {
        var selected_tab = this.tab;
        var ret_val = false;

        $scope.available_entities.forEach(function(entry)
        {
            if(selected_tab === entry.label)
            {
                ret_val =  true;
            }
        });

        return ret_val;
    };

    this.initializePage();              // trigger page initialization
});