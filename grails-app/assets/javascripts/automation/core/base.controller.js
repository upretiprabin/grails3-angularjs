angular
    .module('automation')
    .controller('baseController', baseController);

baseController.$inject = ['$scope'];

function baseController($scope){

    $scope.testString = "OK";
    //Doing nothing right now but good technique that might be needed later.
    $scope.$on('$viewContentLoaded', function(event, toState, toParams, fromState, fromParams){

        //Do nothing.

    });
}
