 function fillselect(typecode,selectid){
    	 $.ajax({
 			url : 'commonAction/getBaCodeListByMainCode?maincode='+typecode,
 			type : 'POST',
 			dataType : 'json',
 			cache:false,
 			//data : data,
 			success : function(result){
 				//alert(result[0].stringify());
 				
 				 $.each(result, function (n, value) {  
 		             $("#"+selectid).append("<option value='"+value.bacodeid+"' parents='"+ value.bacodemainid +"'types='"+ value.code +"'>"+value.name+"</option>");
 		          });  
 			}
 		});
 		 
     }
 //下拉框：键值为code,name
 function fillselectCN(typecode,selectid){
	 $.ajax({
			url : 'commonAction/commonBaCode.json?typecode='+typecode,
			type : 'POST',
			dataType : 'json',
			cache:false,
			//data : data,
			success : function(result){
				//alert(result[0].stringify());
				
				 $.each(result, function (n, value) {  
		             $("#"+selectid).append("<option value='"+value.code+"'>"+value.name+"</option>");
		          });  
			}
		});
		 
 }
 
 function fillselectMul(typecode,selectid){	
		$("#"+selectid).click(function(){			
			 $.ajax({
					url : 'commonAction/commonBaCode.json?typecode='+typecode,
					type : 'POST',
					dataType : 'json',
					cache:false,
					//data : data,
					success : function(result){
						//alert(result[0].stringify());
						var data=[];						
						 $.each(result, function (n, value) {  
							 var onedata= {"parents":"1001","text":"软件部","leaf":"true","nodeid":"1003"};
							 onedata["text"]=value.name;
							 onedata["nodeid"]=value.codeid;
							 data.push(onedata);
				            /* $("#"+selectid).append("<option value='"+value.codeid+"'>"+value.name+"</option>");*/
				          }); 
						 pubtree.multree(selectid,data,function(ret){
								var inputstr = "";
								var idstr="";
								for(var i=0; i < ret.length; i++){
									if(i==0){
									inputstr = inputstr + ret[i].text + ",";
									}
									idstr=idstr+"'"+ret[i].nodeid+"'";
									if(i!=ret.length-1){
										idstr=idstr+",";
									}									
								}
								$("#"+selectid).val(inputstr+"等"+ret.length+"个");
								$("#"+selectid).attr("data-val",idstr);
							});
					}
				});				
			return false;				
		});	 
 }
//下拉框同步初始化:并设置最大排序码的项为初始值
 function fillselectSyn(typecode,selectid){
 	$.ajax({
 		url:'commonAction/commonBaCode.json?typecode='+typecode,
 		type:"POST",
 		dataType:"json",
 		async:false,
 		success:function(rtx){
 			//$("#"+selectid).find("option").remove();
 			var max="";
 			$.each(rtx, function (n, value){  
 	             $("#"+selectid).append("<option value='"+value.codeid+"'>"+value.name+"</option>");
 	             if(n==rtx.length-1){
 	            	 max=value.codeid;
 	             }
 	        });
 			$("#"+selectid).val(max);
 		}
 		
 	});
 };
//下拉框同步初始化:并设置最大排序码的项为初始值
 function fillselectSynCode(typecode,selectid){
 	$.ajax({
 		url:'commonAction/commonBaCode.json?typecode='+typecode,
 		type:"POST",
 		dataType:"json",
 		async:false,
 		success:function(rtx){
 			//$("#"+selectid).find("option").remove();
 			var max="";
 			$.each(rtx, function (n, value){  
 	             $("#"+selectid).append("<option value='"+value.code+"'>"+value.name+"</option>");
 	             if(n==rtx.length-1){
 	            	 max=value.code;
 	             }
 	        });
 			$("#"+selectid).val(max);
 		}
 		
 	});
 };
