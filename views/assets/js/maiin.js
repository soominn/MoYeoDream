
/* 알림 보기 */
let $noti = $(".headerNoti");
let $notiBox = $(".notiHidden");
let $notiClose = $(".notiXbtn");

$noti.click(function(){
    $notiBox.toggle();
});



/* 아이콘 클릭시 */
let $headerIcon = $(".headerIcon");
let $iconBox = $(".iconHidden");

$headerIcon.click(function(){
    $iconBox.toggle();

    if(this.focusout){
        if($iconBox.css('display','block')){
            console.log("포커스 아웃");
            $iconBox.css('display','none');
            $iconBox.addClass('hidden');
        }
    }
});

/* $headerIcon.focusout(function(){
    console.log("포커스 아웃");
    $iconBox.css('display','none');
}); */

/* 카테고리 필터 선택 */
let $cateListArr = $(".cateLi");

$cateListArr.each(function(i){
    $(this).click(function(){
        if(!$(this).hasClass('cateLiSelect')){
            $cateListArr.not($(this)).removeClass('cateLiSelect');
            $(this).addClass('cateLiSelect');
        }
    })
});


/* 타입 선택 */
let $typeArr = $(".typeLi");

$typeArr.each(function(i){
    $(this).click(function(){
        if(!$(this).hasClass('typeSelect')){
            $typeArr.not($(this)).removeClass('typeSelect');
            $(this).addClass('typeSelect');
        }
    });
});