var files = WScript.Arguments; 
var fso = new ActiveXObject("Scripting.FileSystemObject"); 
var word = new ActiveXObject("Word.Application"); 
//word.ActivePrinter = "Zan Image Printer (Color)"; 

//files(0) ΪWORD�ĵ��ļ��� 
//files(1) Ϊ,ת������Ҫ�����·�� 
//����fso.GetBaseName(files(0))��,Ϊ��·��,����չ��,���ļ��� 
//files.lengthΪ�ļ������ĸ���,ʹ��ѭ������֧�ֶ��WORD�ĵ���ת�� 

var docfile = files(0); 
WScript.Echo(docfile );//�ɹ� 

try{ 
var doc = word.Documents.Open(docfile); 
WScript.Echo("Open");//�ɹ� 
//WORD�ļ�ת��PS�ļ�; 
word.PrintOut(); 
doc.Close(0); 



word.Quit(); 
WScript.Echo("isuccess");//�ɹ� 
WScript.Quit(0); 
} 
catch(x) 
{ 
word.Quit(); 
WScript.Echo(x);//ʧ�� 
WScript.Echo("isfail");//ʧ�� 
WScript.Quit(0); 
} 