<%@ taglib uri='/WEB-INF/tlds/template.tld' prefix='template' %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title><template:get name="title"/></title>
  <link href="../assets/css/bootstrap.min.css" rel="stylesheet">
  <link href="../assets/css/roboto.min.css" rel="stylesheet">
  <link href="../assets/css/material.min.css" rel="stylesheet">
  <link href="../assets/css/ripples.min.css" rel="stylesheet">
  <link href="../assets/css/app.css" rel="stylesheet">
</head>
<body>
	<template:get name="header"/>
	<template:get name="content"/>
	<template:get name="footer"/>
</body>
</html>