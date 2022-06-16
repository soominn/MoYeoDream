const imgThumbnail = document.querySelector("label[for='enterprise-img'] img");
const imgFile = document.querySelector("input[id='enterprise-img']");

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