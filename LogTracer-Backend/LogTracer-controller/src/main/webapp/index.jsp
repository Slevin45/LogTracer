<%--
  Created by IntelliJ IDEA.
  User: Loki
  Date: 06.04.16
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogTracer</title>
</head>
<body>
<style>
    table {
        border: 1px solid black;
    }

    td {
        border: 1px solid black;
    }
</style>
<input type=date name="sDate" id="sDate">
<input type=date name="eDate" id="eDate">
<input type=text name="phrase" id="phrase" size="40">
<button onclick="loadLogs()">Try</button>
<h1>Logs</h1>

<div id='id01'></div>
<div id='paginateLeft'></div>
<div id='paginateRight'></div>
<script>
    function paginate(current) {
        if (current == -1) {
            current = 0
        }
        debugger;
        var arr;
        var xhr = new XMLHttpRequest(),
                phrase = document.querySelector('#phrase'),
                sDate = document.querySelector('#sDate'),
                eDate = document.querySelector('#eDate');
        xhr.open('GET', '/api/getlog/7/' + phrase.value + '/' + sDate.value + '/' + eDate.value + '/' + current, false);
        xhr.send();

        if (xhr.status != 200) {
            alert('Ошибка ' + xhr.status + ': ' + xhr.statusText);
        }
        arr = JSON.parse(xhr.responseText)
        if (arr.length == 0) {
            alert('Sorry, we didnt find logs for you');
        }
        else {
            var i,
                    out = "<table>";
            for (i = 0; i < arr.length; i++) {
                out += "<tr><td>" + arr[i].tag + "</td>" +
                        "<td>" + arr[i].timestamp + "</td>" +
                        "<td>" + arr[i].message + "</td>" +
                        "<td>" + arr[i].exception + "</td>" +
                        "<td>" + arr[i].appId + "</td>" +
                        "<td>" + arr[i].id + "</td></tr>";
            }

            out += "</table>";

            document.getElementById("id01").innerHTML = out;
            debugger;

            buttonRight = '<input type="button" value=">>" onclick="paginate(' + parseInt(current + 1) + ')">';
            buttonLeft = '<input type="button" value="<<" onclick="paginate(' + parseInt(current - 1) + ')">';


            document.getElementById("paginateLeft").innerHTML = buttonLeft;
            document.getElementById("paginateRight").innerHTML = buttonRight;
        }
    }

    function loadLogs() {
        var firstPage = 0;
        paginate(firstPage);
    }

</script>


</body>
</html>