
	<a class="item header ui" href="/">
		  <i class="big icons">
			<i class="tasks orange icon"></i>
			<i class="yellow inverted corner map loading icon"></i>
		  </i>
		  {{::AppName}}
	</a>
	<a class="item" ui-sref="a2a" ng-class="{'active': (selectedMenu == '/')}">
	  <i class="icon settings"></i>A 2 A
	</a>
	<a class="item" ui-sref="smoketest" ng-class="{'active':(selectedMenu == '/smoketest')}">
	  <i class="icon bar chart"></i>Smoke Test
	</a>
	%{--<div class="ui simple dropdown item">--}%
		%{--<i class="sitemap icon"></i>--}%
		%{--Projects--}%
		%{--<div class="menu">--}%
		  %{--<a class="item" ng-repeat="project in ProjectList" href="{{::project.url}}">{{::project.name}} <i class="icon grey external"></i></a>--}%
		%{--</div>--}%
	  %{--</div>--}%
	<a class="item" href="/login/logout">
	  <i class="icon mail"></i>Logout
	</a>
