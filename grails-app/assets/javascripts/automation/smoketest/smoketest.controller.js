angular
    .module('automation')
    .controller('smokeTestController',smokeTestController);

smokeTestController.$inject = ['$scope','fetchservice'];


function smokeTestController($scope,fetchservice) {
    var vm=this;                                                                                                                                                                                                                                                                                                                                                                                
    vm.instanceCount = 1;
    vm.instanceColl = [1];

    $scope.run = function () {
        console.log("OK: run()   smokeTestController.controller.js=======000=======");
        var jsonResponse=fetchservice.getDasResponse()
        console.log("jsonResponse===="+jsonResponse)
        vm.jsonResponse=jsonResponse

    };
    $scope.add = function () {
        vm.instanceCount++;
        vm.instanceColl.push(vm.instanceCount);
    };
    $scope.remove = function () {
        if(vm.instanceColl.length > 1)
            vm.instanceColl.pop(vm.instanceColl.length)
    };

    $scope.removeAll = function () {
        vm.instanceColl = [1];
    };
}