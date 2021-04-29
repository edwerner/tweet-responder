<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.appengine.hello.HelloInfo" %>
<!-- [START_EXCLUDE] -->
<%--
  ~ Copyright (c) 2016 Google Inc. All Rights Reserved.
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License"); you
  ~ may not use this file except in compliance with the License. You may
  ~ obtain a copy of the License at
  ~
  ~     http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing, software
  ~ distributed under the License is distributed on an "AS IS" BASIS,
  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
  ~ implied. See the License for the specific language governing
  ~ permissions and limitations under the License.
  --%>
<!-- [END_EXCLUDE] -->
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="resources/css/flex.css"/>
  <link rel="stylesheet" href="resources/css/styles.css"/>
  <script src="resources/javascripts/jquery-3.3.1.min.js"></script>
  <script src="resources/javascripts/app.js"></script>
</head>
<body>
  <div class="card mb-4 box-shadow">
	<div class="home">
		<div class="headline flex flex-column flex-center">
			<h1>Twitter Bot</h1>
			<h2>Hello!</h2>
		</div>
		<div class="home flex flex-column flex-center">
			<p>This is <%= HelloInfo.getInfo() %>.</p>
			<div class="content flex flex-column flex-center">
					<div class="logo-content flex flex-column">
						<div class="logo">
							<img src="resources/images/robot.png" />
						</div>
						<!-- <button type="button" class="btn btn-primary activate-button">Enter</button> -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="tweet-content">
		<div class="tweet-content-headline flex flex-row">
			<div class="content-logo">
				<img src="resources/images/robot.png" />
			</div>
			<div class="headline flex flex-column flex-center">
				<h1>Twitter Bot</h1>
				<h2>Tweets</h2>
			</div>
		</div>
		<div class="tweet-home flex flex-column flex-center">
			<div class="tweet-content flex flex-column flex-center">
				<div class="logo-content flex flex-column">
					<button type="button" class="btn btn-primary home-button">Activate</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
