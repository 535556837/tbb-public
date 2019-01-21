var icon = "<i class='fa fa-times-circle'></i> ";
var validate = $("#vdform").validate({
    rules: {
        firstname: "required",
        lastname: "required",
        title: {
            required: true,
            minlength: 2,
            maxlength:20
        },
        adviceid:{
        	required: true
        },
        jc: {
            required: true,
        },
        jb: {
            required: true,
        },
        email: {
            required: true,
            email: true
        },
        contelephone: {
        	 required: true,
        },
        sfjgdy: {
       	 required: true,
        },
        tccs: {
      	 required: true,
        },
        sfzctryj: {
     	 required: true,
        },
        unit: {
    	 required: true,
     	},
    },
    messages: {
        firstname: icon + "请输入你的姓",
        lastname: icon + "请输入您的名字",
        title: {
            required: icon + "请输入您的提案标题",
        },
        adviceid: {
            required: icon + "请输入您的提案编号",
         },
        jc: {
            required: icon + "请再次选择届次",
        },
        jb: {
            required: icon + "请输入您的用户名",
        },
        email: {
            required: icon + "请输入您的邮箱",
         },
         sfjgdy: {
            required: icon + "请输入您的新密码",
        },
        sfzctryj: {
            required: icon + "请输入您的用户名",
        },
        tccs: {
            required: icon + "请输入您的旧密码",
         },
         unit: {
            required: icon + "请输入您的希望主办单位",
       // email: icon + "请输入您的E-mail",
       // agree: {
       //     required: icon + "必须同意协议后才能注册",
       //    element: '#agree-error'
        }
    }
});