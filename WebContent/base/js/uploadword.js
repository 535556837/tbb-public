function uploadword(id,fileName,filePath,ue){
    var $ = jQuery,
     fileid=fileName,
    /*  $btn = $('#ctlBtn'), */
     state = 'pending',
     uploader;

    $("#"+id).html('<table align="left"><tr><td><input type="text" style="width:500px;height:30px;" id="'+fileid+'" name="'+fileid+'" placeholder="文件" ><input type="text" id="'+filePath+'" name="'+filePath+'" placeholder="文件" style="display: none" ><span id="state'+fileid+'"></span></td><td><div id="picker">选择文件</div><div id="btns" style="display: none"></div></td></tr></table>');
   
 
    
 uploader = WebUploader.create({

     // 不压缩imageu
     resize: false,

     // swf文件路径
     swf:'base/js/plugins/baiduuploader/Uploader.swf',

     // 文件接收服务端。
     server: 'commonAction/uploadWord',

     // 选择文件的按钮。可选。
     // 内部根据当前运行是创建，可能是input元素，也可能是flash.
     pick: '#picker',
     //fileSingleSizeLimit: 5242880,
     accept:{
		    title: 'file',
		    /*extensions: 'ppt,pptx,doc,docx,xls,xlsx,pdf',
		    mimeTypes: '.ppt,.pptx,.doc,.docx,.xls,.xlsx,.pdf'*/
		    extensions: 'docx',
		    mimeTypes: '.docx'
     }
 });
 
 uploader.on("error",function (type){
     if (type=="Q_TYPE_DENIED"){
         dialogMsg("myModal","messageP","请上传JPG、PNG格式文件");
     }else if(type=="F_EXCEED_SIZE"){
         dialogMsg("myModal","messageP","文件大小不能超过8M");
     }
 });
 // 当有文件添加进来的时候
 uploader.on( 'fileQueued', function( file ) {
 	//$("#"+fileid).val(file.name);
 	
 	$("#state"+fileid).text("等待上传...");
     uploader.upload();
 });

 // 文件上传过程中创建进度条实时显示。
 uploader.on( 'uploadProgress', function( file, percentage ) {
    
     // 避免重复创建
 /*     if ( !$percent.length ) {
         $percent = $('<div class="progress progress-striped active">' +
           '<div class="progress-bar" role="progressbar" style="width: 0%">' +
           '</div>' +
         '</div>').appendTo( $li ).find('.progress-bar');
     } */

     $("#state"+fileid).text('上传中'+ parseInt(percentage * 100) + '%');
     
 });

 uploader.on( 'uploadSuccess', function( file ,data) {
	ue.setContent(data.detail);
	//ue.setContent($("#advicecontentExt").val());
	//$("#advicecontentExt").val("aaaaa");
 	//$("#picker").hide();
 	//$("#btns").show();
 	$("#state"+fileid).html('');
 //	$("#btns").append('<a href="commonAction/download?fileName='+data.detail+'">下载</a>|<a id="del'+fileid+'" >删除</a>');
 	/*$("#del"+fileid).click(function(){
 		delfile(data);
 		$("#picker").show();
 		$("#btns").text('');
     	$("#btns").hide();
     	$("#"+fileid).val("");
     	$("#state"+fileid).html('');
 	});*/
 
 	//<a href="#">下载</a>
 });
 //物理上删除文件
 function delfile(data){
	 $.ajax({
			url : 'commonAction/delfile?fileName='+data.detail,
			type : 'POST',
			dataType: 'json',
			success : function(result){
				console.info(result);
				window.pubwin.alert('提示',result.responseText,null,"500px");
				//alert(result.responseText);				
			},
			error:function(result){
				console.info(result);
				window.pubwin.alert('提示',result.responseText,null,"500px");
				//alert(result.responseText);				
			}
		});
 }
 
 
 uploader.on( 'uploadError', function( file ) {
 	$("#state").text('上传出错');
 });

 uploader.on( 'uploadComplete', function( file ) {
     //$( '#'+file.id ).find('.progress').fadeOut();
 });

 uploader.on( 'all', function( type ) {
     if ( type === 'startUpload' ) {
         state = 'uploading';
     } else if ( type === 'stopUpload' ) {
         state = 'paused';
     } else if ( type === 'uploadFinished' ) {
         state = 'done';
     }

/*         if ( state === 'uploading' ) {
         $btn.text('暂停上传');
     } else {
         $btn.text('开始上传');
     } */
 });

/*   $btn.on( 'click', function() {
     if ( state === 'uploading' ) {
         uploader.stop();
     } else {
         uploader.upload();
     }
 }); */
}