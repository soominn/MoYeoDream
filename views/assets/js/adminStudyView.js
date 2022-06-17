/* 승인버튼 */
const $confirmBtn = $(".confirm");

$confirmBtn.click(function(){
    confirm("승인 하시겠습니까?")
});

/* 반려버튼 */
const $refuseBtn = $(".refuse");

$refuseBtn.click(function(){
    confirm("반려 하시겠습니까?")
});