/**
 * Created by elena on 12.02.16.
 */

app = angular.module('todoListApp', []);

app.controller('TodoListListCtrl', ['$scope', '$http', function($scope, $http) {

    $scope.todoList = [];
    var isFirst;
    var isLast;
    var params = {
        page: 0,
        size: 10,
        isMade: undefined
    };


    function upd() {

        $http.get('/actions', {params:params}).then(function success(responce) {
            $scope.todoList = responce.data.content;
            isFirst = responce.data.first;
            isLast = responce.data.last;
        });
    };

    upd();

    $scope.addAction = function () {
        var action = {
            actionName: $scope.actionName,
            isMade: false
        };

        $http.post('/action', action).then(function success(responce) {
            action.id = responce.data;
            $scope.todoList.push(action);
        });
    };


    $scope.deleteAction = function (id) {
        $http.delete('/action/' + id).then(function success(responce) {
            upd();
        });
    };

    $scope.setMade = function (id) {
        $http.put('/action/isMade/'+id).then(function success(responce) {
            upd();
        });
    };

    $scope.previousPage = function() {
        if(isFirst){
            return;
        }
        params.page--;
        upd();
    };

    $scope.nextPage = function() {

        if (isLast){
            return;
        }
        params.page++;

        upd();
    };

    $scope.isDone = function() {
        params.isMade = true;
        params.page = 0;
        upd();
    };

    $scope.isNotDone = function() {
        params.isMade = false;
        params.page  = 0;
        upd();
    };

    $scope.showAll = function(){
        params.isMade = undefined;
        upd();
    }
}]);

