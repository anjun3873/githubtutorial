/**
 *  공통 폼 유효성 검사 
 *  발리데이션 체크(클래스 활용)
 *  
 */

$(".valCheckFloat").on("keypress keyup blur",function (event) {
    //this.value = this.value.replace(/[^0-9\.]/g,'');
	$(this).val($(this).val().replace(/[^0-9\.]/g,''));
    if ((event.which != 46 || $(this).val().indexOf('.') != -1) && ((event.which < 48) || (event.which > 57))) {
        event.preventDefault();        
    }
});

$(".valCheckInt").on("keypress keyup blur",function (event) {   
    $(this).val($(this).val().replace(/[^\d].+/, ""));
    $(this).val($(this).val().replace(/[^\d].+/, ""));
    $(this).val($(this).val().replace(/[^0-9\.]/g,''));
     if ((event.which < 48 || event.which > 57)) {
         event.preventDefault();
     }
 });


//input의 숫자값을 4개까지만 입력하도록 이용
function maxLengthCheck(id,len){
 if($("#"+id).val().length > len){
		$("#"+id).val( $("#"+id).val().slice(0, len) );
 }    
}