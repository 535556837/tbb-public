mainApp.controller('CollectCtrl', function ($scope, $http, ngDialog, $interval, $upload) {
    $scope.jieciList = jieciList;
    $scope.types = types;
    $scope.classes = classes;
    $scope.statuses = statuses;
    $scope.user = user;

    /**
     * Query advices
     */
    $scope.showResults = true;
    $scope.formData = {};
    $scope.pageSizes = ['10', '20', '40', '60', '80', '100'];
    $scope.searchResult = {
        total: 0,
        results: [],
        pageNo: 1,
        size: $scope.pageSizes[0]
    };
    $scope.search = function () {
        $scope.formData.offset = parseInt($scope.searchResult.size) * ($scope.searchResult.pageNo - 1);
        $scope.formData.limit = parseInt($scope.searchResult.size);

        //Clear old data
        $scope.searchResult.results = [];
        $scope.errorMsg = null;
        $scope.loading = true;
        $http.post('AdviceManage/queryAdvice', $scope.formData).success(function (response) {
            $scope.loading = false;
            $scope.searchResult.total = response.total;
            $scope.searchResult.results = response.rows;
        }).error(function (data) {
            $scope.loading = false;
            $scope.errorMsg = 'Error!';
        });
    };
    $scope.newSearch = function () {
        $scope.searchResult.pageNo = 1;
        $scope.search();
    };

    $scope.selectedAdvices = [];
    $scope.containsAdvice = function (advice) {
        for (var i = 0; i < $scope.selectedAdvices.length; i++) {
            if (advice.id == $scope.selectedAdvices[i].id) {
                return true;
            }
        }
        return false;
    };
    $scope.getIndexOfAdvice = function (advice) {
        for (var i = 0; i < $scope.selectedAdvices.length; i++) {
            if (advice.id == $scope.selectedAdvices[i].id) {
                return i;
            }
        }
        return -1;
    };
    $scope.pushAdvice = function (advice) {
        if ($scope.containsAdvice(advice)) {
            return;
        }
        $scope.selectedAdvices.push(advice);
    };
    $scope.toggleAdvice = function (advice) {
        var idx = $scope.getIndexOfAdvice(advice);
        if (idx > -1) {
            $scope.selectedAdvices.splice(idx, 1);
        } else {
            $scope.selectedAdvices.push(advice);
        }
    };

    /**
     * Query union users
     */
    $scope.selectedUnionUsers = [];
    $scope.selectedTempUnionUsers = [];
    $scope.queryUnionUserForm = {};
    $scope.unionUserSearchResult = {
        total: 0,
        results: [],
        pageNo: 1,
        size: 10
    };
    $scope.queryUnionUsers = function () {
        $scope.queryUnionUserForm.offset = $scope.unionUserSearchResult.size * ($scope.unionUserSearchResult.pageNo - 1);
        $scope.queryUnionUserForm.limit = parseInt($scope.searchResult.size);

        //Clear old data
        $scope.unionUserSearchResult.results = [];
        $scope.queryUnionErrorMsg = null;
        $scope.loadingUnionUsers = true;
        $http.post('Advisermanage/getname', $scope.queryUnionUserForm).success(function (response) {
            $scope.loadingUnionUsers = false;
            $scope.unionUserSearchResult.total = response.total;
            $scope.unionUserSearchResult.results = response.rows;
        }).error(function (data) {
            $scope.loadingUnionUsers = false;
            $scope.queryUnionErrorMsg = 'Error!';
        });
    };
    /**
     * Click select union users
     */
    $scope.selectUnionUsers = function () {
        $scope.selectedTempUnionUsers = [];
        for (var i = 0; i < $scope.selectedUnionUsers.length; i++) {
            $scope.pushUnionUser($scope.selectedUnionUsers[i]);
        }
        $scope.selectUnionUserDialog = ngDialog.open({
            template: 'selectUnionUserTemplate.html',
            scope: $scope
        });
        $scope.queryUnionUsers();
    };
    $scope.containsUnionUser = function (unionUser) {
        for (var i = 0; i < $scope.selectedTempUnionUsers.length; i++) {
            if (unionUser.id == $scope.selectedTempUnionUsers[i].id) {
                return true;
            }
        }
        return false;
    };
    $scope.getIndexOfUnionUser = function (unionUser) {
        for (var i = 0; i < $scope.selectedTempUnionUsers.length; i++) {
            if (unionUser.id == $scope.selectedTempUnionUsers[i].id) {
                return i;
            }
        }
        return -1;
    };
    $scope.pushUnionUser = function (unionUser) {
        if ($scope.containsUnionUser(unionUser)) {
            return;
        }
        $scope.selectedTempUnionUsers.push(unionUser);
    };
    $scope.toggleUnionUser = function (unionUser) {
        var idx = $scope.getIndexOfUnionUser(unionUser);
        if (idx > -1) {
            $scope.selectedTempUnionUsers.splice(idx, 1);
        } else {
            $scope.selectedTempUnionUsers.push(unionUser);
        }
    };
    $scope.selectUnionUserAction = function () {
        $scope.selectedUnionUsers = [];
        for (var i = 0; i < $scope.selectedTempUnionUsers.length; i++) {
            $scope.selectedUnionUsers.push($scope.selectedTempUnionUsers[i]);
        }
        $scope.selectUnionUserDialog.close();
    };
    $scope.cancelSelectUnionUser = function () {
        $scope.selectUnionUserDialog.close();
    };
    $scope.clearSelectedUnionUsers = function () {
        $scope.selectedUnionUsers = [];
    };
    $scope.delUnionUser = function (unionUser) {
        var idx = $scope.selectedUnionUsers.indexOf(unionUser);
        if (idx > -1) {
            $scope.selectedUnionUsers.splice(idx, 1);
        }
    };


    $scope.uploadFile = function (files) {
        if (files && files.length) {
            for (var i = 0; i < files.length; i++) {
                var file = files[i];
                $scope.uploading = true;
                $upload.upload({
                    url: '/commonAction/upload',
                    fields: [],
                    file: file
                }).progress(function (evt) {
                    var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
                    $scope.progressPercentage = progressPercentage;
                }).success(function (data, status, headers, config) {
                    $scope.uploadedFileName = file.name;
                    $scope.createForm.advicecontentExt = data.detail;
                    $scope.uploading = false;
                });
            }
        }
    };
    $scope.addAdvice = function () {
        $scope.isEdit = false;
        $scope.showResults = false;
        UE.getEditor("note").setContent('');
        $scope.selectedUnionUsers = [];
        $scope.createForm = {
            ttype: types[0].value,
            tclass: classes[0].value,
            jc: jieciList[0].codeid,
            usersid: $scope.user.usercode,
            sfjgdy: "1",
            tccs: "1",
            sfzctryj: "1",
            unionUserIds: []
        };
    };

    $scope.createForm = {};
    $scope.createFormAction = function (type) {
        var ue = UE.getEditor('note');
        $scope.createForm.note = ue.getContent();
        if ($scope.createForm.ttype == 'U') {
            $scope.createForm.unionUserIds = [];
            for (var i = 0; i < $scope.selectedUnionUsers.length; i++) {
                $scope.createForm.unionUserIds.push($scope.selectedUnionUsers[i].id);
            }
        }
        if (type == 'submit') {
            $scope.createForm.status = 'SU';
        } else {
            $scope.createForm.status = 'DR';
        }
        $scope.saving = true;
        $http.post('AdviceManage/savaAdvice.json', $scope.createForm).success(function (response) {
            $scope.saving = false;
            $scope.newSearch();
            $scope.showResults = true;
        }).error(function (data) {
            $scope.saving = false;
            $scope.savingErrorMsg = 'Error!';
        });
    };

    $scope.edit = function (adviceId) {
        $scope.loadingDetails = true;
        $scope.showResults = false;
        $scope.isEdit = true;
        $http.get('AdviceManage/getAdviceDetails/' + adviceId).success(function (response) {
            $scope.createForm.id = response.id;
            $scope.createForm.title = response.title;
            $scope.createForm.tclass = response.tclass;
            $scope.createForm.jc = response.jc;
            $scope.createForm.usersid = response.usersid;
            $scope.createForm.jb = response.jb;
            $scope.createForm.submitter = response.submitter;
            $scope.createForm.contelephone = response.contelephone;
            $scope.createForm.email = response.email;
            $scope.createForm.address = response.address;
            $scope.createForm.ttype = response.ttype;
            $scope.selectedUnionUsers = response.unionUsers ? response.unionUsers : [];
            $scope.createForm.groupname = response.groupname;
            $scope.createForm.connector = response.connector;
            $scope.createForm.contelephone = response.contelephone;
            $scope.createForm.sfjgdy = response.sfjgdy;
            $scope.createForm.tccs = response.tccs;
            $scope.createForm.sfzctryj = response.sfzctryj;
            $scope.createForm.unit = response.unit;
            $scope.createForm.advicecontentExt = response.advicecontentExt;
            $scope.uploadedFileName = response.advicecontentExt;
            $scope.createForm.note = response.note;
            UE.getEditor("note").setContent(response.note ? response.note : '');
            $scope.loadingDetails = false;

        }).error(function (data) {
            $scope.loadingDetails = false;
            $scope.loadingDetailsErrorMsg = 'Error!';
        });
    };

    /**
     * View advice details.
     */
    $scope.adviceDetails = {};
    $scope.viewDetails = function (adviceId) {
        $scope.loadingDetails = true;
        $scope.showResults = false;
        $scope.isViewDetails = true;
        $http.get('AdviceManage/getAdviceDetails/' + adviceId).success(function (response) {
            $scope.adviceDetails.id = response.id;
            $scope.adviceDetails.title = response.title;
            $scope.adviceDetails.tclass = null;
            for(var i = 0; i< $scope.classes.length; i++) {
                if($scope.classes[i].value == response.tclass) {
                    $scope.adviceDetails.tclass = $scope.classes[i].name;
                    break;
                }
            }
            $scope.adviceDetails.jc = null;
            for(var i = 0; i< $scope.jieciList.length; i++) {
                if($scope.jieciList[i].codeid == response.jc) {
                    $scope.adviceDetails.jc = $scope.jieciList[i].name;
                    break;
                }
            }
            $scope.adviceDetails.usersid = response.usersid;
            $scope.adviceDetails.jb = response.jb;
            $scope.adviceDetails.submitter = response.submitter;
            $scope.adviceDetails.contelephone = response.contelephone;
            $scope.adviceDetails.email = response.email;
            $scope.adviceDetails.address = response.address;
            $scope.adviceDetails.ttype = response.ttype;

            for(var i = 0; i< $scope.types.length; i++) {
                if($scope.types[i].value == response.ttype) {
                    $scope.adviceDetails.ttypeName = $scope.types[i].name;
                    break;
                }
            }
            $scope.selectedUnionUsers = response.unionUsers ? response.unionUsers : [];
            $scope.adviceDetails.groupname = response.groupname;
            $scope.adviceDetails.connector = response.connector;
            $scope.adviceDetails.contelephone = response.contelephone;
            $scope.adviceDetails.sfjgdy = response.sfjgdy;
            $scope.adviceDetails.tccs = response.tccs;
            $scope.adviceDetails.sfzctryj = response.sfzctryj;
            $scope.adviceDetails.unit = response.unit;
            $scope.adviceDetails.advicecontentExt = response.advicecontentExt;
            $scope.adviceDetails.note = response.note;

            $scope.loadingDetails = false;

        }).error(function (data) {
            $scope.loadingDetails = false;
            $scope.loadingDetailsErrorMsg = 'Error!';
        });
    };

    /**
     * Submit advice
     */
    $scope.submitAdvice = function() {
         $scope.submittingAdvice = true;
        var submitAdviceForm = {adviceIds:[]};
        for(var i = 0; i < $scope.selectedAdvices.length; i++) {
            submitAdviceForm.adviceIds.push($scope.selectedAdvices[i].id);
        }
        $http.post('AdviceManage/submit', submitAdviceForm).success(function (response) {
            $scope.submittingAdvice = false;
            $scope.newSearch();
        }).error(function (data) {
            $scope.submittingAdvice = false;
            $scope.submittingErrorMsg = 'Error!';
        });
    };

    /**
     * Delete advice
     */
    $scope.deleteAdvice = function() {
        $scope.deleteAdviceDialog = ngDialog.open({
            template: 'deleteAdviceTemplate.html',
            scope: $scope
        });
    };

    $scope.deleteAdviceAction = function() {
        $scope.deletingAdvice = true;
        var submitAdviceForm = {adviceIds:[]};
        for(var i = 0; i < $scope.selectedAdvices.length; i++) {
            submitAdviceForm.adviceIds.push($scope.selectedAdvices[i].id);
        }
        $scope.deleteAdviceDialog.close();
        $http.post('AdviceManage/delete', submitAdviceForm).success(function (response) {
            $scope.deletingAdvice = false;
            $scope.newSearch();
        }).error(function (data) {
            $scope.deletingAdvice = false;
            $scope.deletingErrorMsg = 'Error!';
        });
    };
    $scope.cancelDeleteAdvice = function () {
        $scope.deleteAdviceDialog.close();
    };

    $scope.newSearch();
});
