var serviceUrl = "http://autoorder.baidu.com:8080/autoorder";
var baiduPhotoUrl = "http://tb.himg.baidu.com/sys/portraitn/item/";

var hospitalParams = null;
var baiduUser = null;

var main = {
	init: function() {
		user.checkLogin();
		$.ajax({
			url: serviceUrl + "/hospital/init.do",
			async: false
		}).done(function(jsonObj) {
			hospitalParams = jsonObj;
		});
	}
}

var user = {
	login: function(baiduCode) {
		var baiduCodeUrl = "http://openapi.baidu.com/oauth/2.0/authorize?response_type=code&client_id=kcqb2uI1oNT330nBGEVrGZ0X&redirect_uri="
							+ serviceUrl + "/user/baiduCode.do";
		location.href = baiduCodeUrl;
	},
	
	checkLogin: function() {
		$.ajax({
			url: serviceUrl + "/user/checkLogin.do",
		}).done(function(jsonObj) {
			if (jsonObj.isLogin) {
				baiduUser = jsonObj.loginUser;
				$("#userName").text(baiduUser.userName);
			} else {
				baiduUser = null;
				$("#userName").text("登陆");
			}
		});
	},
	
	myorder: function() {
		if (null == baiduUser) {
			this.login();	
		} else {
			
		}
	}
}

var hospital = {
	init: function() {
		if (null == hospitalParams) {
			main.init();
		}

		$("#hospitalArea").html(genOption(hospitalParams.HospitalArea));
		$("#hospitalRank").html(genOption(hospitalParams.HospitalRank));
		$("#hospitalType").html(genOption(hospitalParams.HospitalType));
	},

	query: function() {
		$("#queryHospitalButton").attr("disabled", "disabled");
		$.ajax({
			url: serviceUrl + "/hospital/query.do",
			data: {
				"hospitalArea": $("#hospitalArea").val(),
				"hospitalType": $("#hospitalType").val(),
				"hospitalRank": $("#hospitalRank").val()
			}

		}).done(function(jsonObj) {
			var data = {};
			data["list"] = jsonObj;

			for (var i in jsonObj) {
				jsonObj[i].hospitalArea = hospitalParams.HospitalArea[jsonObj[i].hospitalArea];
			}

			var html = template("hospitalItemListHtml", data);
			$("#hospitalList").html(html);
		}).fail(function() {
			$("#queryHospitalButton").text("查询失败，请重试！");
		}).always(function() {
			$("#queryHospitalButton").removeAttr("disabled");
		});
	},
	
	getOutPatient: function(hospitalID) {
		outPatient.init();
		outPatient.queryOutPatient(hospitalID);
	}
}

var outPatient = {
	init: function() {
		$.ajax({
			url: serviceUrl + "/html/getOutPatient.html",
			async: false
		}).done(function(htmlStr) {
			$("#mainhtml").html(htmlStr);
		});
	},

	queryOutPatient: function(hospitalID) {
		$.ajax({
			url: serviceUrl + "/outPatient/queryOutPatient.do",
			data: {
				"hospitalID": hospitalID
			}
		}).done(function(jsonObj) {
			$("#hospitalName").html(jsonObj.hospital.name);
			$("#hospitalAddress").html(jsonObj.hospital.address);
			$("#hospitalPhone").html(jsonObj.hospital.telphone);
			
			var param = jsonObj.outPatientList;
			
			var list = {};
			for(var i in param) {
				if (!list[param[i].department]) {
					list[param[i].department] = [];
				}
				list[param[i].department].push(param[i])
			}
			
			var data = {};
			data["list"] = list;
			var html = template("outPatientListHtml", data);
			$("#outPatientList").html(html);
		});
	}
}


function genOption(map) {
	var option = "<option value=''>请选择</option>";
	for (var i in map) {
		option = option + "<option value='" + i + "'>" + map[i] + "</option>";
	}
	return option;
}
