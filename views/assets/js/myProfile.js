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