//下拉框同步初始化s数据
 function fillselectAsync(typecode,selectid){
	 $.ajax({
			url : 'commonAction/commonBaCode.json?typecode='+typecode,
			type : 'POST',
			dataType : 'json',
			cache:false,
			async:false,
			//data : data,
			success : function(result){
				//alert(result[0].stringify());
				
				 $.each(result, function (n, value) {  
		             $("#"+selectid).append("<option value='"+value.codeid+"'>"+value.name+"</option>");
		          });  
			}
		});
		 
 }
 
 function fillselectSc(typecode,selectid){
	 	$.ajax({
	 		url:'organizeAction/findOrganizeTree?id='+typecode,
	 		type:"POST",
	 		dataType:"json",
	 		async:false,
	 		success:function(rtx){
	 			//$("#"+selectid).find("option").remove();
	 			/*var max="";*/
	 			$.each(rtx, function (n, value){  
	 	             $("#"+selectid).append("<option value='"+value.organizeid+"' parentsid='"+ value.parents +"'>"+value.organizenm+"</option>");
	 	            /* if(n==rtx.length-1){
	 	            	 max=value.codeid;
	 	             }*/
	 	        });
	 			/*$("#"+selectid).val(max);*/
	 		}	 		
	 	});
	 }
//单选按钮组同步加载，codeid和codename
 function fillRadio(typecode,selectid,divid){
	 $.ajax({
			url : 'commonAction/commonBaCode.json?typecode='+typecode,
			type : 'POST',
			dataType : 'json',
			cache:false,
			async:false,
			//data : data,
			success : function(result){
				//console.info(result.length);
				 var str = '';
				 $.each(result, function (n, value) {  
					 if(n == 0){
						 str += '<label class="checkbox-inline i-checks "><input type="radio" name="'+selectid+'" checked="checked" value="'+value.codeid+'" >'+value.name+'</label>';
					 }else{
						 str += '<label class="checkbox-inline i-checks "><input type="radio" name="'+selectid+'" value="'+value.codeid+'">'+value.name+'</label>';
					 }
		          });  
				 //str+="</div>";
				 $("#"+divid).html(str);
			}
		});
 }
//单选按钮组同步加载，code和codename
 function fillRadioCN(typecode,selectid,divid){
	 $.ajax({
			url : 'commonAction/commonBaCode.json?typecode='+typecode,
			type : 'POST',
			dataType : 'json',
			cache:false,
			async:false,
			//data : data,
			success : function(result){
				//console.info("result---------");
				//console.info(result);
				 var str = '';
				 $.each(result, function (n, value) {  
					 if(n == 0){
						 
						 str += '<label class="checkbox-inline i-checks "><input type="radio" name="'+selectid+'" checked="checked" value="'+value.code+'" >'+value.name+'</label>';
					 }else{
						 str += '<label class="checkbox-inline i-checks "><input type="radio" name="'+selectid+'" value="'+value.code+'">'+value.name+'</label>';
					 }
		          });  
				 //str+="</div>";
				 $("#"+divid).html(str);
			}
		});
 }
 
 function getOrganizeInfoByid(organizeid,selectid){
	$.ajax({
 		url:'organizeAction/getOrganizeInfoByid?organizeid='+organizeid,
 		type:"POST",
 		dataType:"json",
 		async:false,
 		success:function(rtx){
 			$.each(rtx, function (n, value){  
 	             $("#"+selectid).append("<option value='"+value.organizeid+"' parentsid='"+ value.parents +"'>"+value.organizenm+"</option>");
 	        });
 		}		 		
 	});
}
 function getOrganizeInfoByidForCity(organizeid,selectid){
		$.ajax({
	 		url:'organizeAction/getOrganizeInfoByid?organizeid='+organizeid,
	 		type:"POST",
	 		dataType:"json",
	 		async:false,
	 		success:function(rtx){
	 			$.each(rtx, function (n, value){  
	 				if(value.organizeid == organizeid){
	 					 $("#"+selectid).append("<option value='"+value.organizeid+"' parentsid='"+ value.parents +"'>"+value.organizenm+"</option>");
	 				}	
	 	        });
	 		}		 		
	 	});
	}