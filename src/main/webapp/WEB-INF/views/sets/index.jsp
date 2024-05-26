<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Knowledge Package Set - ${title}</title>
    <%@ include file="../../settings/header.jsp" %>
</head>
<body>

<h2>${title}</h2>

<div id="grid_container" style="width: 100%; height: 100vh;"></div>

<%@ include file="../../settings/footer.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/builder/knowledgePackageSetBuilder.js" type="module"></script>
</body>
</html>
