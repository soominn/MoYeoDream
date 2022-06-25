$(document).ready(function () {
    $('.summernote').summernote({
        height: 523,
        maxHeight: 523,
        minHeight: 523,
        lang: "ko-KR",
        placeholder: '내용을 작성해주세요!'
    });
});

const $inputTitle = $("input#title-input");
const $note = $(".summernote");
const $input = $("input.inquiry-content");
const $registerButton = $("button.register");


$registerButton.on("click", function () {
    let note = $note.summernote('code');

    if($inputTitle.val() == "") {
        alert("문의 제목을 입력해주세요.");
    }
    else if(note == "<p><br></p>" || note == "") {
        alert("문의 내용을 입력해주세요.");
    }
    else {
        $input.val(note);
        $("#inquiryForm").submit();
    }
});


