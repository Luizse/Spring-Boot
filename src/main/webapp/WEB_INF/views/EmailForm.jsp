<!DOCTYPE html>
<html>
<head>
    <title>Email Form</title>
</head>
<body>
    <h2>Email Form</h2>

    <c:if test="${not empty message}">
        <p style="color: green;">${message}</p>
    </c:if>

    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>

    <form method="post" action="${pageContext.request.contextPath}/sendEmail">
        <label for="to">To:</label>
        <input type="text" id="to" name="to" value="${email.to}" required><br><br>

        <label for="subject">Subject:</label>
        <input type="text" id="subject" name="subject" value="${email.subject}" required><br><br>

        <label for="body">Body:</label><br>
        <textarea id="body" name="body" rows="4" cols="50" required>${email.body}</textarea><br><br>

        <input type="submit" value="Send Email">
    </form>
</body>
</html>