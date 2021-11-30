let app = angular.module('app',[]);
app.controller('ctrl',function ($scope,$http){
    $scope.lists = [];
    $scope.isShowId = true;
    $scope.isShowName = true;
    $scope.isShowAge = true;
    $scope.num = 1 ;

    $scope.isCreate = function (){
        $scope.flush();
        $scope.isShowId = true;
        $scope.isShowName = true;
        $scope.isShowAge = true;
        $scope.num = 1 ;
        $scope.queryLists();
    }

    $scope.isQuery = function (){
        $scope.flush();
        $scope.isShowId = true;
        $scope.isShowName = false;
        $scope.isShowAge = false;
        $scope.num = 2 ;
        $scope.queryLists();
    }

    $scope.isEdit = function (listId,listName,listAge){
        $scope.queryData(listId);
        $scope.isShowId = true;
        $scope.isShowName = true;
        $scope.isShowAge = true;
        $scope.orgId = listId;
        $scope.id = listId ;
        $scope.name = listName ;
        $scope.age = listAge ;
        $scope.num = 3 ;
    }

    $scope.cancelData = function (){
        $scope.isCreate();
    }

    $scope.flush = function (){
        $scope.id = '';
        $scope.name = '';
        $scope.age = '';
        $scope.msg = '';
    }

    let url = "http://localhost:8080/students";

    // 撈所有資料
    $scope.queryLists = function (){
        $scope.lists = [];
        $http.get(url).then(function (res){
           // res.data 為陣列格式 [{xxx},{xxx},....]
           // concat : 連結兩陣列 , 但不會改變原本的陣列 , 所以需要再把他丟回原本的lists陣列
            console.log("查詢所有資料成功: "+ res.data);
            $scope.lists = $scope.lists.concat(res.data);
        },function (res){
            console.log("查詢所有資料失敗: "+res.data);
        });
    }

    // 透過id查詢
    $scope.queryData = function (id) {
        $scope.flush();
        $scope.lists = [];
        let urlpath = url+ "/" + id;
        $http.get(urlpath)
            .then(function (response) {
                // $scope.content = response.data.id;
                console.log("response.data:"+response.data);
                if(response.data == ""){
                    $scope.msg = '沒有撈到資料'
                }else{
                    $scope.lists.push(response.data);
                    $scope.msg = '查詢成功';
                }
            }, function (response) {
                $scope.msg = '查詢失敗';
            });
    }

    // 新增
    $scope.addData = function (id,name,age) {
        $scope.flush();
        $scope.lists = [];
        let urlpath = url;
        let data = {
            id: id,
            name: name,
            age: age
        };

        let nameLower = name.toLowerCase();
        if(nameLower === "null" || nameLower === "undefined"){
            $scope.msg = "不能新增: name 不能為null值、空值、undefined ";
            $scope.queryLists();
        }else{
            // 這邊用json格式request
            let jsonData = JSON.stringify(data);
            $http.post(urlpath, jsonData)
                .then(function (response) {
                    // 因Content-type設定json request,所以這邊也要用json response,
                    // 否則會出錯
                    console.log('response.data: '+response.data);
                    $scope.msg = "新增結果: "+response.status+" - "+response.data.msg;
                    $scope.queryLists();
                }, function (response) {
                    console.log('response.data: '+response.data);
                    $scope.msg = "新增結果: "+response.status+" - "+response.data.msg;
                    $scope.queryLists();
                });
        }
    }

    //刪除
    $scope.deleteData = function (id){
        $scope.flush();
        let urlpath = url+ "/" + id;
        // 使用json response, 因為單純回傳String似乎會跑到response失敗(但資料庫資料仍會刪除)
        $http.delete(urlpath,id)
            .then(function (response){
                console.log("responseData成功: "+response.data);
                $scope.lists.splice(id-1,1);
                $scope.msg = "刪除成功: "+response.status+" - "+response.data.msg;
                $scope.queryLists();
        },function (response){
                console.log("responseData失敗: "+response.data);
                $scope.msg= "刪除失敗: "+response.status+" - "+response.data.msg;
                $scope.queryLists();
            });
    }

    // 更新
    $scope.updateData = function (id,name,age){
        $scope.flush();
        $scope.lists = [];
        let urlpath = url+ "/" + $scope.orgId;
        let data = {
            id: id,
            name: name,
            age: age
        };
        let jsonData = JSON.stringify(data);
        $http.put(urlpath,jsonData)
            .then(function (response) {
                $scope.msg = "更新成功: "+response.status+" - "+response.data.msg;
                $scope.queryLists();
                $scope.orgId = 0;
        },function (response){
                $scope.msg = "更新失敗: "+response.status+" - "+response.data.msg;
                $scope.queryLists();
                $scope.orgId = 0;
            });
    }

    // reload網頁時才跑
    $scope.queryLists();


});