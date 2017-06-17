angular
    .module('automation')
    .factory('fetchservice',fetchservice);

fetchservice.$inject = ['$http','toastr'];

function fetchservice($http,toastr) {

    var service = {
        a2aTest : a2aTest,
        smokeTest: smokeTest,
        getDasResponse:getDasResponse
    };
    function getDasResponse(){
        console.log("OK: getDasResponse() fetchdata.service.js=======222=======");
        return getData('/fetchData/smokeTest', []);
    }

    function getData(url, filters) {
        console.log("OK: getData() fetchdata.service.js=======333=======");
        return $http.get(url, filters)
            .then(getComplete)
            .catch(getFailed);

        function getComplete(response) {
            return response.data;
        }

        function getFailed(error) {
            logger.error('XHR Failed for ' + url + "." + error.data);
        }
    }
    return service;

    function a2aTest(filters) {
        return postData("test/a2a",filters);
    }

    function smokeTest() {

    }

    function getData(url, filters) {
        return $http.get(url, filters)
            .then(getComplete)
            .catch(getFailed);

        function getComplete(response) {
            return response.data;
        }

        function getFailed(error) {
        }
    }


    function postData(url, filters) {
        return $http.post(url, filters)
            .then(getComplete)
            .catch(getFailed);

        function getComplete(response) {
            console.log(response.data)
            // if(response.data.status == 200 && response.data.message){
            //     toastr.success(response.data.message);
            // }else if(response.data.error){
            //     toastr.error(response.data.message);
            //
            // }
            return response.data;
        }

        function getFailed(error) {
            toastr.error("Error Occurred !");
        }
    }

}