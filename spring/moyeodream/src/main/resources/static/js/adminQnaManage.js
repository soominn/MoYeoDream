/* 페이징 버튼 클릭 */
let $numBtnArr = $(".numBtn");

$numBtnArr.each(function(){
    $(this).click(function () {
        $numBtnArr.not($(this)).removeClass("selected");
        $(this).addClass("selected");
    })
})