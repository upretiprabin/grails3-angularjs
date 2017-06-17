angular
    .module('automation')
    .controller('a2aController',a2aController);

a2aController.$inject = ['$scope','fetchservice'];

function a2aController($scope,fetchservice) {

    var vm=this;
    vm.instanceCount = 1;
    vm.instanceColl = [1];
    vm.data = {};

    $scope.run = function () {
        var requestData = {};
        requestData['clientId']=$scope.clientId;
        angular.forEach(vm.instanceColl,function (v,index) {
            requestData['clientInstanceId_'+v]=$('#clientInstanceId_'+v).val();
        });

        console.log("-reqData"+angular.toJson(requestData));

        fetchservice.a2aTest(requestData).then(function(data){
            console.log(data);
            vm.data = data;
        });
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
