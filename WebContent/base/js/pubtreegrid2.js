/*
 * pubtreegrid2，普通表格树和带选择框表格树，选择框之间父子节点关联（即有灰选和全选效果）。
 * 
*/

$(function(){
	
	if("undefined" == (typeof window.pubtreegrid2)){
		window.pubtreegrid2 = {};
	}
	if("undefined" == (typeof window.pubtreegrid2.pf)){
		window.pubtreegrid2.pf = {};      //公用方法
	}
	if("undefined" == (typeof window.pubtreegrid2.dt)){
		window.pubtreegrid2.dt = {};      //缓存数据
	}
	
	/*表格树  tgrid    参数说明：
	 * columns： = [{name:"显示的名称(必须)",field:"关联的字段(必须)",chktype:"radio/checkbox（可省）",
	 *				width:"设置列宽（可省）",render:"自定义样式（function(val) 可省）"}]
	 *    data： = {	
	 * 				val: res,   //表格树数据,可以是url地址或数据对象   (必须) 
	 * 				key: {      //表格树参数设置
	 *					name: "deptnm",        //显示名称字段  (必须) 
	 *					nId: "deptid",         //节点ID字段   (必须) 
	 *					pId: "parents",        //父节点ID字段  (必须) 
	 *					child: "chindren",     //子节点key  (必须) 
	 *					nochk: "true",         //true:父节点选择框禁用，默认false，（可省）
	 *				},
	 *			};
	 *    tgridid： 表格树table id
	 * returnfunc： 回调函数   行点击   返回值
	 * selectfunc： 回调函数   单选/多选    结果返回值
	**/
	window.pubtreegrid2.tgrid = function(columns,data,tgridid,returnfunc,selectfunc){		
		if("string" == typeof data.val){
			data.val = pubtreegrid2.pf.loaddata(data.val);			
		}
		$("#"+tgridid).append( pubtreegrid2.tgrid.setting.gridtitle_html($.extend(true, {}, columns ),tgridid) ); 
		if("undefined" == (typeof pubtreegrid2.dt[tgridid])){
			pubtreegrid2.dt[tgridid] = {};      //缓存数据
		}
		pubtreegrid2.dt[tgridid].reldata = {};  //结果缓存
		pubtreegrid2.dt[tgridid].columns = $.extend(true, {}, columns );
		pubtreegrid2.dt[tgridid].data = $.extend(true, {}, data );
		pubtreegrid2.tgrid.setting.loaddata(tgridid);
		pubtreegrid2.tgrid.setting.rowclick(tgridid);
		if("undefined" == (typeof pubtreegrid2.tgrid[tgridid])){
			pubtreegrid2.tgrid[tgridid] = {};      //返回数据缓存
		}
		pubtreegrid2.tgrid[tgridid].returnfunc = returnfunc;
		pubtreegrid2.tgrid[tgridid].selectfunc = selectfunc;
		$("#"+tgridid).treegrid({
			expanderExpandedClass: "glyphicon glyphicon-minus",
			expanderCollapsedClass: "glyphicon glyphicon-plus",
			initialState: "collapsed"
		});
	};
	//获取缓存数据 
	window.pubtreegrid2.tgridcol = function(tgridid){
		try{
			return pubtreegrid2.dt[tgridid].columns;
		}catch(e){}
	};
	window.pubtreegrid2.tgriddata = function(tgridid){
		try{
			return pubtreegrid2.dt[tgridid].data;
		}catch(e){}
	};
	//表格树设置 
	window.pubtreegrid2.tgrid.setting = {
		//表格树生成表头 
		gridtitle_html: function(columns,tgridid) {
			var th_html = '<thead><tr>';
			for(var i in columns){
				if("undefined" === typeof columns[i].width){
					columns[i].width = "";
				}else{
					columns[i].width = "width:"+columns[i].width;
				}
				if("undefined" === typeof columns[i].chktype){
					th_html = th_html + '<th data-field="'+columns[i].field+'" tabindex="'+i
									  +'" style="'+columns[i].width+'">'+columns[i].name+'</th>';
				}else{
					th_html = th_html + '<th data-field="'+columns[i].chktype+'" tabindex="'+i
					  				  +'" style="'+columns[i].width+'">'+columns[i].name+'</th>';
				}			
			}
			th_html = th_html + '</tr></thead><tbody id="tgridbody_'+tgridid+'"></tbody>';
			return th_html;
		},
		//表格树加载数据 
		loaddata: function(tgridid){
			var columns = $.extend(true, {}, pubtreegrid2.tgridcol(tgridid) );
			var data = $.extend(true, {}, pubtreegrid2.tgriddata(tgridid) );
			var tbodyid = "tgridbody_"+tgridid;
			var dataval = pubtreegrid2.pf.transData(data.val, data.key.nId, data.key.pId, data.key.child);
			var obj = {};
			var render = {};
			var chktypes;
			for(var i in columns){
				if("undefined" === typeof columns[i].chktype){
					if("undefined" != typeof columns[i].render){
						render.field = columns[i].field;
						render.func = columns[i].render;
					}	
					obj[columns[i].field] = "";
				}else{
					obj[columns[i].chktype] = "";
					chktypes = columns[i].chktype;
				}				
			}
			//初始化赋值取值
			var initdata = $.extend(true, {}, pubtreegrid2.tgriddata(tgridid) );
			var grayid=[], graydata=[], relid=[], reldata=[], allid=[], alldata=[];
			var rels = [];
			$.each(initdata.val, function(i, val){				
				if(val["chkstate"] == "2"){
					grayid.push(val[initdata.key.nId]);
					graydata.push(val);
				}
				if(val["chkstate"] == "1"){
					rels.push(val);
					allid.push(val[initdata.key.nId]);
					alldata.push(val);
				}
			});
			var rels2 = pubtreegrid2.pf.transData(rels, initdata.key.nId, initdata.key.pId, initdata.key.child);
			for(var i in rels2){
				var val = rels2[i];
				relid.push(val[initdata.key.nId]);
				reldata.push(val);
			}			
			if(chktypes == "radio"){
				pubtreegrid2.dt[tgridid].reldata.relid = relid;
				pubtreegrid2.dt[tgridid].reldata.reldata = reldata;
				pubtreegrid2.dt[tgridid].reldata.grayid = grayid;
				pubtreegrid2.dt[tgridid].reldata.graydata = graydata;
			}
			if(chktypes == "checkbox"){
				pubtreegrid2.dt[tgridid].reldata.allid = allid;
				pubtreegrid2.dt[tgridid].reldata.alldata = alldata;
				pubtreegrid2.dt[tgridid].reldata.relid = relid;
				pubtreegrid2.dt[tgridid].reldata.reldata = reldata;
				pubtreegrid2.dt[tgridid].reldata.grayid = grayid;
				pubtreegrid2.dt[tgridid].reldata.graydata = graydata;
			}
			
			//表格树初始化 
			var tgridinit = function(dval){
				for(var i in dval){
		 			var row = dval[i];
		 			var trstr = "<tr id='tg_"+row[data.key.nId]+"'></tr>";
		 			var tr = $(trstr).addClass("treegrid-"+row[data.key.nId]).appendTo($("#"+tbodyid));
		 			if(row[data.key.pId] !=0){
		     			tr.addClass("treegrid-parent-"+row[data.key.pId]);
		     		}	
		 			var nochkval = data.key.nochk;
		 			var childtype = typeof row[data.key.child];
		 			var chktype = typeof row.chkstate;
		   			for(var key in obj){
		   				var tdstr = "<td data-key='"+key+"' tabindex='"+row[data.key.nId];		   				
		   				if(key == "radio"){
		   					var ischk = "";		   					
		   					if(nochkval == "true" && childtype != "undefined"){		   						
		   						ischk = '<lable style="padding:6px 8px;">'+
	   								'<i class="fa fa-circle" style="color:rgb(144,144,144);font-size:18px;">'+
	   								'</i></lable>';
		   						tdstr = tdstr + "' data-type=''></td>";
		   					}else{
		   						if(chktype != "undefined" && row.chkstate == 1){
		   							ischk = '<lable style="padding:6px 8px;cursor: pointer;">'+
			   							'<input type="radio" name="'+row[data.key.pId]+'" value="'+
			   							row[data.key.nId]+'" style="display:none;" checked/>'+
			   							'<i class="fa fa-dot-circle-o" style="color:rgb(1,131,1);font-size:18px;">'+
			   							'</i></lable>';
			   						tdstr = tdstr + "' data-type='radio'></td>";
			   					}else if(chktype != "undefined" && row.chkstate == 2){
			   						ischk = '<lable style="padding:6px 8px;cursor: pointer;">'+
			   							'<input type="radio" name="'+row[data.key.pId]+'" value="'+
			   							row[data.key.nId]+'" style="display:none;"/>'+
			   							'<i class="fa fa-dot-circle-o" style="color:rgb(144,144,144);font-size:18px;">'+
			   							'</i></lable>';
			   						tdstr = tdstr + "' data-type='radio'></td>";
			   					}else{
			   						ischk = '<lable style="padding:6px 8px;cursor: pointer;">'+
			   							'<input type="radio" name="'+row[data.key.pId]+'" value="'+
			   							row[data.key.nId]+'" style="display:none;"/>'+
			   							'<i class="fa fa-circle-o" style="color:rgb(1,131,1);font-size:18px;">'+
			   							'</i></lable>';
			   						tdstr = tdstr + "' data-type='radio'></td>";
			   					}		   						
		   					}
				     		obj[key] = ischk;				     		
		   				}else if(key == "checkbox"){
		   					var ischk = "";
		   					if(nochkval == "true" && childtype != "undefined"){
		   						ischk = '<lable style="padding:6px 8px;">'+
	   								'<i class="fa fa-square" style="color:rgb(144,144,144);font-size:18px;">'+
	   								'</i></lable>';
		   						tdstr = tdstr + "' data-type=''></td>";
		   					}else{
		   						if(chktype != "undefined" && row.chkstate == 1){
		   							ischk = '<lable style="padding:6px 8px;cursor: pointer;">'+
			   							'<input type="checkbox" name="'+row[data.key.pId]+'" value="'+
			   							row[data.key.nId]+'" style="display:none;" checked/>'+
			   							'<i class="fa fa-check-square-o" style="color:rgb(1,131,1);font-size:18px;">'+
			   							'</i></lable>';
			   						tdstr = tdstr + "' data-type='checkbox'></td>";
		   						}else if(chktype != "undefined" && row.chkstate == 2){
		   							ischk = '<lable style="padding:6px 8px;cursor: pointer;">'+
			   							'<input type="checkbox" name="'+row[data.key.pId]+'" value="'+
			   							row[data.key.nId]+'" style="display:none;"/>'+
			   							'<i class="fa fa-check-square-o" style="color:rgb(144,144,144);font-size:18px;">'+
			   							'</i></lable>';
			   						tdstr = tdstr + "' data-type='checkbox'></td>";
		   						}else{
		   							ischk = '<lable style="padding:6px 8px;cursor: pointer;">'+
			   							'<input type="checkbox" name="'+row[data.key.pId]+'" value="'+
			   							row[data.key.nId]+'" style="display:none;"/>'+
			   							'<i class="fa fa-square-o" style="color:rgb(1,131,1);font-size:18px;">'+
			   							'</i></lable>';
			   						tdstr = tdstr + "' data-type='checkbox'></td>";
		   						}		   						
		   					}
		   					obj[key] = ischk;		   					
		   				}else{
		   					if(key == render.field ){
		   						obj[key] = render.func( row[key] ) ;
		   					}else{
		   						obj[key] = row[key];
		   					}	
		   					tdstr = tdstr + "' data-type=''></td>";
		   				}		   				
		   				$(tdstr).html(obj[key]).appendTo(tr);
		   			}
		    		if("undefined" != childtype){
		    			tgridinit(row[data.key.child]);	
		    		}
		 		}
			};
			tgridinit(dataval);
		},
		//鼠标移入移除   行点击事件
		rowclick: function(tgridid){	
			$("#"+tgridid).delegate("td","click mouseover mouseout",function(e){
		 		if(e.type == "mouseover"){   //鼠标移入 
		 			if($(this).parent().attr("dt-click") != "1")
		 				$(this).parent().css("background-color", "#DBDBDB");
		 		}
		 		if(e.type == "mouseout"){    //鼠标移除
		 			if($(this).parent().attr("dt-click") != "1")
		 				$(this).parent().css("background-color", "");
		 		}
				if(e.type == "click"){       //点击事件					
					$(this).parent().css("background-color", "rgb(249, 230, 104)");
					$(this).parent().siblings("tr").css("background-color", "");
					$(this).parent().attr("dt-click","1");
					$(this).parent().siblings("tr").attr("dt-click","");
					var types = "";
					if( $(e.target).hasClass("treegrid-expander") && e.target.nodeName == "SPAN" ){}else{
						var ds = $.extend(true, {}, pubtreegrid2.tgriddata(tgridid) );
						var dval = pubtreegrid2.pf.transData2(ds.val,ds.key.nId,ds.key.pId,ds.key.child);
						var tid = $(this).parent()[0].id.replace("tg_","");
						var col = $(this).attr("data-key");
						$.each(ds.val, function(i,val){
							delete val[ds.key.child];
							if(val[ds.key.nId] == tid){
								pubtreegrid2.tgrid[tgridid].returnfunc(tid,col,val);   //返回点击行参数
							}							
					    });
						types = $(this).attr("data-type");   //判断radio或checkbook
					}
					//单选------------------------------单选单选单选----------------------------------------
					if(types == "radio"){
						var ischecked = $(this).find("input")[0].checked;
						var selectval = $(this).find("input")[0].value;
						var tglevlobj;
						$.each(ds.val, function(i,val){
							if(val[ds.key.nId] == selectval){
								tglevlobj = val.tg_levl_2.split(",");
							}							
					    });
						var $thisp = $(this).parent().parent();
						var selectstate = true;
						if(ischecked){	
							$(this).find("input")[0].checked = false;
							$(this).find("i").removeClass("fa-dot-circle-o").addClass("fa-circle-o");
							$(this).find("i").css("color","rgb(1,131,1)");
							$(this).parent().siblings("tr").find("i").removeClass("fa-dot-circle-o").addClass("fa-circle-o");
							$(this).parent().siblings("tr").find("i").css("color","rgb(1,131,1)");							
							selectstate = false;
							
						}else{
							var allradio = $thisp.find("input");
							$.each(allradio,function(){
								if(this.value == selectval){
									$(this)[0].checked = true;
									$(this).siblings("i").removeClass("fa-circle-o").addClass("fa-dot-circle-o");
									$(this).siblings("i").css("color","rgb(1,131,1)");
								}else{
									$(this)[0].checked = false;
									$(this).siblings("i").removeClass("fa-dot-circle-o").addClass("fa-circle-o");
									$(this).siblings("i").css("color","rgb(1,131,1)");
									for(var i in tglevlobj){
										if(this.value === tglevlobj[i]){
											$(this).siblings("i").removeClass("fa-circle-o").addClass("fa-dot-circle-o");
											$(this).siblings("i").css("color","rgb(144,144,144)");
										}
									}
								}
							});
							selectstate = true;
						}
						//返回结果
						var relid = [];
						var reldata = [];
						var grayid = [];
						var graydata = [];
						if(selectstate){
							relid.push(selectval);
							var allGsel = $thisp.find("i[class$='fa-dot-circle-o']").siblings("input[type=radio]").not("input:checked");
							console.log(allGsel);
							$.each(allGsel,function(){
								grayid.push(this.value);
							});
							$.each(ds.val, function(i,val){
								if(val[ds.key.nId] == relid){
									delete val.tg_levl_2;	
									val["chkstate"] = 1;
									reldata.push(val);
								}	
								for(var i in grayid){
									if(val[ds.key.nId] == grayid[i]){
										delete val.tg_levl_2;
										val["chkstate"] = 2;
										graydata.push(val);
									}										
								}
						    });
							
						}
						pubtreegrid2.tgrid[tgridid].selectfunc(relid,reldata,grayid,graydata);
						pubtreegrid2.dt[tgridid].reldata.relid = relid;
						pubtreegrid2.dt[tgridid].reldata.reldata = reldata;
						pubtreegrid2.dt[tgridid].reldata.grayid = grayid;
						pubtreegrid2.dt[tgridid].reldata.graydata = graydata;
						
					}
					//多选 ------------------------------多选多选多选----------------------------------------
					if(types == "checkbox"){
						var ischecked = $(this).find("input")[0].checked;
						var selectval = $(this).find("input")[0].value;
						var tglevlobj;
						$.each(ds.val, function(i,val){
							if(val[ds.key.nId] == selectval){
								tglevlobj = val.tg_levl_2.split(",");
							}							
					    });
						var $thisp = $(this).parent().parent();
						if(ischecked){							
							$(this).find("input")[0].checked = false;
							$(this).find("i").removeClass("fa-check-square-o").addClass("fa-square-o");	
							$(this).find("i").css("color","rgb(1,131,1)");
							
							$.each(ds.val, function(i,val){
								var tlobj = val.tg_levl_2.split(",");
								if(tlobj.indexOf(selectval) != "-1" && val[ds.key.nId] != selectval){
									$thisp.find("input[value='"+val[ds.key.nId]+"']").each(function(){
					 					this.checked = false;
					 					$(this).siblings("i").removeClass("fa-check-square-o").addClass("fa-square-o");
					 					$(this).siblings("i").css("color","rgb(1,131,1)");
					 				});
								}
						    });
							for(var i in tglevlobj){
								if(tglevlobj[i] != selectval){
									var lenchk = $thisp.find("input[name='"+tglevlobj[i]+"']:checked").length;
									var lenall = $thisp.find("input[name='"+tglevlobj[i]+"']").length;	
									var istrlen = $thisp.find("input[name='"+tglevlobj[i]+"']").siblings("i[class='fa fa-check-square-o']").length;
									if(lenchk == 0 && istrlen == 0){	
						 				$thisp.find("input[value='"+tglevlobj[i]+"']").each(function(){
						 					this.checked = false;
						 					$(this).siblings("i").removeClass("fa-check-square-o").addClass("fa-square-o");
						 					$(this).siblings("i").css("color","rgb(1,131,1)");
						 				});
						 			}else{
						 				$thisp.find("input[value='"+tglevlobj[i]+"']").each(function(){
						 					this.checked = false;
						 					$(this).siblings("i").removeClass("fa-square-o").addClass("fa-check-square-o");
						 					$(this).siblings("i").css("color","rgb(144,144,144)");
						 				});
						 			}								
								}
							}
						}else{
							$(this).find("input")[0].checked = true;
							$(this).find("i").removeClass("fa-square-o").addClass("fa-check-square-o");
							$(this).find("i").css("color","rgb(1,131,1)");
							
							$.each(ds.val, function(i,val){
								var tlobj = val.tg_levl_2.split(",");
								if(tlobj.indexOf(selectval) != "-1" && val[ds.key.nId] != selectval){
									$thisp.find("input[value='"+val[ds.key.nId]+"']").each(function(){
					 					this.checked = true;
					 					$(this).siblings("i").removeClass("fa-square-o").addClass("fa-check-square-o");
					 					$(this).siblings("i").css("color","rgb(1,131,1)");
					 				});
								}
						    });
							for(var i in tglevlobj){
								if(tglevlobj[i] != selectval){
									var lenchk = $thisp.find("input[name='"+tglevlobj[i]+"']:checked").length;
						 			var lenall = $thisp.find("input[name='"+tglevlobj[i]+"']").length;
						 			if(lenchk == lenall){
						 				$thisp.find("input[value='"+tglevlobj[i]+"']").each(function(){
						 					this.checked = true;
						 					$(this).siblings("i").removeClass("fa-square-o").addClass("fa-check-square-o");
						 					$(this).siblings("i").css("color","rgb(1,131,1)");
						 				});
						 			}else{
						 				$thisp.find("input[value='"+tglevlobj[i]+"']").each(function(){
						 					this.checked = false;
						 					$(this).siblings("i").removeClass("fa-square-o").addClass("fa-check-square-o");
						 					$(this).siblings("i").css("color","rgb(144,144,144)");
						 				});
						 			}									
								}
							}							
						}
						//返回结果
						var allchked = $thisp.find("input[type=checkbox]:checked");
						var allGsel = $thisp.find("i[class$='fa-check-square-o']").siblings("input[type=checkbox]").not("input:checked");
						//返回全部和返回父节点
						var allid = [];
						var chkarrys = [];
						$.each(allchked,function(){
							var js = {};
							js.nids = this.value;
							js.pids = this.name;
							chkarrys.push(js);
							allid.push(js.nids);
						});
						var grayid = [];
						$.each(allGsel,function(){
							grayid.push(this.value);
						});
						var chkarry = pubtreegrid2.pf.transData(chkarrys,"nids","pids","node");
						var alldata = [];						
						var relid = [];							
						var reldata = [];						
						var graydata = [];
						$.each(ds.val, function(i,val){
							for(var i in allid){
								if(val[ds.key.nId] == allid[i]){
									delete val.tg_levl_2;
									val["chkstate"] = 1;
									alldata.push(val);
								}										
							}
							for(var i in chkarry){
								if(val[ds.key.nId] == chkarry[i].nids){
									delete val.tg_levl_2;
									relid.push(chkarry[i].nids);
									val["chkstate"] = 1;
									reldata.push(val);
								}										
							}
							for(var i in grayid){
								if(val[ds.key.nId] == grayid[i]){
									delete val.tg_levl_2;
									val["chkstate"] = 2;
									graydata.push(val);
								}										
							}
					    });			
						pubtreegrid2.tgrid[tgridid].selectfunc(allid,alldata,relid,reldata,grayid,graydata);
						pubtreegrid2.dt[tgridid].reldata.allid = allid;
						pubtreegrid2.dt[tgridid].reldata.alldata = alldata;
						pubtreegrid2.dt[tgridid].reldata.relid = relid;
						pubtreegrid2.dt[tgridid].reldata.reldata = reldata;
						pubtreegrid2.dt[tgridid].reldata.grayid = grayid;
						pubtreegrid2.dt[tgridid].reldata.graydata = graydata;
						
					}
				}
			});
		}
	};
	
	//表格树  tgrid   end
	
	
	//获取结果  —— 获取总结果
	window.pubtreegrid2.getrel = function(tgridid){
		return pubtreegrid2.dt[tgridid].reldata;
	};
	//获取结果  —— 获取选择结果id
	window.pubtreegrid2.getrelid = function(tgridid){
		return pubtreegrid2.dt[tgridid].reldata.relid;
	};
	//获取结果  —— 获取选择结果data
	window.pubtreegrid2.getreldata = function(tgridid){
		return pubtreegrid2.dt[tgridid].reldata.reldata;
	};
	//获取结果  —— 获取灰选结果id
	window.pubtreegrid2.getgrayid = function(tgridid){
		return pubtreegrid2.dt[tgridid].reldata.grayid;
	};
	//获取结果  —— 获取灰选结果data
	window.pubtreegrid2.getgraydata = function(tgridid){
		return pubtreegrid2.dt[tgridid].reldata.graydata;
	};
	
	//获取结果  —— 获取全部结果id  ——  多选才有
	window.pubtreegrid2.getallid = function(tgridid){
		return pubtreegrid2.dt[tgridid].reldata.allid;
	};
	//获取结果  —— 获取全部结果data  ——  多选才有
	window.pubtreegrid2.getalldata = function(tgridid){
		return pubtreegrid2.dt[tgridid].reldata.alldata;
	};
	
	
	//重新加载数据
	window.pubtreegrid2.reload = function(tgridid,datas){
		var columns = $.extend(true, {}, pubtreegrid2.tgridcol(tgridid) );
		var data = $.extend(true, {}, pubtreegrid2.tgriddata(tgridid) );
		$("#"+tgridid).unbind(); 
		$("#"+tgridid).children().remove();
		if("undefined" == (typeof datas)){
			pubtreegrid2.tgrid(columns,data,tgridid,function(){},function(){});
		}else if("string" == (typeof datas)){
			var dataval = pubtreegrid2.pf.loaddata(datas);
			data.val = dataval;
			pubtreegrid2.tgrid(columns,data,tgridid,function(){},function(){});
		}else{		
			data.val = datas;
			pubtreegrid2.tgrid(columns,data,tgridid,function(){},function(){});
		}
	};
	
	/*
	 * 公用方法      
	*/
	
	//根据url获取数据  
	window.pubtreegrid2.pf.loaddata = function(url){
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
	
	// 解析json   转换生成    树结构JSON格式 
	window.pubtreegrid2.pf.transData = function(jsons, idStr, pidStr, chindrenStr){  
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
	
	// 解析json   转换生成    树结构JSON格式   添加tg_levl_2属性（节点的路径levels）
	window.pubtreegrid2.pf.transData2 = function(jsons, idStr, pidStr, chindrenStr){  
		var r = [], hash = {};
	    var id = idStr, pid = pidStr, children = chindrenStr;
	    var i = 0, j = 0, k = 0, len = jsons.length;  
	    for(; i < len; i++){  
	    	jsons[i].tg_levl_2 = jsons[i][id];
	        hash[jsons[i][id]] = jsons[i];  
	    }  
	    for(; j < len; j++){  
	        var aVal = jsons[j], hashVP = hash[aVal[pid]]; 
	        if(hashVP){  
	            !hashVP[children] && (hashVP[children] = []); 
	            aVal.tg_levl_2 = aVal[id]+","+hashVP.tg_levl_2;
	            hashVP[children].push(aVal);  
	        }else{  
	            r.push(aVal);  
	        }
	    }  
	    for(; k < len; k++){  
	        var aVal = jsons[k], hashVP = hash[aVal[pid]]; 
	        if(hashVP){ 	     
	        	aVal.tg_levl_2 = pubtreegrid2.pf.unique(aVal.tg_levl_2+","+hashVP.tg_levl_2);
	        }
	    } 
	    return r;  
	};
	//对tg_levl_2属性的补充修改，功能——数组去重
	window.pubtreegrid2.pf.unique = function(arrystr){
		var arry = arrystr.split(",");
		var res = [];
		var json = {};
		for(var i = 0; i < arry.length; i++){
			if(!json[arry[i]]){
		   		res.push(arry[i]);
		   		json[arry[i]] = 1;
		  	}
		}
		return res.join(",");
	};
	/*
	 * 公用方法    end
	*/
	
});

