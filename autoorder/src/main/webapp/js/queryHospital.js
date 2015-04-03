var serviceUrl = "http://autoorder.baidu.com:8080/autoorder";
var hospitalParams;

function init() {
	$.get(serviceUrl + "/hospital/init.do", {}, function(jsonObj) {
		hospitalParams = jsonObj;

		$("#hospitalArea").html(genOption(hospitalParams.HospitalArea));
		$("#hospitalRank").html(genOption(hospitalParams.HospitalRank));
		$("#hospitalType").html(genOption(hospitalParams.HospitalType));
	});
}


function genOption(map) {
	var option = "<option value=''>请选择</option>";
	for (var i in map) {
		option = option + "<option value='" + i + "'>" + map[i] + "</option>";
	}

	return option;
}

var queryHospital = {
	query: function() {
		$.get(serviceUrl + "/hospital/query.do", {
			"hospitalArea": $("#hospitalArea").val(),
			"hospitalType": $("#hospitalType").val(),
			"hospitalRank": $("#hospitalRank").val()
		}, function(jsonObj) {
			var data = {};
			data["list"] = jsonObj;
			
			for(var i in jsonObj) {
				jsonObj[i].hospitalArea = hospitalParams.HospitalArea[jsonObj[i].hospitalArea];	
			}
			
			var html = template("hospitalItemList", data);
			$("#hospitalList").html(html);
		});
	}
}