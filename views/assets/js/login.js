const nicknameNext = document.querySelector("button.nickname-next");
const joinSuccess = document.querySelector("button.join-success");

const loginContent = document.querySelector("div.login-content");
const nicknameContent = document.querySelector("div.nickname-content");
const imgContent = document.querySelector("div.img-content");
const joinOk = document.querySelector("div.join-ok");

const nicknameImg = document.querySelector("img.nickname");
const imgImg = document.querySelector("img.img");

nicknameNext.addEventListener("click", function() {
	nicknameContent.style.display = "none";
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

imgImg.addEventListener("click", function() {
	nicknameContent.style.display = "flex";
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

// 구글 로그인 API
// 처음 실행하는 함수
function init() {
	gapi.load('auth2', function() {
		gapi.auth2.init();
		options = new gapi.auth2.SigninOptionsBuilder();
		options.setAppPackageName('com.example.app');
		options.setPrompt('select_account');
		options.setScope('email');
		gapi.auth2.getAuthInstance().attachClickHandler('googleLogin', options, onSignIn, onSignInFailure);
	});
}

function onSignIn(googleUser) {
	let access_token = googleUser.getAuthResponse().access_token;
	$.ajax({
		url: 'https://people.googleapis.com/v1/people/me', 
		data: {personFields:'emailAddresses', key:'AIzaSyBHaP1X9sCZIuZ_HZd96k2v6FUStx_MaW8', 'access_token': access_token}, 
		method:'GET'
	})
	.done(function(e){
		let profile = googleUser.getBasicProfile();
		console.log(profile.getEmail());
	})
	.fail(function(e){
		console.log(e);
	});
}

function onSignInFailure(t){		
	console.log(t);
}