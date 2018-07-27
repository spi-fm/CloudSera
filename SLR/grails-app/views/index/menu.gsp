<!DOCTYPE html>
<html lang="${lang}">

<head>

    <%-- Head Meta --%>
	<g:render template="headMeta" contextPath="/"/>

    <title>CloudSERA | Menu</title>
    <link rel="icon" href="https://github.com/spi-fm/CloudSERA/raw/master/images/CloudSERA-sm.jpeg">

	<%-- CSS --%>
    <g:render template="css" contextPath="/"/>

</head>

<body>

    <div id="wrapper">

        <%-- Head --%>
        <g:render template="head" contextPath="/"/>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"><g:message code="pfc.main.h1" locale="${languageDefault}" /></h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>

            <%-- Menu center --%>
            <g:render template="menucenter" contextPath="/"/>

            <div class="row">
                <div class="col-lg-8">

                    <%-- Logger
                    <g:render template="logger" contextPath="/"/>--%>
                    <div id="searchloggers" class="chat-panel panel panel-default">
                    	<g:render template="logger" contextPath="/"/>
                    </div>
                    <g:render template="donut" contextPath="/"/>

                </div>

                <div class="col-lg-4">

                    <g:render template="statgraphics" contextPath="/"/>
                    <%--<g:render template="friendsconnect" contextPath="/"/> --%>
                    <%--<g:render template="lastusers" contextPath="/"/> --%>
                    <g:render template="lastslrs" contextPath="/"/>

                </div>

            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

        <%-- Foot --%>
        <g:render template="foot" contextPath="/"/>

    </div>
    <!-- /#wrapper -->

    <%-- JavaScript --%>
    <g:render template="javascript" contextPath="/"/>
	<g:render template="graphGoogleIndex" contextPath="/graphs"/>
</body>

</html>
