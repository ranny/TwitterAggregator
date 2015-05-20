<%@ taglib uri='/WEB-INF/tlds/template.tld' prefix='template' %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title><template:get name="title"/></title>
  <link href="../TwitterAggregator2/assets/css/bootstrap.min.css" rel="stylesheet">
  <link href="../TwitterAggregator2/assets/css/roboto.min.css" rel="stylesheet">
  <link href="../TwitterAggregator2/assets/css/material.min.css" rel="stylesheet">
  <link href="../TwitterAggregator2/assets/css/ripples.min.css" rel="stylesheet">
  <link href="../TwitterAggregator2/assets/css/app.css" rel="stylesheet">
</head>
<body>
	<template:get name="header"/>
	<template:get name="content"/>
	<template:get name="footer"/>
</body>
</html>