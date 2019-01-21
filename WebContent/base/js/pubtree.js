$(function(){
	
	if("undefined" == (typeof window.pubtree)){
		window.pubtree = {};
	}
	if("undefined" == (typeof window.pubtree.pf)){
		window.pubtree.pf = {};      //公用方法
	}
	
	//sintree  单选 
	var divid="1";
	window.pubtree.sintree = function(inputid,url,returnfunc){
		 divid = "#sin_seltree_"+inputid;
		if($(divid).length == 0){
			$("#"+inputid).parent().append( pubtree.sintree.pubwinsin_html(inputid) ); 
			pubtree.sintree.ztreeradioinit(inputid,url);			
		}	
		window.pubtree.sintree.zTree = $.fn.zTree.getZTreeObj("sin_ztree_"+inputid);        
		window.pubtree.sintree.returnfunc = returnfunc;		
		$(divid).hide(150);			
		$(divid).click(function(e){  e.stopPropagation(); 	}); //阻止冒泡   点击下拉框内下拉框不消失 
		//$(document).click(function(e){  $(divid).hide(150); });//点击其他地方下拉框消失 	
		
		$("#"+inputid).click(function(){
			$(divid).show(150);	
		});
	};	
	window.pubtree.sintree.setvalue=function(nodeid){
		
		var tr=window.pubtree.sintree.zTree;
		var node=tr.getNodeByParam("nodeid",nodeid);
		   
		tr.selectNode(node);//选择点  
		tr.setting.callback.onClick(null, tr.setting.treeId, node);//调用事件  
	
	}
	
	window.pubtree.sintree.pubwinsin_html = function(inputid) {
		return  '<div id="sin_seltree_'+inputid+'" class="dropdown-tree dropdown-menu">'+
					'<ul id="sin_ztree_'+inputid+'" class="ztree"></ul>'+
				'</div>';
	};
	//ztree参数设置
	window.pubtree.sintree.radiosetting = {
		check: {
			enable: true,                   //是否显示选择框 
			chkStyle: "radio",              //复选checkbox  单选  radio 
			radioType: "all",   
		},
        data:{                  // 使用data定义参数  
            simpleData : {  
                enable : true,  
                idKey : "nodeid",           // id编号命名   
                pIdKey : "parents",         // 父id编号命名    
            },
            key: {
            	children: "children",
            	name: "text",
            },
     	},          
        callback : {             // 回调函数  
            onClick : function(event, treeId, treeNode, clickFlag) {  
            	
            	// $(divid).hide(150);
            	
            	var zTree = pubtree.sintree.zTree;
            	if(treeNode.checked == true){
            		zTree.checkNode(treeNode, false, true, true);
            	}else{
            		zTree.checkNode(treeNode, true, true, true);
            	};	                
            },  
            //节点选择事件
			onCheck: function(e,treeId,treeNode){
				var zTree = pubtree.sintree.zTree;
				
				
				var nodes = zTree.getCheckedNodes(true);
				if("undefined" != typeof nodes[0]){
					pubtree.sintree.returnfunc(nodes[0]);	
				}else{
					nodes = {};
					pubtree.sintree.returnfunc(nodes);	
				} 
				
				$(divid).hide(150);	
		    }, 
        }  
   	}; 
	//ztree初始化 
	window.pubtree.sintree.ztreeradioinit = function(inputid,url){
		var treeid = "#sin_ztree_"+inputid;
		if("string" == typeof url){
			pubtree.sintree.radiosetting.async = {};
			pubtree.sintree.radiosetting.async.url = url;   //异步获取json数据
			pubtree.sintree.radiosetting.async.enable = true;
			pubtree.sintree.radiosetting.async.autoParam = [ "nodeid" ];   //ajax提交的时候，传的是node值 
			var datan = pubtree.pf.loaddata(url,0);
			
			
			$.fn.zTree.init($(treeid), pubtree.sintree.radiosetting, datan);
			
			
		}
		if("object" == typeof url){
			pubtree.sintree.radiosetting.async = {};			
			$.fn.zTree.init($(treeid), pubtree.sintree.radiosetting, url );
		}		
	}; 
	
	//sintree  单选  end 
	
	
	
	
	
	//multree  多选
	
	window.pubtree.multree = function(inputid,url,returnfunc){
		var divid = "#mul_seltree_"+inputid;
		if($(divid).length == 0){
			$("#"+inputid).parent().append( pubtree.multree.pubwinmul_html(inputid)); 
			pubtree.multree.ztreecheckboxinit(inputid,url);
		}	
		window.pubtree.multree.zTree = $.fn.zTree.getZTreeObj("mul_ztree_"+inputid);
		window.pubtree.multree.returnfunc = returnfunc;
		$(divid).toggle(150);		
		$(divid).click(function(e){  e.stopPropagation(); 	}); //阻止冒泡   点击下拉框内下拉框不消失 
		$(document).click(function(e){  $(divid).hide(150); });//点击其他地方下拉框消失 
	};	
	window.pubtree.multree.pubwinmul_html = function(inputid) {
		return  '<div id="mul_seltree_'+inputid+'" class="dropdown-tree dropdown-menu">'+
					'<ul id="mul_ztree_'+inputid+'" class="ztree"></ul>'+
				'</div>';
	};
	//ztree参数设置
	window.pubtree.multree.checkboxsetting = {
		check: {
			enable: true,       //是否显示选择框 
			chkStyle: "checkbox",  //复选checkbox  单选  radio 
			nocheckInherit: true,
			radioType: "all",   
		},
        data:{ // 使用data定义参数  
            simpleData : {  
                enable : true,  
                idKey : "nodeid", // id编号命名   
                pIdKey : "parents", // 父id编号命名    
            },
            key: {
            	children: "children",
            	name: "text"
            },            
     	},  
        // 回调函数  
        callback : {  
            onClick : function(event, treeId, treeNode, clickFlag) {  
            	
            	
            	var zTree = pubtree.multree.zTree;
            	if(treeNode.checked == true){
            		zTree.checkNode(treeNode, false, true, true);
            	}else{
            		zTree.checkNode(treeNode, true, true, true);
            	}
            },  
			onCheck: function(e,treeId,treeNode){
				var zTree = pubtree.multree.zTree;
				var nodes = zTree.getCheckedNodes(true);
				var endstr=[];
				if(nodes.length != 0){			
					for(var k in nodes){
						if(nodes[k].check_Child_State != 1){
							var node = {};
							node.text = nodes[k].text;
							node.nodeid = nodes[k].nodeid;
							node.parents = nodes[k].parents;
							endstr.push(node);
						}								
					}
					var node_json = pubtree.pf.transData(endstr, "nodeid", "parents", "nodes");
					pubtree.multree.returnfunc(node_json);
				}else{
					pubtree.multree.returnfunc(endstr);
				}				
		    }, 
        }  
   	};
	//ztree初始化 
	window.pubtree.multree.ztreecheckboxinit = function(inputid,url){
		var treeid = "#mul_ztree_"+inputid;
		if("string" == typeof url){
			pubtree.multree.checkboxsetting.async = {};
			pubtree.multree.checkboxsetting.async.url = url;   //异步获取json数据
			pubtree.multree.checkboxsetting.async.enable = true;
			pubtree.multree.checkboxsetting.async.autoParam = [ "nodeid" ];   //ajax提交的时候，传的是node值 
			$.fn.zTree.init($(treeid), pubtree.multree.checkboxsetting, pubtree.pf.loaddata(url,0) );
		}
		if("object" == typeof url){
			pubtree.multree.checkboxsetting.async = {};			
			$.fn.zTree.init($(treeid), pubtree.multree.checkboxsetting, url );
		}
	}; 	
	
	//multree 多选   end 	
	
	
	
	//初始数据   父节点为0 
	window.pubtree.pf.loaddata = function(url, nodeids){
		var data;
	 	$.ajax({
	      	url: url,
	      	dataType: "json",
	      	type : 'post',
	      	async: false,
	      	data: {nodeid: nodeids},
	      	success: function(res){
	      		data = res;  
	      		
	      	}
	    });
	 	return data;
	};
	
	/*
	 * 公用方法      
	 */
	// 解析json   转换生成     树结构JSON格式 
	window.pubtree.pf.transData = function(jsons, idStr, pidStr, chindrenStr){  
	    var r = [], hash = {};
	    var id = idStr, pid = pidStr, children = chindrenStr;
	    var i = 0, j = 0, len = jsons.length;  
	    for(; i < len; i++){  
	        hash[jsons[i][id]] = jsons[i];  
	    }  
	    for(; j < len; j++){  
	        var aVal = jsons[j], hashVP = hash[aVal[pid]];  
	        if(hashVP){  
	            !hashVP[children] && (hashVP[children] = []);  
	            hashVP[children].push(aVal);  
	        }else{  
	            r.push(aVal);  
	        }  
	    }  
	    return r;  
	};
	/*
	 * 公用方法    end
	 */
	
});

