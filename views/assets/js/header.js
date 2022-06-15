/* 새 글 쓰기 */
const $writeBtn = $(".writeBtn");
const $writeBox = $(".writeHidden");
let writeCheck = false;

$writeBtn.click(function(){
    $writeBox.toggle();
});

/* function focusOut(){
    if($writeBox.css("display") == "block"){
        console.log("writeBox열림");
        
        $('html').click(function(e){
            console.log(e);
            if(!$writeBox.has(e.target).length){
                $writeBox.css("display","none");
            }
        });
    };
} */

/* $("html").click(function(e){
    console.log(e);
    if(!$(e.target).hasClass('writeHidden')){
        console.log("포커스 아웃");
    }
}); */

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