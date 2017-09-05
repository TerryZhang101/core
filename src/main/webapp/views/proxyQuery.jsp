<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>data transform center</title>
    <link rel="shortcut icon" href="../favicon.ico">
    <link rel="stylesheet" type="text/css" href="../css/demo.css" />
    <link rel="stylesheet" type="text/css" href="../css/style3.css" />
    <script type="text/javascript" src="../css/jquery-3.2.1.js"></script>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
</head>
<style type="text/css">
    #container_buttons{
        width: 700px;
    }
</style>
<body>
<div class="container">
    <!-- Codrops top bar -->
    <div class="codrops-top">
        <span><a href="#"><strong>Background Page</strong></a></span>
        <span class="right"><a href="#"><strong>Background Page</strong></a></span>
        <div class="clr"></div>
        <div class="clr"></div>
    </div><!--/ Codrops top bar -->
    <header>
        <h1>data <span>transform</span></h1>
        <h2>proxyQuery center</h2>
        <nav class="codrops-demos">
            <a class="current" href="./index.jsp">HomePage</a>
            <a class="current" href="websocket.jsp">UpperPage</a>
        </nav>
    </header>
    <section>
        <div id="container_buttons">
            <p>
            <form name="form1" method="post" >
                测试数据：<input id="data" type="text" name="data" value="anything" /><br/>
            </form>
            </p>
            <p>
                <a id="asubmit1" class="a_demo_three" href="#" onclick="submitForm();">
                    提交
                </a>
            </p>
            <p>
            <div>
                <textarea id="content" cols="100" rows="30"></textarea>
            </div>
            </p>

        </div>
    </section>
</div>
</body>
<script type="text/javascript">

    $(document).ready(function(){
        $("#asubmit1").click(function(){
            var request_data = '{"data":"' + $('#data').val() +'"}';
            $.ajax({
                type : 'POST',
                contentType : 'application/json',
                url : '<%=contextPath%>/test.do',
                processData : false,
                dataType : 'json',
                data : request_data,
                success : function(data) {
                    $('#content').val(data.message);
                },
                error : function() {
                    alert('返回异常');
                }
            });
        });
    });

</script>
</html>