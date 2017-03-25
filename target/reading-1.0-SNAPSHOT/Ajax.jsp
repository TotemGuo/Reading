<%--
  Created by IntelliJ IDEA.
  User: Holmes
  Date: 2016/10/15
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="/jslib/jquery-3.1.1.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            var b = 0;
            $.ajax({
                type:"post",
                url:"http://localhost:8080/reading/setSession",
                contentType:"application/json",
                data:JSON.stringify({thread:1}),
                success:function(dataStr){
                    $('#sessionDetail p').eq(0).html('Thread1:'+dataStr);
                },
                error:function() {
                    alert("出错了！");
                }
            });

            $.ajax({
                type:"post",
                url:"http://localhost:8080/reading/setSession",
                contentType:"application/json",
                data:JSON.stringify({thread:2}),
                success:function(dataStr){
                    $('#sessionDetail p').eq(1).html('Thread2:'+dataStr);
                },
                error:function() {
                    alert("出错了！");
                }
            });

            $('#num').change(function(){
                var selectedNum = $('#num option:selected').val();
                var selectedNum2 = $('#num').find('option:selected').val();
                var selectedNum3 = $('#num option').eq(0).val();
                alert('selectedNum:'+selectedNum+'\nselectedNum2:'+selectedNum2+'\nselectedNum3:'+selectedNum3);
            });
        });
    </script>
</head>
<body>
    <div id="sessionDetail">
        <select id="num">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
        </select>
    </div>
</body>
</html>
