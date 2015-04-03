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

var queryHospital = {
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

			var html = template("hospitalItemList", data);
			$("#hospitalList").html(html);
		}).fail(function() {
			$("#queryHospitalButton").text("查询失败，请重试！");
		}).always(function() {
			$("#queryHospitalButton").removeAttr("disabled");
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

function getParameter(name) {
    var r = new RegExp("(\\?|#|&)" + name + "=([^&#?]*)(&|#|\\?|$)"), m = location.href.match(r);
    return decodeURIComponent(!m ? "" : m[2])
  }