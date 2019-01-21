	 
	 function resize(){
	 		$("#pan2cont").height($("body").height()*0.9);
	 	};
	 
	 function meettypeBtnClick(){
	   
	    $("#meetname").bsSuggest("destroy");
         meetNameBsSuggestInit();
	   
	 }
	 
	function meetNameBsSuggestInit(){
	
	   $("#meetname").bsSuggest({
            url: 'metAction/meetInfoBymeettype.json?meettype='+$("#meettype").val(),
            effectiveFields: ["meetname"],
            
            /*searchFields: [ "shortAccount"],
            effectiveFieldsAlias:{userName: "姓名"},*/
            showBtn: false,
            idField: "meetid",
            keyField: "meetname",
            getDataMethod: "firstByUrl",
            allowNoKeyword: true,
        }).on('onDataRequestSuccess', function (e, result) {
            console.log('onDataRequestSuccess: ', result);
        }).on('onSetSelectValue', function (e, keyword) {
            console.log('onSetSelectValue: ', keyword);
        }).on('onUnsetSelectValue', function (e) {
            console.log("onUnsetSelectValue");
        });
	}
	
 	function modifymeettypeBtnClick(){
	 $("#modifymeetname").bsSuggest("destroy");
	    modifymeetnameBsSuggestInit();
	}
	
	function modifymeetnameBsSuggestInit(){
	
	  $("#modifymeetname").bsSuggest({
            url: 'metAction/meetInfoBymeettype.json?meettype='+$("#modifymeettype").val(),
            effectiveFields: ["meetname"],
            
            /*searchFields: [ "shortAccount"],
            effectiveFieldsAlias:{userName: "姓名"},*/
            showBtn: false,
            idField: "meetid",
            keyField: "meetname",
            getDataMethod: "firstByUrl",
            allowNoKeyword: true,
        }).on('onDataRequestSuccess', function (e, result) {
            console.log('onDataRequestSuccess: ', result);
        }).on('onSetSelectValue', function (e, keyword) {
            console.log('onSetSelectValue: ', keyword);
        }).on('onUnsetSelectValue', function (e) {
            console.log("onUnsetSelectValue");
        });
	} 
 
	 
	 
	 
	 //给表单验证添加日期比较方法
	 $.validator.addMethod("dateCompare",function(value,element,params){
	    
	    
	     var beginTime =$("#calldate").val().split("-");
         var endTime =  value.split("-");
         var beginTimeDate = new Date(beginTime[0],beginTime[1],beginTime[2]);
         var endTimeDate = new Date(endTime[0],endTime[1],endTime[2]);
         var state = Date.parse(endTimeDate)-Date.parse(beginTimeDate);
         if(state<0){
         return false;
         }else{
         return true;
         }
	 },"会议开始日期大于结束日期");
	 $.validator.addMethod("modifydateCompare",function(value,element,params){
	    
	    
	      var beginTime =$("#modifycalldate").val().split("-");
          var endTime =  value.split("-");
         var beginTimeDate = new Date(beginTime[0],beginTime[1],beginTime[2]);
         var endTimeDate = new Date(endTime[0],endTime[1],endTime[2]);
         var state = Date.parse(endTimeDate)-Date.parse(beginTimeDate);
         if(state<0){
         return false;
         }else{
         return true;
         }
      
	 },"会议开始日期大于结束日期");
	 
	 function currentmeet(meetid) {
	   var data= {};
	   data['meetid'] = meetid;
	   $.ajax({
				url : 'metAction/meetInfo.json',
				type : 'POST',
				dataType : 'json',
				data : data,
				success : function(result){
				  if(result.iscurrentmeet == null || result.iscurrentmeet == "" || result.iscurrentmeet=="0"){
				     updateCurrentMeet(meetid,"1");
				  }else{
				    updateCurrentMeet(meetid,"0");
				  }
				  
				}
			});
		
	   }
	   
	   function updateCurrentMeet(meetid,isCurrentmeetState){
	   
	   var data= {};
	   data['meetid'] = meetid;
	   data['isCurrentmeetState'] = isCurrentmeetState;
	   $.ajax({
				url : 'metAction/updateIsCurrentmeet.json',
				type : 'POST',
				dataType : 'json',
				data : data,
				success : function(result){
					if(result.result == "success"){
						toastr.success("提示","修改成功");
					}else{
						toastr.error("提示","修改失败");
					}
					$("#reset").trigger("click");
				}
			});
	   }
	  
    $(function(){
    
    
    
    
      meetNameBsSuggestInit();
      modifymeetnameBsSuggestInit();
       $("#queryInputId").bsSuggest({
            //url: "/rest/sys/getuserlist?keyword=",
            url: 'metAction/queryMeetInfosList.json',
            effectiveFields: ["meetname"],
            /*searchFields: [ "shortAccount"],
            effectiveFieldsAlias:{userName: "姓名"},*/
            showBtn: false,
            idField: "meetid",
            keyField: "meetname",
            allowNoKeyword: false
        }).on('onDataRequestSuccess', function (e, result) {
            console.log('onDataRequestSuccess: ', result);
        }).on('onSetSelectValue', function (e, keyword) {
            console.log('onSetSelectValue: ', keyword);
        }).on('onUnsetSelectValue', function (e) {
            console.log("onUnsetSelectValue");
        });
      
      
      function refersh() {
     	  var data = {};
			query(data);
		}
     	
     	function query(data){
			$('#table').bootstrapTable('refresh',{
			 	url: 'metAction/meetInfosList.json',
				query: data
			}); 
		}
       
        
       
      //查询 
	  $("#button1").click(function(){
	  
	   var data = {
	    "keys":$('#queryInputId').val()
	   }
	   query(data);
	  
	  });
      
      
      var validate;
      //外部js调用
        laydate({
            elem: '#calldate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });
      
       laydate({
            elem: '#enddate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });
      
      
       laydate({
            elem: '#modifycalldate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });
      
       laydate({
            elem: '#modifyenddate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });
     
   
       	
        $('#table').bootstrapTable({
					    url: 'metAction/meetInfosList.json',
					    clickToSelect:true,
					    singleSelect:true,
					    maintainSelected:true,
					    toolbar:'#toolbar',
					    toolbarAlign:'-',
					    pagination:'true', 
					    height:400,
					    sidePagination:'server',
					    pageList:[10, 25, 50, 100,'All'],
					    showColumns:true,
					    queryParams:tableQueryParams,
					    columns: [{
					        title: '会议ID',
					        field: 'meetid',
					        visible:false
					    },{
					      title: '',
					        field: 'state',
					        radio:true
					    },{
					        title: '会议类型',
					        field: 'meettype',
					 
					    },{
					        title: '会议名称',
					        field: 'meetname',
					   
					    },{
					        title: '会议简称',
					        field: 'meetbriname',
					      
					    },{
					        title: '届',
					        field: 'meetsession'
					    }, {
					        title: '次',
					        field: 'meettimes'
					    },{
					        title: '会议召开时间',
					        field: 'calldate',
					        formatter: function(value,row,index){
					         var startTime = value.substring(0,10);
					         return startTime;
					        }
					    },{
					        title: '会议结束时间',
					        field: 'enddate',
					        formatter: function(value,row,index){
					         var endTime = value.substring(0,10);
					         return endTime;
					        }  
					    },{
					        title: '召开地点',
					        field: 'calladdress',
					      
					    },{
					        title: '备注',
					        field: 'remark',
					     
					    },{
					     title : '设置当前会议',
		                 field : 'iscurrentmeet',
		                 formatter: function(value,row,index){
		                     
		                              if(value==null || value=="" || value == "0"){
		                               return '<input type="checkbox" onclick=javascript:currentmeet("'+row.meetid+'") />';
		                               }else if(value =='1'){
		                                 return '<input type="checkbox" onclick=javascript:currentmeet("'+row.meetid+'") checked="checked">';
		                             }
			                       }
					    }]
					}); 
					
					function tableQueryParams(params){
					   if($("#queryInputId").val() != null && $("#queryInputId").val() != "" ){
					   
					       params['keys'] =  $("#queryInputId").val();
					   }
					     return  params;
					}
					
					$("#button2").click(function(){
					        $("#myModal2").modal('show');
					});
					
					$("#savebtn").click(save);//新增窗口的保存按钮
					
					var icon = "<i class='fa fa-times-circle'></i>";
					validate = $("#form-horizontal").validate({
		                rules: {
		                    meetsession: {
		                        required: true,
		                    },
		                    meettimes: {
		                        required: true,
		                        
		                    },
		                    meetname: {
		                        required: true,
		                    },
		                    calladdress: {
		                        required: true,
		                    },
		                    calldate: {
		                        required: true,
		                        dateISO:true,
		                        
		                    },
		                    meetbriname: {
		                        required: true,
		                        
		                    },
		                    meettype: {
		                        required: true,
		                    },
		                    enddate:{
		                         required: true,
		                         dateCompare:true,
		                         dateISO:true,
		                    }
		                },
		                messages: {
		                    meetsession: {
		                        required: icon + "请选择届次",
		                    },
		                    meettimes: icon + "请选择第几次会议",
		                    meetname: {
		                        required: icon + "请输入会议名称",
		                      
		                    },		                    
		                    calladdress: icon + "请输入会议召开地点",
		                    calldate:{
		                       required:icon + "请选择召开时间",
		                       dateISO:icon+"输入正确日期类型",
		                     },
		                    enddate:{ required:icon + "请选择结束时间",
		                              dateISO:icon+"输入正确日期类型",
		                              dateCompare:icon+"会议结束时间大于开始时间",
		                              
		                      },
		                    meetbriname:icon + "请输入会议简称",
		                     meettype:icon + "请选择会议类型"
		                    
		                }
		            });
		            
		            	/******* 保存用户 *********/
	      function save(){
	  		var formflag = validate.form();//表单验证
	  		//alert(formflag); 
	  		if(!formflag){
	  			 return;
	  		}
	  	   var data = getMeetInfo();
			$.ajax({
				url : 'metAction/addMeetInfo.json',
				type : 'POST',
				dataType : 'json',
				data : data,
				success : function(result){
					if(result.result == "success"){
						$("#myModal2").modal('hide');
						refersh();
						toastr.success("提示","添加成功！");
					}else{
						$("#myModal2").modal('hide');
						//toastr.error("提示","添加失败！");
						toastr.error("提示",result.detail);
					}
					$("#reset").trigger("click");
				}
			});
			
			function getMeetInfo(){
     		var data = {};
     		data['meetsession']= $("#meetsession").val();
     		data['meettimes']=$("#meettimes").val();
     		data['calldate']=$("#calldate").val();
     		data['enddate']=$("#enddate").val();
     		data['calladdress']=$("#calladdress").val();
     		data['meetname']=$("#meetname").val();
     		data['meetbriname']=$("#meetbriname").val();
     		data['meettype']=$("#meettype").val();
     		data['remark']=$("#remark").val();
     		data['operuserid']=$("#OperUserID").val();
     		return data;
     	     }
		}
		
		//删除按钮 
		$("#button4").click(function(){
			var selectRow = $('#table').bootstrapTable('getSelections','');
			if(selectRow.length!=0){
			     	$("#myModal3").modal('show');
			  }else{
			     toastr.warning("提示","请选中一行数据！");
		     }
		});
		
		$("#delyesbtn").click(delmeetInfo);
		
		function delmeetInfo(){
			  var del_meetid='';
			  var selectRow = $('#table').bootstrapTable('getSelections','');
			  if(selectRow.length!=0){
			     	del_meetid = selectRow[0].meetid;
			   }
			   $.ajax({
				  url:'metAction/deletemeetinfo.json',
				  type:'POST',
				  dataType:'json',
				  data:{'meetid': del_meetid},
				  success:function(result){
				  if(result.result == "success"){
						toastr.success("提示","删除成功！");
							refersh();
						}else if(result == 'fail'){
							toastr.error("提示","删除失败！");
						}
					  },
					 error : {}
		     });
	   }
	   
	   //修改 
		$("#button3").click(modify_meetInfo);
		
			
		  
		  function modify_meetInfo(){
		  var tablerowsnum=$("#table").bootstrapTable('getOptions', '').data.length;//表格的数据条数
		if(tablerowsnum==0){     //没有数据的时候不弹窗
			toastr.warning("提示","没有可修改数据！");
			return;
		}
		var selectrow=$("#table").bootstrapTable('getSelections', '');
		if(selectrow.length==0){     //没选中默认选中第一行 
			$("#table").bootstrapTable('check', 0);
		}
		selectrow=$("#table").bootstrapTable('getSelections', '');
		$("#myModal1").modal('show');
		if(selectrow.length!= 0){
				$("#modifymeetsession").val(selectrow[0].meetsession);
				$("#modifymeettimes").val(selectrow[0].meettimes);
				$("#modifymeettype").val(selectrow[0].meettype);
				$("#modifycalladdress").val(selectrow[0].calladdress);
				$("#modifymeetname").val(selectrow[0].meetname);
				
				
				$("#modifyremark").val(selectrow[0].remark);
				$("#modifymeetbriname").val(selectrow[0].meetbriname);
				$("#meetid").val(selectrow[0].meetid);
				
				//日期格式处理
				var startTime = selectrow[0].calldate.substring(0,10);
				$("#modifycalldate").val(startTime);
				
				var endTime = selectrow[0].enddate.substring(0,10);
				$("#modifyenddate").val(endTime);
				
		  }
		  }
		  
	   $("#modify_savebtn").click(updateMeetInfo);//修改窗口的保存按钮
	   
	   /*******修改用户信息验证**********/
	   var modify_validate;
	   modify_validate = $("#modify-form-horizontal").validate({
		                rules: {
		                    modifymeetsession: {
		                        required: true,
		                    },
		                    modifymeettimes: {
		                        required: true,
		                        
		                    },
		                    modifymeetname: {
		                        required: true,
		                    }
		                    ,
		                    modifycalladdress: {
		                        required: true,
		                    }
		                    ,
		                    modifycalldate: {
		                        dateISO:true,
		                        required: true,
		                    },
		                    modifymeetbriname: {
		                        required: true,
		                    },
		                    modifymeettype: {
		                        required: true,
		                    },
		                    modifyenddate:{
		                         required: true,
		                         dateISO:true,
		                         modifydateCompare:true,
		                    }
		                    
		                },
		                messages: {
		                    modifymeetsession: {
		                        required: icon + "请选择届次",
		                    },
		                    modifymeettimes: icon + "请选择第几次会议",
		                    modifymeetname: {
		                        required: icon + "请输入会议名称",
		                      
		                    },		                    
		                    modifycalladdress: icon + "请输入会议召开地点",
		                    modifycalldate:{
		                      required:icon + "请选择召开时间",
		                      dateISO:icon+"输入正确日期类型",
		                     },
		                    modifyenddate:{ required:icon + "请选择结束时间",
		                    dateISO:icon+"输入正确日期类型",
		                    modifydateCompare:icon+"会议开始时间大于结束时间",
		                    },
		                    modifymeetbriname:icon + "请输入会议简称",
		                    modifymeettype:icon + "请选择会议类型"
		                    
		                }
		            });
	   
   /******* 修改用户 *********/
     	function updateMeetInfo(){
     	
     	var formflag = modify_validate.form();//表单验证
	  		//alert(formflag); 
	  		if(!formflag){
	  			 return;
	  		}
     	
        	
     		var data = getMeetInfo_modify();
     		console.info(data);
			$.ajax({
				url : 'metAction/modifyMeetInfo.json',
				type : 'POST',
				dataType : 'json',
				data : data,
				success : function(result){
					console.info(result);
					if(result.result == "success"){
						$("#myModal1").modal('hide');
						
						toastr.success("提示","修改成功！");
						refersh();
					}else{
						toastr.error("提示",result.detail);
					}
				   $("#reset").trigger("click");
				}
			});
     	}
     	
     	function getMeetInfo_modify(){
     		var data = {};
     		data['meetsession']= $("#modifymeetsession").val();
     		data['meettimes']=$("#modifymeettimes").val();
     		data['calldate']=$("#modifycalldate").val();
     		data['enddate']=$("#modifyenddate").val();
     		data['calladdress']=$("#modifycalladdress").val();
     		data['meetname']=$("#modifymeetname").val();
     		data['meetbriname']=$("#modifymeetbriname").val();
     		data['meettype']=$("#modifymeettype").val();
     		data['remark']=$("#modifyremark").val();
     		data['meetid']  = $("#meetid").val();
     		data['modifyuserid']=$("#OperUserID").val();
     		return data;
     	
     	}
     	
     	 
		
    });
    
    $(function(){
		     	
    	fillselect("SESSION","modifymeetsession");
    	fillselect("SESSION","meetsession");  
    	fillselect("TIMES","meettimes");  
    	
    });