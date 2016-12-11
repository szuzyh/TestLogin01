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
    </style>
    <script type="text/javascript">
        function getMoreContents() {
            var content=document.getElementById("keyword");
            if(content.value==""){
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
            if(xmlHttp.readyState==4&&xmlHttp.status==200){
                    var result=xmlHttp.responseText;
                    var json=eval("("+result+")");
            }
        }
        function setContent(contents) {
            var size=contents.length;
            for(var i=0;i<size;i++){
                var nextNode=contents[i];
                var tr=document.createElement("tr");
                var td=document.createElement("td");
                td.setAttribute("border","0")
                td.setAttribute("bgcolor","#FFFAFA");
                td.onmouseout=function () {
                    this.className='mouseOver';
                }
                td.onmouseout=function () {
                    this.className='mouseOut';
                }
                td.onclick=function () {
                    this.
                }
                var text=document.createTextNode(nextNode);
                td.appendChild(text);
                tr.appendChild(td);
                document.getElementById("content_table_body").appendChild(tr);
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
    </script>
</head>
<body>
<div id="myDiv">
    <%--输入框--%>
    <input id="keyword" type="text" size="50" onkeyup="getMoreContents()">
    <div id="popDiv"  >
        <table id="contentTable" bgcolor="#f0ffff" border="0" cellpadding="0" cellspacing="0">
            <tbody id="content_table_body">
         <tr><td>sssss</td></tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
