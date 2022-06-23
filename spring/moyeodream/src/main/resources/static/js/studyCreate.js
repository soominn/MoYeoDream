$(document).ready(function() {
    $('.summernote-chief').summernote({
        height: 523,
        maxHeight: 523,
        minHeight: 523,
        lang: "ko-KR",
        placeholder: '내용을 작성해주세요!'
    });
});

$(document).ready(function() {
    $('.summernote-study').summernote({
        height: 523,
        maxHeight: 523,
        minHeight: 523,
        lang: "ko-KR",
        placeholder: '내용을 작성해주세요!'
    });
});

const $selectCategory = $("select#category-select");
const $selectProcess = $("select#way-select");
const $selectPersonnel = $("select#people-select");
const $inputStartDate = $("input#start-date");
const $inputCommunication = $("input#contact-input");
const $selectPeriod = $("select#period-select");
const $noteChief = $(".summernote-chief");
const $inputChief = $("input.study-chief");
const $inputTitle = $("input#title-input");
const $noteStudy = $(".summernote-study");
const $inputStudy = $("input.study-content");
const $registerButton = $("button.register");

$registerButton.on("click", function () {
    let noteChief = $noteChief.summernote('code');
    let noteStudy = $noteStudy.summernote('code');

    if($selectCategory.val() == "") {
        alert("카테고리를 선택해주세요.");
    }
    else if($selectProcess.val() == "") {
        alert("진행 방식을 선택해주세요.");
    }
    else if($selectPersonnel.val() == "") {
        alert("모집 인원을 선택해주세요.");
    }
    else if($inputStartDate.val() == "") {
        alert("시작 예정일을 선택해주세요.");
    }
    else if($inputCommunication.val() == "") {
        alert("연락 방법을 입력해주세요.");
    }
    else if($selectPeriod.val() == "") {
        alert("진행 기간을 입력해주세요.");
    }
    else if(noteChief == "<p><br></p>" || noteChief == "") {
        alert("스터디장 소개를 입력해주세요.");
    }
    else if($inputTitle.val() == "") {
        alert("제목을 입력해주세요.");
    }
    else if(noteStudy == "<p><br></p>" || noteStudy == "") {
        alert("스터디 소개를 입력해주세요.");
    }
    else {
        $inputChief.val(noteChief);
        $inputStudy.val(noteStudy);
        $("#studyForm").submit();
    }
});