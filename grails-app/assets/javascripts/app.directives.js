/**
 * INSPINIA - Responsive Admin Theme
 *
 */


/**
 * pageTitle - Directive for set Page title - mata title
 */
function pageTitle($rootScope, $timeout) {
    return {
        link: function(scope, element) {
            var listener = function(event, toState, toParams, fromState, fromParams) {
                // Default title - load on Dashboard 1
                var title = 'Test Automation';
                // Create your own title pattern
                if (toState.data && toState.data.pageTitle) title = 'Test Automation | ' + toState.data.pageTitle;
                $timeout(function() {
                    element.text(title);
                });
            };
            $rootScope.$on('$stateChangeStart', listener);
        }
    }
};

/**
 * sideNavigation - Directive for run metsiMenu on sidebar navigation
 */
function sideNavigation($timeout) {
    return {
        restrict: 'A',
        link: function(scope, element) {
            // Call the metsiMenu plugin and plug it to sidebar navigation
            $timeout(function(){
                element.metisMenu({
                    preventDefault: false
                });
            });
        }
    };
};

/**
 * iboxTools - Directive for iBox tools elements in right corner of ibox
 */

//This is not used...copy and paste and make your own directive from this as needed - RWW
function iboxTools($timeout) {
    return {
        restrict: 'A',
        scope: true,
        templateUrl: 'common/ibox_tools',
        controller: function ($scope, $element) {

            // Function for collapse ibox
            $scope.showhide = function () {
                var ibox = $element.closest('div.ibox');
                var icon = $element.find('i:first');

                var content = ibox.find('div.ibox-content');
                content.slideToggle(200);

                // Toggle icon from up to down
                icon.toggleClass('fa-chevron-down').toggleClass('fa-chevron-up');
                ibox.toggleClass('').toggleClass('border-bottom');

                $timeout(function () {
                    ibox.resize();
                    ibox.find('[id^=map-]').resize();
                }, 50);
            };

            // Function for close ibox
            $scope.schedule = function () {
                alert("Need to add this.");
            };

            $scope.togglefavorite = function(){
                var ibox = $element.closest('div.ibox');
                var icon = $element.find('i:eq(1)');

                icon.toggleClass('fa-star star-favorite').toggleClass('fa-star-o');
            }
        }
    };
};

/**
 * minimalizaSidebar - Directive for minimalize sidebar
 */
function minimalizaSidebar($timeout) {
    return {
        restrict: 'A',
        template: '<a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="" ng-click="minimalize()"><i class="fa fa-caret-left"></i></a>',
        controller: function ($scope, $element) {
            $scope.minimalize = function ()
            {
                $("body").toggleClass("mini-navbar");

                var icon = $element.find('i:first');
                icon.toggleClass('fa-caret-left').toggleClass('fa-caret-right');

                if (!$('body').hasClass('mini-navbar') || $('body').hasClass('body-small'))
                {
                    // Hide menu in order to smoothly turn on when maximize menu
                    $('#side-menu').hide();

                    // For smoothly turn on menu
                    setTimeout(
                        function () {
                            $('#side-menu').fadeIn(400);
                            $("#nav-logo").show();

                        }, 200);

                } else if ($('body').hasClass('fixed-sidebar')){
                    $('#side-menu').hide();

                    setTimeout(
                        function () {
                            $('#side-menu').fadeIn(400);
                            $("#nav-logo").show();
                        }, 100);

                } else {

                    // Remove all inline style from jquery fadeIn function to reset menu state
                    $("#nav-logo").hide();
                    $('#side-menu').removeAttr('style');

                }
            }
        }
    };
};


/**
 * sparkline - Directive for Sparkline chart
 */
function sparkline() {
    return {
        restrict: 'A',
        scope: {
            sparkData: '=',
            sparkOptions: '='
        },
        link: function (scope, element, attrs) {
            scope.$watch(scope.sparkData, function () {
                render();
            });
            scope.$watch(scope.sparkOptions, function(){
                render();
            });
            var render = function () {
                $(element).sparkline(scope.sparkData, scope.sparkOptions);
            };
        }
    }
}


function button() {
    return {
        restrict: 'E',
        controller: function ($scope, $element) {

            // Function for collapse ibox
            $scope.comingSoon = function () {
                alert("This feature will coming in a future Executive Analytics release.");
            }
        }
    };
};

function a() {
    return {
        restrict: 'E',
        controller: function ($scope, $element) {

            // Function for collapse ibox
            $scope.comingSoon = function () {
                alert("This feature will coming in a future Executive Analytics release.");
            }
        }
    };
};



/**
 *
 * Pass all functions into module
 */
angular
    .module('automation')
    .directive('pageTitle', pageTitle)
    .directive('sideNavigation', sideNavigation)
    .directive('iboxTools', iboxTools)
    .directive('sparkline', sparkline)
    .directive('button', button)
    .directive('a', a)
    .directive('minimalizaSidebar', minimalizaSidebar);
