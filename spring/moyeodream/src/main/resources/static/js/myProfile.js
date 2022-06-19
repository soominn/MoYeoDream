$(function() {
    $(".open-select").click(function() {
        $(".select-box").toggle();
    });
});

const imgThumbnail = document.querySelector("img.img-example");
const imgFile = document.querySelector("input[id='imageUpload']");
const imgDelete = document.querySelector("button.img-delete");

imgFile.addEventListener("change", function(event) {
	let reader = new FileReader();
	reader.readAsDataURL(event.target.files[0]);
	reader.onload = function(event) {
		let url = event.target.result;
		if(url.includes("image")) {
			imgThumbnail.src = url;
		}
		else {
			imgThumbnail.src = "https://hola-post-image.s3.ap-northeast-2.amazonaws.com/default.PNG";
		}
	}
});

imgDelete.addEventListener("click", function() {
	imgFile.value = "";
	imgThumbnail.src = "https://hola-post-image.s3.ap-northeast-2.amazonaws.com/default.PNG";
});



/* 세부 카테고리 */
const $cateChildLiArr = $(".select-value");

// 카테고리 클릭시 나오는 block
const $cateBlockArr = $(".cateBlock");

// 모두 지우기 버튼
const $clear = $(".delete-all-select");

// 해당 카테고리 지우기
const $deleteOneArr = $(".choice-box-value-remove");





$cateChildLiArr.each(function(){
	
	$(this).click(function(i){
		let $liValue = $(this).attr("value");
		
        $cateBlockArr.each(function(){
			if($(this).attr("value") == $liValue){
				$(this).show();
			}
		});
		
		$(".select-box").toggle();
	});
	
});

// 해당 카테고리 삭제
$cateBlockArr.each(function(){
	$cateBlockArr.children($deleteOneArr).click(function(){
		$(this).parent(".cateBlock").hide();
	})
});

// 전체 카테고리 삭제
$clear.click(function(){
	$cateBlockArr.hide();
});






