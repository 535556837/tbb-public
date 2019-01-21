;
$(function() {
	var num=$("#pnSelect").val();
	var obj;
	$.ajax({
		type : "GET",
		url : "menu/getWeixinCustomMenu",
		async : false,
		data:{
			num:num
		},
		dataType : "json",
		success : function(data) {
			obj = data;
		}
	});
	
	var button = obj.menu.button;// 一级菜单
	var ix = button.length;// 一级菜单数量
	$("#pnSelect").change(function(){
		num=$("#pnSelect").val();
		$.ajax({
			type : "GET",
			url : "menu/getWeixinCustomMenu",
			async : false,
			data:{
				num:num
			},
			dataType : "json",
			success : function(data) {
				obj = data;
				button=data.menu.button;
				ix = button.length;
				$(".custom-menu-view__footer__right").html('');
				showMenu();
				addMenuClick();
			}
		});
	})
	

	var firstButtonIndex;
	var secondButtonIndex;
	var mId = null;
	// 显示自定义按钮组
	// var obj={
	// "menu": {
	// "button": [
	// {
	// "type": "click",
	// "name": "今日歌曲",
	// "key": "pic",
	// "sub_button": [ ]
	// },
	// {
	// "type": "view",
	// "name": "百度一下",
	// "url": "http://www.baidu.com/",
	// "sub_button": [ ]
	// },
	// {
	// "name": "菜单",
	// "sub_button": [
	// {
	// "type": "view",
	// "name": "搜索",
	// "url": "http://www.soso.com/"
	// },
	// {
	// "type": "view",
	// "name": "视频",
	// "url": "http://v.qq.com/"
	// },
	// {
	// "type": "click",
	// "name": "赞一下我们",
	// "key": "col_1"
	// }
	// ]
	// }
	// ]
	// }
	// };
	var tempObj = {};// 存储HTML对象
	var button = obj.menu.button;// 一级菜单
	// 显示异常
	if (obj.errcode) {
		$('#abnormalModal').modal('show');
	}
	// 一级菜单对象
	function parents(param) {
		this.name = param;
		this.sub_button = [];
	}
	// 二级菜单对象
	function subs(param) {
		this.name = param;
	}
	var objp = new parents();
	var objs = new subs();
	
	var menu = '<div class="custom-menu-view__menu"><div class="text-ellipsis"></div></div>';
	var customBtns = $('.custom-menu-view__footer__right');
	if (button.length > 0) {
		showMenu();
		// $('.cm-edit-before').hide();
		$('.cm-edit-after').hide();
	} else {
		addMenu();
		$('.cm-edit-before').siblings().hide();
	}
	// 显示第一级菜单
	function showMenu() {
		if (button.length == 1) {
			appendMenu(button.length);
			showBtn();
			$('.custom-menu-view__menu').css({
				width : '50%',
			});
		}
		if (button.length == 2) {
			appendMenu(button.length);
			showBtn();
			$('.custom-menu-view__menu').css({
				width : '33.3333%',
			});
		}
		if (button.length == 3) {
			appendMenu(button.length);
			showBtn();
			$('.custom-menu-view__menu').css({
				width : '33.3333%',
			});
		}
		for (var b = 0; b < button.length; b++) {
			$('.custom-menu-view__menu')[b].setAttribute('alt', b);
		}
	}
	// 显示子菜单
	function showBtn() {
		for (var i = 0; i < button.length; i++) {
			var text = button[i].name;
			var list = document.createElement('ul');
			list.className = "custom-menu-view__menu__sub";
			$('.custom-menu-view__menu')[i].childNodes[0].innerHTML = text;
			$('.custom-menu-view__menu')[i].appendChild(list);
			for (var j = 0; j < button[i].sub_button.length; j++) {
				var text = button[i].sub_button[j].name;
				var li = document.createElement("li");
				var tt = document.createTextNode(text);
				var div = document.createElement('div');
				li.className = 'custom-menu-view__menu__sub__add';
				li.id = 'sub_' + i + '_' + j;// 设置二级菜单id
				div.className = "text-ellipsis";
				div.appendChild(tt);
				li.appendChild(div);
				$('.custom-menu-view__menu__sub')[i].appendChild(li);
			}
			var ulBtnL = button[i].sub_button.length;
			var iLi = document.createElement("li");
			var ii = document.createElement('i');
			var iDiv = document.createElement("div");
			ii.className = "glyphicon glyphicon-plus text-info";
			iDiv.className = "text-ellipsis";
			iLi.className = 'custom-menu-view__menu__sub__add';
			iDiv.appendChild(ii);
			iLi.appendChild(iDiv);
			if (ulBtnL < 5) {
				$('.custom-menu-view__menu__sub')[i].appendChild(iLi);
			}

		}
	}
	// 显示添加的菜单
	function appendMenu(num) {
		var menuDiv = document.createElement('div');
		var mDiv = document.createElement('div');
		var mi = document.createElement('i');
		mi.className = 'glyphicon glyphicon-plus text-info iBtn';
		mDiv.className = 'text-ellipsis';
		menuDiv.className = 'custom-menu-view__menu';
		mDiv.appendChild(mi);
		menuDiv.appendChild(mDiv)
		switch (num) {
		case 1:
			customBtns.append(menu);
			customBtns.append(menuDiv);
			break;
		case 2:
			customBtns.append(menu);
			customBtns.append(menu);
			customBtns.append(menuDiv);
			break;
		case 3:
			customBtns.append(menu);
			customBtns.append(menu);
			customBtns.append(menu);
			break;
		}
	}
	// 初始化菜单按钮
	function addMenu() {
		var menuI = '<div class="custom-menu-view__menu"><div class="text-ellipsis"><i class="glyphicon glyphicon-plus text-info iBtn"></i></div></div>';
		var sortIndex = true;
		customBtns.append(menuI);
		var customFirstBtns = $('.custom-menu-view__menu');
		var firstBtnsLength = customFirstBtns.length;
		if (firstBtnsLength <= 1) {
			customFirstBtns.css({
				width : '100%',
			})
		}
	}
	function addMenuClick(){
		$('.iBtn').parent().on(
				'click',
				function() {
					var menuname = $('input[name="custom_input_title"]').val();

					// 一级菜单的长度
					var num = $('.custom-menu-view__footer__right').find(
							'.custom-menu-view__menu').length;
					// 二级菜单的长度
					var ulNum = $(this).parents('.custom-menu-view__menu').prev()
							.find('.custom-menu-view__menu__sub').length;

					ix++;
					if (ix < 4) {
						$(this).parent().before(customEl);
						$(this).parent().prev().append(customUl);

						$('.custom-menu-view__footer__right').find(
								'.subbutton__actived').removeClass(
								'subbutton__actived');
						$(this).parent().prev().addClass('subbutton__actived');

						// 一级菜单列数
						var buttonIndex = $(this)
								.parents('.custom-menu-view__menu').index() - 1;
						$('.custom-menu-view__menu').eq(buttonIndex).on(
								'click',
								(function(buttonIndex) {
									var txt = $('.custom-menu-view__menu').eq(
											buttonIndex).text();
									setMenuText(txt);
								})(buttonIndex));

						if (ix == 1) {
							$('.custom-menu-view__menu').css({
								width : '50%'
							});
							$('.custom-menu-view__menu')[ix - 1].setAttribute(
									'alt', ix - 1);

						}
						if (ix == 2) {
							$('.custom-menu-view__menu').css({
								width : '33.3333%'
							});
							$('.custom-menu-view__menu')[ix - 1].setAttribute(
									'alt', ix - 1);
						}
						var divText = $(this).parent().prev()
								.find('.text-ellipsis').text();
						button.push(new parents(divText));
					}

					if (ix == 3) {
						$(this).parents('.custom-menu-view__menu').remove();
						$(this).parent().append(customUl);
						$('.custom-menu-view__menu')[ix - 1].setAttribute('alt',
								ix - 1);
					}
					$('.cm-edit-after').show().siblings().hide();
				});
	}
	// 添加菜单按钮
	var customEl = '<div class="custom-menu-view__menu"><div class="text-ellipsis">新建菜单</div></div>'
	var customUl = '<ul class="custom-menu-view__menu__sub"><li class="custom-menu-view__menu__sub__add"><div class="text-ellipsis"><i class="glyphicon glyphicon-plus text-info"></i></div></li></ul>';
	var customLi = '<li class="custom-menu-view__menu__sub__add"><div class="text-ellipsis">新建子菜单</div></li>';
	$('.iBtn').parent().on(
			'click',
			function() {
				var menuname = $('input[name="custom_input_title"]').val();

				// 一级菜单的长度
				var num = $('.custom-menu-view__footer__right').find(
						'.custom-menu-view__menu').length;
				// 二级菜单的长度
				var ulNum = $(this).parents('.custom-menu-view__menu').prev()
						.find('.custom-menu-view__menu__sub').length;

				ix++;
				if (ix < 4) {
					$(this).parent().before(customEl);
					$(this).parent().prev().append(customUl);

					$('.custom-menu-view__footer__right').find(
							'.subbutton__actived').removeClass(
							'subbutton__actived');
					$(this).parent().prev().addClass('subbutton__actived');

					// 一级菜单列数
					var buttonIndex = $(this)
							.parents('.custom-menu-view__menu').index() - 1;
					$('.custom-menu-view__menu').eq(buttonIndex).on(
							'click',
							(function(buttonIndex) {
								var txt = $('.custom-menu-view__menu').eq(
										buttonIndex).text();
								setMenuText(txt);
							})(buttonIndex));

					if (ix == 1) {
						$('.custom-menu-view__menu').css({
							width : '50%'
						});
						$('.custom-menu-view__menu')[ix - 1].setAttribute(
								'alt', ix - 1);

					}
					if (ix == 2) {
						$('.custom-menu-view__menu').css({
							width : '33.3333%'
						});
						$('.custom-menu-view__menu')[ix - 1].setAttribute(
								'alt', ix - 1);
					}
					var divText = $(this).parent().prev()
							.find('.text-ellipsis').text();
					button.push(new parents(divText));
				}

				if (ix == 3) {
					$(this).parents('.custom-menu-view__menu').remove();
					$(this).parent().append(customUl);
					$('.custom-menu-view__menu')[ix - 1].setAttribute('alt',
							ix - 1);
				}
				$('.cm-edit-after').show().siblings().hide();
			});
	var setMenuText = function(value) {
		setInput(value);
		updateTit(value);

		radios[0].checked = true;
		$('#editMsg').show();
		$('#editPage').hide();
		$('#editMiniapp').hide();
		// $('.msg-context__item').show();
		// $('.msg-template').hide();
		
		
		
	}
	function setSubText() {
		var actived = $('.custom-menu-view__menu__sub__add').hasClass(
				'subbutton__actived');
		var activedTxt = $('.subbutton__actived').text();
		if (actived) {
			setInput(activedTxt);
			updateTit(activedTxt);

			radios[0].checked = true;
			$('.msg-panel__tab>li').eq(0).addClass('on');
			$('#editMsg').show();
			$('#editPage').hide();
			$('#editMiniapp').hide();
			// $('.msg-context__item').show();
			// $('.msg-template').hide();

			$("input[name='url']").val('')
			$("input[name='appid']").val('')
			$("input[name='pagepath']").val('')
			$("#linkTitle").val('');
			$("#description").val('');
			$("#linkUrl").val('');
			$("#picurl").val('');
			$("#custommenuid").val('');
			$("#linkKey").val('');
			$("#textAreaUrl").val('');
			$("#textKey").val('');
			$("#textContent").val('');

		}
	}
	// 添加子菜单
	var colIndex;// 一级菜单列数
	customBtns.on('click', 'li>.text-ellipsis>i',
			function() {
				// 绑定删除事件
				$('.msg-panel__del').on('click', delClick);
				colIndex = $(this).parents('.custom-menu-view__menu').attr(
						'alt');
				var liNum = $(this).parents('.custom-menu-view__menu').find(
						'li').length;

				if (liNum <= 1) {
					$('#reminderModal').modal('show');
				} else {
					if (liNum < 6) {
						$(this).parent().parent().before(customLi);
						setLiId();
					}
					if (liNum == 5) {
						$(this).parents('li').remove();
					}
				}
				$('#radioGroup').show();
				setSubText();

			});
	// 确定添加子菜单事件
	$('.reminder').click(
			function() {

				var ul = $('.custom-menu-view__menu')[colIndex]
						.getElementsByTagName('ul')[0];
				var li = document.createElement('li');
				var div = document.createElement('div');
				var Text = document.createTextNode('新建子菜单');
				li.className = "custom-menu-view__menu__sub__add";
				div.className = "text-ellipsis";
				div.appendChild(Text);
				li.appendChild(div);
				ul.insertBefore(li, ul.childNodes[0]);
				setLiId();
				var liNum = $(this).parents('.custom-menu-view__menu').find(
						'li').length;

				if (button[colIndex].type == "click") {
					$.ajax({
						type : "POST",
						url : "menu/delLinkMsg",
						data : {
							keyword : button[colIndex].key
						},
						success : function(data) {
							if (data == "1") {
								alert("清空数据成功")
							}
						}
					});
				}

				delete button[colIndex].type;
				delete button[colIndex].key;
				delete button[colIndex].url;
				delete button[colIndex].appid;
				delete button[colIndex].pagepath;
				$('#reminderModal').modal('hide');

				setSubText();

			});
	// 对新添加二级菜单添加id
	function setLiId() {
		var prev = $('.custom-menu-view__menu')[colIndex]
				.getElementsByTagName('i')[0].parentNode.parentNode.previousSibling;
		var divText = prev.childNodes[0].innerHTML;
		button[colIndex].sub_button.push(new subs(divText));
		var id = button[colIndex].sub_button.length - 1;
		prev.setAttribute('id', 'sub_' + colIndex + '_' + id);

		$('.custom-menu-view__footer__right').find('.subbutton__actived')
				.removeClass('subbutton__actived');
		$('.custom-menu-view__menu').eq(colIndex).find('i').parent().parent()
				.prev().addClass('subbutton__actived');
	}
	// 点击菜单
	customBtns
			.on(
					'click',
					'.text-ellipsis',
					function() {
						var menuname = $('input[name="custom_input_title"]').val();
						if(menuname=="新建菜单"){
							setSubText();
						}
						
						
						$('.uploadimg-wrap').hide();
						$('#form')[0].reset();
						$('#imgpre').hide().attr('src','');						
						$('.cm-edit-after').show().siblings().hide();
						if ($(this).parent().attr('id')
								|| $(this).parent().attr('alt')) {
							$(this).parents('.custom-menu-view__footer__right')
									.find('.subbutton__actived').removeClass(
											'subbutton__actived');
							$(this).parent().addClass('subbutton__actived');
						}
						// 一级菜单列数
						var buttonIndex = $(this).parents(
								'.custom-menu-view__menu').index();
						// console.log(buttonIndex)
						// if($('.msg-context__item').is(':hidden')){
						// $('.msg-template').show();
						// }else if($('.msg-context__item').is(':visible')){
						// $('.msg-template').hide();
						// }
						// 点击在一级菜单上
						if ($(this).parent().attr('alt')) {
							if ($('.custom-menu-view__menu').hasClass(
									'subbutton__actived')) {
								var current = $('.subbutton__actived');
								var alt = current.attr('alt');
								var lis = current.find('ul>li');
								setInput(button[buttonIndex].name);
								updateTit(button[buttonIndex].name);
								if (lis.length > 1) {
									$('#editMsg').hide();
									$('#editPage').hide();
									$('#editMiniapp').hide();
									$('#radioGroup').hide();
								} else {
									if (button[buttonIndex].type == 'click') {
										radios[0].checked = true;
										$('input[name="appid"]').val('');
										$('input[name="pagepath"]').val('');
										$('input[name="url"]').val('');
										$('#editMsg').show();
										$('#editPage').hide();
										$('#editMiniapp').hide();
										$('#radioGroup').show();
										var subKey = button[buttonIndex].key;
										console.log(subKey)

										$
												.ajax({
													type : "POST",
													url : "menu/findLinkMsg",
													data : {
														keyword : subKey
													},
													success : function(data) {
														if(data.msgtype == "word"){
															
															$("#textKey").val(
																	data.keyword);
															$("#textContent").val(
																	data.content);
															//隐藏字段
															$("#custommenuid")
																	.val(
																			data.custommenuid);
															
															$(".msg-panel__tab>li").eq(0).addClass('on').siblings().removeClass('on');
															$(".msg-panel__context>div").eq(0).show().siblings().hide();
															$(".uploadimg-wrap").hide()
															
															
														}else if (data.msgtype == "tuwen") {	
															$(".msg-panel__tab>li").eq(1).addClass('on').siblings().removeClass('on');
															$(".msg-panel__context>div").eq(1).show().siblings().hide();														
															$("#linkTitle")
																	.val(
																			data.title);
															$("#description")
																	.val(
																			data.description);
															$("#linkUrl").val(
																	data.url);
															$("#picurl")
																	.val(
																			data.picurl);
															$("#custommenuid")
																	.val(
																			data.custommenuid);
															$("#linkKey")
																	.val(
																			data.keyword);
														}else if(data.msgtype == "pic"){
															$(".msg-panel__tab>li").eq(2).addClass('on').siblings().removeClass('on');
															$(".msg-panel__context>div").eq(2).show().siblings().hide();
														}
													}
												});

									} else if (button[buttonIndex].type == 'miniprogram') {
										radios[2].checked = true;
										$('input[name="appid"]').val(
												button[buttonIndex].appid);
										$('input[name="pagepath"]').val(
												button[buttonIndex].pagepath);
										$('input[name="url"]').val('');
										$('#editMsg').hide();
										$('#editPage').hide();
										$('#editMiniapp').show();
										$('#radioGroup').show();
									} else if (button[buttonIndex].type == 'view') {
										radios[1].checked = true;
										$('input[name="appid"]').val('');
										$('input[name="pagepath"]').val('');
										$('input[name="url"]').val(
												button[buttonIndex].url);
										$('#editMsg').hide();
										$('#editPage').show();
										$('#editMiniapp').hide();
										$('#radioGroup').show();
									}
									
								}

							}

						}
						// 点击在二级菜单上
						if ($(this).parent().attr('id')) {
							var substr = $(this).parent().attr('id')
									.lastIndexOf('_') + 1;
							var subIndex = $(this).parent().attr('id')
									.substring(substr);
							// console.log(subIndex)
							var subText = button[buttonIndex].sub_button[subIndex].name;
							var subUrl = button[buttonIndex].sub_button[subIndex].url;
							var subType = button[buttonIndex].sub_button[subIndex].type;
							var subKey = button[buttonIndex].sub_button[subIndex].key;
							var appid = button[buttonIndex].sub_button[subIndex].appid;
							var pagepath = button[buttonIndex].sub_button[subIndex].pagepath;

							if ($('.custom-menu-view__menu__sub__add')
									.hasClass('subbutton__actived')) {
								setInput(subText);
								updateTit(subText);
								$('#radioGroup').show();
								if (subType == 'click') {
									radios[0].checked = true;
									$('#editMsg').show();
									$('#editPage').hide();
									$('#editMiniapp').hide();

									$
											.ajax({
												type : "POST",
												url : "menu/findLinkMsg",
												data : {
													keyword : subKey
												},
												success : function(data) {
													if(data.msgtype == "word"){
														
														$("#textKey").val(
																data.keyword);
														$("#textContent").val(
																data.content);
														//隐藏字段
														$("#custommenuid")
																.val(
																		data.custommenuid);
														
														$(".msg-panel__tab>li").eq(0).addClass('on').siblings().removeClass('on');
														$(".msg-panel__context>div").eq(0).show().siblings().hide();
														$(".uploadimg-wrap").hide()
														
														
													}else if (data.msgtype == "tuwen") {
														$("#linkTitle").val(
																data.title);
														$("#description")
																.val(
																		data.description);
														$("#linkUrl").val(
																data.url);
														$("#picurl").val(
																data.picurl);
														$("#custommenuid")
																.val(
																		data.custommenuid);
														$("#linkKey").val(
																data.keyword);
														$(".msg-panel__tab>li").eq(1).addClass('on').siblings().removeClass('on');
														$(".msg-panel__context>div").eq(1).show().siblings().hide();
														$(".uploadimg-wrap").hide()
													} else if (data.msgtype == "pic") {
														$("#imgKey").val(
																data.keyword);
														$(".msg-panel__tab>li").eq(2).addClass('on').siblings().removeClass('on');
														$(".msg-panel__context>div").eq(2).show().siblings().hide();
														$(".uploadimg-wrap").show()
													}
												}
											});

								} else if (subType == 'miniprogram') {
									radios[2].checked = true;
									$('#editMsg').hide();
									$('#editPage').hide();
									$('#editMiniapp').show();
									$('input[name="appid"]').val(appid);
									$('input[name="pagepath"]').val(pagepath);
									$('input[name="url"]').val('');
								} else if (subType == 'view') {
//									alert("111111111")
									radios[1].checked = true;
									$('#editMsg').hide();
									$('#editPage').show();
									$('#editMiniapp').hide();
//									$('textarea[name="url"]').val(subUrl);
									$('#textAreaUrl').val(subUrl);
									$('input[name="appid"]').val('');
									$('input[name="pagepath"]').val('');
								}
							}
						}
						// 绑定删除事件
						// $('.msg-panel__del').on('click',delClick);
					});
	// 设置右边input的value
	function setInput(val) {
		$('input[name="custom_input_title"]').val(val);
	}
	// 实时更新右侧顶部标题
	function updateTit(text) {
		$('#cm-tit').html(text);
	}
	// 保存右侧菜单名称
	$('input[name="custom_input_title"]').keyup(
			function() {
				var val = $(this).val();
				var current = $('.subbutton__actived');
				if ($('.custom-menu-view__menu__sub__add').hasClass(
						'subbutton__actived')) {
					var row = current.attr('id').lastIndexOf('_') - 1;
					var col = current.attr('id').lastIndexOf('_') + 1;
					var sub_row = current.attr('id').substr(row, 1);
					var sub_col = current.attr('id').substring(col);
					button[sub_row].sub_button[sub_col].name = val;
					current.find('.text-ellipsis').text(val);
					updateTit(val);
				} else if ($('.custom-menu-view__menu').hasClass(
						'subbutton__actived')) {
					var alt = current.attr('alt');
					button[alt].name = val;
					current.children('.text-ellipsis').text(val);
					updateTit(val)
				}

			});
	// 保存右侧跳转页面的url
	$('#textAreaUrl').keyup(
			function() {
				var val = $(this).val();
				var current = $('.subbutton__actived');
				if ($('.custom-menu-view__menu__sub__add').hasClass(
						'subbutton__actived')) {
					var row = current.attr('id').lastIndexOf('_') - 1;
					var col = current.attr('id').lastIndexOf('_') + 1;
					var sub_row = current.attr('id').substr(row, 1);
					var sub_col = current.attr('id').substring(col);
					button[sub_row].sub_button[sub_col].url = val;
					button[sub_row].sub_button[sub_col].type = 'view';
					if (button[sub_row].sub_button[sub_col].url == '') {
						delete button[sub_row].sub_button[sub_col].url;
					}
				} else if ($('.custom-menu-view__menu').hasClass(
						'subbutton__actived')) {
					var alt = current.attr('alt');
					button[alt].url = val;
					button[alt].type = 'view';
					if (button[alt].url == '') {
						delete button[alt].url;
					}
				}

			});

	// 保存右侧跳转页面的appid
	$('input[name="appid"]')
			.keyup(
					function() {
						var val = $(this).val();
						var current = $('.subbutton__actived');
						if ($('.custom-menu-view__menu__sub__add').hasClass(
								'subbutton__actived')) {
							var row = current.attr('id').lastIndexOf('_') - 1;
							var col = current.attr('id').lastIndexOf('_') + 1;
							var sub_row = current.attr('id').substr(row, 1);
							var sub_col = current.attr('id').substring(col);
							button[sub_row].sub_button[sub_col].url = 'http://mp.weixin.qq.com';
							button[sub_row].sub_button[sub_col].appid = val;
							button[sub_row].sub_button[sub_col].type = 'miniprogram';
							if (button[sub_row].sub_button[sub_col].appid == '') {
								delete button[sub_row].sub_button[sub_col].appid;
							}
						} else if ($('.custom-menu-view__menu').hasClass(
								'subbutton__actived')) {
							var alt = current.attr('alt');
							button[alt].url = 'http://mp.weixin.qq.com';
							button[alt].appid = val;
							button[alt].type = 'miniprogram';
							if (button[alt].appid == '') {
								delete button[alt].appid;
							}
						}

					});

	// 保存右侧跳转页面的pagepath
	$('input[name="pagepath"]').keyup(
			function() {
				var val = $(this).val();
				var current = $('.subbutton__actived');
				if ($('.custom-menu-view__menu__sub__add').hasClass(
						'subbutton__actived')) {
					var row = current.attr('id').lastIndexOf('_') - 1;
					var col = current.attr('id').lastIndexOf('_') + 1;
					var sub_row = current.attr('id').substr(row, 1);
					var sub_col = current.attr('id').substring(col);
					button[sub_row].sub_button[sub_col].pagepath = val;

					if (button[sub_row].sub_button[sub_col].pagepath == '') {
						delete button[sub_row].sub_button[sub_col].pagepath;
					}
				} else if ($('.custom-menu-view__menu').hasClass(
						'subbutton__actived')) {
					var alt = current.attr('alt');
					button[alt].pagepath = val;

					if (button[alt].pagepath == '') {
						delete button[alt].pagepath;
					}
				}

			});

	// 自定义菜单排序
	$('#sortBtnc')
			.click(
					function() {
						var btnWrap = $('.custom-menu-view__footer__right')
								.find('.custom-menu-view__menu');
						var numBtn = btnWrap.length;
						$('#sortBtnc').hide();
						$('#sortBtn').show();
						$('#saveBtns').show();
						$('.iBtn').parents('.custom-menu-view__menu').show();
						if (button.length > 0) {
							$('.cm-edit-after').show().siblings().hide();
						} else {
							$('.cm-edit-before').show().siblings().hide();
						}

						for (var n = 0; n < numBtn; n++) {
							var ul = btnWrap[n].getElementsByTagName('ul')[0];
							if (ul) {
								(function(n) {
									ul.setAttribute('id', 'menuStage_2_'
											+ (n + 1));
									sortIndex = false;
									sortable(n + 1, sortIndex);
									// $('.text-ellipsis>i').parents('li').show();
									var i_el = '<li class="custom-menu-view__menu__sub__add"><div class="text-ellipsis"><i class="glyphicon glyphicon-plus text-info"></i></div></li>';
									$('.custom-menu-view__menu__sub').eq(n)
											.append(i_el);
								})(n);
								if (ix == 1) {
									$('.custom-menu-view__menu').css({
										width : '50%'
									})
								}
								if (ix == 2) {
									$('.custom-menu-view__menu').css({
										width : '33.3333%'
									});
								}

							}
						}
					});
	$('#sortBtn').click(
			function() {
				var btnWrap = $('.custom-menu-view__footer__right').find(
						'.custom-menu-view__menu');
				var numBtn = btnWrap.length;
				$('#sortBtnc').show();
				$('#sortBtn').hide();
				$('#saveBtns').hide();
				$('.iBtn').parents('.custom-menu-view__menu').hide();
				$('.cm-drag-before').show().siblings().hide();
				for (var n = 0; n < numBtn; n++) {
					var ul = btnWrap[n].getElementsByTagName('ul')[0];
					if (ul) {
						(function(n) {
							ul.setAttribute('id', 'menuStage_2_' + (n + 1));
							sortIndex = true;
							sortable(n + 1, sortIndex);
							$('.text-ellipsis>i').parents('li').remove();
						})(n);
						if (ix == 1) {
							$('.custom-menu-view__menu').css({
								width : '100%'
							})
						}
						if (ix == 2) {
							$('.custom-menu-view__menu').css({
								width : '50%'
							});
						}

					}
				}

			});
	function sortable(m, sortIndex) {
		if (sortIndex) {
			Sortable.create(document.getElementById('menuStage_2_' + m), {
				animation : 300, // 动画参数
				disabled : false,
			});
		} else {
			var el = document.getElementById('menuStage_2_' + m);
			var sortable = Sortable.create(el, {
				disabled : true,
			});
			sortable.destroy();

		}
	}

	// tab切换
	$('.msg-panel__tab>li').click(
			function() {
				var _index = $(this).index();
				console.log(_index);

				var is_Actived = $('.custom-menu-view__menu').hasClass(
						'subbutton__actived');// 一级菜单选择项
				var is_actived = $('.custom-menu-view__menu__sub__add')
						.hasClass('subbutton__actived');// 二级菜单选中项
				var rowIndex = 0;
				var colIndex = 0;

				if (is_Actived) {
					rowIndex = $('.subbutton__actived').attr('alt');
					if (_index == 0) {
						button[rowIndex].type = 'click';
						$("#msgType").val("text");
						$(".msg-panel__context_word").show();
						$(".msg-panel__context_tuwen").hide();
						$(".msg-panel__context_pic").hide();
					} else if (_index == 1) {
						button[rowIndex].type = 'click';
						$("#msgType").val("tuwen");
						$(".msg-panel__context_word").hide();
						$(".msg-panel__context_tuwen").show();
						$(".msg-panel__context_pic").hide();
						
					} else if (_index == 2) {
						button[rowIndex].type = 'click';
						$("#msgType").val("pic");
						$(".msg-panel__context_word").hide();
						$(".msg-panel__context_tuwen").hide();
						$(".msg-panel__context_pic").show();
					}

				} else if (is_actived) {
					rowIndex = $('.subbutton__actived').attr('id').substr(
							$('.subbutton__actived').attr('id')
									.lastIndexOf('_') - 1, 1);
					colIndex = $('.subbutton__actived').attr('id').substr(
							$('.subbutton__actived').attr('id')
									.lastIndexOf('_') + 1, 1);
					if(_index==2){
						$(".uploadimg-wrap").show();
					}else{
						$(".uploadimg-wrap").hide();
					}
					
					if (_index == 0) {
						button[rowIndex].sub_button[colIndex].type = 'click';
						$("#msgType").val("text");
						$(".msg-panel__context_word").show();
						$(".msg-panel__context_tuwen").hide();
						$(".msg-panel__context_pic").hide();

					} else if (_index == 1) {
						button[rowIndex].sub_button[colIndex].type = 'click';
						$("#msgType").val("tuwen");
						$(".msg-panel__context_word").hide();
						$(".msg-panel__context_tuwen").show();
						$(".msg-panel__context_pic").hide();
						
					} else if (_index == 2) {
						button[rowIndex].sub_button[colIndex].type = 'click';
						$("#msgType").val("pic");
						$(".msg-panel__context_word").hide();
						$(".msg-panel__context_tuwen").hide();
						$(".msg-panel__context_pic").show();
					}
				}

				$('.msg-panel__tab>li').eq($(this).index()).addClass('on')
						.siblings().removeClass('on');
				$('.msg-panel__context').eq($(this).index())
						.removeClass('hide').siblings().addClass('hide')

			});

	// 菜单内容跳转
	var radios = document.getElementsByName("radioBtn");

	for (var n = 0; n < radios.length; n++) {
		radios[n].index = n;
		radios[n].onchange = function() {
			var is_Actived = $('.custom-menu-view__menu').hasClass(
					'subbutton__actived');// 一级菜单选择项
			var is_actived = $('.custom-menu-view__menu__sub__add').hasClass(
					'subbutton__actived');// 二级菜单选中项
			var rowIndex = 0;
			var colIndex = 0;
			// 如果选中的是一级菜单
			if (is_Actived) {
				// 得到一级菜单下标
				rowIndex = $('.subbutton__actived').attr('alt');

				if (radios[this.index].checked == true) {
					if (radios[this.index].value == 'sendmsg') {
						$('#editMsg').show();
						$('#editPage').hide();
						$('#editMiniapp').hide();
						button[rowIndex].type = "click";
						delete button[rowIndex].url;
						delete button[rowIndex].appid;
						delete button[rowIndex].pagepath;

					} else if (radios[this.index].value == 'link') {
						$('#editMsg').hide();
						$('#editPage').show();
						$('#editMiniapp').hide();
						$(".uploadimg-wrap").hide();

						button[rowIndex].type = "view";
						delete button[rowIndex].appid;
						delete button[rowIndex].pagepath;
						delete button[rowIndex].key;

					} else if (radios[this.index].value == 'miniapp') {
						$('#editMsg').hide();
						$('#editPage').hide();
						$('#editMiniapp').show();
						$(".uploadimg-wrap").hide();

						button[rowIndex].type = "miniprogram";
						delete button[rowIndex].url;
						delete button[rowIndex].key;

					}
				}

				// 如果选中的是二级级菜单
			} else if (is_actived) {
				rowIndex = $('.subbutton__actived').attr('id')
						.substr(
								$('.subbutton__actived').attr('id')
										.lastIndexOf('_') - 1, 1);
				colIndex = $('.subbutton__actived').attr('id')
						.substr(
								$('.subbutton__actived').attr('id')
										.lastIndexOf('_') + 1, 1);

				if (radios[this.index].checked == true) {
					if (radios[this.index].value == 'sendmsg') {
						$('#editMsg').show();
						$('#editPage').hide();
						$('#editMiniapp').hide();
						button[rowIndex].sub_button[colIndex].type = "click";
						delete button[rowIndex].sub_button[colIndex].url;
						delete button[rowIndex].sub_button[colIndex].appid;
						delete button[rowIndex].sub_button[colIndex].pagepath;

					} else if (radios[this.index].value == 'link') {
						$('#editMsg').hide();
						$('#editPage').show();
						$('#editMiniapp').hide();
						$(".uploadimg-wrap").hide();

						button[rowIndex].sub_button[colIndex].type = "view";
						delete button[rowIndex].sub_button[colIndex].key;
						delete button[rowIndex].sub_button[colIndex].appid;
						delete button[rowIndex].sub_button[colIndex].pagepath;

					} else if (radios[this.index].value == 'miniapp') {
						$('#editMsg').hide();
						$('#editPage').hide();
						$('#editMiniapp').show();
						$(".uploadimg-wrap").hide();

						button[rowIndex].sub_button[colIndex].type = "miniprogram";
						delete button[rowIndex].sub_button[colIndex].key;
						delete button[rowIndex].sub_button[colIndex].url;
					}
				}
			}

		};
	}
	// id为selectModal弹框选中遮罩层
	$('#selectModal .modal-body .panel').click(function() {

		$(this).find('.mask-bg').show();
		$(this).parent().siblings().find('.mask-bg').hide();
		mId = $(this).parent().attr('id');
	});
	// id为selectModal弹框确定按钮事件
	$('#selectModal .ensure').on(
			'click',
			function() {

				var msgTemp = $('.msg-template');
				var delEl = '<span class="msg-panel__del del-tuwen">删除</span>';
				if (mId != null) {
					msgTemp.html($('#' + mId).html());
					delElement();
					msgTemp.find('.mask-bg').hide();
					msgTemp.siblings().hide();
					msgTemp.show();
					tempObj[mId] = msgTemp.html();
					// 绑定删除事件
					$('.msg-panel__del').on('click', delClick);
					var current = $('.subbutton__actived');
					var input_name = $('input[name="custom_input_title"]');
					if ($('.custom-menu-view__menu__sub__add').hasClass(
							'subbutton__actived')) {
						var row = current.attr('id').lastIndexOf('_') - 1;
						var col = current.attr('id').lastIndexOf('_') + 1;
						var sub_row = current.attr('id').substr(row, 1);
						var sub_col = current.attr('id').substring(col);

						button[sub_row].sub_button[sub_col].name = input_name
								.val();
						button[sub_row].sub_button[sub_col].key = mId;
						button[sub_row].sub_button[sub_col].type = 'click';
					} else if ($('.custom-menu-view__menu').hasClass(
							'subbutton__actived')) {
						var alt = current.attr('alt');
						button[alt].name = input_name.val();
						button[alt].key = mId;
						button[alt].type = 'click';
					}

				}
				$('#selectModal').modal('hide');
			});
	// type为click时添加删除按钮元素
	function delElement() {
		var msgTemp = $('.msg-template');
		var delEl = '<span class="msg-panel__del del-tuwen">删除</span>';
		msgTemp.append(delEl);
		if (msgTemp.find('span').length == 0) {
			msgTemp.append(delEl);
		}
	}
	;
	var delClick = function() {
		// $('.msg-template').empty();
		// $('.msg-context__item').show();
		$('.mask-bg').hide();

		var current = $('.subbutton__actived');
		if ($('.custom-menu-view__menu__sub__add').hasClass(
				'subbutton__actived')) {
			var row = current.attr('id').lastIndexOf('_') - 1;
			var col = current.attr('id').lastIndexOf('_') + 1;
			var sub_row = current.attr('id').substr(row, 1);
			var sub_col = current.attr('id').substring(col);
			delete button[sub_row].sub_button[sub_col].key;
		} else if ($('.custom-menu-view__menu').hasClass('subbutton__actived')) {
			var alt = current.attr('alt');
			delete button[alt].key;
		}
	};
	// 删除菜单按钮
	$('#delMenu').click(
			function() {
				var is_Actived = $('.custom-menu-view__menu').hasClass(
						'subbutton__actived');// 一级菜单选择项
				var is_actived = $('.custom-menu-view__menu__sub__add')
						.hasClass('subbutton__actived');// 二级菜单选中项
				var rowIndex = 0;
				var colIndex = 0;

				if (is_Actived) {
					rowIndex = $('.subbutton__actived').attr('alt');
					var subText = button[rowIndex].name;
					var subKey = button[rowIndex].key;
					var length = button[rowIndex].sub_button.length;
					var blength = button.length;
					if(blength==1){
						alert("只有一个主菜单不能删除");
						location.reload();
					}
					if (length == 0) {
						$.ajax({
							type : "POST",
							url : "menu/delLinkMsg",
							data : {
								keyword : subKey
							},
							success : function(data) {
								if (data == "1") {
									alert("删除菜单是《" + subText + "》图文链接消息成功");
								}
							}
						});
						$('.subbutton__actived').remove();
						delete button[rowIndex];
					} else {
						alert("还有《子菜单》不能直接删除");
						location.reload();
					}

					
				} else if (is_actived) {
					rowIndex = $('.subbutton__actived').attr('id').substr(
							$('.subbutton__actived').attr('id')
									.lastIndexOf('_') - 1, 1);
					colIndex = $('.subbutton__actived').attr('id').substr(
							$('.subbutton__actived').attr('id')
									.lastIndexOf('_') + 1, 1);
					var subText = button[rowIndex].sub_button[colIndex].name;
					var subKey = button[rowIndex].sub_button[colIndex].key;
					var length = button[rowIndex].sub_button.length;
					if (length == 1) {
						$.ajax({
							type : "POST",
							url : "menu/delLinkMsg",
							data : {
								keyword : subKey
							},
							success : function(data) {
								if (data == "1") {
									alert("删除菜单是《" + subText + "》图文链接消息成功");
								}
							}
						});
						button[rowIndex].type = "click";
						button[rowIndex].key = "tuwen";
						$('.subbutton__actived').remove();
						delete button[rowIndex].sub_button[colIndex];
					} else {
						$.ajax({
							type : "POST",
							url : "menu/delLinkMsg",
							data : {
								keyword : subKey
							},
							success : function(data) {
								if (data == "1") {
									alert("删除菜单是《" + subText + "》图文链接消息成功");
								}
							}
						});
						$('.subbutton__actived').remove();
						delete button[rowIndex].sub_button[colIndex];
						
					}

//					$('.subbutton__actived').remove();
//					delete button[rowIndex].sub_button[colIndex];
				}
				// 清除右边数据
				$('.cm-edit-before').show().siblings().hide();
				updateTit('');
				setInput('');
				$('input[name="url"]').val('');
				$('input[name="appid"]').val('');
				$('input[name="pagepath"]').val('');
			})
	// 保存自定义菜单
	$('#saveBtns')
			.click(
					function() {
						// 选中的是一级菜单
						var activeBtn = $('.custom-menu-view__menu').hasClass(
								'subbutton__actived');
						// 选中的是二级菜单
						var activeSubBtn = $(
								'.custom-menu-view__menu__sub__add').hasClass(
								'subbutton__actived');
						var rowIndex = 0;
						var colIndex = 0;
						var url = null;
						var strRegex = '(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]';
						var re = new RegExp(strRegex);
						// 如果选中的是一级菜单
						if (activeBtn) {
							// 得到一级菜单的下标
							rowIndex = $('.subbutton__actived').attr('alt');
						} else if (activeSubBtn) {// 如果选中的二级菜单
							// 得到一级菜单下标、
							rowIndex = $('.subbutton__actived').attr('id')
									.substr(
											$('.subbutton__actived').attr('id')
													.lastIndexOf('_') - 1, 1);
							// 得到二级菜单下标
							colIndex = $('.subbutton__actived').attr('id')
									.substr(
											$('.subbutton__actived').attr('id')
													.lastIndexOf('_') + 1, 1);
						}

						if (activeBtn) {
							// 一级菜单
							if (button[rowIndex].hasOwnProperty('url')) {
								url = button[rowIndex].url;
								if (!re.test(url)) {
									alert("请输入正确的url地址！");
									return false;
								}
								saveAjax();
							} else if (button[rowIndex].hasOwnProperty('key')) {
								saveAjax();
							} else {
								alert(JSON.stringify(obj))
								alert("菜单内容不能为空！");
							}
						} else if (activeSubBtn) {
							// 二级菜单
							if (button[rowIndex].sub_button[colIndex]
									.hasOwnProperty('url')) {
								url = button[rowIndex].sub_button[colIndex].url;
								if (!re.test(url)) {
									alert("请输入正确的url地址！");
									return false;
								}
								saveAjax();
							} else if (button[rowIndex].sub_button[colIndex]
									.hasOwnProperty('key')) {
								// alert("请选择图文信息！");
								saveAjax();
							} else {
								alert(JSON.stringify(obj))
								alert("菜单内容不能为空！");
							}
						} else {
							saveAjax();
						}
					});
	// 保存
	function saveAjax() {

		$.ajax({
			type : "POST",
			url : "menu/createWeixinCustomMenu",
			data : {
				"menuJson" : JSON.stringify(obj),// 先将对象转换为字符串再传给后台
				"num":num
			},
			dataType : "json",
			success : function(data) {
				// alert(data.errmsg)
				// alert(data.errcode)
				if (data.errmsg == 'ok') {
					alert("发布成功！");
					location.reload();
				} else {
					alert(data.errmsg);
				}
			}
		});
	}
	// 保存文本数据
	$("#addWord").click(
			function() {
				var textKey = $("#textKey").val();
				var msgType = $("#wordType").val();
				var is_Actived = $('.custom-menu-view__menu').hasClass(
						'subbutton__actived');// 一级菜单选择项
				var is_actived = $('.custom-menu-view__menu__sub__add')
						.hasClass('subbutton__actived');// 二级菜单选中项
				var rowIndex = 0;
				var colIndex = 0;
				if (is_Actived) {
					rowIndex = $('.subbutton__actived').attr('alt');
					if (msgType == "word") {
						button[rowIndex].key = textKey;
						button[rowIndex].type = "click";
					}

				} else if (is_actived) {
					rowIndex = $('.subbutton__actived').attr('id').substr(
							$('.subbutton__actived').attr('id')
									.lastIndexOf('_') - 1, 1);
					colIndex = $('.subbutton__actived').attr('id').substr(
							$('.subbutton__actived').attr('id')
									.lastIndexOf('_') + 1, 1);
					if (msgType == "word") {
						button[rowIndex].sub_button[colIndex].key = textKey;
						button[rowIndex].sub_button[colIndex].type = "click";
					}

				}
				//获取到菜单的名称
				var menuname = $('input[name="custom_input_title"]').val();
				//获取到发送文本的内容
				var content = $("#textContent").val();
				
				$.ajax({
					type : "POST",
					url : "menu/linkmsg",
					data : {
						menuname : menuname,
						content : content,
						keyword : textKey,
						msgtype : msgType
					},
					success : function(data) {
						alert("保存发送的文本数据成功");
					}
				});
			})
			
	// 保存图文数据
	$("#addTuwen").click(
			function() {
				var linkKey = $("#linkKey").val();
				var msgType = $("#msgType").val();
				var is_Actived = $('.custom-menu-view__menu').hasClass(
						'subbutton__actived');// 一级菜单选择项
				var is_actived = $('.custom-menu-view__menu__sub__add')
						.hasClass('subbutton__actived');// 二级菜单选中项
				var rowIndex = 0;
				var colIndex = 0;
				if (is_Actived) {
					rowIndex = $('.subbutton__actived').attr('alt');
					if (msgType == "tuwen") {
						button[rowIndex].key = linkKey;
						button[rowIndex].type = "click";
					}

				} else if (is_actived) {
					rowIndex = $('.subbutton__actived').attr('id').substr(
							$('.subbutton__actived').attr('id')
									.lastIndexOf('_') - 1, 1);
					colIndex = $('.subbutton__actived').attr('id').substr(
							$('.subbutton__actived').attr('id')
									.lastIndexOf('_') + 1, 1);
					if (msgType == "tuwen") {
						button[rowIndex].sub_button[colIndex].key = linkKey;
						button[rowIndex].sub_button[colIndex].type = "click";
					}

				}

				var menuname = $('input[name="custom_input_title"]').val();
				var title = $("#linkTitle").val();
				var description = $("#description").val();
				var url = $("#linkUrl").val();
				var picurl = $("#picurl").val();

				var msgType = $("#msgType").val();
				$.ajax({
					type : "POST",
					url : "menu/linkmsg",
					data : {
						menuname : menuname,
						title : title,
						description : description,
						url : url,
						picurl : picurl,
						keyword : linkKey,
						msgtype : msgType

					},
					success : function(data) {
						alert("保存发送的图文数据成功");
					}
				});
			})
			
			
			
			
			
	$("#uploadbtn").click(function() {
		upload()
	})

	// 保存图片消息的数据和发布
	$("#image_input").change(function(e){	
		 var file = this.files[0];
	     var reader = new FileReader();
	     reader.readAsDataURL(file);
	     reader.onload = function (e) {
	       base64Code=this.result;
	       $("#imgpre").show();
	       $("#imgpre").attr("src",base64Code);
	     }
	})
	function upload() {
		var imagePath = $("#image_input").val();
		if (imagePath == "") {
			alert("请上传图片文件");
			return false;
		}
		var strExtension = imagePath.substr(imagePath.lastIndexOf('.') + 1);
		if (strExtension != 'jpg' && strExtension != 'gif'
				&& strExtension != 'png' && strExtension != 'bmp') {
			alert("请上传图片文件");
			return false;
		}

		var imgKey = $("#imgKey").val();
		var imgMsgType = $("#imgMsgType").val();
		var menuname = $('input[name="custom_input_title"]').val();
		var is_Actived = $('.custom-menu-view__menu').hasClass(
				'subbutton__actived');// 一级菜单选择项
		var is_actived = $('.custom-menu-view__menu__sub__add').hasClass(
				'subbutton__actived');// 二级菜单选中项
		var rowIndex = 0;
		var colIndex = 0;
		if (is_Actived) {
			rowIndex = $('.subbutton__actived').attr('alt');
			if (imgMsgType == "pic") {
				button[rowIndex].key = imgKey;
				button[rowIndex].type = "click";
			}

		} else if (is_actived) {
			rowIndex = $('.subbutton__actived').attr('id')
					.substr(
							$('.subbutton__actived').attr('id')
									.lastIndexOf('_') - 1, 1);
			colIndex = $('.subbutton__actived').attr('id')
					.substr(
							$('.subbutton__actived').attr('id')
									.lastIndexOf('_') + 1, 1);
			if (imgMsgType == "pic") {
				button[rowIndex].sub_button[colIndex].key = imgKey;
				button[rowIndex].sub_button[colIndex].type = "click";
			}

		}
		$("#form").ajaxSubmit({
			type : 'POST',
			url : 'menu/uploadImg',
			data:{
				num:num
			},
			success : function(data) {
				alert("上传图片到微信成功");
//				console.log(imgKey)
//				console.log(imgMsgType)
//				console.log(data.media_id)
//				console.log(data.url)
				$.ajax({
					type : "POST",
					url : "menu/saveImgInfo",
					data : {
						mediaId : data.media_id,
						url :  data.url,
						menuname : menuname,
						keyword : imgKey,
						msgtype : imgMsgType
					},
					success : function(data) {
						alert("保存发送消息数据成功")
					}
				});
			},
			error : function() {
				alert("上传失败，请检查网络后重试");
			}
		});
	}

});