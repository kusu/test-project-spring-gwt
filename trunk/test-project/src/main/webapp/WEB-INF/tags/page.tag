<%@ tag body-content="scriptless"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spr" tagdir="/WEB-INF/tags"%>
<%@ attribute name="isgwt" required="true" type="java.lang.Boolean"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<c:if test="${not isgwt}">
	<link rel="stylesheet" href="/styles/mainstyler.css" type="text/css" />
</c:if>

<c:if test="${isgwt}">
	<meta name="gwt:property" content="locale=en">
	<meta http-equiv="X-UA-Compatible" content="IE=8" />
	<link rel="stylesheet" href="styles/innerstyle.css" type="text/css" />

	<script type="text/javascript" language="javascript"
		src="testproject/testproject.nocache.js"></script>
	<script type="text/javascript">
				//          
				var isomorphicDir = "testproject/sc/";
				//
			</script>

</c:if>

<title>Test Project</title>
</head>
<body>
	<div id="mainHolder">
		<div id="wrapper">
			<spr:headerInner />

			<iframe src="javascript:''" id="__gwt_historyFrame" tabIndex='-1'
				style="position: absolute; width: 0; height: 0; border: 0"></iframe>
			<div>
				<div>
					<jsp:doBody />
				</div>
				<div id="gwt_holder">
					<c:if test="${isgwt}">
						<div id="loader" class="loader">
							<!-- <img alt="" src="../images/loader.gif"> -->
						</div>
					</c:if>
					<div id="gwt"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>