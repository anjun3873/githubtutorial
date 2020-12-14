

// 인버터의 발저량에러로그가 있는지 1분마다 한번씩 체크		
$(function() {
	timer = setInterval( function () {
		$.ajax({
			type : "POST", // GET 또는 POST
			url : '/onm/ajax/adm/invtErrLogData.do', // 서버측에서 가져올 페이지
			data : '', // 서버측에 전달할 parameter
			timeout : 5000, // 응답대기시간
			dataType : 'json', // html , javascript, text, xml, jsonp 등이 있다
			beforeSend : function() { // ajax 요청하기전에 실행되는 함수
			},
			success : function(data) { // 정상적으로 완료되었을 경우에 실행된다
//				console.log(data);
				
				// 최근거 한개 메세지 표출 
				if(data.resultCode =="S" && data.errCrntCnt > 0){
					var errTxt= data.invtErrCrntList[0].logDt + " " + data.invtErrCrntList[0].invtNm + "인버터의 누적발전량 이상 발생";
					$("#alarmSpan").text(errTxt);
					$("#alertDiv").show();
				}
				
				// 지난 24시간동안 발생한거 표출
				// TODO - 이후로 작업할것 : 에러발생로그페이지로 이동(페이지)추가작업
				if(data.resultCode =="S" && data.errTodayCnt > 0){
					
					$("#cntTodayAlm").text(data.errTodayCnt);
					$("#cntTodayTxt").text(data.errTodayCnt + "건의 알림");
					txt = "";
					
					for (var i = 0; i < data.errTodayCnt; i++) {
						txt += "<a class='dropdown-item media bg-flat-color-4' style='margin: 1px 0;'  href='#'>";
						txt += " <i class='fa fa-info'></i>";
						txt += " <p style='color:black'>"+ data.invtErrTodayList[i].invtNm + "인버터의 누적발전량 이상</p>";
						txt += "</a>";
					}
					
					$("#almCon").html(txt);
				}
			},

			error : function(request, status, error) { // 오류가 발생했을 때 호출된다.
				console.log("code:" + request.status+ "\n" + "message:"+ request.responseText + "\n"+ "error:" + error);
//				$('.content').html("인버터 에러알림정보를 호출할수 없는 오류가 있습니다..");
				console.log("인버터 에러알림정보를 호출할수 없는 오류가 있습니다..");
			},

			complete : function() { // 정상이든 비정상인든 실행이 완료될 경우 실행될 함수

			}

		});// ajax E
		
		
	}, 60000); // 60초에 한번씩 받아온다.
});


