const nicknameNext = document.querySelector("button.nickname-next");
const interestNext = document.querySelector("button.interest-next");
const joinSuccess = document.querySelector("button.join-success");

const loginContent = document.querySelector("div.login-content");
const nicknameContent = document.querySelector("div.nickname-content");
const interestContent = document.querySelector("div.interest-content");
const imgContent = document.querySelector("div.img-content");
const joinOk = document.querySelector("div.join-ok");

const nicknameImg = document.querySelector("img.nickname");
const interestImg = document.querySelector("img.interest");
const imgImg = document.querySelector("img.img");

nicknameNext.addEventListener("click", function() {
	nicknameContent.style.display = "none";
	interestContent.style.display = "flex";
});

interestNext.addEventListener("click", function() {
	interestContent.style.display = "none";
	imgContent.style.display = "flex";
});

joinSuccess.addEventListener("click", function() {
	imgContent.style.display = "none";
	joinOk.style.display = "flex";
});

nicknameImg.addEventListener("click", function() {
	loginContent.style.display = "flex";
	nicknameContent.style.display = "none";
});

interestImg.addEventListener("click", function() {
	nicknameContent.style.display = "flex";
	interestContent.style.display = "none";
});

imgImg.addEventListener("click", function() {
	interestContent.style.display = "flex";
	imgContent.style.display = "none";
});

const imgThumbnail = document.querySelector("img.img-example");
const imgFile = document.querySelector("input[id='img-choose']");
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

// 카카오 로그인 API
Kakao.init('ef4b848b330c9b997a796ac0ae5e7e3f'); // 발급 받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk 초기화 여부 판단

// 카카오 로그인
function kakaoLogin() {
    Kakao.Auth.login({
        success: function (response) {
            Kakao.API.request({
                url: '/v2/user/me',
                success: function (response) {
                    console.log(response);
					loginContent.style.display = "none";
					nicknameContent.style.display = "flex";
                },
                fail: function (error) {
                    console.log(error);
                },
            });
        },
        fail: function (error) {
            console.log(error);
        },
    });
}