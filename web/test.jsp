<%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2016/12/9
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索框测试</title>
    <style type="text/css">
        #myDiv{
            position: absolute;
            top: 50%;
            left: 50%;
            margin-left: -200px;
            margin-top: -50px;
        }
        .mouseOver{
            background: #708090;
            color: #FFFAFA;
        }
        .mouseOut{
            background: #FFFAFA;
            color: #000000;
        }
    </style>
    <script type="text/javascript">
        function getMoreContents() {
            var content=document.getElementById("keyword");
            if(content.value==""){
                clearContent();
                return;
            }
            xmlHttp=createXMLHttp();
//            alert(xmlHttp);
            var url="search?keyword="+escape(content.value);
            xmlHttp.open("GET",url,true);
            xmlHttp.onreadystatechange=callback;
            xmlHttp.send(null);
        }
        function callback() {
            if(xmlHttp.readyState==4) {
                if (xmlHttp.status == 200) {

                var result = xmlHttp.responseText;
                var json = eval("(" + result + ")");

               
               setContent(json);
            }
            }
        }
        function setLocation() {
            var content=document.getElementById("keyword");
            var width=content.offsetWidth;
            var left=content["offsetLeft"];
            var top=content["offsetTop"]+content.offsetHeight;
            var popDiv=document.getElementById("popDiv");
            popDiv.style.border="black 1px solid";
            popDiv.style.left=left+"px";
            popDiv.style.top=top+"px";
            popDiv.style.width=width+"px";
            document.getElementById("contentTable").style.width=width+"px";


        }
        function setContent(contents) {
            clearContent();
            setLocation();
            var size=contents.length;
            for(var i=0;i<size;i++){
                var nextNode=contents[i];
                var tr=document.createElement("tr");
                var td=document.createElement("td");
                td.setAttribute("border","0")
                td.setAttribute("bgcolor","#FFFAFA");
                td.onmouseover=function () {
                    this.className='mouseOver';
                }
                td.onmouseout=function () {
                    this.className='mouseOut';
                }

                var text=document.createTextNode(nextNode);
                td.appendChild(text);
                tr.appendChild(td);
                document.getElementById("content_table_body").appendChild(tr);
                td.onclick=function () {

                }
            }
        }
        function createXMLHttp() {
            var xmlHttp;
            if(window.XMLHttpRequest){
                xmlHttp=new XMLHttpRequest();
            }
            if (window.ActiveXObject){
                xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
                if(!xmlHttp){
                    xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
                }
            }
            return xmlHttp;
        }
        function clearContent() {
            var conetntBody=document.getElementById("content_table_body");
            var size=conetntBody.childNodes.length;
            for(var i=size-1;i>0;i--){
                conetntBody.removeChild(conetntBody.childNodes[i]);
            }
            document.getElementById("popDiv").style.border="none";
        }
        function keywordBlur() {
            clearContent();
        }
    </script>
</head>
<body>
<form action="search">
<div id="myDiv" >
    <%--输入框--%>
    <input id="keyword" type="text" size="50" onkeyup="getMoreContents()" 
    onblur="keywordBlur()" onfocus="getMoreContents()" name="content">
    <div id="popDiv"  >
        <table id="contentTable" bgcolor="#f0ffff" border="0" cellpadding="0" cellspacing="0">
            <tbody id="content_table_body" >

            </tbody>
        </table>
    </div>
</div>
</form>
</body>
</html>
