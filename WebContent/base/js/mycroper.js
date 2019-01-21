        /**
         * 照片處理類
         */
        var imagecroper = {
        
            imagesrc:null,
            wid:0,
            hig:0,
        	initCropper : function (imageid,w,h) {
        		 $("#image_cropper").cropper("destroy");
        		 this.wid=w;
        		 this.hig=h;
        		imagesrc=imageid;
				var image=$("#image_cropper");				
        		image.attr('src', $("#"+imageid).attr('src')).cropper({
                	aspectRatio:   w/h,
					viewMode: 0,
					dragMode: 'move',
					autoCrop : true,
					autoCropArea : 1,
					// 是否允许拖动裁剪框，默认true
					cropBoxMovable : false,
					// 是否允许拖动 改变裁剪框大小
					cropBoxResizable : true										
                });
    			
    			$(document.body).on('click', '[data-method]', function() {
    				var data = $(this).data(),
    					$target, result;
    				if (data.method) {
    					data = $.extend({}, data); // Clone a new one
    					
    					if (typeof data.target !== 'undefined') {
    						$target = $(data.target);
    						if (typeof data.option === 'undefined') {
    							try {
    								data.option = JSON.parse($target.val());
    							} catch (e) {
    								console.log(e.message);
    							}
    						}
    					}
    					result = $('#image_cropper').cropper(data.method, data.option);
    					console.log(result);
    					if ($.isPlainObject(result) && $target) {
    						try {
    							$target.val(JSON.stringify(result));
    						} catch (e) {
    							console.log(e.message);
    						}
    					}
    				}
    			})
        	},
        	saveCropper : function (inputid) {
        		
        		var  option = {};            
                 option.fillColor = '#fff';
                 option.height=this.hig;
                 option.width=this.wid;
				var canva=$("#image_cropper").cropper('getCroppedCanvas',option);
				console.log(canva);
				var data=canva.toDataURL('image/jpeg');
				 $("#"+imagesrc).attr("src",data);
				
				 //上传
				 $.ajax({
					 url:"commonAction/base64UpLoad",
					 type:"post",
					 data:{base64Data:data},
					 dataType : 'text',
					 success:function(data){
						 $("#"+inputid).val(data);
					 },
					 error:function(){
						 console.log("上传失败");
					 }
				 });
				
        	}
        	
        }
        