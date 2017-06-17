<br/>

<div class="ui menu">
    <div class="item header">
        A 2 A
    </div>

    <div class="right menu">
        <a class="active teal item">
            Updates
            <div class="ui teal label">14</div>
        </a>
    </div>
</div>


<div ng-controller="a2aController as ata" class="ui segment">
    <form name="myForm" ng-submit="run()">
        <div class="ui">
            <div class="content">
                <h3 class="header">Run App 2 App Test</h3>
                <div class="ui divider"></div>
                <div  style="width:20%">
                    <div class="form-group"><label>Client Id</label>
                        <input type="text" class="form-control" ng-model="clientId" name="clientId" required >
                    </div>
                </div>
                <div ng-repeat="count in ata.instanceColl track by $index">
                    <div  style="width:20%">
                        <div class="form-group">
                            <label>Client Instance {{$index+1}}<input type="text" class="form-control" name="clientInstanceId{{$index+1}}" id="clientInstanceId_{{$index+1}}"  required ></label>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" ng-click="add()">Add Instance</button>
                    <button type="button" class="btn btn-white" ng-click="remove()">Remove</button>
                    <button type="button" class="btn btn-white" ng-click="removeAll()">Remove All</button>
                    <button type="submit" ng-disabled="myForm.input.$invalid" class="btn btn-white">Run Test</button>
                </div>
            </div>
        </div>
    </form>
    <div ng-repeat="d in data">
        <div>{{d.key}}--{{d.value}}</div>
    </div>
</div>