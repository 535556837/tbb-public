mainApp.controller('AssignedCtrl', function ($scope, $http, ngDialog) {
    $scope.jieciList = jieciList;
    $scope.types = types;
    $scope.classes = classes;
    $scope.today = today;

    /**
     * Query advices
     */
    $scope.showResults = true;
    $scope.formData = {status: 'AA'};
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
     * Handle advice
     */
    $scope.selectedHandleAdvice = null;
    $scope.handleForm = {units: []};
    $scope.handleAdvice = function (advice) {
        $scope.selectedHandleAdvice = advice;
        $scope.handleForm.units = [];
        $scope.handleForm.registerdate = $scope.today;
        $scope.isHandle = true;
        $scope.showResults = false;
        $scope.queryUnits();
    };

    $scope.handleAdviceAction = function () {
        $scope.handling = true;
        $scope.handleForm.units = $scope.selectedUnits;
        $scope.handleForm.adviceId = $scope.selectedHandleAdvice.id;
        $http.post('AdviceManage/assign', $scope.handleForm).success(function (response) {
            $scope.handling = false;
            $scope.cancelHandleAdvice();
            $scope.newSearch();
        }).error(function (data) {
            $scope.handling = false;
            $scope.handleErrorMsg = 'Error!';
        });
    };
    $scope.cancelHandleAdvice = function () {
        $scope.isHandle = false;
        $scope.showResults = true;
    };

    /**
     * Query units
     */
    $scope.selectedTempUnits = [];
    $scope.selectedUnits = [];
    $scope.queryUnitForm = {};
    $scope.unitSearchResult = {
        total: 0,
        results: [],
        pageNo: 1,
        size: 10
    };
    $scope.queryUnits = function () {
        $scope.queryUnitForm.offset = $scope.unitSearchResult.size * ($scope.unitSearchResult.pageNo - 1);
        $scope.queryUnitForm.limit = parseInt($scope.unitSearchResult.size);

        //Clear old data
        $scope.unitSearchResult.results = [];
        $scope.queryUnitErrorMsg = null;
        $scope.loadingUnits = true;
        $http.post('AdviceManage/QueryActive_Unit', $scope.queryUnitForm).success(function (response) {
            $scope.loadingUnits = false;
            $scope.unitSearchResult.total = response.total;
            $scope.unitSearchResult.results = response.rows;
        }).error(function (data) {
            $scope.loadingUnits = false;
            $scope.queryUnitErrorMsg = 'Error!';
        });
    };

    /**
     * Click select units
     */
    $scope.containsUnit = function (unit) {
        for (var i = 0; i < $scope.selectedTempUnits.length; i++) {
            if (unit.id == $scope.selectedTempUnits[i].id) {
                return true;
            }
        }
        return false;
    };
    $scope.getIndexOfUnit = function (unit) {
        for (var i = 0; i < $scope.selectedTempUnits.length; i++) {
            if (unit.id == $scope.selectedTempUnits[i].id) {
                return i;
            }
        }
        return -1;
    };
    $scope.pushUnit = function (unit) {
        if ($scope.containsUnit(unit)) {
            return;
        }
        $scope.selectedTempUnits.push(unit);
    };
    $scope.toggleUnit = function (unit) {
        var idx = $scope.getIndexOfUnit(unit);
        if (idx > -1) {
            $scope.selectedTempUnits.splice(idx, 1);
        } else {
            $scope.selectedTempUnits.push(unit);
        }
    };
    $scope.setHandle = function (type) {
        var toSelectedUnits = [];
        for (var i = 0; i < $scope.selectedTempUnits.length; i++) {
            var found = false;
            for (var j = 0; j < $scope.selectedUnits.length; j++) {
                if ($scope.selectedUnits[j].unitid == $scope.selectedTempUnits[i].id) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                toSelectedUnits.push($scope.selectedTempUnits[i]);
            }
        }

        var unittype = null;
        if (type == 1) {
            unittype = '主办';
        } else if (type == 2) {
            unittype = '分办';
        } else if (type == 3) {
            unittype = '会办';
        }

        for (var i = 0; i < toSelectedUnits.length; i++) {
            var unit = toSelectedUnits[i];
            var selectedUnit = {
                advicepk: $scope.selectedHandleAdvice.id,
                unitid: unit.id,
                unitname: unit.unitname,
                unittype: unittype
            };
            $scope.selectedUnits.push(selectedUnit);
        }
    };
    $scope.deleteSelectedUnit = function(unit) {
        var idx = -1;
        for(var i = 0; i < $scope.selectedUnits.length; i++) {
            if(unit.unitid == $scope.selectedUnits[i].unitid) {
                idx = i;
                break;
            }
        }
        if (idx > -1) {
            $scope.selectedUnits.splice(idx, 1);
        }
    };
    $scope.newSearch();
});
