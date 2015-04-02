var serviceUrl = "http://127.0.0.1:8080/autoorder/hospital/";

function init() {

	$.get(serviceUrl + "init.do", {}, function(jsonObj) {
		$("#hospitalArea").html(genOption(jsonObj.HospitalArea));
		$("#hospitalRank").html(genOption(jsonObj.HospitalRank));
		$("#hospitalType").html(genOption(jsonObj.HospitalType));
	});
}

function genOption(map) {
	var option = "<option value='null'>请选择</option>";
	for(var i in map) {
		option = option + "<option value='" + i +"'>" + map[i] + "</option>";
	}
	
	return option;
}
