var files = WScript.Arguments; 
var fso = new ActiveXObject("Scripting.FileSystemObject"); 
var word = new ActiveXObject("Word.Application"); 
//word.ActivePrinter = "Zan Image Printer (Color)"; 

//files(0) 为WORD文档文件名 
//files(1) 为,转换后需要保存的路径 
//调用fso.GetBaseName(files(0))后,为无路径,无扩展名,的文件名 
//files.length为文件参数的个数,使用循环可以支持多个WORD文档的转换 

var docfile = files(0); 
WScript.Echo(docfile );//成功 

try{ 
var doc = word.Documents.Open(docfile); 
WScript.Echo("Open");//成功 
//WORD文件转成PS文件; 
word.PrintOut(); 
doc.Close(0); 



word.Quit(); 
WScript.Echo("isuccess");//成功 
WScript.Quit(0); 
} 
catch(x) 
{ 
word.Quit(); 
WScript.Echo(x);//失败 
WScript.Echo("isfail");//失败 
WScript.Quit(0); 
} 