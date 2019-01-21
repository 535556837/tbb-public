  // Web Uploader实例
var    uploader;

function imageupload(btid,imgid,resultid){
	  if(uploader){
		  return;
	  }
	  var $ = jQuery,
     
      // 优化retina, 在retina下这个值是2
      ratio = window.devicePixelRatio || 1,

      // 缩略图大小
      thumbnailWidth = 300 * ratio,
      thumbnailHeight = 300 * ratio;


  // 初始化Web Uploader
  uploader = WebUploader.create({

      // 自动上传。
      auto: true,

      // swf文件路径
      swf: 'base/js/plugins/baiduuploader/Uploader.swf',

      // 文件接收服务端。
      server: 'commonAction/upload',

      // 选择文件的按钮。可选。
      // 内部根据当前运行是创建，可能是input元素，也可能是flash.
      pick: '#'+btid,

      // 只允许选择文件，可选。
      accept: {
          title: 'Images',
          extensions: 'gif,jpg,jpeg,bmp,png',
          mimeTypes: 'image/*'
      }
  });
  setTimeout(function() {
	  uploader.refresh();
	}, 500);
  // 当有文件添加进来的时候
  uploader.on( 'fileQueued', function( file ) {
     
         
      // 创建缩略图
      uploader.makeThumb( file, function( error, src ) {
          if ( error ) {
              $img.replaceWith('<span>不能预览</span>');
              return;
          }

          $("#"+imgid).attr( 'src', src );
      }, thumbnailWidth, thumbnailHeight );
  });

  // 文件上传过程中创建进度条实时显示。
  uploader.on( 'uploadProgress', function( file, percentage ) {
  	     
  });

  // 文件上传成功，给item添加成功class, 用样式标记上传成功。
  uploader.on( 'uploadSuccess', function( file,data ) {	
	  
	 console.log(data);
      $( '#'+resultid ).val(data._raw);
      $("#"+imgid).attr( 'src','commonAction/getimgnew?fileName='+ data._raw);
  });

  // 文件上传失败，现实上传出错。
  uploader.on( 'uploadError', function( file ) {
      var $li = $( '#'+file.id ),
          $error = $li.find('div.error');

      // 避免重复创建
      if ( !$error.length ) {
          $error = $('<div class="error"></div>').appendTo( $li );
      }

      $error.text('上传失败');
  });

  // 完成上传完了，成功或者失败，先删除进度条。
  uploader.on( 'uploadComplete', function( file ) {
      $( '#'+file.id ).find('.progress').remove();
  });
	
}