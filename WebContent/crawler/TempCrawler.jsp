<%@ taglib uri='/WEB-INF/tlds/template.tld' prefix='template' %>

<template:insert template="../templates/ArticleTemplate.jsp">
	<template:put name="title" content="Twitter Aggregator | Crawler" direct="true"/>
	<template:put name="header" content="../layouts/Header.jsp"/>
	<template:put name="content" content="../crawler/Crawler.jsp"/>
	<template:put name="footer" content="../layouts/FooterChart.html"/>
</template:insert>