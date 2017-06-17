;(function() {

  'use strict';
  angular
    .module('automation')
    .directive('sideBar', SideBar);
  
  SideBar.$inject = ['$rootScope','$timeout','$location'];
  
  function SideBar( $rootScope, $timeout, $location) {

    // Definition of directive
    var directiveDefinitionObject = {
      restrict: 'E',
	  scope : {},
      templateUrl: 'common/sidebar',
	  link : SiteBarLink 
    };
	
	function SiteBarLink(scope){
		scope.AppName = "Test Automation";
		scope.ProjectList = ['upreti'];
		scope.SubMenuActive = false;
		
		
	}
    return directiveDefinitionObject;
  }
  
  

})();