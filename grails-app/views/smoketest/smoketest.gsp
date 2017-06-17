<br/>

<div class="ui menu">
    <div class="item header">
        Smoke Test
    </div>

    <div class="right menu">
        <a class="active teal item">
            Updates
            <div class="ui teal label">14</div>
        </a>
    </div>
</div>


<div ng-controller="smokeTestController as smoke" class="ui segment">
    <form name = "myForm" ng-submit="run()">
        <div class="ui">
            <div class="content">
                <h3 class="header">Run Smoke Test</h3>
                <div class="ui divider"></div>
                <div  style="width:20%">
                    <div class="form-group"><label>Client Id</label>
                        <input type="text" class="form-control"  name="clientId" required >
                    </div>
                </div>
                <div ng-repeat="count in smoke.instanceColl track by $index">
                    <div  style="width:20%">
                        <div class="form-group"><label>Client Instance {{$index+1}}</label>
                            <input type="text" class="form-control" name="clientInstanceId{{$index+1}}" required >
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" ng-click="add()">Add Instance</button>
                    <button type="button" class="btn btn-white" ng-click="remove()">Remove</button>
                    <button type="button" class="btn btn-white" ng-click="removeAll()">Remove All</button>
                    <button type="submit" class="btn btn-white">Run Test</button>
                </div>
            </div>
        </div>
    </form>
</div>