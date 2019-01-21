mainApp.controller('ApproveCtrl', function ($scope, $http, ngDialog) {
    $scope.jieciList = jieciList;
    $scope.types = types;
    $scope.classes = classes;
    $scope.contentTypes = contentTypes;
    $scope.approveStatuses = approveStatuses;

    /**
     * Query advices
     */
    $scope.showResults = true;
    $scope.formData = {status: 'SU'};
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
     * View advice details.
     */
    $scope.adviceDetails = {};
    $scope.loadAdviceDetails = function (adviceId) {
        $scope.isViewDetails = true;
        $http.get('AdviceManage/getAdviceDetails/' + adviceId).success(function (response) {
            $scope.adviceDetails.id = response.id;
            $scope.adviceDetails.title = response.title;
            $scope.adviceDetails.tclass = null;
            for (var i = 0; i < $scope.classes.length; i++) {
                if ($scope.classes[i].value == response.tclass) {
                    $scope.adviceDetails.tclass = $scope.classes[i].name;
                    break;
                }
            }
            $scope.adviceDetails.jc = null;
            for (var i = 0; i < $scope.jieciList.length; i++) {
                if ($scope.jieciList[i].codeid == response.jc) {
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

            for (var i = 0; i < $scope.types.length; i++) {
                if ($scope.types[i].value == response.ttype) {
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
    $scope.viewDetails = function (adviceId) {
        $scope.showResults = false;
        $scope.loadAdviceDetails(adviceId);
    };

    /**
     * Approve advice
     */
    $scope.selectedApproveAdvice = null;
    $scope.approveForm = {};
    $scope.approveAdvice = function (advice) {
        $scope.selectedApproveAdvice = advice;
        $scope.approveForm.id = advice.id;
        $scope.approveForm.adviceid = advice.adviceid;
        $scope.approveForm.contenttype = $scope.contentTypes[0].value;
        $scope.approveForm.status = $scope.approveStatuses[0].value;
        $scope.approveForm.qstime = advice.qstime;
        $scope.approveForm.advicemsg = advice.advicemsg;
        $scope.approveForm.keyProject = advice.iskeysupervise == '1'?true:false;

        $scope.approveAdviceDialog = ngDialog.open({
            template: 'approveAdviceTemplate.html',
            scope: $scope
        });
    };

    $scope.approveAdviceAction = function () {
        $scope.approving = true;
        if($scope.approveForm.keyProject) {
            $scope.approveForm.iskeysupervise = '1';
        } else {
            $scope.approveForm.iskeysupervise = '0';
        }
        $http.post('AdviceManage/approve', $scope.approveForm).success(function (response) {
            $scope.approving = false;
            $scope.cancelApproveAdvice();
            $scope.newSearch();
        }).error(function (data) {
            $scope.approving = false;
            $scope.approveErrorMsg = 'Error!';
        });
    };
    $scope.cancelApproveAdvice = function () {
        $scope.approveAdviceDialog.close();
    };


    $scope.newSearch();
});
