/**
 * INSPINIA - Responsive Admin Theme
 *
 * Inspinia theme use AngularUI Router to manage routing and views
 * Each view are defined as state.
 * Initial there are written state for all view in theme.
 *
 */
function config($stateProvider, $urlRouterProvider) {

    // Configure Idle settings
    // IdleProvider.idle(5); // in seconds
    // IdleProvider.timeout(120); // in seconds

    $urlRouterProvider.otherwise("/a2a");

    // $ocLazyLoadProvider.config({
    //     Set to true if you want to see what and when is dynamically loaded
        // debug: false
    // });

    $stateProvider

        .state('a2a', {
            url: "/a2a",
            templateUrl: "/a2a/a2a",
            data: { pageTitle: 'A 2 A Test' },
            controller: 'baseController'
        })
        .state('smoketest', {
            url: "/smoketest",
            templateUrl: "/smoketest/smoketest",
            data: { pageTitle: 'Smoke Test' },
            controller: 'smokeTestController'
        });


}
angular
    .module('automation')
    .config(config)
    .config(['$qProvider', function ($qProvider) {
        $qProvider.errorOnUnhandledRejections(false);
    }])
    .run(function($rootScope, $state) {
        $rootScope.$state = $state;
    });
