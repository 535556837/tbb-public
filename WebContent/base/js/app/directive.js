angular.module('common.directives', [])
    .directive('focus', function () {
        return {
            restrict: 'A',
            scope: {
                focus: '=focus'
            },
            link: function (scope, element) {
                scope.$watch('focus', function (newValue) {
                    if (newValue) {
                        element[0].focus();
                    }
                });

                element.on('blur', function () {
                    scope.$apply(function () {
                        scope.focus = false;
                    })
                })
            }
        }
    })
    .directive('jdate', function () {
        return {
            restrict: 'EA',
            scope: {
                data: "=ngModel"
            },
            link: function (scope, element, attrs, ctrl) {
                if (attrs.jdate === "date") {
                    $(element).datetimepicker({
                        timepicker: false,
                        lang: "ch",
                        format: "Y-m-d",
                        onChangeDateTime: function (dp, $input) {
                            scope.data = $input.val();
                            scope.$apply();
                        }
                    });

                } else {
                    $(element).datetimepicker({
                        datepicker: false,
                        lang: "ch",
                        step: 30,
                        format: "H:i",
                        onChangeDateTime: function (dp, $input) {
                            scope.data = $input.val();
                            scope.$apply();
                        }
                    });
                }
            }
        }
    }).directive('ueditor', function () {
        return {
            restrict: 'EA',
            scope: {},
            link: function (scope, element, attrs, ctrl) {
                var id = attrs.id;
                var ue = UE.getEditor(id);
            }
        }
    }).directive('bootstrapTable', function () {
        var defaultConfig = {
            clickToSelect: false,
            singleSelect: false,
            toolbar: '#toolbar',
            toolbarAlign: '-',
            pagination: 'true',
            sidePagination: 'server',
            pageList: [10, 25, 50, 100, 'All'],
            showColumns: true,
            cssClass: 'table-hover'
        };

        return {
            restrict: 'E',
            scope: {
                clickToSelect: '=clickToSelect',
                singleSelect: '=singleSelect',
                toolbar: '=toolbar',
                toolbarAlign: '=toolbarAlign',
                pagination: '=pagination',
                height: '=height',
                sidePagination: '=sidePagination',
                pageList: '=pageList',
                showColumns: '=showColumns',
                columns: '=columns',
                url: '=url',
                data:'=data',
                cssClass: '=class'
            },
            template: '<table class="{{configs.cssClass}}"></table>',
            link: function (scope, element) {
                var configs = {
                    clickToSelect: scope.clickToSelect !== undefined ? scope.clickToSelect : defaultConfig.clickToSelect,
                    singleSelect: scope.singleSelect !== undefined ? scope.singleSelect : defaultConfig.singleSelect,
                    toolbar: scope.toolbar !== undefined ? scope.toolbar : defaultConfig.toolbar,
                    toolbarAlign: scope.toolbarAlign !== undefined ? scope.toolbarAlign : defaultConfig.toolbarAlign,
                    pagination: scope.pagination !== undefined ? scope.pagination : defaultConfig.pagination,
                    height: scope.height !== undefined ? scope.height : defaultConfig.height,
                    sidePagination: scope.sidePagination !== undefined ? scope.sidePagination : defaultConfig.sidePagination,
                    pageList: scope.pageList !== undefined ? scope.pageList : defaultConfig.pageList,
                    showColumns: scope.showColumns !== undefined ? scope.showColumns : defaultConfig.showColumns,
                    columns: scope.columns !== undefined ? scope.columns : defaultConfig.columns,
                    cssClass: scope.cssClass !== undefined ? scope.cssClass : defaultConfig.cssClass,
                    url: scope.url !== undefined ? scope.url : undefined
                };
                scope.configs = configs;

                $(element).find(">table").bootstrapTable(scope.configs);
            }
        }
    });