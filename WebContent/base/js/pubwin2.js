$(function() {
		
	if("undefined" == (typeof window.pubwin)){
		window.pubwin = {};
	}
	if("undefined" == (typeof window.pubwin.pf)){
		window.pubwin.pf = {};      //公用方法
	}
	if("undefined" == (typeof window.pubwin.dt)){
		window.pubwin.dt = {};      //缓存数据
	}
	
	///user  单选
	var pubwinuser_html =
		'<div class="modal inmodal fade" id="pubwinuser_Modal" tabindex="-1" '+
				'role="dialog" aria-hidden="true"  data-remote="user.html">'+
			'<div class="modal-dialog " style="width:80%;">'+
				'<div class="modal-content animated bounceInRight"> '+
				'</div>'+
		   '</div>'+
		'</div>';
	window.pubwin.user = function(opts,returnfunc){
		$("#pubwinuser_Modal").remove(); 
		$("body").append( pubwinuser_html); 
		window.pubwin.user.opts = opts;
		window.pubwin.user.returnfunc = returnfunc;
		$('#pubwinuser_Modal').modal('show');			
	};
	//user  end
	
	///users  多选
	var pubwinusers_html =
		'<div class="modal inmodal fade" id="pubwinusers2_Modal" tabindex="-1" '+
				'role="dialog" aria-hidden="true"  data-remote="jsp/util/pubwinUsers2.html">'+
			'<div class="modal-dialog " style="width:80%;">'+
				'<div class="modal-content animated bounceInRight"> '+
				'</div>'+
		   '</div>'+
		'</div>';
	window.pubwin.users = function(opts,returnfunc){
		$("#pubwinusers2_Modal").remove(); 
		$("body").append( pubwinusers_html); 
		window.pubwin.users.opts = opts;
		window.pubwin.users.returnfunc = returnfunc;
		$('#pubwinusers2_Modal').modal('show');			
	};
	//users  end
		
	///meetusers  多选
	var pubwinmeetusers_html =
		'<div class="modal inmodal fade" id="pubwinusers3_Modal" tabindex="-1" '+
				'role="dialog" aria-hidden="true"  data-remote="jsp/util/pubwinUsers1.html">'+
			'<div class="modal-dialog " style="width:80%;">'+
				'<div class="modal-content animated bounceInRight"> '+
				'</div>'+
		   '</div>'+
		'</div>';
	window.pubwin.meetusers = function(opts,returnfunc){
		$("#pubwinusers3_Modal").remove(); 
		$("body").append( pubwinmeetusers_html); 
		window.pubwin.users.opts = opts;
		window.pubwin.users.returnfunc = returnfunc;
		$('#pubwinusers3_Modal').modal('show');			
	};
	//users  end	
		
	//alert start
	var pubwinalert_html=function(title,content,width){
		if("undefined" == (typeof width)){
			width="";
		}else{
			width="width:"+width;
		}
		return '<div class="modal inmodal fade" id="pubwinalert_Modal" tabindex="-1" role="dialog" aria-hidden="true">'+
			'<div class="modal-dialog modal-sm"  style="'+width+'">'+
				'<div class="modal-content">'+
					'<div class="modal-header">'+
						'<button type="button" class="close" data-dismiss="modal">'+
							'<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>'+
						'</button>'+
						'<h4 class="modal-title">'+title+'</h4>'+
					'</div>'+
					'<div class="modal-body">'+
						'<p>'+
							content+
						'</p>'+
					'</div>'+
					'<div class="modal-footer">'+ 
						'<button type="button" id="pubwinalert_btn" class="btn btn-primary" data-dismiss="modal">确认</button>'+
					'</div>'+
				'</div>'+
			'</div>'+
		'</div>'
		;};
	
	window.pubwin.alert=function(title,content,func,width){ 
		$("#pubwinalert_Modal").remove();
		$("body").append( pubwinalert_html(title,content,width)); 
		$('#pubwinalert_Modal').on('hide.bs.modal',  func); 
		$('#pubwinalert_Modal').modal('show');   
	};
	//alert end	
		
		
		
	//confrim start
	var pubwinconfrim_html=function(title,content,width){
		if("undefined" == (typeof width)){
			width="";
		}else{
			width="width:"+width;
		}
		return '<div class="modal inmodal fade" id="pubwinconfrim_Modal" tabindex="-1" role="dialog" aria-hidden="true">'+
			'<div class="modal-dialog modal-sm"  style="'+width+'">'+
				'<div class="modal-content">'+
					'<div class="modal-header">'+
						'<button type="button" class="close" data-dismiss="modal">'+
							'<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>'+
						'</button>'+
						'<h4 class="modal-title">'+title+'</h4>'+
					'</div>'+
					'<div class="modal-body">'+
						'<p>'+
							content+
						'</p>'+
					'</div>'+
					'<div class="modal-footer">'+ 
						'<button type="button" id="pubwinconfrim_btn2" class="btn btn-white" data-dismiss="modal">取消</button>'+
						'<button type="button" id="pubwinconfrim_btn" class="btn btn-primary" data-dismiss="modal">确认</button>'+
					'</div>'+
				'</div>'+
			'</div>'+
		'</div>'
		;};
	
	window.pubwin.confrim=function(title,content,func,func2,width){ 
		$("#pubwinconfrim_Modal").remove();
		$("body").append( pubwinconfrim_html(title,content,width));
		$('#pubwinconfrim_btn').on("click", func );
		$('#pubwinconfrim_btn2').on("click", func2);
		$('#pubwinconfrim_Modal').modal('show');   
	}; 
	//confrim end
		
	//confrim2 start
	var pubwinconfrim2_html=function(title,content,width){
		if("undefined" == (typeof width)){
			width="";
		}else{
			width="width:"+width;
		}
		return '<div class="modal inmodal fade" id="pubwinconfrim2_Modal" tabindex="-1" role="dialog" aria-hidden="true">'+
			'<div class="modal-dialog modal-sm"  style="'+width+'">'+
				'<div class="modal-content">'+
					'<div class="modal-header">'+
						'<button type="button" class="close" data-dismiss="modal">'+
							'<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>'+
						'</button>'+
						'<h4 class="modal-title">'+title+'</h4>'+
					'</div>'+
					'<div class="modal-body">'+
						'<p>'+
							content+
						'</p>'+
					'</div>'+
					'<div class="modal-footer">'+ 
						'<button type="button" id="pubwinconfrim_btn2" class="btn btn-white" data-dismiss="modal">取消</button>'+
						'<button type="button" id="pubwinconfrim_btn" class="btn btn-primary" data-dismiss="modal">确认</button>'+
						'<button type="button" id="pubwinconfrim_btn3" class="btn btn-info" data-dismiss="modal">确认并继续撰写</button>'+
					'</div>'+
				'</div>'+
			'</div>'+
		'</div>'
		;};
	
	window.pubwin.confrim2=function(title,content,func,func2,func3,width){ 
		$("#pubwinconfrim2_Modal").remove();
		$("body").append( pubwinconfrim2_html(title,content,width));
		$('#pubwinconfrim_btn').on("click", func );
		$('#pubwinconfrim_btn2').on("click", func2);
		$('#pubwinconfrim_btn3').on("click", func3);
		$('#pubwinconfrim2_Modal').modal('show');   
	}; 
	//confrim end
	
	//prompt start
	var pubwinprompt_html=function(title,content,width){ 
		if("undefined" == (typeof width)){
			width="";
		}else{
			width="width:"+width;
		}
		return '<div class="modal inmodal fade" id="pubwinprompt_Modal" tabindex="-1" role="dialog" aria-hidden="true">'+
			'<div class="modal-dialog modal-sm"  style="'+width+'">'+
				'<div class="modal-content">'+
					'<div class="modal-header">'+
						'<button type="button" class="close" data-dismiss="modal">'+
							'<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>'+
						'</button>'+
						'<h4 class="modal-title">'+title+'</h4>'+
					'</div>'+
					'<div class="modal-body">'+
						'<p>'+
							content+
						'</p>'+
						'<input type="text" id="pubwinprompt_input" placeholder="请输入" class="form-control" name="name" required="" aria-required="true">'+
					'</div>'+
					'<div class="modal-footer">'+ 
						'<button type="button" id="pubwinprompt_btn2" class="btn btn-white" data-dismiss="modal">取消</button>'+
						'<button type="button" id="pubwinprompt_btn" class="btn btn-primary" data-dismiss="modal">确认</button>'+
					'</div>'+
				'</div>'+
			'</div>'+
		'</div>'
		;};
	
	window.pubwin.prompt=function(title,content,func,func2,width){ 
		$("#pubwinprompt_Modal").remove();
		$("body").append( pubwinprompt_html(title,content,width));
		$('#pubwinprompt_btn').on("click", function(){  func($('#pubwinprompt_input').val());  });
		$('#pubwinprompt_btn2').on("click", function(){  func2($('#pubwinprompt_input').val()); });
		$('#pubwinprompt_Modal').modal('show');   
	};
	//prompt end
		
	
	
	//form start
	var pubwinform_html=function(title,content,form,width){ 
		if("undefined" == (typeof width)){
			width="";
		}else{
			width="width:"+width;
		}
		return '<div class="modal inmodal fade" id="pubwinform_Modal" tabindex="-1" role="dialog" aria-hidden="true">'+
			'<div class="modal-dialog modal-sm"  style="'+width+'">'+
				'<div class="modal-content">'+
					'<div class="modal-header">'+
						'<button type="button" class="close" data-dismiss="modal">'+
							'<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>'+
						'</button>'+
						'<h4 class="modal-title">'+title+'</h4>'+
					'</div>'+
					'<div class="modal-body">'+
						'<p>'+
							content+
						'</p>'+
						'<form id="pubwinform_form">'+form+
						'</form>'+
					'</div>'+
					'<div class="modal-footer">'+ 
						'<button type="button" id="pubwinform_btn2" class="btn btn-white" data-dismiss="modal">取消</button>'+
						'<button type="button" id="pubwinform_btn" class="btn btn-primary" data-dismiss="modal">确认</button>'+
					'</div>'+
				'</div>'+
			'</div>'+
		'</div>'
		;};
	
	window.pubwin.form=function(title,content,form,func,func2,width){ 
		$("#pubwinform_Modal").remove();
		$("body").append( pubwinform_html(title,content,form,width));
		$('#pubwinform_btn').on("click",  function(){  func($('#pubwinform_form').serialize());  } );
		$('#pubwinform_btn2').on("click",  function(){  func2($('#pubwinform_form').serialize());  });
		$('#pubwinform_Modal').modal('show');   
	}; 
	//form end	
	
	
	
	//select 普通下拉
	/*
	*参数说明：
	*  	data = {
	*		val: [   //结构数据
	*			{"rid":"1001","nNam":"选择1"},
	*			{"rid":"1002","nNam":"选择2"},
	*			{"rid":"1003","nNam":"选择3"},
	*			{"rid":"1004","nNam":"选择4"},
	*		],
	*		key: {nId:"rid",name:"nNam"},   //参数配置 nId-节点ID  name—节点名称
	*	};
	*	selid：下拉框ID
	*	returnfunc： 选择返回值，sid-选中节点ID,  name-节点名称,   val-节点数据
	*/
	window.pubwin.select = function(data,selid,returnfunc){
		if("string" == typeof data.val){
			data.val = pubwin.pf.loaddata(data.val);			
		}
		if("undefined" == (typeof pubwin.dt[selid])){
			pubwin.dt[selid] = {};      //缓存数据
		}
		pubwin.dt[selid].data = data;
		$("#"+selid).children().remove();
		$("#"+selid).append( pubwin.select.pubwinselect_html(data, selid) );
		pubwin.select.selclick(selid);
		if("undefined" == (typeof pubwin.select[selid])){
			pubwin.select[selid] = {};      //返回数据缓存
		}
		pubwin.select[selid].returnfunc = returnfunc;
	};
	window.pubwin.select.getdata = function(selid){
		try{
			return pubwin.dt[selid].data;
		}catch(e){}
	};
	window.pubwin.select.pubwinselect_html = function(data, selid){
		var s_hl = 
			'<input id="selrel_'+selid+'" data-toggle="dropdown" type="button" class="form-control" '+
			'style="text-align:left;" data-sid="">'+
			'<span class="caret" style="position: absolute;top: 50%;right: 0;margin-right: 10px;"></span>'+
			'<ul class="dropdown-menu" id="selul_'+selid+'" style="left:1px;right:1px;max-height:300px;overflow:auto;">';
		for(var i in data.val){
			s_hl = s_hl+'<li data-sid='+data.val[i][data.key.nId]+' data-nm='+data.val[i][data.key.name]+'>'+
				'<a data-sid='+data.val[i][data.key.nId]+' data-nm='+data.val[i][data.key.name]+'>'+
				data.val[i][data.key.name]+'</a></li>';
		}
		return s_hl + '</ul>';
	};	
	window.pubwin.select.selclick = function(selid){
		var u_id = "selul_" + selid;
		$("#"+u_id).delegate("li","click",function(e){
			var ds = $.extend(true, {}, pubwin.select.getdata(selid) );
			var sid = $(this).attr("data-sid");
			var nm = $(this).attr("data-nm");
			$("#selrel_"+selid).attr("data-sid",sid);
			$("#selrel_"+selid).val(nm);
			$.each(ds.val, function(i,val){
				if(val[ds.key.nId] == sid)
					pubwin.select[selid].returnfunc(sid,val[ds.key.name],val);
		    });
		});
	};
	//默认选中
	window.pubwin.selclick = function(selid,canshu,datastr){
		if("undefined" == (typeof datastr)){
			$("#"+selid).find("ul li").eq(canshu-1).trigger("click");
		}else{
			if(datastr == "data-sid" || datastr == "data-nm"){
				$("#"+selid).find("ul li["+datastr+"="+canshu+"]").trigger("click");
			}else{
				$("#"+selid).find("ul li[data-sid="+canshu+"]").trigger("click");
			}	
		}
	};
	//获取id
	window.pubwin.getselval = function(selid){
		return $("#selrel_"+selid).attr("data-sid");
	};
	//获取name
	window.pubwin.getselnam = function(selid){
		return $("#selrel_"+selid).val();
	};
	//获取row
	window.pubwin.getselrow = function(selid){
		var ds = $.extend(true, {}, pubwin.select.getdata(selid) );
		var sid = $("#selrel_"+selid).attr("data-sid");
		var row = {};
		$.each(ds.val, function(i,val){
			if(val[ds.key.nId] == sid)
				row = val;
	    });
		return row;
	};
	
	//select 普通下拉  end	
	
	
	
	
	/*
	 * 公用方法      
	*/
	
	//根据url获取数据  
	window.pubwin.pf.loaddata = function(url){
		var data;
	 	$.ajax({
	      	url: url,
	      	dataType: "json",
	      	async: false,
	      	success: function(res){
	      		data = res;      		
	      	}
	    });
	 	return data;
	};
	
});