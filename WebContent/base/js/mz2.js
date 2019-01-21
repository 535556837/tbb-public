var list1 = new Array;
list1[list1.length] ="汉族";
list1[list1.length] ="蒙古族" ;
list1[list1.length] ="回族";
list1[list1.length] ="藏族" ;
list1[list1.length] ="维吾尔族"; 
list1[list1.length] ="苗族";
list1[list1.length] ="彝族";
list1[list1.length] ="壮族" ;
list1[list1.length] ="布依族";
list1[list1.length] ="朝鲜族" ;
list1[list1.length] ="满族";
list1[list1.length] ="侗族";
list1[list1.length] ="瑶族";
list1[list1.length] ="白族";
list1[list1.length] ="土家族";
list1[list1.length] ="哈尼族";
list1[list1.length] ="哈萨克族"; 
list1[list1.length] ="傣族";
list1[list1.length] ="黎族";
list1[list1.length] ="僳僳族";
list1[list1.length] ="佤族" ;
list1[list1.length] ="畲族";
list1[list1.length] ="高山族"; 
list1[list1.length] ="拉祜族" ;
list1[list1.length] ="水族";
list1[list1.length] ="东乡族";
list1[list1.length] ="纳西族";
list1[list1.length] ="景颇族";
list1[list1.length] ="柯尔克孜族";
list1[list1.length] ="土族";
list1[list1.length] ="达斡尔族";
list1[list1.length] ="仫佬族";
list1[list1.length] ="羌族";
list1[list1.length] ="布朗族";
list1[list1.length] ="撒拉族";
list1[list1.length] ="毛南族";
list1[list1.length] ="仡佬族";
list1[list1.length] ="锡伯族";
list1[list1.length] ="阿昌族";
list1[list1.length] ="普米族";
list1[list1.length] ="塔吉克族";
list1[list1.length] ="怒族";
list1[list1.length] ="乌孜别克族";
list1[list1.length] ="俄罗斯族";
list1[list1.length] ="鄂温克族";
list1[list1.length] ="德昂族";
list1[list1.length] ="保安族";
list1[list1.length] ="裕固族";
list1[list1.length] ="京族";
list1[list1.length] ="塔塔尔族";
list1[list1.length] ="独龙族" ;
list1[list1.length] ="鄂伦春族";
list1[list1.length] ="赫哲族" ;
list1[list1.length] ="门巴族" ;
list1[list1.length] ="珞巴族";
list1[list1.length] ="基诺族";

    var ddlProvince = document.getElementById("nationality");
    for(var i =0;i<list1.length; i++)
    {
        var option = document.createElement("option");
        option.appendChild(document.createTextNode(list1[i]));
        option.value = list1[i];
        ddlProvince.appendChild(option);
    }
    function indexof(obj,value)
    {
        var k=0;
        for(;k<obj.length;k++)
        {
            if(obj[k] == value)
            return k;
        }
        return k;
    }
    function selectprovince(obj) {
        var index = indexof(list1,obj.value);
        for(var i =0;i<index.length; i++)
        {
            var option = document.createElement("option");
            option.appendChild(document.createTextNode(index[i]));
            option.value = index[i];
        }
    }