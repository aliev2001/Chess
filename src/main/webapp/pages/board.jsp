<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file='../includes/head.jsp' %>

    <style>
        .box{
            width: 60px;
            height: 60px;
            border: 1px solid black;
            display: inline-block;
            margin: -2px;
            font-size: 40px;
            text-align: center;
            background-color: burlywood;
        }

        .black{
            background-color: saddlebrown;
        }
    </style>

<body>
<%@ include file='../includes/header.jsp' %>
    <div align="center" style="margin-top: 20px">
        <div>
            <div>
                <div class="box" id="a8"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/bR.png" width="50px"></div>
                <div class="box black" id="b8"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/bN.png" width="50px"></div>
                <div class="box" id="c8"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/bB.png" width="50px"></div>
                <div class="box black" id="d8"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/bK.png" width="50px"></div>
                <div class="box" id="e8"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/bQ.png" width="50px"></div>
                <div class="box black" id="f8"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/bB.png" width="50px"></div>
                <div class="box" id="g8"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/bN.png" width="50px"></div>
                <div class="box black" id="h8"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/bR.png" width="50px"></div>
            </div>
            <div>
                <div class="box black" id="a7"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/bP.png" width="50px"></div>
                <div class="box" id="b7"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/bP.png" width="50px"></div>
                <div class="box black" id="c7"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/bP.png" width="50px"></div>
                <div class="box" id="d7"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/bP.png" width="50px"></div>
                <div class="box black" id="e7"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/bP.png" width="50px"></div>
                <div class="box" id="f7"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/bP.png" width="50px"></div>
                <div class="box black" id="g7"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/bP.png" width="50px"></div>
                <div class="box" id="h7"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/bP.png" width="50px"></div>
            </div>
        </div>

        <div>
            <div>
                <div class="box" id="a6"></div>
                <div class="box black" id="b6"></div>
                <div class="box" id="c6"></div>
                <div class="box black" id="d6"></div>
                <div class="box" id="e6"></div>
                <div class="box black" id="f6"></div>
                <div class="box" id="g6"></div>
                <div class="box black" id="h6"> </div>
            </div>
            <div>
                <div class="box black" id="a5"></div>
                <div class="box" id="b5"></div>
                <div class="box black" id="c5"></div>
                <div class="box" id="d5"></div>
                <div class="box black" id="e5"></div>
                <div class="box" id="f5"></div>
                <div class="box black" id="g5"></div>
                <div class="box" id="h5"></div>
            </div>
        </div>

        <div>
            <div>
                <div class="box" id="a4"></div>
                <div class="box black" id="b4"></div>
                <div class="box" id="c4"></div>
                <div class="box black" id="d4"></div>
                <div class="box" id="e4"></div>
                <div class="box black" id="f4"></div>
                <div class="box" id="g4"></div>
                <div class="box black" id="h4"> </div>  </div>
            <div>
                <div class="box black" id="a3"></div>
                <div class="box" id="b3"></div>
                <div class="box black" id="c3"></div>
                <div class="box" id="d3"></div>
                <div class="box black" id="e3"></div>
                <div class="box" id="f3"></div>
                <div class="box black" id="g3"></div>
                <div class="box" id="h3"></div>
            </div>
        </div>

        <div>
            <div>
                <div class="box" id="a2"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/wP.png" width="50px"></div>
                <div class="box black" id="b2"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/wP.png" width="50px"></div>
                <div class="box" id="c2"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/wP.png" width="50px"></div>
                <div class="box black" id="d2"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/wP.png" width="50px"></div>
                <div class="box" id="e2"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/wP.png" width="50px"></div>
                <div class="box black" id="f2"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/wP.png" width="50px"></div>
                <div class="box" id="g2"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/wP.png" width="50px"></div>
                <div class="box black" id="h2"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/wP.png" width="50px"></div>
            </div>
            <div>
                <div class="box black" id="a1"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/wR.png" width="50px"></div>
                <div class="box" id="b1"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/wN.png" width="50px"></div>
                <div class="box black" id="c1"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/wB.png" width="50px"></div>
                <div class="box" id="d1"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/wQ.png" width="50px"></div>
                <div class="box black" id="e1"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/wK.png" width="50px"></div>
                <div class="box" id="f1"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/wB.png" width="50px"></div>
                <div class="box black" id="g1"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/wN.png" width="50px"></div>
                <div class="box" id="h1"><img src="${pageContext.request.contextPath}/img/chesspieces/wikipedia/wR.png" width="50px"></div>
            </div>
        </div>
    </div>

<script>

</script>

</body>
</html>
