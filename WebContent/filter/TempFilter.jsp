<%@ taglib uri='/WEB-INF/tlds/template.tld' prefix='template' %>

<template:insert template="../templates/ArticleTemplate.jsp">
	<template:put name="title" content="Twitter Aggregator | Filter" direct="true"/>
	<template:put name="header" content="../layouts/Header.jsp"/>
	<template:put name="content" content="../filter/Filter.html"/>
	<template:put name="footer" content="../layouts/Footer.html"/>
</template:insert>